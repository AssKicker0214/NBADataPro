package presentation.table;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import presentation.common.ListType;

public class TeamTablePanel extends TablePane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeamTablePanel(ArrayList<ArrayList<String>> datas, String[] columns,
			ArrayList<Integer> wid, int x, int y, int w, int sh, int h,
			boolean hasIndex, boolean whetherRank) {
		super(datas, columns, wid, x, y, w, sh, h, hasIndex, whetherRank);
		// TODO Auto-generated constructor stub
	}
	
protected void getRows(final ArrayList<ArrayList<String>> rowInfos){
		
		SwingWorker<ArrayList<TeamRowPane>, Void> worker = new SwingWorker<ArrayList<TeamRowPane>, Void>() {

			protected ArrayList<TeamRowPane> doInBackground() throws Exception {
				ArrayList<TeamRowPane> rows = new ArrayList<TeamRowPane>();
				
				if(firstV.equals(""))
					for(int i=0;i<rowInfos.size();i++){
						TeamRowPane row = new TeamRowPane(i+1,hasIndex);		
						row.addDatas_pic(rowInfos.get(i),wid);
						rows.add(row);
					}
				else
					for(int i=0;i<rowInfos.size();i++){
						TeamRowPane row = new TeamRowPane(i+1,hasIndex);		
						row.addDatas(rowInfos.get(i),wid);
						rows.add(row);
					}
				return rows;
				
			}
			
			protected void done(){
				try {
					ArrayList<TeamRowPane> rows = get();
					setContent(rows);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		};
		
		worker.execute();
		
	}
	
	public void SortContent(String sortBy,boolean isDesc){
		SortParamHandler sp = new SortParamHandler();
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		remove(content);
		System.out.print(sortBy);
		if(type == ListType.normal)
			datas = sp.TeamNormalHandler(sortBy, isDesc);
		else if(type == ListType.avg)
			datas = sp.TeamNormalAvgHandler(sortBy, isDesc);
		else if(type == ListType.high)
			datas = sp.TeamHighHandler(sortBy, isDesc);
		
		if(datas.size()==0)
			return;
		getRows(datas);
	}

}

package presentation.table;

import java.util.ArrayList;

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
	
	public void SortContent(String sortBy,boolean isDesc){
		SortParamHandler sp = new SortParamHandler();
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		remove(content);
		if(type == ListType.normal)
			datas = sp.TeamNormalHandler(sortBy, isDesc);
		else if(type == ListType.avg)
			datas = sp.TeamNormalAvgHandler(sortBy, isDesc);
		else if(type == ListType.high)
			datas = sp.TeamHighHandler(sortBy, isDesc);
		getRows(datas);
	}

}

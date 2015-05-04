package presentation.table;

import java.util.ArrayList;

import dataservice.player.PlayerDataService;
import dataservice.player.PlayerData_stub;

public class playerTablePanel extends TablePane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public playerTablePanel(ArrayList<ArrayList<String>> datas,
			String[] columns, ArrayList<Integer> wid, int x, int y, int w,
			int sh, int h, boolean hasIndex, boolean whetherRank) {
		super(datas, columns, wid, x, y, w, sh, h, hasIndex, whetherRank);
		// TODO Auto-generated constructor stub
	}
	
	public void SortContent(String sortBy,boolean isDesc){
		PlayerDataService pds = new PlayerData_stub();
		//pds.sortPlayerNormal(new sortParam(sortBy,isDesc));
	}

}

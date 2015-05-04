package presentation.table;

import java.util.ArrayList;

import presentation.team.TeamVO2List;
import dataservice.team.TeamDataService;
import dataservice.team.TeamData_stub;

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
		TeamDataService tds = new TeamData_stub();
		TeamVO2List t2l = new TeamVO2List();
		remove(content);
		ArrayList<ArrayList<String>> datas = t2l.normalData(tds.sortTeamNormal(30, sortBy, isDesc));
		getRows(datas);
	}

}

package presentation;

import dataservice.team.TeamDataHandel;
import dataservice.team.TeamDataService;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeamDataService tds =  new TeamDataHandel();
		System.out.println(tds.findTeamInfo("Hawks").teamName);
		
	}

}

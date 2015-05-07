package presentation;

import data.DataInitial;
import dataservice.match.MatchDataHandel;
import dataservice.match.MatchDataService;
import dataservice.player.PlayerDataHandel;
import dataservice.player.PlayerDataService;
import dataservice.team.TeamDataHandel;
import dataservice.team.TeamDataService;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataInitial.init();
		MatchDataService tds =  new MatchDataHandel();
		tds.findByDT("13-14-15", "15-11-11", "Hawks").get(0).show();
		
	}

}

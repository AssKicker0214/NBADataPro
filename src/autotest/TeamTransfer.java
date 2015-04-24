package autotest;

import java.io.PrintStream;
import java.util.ArrayList;

import po.teampo.*;
import test.data.*;

public class TeamTransfer {
	public void transfer_hot(PrintStream out,ArrayList<HotTeamsPO> po,String field){
		for(int i=0;i<po.size();i++){
			TeamHotInfo temp = new TeamHotInfo();
			temp.setField(field);
			temp.setLeague(po.get(i).league);
			temp.setTeamName(po.get(i).name);
			temp.setValue(po.get(i).value);
			
			out.print(temp);
		}
	}
	
	public void transfer_h(PrintStream out,ArrayList<TeamPO> po){
		for(int i=0;i<po.size();i++){
			TeamHighInfo temp = new TeamHighInfo();
			temp.setAssistEfficient(po.get(i).assistEfficient);
			temp.setDefendEfficient(po.get(i).defendEfficient);
			temp.setDefendReboundEfficient(po.get(i).defendReboundEfficient);
			temp.setOffendEfficient(po.get(i).offendEfficient);
			temp.setOffendReboundEfficient(po.get(i).offendReboundEfficient);
			temp.setOffendRound(po.get(i).offendRound);
			temp.setStealEfficient(po.get(i).stealEfficient);
			temp.setTeamName(po.get(i).teamName);
			temp.setWinRate(po.get(i).winRate);
			
			out.print(temp);
		}
	}
	public void transfer_n(PrintStream out,ArrayList<TeamPO> po){
		for(int i=0;i<po.size();i++){
			TeamNormalInfo temp = new TeamNormalInfo();
			temp.setAssist(po.get(i).assist);
			temp.setBlockShot(po.get(i).blockShot);
			temp.setDefendRebound(po.get(i).defendRebound);
			temp.setFault(po.get(i).fault);
			temp.setFoul(po.get(i).foul);
			temp.setNumOfGame(po.get(i).numOfGame);
			temp.setOffendRebound(po.get(i).offendRebound);
			temp.setPenalty(po.get(i).penalty);
			temp.setPoint(po.get(i).point);
			temp.setRebound(po.get(i).rebound);
			temp.setShot(po.get(i).shot);
			temp.setSteal(po.get(i).steal);
			temp.setTeamName(po.get(i).teamName);
			temp.setThree(po.get(i).three);
			
			out.print(temp);
		}
	}
}

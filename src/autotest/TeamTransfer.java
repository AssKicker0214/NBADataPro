package autotest;

import java.io.PrintStream;
import java.util.ArrayList;

import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;
import vo.teamvo.HotTeamsVO;
import vo.teamvo.TeamVO;


public class TeamTransfer {
	public void transfer_hot(PrintStream out,ArrayList<HotTeamsVO> vo,String field){
		for(int i=0;i<vo.size();i++){
			TeamHotInfo temp = new TeamHotInfo();
			temp.setField(field);
			temp.setLeague(vo.get(i).league+"");
			temp.setTeamName(vo.get(i).name);
			temp.setValue(vo.get(i).value);
			
	//		out.print(temp);
			out.append(temp.toString());
		}
	}
	
	public void transfer_h(PrintStream out,ArrayList<TeamVO> vo){
		for(int i=0;i<vo.size();i++){
			TeamHighInfo temp = new TeamHighInfo();
			temp.setAssistEfficient(vo.get(i).assistEfficient);
			temp.setDefendEfficient(vo.get(i).defendEfficient);
			temp.setDefendReboundEfficient(vo.get(i).defendReboundEfficient);
			temp.setOffendEfficient(vo.get(i).offendEfficient);
			temp.setOffendReboundEfficient(vo.get(i).offendReboundEfficient);
			temp.setOffendRound(vo.get(i).offendRound);
			temp.setStealEfficient(vo.get(i).stealEfficient);
			temp.setTeamName(vo.get(i).teamName);
			temp.setWinRate(vo.get(i).winRate);
			
//			out.print(temp);
				out.append(temp.toString());
		}
	}
	public void transfer_n(PrintStream out,ArrayList<TeamVO> vo){
		for(int i=0;i<vo.size();i++){
			TeamNormalInfo temp = new TeamNormalInfo();
			temp.setAssist(vo.get(i).assist);
			temp.setBlockShot(vo.get(i).blockShot);
			temp.setDefendRebound(vo.get(i).defendRebound);
			temp.setFault(vo.get(i).fault);
			temp.setFoul(vo.get(i).foul);
			temp.setNumOfGame(vo.get(i).numOfGame);
			temp.setOffendRebound(vo.get(i).offendRebound);
			temp.setPenalty(vo.get(i).penalty);
			temp.setPoint(vo.get(i).point);
			temp.setRebound(vo.get(i).rebound);
			temp.setShot(vo.get(i).shot);
			temp.setSteal(vo.get(i).steal);
			temp.setTeamName(vo.get(i).teamName);
			temp.setThree(vo.get(i).three);
			
//			out.print(temp);
				out.append(temp.toString());
		}
	}
	public void transfer_avgn(PrintStream out,ArrayList<TeamVO> vo){
		for(int i=0;i<vo.size();i++){
			TeamNormalInfo temp = new TeamNormalInfo();
			temp.setAssist(vo.get(i).avgAssist);
			temp.setBlockShot(vo.get(i).avgBlockShot);
			temp.setDefendRebound(vo.get(i).avgDefendRebound);
			temp.setFault(vo.get(i).avgFault);
			temp.setFoul(vo.get(i).avgFoul);
			temp.setNumOfGame(vo.get(i).numOfGame);
			temp.setOffendRebound(vo.get(i).avgOffendRebound);
			temp.setPenalty(vo.get(i).penalty);
			temp.setPoint(vo.get(i).avgPoint);
			temp.setRebound(vo.get(i).avgRebound);
			temp.setShot(vo.get(i).shot);
			temp.setSteal(vo.get(i).avgSteal);
			temp.setTeamName(vo.get(i).teamName);
			temp.setThree(vo.get(i).three);
			
//			out.print(temp);
				out.append(temp.toString());
		}
	}
}

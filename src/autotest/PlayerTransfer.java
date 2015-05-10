package autotest;

import java.io.PrintStream;
import java.util.ArrayList;

import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;
import vo.playervo.*;

public class PlayerTransfer {
	public void transfer_hot(PrintStream out,ArrayList<HotPlayersVO> vo,String field){
		for(int i=0;i<vo.size();i++){
			PlayerHotInfo temp = new PlayerHotInfo();
			temp.setField(field);
			temp.setTeamName(vo.get(i).name);
			temp.setPosition(vo.get(i).position);
			temp.setTeamName(vo.get(i).teamName);
			temp.setUpgradeRate(vo.get(i).upgradeRate);
			temp.setValue(vo.get(i).value);
			
			out.print(i+1);
			out.println(temp);
		}
	}
	public void transfer_king(PrintStream out,ArrayList<HotPlayersVO> vo,String field){
		for(int i=0;i<vo.size();i++){
			PlayerKingInfo temp = new PlayerKingInfo();
			temp.setField(field);
			temp.setTeamName(vo.get(i).name);
			temp.setPosition(vo.get(i).position);
			temp.setTeamName(vo.get(i).teamName);
			temp.setValue(vo.get(i).value);
			
			out.print(i+1);
			out.println(temp);
		}
	}
	public void transfer_h(PrintStream out,ArrayList<PlayerVO> vo){
		for(int i=0;i<vo.size();i++){
			PlayerHighInfo temp = new PlayerHighInfo();
			temp.setAssistEfficient(vo.get(i).assistEfficient);
			temp.setBlockShotEfficient(vo.get(i).blockShotEfficient);
			temp.setDefendReboundEfficient(vo.get(i).defendReboundEfficient);
			temp.setFaultEfficient(vo.get(i).faultEfficient);
			temp.setFrequency(vo.get(i).frequency);
			temp.setGmSc(vo.get(i).gmSc);
			if(vo.get(i).league=='E')
				temp.setLeague("East");
			else if(vo.get(i).league=='W')
				temp.setLeague("West");
			temp.setName(vo.get(i).name);
			temp.setOffendReboundEfficient(vo.get(i).offendReboundEfficient);
			temp.setPosition(vo.get(i).position);
			temp.setRealShot(vo.get(i).realShot);
			temp.setReboundEfficient(vo.get(i).reboundEfficient);
			temp.setShotEfficient(vo.get(i).reboundEfficient);
			temp.setStealEfficient(vo.get(i).stealEfficient);
			temp.setTeamName(vo.get(i).teamName);
			
			out.print(i+1);
			out.println(temp);
		}
	}
	public void transfer_n(PrintStream out,ArrayList<PlayerVO> vo){
		for(int i=0;i<vo.size();i++){
			PlayerNormalInfo temp = new PlayerNormalInfo();
			temp.setAge(vo.get(i).age);
			temp.setAssist(vo.get(i).assist);
			temp.setBlockShot(vo.get(i).blockShot);
			temp.setDefend(vo.get(i).defend);
			temp.setEfficiency(vo.get(i).efficiency);
			temp.setFault(vo.get(i).fault);
			temp.setFoul(vo.get(i).foul);
			temp.setMinute(vo.get(i).minute);
			temp.setName(vo.get(i).name);
			temp.setNumOfGame(vo.get(i).numOfGame);
			temp.setOffend(vo.get(i).offend);
			temp.setPenalty(vo.get(i).penalty);
			temp.setPoint(vo.get(i).point);
			temp.setRebound(vo.get(i).rebound);
			temp.setShot(vo.get(i).shot);
			temp.setStart(vo.get(i).start);
			temp.setSteal(vo.get(i).steal);
			temp.setTeamName(vo.get(i).teamName);
			temp.setThree(vo.get(i).three);
			
			out.print(i+1);
			out.println(temp);
		}
	}
	public void transfer_avgn(PrintStream out,ArrayList<PlayerVO> vo){
		for(int i=0;i<vo.size();i++){
			PlayerNormalInfo temp = new PlayerNormalInfo();
			temp.setAge(vo.get(i).age);
			temp.setAssist(vo.get(i).avgAssist);
			temp.setBlockShot(vo.get(i).avgBlockShot);
			temp.setDefend(vo.get(i).avgDefend);
			temp.setEfficiency(vo.get(i).efficiency);
			temp.setFault(vo.get(i).avgFault);
			temp.setFoul(vo.get(i).avgFoul);
			temp.setMinute(vo.get(i).avgMinute);
			temp.setName(vo.get(i).name);
			temp.setNumOfGame(vo.get(i).numOfGame);	
			temp.setOffend(vo.get(i).avgOffend);
			temp.setPenalty(vo.get(i).penalty);
			temp.setPoint(vo.get(i).avgPoint);
			temp.setRebound(vo.get(i).avgRebound);
			temp.setShot(vo.get(i).shot);
			temp.setStart(vo.get(i).start);	
			temp.setSteal(vo.get(i).avgSteal);
			temp.setTeamName(vo.get(i).teamName);
			temp.setThree(vo.get(i).three);
			
			out.print(i+1);
			out.println(temp);
		}
	}
}

package autotest;

import java.io.PrintStream;
import java.util.ArrayList;

import po.playerpo.*;
import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;

public class PlayerTransfer {
	public void transfer_hot(PrintStream out,ArrayList<HotPlayersPO> po,String field){
		for(int i=0;i<po.size();i++){
			PlayerHotInfo temp = new PlayerHotInfo();
			temp.setField(field);
			temp.setTeamName(po.get(i).name);
			temp.setPosition(po.get(i).position);
			temp.setTeamName(po.get(i).teamName);
			temp.setUpgradeRate(po.get(i).upgradePate);
			temp.setValue(po.get(i).value);
			
			out.print(temp);
		}
	}
	public void transfer_king(PrintStream out,ArrayList<HotPlayersPO> po,String field){
		for(int i=0;i<po.size();i++){
			PlayerKingInfo temp = new PlayerKingInfo();
			temp.setField(field);
			temp.setTeamName(po.get(i).name);
			temp.setPosition(po.get(i).position);
			temp.setTeamName(po.get(i).teamName);
			temp.setValue(po.get(i).value);
			
			out.print(temp);
		}
	}
	public void transfer_h(PrintStream out,ArrayList<PlayerPO> po){
		for(int i=0;i<po.size();i++){
			PlayerHighInfo temp = new PlayerHighInfo();
			temp.setAssistEfficient(po.get(i).assistEfficient);
			temp.setBlockShotEfficient(po.get(i).blockShotEfficient);
			temp.setDefendReboundEfficient(po.get(i).defendReboundEfficient);
			temp.setFaultEfficient(po.get(i).faultEfficient);
			temp.setFrequency(po.get(i).frequency);
			temp.setGmSc(po.get(i).gmSc);
			temp.setLeague(po.get(i).league);
			temp.setName(po.get(i).name);
			temp.setOffendReboundEfficient(po.get(i).offendReboundEfficient);
			temp.setPosition(po.get(i).position);
			temp.setRealShot(po.get(i).realShot);
			temp.setReboundEfficient(po.get(i).reboundEfficient);
			temp.setShotEfficient(po.get(i).reboundEfficient);
			temp.setStealEfficient(po.get(i).stealEfficient);
			temp.setTeamName(po.get(i).teamName);
			
			out.print(temp);
		}
	}
	public void transfer_n(PrintStream out,ArrayList<PlayerPO> po){
		for(int i=0;i<po.size();i++){
			PlayerNormalInfo temp = new PlayerNormalInfo();
			temp.setAge(po.get(i).age);
			temp.setAssist(po.get(i).assist);
			temp.setBlockShot(po.get(i).blockShot);
			temp.setDefend(po.get(i).defend);
			temp.setEfficiency(po.get(i).efficiency);
			temp.setFault(po.get(i).fault);
			temp.setFoul(po.get(i).foul);
			temp.setMinute(po.get(i).minute);
			temp.setName(po.get(i).name);
			temp.setNumOfGame(po.get(i).numOfGame);
			temp.setOffend(po.get(i).offend);
			temp.setPenalty(po.get(i).penalty);
			temp.setPoint(po.get(i).point);
			temp.setRebound(po.get(i).rebound);
			temp.setShot(po.get(i).shot);
			temp.setStart(po.get(i).start);
			temp.setSteal(po.get(i).steal);
			temp.setTeamName(po.get(i).teamName);
			temp.setThree(po.get(i).three);
			
			out.print(temp);
		}
	}

}

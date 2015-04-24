package autotest;

import java.io.PrintStream;
import java.util.ArrayList;

import po.playerpo.*;
import data.player.PlayerData;
import dataservice.player.PlayerDataService;
import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;

@CmdCommand(names={"-player","-p"},description="Show Player Infomation")
public class PlayerCommand extends TeamCommand{
	
	public PlayerCommand(){
		number = 50;
	}
	
	boolean isDailyKing = false;
	boolean isSeasonKing = false;
	ArrayList<String> positionFilterField = new ArrayList<String>();
	ArrayList<String> leagueFilterField = new ArrayList<String>();
	ArrayList<String> ageFilterField = new ArrayList<String>();
	ArrayList<String> sortField = new ArrayList<String>();
	
	@CmdOption(names={"-king"},args={"sort"},description="show the king of **",
			conflictsWith={"-avg","-total","-sort","-fliter","-hot","-all"})
	public void king(String sort){
		sortBy = sort;
	}
	@CmdOption(names={"-season"},description="season king",requires={"-king"},conflictsWith={"-daily"})
	public void seasonKing(){
		isSeasonKing = true;
	}
	@CmdOption(names={"-daily"},description="daily king",requires={"-king"},conflictsWith={"-season"})
	public void dailyKing(){
		isDailyKing = true;
	}
	@CmdOption(names={"-sort"},args={"sort"},description="sort data")
	public void sort(String sort){
		String[] result = sort.split(",");
		for(int i=0;i<result.length;i++)
			sortField.add(result[i]);
	}
	@CmdOption(names={"-filter"},args={"filter"},description="filter the players")
	public void fliter(String filter){
		String[] result = filter.split(",");
		String[] temp = {"",""};
		for(int i=0;i<result.length;i++){
			temp = result[i].split(".");
			if(temp[0].equals("position"))
				positionFilterField.add(temp[1]);
			else if(temp[0].equals("league"))
				leagueFilterField.add(temp[1]);
			else if(temp[0].equals("age"))
				ageFilterField.add(temp[1]);
		}
	}
	
	public void optionHandler(PrintStream out){
		PlayerTransfer pt = new PlayerTransfer();
		PlayerDataService pds = new PlayerData();
		if(isHot){
			ArrayList<HotPlayersPO> po = pds.hotPlayer(hotNum, sortBy); 
			pt.transfer_hot(out, po, sortBy);			
		}else if(isDailyKing){
			ArrayList<HotPlayersPO> po = pds.DailyKing(hotNum, sortBy); 
			pt.transfer_king(out, po, sortBy);
		}else if(isSeasonKing){
			ArrayList<HotPlayersPO> po = pds.SeasonKing(hotNum, sortBy); 
			pt.transfer_king(out, po, sortBy);
		}else{
			if(positionFilterField.size()==0)
				positionFilterField.add("All");
			if(leagueFilterField.size()==0)
				leagueFilterField.add("All");
			if(ageFilterField.size()==0)
				ageFilterField.add("All");
			
			if(isHigh){
				if(sortField.size()==0)
					sortField.add("score.desc");
				ArrayList<PlayerPO> po = pds.filterNormal(sortField, positionFilterField, leagueFilterField, ageFilterField, number, isAvg);
				pt.transfer_h(out, po);
			}else{
				if(sortField.size()==0)
					sortField.add("realShot.desc");
				ArrayList<PlayerPO> po = pds.filterHigh(sortField, positionFilterField, leagueFilterField, ageFilterField, number, isAvg);
				pt.transfer_n(out, po);
			}
		}
	}
	
}

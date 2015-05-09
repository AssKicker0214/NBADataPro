package autotest;

import java.io.PrintStream;
import java.util.ArrayList;

import vo.playervo.*;
import dataservice.player.PlayerDataService;
import dataservice.player.PlayerData_stub;
import dataservice.player.sortParam;
import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;

@CmdCommand(names={"-player","-p"},description="Show Player Infomation")
public class PlayerCommand extends TeamCommand{
	
	public PlayerCommand(){
		number = 50;
	}
	
	boolean isDailyKing = false;
	boolean isSeasonKing = false;
	int startAge=-1;
	int endAge=-1;
	ArrayList<String> positionFilterField = new ArrayList<String>();
	ArrayList<String> leagueFilterField = new ArrayList<String>();
	ArrayList<sortParam> sortField = new ArrayList<sortParam>();
	
	@CmdOption(names={"-king"},args={"sort"},description="show the king of **",
			conflictsWith={"-avg","-total","-sort","-fliter","-hot","-all"})
	public void king(String sort){
		if(sort.equals("score"))
			sort = "point";
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
		for(int i=0;i<result.length;i++){
			sortParam sp = new sortParam();
			String[] temp = sort.split("."); 
			if(temp[0].equals("score"))
				temp[0] = "point";
			sp.field = temp[0];
			if(temp[1].equals("desc"))
				sp.isDesc = true;
			else
				sp.isDesc = false;
			sortField.add(sp);
		}
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
				leagueFilterField.add(temp[1].substring(0,1));
			else if(temp[0].equals("age")){
				switch(temp[1]){
				case "<=22": endAge = 22;break;
				case "22< X <=25": startAge = 22;endAge = 25;break;
				case "25< X <=30": startAge = 25;endAge = 30;break;
				case ">30": startAge = 30;break;
				}
				
			}
		}
	}
	
	public void optionHandler(PrintStream out){
		PlayerTransfer pt = new PlayerTransfer();
		PlayerDataService pds = new PlayerData_stub();
		if(isHot){
			ArrayList<HotPlayersVO> po = pds.hotPlayer(hotNum, sortBy); 
			pt.transfer_hot(out, po, sortBy);			
		}else if(isDailyKing){
			ArrayList<HotPlayersVO> po = pds.DailyKing(hotNum, sortBy,""); 
			pt.transfer_king(out, po, sortBy);
		}else if(isSeasonKing){
			ArrayList<HotPlayersVO> po = pds.SeasonKing(hotNum, sortBy); 
			pt.transfer_king(out, po, sortBy);
		}else{
			if(positionFilterField.size()==0){
				positionFilterField.add("F");
				positionFilterField.add("G");
				positionFilterField.add("C");
				
			}
			if(leagueFilterField.size()==0){
				leagueFilterField.add("W"); 
				leagueFilterField.add("E");
			}
			
			if(isHigh){
				if(sortField.size()==0)
					sortField.add(new sortParam("point",true));
				ArrayList<PlayerVO> po = pds.filterNormal(sortField, positionFilterField, leagueFilterField, startAge, endAge, number);
				pt.transfer_h(out, po);
			}else{
				if(sortField.size()==0)
					sortField.add(new sortParam("realShot",true));
				ArrayList<PlayerVO> po = pds.filterHigh(sortField, positionFilterField, leagueFilterField, startAge, endAge, number);
				if(isAvg)
					pt.transfer_avgn(out, po);
				else
					pt.transfer_n(out, po);
			}
		}
	}
	
}

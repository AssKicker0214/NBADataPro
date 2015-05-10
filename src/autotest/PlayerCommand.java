package autotest;

import java.io.PrintStream;
import java.util.ArrayList;

import vo.playervo.*;
import dataservice.player.PlayerDataHandel;
import dataservice.player.PlayerDataService;
import dataservice.player.sortParam;
import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;

@CmdCommand(names={"-player","-p"},description="Show Player Infomation")
public class PlayerCommand extends TeamCommand{
//	int number = 50;
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
			conflictsWith={"-avg","-total","-sort","-filter","-hot","-all"})
	public void king(String sort){
		
		sortBy = AVGParam(sort);
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
			String[] temp = sort.split("\\."); 
			
			if(isAvg)
				temp[0] = AVGParam(temp[0]);
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
		System.out.println(filter);
		String[] result = filter.split(",");
		String[] temp = {"",""};
		for(int i=0;i<result.length;i++){
			temp = result[i].split("\\.");
			if(temp[0].equals("position"))
				positionFilterField.add(temp[1].toUpperCase());
			else if(temp[0].equals("league"))
				leagueFilterField.add(temp[1].substring(0,1).toUpperCase());
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
	
	public String AVGParam(String sortBy){
		String sort = "";
		switch(sortBy){
		case "score":sort = "avgPoint";break;
		case "point":sort = "avgPoint";break;
		case "rebound":sort = "avgRebound";break;
		case "assist":sort = "avgAssist";break;
		case "blockShot":sort = "avgBlockShot";break;
		case "steal":sort = "avgSteal";break;
		case "foul":sort = "avgFoul";break;
		case "minute":sort = "avgMinute";break;
		default :return sortBy;
		
		}
		return sort;
	}
	
	public void optionHandler(PrintStream out){
		PlayerTransfer pt = new PlayerTransfer();
		PlayerDataService pds = new PlayerDataHandel();
		if(isHot){
			ArrayList<HotPlayersVO> po = pds.hotPlayer(hotNum, sortBy); 
			pt.transfer_hot(out, po, sortBy);			
		}else if(isDailyKing){
			ArrayList<HotPlayersVO> po = pds.DailyKing(hotNum, sortBy,pds.getLastDay()); 
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
			ArrayList<PlayerVO> po  = new ArrayList<PlayerVO>();
			if(isHigh){
				if(sortField.size()==0)
					sortField.add(new sortParam("realShot",true));
				po = pds.filterHigh(sortField, positionFilterField, leagueFilterField, startAge, endAge, number);
				pt.transfer_h(out, po);
			}else{
				if(isAvg){
					if(sortField.size()==0)
						sortField.add(new sortParam("avgPoint",true));
					System.out.println(sortField.size()+sortField.get(0).field+" "+sortField.get(0).isDesc+positionFilterField+leagueFilterField+startAge+" "+endAge+" "+number);
					po = pds.filterNormalAvg(sortField, positionFilterField, leagueFilterField, startAge, endAge, number);
					for (int i = 0; i <po.size();i++){
						PlayerVO vo = po.get(i);
						System.out.println(vo.name+" "+vo.teamName+" "+vo.numOfGame+" "+vo.start);
					}
					pt.transfer_avgn(out, po);
				}else{
					if(sortField.size()==0)
						sortField.add(new sortParam("point",true));
					po = pds.filterNormal(sortField, positionFilterField, leagueFilterField, startAge, endAge, number);
					pt.transfer_n(out, po);
				}
			}
		}
		isAvg = true;
		isHot = false;
		isHigh = false;
		number = 50;
		hotNum = 5;
		sortBy = "-";
		isDesc = true;
		positionFilterField.clear();
		leagueFilterField.clear();
		sortField.clear();
	}
	
}

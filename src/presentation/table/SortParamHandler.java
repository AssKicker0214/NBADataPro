package presentation.table;

import java.util.ArrayList;

import presentation.player.PlayerVO2List;
import presentation.team.TeamVO2List;
import dataservice.player.PlayerDataService;
import dataservice.player.PlayerData_stub;
import dataservice.player.sortParam;
import dataservice.team.TeamDataService;
import dataservice.team.TeamData_stub;

public class SortParamHandler {
	TeamDataService tds = new TeamData_stub();
	TeamVO2List t2l = new TeamVO2List();
	PlayerDataService pds = new PlayerData_stub();
	PlayerVO2List p2l = new PlayerVO2List();
	
	public ArrayList<ArrayList<String>> TeamNormalHandler(String sortBy,boolean isDesc){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		String sort;
		switch(sortBy){
		case"助攻": sort = "assist";break;
		
		
		
		default:return datas;
		}
			datas = t2l.normalData(tds.sortTeamNormal(30, sortBy, isDesc));
		return datas;
	}
	public ArrayList<ArrayList<String>> TeamNormalAvgHandler(String sortBy,boolean isDesc){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		String sort;
		switch(sortBy){
		case"助攻": sort = "avgAssist";break;
		
		
		
		default:return datas;
		}
			datas = t2l.avgNormalData(tds.sortTeamNormalAvg(30, sortBy, isDesc));
		return datas;
	}
	public ArrayList<ArrayList<String>> TeamHighHandler(String sortBy,boolean isDesc){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		String sort;
		switch(sortBy){
		case"助攻效率": sort = "assistEfficient";break;
		
		
		
		default:return datas;
		}
		datas = t2l.highData(tds.sortTeamHigh(30, sortBy, isDesc));
		return datas;
	}
	
	public ArrayList<ArrayList<String>> PlayerNormalHandler(String sortBy,boolean isDesc){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		ArrayList<sortParam> sortP = new ArrayList<sortParam>();
		sortParam sort = new sortParam("",isDesc);
		switch(sortBy){
		case"首发": sort.field = "start";break;
		
		
		
		default:return datas;
		}
		sortP.add(sort);
		datas = p2l.normalData(pds.sortPlayerNormal(sortP));
		return datas;
	}
	public ArrayList<ArrayList<String>> PlayerNormalAvgHandler(String sortBy,boolean isDesc){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		ArrayList<sortParam> sortP = new ArrayList<sortParam>();
		sortParam sort = new sortParam("",isDesc);
		switch(sortBy){
		case"首发": sort.field = "start";break;
		
		
		
		default:return datas;
		}
		sortP.add(sort);
		datas = p2l.avgNormalData(pds.sortPlayerNormalAvg(sortP));
		return datas;
	}
	public ArrayList<ArrayList<String>> PlayerHighHandler(String sortBy,boolean isDesc){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		ArrayList<sortParam> sortP = new ArrayList<sortParam>();
		sortParam sort = new sortParam("",isDesc);
		switch(sortBy){
		case"助攻率": sort.field = "assistEfficient";break;
		
		
		
		default:return datas;
		}
		sortP.add(sort);
		datas = p2l.highData(pds.sortPlayerHigh(sortP));
		return datas;
	}

}

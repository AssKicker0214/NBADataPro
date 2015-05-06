package presentation.table;

import java.util.ArrayList;

import presentation.player.PlayerVO2List;
import presentation.team.TeamVO2List;
import dataservice.player.PlayerDataService;
import dataservice.player.PlayerDataHandel;
import dataservice.player.sortParam;
import dataservice.team.TeamDataService;
import dataservice.team.TeamDataHandel;

public class SortParamHandler {
	TeamDataService tds = new TeamDataHandel();
	TeamVO2List t2l = new TeamVO2List();
	PlayerDataService pds = new PlayerDataHandel();
	PlayerVO2List p2l = new PlayerVO2List();
	
	public ArrayList<ArrayList<String>> TeamNormalHandler(String sortBy,boolean isDesc){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		String sort;
		switch(sortBy){
			case"助攻": sort = "assist";break;
			case"盖帽": sort = "blockShot";break;
			case"篮板": sort = "rebound";break;
			case"抢断": sort = "steal";break;
			case"防守篮板": sort = "defendRebound";break;
			case"进攻篮板": sort = "offendRebound";break;
			case"%": sort = "shot";break;
			case"三分％": sort = "three";break;
			case"罚球％": sort = "penalty";break;
			case"失误": sort = "fault";break;
			case"犯规": sort = "foul";break;
			case"比赛场数": sort = "numOfGame";break;
			case"得分": sort = "point";break;
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
			case"盖帽": sort = "avgBlockShot";break;
			case"篮板": sort = "avgRebound";break;
			case"抢断": sort = "avgSteal";break;
			case"防守篮板": sort = "avgDefendRebound";break;
			case"进攻篮板": sort = "avgOffendRebound";break;
			case"%": sort = "shot";break;
			case"三分％": sort = "three";break;
			case"罚球％": sort = "penalty";break;
			case"失误": sort = "avgFault";break;
			case"犯规": sort = "avgFoul";break;
			case"比赛场数": sort = "numOfGame";break;
			case"得分": sort = "avgPoint";break;
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
			case"抢断效率": sort = "stealEfficient";break;
			case"防守效率": sort = "defendEfficient";break;
			case"进攻效率": sort = "offendEfficient";break;
			case"防守篮板率": sort = "defendReboundEfficient";break;
			case"进攻篮板率": sort = "offendReboundEfficient";break;
			case"进攻回合": sort = "offendRound";break;
			case"胜率": sort = "winRate";break;
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
			case"效率": sort.field = "efficiency";break;
			case"上场次数": sort.field = "numOfGame";break;
			case"分钟": sort.field = "minute";break;
			case"％": sort.field = "shot";break;
			case"三分％": sort.field = "three";break;
			case"罚球％": sort.field = "penalty";break;
			case"进攻": sort.field = "offend";break;
			case"防守": sort.field= "defend";break;
			case"篮板": sort.field = "rebound";break;
			case"助攻": sort.field = "assist";break;
			case"抢断": sort.field = "steal";break;
			case"盖帽": sort.field = "blockShot";break;
			case"失误": sort.field = "fault";break;
			case"犯规": sort.field = "foul";break;
			case"得分": sort.field = "point";break;
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
			case"效率": sort.field = "efficiency";break;
			case"上场次数": sort.field = "numOfGame";break;
			case"分钟": sort.field = "avgMinute";break;
			case"％": sort.field = "shot";break;
			case"三分％": sort.field = "three";break;
			case"罚球％": sort.field = "penalty";break;
			case"进攻": sort.field = "avgOffend";break;
			case"防守": sort.field= "avgDefend";break;
			case"篮板": sort.field = "avgRebound";break;
			case"助攻": sort.field = "avgAssist";break;
			case"抢断": sort.field = "avgSteal";break;
			case"盖帽": sort.field = "avgBlockShot";break;
			case"失误": sort.field = "avgFault";break;
			case"犯规": sort.field = "avgFoul";break;
			case"得分": sort.field = "avgPoint";break;
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
			case"盖帽率": sort.field = "blockShotEfficient";break;
			case"抢断率": sort.field = "stealEfficient";break;
			case"防守篮板率": sort.field = "defendReboundEfficient";break;
			case"进攻篮板率": sort.field = "offendReboundEfficient";break;
			case"失误率": sort.field = "faultEfficient";break;
			case"使用率": sort.field = "frequency";break;
			case"GmSc": sort.field = "gmSc";break;
			case"真实命中率": sort.field= "realShot";break;
			case"篮板率": sort.field = "reboundEfficient";break;
			case"投篮效率": sort.field = "shotEfficient";break;
			default:return datas;
		}
		sortP.add(sort);
		datas = p2l.highData(pds.sortPlayerHigh(sortP));
		return datas;
	}

}

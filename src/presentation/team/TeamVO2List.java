package presentation.team;

import java.util.ArrayList;

import vo.teamvo.TeamVO;

public class TeamVO2List {
	public ArrayList<ArrayList<String>> basicInfo(ArrayList<TeamVO> vo){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();	
		for(int i=0;i<vo.size();i++){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add("teamsPNG/"+vo.get(i).photo+".png");
			temp.add(vo.get(i).location);
			temp.add(vo.get(i).teamName);
			temp.add(vo.get(i).league+"");
			temp.add(vo.get(i).division);
			temp.add(vo.get(i).homeCourt);
			temp.add(vo.get(i).foundTime+"");
		
			datas.add(temp);
		}
		return datas;
	}
	
	public ArrayList<ArrayList<String>> normalData(ArrayList<TeamVO> vo){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();	
		for(int i=0;i<vo.size();i++){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add("teamsPNG/"+vo.get(i).photo+".png");
			temp.add(vo.get(i).teamName);
			temp.add(vo.get(i).assist+"");
			temp.add(vo.get(i).blockShot+"");
			temp.add(vo.get(i).rebound+"");
			temp.add(vo.get(i).steal+"");
			temp.add(vo.get(i).defendRebound+"");
			temp.add(vo.get(i).offendRebound+"");
			temp.add(vo.get(i).shot+"");
			temp.add(vo.get(i).three+"");
			temp.add(vo.get(i).penalty+"");
			temp.add(vo.get(i).fault+"");
			temp.add(vo.get(i).foul+"");
			temp.add(vo.get(i).numOfGame+"");
			temp.add(vo.get(i).point+"");
			
			datas.add(temp);
		}
		return datas;
	}
	public ArrayList<ArrayList<String>> avgNormalData(ArrayList<TeamVO> vo){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();	
		for(int i=0;i<vo.size();i++){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add("teamsPNG/"+vo.get(i).photo+".png");
			temp.add(vo.get(i).teamName);
			temp.add(vo.get(i).avgAssist+"");
			temp.add(vo.get(i).avgBlockShot+"");
			temp.add(vo.get(i).avgRebound+"");
			temp.add(vo.get(i).avgSteal+"");
			temp.add(vo.get(i).avgDefendRebound+"");
			temp.add(vo.get(i).avgOffendRebound+"");
			temp.add(vo.get(i).shot+"");
			temp.add(vo.get(i).three+"");
			temp.add(vo.get(i).penalty+"");
			temp.add(vo.get(i).avgFault+"");
			temp.add(vo.get(i).avgFoul+"");
			temp.add(vo.get(i).numOfGame+"");
			temp.add(vo.get(i).avgPoint+"");
		
			datas.add(temp);
		}
		return datas;
	}
	public ArrayList<ArrayList<String>> highData(ArrayList<TeamVO> vo){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();	
		for(int i=0;i<vo.size();i++){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add("teamsPNG/"+vo.get(i).photo+".png");
			temp.add(vo.get(i).teamName);
			temp.add(vo.get(i).assistEfficient+"");
			temp.add(vo.get(i).stealEfficient+"");
			temp.add(vo.get(i).defendEfficient+"");
			temp.add(vo.get(i).offendEfficient+"");
			temp.add(vo.get(i).defendRebound+"");
			temp.add(vo.get(i).offendRebound+"");
			temp.add(vo.get(i).offendRound+"");
			temp.add(vo.get(i).winRate+"");
		
			datas.add(temp);
		}
		return datas;
	}
}

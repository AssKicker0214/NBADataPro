package presentation.player;

import java.util.ArrayList;

import vo.playervo.PlayerVO;

public class PlayerVO2List {
	public ArrayList<ArrayList<String>> basicInfo(ArrayList<PlayerVO> vo){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();	
		
		for(int i=0;i<vo.size();i++){
			ArrayList<String> temp = new ArrayList<String>();

			temp.add("portrait/"+vo.get(i).photo+".png");
			temp.add(vo.get(i).name);
			temp.add(vo.get(i).team);
			temp.add(vo.get(i).league+"");
			temp.add(vo.get(i).number+"");
			temp.add(vo.get(i).position);
			temp.add(vo.get(i).age+"");
			temp.add(vo.get(i).hight);
			temp.add(vo.get(i).weigth);
			temp.add(vo.get(i).school);
			
			datas.add(temp);
		}
		return datas;
	}
	
	public ArrayList<ArrayList<String>> teamMember(ArrayList<PlayerVO> vo){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();	
		
		for(int i=0;i<vo.size();i++){
			ArrayList<String> temp = new ArrayList<String>();

			temp.add("portrait/"+vo.get(i).photo+".png");
			temp.add(vo.get(i).name);
			temp.add(vo.get(i).position);
			temp.add(vo.get(i).number+"");
			temp.add(vo.get(i).age+"");
			temp.add(vo.get(i).exp+"");
			temp.add(vo.get(i).hight);
			temp.add(vo.get(i).weigth);
			temp.add(vo.get(i).school);
			
			datas.add(temp);
		}
		return datas;
	}
	
	public ArrayList<ArrayList<String>> normalData(ArrayList<PlayerVO> vo){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();	
		
		for(int i=0;i<vo.size();i++){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add("portrait/"+vo.get(i).photo+".png");
			temp.add(vo.get(i).name);
			temp.add(vo.get(i).start+"");
			temp.add(vo.get(i).efficiency+"");
			temp.add(vo.get(i).numOfGame+"");
			temp.add(vo.get(i).minute+"");
			temp.add(vo.get(i).shot+"");
			temp.add(vo.get(i).three+"");
			temp.add(vo.get(i).penalty+"");
			temp.add(vo.get(i).offend+"");
			temp.add(vo.get(i).defend+"");
			temp.add(vo.get(i).rebound+"");
			temp.add(vo.get(i).assist+"");
			temp.add(vo.get(i).steal+"");
			temp.add(vo.get(i).blockShot+"");
			temp.add(vo.get(i).fault+"");
			temp.add(vo.get(i).foul+"");
			temp.add(vo.get(i).point+"");
			
			datas.add(temp);
		}
		return datas;
	}
	public ArrayList<ArrayList<String>> avgNormalData(ArrayList<PlayerVO> vo){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();	
		for(int i=0;i<vo.size();i++){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add("portrait/"+vo.get(i).photo+".png");
			temp.add(vo.get(i).name);
			temp.add(vo.get(i).start+"");
			temp.add(vo.get(i).efficiency+"");
			temp.add(vo.get(i).numOfGame+"");
			temp.add(vo.get(i).avgMinute+"");
			temp.add(vo.get(i).shot+"");
			temp.add(vo.get(i).three+"");
			temp.add(vo.get(i).penalty+"");
			temp.add(vo.get(i).avgOffend+"");
			temp.add(vo.get(i).avgDefend+"");
			temp.add(vo.get(i).avgRebound+"");
			temp.add(vo.get(i).avgAssist+"");
			temp.add(vo.get(i).avgSteal+"");
			temp.add(vo.get(i).avgBlockShot+"");
			temp.add(vo.get(i).avgFault+"");
			temp.add(vo.get(i).avgFoul+"");
			temp.add(vo.get(i).avgPoint+"");
		
			datas.add(temp);
		}
		return datas;
	}
	public ArrayList<ArrayList<String>> highData(ArrayList<PlayerVO> vo){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();	
		for(int i=0;i<vo.size();i++){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add("portrait/"+vo.get(i).photo+".png");
			temp.add(vo.get(i).name);
			temp.add(vo.get(i).assistEfficient+"");
			temp.add(vo.get(i).blockShotEfficient+"");
			temp.add(vo.get(i).stealEfficient+"");
			temp.add(vo.get(i).defendReboundEfficient+"");
			temp.add(vo.get(i).offendReboundEfficient+"");
			temp.add(vo.get(i).faultEfficient+"");
			temp.add(vo.get(i).frequency+"");
			temp.add(vo.get(i).gmSc+"");
			temp.add(vo.get(i).realShot+"");
			temp.add(vo.get(i).reboundEfficient+"");
			temp.add(vo.get(i).shotEfficient+"");
		
			datas.add(temp);
		}
		return datas;
	}
}

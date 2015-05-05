package presentation.match;

import java.util.ArrayList;

import vo.matchvo.MatchContentPlayerVO;
import vo.matchvo.MatchVO;

public class MatchVO2List {
	public ArrayList<ArrayList<String>> playerDeitail(ArrayList<MatchContentPlayerVO> vo){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < vo.size() ;i++){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(vo.get(i).date);
			temp.add(vo.get(i).matchID+"");
			temp.add(vo.get(i).vs);
			temp.add(vo.get(i).minute+"");
			temp.add((double)vo.get(i).shot/(double)vo.get(i).shotA+"");
			temp.add(vo.get(i).shot+"");
			temp.add(vo.get(i).shotA+"");
			temp.add(vo.get(i).three+"/"+vo.get(i).threeA);
			temp.add(vo.get(i).penalty+"/"+vo.get(i).penaltyA);
			temp.add(vo.get(i).offendRebound+"");
			temp.add(vo.get(i).offendRebound+"");
			temp.add(vo.get(i).rebound+"");
			temp.add(vo.get(i).assist+"");
			temp.add(vo.get(i).blockShot+"");
			temp.add(vo.get(i).fault+"");
			temp.add(vo.get(i).foul+"");
			temp.add(vo.get(i).point+"");
			
			datas.add(temp);
		}
		return datas;
	}
	public ArrayList<ArrayList<String>> matchList(ArrayList<MatchVO> vo){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < vo.size() ;i++){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(vo.get(i).date);
			temp.add(vo.get(i).id+"");
			temp.add(vo.get(i).homeTeam.name+"-"+vo.get(i).guestTeam.name);
			temp.add(vo.get(i).homePoint+"-"+vo.get(i).guestPoint);
			temp.add(vo.get(i).homePoint_1+"-"+vo.get(i).guestPoint_1);
			temp.add(vo.get(i).homePoint_2+"-"+vo.get(i).guestPoint_2);
			temp.add(vo.get(i).homePoint_3+"-"+vo.get(i).guestPoint_3);
			temp.add(vo.get(i).homePoint_4+"-"+vo.get(i).guestPoint_4);
			
			
			datas.add(temp);
		}
		return datas;
	}
	
}

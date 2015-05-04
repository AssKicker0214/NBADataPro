package presentation.match;

import java.util.ArrayList;

import vo.matchvo.MatchContentPlayerVO;

public class MatchVO2List {
	public ArrayList<ArrayList<String>> playerDeitail(ArrayList<MatchContentPlayerVO> vo){
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < vo.size() ;i++){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(vo.get(i).date);
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
}

package dataservice.player;

import java.util.ArrayList;

import vo.playervo.HotPlayersVO;
import vo.playervo.PlayerVO;

public class PlayerData_stub implements PlayerDataService{

	


	@Override
	public ArrayList<HotPlayersVO> DailyKing(int num, String sortBy) {
		ArrayList<HotPlayersVO>  result = new ArrayList<HotPlayersVO>();
		HotPlayersVO vo = new HotPlayersVO();
		vo.name = "Aaron Brooks";
		vo.number = 12;
		vo.photo = "Aaron Brooks";
		vo.position = "F";
		vo.teamName = "Hawks";
		vo.teamPhoto = "BKN";
		vo.value = 39;
		HotPlayersVO vo3 = new HotPlayersVO();
		vo3.name = "Aaron Brooks";
		vo3.number = 12;
		vo3.photo = "Aaron Brooks";
		vo3.position = "F";
		vo3.teamName = "Hawks";
		vo3.teamPhoto = "ATL";
		vo3.value = 39;
		
		if(sortBy.equals("avgPoint"))
			result.add(vo);
		else
			result.add(vo3);
		
		HotPlayersVO vo2 = new HotPlayersVO();
		vo2.name = "Aaron Brooks";
		vo2.number = 12;
		vo2.photo = "Aaron Brooks";
		vo2.position = "F";
		vo2.teamName = "Hawks";
		vo2.teamPhoto = "ATL";
		vo2.value = 39;
		result.add(vo2);
		result.add(vo2);
		result.add(vo2);
		result.add(vo2);
			
		return result;
	}

	@Override
	public ArrayList<HotPlayersVO> SeasonKing(int num, String sortBy) {
		ArrayList<HotPlayersVO>  result = new ArrayList<HotPlayersVO>();
		HotPlayersVO vo = new HotPlayersVO();
		vo.name = "Aaron Brooks";
		vo.number = 12;
		vo.photo = "Aaron Brooks";
		vo.position = "F";
		vo.teamName = "Hawks";
		vo.teamPhoto = "ATL";
		vo.value = 39;
		HotPlayersVO vo3 = new HotPlayersVO();
		vo3.name = "Aaron Brooks";
		vo3.number = 12;
		vo3.photo = "Aaron Brooks";
		vo3.position = "F";
		vo3.teamName = "Hawks";
		vo3.teamPhoto = "BKN";
		vo3.value = 39;
		
		if(sortBy.equals("avgPoint"))
			result.add(vo);
		else
			result.add(vo3);
		
		HotPlayersVO vo2 = new HotPlayersVO();
		vo2.name = "Aaron Brooks";
		vo2.number = 12;
		vo2.photo = "Aaron Brooks";
		vo2.position = "F";
		vo2.teamName = "Hawks";
		vo2.teamPhoto = "ATL";
		vo2.value = 39;
		result.add(vo2);
		result.add(vo2);
		result.add(vo2);
		result.add(vo2);
			
		return result;
	}

	@Override
	public ArrayList<HotPlayersVO> hotPlayer(int num, String sortBy) {
		ArrayList<HotPlayersVO>  result = new ArrayList<HotPlayersVO>();
		HotPlayersVO vo = new HotPlayersVO();
		vo.name = "Aaron Brooks";
		vo.number = 12;
		vo.photo = "Aaron Brooks";
		vo.position = "F";
		vo.teamName = "Hawks";
		vo.teamPhoto = "ATL";
		vo.upgradeRate = 39.98;
		vo.value = 39;
		
		HotPlayersVO vo3 = new HotPlayersVO();
		vo3.name = "Aaron Brooks";
		vo3.number = 12;
		vo3.photo = "Aaron Brooks";
		vo3.position = "F";
		vo3.teamName = "Hawks";
		vo.upgradeRate = 39.98;
		vo3.teamPhoto = "BKN";
		vo3.value = 39;
		
		if(sortBy.equals("avgPoint"))
			result.add(vo);
		else
			result.add(vo3);
		
		HotPlayersVO vo2 = new HotPlayersVO();
		vo2.name = "Aaron Brooks";
		vo2.number = 12;
		vo2.photo = "Aaron Brooks";
		vo2.position = "F";
		vo2.teamName = "Hawks";
		vo2.teamPhoto = "ATL";
		vo2.upgradeRate = 39.98;

		vo2.value = 39;
		result.add(vo2);
		result.add(vo2);
		result.add(vo2);
		result.add(vo2);
			
		return result;
	}

	@Override
	public PlayerVO findPlayerData(int playerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerVO findPlayerData(String name) {
		PlayerVO vo = new PlayerVO();
		vo.photo = "Aaron Gray";
		vo.name = "Aaron Gray";
		vo.team = "Hawks";
		return vo;
	}

	@Override
	public ArrayList<PlayerVO> sortPlayerInfo(ArrayList<sortParam> sortBy) {
		ArrayList<PlayerVO> vol = new ArrayList<PlayerVO>();
		PlayerVO vo1 = new PlayerVO();
		vo1.photo = "Aaron Brooks";
		vo1.name = "Aaron Brooks";
		vol.add(vo1);
		PlayerVO vo2 = new PlayerVO();
		vo2.photo = "Aaron Gray";
		vo2.name = "Aaron Gray";
		vol.add(vo2);
		return vol;
	}

	@Override
	public ArrayList<PlayerVO> sortPlayerNormal(ArrayList<sortParam> sortBy) {
		ArrayList<PlayerVO> vol = new ArrayList<PlayerVO>();
		PlayerVO vo = new PlayerVO();
		vo.photo = "Aaron Grey";
		vo.name = "Aaron Grey";
		vol.add(vo);
		return vol;
	}

	@Override
	public ArrayList<PlayerVO> sortPlayerNormalAvg(ArrayList<sortParam> sortBy) {
		ArrayList<PlayerVO> vol = new ArrayList<PlayerVO>();
		PlayerVO vo = new PlayerVO();
		vo.photo = "Aaron Brooks";
		vo.name = "Aaron Brooks";
		vol.add(vo);
		return vol;
	}

	@Override
	public ArrayList<PlayerVO> sortPlayerHigh(ArrayList<sortParam> sortBy) {
		ArrayList<PlayerVO> vol = new ArrayList<PlayerVO>();
		PlayerVO vo = new PlayerVO();
		vo.photo = "Aaron Brooks";
		vo.name = "Aaron Brooks";
		vol.add(vo);
		return vol;
	}

	@Override
	public ArrayList<PlayerVO> filterInfo(ArrayList<sortParam> sortBy,
			ArrayList<String> position, ArrayList<String> league, int numS,
			int numE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerVO> filterNormal(ArrayList<sortParam> sortBy,
			ArrayList<String> position, ArrayList<String> league, int numS,
			int numE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerVO> filterNormalAvg(ArrayList<sortParam> sortBy,
			ArrayList<String> position, ArrayList<String> league, int numS,
			int numE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerVO> filterHigh(ArrayList<sortParam> sortBy,
			ArrayList<String> position, ArrayList<String> league, int numS,
			int numE) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//联盟平均数据 返回值包括 场均得分，场均篮板，场均助攻，罚球命中率，三分命中率
	@Override
	public PlayerVO avgLeague() {
		PlayerVO vo = new PlayerVO();
		vo.avgPoint = 5;
		vo.avgRebound = 10;
		vo.avgAssist = 4;
		vo.penalty = 100.0;
		vo.three = 90.0;
		return vo;
	}

	
	@Override
	public ArrayList<PlayerVO> findPlayers(String msg) {
		ArrayList<PlayerVO>  result = new ArrayList<PlayerVO>();
		PlayerVO vo = new PlayerVO();
		vo.name = "Aaron Brooks";
		vo.photo = "Aaron Brooks";
		for(int i = 0;i < 10;i++){
			result.add(vo);
		}
		return result;
	}

	

}

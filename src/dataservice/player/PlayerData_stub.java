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
		vo.teamPhoto = "ATL";
		vo.value = 39;
		
		result.add(vo);
		
		HotPlayersVO vo2 = new HotPlayersVO();
		vo2.name = "Aaron Brooks";
		vo2.number = 12;
		vo2.photo = "1";
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
		
		result.add(vo);
		
		HotPlayersVO vo2 = new HotPlayersVO();
		vo2.name = "Aaron Brooks";
		vo2.number = 12;
		vo2.photo = "1";
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
		
		result.add(vo);
		
		HotPlayersVO vo2 = new HotPlayersVO();
		vo2.name = "Aaron Brooks";
		vo2.number = 12;
		vo2.photo = "1";
		vo2.position = "F";
		vo2.teamName = "Hawks";
		vo2.teamPhoto = "ATL";
		vo.upgradeRate = 39.98;

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
	public ArrayList<PlayerVO> findPlayerData(String msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerVO> sortPlayerInfo(ArrayList<sortParam> sortBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerVO> sortPlayerNormal(ArrayList<sortParam> sortBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerVO> sortPlayerNormalAvg(ArrayList<sortParam> sortBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerVO> sortPlayerHigh(ArrayList<sortParam> sortBy) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public PlayerVO avgLeague(ArrayList<String> attributes) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

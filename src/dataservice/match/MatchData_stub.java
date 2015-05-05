package dataservice.match;

import java.util.ArrayList;

import vo.matchvo.MatchContentPlayerVO;
import vo.matchvo.MatchVO;

public class MatchData_stub implements MatchDataService{

	@Override
	public ArrayList<MatchContentPlayerVO> FindRecentMatches_p(
			String playerName) {
		ArrayList<MatchContentPlayerVO> result = new ArrayList<MatchContentPlayerVO>();
		MatchContentPlayerVO vo1 = new MatchContentPlayerVO();
		vo1.date = "2014-1-1";
		result.add(vo1);
		MatchContentPlayerVO vo2 = new MatchContentPlayerVO();
		vo2.date = "2015-1-1";
		result.add(vo2);
		
		return result;
	}

	@Override
	public ArrayList<MatchVO> FindRecentMatches_t(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatchVO findMatch(int matchID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatchVO> findByDate(String start, String end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatchContentPlayerVO> findByDP(String start, String end,
			String playerName) {
		ArrayList<MatchContentPlayerVO> result = new ArrayList<MatchContentPlayerVO>();
		MatchContentPlayerVO vo1 = new MatchContentPlayerVO();
		vo1.date = "2014-1-1";
		result.add(vo1);
		MatchContentPlayerVO vo2 = new MatchContentPlayerVO();
		vo2.date = "2015-1-1";
		result.add(vo2);
		
		return result;
	}

	@Override
	public ArrayList<MatchVO> findByDT(String start, String end, String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

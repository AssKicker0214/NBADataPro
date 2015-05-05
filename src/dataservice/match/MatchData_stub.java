package dataservice.match;

import java.util.ArrayList;

import vo.matchvo.MatchContentPlayerVO;
import vo.matchvo.MatchVO;
import vo.teamvo.HotTeamsVO;

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
		ArrayList<MatchVO> vol = new ArrayList<MatchVO>();
		MatchVO vo = new MatchVO();
		HotTeamsVO ht = new HotTeamsVO();
		HotTeamsVO gt = new HotTeamsVO();
		ht.name = "ATL";
		gt.name = "BKN";
		vo.date = "2015-5-5";
		vo.homeTeam = ht;
		vo.guestTeam = gt;
		vol.add(vo);
		
		System.out.println(vol.get(0).homeTeam.name+vol.get(0).guestTeam.name);
		
		return vol;
	}

	@Override
	public MatchVO findMatch(int matchID) {
		MatchVO vo = new MatchVO();
		vo.date = "2015-5-5";		
		return vo;
	}

	@Override
	public ArrayList<MatchVO> findByDate(String start, String end) {
		ArrayList<MatchVO> vol = new ArrayList<MatchVO>();
		MatchVO vo = new MatchVO();
		HotTeamsVO ht = new HotTeamsVO();
		HotTeamsVO gt = new HotTeamsVO();
		ht.name = "ATL";
		gt.name = "BKN";
		vo.date = "2015-5-5";
		vo.homeTeam = ht;
		vo.guestTeam = gt;
		vol.add(vo);
		
		
		return vol;
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
		ArrayList<MatchVO> vol = new ArrayList<MatchVO>();
		MatchVO vo = new MatchVO();
		HotTeamsVO ht = new HotTeamsVO();
		HotTeamsVO gt = new HotTeamsVO();
		ht.name = "ATL";
		gt.name = "BKN";
		vo.date = "2015-5-5";
		vo.homeTeam = ht;
		vo.guestTeam = gt;
		vol.add(vo);
		
		
		return vol;
	}

	
}

package dataservice.match;

import java.util.ArrayList;

import vo.matchvo.MatchVO;

public interface MatchDataService {
	public ArrayList<MatchVO> FindRecentMatches_p(int num, int playerID);// 球员最近比赛信息
	public ArrayList<MatchVO> FindRecentMatches_t(int num, int teamId);// 球队最近比赛信息

	public ArrayList<MatchVO> findByDate(String start, String end);//根据日期查找比赛
	public ArrayList<MatchVO> findByDP(String start, String end, int playerID);//根据日期及球员查找
	public ArrayList<MatchVO> findByDT(String start, String end, int teamId);//根据日期及球队查找
}

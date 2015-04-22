package dataservice.match;

import java.util.ArrayList;

import po.matchpo.MatchPO;

public interface MatchDataService {
	public ArrayList<MatchPO> FindRecentMatches_p(int num, int playerID);// 球员最近比赛信息
	public ArrayList<MatchPO> FindRecentMatches_t(int num, int teamId);// 球队最近比赛信息

	public ArrayList<MatchPO> findByDate(String start, String end);//根据日期查找比赛
	public ArrayList<MatchPO> findByDP(String start, String end, int playerID);//根据日期及球员查找
	public ArrayList<MatchPO> findByDT(String start, String end, int teamId);//根据日期及球队查找
}

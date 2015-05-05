package dataservice.match;

import java.util.ArrayList;

import vo.matchvo.MatchContentPlayerVO;
import vo.matchvo.MatchVO;

public interface MatchDataService {
	public ArrayList<MatchContentPlayerVO> FindRecentMatches_p(int num, String playerName);// 球员最近比赛信息
	public ArrayList<MatchContentPlayerVO> findByDP(String start, String end, String playerName);//根据日期及球员查找

	
	
	//返回MatchVO全部属性
	public MatchVO findMatch(int matchID);//根据id返回比赛
	
	//以下3个方法返回的MatchVO中不需要2个球员list（homeTeamPlayer，guestTeamPlayer）
	public ArrayList<MatchVO> FindRecentMatches_t(String teamName);// 球队最近5场比赛信息
	public ArrayList<MatchVO> findByDate(String start, String end);//根据日期查找比赛
	public ArrayList<MatchVO> findByDT(String start, String end, String teamName);//根据日期及球队查找
}

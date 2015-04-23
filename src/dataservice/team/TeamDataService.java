package dataservice.team;

import java.util.ArrayList;

import po.teampo.HotTeamsPO;
import po.teampo.TeamPO;

public interface TeamDataService {
	
	public ArrayList<HotTeamsPO> hotTeams(int num,String sortBy);//热点球队
	
	public TeamPO findTeamInfo(int teamId,boolean isAvg);// 返回确切的某一个球队的基本信息

	public ArrayList<TeamPO> findTeamInfoList(boolean isAvg);// 返回球队基本信息列表，按id升序排列;true表示场均

	public ArrayList<TeamPO> sortTeamInfoList(String sortBy, boolean desc, boolean isAvg);// 排序球队列表，true表示降序
}

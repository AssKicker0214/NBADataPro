package dataservice.team;

import java.util.ArrayList;

import po.teampo.TeamDataPO;
import po.teampo.TeamInfoPO;

public interface TeamDataService {
	

	public TeamInfoPO findTeamInfo(int teamId);// 返回确切的某一个球队的基本信息
	public TeamDataPO findTeamData(int teamId);// 返回确切的某一个球队的比赛信息

	public ArrayList<TeamInfoPO> findTeamInfoList();// 返回球队基本信息列表，按id升序排列
	public ArrayList<TeamDataPO> findTeamDataList(ArrayList<String> list);// 返回球队比赛信息列表，按id升序排列

	public ArrayList<TeamDataPO> sortTeamList(ArrayList<String> list,
                                              String mainProperty, boolean order);// 排序球队列表，true表示降序
}

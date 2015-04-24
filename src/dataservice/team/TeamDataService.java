package dataservice.team;

import java.util.ArrayList;

import po.teampo.HotTeamsPO;
import po.teampo.TeamPO;

public interface TeamDataService {
	
	public ArrayList<HotTeamsPO> hotTeams(int num,String sortBy);//热点球队
	
	public TeamPO findTeamInfo(int teamId,boolean isAvg);// 返回确切的某一个球队的基本信息

	public ArrayList<TeamPO> findTeamNormal(boolean isAvg);// 返回球队基本信息列表，按id升序排列;true表示场均
	public ArrayList<TeamPO> findTeamHigh(boolean isAvg);// 返回球队高阶信息列表，按id升序排列;true表示场均

	public ArrayList<TeamPO> sortTeamNormal(int num,String sortBy, boolean desc, boolean isAvg);// 排序球队基本信息列表，true表示降序
	public ArrayList<TeamPO> sortTeamHigh(int num,String sortBy, boolean desc, boolean isAvg);// 排序球队高阶信息列表，true表示降序
}

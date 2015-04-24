package dataservice.team;

import java.util.ArrayList;

import vo.playervo.PlayerVO;
import vo.teamvo.HotTeamsVO;
import vo.teamvo.TeamVO;

public interface TeamDataService {
	
	public ArrayList<HotTeamsVO> hotTeams(int num,String sortBy);//热点球队
	
	public TeamVO findTeamInfo(int teamId,boolean isAvg);// 返回确切的某一个球队的基本信息

	public ArrayList<TeamVO> findTeamNormal(boolean isAvg);// 返回球队基本信息列表，按id升序排列;true表示场均
	public ArrayList<TeamVO> findTeamHigh();// 返回球队高阶信息列表，按id升序排列

	public ArrayList<TeamVO> sortTeamNormal(int num,String sortBy, boolean desc, boolean isAvg);// 排序球队基本信息列表，true表示降序
	public ArrayList<TeamVO> sortTeamHigh(int num,String sortBy, boolean desc);// 排序球队高阶信息列表，true表示降序
	
	public TeamVO avgLeague(ArrayList<String> attributes);//联盟平均数据
	
	public ArrayList<PlayerVO> teamMemberList(int teamID);//某球队球员的基本信息
}

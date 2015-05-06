package dataservice.team;

import java.util.ArrayList;

import vo.playervo.PlayerVO;
import vo.teamvo.HotTeamsVO;
import vo.teamvo.TeamVO;


public interface TeamDataService {
	
	/**
	 * 根据排序依据降序返回前num支球队
	 * @Param num:返回的球队的个数  sortBy：排序依据 参数范围: avgPoint;avgRebound;avgSteal;avgAssist;avgBlockShot;shot;three;penalty
	 * @Return HotTeamsVO中的全部属性
	 */
	public ArrayList<HotTeamsVO> hotTeams(int num,String sortBy);//热点球队
	
	/**
	 * 返回确切的某一个球队的基本信息
	 * @Param teamID 球队ID
	 * @Return 返回TeamVO中有均总之分的属性值的avg属性，和不区分场均和总计的全部属性
	 */
	public TeamVO findTeamInfo(int teamId);// 
	public TeamVO findTeamInfo(String teamName);

	
	//返回姓名包含输入的字符串的球员列表，返回值包括id,name,photo
	public ArrayList<TeamVO> findTeams(String msg);

	
	/**
	 * 返回球队普通数据列表
	 * @Return 返回TeamVO中的normal info以及teamName，photo
	 */
	public ArrayList<TeamVO> findTeamNormal();  
	/**
	 * 返回球队普通数据均值列表
	 * @Return 返回TeamVO中的avg normal info,
	 * 		及以numOfGame,penalty,shot,three(即normal info 中不分均总的数据), 及teamName,photo,
	 */
	public ArrayList<TeamVO> findTeamNormalAvg(); 
	/**
	 * 返回球队基本信息列表
	 * @Return 返回TeamVO中的basic info
	 */
	public ArrayList<TeamVO> findTeamBasic(); 
	/**
	 * 返回球队高阶数据列表
	 * @Return 返回TeamVO中的high info及以及teamName，photo
	 */
	public ArrayList<TeamVO> findTeamHigh();      

	/**
	 * 返回球队排序列表
	 * @Param num：返回排序后前num支球队信息
	 * @Param sortBy:排序依据    参数范围:需要返回的属性中除teamName和photo外的全部属性
	 * @Param desc: true表示降序排列
	 * @Return 返回TeamVO中的normal info以及teamName，photo
	 */
	public ArrayList<TeamVO> sortTeamNormal(int num,String sortBy, boolean desc);
	/**
	 * 参数同上
	 * @Return 返回TeamVO中的avg normal info,
	 * 		及以numOfGame,penalty,shot,three(即normal info 中不分均总的数据), 及teamName,photo,
	 */
	public ArrayList<TeamVO> sortTeamNormalAvg(int num,String sortBy, boolean desc);
	/**
	 * 参数同上
	 *  @Return 返回TeamVO中的high info及以及teamName，photo
	 */
	public ArrayList<TeamVO> sortTeamHigh(int num,String sortBy, boolean desc);
	


	/**
	 * 返回球队联盟总数据
	 * @Param attributes：需要返回的属性列表
	 * @Param league: 联盟  参数范围：E; W;
	 * @Return TeamVO中attributes指示的属性的联盟平均值
	 */
//	public TeamVO avgLeague(ArrayList<String> attributes, char league);//联盟平均数据


	
	/**
	 * 返回球队联盟总数据
	 * @Param teamID：球队ID
	 * @Return 该球队的所有球员的avg normal info 
	 * 		以及age,efficiency,numOfGame,penalty,shot,start,three(即normal info 中不分均总的数据)
	 * 		及ID，photo，name
	 */
	public ArrayList<PlayerVO> teamMemberList(int teamID);//某球队球员的基本信息
}

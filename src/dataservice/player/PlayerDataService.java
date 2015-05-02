package dataservice.player;

import java.util.ArrayList;

import vo.playervo.HotPlayersVO;
import vo.playervo.PlayerVO;

public interface PlayerDataService {
			
	public PlayerVO findPlayerData(int playerId, boolean isAvg);//返回确切的某一个球员；true表示场均数据
	public ArrayList<PlayerVO> findPlayerData(String msg);//返回确切的某一个球员；true表示场均数据

	public ArrayList<PlayerVO> findPlayer();//返回球员信息列表，按id升序排列

	//排序球员列表
	public ArrayList<PlayerVO> sortPlayerNormal(ArrayList<sortParam> sortBy, boolean isAvg);
	public ArrayList<PlayerVO> sortPlayerHigh(ArrayList<sortParam> sortBy);//排序球员列表

	//返回筛选球员普通数据列表
	public ArrayList<PlayerVO> filterNormal(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league,ArrayList<String> age,int numS,int numE,boolean isAvg);
	//返回筛选球员高阶数据列表
	public ArrayList<PlayerVO> filterHigh(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league,ArrayList<String> age,int numS,int numE,boolean isAvg);

	//以下默认返回平均数据
	public ArrayList<HotPlayersVO> DailyKing(int num,String sortBy);//当日热门球员	
	public ArrayList<HotPlayersVO> SeasonKing(int num,String sortBy);//赛季热门球员

	public ArrayList<HotPlayersVO> hotPlayer(int num,String sortBy);//进步最快球员
	
	public PlayerVO avgLeague(ArrayList<String> attributes);//联盟平均数据

}

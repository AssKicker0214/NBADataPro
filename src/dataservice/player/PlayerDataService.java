package dataservice.player;

import java.util.ArrayList;

import po.playerpo.HotPlayersPO;
import po.playerpo.PlayerPO;

public interface PlayerDataService {
			
	public PlayerPO findPlayerData(int playerId, boolean isAvg);//返回确切的某一个球员；true表示场均数据
	
	public ArrayList<PlayerPO> findPlayerNormal(boolean isAvg);//返回球员信息列表，按id升序排列
	public ArrayList<PlayerPO> findPlayerHigh(boolean isAvg);//返回球员信息列表，按id升序排列

	//排序球员列表，sortBy中的字符串格式示例：assist.desc(倒序) assist.asc(正序)
	public ArrayList<PlayerPO> sortPlayerNormal(ArrayList<String> sortBy, boolean isAvg);
	public ArrayList<PlayerPO> sortPlayerHigh(ArrayList<String> sortBy, boolean isAvg);//排序球员列表

	//返回筛选球员普通数据列表
	public ArrayList<PlayerPO> filterNormal(ArrayList<String> sortBy, ArrayList<String> position, ArrayList<String> league,ArrayList<String> age,int num,boolean isAvg);
	//返回筛选球员高阶数据列表
	public ArrayList<PlayerPO> filterHigh(ArrayList<String> sortBy, ArrayList<String> position, ArrayList<String> league,ArrayList<String> age,int num,boolean isAvg);

	//以下默认返回平均数据
	public ArrayList<HotPlayersPO> DailyKing(int num,String sortBy);//当日热门球员	
	public ArrayList<HotPlayersPO> SeasonKing(int num,String sortBy);//赛季热门球员

	public ArrayList<HotPlayersPO> hotPlayer(int num,String sortBy);//进步最快球员
}

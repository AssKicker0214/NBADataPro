package dataservice.player;

import java.util.ArrayList;

import po.playerpo.HotPlayersPO;
import po.playerpo.PlayerPO;

public interface PlayerDataService {
			
	public PlayerPO findPlayerData(int playerId, boolean isAvg);//返回确切的某一个球员；true表示场均数据
	
	public ArrayList<PlayerPO> findPlayerDataList(boolean isAvg);//返回球员信息列表，按id升序排列

	public ArrayList<PlayerPO> sortPlayerDataList(ArrayList<String> sortBy, boolean desc, boolean isAvg);//排序球员列表，true表示降序

	//返回球员前50列表
	public ArrayList<PlayerPO> findTop50(String mainProperty, ArrayList<String> position, ArrayList<String> division);
	public ArrayList<PlayerPO> findTop50_pos(String mainProperty, ArrayList<String> position);
	public ArrayList<PlayerPO> findTop50_div(String mainProperty, ArrayList<String> division);
	public ArrayList<PlayerPO> findTop50(String mainProperty);

	//以下默认返回平均数据
	public ArrayList<HotPlayersPO> DailyKing(int num,String sortBy);//当日热门球员	
	public ArrayList<HotPlayersPO> SeasonKing(int num,String sortBy);//赛季热门球员

	public ArrayList<HotPlayersPO> hotPlayer(int num,String sortBy);//进步最快球员
}

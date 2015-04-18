package dataservice.player;

import java.util.ArrayList;

import po.playerpo.PlayerPO;



public interface PlayerDataService {
	
	public PlayerPO findPlayerInfo(int playerId);//返回确切的某一个球员的基本信息
	public PlayerPO findPlayerData(int playerId);//返回确切的某一个球员的比赛信息
	
	public ArrayList<PlayerPO> findPlayerList(ArrayList<String> list);//返回球员比赛信息列表，按id升序排列
		
	public ArrayList<PlayerPO> sortPlayerList(ArrayList<String> list, String mainProperty, boolean order);//排序球员列表，true表示降序
	
	//返回球员前50列表
	public ArrayList<PlayerPO> findTop50(ArrayList<String> list, String mainProperty, ArrayList<String> position, ArrayList<String> division);
	public ArrayList<PlayerPO> findTop50_pos(ArrayList<String> list, String mainProperty, ArrayList<String> position);
	public ArrayList<PlayerPO> findTop50_div(ArrayList<String> list, String mainProperty, ArrayList<String> division);
	public ArrayList<PlayerPO> findTop50(ArrayList<String> list, String mainProperty);

	
	
}

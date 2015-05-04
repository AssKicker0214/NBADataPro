package dataservice.player;

import java.util.ArrayList;

import vo.playervo.HotPlayersVO;
import vo.playervo.PlayerVO;

public interface PlayerDataService {
			
	public PlayerVO findPlayerData(int playerId);//返回确切的某一个球员，默认场均
	public PlayerVO findPlayerData(String name);//返回确切的某一个球员，默认场均
	
	//返回姓名包含输入的字符串的球员列表，返回值包括id,name,photo
	public ArrayList<PlayerVO> findPlayers(String msg);
	

	//排序球员列表
	public ArrayList<PlayerVO> sortPlayerInfo(ArrayList<sortParam> sortBy);
	public ArrayList<PlayerVO> sortPlayerNormal(ArrayList<sortParam> sortBy);
	public ArrayList<PlayerVO> sortPlayerNormalAvg(ArrayList<sortParam> sortBy);
	public ArrayList<PlayerVO> sortPlayerHigh(ArrayList<sortParam> sortBy);

	//返回筛选球员普通数据列表
	public ArrayList<PlayerVO> filterInfo(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league,int numS,int numE);
	public ArrayList<PlayerVO> filterNormal(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league,int numS,int numE);
	public ArrayList<PlayerVO> filterNormalAvg(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league,int numS,int numE);
	public ArrayList<PlayerVO> filterHigh(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league,int numS,int numE);

	//以下默认返回平均数据
	
	//返回HotPlayersVO中除upgradeRate外的全部数据
	public ArrayList<HotPlayersVO> DailyKing(int num,String sortBy);//当日热门球员	
	public ArrayList<HotPlayersVO> SeasonKing(int num,String sortBy);//赛季热门球员
	//返回HotPlayersVO中的全部数据，其中value属性为赛季平均数据（暂定）
	public ArrayList<HotPlayersVO> hotPlayer(int num,String sortBy);//进步最快球员
	
	public PlayerVO avgLeague();//联盟平均数据 返回值包括 场均得分，场均篮板，场均助攻，罚球命中率，三分命中率

}

package vo.matchvo;

import java.util.ArrayList;

import vo.teamvo.HotTeamsVO;

public class MatchVO {
	public int id;
	
	public String date;
	//比分
	public int homePoint;	//主场球队总得分
	public int guestPoint;	//客场球队总得分
	public int homePoint_1;		//主场球队第一节得分
	public int guestPoint_1;	//客场球队第一节得分
	public int homePoint_2;		//主场球队第二节得分
	public int guestPoint_2;	//客场球队第二节得分
	public int homePoint_3;		//主场球队第三节得分
	public int guestPoint_3;	//客场球队第三节得分
	public int homePoint_4;		//主场球队第四节得分
	public int guestPoint_4;	//客场球队第四节得分
	
	public HotTeamsVO homeTeam; 	//主场球队,需要HotTeamsVO中除value以外的值
	public HotTeamsVO guestTeam; 	//客场球队,需要HotTeamsVO中除value以外的值
	
	public ArrayList<MatchContentPlayerVO> homeTeamPlayer;	//主场球队上场球员
	public ArrayList<MatchContentPlayerVO> guestTeamPlayer;	//客场球队上场球员
	
}

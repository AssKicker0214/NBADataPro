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


    public void show(){
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("id:"+id+" date:"+date+" team1:"+homeTeam.name+" "+"team2:"+guestTeam.name+" score1:"+homePoint+" score2:"+guestPoint);
        System.out.println("score1_1:"+homePoint_1+" score2_1:"+guestPoint_1);
        System.out.println("score1_2:"+homePoint_2+" score2_2:"+guestPoint_2);
        System.out.println("score1_3:"+homePoint_3+" score2_3:"+guestPoint_3);
        System.out.println("score1_4:"+homePoint_4+" score2_4:"+guestPoint_4);
        System.out.println(homeTeam.name+"--------------------------->>>>>>>>>>>>>>>>>>>>>>>>>");
        for (int i = 0; i< homeTeamPlayer.size();i++){
            homeTeamPlayer.get(i).show();
        }
        System.out.println(guestTeam.name+"--------------------------->>>>>>>>>>>>>>>>>>>>>>>>>");
        for (int i = 0; i< guestTeamPlayer.size();i++){
            guestTeamPlayer.get(i).show();
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}

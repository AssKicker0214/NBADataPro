package vo.teamvo;
/*
 * 球队
 */
public class TeamVO {
	
	//basic info
	public int id;					//球队ID
	public String photo;			//球队图片
	public String teamName;			//球队名称
	public String abridge;			//球队名称缩写
	public String location;			//所在地
	public char league;			//赛区
	public String division;			//分区
	public String homeCourt;		//主场
	public int 	foundTime;			//建立时间
	
	//normal info
	public int 	assist;			//助攻数
	public int 	blockShot;		//盖帽数
	public int 	defendRebound;	//防守篮板数
	public int 	fault;			//失误数
	public int 	foul;			//犯规数
	public int 	numOfGame;		//比赛场数
	public int 	offendRebound;	//进攻篮板数
	public double 	penalty;	//罚球命中率
	public int 	point;			//得分
	public int 	rebound;		//篮板数
	public double 	shot;		//投篮命中率
	public int 	steal;			//抢断数
	public double 	three;		//三分命中率
	
	//avg normal info
	public double 	avgAssist;			//助攻数
	public double 	avgBlockShot;		//盖帽数
	public double 	avgDefendRebound;	//防守篮板数
	public double 	avgFault;			//失误数
	public double 	avgFoul;			//犯规数
	public double 	avgOffendRebound;	//进攻篮板数
	public double 	avgPoint;			//得分
	public double 	avgRebound;			//篮板数
	public double 	avgSteal;			//抢断数
	
	//high info
	public double 	assistEfficient;		//助攻效率
	public double 	defendEfficient;		//防守效率
	public double 	defendReboundEfficient;	//防守篮板效率
	public double 	offendEfficient;		//进攻效率
	public double 	offendReboundEfficient;	//进攻篮板效率
	public double 	offendRound;			//进攻回合数
	public double 	stealEfficient;			//抢断效率
	public double 	winRate;				//胜率
}

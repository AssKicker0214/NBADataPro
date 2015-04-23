package po.teampo;
/*
 * 球队
 */
public class TeamPO {
	
	public int id;					//球队ID
	public String photo;			//球队图片
	public String teamName;			//球队名称
	public String abridge;			//球队名称缩写
	public String location;			//所在地
	public String conference;		//赛区
	public String division;			//分区
	public String homeCourt;		//主场
	public int 	foundTime;			//建立时间
	
	//normal info
	public double 	assist;			//助攻数
	public double 	blockShot;		//盖帽数
	public double 	defendRebound;	//防守篮板数
	public double 	fault;			//失误数
	public double 	foul;			//犯规数
	public int 		numOfGame;		//比赛场数
	public double 	offendRebound;	//进攻篮板数
	public double 	penalty;		//罚球命中率
	public double 	point;			//得分
	public double 	rebound;		//篮板数
	public double 	shot;			//投篮命中率
	public double 	steal;			//抢断数
	public double 	three;			//三分命中率
	
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

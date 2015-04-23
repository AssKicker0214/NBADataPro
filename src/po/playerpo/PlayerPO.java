package po.playerpo;
/*
 * 球员
 */
public class PlayerPO {
	public int id;					//球员ID
	public String photo;			//头像
	public String conference;		//赛区(联盟)
	public String division;			//分区
	public String posititon;		//球员位置
	public String playerName;		//球员名称
	public String Team;				//所属球队
	
	//normal info
	public int 	age;				//球员年龄
	public double 	assist;			//助攻数
	public double 	blockShot;		//盖帽数
	public double 	defend;			//防守数
	public double 	efficiency;		//效率
	public double 	fault;			//失误数
	public double 	foul;			//犯规数
	public double 	minute;			//上场时间数（单位：分钟）
	public String 	name;			//球员姓名（全名）
	public int 	numOfGame;			//上场次数
	public double 	offend;			//进攻数
	public double 	penalty;		//投篮命中率
	public double 	point;			//得分
	public double 	rebound;		//篮板数
	public double 	shot;			//投篮命中率
	public int 	start;				//首发次数
	public double 	steal;			//抢断数
	public String 	teamName;		//球队名称（缩写）
	public double 	three;			//三分命中率
	
	//high info
	public double 	assistEfficient;		//助攻率
	public double 	blockShotEfficient;		//盖帽率
	public double 	defendReboundEfficient;	//防守篮板率
	public double 	faultEfficient;			//失误率
	public double 	frequency;				//使用率
	public double 	gmSc;					//GmSc效率值
	public String 	league;					//球员所属联盟
	public double 	offendReboundEfficient;	//进攻篮板率
	public String 	position;				//球员位置信息
	public double 	realShot;				//真实命中率
	public double 	reboundEfficient;		//篮板率
	public double 	shotEfficient;			//投篮效率
	public double 	stealEfficient;			//抢断率
}

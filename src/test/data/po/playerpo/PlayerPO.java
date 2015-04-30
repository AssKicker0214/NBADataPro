package test.data.po.playerpo;
/*
 * 赛季数据
 */
public class PlayerPO {
	public int id;					//球员ID
	public String timeOnCourt;		//在场时间
	public int startSession;		//先发场数
	public int matchNum;			//参赛场数
	public double FGP;				//投球命中率(field goal percentage)
	public double TPSP;				//三分命中率(three-point shot percentage )
	public double FTP; 				//罚球命中率(free throw percentage)
	public int BS;					//盖帽数(Block shot)
	public double BSP;				//盖帽率
	public int assist;				//助攻数
	public double assistP;			//助攻率
	public int rebound;				//篮板数
	public double reboundP;			//篮板效率
	public int steal;				//抢断数
	public double stealP;			//抢断效率
	public int turnover;			//失误数
	public double turnoverP;		//失误率
	public int foul;				//犯规数
	public int score;				//比赛得分
	public int offensive;			//进攻数
	public int defense;				//防守数
	public double effiency;			//效率
	public double GmSc;				//GmSc效率
	public double TSP;				//真实命中率(true shooting percentage)
	public double OSE;				//投篮效率(offensive shooting effiency)
	public double OREB;				//进攻篮板率(offensive rebounce)
	public double DREB;				//防守篮板率(defense rebounce)
	public double utiliation;		//使用率
	/*
	 *场均数据 
	 */
	public double AvgBS;					//盖帽数(Block shot)
	public double Avgassist;				//助攻数
	public double Avgrebound;				//篮板数
	public double Avgsteal;					//抢断数
	public double Avgturnover;				//失误数
	public double Avgfoul;					//犯规数
	public double Avgscore;					//比赛得分
	public double Avgoffensive;				//进攻数
	public double Avgdefense;				//防守数
	
	public String photo;			//头像
	public String conference;		//赛区(联盟)
	public String division;			//分区
	public String posititon;		//球员位置
	public String playerName;		//球员名称
	public String Team;				//所属球队
	
}

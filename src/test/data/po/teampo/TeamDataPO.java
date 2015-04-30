package test.data.po.teampo;
/*
 * 赛季数据
 */

public class TeamDataPO {
	public TeamDataPO(){}
	public int id;					//球队ID
	public int matchNum;			//比赛场数
	public int FG;					//投球命中数
	public int FGA;				//投球出手次数
	public double FGP;				//投球命中率
	public int TPS;				//三分命中数
	public int TPSA;  				//三分出手次数
	public double TPSP;			//三分命中率
	public int FTM;				//罚球命中数
	public int FTA;				//罚球出手次数
	public double FTP; 			//罚球命中率
	public int BS;					//盖帽数
	public int assist;				//助攻数
	public double assistP;			//助攻率
	public int rebound;			//篮板数
	public double OREBP;			//进攻篮板效率
	public double DREBP;			//防守篮板效率
	public int ORebound;			//进攻篮板数
	public int DRebound;			//防守篮板数
	public int steal;				//抢断数
	public double stealP;			//抢断效率
	public int turnover;			//失误数
	public int foul;				//犯规数
	public int score;				//比赛得分
	public double WinP;			//胜率
	public double leg;				//进攻回合
	public double ORtg;			//进攻效率
	public double DRtg;			//防守效率
	/*
	 * 场均数据
	 */
	public double AvgFG;					//投球命中数
	public double AvgFGA;					//投球出手次数
	public double AvgTPS;					//三分命中数
	public double AvgTPSA;  				//三分出手次数
	public double AvgFTM;					//罚球命中数
	public double AvgFTA;					//罚球出手次数
	public double AvgBS;					//盖帽数
	public double Avgassist;				//助攻数
	public double Avgrebound;				//篮板数
	public double AvgORebound;				//进攻篮板数
	public double AvgDRebound;				//防守篮板数
	public double Avgsteal;					//抢断数
	public double Avgturnover;				//失误数
	public double Avgfoul;					//犯规数
	public double Avgscore;					//比赛得分
	public double Avgleg;					//进攻回合
}

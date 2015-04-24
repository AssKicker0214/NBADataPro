package data;

import vo.Material;

public class Query {
	public static final String legQA = "sum(a.sthrowallA)+0.4*sum(a.spenaltyallA)-1.07*sum(a.sattackbasA)/sum(a.sattackbasA+b.sdefencebasB)*sum(a.sthrowallA-a.sthrowinA)+1.07*sum(a.smistakeA)";
	public static final String legQB = "sum(b.sthrowallB)+0.4*sum(b.spenaltyallB)-1.07*sum(b.sattackbasB)/sum(b.sattackbasB+a.sdefencebasA)*sum(b.sthrowallB-b.sthrowinB)+1.07*sum(b.smistakeB)";
	public static final String[] teamQuerys = { "count(a.mid) as matchNum,",
			"sum(a.sthrowinA) as FG,", "sum(a.sthrowallA) as FGA,",
			"sum(a.sthrowinA)/sum(a.sthrowallA) as FGP,",
			"sum(a.sthrow3inA) as TPS,", "sum(a.sthrow3allA) as TPSA,",
			"sum(a.sthrow3inA)/sum(a.sthrow3allA) as TPSP,",
			"sum(a.spenaltyinA) as FTM,", "sum(a.spenaltyallA) as FTA,",
			"sum(a.spenaltyinA)/sum(a.spenaltyallA) as FTP,",
			"sum(a.sblockA) as BS,", "sum(a.shelpattA) as assist,",
			"100*sum(a.shelpattA)/(" + legQA + ") as assistP,",
			"sum(a.sallbasA) as rebound,", "",
			"sum(a.sattackbasA) as ORebound,",
			"sum(a.sdefencebasA) as DRebound,", "sum(a.sinterpA) as steal,",
			"100*sum(a.sinterpA)/(" + legQB + ") as stealP,",
			"sum(a.smistakeA) as turnover,", "sum(a.sfoulA) as foul,",
			"sum(a.sscoreA) as score,", "", legQA + " as leg,",
			"100*sum(a.sscoreA)/(" + legQA + ") as ORtg,",
			"100*sum(b.sscoreB)/(" + legQB + ") as DRtg,",
			"sum(a.sattackbasA)/sum(a.sattackbasA+b.sdefencebasB) as OREBP,",
			"sum(a.sdefencebasA)/sum(+a.sdefencebasA+b.sattackbasB) as DREBP,",
			"sum(a.sthrowinA)/count(a.mid) as AvgFG,",
			"sum(a.sthrowallA)/count(a.mid) as AvgFGA,",
			"sum(a.sthrow3inA)/count(a.mid) as AvgTPS,",
			"sum(a.sthrow3allA)/count(a.mid) as AvgTPSA,",
			"sum(a.spenaltyinA)/count(a.mid) as AvgFTM,",
			"sum(a.spenaltyallA)/count(a.mid) as AvgFTA,",
			"sum(a.sblockA)/count(a.mid) as AvgBS,",
			"sum(a.shelpattA)/count(a.mid) as Avgassist,",
			"sum(a.sallbasA)/count(a.mid) as Avgrebound,",
			"sum(a.sattackbasA)/count(a.mid) as AvgORebound,",
			"sum(a.sdefencebasA)/count(a.mid) as AvgDRebound,",
			"sum(a.sinterpA)/count(a.mid) as Avgsteal,",
			"sum(a.smistakeA)/count(a.mid) as Avgturnover,",
			"sum(a.sfoulA)/count(a.mid) as Avgfoul,",
			"sum(a.sscoreA)/count(a.mid) as Avgscore,",
			"(" + legQA + ")/count(a.mid) as Avgleg," };
	
	public static final String[] playerQuerys = {
		"SUM(TIME_TO_SEC(p.inplacetime)) as timeOnCourt,",
		"mn.startSession as startSession,",
		"count(p.mid) as matchNum,",
		"sum(p.throwin)/sum(p.throwall) as FGP,",
		"sum(p.throw3in)/sum(p.throw3all) as TPSP,",
		"sum(p.penaltyin)/sum(p.penaltyall) as FTP,",
		"sum(p.block) as BS,",
		"((sum(p.block)*sum(a.sinplacetimeA/5))/sum(time_to_sec(p.inplacetime)))/sum(b.sthrowallB-b.sthrow3allB) as BSP,",
		"sum(p.helpatt) as assist,",
		"sum(p.helpatt)*(sum(time_to_sec(p.inplacetime)))/(sum(a.sinplacetimeA)/5)*sum(a.sthrowinA)-sum(p.throwin)) as assistP,",
		"sum(p.allbas) as rebound,",
		"(sum(p.allbas)*(sum(a.sinplacetimeA)/5)/sum(p.inplacetime))/sum(a.sallbasA+b.sallbasB) as reboundP,",
		"sum(p.interp) as steal,",
		"((sum(p.interp)*(sum(a.sinplacetimeA)/5))/sum(p.inplacetime))/("
				+ legQB + ") as stealP,",
		"sum(p.mistake) as turnover,",
		"sum(p.mistake)/(sum(p.throwall-throwin)+0.44*sum(p.penaltyall)+sum(p.mistake)) as turnoverP,",
		"sum(p.foul) as foul,",
		"sum(p.score) as score,",
		"sum(p.attackbas) as offensive,",
		"sum(p.defencebas) as defense,",
		"sum(p.score+p.allbas+p.helpatt+p.interp+p.block)-sum(p.throwall-p.throwin)-sum(p.penaltyall-p.penaltyin)-sum(p.mistake) as effiency,",
		"sum(p.score+0.4*p.throwin-0.7*p.throwall-0.4*(p.penaltyall-p.penaltyin)+0.7*p.attackbas+0.3*p.defencebas+p.interp+0.7*p.helpatt+0.7*p.block-0.4*p.foul-p.mistake) as GmSc,",
		"sum(p.score)/(2*(sum(p.throwall)+0.44*sum(p.penaltyall))) as TSP,",
		"(sum(p.throwin)+0.5*sum(p.throw3in))/(sum(p.throwall)) as OSE,",
		"(sum(p.attackbas)*(sum(a.sinplacetimeA)/5)/sum(p.inplacetime))/sum(a.sallbasA+b.sallbasB) as OREB,",
		"(sum(p.defencebas)*(sum(a.sinplacetimeA)/5)/sum(p.inplacetime))/sum(a.sallbasA+b.sallbasB) as DREB,",
		"(sum(p.throwall+0.44*p.penaltyall+p.mistake)*(sum(a.sinplacetimeA)/5)/sum(p.inplacetime))/(sum(a.sthrowallA+0.44*a.spenaltyallA+a.smistakeA)) as utiliation,",
		"sum(p.block)/count(p.mid) as AvgBS,",
		"sum(p.helpatt)/count(p.mid) as Avgassist,",
		"sum(p.allbas)/count(p.mid) as Avgrebound,",
		"sum(p.interp)/count(p.mid) as Avgsteal,",
		"sum(p.mistake)/count(p.mid) as Avgturnover,",
		"sum(p.foul)/count(p.mid) as Avgfoul,",
		"sum(p.score)/count(p.mid) as Avgscore,",
		"sum(p.attackbas)/count(p.mid) as Avgoffensive,",
		"sum(p.defencebas)/count(p.mid) as Avgdefense,",
		"pi.photo as photo,", "pi.conference as conference,",
		"pi.division as division,", "pi.posititon as posititon,",
		"pi.playerName as playerName,", "pi.Team as Team," };
	
	public static String getQuery(Material material,String t) {
		switch (material) {
		case inplacetime:
			return "sum(inplacetime) as sinplacetime"+t;
		case throwin:
			return "sum(throwin) as sthrowin"+t;
		case throwall:
			return "sum(throwall) as sthrowall"+t;
		case throw3in:
			return "sum(throw3in) as sthrow3in"+t;
		case throw3all:
			return "sum(throw3all) as sthrow3all"+t;
		case penaltyin:
			return "sum(penaltyin) as spenaltyin"+t;
		case penaltyall:
			return "sum(penaltyall) as spenaltyall"+t;
		case attackbas:
			return "sum(attackbas) as sattackbas"+t;
		case defencebas:
			return "sum(defencebas) as sdefencebas"+t;
		case allbas:
			return "sum(allbas) as sallbas"+t;
		case helpatt:
			return "sum(helpatt) as shelpatt"+t;
		case block:
			return "sum(block) as sblock"+t;
		case mistake:
			return "sum(mistake) as smistake"+t;
		case foul:
			return "sum(foul) as sfoul"+t;
		case score:
			return "sum(score) as sscore"+t;
		case interp:
			return "sum(interp) as sinterp"+t;

		default:
			break;
		}
		return "tid";
	}
	
	public static String getQuery(Material material) {
		switch (material) {
		case photo:
			return "player.imgsrc as photo";
		case conference:
			return "team.area as conference";
		case division:
			return "team.subarea as division";
		case _posititon:
			return "player.position as posititon";
		case playerName:
			return "player.name as playerName";
		case Team:
			return "team.fullname as Team";
		default:
			break;
		}
		return "";
	}
}

package data.player;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import po.playerpo.PlayerPO;
import data.JDBCUtils;
import data.PlayerMaterialSql;
import data.Query;
import dataservice.playerdataservice.PlayerDataService;

public class PlayerData implements PlayerDataService {

	@Override
	public PlayerPO findPlayerData(int playerId) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("timeOnCourt");
		arrayList.add("startSession");
		arrayList.add("matchNum");
		arrayList.add("FGP");
		arrayList.add("TPSP");
		arrayList.add("FTP");
		arrayList.add("BS");
		arrayList.add("BSP");
		arrayList.add("assist");
		arrayList.add("assistP");
		arrayList.add("rebound");
		arrayList.add("reboundP");
		arrayList.add("steal");
		arrayList.add("stealP");
		arrayList.add("turnover");
		arrayList.add("turnoverP");
		arrayList.add("foul");
		arrayList.add("score");
		arrayList.add("offensive");
		arrayList.add("defense");
		arrayList.add("effiency");
		arrayList.add("GmSc");
		arrayList.add("TSP");
		arrayList.add("OSE");
		arrayList.add("OREB");
		arrayList.add("DREB");
		arrayList.add("utiliation");
		arrayList.add("AvgBS");
		arrayList.add("Avgassist");
		arrayList.add("Avgrebound");
		arrayList.add("Avgsteal");
		arrayList.add("Avgturnover");
		arrayList.add("Avgfoul");
		arrayList.add("Avgscore");
		arrayList.add("Avgoffensive");
		arrayList.add("Avgdefense");
		String sql = getSql(arrayList, "p.pid=?");
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			Object[] objects = queryRunner.query(sql, new ArrayHandler(),
					playerId);
			PlayerPO dataPO = getPlayerDataPO(arrayList, objects);
			return dataPO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new PlayerPO();
	}

	@Override
	public ArrayList<PlayerPO> findPlayerList(ArrayList<String> list) {
		String sql = getSql(list);
		sql += " group by p.pid order by p.pid";
		System.out.println(sql);
		ArrayList<PlayerPO> arrayList = new ArrayList<PlayerPO>();
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			List<Object[]> resultList = queryRunner.query(sql,
					new ArrayListHandler());
			for (int i = 0; i < resultList.size(); i++) {
				Object[] objects = resultList.get(i);
				PlayerPO dataPO = getPlayerDataPO(list, objects);
				arrayList.add(dataPO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayList;
	}

	@Override
	public ArrayList<PlayerPO> sortPlayerList(ArrayList<String> list,
			String mainProperty, boolean order) {
		String sql = getSql(list);
		sql += " group by p.pid order by " + mainProperty;
		if (order) {
			sql += " desc";
		}
		ArrayList<PlayerPO> arrayList = new ArrayList<PlayerPO>();
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			List<Object[]> resultList = queryRunner.query(sql,
					new ArrayListHandler());
			for (int i = 0; i < resultList.size(); i++) {
				Object[] objects = resultList.get(i);
				PlayerPO dataPO = getPlayerDataPO(list, objects);
				arrayList.add(dataPO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public ArrayList<PlayerPO> findTop50(ArrayList<String> list,
			String mainProperty, ArrayList<String> position,
			ArrayList<String> division) {
		String where1 = "playerposition.position='" + position.get(0) + "'";
		for (int i = 1; i < position.size(); i++) {
			where1 += " or playerposition.position='" + position.get(i) + "'";
		}
		String where2 = "team.subarea='" + division.get(0) + "'";
		for (int i = 1; i < division.size(); i++) {
			where2 += " or team.subarea='" + division.get(i) + "'";
		}
		String from = "playerposition,team";
		String where = "p.tid=team.tid and p.pid=playerposition.pid and ("
				+ where1 + ") and (" + where2 + ")";
		return getTOP50(list, mainProperty, from, where);
	}

	@Override
	public ArrayList<PlayerPO> findTop50_pos(ArrayList<String> list,
			String mainProperty, ArrayList<String> position) {
		String where = "playerposition.position='" + position.get(0) + "'";
		for (int i = 1; i < position.size(); i++) {
			where += " or playerposition.position='" + position.get(i) + "'";
		}
		where = "p.pid=playerposition.pid and (" + where + ")";
		String from = "playerposition";
		return getTOP50(list, mainProperty, from, where);
	}

	@Override
	public ArrayList<PlayerPO> findTop50_div(ArrayList<String> list,
			String mainProperty, ArrayList<String> division) {
		String where = "team.subarea='" + division.get(0) + "'";
		for (int i = 1; i < division.size(); i++) {
			where += " or team.subarea='" + division.get(i) + "'";
		}
		where = "p.tid=team.tid and (" + where + ")";
		String from = "team";
		return getTOP50(list, mainProperty, from, where);
	}

	@Override
	public ArrayList<PlayerPO> findTop50(ArrayList<String> list,
			String mainProperty) {
		String sql = getSql(list);
		sql += " group by p.pid order by " + mainProperty + " desc limit 0,50";
		ArrayList<PlayerPO> arrayList = new ArrayList<PlayerPO>();
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			List<Object[]> resultList = queryRunner.query(sql,
					new ArrayListHandler());
			for (int i = 0; i < resultList.size(); i++) {
				Object[] objects = resultList.get(i);
				PlayerPO dataPO = getPlayerDataPO(list, objects);
				arrayList.add(dataPO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public PlayerPO findPlayerInfo(int playerId) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("photo");
		arrayList.add("conference");
		arrayList.add("division");
		arrayList.add("posititon");
		arrayList.add("playerName");
		arrayList.add("Team");

		String sql = getSql(arrayList, "p.pid=?");
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			Object[] objects = queryRunner.query(sql, new ArrayHandler(),
					playerId);
			PlayerPO dataPO = getPlayerDataPO(arrayList, objects);
			return dataPO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new PlayerPO();
	}
	

	private PlayerPO getPlayerDataPO(ArrayList<String> list, Object[] objects) {
		PlayerPO dataPO = new PlayerPO();
		dataPO.id = Integer.parseInt(String.valueOf(objects[0]));
		System.out.println(dataPO.id);
		for (int j = 0; j < list.size(); j++) {
			setValue(dataPO, list.get(j), objects[j + 1]);
		}
		return dataPO;
	}


	private void setValue(PlayerPO dataPO, String string, Object object) {
		System.out.println(string + ":" + object);
		switch (string) {
		case "timeOnCourt":
			dataPO.timeOnCourt = getTime(Integer.parseInt(String
					.valueOf(object)));
			return;
		case "startSession":
			System.out.println("test");
			dataPO.startSession = object == null ? 0 : Integer.parseInt(String
					.valueOf(object));
			System.out.println("testend");
			return;
		case "matchNum":
			dataPO.matchNum = object == null ? -11 : Integer.parseInt(String
					.valueOf(object));
			return;
		case "FGP":
			dataPO.FGP = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "TPSP":
			dataPO.TPSP = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "FTP":
			dataPO.FTP = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "BS":
			dataPO.BS = object == null ? -11 : Integer.parseInt(String
					.valueOf(object));
			return;
		case "BSP":
			dataPO.BSP = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "assist":
			dataPO.assist = object == null ? -11 : Integer.parseInt(String
					.valueOf(object));
			return;
		case "assistP":
			dataPO.assistP = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "rebound":
			dataPO.rebound = object == null ? -11 : Integer.parseInt(String
					.valueOf(object));
			return;
		case "reboundP":
			dataPO.reboundP = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "steal":
			dataPO.steal = object == null ? -11 : Integer.parseInt(String
					.valueOf(object));
			return;
		case "stealP":
			dataPO.stealP = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "turnover":
			dataPO.turnover = object == null ? -11 : Integer.parseInt(String
					.valueOf(object));
			return;
		case "turnoverP":
			dataPO.turnoverP = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "foul":
			dataPO.foul = object == null ? -11 : Integer.parseInt(String
					.valueOf(object));
			return;
		case "score":
			dataPO.score = object == null ? -11 : Integer.parseInt(String
					.valueOf(object));
			return;
		case "offensive":
			dataPO.offensive = object == null ? -11 : Integer.parseInt(String
					.valueOf(object));
			return;
		case "defense":
			dataPO.defense = object == null ? -11 : Integer.parseInt(String
					.valueOf(object));
			return;
		case "effiency":
			dataPO.effiency = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "GmSc":
			dataPO.GmSc = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "TSP":
			dataPO.TSP = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "OSE":
			dataPO.OSE = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "OREB":
			dataPO.OREB = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "DREB":
			dataPO.DREB = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "utiliation":
			dataPO.utiliation = object == null ? -11 : Double
					.parseDouble(String.valueOf(object));
			return;
		case "AvgBS":
			dataPO.AvgBS = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "Avgassist":
			dataPO.Avgassist = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "Avgrebound":
			dataPO.Avgrebound = object == null ? -11 : Double
					.parseDouble(String.valueOf(object));
			return;
		case "Avgsteal":
			dataPO.Avgsteal = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "Avgturnover":
			dataPO.Avgturnover = object == null ? -11 : Double
					.parseDouble(String.valueOf(object));
			return;
		case "Avgfoul":
			dataPO.Avgfoul = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "Avgscore":
			dataPO.Avgscore = object == null ? -11 : Double.parseDouble(String
					.valueOf(object));
			return;
		case "Avgoffensive":
			dataPO.Avgoffensive = object == null ? -11 : Double
					.parseDouble(String.valueOf(object));
			return;
		case "photo":
			dataPO.photo = object == null ? null : String.valueOf(object);
			return;
		case "conference":
			dataPO.conference = object == null ? null : String.valueOf(object);
			return;
		case "division":
			dataPO.division = object == null ? null : String.valueOf(object);
			return;
		case "posititon":
			dataPO.posititon = object == null ? "" : String.valueOf(object);
			return;
		case "playerName":
			dataPO.playerName = object == null ? null : String.valueOf(object);
			return;
		case "Team":
			dataPO.Team = object == null ? null : String.valueOf(object);
			return;
		default:
			break;
		}
	}

	private String getTime(int timeS) {
		DecimalFormat df = new DecimalFormat("00");
		int hour = timeS / 3600;
		int minute = (timeS - 3600 * hour) / 60;
		int second = (timeS - 3600 * hour - 60 * minute) / 60;
		return df.format(hour) + ":" + df.format(minute) + ":"
				+ df.format(second);
	}

	private String getSql(ArrayList<String> list) {
		// TODO Auto-generated method stub
		return getSql(list, null, null);
	}

	private String getSql(ArrayList<String> list, String wheres) {
		return getSql(list, wheres, null);
	}

	private String getSql(ArrayList<String> list, String wheres, String froms) {
		PlayerMaterialSql materialSql = new PlayerMaterialSql();
		String query = queryHandel(list, materialSql).trim();
		ArrayList<String> whereList = materialSql.getWheres();
		if (wheres != null) {
			whereList.add(wheres);
		}
		String where = "";
		if (whereList.size() > 0) {
			where = "where " + where;
			where += whereList.get(0);
			for (int i = 1; i < whereList.size(); i++) {
				where += " and " + whereList.get(i);
			}
		}
		String from = materialSql.getMaterial().trim();
		if (froms != null) {
			from = from + "," + froms;
		}

		String sql = "select " + query + " from " + from + " " + where;
		return sql;
	}

	private String queryHandel(ArrayList<String> list,
			PlayerMaterialSql materialSql) {
		if (list.size() == 0 || list == null) {
			return "*";
		}
		String query = "";
		for (String string : list) {
			query += getQuery(string, materialSql);
		}
		query = "p.pid," + query;
		query = query.substring(0, query.length() - 1);
		return query;
	}

	private String[] querys = Query.playerQuerys;

	private String getQuery(String string, PlayerMaterialSql materialSql) {
		switch (string) {
		case "timeOnCourt":
			return querys[0];
		case "startSession":
			new StartSessionHandel().addMaterial(materialSql);
			return querys[1];
		case "matchNum":
			return querys[2];
		case "FGP":
			return querys[3];
		case "TPSP":
			return querys[4];
		case "FTP":
			return querys[5];
		case "BS":
			return querys[6];
		case "BSP":
			new BlockrateHandel().addMaterial(materialSql);
			return querys[7];
		case "assist":
			return querys[8];
		case "assistP":
			new HelprateHandel().addMaterial(materialSql);
			return querys[9];
		case "rebound":
			return querys[10];
		case "reboundP":
			new BasrateHandel().addMaterial(materialSql);
			return querys[11];
		case "steal":
			return querys[12];
		case "stealP":
			new InterprateHandel().addMaterial(materialSql);
			return querys[13];
		case "turnover":
			return querys[14];
		case "turnoverP":
			new MisrateHandel().addMaterial(materialSql);
			return querys[15];
		case "foul":
			return querys[16];
		case "score":
			return querys[17];
		case "offensive":
			return querys[18];
		case "defense":
			return querys[19];
		case "effiency":
			new EfficHandel().addMaterial(materialSql);
			return querys[20];
		case "GmSc":
			new GmScHandel().addMaterial(materialSql);
			return querys[21];
		case "TSP":
			new RealinrateHandel().addMaterial(materialSql);
			return querys[22];
		case "OSE":
			return querys[23];
		case "OREB":
			new BasrateHandel().addMaterial(materialSql);
			return querys[24];
		case "DREB":
			new BasrateHandel().addMaterial(materialSql);
			return querys[25];
		case "utiliation":
			new UsereateHandel().addMaterial(materialSql);
			return querys[26];
		case "AvgBS":
			return querys[27];
		case "Avgassist":
			return querys[28];
		case "Avgrebound":
			return querys[29];
		case "Avgsteal":
			return querys[30];
		case "Avgturnover":
			return querys[31];
		case "Avgfoul":
			return querys[32];
		case "Avgscore":
			return querys[33];
		case "Avgoffensive":
			return querys[34];
		case "Avgdefense":
			return querys[35];
		case "photo":
			new PhotoHandel().addMaterial(materialSql);
			return querys[36];
		case "conference":
			new ConferenceHandel().addMaterial(materialSql);
			return querys[37];
		case "division":
			new DivisionHandel().addMaterial(materialSql);
			return querys[38];
		case "posititon":
			new PosititonHandel().addMaterial(materialSql);
			return querys[39];
		case "playerName":
			new PlayerNameHandel().addMaterial(materialSql);
			return querys[40];
		case "Team":
			new TeamHandel().addMaterial(materialSql);
			return querys[41];
		default:
			break;
		}
		return "";
	}

	private ArrayList<PlayerPO> getTOP50(ArrayList<String> list,
			String mainProperty, String from, String where) {
		if (mainProperty.equals("s_r_a")) {
			mainProperty = "(p.score+p.allbas+p.helpatt)";
		} else if (mainProperty.equals("DD")) {
			from = from
					+ ","
					+ "(select vv.pid,ddd.DD from (select distinct pid from playerscore) as vv left join (select pid,count(mid) as DD from playerscore where (score>10 and allbas>10)or(score>10 and helpatt>10)or(score>10 and interp>10)or(score>10 and block>10)or(allbas>10 and helpatt>10)or(allbas>10 and interp>10)or(allbas>10 and block>10)or(helpatt>10 and interp>10)or(helpatt>10 and block>10)or(interp>10 and block>10) group by pid) as ddd on vv.pid=ddd.pid) as d";
			where = where + " and p.pid=d.pid";
			mainProperty = "d.DD";
		}
		String sql = getSql(list, where, from);

		sql += " group by p.pid order by " + mainProperty + " desc limit 0,50";
		ArrayList<PlayerPO> arrayList = new ArrayList<PlayerPO>();
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			List<Object[]> resultList = queryRunner.query(sql,
					new ArrayListHandler());
			list.remove("s_r_a");
			list.remove("DD");
			for (int i = 0; i < resultList.size(); i++) {
				Object[] objects = resultList.get(i);
				PlayerPO dataPO = getPlayerDataPO(list, objects);
				arrayList.add(dataPO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}

}

package data.team;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import po.teampo.TeamDataPO;
import po.teampo.TeamInfoPO;
import data.JDBCUtils;
import data.Query;
import data.TeamMaterialSql;
import dataservice.teamdataservice.TeamDataService;

public class TeamData implements TeamDataService {

	@Override
	public TeamInfoPO findTeamInfo(int TeamId) {
		String sql = "select * from team where tid=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			Object[] objects = queryRunner.query(sql, new ArrayHandler(),
					TeamId);
			TeamInfoPO infoPO = getTeamInfoPO(objects);
			return infoPO;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public TeamDataPO findTeamData(int TeamId) {
		ArrayList<String> list = new ArrayList<String>();

		list.add("matchNum");
		list.add("FG");
		list.add("FGA");
		list.add("FGP");
		list.add("TPS");
		list.add("TPSA");
		list.add("TPSP");
		list.add("FTM");
		list.add("FTA");
		list.add("FTP");
		list.add("BS");
		list.add("assist");
		list.add("assistP");
		list.add("rebound");
		list.add("OREBP");
		list.add("DREBP");
		list.add("ORebound");
		list.add("DRebound");
		list.add("steal");
		list.add("stealP");
		list.add("turnover");
		list.add("foul");
		list.add("score");
		list.add("WinP");
		list.add("leg");
		list.add("ORtg");
		list.add("DRtg");
		String sql = getSql(list, "a.tid=?");
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			Object[] objects = queryRunner.query(sql, new ArrayHandler(),
					TeamId);
			TeamDataPO dataPO = getTeamDataPO(list, objects);
			return dataPO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<TeamInfoPO> findTeamInfoList() {
		String sql = "select * from team";
		ArrayList<TeamInfoPO> arrayList = new ArrayList<TeamInfoPO>();
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			List<Object[]> resultList = queryRunner.query(sql,
					new ArrayListHandler());
			for (int i = 0; i < resultList.size(); i++) {
				Object[] objects = resultList.get(i);
				TeamInfoPO infoPO = getTeamInfoPO(objects);
				arrayList.add(infoPO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayList;
	}

	@Override
	public ArrayList<TeamDataPO> findTeamDataList(ArrayList<String> list) {
		String sql = getSql(list);
		sql += " group by a.tid order by a.tid";
		ArrayList<TeamDataPO> arrayList = new ArrayList<TeamDataPO>();
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			List<Object[]> resultList = queryRunner.query(sql,
					new ArrayListHandler());
			for (int i = 0; i < resultList.size(); i++) {
				Object[] objects = resultList.get(i);
				TeamDataPO dataPO = getTeamDataPO(list, objects);
				arrayList.add(dataPO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayList;
	}

	@Override
	public ArrayList<TeamDataPO> sortTeamList(ArrayList<String> list,
			String mainProperty, boolean order) {
		String sql = getSql(list);
		sql += " group by a.tid order by " + mainProperty;
		if (order == true) {
			sql += " desc";
		}
		ArrayList<TeamDataPO> arrayList = new ArrayList<TeamDataPO>();
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			List<Object[]> resultList = queryRunner.query(sql,
					new ArrayListHandler());
			for (int i = 0; i < resultList.size(); i++) {
				Object[] objects = resultList.get(i);
				TeamDataPO dataPO = getTeamDataPO(list, objects);
				arrayList.add(dataPO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayList;
	}

	private String queryHandel(ArrayList<String> list,
			TeamMaterialSql materialSql) {
		if (list.size() == 0 || list == null) {
			return "*";
		}
		String query = "";
		for (String string : list) {
			query += getQuery(string, materialSql);
		}
		query = "a.tid," + query;
		query = query.substring(0, query.length() - 1);
		return query;
	}

	private static String[] querys = Query.teamQuerys;

	private String getQuery(String string, TeamMaterialSql materialSql) {
		switch (string) {
		case "matchNum":
			new GamesplayedHandel().addMaterial(materialSql);
			return querys[0];
		case "FG":
			new ThrowinnumHandel().addMaterial(materialSql);
			return querys[1];
		case "FGA":
			new ThrowallnumHandel().addMaterial(materialSql);
			return querys[2];
		case "FGP":
			new ThrowinrateHandel().addMaterial(materialSql);
			return querys[3];
		case "TPS":
			new Throw3innumHandel().addMaterial(materialSql);
			return querys[4];
		case "TPSA":
			new Throw3allnumHandel().addMaterial(materialSql);
			return querys[5];
		case "TPSP":
			new Throw3inrateHandel().addMaterial(materialSql);
			return querys[6];
		case "FTM":
			new PenaltyinnumHandel().addMaterial(materialSql);
			return querys[7];
		case "FTA":
			new PenaltyallnumHandel().addMaterial(materialSql);
			return querys[8];
		case "FTP":
			new PenaltyinrateHandel().addMaterial(materialSql);
			return querys[9];
		case "BS":
			new BlocknumHandel().addMaterial(materialSql);
			return querys[10];
		case "assist":
			new HelpattnumHandel().addMaterial(materialSql);
			return querys[11];
		case "assistP":
			new HelpeffiHandel().addMaterial(materialSql);
			return querys[12];
		case "rebound":
			new AllbasnumHandel().addMaterial(materialSql);
			return querys[13];
		case "reboundP":
			return querys[14];
		case "ORebound":
			new AttbaseffiHandel().addMaterial(materialSql);
			return querys[15];
		case "DRebound":
			new DefbaseffiHandel().addMaterial(materialSql);
			return querys[16];
		case "steal":
			new InterpnumHandel().addMaterial(materialSql);
			return querys[17];
		case "stealP":
			new InterpeffiHandel().addMaterial(materialSql);
			return querys[18];
		case "turnover":
			new MistakenumHandel().addMaterial(materialSql);
			return querys[19];
		case "foul":
			new FoulnumHandel().addMaterial(materialSql);
			return querys[20];
		case "score":
			new ScorenumHandel().addMaterial(materialSql);
			return querys[21];
		case "WinP":
			new WinPHandel().addMaterial(materialSql);
			return "t.WinP,";
		case "leg":
			new AttaroundHandel().addMaterial(materialSql);
			return querys[23];
		case "ORtg":
			new AtteffiHandel().addMaterial(materialSql);
			return querys[24];
		case "DRtg":
			new DefeffiHandel().addMaterial(materialSql);
			return querys[25];
		case "OREBP":
			new AttbaseffiHandel().addMaterial(materialSql);
			return querys[26];
		case "DREBP":
			new DefeffiHandel().addMaterial(materialSql);
			return querys[27];
		case "AvgFG":
			new ThrowinnumHandel().addMaterial(materialSql);
			return querys[28];
		case "AvgFGA":
			new ThrowallnumHandel().addMaterial(materialSql);
			return querys[29];
		case "AvgTPS":
			new Throw3innumHandel().addMaterial(materialSql);
			return querys[30];
		case "AvgTPSA":
			new Throw3allnumHandel().addMaterial(materialSql);
			return querys[31];
		case "AvgFTM":
			new PenaltyinnumHandel().addMaterial(materialSql);
			return querys[32];
		case "AvgFTA":
			new PenaltyallnumHandel().addMaterial(materialSql);
			return querys[33];
		case "AvgBS":
			new BlocknumHandel().addMaterial(materialSql);
			return querys[34];
		case "Avgassist":
			new HelpattnumHandel().addMaterial(materialSql);
			return querys[35];
		case "Avgrebound":
			new AllbasnumHandel().addMaterial(materialSql);
			return querys[36];
		case "AvgORebound":
			new AttbaseffiHandel().addMaterial(materialSql);
			return querys[37];
		case "AvgDRebound":
			new DefbaseffiHandel().addMaterial(materialSql);
			return querys[38];
		case "Avgsteal":
			new InterpnumHandel().addMaterial(materialSql);
			return querys[39];
		case "Avgturnover":
			new MistakenumHandel().addMaterial(materialSql);
			return querys[40];
		case "Avgfoul":
			new FoulnumHandel().addMaterial(materialSql);
			return querys[41];
		case "Avgscore":
			new ScorenumHandel().addMaterial(materialSql);
			return querys[42];
		case "Avgleg":
			new AttaroundHandel().addMaterial(materialSql);
			return querys[43];
		default:
			break;
		}
		return "";
	}

	private String getSql(ArrayList<String> list) {
		return getSql(list, null);
	}

	private String getSql(ArrayList<String> list, String wheres) {
		TeamMaterialSql materialSql = new TeamMaterialSql();
		String query = queryHandel(list, materialSql).trim();
		ArrayList<String> arrayList = materialSql.getWheres();
		if (wheres != null) {
			arrayList.add(wheres);
		}
		String where = "";
		if (arrayList.size() > 0) {
			where = "where " + where;
			where += arrayList.get(0);
			for (int i = 1; i < arrayList.size(); i++) {
				where += " and " + arrayList.get(i);
			}
		}
		String from = materialSql.getMaterial().trim();

		String sql = "select " + query + " from " + from + " " + where;
		return sql;
	}

	private TeamDataPO getTeamDataPO(ArrayList<String> list, Object[] objects) {
		TeamDataPO dataPO = new TeamDataPO();
		dataPO.id = Integer.parseInt(String.valueOf(objects[0]));
		for (int j = 0; j < list.size(); j++) {
			setValue(dataPO, list.get(j), objects[j + 1]);
		}
		return dataPO;
	}

	private void setValue(TeamDataPO dataPO, String key, Object value) {
		switch (key) {

		case "matchNum":
			dataPO.matchNum = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "FG":
			dataPO.FG = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "FGA":
			dataPO.FGA = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "FGP":
			dataPO.FGP = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "TPS":
			dataPO.TPS = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "TPSA":
			dataPO.TPSA = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "TPSP":
			dataPO.TPSP = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "FTM":
			dataPO.FTM = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "FTA":
			dataPO.FTA = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "FTP":
			dataPO.FTP = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "BS":
			dataPO.BS = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "assist":
			dataPO.assist = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "assistP":
			dataPO.assistP = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "rebound":
			dataPO.rebound = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "ORebound":
			dataPO.ORebound = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "DRebound":
			dataPO.DRebound = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "steal":
			dataPO.steal = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "stealP":
			dataPO.stealP = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "turnover":
			dataPO.turnover = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "foul":
			dataPO.foul = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "score":
			dataPO.score = value == null ? -11 : Integer.parseInt(String
					.valueOf(value));
			return;
		case "leg":
			dataPO.leg = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "ORtg":
			dataPO.ORtg = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "DRtg":
			dataPO.DRtg = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "WinP":
			dataPO.WinP = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "OREBP":
			dataPO.OREBP = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "DREBP":
			dataPO.DREBP = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "AvgFG":
			dataPO.AvgFG = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "AvgFGA":
			dataPO.AvgFGA = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "AvgTPS":
			dataPO.AvgTPS = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "AvgTPSA":
			dataPO.AvgTPSA = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "AvgFTM":
			dataPO.AvgFTM = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "AvgFTA":
			dataPO.AvgFTA = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "AvgBS":
			dataPO.AvgBS = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "Avgassist":
			dataPO.Avgassist = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "Avgrebound":
			dataPO.Avgrebound = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "AvgORebound":
			dataPO.AvgORebound = value == null ? -11 : Double
					.parseDouble(String.valueOf(value));
			return;
		case "AvgDRebound":
			dataPO.AvgDRebound = value == null ? -11 : Double
					.parseDouble(String.valueOf(value));
			return;
		case "Avgsteal":
			dataPO.Avgsteal = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "Avgturnover":
			dataPO.Avgturnover = value == null ? -11 : Double
					.parseDouble(String.valueOf(value));
			return;
		case "Avgfoul":
			dataPO.Avgfoul = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "Avgscore":
			dataPO.Avgscore = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		case "Avgleg":
			dataPO.Avgleg = value == null ? -11 : Double.parseDouble(String
					.valueOf(value));
			return;
		default:
			break;
		}
	}

	private TeamInfoPO getTeamInfoPO(Object[] objects) {
		TeamInfoPO po = new TeamInfoPO(Integer.parseInt(String
				.valueOf(objects[0])), String.valueOf(objects[2]),
				String.valueOf(objects[1]), String.valueOf(objects[2]),
				String.valueOf(objects[3]), String.valueOf(objects[4]),
				String.valueOf(objects[5]), String.valueOf(objects[6]),
				Integer.parseInt(String.valueOf(objects[7])));
		return po;
	}
}

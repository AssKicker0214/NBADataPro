package data;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import po.Material;

public class Table {
	public static String getTable(Set<Material> set, String t) {
		Set<String> setS = new HashSet<String>();
		setS.add("tid");
		setS.add("mid");
		Iterator<Material> it = set.iterator();
		while (it.hasNext()) {
			Material material = it.next();
			setS.add(getQuery(material,t));
			
		}
		String table = "";
		table += "select ";
		Iterator<String> its = setS.iterator();
		table += its.next();
		while (its.hasNext()) {
			String str = its.next();
			table +=(","+str);
		}

		table += " from playerscore group by mid,tid";
		table = "(" + table + ") as " + t.toLowerCase() + ",";

		return table;
	}
	
	public static String getTableW(){
		return ("(select m.tid,n.cwintid/m.ctid as WinP "
				+ "from (select team.tid ,count(team.tid) as ctid "
				+ "from matchinfo,team  where  ( teamf = team.tid or teaml = team.tid) "
				+ "group by team.tid order by team.tid ) as m ,("
				+ "select team.tid ,count(team.tid) as cwintid "
				+ "from matchinfo,team  where  ( teamf = team.tid and "
				+ "allscoref > allscorel )or (teaml = team.tid and "
				+ "allscorel > allscoref ) group by tid ) as n where m.tid = n.tid) as t,");
	}
	
	private static String getQuery(Material material,String t) {
		return Query.getQuery(material, t);
	}
	
	public static String getTablePI(Set<Material> set) {
		Set<String> setS = new HashSet<String>();
		setS.add("player.pid");
		Iterator<Material> it = set.iterator();
		while (it.hasNext()) {
			Material material = it.next();
			setS.add(getQuery(material));

		}
		String table = "";
		table += "select ";
		Iterator<String> its = setS.iterator();
		table += its.next();
		while (its.hasNext()) {
			String str = its.next();
			if (str.length() > 0) {
				table += ("," + str);
			}
		}

		table += " from player,team,(select playerscore.pid,playerscore.tid,"
				+ "playerscore.mid,max(matchinfo.matchtime) from playerscore,matchinfo "
				+ "where matchinfo.mid=playerscore.mid group by playerscore.pid) "
				+ "as z where player.pid=z.pid and team.tid=z.tid group by player.pid";
		table = "(" + table + ") as pi,";
		return table;
	}
	
	private static String getQuery(Material material) {
		return Query.getQuery(material);
	}
	
	public static String getTableST(){
		return "(select v.pid,u.startSession from (select distinct pid "
				+ "from playerscore) as v left join (select pid,count(mid) "
				+ "as startSession from playerscore where playerscore.serialid<6 "
				+ "group by playerscore.pid) as u on v.pid=u.pid ) as mn,";
	}
}

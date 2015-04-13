package data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import po.Material;

public class TeamMaterialSql {
	private Set<Material> setA;
	private Set<Material> setB;
	private boolean setW;

	public TeamMaterialSql() {
		setA = new HashSet<Material>();
		setB = new HashSet<Material>();
		setW = false;
	}

	public void addMaterialA(Material a) {
		setA.add(a);
	}

	public void addMaterialB(Material b) {
		setB.add(b);
	}

	public void addMaterialW() {
		setW = true;
	}

	public String getMaterial() {
		String from = "";
		from += getTable(setA, "A");
		if (setB.size()>0) {
			from += getTable(setB, "B");
		}
		if (setW) {
			from += Table.getTableW();
		}
		from = from.substring(0, from.length() - 1);
		return from;
	}

	private String getTable(Set<Material> set, String t) {
		return Table.getTable(set, t);
	}

	public ArrayList<String> getWheres() {
		ArrayList<String> list = new ArrayList<String>();
		if (setB.size() > 0) {
			list.add("a.mid=b.mid and a.tid!=b.tid");
		}
		if (setW) {
			list.add("a.tid=t.tid");
		}
		return list;
	}

	
}

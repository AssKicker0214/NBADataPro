package data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import po.Material;

public class PlayerMaterialSql {
	private Set<Material> setA;
	private Set<Material> setB;
	private Set<Material> setPI;
	private boolean setST;

	public PlayerMaterialSql() {
		setA = new HashSet<Material>();
		setB = new HashSet<Material>();
		setPI = new HashSet<Material>();
		setST = false;
	}

	public void addMaterialA(Material a) {
		setA.add(a);
	}

	public void addMaterialB(Material b) {
		setB.add(b);
	}

	public void addMaterialPI(Material pi) {
		setPI.add(pi);
	}

	public void addMaterialW() {
		setST = true;
	}

	

	public String getMaterial() {
		String table = "";
		table += " playerscore p,";

		if (setA.size() > 0) {
			table += getTable(setA, "A");
		}

		if (setB.size() > 0) {
			table += getTable(setB, "B");
		}
		if (setPI.size() > 0) {
			table += getTablePI(setPI);
		}
		if (setST) {
			table += Table.getTableST();
		}

		return table.substring(0, table.length() - 1);
	}

	private String getTablePI(Set<Material> set) {
		return Table.getTablePI(set);
	}

	

	private String getTable(Set<Material> set, String t) {
		return Table.getTable(set, t);
	}

	public ArrayList<String> getWheres() {
		ArrayList<String> list = new ArrayList<String>();
		if (setA.size() > 0) {
			list.add("p.tid=a.tid and p.mid=a.mid");
		}
		if (setB.size() > 0) {
			list.add("p.mid=b.mid and p.tid!=b.tid");
		}
		if (setPI.size() > 0) {
			list.add("p.pid=pi.pid");
		}
		
		if (setST) {
			list.add("p.pid=mn.pid");
		}
		return list;
	}

}

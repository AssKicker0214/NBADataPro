package data.team;

import po.Material;
import data.TeamMaterialHandel;
import data.TeamMaterialSql;

public class InterpeffiHandel implements TeamMaterialHandel {

	public void addMaterial(TeamMaterialSql materialSql) {
		// TODO Auto-generated method stub
		materialSql.addMaterialA(Material.interp);
		materialSql.addMaterialB(Material.penaltyall);
		materialSql.addMaterialB(Material.attackbas);
		materialSql.addMaterialB(Material.mistake);
		materialSql.addMaterialB(Material.throwin);
		materialSql.addMaterialB(Material.throwall);
		materialSql.addMaterialA(Material.defencebas);
	}

}

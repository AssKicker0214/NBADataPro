package data.team;

import vo.Material;
import data.TeamMaterialHandel;
import data.TeamMaterialSql;

public class DefeffiHandel implements TeamMaterialHandel {

	public void addMaterial(TeamMaterialSql materialSql) {
		// TODO Auto-generated method stub
		materialSql.addMaterialB(Material.throwall);
		materialSql.addMaterialB(Material.penaltyall);
		materialSql.addMaterialB(Material.attackbas);
		materialSql.addMaterialB(Material.mistake);
		materialSql.addMaterialB(Material.throwin);
		materialSql.addMaterialB(Material.score);
		materialSql.addMaterialA(Material.defencebas);
	}

}

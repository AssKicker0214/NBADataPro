package data.team;

import vo.Material;
import data.TeamMaterialHandel;
import data.TeamMaterialSql;

public class PenaltyinnumHandel implements TeamMaterialHandel {

	public void addMaterial(TeamMaterialSql materialSql) {
		// TODO Auto-generated method stub
		materialSql.addMaterialA(Material.penaltyin);
	}

}

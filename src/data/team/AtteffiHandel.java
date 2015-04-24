package data.team;

import vo.Material;
import data.TeamMaterialHandel;
import data.TeamMaterialSql;

public class AtteffiHandel implements TeamMaterialHandel {

	public void addMaterial(TeamMaterialSql materialSql) {
		// TODO Auto-generated method stub
		new AttaroundHandel().addMaterial(materialSql);
		materialSql.addMaterialA(Material.score);
	}

}

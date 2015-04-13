package data.team;

import po.Material;
import data.TeamMaterialHandel;
import data.TeamMaterialSql;

public class BlocknumHandel implements TeamMaterialHandel {

	public void addMaterial(TeamMaterialSql materialSql) {
		// TODO Auto-generated method stub
		materialSql.addMaterialA(Material.block);
	}

}

package data.team;

import data.TeamMaterialHandel;
import data.TeamMaterialSql;

public class WinPHandel implements TeamMaterialHandel{

	@Override
	public void addMaterial(TeamMaterialSql materialSql) {
		// TODO Auto-generated method stub
		materialSql.addMaterialW();
	}

}

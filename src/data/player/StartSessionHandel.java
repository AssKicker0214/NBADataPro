package data.player;

import data.PlayerMaterialHandel;
import data.PlayerMaterialSql;

public class StartSessionHandel implements PlayerMaterialHandel {

	@Override
	public void addMaterial(PlayerMaterialSql materialSql) {
		// TODO Auto-generated method stub
		materialSql.addMaterialW();
	}

}

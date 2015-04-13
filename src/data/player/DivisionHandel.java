package data.player;

import po.Material;
import data.PlayerMaterialHandel;
import data.PlayerMaterialSql;

public class DivisionHandel implements PlayerMaterialHandel {

	public void addMaterial(PlayerMaterialSql materialSql) {
		// TODO Auto-generated method stub
		materialSql.addMaterialPI(Material.division);
	}

}

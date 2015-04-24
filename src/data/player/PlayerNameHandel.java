package data.player;

import vo.Material;
import data.PlayerMaterialHandel;
import data.PlayerMaterialSql;

public class PlayerNameHandel implements PlayerMaterialHandel {

	public void addMaterial(PlayerMaterialSql materialSql) {
		// TODO Auto-generated method stub
		materialSql.addMaterialPI(Material.playerName);
	}

}

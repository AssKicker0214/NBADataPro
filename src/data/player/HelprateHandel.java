package data.player;

import po.Material;
import data.PlayerMaterialHandel;
import data.PlayerMaterialSql;

//助攻率:球员助攻数÷(球员上场时间÷(球队所有球员上场时间÷5)×球队总进球数-球员进球数)
public class HelprateHandel implements PlayerMaterialHandel {

	public void addMaterial(PlayerMaterialSql materialSql) {
		// TODO Auto-generated method stub
		materialSql.addMaterialA(Material.inplacetime);
		materialSql.addMaterialA(Material.throwin);
		
	}

}

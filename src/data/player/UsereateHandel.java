package data.player;

import vo.Material;
import data.PlayerMaterialHandel;
import data.PlayerMaterialSql;

//使用率:(球员出手次数+0.44×球员罚球次数+球员失误次数)×(球队所有球员上场时间÷5)÷球员上场时间÷
//(球队所有总球员出手次数+0.44×球队所有球员罚球 次数+球队所有球员失误次数)
public class UsereateHandel implements PlayerMaterialHandel {

	public void addMaterial(PlayerMaterialSql materialSql) {
		// TODO Auto-generated method stub
		materialSql.addMaterialA(Material.throwall);
		materialSql.addMaterialA(Material.penaltyall);
		materialSql.addMaterialA(Material.mistake);
		materialSql.addMaterialA(Material.inplacetime);
	}

}

package data.player;

import vo.Material;
import data.PlayerMaterialHandel;
import data.PlayerMaterialSql;
//盖帽率:球员盖帽数×(球队所有球员上场时间÷5)÷球员上场时间÷对手两分球出手次数
public class BlockrateHandel implements PlayerMaterialHandel{

	public void addMaterial(PlayerMaterialSql materialSql) {
		// TODO Auto-generated method stub
		materialSql.addMaterialA(Material.inplacetime);
		materialSql.addMaterialB(Material.throw3all);
		materialSql.addMaterialB(Material.throwall);
		materialSql.addMaterialB(Material.throwin);
	}

}

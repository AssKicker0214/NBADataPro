package data.player;

import vo.Material;
import data.PlayerMaterialHandel;
import data.PlayerMaterialSql;
//抢断率:球员抢断数×(球队所有球员上场时间÷5)÷球员上场时间÷对手进攻次数)
//本队回合=投篮数+0.4*球队罚球数-1.07*(本队进攻篮板/(本队进攻篮
//板+对手防守篮板)*投失球数)+1.07*失误数
public class InterprateHandel implements PlayerMaterialHandel{

	public void addMaterial(PlayerMaterialSql materialSql) {
		// TODO Auto-generated method stub
		materialSql.addMaterialA(Material.inplacetime);
		materialSql.addMaterialB(Material.throwin);
		materialSql.addMaterialB(Material.penaltyall);
		materialSql.addMaterialB(Material.throwall);
		materialSql.addMaterialB(Material.attackbas);
		materialSql.addMaterialB(Material.mistake);
		materialSql.addMaterialA(Material.defencebas);
		
	}

}

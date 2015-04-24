package data.team;

import vo.Material;
import data.TeamMaterialHandel;
import data.TeamMaterialSql;
//本队回合=投篮数+0.4*球队罚球数-1.07*(本队进攻篮板/(本队进攻篮
//板+对手防守篮板)*投失球数)+1.07*失误数
public class AttaroundHandel implements TeamMaterialHandel {

	public void addMaterial(TeamMaterialSql materialSql) {
		// TODO Auto-generated method stub
		materialSql.addMaterialA(Material.throwall);
		materialSql.addMaterialA(Material.penaltyall);
		materialSql.addMaterialA(Material.attackbas);
		materialSql.addMaterialA(Material.mistake);
		materialSql.addMaterialA(Material.throwin);
		materialSql.addMaterialB(Material.defencebas);
	}

}

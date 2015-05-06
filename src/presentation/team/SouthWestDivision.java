package presentation.team;

public class SouthWestDivision extends SingleDivisionLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void setTeams() {
		this.add(new SingleTeamLabel("teamsPNG/DAL.png","达拉斯","小牛",g));
		this.add(new SingleTeamLabel("teamsPNG/HOU.png","休斯顿","火箭",w));
		this.add(new SingleTeamLabel("teamsPNG/MEM.png","孟菲斯","灰熊",g));
		this.add(new SingleTeamLabel("teamsPNG/NOP.png","新奥尔兰","鹈鹕",w));
		this.add(new SingleTeamLabel("teamsPNG/SAS.png","圣安东尼奥","马刺",g));
		
	}

}

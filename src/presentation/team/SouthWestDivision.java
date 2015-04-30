package presentation.team;

public class SouthWestDivision extends SingleDivisionLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void setTeams() {
		this.add(new SingleTeamLabel("teamsPNG/DAL.png","达拉斯 小牛"));
		this.add(new SingleTeamLabel("teamsPNG/HOU.png","休斯顿 火箭"));
		this.add(new SingleTeamLabel("teamsPNG/MEM.png","孟菲斯 灰熊"));
		this.add(new SingleTeamLabel("teamsPNG/ONP.png","新奥尔兰 鹈鹕"));
		this.add(new SingleTeamLabel("teamsPNG/SAS.png","圣安东尼奥 马刺"));
		
	}

}

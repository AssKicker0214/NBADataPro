package presentation.team;

public class SouthEastDivision extends SingleDivisionLabel{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void setTeams() {
		SingleTeamLabel ATL = new SingleTeamLabel("teamsPNG/ATL.png","亚特兰大","老鹰",g);
		SingleTeamLabel CHA = new SingleTeamLabel("teamsPNG/CHA.png","夏洛特","黄蜂",w);
		SingleTeamLabel MIA = new SingleTeamLabel("teamsPNG/MIA.png","迈阿密","热火",g);
		SingleTeamLabel ORL = new SingleTeamLabel("teamsPNG/ORL.png","奥兰多","魔术",w);
		SingleTeamLabel WAS = new SingleTeamLabel("teamsPNG/WAS.png","华盛顿","奇才",g);

		this.addTeam(ATL);
		this.addTeam(CHA);
		this.addTeam(MIA);
		this.addTeam(ORL);
		this.addTeam(WAS);
	}
	


}

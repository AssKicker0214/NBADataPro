package presentation.team;

public class AtlanticDivision  extends SingleDivisionLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void setTeams() {
		this.add(new SingleTeamLabel("teamsPNG/BOS.png","波士顿","凯尔特人",g));
		this.add(new SingleTeamLabel("teamsPNG/BKN.png","布鲁克林","篮网",w));
		this.add(new SingleTeamLabel("teamsPNG/NYK.png","纽约","尼克斯",g));
		this.add(new SingleTeamLabel("teamsPNG/PHI.png","费城","76人",w));
		this.add(new SingleTeamLabel("teamsPNG/TOR.png","多伦多","猛龙",g));
	}

}

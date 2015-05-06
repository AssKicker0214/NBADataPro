package presentation.team;

public class AtlanticDivision  extends SingleDivisionLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void setTeams() {
		this.add(new SingleTeamLabel("teamsPNG/BOS.png","Boston","Celtics",g));
		this.add(new SingleTeamLabel("teamsPNG/BKN.png","Brooklyn","Nets",w));
		this.add(new SingleTeamLabel("teamsPNG/NYK.png","NewYork","Knicks",g));
		this.add(new SingleTeamLabel("teamsPNG/PHI.png","Philadelphia","76ers",w));
		this.add(new SingleTeamLabel("teamsPNG/TOR.png","Toronto","Raptors ",g));
	}

}

package presentation.team;

public class PacificDivision extends SingleDivisionLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void setTeams() {
		this.add(new SingleTeamLabel("teamsPNG/GSW.png","Golden State","Warriors",g));
		this.add(new SingleTeamLabel("teamsPNG/LAC.png","Los Angeles","Clippers",w));
		this.add(new SingleTeamLabel("teamsPNG/LAL.png","Los Angeles","Lakers",g));
		this.add(new SingleTeamLabel("teamsPNG/PHX.png","Phoenix","Suns",w));
		this.add(new SingleTeamLabel("teamsPNG/SAC.png","Sacramento","Kings",g));		
	}

}

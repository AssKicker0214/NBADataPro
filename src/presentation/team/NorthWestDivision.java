package presentation.team;

public class NorthWestDivision extends SingleDivisionLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void setTeams() {
		this.add(new SingleTeamLabel("teamsPNG/DEN.png","Denver","Nuggets",g));
		this.add(new SingleTeamLabel("teamsPNG/MIN.png","Minnesota","Timberwolves",w));
		this.add(new SingleTeamLabel("teamsPNG/OKC.png","Oklahoma City","Thunder",g));
		this.add(new SingleTeamLabel("teamsPNG/POR.png","Portland","Blazers",w));
		this.add(new SingleTeamLabel("teamsPNG/UTA.png","Utah","Jazz",g));		
	}
	
}

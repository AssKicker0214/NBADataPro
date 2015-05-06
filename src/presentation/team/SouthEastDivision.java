package presentation.team;

public class SouthEastDivision extends SingleDivisionLabel{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void setTeams() {
		SingleTeamLabel ATL = new SingleTeamLabel("teamsPNG/ATL.png","Atlanta","Hawks",g);
		SingleTeamLabel CHA = new SingleTeamLabel("teamsPNG/CHA.png","Charlotte","Hornets",w);
		SingleTeamLabel MIA = new SingleTeamLabel("teamsPNG/MIA.png","Miami","Heat",g);
		SingleTeamLabel ORL = new SingleTeamLabel("teamsPNG/ORL.png","Orlando","Magic",w);
		SingleTeamLabel WAS = new SingleTeamLabel("teamsPNG/WAS.png","Washington","Wizards",g);

		this.addTeam(ATL);
		this.addTeam(CHA);
		this.addTeam(MIA);
		this.addTeam(ORL);
		this.addTeam(WAS);
	}
	


}

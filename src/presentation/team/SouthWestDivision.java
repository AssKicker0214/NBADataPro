package presentation.team;

public class SouthWestDivision extends SingleDivisionLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void setTeams() {
		this.add(new SingleTeamLabel("teamsPNG/DAL.png","Dallas","Mavericks",g));
		this.add(new SingleTeamLabel("teamsPNG/HOU.png","Houston","Rockets",w));
		this.add(new SingleTeamLabel("teamsPNG/MEM.png","Memphis","Grizzlies",g));
		this.add(new SingleTeamLabel("teamsPNG/NOP.png","New Orleans","Pelicans",w));
		this.add(new SingleTeamLabel("teamsPNG/SAS.png","San Antonio","Spurs",g));
		
	}

}

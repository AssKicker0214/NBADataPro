package presentation.team;

public class CenterDivision  extends SingleDivisionLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void setTeams() {
		this.add(new SingleTeamLabel("teamsPNG/CHI.png","Chicago","Bulls",g));
		this.add(new SingleTeamLabel("teamsPNG/CLE.png","Cleveland","Cavaliers",w));
		this.add(new SingleTeamLabel("teamsPNG/DET.png","Detroit","Pistons",g));
		this.add(new SingleTeamLabel("teamsPNG/IND.png","Indiana","Pacers",w));
		this.add(new SingleTeamLabel("teamsPNG/MIL.png","Milwaukee","Bucks",g));
		
	}

}

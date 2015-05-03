package presentation.team;

public class PacificDivision extends SingleDivisionLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void setTeams() {
		this.add(new SingleTeamLabel("teamsPNG/GSW.png","金州","勇士",g));
		this.add(new SingleTeamLabel("teamsPNG/LAC.png","洛杉矶","快船",w));
		this.add(new SingleTeamLabel("teamsPNG/LAL.png","洛杉矶","湖人",g));
		this.add(new SingleTeamLabel("teamsPNG/PHX.png","菲尼克斯","太阳",w));
		this.add(new SingleTeamLabel("teamsPNG/SAC.png","萨克拉门托","国王",g));		
	}

}

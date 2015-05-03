package presentation.team;

public class NorthWestDivision extends SingleDivisionLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void setTeams() {
		this.add(new SingleTeamLabel("teamsPNG/DEN.png","丹佛","掘金",g));
		this.add(new SingleTeamLabel("teamsPNG/MIN.png","明尼苏达","森林狼",w));
		this.add(new SingleTeamLabel("teamsPNG/OKC.png","奥克拉荷马城","雷霆",g));
		this.add(new SingleTeamLabel("teamsPNG/POR.png","波特兰","开拓者",w));
		this.add(new SingleTeamLabel("teamsPNG/UTA.png","犹他","爵士",g));		
	}

}

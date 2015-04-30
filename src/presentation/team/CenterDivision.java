package presentation.team;

public class CenterDivision  extends SingleDivisionLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void setTeams() {
		this.add(new SingleTeamLabel("teamsPNG/CHI.png","芝加哥 公牛"));
		this.add(new SingleTeamLabel("teamsPNG/CLE.png","克利夫兰 骑士"));
		this.add(new SingleTeamLabel("teamsPNG/DET.png","底特律 活塞"));
		this.add(new SingleTeamLabel("teamsPNG/IND.png","印第安纳 步行者"));
		this.add(new SingleTeamLabel("teamsPNG/MIL.png","密尔沃基 雄鹿"));
		
	}

}

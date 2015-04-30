package presentation.team;

import javax.swing.JFrame;

public class SouthEastDivision extends SingleDivisionLabel{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void setTeams() {
		SingleTeamLabel ATL = new SingleTeamLabel("teamsPNG/ATL.png","亚特兰大 老鹰");
		SingleTeamLabel CHA = new SingleTeamLabel("teamsPNG/CHA.png","夏洛特黄蜂");
		SingleTeamLabel MIA = new SingleTeamLabel("teamsPNG/MIA.png","迈阿密热火");
		SingleTeamLabel ORL = new SingleTeamLabel("teamsPNG/ORL.png","奥兰多魔术");
		SingleTeamLabel WAS = new SingleTeamLabel("teamsPNG/WAS.png","华盛顿奇才");

		this.addTeam(ATL);
		this.addTeam(CHA);
		this.addTeam(MIA);
		this.addTeam(ORL);
		this.addTeam(WAS);
	}
	
	public static void main(String args[]){
		JFrame f  = new JFrame();
		f.add(new SouthEastDivision());
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

package presentation.team;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;

public abstract class SingleDivisionLabel extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<SingleTeamLabel> teams;
	protected Color w = Color.WHITE;
	protected Color g = new Color(241,241,241);
	
	private TeamListPanel teamList;

	public SingleDivisionLabel(){
		teams = new ArrayList<SingleTeamLabel>();

		this.setLayout(new GridLayout(5,1,0,1));
		this.setBounds(0, 0, 200,560);
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		
		setTeams();
		
		this.setVisible(true);
	}
	
	public void setTeamList(TeamListPanel teamList){
		this.teamList = teamList;
	}
	
	protected abstract void setTeams();
	
	protected void addTeam(SingleTeamLabel team){
		teams.add(team);
		this.add(team);
		team.setSingleDivision(this);
	}
	
	public void teamChose(String teamName){
		teamList.teamChose(teamName);
		System.out.println("singleDivisionLabel: "+teamName);
	}
	
}

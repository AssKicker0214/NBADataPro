package presentation.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.main.Mainframe;

public class TeamListPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Mainframe mainFrame;
	
	public TeamListPanel(){
		this.setLayout(null);
		this.setBounds(150, 155,1130,545);
		this.setBackground(Color.WHITE);
		setHead();
		setDivisionHead();
		setTeams();
	}
	private void setHead(){
		JLabel head1 = new JLabel(" 东部联盟");
		head1.setFont(new Font("Dialog",1,30));
		head1.setOpaque(true);
		head1.setForeground(Color.WHITE);
		head1.setBackground(new Color(30,80,140));
		head1.setBounds(0,0,564,50);
		this.add(head1);

		JLabel head2 = new JLabel(" 西部联盟");
		head2.setFont(new Font("Dialog",1,30));
		head2.setOpaque(true);
		head2.setForeground(Color.WHITE);
		head2.setBackground(new Color(30,80,140));
		head2.setBounds(565,0,564,50);		
		this.add(head2);
	}
	
	public void setMainFrame(Mainframe mainFrame){
		this.mainFrame = mainFrame;
	}
	
	public void teamChose(String teamName){
		mainFrame.teamChose(teamName);
		System.out.println("TeamListPanel: "+ teamName);
	}
	
	private void setDivisionHead(){
		JLabel Divide1 = new JLabel(" 东南分区");
		Divide1.setFont(new Font("Dialog",1,15));
		Divide1.setOpaque(true);
		Divide1.setBackground(Color.LIGHT_GRAY);
		Divide1.setBounds(0,50,188,30);
		this.add(Divide1);
		
		JLabel Divide2 = new JLabel(" 中央分区");
		Divide2.setFont(new Font("Dialog",1,15));
		Divide2.setOpaque(true);
		Divide2.setBackground(Color.LIGHT_GRAY);
		Divide2.setBounds(188,50,188,30);
		this.add(Divide2);
		
		JLabel Divide3 = new JLabel(" 大西洋分区");
		Divide3.setFont(new Font("Dialog",1,15));
		Divide3.setOpaque(true);
		Divide3.setBackground(Color.LIGHT_GRAY);
		Divide3.setBounds(376,50,188,30);
		this.add(Divide3);
		
		JLabel Divide4 = new JLabel(" 太平洋分区");
		Divide4.setFont(new Font("Dialog",1,15));
		Divide4.setOpaque(true);
		Divide4.setBackground(Color.LIGHT_GRAY);
		Divide4.setBounds(565,50,188,30);
		this.add(Divide4);
		
		JLabel Divide5 = new JLabel(" 西北分区");
		Divide5.setFont(new Font("Dialog",1,15));
		Divide5.setOpaque(true);
		Divide5.setBackground(Color.LIGHT_GRAY);
		Divide5.setBounds(753,50,188,30);
		this.add(Divide5);
		
		JLabel Divide6 = new JLabel(" 西南分区");
		Divide6.setFont(new Font("Dialog",1,15));
		Divide6.setOpaque(true);
		Divide6.setBackground(Color.LIGHT_GRAY);
		Divide6.setBounds(941,50,188,30);
		this.add(Divide6);
	}
	
	private void setTeams(){
		JPanel TeamPanel = new JPanel();
		TeamPanel.setLayout(new GridLayout(1,6,1,0));
		TeamPanel.setBounds(0,80,1130,465);
		TeamPanel.setBackground(Color.WHITE);

		SingleDivisionLabel southEastDivision = new SouthEastDivision();
		southEastDivision.setTeamList(this);
		TeamPanel.add(southEastDivision);

		SingleDivisionLabel centerDivision = new CenterDivision();
		centerDivision.setTeamList(this);
		TeamPanel.add(centerDivision);

		SingleDivisionLabel AtlanticDivision = new AtlanticDivision();
		AtlanticDivision.setTeamList(this);
		TeamPanel.add(AtlanticDivision);

		SingleDivisionLabel PacificDivision = new PacificDivision();
		PacificDivision.setTeamList(this);
		TeamPanel.add(PacificDivision);

		SingleDivisionLabel northWestDivision = new NorthWestDivision();
		northWestDivision.setTeamList(this);
		TeamPanel.add(northWestDivision);

		SingleDivisionLabel southWestDivision = new SouthWestDivision();
		southWestDivision.setTeamList(this);
		TeamPanel.add(southWestDivision);
		
		this.add(TeamPanel);
	} 
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,720);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().add(new TeamListPanel());
		jf.setVisible(true);
	}
}

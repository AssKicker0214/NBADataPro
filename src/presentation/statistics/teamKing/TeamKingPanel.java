package presentation.statistics.teamKing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TeamKingPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel TitleLabel;
	
	TeamKingOptionsPanel teamKingOptionsPanel;
	
	Color entered = new Color(30,80,140);

	public TeamKingPanel(){
		this.setLayout(null);
		this.setBounds(150, 125,1130,600);
		this.setBackground(Color.WHITE);
		setTitle();
		setTeamKingOptionsPanel();
	}
	
	public void setTitle(){
		TitleLabel = new JLabel(" 赛季 联盟球队数据王",JLabel.LEADING);
		TitleLabel.setFont(new Font("Dialog",1,25));
		TitleLabel.setForeground(Color.WHITE);
		TitleLabel.setBackground(entered);
		TitleLabel.setOpaque(true);
		TitleLabel.setBounds(0,0,1130,100);
		this.add(TitleLabel);
		this.updateUI();
		//new Color(33,82,138)
	}

	public void setTeamKingOptionsPanel(){
		teamKingOptionsPanel = new TeamKingOptionsPanel();
		this.add(teamKingOptionsPanel);
	}

	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new TeamKingPanel());
		jf.setVisible(true);
	}

}

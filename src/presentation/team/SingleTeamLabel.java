package presentation.team;

/*
 * 忘记加监听了
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import presentation.common.PhotoLabel;



public class SingleTeamLabel extends JLabel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel TeamPicLabel;
	JLabel ItemsJLabel;
	
	public SingleTeamLabel(String path,String TeamName){
		this.setLayout(null);
		this.setBounds(0, 80, 188,78);
		this.setOpaque(true);
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
		setItemLabel();
		setTeamNameLabel(TeamName);
		setTeamPicLabel(path);
	}
	
	
	public void setTeamPicLabel(String path){
		TeamPicLabel = new PhotoLabel(new ImageIcon(path).getImage());
		TeamPicLabel.setBounds(0,0,140,75);
		TeamPicLabel.setBackground(Color.LIGHT_GRAY);
		TeamPicLabel.setOpaque(true);
		TeamPicLabel.setVisible(true);
		this.add(TeamPicLabel);
	}
	
	/*team name changes*/
	public void setTeamNameLabel(String TeamName){
		JLabel TeamNameLabel = new JLabel(TeamName);
		TeamNameLabel.setFont(new Font("Dialog",1,15));
		TeamNameLabel.setForeground(Color.GRAY);
		TeamNameLabel.setBounds(80,0,150,30);
		this.add(TeamNameLabel);

	}
	
	public void setItemLabel(){
		
		ItemsJLabel = new JLabel();
		ItemsJLabel.setLayout(new GridLayout(2,2,0,0));
		ItemsJLabel.setBounds(85,30,90,40);
		ItemsJLabel.setBackground(Color.LIGHT_GRAY);
		ItemsJLabel.setOpaque(true);

		JLabel TeamDataLabel = new JLabel("数据");
		TeamDataLabel.setFont(new Font("Dialog",1,12));
		TeamDataLabel.setSize(10, 10);
		TeamDataLabel.setForeground(Color.GRAY);
		ItemsJLabel.add(TeamDataLabel);
		
		JLabel TeamDataKingLabel = new JLabel("数据王");
		TeamDataKingLabel.setFont(new Font("Dialog",1,12));
		TeamDataKingLabel.setForeground(Color.GRAY);
		TeamDataLabel.setSize(10, 10);

		ItemsJLabel.add(TeamDataKingLabel);

		JLabel TeamMemberLabel = new JLabel("阵容");
		TeamMemberLabel.setFont(new Font("Dialog",1,12));
		TeamMemberLabel.setForeground(Color.GRAY);
		TeamDataLabel.setSize(10, 10);

		ItemsJLabel.add(TeamMemberLabel);

		JLabel TeamMatchLabel = new JLabel("赛程");
		TeamMatchLabel.setFont(new Font("Dialog",1,12));
		TeamMatchLabel.setForeground(Color.GRAY);
		TeamDataLabel.setSize(10, 10);

		ItemsJLabel.add(TeamMatchLabel);
		
		ItemsJLabel.setVisible(true);
		this.add(ItemsJLabel);

	}
	//length 188  height 78
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().add(new SingleTeamLabel("teamsPNG/ATL.png","亚特兰大 老鹰"));
		jf.setVisible(true);
	}
}

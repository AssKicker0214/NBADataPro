package presentation.team;

/*
 * 忘记加监听了
 */
import java.awt.Color;
import java.awt.Font;
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
	
	
	public SingleTeamLabel(String path,String location,String TeamName, Color color){
		this.setLayout(null);
		this.setBounds(0, 80, 188,78);
		this.setOpaque(true);
		this.setBackground(color);
		this.setVisible(true);
//		setItemLabel();
		setTeamNameLabel(TeamName);
		setTeamLocationLabel(location);
		setTeamPicLabel(path);
	}
	
	
	public void setTeamPicLabel(String path){
		TeamPicLabel = new PhotoLabel(new ImageIcon(path).getImage());
		TeamPicLabel.setBounds(0,0,140,75);
		TeamPicLabel.setVisible(true);
		this.add(TeamPicLabel);
	}
	
	/*team name changes*/
	public void setTeamNameLabel(String TeamName){
		JLabel TeamNameLabel = new JLabel(TeamName);
		TeamNameLabel.setFont(new Font("Dialog",1,15));
		TeamNameLabel.setForeground(Color.GRAY);
		TeamNameLabel.setBounds(90,40,150,30);
		this.add(TeamNameLabel);

	}
	public void setTeamLocationLabel(String location){
		JLabel TeamLocationLabel = new JLabel(location);
		TeamLocationLabel.setFont(new Font("Dialog",1,15));
		TeamLocationLabel.setForeground(Color.GRAY);
		TeamLocationLabel.setBounds(90,10,150,30);
		this.add(TeamLocationLabel);

	}
	
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().add(new SingleTeamLabel("teamsPNG/ATL.png","亚特兰大","老鹰",Color.WHITE));
		jf.setVisible(true);
	}
}

package presentation.team;

/*
 * 忘记加监听了
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import presentation.common.PhotoLabel;
import presentation.main.Mainframe;
import presentation.player.playerDetail.PlayerMiddlePanel;
import presentation.team.teamDetail.TeamMiddlePanel;



public class SingleTeamLabel extends JLabel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel TeamPicLabel;
	JLabel ItemsJLabel;
	String teamName;
	
	SingleDivisionLabel singleDivision;
	
	
	public SingleTeamLabel(String path,String location,String teamName, Color color){
		this.setLayout(null);
		this.setBounds(0, 80, 188,78);
		this.setOpaque(true);
		this.setBackground(color);
		this.setVisible(true);
//		setItemLabel();
		setTeamNameLabel(teamName);
		setTeamLocationLabel(location);
		setTeamPicLabel(path);
		this.teamName = teamName;
		this.addMouseListener(new SingleTeamAction());
		
		
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
	
	public void setSingleDivision(SingleDivisionLabel singleDivision){
		this.singleDivision = singleDivision;
	}
	
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().add(new SingleTeamLabel("teamsPNG/ATL.png","Atlanta","Hawks",Color.WHITE));
		jf.setVisible(true);
	}
	
	class SingleTeamAction implements MouseListener{

		@Override
		public void mouseClicked
		(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			Mainframe.getFrame().restoreIni();
			Mainframe.getFrame().changeContent(new TeamMiddlePanel(SingleTeamLabel.this.teamName));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

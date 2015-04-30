package presentation.team.teamDetail;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.PhotoLabel;

public class TeamDetailTopPanel  extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel TeamNameLabel;
	JLabel WinRate;
	JPanel TeamBasicInfoPanel;
	JPanel TeamAvgFieldPanel;
	
	public TeamDetailTopPanel(){
		this.setLayout(null);
		this.setBounds(0, 0, 1280,200);
		this.setBackground(Color.white);
		setTeamPhotoLabel();
		setTeamName();
		setWinRate();
		setTeamBasicInfoPanel();
		setTeamAvgFieldPanel();
	}
	
	/*
	 * 画一条线分割基础信息与胜负场数
	 */
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.gray);
		g2.draw(new Line2D.Double(700, 30, 700, 100));
//		g2.drawString("Line", 350, 250);
	}
	
	/*
	 * 在toplabel里添加球员图片；
	 */
	public void setTeamPhotoLabel (){
		JLabel teamPhotoLabel = new PhotoLabel(new ImageIcon("teamsPNG/ATL.png").getImage());
		teamPhotoLabel.setBounds(0,15,230,185);
		teamPhotoLabel.setBackground(Color.WHITE);
		teamPhotoLabel.setOpaque(true);
		teamPhotoLabel.setVisible(true);
		this.add(teamPhotoLabel);
	}
	
	
	/*
	 * 添加球队所在地和名称label
	 */
	public void setTeamName(){
		TeamNameLabel = new JLabel("Atlanta"+" "+"Hawks");
		TeamNameLabel.setFont(new Font("Dialog",1,50));
		TeamNameLabel.setForeground(Color.GRAY);
		TeamNameLabel.setBounds(260,40,440,60);
		this.add(TeamNameLabel);
		
	}
	
	public void setWinRate(){
		WinRate = new JLabel("胜率:"+" "+"0.75");
		WinRate.setFont(new Font("微软雅黑",1,40));
		WinRate.setForeground(Color.DARK_GRAY);
		WinRate.setBounds(710,30,570,60);
		this.add(WinRate);
	}
	
	public void setTeamBasicInfoPanel(){
		TeamBasicInfoPanel = new JPanel();
		TeamBasicInfoPanel.setLayout(new GridLayout(4,1,0,0));
		TeamBasicInfoPanel.setBounds(260,100,200,90);
		TeamBasicInfoPanel.setBackground(Color.WHITE);
				
		JLabel leagueLabel = new JLabel("League:     "+"east");
		leagueLabel.setFont(new Font("Dialog",1,10));
		leagueLabel.setForeground(Color.DARK_GRAY);
		TeamBasicInfoPanel.add(leagueLabel);

		JLabel divisionLabel = new JLabel("Division:     " + "Southeast");
		divisionLabel.setFont(new Font("Dialog",1,10));
		divisionLabel.setForeground(Color.DARK_GRAY);
		TeamBasicInfoPanel.add(divisionLabel);
		
		JLabel homeCourtLabel = new JLabel("Home court:	" + "Philips Arena");
		homeCourtLabel.setFont(new Font("Dialog",1,10));
		homeCourtLabel.setForeground(Color.DARK_GRAY);
		TeamBasicInfoPanel.add(homeCourtLabel);
		
		JLabel foundTimeLabel = new JLabel("Found time:    " + "1949");
		foundTimeLabel.setFont(new Font("Dialog",1,10));
		foundTimeLabel.setForeground(Color.DARK_GRAY);
		TeamBasicInfoPanel.add(foundTimeLabel);
		
		TeamBasicInfoPanel.setVisible(true);
		this.add(TeamBasicInfoPanel);
	}

	public void setTeamAvgFieldPanel(){
		TeamAvgFieldPanel = new JPanel();
		TeamAvgFieldPanel.setLayout(new GridLayout(2,3,10,0));
		TeamAvgFieldPanel.setBounds(710,120,230,78);
		TeamAvgFieldPanel.setBackground(Color.WHITE);
				
		JLabel AvgFieldScoreLabel = new JLabel("场均得分");
		AvgFieldScoreLabel.setFont(new Font("Dialog",1,15));
		AvgFieldScoreLabel.setForeground(Color.GRAY);
		TeamAvgFieldPanel.add(AvgFieldScoreLabel);

		JLabel AvgFieldREBLabel = new JLabel("场均篮板");
		AvgFieldREBLabel.setFont(new Font("Dialog",1,15));
		AvgFieldREBLabel.setForeground(Color.GRAY);
		TeamAvgFieldPanel.add(AvgFieldREBLabel);
		
		JLabel AvgFieldAssistLabel = new JLabel("场均助攻");
		AvgFieldAssistLabel.setFont(new Font("Dialog",1,15));
		AvgFieldAssistLabel.setForeground(Color.GRAY);
		TeamAvgFieldPanel.add(AvgFieldAssistLabel);
		
		JLabel AvgFieldScore = new JLabel("3.1");
		AvgFieldScore.setFont(new Font("Dialog",1,25));
		AvgFieldScore.setForeground(Color.GRAY);
		TeamAvgFieldPanel.add(AvgFieldScore);
		
		JLabel AvgFieldREB = new JLabel("0.9");
		AvgFieldREB.setFont(new Font("Dialog",1,25));
		AvgFieldREB.setForeground(Color.GRAY);
		TeamAvgFieldPanel.add(AvgFieldREB);
		
		JLabel AvgFieldAssist = new JLabel("0.5");
		AvgFieldAssist.setFont(new Font("Dialog",1,25));
		AvgFieldAssist.setForeground(Color.GRAY);
		TeamAvgFieldPanel.add(AvgFieldAssist);
				
		TeamAvgFieldPanel.setVisible(true);
		this.add(TeamAvgFieldPanel);
	}
	
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new TeamDetailTopPanel());
		jf.setVisible(true);
	}
}

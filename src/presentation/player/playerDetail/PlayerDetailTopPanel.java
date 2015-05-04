package presentation.player.playerDetail;

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

import presentation.common.PhotoLabel;
import vo.playervo.PlayerVO;


public class PlayerDetailTopPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel playerNumLabel;
	JLabel playerNameLabel;
	JLabel playerPos_TeamLabel;
	JPanel PlayerBasicInfoPanel;
	JPanel PlayerAvgFieldPanel;
	
	PlayerVO vo;
	
	public PlayerDetailTopPanel(PlayerVO v){
		vo = v;
		this.setLayout(null);
		this.setBounds(0, 0, 1280,200);
		this.setBackground(Color.white);
		setPlayerPhotoLabel();
		setTeamPicLabel();
		setPlayerNUM();
		setPlayerName();
		setPlayerPos_Team();
		setPlayerBasicInfoPanel();
		setPlayerAvgFieldPanel();
	}
	
	/*
	 * 画一条线分割基础信息与球衣号
	 */
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.gray);
		g2.draw(new Line2D.Double(450, 20, 450, 110));
//		g2.drawString("Line", 350, 250);
	}
	
	/*
	 * 在toplabel里添加球员图片；1.png是球员图片
	 */
	public void setPlayerPhotoLabel (){
		JLabel playerPhotoLabel = new PhotoLabel(new ImageIcon("portrait/"+vo.photo+".png").getImage());
		playerPhotoLabel.setBounds(0,15,230,185);
		playerPhotoLabel.setBackground(Color.WHITE);
		playerPhotoLabel.setOpaque(true);
		playerPhotoLabel.setVisible(true);
		this.add(playerPhotoLabel);
	}
	
	/*
	 * 在panel右侧添加球员所属球队图片，图片名称为ATL
	 */
	public void setTeamPicLabel(){
		JLabel teamPicLabel = new PhotoLabel(new ImageIcon("teamsPNG/"+vo.teamName+".png").getImage());
		teamPicLabel.setBounds(1100,0,130,130);
		teamPicLabel.setBackground(Color.WHITE);
		teamPicLabel.setOpaque(true);
		teamPicLabel.setVisible(true);
		this.add(teamPicLabel);
	}
	
	/*
	 * 添加球员球衣号label
	 */
	public void setPlayerNUM(){
		playerNumLabel = new JLabel(vo.number+"");
		playerNumLabel.setFont(new Font("Dialog",1,60));
		playerNumLabel.setForeground(Color.GRAY);
		playerNumLabel.setBounds(390,40,60,60);
		this.add(playerNumLabel);
		
	}
	
	public void setPlayerName(){
		playerNameLabel = new JLabel(vo.name+"");
		playerNameLabel.setFont(new Font("Dialog",1,20));
		playerNameLabel.setForeground(Color.DARK_GRAY);
		playerNameLabel.setBounds(470,30,180,30);
		this.add(playerNameLabel);
	}
	
	public void setPlayerPos_Team(){
		playerPos_TeamLabel = new JLabel(vo.position+"／"+vo.team);
		playerPos_TeamLabel.setFont(new Font("Dialog",1,13));
		playerPos_TeamLabel.setForeground(Color.DARK_GRAY);
		playerPos_TeamLabel.setBounds(470,80,150,30);
		this.add(playerPos_TeamLabel);
	}

	public void setPlayerBasicInfoPanel(){
		PlayerBasicInfoPanel = new JPanel();
		PlayerBasicInfoPanel.setLayout(new GridLayout(4,1,0,0));
		PlayerBasicInfoPanel.setBounds(850,20,200,90);
		PlayerBasicInfoPanel.setBackground(Color.WHITE);
				
		JLabel height_weightLabel = new JLabel("Height/Weight:     "+vo.hight+"/"+vo.weigth);
		height_weightLabel.setFont(new Font("Dialog",1,10));
		height_weightLabel.setForeground(Color.DARK_GRAY);
		PlayerBasicInfoPanel.add(height_weightLabel);

		JLabel birthdatLabel = new JLabel("Bitrh:     " + vo.birth);
		birthdatLabel.setFont(new Font("Dialog",1,10));
		birthdatLabel.setForeground(Color.DARK_GRAY);
		PlayerBasicInfoPanel.add(birthdatLabel);
		
		JLabel EXPLabel = new JLabel("Exp:    "+vo.exp+ "years");
		EXPLabel.setFont(new Font("Dialog",1,10));
		EXPLabel.setForeground(Color.DARK_GRAY);
		PlayerBasicInfoPanel.add(EXPLabel);
		
		JLabel schoolLabel = new JLabel("School:    " +vo.school);
		schoolLabel.setFont(new Font("Dialog",1,10));
		schoolLabel.setForeground(Color.DARK_GRAY);
		PlayerBasicInfoPanel.add(schoolLabel);
		
		PlayerBasicInfoPanel.setVisible(true);
		this.add(PlayerBasicInfoPanel);
	}

	public void setPlayerAvgFieldPanel(){
		PlayerAvgFieldPanel = new JPanel();
		PlayerAvgFieldPanel.setLayout(new GridLayout(2,3,10,0));
		PlayerAvgFieldPanel.setBounds(400,120,230,78);
		PlayerAvgFieldPanel.setBackground(Color.WHITE);
				
		JLabel AvgFieldScoreLabel = new JLabel("场均得分");
		AvgFieldScoreLabel.setFont(new Font("Dialog",1,15));
		AvgFieldScoreLabel.setForeground(Color.GRAY);
		PlayerAvgFieldPanel.add(AvgFieldScoreLabel);

		JLabel AvgFieldREBLabel = new JLabel("场均篮板");
		AvgFieldREBLabel.setFont(new Font("Dialog",1,15));
		AvgFieldREBLabel.setForeground(Color.GRAY);
		PlayerAvgFieldPanel.add(AvgFieldREBLabel);
		
		JLabel AvgFieldAssistLabel = new JLabel("场均助攻");
		AvgFieldAssistLabel.setFont(new Font("Dialog",1,15));
		AvgFieldAssistLabel.setForeground(Color.GRAY);
		PlayerAvgFieldPanel.add(AvgFieldAssistLabel);
		
		JLabel AvgFieldScore = new JLabel(vo.avgPoint+"");
		AvgFieldScore.setFont(new Font("Dialog",1,25));
		AvgFieldScore.setForeground(Color.GRAY);
		PlayerAvgFieldPanel.add(AvgFieldScore);
		
		JLabel AvgFieldREB = new JLabel(vo.avgRebound+"");
		AvgFieldREB.setFont(new Font("Dialog",1,25));
		AvgFieldREB.setForeground(Color.GRAY);
		PlayerAvgFieldPanel.add(AvgFieldREB);
		
		JLabel AvgFieldAssist = new JLabel(vo.avgAssist+"");
		AvgFieldAssist.setFont(new Font("Dialog",1,25));
		AvgFieldAssist.setForeground(Color.GRAY);
		PlayerAvgFieldPanel.add(AvgFieldAssist);
				
		PlayerBasicInfoPanel.setVisible(true);
		this.add(PlayerAvgFieldPanel);
	}
	
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
//		jf.add(new PlayerDetailTopPanel());
		jf.setVisible(true);
	}
}

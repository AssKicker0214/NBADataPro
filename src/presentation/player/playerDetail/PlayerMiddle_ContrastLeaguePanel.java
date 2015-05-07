package presentation.player.playerDetail;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.player.SingleBarLabel;


public class PlayerMiddle_ContrastLeaguePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel BarsGroupLabel;
	JLabel AvgFieldScoreLabel;
	JLabel AvgFieldREBLabel;
	JLabel AvgFieldAssitLabel;
	JLabel FTPLabel;
	JLabel TPSPLabel;
	JLabel BlueLabel;
	JLabel PlayerTextLabel;
	JLabel GreyLabel;
	JLabel LeagueAvgTextLabel;
	
	Color blue = new Color(56,167,230);
	
	public PlayerMiddle_ContrastLeaguePanel(ArrayList<Double> player,ArrayList<Double> leagueAvg){
		this.setLayout(null);
		this.setBounds(0, 250, 1280,180);
		this.setBackground(Color.WHITE);
		BarsGroupLabel = new JLabel();
		setBottomTitle();
		setBarsLabel(player,leagueAvg);
	}
	
	/*
	 * 画5条线分割属性
	 */
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.LIGHT_GRAY); 
		g2.draw(new Line2D.Double(320, 130, 320,180 ));
		g2.draw(new Line2D.Double(495, 130, 495,180));
		g2.draw(new Line2D.Double(670, 130, 670,180 ));
		g2.draw(new Line2D.Double(845, 130, 845,180 ));
		g2.draw(new Line2D.Double(1020, 130,1020,180 ));
		g2.setPaint(Color.ORANGE);
		g2.draw(new Line2D.Double(0, 180, 1280, 180));
	}
	
	public void setBottomTitle(){
		AvgFieldScoreLabel = new JLabel("场均得分",JLabel.CENTER);
		AvgFieldScoreLabel.setFont(new Font("Dialog",1,15));
		AvgFieldScoreLabel.setForeground(Color.BLACK);
		AvgFieldScoreLabel.setBounds(321,130,175,50);
		this.add(AvgFieldScoreLabel);

		AvgFieldREBLabel = new JLabel("场均篮板",JLabel.CENTER);
		AvgFieldREBLabel.setFont(new Font("Dialog",1,15));
		AvgFieldREBLabel.setForeground(Color.BLACK);
		AvgFieldREBLabel.setBounds(496,130,175,50);
		this.add(AvgFieldREBLabel);
		
		AvgFieldAssitLabel = new JLabel("场均助攻",JLabel.CENTER);
		AvgFieldAssitLabel.setFont(new Font("Dialog",1,15));
		AvgFieldAssitLabel.setForeground(Color.BLACK);
		AvgFieldAssitLabel.setBounds(671,130,175,50);
		this.add(AvgFieldAssitLabel);
		
		FTPLabel = new JLabel("罚球％",JLabel.CENTER);
		FTPLabel.setFont(new Font("Dialog",1,15));
		FTPLabel.setForeground(Color.BLACK);
		FTPLabel.setBounds(846,130,175,50);
		this.add(FTPLabel);
		
		TPSPLabel = new JLabel("三分％",JLabel.CENTER);
		TPSPLabel.setFont(new Font("Dialog",1,15));
		TPSPLabel.setForeground(Color.BLACK);
		TPSPLabel.setBounds(1021,130,175,50);
		this.add(TPSPLabel);
		
		BlueLabel = new JLabel();
		BlueLabel.setBackground(blue);
		BlueLabel.setBounds(70,150,10,10);
		BlueLabel.setOpaque(true);
		this.add(BlueLabel);
		
		PlayerTextLabel = new JLabel("球员");
		PlayerTextLabel.setFont(new Font("Dialog",1,10));
		PlayerTextLabel.setForeground(Color.GRAY);
		PlayerTextLabel.setBounds(85,140,30,30);
		this.add(PlayerTextLabel);
		
		GreyLabel = new JLabel();
		GreyLabel.setBackground(Color.LIGHT_GRAY);
		GreyLabel.setBounds(170,150,10,10);
		GreyLabel.setOpaque(true);
		this.add(GreyLabel);

		LeagueAvgTextLabel = new JLabel("联盟平均值");
		LeagueAvgTextLabel.setFont(new Font("Dialog",1,10));
		LeagueAvgTextLabel.setForeground(Color.GRAY);
		LeagueAvgTextLabel.setBounds(185,140,50,30);
		this.add(LeagueAvgTextLabel);

	}
	
	public void setBarsLabel(ArrayList<Double> player,ArrayList<Double> leagueAvg){
		JLabel LeagueContrastTextLabel = new JLabel("联盟对比",JLabel.CENTER);
		LeagueContrastTextLabel.setFont(new Font("Dialog",1,20));
		LeagueContrastTextLabel.setForeground(Color.GRAY);
		LeagueContrastTextLabel.setBounds(0,0,320,130);
		this.add(LeagueContrastTextLabel);
		
		BarsGroupLabel.setLayout(new GridLayout(1,5,0,0));
		BarsGroupLabel.setBounds(340,0,870,130);
		BarsGroupLabel.setBackground(Color.black);
		BarsGroupLabel.setOpaque(true);
		BarsGroupLabel.setVisible(true);

//		int[] playerLim = {40,20,30,1,1};

		JLabel FS_BarLabel = new SingleBarLabel(player.get(0),leagueAvg.get(0),blue,40,100);
		JLabel REB_BarLabel = new SingleBarLabel(player.get(1),leagueAvg.get(1),blue,20,100);
		JLabel Assist_BarLabel = new SingleBarLabel(player.get(2),leagueAvg.get(2),blue,30,100);
		JLabel FTP_BarLabel = new SingleBarLabel(player.get(3),leagueAvg.get(3),blue,1,100);
		JLabel TPTP_BarLabel = new SingleBarLabel(player.get(4),leagueAvg.get(4),blue,1,100);

		BarsGroupLabel.removeAll();
		BarsGroupLabel.add(FS_BarLabel);
		BarsGroupLabel.add(REB_BarLabel);
		BarsGroupLabel.add(Assist_BarLabel);
		BarsGroupLabel.add(FTP_BarLabel);
		BarsGroupLabel.add(TPTP_BarLabel);
		this.add(BarsGroupLabel);
	}


	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		ArrayList<Double> player = new ArrayList<Double>();
		ArrayList<Double> leagueAvg = new ArrayList<Double>();
		player.add(20.5);leagueAvg.add(30.7);
		player.add(20.5);leagueAvg.add(30.7);
		player.add(20.5);leagueAvg.add(30.7);
		player.add(20.5);leagueAvg.add(30.7);
		player.add(20.5);leagueAvg.add(30.7);
		jf.add(new PlayerMiddle_ContrastLeaguePanel(player,leagueAvg));
		jf.setVisible(true);
	}
	


}

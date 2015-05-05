package presentation.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import presentation.floatui.FloatPane;
import presentation.floatui.IMainFrameSize;
import presentation.match.MatchListPanel;
import presentation.player.PlayerDataList;
import presentation.player.playerDetail.PlayerMiddlePanel;
import presentation.statistics.hotPlayer.HotPlayerPanel;
import presentation.statistics.playerKing.PlayerKingPanel;
import presentation.statistics.teamKing.TeamKingPanel;
import presentation.team.TeamListPanel;
import presentation.team.teamDetail.TeamMiddlePanel;

public class Mainframe extends JFrame implements IMainFrame,IMainFrameSize{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Mainframe frame;
	JLayeredPane layer;
	JPanel contentPane;
	JPanel bufferedPane;
	
	boolean contentPaneChange = false;
	
	JPanel playerKing;
	JPanel teamKing;
	JPanel hotPlayer;
	JPanel teamList;
	JPanel playerList;
	JPanel matchList;
	ArrayList<JPanel> mainParts = new ArrayList<JPanel>();
	
	private  Mainframe(){ 
		setFrame();
	}
	
	public static Mainframe getFrame(){
		if(frame == null){
			frame = new Mainframe();
		}else{
			
		}

		return frame;
	}
	
	private void setFrame(){
		layer = this.getLayeredPane();
		contentPane = (JPanel) this.getContentPane();
		bufferedPane = new JPanel();
	
		setLayout(null);
		setUndecorated(true);
		setSize(1280,700);
		setLocationRelativeTo(null);
		setTitleLabel();
		setImageLabel(); 
		setGuideGroup();
		
		setMainPartPanel();
		
		setFloat();
		
		setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setTitleLabel(){
		JLabel titleLabel = new JLabel();
		titleLabel.setBounds(0, 0, 1280,30);
		titleLabel.setBackground(Color.black);
		titleLabel.setOpaque(true);
		this.add(titleLabel);
		titleLabel.addMouseMotionListener(new  MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	public void setImageLabel(){
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 30, 1280,120);
		imageLabel.setBackground(Color.darkGray);
		imageLabel.setOpaque(true);
		this.add(imageLabel);
	}
	
	private void setGuideGroup(){
		GuideContainer guideContainer = new GuideContainer();
		GuideLabel playerGuide = new GuideLabel("球员");
		playerGuide.setMainFrame(this);
		
		GuideLabel teamGuide = new GuideLabel("球队");
		teamGuide.setMainFrame(this);

		GuideLabel gameGuide = new GuideLabel("比赛");
		gameGuide.setMainFrame(this);

		GuideLabel staticGuide = new GuideLabel("统计");
		staticGuide.setMainFrame(this);


			SuboptionLayer staticSuboptionLayer = new StaticSuboptionLayer();
			
			layer.add(staticSuboptionLayer);
			layer.setLayer(staticSuboptionLayer, 500);
			staticSuboptionLayer.setMainFrame(this);
			
		staticGuide.linkSuboption(staticSuboptionLayer);
			
		guideContainer.addGuide(playerGuide);
		guideContainer.addGuide(teamGuide);
		guideContainer.addGuide(gameGuide);
		guideContainer.addGuide(staticGuide);
		this.add(guideContainer);
		
//		this.setSuboptionLayer();
	}
	
	
	private void setMainPartPanel(){
		playerKing = new PlayerKingPanel();
		this.add(playerKing);
		playerKing.setVisible(false);
		
		teamKing = new TeamKingPanel();
		this.add(teamKing);
		teamKing.setVisible(false);
		
		hotPlayer = new HotPlayerPanel();
		this.add(hotPlayer);
		hotPlayer.setVisible(false);
		
		teamList = new TeamListPanel();
		((TeamListPanel) teamList).setMainFrame(this);
		this.add(teamList);
		teamList.setVisible(false);
		
		playerList = new PlayerDataList();
		this.add(playerList,0);
		playerList.setVisible(false);
		
		matchList = new MatchListPanel();
		this.add(matchList,0);
		matchList.setVisible(false);
		
		mainParts.add(playerKing);
		mainParts.add(teamKing);
		mainParts.add(hotPlayer);
		mainParts.add(teamList);
		mainParts.add(playerList);
		mainParts.add(matchList);
	}
	
	private void changeMainPart(JPanel target){
		for(JPanel mainpart: mainParts){
			if(mainpart != target){
				mainpart.setVisible(false);
			}else{
				target.setVisible(true);
			}
		}
	}
	
	private void setFloat(){
		FloatPane floatPane = new FloatPane();
		layer.add(floatPane, new Integer(10000));
		floatPane.setMainFrame(this);
		
	}
	
	public static  void main(String[] args){
		Mainframe.getFrame();
	}

	public void returnIni(){
		if(contentPaneChange){
			contentPaneChange = false;
			this.setContentPane(bufferedPane);
			contentPane.repaint();
		}
		for(int i=0;i<mainParts.size();i++){
			mainParts.get(i).setVisible(false);
		}
	}
	
	public void restoreIni(){
		bufferedPane = contentPane;
	}

	@Override
	public void update(String s) {
		// TODO Auto-generated method stub
		switch(s){
			case "热点球员": changeMainPart(playerKing); System.out.println(s);break;
			case "热点球队": changeMainPart(teamKing); System.out.println(s);break;
			case "进步球员": changeMainPart(hotPlayer);System.out.println(s);break;
			case "球队": changeMainPart(teamList);System.out.println(s);break;
			case "球员": changeMainPart(playerList);System.out.println(s);break;
			case "比赛": changeMainPart(matchList);System.out.println(s);break;
			default: break;
		}
	}
	
	public void teamChose(String teamName){
		contentPaneChange = true;
		restoreIni();
		this.setContentPane(new PlayerMiddlePanel("Aaron Gray"));
//		contentPane = new PlayerMiddlePanel("Aaron Gray");
//		contentPane.setVisible(false);
//		contentPane.add(new PlayerMiddlePanel("Aaron Gray"),0);
//		contentPane.setVisible(true);
		System.out.println("team has been chosen: "+teamName);
	}


	@Override
	public Dimension getMainFrameSize() {
		// TODO Auto-generated method stub
		System.out.println(this.getSize());
		return this.getSize();
	}

}

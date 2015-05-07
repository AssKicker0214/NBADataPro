package presentation.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import data.DataInitial;
import presentation.common.PhotoLabel;
import presentation.floatui.FloatPane;
import presentation.floatui.IMainFrameSize;
import presentation.match.MatchListPanel;
import presentation.player.PlayerDataList;
import presentation.statistics.hotPlayer.HotPlayerPanel;
import presentation.statistics.playerKing.PlayerKingPanel;
import presentation.statistics.teamKing.TeamKingPanel;
import presentation.team.TeamDataList;
import presentation.team.TeamListPanel;

public class Mainframe extends JFrame implements IMainFrame,IMainFrameSize{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Mainframe frame;
	JLayeredPane layer;

	JPanel contentPane;
	JPanel bufferedPane;
	JPanel jumpPane;
	
	boolean contentPaneChange = false;
	
	JPanel playerKing;
	JPanel teamKing;
	JPanel hotPlayer;
	JPanel teamList;
	JPanel playerList;
	JPanel matchList;
	JPanel teamDataList;
	
	ArrayList<JPanel> mainParts = new ArrayList<JPanel>();
	
	GuideContainer guideContainer;
	
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
		bufferedPane = new JPanel();
	
		setLayout(null);
		setUndecorated(true);
		setSize(1280,700);
		setLocationRelativeTo(null);
		setContent();
		setTitleLabel();
		setImageLabel(); 
		setGuideGroup();
		
		setMainPartPanel();
		
		setFloat();
		
		setVisible(true);
		contentPane.setVisible(true);
		System.out.println(contentPane.getComponentCount());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setTitleLabel(){
		TitleLabel titleLabel = new TitleLabel();
		this.add(titleLabel);
	}
	
	private void setContent(){
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setVisible(false);
//		contentPane.setBackground(Color.cyan);
		contentPane.setBounds(0, 30, 1280, 670);
		this.add(contentPane);
	}
	
	public void changeContent(JPanel panel){
		contentPaneChange = true;
		contentPane.setVisible(false);
		Mainframe.getFrame().remove(contentPane);
		contentPane = panel;
		Mainframe.getFrame().add(contentPane);
		contentPane.setVisible(true);
		System.out.println(contentPane.getComponentCount());
	}
	
	public void setImageLabel(){
		JLabel imageLabel = new PhotoLabel(new ImageIcon("title.png").getImage());
		imageLabel.setBounds(0, 0, 1280,120);
		imageLabel.setBackground(Color.darkGray);
		imageLabel.setOpaque(true);
		contentPane.add(imageLabel);
	}
	
	private void setGuideGroup(){
		guideContainer = new GuideContainer();
		GuideLabel playerGuide = new GuideLabel("球员");
		playerGuide.setMainFrame(this);
		
		GuideLabel teamGuide = new GuideLabel("球队");
		teamGuide.setMainFrame(this);
		
			SuboptionLayer teamSuboptionLayer = new TeamSuboptionLayer();
			layer.add(teamSuboptionLayer);
			layer.setLayer(teamSuboptionLayer, 600);
			teamSuboptionLayer.setMainFrame(this);
			teamGuide.linkSuboption(teamSuboptionLayer);
		
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
		contentPane.add(guideContainer);
		
//		this.setSuboptionLayer();
	}
	
	private void setMainPartPanel(){
/*		playerKing = new PlayerKingPanel();
		contentPane.add(playerKing);
		playerKing.setVisible(false);
		
		teamKing = new TeamKingPanel();
		contentPane.add(teamKing);
		teamKing.setVisible(false);
		
		hotPlayer = new HotPlayerPanel();
		contentPane.add(hotPlayer);
		hotPlayer.setVisible(false);
		*/
		
		teamList = new TeamListPanel();
	//	((TeamListPanel) teamList).setMainFrame(this);
		contentPane.add(teamList);
		teamList.setVisible(true);
		
		playerList = new PlayerDataList();
		contentPane.add(playerList,0);
		playerList.setVisible(false);
		
		matchList = new MatchListPanel();
		contentPane.add(matchList,0);
		matchList.setVisible(false);
	//	DataInitial.addUpdatable((MatchListPanel)matchList);
		
 		teamDataList = new TeamDataList();
 		contentPane.add(teamDataList,0);
 		teamDataList.setVisible(false);
		
//		mainParts.add(playerKing);
//		mainParts.add(teamKing);
//		mainParts.add(hotPlayer);
		mainParts.add(teamList);
		mainParts.add(playerList);
		mainParts.add(matchList);
		mainParts.add(teamDataList);

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
		DataInitial.init();
		Mainframe.getFrame();
	}

	public void returnIni(){
		if(contentPaneChange){
			System.out.println("contentPaneChange");
			contentPane.setVisible(false);
			contentPaneChange = false;
			this.remove(contentPane);
			contentPane = bufferedPane;
			this.add(contentPane);
			this.repaint();
			guideContainer.setAllUnselected();
			contentPane.setVisible(true);
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
			case "热点球员": changeMainPart(playerKing); System.out.println(s);restoreIni();break;
			case "热点球队": changeMainPart(teamKing); System.out.println(s);restoreIni();break;
			case "进步球员": changeMainPart(hotPlayer);System.out.println(s);restoreIni();break;
			case "球队列表": changeMainPart(teamList);System.out.println(s);restoreIni();break;
			case "球员": changeMainPart(playerList);System.out.println(s);restoreIni();break;
			case "比赛": changeMainPart(matchList);System.out.println(s);restoreIni();break;
			case "球队表格": changeMainPart(teamDataList);System.out.println(s);restoreIni();break;
			default: break;
		}
	}
	
	public void teamChose(String teamName){
		contentPaneChange = true;
		restoreIni();
//		changeContent(panel);
//		this.setContentPane(new TeamMiddlePanel(teamName));
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

	class TitleLabel extends JLabel{
		Mainframe frame;
		int offsetX;
		int offsetY;

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public TitleLabel(){
			initialise();
		}
		
		private void initialise(){
			this.setBounds(0, 0, 1280,30);
			this.setBackground(Color.black);
			this.setOpaque(true);
			this.addMouseMotionListener(new  MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
					frame.setLocation(e.getXOnScreen()-offsetX, e.getYOnScreen()-offsetY);
				}
			});
			
			this.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					frame = Mainframe.getFrame();
					offsetX = e.getX();
					offsetY = e.getY();
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
			setClose();
			setMin();
		}
		
		private void setClose(){
			JLabel closeLabel = new JLabel("X");
			closeLabel.setOpaque(true);
			closeLabel.setHorizontalAlignment(JLabel.CENTER);
			closeLabel.setBackground(new Color(100, 30, 40));
			closeLabel.setBounds(1240, 0, 40, 30);
			closeLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
			closeLabel.setForeground(Color.white);
			closeLabel.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					Mainframe.getFrame().dispose();;
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					closeLabel.setBackground(new Color(100, 30, 40));
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					closeLabel.setBackground(new Color(200, 60, 70));
					
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			this.add(closeLabel);
		}
		
		private void setMin(){
			JLabel minLabel = new JLabel("-");
			minLabel.setBounds(1200, 0, 40, 30);
			minLabel.setHorizontalAlignment(JLabel.CENTER);
			minLabel.setBackground(new Color(50, 50, 80));
			minLabel.setOpaque(true);
			minLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
			minLabel.setForeground(Color.white);
			minLabel.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					Mainframe.getFrame().setExtendedState(JFrame.ICONIFIED);
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					minLabel.setBackground(new Color(50, 50, 80));
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					minLabel.setBackground(new Color(80, 80, 160));
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
				}
			});
			this.add(minLabel);
			
		}
	}
}

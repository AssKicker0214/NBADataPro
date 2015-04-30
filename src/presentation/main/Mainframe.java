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

import ui.floatui.FloatPane;
import ui.floatui.IMainFrameSize;
import ui.statistics.playerKing.PlayerKingPanel;
import ui.statistics.teamKing.TeamKingPanel;

public class Mainframe extends JFrame implements IMainFrame, IMainFrameSize{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLayeredPane layer;
	
	JPanel playerKing;
	JPanel teamKing;
	ArrayList<JPanel> mainParts = new ArrayList<JPanel>();
	
	public  Mainframe(){ 
		layer = this.getLayeredPane();
	
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
	//设置最上层,用来承载弹出的子选项
	private void setFrontLayer(){
		
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
		
		mainParts.add(playerKing);
		mainParts.add(teamKing);
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
		Mainframe mf = new Mainframe();
	}


	@Override
	public void update(String s) {
		// TODO Auto-generated method stub
		switch(s){
			case "热点球员": changeMainPart(playerKing); System.out.println(s);break;
			case "热点球队": changeMainPart(teamKing);break;
			case "进步球员": break;
			default: break;
		}
	}


	@Override
	public Dimension getMainFrameSize() {
		// TODO Auto-generated method stub
		System.out.println(this.getSize());
		return this.getSize();
	}

}

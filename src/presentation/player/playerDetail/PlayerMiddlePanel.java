package presentation.player.playerDetail;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.SelectLabel;

public class PlayerMiddlePanel extends JPanel{

	/**
	 * 是playerDetailFrame下最大的Panel
	 */
	private static final long serialVersionUID = 1L;

	SelectLabel ContrastLabel;//联盟对比
	SelectLabel LatestMatchLabel;//近5场比赛
	SelectLabel PastLabel;//过往查询
	SelectLabel ComparePalyersLabel;//球员对比
		
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
	
	PlayerMiddle_ContrastLeaguePanel contrastPanel;

	JPanel playerDetailTopPanel;

	
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();
	
	
	public PlayerMiddlePanel(){
		this.setLayout(null);
		this.setBounds(0, 35, 1280,670);
		this.setBackground(Color.WHITE);
		setTopPanel();
		setContrastLabel();
		setLatestMatchLabel();
		setPastLabel();
		setComparePalyersLabel();
	}
	
	public void setSelectedGroups(SelectLabel s){
		selectLabelGroups.clear();
		selectLabelGroups.add(ContrastLabel);
		selectLabelGroups.add(LatestMatchLabel);
		selectLabelGroups.add(PastLabel);
		selectLabelGroups.add(ComparePalyersLabel);
		for(SelectLabel sl : selectLabelGroups){
			if(sl != s){
				sl.setBackground(Color.black);;
			}
		}
	}
	
	
	public void setTopPanel (){
		playerDetailTopPanel = new PlayerDetailTopPanel();
		this.add(playerDetailTopPanel);
	}
	
	public void setContrastLabel(){
		Point location = new Point(0,200);
		Point size = new Point(320,50);
		ContrastLabel = new SelectLabel("资料",location,size);
		ContrastLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setSelectedGroups(ContrastLabel);
				setVisible(false);
//				remove(contrastPanel);
				setContrastPanel();
				setVisible(true);
				repaint();
			}
		});
		this.add(ContrastLabel);
	}
	
	public void setLatestMatchLabel(){
		Point location = new Point(321,200);
		Point size = new Point(320,50);
		LatestMatchLabel = new SelectLabel("近5场比赛查询",location,size);

		LatestMatchLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setSelectedGroups(LatestMatchLabel);
			}
		});

		this.add(LatestMatchLabel);
	}

	public void setPastLabel(){
		Point location = new Point(642,200);
		Point size = new Point(320,50);
		PastLabel = new SelectLabel("过往查询",location,size);
		PastLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setSelectedGroups(PastLabel);
				
			}
		});

		this.add(PastLabel);
	}

	public void setComparePalyersLabel(){
		
		Point location = new Point(964,200);
		Point size = new Point(320,50);
		ComparePalyersLabel = new SelectLabel("球员对比",location,size);
		ComparePalyersLabel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				setSelectedGroups(ComparePalyersLabel);
			}
			
		});
		this.add(ComparePalyersLabel);
	}

	public void setContrastPanel(){
		contrastPanel = new PlayerMiddle_ContrastLeaguePanel();
		this.add(contrastPanel);
		repaint();
	}
	

	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new PlayerMiddlePanel());
		jf.setVisible(true);
	}
	
}

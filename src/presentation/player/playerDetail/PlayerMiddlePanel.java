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
	PlayerMiddle_SeasonDataPanel seasonDataPanel;
	PlayerMiddle_Recent5Match recent5MatchPanel;
	PlayerMiddle_PastPanel pastPanel;

	JPanel playerDetailTopPanel;

	
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();
	
	
	public PlayerMiddlePanel(ArrayList<Double> player,ArrayList<Double> leagueAvg,
									ArrayList<String> avg,ArrayList<String> total){
		this.setLayout(null);
		this.setBounds(0, 35, 1280,670);
		this.setBackground(Color.WHITE);
		setTopPanel();
		setContrastLabel(player,leagueAvg,avg,total);
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
				sl.setBackground(Color.black);
				sl.isSelected = false;
			}
		}
	}
	
	
	public void setTopPanel (){
		playerDetailTopPanel = new PlayerDetailTopPanel();
		this.add(playerDetailTopPanel);
	}
	
	public void setContrastLabel(ArrayList<Double> player,ArrayList<Double> leagueAvg,
			ArrayList<String> avg,ArrayList<String> total){
		Point location = new Point(0,200);
		Point size = new Point(320,50);
		ContrastLabel = new SelectLabel("资料",location,size);
		ContrastLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setSelectedGroups(ContrastLabel);
				setVisible(false);
				if(contrastPanel != null){
					remove(contrastPanel);
				}
				setContrastPanel(player,leagueAvg);
				setSeasonPanel(avg,total);
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
				setVisible(false);
				if(recent5MatchPanel != null){
					remove(recent5MatchPanel);
				}
				setRecent5MatchPanel();
				setVisible(true);
				repaint();
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
				setVisible(false);
				if(pastPanel != null){
					remove(pastPanel);
				}
				setPastPanel();
				setVisible(true);
				repaint();
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

	public void setContrastPanel(ArrayList<Double> player,ArrayList<Double> leagueAvg){
		contrastPanel = new PlayerMiddle_ContrastLeaguePanel(player,leagueAvg);
		this.add(contrastPanel,0);
		repaint();
	}
	
	public void setSeasonPanel(ArrayList<String> avg,ArrayList<String> total){
		seasonDataPanel = new PlayerMiddle_SeasonDataPanel(avg, total);
		this.add(seasonDataPanel,0);
		repaint();
	}
	
	public void setRecent5MatchPanel(){
		recent5MatchPanel = new PlayerMiddle_Recent5Match();
		this.add(recent5MatchPanel,0);
		repaint();
	}

	public void setPastPanel(){
		pastPanel = new PlayerMiddle_PastPanel();
		this.add(pastPanel,0);
		repaint();
	}

	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		ArrayList<Double> player = new ArrayList<Double>();
		ArrayList<Double> leagueAvg = new ArrayList<Double>();
		ArrayList<String> avg = new ArrayList<String>();
		ArrayList<String> total = new ArrayList<String>();
		player.add(20.5);leagueAvg.add(30.7);
		player.add(20.5);leagueAvg.add(30.7);
		player.add(20.5);leagueAvg.add(30.7);
		player.add(20.5);leagueAvg.add(30.7);
		player.add(20.5);leagueAvg.add(30.7);
		
		for(int i = 0; i < 16 ; i++){
			avg.add("11.11");
		}
		for(int i = 0; i < 16 ; i++){
			total.add("22.11");
		}

		
		jf.add(new PlayerMiddlePanel(player,leagueAvg,avg,total));
		jf.setVisible(true);
	}
	
}

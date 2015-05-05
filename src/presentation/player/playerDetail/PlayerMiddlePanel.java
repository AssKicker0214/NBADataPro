package presentation.player.playerDetail;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataservice.player.PlayerDataService;
import dataservice.player.PlayerData_stub;
import presentation.common.SelectLabel;
import presentation.player.vs.VSContentPanel;
import presentation.player.vs.PlayersVSTopPanel;
import vo.playervo.PlayerVO;

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
	
	JLabel chooseList;
	String message;
	
	Color darkest = new Color(29,72,121);
	
	PlayerMiddle_ContrastLeaguePanel contrastPanel;
	PlayerMiddle_SeasonDataPanel seasonDataPanel;
	PlayerMiddle_Recent5Match recent5MatchPanel;
	PlayerMiddle_PastPanel pastPanel;
	VSContentPanel vsContentPanel;
	
	PlayersVSTopPanel vsTopPanel;
	JPanel playerDetailTopPanel;
	
	PlayerVO vo;
	
	ArrayList<Double> player = new ArrayList<Double>();
	ArrayList<Double> leagueAvg = new ArrayList<Double>();
	ArrayList<String> avg = new ArrayList<String>();
	ArrayList<String> total = new ArrayList<String>();
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();
	
	
	public PlayerMiddlePanel(String name){
		this.setLayout(null);
		this.setBounds(0, 35, 1280,670);
		this.setBackground(Color.WHITE);
		setAttri(name);
		setContrastLabel();
		setLatestMatchLabel();
		setPastLabel();
		setComparePalyersLabel();
		
		setContrastPanel();
		setSeasonPanel();
		ContrastLabel.setBackground(Color.GRAY);
	}
	
	public void setAttri(String name){
		PlayerDataService pds = new PlayerData_stub();
		PlayerVO voL = pds.avgLeague(); 
		PlayerVO voP = pds.findPlayerData(name); 
		vo = voP;
		setTopPanel(voP);
		player.add(voP.avgPoint);player.add(voP.avgRebound);player.add(voP.avgAssist);
		player.add(voP.three);player.add(voP.penalty);
		leagueAvg.add(voL.avgPoint);leagueAvg.add(voL.avgRebound);leagueAvg.add(voL.avgAssist);
		leagueAvg.add(voL.three);leagueAvg.add(voL.penalty);
		//"年度","球队","场数","先发","分钟","％","三分％","罚球％",
		//"进攻","防守","场均篮板","场均助攻","场均抢断","场均盖帽","失误","犯规","场均得分"
		avg.add("2012-2013");avg.add(voP.team);avg.add(voP.numOfGame+"");avg.add(voP.start+"");avg.add(voP.avgMinute+"");avg.add(voP.shot+"");avg.add(voP.three+"");
		avg.add(voP.penalty+"");avg.add(voP.avgOffend+"");avg.add(voP.avgDefend+"");avg.add(voP.avgRebound+"");avg.add(voP.avgAssist+"");avg.add(voP.avgSteal+"");
		avg.add(voP.avgBlockShot+"");avg.add(voP.avgFault+"");avg.add(voP.avgFoul+"");avg.add(voP.avgPoint+"");
		total.add("2012-2013");total.add(voP.team);total.add(voP.numOfGame+"");total.add(voP.start+"");total.add(voP.minute+"");total.add(voP.shot+"");total.add(voP.three+"");
		total.add(voP.penalty+"");total.add(voP.offend+"");total.add(voP.defend+"");total.add(voP.rebound+"");total.add(voP.assist+"");total.add(voP.steal+"");
		total.add(voP.blockShot+"");total.add(voP.fault+"");total.add(voP.foul+"");total.add(voP.point+"");

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
	
	
	public void setTopPanel (PlayerVO vo){
		playerDetailTopPanel = new PlayerDetailTopPanel(vo);
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
				if(contrastPanel != null){
					remove(contrastPanel);
				}
				if(pastPanel != null){
					remove(pastPanel);
				}
				if(recent5MatchPanel != null){
					remove(recent5MatchPanel);
				}
				if(vsContentPanel != null){
					remove(vsContentPanel);
				}
				if(seasonDataPanel != null){
					remove(seasonDataPanel);
				}
				if(vsTopPanel != null){
					remove(vsTopPanel);
				}
				if(playerDetailTopPanel != null){
					remove(playerDetailTopPanel);
					setTopPanel(vo);
				}else{
					setTopPanel(vo);
				}
				
				setContrastPanel();
				setSeasonPanel();
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
				if(contrastPanel != null){
					remove(contrastPanel);
				}
				if(pastPanel != null){
					remove(pastPanel);
				}
				if(recent5MatchPanel != null){
					remove(recent5MatchPanel);
				}
				if(vsContentPanel != null){
					remove(vsContentPanel);
				}
				if(seasonDataPanel != null){
					remove(seasonDataPanel);
				}
				if(vsTopPanel != null){
					remove(vsTopPanel);
				}
				if(playerDetailTopPanel != null){
					remove(playerDetailTopPanel);
					setTopPanel(vo);
				}else{
					setTopPanel(vo);
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
				if(contrastPanel != null){
					remove(contrastPanel);
				}
				if(pastPanel != null){
					remove(pastPanel);
				}
				if(recent5MatchPanel != null){
					remove(recent5MatchPanel);
				}
				if(vsContentPanel != null){
					remove(vsContentPanel);
				}
				if(seasonDataPanel != null){
					remove(seasonDataPanel);
				}
				if(vsTopPanel != null){
					remove(vsTopPanel);
				}
				if(playerDetailTopPanel != null){
					remove(playerDetailTopPanel);
					setTopPanel(vo);
				}else{
					setTopPanel(vo);
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
				setVisible(false);
				if(contrastPanel != null){
					remove(contrastPanel);
				}
				if(pastPanel != null){
					remove(pastPanel);
				}
				if(recent5MatchPanel != null){
					remove(recent5MatchPanel);
				}
				if(vsContentPanel != null){
					remove(vsContentPanel);
				}
				if(seasonDataPanel != null){
					remove(seasonDataPanel);
				}
				if(playerDetailTopPanel != null){
					remove(playerDetailTopPanel);
				}
				if(vsTopPanel != null){
					remove(vsTopPanel);
					setVSTopPanel(PlayerMiddlePanel.this); 
				}else{
					setVSTopPanel(PlayerMiddlePanel.this); 
				}
				setVSPanel();
				setVisible(true);
				repaint();
			}
			
		});
		this.add(ComparePalyersLabel);
	}

	public void setContrastPanel(){
		contrastPanel = new PlayerMiddle_ContrastLeaguePanel(player,leagueAvg);
		this.add(contrastPanel);
		repaint();
	}
	
	public void setSeasonPanel(){
		seasonDataPanel = new PlayerMiddle_SeasonDataPanel(avg, total);
		this.add(seasonDataPanel);
		repaint();
	}
	
	public void setRecent5MatchPanel(){
		recent5MatchPanel = new PlayerMiddle_Recent5Match(vo.name);
		this.add(recent5MatchPanel);
		repaint();
	}

	public void setPastPanel(){
		pastPanel = new PlayerMiddle_PastPanel(vo.name);
		this.add(pastPanel);
		repaint();
	}
	
	public void setVSPanel(){
		//
		ArrayList<String> itemsNeedAdd = new ArrayList<String>();
		ArrayList<Double> avg1 = new ArrayList<Double>();
		ArrayList<Double> avg2 = new ArrayList<Double>();
		
		itemsNeedAdd.add("场均得分"); avg1.add(5.9); avg2.add(10.043);
		itemsNeedAdd.add("场均助攻"); avg1.add(1.0); avg2.add(2.159);
		itemsNeedAdd.add("场均篮板"); avg1.add(4.4); avg2.add(4.469);
		itemsNeedAdd.add("三分％"); 	avg1.add(30.0); avg2.add(34.5);
		itemsNeedAdd.add("罚球％");	avg1.add(78.4); avg2.add(74.3);
		//
		vsContentPanel = new VSContentPanel(itemsNeedAdd,avg1,avg2);
		this.add(vsContentPanel);
		repaint();
	}
	
	
	public void setVSTopPanel(JPanel middle){
		vsTopPanel = new PlayersVSTopPanel(middle);
		this.add(vsTopPanel);
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

		
		jf.add(new PlayerMiddlePanel("Aaron Gray"));
		jf.setVisible(true);
	}
	
}

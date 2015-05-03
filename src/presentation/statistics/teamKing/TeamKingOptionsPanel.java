package presentation.statistics.teamKing;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dataservice.team.TeamDataService;
import dataservice.team.TeamData_stub;
import presentation.common.SelectLabel;

public class TeamKingOptionsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	SelectLabel FildScoreButton;//得分
	SelectLabel REBButton;//篮板
	SelectLabel AssitButton;//助攻
	SelectLabel BSButton;//盖帽
	SelectLabel TPSPButton;//抢断
	SelectLabel StealButton;//三分％
	SelectLabel FGPButton;//命中率
	SelectLabel FTPButton;//罚球％

	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();

	TeamKingContentPanel teamKingContentPanel;

	public TeamKingOptionsPanel(){
		this.setLayout(null);
		this.setBounds(0, 105,1130,430);
		this.setBackground(Color.WHITE);
		setFildScoreButton();
		setREBButton();
		setAssitButton();
		setBSButton();
		setTPSPButton();
		setStealButton();
		setFGPButton();
		setFTPButton();
		setTeamKingContentPanel("avgPoint");
	}
	
	public void setOptionsSelectedGroups(SelectLabel s){
		selectLabelGroups.add(FildScoreButton);
		selectLabelGroups.add(REBButton);
		selectLabelGroups.add(AssitButton);
		selectLabelGroups.add(BSButton);
		selectLabelGroups.add(TPSPButton);
		selectLabelGroups.add(StealButton);
		selectLabelGroups.add(FGPButton);
		selectLabelGroups.add(FTPButton);

		for(SelectLabel sl : selectLabelGroups){
			if(sl != s){
				sl.setBackground(Color.black);;
			}
		}
	
	}

	public void setTeamKingContentPanel(String sortBy){
		TeamDataService tds = new TeamData_stub();
		teamKingContentPanel = new TeamKingContentPanel(tds.hotTeams(5, sortBy));
		this.add(teamKingContentPanel);
		repaint();
	}

	
	public void setFildScoreButton(){
		Point location = new Point(0,0);
		Point size = new Point(140,50);
		FildScoreButton = new SelectLabel("得分",location,size);

		FildScoreButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(FildScoreButton);
				remove(teamKingContentPanel);
				setVisible(false);
				setTeamKingContentPanel("avgPoint");
				setVisible(true);
				repaint();
			}
		});

		this.add(FildScoreButton);
	}
	
	public void setREBButton(){
		Point location = new Point(141,0);
		Point size = new Point(140,50);
		REBButton = new SelectLabel("篮板",location,size);

		REBButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(REBButton);
				remove(teamKingContentPanel);
				setVisible(false);
				setTeamKingContentPanel("avgRebound");
				setVisible(true);
				repaint();
			}
		});

		this.add(REBButton);
	}
	
	public void setAssitButton(){
		Point location = new Point(282,0);
		Point size = new Point(140,50);
		AssitButton = new SelectLabel("助攻",location,size);

		AssitButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(AssitButton);
				remove(teamKingContentPanel);
				setVisible(false);
				setTeamKingContentPanel("avgAssist");
				setVisible(true);
				repaint();
			}
		});

		this.add(AssitButton);
	}
	
	public void setBSButton(){
		Point location = new Point(423,0);
		Point size = new Point(140,50);
		BSButton = new SelectLabel("盖帽",location,size);

		BSButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(BSButton);
				remove(teamKingContentPanel);
				setVisible(false);
				setTeamKingContentPanel("avgBlockShot");
				setVisible(true);
				repaint();
			}
		});

		this.add(BSButton);
	}

	public void setTPSPButton(){
		Point location = new Point(564,0);
		Point size = new Point(140,50);
		TPSPButton = new SelectLabel("抢断",location,size);

		TPSPButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(TPSPButton);
				remove(teamKingContentPanel);
				setVisible(false);
				setTeamKingContentPanel("avgSteal");
				setVisible(true);
				repaint();
			}
		});

		this.add(TPSPButton);
	}

	public void setStealButton(){
		Point location = new Point(705,0);
		Point size = new Point(140,50);
		StealButton = new SelectLabel("三分％",location,size);

		StealButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(StealButton);
				remove(teamKingContentPanel);
				setVisible(false);
				setTeamKingContentPanel("three");
				setVisible(true);
				repaint();
			}
		});

		this.add(StealButton);
	}

	public void setFGPButton(){
		Point location = new Point(846,0);
		Point size = new Point(140,50);
		FGPButton = new SelectLabel("%",location,size);

		FGPButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(FGPButton);
				remove(teamKingContentPanel);
				setVisible(false);
				setTeamKingContentPanel("shot");
				setVisible(true);
				repaint();
			}
		});

		this.add(FGPButton);
	}

	public void setFTPButton(){
		Point location = new Point(987,0);
		Point size = new Point(140,50);
		FTPButton = new SelectLabel("罚球％",location,size);

		FTPButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(FTPButton);
				remove(teamKingContentPanel);
				setVisible(false);
				setTeamKingContentPanel("penalty");
				setVisible(true);
				repaint();
			}
		});

		this.add(FTPButton);
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new TeamKingOptionsPanel());
		jf.setVisible(true);
	}

	

	
		
}

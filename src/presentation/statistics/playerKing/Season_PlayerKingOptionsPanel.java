package presentation.statistics.playerKing;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dataservice.player.PlayerDataService;
import dataservice.player.PlayerData_stub;
import presentation.common.SelectLabel;

public class Season_PlayerKingOptionsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	SelectLabel AvgFildScoreButton;//场均得分
	SelectLabel AvgREBButton;//场均篮板
	SelectLabel AvgAssitButton;//场均助攻
	SelectLabel AvgBSButton;//场均盖帽
	SelectLabel TPSPButton;//场均抢断
	SelectLabel AvgStealButton;//三分％
	SelectLabel FGPButton;//命中率
	SelectLabel FTPButton;//罚球％
	
	
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();

	PlayerKingContentPanel playerKingContentPanel;
	
	public Season_PlayerKingOptionsPanel(){
		this.setLayout(null);
		this.setBounds(0, 105,1130,430);
		this.setBackground(Color.WHITE);
		setAvgFildScoreButton();
		setAvgREBButton();
		setAvgAssitButton();
		setAvgBSButton();
		setTPSPButton();
		setAvgStealButton();
		setFGPButton();
		setFTPButton();
		setPlayerKingContentPanel("avgPoint");
	}
		
	public void setOptionsSelectedGroups(SelectLabel s){
		selectLabelGroups.add(AvgFildScoreButton);
		selectLabelGroups.add(AvgREBButton);
		selectLabelGroups.add(AvgAssitButton);
		selectLabelGroups.add(AvgBSButton);
		selectLabelGroups.add(TPSPButton);
		selectLabelGroups.add(AvgStealButton);
		selectLabelGroups.add(FGPButton);
		selectLabelGroups.add(FTPButton);

		for(SelectLabel sl : selectLabelGroups){
			if(sl != s){
				sl.setBackground(Color.black);;
			}
		}
	
	}

	
	public void setPlayerKingContentPanel(String sortBy){
		PlayerDataService pds = new PlayerData_stub();
		playerKingContentPanel = new PlayerKingContentPanel(pds.SeasonKing(5, sortBy));		
		this.add(playerKingContentPanel);
		repaint();
	}

	public void setAvgFildScoreButton(){
		Point location = new Point(0,0);
		Point size = new Point(140,50);
		AvgFildScoreButton = new SelectLabel("场均得分",location,size);

		AvgFildScoreButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(AvgFildScoreButton);
				remove(playerKingContentPanel);
				setVisible(false);
				setPlayerKingContentPanel("avgPoint");
				setVisible(true);
				repaint();
			}
		});

		this.add(AvgFildScoreButton);
	}

	public void setAvgREBButton(){
		Point location = new Point(141,0);
		Point size = new Point(140,50);
		AvgREBButton = new SelectLabel("场均篮板",location,size);

		AvgREBButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(AvgREBButton);
				remove(playerKingContentPanel);
				setVisible(false);
				setPlayerKingContentPanel("avgRebound");
				setVisible(true);
				repaint();
			}
		});

		this.add(AvgREBButton);
	}
	
	public void setAvgAssitButton(){
		Point location = new Point(282,0);
		Point size = new Point(140,50);
		AvgAssitButton = new SelectLabel("场均助攻",location,size);

		AvgAssitButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(AvgAssitButton);
				remove(playerKingContentPanel);
				setVisible(false);
				setPlayerKingContentPanel("avgAssist");
				setVisible(true);
				repaint();
			}
		});

		this.add(AvgAssitButton);
	}
	
	public void setAvgBSButton(){
		Point location = new Point(423,0);
		Point size = new Point(140,50);
		AvgBSButton = new SelectLabel("场均盖帽",location,size);

		AvgBSButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(AvgBSButton);
				remove(playerKingContentPanel);
				setVisible(false);
				setPlayerKingContentPanel("avgBlockShot");
				setVisible(true);
				repaint();
			}
		});

		this.add(AvgBSButton);
	}
	
	public void setTPSPButton(){
		Point location = new Point(564,0);
		Point size = new Point(140,50);
		TPSPButton = new SelectLabel("场均抢断",location,size);

		TPSPButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(TPSPButton);
				remove(playerKingContentPanel);
				setVisible(false);
				setPlayerKingContentPanel("avgSteal");
				setVisible(true);
				repaint();
			}
		});

		this.add(TPSPButton);
	}
	
	public void setAvgStealButton(){
		Point location = new Point(705,0);
		Point size = new Point(140,50);
		AvgStealButton = new SelectLabel("三分％",location,size);

		AvgStealButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(AvgStealButton);
				remove(playerKingContentPanel);
				setVisible(false);
				setPlayerKingContentPanel("three");
				setVisible(true);
				repaint();
			}
		});

		this.add(AvgStealButton);
	}
	

	public void setFGPButton(){
		Point location = new Point(846,0);
		Point size = new Point(140,50);
		FGPButton = new SelectLabel("%",location,size);

		FGPButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(FGPButton);
				remove(playerKingContentPanel);
				setVisible(false);
				setPlayerKingContentPanel("shot");
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
				remove(playerKingContentPanel);
				setVisible(false);
				setPlayerKingContentPanel("penalty");
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
		jf.add(new Season_PlayerKingOptionsPanel());
		jf.setVisible(true);
	}



}

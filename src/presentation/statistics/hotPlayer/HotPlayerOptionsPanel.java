package presentation.statistics.hotPlayer;

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

public class HotPlayerOptionsPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	SelectLabel AvgFildScoreButton;//场均得分
	SelectLabel AvgREBButton;//场均篮板
	SelectLabel AvgAssitButton;//场均助攻
	
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();

	HotPlayerContentPanel hotPlayerContentPanel;

	public HotPlayerOptionsPanel(){
		this.setLayout(null);
		this.setBounds(0, 105,1130,430);
		this.setBackground(Color.WHITE);
		setAvgFildScoreButton();
		setAvgREBButton();
		setAvgAssitButton();
		setHotPlayerContentPanel("avgPoint");
	}
	
	public void setOptionsSelectedGroups(SelectLabel s){
		selectLabelGroups.clear();
		selectLabelGroups.add(AvgFildScoreButton);
		selectLabelGroups.add(AvgREBButton);
		selectLabelGroups.add(AvgAssitButton);

		for(SelectLabel sl : selectLabelGroups){
			if(sl != s){
				sl.setBackground(Color.black);
			}
		}
	}
	
	public void setHotPlayerContentPanel(String sortBy){
		PlayerDataService pds = new PlayerData_stub();
		hotPlayerContentPanel = new HotPlayerContentPanel(pds.hotPlayer(5, sortBy));
		this.add(hotPlayerContentPanel);
		repaint();
	}

	
	public void setAvgFildScoreButton(){
		Point location = new Point(0,0);
		Point size = new Point(377,50);
		AvgFildScoreButton = new SelectLabel("场均得分",location,size);

		AvgFildScoreButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(AvgFildScoreButton);
				remove(hotPlayerContentPanel);
				setVisible(false);
				setHotPlayerContentPanel("avgPoint");
				setVisible(true);
				repaint();
			}
		});

		this.add(AvgFildScoreButton);
	}
	
	public void setAvgREBButton(){
		Point location = new Point(378,0);
		Point size = new Point(377,50);
		AvgREBButton = new SelectLabel("场均篮板",location,size);

		AvgREBButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(AvgREBButton);
				remove(hotPlayerContentPanel);
				setVisible(false);
				setHotPlayerContentPanel("avgRebound");
				setVisible(true);
				repaint();
			}
		});

		this.add(AvgREBButton);
	}
	
	public void setAvgAssitButton(){
		Point location = new Point(756,0);
		Point size = new Point(377,50);
		AvgAssitButton = new SelectLabel("场均助攻",location,size);

		AvgAssitButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(AvgAssitButton);
				remove(hotPlayerContentPanel);
				setVisible(false);
				setHotPlayerContentPanel("avgAssist");
				setVisible(true);
				repaint();
			}
		});

		this.add(AvgAssitButton);
	}

	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new HotPlayerOptionsPanel());
		jf.setVisible(true);
	}



}

package presentation.statistics.playerKing;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.common.SelectLabel;

public class EveryDay_PlayerKingOptionsPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	SelectLabel ScoreButton;//得分
	SelectLabel REBButton;//篮板
	SelectLabel AssitButton;//场均助攻
	SelectLabel BSButton;//场均盖帽
	SelectLabel StealButton;//场均抢断
	
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();

	PlayerKingContentPanel playerKingContentPanel;

	public EveryDay_PlayerKingOptionsPanel(){
		this.setLayout(null);
		this.setBounds(0, 105,1130,430);
		this.setBackground(Color.WHITE);
		setScoreButton();
		setREBButton();
		setAssitButton();
		setBSButton();
		setStealButton();
	}
	
	public void setOptionsSelectedGroups(SelectLabel s){
		selectLabelGroups.add(ScoreButton);
		selectLabelGroups.add(REBButton);
		selectLabelGroups.add(AssitButton);
		selectLabelGroups.add(BSButton);
		selectLabelGroups.add(StealButton);

		for(SelectLabel sl : selectLabelGroups){
			if(sl != s){
				sl.setBackground(Color.black);;
			}
		}
	
	}
	
	public void setPlayerKingContentPanel(){
		playerKingContentPanel = new PlayerKingContentPanel();
		this.add(playerKingContentPanel);
		repaint();
	}


	public void setScoreButton(){
		Point location = new Point(0,0);
		Point size = new Point(225,50);
		ScoreButton = new SelectLabel("得分",location,size);

		ScoreButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(ScoreButton);
				setVisible(false);
				setPlayerKingContentPanel();
				setVisible(true);
				repaint();
			}
		});

		this.add(ScoreButton);

	}
	
	public void setREBButton(){
		Point location = new Point(226,0);
		Point size = new Point(225,50);
		REBButton = new SelectLabel("篮板",location,size);

		REBButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(REBButton);
			}
		});

		this.add(REBButton);
	}
	
	public void setAssitButton(){
		Point location = new Point(452,0);
		Point size = new Point(225,50);
		AssitButton = new SelectLabel("助攻",location,size);

		AssitButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(AssitButton);
			}
		});

		this.add(AssitButton);

	}
	public void setBSButton(){
		Point location = new Point(678,0);
		Point size = new Point(225,50);
		BSButton = new SelectLabel("盖帽",location,size);

		BSButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(BSButton);
			}
		});

		this.add(BSButton);

	}
	
	public void setStealButton(){
		Point location = new Point(904,0);
		Point size = new Point(225,50);
		StealButton = new SelectLabel("抢断",location,size);

		StealButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setOptionsSelectedGroups(StealButton);
			}
		});

		this.add(StealButton);

	}

	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new EveryDay_PlayerKingOptionsPanel());
		jf.setVisible(true);
	}


	
	
}

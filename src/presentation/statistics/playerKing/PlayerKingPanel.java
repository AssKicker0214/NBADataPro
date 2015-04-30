package presentation.statistics.playerKing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.common.SelectLabel;

public class PlayerKingPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel TitleLabel;
	JLabel ButtonsBGLabel;
	
	public SelectLabel everyDayButton;//每日
	public SelectLabel seasonButton;//赛季
	
	Color entered = new Color(30,80,140);
	Color pressed = new Color(42,109,183);
	Color exicted= new Color(26,70,122);

	Season_PlayerKingOptionsPanel season_PlayerKingOptionsPanel;
	EveryDay_PlayerKingOptionsPanel everyDay_PlayerKingOptionsPanel;
	
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();
	
	public PlayerKingPanel(){
		this.setLayout(null);
		this.setBounds(150, 155,1130,600);
		this.setBackground(Color.WHITE);
		setTitle(" 每日  联盟球员数据王");
		setButtonsBGLabel();
		everyDayButton.setBackground(pressed);
		setEveryDay_PlayerKingOptionsPanel();
		setSeason_PlayerKingOptionsPanel();
		season_PlayerKingOptionsPanel.setVisible(false);
		everyDay_PlayerKingOptionsPanel.setVisible(true);
	}
	
	public void setSelectedGroups(SelectLabel s){
		selectLabelGroups.clear();
		selectLabelGroups.add(everyDayButton);
		selectLabelGroups.add(seasonButton);
		for(SelectLabel sl : selectLabelGroups){
			if(sl != s){
				sl.setBackground(exicted);;
			}
		}
	
	}

	
	public void setTitle(String text){
		
		TitleLabel = new JLabel(text,JLabel.LEADING);
		TitleLabel.setFont(new Font("Dialog",1,25));
		TitleLabel.setForeground(Color.WHITE);
		TitleLabel.setBackground(entered);
		TitleLabel.setOpaque(true);
		TitleLabel.setBounds(0,0,1130,100);
		this.add(TitleLabel);
		this.updateUI();
		//new Color(33,82,138)
	}
	
	public void setEveryDayButton(){
		Point p1 = new Point(5,5);
		Point p2 = new Point(50,50);
		everyDayButton = new SelectLabel("每日",p1,p2,entered,pressed,exicted);
		everyDayButton.setForeground(Color.WHITE);
		everyDayButton.setBackground(exicted);
		everyDayButton.setOpaque(true);
		everyDayButton.addMouseListener(new EveryDayButtonListener());
		ButtonsBGLabel.add(everyDayButton);
	}
	
	class EveryDayButtonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			PlayerKingPanel.this.remove(TitleLabel);
			setVisible(false);
			setTitle(" 每日  联盟球员数据王");
			setButtonsBGLabel();
			everyDayButton.isSelected = true;
			everyDayButton.setBackground(pressed);
			setSelectedGroups(everyDayButton);
			setEveryDay_PlayerKingOptionsPanel();
			
			season_PlayerKingOptionsPanel.setVisible(false);
			everyDay_PlayerKingOptionsPanel.setVisible(true);

			
			setVisible(true);
			repaint();	
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}

	
		
	}

	public void setSeasonButton(){
		Point p1 = new Point(60,5);
		Point p2 = new Point(50,50);
		seasonButton = new SelectLabel("赛季",p1,p2,entered,pressed,exicted);
		seasonButton.setForeground(Color.WHITE);
		seasonButton.setBackground(exicted);
		seasonButton.addMouseListener(new SeasonButtonListener());
		ButtonsBGLabel.add(seasonButton);
	}

	
	public class SeasonButtonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			PlayerKingPanel.this.remove(TitleLabel);
			PlayerKingPanel.this.remove(everyDay_PlayerKingOptionsPanel);

			setVisible(false);
			setTitle(" 赛季  联盟球员数据王");
			setButtonsBGLabel();
			seasonButton.isSelected = true;
			seasonButton.setBackground(pressed);
			setSelectedGroups(seasonButton);
			setSeason_PlayerKingOptionsPanel();
			
			everyDay_PlayerKingOptionsPanel.setVisible(false);
			season_PlayerKingOptionsPanel.setVisible(true);
			
			setVisible(true);
			repaint();	
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public void setButtonsBGLabel(){
		ButtonsBGLabel = new JLabel();
		ButtonsBGLabel.setBackground(exicted);
		ButtonsBGLabel.setOpaque(true);
		ButtonsBGLabel.setBounds(895,20,115,60);
		setEveryDayButton();
		setSeasonButton();
		TitleLabel.add(ButtonsBGLabel,0);
	}

	
	public void setSeason_PlayerKingOptionsPanel(){
		season_PlayerKingOptionsPanel = new Season_PlayerKingOptionsPanel();
		this.add(season_PlayerKingOptionsPanel);
	}
	
	public void setEveryDay_PlayerKingOptionsPanel(){
		everyDay_PlayerKingOptionsPanel = new EveryDay_PlayerKingOptionsPanel();
		this.add(everyDay_PlayerKingOptionsPanel);
	}

	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new PlayerKingPanel());
		jf.setVisible(true);
	}


	
}

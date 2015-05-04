package presentation.match;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.PhotoLabel;
import presentation.common.SelectLabel;
import presentation.player.PlayerDataList;
import presentation.table.TablePane;

public class MatchDataAnalysePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel TitleLabel;
	JLabel ButtonsBGLabel;
	JLabel teamLabel;
	
	public SelectLabel fstPageButton;//信息
	public SelectLabel secPageButton;//普通数据

	Color entered = new Color(30,80,140);
	Color pressed = new Color(42,109,183);
	Color exicted= new Color(26,70,122);

	TablePane InfoTable;

	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();

	public MatchDataAnalysePanel(){
		this.setLayout(null);
		this.setBounds(0,212,1280,540);
		this.setBackground(Color.WHITE);
		setTitle();
		setButtonsBGLabel();
		setTeamLabel("亚特兰大 老鹰","teamsPNG/ATL.png");
		setInfoTablePanel();
//		setButtonsBGLabel();
//		basicInfoButton.setBackground(pressed);
//		setBasicInfoTablePanel();
	}
	
	public void setSelectedGroups(SelectLabel s){
		selectLabelGroups.clear();
		selectLabelGroups.add(fstPageButton);
		selectLabelGroups.add(secPageButton);
		for(SelectLabel sl : selectLabelGroups){
			if(sl != s){
				sl.setBackground(exicted);;
			}
		}
	}

	public void setTitle(){
		TitleLabel = new JLabel(" 技术统计",JLabel.LEADING);
		TitleLabel.setFont(new Font("Dialog",1,20));
		TitleLabel.setForeground(Color.WHITE);
		TitleLabel.setBackground(entered);
		TitleLabel.setOpaque(true);
		TitleLabel.setBounds(0,0,1280,40);
		this.add(TitleLabel);
		this.updateUI();
	}
	
	public void setTeamLabel(String teamName,String photo){
		teamLabel = new JLabel();
		teamLabel.setLayout(null);
		teamLabel.setBounds(0,40,1280,60);
		teamLabel.setBackground(Color.WHITE);

		JLabel TeamPhotoLabel = new PhotoLabel(new ImageIcon(photo).getImage());
		TeamPhotoLabel.setBounds(20,0,100,60);
		TeamPhotoLabel.setBackground(Color.WHITE);
		TeamPhotoLabel.setOpaque(true);
		TeamPhotoLabel.setVisible(true);
		teamLabel.add(TeamPhotoLabel);
		
		JLabel TeamNameLabel = new JLabel(teamName,JLabel.CENTER);
		TeamNameLabel.setFont(new Font("Dialog",1,20));
		TeamNameLabel.setBounds(100,0,200,60);
		TeamNameLabel.setForeground(Color.DARK_GRAY);
		TeamNameLabel.setBackground(Color.WHITE);
		TeamNameLabel.setOpaque(true);
		TeamNameLabel.setVisible(true);
		teamLabel.add(TeamNameLabel);
		
		this.add(teamLabel);
	}
	
	public void setFstPageButton(){
		Point p1 = new Point(5,5);
		Point p2 = new Point(40,20);
		fstPageButton = new SelectLabel("1",p1,p2,entered,pressed,exicted);
		fstPageButton.setForeground(Color.WHITE);
		fstPageButton.setBackground(exicted);
		fstPageButton.setOpaque(true);
		fstPageButton.addMouseListener(new FstPageButtonListener());
		ButtonsBGLabel.add(fstPageButton);
	}
	
	class FstPageButtonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
			setButtonsBGLabel();
			fstPageButton.isSelected = true;
			fstPageButton.setBackground(pressed);
			setSelectedGroups(fstPageButton);
			if(InfoTable!=null){
				MatchDataAnalysePanel.this.remove(InfoTable);
			}
			setInfoTablePanel(); 
			if(teamLabel!=null){
				MatchDataAnalysePanel.this.remove(teamLabel);
			}
			setTeamLabel();
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

	public void setSecPageButton(){
		Point p1 = new Point(50,5);
		Point p2 = new Point(40,20);
		secPageButton = new SelectLabel("2",p1,p2,entered,pressed,exicted);
		secPageButton.setForeground(Color.WHITE);
		secPageButton.setBackground(exicted);
		secPageButton.setOpaque(true);
		secPageButton.addMouseListener(new SecPageButtonListener());
		ButtonsBGLabel.add(secPageButton);
	}
	
	public class SecPageButtonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
		ButtonsBGLabel.setBounds(1105,5,95,30);
		setFstPageButton();
		setSecPageButton();
		TitleLabel.add(ButtonsBGLabel,0);
	}
	
	public void setInfoTablePanel(){
//		sortParam s = new sortParam("point",true);
//		ArrayList<sortParam> sortBy = new ArrayList<sortParam>();
//		sortBy.add(s);
//		ArrayList<PlayerVO> vo = pds.sortPlayerInfo(sortBy);
//		PlayerVO2List v2l = new PlayerVO2List();
//		ArrayList<ArrayList<String>> datas = v2l.basicInfo(vo);
		
		ArrayList<String> l = new ArrayList<String>();
		for(int i =0;i<21;i++){
			l.add("20.0");
		}
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		for(int i = 0;i<20;i++){
			datas.add(l);
		}
			
		String[] header = {"姓名","位置","分钟","％","命中","出手","三分％","三分命中","三分出手",
				"罚球％","罚球命中","罚球出手","进攻","防守","篮板","助攻","犯规","抢断","失误","盖帽","得分"};
		ArrayList<Integer> wid = new ArrayList<Integer>();
		wid.add(50);wid.add(50);
		wid.add(60);wid.add(60);wid.add(60);wid.add(60);
		wid.add(60);wid.add(60);wid.add(60);wid.add(60);
		wid.add(60);wid.add(60);wid.add(60);wid.add(60);
		wid.add(60);wid.add(60);wid.add(60);wid.add(60);
		wid.add(60);wid.add(60);wid.add(60);
		
		InfoTable = new TablePane(datas,header,wid,0,100,1280,355,30,true,false);
		this.add(InfoTable);
	}

	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new MatchDataAnalysePanel());
		jf.setVisible(true);
	}


}

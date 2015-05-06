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
import presentation.table.TablePane;
import presentation.table.playerTablePanel;
import vo.matchvo.MatchContentPlayerVO;

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
	
	ArrayList<MatchContentPlayerVO> home; 
	ArrayList<MatchContentPlayerVO> guest;
	String[] teamInfo = {"","","",""};

	
	public MatchDataAnalysePanel(ArrayList<MatchContentPlayerVO> homeTeamPlayer, ArrayList<MatchContentPlayerVO> guestTeamPlayer, String[] msg){
		this.setLayout(null);
		this.setBounds(0,215,1280,540);
		this.setBackground(Color.WHITE);
		home = homeTeamPlayer;
		guest = guestTeamPlayer;
		teamInfo = msg;
		setTitle();
		setButtonsBGLabel();
		setTeamLabel(teamInfo[0],teamInfo[1]);
		setInfoTablePanel(home);
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
				sl.setBackground(exicted);
				sl.isSelected = false;
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
			setVisible(false);
			setButtonsBGLabel();
			fstPageButton.isSelected = true;
			fstPageButton.setBackground(pressed);
			setSelectedGroups(fstPageButton);
			if(InfoTable!=null){
				MatchDataAnalysePanel.this.remove(InfoTable);
			}
			if(teamLabel!=null){
				MatchDataAnalysePanel.this.remove(teamLabel);
			}
			setTeamLabel(teamInfo[0],teamInfo[1]);
			setInfoTablePanel(home);
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
			setVisible(false);
			setButtonsBGLabel();
			secPageButton.isSelected = true;
			secPageButton.setBackground(pressed);
			setSelectedGroups(secPageButton);
			if(InfoTable!=null){
				MatchDataAnalysePanel.this.remove(InfoTable);
			}
			if(teamLabel!=null){
				MatchDataAnalysePanel.this.remove(teamLabel);
			}
			setTeamLabel(teamInfo[2],teamInfo[3]);
			setInfoTablePanel(guest);
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
		ButtonsBGLabel.setBounds(1105,5,95,30);
		setFstPageButton();
		setSecPageButton();
		TitleLabel.add(ButtonsBGLabel,0);
	}
	
	public void setInfoTablePanel(ArrayList<MatchContentPlayerVO> playersdata){

		String[] columns = {"姓名","日期","","对手","分钟","％","命中","出手","三分％","罚球％",
				"进攻篮板","防守篮板","篮板","助攻","盖帽","失误","犯规","得分"};
				
		MatchVO2List m2l = new MatchVO2List();
		ArrayList<ArrayList<String>> datas = m2l.matchDeitail(playersdata);
		
		ArrayList<Integer> w = new ArrayList<Integer>();
		w.add(100);w.add(150);w.add(0);w.add(150);
		for(int i = 0; i < 14 ; i++){
			w.add(60);
		}
		
		InfoTable = new playerTablePanel(datas,columns,w,0,100,1280,340,30,false,false);
		this.add(InfoTable);
	}

	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
//		jf.add(new MatchDataAnalysePanel());
		jf.setVisible(true);
	}


}

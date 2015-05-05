package presentation.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataservice.player.PlayerDataService;
import dataservice.player.PlayerData_stub;
import dataservice.player.sortParam;
import presentation.common.SelectLabel;
import presentation.table.TablePane;
import vo.playervo.PlayerVO;

public class PlayerDataList  extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel TitleLabel;
	JLabel ButtonsBGLabel;
	
	public SelectLabel basicInfoButton;//信息
	public SelectLabel NormalInfoButton;//普通数据
	public SelectLabel AvgNormalInfoButton;//平均普通数据
	public SelectLabel HighInfoButton;//高阶数据
	
	PlayerDataService pds = new PlayerData_stub();
	
	Color entered = new Color(30,80,140);
	Color pressed = new Color(42,109,183);
	Color exicted= new Color(26,70,122);

	TablePane BasicInfoTable;
	TablePane NormalInfoTable;
	TablePane HighInfoTable;
	
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();
	
	public PlayerDataList(){
		this.setLayout(null);
		this.setBounds(0,155,1280,540);
		this.setBackground(Color.WHITE);
		setTitle();
		setButtonsBGLabel();
		basicInfoButton.setBackground(pressed);
		setBasicInfoTablePanel();
	}
	
	public void setSelectedGroups(SelectLabel s){
		selectLabelGroups.clear();
		selectLabelGroups.add(basicInfoButton);
		selectLabelGroups.add(NormalInfoButton);
		selectLabelGroups.add(AvgNormalInfoButton);
		selectLabelGroups.add(HighInfoButton);
		for(SelectLabel sl : selectLabelGroups){
			if(sl != s){
				sl.setBackground(exicted);;
			}
		}
	}

	public void setTitle(){
		TitleLabel = new JLabel(" 球员列表",JLabel.LEADING);
		TitleLabel.setFont(new Font("Dialog",1,20));
		TitleLabel.setForeground(Color.WHITE);
		TitleLabel.setBackground(entered);
		TitleLabel.setOpaque(true);
		TitleLabel.setBounds(0,0,1280,60);
		this.add(TitleLabel);
		this.updateUI();
	}

	public void setBasicInfoButton(){
		Point p1 = new Point(5,5);
		Point p2 = new Point(40,30);
		basicInfoButton = new SelectLabel("信息",p1,p2,entered,pressed,exicted);
		basicInfoButton.setForeground(Color.WHITE);
		basicInfoButton.setBackground(exicted);
		basicInfoButton.setOpaque(true);
		basicInfoButton.addMouseListener(new BasicInfoButtonListener());
		ButtonsBGLabel.add(basicInfoButton);
	}
	
	class BasicInfoButtonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			setVisible(false);
			setButtonsBGLabel();
			basicInfoButton.isSelected = true;
			basicInfoButton.setBackground(pressed);
			setSelectedGroups(basicInfoButton);
			if(BasicInfoTable!=null)
				PlayerDataList.this.remove(BasicInfoTable);
			if(NormalInfoTable!=null)
				PlayerDataList.this.remove(NormalInfoTable);
			if(HighInfoTable!=null)
				PlayerDataList.this.remove(HighInfoTable);
			setBasicInfoTablePanel(); 
				
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

	
	public void setNormalInfoButton(){
		Point p1 = new Point(50,5);
		Point p2 = new Point(40,30);
		NormalInfoButton = new SelectLabel("基础",p1,p2,entered,pressed,exicted);
		NormalInfoButton.setForeground(Color.WHITE);
		NormalInfoButton.setBackground(exicted);
		NormalInfoButton.setOpaque(true);
		NormalInfoButton.addMouseListener(new NormalInfoButtonListener());
		ButtonsBGLabel.add(NormalInfoButton);
	}

	
	public class NormalInfoButtonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
//			PlayerKingPanel.this.remove(TitleLabel);
//			PlayerKingPanel.this.remove(everyDay_PlayerKingOptionsPanel);

			setVisible(false);
			setButtonsBGLabel();
			NormalInfoButton.isSelected = true;
			NormalInfoButton.setBackground(pressed);
			setSelectedGroups(NormalInfoButton);
			
			if(BasicInfoTable!=null)
				PlayerDataList.this.remove(BasicInfoTable);
			if(NormalInfoTable!=null)
				PlayerDataList.this.remove(NormalInfoTable);
			if(HighInfoTable!=null)
				PlayerDataList.this.remove(HighInfoTable);
			setNormalInfoTablePanel(false); 
			
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
	public void setAvgNormalInfoButton(){
		Point p1 = new Point(100,5);
		Point p2 = new Point(40,30);
		AvgNormalInfoButton = new SelectLabel("场均",p1,p2,entered,pressed,exicted);
		AvgNormalInfoButton.setForeground(Color.WHITE);
		AvgNormalInfoButton.setBackground(exicted);
		AvgNormalInfoButton.setOpaque(true);
		AvgNormalInfoButton.addMouseListener(new AvgNormalInfoButtonListener());
		ButtonsBGLabel.add(AvgNormalInfoButton);
	}

	
	public class AvgNormalInfoButtonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {

			setVisible(false);
			setButtonsBGLabel();
			AvgNormalInfoButton.isSelected = true;
			AvgNormalInfoButton.setBackground(pressed);
			setSelectedGroups(AvgNormalInfoButton);
			
			if(BasicInfoTable!=null)
				PlayerDataList.this.remove(BasicInfoTable);
			if(NormalInfoTable!=null)
				PlayerDataList.this.remove(NormalInfoTable);
			if(HighInfoTable!=null)
				PlayerDataList.this.remove(HighInfoTable);
			setNormalInfoTablePanel(true); 
			
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
	public void setHighInfoButton(){
		Point p1 = new Point(150,5);
		Point p2 = new Point(40,30);
		HighInfoButton = new SelectLabel("高阶",p1,p2,entered,pressed,exicted);
		HighInfoButton.setForeground(Color.WHITE);
		HighInfoButton.setBackground(exicted);
		HighInfoButton.setOpaque(true);
		HighInfoButton.addMouseListener(new HighInfoButtonListener());
		ButtonsBGLabel.add(HighInfoButton);
	}

	
	public class HighInfoButtonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
//			PlayerKingPanel.this.remove(TitleLabel);
//			PlayerKingPanel.this.remove(everyDay_PlayerKingOptionsPanel);

			setVisible(false);
			setButtonsBGLabel();
			HighInfoButton.isSelected = true;
			HighInfoButton.setBackground(pressed);
			setSelectedGroups(HighInfoButton);
			if(BasicInfoTable!=null)
				PlayerDataList.this.remove(BasicInfoTable);
			if(NormalInfoTable!=null)
				PlayerDataList.this.remove(NormalInfoTable);
			if(HighInfoTable!=null)
				PlayerDataList.this.remove(HighInfoTable);
			setHighInfoTablePanel(); 
			
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
		ButtonsBGLabel.setBounds(1005,10,195,40);
		setBasicInfoButton();
		setNormalInfoButton();
		setAvgNormalInfoButton();
		setHighInfoButton();
		TitleLabel.add(ButtonsBGLabel,0);
	}

	public void setBasicInfoTablePanel(){
		sortParam s = new sortParam("point",true);
		ArrayList<sortParam> sortBy = new ArrayList<sortParam>();
		sortBy.add(s);
		ArrayList<PlayerVO> vo = pds.sortPlayerInfo(sortBy);
		PlayerVO2List v2l = new PlayerVO2List();
		ArrayList<ArrayList<String>> datas = v2l.basicInfo(vo);
			
		String[] header = {"","名称","所属球队","联盟","号码","球员位置","球员年龄","身高","体重","毕业学校"};
		ArrayList<Integer> wid = new ArrayList<Integer>();
		wid.add(50);wid.add(150);wid.add(100);wid.add(100);wid.add(100);wid.add(100);wid.add(100);wid.add(100);wid.add(100);wid.add(200);
		
		BasicInfoTable = new TablePane(datas,header,wid,0,60,1280,400,50,true,false);
		this.add(BasicInfoTable);
	}
		
	public void setNormalInfoTablePanel(boolean isAvg){
			
		sortParam s = new sortParam("point",true);
		ArrayList<sortParam> sortBy = new ArrayList<sortParam>();
		sortBy.add(s);
		ArrayList<PlayerVO> vo = new ArrayList<PlayerVO>();
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();			
		PlayerVO2List v2l = new PlayerVO2List();
		if(isAvg){
			vo = pds.sortPlayerNormalAvg(sortBy);
			datas = v2l.avgNormalData(vo);
		}else{
			vo = pds.sortPlayerNormal(sortBy);
			datas = v2l.normalData(vo);
		}

		String[] tbHead = {"","姓名","首发","效率","上场次数","分钟","％","三分％","罚球％","进攻",
					"防守","篮板","助攻","抢断","盖帽","失误","犯规","得分"};
			
		ArrayList<Integer> wid = new ArrayList<Integer>();
		wid.add(50);wid.add(150);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);
		wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);
			
		NormalInfoTable = new TablePane(datas,tbHead,wid,0,60,1280,400,50,true,true);
		this.add(NormalInfoTable);
	}
	public void setHighInfoTablePanel(){
		
		sortParam s = new sortParam("point",true);
		ArrayList<sortParam> sortBy = new ArrayList<sortParam>();
		sortBy.add(s);
		ArrayList<PlayerVO> vo = pds.sortPlayerHigh(sortBy);
		PlayerVO2List v2l = new PlayerVO2List();
		ArrayList<ArrayList<String>> datas = v2l.highData(vo);
				
		String[] tbHead = {"","姓名","助攻率","盖帽率","抢断率","防守篮板率","进攻篮板率","失误率","使用率","GmSc",
					"真实命中率","篮板率","投篮效率"};
			
		ArrayList<Integer> wid = new ArrayList<Integer>();
		wid.add(50);wid.add(150);wid.add(50);wid.add(50);wid.add(50);wid.add(100);wid.add(100);wid.add(50);wid.add(50);wid.add(50);
		wid.add(100);wid.add(50);wid.add(70);
			
		NormalInfoTable = new TablePane(datas,tbHead,wid,0,60,1280,400,50,true,true);
		this.add(NormalInfoTable);
	}

	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new PlayerDataList());
		jf.setVisible(true);
	}

}

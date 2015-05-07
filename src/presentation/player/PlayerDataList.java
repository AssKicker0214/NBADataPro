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
import dataservice.player.PlayerDataHandel;
import dataservice.player.sortParam;
import presentation.common.ListType;
import presentation.common.PanelMotion;
import presentation.common.PullDownMenu;
import presentation.common.SelectLabel;
import presentation.player.playerDetail.FilterLabel;
import presentation.table.TablePane;
import presentation.table.playerTablePanel;
import vo.playervo.PlayerVO;

public class PlayerDataList  extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel titleLabel;
	JLabel buttonsBGLabel;
	
	PullDownMenu menu;
	FilterLabel filter;
	
	PanelMotion upMotion;
	PanelMotion downMotion;
	
	public SelectLabel basicInfoButton;//信息
	public SelectLabel NormalInfoButton;//普通数据
	public SelectLabel AvgNormalInfoButton;//平均普通数据
	public SelectLabel HighInfoButton;//高阶数据
	
	PlayerDataService pds = new PlayerDataHandel();
	
	Color entered = new Color(30,80,140);
	Color pressed = new Color(42,109,183);
	Color exicted= new Color(26,70,122);

	TablePane BasicInfoTable;
	TablePane NormalInfoTable;
	TablePane HighInfoTable;
	
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();
	
	ArrayList<sortParam> sortBy = new ArrayList<sortParam>();
	ArrayList<String> position = new ArrayList<String>();
	ArrayList<String> league = new ArrayList<String>();
	
	public PlayerDataList(){
		this.setLayout(null);
		this.setBounds(0,125,1280,545);
		this.setBackground(Color.WHITE);
		setTitle();
		setButtonsBGLabel();
		basicInfoButton.setBackground(pressed);
		sortBy.add(new sortParam("point",true));
		position.add("F");position.add("C");position.add("G");
		league.add("w");league.add("E");
		setBasicInfoTablePanel();

		setMotion();
		setFilterButton();
	}
	
	private void setMotion(){
		ArrayList<JPanel> panels = new ArrayList<JPanel>();
		panels.add(BasicInfoTable);
		panels.add(NormalInfoTable);
		panels.add(HighInfoTable);
		upMotion = new PanelMotion(panels, 60);
		downMotion = new PanelMotion(panels, 150);
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
	public void setAttri(){
		String leagueChosen = (String) filter.leagueCombo.getSelectedItem();
		String positionChosen = (String) filter.positionCombo.getSelectedItem();
		String fst = (String) filter.firstCombo.getSelectedItem();
		String sec = (String) filter.secondCombo.getSelectedItem();
		String third = (String) filter.thirdCombo.getSelectedItem();
		switch(leagueChosen){
			case"全部":league.add("E"); league.add("W");break;
			case"东部联盟":league.add("E");break;
			case"西部联盟":league.add("W");break;
			default:break;
		}
		switch(positionChosen){
			case"全部":position.add("F"); position.add("C");position.add("G");break;
			case"前锋":position.add("F");break;
			case"中锋":position.add("C");break;
			case"后卫":position.add("G");break;
			default:break;
		}
		switch(fst){
			case"第一优先级":sortBy.add(new sortParam("avgPoint",true));break;
			case"场均助攻":sortBy.add(new sortParam("avgAssist",true));break;
			case"场均盖帽":sortBy.add(new sortParam("avgBlockShot",true));break;
			case"场均防守":sortBy.add(new sortParam("avgDefend",true));break;
			case"场均失误":sortBy.add(new sortParam("avgFault",true));break;
			case"场均犯规":sortBy.add(new sortParam("avgFoul",true));break;
			case"上场时间":sortBy.add(new sortParam("avgMinute",true));break;
			case"进攻":	 sortBy.add(new sortParam("avgOffend",true));break;
			case"场均篮板":sortBy.add(new sortParam("avgRebound",true));break;
			case"场均得分":sortBy.add(new sortParam("avgPoint",true));break;
			case"场均抢断":sortBy.add(new sortParam("avgSteal",true));break;
			case"GMSC效率值":sortBy.add(new sortParam("gmSc",true));break;
			case"三分命中率":sortBy.add(new sortParam("three",true));break;
			case"投篮命中率":sortBy.add(new sortParam("shot",true));break;
			case"罚球命中率":sortBy.add(new sortParam("penalty",true));break;
			default:break;
		}
			
		switch(sec){
			case"第二优先级":break;
			case"场均助攻":sortBy.add(new sortParam("avgAssist",true));break;
			case"场均盖帽":sortBy.add(new sortParam("avgBlockShot",true));break;
			case"场均防守":sortBy.add(new sortParam("avgDefend",true));break;
			case"场均失误":sortBy.add(new sortParam("avgFault",true));break;
			case"场均犯规":sortBy.add(new sortParam("avgFoul",true));break;
			case"上场时间":sortBy.add(new sortParam("avgMinute",true));break;
			case"进攻":	 sortBy.add(new sortParam("avgOffend",true));break;
			case"场均篮板":sortBy.add(new sortParam("avgRebound",true));break;
			case"场均得分":sortBy.add(new sortParam("avgPoint",true));break;
			case"场均抢断":sortBy.add(new sortParam("avgSteal",true));break;
			case"GMSC效率值":sortBy.add(new sortParam("gmSc",true));break;
			case"三分命中率":sortBy.add(new sortParam("three",true));break;
			case"投篮命中率":sortBy.add(new sortParam("shot",true));break;
			case"罚球命中率":sortBy.add(new sortParam("penalty",true));break;
			default:break;
		}
		
		switch(third){
			case"第三优先级":break;
			case"场均助攻":sortBy.add(new sortParam("avgAssist",true));break;
			case"场均盖帽":sortBy.add(new sortParam("avgBlockShot",true));break;
			case"场均防守":sortBy.add(new sortParam("avgDefend",true));break;
			case"场均失误":sortBy.add(new sortParam("avgFault",true));break;
			case"场均犯规":sortBy.add(new sortParam("avgFoul",true));break;
			case"上场时间":sortBy.add(new sortParam("avgMinute",true));break;
			case"进攻":	 sortBy.add(new sortParam("avgOffend",true));break;
			case"场均篮板":sortBy.add(new sortParam("avgRebound",true));break;
			case"场均得分":sortBy.add(new sortParam("avgPoint",true));break;
			case"场均抢断":sortBy.add(new sortParam("avgSteal",true));break;
			case"GMSC效率值":sortBy.add(new sortParam("gmSc",true));break;
			case"三分命中率":sortBy.add(new sortParam("three",true));break;
			case"投篮命中率":sortBy.add(new sortParam("shot",true));break;
			case"罚球命中率":sortBy.add(new sortParam("penalty",true));break;
			default:break;
		}
	}


	
	public void setTitle(){
		titleLabel = new JLabel(" 球员列表",JLabel.LEADING);
		titleLabel.setFont(new Font("Dialog",1,20));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(entered);
		titleLabel.setOpaque(true);
		titleLabel.setBounds(0,0,1280,60);
		this.add(titleLabel);
		this.updateUI();
		
		filter = new FilterLabel();
		filter.setLocation(0, 55);
		this.add(filter);
		filter.setVisible(false);
	}
	
	private void setFilterButton(){
		JLabel filterButton = new JLabel("筛选",JLabel.LEADING);
		filterButton.setBounds(1220, 10, 80, 40);
		filterButton.setBackground(entered);
		filterButton.setForeground(Color.WHITE);
		filterButton.setFont(new Font("Dialog",1,20));
		filterButton.setOpaque(true);
		filterButton.addMouseListener(new MouseListener() {
			boolean selected = false;
			@Override
			public void mouseReleased(MouseEvent e) {
				if(selected == true){
					upMotion.upMove();
					filterButton.setText("筛选");
					filter.setVisible(false);
					
					setAttri();
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
					
				}else{
					downMotion.downMove();
					filterButton.setText("确定");
					filter.setVisible(true);
				}
				selected = !selected;
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		titleLabel.add(filterButton);
	
	}
	
	public void setBasicInfoButton(){
		Point p1 = new Point(5,5);
		Point p2 = new Point(40,30);
		basicInfoButton = new SelectLabel("信息",p1,p2,entered,pressed,exicted);
		basicInfoButton.setForeground(Color.WHITE);
		basicInfoButton.setBackground(exicted);
		basicInfoButton.setOpaque(true);
		basicInfoButton.addMouseListener(new BasicInfoButtonListener());
		buttonsBGLabel.add(basicInfoButton);
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
		buttonsBGLabel.add(NormalInfoButton);
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
		buttonsBGLabel.add(AvgNormalInfoButton);
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
		buttonsBGLabel.add(HighInfoButton);
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
		buttonsBGLabel = new JLabel();
		buttonsBGLabel.setBackground(exicted);
		buttonsBGLabel.setOpaque(true);
		buttonsBGLabel.setBounds(1005,10,195,40);
		setBasicInfoButton();
		setNormalInfoButton();
		setAvgNormalInfoButton();
		setHighInfoButton();
		titleLabel.add(buttonsBGLabel,0);
	}

	public void setBasicInfoTablePanel(){
		ArrayList<PlayerVO> vo = pds.filterInfo(sortBy,position,league,-1,-1);
		PlayerVO2List v2l = new PlayerVO2List();
		ArrayList<ArrayList<String>> datas = v2l.basicInfo(vo);
			
		String[] header = {"","名称","所属球队","联盟","号码","球员位置","球员年龄","身高","体重","毕业学校"};
		ArrayList<Integer> wid = new ArrayList<Integer>();
		wid.add(70);wid.add(150);wid.add(100);wid.add(100);wid.add(100);wid.add(100);wid.add(100);wid.add(100);wid.add(100);wid.add(200);
		
		BasicInfoTable = new playerTablePanel(datas,header,wid,0,60,1280,450,50,true,false);
		this.add(BasicInfoTable);
	}
		
	public void setNormalInfoTablePanel(boolean isAvg){
		ArrayList<PlayerVO> vo = new ArrayList<PlayerVO>();
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();			
		PlayerVO2List v2l = new PlayerVO2List();
		ListType tableType = ListType.avg;
		if(isAvg){
			vo = pds.filterNormalAvg(sortBy,position,league,-1,-1);
			datas = v2l.avgNormalData(vo);
		}else{
			tableType = ListType.normal;
			vo = pds.filterNormal(sortBy,position,league,-1,-1);
			datas = v2l.normalData(vo);
		}

		String[] tbHead = {"","姓名","首发","效率","上场次数","分钟","％","三分％","罚球％","进攻",
					"防守","篮板","助攻","抢断","盖帽","失误","犯规","得分"};
			
		ArrayList<Integer> wid = new ArrayList<Integer>();
		wid.add(70);wid.add(150);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);
		wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);
			
		NormalInfoTable = new playerTablePanel(datas,tbHead,wid,0,60,1280,450,50,true,true);
		NormalInfoTable.type = tableType;
		this.add(NormalInfoTable);
	}
	
	public void setHighInfoTablePanel(){
		ArrayList<PlayerVO> vo = pds.filterHigh(sortBy,position,league,-1,-1);
		PlayerVO2List v2l = new PlayerVO2List();
		ArrayList<ArrayList<String>> datas = v2l.highData(vo);
				
		String[] tbHead = {"","姓名","助攻率","盖帽率","抢断率","防守篮板率","进攻篮板率","失误率","使用率","GmSc",
					"真实命中率","篮板率","投篮效率"};
			
		ArrayList<Integer> wid = new ArrayList<Integer>();
		wid.add(70);wid.add(150);wid.add(50);wid.add(50);wid.add(50);wid.add(100);wid.add(100);wid.add(50);wid.add(50);wid.add(50);
		wid.add(100);wid.add(50);wid.add(70);
			
		HighInfoTable = new playerTablePanel(datas,tbHead,wid,0,60,1280,450,50,true,true);
		HighInfoTable.type = ListType.high;

		this.add(HighInfoTable);
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

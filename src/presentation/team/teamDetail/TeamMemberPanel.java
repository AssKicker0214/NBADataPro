package presentation.team.teamDetail;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataservice.team.TeamDataService;
import dataservice.team.TeamData_stub;
import presentation.common.SelectLabel;
import presentation.player.PlayerVO2List;
import presentation.table.TablePane;
import vo.playervo.PlayerVO;

public class TeamMemberPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel TitleLabel;
	JLabel ButtonsBGLabel;
	
	public SelectLabel basicInfoButton;//信息
	public SelectLabel dataButton;//数据
	
	Color entered = new Color(30,80,140);
	Color pressed = new Color(42,109,183);
	Color exicted= new Color(26,70,122);

	TablePane membersBasicInfoTable;
	TablePane membersDataTable;
	
	ArrayList<PlayerVO> vo;
	
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();
	
	public TeamMemberPanel(int id){
		
		TeamDataService tds = new TeamData_stub();
		vo = tds.teamMemberList(id);
		this.setLayout(null);
		this.setBounds(0,260,1280,380);
		this.setBackground(Color.WHITE);
		setTitle();
		setButtonsBGLabel();
		basicInfoButton.setBackground(pressed);
		setBasicInfoTablePanel();
	}
	
	public void setSelectedGroups(SelectLabel s){
		selectLabelGroups.clear();
		selectLabelGroups.add(basicInfoButton);
		selectLabelGroups.add(dataButton);
		for(SelectLabel sl : selectLabelGroups){
			if(sl != s){
				sl.setBackground(exicted);;
			}
		}
	}

	public void setTitle(){
		TitleLabel = new JLabel(" 球队阵容",JLabel.LEADING);
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
			
			if(membersBasicInfoTable==null){
				setBasicInfoTablePanel(); 
			}else{
				TeamMemberPanel.this.remove(membersBasicInfoTable);
				if(membersDataTable != null){
					TeamMemberPanel.this.remove(membersDataTable);
				}
				setBasicInfoTablePanel(); 
			}
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

	
	public void setDataButton(){
		Point p1 = new Point(50,5);
		Point p2 = new Point(40,30);
		dataButton = new SelectLabel("数据",p1,p2,entered,pressed,exicted);
		dataButton.setForeground(Color.WHITE);
		dataButton.setBackground(exicted);
		dataButton.addMouseListener(new DataButtonListener());
		ButtonsBGLabel.add(dataButton);
	}

	
	public class DataButtonListener implements MouseListener{

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
			dataButton.isSelected = true;
			dataButton.setBackground(pressed);
			setSelectedGroups(dataButton);
			
			if(membersDataTable==null){
				TeamMemberPanel.this.remove(membersBasicInfoTable);
				setDataTablePanel(); 
			}else{
				TeamMemberPanel.this.remove(membersDataTable);
				TeamMemberPanel.this.remove(membersBasicInfoTable);
				setDataTablePanel(); 
			}
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
		ButtonsBGLabel.setBounds(1105,10,95,40);
		setBasicInfoButton();
		setDataButton();
		TitleLabel.add(ButtonsBGLabel,0);
	}

	public void setBasicInfoTablePanel(){
			
		PlayerVO2List p2l = new PlayerVO2List();
		ArrayList<ArrayList<String>> datas = p2l.teamMember(vo);	
		String[] tbHead = {"","姓名","位置","号码","年龄","球龄","身高","体重","毕业学校"};
		
		ArrayList<Integer> wid = new ArrayList<Integer>();
		wid.add(50);wid.add(300);wid.add(100);wid.add(100);wid.add(100);wid.add(100);wid.add(100);wid.add(100);wid.add(100);
		
		membersBasicInfoTable = new TablePane(datas,tbHead,wid,0,60,1280,350,50,true,false);
		this.add(membersBasicInfoTable);
	}
		
	public void setDataTablePanel(){
			
		PlayerVO2List p2l = new PlayerVO2List();
		ArrayList<ArrayList<String>> datas = p2l.avgNormalData(vo);
				
		String[] tbHead = {"","姓名","首发","效率","上场次数","分钟","％","三分％","罚球％","进攻",
				"防守","篮板","助攻","抢断","盖帽","失误","犯规","得分"};
			
		ArrayList<Integer> wid = new ArrayList<Integer>();
		wid.add(50);wid.add(150);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);
		wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);wid.add(50);
			
		membersDataTable = new TablePane(datas,tbHead,wid,0,60,1280,320,50,true,false);
		this.add(membersDataTable);
	}

	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
	//	jf.add(new TeamMemberPanel());
		jf.setVisible(true);
	}
}

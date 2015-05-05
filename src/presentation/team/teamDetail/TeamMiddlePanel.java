package presentation.team.teamDetail;

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
import presentation.player.vs.VSContentPanel;
import presentation.team.vs.TeamVSTopPanel;
import vo.teamvo.TeamVO;
//过往查询
public class TeamMiddlePanel  extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SelectLabel DataLabel;//球队资料
	SelectLabel MemberLabel;//球队阵容
	SelectLabel LatestMatchLabel;//近5场比赛
	SelectLabel PastLabel;//过往查询
	SelectLabel CompareTeamsLabel;//球队对比
	
	JPanel teamDetailTopPanel;
	JPanel teamVSTopPanel;
	
	TeamMemberPanel teamMemberPanel;
	TeamRecent5MatchPanel teamRecent5MatchPanel;
	TeamSchedulePanel teamSchedulePanel;
	TeamDataPanel teamDataPanel;
	VSContentPanel vsContentPanel;
	
	TeamVO vo;
	
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();

	public TeamMiddlePanel(String name){
		this.setLayout(null);
		this.setBounds(0, 35, 1280,670);
		this.setBackground(Color.WHITE);
		
		TeamDataService tds =  new TeamData_stub();
		vo = tds.findTeamInfo(name);
		setTopPanel();
		setContrastLabel();
		setMemberLabel();
		setLatestMatchLabel();
		setPastLabel();
		setCompareTeamsLabel();
		
		setTeamDataPanel();
		DataLabel.setBackground(Color.GRAY);
	}
	
	public void setSelectedGroups(SelectLabel s){
		selectLabelGroups.clear();
		selectLabelGroups.add(DataLabel);
		selectLabelGroups.add(MemberLabel);
		selectLabelGroups.add(LatestMatchLabel);
		selectLabelGroups.add(PastLabel);
		selectLabelGroups.add(CompareTeamsLabel);
		for(SelectLabel sl : selectLabelGroups){
			if(sl != s){
				sl.setBackground(Color.black);
				sl.isSelected = false;
			}
		}
	}
	
	public void setTeamMemberPanel(){
		teamMemberPanel = new TeamMemberPanel(vo.id);
		this.add(teamMemberPanel,0);
		repaint();
	}

	public void setTeamSchedulePanel(){
		teamSchedulePanel = new TeamSchedulePanel(vo.teamName);
		this.add(teamSchedulePanel,0);
		repaint();
	}

	public void setTeamRecent5MatchPanel(){
		teamRecent5MatchPanel = new TeamRecent5MatchPanel(vo.teamName);
		this.add(teamRecent5MatchPanel,0);
		repaint();
	}
	
	public void setTeamDataPanel(){
		teamDataPanel = new TeamDataPanel(vo);
		this.add(teamDataPanel,0);
		repaint();
	}
	
	public void setTeamVSPanel(){
		ArrayList<String> itemsNeedAdd = new ArrayList<String>();
		ArrayList<Double> avg1 = new ArrayList<Double>();
		ArrayList<Double> avg2 = new ArrayList<Double>();
		
		itemsNeedAdd.add("场均得分"); avg1.add(5.9); avg2.add(10.043);
		itemsNeedAdd.add("场均助攻"); avg1.add(1.0); avg2.add(2.159);
		itemsNeedAdd.add("场均篮板"); avg1.add(4.4); avg2.add(4.469);
		itemsNeedAdd.add("三分％"); 	avg1.add(30.0); avg2.add(34.5);
		itemsNeedAdd.add("罚球％");	avg1.add(78.4); avg2.add(74.3);

		vsContentPanel = new VSContentPanel(itemsNeedAdd,avg1,avg2);
		this.add(vsContentPanel);
		repaint();
	}

	public void setVSTopPanel(){
		teamVSTopPanel = new TeamVSTopPanel();
		this.add(teamVSTopPanel);
		repaint();
	}
	
	public void setTopPanel (){
		teamDetailTopPanel = new TeamDetailTopPanel(vo);
		this.add(teamDetailTopPanel);
	}
	
	public void setContrastLabel(){
		Point location = new Point(0,200);
		Point size = new Point(255,50);
		DataLabel = new SelectLabel("资料",location,size);

		DataLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setSelectedGroups(DataLabel);
				setVisible(false);
				if(teamDataPanel != null){
					remove(teamDataPanel);
				}
				if(teamMemberPanel != null){
					remove(teamMemberPanel);
				}
				if(teamRecent5MatchPanel != null){
					remove(teamRecent5MatchPanel);
				}
				if(teamSchedulePanel != null){
					remove(teamSchedulePanel);
				}
				if(vsContentPanel != null){
					remove(vsContentPanel);
				}
				if(teamDetailTopPanel != null){
					remove(teamDetailTopPanel);
				}
				if(teamVSTopPanel != null){
					remove(teamVSTopPanel);
				}
				setTopPanel();
				setTeamDataPanel();
				setVisible(true);
				repaint();				
			}
		});
		this.add(DataLabel);
	}
	
	public void setMemberLabel(){
		Point location = new Point(256,200);
		Point size = new Point(255,50);
		MemberLabel = new SelectLabel("阵容",location,size);

		MemberLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setSelectedGroups(MemberLabel);
				setVisible(false);
				if(teamDataPanel != null){
					remove(teamDataPanel);
				}
				if(teamMemberPanel != null){
					remove(teamMemberPanel);
				}
				if(teamRecent5MatchPanel != null){
					remove(teamRecent5MatchPanel);
				}
				if(teamSchedulePanel != null){
					remove(teamSchedulePanel);
				}
				if(vsContentPanel != null){
					remove(vsContentPanel);
				}
				if(teamDetailTopPanel != null){
					remove(teamDetailTopPanel);
				}
				if(teamVSTopPanel != null){
					remove(teamVSTopPanel);
				}
				setTopPanel();
				setTeamMemberPanel();
				setVisible(true);
				repaint();			
			}
		});
		this.add(MemberLabel);
	}
	
	public void setLatestMatchLabel(){
		Point location = new Point(512,200);
		Point size = new Point(255,50);
		LatestMatchLabel = new SelectLabel("近5场比赛查询",location,size);

		LatestMatchLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setSelectedGroups(LatestMatchLabel);
				setVisible(false);
				if(teamDataPanel != null){
					remove(teamDataPanel);
				}
				if(teamMemberPanel != null){
					remove(teamMemberPanel);
				}
				if(teamRecent5MatchPanel != null){
					remove(teamRecent5MatchPanel);
				}
				if(teamSchedulePanel != null){
					remove(teamSchedulePanel);
				}
				if(vsContentPanel != null){
					remove(vsContentPanel);
				}
				if(teamDetailTopPanel != null){
					remove(teamDetailTopPanel);
				}
				if(teamVSTopPanel != null){
					remove(teamVSTopPanel);
				}
				setTopPanel();
				setTeamRecent5MatchPanel();
				setVisible(true);
				repaint();				
			}
		});

		this.add(LatestMatchLabel);
	}

	public void setPastLabel(){
		Point location = new Point(768,200);
		Point size = new Point(255,50);
		PastLabel = new SelectLabel("过往查询",location,size);
		PastLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				setSelectedGroups(PastLabel);
				setVisible(false);
				if(teamDataPanel != null){
					remove(teamDataPanel);
				}
				if(teamMemberPanel != null){
					remove(teamMemberPanel);
				}
				if(teamRecent5MatchPanel != null){
					remove(teamRecent5MatchPanel);
				}
				if(teamSchedulePanel != null){
					remove(teamSchedulePanel);
				}
				if(vsContentPanel != null){
					remove(vsContentPanel);
				}
				if(teamDetailTopPanel != null){
					remove(teamDetailTopPanel);
				}
				if(teamVSTopPanel != null){
					remove(teamVSTopPanel);
				}
				setTopPanel();
				setTeamSchedulePanel();
				setVisible(true);
				repaint();		
				
			}
		});

		this.add(PastLabel);
	}
	
	public void setCompareTeamsLabel(){
		
		Point location = new Point(1024,200);
		Point size = new Point(255,50);
		CompareTeamsLabel = new SelectLabel("球队对比",location,size);
		CompareTeamsLabel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				setSelectedGroups(CompareTeamsLabel);
				setVisible(false);
				if(teamDataPanel != null){
					remove(teamDataPanel);
				}
				if(teamMemberPanel != null){
					remove(teamMemberPanel);
				}
				if(teamRecent5MatchPanel != null){
					remove(teamRecent5MatchPanel);
				}
				if(teamSchedulePanel != null){
					remove(teamSchedulePanel);
				}
				if(vsContentPanel != null){
					remove(vsContentPanel);
				}
				if(teamDetailTopPanel != null){
					remove(teamDetailTopPanel);
				}
				if(teamVSTopPanel != null){
					remove(teamVSTopPanel);
				}
				setVSTopPanel();
				setVisible(true);
				repaint();		
			}
			
		});
		this.add(CompareTeamsLabel);
	}


	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new TeamMiddlePanel("Hawks"));
		jf.setVisible(true);
	}
	
	
}

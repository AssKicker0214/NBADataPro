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
	
	TeamMemberPanel teamMemberPanel;
	TeamRecent5MatchPanel teamRecent5MatchPanel;
	TeamSchedulePanel teamSchedulePanel;
	TeamDataPanel teamDataPanel;
	
	TeamVO vo;
	
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();

	public TeamMiddlePanel(String name){
		this.setLayout(null);
		this.setBounds(0, 35, 1280,670);
		this.setBackground(Color.WHITE);
		setTopPanel();
		setContrastLabel();
		setMemberLabel();
		setLatestMatchLabel();
		setPastLabel();
		setCompareTeamsLabel();
		
		TeamDataService tds =  new TeamData_stub();
		vo = tds.findTeamInfo(name);
		setTeamDataPanel();
		DataLabel.setBackground(Color.GRAY);
	}
	
	public void setTopPanel (){
		teamDetailTopPanel = new TeamDetailTopPanel(vo);
		this.add(teamDetailTopPanel);
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
				setTeamDataPanel();
				setVisible(true);
				repaint();				
			}
		});
		this.add(DataLabel);
	}
	
	public void setTeamMemberPanel(){
		teamMemberPanel = new TeamMemberPanel(vo.id);
		this.add(teamMemberPanel,0);
		repaint();
	}

	public void setTeamSchedulePanel(){
		teamSchedulePanel = new TeamSchedulePanel();
		this.add(teamSchedulePanel,0);
		repaint();
	}

	public void setTeamRecent5MatchPanel(){
		teamRecent5MatchPanel = new TeamRecent5MatchPanel();
		this.add(teamRecent5MatchPanel,0);
		repaint();
	}
	
	public void setTeamDataPanel(){
		teamDataPanel = new TeamDataPanel(vo);
		this.add(teamDataPanel,0);
		repaint();
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
				setTeamSchedulePanel();
				setVisible(true);
				repaint();		
				
			}
		});

		this.add(PastLabel);
	}
	
	
//	 setTeamDataPanel()
//setTeamMemberPanel()
//	 setTeamSchedulePanel()
//	setTeamRecent5MatchPanel()
	
//	TeamMemberPanel teamMemberPanel;
//	TeamRecent5MatchPanel teamRecent5MatchPanel;
//	TeamSchedulePanel teamSchedulePanel;
//	TeamDataPanel teamDataPanel;




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
//				setTeamSchedulePanel();
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
//		jf.add(new TeamMiddlePanel());
		jf.setVisible(true);
	}
	
	
}

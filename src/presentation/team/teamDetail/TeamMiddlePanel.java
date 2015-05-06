package presentation.team.teamDetail;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dataservice.player.PlayerDataService;
import dataservice.player.PlayerData_stub;
import dataservice.team.TeamDataService;
import dataservice.team.TeamData_stub;
import presentation.common.SelectLabel;
import presentation.player.vs.VSContentPanel;
import presentation.team.vs.TeamVSTopPanel;
import vo.playervo.PlayerVO;
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
	
	ArrayList<Double> team = new ArrayList<Double>();
	ArrayList<Double> leagueAvg = new ArrayList<Double>();
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();
	ArrayList<String> itemsNeedAdd = new ArrayList<String>();

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
	
	public void setAttri(String name){
		TeamDataService pds = new TeamData_stub();
		PlayerVO voL = pds.avgLeague(); 
		TeamVO voP = pds.findTeamInfo(name); 
		vo = voP;
		setTopPanel(voP);
		player.add(voP.avgPoint);player.add(voP.avgRebound);player.add(voP.avgAssist);
		player.add(voP.three);player.add(voP.penalty);
		leagueAvg.add(voL.avgPoint);leagueAvg.add(voL.avgRebound);leagueAvg.add(voL.avgAssist);
		leagueAvg.add(voL.three);leagueAvg.add(voL.penalty);
		//"年度","球队","场数","先发","分钟","％","三分％","罚球％",
		//"进攻","防守","场均篮板","场均助攻","场均抢断","场均盖帽","失误","犯规","场均得分"
		avg.add("2012-2013");avg.add(voP.team);avg.add(voP.numOfGame+"");avg.add(voP.start+"");avg.add(voP.avgMinute+"");avg.add(voP.shot+"");avg.add(voP.three+"");
		avg.add(voP.penalty+"");avg.add(voP.avgOffend+"");avg.add(voP.avgDefend+"");avg.add(voP.avgRebound+"");avg.add(voP.avgAssist+"");avg.add(voP.avgSteal+"");
		avg.add(voP.avgBlockShot+"");avg.add(voP.avgFault+"");avg.add(voP.avgFoul+"");avg.add(voP.avgPoint+"");
		total.add("2012-2013");total.add(voP.team);total.add(voP.numOfGame+"");total.add(voP.start+"");total.add(voP.minute+"");total.add(voP.shot+"");total.add(voP.three+"");
		total.add(voP.penalty+"");total.add(voP.offend+"");total.add(voP.defend+"");total.add(voP.rebound+"");total.add(voP.assist+"");total.add(voP.steal+"");
		total.add(voP.blockShot+"");total.add(voP.fault+"");total.add(voP.foul+"");total.add(voP.point+"");
		itemsNeedAdd.add("场均得分");
		itemsNeedAdd.add("场均助攻");
		itemsNeedAdd.add("场均篮板"); 
		itemsNeedAdd.add("三分％"); 
		itemsNeedAdd.add("罚球％");

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
		vsContentPanel = new VSContentPanel(itemsNeedAdd,team,leagueAvg);
		this.add(vsContentPanel);
		repaint();
	}

	public void setVSTopPanel(TeamMiddlePanel middle){
		teamVSTopPanel = new TeamVSTopPanel(middle);
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
				setVSTopPanel(TeamMiddlePanel.this);
				setTeamVSPanel();
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

package presentation.team.teamDetail;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.common.SelectLabel;

public class TeamMiddlePanel  extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SelectLabel ContrastLabel;//联盟对比
	SelectLabel MemberLabel;//球队阵容
	SelectLabel LatestMatchLabel;//近5场比赛
	SelectLabel PastLabel;//过往查询
	SelectLabel CompareTeamsLabel;//球队对比
	
	JPanel teamDetailTopPanel;
	
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();

	public TeamMiddlePanel(){
		this.setLayout(null);
		this.setBounds(0, 35, 1280,670);
		this.setBackground(Color.WHITE);
		setTopPanel();
		setContrastLabel();
		setMemberLabel();
		setLatestMatchLabel();
		setPastLabel();
		setCompareTeamsLabel();
	}
	
	public void setTopPanel (){
		teamDetailTopPanel = new TeamDetailTopPanel();
		this.add(teamDetailTopPanel);
	}
	
	public void setSelectedGroups(SelectLabel s){
		selectLabelGroups.clear();
		selectLabelGroups.add(ContrastLabel);
		selectLabelGroups.add(MemberLabel);
		selectLabelGroups.add(LatestMatchLabel);
		selectLabelGroups.add(PastLabel);
		selectLabelGroups.add(CompareTeamsLabel);
		for(SelectLabel sl : selectLabelGroups){
			if(sl != s){
				sl.setBackground(Color.black);;
			}
		}
	}
	public void setContrastLabel(){
		Point location = new Point(0,200);
		Point size = new Point(255,50);
		ContrastLabel = new SelectLabel("资料",location,size);

		ContrastLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setSelectedGroups(ContrastLabel);
				setVisible(false);
//				set
				
				
				
			}
		});
		this.add(ContrastLabel);
	}
	
	public void setContrastPanel(){
		
	}
	
	public void setMemberLabel(){
		Point location = new Point(256,200);
		Point size = new Point(255,50);
		MemberLabel = new SelectLabel("阵容",location,size);

		MemberLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setSelectedGroups(MemberLabel);
		
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
			}
			
		});
		this.add(CompareTeamsLabel);
	}


	

	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new TeamMiddlePanel());
		jf.setVisible(true);
	}
	
	
}

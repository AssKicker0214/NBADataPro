package presentation.match;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataservice.match.MatchDataService;
import dataservice.match.MatchDataHandel;
import dataservice.match.MatchDataHandel;
import presentation.common.PhotoLabel;
import presentation.main.Mainframe;
import presentation.team.teamDetail.TeamMiddlePanel;
import vo.matchvo.MatchVO;

public class MatchAnalyseTopPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel localTeamPhotoLabel;
	JLabel anotherTeamPhotoLabel;
	JLabel VSLabel;
	JLabel localInfoGroupsLabel;
	JLabel anotherInfoGroupsLabel;
	JLabel dateLabel;
	JLabel partialScoreLabelGroups;//小比分群
	JLabel scoreLabel;//小比分群
	
	MatchDataAnalysePanel matchDataAnalysePanel;
	
	MatchVO vo;
	public MatchAnalyseTopPanel(int matchID){
		this.setLayout(null);
		this.setBounds(0, 0, 1280,700);
		this.setBackground(Color.WHITE);
		MatchDataService mds = new MatchDataHandel();
		vo = mds.findMatch(matchID);
		
		setDataLabel();
		setsetLocalTeamPhotoLabel();
		setAnotherTeamPhotoLabel();
		setVSLabel();
		setLocalInfoGroupsLabel();
		setAnotherInfoGroupsLabel();
		setScoreLabel();
		setMatchDataAnalysePanel();
	}
	
	public void setDataLabel(){
		dateLabel = new JLabel(vo.date,JLabel.CENTER);
		dateLabel.setFont(new Font("Dialog",1,15));
		dateLabel.setForeground(Color.DARK_GRAY);
		dateLabel.setBackground(Color.LIGHT_GRAY);
		dateLabel.setOpaque(true);
		dateLabel.setBounds(500,0,230,30);
		this.add(dateLabel);
	}
	
	private void setsetLocalTeamPhotoLabel(){
		localTeamPhotoLabel = new PhotoLabel(new ImageIcon("teamsPNG/"+vo.homeTeam.photo+".png").getImage());
//		localTeamPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		localTeamPhotoLabel.setBounds(350,23,200,125);
		localTeamPhotoLabel.setBackground(Color.WHITE);
		localTeamPhotoLabel.setOpaque(true);
		localTeamPhotoLabel.setVisible(true);
		localTeamPhotoLabel.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				Mainframe.getFrame().changeContent(new TeamMiddlePanel(vo.homeTeam.name));
			}
		
		});
		this.add(localTeamPhotoLabel);
	}
	
	public void setAnotherTeamPhotoLabel (){
		anotherTeamPhotoLabel = new PhotoLabel(new ImageIcon("teamsPNG/"+vo.guestTeam.photo+".png").getImage());
		anotherTeamPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		anotherTeamPhotoLabel.setBounds(730,23,180,125);
		anotherTeamPhotoLabel.setBackground(Color.white);
		anotherTeamPhotoLabel.setOpaque(true);
		anotherTeamPhotoLabel.setVisible(true);
		anotherTeamPhotoLabel.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				Mainframe.getFrame().changeContent(new TeamMiddlePanel(vo.guestTeam.name));
			}
		
		});
		this.add(anotherTeamPhotoLabel);
	}
	
	public void setVSLabel(){
		VSLabel = new JLabel("VS",JLabel.CENTER);
		VSLabel.setFont(new Font("Dialog",1,30));
		VSLabel.setForeground(Color.DARK_GRAY);
		VSLabel.setBackground(Color.WHITE);
		VSLabel.setOpaque(true);
		VSLabel.setBounds(550,15,130,130);
		this.add(VSLabel);

	}
	
	public void setLocalInfoGroupsLabel(){
		localInfoGroupsLabel = new JLabel();
		localInfoGroupsLabel.setBounds(0,85,350,67);
		localInfoGroupsLabel.setOpaque(true);
		localInfoGroupsLabel.setBackground(Color.BLACK);

		JLabel localScore = new JLabel(vo.homePoint+"",JLabel.CENTER);
		localScore.setFont(new Font("Dialog",1,30));
		localScore.setForeground(Color.WHITE);
		localScore.setBounds(270,0,80,55);
		localInfoGroupsLabel.add(localScore);

		JLabel playerName = new JLabel(vo.homeTeam.location+" "+vo.homeTeam.name,JLabel.LEADING);
		playerName.setFont(new Font("Dialog",1,20));
		playerName.setForeground(Color.WHITE);
		playerName.setBounds(5,0,260,55);
		localInfoGroupsLabel.add(playerName);
		
		this.add(localInfoGroupsLabel);
	}
	
	public void setAnotherInfoGroupsLabel(){
		anotherInfoGroupsLabel = new JLabel();
		anotherInfoGroupsLabel.setBounds(910,85,370,67);
		anotherInfoGroupsLabel.setOpaque(true);
		anotherInfoGroupsLabel.setBackground(Color.BLACK);
		
		JLabel anotherNum = new JLabel(vo.guestPoint+"",JLabel.CENTER);
		anotherNum.setFont(new Font("Dialog",1,30));
		anotherNum.setForeground(Color.WHITE);
		anotherNum.setBounds(0,0,80,55);
		anotherInfoGroupsLabel.add(anotherNum);
		
		JLabel anotherName = new JLabel(vo.guestTeam.location+" "+vo.guestTeam.name,JLabel.RIGHT);
		anotherName.setFont(new Font("Dialog",1,20));
		anotherName.setForeground(Color.WHITE);
		anotherName.setBounds(80,0,230,55);
		anotherInfoGroupsLabel.add(anotherName);

		this.add(anotherInfoGroupsLabel);
	}
	
	public JLabel setSinglePartialScoreLabel(String index,String score1,String score2){
		JLabel SinglePartialScoreLabel = new JLabel();
		SinglePartialScoreLabel.setOpaque(true);
		SinglePartialScoreLabel.setBackground(Color.LIGHT_GRAY);
		
		JLabel indexLabel = new JLabel(index,JLabel.CENTER);
		indexLabel.setFont(new Font("Dialog",1,15));
		indexLabel.setForeground(Color.WHITE);
		indexLabel.setBounds(0,0,50,20);
		SinglePartialScoreLabel.add(indexLabel);
		
		JLabel scoreLabel1 = new JLabel(score1,JLabel.CENTER);
		scoreLabel1.setFont(new Font("Dialog",1,15));
		scoreLabel1.setForeground(Color.WHITE);
		scoreLabel1.setBounds(0,20,50,20);
		SinglePartialScoreLabel.add(scoreLabel1);
		
		JLabel scoreLabel2 = new JLabel(score1,JLabel.CENTER);
		scoreLabel2.setFont(new Font("Dialog",1,15));
		scoreLabel2.setForeground(Color.WHITE);
		scoreLabel2.setBounds(0,40,50,20);
		SinglePartialScoreLabel.add(scoreLabel2);

		return SinglePartialScoreLabel;
	}
	
	public void setPartialScoreGroupsLabel(){
		partialScoreLabelGroups = new JLabel();
		partialScoreLabelGroups.setBounds(100,0,460,62);
		partialScoreLabelGroups.setOpaque(true);
		partialScoreLabelGroups.setBackground(Color.LIGHT_GRAY);
		partialScoreLabelGroups.setLayout(new GridLayout(1,5,0,0));
		
		
		partialScoreLabelGroups.add(setSinglePartialScoreLabel("1",vo.homePoint_1+"",vo.guestPoint_1+""));
		partialScoreLabelGroups.add(setSinglePartialScoreLabel("2",vo.homePoint_2+"",vo.guestPoint_2+""));
		partialScoreLabelGroups.add(setSinglePartialScoreLabel("3",vo.homePoint_3+"",vo.guestPoint_3+""));
		partialScoreLabelGroups.add(setSinglePartialScoreLabel("4",vo.homePoint_4+"",vo.guestPoint_4+""));
		partialScoreLabelGroups.add(setSinglePartialScoreLabel("",vo.homePoint+"",vo.guestPoint+""));

		scoreLabel.add(partialScoreLabelGroups);
	}
	
	
	//整个记分板
	public void setScoreLabel(){
		scoreLabel = new JLabel();
		scoreLabel.setBounds(350,150,560,62);
		scoreLabel.setOpaque(true);
		scoreLabel.setBackground(Color.LIGHT_GRAY);
		
		JLabel name = new JLabel(vo.homeTeam.photo,JLabel.CENTER);
		name.setFont(new Font("Dialog",1,15));
		name.setForeground(Color.WHITE);
		name.setBounds(0,20,35,20);
		scoreLabel.add(name);
		
		JLabel anotherName = new JLabel(vo.guestTeam.photo,JLabel.CENTER);
		anotherName.setFont(new Font("Dialog",1,15));
		anotherName.setForeground(Color.WHITE);
		anotherName.setBounds(0,40,35,20);
		scoreLabel.add(anotherName);

		this.add(scoreLabel);
		setPartialScoreGroupsLabel();
	}

	public void setMatchDataAnalysePanel(){
		String[] msg = {vo.homeTeam.location+" "+vo.homeTeam.name,"teamsPNG/"+vo.homeTeam.photo+".png",
				vo.guestTeam.location+" "+vo.guestTeam.name,"teamsPNG/"+vo.guestTeam.photo+".png"};
		matchDataAnalysePanel = new MatchDataAnalysePanel(vo.homeTeamPlayer,vo.guestTeamPlayer,msg);
		this.add(matchDataAnalysePanel);
		repaint();
	}


	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new MatchAnalyseTopPanel(1));
		jf.setVisible(true);
	}

}

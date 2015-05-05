package presentation.match;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.PhotoLabel;

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
	
	public MatchAnalyseTopPanel(){
		this.setLayout(null);
		this.setBounds(0, 0, 1280,700);
		this.setBackground(Color.WHITE);
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
		dateLabel = new JLabel("10月7日",JLabel.CENTER);
		dateLabel.setFont(new Font("Dialog",1,15));
		dateLabel.setForeground(Color.DARK_GRAY);
		dateLabel.setBackground(Color.LIGHT_GRAY);
		dateLabel.setOpaque(true);
		dateLabel.setBounds(500,0,230,30);
		this.add(dateLabel);
	}
	
	private void setsetLocalTeamPhotoLabel(){
		localTeamPhotoLabel = new PhotoLabel(new ImageIcon("teamsPNG/ATL.png").getImage());
//		localTeamPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		localTeamPhotoLabel.setBounds(350,0,200,150);
		localTeamPhotoLabel.setBackground(Color.WHITE);
		localTeamPhotoLabel.setOpaque(true);
		localTeamPhotoLabel.setVisible(true);
		this.add(localTeamPhotoLabel);
	}
	
	public void setAnotherTeamPhotoLabel (){
		anotherTeamPhotoLabel = new PhotoLabel(new ImageIcon("teamsPNG/ATL.png").getImage());
		anotherTeamPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		anotherTeamPhotoLabel.setBounds(730,0,180,150);
		anotherTeamPhotoLabel.setBackground(Color.white);
		anotherTeamPhotoLabel.setOpaque(true);
		anotherTeamPhotoLabel.setVisible(true);
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

		JLabel localScore = new JLabel("87",JLabel.CENTER);
		localScore.setFont(new Font("Dialog",1,30));
		localScore.setForeground(Color.WHITE);
		localScore.setBounds(250,0,100,55);
		localInfoGroupsLabel.add(localScore);

		JLabel playerName = new JLabel("新奥尔良 鹈鹕",JLabel.CENTER);
		playerName.setFont(new Font("Dialog",1,20));
		playerName.setForeground(Color.WHITE);
		playerName.setBounds(55,0,180,55);
		localInfoGroupsLabel.add(playerName);
		
		this.add(localInfoGroupsLabel);
	}
	
	public void setAnotherInfoGroupsLabel(){
		anotherInfoGroupsLabel = new JLabel();
		anotherInfoGroupsLabel.setBounds(910,85,370,67);
		anotherInfoGroupsLabel.setOpaque(true);
		anotherInfoGroupsLabel.setBackground(Color.BLACK);
		
		JLabel anotherNum = new JLabel("93",JLabel.CENTER);
		anotherNum.setFont(new Font("Dialog",1,30));
		anotherNum.setForeground(Color.WHITE);
		anotherNum.setBounds(0,0,100,55);
		anotherInfoGroupsLabel.add(anotherNum);
		
		JLabel anotherName = new JLabel("亚特兰大 老鹰");
		anotherName.setFont(new Font("Dialog",1,20));
		anotherName.setForeground(Color.WHITE);
		anotherName.setBounds(100,0,180,55);
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
		
		for(int i = 0 ; i < 5 ; i++){
			if(i == 4){
				partialScoreLabelGroups.add(setSinglePartialScoreLabel("","24","32"));
			}else{
				partialScoreLabelGroups.add(setSinglePartialScoreLabel(i+1+"","24","32"));
			}
		}
		
		scoreLabel.add(partialScoreLabelGroups);
	}
	
	
	//整个记分板
	public void setScoreLabel(){
		scoreLabel = new JLabel();
		scoreLabel.setBounds(350,150,560,62);
		scoreLabel.setOpaque(true);
		scoreLabel.setBackground(Color.LIGHT_GRAY);
		
		JLabel name = new JLabel("鹈鹕",JLabel.CENTER);
		name.setFont(new Font("Dialog",1,15));
		name.setForeground(Color.WHITE);
		name.setBounds(0,20,35,20);
		scoreLabel.add(name);
		
		JLabel anotherName = new JLabel("老鹰",JLabel.CENTER);
		anotherName.setFont(new Font("Dialog",1,15));
		anotherName.setForeground(Color.WHITE);
		anotherName.setBounds(0,40,35,20);
		scoreLabel.add(anotherName);

		this.add(scoreLabel);
		setPartialScoreGroupsLabel();
	}

	public void setMatchDataAnalysePanel(){
		matchDataAnalysePanel = new MatchDataAnalysePanel();
		this.add(matchDataAnalysePanel);
		repaint();
	}


	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new MatchAnalyseTopPanel());
		jf.setVisible(true);
	}

}

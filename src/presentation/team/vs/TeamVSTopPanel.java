package presentation.team.vs;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.PhotoLabel;

public class TeamVSTopPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel localTeamPhotoLabel;
	JLabel anotherTeamPhotoLabel;
	JLabel VSUpLabel;
	JLabel VSDownLabel;
	JLabel localInfoGroupsLabel;
	JLabel anotherInfoGroupsLabel;
	
	JLabel searchLabel;

	Color lightest = new Color(46,110,180);
	Color light = new Color(33,82,138);
	Color darkest = new Color(29,72,121);
	
	public TeamVSTopPanel(){
		this.setLayout(null);
		this.setBounds(0, 0, 1280,197);
		this.setBackground(Color.WHITE);
		setLocalTeamPhotoLabel();
		setAnotherTeamPhotoLabel();
		setVSUpLabel();
		setVSDownLabel();
		setLocalInfoGroupsLabel();
		setAnotherInfoGroupsLabel();
	}
	
	public void setLocalTeamPhotoLabel (){
		localTeamPhotoLabel = new PhotoLabel(new ImageIcon("teamsPNG/ATL.png").getImage());
		localTeamPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		localTeamPhotoLabel.setBounds(300,-5,230,150);
		localTeamPhotoLabel.setBackground(Color.WHITE);
		localTeamPhotoLabel.setOpaque(true);
		localTeamPhotoLabel.setVisible(true);
		this.add(localTeamPhotoLabel);
	}
	
	public void setAnotherTeamPhotoLabel (){
		anotherTeamPhotoLabel = new PhotoLabel(new ImageIcon("teamsPNG/BOS.png").getImage());
		anotherTeamPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		anotherTeamPhotoLabel.setBounds(730,-5,230,150);
		anotherTeamPhotoLabel.setBackground(Color.WHITE);
		anotherTeamPhotoLabel.setOpaque(true);
		anotherTeamPhotoLabel.setVisible(true);
		this.add(anotherTeamPhotoLabel);
	}

	public void setLocalInfoGroupsLabel(){
		localInfoGroupsLabel = new JLabel();
		localInfoGroupsLabel.setBounds(0,145,535,55);
		localInfoGroupsLabel.setOpaque(true);
		localInfoGroupsLabel.setBackground(light);

		JLabel playerName = new JLabel("亚特兰大",JLabel.RIGHT);
		playerName.setFont(new Font("Dialog",1,13));
		playerName.setForeground(Color.WHITE);
		playerName.setBounds(335,5,180,15);
		localInfoGroupsLabel.add(playerName);
		
		JLabel playerPos = new JLabel("凯尔特人",JLabel.RIGHT);
		playerPos.setFont(new Font("Dialog",1,18));
		playerPos.setForeground(Color.WHITE);
		playerPos.setBounds(415,20,100,30);
		localInfoGroupsLabel.add(playerPos);

		this.add(localInfoGroupsLabel);
	}
	
	public void setAnotherInfoGroupsLabel(){
		anotherInfoGroupsLabel = new JLabel();
		anotherInfoGroupsLabel.setBounds(715,145,565,55);
		anotherInfoGroupsLabel.setOpaque(true);
		anotherInfoGroupsLabel.setBackground(light);
		
		JLabel anotherName = new JLabel("波士顿",JLabel.LEADING);
		anotherName.setFont(new Font("Dialog",1,13));
		anotherName.setForeground(Color.WHITE);
		anotherName.setBounds(15,5,180,15);
		anotherInfoGroupsLabel.add(anotherName);
		
		JLabel anotherPos = new JLabel("凯尔特人");
		anotherPos.setFont(new Font("Dialog",1,18));
		anotherPos.setForeground(Color.WHITE);
		anotherPos.setBounds(15,20,180,30);
		anotherInfoGroupsLabel.add(anotherPos);

		this.add(anotherInfoGroupsLabel);
	}

	
	public void setSearchLabel(){
//		searchLabel = new JLabel("球队对比",JLabel.CENTER);
//		searchLabel.setFont(new Font("Dialog",1,30));
//		searchLabel.setForeground(Color.GRAY);
//		searchLabel.setBounds(535,35,180,60);
		this.add(searchLabel);
	}

	public void setVSUpLabel(){
		VSUpLabel = new JLabel("球队对比",JLabel.CENTER);
		VSUpLabel.setFont(new Font("Dialog",1,30));
		VSUpLabel.setForeground(Color.GRAY);
		VSUpLabel.setBounds(535,35,180,60);
		this.add(VSUpLabel);
	}

	public void setVSDownLabel(){
		VSDownLabel = new JLabel("VS",JLabel.CENTER);
		VSDownLabel.setFont(new Font("Dialog",1,30));
		VSDownLabel.setForeground(Color.WHITE);
		VSDownLabel.setBackground(lightest);
		VSDownLabel.setOpaque(true);
		VSDownLabel.setBounds(535,145,180,55);
		this.add(VSDownLabel);
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new TeamVSTopPanel());
		jf.setVisible(true);
	}

}

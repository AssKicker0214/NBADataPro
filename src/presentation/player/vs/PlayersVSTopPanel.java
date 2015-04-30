package presentation.player.vs;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.PhotoLabel;

public class PlayersVSTopPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel localPlayerPhotoLabel;
	JLabel anotherPlayerPhotoLabel;
	JLabel localTeamPhotoLabel;
	JLabel anotherTeamPhotoLabel;
	JLabel VSUpLabel;
	JLabel VSDownLabel;
	JLabel localInfoGroupsLabel;
	JLabel anotherInfoGroupsLabel;
	
	Color lightest = new Color(46,110,180);
	Color light = new Color(33,82,138);
	Color darkest = new Color(29,72,121);

	public PlayersVSTopPanel(){
		this.setLayout(null);
		this.setBounds(0, 0, 1280,265);
		this.setBackground(Color.WHITE);
		setLocalPlayerPhotoLabel();
		setAnotherPlayerPhotoLabel();
		setLocalTeamPhotoLabel();
		setAnotherTeamPhotoLabel();
		setVSUpLabel();
		setVSDownLabel();
		setLocalInfoGroupsLabel();
		setAnotherInfoGroupsLabel();
	}
	
	public void setLocalPlayerPhotoLabel (){
		localPlayerPhotoLabel = new PhotoLabel(new ImageIcon("1.png").getImage());
		localPlayerPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		localPlayerPhotoLabel.setBounds(300,20,230,180);
		localPlayerPhotoLabel.setBackground(Color.WHITE);
		localPlayerPhotoLabel.setOpaque(true);
		localPlayerPhotoLabel.setVisible(true);
		this.add(localPlayerPhotoLabel);
	}
	
	public void setLocalTeamPhotoLabel (){
		localTeamPhotoLabel = new PhotoLabel(new ImageIcon("teamsPNG/ATL.png").getImage());
		localTeamPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		localTeamPhotoLabel.setBounds(140,20,250,150);
		localTeamPhotoLabel.setBackground(Color.WHITE);
		localTeamPhotoLabel.setOpaque(true);
		localTeamPhotoLabel.setVisible(true);
		this.add(localTeamPhotoLabel);
	}
	
		
	public void setVSUpLabel(){
		VSUpLabel = new JLabel("球员对比",JLabel.CENTER);
		VSUpLabel.setFont(new Font("Dialog",1,30));
		VSUpLabel.setForeground(Color.GRAY);
		VSUpLabel.setBounds(535,35,180,60);
		this.add(VSUpLabel);
	}
	
	public void setAnotherTeamPhotoLabel (){
		anotherTeamPhotoLabel = new PhotoLabel(new ImageIcon("teamsPNG/ATL.png").getImage());
		anotherTeamPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		anotherTeamPhotoLabel.setBounds(955,20,250,150);
		anotherTeamPhotoLabel.setBackground(Color.WHITE);
		anotherTeamPhotoLabel.setOpaque(true);
		anotherTeamPhotoLabel.setVisible(true);
		this.add(anotherTeamPhotoLabel);
	}

	public void setAnotherPlayerPhotoLabel (){
		anotherPlayerPhotoLabel = new PhotoLabel(new ImageIcon("1.png").getImage());
		anotherPlayerPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		anotherPlayerPhotoLabel.setBounds(730,20,230,180);
		anotherPlayerPhotoLabel.setBackground(Color.WHITE);
		anotherPlayerPhotoLabel.setOpaque(true);
		anotherPlayerPhotoLabel.setVisible(true);
		this.add(anotherPlayerPhotoLabel);
	}
	
	public void setLocalInfoGroupsLabel(){
		localInfoGroupsLabel = new JLabel();
		localInfoGroupsLabel.setBounds(0,205,535,60);
		localInfoGroupsLabel.setOpaque(true);
		localInfoGroupsLabel.setBackground(light);

		JLabel playerNum = new JLabel("4",JLabel.CENTER);
		playerNum.setFont(new Font("Dialog",1,30));
		playerNum.setForeground(Color.WHITE);
		playerNum.setBackground(darkest);
		playerNum.setOpaque(true);
		playerNum.setBounds(0,0,100,60);
		localInfoGroupsLabel.add(playerNum);

		JLabel playerName = new JLabel("Jordan-Adams",JLabel.CENTER);
		playerName.setFont(new Font("Dialog",1,20));
		playerName.setForeground(Color.WHITE);
		playerName.setBounds(355,5,180,30);
		localInfoGroupsLabel.add(playerName);
		
		JLabel playerPos = new JLabel("前锋"+" / "+"纽约",JLabel.CENTER);
		playerPos.setFont(new Font("Dialog",1,15));
		playerPos.setForeground(Color.WHITE);
		playerPos.setBounds(390,40,180,15);
		localInfoGroupsLabel.add(playerPos);

		this.add(localInfoGroupsLabel);
	}
	
	public void setAnotherInfoGroupsLabel(){
		anotherInfoGroupsLabel = new JLabel();
		anotherInfoGroupsLabel.setBounds(715,205,565,60);
		anotherInfoGroupsLabel.setOpaque(true);
		anotherInfoGroupsLabel.setBackground(light);
		
		JLabel anotherNum = new JLabel("4",JLabel.CENTER);
		anotherNum.setFont(new Font("Dialog",1,30));
		anotherNum.setForeground(Color.WHITE);
		anotherNum.setBackground(darkest);
		anotherNum.setOpaque(true);
		anotherNum.setBounds(465,0,100,60);
		anotherInfoGroupsLabel.add(anotherNum);
		
		JLabel anotherName = new JLabel("Jordan-Adams");
		anotherName.setFont(new Font("Dialog",1,20));
		anotherName.setForeground(Color.WHITE);
		anotherName.setBounds(15,5,180,30);
		anotherInfoGroupsLabel.add(anotherName);
		
		JLabel anotherPos = new JLabel("前锋"+" / "+"纽约");
		anotherPos.setFont(new Font("Dialog",1,15));
		anotherPos.setForeground(Color.WHITE);
		anotherPos.setBounds(15,40,180,15);
		anotherInfoGroupsLabel.add(anotherPos);

		this.add(anotherInfoGroupsLabel);
	}
	
	public void setVSDownLabel(){
		VSDownLabel = new JLabel("VS",JLabel.CENTER);
		VSDownLabel.setFont(new Font("Dialog",1,30));
		VSDownLabel.setForeground(Color.WHITE);
		VSDownLabel.setBackground(lightest);
		VSDownLabel.setOpaque(true);
		VSDownLabel.setBounds(535,205,180,60);
		this.add(VSDownLabel);

	}

	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new PlayersVSTopPanel());
		jf.setVisible(true);
	}
}

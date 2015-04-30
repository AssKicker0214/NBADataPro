package presentation.player.playerDetail;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PlayerDetailFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	JPanel playerDetailTopPanel;
	
	public  PlayerDetailFrame(){ 
		setLayout(null);
		setUndecorated(true);
		setSize(1280,700);
		setLocationRelativeTo(null);
		setPlayerTitleLabel();
		setPlayerMiddlePanel();
		setVisible(true);
	}
	
	
	private void setPlayerTitleLabel(){
		JLabel titleLabel = new JLabel("      player title");
		titleLabel.setBounds(0, 0, 1280,30);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(Color.black);
		titleLabel.setOpaque(true);
		this.add(titleLabel);
	
	}
	
/*	
	public void setTopPanel (){
		playerDetailTopPanel = new PlayerDetailTopPanel();
		this.add(playerDetailTopPanel);
	}
*/	
	public void setPlayerMiddlePanel(){
		this.add(new PlayerMiddlePanel());
	}
	
	public static void main(String[] args){
		new PlayerDetailFrame();
	}
	
}

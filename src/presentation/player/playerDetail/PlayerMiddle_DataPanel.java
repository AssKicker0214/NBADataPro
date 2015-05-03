package presentation.player.playerDetail;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

//资料
public class PlayerMiddle_DataPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	PlayerMiddle_ContrastLeaguePanel contrastPanel;
	PlayerMiddle_SeasonDataPanel seasonDataPanel;
	
	public PlayerMiddle_DataPanel(){
		this.setLayout(null);
		this.setBounds(0, 250,1280,400);
		this.setBackground(Color.WHITE);
//		setContrastPanel();
//		setSeasonPanel();
	}
	
	public void setContrastPanel(ArrayList<Double> player,ArrayList<Double> leagueAvg){
		contrastPanel = new PlayerMiddle_ContrastLeaguePanel(player,leagueAvg);
		this.add(contrastPanel);
		repaint();
	}
	
	public void setSeasonPanel(ArrayList<String> avg,ArrayList<String> total){
		seasonDataPanel = new PlayerMiddle_SeasonDataPanel(avg, total);
		this.add(seasonDataPanel);
		repaint();
	}
	
}

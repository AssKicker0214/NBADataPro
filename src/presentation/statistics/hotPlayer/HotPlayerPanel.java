package presentation.statistics.hotPlayer;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.SelectLabel;

public class HotPlayerPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel TitleLabel;
	HotPlayerOptionsPanel optionsPanel;
	
	Color entered = new Color(30,80,140);
	Color pressed = new Color(42,109,183);
	Color exicted= new Color(26,70,122);
	
	ArrayList<SelectLabel> selectLabelGroups = new ArrayList<SelectLabel>();
	
	public HotPlayerPanel(){
		this.setLayout(null);
		this.setBounds(150, 155, 1280, 550);
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		setTitle("  进步最快球员");
		setOptionsPanel();
	}

	public void setTitle(String text){
		TitleLabel = new JLabel(text,JLabel.LEADING);
		TitleLabel.setFont(new Font("Dialog",1,20));
		TitleLabel.setForeground(Color.WHITE);
		TitleLabel.setBackground(entered);
		TitleLabel.setOpaque(true);
		TitleLabel.setBounds(0,0,1130,75);
		this.add(TitleLabel);
		this.updateUI();
		//new Color(33,82,138)
	}
	
	public void setOptionsPanel(){
		 optionsPanel = new HotPlayerOptionsPanel();
		 this.add(optionsPanel);
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new HotPlayerPanel());
		jf.setVisible(true);
	}



}

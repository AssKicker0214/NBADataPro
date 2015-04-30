package presentation.player.playerDetail;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.table.TablePane;


public class PlayerMiddle_SeasonDataPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel seasonDataTitleLabel;
	
	JLabel tabelLabel;
	
	JLabel titlesLabel;
	JLabel SeansonAvgLabel;
	JLabel SeansonAvgContentLabel;
	JLabel SeasonTotalLabel;
	JLabel SeasonTotalConetentLabel;
	
	

	public PlayerMiddle_SeasonDataPanel(){
		this.setLayout(null);
		this.setBounds(0, 250, 1280,180);
		setSeasonDataTitleLabel();
		this.setBackground(Color.WHITE);
		setTabel();
	}
	
	public void setSeasonDataTitleLabel(){
		seasonDataTitleLabel = new JLabel("   赛季数据",JLabel.LEADING);
		seasonDataTitleLabel.setFont(new Font("Dialog",1,20));
		seasonDataTitleLabel.setForeground(Color.WHITE);
		seasonDataTitleLabel.setBackground(new Color(33,82,138));
		seasonDataTitleLabel.setOpaque(true);
		seasonDataTitleLabel.setBounds(0,0,1280,50);
		this.add(seasonDataTitleLabel);
	}
	
	public void setGroups(){
		tabelLabel.setLayout(new GridLayout(5,1,0,0));
		tabelLabel.setBounds(0, 0, 200,500);
		tabelLabel.setBackground(Color.WHITE);
		tabelLabel.setOpaque(true);
		tabelLabel.setVisible(true);

		this.add(tabelLabel);
		
		
		
		seasonDataTitleLabel = new JLabel("   赛季数据",JLabel.LEADING);
		seasonDataTitleLabel.setFont(new Font("Dialog",1,20));
		seasonDataTitleLabel.setForeground(Color.WHITE);
		seasonDataTitleLabel.setBackground(new Color(33,82,138));
		seasonDataTitleLabel.setOpaque(true);
		seasonDataTitleLabel.setBounds(0,0,1280,50);
		this.add(seasonDataTitleLabel);

		
	}
	
	public void setFixedLabel(){
		seasonDataTitleLabel = new JLabel("年度      " + "球队"+""+""+""+""+""+""+""+""+""+""+""+""+"" );
		seasonDataTitleLabel.setFont(new Font("Dialog",1,20));
		seasonDataTitleLabel.setForeground(Color.WHITE);
		seasonDataTitleLabel.setBackground(new Color(33,82,138));
		seasonDataTitleLabel.setOpaque(true);
		seasonDataTitleLabel.setBounds(0,0,1280,50);
		this.add(seasonDataTitleLabel);
	}
	
	public void setTabel(){
		ArrayList<String> l1 = new ArrayList<String>();
		l1.add("teamsPNG/ATL.png");
		l1.add("0.1");
		l1.add("0.2");
		l1.add("0.1");
		l1.add("0.2");
		
		ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
		a.add(l1);
		a.add(l1);
		a.add(l1);
		a.add(l1);
		a.add(l1);
		a.add(l1);
		a.add(l1);
		a.add(l1);
		a.add(l1);
		a.add(l1);
		String[] b = {"","**","**","**","**"};
		
		ArrayList<Integer> w = new ArrayList<Integer>();
		w.add(50);
		w.add(100);
		w.add(200);
		w.add(300);
		w.add(400);

		TablePane t = new TablePane(a,b,w,0,19,1200,200,50,false);
		this.add(t);
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new PlayerMiddle_SeasonDataPanel());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

}

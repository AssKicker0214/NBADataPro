package presentation.team.teamDetail;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.table.TablePane;

public class TeamRecent5MatchPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel Recent5MatchLabel;
	
	JLabel tabelLabel;
	
	public TeamRecent5MatchPanel(){
		this.setLayout(null);
		this.setBounds(0, 265,1280,400);
		setRecent5MactchTitleLabel();
		this.setBackground(Color.WHITE);
		setTabel();
	}

	public void setRecent5MactchTitleLabel(){
		Recent5MatchLabel = new JLabel("  最近5场比赛",JLabel.LEADING);
		Recent5MatchLabel.setFont(new Font("Dialog",1,20));
		Recent5MatchLabel.setForeground(Color.WHITE);
		Recent5MatchLabel.setBackground(new Color(33,82,138));
//		Recent5MatchLabel.setBackground(Color.DARK_GRAY);
		Recent5MatchLabel.setOpaque(true);
		Recent5MatchLabel.setBounds(0,0,1280,50);
		this.add(Recent5MatchLabel);
	}
 
	public void setTabel(){
		String[] columns = {"日期","对阵球队","总比分","第一节比分","第二节比分","第三节比分","第四节比分","比赛链接"};
		
		ArrayList<String> l = new ArrayList<String>();
		for(int i = 0; i < 8;i++){
			l.add("20.0");
		}
		ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < 5 ;i++){
			a.add(l);
		}
		
		ArrayList<Integer> w = new ArrayList<Integer>();
		for(int i = 0; i < 8 ; i++){
			w.add(160);
		}

		TablePane t = new TablePane(a,columns,w,0,50,1280,400,60,true,false);
		this.add(t);
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		
		jf.add(new TeamRecent5MatchPanel());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

}

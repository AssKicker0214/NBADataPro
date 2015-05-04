package presentation.team.teamDetail;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.table.TablePane;

public class TeamDataPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel teamSeasonDataTitleLabel;
	
	JLabel tabelLabel;
	
	public TeamDataPanel(){
		this.setLayout(null);
		this.setBounds(0, 265,1280,430);
		setSeasonDataTitleLabel();
		this.setBackground(Color.WHITE);
		setTabel();
	}
	
	public void setSeasonDataTitleLabel(){
		teamSeasonDataTitleLabel = new JLabel("   赛季数据",JLabel.LEADING);
		teamSeasonDataTitleLabel.setFont(new Font("Dialog",1,20));
		teamSeasonDataTitleLabel.setForeground(Color.WHITE);
		teamSeasonDataTitleLabel.setBackground(new Color(33,82,138));
//		teamSeasonDataTitleLabel.setBackground(Color.DARK_GRAY);
		teamSeasonDataTitleLabel.setOpaque(true);
		teamSeasonDataTitleLabel.setBounds(0,0,1280,50);
		this.add(teamSeasonDataTitleLabel);
	}

	public void setTabel(){
		String[] columns = {"年度","场数","％","三分％","罚球％","进攻","防守",
				"场均篮板","场均助攻","场均抢断","场均盖帽","失误","犯规","场均得分"};
		
		ArrayList<String> seasonAvgItem = new ArrayList<String>();
		seasonAvgItem.add("赛季平均"); 
		for(int i = 0; i < 13 ; i++){
			seasonAvgItem.add(" ");
		}

		ArrayList<String> seasonTotalItem = new ArrayList<String>();
		seasonTotalItem.add("赛季总计"); 
		for(int i = 0; i < 13 ; i++){
			seasonTotalItem.add(" ");
		}
		
		ArrayList<String> avg = new ArrayList<String>();
		ArrayList<String> total = new ArrayList<String>();
		
		for(int i = 0; i < 14;i++){
			avg.add("8");
			total.add("10");
		}
		
		ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
		a.add(seasonAvgItem);
		a.add(avg);
		a.add(seasonTotalItem);
		a.add(total);
		
		ArrayList<Integer> w = new ArrayList<Integer>();
		for(int i = 0; i < 14 ; i++){
			w.add(90);
		}

		TablePane t = new TablePane(a,columns,w,0,50,1280,200,30,false,false);
		this.add(t);
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		
		jf.add(new TeamDataPanel());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

}

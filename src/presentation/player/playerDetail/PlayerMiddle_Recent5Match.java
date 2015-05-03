package presentation.player.playerDetail;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.table.TablePane;

public class PlayerMiddle_Recent5Match extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel Recent5MatchLabel;
	
	JLabel tabelLabel;

	
	public PlayerMiddle_Recent5Match(){
		this.setLayout(null);
		this.setBounds(0, 430, 1280,220);
		setRecent5MactchTitleLabel();
		this.setBackground(Color.WHITE);
		setTabel();
	}
	
	public void setRecent5MactchTitleLabel(){
		Recent5MatchLabel = new JLabel("   赛季数据",JLabel.LEADING);
		Recent5MatchLabel.setFont(new Font("Dialog",1,20));
		Recent5MatchLabel.setForeground(Color.WHITE);
//		seasonDataTitleLabel.setBackground(new Color(33,82,138));
		Recent5MatchLabel.setBackground(Color.DARK_GRAY);
		Recent5MatchLabel.setOpaque(true);
		Recent5MatchLabel.setBounds(0,0,1280,50);
		this.add(Recent5MatchLabel);
	}

	public void setTabel(){
		String[] columns = {"年度","球队","场数","先发","分钟","％","三分％","罚球％",
				"进攻","防守","场均篮板","场均助攻","场均抢断","场均盖帽","失误","犯规","场均得分"};
		ArrayList<String> items = new ArrayList<String>();
		items.add("年度"); items.add("球队");items.add("场数");
		items.add("先发"); items.add("分钟");items.add("％");
		items.add("三分％"); items.add("罚球％"); items.add("进攻");
		items.add("防守"); items.add("场均篮板"); items.add("场均助攻");
		items.add("场均抢断"); items.add("场均盖帽"); items.add("失误");
		items.add("犯规"); items.add("场均得分");
		
		ArrayList<String> seasonAvgItem = new ArrayList<String>();
		seasonAvgItem.add("赛季平均"); 
		for(int i = 0; i < 16 ; i++){
			seasonAvgItem.add(" ");
		}

		ArrayList<String> seasonTotalItem = new ArrayList<String>();
		seasonTotalItem.add("赛季总计"); 
		for(int i = 0; i < 16 ; i++){
			seasonTotalItem.add(" ");
		}
		
		ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
		a.add(seasonAvgItem);
		a.add(avg);
		a.add(seasonTotalItem);
		a.add(total);
		
		ArrayList<Integer> w = new ArrayList<Integer>();
		for(int i = 0; i < 17 ; i++){
			w.add(85);
		}

		TablePane t = new TablePane(a,columns,w,0,50,1280,200,30,false,false);
		this.add(t);
	}


}

package presentation.player.playerDetail;

import java.awt.Color;
import java.awt.Font;
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
	
	public PlayerMiddle_SeasonDataPanel(ArrayList<String> avg,ArrayList<String> total){
		this.setLayout(null);
		this.setBounds(0, 430, 1280,220);
		setSeasonDataTitleLabel();
		this.setBackground(Color.WHITE);
		setTabel(avg,total);
	}
	
	public void setSeasonDataTitleLabel(){
		seasonDataTitleLabel = new JLabel("   赛季数据",JLabel.LEADING);
		seasonDataTitleLabel.setFont(new Font("Dialog",1,20));
		seasonDataTitleLabel.setForeground(Color.WHITE);
//		seasonDataTitleLabel.setBackground(new Color(33,82,138));
		seasonDataTitleLabel.setBackground(Color.DARK_GRAY);
		seasonDataTitleLabel.setOpaque(true);
		seasonDataTitleLabel.setBounds(0,0,1280,50);
		this.add(seasonDataTitleLabel);
	}
	
	
	
	public void setTabel(ArrayList<String> avg,ArrayList<String> total ){
		String[] columns = {"年度","球队","场数","先发","分钟","％","三分％","罚球％",
				"进攻","防守","场均篮板","场均助攻","场均抢断","场均盖帽","失误","犯规","场均得分"};
		
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
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		
		ArrayList<String> avg = new ArrayList<String>();
		ArrayList<String> total = new ArrayList<String>();
		
		for(int i = 0; i < 17;i++){
			avg.add("8");
			total.add("10");
		}
		jf.add(new PlayerMiddle_SeasonDataPanel(avg,total));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

}

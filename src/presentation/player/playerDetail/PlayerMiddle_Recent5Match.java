package presentation.player.playerDetail;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
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

	
	public PlayerMiddle_Recent5Match(String playerName){
		this.setLayout(null);
		this.setBounds(0, 255,1280,400);
		setRecent5MactchTitleLabel(playerName);
		this.setBackground(Color.WHITE);
		setTabel();
	}
	
	public void setRecent5MactchTitleLabel(String playerName){
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
		String[] columns = {"日期","对手","分钟","％","命中","出手","三分％","罚球％",
				"进攻","防守","篮板","助攻","抢断","盖帽","失误","犯规","得分"};
				
		ArrayList<String> l = new ArrayList<String>();
		for(int i = 0; i < 17;i++){
			l.add("20.0");
		}
		ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < 5 ;i++){
			a.add(l);
		}
		
		ArrayList<Integer> w = new ArrayList<Integer>();
		for(int i = 0; i < 17 ; i++){
			w.add(85);
		}

		TablePane t = new TablePane(a,columns,w,0,50,1280,400,60,true,false);
		this.add(t);
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		
//		jf.add(new PlayerMiddle_Recent5Match());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}


}

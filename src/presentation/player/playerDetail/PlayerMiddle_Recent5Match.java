package presentation.player.playerDetail;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataservice.match.MatchDataService;
import dataservice.match.MatchData_stub;
import presentation.match.MatchVO2List;
import presentation.table.TablePane;
import vo.matchvo.MatchContentPlayerVO;

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
		setRecent5MactchTitleLabel();
		this.setBackground(Color.WHITE);
		setTabel(playerName);
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

	public void setTabel(String playerName){
		MatchDataService mds = new MatchData_stub();
		ArrayList<MatchContentPlayerVO> vo = mds.FindRecentMatches_p(playerName);
		String[] columns = {"日期","对手","分钟","％","命中","出手","三分％","罚球％",
				"进攻篮板","防守篮板","篮板","助攻","盖帽","失误","犯规","得分"};
				
		MatchVO2List m2l = new MatchVO2List();
		ArrayList<ArrayList<String>> datas = m2l.playerDeitail(vo);
		
		ArrayList<Integer> w = new ArrayList<Integer>();
		w.add(200);w.add(200);
		for(int i = 0; i < 14 ; i++){
			w.add(60);
		}

		TablePane t = new TablePane(datas,columns,w,0,50,1280,400,60,true,false);
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

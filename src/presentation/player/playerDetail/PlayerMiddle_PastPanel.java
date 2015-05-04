package presentation.player.playerDetail;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataservice.match.MatchDataService;
import dataservice.match.MatchData_stub;
import presentation.common.DateLabel;
import presentation.match.MatchVO2List;
import presentation.table.TablePane;
import vo.matchvo.MatchContentPlayerVO;

public class PlayerMiddle_PastPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel CheckPastPanel;
	
	JLabel tabelLabel;
	
	public PlayerMiddle_PastPanel(String playerName){
		this.setLayout(null);
		this.setBounds(0, 255,1280,420);
		setPastTitleLabel();
		setBeginDate();
		setEndDate();
		this.setBackground(Color.WHITE);
		setTabel(playerName);
	}
	
	public void setPastTitleLabel(){
		CheckPastPanel = new JLabel("  过往比赛查询",JLabel.LEADING);
		CheckPastPanel.setFont(new Font("Dialog",1,20));
		CheckPastPanel.setForeground(Color.WHITE);
		CheckPastPanel.setBackground(new Color(33,82,138));
//		Recent5MatchLabel.setBackground(Color.DARK_GRAY);
		CheckPastPanel.setOpaque(true);
		CheckPastPanel.setBounds(0,0,1280,50);
		this.add(CheckPastPanel);
	}
	
	public void setBeginDate(){
		DateLabel calendar = new DateLabel();
		calendar.setBounds(1000,-25,100,100);
		CheckPastPanel.add(calendar);
	}
	
	public void setEndDate(){
		DateLabel calendar = new DateLabel();
		calendar.setBounds(1150,-25,100,100);
		CheckPastPanel.add(calendar);
//		System.out.println(calendar.getSelectedDate());
	}

	
	public void setTabel(String playerName){
		MatchDataService mds = new MatchData_stub();
		ArrayList<MatchContentPlayerVO> vo = mds.FindRecentMatches_p(5, playerName);
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
		
//		jf.add(new PlayerMiddle_PastPanel());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}



}

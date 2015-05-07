package presentation.player.playerDetail;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataservice.match.MatchDataService;
import dataservice.match.MatchDataHandel;
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
	JLabel commit;
	
	String PlayerName;
	
	public PlayerMiddle_PastPanel(String player){
		PlayerName = player;
		this.setLayout(null);
		this.setBounds(0, 255,1280,420);
		setPastTitleLabel();
		setDate();
		this.setBackground(Color.WHITE);
		SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		setTabel(date,date);
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
	
	public void setDate(){
		DateLabel calendarStart = new DateLabel();
		calendarStart.setBounds(900,-25,100,100);
		CheckPastPanel.add(calendarStart);
	
		DateLabel calendarEnd = new DateLabel();
		calendarEnd.setBounds(1000,-25,100,100);
		CheckPastPanel.add(calendarEnd);
		
		commit = new JLabel("commit");
		commit.setForeground(Color.WHITE);
		commit.setFont(new Font("Dialog",0,15));
		commit.setBounds(1110,0,1280,50);
		commit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				commit.setFont(new Font("Dialog",1,15));
				setTabel(calendarStart.getSelectedDate().toString().substring(2,10),calendarEnd.getSelectedDate().toString().substring(2,10));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				commit.setCursor(new Cursor(Cursor.HAND_CURSOR));	
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		CheckPastPanel.add(commit);
	}

	
	public void setTabel(String start,String end){
		MatchDataService mds = new MatchDataHandel();
		System.out.println(start+end+PlayerName);
		ArrayList<MatchContentPlayerVO> vo = mds.findByDP(start, end, PlayerName);
		String[] columns = {"日期","","对手","分钟","％","命中","出手","三分％","罚球％",
				"进攻篮板","防守篮板","篮板","助攻","盖帽","失误","犯规","得分"};
				
		MatchVO2List m2l = new MatchVO2List();
		ArrayList<ArrayList<String>> datas = m2l.playerDeitail(vo);
		
		ArrayList<Integer> w = new ArrayList<Integer>();
		w.add(200);w.add(0);w.add(200);
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

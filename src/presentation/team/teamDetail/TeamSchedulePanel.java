package presentation.team.teamDetail;

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
import vo.matchvo.MatchVO;

public class TeamSchedulePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel TitleLabel;
	
	TablePane scheduleInfoTable;
	
	JLabel commit;

	Color entered = new Color(30,80,140);
	
	String TeamName;
	
	public TeamSchedulePanel(String team){
		TeamName = team;
		this.setLayout(null);
		this.setBounds(0,260,1280,450);
		this.setBackground(Color.WHITE);
		setTitle();
		setDate();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		setScheduleTablePanel(date,date);
	}
	
	public void setTitle(){
		TitleLabel = new JLabel(" 球队赛程",JLabel.LEADING);
		TitleLabel.setFont(new Font("Dialog",1,20));
		TitleLabel.setForeground(Color.WHITE);
		TitleLabel.setBackground(entered);
		TitleLabel.setOpaque(true);
		TitleLabel.setBounds(0,0,1280,60);
		this.add(TitleLabel);
		this.updateUI();
	}
	
	public void setDate(){
		DateLabel calendarStart = new DateLabel();
		calendarStart.setBounds(900,-25,100,100);
		TitleLabel.add(calendarStart);
	
		DateLabel calendarEnd = new DateLabel();
		calendarEnd.setBounds(1000,-25,100,100);
		TitleLabel.add(calendarEnd);
		
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
				setScheduleTablePanel(calendarStart.getSelectedDate().toString(),calendarEnd.getSelectedDate().toString());

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
		TitleLabel.add(commit);
	}
	
	public void setScheduleTablePanel(String start,String end){
		MatchDataService mds = new MatchDataHandel();
		ArrayList<MatchVO> vo = mds.findByDT(start, end, TeamName);
	
		String[] tbHead = {"日期","","对阵球队","总比分","第一节比分","第二节比分","第三节比分","第四节比分"};
		
		MatchVO2List m2l = new MatchVO2List();
		ArrayList<ArrayList<String>> datas = m2l.matchList(vo);
		
		ArrayList<Integer> wid = new ArrayList<Integer>();
		wid.add(180);wid.add(0);
		for(int i = 0; i < 6;i++){
			wid.add(180);
		}
		wid.add(0);
		scheduleInfoTable = new TablePane(datas,tbHead,wid,0,60,1280,300,30,true,false);
		this.add(scheduleInfoTable);
	}

	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
	//	jf.add(new TeamSchedulePanel());
		jf.setVisible(true);
	}

	
}

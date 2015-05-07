package presentation.match;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataservice.Updatable;
import dataservice.match.MatchDataService;
import dataservice.match.MatchDataHandel;
import presentation.common.DateLabel;
import presentation.table.TablePane;
import vo.matchvo.MatchVO;

public class MatchListPanel extends JPanel implements Updatable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel matchTitleLabel;
	
	JLabel tabelLabel;
	
	JLabel commit;
	
	TablePane table;
	
	public MatchListPanel(){
		this.setLayout(null);
		this.setBounds(0,125,1280,540);
		setMatchTitleLabel();
		setDate();
		this.setBackground(Color.WHITE);
		update();
	}

	public void setMatchTitleLabel(){
		matchTitleLabel = new JLabel("  赛程",JLabel.LEADING);
		matchTitleLabel.setFont(new Font("Dialog",1,20));
		matchTitleLabel.setForeground(Color.WHITE);
		matchTitleLabel.setBackground(new Color(33,82,138));
		matchTitleLabel.setOpaque(true);
		matchTitleLabel.setBounds(0,0,1280,70);
		this.add(matchTitleLabel);
	}
	
	public void setDate(){
		DateLabel calendarStart = new DateLabel();
		calendarStart.setBounds(900,0,100,70);
		matchTitleLabel.add(calendarStart);
	
		DateLabel calendarEnd = new DateLabel();
		calendarEnd.setBounds(1000,0,100,70);
		matchTitleLabel.add(calendarEnd);
		
		commit = new JLabel("commit");
		commit.setForeground(Color.WHITE);
		commit.setFont(new Font("Dialog",0,18));
		commit.setBounds(1110,10,100,50);
		commit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				commit.setFont(new Font("Dialog",1,15));
				System.out.println(calendarStart.getSelectedDate().toString().substring(2,10));
				System.out.println(calendarEnd.getSelectedDate().toString().substring(2,10));
				setTabel(calendarStart.getSelectedDate().toString().substring(2,10),calendarEnd.getSelectedDate().toString().substring(2, 10));
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
		matchTitleLabel.add(commit);
	}
	
	public void setTabel(String start,String end){
		
		this.remove(table);
		
		MatchDataService mds = new MatchDataHandel();
		ArrayList<MatchVO> vo = mds.findByDate(start, end);
		
		String[] columns = {"日期","","对阵球队","总比分","第一节比分","第二节比分","第三节比分","第四节比分"};
		
		MatchVO2List m2l = new MatchVO2List();
		ArrayList<ArrayList<String>> datas = m2l.matchList(vo);
		
		ArrayList<Integer> wid = new ArrayList<Integer>();
		wid.add(180);wid.add(0);
		for(int i = 0; i < 6;i++){
			wid.add(180);
		}
		wid.add(0);
		table = new TablePane(datas,columns,wid,0,70,1280,420,30,true,false);
		this.add(table);
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		
		jf.add(new MatchListPanel());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	@Override
	public void update() {
		if(table!=null)
			remove(table);
		MatchDataService mds = new MatchDataHandel();
		ArrayList<MatchVO> vo = mds.findRecent20();//显示最近20场比赛
		
		String[] columns = {"日期","","对阵球队","总比分","第一节比分","第二节比分","第三节比分","第四节比分"};
		
		MatchVO2List m2l = new MatchVO2List();
		ArrayList<ArrayList<String>> datas = m2l.matchList(vo);
		
		ArrayList<Integer> wid = new ArrayList<Integer>();
		wid.add(180);wid.add(0);
		for(int i = 0; i < 6;i++){
			wid.add(180);
		}
		wid.add(0);
		table = new TablePane(datas,columns,wid,0,70,1280,420,30,true,false);
		this.add(table);
		
	}

}

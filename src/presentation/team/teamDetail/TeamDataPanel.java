package presentation.team.teamDetail;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.table.TablePane;
import vo.teamvo.TeamVO;

public class TeamDataPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel teamSeasonDataTitleLabel;
	
	JLabel tabelLabel;
	TeamVO vo;
	
	public TeamDataPanel(TeamVO v){
		vo = v;
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
		String[] columns = {"年度","场数","％","三分％","罚球％","进攻篮板","防守篮板",
				"总篮板","助攻","抢断","盖帽","失误","犯规","得分"};
		
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
		avg.add("2012-2013");avg.add(vo.numOfGame+"");avg.add(vo.shot+"");avg.add(vo.three+"");avg.add(vo.penalty+"");
		avg.add(vo.avgOffendRebound+"");avg.add(vo.avgDefendRebound+"");avg.add(vo.avgRebound+"");avg.add(vo.avgAssist+"");
		avg.add(vo.avgSteal+"");avg.add(vo.avgBlockShot+"");avg.add(vo.avgFault+"");avg.add(vo.avgFoul+"");avg.add(vo.avgPoint+"");
		total.add("2012-2013");total.add(vo.numOfGame+"");total.add(vo.shot+"");total.add(vo.three+"");total.add(vo.penalty+"");
		total.add(vo.offendRebound+"");total.add(vo.defendRebound+"");total.add(vo.rebound+"");total.add(vo.assist+"");
		total.add(vo.steal+"");total.add(vo.blockShot+"");total.add(vo.fault+"");total.add(vo.foul+"");total.add(vo.point+"");

		
		
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
		
	//	jf.add(new TeamDataPanel());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

}

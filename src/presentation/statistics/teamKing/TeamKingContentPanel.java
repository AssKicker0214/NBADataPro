package presentation.statistics.teamKing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.PhotoLabel;
import presentation.main.Mainframe;
import presentation.team.teamDetail.TeamMiddlePanel;
import vo.teamvo.HotTeamsVO;


public class TeamKingContentPanel  extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<HotTeamsVO> vo;
	JPanel FirstTeam;
	JPanel placePanel;
	JPanel top5;
	
	public TeamKingContentPanel(ArrayList<HotTeamsVO> v){
		this.vo = v;
		this.setLayout(null);
		this.setBounds(0, 52, 1130,372);
		this.setBackground(Color.white);
		setFirstTeam();
		setPlaceLabel();
		setTop5();
	}
	//数据王
	public void setFirstTeam(){
		FirstTeam = new JPanel();
		FirstTeam.setLayout(null);
		FirstTeam.setBounds(0,0,600,300);
		FirstTeam.setBackground(Color.WHITE);
		//添加数据王图片
		PhotoLabel firstPlayerPhotoLabel = new PhotoLabel(new ImageIcon("teamsPNG/"+vo.get(0).photo+".png").getImage());
		firstPlayerPhotoLabel.setBounds(0,10,240,240);
		firstPlayerPhotoLabel.setBackground(Color.WHITE);
		firstPlayerPhotoLabel.setOpaque(true);
		firstPlayerPhotoLabel.setVisible(true);
		
		firstPlayerPhotoLabel.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				Mainframe.getFrame().restoreIni();
				Mainframe.getFrame().setContentPane(new TeamMiddlePanel(vo.get(0).name));
			}
		
		});
		FirstTeam.add(firstPlayerPhotoLabel);
		//添加球队排名
		JLabel place = new JLabel("1");
		place.setFont(new Font("Vrinda",1,120));
		place.setForeground(Color.DARK_GRAY);
		place.setBounds(260,55,120,120);
		FirstTeam.add(place);
		//添加球队所在地
		JLabel firstName = new JLabel(vo.get(0).location);
		firstName.setFont(new Font("Vrinda",1,20));
		firstName.setForeground(Color.DARK_GRAY);
		firstName.setBounds(340,70,100,20);
		FirstTeam.add(firstName);
		//添加球队名称
		JLabel lastName = new JLabel(vo.get(0).name);
		lastName.setFont(new Font("Vrinda",1,20));
		lastName.setForeground(Color.DARK_GRAY);
		lastName.setBounds(340,90,100,40);
		FirstTeam.add(lastName);
		//添加球员联盟
		JLabel info = new JLabel("league: "+vo.get(0).league);
		info.setFont(new Font("Vrinda",1,15));
		info.setForeground(Color.GRAY);
		info.setBounds(340,130,150,15);
		FirstTeam.add(info);
		this.add(FirstTeam);
		//添加数据值
		JLabel value = new JLabel(vo.get(0).value+"");
		value.setFont(new Font("Vrinda",1,60));
		value.setForeground(Color.DARK_GRAY);
		value.setBounds(260,230,200,60);
		FirstTeam.add(value);
		
		this.add(FirstTeam);
	}
	
	
	public void setPlaceLabel(){
		
		JLabel second = new JLabel("2",JLabel.CENTER);
		second.setFont(new Font("Vrinda",1,30));
		second.setOpaque(true);
		second.setBounds(480,0,100,93);
		second.setBackground(new Color(245,245,245));
		second.setForeground(Color.GRAY);
		JLabel third = new JLabel("3",JLabel.CENTER);
		third.setFont(new Font("Vrinda",1,30));
		third.setOpaque(true);
		third.setBackground(new Color(245,245,245));
		third.setForeground(Color.GRAY);
		third.setBounds(480,93,100,93);
		JLabel fourth = new JLabel("4",JLabel.CENTER);
		fourth.setFont(new Font("Vrinda",1,30));
		fourth.setOpaque(true);
		fourth.setBackground(new Color(245,245,245));
		fourth.setForeground(Color.GRAY);
		fourth.setBounds(480,186,100,93);
		JLabel fifth = new JLabel("5",JLabel.CENTER);
		fifth.setFont(new Font("Vrinda",1,30));
		fifth.setOpaque(true);
		fifth.setBackground(new Color(245,245,245));
		fifth.setForeground(Color.GRAY);
		fifth.setBounds(480,279,100,93);
		this.add(second);
		this.add(third);
		this.add(fourth);
		this.add(fifth);
	}
	public void setTop5(){
		top5 = new JPanel();
		top5.setLayout(new BoxLayout(top5,BoxLayout.Y_AXIS));
		top5.setBounds(610,0,530,372);
		top5.setBackground(Color.WHITE);
		for(int i=1;i<5;i++)
			top5.add(team("teamsPNG/"+vo.get(i).photo+".png",vo.get(i).location+"-"+vo.get(i).name,vo.get(i).league+"",vo.get(i).value+""));
	
		
		this.add(top5);
		
	}
	
	
	public JPanel team(String photo,String name,String league,String value){
		JPanel playerP = new JPanel();
		playerP.setLayout(null);
		playerP.setPreferredSize(new Dimension(530,93));
		playerP.setBackground(Color.WHITE);
		
		//添加球队图片
				PhotoLabel teamPhotoLabel = new PhotoLabel(new ImageIcon(photo).getImage());
				teamPhotoLabel.setBounds(0,0,75,75);
				teamPhotoLabel.setBackground(Color.WHITE);
				teamPhotoLabel.setOpaque(true);
				teamPhotoLabel.setVisible(true);
				teamPhotoLabel.addMouseListener(new MouseAdapter(){
					@Override
					public void mousePressed(MouseEvent e) {
						Mainframe.getFrame().restoreIni();
						Mainframe.getFrame().setContentPane(new TeamMiddlePanel(name));
					}
				
				});
				playerP.add(teamPhotoLabel);
				//添加球队名称
				JLabel teamName = new JLabel(name);
				teamName.setFont(new Font("Vrinda",1,15));
				teamName.setForeground(Color.GRAY);
				teamName.setBounds(80,10,150,25);
				playerP.add(teamName);
				//添加联盟信息
				JLabel info = new JLabel("league: "+league);
				info.setFont(new Font("Vrinda",1,15));
				info.setForeground(new Color(39,64,139));
				info.setBounds(80,35,150,20);
				playerP.add(info);
				this.add(FirstTeam);
				//添加数据值
				JLabel fieldValue = new JLabel(value);
				fieldValue.setFont(new Font("Vrinda",1,35));
				fieldValue.setForeground(Color.DARK_GRAY);
				fieldValue.setBounds(350,15,200,40);
				playerP.add(fieldValue);
				
		
		return playerP;
	}
	
	
	//
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
//		jf.add(new TeamKingContentPanel());
		jf.setVisible(true);
	}
	
}

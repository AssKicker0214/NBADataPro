package presentation.statistics.hotPlayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.PhotoLabel;
import vo.playervo.HotPlayersVO;


public class HotPlayerContentPanel  extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<HotPlayersVO> vo;
	JPanel FirstPlayer;
	JPanel placePanel;
	JPanel top5;
	
	public HotPlayerContentPanel(ArrayList<HotPlayersVO> v){
		this.vo = v;
		this.setLayout(null);
		this.setBounds(321, 250, 1130,500);
		this.setBackground(Color.white);
		setFirstPlayer();
		setTitleAndPlaceLabel();
		setTop5();
	}
	//划线
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.gray);
		g2.draw(new Line2D.Double(580, 45, 580, 165));
//		g2.drawString("Line", 350, 250);
	}
	//进步最快球员
	public void setFirstPlayer(){
		FirstPlayer = new JPanel();
		FirstPlayer.setLayout(null);
		FirstPlayer.setBounds(0,0,1280,200);
		FirstPlayer.setBackground(Color.WHITE);
		//添加数据王图片
		PhotoLabel firstPlayerPhotoLabel = new PhotoLabel(new ImageIcon("actionPNG/"+vo.get(0).photo+".png").getImage());
		firstPlayerPhotoLabel.setBounds(10,15,240,200);
		firstPlayerPhotoLabel.setBackground(Color.WHITE);
		firstPlayerPhotoLabel.setOpaque(true);
		firstPlayerPhotoLabel.setVisible(true);
		FirstPlayer.add(firstPlayerPhotoLabel);
		//添加球员排名
		JLabel place = new JLabel("1");
		place.setFont(new Font("Vrinda",1,120));
		place.setForeground(Color.DARK_GRAY);
		place.setBounds(480,45,100,120);
		FirstPlayer.add(place);
		//添加球员名称
		JLabel name = new JLabel(vo.get(0).name);
		name.setFont(new Font("Vrinda",1,25));
		name.setForeground(Color.DARK_GRAY);
		name.setBounds(600,45,300,25);
		FirstPlayer.add(name);		
		//添加球员信息
		JLabel info = new JLabel(vo.get(0).number+" "+vo.get(0).position+"/"+vo.get(0).teamName);
		info.setFont(new Font("Vrinda",1,20));
		info.setForeground(Color.GRAY);
		info.setBounds(600,70,300,20);
		FirstPlayer.add(info);
		this.add(FirstPlayer);
		//添加数据值
		JLabel field = new JLabel("最近五场     /提升率");
		field.setFont(new Font("微软雅黑",1,15));
		field.setForeground(Color.LIGHT_GRAY);
		field.setBounds(600,110,200,15);
		FirstPlayer.add(field);
		JLabel value = new JLabel(vo.get(0).value+"");
		value.setFont(new Font("Vrinda",1,40));
		value.setForeground(Color.DARK_GRAY);
		value.setBounds(600,130,100,40);
		FirstPlayer.add(value);
		JLabel slash = new JLabel("/");
		slash.setFont(new Font("微软雅黑",1,20));
		slash.setForeground(Color.LIGHT_GRAY);
		slash.setBounds(700,150,20,20);
		FirstPlayer.add(slash);
		JLabel upRate = new JLabel(vo.get(0).upgradeRate+"%");
		upRate.setFont(new Font("Vrinda",1,20));
		upRate.setForeground(new Color(39,64,139));
		upRate.setBounds(720,150,100,20);
		FirstPlayer.add(upRate);
		//添加球队图片
		PhotoLabel teamPic = new PhotoLabel(new ImageIcon("teamsPNG/"+vo.get(0).teamPhoto+".png").getImage());
		teamPic.setBounds(1100,110,90,90);
		teamPic.setBackground(Color.WHITE);
		teamPic.setOpaque(true);
		teamPic.setVisible(true);
		FirstPlayer.add(teamPic);
		this.add(FirstPlayer);
	}
	
	
	
	public void setTitleAndPlaceLabel(){
		JLabel title1 = new JLabel("  排名");
		title1.setFont(new Font("微软雅黑",1,15));
		title1.setOpaque(true);
		title1.setBounds(10,200,200,30);
		title1.setBackground(new Color(105,105,105));
		title1.setForeground(Color.WHITE);
		JLabel title2 = new JLabel("  球员");
		title2.setFont(new Font("微软雅黑",1,15));
		title2.setOpaque(true);
		title2.setBounds(210,200,470,30);
		title2.setBackground(new Color(105,105,105));
		title2.setForeground(Color.WHITE);
		JLabel title3 = new JLabel("  最近五场 /提升率");
		title3.setFont(new Font("微软雅黑",1,15));
		title3.setOpaque(true);
		title3.setBounds(680,200,440,30);
		title3.setBackground(new Color(105,105,105));
		title3.setForeground(Color.WHITE);
		JLabel title4 = new JLabel("  球队");
		title4.setFont(new Font("微软雅黑",1,15));
		title4.setOpaque(true);
		title4.setBounds(1120,200,150,30);
		title4.setBackground(new Color(105,105,105));
		title4.setForeground(Color.WHITE);
		this.add(title1);
		this.add(title2);
		this.add(title3);
		this.add(title4);
		
		JLabel second = new JLabel("2",JLabel.CENTER);
		second.setFont(new Font("Vrinda",1,30));
		second.setOpaque(true);
		second.setBounds(10,230,200,55);
		second.setBackground(new Color(245,245,245));
		second.setForeground(Color.GRAY);
		JLabel third = new JLabel("3",JLabel.CENTER);
		third.setFont(new Font("Vrinda",1,30));
		third.setOpaque(true);
		third.setBackground(new Color(245,245,245));
		third.setForeground(Color.GRAY);
		third.setBounds(10,295,200,55);
		JLabel fourth = new JLabel("4",JLabel.CENTER);
		fourth.setFont(new Font("Vrinda",1,30));
		fourth.setOpaque(true);
		fourth.setBackground(new Color(245,245,245));
		fourth.setForeground(Color.GRAY);
		fourth.setBounds(10,360,200,55);
		JLabel fifth = new JLabel("5",JLabel.CENTER);
		fifth.setFont(new Font("Vrinda",1,30));
		fifth.setOpaque(true);
		fifth.setBackground(new Color(245,245,245));
		fifth.setForeground(Color.GRAY);
		fifth.setBounds(10,425,200,55);
		this.add(second);
		this.add(third);
		this.add(fourth);
		this.add(fifth);
	}
	public void setTop5(){
		top5 = new JPanel();
		top5.setLayout(new BoxLayout(top5,BoxLayout.Y_AXIS));
		top5.setBounds(220,230,1030,270);
		top5.setBackground(Color.WHITE);
		for(int i=1;i<5;i++)
			top5.add(player("portrait/"+vo.get(i).photo+".png",vo.get(i).name,vo.get(i).number+" "+vo.get(i).position+"/"+vo.get(i).teamName,vo.get(i).value+"",vo.get(i).upgradeRate+"%","teamsPNG/"+vo.get(i).teamPhoto+".png"));
		
		this.add(top5);
		
	}
	
	//参数：头像，名称，信息，数据值，提升率，球队图片
	public JPanel player(String p,String n,String inf,String v,String r,String t){
		JPanel playerP = new JPanel();
		playerP.setLayout(null);
		playerP.setPreferredSize(new Dimension(1030,65));
		playerP.setBackground(Color.WHITE);
		
		//添加球员图片
				PhotoLabel PlayerPhotoLabel = new PhotoLabel(new ImageIcon(p).getImage());
				PlayerPhotoLabel.setBounds(0,0,65,55);
				PlayerPhotoLabel.setBackground(Color.WHITE);
				PlayerPhotoLabel.setOpaque(true);
				PlayerPhotoLabel.setVisible(true);
				playerP.add(PlayerPhotoLabel);
				//添加球员名称
				JLabel name = new JLabel(n);
				name.setFont(new Font("Vrinda",1,15));
				name.setForeground(new Color(39,64,139));
				name.setBounds(70,10,100,25);
				playerP.add(name);
				//添加球员信息
				JLabel info = new JLabel(inf);
				info.setFont(new Font("Vrinda",1,15));
				info.setForeground(Color.GRAY);
				info.setBounds(70,35,150,15);
				playerP.add(info);
				this.add(FirstPlayer);
				//添加数据值
				JLabel value = new JLabel(v);
				value.setFont(new Font("Vrinda",1,40));
				value.setForeground(Color.DARK_GRAY);
				value.setBounds(470,10,100,40);
				playerP.add(value);
				JLabel slash = new JLabel("/");
				slash.setFont(new Font("微软雅黑",1,20));
				slash.setForeground(Color.LIGHT_GRAY);
				slash.setBounds(570,30,20,20);
				playerP.add(slash);
				JLabel upRate = new JLabel(r);
				upRate.setFont(new Font("Vrinda",1,20));
				upRate.setForeground(new Color(39,64,139));
				upRate.setBounds(590,30,100,20);
				playerP.add(upRate);
				//添加球队图片
				PhotoLabel teamPic = new PhotoLabel(new ImageIcon(t).getImage());
				teamPic.setBounds(890,5,75,70);
				teamPic.setBackground(Color.WHITE);
				teamPic.setOpaque(true);
				teamPic.setVisible(true);
				playerP.add(teamPic);
		
		
		return playerP;
	}
	
	
	//
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
//		jf.add(new HotPlayerPanel());
		jf.setVisible(true);
	}
	
}

package presentation.statistics.hotPlayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.PhotoLabel;
import presentation.main.Mainframe;
import presentation.player.playerDetail.PlayerMiddlePanel;
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
		this.setBounds(0, 52, 1130,405);
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
		g2.draw(new Line2D.Double(440, 25, 440, 105));
//		g2.drawString("Line", 350, 250);
	}
	//进步最快球员
	public void setFirstPlayer(){
		FirstPlayer = new JPanel();
		FirstPlayer.setLayout(null);
		FirstPlayer.setBounds(0,0,1280,180);
		FirstPlayer.setBackground(Color.WHITE);
		//添加数据王图片
		PhotoLabel firstPlayerPhotoLabel = new PhotoLabel(new ImageIcon("actionPNG/"+vo.get(0).photo+".png").getImage());
		firstPlayerPhotoLabel.setBounds(50,-35,200,180);
		firstPlayerPhotoLabel.setBackground(Color.WHITE);
		firstPlayerPhotoLabel.setOpaque(true);
		firstPlayerPhotoLabel.setVisible(true);
		
		firstPlayerPhotoLabel.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				Mainframe.getFrame().changeContent(new PlayerMiddlePanel(vo.get(0).name));
			}
		
		});
		FirstPlayer.add(firstPlayerPhotoLabel);

		//添加球员排名
		JLabel place = new JLabel("1");
		place.setFont(new Font("Vrinda",1,120));
		place.setForeground(Color.DARK_GRAY);
		place.setBounds(350,25,100,100);
		FirstPlayer.add(place);
		//添加球员名称
		JLabel name = new JLabel(vo.get(0).name);
		name.setFont(new Font("Vrinda",1,25));
		name.setForeground(Color.DARK_GRAY);
		name.setBounds(460,25,300,25);
		FirstPlayer.add(name);		
		//添加球员信息
		JLabel info = new JLabel(vo.get(0).number+" "+vo.get(0).position+"/"+vo.get(0).teamName);
		info.setFont(new Font("Vrinda",1,20));
		info.setForeground(Color.GRAY);
		info.setBounds(460,50,300,20);
		FirstPlayer.add(info);
		this.add(FirstPlayer);
		//添加数据值
		JLabel field = new JLabel("最近五场     /提升率");
		field.setFont(new Font("微软雅黑",1,15));
		field.setForeground(Color.LIGHT_GRAY);
		field.setBounds(460,78,200,15);
		FirstPlayer.add(field);
		JLabel value = new JLabel(vo.get(0).value+"");
		value.setFont(new Font("Vrinda",1,40));
		value.setForeground(Color.DARK_GRAY);
		value.setBounds(460,100,100,40);
		FirstPlayer.add(value);
		JLabel slash = new JLabel("/");
		slash.setFont(new Font("微软雅黑",1,20));
		slash.setForeground(Color.LIGHT_GRAY);
		slash.setBounds(560,110,20,20);
		FirstPlayer.add(slash);
		JLabel upRate = new JLabel(vo.get(0).upgradeRate+"%");
		upRate.setFont(new Font("Vrinda",1,20));
		upRate.setForeground(new Color(39,64,139));
		upRate.setBounds(580,110,100,20);
		FirstPlayer.add(upRate);
		//添加球队图片
		PhotoLabel teamPic = new PhotoLabel(new ImageIcon("teamsPNG/"+vo.get(0).teamPhoto+".png").getImage());
		teamPic.setBounds(950,60,90,90);
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
		title1.setBounds(10,150,200,30);
		title1.setBackground(new Color(105,105,105));
		title1.setForeground(Color.WHITE);
		JLabel title2 = new JLabel("  球员");
		title2.setFont(new Font("微软雅黑",1,15));
		title2.setOpaque(true);
		title2.setBounds(210,150,400,30);
		title2.setBackground(new Color(105,105,105));
		title2.setForeground(Color.WHITE);
		JLabel title3 = new JLabel("  最近五场 /提升率");
		title3.setFont(new Font("微软雅黑",1,15));
		title3.setOpaque(true);
		title3.setBounds(610,150,350,30);
		title3.setBackground(new Color(105,105,105));
		title3.setForeground(Color.WHITE);
		JLabel title4 = new JLabel("  球队");
		title4.setFont(new Font("微软雅黑",1,15));
		title4.setOpaque(true);
		title4.setBounds(960,150,170,30);
		title4.setBackground(new Color(105,105,105));
		title4.setForeground(Color.WHITE);
		this.add(title1);
		this.add(title2);
		this.add(title3);
		this.add(title4);
		
		JLabel second = new JLabel("2",JLabel.CENTER);
		second.setFont(new Font("Vrinda",1,30));
		second.setOpaque(true);
		second.setBounds(10,180,200,55);
		second.setBackground(new Color(245,245,245));
		second.setForeground(Color.GRAY);
		JLabel third = new JLabel("3",JLabel.CENTER);
		third.setFont(new Font("Vrinda",1,30));
		third.setOpaque(true);
		third.setBackground(new Color(245,245,245));
		third.setForeground(Color.GRAY);
		third.setBounds(10,236,200,55);
		JLabel fourth = new JLabel("4",JLabel.CENTER);
		fourth.setFont(new Font("Vrinda",1,30));
		fourth.setOpaque(true);
		fourth.setBackground(new Color(245,245,245));
		fourth.setForeground(Color.GRAY);
		fourth.setBounds(10,292,200,55);
		JLabel fifth = new JLabel("5",JLabel.CENTER);
		fifth.setFont(new Font("Vrinda",1,30));
		fifth.setOpaque(true);
		fifth.setBackground(new Color(245,245,245));
		fifth.setForeground(Color.GRAY);
		fifth.setBounds(10,348,200,55);
		this.add(second);
		this.add(third);
		this.add(fourth);
		this.add(fifth);
	}
	public void setTop5(){
		top5 = new JPanel();
		top5.setLayout(new BoxLayout(top5,BoxLayout.Y_AXIS));
		top5.setBounds(220,180,1030,220);
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
				PlayerPhotoLabel.addMouseListener(new MouseAdapter(){
					@Override
					public void mousePressed(MouseEvent e) {
						Mainframe.getFrame().changeContent(new PlayerMiddlePanel(n));
					}
				
				});
				playerP.add(PlayerPhotoLabel);
				//添加球员名称
				JLabel name = new JLabel(n);
				name.setFont(new Font("Vrinda",1,15));
				name.setForeground(new Color(39,64,139));
				name.setBounds(75,10,130,25);
				playerP.add(name);
				//添加球员信息
				JLabel info = new JLabel(inf);
				info.setFont(new Font("Vrinda",1,15));
				info.setForeground(Color.GRAY);
				info.setBounds(75,35,170,15);
				playerP.add(info);
				this.add(FirstPlayer);
				//添加数据值
				JLabel value = new JLabel(v);
				value.setFont(new Font("Vrinda",1,40));
				value.setForeground(Color.DARK_GRAY);
				value.setBounds(400,10,100,30);
				playerP.add(value);
				JLabel slash = new JLabel("/");
				slash.setFont(new Font("微软雅黑",1,20));
				slash.setForeground(Color.LIGHT_GRAY);
				slash.setBounds(500,30,20,20);
				playerP.add(slash);
				JLabel upRate = new JLabel(r);
				upRate.setFont(new Font("Vrinda",1,20));
				upRate.setForeground(new Color(39,64,139));
				upRate.setBounds(520,30,100,20);
				playerP.add(upRate);
				//添加球队图片
				PhotoLabel teamPic = new PhotoLabel(new ImageIcon(t).getImage());
				teamPic.setBounds(730,0,75,55);
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

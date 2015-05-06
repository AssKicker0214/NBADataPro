package presentation.statistics.playerKing;

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
import presentation.player.playerDetail.PlayerMiddlePanel;
import vo.playervo.HotPlayersVO;

public class PlayerKingContentPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<HotPlayersVO> vo;
	JPanel FirstPlayer;
	JPanel placePanel;
	JPanel top5;
	
	public PlayerKingContentPanel(ArrayList<HotPlayersVO> v){
		this.vo = v;
		this.setLayout(null);
		this.setBounds(0, 52, 1280,372);
		this.setBackground(Color.white);
		setFirstPlayer();
		setPlaceLabel();
		setTop5();
	}
	//数据王
	public void setFirstPlayer(){
		
		String[] name = vo.get(0).name.split(" ");
		
		FirstPlayer = new JPanel();
		FirstPlayer.setLayout(null);
		FirstPlayer.setBounds(0,0,520,345);
		FirstPlayer.setBackground(Color.WHITE);
		//添加数据王图片
		PhotoLabel firstPlayerPhotoLabel = new PhotoLabel(new ImageIcon("actionPNG/"+vo.get(0).photo+".png").getImage());
		firstPlayerPhotoLabel.setBounds(0,15,195,340);
		firstPlayerPhotoLabel.setBackground(Color.WHITE);
		firstPlayerPhotoLabel.setOpaque(true);
		firstPlayerPhotoLabel.setVisible(true);
		firstPlayerPhotoLabel.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				Mainframe.getFrame().restoreIni();
				Mainframe.getFrame().setContentPane(new PlayerMiddlePanel(vo.get(0).name));
			}
		
		});
		FirstPlayer.add(firstPlayerPhotoLabel);
		//添加球员排名
		JLabel place = new JLabel("1");
		place.setFont(new Font("Vrinda",1,120));
		place.setForeground(Color.DARK_GRAY);
		place.setBounds(180,50,115,120);
		FirstPlayer.add(place);
		//添加球员名称
		JLabel firstName = new JLabel(name[0]);
		firstName.setFont(new Font("Vrinda",1,20));
		firstName.setForeground(Color.DARK_GRAY);
		firstName.setBounds(270,70,100,20);
		FirstPlayer.add(firstName);
		JLabel lastName = new JLabel(name[1]);
		lastName.setFont(new Font("Vrinda",1,20));
		lastName.setForeground(Color.DARK_GRAY);
		lastName.setBounds(270,90,100,40);
		FirstPlayer.add(lastName);
		//添加球员信息
		JLabel info = new JLabel(vo.get(0).number+" "+vo.get(0).position+"/"+vo.get(0).teamName);
		info.setFont(new Font("Vrinda",1,15));
		info.setForeground(Color.GRAY);
		info.setBounds(270,130,200,15);
		FirstPlayer.add(info);
		this.add(FirstPlayer);
		//添加数据值
		JLabel value = new JLabel(vo.get(0).value+"");
		value.setFont(new Font("Vrinda",1,60));
		value.setForeground(Color.DARK_GRAY);
		value.setBounds(270,200,200,60);
		FirstPlayer.add(value);
		//添加球队图片
		PhotoLabel teamPic = new PhotoLabel(new ImageIcon("teamsPNG/"+vo.get(0).teamPhoto+".png").getImage());
		teamPic.setBounds(370,0,120,120);
		teamPic.setBackground(Color.WHITE);
		teamPic.setOpaque(true);
		teamPic.setVisible(true);
		FirstPlayer.add(teamPic);
		this.add(FirstPlayer);
	}
	
	
	public void setPlaceLabel(){
		
		JLabel second = new JLabel("2",JLabel.CENTER);
		second.setFont(new Font("Vrinda",1,30));
		second.setOpaque(true);
		second.setBounds(510,0,100,93);
		second.setBackground(new Color(245,245,245));
		second.setForeground(Color.GRAY);
		JLabel third = new JLabel("3",JLabel.CENTER);
		third.setFont(new Font("Vrinda",1,30));
		third.setOpaque(true);
		third.setBackground(new Color(245,245,245));
		third.setForeground(Color.GRAY);
		third.setBounds(510,93,100,93);
		JLabel fourth = new JLabel("4",JLabel.CENTER);
		fourth.setFont(new Font("Vrinda",1,30));
		fourth.setOpaque(true);
		fourth.setBackground(new Color(245,245,245));
		fourth.setForeground(Color.GRAY);
		fourth.setBounds(510,186,100,93);
		JLabel fifth = new JLabel("5",JLabel.CENTER);
		fifth.setFont(new Font("Vrinda",1,30));
		fifth.setOpaque(true);
		fifth.setBackground(new Color(245,245,245));
		fifth.setForeground(Color.GRAY);
		fifth.setBounds(510,279,100,93);
		this.add(second);
		this.add(third);
		this.add(fourth);
		this.add(fifth);
	}
	public void setTop5(){
		top5 = new JPanel();
		top5.setLayout(new BoxLayout(top5,BoxLayout.Y_AXIS));
		top5.setBounds(630,0,510,372);
		top5.setBackground(Color.WHITE);
		for(int i=1;i<5;i++)
			top5.add(player("portrait/"+vo.get(i).photo+".png",vo.get(i).name,vo.get(i).number+" "+vo.get(i).position+"/"+vo.get(i).teamName,vo.get(i).value+"","teamsPNG/"+vo.get(i).teamPhoto+".png"));
	
		this.add(top5);
		
	}
	
	//参数：头像，名称，信息，数据值，球队图片
	public JPanel player(String p,String n,String inf,String v,String t){
		JPanel playerP = new JPanel();
		playerP.setLayout(null);
		playerP.setPreferredSize(new Dimension(510,93));
		playerP.setBackground(Color.WHITE);
		
		//添加球员图片
				PhotoLabel PlayerPhotoLabel = new PhotoLabel(new ImageIcon(p).getImage());
				PlayerPhotoLabel.setBounds(0,20,75,60);
				PlayerPhotoLabel.setBackground(Color.WHITE);
				PlayerPhotoLabel.setOpaque(true);
				PlayerPhotoLabel.setVisible(true);
				PlayerPhotoLabel.addMouseListener(new MouseAdapter(){
					@Override
					public void mousePressed(MouseEvent e) {
						Mainframe.getFrame().restoreIni();
						Mainframe.getFrame().setContentPane(new PlayerMiddlePanel(n));
					}
				
				});
				playerP.add(PlayerPhotoLabel);
				//添加球员名称
				JLabel name = new JLabel(n);
				name.setFont(new Font("Vrinda",1,15));
				name.setForeground(new Color(39,84,139));
				name.setBounds(80,30,150,25);
				playerP.add(name);
				//添加球员信息
				JLabel info = new JLabel(inf);
				info.setFont(new Font("Vrinda",1,15));
				info.setForeground(Color.GRAY);
				info.setBounds(80,55,200,15);
				playerP.add(info);
				this.add(FirstPlayer);
				//添加数据值
				JLabel value = new JLabel(v);
				value.setFont(new Font("Vrinda",1,40));
				value.setForeground(Color.DARK_GRAY);
				value.setBounds(400,25,105,40);
				playerP.add(value);
				//添加球队图片
				PhotoLabel teamPic = new PhotoLabel(new ImageIcon(t).getImage());
				teamPic.setBounds(300,15,75,70);
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
//		jf.add(new PlayerKingContentPanel());
		jf.setVisible(true);
	}
}

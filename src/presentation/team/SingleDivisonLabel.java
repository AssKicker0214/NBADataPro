package presentation.team;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SingleDivisonLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean hasSuboptions = true;


	JLabel DivisionLabel;
	
	public SingleDivisonLabel(String division){
		this.setLayout(new GridLayout(5,1,0,1));
		this.setBounds(0, 0, 200,500);
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		this.setVisible(true);
		switch(division){
			case "1": setEast_SouthEast();break;
			case "2": setEast_Center();break;
			case "3": setEast_Atlantic();break;
			case "4": West_Pacific();break;
			case "5": West_NorthWest();break;
			case "6": West_SouthWest();break;
			default : break;
		}
	}
	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
//		g2d.rotate(Math.PI/12);
		
		super.paint(g2d);
	}
	
	
	/*
	public void setDivisionText(String division){
		DivisionLabel = new JLabel(division);
		DivisionLabel.setFont(new Font("Dialog",1,15));
		DivisionLabel.setForeground(Color.GRAY);
		DivisionLabel.setBounds(110,0,188,30);
		DivisionLabel.setOpaque(true);
		this.add(DivisionLabel);
	}
	*/
	
	public void setEast_SouthEast(){
		this.add(new SingleTeamLabel("teamsPNG/ATL.png","亚特兰大 老鹰"));
		this.add(new SingleTeamLabel("teamsPNG/CHA.png","夏洛特 黄蜂"));
		this.add(new SingleTeamLabel("teamsPNG/MIA.png","迈阿密 热火"));
		this.add(new SingleTeamLabel("teamsPNG/ORL.png","奥兰多 魔术"));
		this.add(new SingleTeamLabel("teamsPNG/WAS.png","华盛顿 奇才"));
	}
	
	public void setEast_Center(){
		this.add(new SingleTeamLabel("teamsPNG/CHI.png","芝加哥 公牛"));
		this.add(new SingleTeamLabel("teamsPNG/CLE.png","克利夫兰 骑士"));
		this.add(new SingleTeamLabel("teamsPNG/DET.png","底特律 活塞"));
		this.add(new SingleTeamLabel("teamsPNG/IND.png","印第安纳 步行者"));
		this.add(new SingleTeamLabel("teamsPNG/MIL.png","密尔沃基 雄鹿"));
	}
	
	public void setEast_Atlantic(){
		this.add(new SingleTeamLabel("teamsPNG/BOS.png","波士顿 凯尔特人"));
		this.add(new SingleTeamLabel("teamsPNG/BKN.png","布鲁克林 篮网"));
		this.add(new SingleTeamLabel("teamsPNG/NYK.png","纽约 尼克斯"));
		this.add(new SingleTeamLabel("teamsPNG/PHI.png","费城 76人"));
		this.add(new SingleTeamLabel("teamsPNG/TOR.png","多伦多 猛龙"));
	}

	public void West_Pacific(){
		this.add(new SingleTeamLabel("teamsPNG/GSW.png","金州 勇士"));
		this.add(new SingleTeamLabel("teamsPNG/LAC.png","洛杉矶 快船"));
		this.add(new SingleTeamLabel("teamsPNG/LAL.png","洛杉矶 湖人"));
		this.add(new SingleTeamLabel("teamsPNG/PHX.png","菲尼克斯 太阳"));
		this.add(new SingleTeamLabel("teamsPNG/SAC.png","萨克拉门托 国王"));
	}

	public void West_NorthWest(){
		this.add(new SingleTeamLabel("teamsPNG/DEN.png","丹佛 掘金"));
		this.add(new SingleTeamLabel("teamsPNG/MIN.png","明尼苏达 森林狼"));
		this.add(new SingleTeamLabel("teamsPNG/OKC.png","奥克拉荷马城 雷霆"));
		this.add(new SingleTeamLabel("teamsPNG/POR.png","波特兰 开拓者"));
		this.add(new SingleTeamLabel("teamsPNG/UTA.png","犹他 爵士"));
	}

	public void West_SouthWest(){
		this.add(new SingleTeamLabel("teamsPNG/DAL.png","达拉斯 小牛"));
		this.add(new SingleTeamLabel("teamsPNG/HOU.png","休斯顿 火箭"));
		this.add(new SingleTeamLabel("teamsPNG/MEM.png","孟菲斯 灰熊"));
		this.add(new SingleTeamLabel("teamsPNG/ONP.png","新奥尔兰 鹈鹕"));
		this.add(new SingleTeamLabel("teamsPNG/SAS.png","圣安东尼奥 马刺"));
	}


	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().add(new SingleDivisonLabel("2"));
		jf.setVisible(true);
	}
}

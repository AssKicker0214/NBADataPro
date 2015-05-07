package presentation.player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import presentation.common.DynamicBar;


public class SingleVSBarLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	double avg1;
	double avg2;
	
	DynamicBar local;
	DynamicBar another;
	JLabel itemLabel;
	
	static Color blue = new Color(14,105,176);
	static Color grey = Color.GRAY;
	
	int limit;//最高分
	int length;//bar条长度
	
	String[] items = {"场均得分","场均篮板","场均助攻","三分％","罚球％"};
	int[] playerLim = {40,20,30,1,1};
	int[] TeamLim = {150,100,80,1,1};
	
	public SingleVSBarLabel(double avg1,double avg2,String item,int length,boolean isPlayer){
		this.avg1 = avg1;
		this.avg2 = avg2;
		this.length = length;
		if(isPlayer)
			TeamLim = playerLim;
//		this.setLayout(new GridLayout(1,2,0,20));
		this.setLayout(null);
//		this.setBounds(0, 0, 1280,60);
		this.setLocation(0, 0);
		this.setPreferredSize(new Dimension(1280,60));
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		this.setLayout(null);
		this.setVisible(true);
		setLimit(item);
		setBars(avg1,avg2);
		setItem(item);
	}
	
	
	private void setLimit(String item){
		for(int i = 0; i < 5; i++){
			if(items[i].equals(item)){
				this.limit = TeamLim[i];
				System.out.println(item+" "+limit);
			}
		}
	}

	private void setBars(double avg1, double avg2){
		System.out.println(avg1+" "+avg2);
		if(avg1 > avg2){
			local = new DynamicBar(blue,this.limit,avg1,this.length);
			another = new DynamicBar(grey,this.limit,avg2,this.length);
		}else if(avg1 == avg2){
			local = new DynamicBar(grey,this.limit,avg1,this.length);
			another = new DynamicBar(grey,this.limit,avg2,this.length);
		}else if(avg1 < avg2){
			local = new DynamicBar(grey,this.limit,avg1,this.length);
			another = new DynamicBar(blue,this.limit,avg2,this.length);
		}
		local.setValueAndDirection(DynamicBar.LEFT);
		another.setValueAndDirection(DynamicBar.RIGHT);
		
		local.setLocation(20, 5);
		another.setLocation(700, 5);

		this.add(local);
		this.add(another);
		
		local.showOut();
		another.showOut();
	}
	
	private void setItem(String item){
		itemLabel = new JLabel(item,JLabel.CENTER);
		itemLabel.setFont(new Font("Dialog",1,20));
		itemLabel.setForeground(Color.BLACK);
		itemLabel.setBackground(Color.LIGHT_GRAY);
		itemLabel.setOpaque(true);
		itemLabel.setBounds(500,0,200,60);
		this.add(itemLabel);
	}
		
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
//		jf.add(new SingleVSBarLabel(20.9,30.0,"场均得分",430));
		jf.setVisible(true);
	}


}

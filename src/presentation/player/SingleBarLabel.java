package presentation.player;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import presentation.common.DynamicBar;


public class SingleBarLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	double avg1;
	double avg2;
	
	static Color blue = new Color(56,167,230);
	
	public SingleBarLabel(double avg1,double avg2,Color c,int l,int hl){
		this.avg1 = avg1;
		this.avg2 = avg2;
		
		this.setBounds(0, 0, 200,180);
		this.setLayout(new GridLayout(1,2,0,20));
		this.setOpaque(true);
		this.setBackground(Color.BLACK);
		setBars(c,l,avg1,hl);
		setBars(l,avg2,hl);
		this.setVisible(true);

	}
	

	public void setBars(Color c,int l,double value,int hl){
		DynamicBar db = new DynamicBar(c,l,value,hl);
		db.setValueAndDirection(DynamicBar.UP);
//		db.setLocation(0, 0);
		this.add(db);
		db.showOut();
	}
	
	public void setBars(int l,double value,int hl){
		DynamicBar db = new DynamicBar(l,value,hl);
		db.setValueAndDirection(DynamicBar.UP);
//		db.setLocation(0, 0);
		this.add(db);
		db.showOut();
	}
	
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new SingleBarLabel(20.1,30.9,blue,100,150));
		jf.setVisible(true);
	}
}

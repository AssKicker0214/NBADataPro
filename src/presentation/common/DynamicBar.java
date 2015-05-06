package presentation.common;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class DynamicBar extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//这里是动态增长方向，使用举例:DynamicBar.UP
	public static int UP = 0;
	public static int LEFT = 1;
	public static int RIGHT = 2;
	public Color c;
	
	private double value = 50.9;//百分率
	private JLabel dBar;//会动的条
	private JTextField dVal;//会动的数字
	private Timer timer;
	
	private int length;
	private int wholeLength=420;
//	private double wholeWidth;
//	private ActionListener action;
	
	public DynamicBar(int l,double Value,int hl){
		wholeLength = hl;
		length = l;
		value = Value*((double)wholeLength)/((double)length);
		this.setSize(50, wholeLength+30);//这里默认还是竖着的，后面通过调用setValueAndDirection方法重新设置
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		this.c = Color.LIGHT_GRAY;
		initialise();
	}

	public DynamicBar(Color c,int l,double Value,int hl){
		wholeLength = hl;
		length = l;
		value = Value*((double)wholeLength)/((double)length);
		this.setSize(50, wholeLength+30);//这里默认还是竖着的，后面通过调用setValueAndDirection方法重新设置
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		this.c = c;
		initialise();
	}
	
	public void setValueAndDirection(int direction){
		if(direction == DynamicBar.LEFT){
			iniLeft();
		}else if(direction == DynamicBar.RIGHT){
			iniRight();
		}else{// UP
			
		}
	}
	
	private void iniLeft(){
		this.setSize(wholeLength+50, 50);
		dBar.setBounds(wholeLength+50, 0, wholeLength, 50);
		dVal.setBounds(wholeLength, 0, 50, 50);
		timer = new Timer(10, new LeftAction());
	}
	
	private void iniRight(){
		this.setSize(wholeLength+50, 50);
		dBar.setBounds(-wholeLength, 0, wholeLength, 50);
		dVal.setBounds(0, 0, 50, 50);
		timer = new Timer(10, new RightAction());
	}
	
	private void initialise(){
		dBar = new JLabel();
		dBar.setBounds(0, wholeLength+30, 50, wholeLength);//这里默认还是竖着的，后面通过调用setValueAndDirection方法重新设置
		dBar.setBackground(c);
		dBar.setOpaque(true);
		this.add(dBar);
		
		dVal = new JTextField();
		dVal.setText(0.0+"");
		dVal.setBounds(0, wholeLength, 50, 30);//这里默认还是竖着的，后面通过调用setValueAndDirection方法重新设置
		dVal.setOpaque(false);
		dVal.setBorder(null);
		dVal.setEditable(false);
		dVal.setFont(new Font("微软雅黑", Font.BOLD, 11));
		this.add(dVal);

		timer = new Timer(10, new UpAction());
	}
	
	public void showOut(){
		timer.setRepeats(true);
		timer.start();
	}
	
	class UpAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int height = wholeLength+30 - dBar.getY();
			if(height<value){
				int valY = dVal.getY();
		//		double tempValue = Double.parseDouble(dVal.getText()) + 1.0;
				dVal.setText(String.format("%.1f",(wholeLength-valY)*((double)length)/((double)wholeLength)));
				dVal.setLocation(0, valY-1);
				
				int barY = dBar.getY();
				dBar.setLocation(0, barY-1);
				
				
			}else{
				dVal.setText(value*((double)length)/((double)wholeLength)+"");
				timer.stop();
			}
			
		}
		
	}
	
	class LeftAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int width = wholeLength+50 - dBar.getX();
			if(width<value){
				int valX = dVal.getX();
		//		double tempValue = Double.parseDouble(dVal.getText()) + 1;
				dVal.setText(String.format("%.1f",(wholeLength-valX)*((double)length)/((double)wholeLength)));
				dVal.setLocation(valX-1, 0);
				
				int barX = dBar.getX();
				dBar.setLocation(barX-1, 0);
				
//				System.out.println(dBar.getLocation());
			}else{
				dVal.setText(value*((double)length)/((double)wholeLength)+"");
				timer.stop();
			}
		}
		
	}
	
	class RightAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println(dBar.getLocation()+""+dVal.getLocation());
			int width = wholeLength + dBar.getX();
			if(width<value){
				int valX = dVal.getX();
	//			double tempValue = Double.parseDouble(dVal.getText()) + 1;
				dVal.setText(String.format("%.1f",valX*((double)length)/((double)wholeLength)));
				dVal.setLocation(valX+1, 0);
				
				int barX = dBar.getX();
				dBar.setLocation(barX+1, 0);
				
			}else{
				dVal.setText(value*((double)length)/((double)wholeLength)+"");
				timer.stop();
			}
		}
		
	}
	
	public static void main(String args[]){
		JFrame f = new JFrame();
		f.setLayout(null);
		JPanel jp = new JPanel();
		jp.setBackground(Color.black);
		jp.setBounds(0,0,600,600);
		jp.setLayout(null);
		DynamicBar db = new DynamicBar(40,40,430);
		db.setValueAndDirection(RIGHT);
		db.setLocation(50, 10);
		jp.add(db);
		f.add(jp);
		f.setSize(200, 600);
		f.setVisible(true);
		db.showOut();
	}
}

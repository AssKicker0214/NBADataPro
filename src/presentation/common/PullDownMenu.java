package presentation.common;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PullDownMenu extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String[] items = {"场均得分","场均助攻","场均篮板","三分％","罚球％",
					"场数","先发","分钟","投篮命中","进攻篮板",
					"防守篮板","场均抢断","场均盖帽","失误","犯规"};
	
	Point p = new Point(0,340);
//height = 80
	
	public PullDownMenu(Point p){
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		fl.setVgap(0);
		fl.setHgap(35);
		this.setLayout(fl);
		this.setSize(1280, 90);
//		this.setBounds(0, 340,1280,90);
		this.setLocation(p);
		this.setBackground(Color.GRAY);
		this.setOpaque(true);
		addMyCheckBoxLabels();
		this.setVisible(true);
	}
	
	public PullDownMenu(){
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		fl.setVgap(0);
		fl.setHgap(35);
		this.setLayout(fl);
		this.setSize(1280, 90);
		this.setLocation(p);
//		this.setBounds(0, 340,1280,90);
		this.setBackground(Color.GRAY);
		this.setOpaque(true);
		addMyCheckBoxLabels();
		this.setVisible(true);
	}

	
	private void addMyCheckBoxLabels(){
		for(String item : items){
			this.add(new MyCheckBoxLabel(item));
		}
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new PullDownMenu());
		jf.setVisible(true);
	}

}

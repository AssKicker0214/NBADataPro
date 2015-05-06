package presentation.player.vs;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.player.SingleVSBarLabel;


public class VSContentPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<String> items;
	ArrayList<Double> avg1;
	ArrayList<Double> avg2;
	
	int length = 430;
	static Color blue = new Color(14,105,176);
	static Color grey = Color.GRAY;
	
	public VSContentPanel(ArrayList<String> itemsNeedAdd,ArrayList<Double> avg1,
			ArrayList<Double> avg2, boolean isPlayer){
		this.avg1 = avg1;
		this.avg2 = avg2;
		initArray(itemsNeedAdd);

		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		fl.setVgap(0);
		this.setLayout(fl);

		this.setBounds(30, 300, 1280,360);
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		addBars(isPlayer);
		this.setVisible(true);
	}

	private void initArray(ArrayList<String> itemsNeedAdd){
		items = new ArrayList<String>();
		for(String item : itemsNeedAdd){
			items.add(item);
		}
	}

	private void addBars(boolean isPlayer){
		for(int i = 0; i < items.size();i++){
			System.out.println(items.size() + "  " + Double.toString(avg1.get(i)) + "  " + 
					Double.toString(avg2.get(i)) + "  " + items.get(i) + "");
			this.add(new SingleVSBarLabel(avg1.get(i),avg2.get(i),items.get(i),length,isPlayer));
		}
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		
		ArrayList<String> itemsNeedAdd = new ArrayList<String>();
		ArrayList<Double> avg1 = new ArrayList<Double>();
		ArrayList<Double> avg2 = new ArrayList<Double>();
		
		itemsNeedAdd.add("场均得分"); avg1.add(5.9); avg2.add(10.043);
		itemsNeedAdd.add("场均助攻"); avg1.add(1.0); avg2.add(2.159);
		itemsNeedAdd.add("场均篮板"); avg1.add(4.4); avg2.add(4.469);
		itemsNeedAdd.add("三分％"); 	avg1.add(30.0); avg2.add(34.5);
		itemsNeedAdd.add("罚球％");	avg1.add(78.4); avg2.add(74.3);
//		itemsNeedAdd.add("分钟");
	
		jf.add(new VSContentPanel(itemsNeedAdd,avg1,avg2,true));
		jf.setVisible(true);
	}

	
}

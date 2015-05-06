package presentation.player.playerDetail;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import dataservice.player.sortParam;
import presentation.common.TF;
import vo.playervo.PlayerVO;

public class FilterLabel extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilterComboBox leagueCombo;
	public FilterComboBox positionCombo;
	public FilterComboBox firstCombo;
	public FilterComboBox secondCombo;
	public FilterComboBox thirdCombo;
	

	public FilterLabel(){
		initialise();
	}
	
	private void initialise(){
		this.setLayout(null);
		this.setSize(1280, 90);
		this.setOpaque(true);
		this.setBackground(Color.GRAY);
		
		chooseLeague();
		choosePosition();
		
		setFirst();
		setSecond();
		setThird();
	}
	
	private void chooseLeague(){
		leagueCombo = new FilterComboBox();
		leagueCombo.addItem("筛选－联盟");
		leagueCombo.addItem("全部");
		leagueCombo.addItem("东部联盟");
		leagueCombo.addItem("西部联盟");
		leagueCombo.setLocation(50, 10);
		leagueCombo.setSelectedIndex(0);
		this.add(leagueCombo);
	}
	
	private void choosePosition(){
		positionCombo = new FilterComboBox();
		positionCombo.addItem("筛选－位置");
		positionCombo.addItem("全部");
		positionCombo.addItem("前锋");
		positionCombo.addItem("中锋");
		positionCombo.addItem("后卫");
		positionCombo.setSelectedIndex(0);
		positionCombo.setLocation(200, 10);
		this.add(positionCombo);
	}
	
	private void setFirst(){
		firstCombo = new AccordFilterComboBox("第一优先级");
		firstCombo.setLocation(350, 10);
		this.add(firstCombo);
	}
	
	private void setSecond(){

		secondCombo = new AccordFilterComboBox("第二优先级");
		secondCombo.setLocation(500, 10);
		this.add(secondCombo);
	}
	
	private void setThird(){

		thirdCombo = new AccordFilterComboBox("第三优先级");
		thirdCombo.setLocation(650, 10);
		this.add(thirdCombo);
	}
		
	private void setConfirm(){
		JButton confirmButton = new JButton("确定");
		confirmButton.setBounds(850, 10, 150, 30);
		confirmButton.addActionListener(new ConfirmAction());
		this.add(confirmButton);
	}
	
	public static void main(String args[]){
		TF f = new TF();
		FilterLabel label = new FilterLabel();
		label.setLocation(0, 20);
		f.add(label);
		f.setBounds(10, 200, 1280, 160);
//		f.pack();
	}
	
	public class FilterComboBox extends JComboBox<String>{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		FilterComboBox(){
			initialise();
		}
		
		private void initialise(){
			this.setBackground(Color.LIGHT_GRAY);
			this.setBorder(null);
			this.setSize(120, 30);
		}
		
	}

	class AccordFilterComboBox extends FilterComboBox{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public AccordFilterComboBox(String piority){
			this.initialise(piority);
		}
		
		private void initialise(String piority){
			this.addItem(piority);
			this.addItem("场均助攻");
			this.addItem("场均盖帽");
			this.addItem("场均防守");
			this.addItem("场均失误");
			this.addItem("场均犯规");
			this.addItem("上场时间");
			this.addItem("进攻");
			this.addItem("场均篮板");
			this.addItem("场均得分");
			this.addItem("场均抢断");
			this.addItem("GMSC效率值");
			this.addItem("三分命中率");
			this.addItem("投篮命中率");
			this.addItem("罚球命中率");
			
			
			this.setSelectedIndex(0);
			
		}
		
	}

	class ConfirmAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
}

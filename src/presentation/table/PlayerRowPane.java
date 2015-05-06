package presentation.table;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import presentation.main.Mainframe;
import presentation.player.playerDetail.PlayerMiddlePanel;

public class PlayerRowPane extends RowPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlayerRowPane(int index, boolean hasIndex) {
		super(index, hasIndex);
		// TODO Auto-generated constructor stub
	}
	
	public void addData(String data,int width){		
		JLabel block = new JLabel(data,JLabel.CENTER);
		block.setPreferredSize(new Dimension(width, TablePane.height));
		block.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				Component[] labels =  getComponents();
				System.out.println(((JLabel) labels[2]).getText());
				Mainframe.getFrame().setContentPane(new PlayerMiddlePanel(((JLabel) labels[2]).getText()));
			}
		
		});
		this.add(block);
	}

}

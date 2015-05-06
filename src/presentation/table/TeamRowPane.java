package presentation.table;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import presentation.main.Mainframe;
import presentation.team.teamDetail.TeamMiddlePanel;

public class TeamRowPane extends RowPane{

	public TeamRowPane(int index, boolean hasIndex, int width, int h) {
		super(index, hasIndex, width, h);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public void addData(String data,int width){		
		JLabel block = new JLabel(data,JLabel.CENTER);
		block.setPreferredSize(new Dimension(width,height));
		block.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				Component[] labels =  getComponents();
				Mainframe.getFrame().changeContent(new TeamMiddlePanel(((JLabel) labels[2]).getText()));
			}
		
		});
		this.add(block);
	}
}

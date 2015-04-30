package presentation.table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RowContainerPane extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<RowPane> rowPanes;

	public RowContainerPane(ArrayList<RowPane> rows){
	//	this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		FlowLayout fl = (FlowLayout) this.getLayout();
		fl.setVgap(0);
//		this.setBounds(0,0,TablePane.width,Math.max(TablePane.height*(rows.size()+1),TablePane.sumHeight));
		this.setPreferredSize(new Dimension(TablePane.width, Math.max(TablePane.height*(rows.size()+1),TablePane.sumHeight)));

		this.setBackground(new Color(245,245,245));
		setRows(rows);
	}
	
	
	public void setRows(ArrayList<RowPane> rows){
		rowPanes = rows;
		this.removeAll();
		for(int i=0;i<rows.size();i++){
			this.add(rows.get(i));
			this.repaint();
		}
	}

}

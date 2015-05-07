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
	ArrayList<? extends RowPane> rowPanes;

	public RowContainerPane(ArrayList<? extends RowPane> rows,int width,int height,int sumHeight){
		FlowLayout fl = (FlowLayout) this.getLayout();
		fl.setVgap(0);
		this.setPreferredSize(new Dimension(width, Math.max(height*(rows.size()+1),sumHeight)));

		this.setBackground(new Color(245,245,245));
		setRows(rows);
	}
	
	
	public void setRows(ArrayList<? extends RowPane> rows){
		rowPanes = rows;
		this.removeAll();
		for(int i=0;i<rows.size();i++){
			this.add(rows.get(i));
			this.repaint();
		}
	}

}

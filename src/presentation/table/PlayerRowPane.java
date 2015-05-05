package presentation.table;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

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
				System.out.println("player");
			}
		
		});
		this.add(block);
	}

}

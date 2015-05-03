package presentation.common;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyCheckBoxLabel extends JLabel{

	/**
	 * 
	 */
	String chosenPath;
	String unchosePath;
	private static final long serialVersionUID = 1L;
	
//	height = 17
	public MyCheckBoxLabel(String item){
		this.setOpaque(true);
		this.setText(item);
		this.setFont(new Font("Dialog",1,15));
		this.setBackground(Color.GRAY);
		this.setForeground(Color.WHITE);
		this.setIcon(new ImageIcon("unchosen.png"));
		this.setHorizontalAlignment(JLabel.LEADING);
//		this.setSize(110, 50);
		this.setPreferredSize(new Dimension(220, 30));
		this.setLocation(0, 0);
		this.addMouseListener(new CheckBoxListener());
	}
	
	class CheckBoxListener implements MouseListener{

		int clickedTimes = 0;
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			clickedTimes += 1;
			MyCheckBoxLabel checkBoxLabel = (MyCheckBoxLabel) e.getSource();
			if(clickedTimes%2 == 1){
				checkBoxLabel.setIcon(new ImageIcon("chosen.png"));
			}else{
				checkBoxLabel.setIcon(new ImageIcon("unchosen.png"));
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			MyCheckBoxLabel checkBoxLabel = (MyCheckBoxLabel) e.getSource();
			checkBoxLabel.setCursor();		
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public void setCursor(){
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));		
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new MyCheckBoxLabel("running"));
		jf.setVisible(true);
	}

	
}

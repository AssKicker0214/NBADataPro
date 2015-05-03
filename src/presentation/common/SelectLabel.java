package presentation.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class SelectLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean isSelected = false;
	Color entered;
	Color pressed;
	Color exicted;

	
	public SelectLabel(String text,Point p1,Point p2){
		this.setOpaque(true);
		this.setText(text);
		this.setFont(new Font("Dialog",1,15));
		this.setBackground(Color.BLACK);
		this.setForeground(Color.WHITE);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setBounds(p1.x, p1.y, p2.x, p2.y);
		this.addMouseListener(new LabelListener());
		this.entered = Color.LIGHT_GRAY;
		this.pressed = Color.GRAY;
		this.exicted = Color.BLACK;
	}
	
	public SelectLabel(String text,Point p1,Point p2,Color entered,Color pressed,Color exicted){
		this.setOpaque(true);
		this.setText(text);
		this.setFont(new Font("Dialog",1,15));
		this.setBackground(Color.BLACK);
		this.setForeground(Color.WHITE);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setBounds(p1.x, p1.y, p2.x, p2.y);
		this.addMouseListener(new LabelListener());
		this.entered = entered;
		this.pressed = pressed;
		this.exicted = exicted;
	}

	class LabelListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			isSelected = true;
			SelectLabel l = (SelectLabel) e.getSource();
			l.setBackground(pressed);

		}

		@Override
		public void mousePressed(MouseEvent e) {
	
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			SelectLabel l = (SelectLabel) e.getSource();
			l.setBackground(entered);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			SelectLabel l = (SelectLabel) e.getSource();
			if(!l.isSelected){
				l.setBackground(exicted);
			}else{
				l.setBackground(pressed);
			}
		}
		
		
	}

}

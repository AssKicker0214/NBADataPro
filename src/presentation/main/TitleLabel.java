package presentation.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

public class TitleLabel extends JLabel{

	public TitleLabel(){
		initialise();
	}
	
	private void initialise(){
		this.setBounds(0, 0, 1280,30);
		this.setBackground(Color.black);
		this.setOpaque(true);
		this.addMouseMotionListener(new  MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void setClose(){
		
	}
	
	private void setMin(){
		JLabel minLabel = new JLabel("-");
		minLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
		minLabel.setForeground(Color.white);
		minLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		this.add(minLabel);
		
	}
}

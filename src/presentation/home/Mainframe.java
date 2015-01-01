package presentation.home;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mainframe extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  Mainframe(){ 
	
		setLayout(null);
		setUndecorated(true);
		setSize(1280,700);
		setLocationRelativeTo(null);
		setTitleLabel();
		setImageLabel();
		setGuideGroup();
		setVisible(true);
		
	}
	
	
	private void setTitleLabel(){
		JLabel titleLabel = new JLabel();
		titleLabel.setBounds(0, 0, 1280,30);
		titleLabel.setBackground(Color.black);
		titleLabel.setOpaque(true);
		this.add(titleLabel);
		titleLabel.addMouseMotionListener(new  MouseMotionListener(
				) {
			
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
	
	
	public void setImageLabel(){
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 30, 1280,120);
		imageLabel.setBackground(Color.darkGray);
		imageLabel.setOpaque(true);
		this.add(imageLabel);
	}
	
	public void setGuideGroup(){
		JLabel guideLabel = new JLabel();
		guideLabel.setLayout(new GridLayout(4,1,0,5));
		guideLabel.setBounds(0, 155, 150,550);
		guideLabel.setBackground(Color.darkGray);
		guideLabel.setOpaque(true);
		guideLabel.add(new GuideLabel());
		guideLabel.add(new GuideLabel());
		guideLabel.add(new GuideLabel());
		guideLabel.add(new GuideLabel());

		this.add(guideLabel);
	}
	public static  void main(String[] args){
		Mainframe mf = new Mainframe();
	}

}

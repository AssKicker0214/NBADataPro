package presentation.main;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public abstract class SuboptionLayer extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GuideLabel guideLabel;
	IMainFrame imainframe;
	
	Color entered = new Color(30,80,140);
	Color pressed = new Color(42,109,183);
	Color exicted= new Color(26,70,122);


	public SuboptionLayer(){
		this.setOpaque(true);
		this.setBackground(new Color(45, 67, 45));
		this.setBounds(150, 450, 200, 60);
		this.setLayout(null);
		this.setVisible(false);
		makeSubOptions();
	}
	
	public abstract void  makeSubOptions(); 
	
	
	
	public void setMainFrame(IMainFrame imainframe){
		this.imainframe = imainframe;
	}
	
	public void link(GuideLabel guideLabel){
		this.guideLabel = guideLabel;
	}
	
	public void showSuboptions() {
		
		this.setLocation(150, guideLabel.getY()+150);
		this.setVisible(true);
	}
	
	public void hideSuboptions(){
		this.setVisible(false);
	}
	
	class SubOptionLabel extends JLabel implements MouseListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

			public SubOptionLabel(String option){
			this.setText(option);
			this.setForeground(Color.WHITE);
			this.setBackground(exicted);
			this.setOpaque(true);
			this.addMouseListener(this);
			
		}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				imainframe.update(this.getText());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
	}
}

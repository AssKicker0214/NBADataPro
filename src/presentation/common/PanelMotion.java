package presentation.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelMotion {

	private ArrayList<JPanel> panels;
	private Timer upTimer;
	private Timer downTimer;
	private int y;
	
	public PanelMotion(ArrayList<JPanel> panels, int y){
		this.panels = panels;
		this.y = y;
	}
	
	public void upMove(){
		upTimer = new Timer(20, new UpMotion());
		upTimer.start();
	}
	
	public void downMove(){
		downTimer = new Timer(20, new DownMotion());
		downTimer.start();
	}
	
	class DownMotion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for(JPanel panel:panels){
				int currentY = panel.getY();
				if(currentY < y){
					panel.setLocation(panel.getX(), currentY+3);
				}else{
					panel.setLocation(panel.getX(), y);
					downTimer.stop();
				}
			}
			
			
		}
		
	}
	
	class UpMotion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for(JPanel panel:panels){
				int currentY = panel.getY();
				if(currentY < y){
					panel.setLocation(panel.getX(), currentY-3);
				}else{
					panel.setLocation(panel.getX(), y);
					downTimer.stop();
				}
			}
			
		}
		
	}
	
}

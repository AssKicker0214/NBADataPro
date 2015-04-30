package presentation.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import ui.statistics.playerKing.PlayerKingPanel;

public class GuideLabel extends JLabel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IMainFrame imainframe;
	
	private boolean selected = false;
	private SuboptionLayer suboptionLayer;
	private boolean hasSuboptions = false;
	private IGuideContainer container;
	
	private String son;

	Color entered = new Color(30,80,140);
	Color pressed = new Color(42,109,183);
	Color exicted= new Color(26,70,122);
	
		public GuideLabel(){
			initialise();
		}
		
		public GuideLabel(String text){
			this.setText(text);
			this.setFont(new Font("Dialog",1,20));
			this.setHorizontalAlignment(JLabel.CENTER);
			initialise();
		}
		
		public void paint(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
//			g2d.rotate(Math.PI/12);
			
			super.paint(g2d);
		}
		
		private void initialise(){
			this.setSize(120, 130);
			this.setBackground(pressed);
			this.setForeground(Color.WHITE);
			this.setOpaque(true);
			this.addMouseListener(this);
		}
/**
 * observer
 * */		
		public void setMainFrame(IMainFrame imainframe){
			this.imainframe = imainframe;
		}
		
		public void setContainer(IGuideContainer container){
			this.container = container;
					
		}
		
		public void linkSuboption(SuboptionLayer suboption){
			this.suboptionLayer = suboption;
			suboption.link(this);
			hasSuboptions = true;
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			imainframe.update(this.getText());
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			if(selected){
				
			}else{
				this.setSize(130, 130);
			}
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			if(selected){
				
			}else{
				this.setSize(120, 130);
			}			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			if(selected){
				setUnselected();
			}else{
				setSelected();
				if(suboptionLayer != null){
					suboptionLayer.showSuboptions();
				}
			}	
//			selected = !selected;
//			System.out.println(selected);
		}
		
		public void update(){
			if(selected){
				selected = false;
				setUnselected();
			}
		}
		
		private void setSelected(){
			selected = true;
			this.setSize(150, 130);
			container.notifyOtherGuides(this);
		}
		
		private void setUnselected(){
			selected = false;
			this.setSize(120, 130);
			if(suboptionLayer != null){
				suboptionLayer.hideSuboptions();
			}
		}
		
		private void setSigned(){
			
		}
}

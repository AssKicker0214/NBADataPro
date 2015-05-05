package presentation.floatui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.TimerTask;

import javax.swing.*;

import presentation.main.IMainFrame;


public class FloatButton extends JLabel implements MouseMotionListener, MouseListener, ComponentListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	IFloatPane floatPane;
	IMainFrame mainPane;
	IMainFrameSize mainFrameSize;
	
	private int buttonX;
	private int buttonY;
	private int mouseX;
	private int mouseY;
	
	public FloatButton(){
//		this.setOpaque(true);
		this.setBounds(400, 300, 100, 100);
		this.setIcon(new ImageIcon("切换ball.png"));
//		this.setBackground(new Color(134, 150, 178, 200));
		this.setFont(new Font("微软雅黑", Font.BOLD, 16));
		this.setHorizontalAlignment(JLabel.CENTER);
//		this.setText("Team - Player");
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	private void makeBorder(){
		TimerTask task = new TimerTask(){
			
			int r = (int) (Math.random()*255);
			int g = (int) (Math.random()*255);
			int b = (int) (Math.random()*255);
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		};
		new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected void process(List<Void> chunks) {
				// TODO Auto-generated method stub
				super.process(chunks);
			}

			@Override
			protected void done() {
				// TODO Auto-generated method stub
				super.done();
			}

		}.execute();;
	}
	
	public void setFloatPane(FloatPane floatPane){
		this.floatPane = floatPane;
	}
	
	public void setMainPaneChange(IMainFrame mainfame){
		this.mainPane = mainfame;
	}
	
	public void setMainFrameSize(IMainFrameSize size){
		this.mainFrameSize = size;
	}
	
	public void mouseDragged(MouseEvent e) {
		int currentMouseX = e.getX();
		int currentMouseY = e.getY();
		
		int dx = currentMouseX - mouseX;
		int dy = currentMouseY - mouseY;
		
		this.setLocation(buttonX+dx, buttonY+dy);
		buttonX = buttonX + dx;
		buttonY = buttonY + dy;
		
		floatPane.refresh();
		this.repaint();
	}

	public void mouseMoved(MouseEvent e) {
		
	}

	public void mouseClicked(MouseEvent e) {
//		mainPane.changeMainPane();
		mainPane.returnIni();
	}

	public void mousePressed(MouseEvent e) {
		buttonX = this.getX();
		buttonY = this.getY();
		mouseX = e.getX();
		mouseY = e.getY();
		this.setIcon(new ImageIcon("切换ball.png"));
	}

	public void mouseReleased(MouseEvent e) {
//		this.setOpaque(true);
//		this.setIcon(null);
		
		Dimension d = mainFrameSize.getMainFrameSize();
		
		int x = this.getLocation().x;
		int y = this.getLocation().y;
		
		int fWidth = d.width - 20;
		int fHeight = d.height - 40;
		
		int bWidth = this.getWidth();
		int bHeight = this.getHeight();
		
		if(x<0 && y>=0){
			this.setLocation(0, y);
			this.setIcon(new ImageIcon("切换left.png"));
			this.setOpaque(false);
		}else if(y<0 && x>=0){
			this.setLocation(x, 0);
			this.setIcon(new ImageIcon("切换top.png"));
			this.setOpaque(false);
		}else if(x<0 && y<0){
			this.setLocation(0, 0);
			this.setIcon(new ImageIcon("切换top.png"));
			this.setOpaque(false);
		}
		
		if(x+bWidth>fWidth && y+bHeight<=fHeight){
			this.setLocation(fWidth-bWidth, y);
			this.setIcon(new ImageIcon("切换right.png"));
			this.setOpaque(false);
		}else if(y+bHeight>fHeight && x+bWidth<=fWidth){
			this.setLocation(x, fHeight-bHeight);
			this.setIcon(new ImageIcon("切换top.png"));
			this.setOpaque(false);
		}else if(x+bWidth>fWidth && y+bHeight>fHeight){//右下角
			this.setLocation(fWidth-bWidth, fHeight-bHeight);
			this.setOpaque(false);
			this.setIcon(new ImageIcon("页脚.png"));
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		Component frame = (Component) e.getSource();
		Dimension d = frame.getSize();
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}

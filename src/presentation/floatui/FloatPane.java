package presentation.floatui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import ui.main.IMainFrame;

public class FloatPane extends JPanel implements IFloatPane{

//	IMainPaneChange mainPane;
	FloatButton button;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	IMainFrame mainFrame;

	public FloatPane(){
		this.setOpaque(false);
		this.setBackground(new Color(0, 0, 0, 0));
		this.setLayout(null);
		this.setBounds(0, 0, 1400, 900);
//		this.setPreferredSize(new Dimension(800, 500));
		this.addFloatButton();
	}
	
	public void addFloatButton(){
		button = new FloatButton();
		button.setFloatPane(this);
		this.add(button);
		this.repaint();
	}
	
	public void setMainFrame(IMainFrame mainFrame){
		this.mainFrame = mainFrame;
		button.setMainPaneChange(mainFrame);
		button.setMainFrameSize((IMainFrameSize) mainFrame);
	}
	
	
	public void refresh(){
		this.repaint();
	}
	
	public static void main(String args[]){
		JFrame f = new JFrame();
//		f.setUndecorated(true);
		FloatPane p = new FloatPane();
		f.getContentPane().setBackground(Color.blue);
		f.getContentPane().add(p);
//		p.addFloatButton();
//		f.add(p);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

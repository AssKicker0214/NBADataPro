package presentation.common;

import javax.swing.JFrame;

public class testCalendar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public testCalendar() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setUndecorated(true);
		setSize(1280,700);
		setLocationRelativeTo(null);
		setCalendar();
		setVisible(true);
		
	}
	public void setCalendar(){
		DateLabel calendar = new DateLabel();
		calendar.setBounds(0, 100,100, 100);
		this.add(calendar);
	}

	public static void main(String[] args){
		new testCalendar();
	}
	
}

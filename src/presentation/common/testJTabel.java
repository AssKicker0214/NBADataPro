package presentation.common;

import javax.swing.JFrame;
import javax.swing.JTable;

public class testJTabel extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int width = 1280;
	
	private JTable fileTable;
	
	public testJTabel(){
		
	}
	
	private void initTabel(){
		String[] columnName = new String[]{
			"日期","对手","分钟","％","命中","出手","三分％","三分命中","三分出手" 	
		};
		Object[][] columnValues = new Object[][]{
				{"4/16/15","活塞","19","0.0","0","4","0.0","0","2"},
				{"4/16/15","活塞","19","0.0","0","4","0.0","0","2"},
				{"4/16/15","活塞","19","0.0","0","4","0.0","0","2"},
				{"4/16/15","活塞","19","0.0","0","4","0.0","0","2"},
		};
		fileTable = new JTable(columnValues,columnName);
		fileTable.setRowHeight(25);
		
		
	}

}

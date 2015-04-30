package presentation.table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

public class TablePane extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  static int height = 50;
	public  static int width;
	public  static int column;
	public  static int sumHeight;
	
	private JPanel header;
	private JScrollPane content;
	private RowContainerPane rowContainer;

	public TablePane(ArrayList<ArrayList<String>> datas,String[] columns,ArrayList<Integer> wid,int x,int y,int w,int sh,int h ,boolean hasIndex){
		height = h;
		width = w;
		sumHeight = sh;
		column = columns.length; 
		this.setBackground(Color.WHITE);
		this.setBounds(x,y,w,sh);
		this.setLayout(null);
		
		
		setHeader(columns,wid,hasIndex);
		getRows(datas,wid,columns[0],hasIndex);
		
		this.repaint();
	}
	
	
	private void getRows(final ArrayList<ArrayList<String>> rowInfos, final ArrayList<Integer> width,final String firstVal,final boolean hasIndex){
		
		SwingWorker<ArrayList<RowPane>, Void> worker = new SwingWorker<ArrayList<RowPane>, Void>() {

			protected ArrayList<RowPane> doInBackground() throws Exception {
				ArrayList<RowPane> rows = new ArrayList<RowPane>();
//				ArrayList<Integer> widths = decideWidth(dataTypes);
//				
				if(firstVal.equals(""))
					for(int i=0;i<rowInfos.size();i++){
						RowPane row = new RowPane(i+1,hasIndex);		
						row.addDatas_pic(rowInfos.get(i),width);
						rows.add(row);
					}
				else
					for(int i=0;i<rowInfos.size();i++){
						RowPane row = new RowPane(i+1,hasIndex);		
						row.addDatas(rowInfos.get(i),width);
						rows.add(row);
					}
				return rows;
				
			}
			
			protected void done(){
				try {
					ArrayList<RowPane> rows = get();
					setContent(rows);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		};
		
		worker.execute();
		
	}
	private void setHeader(String[] columns, ArrayList<Integer> wid, boolean hasIndex){
		header = new JPanel();
		header.setBackground(Color.LIGHT_GRAY);
		FlowLayout flowLayout = (FlowLayout) header.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEADING);
		header.setBounds(0,0,width,30);
		header.setLayout(flowLayout);
		
		if(hasIndex){
			JLabel cLabel = new JLabel(" ",JLabel.CENTER);
			cLabel.setPreferredSize(new Dimension(20, 30));
			header.add(cLabel);
		}
		for(int i=0;i<column;i++){
			JLabel l1 = new JLabel(columns[i],JLabel.CENTER);
			
			l1.setPreferredSize(new Dimension(wid.get(i), 30));
			header.add(l1);
		}
		this.add(header);
	}
	private void setContent(ArrayList<RowPane> rows){

		content = new JScrollPane();
		content.getVerticalScrollBar().setUnitIncrement(40);
		content.setBounds(0, 30, width+20, sumHeight);
		content.setBackground(new Color(245,245,245));
		rowContainer = new RowContainerPane(rows);
		this.add(content);
		content.setViewportView(rowContainer);
		
	}
	
	public static void main(String args[]){
		JFrame f = new JFrame();
		f.setLayout(null);
		f.setSize(1280,700);
		f.setLocationRelativeTo(null);
	
		ArrayList<String> l1 = new ArrayList<String>();
		l1.add("teamsPNG/ATL.png");
		l1.add("0.1");
		l1.add("0.2");
		l1.add("0.1");
		l1.add("0.2");
		
		ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
		a.add(l1);
		a.add(l1);
		a.add(l1);
		a.add(l1);
		a.add(l1);
		a.add(l1);
		a.add(l1);
		a.add(l1);
		a.add(l1);
		a.add(l1);
		String[] b = {"","**","**","**","**"};
		ArrayList<Integer> w = new ArrayList<Integer>();
		w.add(50);
		w.add(100);
		w.add(200);
		w.add(300);
		w.add(400);
		TablePane t = new TablePane(a,b,w,0,0,1200,200,40,false);
		f.getContentPane().add(t);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}

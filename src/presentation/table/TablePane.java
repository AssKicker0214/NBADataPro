package presentation.table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

import presentation.common.ListType;

public class TablePane extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  static int height = 50;
	public  static int width;
	public  static int column;
	public  static int sumHeight;
	
	protected JPanel header;
	protected JScrollPane content;
	protected RowContainerPane rowContainer;
	
	protected ListType type;
	protected ArrayList<Integer> wid;
	protected String firstV;
	protected boolean hasIndex;
	
	protected ArrayList<JLabel> headsList = new ArrayList<JLabel>();
	
	public TablePane(ArrayList<ArrayList<String>> datas,String[] columns,ArrayList<Integer> wi,
			int x,int y,int w,int sh,int h ,boolean hasI,boolean whetherRank){
		height = h;
		width = w;
		sumHeight = sh;
		column = columns.length; 
		wid = wi;
		firstV = columns[0];
		hasIndex = hasI;
		this.setBackground(Color.WHITE);
		this.setBounds(x,y,w,sh);
		this.setLayout(null);
		
		
		setHeader(columns,wid,hasIndex,whetherRank);
		getRows(datas);
		
		this.repaint();
	}
	
	
	protected void getRows(final ArrayList<ArrayList<String>> rowInfos){
		
		SwingWorker<ArrayList<RowPane>, Void> worker = new SwingWorker<ArrayList<RowPane>, Void>() {

			protected ArrayList<RowPane> doInBackground() throws Exception {
				ArrayList<RowPane> rows = new ArrayList<RowPane>();
//				ArrayList<Integer> widths = decideWidth(dataTypes);
//				
				if(firstV.equals(""))
					for(int i=0;i<rowInfos.size();i++){
						RowPane row = new RowPane(i+1,hasIndex);		
						row.addDatas_pic(rowInfos.get(i),wid);
						rows.add(row);
					}
				else
					for(int i=0;i<rowInfos.size();i++){
						RowPane row = new RowPane(i+1,hasIndex);		
						row.addDatas(rowInfos.get(i),wid);
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
	
	protected void setHeader(String[] columns, ArrayList<Integer> wid, boolean hasIndex,boolean whetherRank){
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
			cLabel.setPreferredSize(new Dimension(30, 30));
			header.add(cLabel);
		}
		for(int i=0;i<column;i++){
			JLabel l1 = new JLabel(columns[i],JLabel.CENTER);
			l1.setPreferredSize(new Dimension(wid.get(i), 30));
			header.add(l1);
			headsList.add(l1);
			if(whetherRank){
				l1.addMouseListener(new MouseAdapter() {
			
					int clicked = 0;
					boolean isSelected = false;

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						isSelected = true;
						clicked += 1;
						boolean isDesc = true;
						if(clicked%2 == 0){
							isDesc = false;
						}
						l1.setOpaque(true);
						l1.setBackground(Color.GRAY);
						setSelectedGroups(l1);
						SortContent(l1.getText(),isDesc);
					}
				
					@Override
					public void mouseExited(MouseEvent e) {
						JLabel l = (JLabel) e.getSource();
						if(!isSelected){
							l.setBackground(Color.LIGHT_GRAY) ;
						}else{
							l.setBackground(Color.GRAY);
						}
					
					}				
					@Override
					public void mouseEntered(MouseEvent e) {
						JLabel jl = (JLabel) e.getSource();
						jl.setOpaque(true);
						jl.setBackground(Color.GRAY);
					}
				});
			}
			this.add(header);
		}
	}
		
	protected void setSelectedGroups(JLabel s){
		for(JLabel sl : headsList){
			if(sl != s){
				sl.setBackground(Color.LIGHT_GRAY);
			}
		}
	}
	
	protected void setContent(ArrayList<RowPane> rows){

		content = new JScrollPane();
		content.getVerticalScrollBar().setUnitIncrement(40);
		content.setBounds(0, 30, width+20, sumHeight);
		content.setBackground(new Color(245,245,245));
		rowContainer = new RowContainerPane(rows);
		this.add(content);
		content.setViewportView(rowContainer);
	}
	
	public void SortContent(String sortBy,boolean isDesc){}
	
	
	public static void main(String args[]){
		JFrame f = new JFrame();
		f.setLayout(null);
		f.setSize(1280,700);
		f.setLocationRelativeTo(null);
	
		ArrayList<String> l1 = new ArrayList<String>();
		l1.add("bg.png");
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
		TablePane t = new TablePane(a,b,w,0,0,1200,200,40,true,true);
		f.getContentPane().add(t);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}

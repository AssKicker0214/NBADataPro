package presentation.main;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;

public class GuideContainer extends JLabel implements IGuideContainer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<GuideLabel> guides;
	
	Color entered = new Color(30,80,140);
	Color pressed = new Color(42,109,183);
	Color exicted= new Color(26,70,122);


	public GuideContainer(){
		this.setBounds(0, 125, 145, 550);
		this.setLayout(null);
		this.setBackground(entered);
		this.setOpaque(true);
		setWhiteLine();
		guides = new ArrayList<GuideLabel>();
	}
	
	public void addGuide(GuideLabel guide){
		guides.add(guide);
		guide.setContainer(this);
		if(guides.size() == 4){
			this.showGuides();
		}
	}
	
	private void setWhiteLine(){
		JLabel white = new JLabel();
		white.setBackground(Color.WHITE);
		white.setLayout(null);
		white.setOpaque(true);
		white.setBounds(100, 155, 5, 550);
		this.add(white,0);
	}
	
	private void showGuides(){
		this.removeAll();
		for(int i=0;i<guides.size();i++){
			guides.get(i).setLocation(0, 5 + 135*i);
			this.add(guides.get(i));
		}
	}

	public void notifyOtherGuides(GuideLabel sourceGuide) {
		for(int i=0;i<guides.size();i++){
			GuideLabel guide = guides.get(i);
			if(guide != sourceGuide){
				guide.update();
			}else{
//				System.out.println("```");
			}
		}
			
	}
	
	public void setAllUnselected(){
		for(GuideLabel label : guides){
			label.update();
		}
	}
}

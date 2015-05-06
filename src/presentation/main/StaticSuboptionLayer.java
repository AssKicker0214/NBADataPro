package presentation.main;

import java.awt.GridLayout;

public class StaticSuboptionLayer extends SuboptionLayer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	public void makeSubOptions() {
		// TODO Auto-generated method stub
		this.setLayout(new GridLayout(1, 3));
		SubOptionLabel playerKing = new SubOptionLabel("热点球员");
		SubOptionLabel teamKing = new SubOptionLabel("热点球队");
		SubOptionLabel hotPlayer = new SubOptionLabel("进步球员");
		this.add(playerKing);
		this.add(teamKing);
		this.add(hotPlayer);
	}

	
}

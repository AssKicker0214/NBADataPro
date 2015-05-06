package presentation.main;

import java.awt.GridLayout;

public class TeamSuboptionLayer extends SuboptionLayer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	public void makeSubOptions() {
		this.setLayout(new GridLayout(1, 2));
		SubOptionLabel teamList = new SubOptionLabel("球队列表");
		SubOptionLabel teamTable = new SubOptionLabel("球队表格");
		this.add(teamList);
		this.add(teamTable);
	}

}

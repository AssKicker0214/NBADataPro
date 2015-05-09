package autotest;

import data.DataInitial;
import de.tototec.cmdoption.CmdOption;

public class Config {
	
	@CmdOption(names={"--datasourse"},args={"dataSourse"})
	public void setData(String dataSourse){
		DataInitial.setPath(dataSourse);
		DataInitial.init();

		System.out.println(dataSourse);
	}
}

package autotest;

import data.DataInitial;
import de.tototec.cmdoption.CmdOption;

public class Config {
	
	@CmdOption(names={"--datasource"},args={"dataSourse"})
	public void setData(String dataSourse){
		DataInitial.setPath(dataSourse);
		DataInitial.init();
	}
}

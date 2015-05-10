package autotest;

import data.DataInitial;
import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;

@CmdCommand(names={"--datasource"},description="Show Player Infomation")
public class Config {
	
	@CmdOption(args={"dataSourse"})
	public void setData(String dataSourse){
		DataInitial.setPath(dataSourse);
		DataInitial.init();
	}
}

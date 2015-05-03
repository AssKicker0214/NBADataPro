package autotest;

import de.tototec.cmdoption.CmdOption;

public class Config {
	
	@CmdOption(names={"--datasourse"},args={"dataSourse"})
	public void setData(String dataSourse){
		//设置数据源
		System.out.println(dataSourse);
	}
}

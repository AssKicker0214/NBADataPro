package autotest;

import de.tototec.cmdoption.CmdOption;

public class Config {
	
	@CmdOption(names={"--datasourse"},args={"dataSourse"})
	public void setData(String dataSourse){
		//��������Դ
		System.out.println(dataSourse);
	}
}

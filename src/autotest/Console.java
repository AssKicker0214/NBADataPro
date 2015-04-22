package autotest;

import java.io.PrintStream;

import de.tototec.cmdoption.CmdlineParser;
import de.tototec.cmdoption.CmdlineParserException;

public class Console {
	public void execute(PrintStream out, String[] args){
//		TeamCommand CmdObj = null;
		Config c = new Config();
		TeamCommand tc = new TeamCommand();
		PlayerCommand pc = new PlayerCommand();
		CmdlineParser cp = new CmdlineParser(c,tc,pc);
		try {
			  cp.parse(args);;
		} catch (CmdlineParserException e) {
			System.err.println("Error: " + e.getMessage() + "\nRun myprogram --help for help.");
		}
		
		//����λ�������������󷵻�
		if(cp.getParsedCommandName()==null)
			return;
		
		//��Ա/���ģ������
//		System.out.println(cp.getParsedCommandName());
		
		if(cp.getParsedCommandName().equals("-team")){
			TeamCommand CmdObj = (TeamCommand)cp.getParsedCommandObject();
			CmdObj.optionHandler();
		//	System.out.println(CmdObj.isAll+" "+CmdObj.number+CmdObj.hotNum);
		}
		if(cp.getParsedCommandName().equals("-player")){
			PlayerCommand CmdObj = (PlayerCommand)cp.getParsedCommandObject();
			System.out.println(CmdObj.isAvg+" "+CmdObj.number);
		}
	}
}

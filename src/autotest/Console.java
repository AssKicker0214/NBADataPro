package autotest;

import java.io.PrintStream;

import data.DataInitial;
import de.tototec.cmdoption.CmdlineParser;
import de.tototec.cmdoption.CmdlineParserException;

public class Console {
	public void execute(PrintStream out, String[] args){
//		DataInitial.init();
//		TeamCommand CmdObj = null;
		Config c = new Config();
		TeamCommand tc = new TeamCommand();
		PlayerCommand pc = new PlayerCommand();
		CmdlineParser cp = new CmdlineParser(c,tc,pc);
		try {
			  cp.parse(args);
		} catch (CmdlineParserException e) {
			System.err.println("Error: " + e.getMessage() + "\nRun myprogram --help for help.");
		}
		
		if(cp.getParsedCommandName()==null)
			return;
		
//		System.out.println(cp.getParsedCommandName());
		
		if(cp.getParsedCommandName().equals("-team")){
			TeamCommand CmdObj = (TeamCommand)cp.getParsedCommandObject();
			CmdObj.optionHandler(out);
		}
		if(cp.getParsedCommandName().equals("-player")){
			PlayerCommand CmdObj = (PlayerCommand)cp.getParsedCommandObject();
			CmdObj.optionHandler(out);
		}
	}
	
	
}

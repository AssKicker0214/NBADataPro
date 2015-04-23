package autotest;

import java.io.PrintStream;
import java.util.ArrayList;

import po.teampo.HotTeamsPO;
import test.data.TeamHotInfo;
import data.team.TeamData;
import dataservice.team.TeamDataService;
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
		
		//若命令为读入数据则返回
		if(cp.getParsedCommandName()==null)
			return;
		
//		System.out.println(cp.getParsedCommandName());
		
		if(cp.getParsedCommandName().equals("-team")){
			TeamCommand CmdObj = (TeamCommand)cp.getParsedCommandObject();
			TeamDataService tds = new TeamData();
			if(!CmdObj.isAll){
				ArrayList<HotTeamsPO> result = tds.hotTeams(CmdObj.hotNum,CmdObj.sortBy);
				
				System.out.println(CmdObj.hotNum+CmdObj.sortBy);
			}else{
				System.out.println(CmdObj.isAvg+" "+CmdObj.isHigh+CmdObj.hotNum+CmdObj.sortBy+CmdObj.isDesc);
			}
		}
		if(cp.getParsedCommandName().equals("-player")){
			PlayerCommand CmdObj = (PlayerCommand)cp.getParsedCommandObject();
			System.out.println(CmdObj.isAvg+" "+CmdObj.number);
		}
	}
	
	public ArrayList<TeamHotInfo> exchange(ArrayList<HotTeamsPO> po,String field){
		ArrayList<TeamHotInfo> result = new ArrayList<TeamHotInfo>();
		for(int i=0;i<po.size();i++){
			TeamHotInfo temp = new TeamHotInfo();
			temp.setField(field);
			temp.setLeague(po.get(i).league);
			temp.setTeamName(po.get(i).name);
			temp.setValue(po.get(i).value);
		}
		return result;
	}
}

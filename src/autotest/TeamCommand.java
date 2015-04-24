package autotest;

import java.io.PrintStream;
import java.util.ArrayList;

import po.teampo.HotTeamsPO;
import po.teampo.TeamPO;
import data.team.TeamData;
import dataservice.team.TeamDataService;
import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;

@CmdCommand(names={"-team","-t"},description="Show Team Infomation")
public class TeamCommand {
	boolean isAvg = true;
	boolean isHot = false;
	boolean isHigh = false;
	int number = 30;
	int hotNum = 5;
	String sortBy = "-";
	boolean isDesc = true;
	
	@CmdOption(names={"-total"},description="show total data",conflictsWith={"-avg"})
	public void total(){
		isAvg = false;
	}
	@CmdOption(names={"-avg"},description="show average data",conflictsWith={"-total"})
	public void avg(){
		isAvg = true;
	}
	@CmdOption(names={"-all"},description="show data of all the teams",conflictsWith={"-hot"})
	public void all(){
		isHot = false;
	}
	@CmdOption(names={"-hot"},args={"sort"},description="show hot teams",conflictsWith={"-avg","-total","-sort"})
	public void hot(String sort){
		isAvg = true;
		isHot = true;
		sortBy = sort;
	}
	@CmdOption(names={"-n"},args={"num"},description="the number of teams to show(all)")
	public void changeNum(int num){
		if(isHot)
			hotNum = num;
		else
			number = num;
	}
	@CmdOption(names={"-high"},description="show high level data")
	public void high(){
		isHigh = true;
	}
	@CmdOption(names={"-sort"},args={"sort"},description="sort data")
	public void sort(String sort){
		String[] result = sort.split("."); 
		sortBy = result[0];
		if(result[1].equals("asc"))
			isDesc = false;
	}
	
	public void optionHandler(PrintStream out){
		TeamTransfer tt = new TeamTransfer();
		TeamDataService tds = new TeamData();
		if(isHot){
			ArrayList<HotTeamsPO> po = tds.hotTeams(hotNum,sortBy);
			tt.transfer_hot(out, po, sortBy);
		}else if(isHigh){
			if(sortBy.equals("-"))
				sortBy = "winRate";
			ArrayList<TeamPO> po = tds.sortTeamHigh(number,sortBy, isDesc, isAvg);
			tt.transfer_h(out, po);
		}else{
			if(sortBy.equals("-"))
				sortBy = "score";
			ArrayList<TeamPO> po = tds.sortTeamNormal(number,sortBy, isDesc, isAvg);
			tt.transfer_n(out, po);
		}
	}
}

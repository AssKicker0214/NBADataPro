package autotest;

import java.io.PrintStream;
import java.util.ArrayList;

import vo.teamvo.HotTeamsVO;
import vo.teamvo.TeamVO;
import dataservice.team.TeamDataService;
import dataservice.team.TeamData_stub;
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
		TeamDataService tds = new TeamData_stub();
		if(isHot){
			ArrayList<HotTeamsVO> vo = tds.hotTeams(hotNum,sortBy);
			tt.transfer_hot(out, vo, sortBy);
		}else if(isHigh){
			if(sortBy.equals("-"))
				sortBy = "winRate";
			ArrayList<TeamVO> vo = tds.sortTeamHigh(number,sortBy, isDesc);
			tt.transfer_h(out, vo);
		}else{
			if(sortBy.equals("-"))
				sortBy = "point";
			ArrayList<TeamVO> vo = new ArrayList<TeamVO>();
			if(isAvg){
				vo = tds.sortTeamNormalAvg(number,sortBy, isDesc);
				tt.transfer_avgn(out, vo);
			}else{
				vo = tds.sortTeamNormal(number,sortBy, isDesc);
				tt.transfer_n(out, vo);
			}
		}
	}
}

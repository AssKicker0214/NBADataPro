package dataservice.team;

import java.util.ArrayList;

import vo.playervo.PlayerVO;
import vo.teamvo.HotTeamsVO;
import vo.teamvo.TeamVO;

public class TeamData_stub implements TeamDataService{

	@Override
	public ArrayList<HotTeamsVO> hotTeams(int num, String sortBy) {
		ArrayList<HotTeamsVO>  result = new ArrayList<HotTeamsVO>();
		HotTeamsVO vo = new HotTeamsVO();
		vo.name = "Hawks";
		vo.league = 'E';
		vo.photo = "ATL";
		vo.location = "Atlanta";
		vo.value = 39;
		
		result.add(vo);
		result.add(vo);
		result.add(vo);
		result.add(vo);
		result.add(vo);
			
		return result;
	}

	@Override
	public TeamVO findTeamInfo(int teamId) {
		TeamVO vo = new TeamVO();
		vo.teamName = "Hawks";
		vo.league = 'E';
		vo.photo = "ATL";
		vo.location = "Atlanta";
		return vo;
	}
	

	@Override
	public ArrayList<TeamVO> findTeams(String msg) {
		ArrayList<TeamVO>  result = new ArrayList<TeamVO>();
		TeamVO vo = new TeamVO();
		vo.teamName = "Hawks";
		vo.location = "Atlanta";
		vo.photo = "ATL";
		for(int i = 0;i < 10;i++){
			result.add(vo);
		}
		return result;
	}



	@Override
	public ArrayList<TeamVO> findTeamNormal() {
		ArrayList<TeamVO> vol = new ArrayList<TeamVO>();
		TeamVO vo = new TeamVO();
		vo.photo = "ATL";
		vo.location = "***";
		vo.teamName = "***";
		vol.add(vo);
		return vol;
	}

	@Override
	public ArrayList<TeamVO> findTeamNormalAvg() {
		ArrayList<TeamVO> vol = new ArrayList<TeamVO>();
		TeamVO vo = new TeamVO();
		vo.photo = "ATL";
		vo.location = "***";
		vo.teamName = "***";
		vol.add(vo);
		return vol;
	}

	@Override
	public ArrayList<TeamVO> findTeamBasic() {
		ArrayList<TeamVO> vol = new ArrayList<TeamVO>();
		TeamVO vo = new TeamVO();
		vo.photo = "ATL";
		vo.location = "***";
		vo.teamName = "***";
		vol.add(vo);
		return vol;
	}

	@Override
	public ArrayList<TeamVO> findTeamHigh() {
		ArrayList<TeamVO> vol = new ArrayList<TeamVO>();
		TeamVO vo = new TeamVO();
		vo.photo = "ATL";
		vo.location = "***";
		vo.teamName = "***";
		vol.add(vo);
		return vol;
	}

	@Override
	public ArrayList<TeamVO> sortTeamNormal(int num, String sortBy, boolean desc) {
		ArrayList<TeamVO> vol = new ArrayList<TeamVO>();
		TeamVO vo = new TeamVO();
		vo.photo = "BKN";
		vo.location = "***";
		vo.teamName = "***";
		vol.add(vo);
		return vol;
	}

	@Override
	public ArrayList<TeamVO> sortTeamNormalAvg(int num, String sortBy,
			boolean desc) {
		ArrayList<TeamVO> vol = new ArrayList<TeamVO>();
		TeamVO vo = new TeamVO();
		vo.photo = "BKN";
		vo.location = "***";
		vo.teamName = "***";
		vol.add(vo);
		return vol;
	}

	@Override
	public ArrayList<TeamVO> sortTeamHigh(int num, String sortBy, boolean desc) {
		ArrayList<TeamVO> vol = new ArrayList<TeamVO>();
		TeamVO vo = new TeamVO();
		vo.photo = "BKN";
		vo.location = "***";
		vo.teamName = "***";
		vol.add(vo);
		return vol;
	}

/*	@Override
	public TeamVO avgLeague(ArrayList<String> attributes, char league) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public ArrayList<PlayerVO> teamMemberList(int teamID) {
		ArrayList<PlayerVO> vol = new ArrayList<PlayerVO>();
		PlayerVO vo = new PlayerVO();
		vo.photo = "Aaron Brooks";
		vo.name = "Aaron Brooks";
		vo.teamName = "***";
		vol.add(vo);
		return vol;
	}

	@Override
	public TeamVO findTeamInfo(String teamName) {
		TeamVO vo = new TeamVO();
		vo.teamName = "Hawks";
		vo.league = 'E';
		vo.photo = "ATL";
		vo.location = "Atlanta";
		vo.avgAssist = 4.2;
		vo.avgPoint = 12.3;
		return vo;
	}
}

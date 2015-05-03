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
		vo.league = "E";
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamVO> findTeamNormal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamVO> findTeamNormalAvg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamVO> findTeamBasic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamVO> findTeamHigh() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamVO> sortTeamNormal(int num, String sortBy, boolean desc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamVO> sortTeamNormalAvg(int num, String sortBy,
			boolean desc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamVO> sortTeamHigh(int num, String sortBy, boolean desc) {
		// TODO Auto-generated method stub
		return null;
	}

/*	@Override
	public TeamVO avgLeague(ArrayList<String> attributes, char league) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public ArrayList<PlayerVO> teamMemberList(int teamID) {
		// TODO Auto-generated method stub
		return null;
	}

}

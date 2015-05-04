package data;

import data.saver.PlayerScoreSaver;
import data.saver.TeamSaver;
import vo.playervo.HotPlayersVO;
import vo.teamvo.HotTeamsVO;
import vo.teamvo.TeamVO;

import java.util.ArrayList;

/**
 * Created by chenghao on 15/4/30.
 */
public class TeamDataManager {
    public static final int DEFAULT = 1;
    public static final int L5 = 2;
    public static final int BEFORE = 3;
    private PlayerScoreSaver playerScoreSaver;

    private PlayerScoreSaver.TeamData teamDataDefault;
    private PlayerScoreSaver.TeamData teamDataL5;
    private PlayerScoreSaver.TeamData teamDataBefore;

    public TeamDataManager() {
        update();
    }

    public void update() {
        playerScoreSaver = PlayerScoreSaver.getPlayerScoreSaver();
        teamDataDefault = playerScoreSaver.getTeamDataBefore();
        teamDataL5 = playerScoreSaver.getTeamDataL5();
        teamDataBefore = playerScoreSaver.getTeamDataBefore();
    }

    public TeamVO getTeamVO(ArrayList<String> arrayList, int type, int tid) {
        PlayerScoreSaver.TeamData teamData = getTeamData(type);
        TeamVO teamVO = new TeamVO();
        teamVO.id = tid;
        setTeamVO(arrayList, teamVO, teamData);
        return teamVO;
    }

    public ArrayList<TeamVO> getTeamVOs(ArrayList<String> arrayList, int type) {
        PlayerScoreSaver.TeamData teamData = getTeamData(type);
        int size = teamData.getNum();
        ArrayList<TeamVO> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TeamVO teamVO = new TeamVO();
            teamVO.id = i + 1;
            setTeamVO(arrayList, teamVO, teamData);
            res.add(teamVO);
        }
        return res;
    }

    private PlayerScoreSaver.TeamData getTeamData(int type) {
        PlayerScoreSaver.TeamData teamData;
        if (type == DEFAULT) {
            teamData = teamDataDefault;
        } else if (type == L5) {
            teamData = teamDataL5;
        } else {
            teamData = teamDataBefore;
        }
        return teamData;
    }

    private void setTeamVO(ArrayList<String> arrayList, TeamVO teamVO, PlayerScoreSaver.TeamData teamData) {
        for (String s : arrayList) {
            setAttribute(s, teamVO, teamData);
        }
    }

    public void setTeamVO(ArrayList<String> arrayList, TeamVO teamVO, int type) {
        PlayerScoreSaver.TeamData teamData = getTeamData(type);
        for (String s : arrayList) {
            setAttribute(s, teamVO, teamData);
        }
    }

    public void setAttribute(String s, TeamVO teamVO, PlayerScoreSaver.TeamData teamData) {
        switch (s) {
            case "photo":
                teamVO.photo = teamData.getPhoto()[teamVO.id - 1];
                return;
            case "teamName":
                teamVO.teamName = teamData.getTeamName()[teamVO.id - 1];
                return;
            case "abridge":
                teamVO.abridge = teamData.getAbridge()[teamVO.id - 1];
                return;
            case "location":
                teamVO.location = teamData.getLocation()[teamVO.id - 1];
                return;
            case "league":
                teamVO.league = teamData.getLeague()[teamVO.id - 1];
                return;
            case "division":
                teamVO.division = teamData.getDivision()[teamVO.id - 1];
                return;
            case "homeCourt":
                teamVO.homeCourt = teamData.getHomeCourt()[teamVO.id - 1];
                return;
            case "foundTime":
                teamVO.foundTime = teamData.getFoundTime()[teamVO.id - 1];
                return;
            case "assist":
                teamVO.assist = teamData.getAssist()[teamVO.id - 1];
                return;
            case "blockShot":
                teamVO.blockShot = teamData.getBlockShot()[teamVO.id - 1];
                return;
            case "defendRebound":
                teamVO.defendRebound = teamData.getDefendRebound()[teamVO.id - 1];
                return;
            case "fault":
                teamVO.fault = teamData.getFault()[teamVO.id - 1];
                return;
            case "numOfGame":
                teamVO.numOfGame = teamData.getNumOfGame()[teamVO.id - 1];
                return;
            case "offendRebound":
                teamVO.offendRebound = teamData.getOffendRebound()[teamVO.id - 1];
                return;
            case "penalty":
                teamVO.penalty = teamData.getPenalty()[teamVO.id - 1];
                return;
            case "point":
                teamVO.point = teamData.getPoint()[teamVO.id - 1];
                return;
            case "rebound":
                teamVO.rebound = teamData.getRebound()[teamVO.id - 1];
                return;
            case "shot":
                teamVO.shot = teamData.getShot()[teamVO.id - 1];
                return;
            case "steal":
                teamVO.steal = teamData.getSteal()[teamVO.id - 1];
                return;
            case "three":
                teamVO.three = teamData.getThree()[teamVO.id - 1];
                return;

            case "avgAssist":
                teamVO.avgAssist = teamData.getAvgAssist()[teamVO.id - 1];
                return;
            case "avgBlockShot":
                teamVO.avgBlockShot = teamData.getAvgBlockShot()[teamVO.id - 1];
                return;
            case "avgDefendRebound":
                teamVO.avgDefendRebound = teamData.getAvgDefendRebound()[teamVO.id - 1];
                return;
            case "avgFault":
                teamVO.avgFault = teamData.getAvgFault()[teamVO.id - 1];
                return;
            case "avgFoul":
                teamVO.avgFoul = teamData.getAvgFoul()[teamVO.id - 1];
                return;
            case "avgOffendRebound":
                teamVO.avgOffendRebound = teamData.getAvgOffendRebound()[teamVO.id - 1];
                return;
            case "avgPoint":
                teamVO.avgPoint = teamData.getAvgPoint()[teamVO.id - 1];
                return;
            case "avgRebound":
                teamVO.avgRebound = teamData.getAvgRebound()[teamVO.id - 1];
                return;
            case "avgSteal":
                teamVO.avgSteal = teamData.getAvgSteal()[teamVO.id - 1];
                return;

            case "assistEfficient":
                teamVO.assistEfficient = teamData.getAssistEfficient()[teamVO.id - 1];
                return;
            case "defendEfficient":
                teamVO.defendEfficient = teamData.getDefendEfficient()[teamVO.id - 1];
                return;
            case "defendReboundEfficient":
                teamVO.defendReboundEfficient = teamData.getDefendReboundEfficient()[teamVO.id - 1];
                return;
            case "offendEfficient":
                teamVO.offendEfficient = teamData.getOffendEfficient()[teamVO.id - 1];
                return;
            case "offendReboundEfficient":
                teamVO.offendReboundEfficient = teamData.getOffendReboundEfficient()[teamVO.id - 1];
                return;
            case "offendRound":
                teamVO.offendRound = teamData.getOffendRound()[teamVO.id - 1];
                return;
            case "stealEfficient":
                teamVO.stealEfficient = teamData.getStealEfficient()[teamVO.id - 1];
                return;
            case "winRate":
                teamVO.stealEfficient = teamData.getWinRate()[teamVO.id - 1];
                return;
        }
    }

    private void setAttribute(String s, TeamVO teamVO, int values) {
        switch (s) {
            case "assist":
                teamVO.assist = values;
                return;
            case "blockShot":
                teamVO.blockShot = values;
                return;
            case "defendRebound":
                teamVO.defendRebound = values;
                return;
            case "fault":
                teamVO.fault = values;
                return;
            case "numOfGame":
                teamVO.numOfGame = values;
                return;
            case "offendRebound":
                teamVO.offendRebound = values;
                return;
            case "point":
                teamVO.point = values;
                return;
            case "rebound":
                teamVO.rebound = values;
                return;
            case "shot":
                teamVO.shot = values;//
                return;
            case "steal":
                teamVO.steal = values;
                return;
        }
    }

    private void setAttribute(String s, TeamVO teamVO, double values) {
        switch (s) {
            case "penalty":
                teamVO.penalty = values;
                return;
            case "shot":
                teamVO.shot = values;
                return;
            case "three":
                teamVO.three = values;
                return;

            case "avgAssist":
                teamVO.avgAssist = values;
                return;
            case "avgBlockShot":
                teamVO.avgBlockShot = values;
                return;
            case "avgDefendRebound":
                teamVO.avgDefendRebound = values;
                return;
            case "avgFault":
                teamVO.avgFault = values;
                return;
            case "avgFoul":
                teamVO.avgFoul = values;
                return;
            case "avgOffendRebound":
                teamVO.avgOffendRebound = values;
                return;
            case "avgPoint":
                teamVO.avgPoint = values;
                return;
            case "avgRebound":
                teamVO.avgRebound = values;
                return;
            case "avgSteal":
                teamVO.avgSteal = values;
                return;

            case "assistEfficient":
                teamVO.assistEfficient = values;
                return;
            case "defendEfficient":
                teamVO.defendEfficient = values;
                return;
            case "defendReboundEfficient":
                teamVO.defendReboundEfficient = values;
                return;
            case "offendEfficient":
                teamVO.offendEfficient = values;
                return;
            case "offendReboundEfficient":
                teamVO.offendReboundEfficient = values;
                return;
            case "offendRound":
                teamVO.offendRound = values;
                return;
            case "stealEfficient":
                teamVO.stealEfficient = values;
                return;
            case "winRate":
                teamVO.stealEfficient = values;
                return;
        }
    }

    public void setAttribute(String s, TeamVO teamVO, Object values) {
        if (values instanceof Integer) {
            setAttribute(s, teamVO, (Integer) values);
        }
        if (values instanceof Double) {
            setAttribute(s, teamVO, (Double) values);
        }
    }

    public void setAttribute(String s, TeamVO teamVO1, TeamVO teamVO2) {
        switch (s) {
            case "assist":
                teamVO1.assist += teamVO2.assist;
                return;
            case "blockShot":
                teamVO1.blockShot += teamVO2.blockShot;
                return;
            case "defendRebound":
                teamVO1.defendRebound += teamVO2.defendRebound;
                return;
            case "fault":
                teamVO1.fault += teamVO2.fault;
                return;
            case "numOfGame":
                teamVO1.numOfGame += teamVO2.numOfGame;
                return;
            case "offendRebound":
                teamVO1.offendRebound += teamVO2.offendRebound;
                return;
            case "penalty":
                teamVO1.penalty += teamVO2.penalty;
                return;
            case "point":
                teamVO1.point += teamVO2.point;
                return;
            case "rebound":
                teamVO1.rebound += teamVO2.rebound;
                return;
            case "shot":
                teamVO1.shot += teamVO2.shot;
                return;
            case "steal":
                teamVO1.steal += teamVO2.steal;
                return;
            case "three":
                teamVO1.three += teamVO2.three;
                return;
            case "avgAssist":
                teamVO1.avgAssist += teamVO2.avgAssist;
                return;
            case "avgBlockShot":
                teamVO1.avgBlockShot += teamVO2.avgBlockShot;
                return;
            case "avgDefendRebound":
                teamVO1.avgDefendRebound += teamVO2.avgDefendRebound;
                return;
            case "avgFault":
                teamVO1.avgFault += teamVO2.avgFault;
                return;
            case "avgFoul":
                teamVO1.avgFoul += teamVO2.avgFoul;
                return;
            case "avgOffendRebound":
                teamVO1.avgOffendRebound += teamVO2.avgOffendRebound;
                return;
            case "avgPoint":
                teamVO1.avgPoint += teamVO2.avgPoint;
                return;
            case "avgRebound":
                teamVO1.avgRebound += teamVO2.avgRebound;
                return;
            case "avgSteal":
                teamVO1.avgSteal += teamVO2.avgSteal;
                return;
            case "assistEfficient":
                teamVO1.assistEfficient += teamVO2.assistEfficient;
                return;
            case "defendEfficient":
                teamVO1.defendEfficient += teamVO2.defendEfficient;
                return;
            case "defendReboundEfficient":
                teamVO1.defendReboundEfficient += teamVO2.defendReboundEfficient;
                return;
            case "offendEfficient":
                teamVO1.offendEfficient += teamVO2.offendEfficient;
                return;
            case "offendReboundEfficient":
                teamVO1.offendReboundEfficient += teamVO2.offendReboundEfficient;
                return;
            case "offendRound":
                teamVO1.offendRound += teamVO2.offendRound;
                return;
            case "stealEfficient":
                teamVO1.stealEfficient += teamVO2.stealEfficient;
                return;
            case "winRate":
                teamVO1.winRate += teamVO2.winRate;
                return;
        }
    }

    public int getNum() {
        return TeamSaver.getTeamSaver().getNum();
    }

    public HotTeamsVO getInfo(int tid) {
        HotTeamsVO hotTeamsVO = new HotTeamsVO();
        hotTeamsVO.name = teamDataDefault.getTeamName()[tid - 1];
        hotTeamsVO.id = tid;
        hotTeamsVO.league = teamDataDefault.getLeague()[tid - 1];
        hotTeamsVO.location = teamDataDefault.getLocation()[tid - 1];
        hotTeamsVO.photo = teamDataDefault.getPhoto()[tid - 1];
        return hotTeamsVO;
    }

    public int getTeamId(String teamName) {
        return teamDataDefault.getTeamId(teamName);
    }
}

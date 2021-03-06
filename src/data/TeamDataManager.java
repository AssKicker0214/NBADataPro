package data;

import data.saver.PlayerScoreSaver;
import data.saver.TeamSaver;
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
        teamDataDefault = playerScoreSaver.getTeamDataDefault();
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
            case "foul":
                teamVO.foul = teamData.getFoul()[teamVO.id - 1];
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
                teamVO.penalty = Tools.change(teamData.getPenalty()[teamVO.id - 1]);
                return;
            case "point":
                teamVO.point = teamData.getPoint()[teamVO.id - 1];
                return;
            case "rebound":
                teamVO.rebound = teamData.getRebound()[teamVO.id - 1];
                return;
            case "shot":
                teamVO.shot = Tools.change(teamData.getShot()[teamVO.id - 1]);
                return;
            case "steal":
                teamVO.steal = teamData.getSteal()[teamVO.id - 1];
                return;
            case "three":
                teamVO.three = Tools.change(teamData.getThree()[teamVO.id - 1]);
                return;

            case "avgAssist":
                teamVO.avgAssist = Tools.change(teamData.getAvgAssist()[teamVO.id - 1]);
                return;
            case "avgBlockShot":
                teamVO.avgBlockShot = Tools.change(teamData.getAvgBlockShot()[teamVO.id - 1]);
                return;
            case "avgDefendRebound":
                teamVO.avgDefendRebound = Tools.change(teamData.getAvgDefendRebound()[teamVO.id - 1]);
                return;
            case "avgFault":
                teamVO.avgFault = Tools.change(teamData.getAvgFault()[teamVO.id - 1]);
                return;
            case "avgFoul":
                teamVO.avgFoul = Tools.change(teamData.getAvgFoul()[teamVO.id - 1]);
                return;
            case "avgOffendRebound":
                teamVO.avgOffendRebound = Tools.change(teamData.getAvgOffendRebound()[teamVO.id - 1]);
                return;
            case "avgPoint":
                teamVO.avgPoint = Tools.change(teamData.getAvgPoint()[teamVO.id - 1]);
                return;
            case "avgRebound":
                teamVO.avgRebound = Tools.change(teamData.getAvgRebound()[teamVO.id - 1]);
                return;
            case "avgSteal":
                teamVO.avgSteal = Tools.change(teamData.getAvgSteal()[teamVO.id - 1]);
                return;

            case "assistEfficient":
                teamVO.assistEfficient = Tools.change(teamData.getAssistEfficient()[teamVO.id - 1]);
                return;
            case "defendEfficient":
                teamVO.defendEfficient = Tools.change(teamData.getDefendEfficient()[teamVO.id - 1]);
                return;
            case "defendReboundEfficient":
                teamVO.defendReboundEfficient = Tools.change(teamData.getDefendReboundEfficient()[teamVO.id - 1]);
                return;
            case "offendEfficient":
                teamVO.offendEfficient = Tools.change(teamData.getOffendEfficient()[teamVO.id - 1]);
                return;
            case "offendReboundEfficient":
                teamVO.offendReboundEfficient = Tools.change(teamData.getOffendReboundEfficient()[teamVO.id - 1]);
                return;
            case "offendRound":
                teamVO.offendRound = Tools.change(teamData.getOffendRound()[teamVO.id - 1]);
                return;
            case "stealEfficient":
                teamVO.stealEfficient = Tools.change(teamData.getStealEfficient()[teamVO.id - 1]);
                return;
            case "winRate":
                teamVO.winRate = Tools.change(teamData.getWinRate()[teamVO.id - 1]);
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

    public ArrayList<HotTeamsVO> getHotTeams(String sortBy) {
        ArrayList<HotTeamsVO> arrayList = new ArrayList<>();
        for (int i = 0; i < getNum(); i++) {
            arrayList.add(getHotTeamVO(sortBy, i + 1));
        }
        return arrayList;
    }

    private HotTeamsVO getHotTeamVO(String sortBy, int tid) {
        HotTeamsVO hotTeamsVO = new HotTeamsVO();
        hotTeamsVO.id = tid;
        hotTeamsVO.name = teamDataDefault.getTeamName()[tid - 1];
        hotTeamsVO.photo = teamDataDefault.getPhoto()[tid - 1];
        hotTeamsVO.location = teamDataDefault.getLocation()[tid - 1];
        setAttribute(sortBy, hotTeamsVO, getTeamData(DEFAULT));
        return hotTeamsVO;
    }

    private void setAttribute(String sortBy, HotTeamsVO hotTeamsVO, PlayerScoreSaver.TeamData teamData) {
        switch (sortBy) {
            case "assist":
                hotTeamsVO.value = teamData.getAssist()[hotTeamsVO.id - 1];
                return;
            case "blockShot":
                hotTeamsVO.value = teamData.getBlockShot()[hotTeamsVO.id - 1];
                return;
            case "defendRebound":
                hotTeamsVO.value = teamData.getDefendRebound()[hotTeamsVO.id - 1];
                return;
            case "foul":
                hotTeamsVO.value = teamData.getFoul()[hotTeamsVO.id - 1];
                return;
            case "fault":
                hotTeamsVO.value = teamData.getFault()[hotTeamsVO.id - 1];
                return;
            case "numOfGame":
                hotTeamsVO.value = teamData.getNumOfGame()[hotTeamsVO.id - 1];
                return;
            case "offendRebound":
                hotTeamsVO.value = teamData.getOffendRebound()[hotTeamsVO.id - 1];
                return;
            case "penalty":
                hotTeamsVO.value = Tools.change(teamData.getPenalty()[hotTeamsVO.id - 1]);
                return;
            case "point":
                hotTeamsVO.value = teamData.getPoint()[hotTeamsVO.id - 1];
                return;
            case "rebound":
                hotTeamsVO.value = teamData.getRebound()[hotTeamsVO.id - 1];
                return;
            case "shot":
                hotTeamsVO.value = Tools.change(teamData.getShot()[hotTeamsVO.id - 1]);
                return;
            case "steal":
                hotTeamsVO.value = teamData.getSteal()[hotTeamsVO.id - 1];
                return;
            case "three":
                hotTeamsVO.value = Tools.change(teamData.getThree()[hotTeamsVO.id - 1]);
                return;

            case "avgAssist":
                hotTeamsVO.value = Tools.change(teamData.getAvgAssist()[hotTeamsVO.id - 1]);
                return;
            case "avgBlockShot":
                hotTeamsVO.value = Tools.change(teamData.getAvgBlockShot()[hotTeamsVO.id - 1]);
                return;
            case "avgDefendRebound":
                hotTeamsVO.value = Tools.change(teamData.getAvgDefendRebound()[hotTeamsVO.id - 1]);
                return;
            case "avgFault":
                hotTeamsVO.value = Tools.change(teamData.getAvgFault()[hotTeamsVO.id - 1]);
                return;
            case "avgFoul":
                hotTeamsVO.value = Tools.change(teamData.getAvgFoul()[hotTeamsVO.id - 1]);
                return;
            case "avgOffendRebound":
                hotTeamsVO.value = Tools.change(teamData.getAvgOffendRebound()[hotTeamsVO.id - 1]);
                return;
            case "avgPoint":
                hotTeamsVO.value = Tools.change(teamData.getAvgPoint()[hotTeamsVO.id - 1]);
                return;
            case "avgRebound":
                hotTeamsVO.value = Tools.change(teamData.getAvgRebound()[hotTeamsVO.id - 1]);
                return;
            case "avgSteal":
                hotTeamsVO.value = Tools.change(teamData.getAvgSteal()[hotTeamsVO.id - 1]);
                return;

            case "assistEfficient":
                hotTeamsVO.value = Tools.change(teamData.getAssistEfficient()[hotTeamsVO.id - 1]);
                return;
            case "defendEfficient":
                hotTeamsVO.value = Tools.change(teamData.getDefendEfficient()[hotTeamsVO.id - 1]);
                return;
            case "defendReboundEfficient":
                hotTeamsVO.value = Tools.change(teamData.getDefendReboundEfficient()[hotTeamsVO.id - 1]);
                return;
            case "offendEfficient":
                hotTeamsVO.value = Tools.change(teamData.getOffendEfficient()[hotTeamsVO.id - 1]);
                return;
            case "offendReboundEfficient":
                hotTeamsVO.value = Tools.change(teamData.getOffendReboundEfficient()[hotTeamsVO.id - 1]);
                return;
            case "offendRound":
                hotTeamsVO.value = Tools.change(teamData.getOffendRound()[hotTeamsVO.id - 1]);
                return;
            case "stealEfficient":
                hotTeamsVO.value = Tools.change(teamData.getStealEfficient()[hotTeamsVO.id - 1]);
                return;
            case "winRate":
                hotTeamsVO.value = Tools.change(teamData.getWinRate()[hotTeamsVO.id - 1]);
                return;
        }
    }
}

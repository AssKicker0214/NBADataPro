package dataservice.team;

import data.input.Team;
import data.saver.PlayerScoreSaver;
import sun.security.util.Length;
import vo.playervo.PlayerVO;
import vo.teamvo.HotTeamsVO;
import vo.teamvo.TeamVO;

import java.util.ArrayList;

/**
 * Created by cho on 2015/4/30.
 */
public class TeamDataHandel implements TeamDataService {

    private PlayerScoreSaver playerScoreSaver;
    //    private PlayerScoreSaver.PlayerData playerDataDefault;
//    private PlayerScoreSaver.PlayerData playerDataL5;
//    private PlayerScoreSaver.PlayerData playerDataBefore;
    private PlayerScoreSaver.TeamData teamDataDefault;
    private PlayerScoreSaver.TeamData teamDataL5;
    private PlayerScoreSaver.TeamData teamDataBefore;

    public TeamDataHandel(PlayerScoreSaver playerScoreSaver) {
        this.playerScoreSaver = playerScoreSaver;
        update();
    }

    @Override
    public ArrayList<HotTeamsVO> hotTeams(int num, String sortBy) {
        return null;
    }

    @Override
    public TeamVO findTeamInfo(int teamId, boolean isAvg) {
        TeamVO teamVO = new TeamVO();
        if (isAvg) {
            teamVO.avgAssist = teamDataDefault.getAvgAssist()[teamId];            //助攻数
            teamVO.avgBlockShot = teamDataDefault.getAvgBlockShot()[teamId];        //盖帽数
            teamVO.avgDefendRebound = teamDataDefault.getAvgDefendRebound()[teamId];    //防守篮板数
            teamVO.avgFault = teamDataDefault.getAvgFault()[teamId];            //失误数
            teamVO.avgFoul = teamDataDefault.getAvgFoul()[teamId];            //犯规数
            teamVO.avgOffendRebound = teamDataDefault.getAvgOffendRebound()[teamId];    //进攻篮板数
            teamVO.avgPoint = teamDataDefault.getAvgPoint()[teamId];            //得分
            teamVO.avgRebound = teamDataDefault.getAvgRebound()[teamId];            //篮板数
            teamVO.avgSteal = teamDataDefault.getAvgSteal()[teamId];            //抢断数

        } else {
            teamVO.assist = teamDataDefault.getAssist()[teamId];
            teamVO.blockShot = teamDataDefault.getBlockShot()[teamId];
            teamVO.defendRebound = teamDataBefore.getDefendRebound()[teamId];
            teamVO.fault = teamDataDefault.getFault()[teamId];
            teamVO.foul = teamDataDefault.getFoul()[teamId];
            teamVO.numOfGame = teamDataDefault.getNumOfGame()[teamId];
            teamVO.offendRebound = teamDataDefault.getOffendRebound()[teamId];
            teamVO.penalty = teamDataDefault.getPenalty()[teamId];
            teamVO.point = teamDataDefault.getPoint()[teamId];
            teamVO.rebound = teamDataDefault.getRebound()[teamId];
            teamVO.shot = teamDataDefault.getShot()[teamId];
            teamVO.steal = teamDataDefault.getSteal()[teamId];
            teamVO.three = teamDataDefault.getThree()[teamId];
        }
        return teamVO;
    }

    @Override
    public ArrayList<TeamVO> findTeamNormal(boolean isAvg) {
        ArrayList<TeamVO> arrayList = new ArrayList<>();
        if (isAvg) {
            double[] avgAssist = teamDataDefault.getAvgAssist();            //助攻数
            double[] avgBlockShot = teamDataDefault.getAvgBlockShot();        //盖帽数
            double[] avgDefendRebound = teamDataDefault.getAvgDefendRebound();    //防守篮板数
            double[] avgFault = teamDataDefault.getAvgFault();            //失误数
            double[] avgFoul = teamDataDefault.getAvgFoul();            //犯规数
            double[] avgOffendRebound = teamDataDefault.getAvgOffendRebound();    //进攻篮板数
            double[] avgPoint = teamDataDefault.getAvgPoint();            //得分
            double[] avgRebound = teamDataDefault.getAvgRebound();            //篮板数
            double[] avgSteal = teamDataDefault.getAvgSteal();            //抢断数

            for (int i = 0; i < avgAssist.length; i++) {
                TeamVO teamVO = new TeamVO();
                teamVO.avgAssist = avgAssist[i];
                teamVO.avgBlockShot = avgBlockShot[i];
                teamVO.avgDefendRebound = avgDefendRebound[i];
                teamVO.avgFault = avgFault[i];
                teamVO.avgFoul = avgFoul[i];
                teamVO.avgOffendRebound = avgOffendRebound[i];
                teamVO.avgPoint = avgPoint[i];
                teamVO.avgRebound = avgRebound[i];
                teamVO.avgSteal = avgSteal[i];
                arrayList.add(teamVO);
            }
            return arrayList;
        } else {
            int[] assist = teamDataDefault.getAssist();
            int[] blockShot = teamDataDefault.getBlockShot();
            int[] defendRebound = teamDataBefore.getDefendRebound();
            int[] fault = teamDataDefault.getFault();
            int[] foul = teamDataDefault.getFoul();
            int[] numOfGame = teamDataDefault.getNumOfGame();
            int[] offendRebound = teamDataDefault.getOffendRebound();
            double[] penalty = teamDataDefault.getPenalty();
            int[] point = teamDataDefault.getPoint();
            int[] rebound = teamDataDefault.getRebound();
            double[] shot = teamDataDefault.getShot();
            int[] steal = teamDataDefault.getSteal();
            double[] three = teamDataDefault.getThree();

            for (int i = 0; i < assist.length; i++) {
                TeamVO teamVO = new TeamVO();

                teamVO.assist = assist[i];
                teamVO.blockShot = blockShot[i];
                teamVO.defendRebound = defendRebound[i];
                teamVO.fault = fault[i];
                teamVO.foul = foul[i];
                teamVO.numOfGame = numOfGame[i];
                teamVO.offendRebound = offendRebound[i];
                teamVO.penalty = penalty[i];
                teamVO.point = point[i];
                teamVO.rebound = rebound[i];
                teamVO.shot = shot[i];
                teamVO.steal = steal[i];
                teamVO.three = three[i];
            }
        }
        return null;
    }

    @Override
    public ArrayList<TeamVO> findTeamHigh() {
        double[] assistEfficient = teamDataDefault.getAssistEfficient();
        double[] defendEfficient = teamDataDefault.getDefendEfficient();
        double[] defendReboundEfficient = teamDataDefault.getDefendReboundEfficient();
        double[] offendEfficient = teamDataDefault.getOffendEfficient();
        double[] offendReboundEfficient = teamDataDefault.getOffendReboundEfficient();
        double[] offendRound = teamDataDefault.getOffendRound();
        double[] stealEfficient = teamDataDefault.getStealEfficient();
        double[] winRate = teamDataDefault.getWinRate();
        ArrayList<TeamVO> arrayList = new ArrayList<>();
        for (int i = 0; i < assistEfficient.length; i++) {
            TeamVO teamVO = new TeamVO();
            teamVO.assistEfficient = assistEfficient[i];
            teamVO.defendEfficient = defendEfficient[i];
            teamVO.defendReboundEfficient = defendReboundEfficient[i];
            teamVO.offendEfficient = offendEfficient[i];
            teamVO.offendReboundEfficient = offendReboundEfficient[i];
            teamVO.offendRound = offendRound[i];
            teamVO.stealEfficient = stealEfficient[i];
            teamVO.winRate = winRate[i];
            arrayList.add(teamVO);
        }
        return arrayList;
    }

    @Override
    public ArrayList<TeamVO> sortTeamNormal(int num, String sortBy, boolean desc, boolean isAvg) {
        TeamVO[] vos = new TeamVO[num + 1];
        int length = 0;
        ArrayList<TeamVO> arrayList = new ArrayList<>();

        if (isAvg) {
            double[] avgAssist = teamDataDefault.getAvgAssist();            //助攻数
            double[] avgBlockShot = teamDataDefault.getAvgBlockShot();        //盖帽数
            double[] avgDefendRebound = teamDataDefault.getAvgDefendRebound();    //防守篮板数
            double[] avgFault = teamDataDefault.getAvgFault();            //失误数
            double[] avgFoul = teamDataDefault.getAvgFoul();            //犯规数
            double[] avgOffendRebound = teamDataDefault.getAvgOffendRebound();    //进攻篮板数
            double[] avgPoint = teamDataDefault.getAvgPoint();            //得分
            double[] avgRebound = teamDataDefault.getAvgRebound();            //篮板数
            double[] avgSteal = teamDataDefault.getAvgSteal();            //抢断数

            for (int i = 0; i < avgAssist.length; i++) {
                TeamVO teamVO = new TeamVO();
                teamVO.avgAssist = avgAssist[i];
                teamVO.avgBlockShot = avgBlockShot[i];
                teamVO.avgDefendRebound = avgDefendRebound[i];
                teamVO.avgFault = avgFault[i];
                teamVO.avgFoul = avgFoul[i];
                teamVO.avgOffendRebound = avgOffendRebound[i];
                teamVO.avgPoint = avgPoint[i];
                teamVO.avgRebound = avgRebound[i];
                teamVO.avgSteal = avgSteal[i];

                length = serial(vos, length <= num ? length : num, teamVO, sortBy, desc);
            }
        } else {
            int[] assist = teamDataDefault.getAssist();
            int[] blockShot = teamDataDefault.getBlockShot();
            int[] defendRebound = teamDataBefore.getDefendRebound();
            int[] fault = teamDataDefault.getFault();
            int[] foul = teamDataDefault.getFoul();
            int[] numOfGame = teamDataDefault.getNumOfGame();
            int[] offendRebound = teamDataDefault.getOffendRebound();
            double[] penalty = teamDataDefault.getPenalty();
            int[] point = teamDataDefault.getPoint();
            int[] rebound = teamDataDefault.getRebound();
            double[] shot = teamDataDefault.getShot();
            int[] steal = teamDataDefault.getSteal();
            double[] three = teamDataDefault.getThree();

            for (int i = 0; i < assist.length; i++) {
                TeamVO teamVO = new TeamVO();

                teamVO.assist = assist[i];
                teamVO.blockShot = blockShot[i];
                teamVO.defendRebound = defendRebound[i];
                teamVO.fault = fault[i];
                teamVO.foul = foul[i];
                teamVO.numOfGame = numOfGame[i];
                teamVO.offendRebound = offendRebound[i];
                teamVO.penalty = penalty[i];
                teamVO.point = point[i];
                teamVO.rebound = rebound[i];
                teamVO.shot = shot[i];
                teamVO.steal = steal[i];
                teamVO.three = three[i];

                length = serial(vos, length <= num ? length : num, teamVO, sortBy, desc);
            }
        }

        for (int i = 0; i < num; i++) {
            arrayList.add(vos[i]);
        }

        return arrayList;
    }

    private int serial(TeamVO[] vos, int length, TeamVO vo, String sortBy, boolean desc) {
        if (length == 0) {
            vos[0] = vo;
            return length + 1;
        }

        for (int i = length - 1; i >= 0; i--) {
            if ((desc ^ compare(vo, vos[i], sortBy))) {
                vos[i + 1] = vos[i];
            } else {
                vos[i + 1] = vo;
                return length + 1;
            }
        }
        return length + 1;
    }

    private boolean compare(TeamVO vo1, TeamVO vo2, String sortBy) {
        switch (sortBy) {
            case "assist":
                return vo1.assist > vo2.assist;
            case "blockShot":
                return vo1.blockShot > vo2.blockShot;
            case "defendRebound":
                return vo1.defendRebound > vo2.defendRebound;
            case "fault":
                return vo1.fault > vo2.fault;
            case "foul":
                return vo1.foul > vo2.foul;
            case "numOfGame":
                return vo1.numOfGame > vo2.numOfGame;
            case "offendRebound":
                return vo1.offendRebound > vo2.offendRebound;
            case "penalty":
                return vo1.penalty > vo2.penalty;
            case "point":
                return vo1.point > vo2.point;
            case "rebound":
                return vo1.rebound > vo2.rebound;
            case "shot":
                return vo1.shot > vo2.shot;
            case "steal":
                return vo1.steal > vo2.steal;
            case "three":
                return vo1.three > vo2.three;
            case "avgAssist":
                return vo1.avgAssist > vo2.avgAssist;
            case "avgBlockShot":
                return vo1.avgBlockShot > vo2.avgBlockShot;
            case "avgDefendRebound":
                return vo1.avgDefendRebound > vo2.avgDefendRebound;
            case "avgFault":
                return vo1.avgFault > vo2.avgFault;
            case "avgFoul":
                return vo1.avgFoul > vo2.avgFoul;
            case "avgOffendRebound":
                return vo1.avgOffendRebound > vo2.avgOffendRebound;
            case "avgPoint":
                return vo1.avgPoint > vo2.avgPoint;
            case "avgRebound":
                return vo1.avgRebound > vo2.avgRebound;
            case "avgSteal":
                return vo1.avgSteal > vo2.avgSteal;
            case "assistEfficient":
                return vo1.assistEfficient > vo2.assistEfficient;
            case "defendEfficient":
                return vo1.defendEfficient > vo2.defendEfficient;
            case "defendReboundEfficient":
                return vo1.defendReboundEfficient > vo2.defendReboundEfficient;
            case "offendEfficient":
                return vo1.offendEfficient > vo2.offendEfficient;
            case "offendReboundEfficient":
                return vo1.offendReboundEfficient > vo2.offendReboundEfficient;
            case "offendRound":
                return vo1.offendRound > vo2.offendRound;
            case "stealEfficient":
                return vo1.stealEfficient > vo2.stealEfficient;
            case "winRate":
                return vo1.winRate > vo2.winRate;
        }
        return false;
    }

    @Override
    public ArrayList<TeamVO> sortTeamHigh(int num, String sortBy, boolean desc) {
        TeamVO[] vos = new TeamVO[num + 1];
        int length = 0;
        ArrayList<TeamVO> arrayList = new ArrayList<>();
        double[] assistEfficient = teamDataDefault.getAssistEfficient();
        double[] defendEfficient = teamDataDefault.getDefendEfficient();
        double[] defendReboundEfficient = teamDataDefault.getDefendReboundEfficient();
        double[] offendEfficient = teamDataDefault.getOffendEfficient();
        double[] offendReboundEfficient = teamDataDefault.getOffendReboundEfficient();
        double[] offendRound = teamDataDefault.getOffendRound();
        double[] stealEfficient = teamDataDefault.getStealEfficient();
        double[] winRate = teamDataDefault.getWinRate();
        for (int i = 0; i < assistEfficient.length; i++) {
            TeamVO teamVO = new TeamVO();
            teamVO.assistEfficient = assistEfficient[i];
            teamVO.defendEfficient = defendEfficient[i];
            teamVO.defendReboundEfficient = defendReboundEfficient[i];
            teamVO.offendEfficient = offendEfficient[i];
            teamVO.offendReboundEfficient = offendReboundEfficient[i];
            teamVO.offendRound = offendRound[i];
            teamVO.stealEfficient = stealEfficient[i];
            teamVO.winRate = winRate[i];
            length = serial(vos, length <= num ? length : num, teamVO, sortBy, desc);
        }
        for (int i = 0; i < num; i++) {
            arrayList.add(vos[i]);
        }
        return arrayList;
    }

    @Override
    public TeamVO avgLeague(ArrayList<String> attributes) {
        return null;
    }

    @Override
    public ArrayList<PlayerVO> teamMemberList(int teamID) {
        return null;
    }

    public void update() {
//        playerData = playerScoreSaver.get
        teamDataDefault = playerScoreSaver.getTeamDataBefore();
        teamDataL5 = playerScoreSaver.getTeamDataL5();
        teamDataBefore = playerScoreSaver.getTeamDataBefore();
    }
}

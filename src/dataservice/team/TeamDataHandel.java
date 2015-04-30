package dataservice.team;

import data.TeamDataManager;
import data.saver.PlayerScoreSaver;
import vo.playervo.PlayerVO;
import vo.teamvo.HotTeamsVO;
import vo.teamvo.TeamVO;

import java.util.ArrayList;

/**
 * Created by cho on 2015/4/30.
 */
public class TeamDataHandel implements TeamDataService {



    @Override
    public ArrayList<HotTeamsVO> hotTeams(int num, String sortBy) {
        return null;
    }

    @Override
    public TeamVO findTeamInfo(int teamId) {
        TeamVO teamVO = new TeamDataManager().getTeamVO(getAllInformation(), TeamDataManager.DEFAULT, teamId);
        return teamVO;
    }

    @Override
    public ArrayList<TeamVO> findTeamNormal() {
        ArrayList<TeamVO> teamVOs = new TeamDataManager().getTeamVOs(getNormalInfo(), TeamDataManager.DEFAULT);
        return teamVOs;
    }

    @Override
    public ArrayList<TeamVO> findTeamNormalAvg() {
        ArrayList<TeamVO> teamVOs = new TeamDataManager().getTeamVOs(getAvgNormalInfo(), TeamDataManager.DEFAULT);
        return teamVOs;
    }

    @Override
    public ArrayList<TeamVO> findTeamBasic() {
        ArrayList<TeamVO> teamVOs = new TeamDataManager().getTeamVOs(getInformation(), TeamDataManager.DEFAULT);
        return teamVOs;
    }

    public TeamVO findTeamInfo(int teamId, boolean isAvg) {
        TeamVO teamVO = new TeamVO();
        teamVO.id = teamId;
        if (isAvg) {
            setTeamVO(getAvgNormalInfo(),teamVO,teamDataDefault);
        } else {
            setTeamVO(getNormalInfo(),teamVO,teamDataDefault);
        }
        return teamVO;
    }

    public ArrayList<TeamVO> findTeamNormal(boolean isAvg) {
        ArrayList<TeamVO> arrayList = new ArrayList<>();
        if (isAvg) {
            for (int i = 0; i < teamDataDefault.getNum(); i++) {
                TeamVO teamVO = new TeamVO();
                teamVO.id = i + 1;
                setTeamVO(getAvgNormalInfo(),teamVO,teamDataDefault);
                arrayList.add(teamVO);
            }
            return arrayList;
        } else {
            for (int i = 0; i < teamDataDefault.getNum(); i++) {
                TeamVO teamVO = new TeamVO();
                teamVO.id = i + 1;
                setTeamVO(getNormalInfo(),teamVO,teamDataDefault);
                arrayList.add(teamVO);
            }
        }
        return arrayList;
    }

    @Override
    public ArrayList<TeamVO> findTeamHigh() {
        ArrayList<TeamVO> teamVOs = new TeamDataManager().getTeamVOs(getHighInfo(), TeamDataManager.DEFAULT);
        return teamVOs;
    }

    @Override
    public ArrayList<TeamVO> sortTeamNormal(int num, String sortBy, boolean desc) {
        return sortTeam(getNormalInfo(),num,sortBy,desc);
    }

    @Override
    public ArrayList<TeamVO> sortTeamNormalAvg(int num, String sortBy, boolean desc) {
        return sortTeam(getAvgNormalInfo(),num,sortBy,desc);
    }

    private ArrayList<TeamVO> sortTeam(ArrayList<String> attributes,int num, String sortBy, boolean desc){
        TeamVO[] vos = new TeamVO[num + 1];
        int length = 0;
        ArrayList<TeamVO> arrayList = new ArrayList<>();
        TeamDataManager teamDataManager  = new TeamDataManager();
        for (int i = 0; i < teamDataManager.getNum(); i++) {
            TeamVO teamVO = new TeamVO();
            teamVO.id = i + 1;
            teamDataManager.setTeamVO(attributes, teamVO, TeamDataManager.DEFAULT);
            length = serial(vos, length <= num ? length : num, teamVO, sortBy, desc);
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
        return sortTeam(getHighInfo(),num,sortBy,desc);
    }

//    @Override
//    public TeamVO avgLeague(ArrayList<String> attributes, char league) {
//        ArrayList<String> temp = (ArrayList<String>) attributes.clone();
//        attributes.add("league");
//        TeamDataManager teamDataManager = new TeamDataManager();
//        ArrayList<TeamVO> arrayList = teamDataManager.getTeamVOs(temp,TeamDataManager.DEFAULT);
//        TeamVO teamVO = new TeamVO();
//        int num = 0 ;
//        for (int i = 0; i < arrayList.size(); i++ ){
//            if (arrayList.get(i).league == league){
////                teamDataManager.se
//                num++;
//                for (int j = 0; j < attributes.size(); j++){
//                    teamDataManager.setAttribute(attributes.get(j),teamVO,arrayList.get(i));
//                }
//            }
//        }
//        return a
//    }

    public TeamVO avgLeague(ArrayList<String> attributes,String league) {
        ArrayList<String> temp = (ArrayList<String>) attributes.clone();
        attributes.add("league");
        ArrayList<TeamVO> arrayList = getDefault(temp);
        TeamVO teamVO = new TeamVO();
        int num = 0 ;
        for (int i = 0; i <  arrayList.size();i++){
            if (arrayList.get(i).league.equals(league)){
                num++;
                for (String s:attributes){
                    switch (s){
                        case "assist":
                            teamVO.assist += arrayList.get(i).assist;
                        case "blockShot":
                            teamVO.blockShot += arrayList.get(i).blockShot;
                        case "defendRebound":
                            teamVO.defendRebound += arrayList.get(i).defendRebound;
                        case "fault":
                            teamVO.fault += arrayList.get(i).fault;
                        case "numOfGame":
                            teamVO.numOfGame += arrayList.get(i).numOfGame;
                        case "offendRebound":
                            teamVO.offendRebound += arrayList.get(i).offendRebound;
                        case "penalty":
                            teamVO.penalty += arrayList.get(i).penalty;
                        case "point":
                            teamVO.point += arrayList.get(i).point;
                        case "rebound":
                            teamVO.rebound += arrayList.get(i).rebound;
                        case "shot":
                            teamVO.shot += arrayList.get(i).shot;
                        case "steal":
                            teamVO.steal += arrayList.get(i).steal;
                        case "three":
                            teamVO.three += arrayList.get(i).three;
                        case "avgAssist":
                            teamVO.avgAssist += arrayList.get(i).avgAssist;
                        case "avgBlockShot":
                            teamVO.avgBlockShot += arrayList.get(i).avgBlockShot;
                        case "avgDefendRebound":
                            teamVO.avgDefendRebound += arrayList.get(i).avgDefendRebound;
                        case "avgFault":
                            teamVO.avgFault += arrayList.get(i).avgFault;
                        case "avgFoul":
                            teamVO.avgFoul += arrayList.get(i).avgFoul;
                        case "avgOffendRebound":
                            teamVO.avgOffendRebound += arrayList.get(i).avgOffendRebound;
                        case "avgPoint":
                            teamVO.avgPoint += arrayList.get(i).avgPoint;
                        case "avgRebound":
                            teamVO.avgRebound += arrayList.get(i).avgRebound;
                        case "avgSteal":
                            teamVO.avgSteal += arrayList.get(i).avgSteal;

                        case "assistEfficient":
                            teamVO.assistEfficient += arrayList.get(i).assistEfficient;
                        case "defendEfficient":
                            teamVO.defendEfficient += arrayList.get(i).defendEfficient;
                        case "defendReboundEfficient":
                            teamVO.defendReboundEfficient += arrayList.get(i).defendReboundEfficient;
                        case "offendEfficient":
                            teamVO.offendEfficient += arrayList.get(i).offendEfficient;
                        case "offendReboundEfficient":
                            teamVO.offendReboundEfficient += arrayList.get(i).offendReboundEfficient;
                        case "offendRound":
                            teamVO.offendRound += arrayList.get(i).offendRound;
                        case "stealEfficient":
                            teamVO.stealEfficient += arrayList.get(i).stealEfficient;
                        case "winRate":
                            teamVO.stealEfficient += arrayList.get(i).stealEfficient;
                    }
                }
            }
        }
        

        return teamVO;
    }

    @Override
    public ArrayList<PlayerVO> teamMemberList(int teamID) {
        return null;
    }

    private ArrayList<TeamVO> getDefault(ArrayList<String> arrayList){
        int size = teamDataDefault.getNum();
        ArrayList<TeamVO> res = new ArrayList<>();
        for (int i = 0; i < size; i++){
            TeamVO teamVO = new TeamVO();
            setTeamVO(arrayList,teamVO,teamDataDefault);
            res.add(teamVO);
        }
        return res;
    }

    private void setTeamVO(ArrayList<String> arrayList,TeamVO teamVO,PlayerScoreSaver.TeamData teamData){
        for (String s : arrayList){
            setAttribute(s,teamVO,teamData);
        }
    }

    private void setAttribute(String s , TeamVO teamVO,PlayerScoreSaver.TeamData teamData){
        switch (s){
            case "assist":
                teamVO.assist = teamData.getAssist()[teamVO.id - 1];return;
            case "blockShot":
                teamVO.blockShot = teamData.getBlockShot()[teamVO.id - 1];return;
            case "defendRebound":
                teamVO.defendRebound = teamData.getDefendRebound()[teamVO.id - 1];return;
            case "fault":
                teamVO.fault = teamData.getFault()[teamVO.id - 1];return;
            case "numOfGame":
                teamVO.numOfGame = teamData.getNumOfGame()[teamVO.id - 1];return;
            case "offendRebound":
                teamVO.offendRebound = teamData.getOffendRebound()[teamVO.id - 1];return;
            case "penalty":
                teamVO.penalty = teamData.getPenalty()[teamVO.id - 1];return;
            case "point":
                teamVO.point = teamData.getPoint()[teamVO.id - 1];return;
            case "rebound":
                teamVO.rebound = teamData.getRebound()[teamVO.id - 1];return;
            case "shot":
                teamVO.shot = teamData.getShot()[teamVO.id - 1];return;
            case "steal":
                teamVO.steal = teamData.getSteal()[teamVO.id - 1];return;
            case "three":
                teamVO.three = teamData.getThree()[teamVO.id - 1];return;

            case "avgAssist":
                teamVO.avgAssist = teamData.getAvgAssist()[teamVO.id - 1];return;
            case "avgBlockShot":
                teamVO.avgBlockShot = teamData.getAvgBlockShot()[teamVO.id - 1];return;
            case "avgDefendRebound":
                teamVO.avgDefendRebound = teamData.getAvgDefendRebound()[teamVO.id - 1];return;
            case "avgFault":
                teamVO.avgFault = teamData.getAvgFault()[teamVO.id - 1];return;
            case "avgFoul":
                teamVO.avgFoul = teamData.getAvgFoul()[teamVO.id - 1];return;
            case "avgOffendRebound":
                teamVO.avgOffendRebound = teamData.getAvgOffendRebound()[teamVO.id - 1];return;
            case "avgPoint":
                teamVO.avgPoint = teamData.getAvgPoint()[teamVO.id - 1];return;
            case "avgRebound":
                teamVO.avgRebound = teamData.getAvgRebound()[teamVO.id - 1];return;
            case "avgSteal":
                teamVO.avgSteal = teamData.getAvgSteal()[teamVO.id - 1];return;

            case "assistEfficient":
                teamVO.assistEfficient = teamData.getAssistEfficient()[teamVO.id - 1];return;
            case "defendEfficient":
                teamVO.defendEfficient = teamData.getDefendEfficient()[teamVO.id - 1];return;
            case "defendReboundEfficient":
                teamVO.defendReboundEfficient = teamData.getDefendReboundEfficient()[teamVO.id - 1];return;
            case "offendEfficient":
                teamVO.offendEfficient = teamData.getOffendEfficient()[teamVO.id - 1];return;
            case "offendReboundEfficient":
                teamVO.offendReboundEfficient = teamData.getOffendReboundEfficient()[teamVO.id - 1];return;
            case "offendRound":
                teamVO.offendRound = teamData.getOffendRound()[teamVO.id - 1];return;
            case "stealEfficient":
                teamVO.stealEfficient = teamData.getStealEfficient()[teamVO.id - 1];return;
            case "winRate":
                teamVO.stealEfficient = teamData.getWinRate()[teamVO.id - 1];return;
        }
    }

    private static ArrayList<String> highInfo;
    private static ArrayList<String> getHighInfo(){
        if (highInfo == null){
            highInfo = new ArrayList<String>();
            highInfo.add("photo");
            highInfo.add("teamName");
            highInfo.add("assistEfficient");
            highInfo.add("defendEfficient");
            highInfo.add("defendReboundEfficient");
            highInfo.add("offendEfficient");
            highInfo.add("offendReboundEfficient");
            highInfo.add("offendRound");
            highInfo.add("stealEfficient");
            highInfo.add("winRate");
        }
        return highInfo;
    }

    private static ArrayList<String> avgNormalInfo;
    private static ArrayList<String> getAvgNormalInfo(){
        if (avgNormalInfo == null){
            avgNormalInfo = new ArrayList<>();
            avgNormalInfo.add("teamName");
            avgNormalInfo.add("photo");
            avgNormalInfo.add("avgAssist");
            avgNormalInfo.add("avgBlockShot");
            avgNormalInfo.add("avgDefendRebound");
            avgNormalInfo.add("avgFault");
            avgNormalInfo.add("avgFoul");
            avgNormalInfo.add("numOfGame");
            avgNormalInfo.add("avgOffendRebound");
            avgNormalInfo.add("avgPoint");
            avgNormalInfo.add("avgRebound");
            avgNormalInfo.add("avgSteal");
            avgNormalInfo.add("penalty");
            avgNormalInfo.add("shot");
            avgNormalInfo.add("three");
        }
        return avgNormalInfo;
    }

    private static ArrayList<String> normalInfo;
    private static ArrayList<String> getNormalInfo(){
        if (normalInfo == null){
            normalInfo = new ArrayList<>();
            normalInfo.add("assist");
            normalInfo.add("teamName");
            normalInfo.add("photo");
            normalInfo.add("teamName");
            normalInfo.add("blockShot");
            normalInfo.add("defendRebound");
            normalInfo.add("fault");
            normalInfo.add("foul");
            normalInfo.add("numOfGame");
            normalInfo.add("offendRebound");
            normalInfo.add("penalty");
            normalInfo.add("point");
            normalInfo.add("rebound");
            normalInfo.add("shot");
            normalInfo.add("steal");
            normalInfo.add("three");
        }
        return normalInfo;
    }

    private static ArrayList<String> information;
    private static ArrayList<String> getInformation(){
        if (information == null){
            information = new ArrayList<>();
            information.add("photo");
            information.add("teamName");
            information.add("abridge");
            information.add("location");
            information.add("league");
            information.add("division");
            information.add("homeCourt");
            information.add("foundTime");
        }

        return information;
    }

    private static ArrayList<String> allInformation;
    private static ArrayList<String> getAllInformation(){
        if (allInformation == null){
            allInformation = new ArrayList<>();
            allInformation.add("photo");
            allInformation.add("teamName");
            allInformation.add("abridge");
            allInformation.add("location");
            allInformation.add("league");
            allInformation.add("division");
            allInformation.add("homeCourt");
            allInformation.add("foundTime");
            allInformation.add("avgAssist");
            allInformation.add("avgBlockShot");
            allInformation.add("avgDefendRebound");
            allInformation.add("avgFault");
            allInformation.add("avgFoul");
            allInformation.add("numOfGame");
            allInformation.add("avgOffendRebound");
            allInformation.add("avgPoint");
            allInformation.add("avgRebound");
            allInformation.add("avgSteal");
            allInformation.add("penalty");
            allInformation.add("shot");
            allInformation.add("three");
            allInformation.add("assistEfficient");
            allInformation.add("defendEfficient");
            allInformation.add("defendReboundEfficient");
            allInformation.add("offendEfficient");
            allInformation.add("offendReboundEfficient");
            allInformation.add("offendRound");
            allInformation.add("stealEfficient");
            allInformation.add("winRate");
        }
        return allInformation;
    }
}

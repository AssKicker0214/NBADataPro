package dataservice.team;

import data.DataInitial;
import data.PlayerDataManager;
import data.TeamDataManager;
import data.Tools;
import data.input.Team;
import data.saver.PlayerScoreSaver;
import dataservice.player.PlayerDataHandel;
import vo.playervo.PlayerVO;
import vo.teamvo.HotTeamsVO;
import vo.teamvo.TeamVO;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Test;

/**
 * Created by cho on 2015/4/30.
 */
public class TeamDataHandel implements TeamDataService {

    @Override
    public ArrayList<HotTeamsVO> hotTeams(int num, String sortBy) {
        ArrayList<HotTeamsVO> arrayList = new TeamDataManager().getHotTeams(sortBy);
        arrayList.sort(new Comparator<HotTeamsVO>() {
            @Override
            public int compare(HotTeamsVO o1, HotTeamsVO o2) {
                if (o1.value < o2.value)
                    return 1;
                else if (o1.value > o2.value){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        int length = num > arrayList.size() ? arrayList.size():num;
        ArrayList<HotTeamsVO> res = new ArrayList<>();
        for (int i = 0; i < length ; i++){
            res.add(arrayList.get(i));
        }
        return res;
    }

    @Override
    public TeamVO findTeamInfo(int teamId) {
        TeamVO teamVO = new TeamDataManager().getTeamVO(getAllInformation(), TeamDataManager.DEFAULT, teamId);
        return teamVO;
    }

    @Override
    public TeamVO findTeamInfo(String teamName) {
        TeamDataManager teamDataManager = new TeamDataManager();
        int teamId = teamDataManager.getTeamId(teamName);
        return findTeamInfo(teamId);
    }

    @Override
    public ArrayList<TeamVO> findTeams(String msg) {
        ArrayList<TeamVO> arrayList = new TeamDataManager().getTeamVOs(getAllInformation(),TeamDataManager.DEFAULT);
        ArrayList<TeamVO> res = new ArrayList<>();
        msg = msg.toLowerCase();
        for(int i = 0; i < 10; i++){
            int m = 0;
            for (int k = 0;k<arrayList.size();k++){
                TeamVO teamVO = arrayList.get(m);
                String name = Tools.getNPosition(teamVO.teamName.toLowerCase(), i);
                if (name.startsWith(msg)) {
                    res.add(teamVO);
                    arrayList.remove(teamVO);
                }else {
                    m++;
                }
            }
        }
        return res;
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
            if (!(desc ^ compare(vo, vos[i], sortBy))) {
                vos[i + 1] = vos[i];
                if (i == 0){
                    vos[0] = vo;
                }
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
////        ArrayList<String> temp = (ArrayList<String>) attributes.clone();
////        attributes.add("league");
////        TeamDataManager teamDataManager = new TeamDataManager();
////        ArrayList<TeamVO> arrayList = teamDataManager.getTeamVOs(temp,TeamDataManager.DEFAULT);
////        TeamVO teamVO = new TeamVO();
////        int num = 0 ;
////        for (int i = 0; i < arrayList.size(); i++ ){
////            if (arrayList.get(i).league == league){
//////                teamDataManager.se
////                num++;
////                for (int j = 0; j < attributes.size(); j++){
////                    teamDataManager.setAttribute(attributes.get(j),teamVO,arrayList.get(i));
////                }
////            }
////        }
//        return null;
//    }

//    public TeamVO avgLeague(ArrayList<String> attributes,String league) {
//        ArrayList<String> temp = (ArrayList<String>) attributes.clone();
//        attributes.add("league");
//        ArrayList<TeamVO> arrayList = getDefault(temp);
//        TeamVO teamVO = new TeamVO();
//        int num = 0 ;
//        for (int i = 0; i <  arrayList.size();i++){
//            if (arrayList.get(i).league.equals(league)){
//                num++;
//                for (String s:attributes){
//                    switch (s){
//                        case "assist":
//                            teamVO.assist += arrayList.get(i).assist;
//                        case "blockShot":
//                            teamVO.blockShot += arrayList.get(i).blockShot;
//                        case "defendRebound":
//                            teamVO.defendRebound += arrayList.get(i).defendRebound;
//                        case "fault":
//                            teamVO.fault += arrayList.get(i).fault;
//                        case "numOfGame":
//                            teamVO.numOfGame += arrayList.get(i).numOfGame;
//                        case "offendRebound":
//                            teamVO.offendRebound += arrayList.get(i).offendRebound;
//                        case "penalty":
//                            teamVO.penalty += arrayList.get(i).penalty;
//                        case "point":
//                            teamVO.point += arrayList.get(i).point;
//                        case "rebound":
//                            teamVO.rebound += arrayList.get(i).rebound;
//                        case "shot":
//                            teamVO.shot += arrayList.get(i).shot;
//                        case "steal":
//                            teamVO.steal += arrayList.get(i).steal;
//                        case "three":
//                            teamVO.three += arrayList.get(i).three;
//                        case "avgAssist":
//                            teamVO.avgAssist += arrayList.get(i).avgAssist;
//                        case "avgBlockShot":
//                            teamVO.avgBlockShot += arrayList.get(i).avgBlockShot;
//                        case "avgDefendRebound":
//                            teamVO.avgDefendRebound += arrayList.get(i).avgDefendRebound;
//                        case "avgFault":
//                            teamVO.avgFault += arrayList.get(i).avgFault;
//                        case "avgFoul":
//                            teamVO.avgFoul += arrayList.get(i).avgFoul;
//                        case "avgOffendRebound":
//                            teamVO.avgOffendRebound += arrayList.get(i).avgOffendRebound;
//                        case "avgPoint":
//                            teamVO.avgPoint += arrayList.get(i).avgPoint;
//                        case "avgRebound":
//                            teamVO.avgRebound += arrayList.get(i).avgRebound;
//                        case "avgSteal":
//                            teamVO.avgSteal += arrayList.get(i).avgSteal;
//
//                        case "assistEfficient":
//                            teamVO.assistEfficient += arrayList.get(i).assistEfficient;
//                        case "defendEfficient":
//                            teamVO.defendEfficient += arrayList.get(i).defendEfficient;
//                        case "defendReboundEfficient":
//                            teamVO.defendReboundEfficient += arrayList.get(i).defendReboundEfficient;
//                        case "offendEfficient":
//                            teamVO.offendEfficient += arrayList.get(i).offendEfficient;
//                        case "offendReboundEfficient":
//                            teamVO.offendReboundEfficient += arrayList.get(i).offendReboundEfficient;
//                        case "offendRound":
//                            teamVO.offendRound += arrayList.get(i).offendRound;
//                        case "stealEfficient":
//                            teamVO.stealEfficient += arrayList.get(i).stealEfficient;
//                        case "winRate":
//                            teamVO.stealEfficient += arrayList.get(i).stealEfficient;
//                    }
//                }
//            }
//        }
//
//
//        return teamVO;
//    }

    @Override
    public ArrayList<PlayerVO> teamMemberList(int teamID) {
        return new PlayerDataHandel().getTeamPlayerVOs( teamID);
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
            allInformation.add("assist");
            allInformation.add("avgBlockShot");
            allInformation.add("blockShot");
            allInformation.add("avgDefendRebound");
            allInformation.add("defendRebound");
            allInformation.add("avgFault");
            allInformation.add("fault");
            allInformation.add("avgFoul");
            allInformation.add("foul");
            allInformation.add("numOfGame");
            allInformation.add("avgOffendRebound");
            allInformation.add("offendRebound");
            allInformation.add("avgPoint");
            allInformation.add("point");
            allInformation.add("avgRebound");
            allInformation.add("rebound");
            allInformation.add("avgSteal");
            allInformation.add("steal");
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

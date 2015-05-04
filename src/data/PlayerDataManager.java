package data;

import data.saver.PlayerSaver;
import data.saver.PlayerScoreSaver;
import vo.playervo.PlayerVO;

import java.util.ArrayList;

/**
 * Created by chenghao on 15/5/1.
 */
public class PlayerDataManager {
    public static final int DEFAULT = 1;
    public static final int L5 = 2;
    public static final int BEFORE = 3;
    private PlayerScoreSaver playerScoreSaver;

    private PlayerScoreSaver.PlayerData playerDataDefault;
    private PlayerScoreSaver.PlayerData playerDataL5;
    private PlayerScoreSaver.PlayerData playerDataBefore;

    public PlayerDataManager() {
        update();
    }

    public void update() {
        this.playerScoreSaver = PlayerScoreSaver.getPlayerScoreSaver();
        this.playerDataDefault = this.playerScoreSaver.getPlayerDataDefault();
        this.playerDataL5 = this.playerScoreSaver.getPlayerDataL5();
        this.playerDataBefore = this.playerScoreSaver.getPlayerDataBefore();
    }

    public ArrayList<PlayerVO> getPlayerVOs(ArrayList<String> arrayList, int type){
        PlayerScoreSaver.PlayerData playerData = getPlayerData(type);
        ArrayList<PlayerVO> playerVOs = new ArrayList<>();
        for (int i = 0; i < getNum(); i++){
            PlayerVO playerVO = new PlayerVO();
            playerVO.id = i + 1;
            setPlayerVO(arrayList,playerVO,playerData);
            playerVOs.add(playerVO);
        }
        return playerVOs;
    }

    public PlayerVO getPlayerVO(ArrayList<String> arrayList, int type, int pid) {
        PlayerScoreSaver.PlayerData playerData = getPlayerData(type);
        PlayerVO playerVO = new PlayerVO();
        playerVO.id = pid;
        setPlayerVO(arrayList, playerVO, playerData);
        return playerVO;
    }

    private PlayerScoreSaver.PlayerData getPlayerData(int type) {
        PlayerScoreSaver.PlayerData playerData;
        if (type == DEFAULT) {
            playerData = this.playerDataDefault;
        } else if (type == L5) {
            playerData = this.playerDataL5;
        } else {
            playerData = this.playerDataBefore;
        }
        return playerData;
    }

    private void setPlayerVO(ArrayList<String> arrayList, PlayerVO playerVO, PlayerScoreSaver.PlayerData playerData) {
        for (String s : arrayList) {
            setAttribute(s, playerVO, playerData);
        }
    }

    public void setPlayerVO(ArrayList<String> arrayList, PlayerVO playerVO,int type){
        PlayerScoreSaver.PlayerData playerData = getPlayerData(type);
        setPlayerVO(arrayList,playerVO,playerData);
    }

    public int getNum() {
        return PlayerSaver.getPlayerSaver().getNum();
    }

    private void setAttribute(String s, PlayerVO playerVO, PlayerScoreSaver.PlayerData playerData) {
        switch (s){
            case "photo":
                playerVO.photo = playerData.getPhoto()[playerVO.id - 1];
                return;
            case "division":
                playerVO.division = playerData.getDivision()[playerVO.id - 1];
                return;
            case "name":
                playerVO.name = playerData.getName()[playerVO.id - 1];
                return;
            case "team":
                playerVO.name = playerData.getTeam()[playerVO.id - 1];
                return;
            case "teamName":
                playerVO.teamName = playerData.getTeamName()[playerVO.id - 1];
                return;
            case "position":
                playerVO.position = playerData.getPosition()[playerVO.id - 1];
                return;
            case "league":
                playerVO.league = playerData.getLeague()[playerVO.id - 1];
                return;
            case "number":
                playerVO.number = playerData.getNumber()[playerVO.id - 1];
                return;
            case "age":
                playerVO.age = playerData.getAge()[playerVO.id - 1];
                return;
            case "assist":
                playerVO.assist = playerData.getAssist()[playerVO.id - 1];
                return;
            case "blockShot":
                playerVO.blockShot = playerData.getBlockShot()[playerVO.id - 1];
                return;
            case "defend":
                playerVO.defend = playerData.getDefend()[playerVO.id - 1];
                return;
            case "efficiency":
                playerVO.efficiency = playerData.getEfficiency()[playerVO.id - 1];
                return;
            case "fault":
                playerVO.fault = playerData.getFault()[playerVO.id - 1];
                return;
            case "minute":
                playerVO.minute = playerData.getMinute()[playerVO.id - 1];
                return;
            case "numOfGame":
                playerVO.numOfGame = playerData.getNumOfGame()[playerVO.id - 1];
                return;
            case "offend":
                playerVO.offend = playerData.getOffend()[playerVO.id - 1];
                return;
            case "penalty":
                playerVO.penalty = playerData.getPenalty()[playerVO.id - 1];
                return;
            case "point":
                playerVO.point = playerData.getPoint()[playerVO.id - 1];
                return;
            case "rebound":
                playerVO.rebound = playerData.getRebound()[playerVO.id - 1];
                return;
            case "shot":
                playerVO.shot = playerData.getShot()[playerVO.id - 1];
                return;
            case "start":
                playerVO.start = playerData.getStart()[playerVO.id - 1];
                return;
            case "steal":
                playerVO.steal = playerData.getSteal()[playerVO.id - 1];
                return;
            case "three":
                playerVO.three = playerData.getThree()[playerVO.id - 1];
                return;
            case "avgAssist":
                playerVO.avgAssist = playerData.getAvgAssist()[playerVO.id - 1];
                return;
            case "avgBlockShot":
                playerVO.avgBlockShot = playerData.getAvgBlockShot()[playerVO.id - 1];
                return;
            case "avgDefend":
                playerVO.avgDefend = playerData.getAvgDefend()[playerVO.id - 1];
                return;
            case "avgFault":
                playerVO.avgFault = playerData.getAvgFault()[playerVO.id - 1];
                return;
            case "avgFoul":
                playerVO.avgFoul = playerData.getAvgFoul()[playerVO.id - 1];
                return;
            case "avgMinute":
                playerVO.avgMinute = playerData.getAvgMinute()[playerVO.id - 1];
                return;
            case "avgOffend":
                playerVO.avgOffend = playerData.getAvgOffend()[playerVO.id - 1];
                return;
            case "avgPoint":
                playerVO.avgPoint = playerData.getAvgPoint()[playerVO.id - 1];
                return;
            case "avgRebound":
                playerVO.avgRebound = playerData.getAvgRebound()[playerVO.id - 1];
                return;
            case "avgSteal":
                playerVO.avgSteal = playerData.getAvgSteal()[playerVO.id - 1];
                return;
            case "assistEfficient":
                playerVO.assistEfficient = playerData.getAssistEfficient()[playerVO.id - 1];
                return;
            case "blockShotEfficient":
                playerVO.blockShotEfficient = playerData.getBlockShotEfficient()[playerVO.id - 1];
                return;
            case "defendReboundEfficient":
                playerVO.defendReboundEfficient = playerData.getDefendReboundEfficient()[playerVO.id - 1];
                return;
            case "faultEfficient":
                playerVO.faultEfficient = playerData.getFaultEfficient()[playerVO.id - 1];
                return;
            case "frequency":
                playerVO.frequency = playerData.getFrequency()[playerVO.id - 1];
                return;
            case "gmSc":
                playerVO.gmSc = playerData.getGmSc()[playerVO.id - 1];
                return;
            case "offendReboundEfficient":
                playerVO.offendReboundEfficient = playerData.getOffendReboundEfficient()[playerVO.id - 1];
                return;
            case "realShot":
                playerVO.realShot = playerData.getRealShot()[playerVO.id - 1];
                return;
            case "reboundEfficient":
                playerVO.reboundEfficient = playerData.getReboundEfficient()[playerVO.id - 1];
                return;
            case "shotEfficient":
                playerVO.shotEfficient = playerData.getShotEfficient()[playerVO.id - 1];
                return;
            case "stealEfficient":
                playerVO.stealEfficient = playerData.getStealEfficient()[playerVO.id - 1];
                return;
        }
    }

    public int getPlayerId(String name) {
        return 0;
    }


}

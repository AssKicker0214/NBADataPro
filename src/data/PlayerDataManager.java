package data;

import data.saver.PlayerSaver;
import data.saver.PlayerScoreSaver;
import vo.playervo.HotPlayersVO;
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
        return playerDataDefault.getPlayerId(name);
    }

    private HotPlayersVO getHotPlayer(String sortBy,PlayerScoreSaver.PlayerData playerData,int id){
        HotPlayersVO playersVO = new HotPlayersVO();
        playersVO.id = id;
        setHotPlayerInfo(playersVO,playerData);
        setHotPlayerValue(sortBy,playersVO,playerData);
        return playersVO;
    }

    private HotPlayersVO getUpgrade(String sortBy,PlayerScoreSaver.PlayerData playerData,int id){
        HotPlayersVO playersVO = new HotPlayersVO();
        playersVO.id = id;
        setHotPlayerInfo(playersVO,playerData);
        setUpgrade(sortBy,playersVO);
        setHotPlayerValue(sortBy,playersVO,playerData);
        return playersVO;
    }

    public ArrayList<HotPlayersVO> getHotPlayers(String sortBy,int type){
        PlayerScoreSaver.PlayerData playerData = getPlayerData(type);
        ArrayList<HotPlayersVO> playersVOs = new ArrayList<>();
        for (int i = 0; i< playerData.getNum();i++){
            playersVOs.add(getHotPlayer(sortBy,playerData,i++));
        }
        return playersVOs;
    }

    public ArrayList<HotPlayersVO> getUpgrade(String sortBy){
        ArrayList<HotPlayersVO> playersVOs = new ArrayList<>();
        for (int i = 0; i< playerDataDefault.getNum();i++){
            playersVOs.add(getHotPlayer(sortBy,playerDataDefault,i++));
        }
        return playersVOs;
    }

    private void setHotPlayerInfo(HotPlayersVO hotPlayersVO,PlayerScoreSaver.PlayerData playerData){
        hotPlayersVO.name = playerData.getName()[hotPlayersVO.id - 1];
        hotPlayersVO.teamName = playerData.getTeam()[hotPlayersVO.id - 1];
        hotPlayersVO.photo = playerData.getPhoto()[hotPlayersVO.id - 1];
        hotPlayersVO.teamPhoto = playerData.getTeamPhoto()[hotPlayersVO.id - 1];
        hotPlayersVO.position = playerData.getPosition()[hotPlayersVO.id - 1];
        hotPlayersVO.number  = playerData.getNumber()[hotPlayersVO.id - 1];
    }

    private void setHotPlayerValue(String sortBy,HotPlayersVO hotPlayersVO,PlayerScoreSaver.PlayerData playerData){
        switch (sortBy){
            case "assist":
                hotPlayersVO.value = playerData.getAssist()[hotPlayersVO.id - 1];
                return;
            case "blockShot":
                hotPlayersVO.value = playerData.getBlockShot()[hotPlayersVO.id - 1];
                return;
            case "defend":
                hotPlayersVO.value = playerData.getDefend()[hotPlayersVO.id - 1];
                return;
            case "efficiency":
                hotPlayersVO.value = playerData.getEfficiency()[hotPlayersVO.id - 1];
                return;
            case "fault":
                hotPlayersVO.value = playerData.getFault()[hotPlayersVO.id - 1];
                return;
            case "minute":
                hotPlayersVO.value = playerData.getMinute()[hotPlayersVO.id - 1];
                return;
            case "numOfGame":
                hotPlayersVO.value = playerData.getNumOfGame()[hotPlayersVO.id - 1];
                return;
            case "offend":
                hotPlayersVO.value = playerData.getOffend()[hotPlayersVO.id - 1];
                return;
            case "penalty":
                hotPlayersVO.value = playerData.getPenalty()[hotPlayersVO.id - 1];
                return;
            case "point":
                hotPlayersVO.value = playerData.getPoint()[hotPlayersVO.id - 1];
                return;
            case "rebound":
                hotPlayersVO.value = playerData.getRebound()[hotPlayersVO.id - 1];
                return;
            case "shot":
                hotPlayersVO.value = playerData.getShot()[hotPlayersVO.id - 1];
                return;
            case "start":
                hotPlayersVO.value = playerData.getStart()[hotPlayersVO.id - 1];
                return;
            case "steal":
                hotPlayersVO.value = playerData.getSteal()[hotPlayersVO.id - 1];
                return;
            case "three":
                hotPlayersVO.value = playerData.getThree()[hotPlayersVO.id - 1];
                return;
            case "avgAssist":
                hotPlayersVO.value = playerData.getAvgAssist()[hotPlayersVO.id - 1];
                return;
            case "avgBlockShot":
                hotPlayersVO.value = playerData.getAvgBlockShot()[hotPlayersVO.id - 1];
                return;
            case "avgDefend":
                hotPlayersVO.value = playerData.getAvgDefend()[hotPlayersVO.id - 1];
                return;
            case "avgFault":
                hotPlayersVO.value = playerData.getAvgFault()[hotPlayersVO.id - 1];
                return;
            case "avgFoul":
                hotPlayersVO.value = playerData.getAvgFoul()[hotPlayersVO.id - 1];
                return;
            case "avgMinute":
                hotPlayersVO.value = playerData.getAvgMinute()[hotPlayersVO.id - 1];
                return;
            case "avgOffend":
                hotPlayersVO.value = playerData.getAvgOffend()[hotPlayersVO.id - 1];
                return;
            case "avgPoint":
                hotPlayersVO.value = playerData.getAvgPoint()[hotPlayersVO.id - 1];
                return;
            case "avgRebound":
                hotPlayersVO.value = playerData.getAvgRebound()[hotPlayersVO.id - 1];
                return;
            case "avgSteal":
                hotPlayersVO.value = playerData.getAvgSteal()[hotPlayersVO.id - 1];
                return;
            case "assistEfficient":
                hotPlayersVO.value = playerData.getAssistEfficient()[hotPlayersVO.id - 1];
                return;
            case "blockShotEfficient":
                hotPlayersVO.value = playerData.getBlockShotEfficient()[hotPlayersVO.id - 1];
                return;
            case "defendReboundEfficient":
                hotPlayersVO.value = playerData.getDefendReboundEfficient()[hotPlayersVO.id - 1];
                return;
            case "faultEfficient":
                hotPlayersVO.value = playerData.getFaultEfficient()[hotPlayersVO.id - 1];
                return;
            case "frequency":
                hotPlayersVO.value = playerData.getFrequency()[hotPlayersVO.id - 1];
                return;
            case "gmSc":
                hotPlayersVO.value = playerData.getGmSc()[hotPlayersVO.id - 1];
                return;
            case "offendReboundEfficient":
                hotPlayersVO.value = playerData.getOffendReboundEfficient()[hotPlayersVO.id - 1];
                return;
            case "realShot":
                hotPlayersVO.value = playerData.getRealShot()[hotPlayersVO.id - 1];
                return;
            case "reboundEfficient":
                hotPlayersVO.value = playerData.getReboundEfficient()[hotPlayersVO.id - 1];
                return;
            case "shotEfficient":
                hotPlayersVO.value = playerData.getShotEfficient()[hotPlayersVO.id - 1];
                return;
            case "stealEfficient":
                hotPlayersVO.value = playerData.getStealEfficient()[hotPlayersVO.id - 1];
                return;
        }
    }

    private void setUpgrade(String sortBy,HotPlayersVO hotPlayersVO){
        switch (sortBy){
            case "assist":
                hotPlayersVO.upgradeRate = (playerDataBefore.getAssist()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getAssist()[hotPlayersVO.id - 1] -playerDataBefore.getAssist()[hotPlayersVO.id - 1])/(playerDataBefore.getAssist()[hotPlayersVO.id - 1]);
                return;
            case "blockShot":
                hotPlayersVO.upgradeRate = (playerDataBefore.getBlockShot()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getBlockShot()[hotPlayersVO.id - 1] -playerDataBefore.getBlockShot()[hotPlayersVO.id - 1])/(playerDataBefore.getBlockShot()[hotPlayersVO.id - 1]);
                return;
            case "defend":
                hotPlayersVO.upgradeRate = (playerDataBefore.getDefend()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getDefend()[hotPlayersVO.id - 1] -playerDataBefore.getDefend()[hotPlayersVO.id - 1])/(playerDataBefore.getDefend()[hotPlayersVO.id - 1]);
                return;
            case "efficiency":
                hotPlayersVO.upgradeRate = (playerDataBefore.getEfficiency()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getEfficiency()[hotPlayersVO.id - 1] -playerDataBefore.getEfficiency()[hotPlayersVO.id - 1])/(playerDataBefore.getEfficiency()[hotPlayersVO.id - 1]);
                return;
            case "fault":
                hotPlayersVO.upgradeRate = (playerDataBefore.getFault()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getFault()[hotPlayersVO.id - 1] -playerDataBefore.getFault()[hotPlayersVO.id - 1])/(playerDataBefore.getFault()[hotPlayersVO.id - 1]);
                return;
            case "minute":
                hotPlayersVO.upgradeRate = (playerDataBefore.getMinute()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getMinute()[hotPlayersVO.id - 1] -playerDataBefore.getMinute()[hotPlayersVO.id - 1])/(playerDataBefore.getMinute()[hotPlayersVO.id - 1]);
                return;
            case "numOfGame":
                hotPlayersVO.upgradeRate = (playerDataBefore.getNumOfGame()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getNumOfGame()[hotPlayersVO.id - 1] -playerDataBefore.getNumOfGame()[hotPlayersVO.id - 1])/(playerDataBefore.getNumOfGame()[hotPlayersVO.id - 1]);
                return;
            case "offend":
                hotPlayersVO.upgradeRate = (playerDataBefore.getOffend()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getOffend()[hotPlayersVO.id - 1] -playerDataBefore.getOffend()[hotPlayersVO.id - 1])/(playerDataBefore.getOffend()[hotPlayersVO.id - 1]);
                return;
            case "penalty":
                hotPlayersVO.upgradeRate = (playerDataBefore.getPenalty()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getPenalty()[hotPlayersVO.id - 1] -playerDataBefore.getPenalty()[hotPlayersVO.id - 1])/(playerDataBefore.getPenalty()[hotPlayersVO.id - 1]);
                return;
            case "point":
                hotPlayersVO.upgradeRate = (playerDataBefore.getPoint()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getPoint()[hotPlayersVO.id - 1] -playerDataBefore.getPoint()[hotPlayersVO.id - 1])/(playerDataBefore.getPoint()[hotPlayersVO.id - 1]);
                return;
            case "rebound":
                hotPlayersVO.upgradeRate = (playerDataBefore.getRebound()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getRebound()[hotPlayersVO.id - 1] -playerDataBefore.getRebound()[hotPlayersVO.id - 1])/(playerDataBefore.getRebound()[hotPlayersVO.id - 1]);
                return;
            case "shot":
                hotPlayersVO.upgradeRate = (playerDataBefore.getShot()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getShot()[hotPlayersVO.id - 1] -playerDataBefore.getShot()[hotPlayersVO.id - 1])/(playerDataBefore.getShot()[hotPlayersVO.id - 1]);
                return;
            case "start":
                hotPlayersVO.upgradeRate = (playerDataBefore.getStart()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getStart()[hotPlayersVO.id - 1] -playerDataBefore.getStart()[hotPlayersVO.id - 1])/(playerDataBefore.getStart()[hotPlayersVO.id - 1]);
                return;
            case "steal":
                hotPlayersVO.upgradeRate = (playerDataBefore.getSteal()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getSteal()[hotPlayersVO.id - 1] -playerDataBefore.getSteal()[hotPlayersVO.id - 1])/(playerDataBefore.getSteal()[hotPlayersVO.id - 1]);
                return;
            case "three":
                hotPlayersVO.upgradeRate = (playerDataBefore.getThree()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getThree()[hotPlayersVO.id - 1] -playerDataBefore.getThree()[hotPlayersVO.id - 1])/(playerDataBefore.getThree()[hotPlayersVO.id - 1]);
                return;
            case "avgAssist":
                hotPlayersVO.upgradeRate = (playerDataBefore.getAvgAssist()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getAvgAssist()[hotPlayersVO.id - 1] -playerDataBefore.getAvgAssist()[hotPlayersVO.id - 1])/(playerDataBefore.getAvgAssist()[hotPlayersVO.id - 1]);
                return;
            case "avgBlockShot":
                hotPlayersVO.upgradeRate = (playerDataBefore.getAvgBlockShot()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getAvgBlockShot()[hotPlayersVO.id - 1] -playerDataBefore.getAvgBlockShot()[hotPlayersVO.id - 1])/(playerDataBefore.getAvgBlockShot()[hotPlayersVO.id - 1]);
                return;
            case "avgDefend":
                hotPlayersVO.upgradeRate = (playerDataBefore.getAvgDefend()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getAvgDefend()[hotPlayersVO.id - 1] -playerDataBefore.getAvgDefend()[hotPlayersVO.id - 1])/(playerDataBefore.getAvgDefend()[hotPlayersVO.id - 1]);
                return;
            case "avgFault":
                hotPlayersVO.upgradeRate = (playerDataBefore.getAvgFault()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getAvgFault()[hotPlayersVO.id - 1] -playerDataBefore.getAvgFault()[hotPlayersVO.id - 1])/(playerDataBefore.getAvgFault()[hotPlayersVO.id - 1]);
                return;
            case "avgFoul":
                hotPlayersVO.upgradeRate = (playerDataBefore.getAvgFoul()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getAvgFoul()[hotPlayersVO.id - 1] -playerDataBefore.getAvgFoul()[hotPlayersVO.id - 1])/(playerDataBefore.getAvgFoul()[hotPlayersVO.id - 1]);
                return;
            case "avgMinute":
                hotPlayersVO.upgradeRate = (playerDataBefore.getAvgMinute()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getAvgMinute()[hotPlayersVO.id - 1] -playerDataBefore.getAvgMinute()[hotPlayersVO.id - 1])/(playerDataBefore.getAvgMinute()[hotPlayersVO.id - 1]);
                return;
            case "avgOffend":
                hotPlayersVO.upgradeRate = (playerDataBefore.getAvgOffend()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getAvgOffend()[hotPlayersVO.id - 1] -playerDataBefore.getAvgOffend()[hotPlayersVO.id - 1])/(playerDataBefore.getAvgOffend()[hotPlayersVO.id - 1]);
                return;
            case "avgPoint":
                hotPlayersVO.upgradeRate = (playerDataBefore.getAvgPoint()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getAvgPoint()[hotPlayersVO.id - 1] -playerDataBefore.getAvgPoint()[hotPlayersVO.id - 1])/(playerDataBefore.getAvgPoint()[hotPlayersVO.id - 1]);
                return;
            case "avgRebound":
                hotPlayersVO.upgradeRate = (playerDataBefore.getAvgRebound()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getAvgRebound()[hotPlayersVO.id - 1] -playerDataBefore.getAvgRebound()[hotPlayersVO.id - 1])/(playerDataBefore.getAvgRebound()[hotPlayersVO.id - 1]);
                return;
            case "avgSteal":
                hotPlayersVO.upgradeRate = (playerDataBefore.getAvgSteal()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getAvgSteal()[hotPlayersVO.id - 1] -playerDataBefore.getAvgSteal()[hotPlayersVO.id - 1])/(playerDataBefore.getAvgSteal()[hotPlayersVO.id - 1]);
                return;
            case "assistEfficient":
                hotPlayersVO.upgradeRate = (playerDataBefore.getAssistEfficient()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getAssistEfficient()[hotPlayersVO.id - 1] -playerDataBefore.getAssistEfficient()[hotPlayersVO.id - 1])/(playerDataBefore.getAssistEfficient()[hotPlayersVO.id - 1]);
                return;
            case "blockShotEfficient":
                hotPlayersVO.upgradeRate = (playerDataBefore.getAvgBlockShot()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getAvgBlockShot()[hotPlayersVO.id - 1] -playerDataBefore.getAvgBlockShot()[hotPlayersVO.id - 1])/(playerDataBefore.getAvgBlockShot()[hotPlayersVO.id - 1]);
                return;
            case "defendReboundEfficient":
                hotPlayersVO.upgradeRate = (playerDataBefore.getDefendReboundEfficient()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getDefendReboundEfficient()[hotPlayersVO.id - 1] -playerDataBefore.getDefendReboundEfficient()[hotPlayersVO.id - 1])/(playerDataBefore.getDefendReboundEfficient()[hotPlayersVO.id - 1]);
                return;
            case "faultEfficient":
                hotPlayersVO.upgradeRate = (playerDataBefore.getFaultEfficient()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getFaultEfficient()[hotPlayersVO.id - 1] -playerDataBefore.getFaultEfficient()[hotPlayersVO.id - 1])/(playerDataBefore.getFaultEfficient()[hotPlayersVO.id - 1]);
                return;
            case "frequency":
                hotPlayersVO.upgradeRate = (playerDataBefore.getFrequency()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getFrequency()[hotPlayersVO.id - 1] -playerDataBefore.getFrequency()[hotPlayersVO.id - 1])/(playerDataBefore.getFrequency()[hotPlayersVO.id - 1]);
                return;
            case "gmSc":
                hotPlayersVO.upgradeRate = (playerDataBefore.getGmSc()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getGmSc()[hotPlayersVO.id - 1] -playerDataBefore.getGmSc()[hotPlayersVO.id - 1])/(playerDataBefore.getGmSc()[hotPlayersVO.id - 1]);
                return;
            case "offendReboundEfficient":
                hotPlayersVO.upgradeRate = (playerDataBefore.getOffendReboundEfficient()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getOffendReboundEfficient()[hotPlayersVO.id - 1] -playerDataBefore.getOffendReboundEfficient()[hotPlayersVO.id - 1])/(playerDataBefore.getOffendReboundEfficient()[hotPlayersVO.id - 1]);
                return;
            case "realShot":
                hotPlayersVO.upgradeRate = (playerDataBefore.getRealShot()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getRealShot()[hotPlayersVO.id - 1] -playerDataBefore.getRealShot()[hotPlayersVO.id - 1])/(playerDataBefore.getRealShot()[hotPlayersVO.id - 1]);
                return;
            case "reboundEfficient":
                hotPlayersVO.upgradeRate = (playerDataBefore.getReboundEfficient()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getReboundEfficient()[hotPlayersVO.id - 1] -playerDataBefore.getReboundEfficient()[hotPlayersVO.id - 1])/(playerDataBefore.getReboundEfficient()[hotPlayersVO.id - 1]);
                return;
            case "shotEfficient":
                hotPlayersVO.upgradeRate = (playerDataBefore.getShotEfficient()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getShotEfficient()[hotPlayersVO.id - 1] -playerDataBefore.getShotEfficient()[hotPlayersVO.id - 1])/(playerDataBefore.getShotEfficient()[hotPlayersVO.id - 1]);
                return;
            case "stealEfficient":
                hotPlayersVO.upgradeRate = (playerDataBefore.getStealEfficient()[hotPlayersVO.id - 1]) <= 0?-1:((double)playerDataL5.getStealEfficient()[hotPlayersVO.id - 1] -playerDataBefore.getStealEfficient()[hotPlayersVO.id - 1])/(playerDataBefore.getStealEfficient()[hotPlayersVO.id - 1]);
                return;
        }
    }
}

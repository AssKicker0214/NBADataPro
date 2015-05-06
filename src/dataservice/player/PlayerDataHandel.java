package dataservice.player;

import data.PlayerDataManager;
import data.saver.PlayerScoreSaver;
import vo.playervo.HotPlayersVO;
import vo.playervo.PlayerVO;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by chenghao on 15/4/30.
 */
public class PlayerDataHandel implements PlayerDataService {
    private static ArrayList<String> highInfo;

    public static ArrayList<String> getHighInfo() {
        if (highInfo == null) {
            highInfo = new ArrayList<>();
            highInfo.add("name");
            highInfo.add("assistEfficient");
            highInfo.add("blockShotEfficient");
            highInfo.add("defendReboundEfficient");
            highInfo.add("faultEfficient");
            highInfo.add("frequency");
            highInfo.add("gmSc");
            highInfo.add("offendReboundEfficient");
            highInfo.add("realShot");
            highInfo.add("reboundEfficient");
            highInfo.add("shotEfficient");
            highInfo.add("stealEfficient");
        }
        return highInfo;
    }

    private static ArrayList<String> allInfo;

    public static ArrayList<String> getAllInfo() {
        if (allInfo == null) {
            allInfo = new ArrayList<>();
            allInfo.add("photo");
            allInfo.add("division");
            allInfo.add("name");
            allInfo.add("team");
            allInfo.add("teamName");
            allInfo.add("position");
            allInfo.add("league");
            allInfo.add("number");
            allInfo.add("school");
            allInfo.add("birth");
            allInfo.add("exp");
            allInfo.add("age");
            allInfo.add("avgAssist");
            allInfo.add("avgBlockShot");
            allInfo.add("avgDefend");
            allInfo.add("efficiency");
            allInfo.add("avgFault");
            allInfo.add("avgFoul");
            allInfo.add("avgMinute");
            allInfo.add("numOfGame");
            allInfo.add("avgOffend");
            allInfo.add("penalty");
            allInfo.add("avgPoint");
            allInfo.add("avgRebound");
            allInfo.add("start");
            allInfo.add("avgSteal");
            allInfo.add("three");
            allInfo.add("assistEfficient");
            allInfo.add("blockShotEfficient");
            allInfo.add("defendReboundEfficient");
            allInfo.add("faultEfficient");
            allInfo.add("frequency");
            allInfo.add("gmSc");
            allInfo.add("offendReboundEfficient");
            allInfo.add("realShot");
            allInfo.add("reboundEfficient");
            allInfo.add("shotEfficient");
            allInfo.add("stealEfficient");
        }
        return allInfo;
    }

    private static ArrayList<String> avgNormalInfo;

    public static ArrayList<String> getAvgNormalInfo() {
        if (avgNormalInfo == null){
            avgNormalInfo.add("age");
            avgNormalInfo.add("avgAssist");
            avgNormalInfo.add("avgBlockShot");
            avgNormalInfo.add("avgDefend");
            avgNormalInfo.add("efficiency");
            avgNormalInfo.add("avgFault");
            avgNormalInfo.add("avgFoul");
            avgNormalInfo.add("avgMinute");
            avgNormalInfo.add("numOfGame");
            avgNormalInfo.add("avgOffend");
            avgNormalInfo.add("penalty");
            avgNormalInfo.add("avgPoint");
            avgNormalInfo.add("avgRebound");
            avgNormalInfo.add("start");
            avgNormalInfo.add("avgSteal");
            avgNormalInfo.add("three");
        }
        return avgNormalInfo;
    }

    private static ArrayList<String> normalInfo;

    public static ArrayList<String> getNormalInfo() {
        if (normalInfo == null) {
            normalInfo.add("name");
            normalInfo.add("assist");
            normalInfo.add("blockShot");
            normalInfo.add("defend");
            normalInfo.add("efficiency");
            normalInfo.add("fault");
            normalInfo.add("foul");
            normalInfo.add("minute");
            normalInfo.add("numOfGame");
            normalInfo.add("offend");
            normalInfo.add("penalty");
            normalInfo.add("point");
            normalInfo.add("rebound");
            normalInfo.add("start");
            normalInfo.add("steal");
            normalInfo.add("three");
        }
        return normalInfo;
    }

    private static ArrayList<String> information;

    public static ArrayList<String> getInformation() {
        if (information == null) {
            information = new ArrayList<>();
            information.add("photo");
            information.add("division");
            information.add("name");
            information.add("team");
            information.add("teamName");
            information.add("position");
            information.add("league");
            information.add("number");
            information.add("school");
            information.add("birth");
            information.add("exp");
        }
        return information;
    }

    @Override
    public PlayerVO findPlayerData(int playerId) {
        PlayerDataManager playerDataManager = new PlayerDataManager();
        PlayerVO playerVO = new PlayerVO();
        playerVO.id = playerId;
        playerDataManager.setPlayerVO(getAllInfo(), playerVO, PlayerDataManager.DEFAULT);
        return playerVO;
    }

    @Override
    public PlayerVO findPlayerData(String name) {
        int playerId = new PlayerDataManager().getPlayerId(name);
        return findPlayerData(playerId);
    }

    @Override
    public ArrayList<PlayerVO> findPlayers(String msg) {
        ArrayList<PlayerVO> arrayList = new ArrayList<>();
        ArrayList<PlayerVO> playerVOs = findPlayer();
        for (PlayerVO playerVO : playerVOs) {
            if (playerVO.name.contains(msg)) {
                arrayList.add(playerVO);
            }
        }

        return arrayList;
    }

    @Override
    public ArrayList<PlayerVO> sortPlayerInfo(ArrayList<sortParam> sortBy) {
        ArrayList<PlayerVO> playVOs = new PlayerDataManager().getPlayerVOs(getInformation(), PlayerDataManager.DEFAULT);
        return playVOs;
    }

    @Override
    public ArrayList<PlayerVO> sortPlayerNormal(ArrayList<sortParam> sortBy) {
        ArrayList<PlayerVO> playVOs = new PlayerDataManager().getPlayerVOs(getNormalInfo(), PlayerDataManager.DEFAULT);
        return playVOs;
    }

    @Override
    public ArrayList<PlayerVO> sortPlayerNormalAvg(ArrayList<sortParam> sortBy) {
        ArrayList<PlayerVO> playVOs = new PlayerDataManager().getPlayerVOs(getAvgNormalInfo(), PlayerDataManager.DEFAULT);
        return playVOs;
    }

    private ArrayList<PlayerVO> findPlayer() {
        ArrayList<PlayerVO> arrayList = new PlayerDataManager().getPlayerVOs(getAllInfo(), PlayerDataManager.DEFAULT);

        return arrayList;
    }

    public String getToday() {
        return null;
    }

    public ArrayList<PlayerVO> getTeamPlayerVOs(int teamID) {
        return new PlayerDataManager().getPlayerVOs(getAllInfo(), teamID);
    }

    private class ComparePlayVO implements Comparator<PlayerVO> {
        @Override
        public int compare(PlayerVO o1, PlayerVO o2) {
            if (PlayerDataHandel.this.compare(o1, o2, sortBy)) {
                return 1;
            } else {
                return -1;
            }
        }

        private ArrayList<sortParam> sortBy;

        public ComparePlayVO(ArrayList<sortParam> sortBy) {
            this.sortBy = sortBy;
        }
    }

    private boolean compare(PlayerVO playerVO1, PlayerVO playerVO2, ArrayList<sortParam> sortBy) {
        for (int i = 0; i < sortBy.size(); i++) {
            int res = compare(playerVO1, playerVO2, sortBy.get(i));
            if (res > 0) {
                return true;
            } else if (res == 0) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    private int compare(PlayerVO playerVO1, PlayerVO playerVO2, sortParam sortParam) {
        int com = compare(playerVO1, playerVO2, sortParam.field);
        if (sortParam.isDesc) {
            return com;
        } else {
            return -1 * com;
        }

    }

    private int compare(PlayerVO playerVO1, PlayerVO playerVO2, String field) {
        switch (field) {
            case "name":
                return playerVO1.name.compareTo(playerVO2.name);
            case "team":
                return playerVO1.team.compareTo(playerVO2.team);
            case "teamName":
                return playerVO1.teamName.compareTo(playerVO2.teamName);
            case "number":
                return playerVO1.number - playerVO2.number;
            case "age":
                return playerVO1.age - playerVO2.age;
            case "assist":
                return playerVO1.assist - playerVO2.assist;
            case "blockShot":
                return playerVO1.blockShot - playerVO2.blockShot;
            case "defend":
                return playerVO1.defend - playerVO2.defend;
            case "three":
                return (int) (playerVO1.three - playerVO2.three);
            case "fault":
                return playerVO1.fault - playerVO2.fault;
            case "foul":
                return playerVO1.foul - playerVO2.foul;
            case "minute":
                return playerVO1.minute - playerVO2.minute;
            case "offend":
                return playerVO1.offend - playerVO2.offend;
            case "point":
                return playerVO1.point - playerVO2.point;
            case "rebound":
                return playerVO1.rebound - playerVO2.rebound;
            case "start":
                return playerVO1.start - playerVO2.start;
            case "steal":
                return playerVO1.steal - playerVO2.steal;
            case "numOfGame":
                return playerVO1.numOfGame - playerVO2.numOfGame;


            case "efficiency":
                if (playerVO1.efficiency > playerVO2.efficiency) {
                    return 1;
                } else if (playerVO1.efficiency == playerVO2.efficiency) {
                    return 0;
                } else {
                    return -1;
                }
            case "penalty":
                if (playerVO1.penalty > playerVO2.penalty) {
                    return 1;
                } else if (playerVO1.penalty == playerVO2.penalty) {
                    return 0;
                } else {
                    return -1;
                }
            case "shot":
                if (playerVO1.shot > playerVO2.shot) {
                    return 1;
                } else if (playerVO1.shot == playerVO2.shot) {
                    return 0;
                } else {
                    return -1;
                }
            case "avgAssist":
                if (playerVO1.avgAssist > playerVO2.avgAssist) {
                    return 1;
                } else if (playerVO1.avgAssist == playerVO2.avgAssist) {
                    return 0;
                } else {
                    return -1;
                }
            case "avgBlockShot":
                if (playerVO1.avgBlockShot > playerVO2.avgBlockShot) {
                    return 1;
                } else if (playerVO1.avgBlockShot == playerVO2.avgBlockShot) {
                    return 0;
                } else {
                    return -1;
                }
            case "avgDefend":
                if (playerVO1.avgDefend > playerVO2.avgDefend) {
                    return 1;
                } else if (playerVO1.avgDefend == playerVO2.avgDefend) {
                    return 0;
                } else {
                    return -1;
                }
            case "avgFault":
                if (playerVO1.avgFault > playerVO2.avgFault) {
                    return 1;
                } else if (playerVO1.avgFault == playerVO2.avgFault) {
                    return 0;
                } else {
                    return -1;
                }
            case "avgMinute":
                if (playerVO1.avgMinute > playerVO2.avgMinute) {
                    return 1;
                } else if (playerVO1.avgMinute == playerVO2.avgMinute) {
                    return 0;
                } else {
                    return -1;
                }
            case "avgOffend":
                if (playerVO1.avgOffend > playerVO2.avgOffend) {
                    return 1;
                } else if (playerVO1.avgOffend == playerVO2.avgOffend) {
                    return 0;
                } else {
                    return -1;
                }
            case "avgPoint":
                if (playerVO1.avgPoint > playerVO2.avgPoint) {
                    return 1;
                } else if (playerVO1.avgPoint == playerVO2.avgPoint) {
                    return 0;
                } else {
                    return -1;
                }
            case "avgRebound":
                if (playerVO1.avgRebound > playerVO2.avgRebound) {
                    return 1;
                } else if (playerVO1.avgRebound == playerVO2.avgRebound) {
                    return 0;
                } else {
                    return -1;
                }
            case "avgSteal":
                if (playerVO1.avgSteal > playerVO2.avgSteal) {
                    return 1;
                } else if (playerVO1.avgSteal == playerVO2.avgSteal) {
                    return 0;
                } else {
                    return -1;
                }
            case "assistEfficient":
                if (playerVO1.assistEfficient > playerVO2.assistEfficient) {
                    return 1;
                } else if (playerVO1.assistEfficient == playerVO2.assistEfficient) {
                    return 0;
                } else {
                    return -1;
                }
            case "blockShotEfficient":
                if (playerVO1.blockShotEfficient > playerVO2.blockShotEfficient) {
                    return 1;
                } else if (playerVO1.blockShotEfficient == playerVO2.blockShotEfficient) {
                    return 0;
                } else {
                    return -1;
                }
            case "defendReboundEfficient":
                if (playerVO1.defendReboundEfficient > playerVO2.defendReboundEfficient) {
                    return 1;
                } else if (playerVO1.defendReboundEfficient == playerVO2.defendReboundEfficient) {
                    return 0;
                } else {
                    return -1;
                }
            case "faultEfficient":
                if (playerVO1.faultEfficient > playerVO2.faultEfficient) {
                    return 1;
                } else if (playerVO1.faultEfficient == playerVO2.faultEfficient) {
                    return 0;
                } else {
                    return -1;
                }
            case "frequency":
                if (playerVO1.frequency > playerVO2.frequency) {
                    return 1;
                } else if (playerVO1.frequency == playerVO2.frequency) {
                    return 0;
                } else {
                    return -1;
                }
            case "gmSc":
                if (playerVO1.gmSc > playerVO2.gmSc) {
                    return 1;
                } else if (playerVO1.gmSc == playerVO2.gmSc) {
                    return 0;
                } else {
                    return -1;
                }
            case "offendReboundEfficient":
                if (playerVO1.offendReboundEfficient > playerVO2.offendReboundEfficient) {
                    return 1;
                } else if (playerVO1.offendReboundEfficient == playerVO2.offendReboundEfficient) {
                    return 0;
                } else {
                    return -1;
                }
            case "realShot":
                if (playerVO1.realShot > playerVO2.realShot) {
                    return 1;
                } else if (playerVO1.realShot == playerVO2.realShot) {
                    return 0;
                } else {
                    return -1;
                }
            case "reboundEfficient":
                if (playerVO1.reboundEfficient > playerVO2.reboundEfficient) {
                    return 1;
                } else if (playerVO1.reboundEfficient == playerVO2.reboundEfficient) {
                    return 0;
                } else {
                    return -1;
                }
            case "shotEfficient":
                if (playerVO1.shotEfficient > playerVO2.shotEfficient) {
                    return 1;
                } else if (playerVO1.shotEfficient == playerVO2.shotEfficient) {
                    return 0;
                } else {
                    return -1;
                }
            case "stealEfficient":
                if (playerVO1.stealEfficient > playerVO2.stealEfficient) {
                    return 1;
                } else if (playerVO1.stealEfficient == playerVO2.stealEfficient) {
                    return 0;
                } else {
                    return -1;
                }

        }
        return 0;
    }

    @Override
    public ArrayList<PlayerVO> sortPlayerHigh(ArrayList<sortParam> sortBy) {
        ArrayList<PlayerVO> playerVOs = new PlayerDataManager().getPlayerVOs(getHighInfo(), PlayerDataManager.DEFAULT);
        playerVOs.sort(new ComparePlayVO(sortBy));
        return playerVOs;
    }

    @Override
    public ArrayList<PlayerVO> filterInfo(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE) {
        return filter(getInformation(), sortBy, position, league, numS, numE);
    }

    @Override
    public ArrayList<PlayerVO> filterNormal(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE) {
        return filter(getNormalInfo(), sortBy, position, league, numS, numE);
    }

    @Override
    public ArrayList<PlayerVO> filterNormalAvg(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE) {
        return filter(getAvgNormalInfo(), sortBy, position, league, numS, numE);
    }

    @Override
    public ArrayList<PlayerVO> filterHigh(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE) {
        return filter(getHighInfo(), sortBy, position, league, numS, numE);
    }

    private ArrayList<PlayerVO> filter(ArrayList<String> attributes, ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE) {
        ArrayList<PlayerVO> playerVOs = new PlayerDataManager().getPlayerVOs(attributes, PlayerDataManager.DEFAULT);
        ArrayList<PlayerVO> res = new ArrayList<>();
        for (int i = 0; i < playerVOs.size(); i++) {
            if (isInPosition(position, playerVOs.get(i)) && isInLeague(league, playerVOs.get(i)) && isInAge(numS, numE, playerVOs.get(i))) {
                res.add(playerVOs.get(i));
            }
        }

        res.sort(new ComparePlayVO(sortBy));
        return res;
    }

    private boolean isInPosition(ArrayList<String> position, PlayerVO playerVO) {
        for (int i = 0; i < position.size(); i++) {
            if (isInPosition(position.get(i), playerVO)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isInPosition(String position, PlayerVO playerVO) {
        if (position.length() != 1) {
            return false;
        } else if (position.equals("-") == false) {
            return playerVO.position.contains(position);
        } else {
            return false;
        }
    }

    private boolean isInLeague(ArrayList<String> league, PlayerVO playerVO) {
        for (int i = 0; i < league.size(); i++) {
            if (isInLeague(league.get(i), playerVO)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isInLeague(String league, PlayerVO playerVO) {
        if (league.equals(String.valueOf(playerVO.league)))
            return true;
        else
            return false;
    }

    private boolean isInAge(int numS, int numE, PlayerVO playerVO) {
        if (numE == -1) {
            if (playerVO.age >= numS) {
                return true;
            } else {
                return false;
            }
        } else {
            if (playerVO.age >= numS && playerVO.age < numE) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public ArrayList<HotPlayersVO> DailyKing(int num, String sortBy) {
        ArrayList<HotPlayersVO> arrayList = new PlayerDataManager().getHotPlayers(sortBy, PlayerDataManager.DATE);
        arrayList.sort(new Comparator<HotPlayersVO>() {
            @Override
            public int compare(HotPlayersVO o1, HotPlayersVO o2) {
                if (o1.value > o2.value) {
                    return 1;
                } else if (o1.value == o2.value) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        return arrayList;
    }

    @Override
    public ArrayList<HotPlayersVO> SeasonKing(int num, String sortBy) {
        ArrayList<HotPlayersVO> arrayList = new PlayerDataManager().getHotPlayers(sortBy, PlayerDataManager.DEFAULT);
        arrayList.sort(new Comparator<HotPlayersVO>() {
            @Override
            public int compare(HotPlayersVO o1, HotPlayersVO o2) {
                if (o1.value > o2.value) {
                    return 1;
                } else if (o1.value == o2.value) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        return arrayList;
    }

    @Override
    public ArrayList<HotPlayersVO> hotPlayer(int num, String sortBy) {
        ArrayList<HotPlayersVO> arrayList = new PlayerDataManager().getUpgrade(sortBy);
        arrayList.sort(new Comparator<HotPlayersVO>() {
            @Override
            public int compare(HotPlayersVO o1, HotPlayersVO o2) {
                if (o1.upgradeRate > o2.upgradeRate) {
                    return 1;
                } else if (o1.upgradeRate == o2.upgradeRate) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        return arrayList;
    }

    @Override
    public PlayerVO avgLeague() {
        return null;
    }

}

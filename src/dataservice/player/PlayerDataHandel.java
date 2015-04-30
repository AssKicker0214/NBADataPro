package dataservice.player;

import data.saver.PlayerScoreSaver;
import vo.playervo.HotPlayersVO;
import vo.playervo.PlayerVO;

import java.util.ArrayList;

/**
 * Created by chenghao on 15/4/30.
 */
public class PlayerDataHandel implements PlayerDataService {
    private PlayerScoreSaver playerScoreSaver;
    private PlayerScoreSaver.PlayerData playerDataDefault;
    private PlayerScoreSaver.PlayerData playerDataL5;
    private PlayerScoreSaver.PlayerData playerDataBefore;

    @Override
    public PlayerVO findPlayerData(int playerId, boolean isAvg) {
        return null;
    }

    @Override
    public ArrayList<PlayerVO> findPlayerNormal(boolean isAvg) {
        return null;
    }

    @Override
    public ArrayList<PlayerVO> findPlayerHigh(boolean isAvg) {
        return null;
    }

    @Override
    public ArrayList<PlayerVO> sortPlayerNormal(ArrayList<sortParam> sortBy, boolean isAvg) {
        return null;
    }

    @Override
    public ArrayList<PlayerVO> sortPlayerHigh(ArrayList<sortParam> sortBy) {
        return null;
    }

    @Override
    public ArrayList<PlayerVO> filterNormal(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, ArrayList<String> age, int num, boolean isAvg) {
        return null;
    }

    @Override
    public ArrayList<PlayerVO> filterHigh(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, ArrayList<String> age, int num, boolean isAvg) {
        return null;
    }

    @Override
    public ArrayList<HotPlayersVO> DailyKing(int num, String sortBy) {
        return null;
    }

    @Override
    public ArrayList<HotPlayersVO> SeasonKing(int num, String sortBy) {
        return null;
    }

    @Override
    public ArrayList<HotPlayersVO> hotPlayer(int num, String sortBy) {
        return null;
    }

    @Override
    public PlayerVO avgLeague(ArrayList<String> attributes) {
        return null;
    }
}

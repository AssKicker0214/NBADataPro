package dataservice.match;

import data.MatchManager;
import data.PlayerDataManager;
import vo.matchvo.MatchContentPlayerVO;
import vo.matchvo.MatchVO;

import java.util.ArrayList;

/**
 * Created by chenghao on 15/5/4.
 */
public class MatchDataHandel implements MatchDataService {

    @Override
    public ArrayList<MatchContentPlayerVO> FindRecentMatches_p(int num, String playerName) {
        ArrayList<Integer> intS = new PlayerDataManager().getFindRecentMatches_p(playerName);
        ArrayList<MatchContentPlayerVO> res = new ArrayList<>();
        for(int i = 0; i < intS.size();i++){
            res.add(new MatchManager().getMatchVO(intS.get(i)));
        }
        return res;
    }

    @Override
    public ArrayList<MatchVO> FindRecentMatches_t(int num, String teamName) {
        return null;
    }

    @Override
    public MatchVO findMatch(int matchID) {
        return null;
    }

    @Override
    public ArrayList<MatchVO> findByDate(String start, String end) {
        return null;
    }

    @Override
    public ArrayList<MatchContentPlayerVO> findByDP(String start, String end, String playerName) {
        return null;
    }

    @Override
    public ArrayList<MatchVO> findByDT(String start, String end, String teamName) {
        return null;
    }
}

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
            res.add(new MatchManager().getMatchContentPlayerVO(intS.get(i)));
        }
        return res;
    }

    @Override
    public ArrayList<MatchVO> FindRecentMatches_t( String teamName) {
        ArrayList<Integer> intS = new MatchManager().getFindRecentMatches_t(teamName);
        ArrayList<MatchVO> res = new ArrayList<>();
        for(int i = 0; i < intS.size();i++){
            res.add(new MatchManager().getMatchVO(intS.get(i)));
        }
        return res;
    }

    @Override
    public MatchVO findMatch(int matchID) {
        return new MatchManager().getMatchVO(matchID);
    }

    @Override
    public ArrayList<MatchVO> findByDate(String start, String end) {
        return new MatchManager().findByDate(start,end);
    }

    @Override
    public ArrayList<MatchContentPlayerVO> findByDP(String start, String end, String playerName) {
        return new MatchManager().findByDP( start,  end, playerName);
    }

    @Override
    public ArrayList<MatchVO> findByDT(String start, String end, String teamName) {
        return new MatchManager().findByDT(start, end, teamName);
    }
}

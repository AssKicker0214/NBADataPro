package dataservice.match;

import vo.matchvo.MatchVO;

import java.util.ArrayList;

/**
 * Created by chenghao on 15/5/4.
 */
public class MatchDataHandel implements MatchDataService{

    @Override
    public ArrayList<MatchVO> FindRecentMatches_p(int num, int playerID) {
        return null;
    }

    @Override
    public ArrayList<MatchVO> FindRecentMatches_t(int num, int teamId) {
        return null;
    }

    @Override
    public ArrayList<MatchVO> findByDate(String start, String end) {
        return null;
    }

    @Override
    public ArrayList<MatchVO> findByDP(String start, String end, int playerID) {
        return null;
    }

    @Override
    public ArrayList<MatchVO> findByDT(String start, String end, int teamId) {
        return null;
    }
}

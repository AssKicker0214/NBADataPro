package data.saver;

import vo.matchvo.MatchVO;

import java.util.ArrayList;

/**
 * Created by chenghao on 15/5/4.
 */
public class MatchManager {
    private MatchInfoSaver matchInfoSaver;
    private MatchScoreSaver matchScoreSaver;

    private MatchVO getMatchVO(int mid){
        MatchVO matchVO = new MatchVO();
        matchVO.id = mid;
        matchVO.date = matchInfoSaver.getDate(mid);

        ArrayList<TeamScore> teamScores = matchScoreSaver.getTeamScores(mid);

        matchVO.homePoint = matchInfoSaver.getHomePoint()[mid - 1];
    }
}

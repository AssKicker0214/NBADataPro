package data.saver;

import data.TeamDataManager;
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
        matchVO.guestPoint = matchInfoSaver.getGuestPoint()[mid - 1];

        matchVO.homePoint_1 = teamScores.get(0).score1;
        matchVO.homePoint_2 = teamScores.get(1).score1;
        matchVO.homePoint_3 = teamScores.get(2).score1;
        matchVO.homePoint_4 = teamScores.get(3).score1;

        matchVO.guestPoint_1 = teamScores.get(0).score2;
        matchVO.guestPoint_2 = teamScores.get(1).score2;
        matchVO.guestPoint_3 = teamScores.get(2).score2;
        matchVO.guestPoint_4 = teamScores.get(3).score2;

        int tid1 = matchInfoSaver.getTeamf()[mid];
        int tid2 = matchInfoSaver.getTeaml()[mid];

//        matchVO.homeTeam = new TeamDataManager()
        new TeamDataManager();
        return matchVO;
    }
}

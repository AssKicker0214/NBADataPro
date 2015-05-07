package data;

import data.input.Match;
import data.input.Team;
import data.saver.*;
import vo.matchvo.MatchContentPlayerVO;
import vo.matchvo.MatchVO;

import java.util.ArrayList;

/**
 * Created by chenghao on 15/5/4.
 */
public class MatchManager {
    private MatchInfoSaver matchInfoSaver;
    private MatchScoreSaver matchScoreSaver;
    private PlayerScoreSaver playerScoreSaver;
    private TeamSaver teamSaver;

    public MatchManager() {
        this.matchInfoSaver = MatchInfoSaver.getMatchInfoSaver();
        this.matchScoreSaver = MatchScoreSaver.getMatchScoreSaver();
        this.playerScoreSaver = PlayerScoreSaver.getPlayerScoreSaver();
        this.teamSaver = TeamSaver.getTeamSaver();
    }

    public MatchVO getMatchVO(int mid){
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

        int tid1 = matchInfoSaver.getTeamf()[mid-1];
        int tid2 = matchInfoSaver.getTeaml()[mid-1];

        matchVO.homeTeam = new TeamDataManager().getInfo(tid1);
        matchVO.guestTeam = new TeamDataManager().getInfo(tid2);
        ArrayList<MatchContentPlayerVO>[] arrayLists = playerScoreSaver.getTeamPlayer(mid);
        matchVO.homeTeamPlayer = arrayLists[0];
        matchVO.guestTeamPlayer = arrayLists[1];
        return matchVO;
    }

    public MatchContentPlayerVO getMatchContentPlayerVO(int i) {
        return playerScoreSaver.getMatchContentPlayerVO(i);
    }

    public ArrayList<Integer> getFindRecentMatches_t(String teamName) {
        int tid = teamSaver.getTeamId(teamName);
        return matchInfoSaver.getFindRecentMatches_t(tid);
    }

    public ArrayList<MatchVO> findByDate(String start, String end) {
        ArrayList<Integer> arrayList = matchInfoSaver.getMids(start,end);
        ArrayList<MatchVO> matchVOs = new ArrayList<>();
        for (int i = 0; i < arrayList.size();i++){
            matchVOs.add(getMatchVO(arrayList.get(i)));
        }
        return matchVOs;
    }

    public ArrayList<MatchContentPlayerVO> findByDP(String start, String end, String playerName) {
        ArrayList<Integer> intS = new PlayerDataManager().getFindMatches_p(start, end, playerName);
        ArrayList<MatchContentPlayerVO> res = new ArrayList<>();
        for (int i = 0; i < intS.size();i++){
            res.add(getMatchContentPlayerVO(intS.get(i)));
        }
        return res;
    }

    public ArrayList<MatchVO> findByDT(String start, String end, String teamName) {
        ArrayList<Integer> intS = getFindMatches_t(start, end, teamName);
        ArrayList<MatchVO> res = new ArrayList<>();
        for (int i = 0; i < intS.size();i++){
            res.add(getMatchVO(intS.get(i)));
        }
        return res;
    }

    private ArrayList<Integer> getFindMatches_t(String start, String end, String teamName) {
        int tid = teamSaver.getTeamId(teamName);
        return matchInfoSaver.getFindMatches_t(start,end,tid);
    }

    public ArrayList<MatchVO> findRecent20() {
//        MatchInfoSaver.getMatchInfoSaver().show();
        ArrayList<Integer> intS = MatchInfoSaver.getMatchInfoSaver().findRecent20();
        int length = intS.size() > 20?20:intS.size();
        ArrayList<MatchVO> arrayList = new ArrayList<>();
        for (int i = 0;i<length;i++){
//            System.out.println(intS.get(i));
            arrayList.add(getMatchVO(intS.get(i) + 1));
        }
        return arrayList;
    }
}

package data.saver;

import java.util.ArrayList;

/**
 * Created by chenghao on 15/4/26.
 */
public class MatchScoreSaver {
    private long lastModifiedTime;
    private int currentPoint;
    private int[] mid;
    private int[] mindex;
    private int[] scoref;
    private int[] scorel;

    private static MatchScoreSaver matchScoreSaver;
    public static MatchScoreSaver getMatchScoreSaver(){
        if (matchScoreSaver == null){
            matchScoreSaver = new MatchScoreSaver();
        }
        return matchScoreSaver;
    }

    private MatchScoreSaver(){
        int size = 10000;
        mid = new int[size];
        mindex = new int[size];
        scoref = new int[size];
        scorel = new int[size];
        currentPoint = -1;
        refreshTime();
    }


    /**
     * When the data modified,update the lastModifiedTime
     */
    private void refreshTime() {
        lastModifiedTime = System.currentTimeMillis();
    }

    public boolean insert(String[] ss){
        int m_mid = -1;
        try {
            m_mid = ss[0] == null ? -1 : Integer.parseInt(ss[0].trim());
        } catch (Exception e) {

        }
        int m_mindex = -1;
        try {
            m_mindex = ss[1] == null ? -1 : Integer.parseInt(ss[1].trim());
        } catch (Exception e) {

        }
        int m_scoref = -1;
        try {
            m_scoref = ss[2] == null ? -1 : Integer.parseInt(ss[2].trim());
        } catch (Exception e) {

        }
        int m_scorel = -1;
        try {
            m_scorel = ss[3] == null ? -1 : Integer.parseInt(ss[3].trim());
        } catch (Exception e) {

        }
        currentPoint++;
        mid[currentPoint] = m_mid;
        mindex[currentPoint] = m_mindex;
        scoref[currentPoint] = m_scoref;
        scorel[currentPoint] = m_scorel;
        return true;
    }

    public void show(){
        for (int i = 0; i < currentPoint; i++){
            System.out.println(mid[i]+" "+ mindex[i]+" "+scoref[i]+" "+scorel[i]);
        }
    }

    public ArrayList<TeamScore> getTeamScores(int mid) {
        ArrayList<TeamScore> arrayList = new ArrayList<>();
        for (int i = 0; i< currentPoint + 1; i++){
            if (mid == this.mid[i]){
            TeamScore teamScore = new TeamScore();
            teamScore.score1 = this.scoref[i];
            teamScore.score2 = this.scorel[i];
                arrayList.add(this.mindex[i] - 1, teamScore);}
        }
        return arrayList;
    }

    public ArrayList<TeamScore>[] getAllTeamScores(){
        ArrayList<TeamScore>[] res = new ArrayList[MatchInfoSaver.getMatchInfoSaver().getNum()];
        for (int i = 0; i< currentPoint + 1; i++){
            int mid = this.mid[currentPoint];
            if (res[mid - 1] == null){
                res[mid - 1] = new ArrayList<>();
            }
            TeamScore teamScore = new TeamScore();
            teamScore.score1 = this.scoref[i];
            teamScore.score2 = this.scorel[i];
            res[mid - 1].add(this.mindex[i] - 1,teamScore);
        }
        return res;
    }
}

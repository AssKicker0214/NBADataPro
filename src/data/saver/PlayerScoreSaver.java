package data.saver;

import vo.matchvo.MatchContentPlayerVO;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by chenghao on 15/4/21.
 */
public class PlayerScoreSaver {

    private PlayerSaver playerSaver;
    private MatchInfoSaver matchInfoSaver;
    private TeamSaver teamSaver;

    public static final int DEFAULT = 1;
    public static final int L5MID = 2;
    public static final int BEFORE = 3;

    private long lastModifiedTime;
    private int currentPoint;
    private int[] mid;
    private int[] tid;
    private int[] pid;
    private String[] position;
    private int[] inplacetime;
    private int[] throwin;
    private int[] throwall;
    private int[] throw3in;
    private int[] throw3all;
    private int[] penaltyin;
    private int[] penaltyall;
    private int[] attackbas;
    private int[] defencebas;
    private int[] allbas;
    private int[] helpatt;
    private int[] interp;
    private int[] block;
    private int[] mistake;
    private int[] foul;
    private int[] score;
    private int[] serialid;
    private int[] d_tid;

    public void show() {
        for (int i = 0; i <= currentPoint; i++){
            System.out.println(mid[i] + " "+tid[i]+" "+pid[i]+" "
                + position[i]+" " + inplacetime[i]+" "+throwin[i]+" "+
            throwall[i]+" "+throw3in[i]+" "+throw3all[i]+" "+penaltyin[i]+" "+
            penaltyall[i]+" "+attackbas[i]+" "+defencebas[i]+" "+allbas[i]+" "+
            helpatt[i]+" "+ interp[i]+" "+block[i]+" "+mistake[i]+" "+foul[i]+" "
            +score[i]+" "+serialid[i]+" "+d_tid[i]);
        }
////        int sumFoul = 0;
//        for (int i = 0; i < pidDefaultMid.length; i++) {
//            System.out.println(i + " " + pidDefaultMid[i]);
//        }
//        System.out.println("----------------------");
    }

    private static PlayerScoreSaver playerScoreSaver;

    public static PlayerScoreSaver getPlayerScoreSaver() {
        if (playerScoreSaver == null) {
            playerScoreSaver = new PlayerScoreSaver(PlayerSaver.getPlayerSaver(),
                    MatchInfoSaver.getMatchInfoSaver(), TeamSaver.getTeamSaver());
        }
        return playerScoreSaver;
    }

    private PlayerScoreSaver(PlayerSaver playerSaver,
                             MatchInfoSaver matchInfoSaver,
                             TeamSaver teamSaver) {

        this.playerSaver = playerSaver;
        this.matchInfoSaver = matchInfoSaver;
        this.teamSaver = teamSaver;

        int size = 300000;
        mid = new int[size];
        tid = new int[size];
        pid = new int[size];
        position = new String[size];
        inplacetime = new int[size];
        throwin = new int[size];
        throwall = new int[size];
        throw3in = new int[size];
        throw3all = new int[size];
        penaltyin = new int[size];
        penaltyall = new int[size];
        attackbas = new int[size];
        defencebas = new int[size];
        allbas = new int[size];
        helpatt = new int[size];
        interp = new int[size];
        block = new int[size];
        mistake = new int[size];
        foul = new int[size];
        score = new int[size];
        serialid = new int[size];
        d_tid = new int[size];
        currentPoint = -1;
        refreshTime();
    }

    private PlayerData playerDataDefault;
    private PlayerData playerDataL5;
    private PlayerData playerDataBefore;

    public PlayerData getPlayerDataDefault() {
        return playerDataDefault;
    }

    public PlayerData getPlayerDataL5() {
        return playerDataL5;
    }

    public PlayerData getPlayerDataBefore() {
        return playerDataBefore;
    }

    public TeamData getTeamDataDefault() {
        return teamDataDefault;
    }

    public TeamData getTeamDataL5() {
        return teamDataL5;
    }

    public TeamData getTeamDataBefore() {
        return teamDataBefore;
    }

    private TeamData teamDataDefault;
    private TeamData teamDataL5;
    private TeamData teamDataBefore;


    public void update() {
        setPidL5Mid();
        setPidBeforeMid();
        playerDataDefault = new PlayerData(pidDefaultMid, pidDefaultMid.length);
        teamDataDefault = new TeamData(DEFAULT, pidDefaultMid, pidDefaultMid.length);


        playerDataL5 = new PlayerData(pidL5Mid.getPointInL5Mid(), pidL5Mid.getLength());
        playerDataBefore = new PlayerData(pidBeforeMid, pidBeforeMid.length);
        teamDataL5 = new TeamData(L5MID, pidL5Mid.getPointInL5Mid(), pidL5Mid.getLength());
        teamDataBefore = new TeamData(BEFORE, pidBeforeMid, pidBeforeMid.length);
    }

    /**
     * 插入一条球员比赛记录
     *
     * @param ss String[] 应插入的数据，用字符串数组表示
     */
    public void insert(String[] ss) {
        int m_mid = -1;
        try {
            m_mid = ss[0] == null ? -1 : Integer.parseInt(ss[0].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_tid = -1;
        try {
            m_tid = ss[1] == null ? -1 : Integer.parseInt(ss[1].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_pid = -1;
        try {
            m_pid = ss[2] == null ? -1 : Integer.parseInt(ss[2].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String m_position = ss[3] == null ? null : ss[3].trim();
        int m_inplacetime = changeTime(ss[4] == null ? null : ss[4].trim());

        int m_throwin = -1;
        try {
            m_throwin = ss[5] == null ? -1 : Integer.parseInt(ss[5].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_throwall = -1;
        try {
            m_throwall = ss[6] == null ? -1 : Integer.parseInt(ss[6].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_throw3in = -1;
        try {
            m_throw3in = ss[7] == null ? -1 : Integer.parseInt(ss[7].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_throw3all = -1;
        try {
            m_throw3all = ss[8] == null ? -1 : Integer.parseInt(ss[8].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_penaltyin = -1;
        try {
            m_penaltyin = ss[9] == null ? -1 : Integer.parseInt(ss[9].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_penaltyall = -1;
        try {
            m_penaltyall = ss[10] == null ? -1 : Integer.parseInt(ss[10].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_attackbas = -1;
        try {
            m_attackbas = ss[11] == null ? -1 : Integer.parseInt(ss[11].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_defencebas = -1;
        try {
            m_defencebas = ss[12] == null ? -1 : Integer.parseInt(ss[12].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_allbas = -1;
        try {
            m_allbas = ss[13] == null ? -1 : Integer.parseInt(ss[13].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_helpatt = -1;
        try {
            m_helpatt = ss[14] == null ? -1 : Integer.parseInt(ss[14].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_interp = -1;
        try {
            m_interp = ss[15] == null ? -1 : Integer.parseInt(ss[15].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_block = -1;
        try {
            m_block = ss[16] == null ? -1 : Integer.parseInt(ss[16].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_mistake = -1;
        try {
            m_mistake = ss[17] == null ? -1 : Integer.parseInt(ss[17].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_foul = -1;
        try {
            m_foul = ss[18] == null ? -1 : Integer.parseInt(ss[18].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_score = -1;
        try {
            m_score = ss[19] == null ? -1 : Integer.parseInt(ss[19].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_serialid = -1;
        try {
            m_serialid = ss[20] == null ? -1 : Integer.parseInt(ss[20].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m_d_tid = -1;
        try {
            m_d_tid = ss[21] == null ? -1 : Integer.parseInt(ss[21].trim());
        } catch (Exception e) {
            e.printStackTrace();
        }

        currentPoint++;
        mid[currentPoint] = m_mid;
        tid[currentPoint] = m_tid;
        pid[currentPoint] = m_pid;
        position[currentPoint] = m_position;
        inplacetime[currentPoint] = m_inplacetime;
        throwin[currentPoint] = m_throwin;
        throwall[currentPoint] = m_throwall;
        throw3in[currentPoint] = m_throw3in;
        throw3all[currentPoint] = m_throw3all;
        penaltyin[currentPoint] = m_penaltyin;
        penaltyall[currentPoint] = m_penaltyall;
        attackbas[currentPoint] = m_attackbas;
        defencebas[currentPoint] = m_defencebas;
        allbas[currentPoint] = m_allbas;
        helpatt[currentPoint] = m_helpatt;
        interp[currentPoint] = m_interp;
        block[currentPoint] = m_block;
        mistake[currentPoint] = m_mistake;
        foul[currentPoint] = m_foul;
        score[currentPoint] = m_score;
        serialid[currentPoint] = m_serialid;
        d_tid[currentPoint] = m_d_tid;
        refreshTime();
    }

    private int changeTime(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        String[] ss = s.split(":");
        int res = Integer.parseInt(ss[1].trim());
        res = res * 60 + Integer.parseInt(ss[2].trim());
        return res;
    }

    private void refreshTime() {
        lastModifiedTime = System.currentTimeMillis();
    }

    public PlayerData getPlayerData(String date) {
        return new PlayerData(date);
    }

    public ArrayList<Integer> getMidPoint(String start, String end, int pid) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= currentPoint; i++) {
            if (pid == this.pid[i] && matchInfoSaver.isInDate(mid[i], start, end)) {
                System.out.println(mid[i]+"-------------------mid "+this.pid[i]+" --------"+MatchInfoSaver.getMatchInfoSaver().getDate(mid[i]));
                res.add(i);
            }
        }
        return res;
    }

    private class PidL5Mid {

        private long lastModifiedTime;
        private int length;
        private int size;
        private int[] pid;
        private int pid_point;
        private int[] mid;
        private int[] pointInL5Mid;

        private PidL5Mid() {
            System.out.println("-------------------------- create pid l5 mid------------");
            size = playerSaver.getNum() * 5;
            pid = new int[size];
            mid = new int[size];
            pointInL5Mid = new int[size];
            pid_point = -1;
            length = 0;
            for (int i = 0; i <= currentPoint; i++) {
                insert(i);
            }
        }


        /**
         * 插入一条记录
         *
         * @param m
         */
        private void insert(int m) {
            int pid = PlayerScoreSaver.this.pid[m];
            int mid = PlayerScoreSaver.this.mid[m];
            int[] arrayList = new int[5];
            int size = 0;
            String date = matchInfoSaver.getDate(mid);
            for (int i = 0; i <= pid_point; i++) {
                if (this.pid[i] == pid) {

                    arrayList[size] = i;
                    size++;
                    if (size == 5)
                        break;
                }
            }

            if (size < 5) {
                if (pid_point < this.size - 1) {
                    pid_point++;
                    length++;
                    this.pid[pid_point] = pid;
                    this.mid[pid_point] = mid;
                    this.pointInL5Mid[pid_point] = m;
                }
                return;
            }

            int temp = arrayList[0];
            for (int i = 0; i < size; i++) {
                int a = arrayList[i];
                if (matchInfoSaver.getDate(this.mid[temp]).compareTo(matchInfoSaver.getDate(this.mid[a])) > 0) {
                    temp = a;
                }
            }

            if (date.compareTo(matchInfoSaver.getDate(this.mid[temp])) > 0) {
                this.pid[temp] = pid;
                this.mid[temp] = mid;
                pointInL5Mid[temp] = m;
            }
        }

        /**
         * 判断第i条记录是否在最新五场比赛中
         *
         * @param m
         * @return
         */
        public boolean isInPointInL5Mid(int m) {
            for (int i = 0; i < this.length; i++) {
                if (m == pidL5Mid.pointInL5Mid[i])
                    return true;
            }
            return false;
        }

        /**
         * 返回上次修改时间
         *
         * @return
         */
        public long getLastModifiedTime() {
            return lastModifiedTime;
        }

        public int getLength() {
            return length;
        }

        public int[] getPointInL5Mid() {
            return pointInL5Mid;
        }

        public void show(PrintStream printStream) {
            for (int i = 0; i <= pid_point; i++) {
                printStream.println(pid[i] + " " + mid[i]);
            }
        }
    }

    public ArrayList<Integer> getL5MidPoint(int pid) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        PidL5Mid pidL5Mid = getPidL5Mid();
        for (int i = 0; i < pidL5Mid.getLength(); i++) {
            if (pidL5Mid.pid[i] == pid) {
                arrayList.add(pidL5Mid.getPointInL5Mid()[i]);
            }
        }
        return arrayList;
    }

    private PidL5Mid pidL5Mid;
    private boolean pidL5MidFlag = false;

    /**
     * 数据插入完成后计算最新五场比赛信息表
     */
    public void setPidL5Mid() {
        if (pidL5Mid == null)
            pidL5Mid = new PidL5Mid();
        else if (pidL5Mid.getLastModifiedTime() < this.lastModifiedTime)
            pidL5Mid = new PidL5Mid();

        pidL5MidFlag = true;
    }

    /**
     * 获得最新五场比赛表
     *
     * @return
     */
    public PidL5Mid getPidL5Mid() {
        setPidL5Mid();
        return pidL5Mid;
    }

    private int[] pidDefaultMid;

    public int[] getPidDefaultMid() {
        return pidDefaultMid;
    }

    private int[] pidBeforeMid;

    /**
     * 默认比赛信息表
     */
    public void setPidBeforeMid() {
        pidDefaultMid = new int[currentPoint + 1];
//        System.out.println(pidL5Mid.getLength());
        pidBeforeMid = new int[pidDefaultMid.length - pidL5Mid.getLength()];
        int m = 0;
        for (int i = 0; i <= currentPoint; i++) {
            pidDefaultMid[i] = i;
            if (!pidL5Mid.isInPointInL5Mid(i)) {
                pidBeforeMid[m] = i;
                m++;
            }
        }
    }

    public int[] getPidBeforeMid() {
        return pidBeforeMid;
    }

    //----------------------------team 数据计算----------------------------------------------//
    public class TeamData {

        private long lastModifiedTime;

        private int[] a_throwin;
        private int[] a_throwall;
        private int[] a_throw3in;
        private int[] a_throw3all;
        private int[] a_penaltyin;
        private int[] a_penaltyall;
        private int[] a_attackbas;
        private int[] a_defencebas;
        private int[] a_allbas;
        private int[] a_helpatt;
        private int[] a_interp;
        private int[] a_mistake;
        private int[] a_foul;
        private int[] a_score;
        private int[] a_matchNum;
        private int[] a_winNum;
        private int[] b_throwin;
        private int[] b_throwall;
        private int[] b_penaltyall;
        private int[] b_attackbas;
        private int[] b_defencebas;
        private int[] b_mistake;
        private int[] b_score;
        private int type;

        private double[] FGP;
        private double[] TPSP;
        private double[] FTP;
        private double[] leg;
        private double[] legB;
        private double[] assistP;
        private double[] stealP;
        private double[] ORtg;
        private double[] DRtg;
        private double[] avgAssist;
        private double[] avgBlockShot;
        private double[] avgDefendRebound;
        private double[] avgFault;
        private double[] avgFoul;
        private double[] avgOffendRebound;
        private double[] avgPoint;
        private double[] avgRebound;
        private double[] avgSteal;
        private double[] defendReboundEfficient;
        private double[] offendReboundEfficient;
        private double[] winRate;

        private void setTeamDataLevel2() {
            FGP = new double[teamSaver.getNum()];
            TPSP = new double[teamSaver.getNum()];
            leg = new double[teamSaver.getNum()];
            legB = new double[teamSaver.getNum()];
            assistP = new double[teamSaver.getNum()];
            stealP = new double[teamSaver.getNum()];
            ORtg = new double[teamSaver.getNum()];
            DRtg = new double[teamSaver.getNum()];
            FTP = new double[teamSaver.getNum()];
            avgAssist = new double[teamSaver.getNum()];
            avgBlockShot = new double[teamSaver.getNum()];
            avgDefendRebound = new double[teamSaver.getNum()];
            avgFault = new double[teamSaver.getNum()];
            avgFoul = new double[teamSaver.getNum()];
            avgOffendRebound = new double[teamSaver.getNum()];
            avgPoint = new double[teamSaver.getNum()];
            avgRebound = new double[teamSaver.getNum()];
            avgSteal = new double[teamSaver.getNum()];
            defendReboundEfficient = new double[teamSaver.getNum()];
            offendReboundEfficient = new double[teamSaver.getNum()];
            winRate = new double[teamSaver.getNum()];
            avgSteal = new double[teamSaver.getNum()];
            avgSteal = new double[teamSaver.getNum()];

            FTP = new double[teamSaver.getNum()];
            FTP = new double[teamSaver.getNum()];
            FTP = new double[teamSaver.getNum()];
            for (int i = 0; i < teamSaver.getNum(); i++) {
                FGP[i] = ((double) a_throwin[i]) / a_throwall[i];
                TPSP[i] = ((double) a_throw3in[i]) / a_throw3all[i];
//                System.out.println("id:"+i+" "+a_throwall[i]+" "+a_penaltyall[i]+" "+a_attackbas[i]+" "+ b_defencebas[i]+" "+a_throwall[i]+" "+a_throwin[i]+" "+a_mistake[i]);
                leg[i] = a_throwall[i] + 0.4 * a_penaltyall[i] - 1.07 * ((double) a_attackbas[i] / (a_attackbas[i] + b_defencebas[i])) * (double) (a_throwall[i] - a_throwin[i]) + 1.07 * a_mistake[i];
                legB[i] = b_throwall[i] + 0.4 * b_penaltyall[i] - 1.07 * ((double) b_attackbas[i] / (b_attackbas[i] + a_defencebas[i])) * (double) (b_throwall[i] - b_throwin[i]) + 1.07 * b_mistake[i];
                assistP[i] = 100 * a_helpatt[i] / leg[i];
                stealP[i] = 100 * a_interp[i] / legB[i];
                ORtg[i] = 100 * a_score[i] / leg[i];
                DRtg[i] = 100 * b_score[i] / legB[i];
                FTP[i] = ((double) a_penaltyin[i]) / a_penaltyall[i];
                defendReboundEfficient[i] = ((double) a_defencebas[i]) / (a_defencebas[i] + b_attackbas[i]);
                offendReboundEfficient[i] = ((double) a_attackbas[i]) / (a_attackbas[i] + b_defencebas[i]);
                winRate[i] = ((double) a_winNum[i]) / (a_matchNum[i]);
//                    System.out.println("id:"+i+" "+a_winNum[i]+" "+a_matchNum[i]+" "+winRate[i]);
                avgAssist[i] = ((double) a_helpatt[i]) / a_matchNum[i];
                avgBlockShot[i] = ((double) a_block[i]) / a_matchNum[i];
                avgDefendRebound[i] = ((double) a_defencebas[i]) / a_matchNum[i];
                avgFault[i] = ((double) a_mistake[i]) / a_matchNum[i];
                avgOffendRebound[i] = ((double) a_attackbas[i]) / a_matchNum[i];
                avgPoint[i] = ((double) a_score[i]) / a_matchNum[i];
                avgRebound[i] = ((double) a_allbas[i]) / a_matchNum[i];
                avgSteal[i] = ((double) a_interp[i]) / a_matchNum[i];
                avgFoul[i] = ((double) a_foul[i]) / a_matchNum[i];
            }
        }

        private int[] a_block;

        private void setTeamDataLevel1() {

            a_throwin = new int[teamSaver.getNum()];
            a_throwall = new int[teamSaver.getNum()];
            a_throw3in = new int[teamSaver.getNum()];
            a_throw3all = new int[teamSaver.getNum()];
            a_penaltyin = new int[teamSaver.getNum()];
            a_penaltyall = new int[teamSaver.getNum()];
            a_attackbas = new int[teamSaver.getNum()];
            a_defencebas = new int[teamSaver.getNum()];
            a_allbas = new int[teamSaver.getNum()];
            a_helpatt = new int[teamSaver.getNum()];
            a_interp = new int[teamSaver.getNum()];
            a_mistake = new int[teamSaver.getNum()];
            a_foul = new int[teamSaver.getNum()];
            a_score = new int[teamSaver.getNum()];
            a_block = new int[teamSaver.getNum()];

            int[][] match_temp = matchInfoSaver.getMatchNum(type);
            a_matchNum = match_temp[1];
            a_winNum = match_temp[0];
            b_throwin = new int[teamSaver.getNum()];
            b_throwall = new int[teamSaver.getNum()];
            b_penaltyall = new int[teamSaver.getNum()];
            b_attackbas = new int[teamSaver.getNum()];
            b_defencebas = new int[teamSaver.getNum()];
            b_mistake = new int[teamSaver.getNum()];
            b_score = new int[teamSaver.getNum()];

            for (int j = 0; j < length; j++) {
                int i = points[j];
                    int tid = PlayerScoreSaver.this.tid[i];
                    int d_tid = PlayerScoreSaver.this.d_tid[i];
                    if (PlayerScoreSaver.this.throwin[i] > 0){
                        a_throwin[tid - 1] = a_throwin[tid - 1] + PlayerScoreSaver.this.throwin[i];
                        b_throwin[d_tid - 1] = b_throwin[d_tid - 1] + PlayerScoreSaver.this.throwin[i];
                    }
                if (PlayerScoreSaver.this.throwall[i] > 0){
                    a_throwall[tid - 1] = a_throwall[tid - 1] + PlayerScoreSaver.this.throwall[i];
                    b_throwall[d_tid - 1] = b_throwall[d_tid - 1] + PlayerScoreSaver.this.throwall[i];
                }
                if (PlayerScoreSaver.this.throw3in[i] > 0)
                    a_throw3in[tid - 1] = a_throw3in[tid - 1] + PlayerScoreSaver.this.throw3in[i];
                if (PlayerScoreSaver.this.throw3all[i] > 0)
                    a_throw3all[tid - 1] = a_throw3all[tid - 1] + PlayerScoreSaver.this.throw3all[i];
                if (PlayerScoreSaver.this.penaltyin[i] > 0)
                    a_penaltyin[tid - 1] = a_penaltyin[tid - 1] + PlayerScoreSaver.this.penaltyin[i];
                if (PlayerScoreSaver.this.penaltyall[i] > 0){
                    a_penaltyall[tid - 1] = a_penaltyall[tid - 1] + PlayerScoreSaver.this.penaltyall[i];
                    b_penaltyall[d_tid - 1] = b_penaltyall[d_tid - 1] + PlayerScoreSaver.this.penaltyall[i];
                }
                if (PlayerScoreSaver.this.attackbas[i] > 0){
                    a_attackbas[tid - 1] = a_attackbas[tid - 1] + PlayerScoreSaver.this.attackbas[i];
                    b_attackbas[d_tid - 1] = b_attackbas[d_tid - 1] + PlayerScoreSaver.this.attackbas[i];
                }
                if (PlayerScoreSaver.this.defencebas[i] > 0){
                    a_defencebas[tid - 1] = a_defencebas[tid - 1] + PlayerScoreSaver.this.defencebas[i];
                    b_defencebas[d_tid - 1] = b_defencebas[d_tid - 1] + PlayerScoreSaver.this.defencebas[i];
                }
                if (PlayerScoreSaver.this.allbas[i] > 0)
                    a_allbas[tid - 1] = a_allbas[tid - 1] + PlayerScoreSaver.this.allbas[i];
                if (PlayerScoreSaver.this.helpatt[i] > 0)
                    a_helpatt[tid - 1] = a_helpatt[tid - 1] + PlayerScoreSaver.this.helpatt[i];
                if (PlayerScoreSaver.this.interp[i] > 0)
                    a_interp[tid - 1] = a_interp[tid - 1] + PlayerScoreSaver.this.interp[i];
                if (PlayerScoreSaver.this.mistake[i] > 0){
                    a_mistake[tid - 1] = a_mistake[tid - 1] + PlayerScoreSaver.this.mistake[i];
                    b_mistake[d_tid - 1] = b_mistake[d_tid - 1] + PlayerScoreSaver.this.mistake[i];
                }
                if (PlayerScoreSaver.this.foul[i] > 0)
                    a_foul[tid - 1] = a_foul[tid - 1] + PlayerScoreSaver.this.foul[i];
                if (PlayerScoreSaver.this.score[i] > 0){
                    a_score[tid - 1] = a_score[tid - 1] + PlayerScoreSaver.this.score[i];
                    b_score[d_tid - 1] = b_score[d_tid - 1] + PlayerScoreSaver.this.score[i];
                }
                if (PlayerScoreSaver.this.block[i] > 0)
                    a_block[tid - 1] = a_block[tid - 1] + PlayerScoreSaver.this.block[i];
            }

        }

        private int[] points;
        private int length;

        private TeamData(int type, int[] points, int length) {
            this.points = points;
            this.type = type;
            this.length = length;
            setTeamDataLevel1();
            setTeamDataLevel2();
        }

        public int[] getAssist() {
            return a_helpatt;
        }

        public int[] getBlockShot() {
            return a_block;
        }

        public int[] getDefendRebound() {
            return a_defencebas;
        }

        public int[] getFault() {
            return a_mistake;
        }

        public int[] getFoul() {
            return a_foul;
        }

        public int[] getNumOfGame() {
            return a_matchNum;
        }

        public int[] getOffendRebound() {
            return a_attackbas;
        }

        public double[] getPenalty() {
            return FTP;
        }

        public int[] getPoint() {
            return a_score;
        }

        public int[] getRebound() {
            return a_allbas;
        }

        public double[] getShot() {
            return FGP;
        }

        public int[] getSteal() {
            return a_interp;
        }

        public double[] getThree() {
            return TPSP;
        }

        public double[] getAvgAssist() {
            return avgAssist;
        }

        public double[] getAvgBlockShot() {
            return avgBlockShot;
        }

        public double[] getAvgDefendRebound() {
            return avgDefendRebound;
        }

        public double[] getAvgFault() {
            return avgFault;
        }

        public double[] getAvgFoul() {
            return avgFoul;
        }

        public double[] getAvgOffendRebound() {
            return avgOffendRebound;
        }

        public double[] getAvgPoint() {
            return avgPoint;
        }

        public double[] getAvgRebound() {
            return avgRebound;
        }

        public double[] getAvgSteal() {
            return avgSteal;
        }

        public double[] getAssistEfficient() {
            return assistP;
        }

        public double[] getDefendEfficient() {
            return DRtg;
        }

        public double[] getDefendReboundEfficient() {
            return defendReboundEfficient;
        }

        public double[] getOffendEfficient() {
            return ORtg;
        }

        public double[] getOffendReboundEfficient() {
            return offendReboundEfficient;
        }

        public double[] getOffendRound() {
            return leg;
        }

        public double[] getStealEfficient() {
            return stealP;
        }

        public double[] getWinRate() {
            return winRate;
        }

        public int getNum() {
            return teamSaver.getNum();
        }

        public String[] getPhoto() {
            return teamSaver.getPhoto();
        }

        public String[] getTeamName() {
            return teamSaver.getTeamName();
        }

        public String[] getAbridge() {
            return teamSaver.getAbridge();
        }

        public String[] getLocation() {
            return teamSaver.getLocation();
        }

        public char[] getLeague() {
            return teamSaver.getLeague();
        }

        public String[] getDivision() {
            return teamSaver.getDivision();
        }

        public String[] getHomeCourt() {
            return teamSaver.getHomeCourt();
        }

        public int[] getFoundTime() {
            return teamSaver.getFoundTime();
        }

        public int getTeamId(String teamName) {
            return teamSaver.getTeamId(teamName);
        }
    }

    //--------------------------------------------------------------------------------------//
    public class PlayerData {

        private String date;
        private long lastModifiedTime;

        private int[] p_inplacetime;
        private int[] p_throwin;
        private int[] p_throwall;
        private int[] p_throw3in;
        private int[] p_throw3all;
        private int[] p_penaltyin;
        private int[] p_penaltyall;
        private int[] p_attackbas;
        private int[] p_defencebas;
        private int[] p_allbas;
        private int[] p_helpatt;
        private int[] p_interp;
        private int[] p_block;
        private int[] p_mistake;
        private int[] p_foul;
        private int[] p_score;
        private int[] p_throwallTeamB;
        private int[] p_throw3allTeamB;
        private int[] p_throwinTeam;
        private int[] p_throwinTeamB;
        private int[] p_allbasTeam;
        private int[] p_allbasTeamB;
        private int[] p_attackbasTeam;
        private int[] p_attackbasTeamB;
        private int[] p_defencebasTeam;
        private int[] p_defencebasTeamB;
        private int[] p_throwallTeam;
        private int[] p_throw3allTeam;
        private int[] p_penaltyallTeam;
        private int[] p_penaltyallTeamB;
        private int[] p_mistakeTeam;
        private int[] p_mistakeTeamB;
        private int[] p_inplacetimeTeam;
        private int[][] p_tid_mid;
        private int[] p_matchNum;
        private int[] p_startSession;

        private void setPlayerDataLevel2() {
            p_inplacetime = new int[playerSaver.getNum()];
            p_throwin = new int[playerSaver.getNum()];
            p_throwall = new int[playerSaver.getNum()];
            p_throw3in = new int[playerSaver.getNum()];
            p_throw3all = new int[playerSaver.getNum()];
            p_penaltyin = new int[playerSaver.getNum()];
            p_penaltyall = new int[playerSaver.getNum()];
            p_attackbas = new int[playerSaver.getNum()];
            p_defencebas = new int[playerSaver.getNum()];
            p_allbas = new int[playerSaver.getNum()];
            p_helpatt = new int[playerSaver.getNum()];
            p_interp = new int[playerSaver.getNum()];
            p_block = new int[playerSaver.getNum()];
            p_mistake = new int[playerSaver.getNum()];
            p_foul = new int[playerSaver.getNum()];
            p_score = new int[playerSaver.getNum()];
            p_inplacetimeTeam = new int[playerSaver.getNum()];
            p_throwallTeamB = new int[playerSaver.getNum()];
            p_throw3allTeamB = new int[playerSaver.getNum()];
            p_throwinTeam = new int[playerSaver.getNum()];
            p_throwinTeamB = new int[playerSaver.getNum()];
            p_allbasTeam = new int[playerSaver.getNum()];
            p_allbasTeamB = new int[playerSaver.getNum()];
            p_attackbasTeam = new int[playerSaver.getNum()];
            p_attackbasTeamB = new int[playerSaver.getNum()];
            p_defencebasTeam = new int[playerSaver.getNum()];
            p_defencebasTeamB = new int[playerSaver.getNum()];
            p_throwallTeam = new int[playerSaver.getNum()];
            p_throw3allTeam = new int[playerSaver.getNum()];
            p_penaltyallTeam = new int[playerSaver.getNum()];
            p_penaltyallTeamB = new int[playerSaver.getNum()];
            p_mistakeTeam = new int[playerSaver.getNum()];
            p_mistakeTeamB = new int[playerSaver.getNum()];
            pLegB = new double[playerSaver.getNum()];
            p_tid_mid = new int[playerSaver.getNum()][2];
            p_matchNum = new int[playerSaver.getNum()];
            p_startSession = new int[playerSaver.getNum()];
            for (int i = 0; i < p_tid_mid.length; i++) {
                p_tid_mid[i][0] = -1;
            }

            for (int j = 0; j < length; j++) {
                int i = points[j];
                int pid = PlayerScoreSaver.this.pid[i];
                int tid = PlayerScoreSaver.this.tid[i];
                int mid = PlayerScoreSaver.this.mid[i];
                if (pid == 32){
//                    System.out.println(pid + " " + tid +" "+mid+" "+inplacetime[i]);
                }
                if (serialid[i] <= 5) {
                    p_startSession[pid - 1] = p_startSession[pid - 1] + 1;
                }

                p_matchNum[pid - 1] = p_matchNum[pid - 1] + 1;

                String date = matchInfoSaver.getDate(mid);
                if (p_tid_mid[pid - 1][0] == -1) {
                    p_tid_mid[pid - 1][0] = tid;
                    p_tid_mid[pid - 1][1] = mid;
                } else {
                    if (date.compareTo(matchInfoSaver.getDate(p_tid_mid[pid - 1][1])) > 0) {
                        p_tid_mid[pid - 1][0] = tid;
                        p_tid_mid[pid - 1][1] = mid;
                    }
                }

                if (inplacetime[i] > 0) {
                    p_inplacetime[pid - 1] = p_inplacetime[pid - 1] + inplacetime[i];
                }

                if (throwin[i] > 0) {
                    p_throwin[pid - 1] = p_throwin[pid - 1] + throwin[i];
                }

                if (throwall[i] > 0) {
                    p_throwall[pid - 1] = p_throwall[pid - 1] + throwall[i];
                }

                if (throw3in[i] > 0) {
                    p_throw3in[pid - 1] = p_throw3in[pid - 1] + throw3in[i];
                }

                if (throw3all[i] > 0) {
                    p_throw3all[pid - 1] = p_throw3all[pid - 1] + throw3all[i];
                }

                if (penaltyin[i] > 0) {
                    p_penaltyin[pid - 1] = p_penaltyin[pid - 1] + penaltyin[i];
                }

                if (penaltyall[i] > 0) {
                    p_penaltyall[pid - 1] = p_penaltyall[pid - 1] + penaltyall[i];
                }

                if (attackbas[i] > 0) {
                    p_attackbas[pid - 1] = p_attackbas[pid - 1] + attackbas[i];
                }

                if (defencebas[i] > 0) {
                    p_defencebas[pid - 1] = p_defencebas[pid - 1] + defencebas[i];
                }

                if (allbas[i] > 0) {
                    p_allbas[pid - 1] = p_allbas[pid - 1] + allbas[i];
                }

                if (helpatt[i] > 0) {
                    p_helpatt[pid - 1] = p_helpatt[pid - 1] + helpatt[i];
                }

                if (interp[i] > 0) {
                    p_interp[pid - 1] = p_interp[pid - 1] + interp[i];
                }

                if (block[i] > 0) {
                    p_block[pid - 1] = p_block[pid - 1] + block[i];
                }

                if (mistake[i] > 0) {
                    p_mistake[pid - 1] = p_mistake[pid - 1] + mistake[i];
                }

                if (foul[i] > 0) {
                    p_foul[pid - 1] = p_foul[pid - 1] + foul[i];
                }

                if (score[i] > 0) {
                    p_score[pid - 1] = p_score[pid - 1] + score[i];
                }

                int[] temp = mid_inplacetime[mid - 1];
                if (temp[0] == tid) {
                    p_inplacetimeTeam[pid - 1] = p_inplacetimeTeam[pid - 1] + temp[1];
                }
                if (temp[2] == tid) {
                    p_inplacetimeTeam[pid - 1] = p_inplacetimeTeam[pid - 1] + temp[3];
                }

                temp = mid_throwall[mid - 1];
                if (temp[0] == tid) {
                    p_throwallTeam[pid - 1] = p_throwallTeam[pid - 1] + temp[1];
                    p_throwallTeamB[pid - 1] = p_throwallTeamB[pid - 1] + temp[3];
                }
                if (temp[2] == tid) {
                    p_throwallTeam[pid - 1] = p_throwallTeam[pid - 1] + temp[3];
                    p_throwallTeamB[pid - 1] = p_throwallTeamB[pid - 1] + temp[1];
                }

                temp = mid_throw3all[mid - 1];
                if (temp[0] == tid) {
                    p_throw3allTeam[pid - 1] = p_throw3allTeam[pid - 1] + temp[1];
                    p_throw3allTeamB[pid - 1] = p_throw3allTeamB[pid - 1] + temp[3];
                }
                if (temp[2] == tid) {
                    p_throw3allTeam[pid - 1] = p_throw3allTeam[pid - 1] + temp[3];
                    p_throw3allTeamB[pid - 1] = p_throw3allTeamB[pid - 1] + temp[1];
                }
                temp = mid_throwin[mid - 1];
                if (temp[0] == tid) {
                    p_throwinTeam[pid - 1] = p_throwinTeam[pid - 1] + temp[1];
                    p_throwinTeamB[pid - 1] = p_throwinTeamB[pid - 1] + temp[3];
                }
                if (temp[2] == tid) {
                    p_throwinTeam[pid - 1] = p_throwinTeam[pid - 1] + temp[3];
                    p_throwinTeamB[pid - 1] = p_throwinTeamB[pid - 1] + temp[1];
                }

                temp = mid_allbas[mid - 1];
                if (temp[0] == tid) {
                    p_allbasTeam[pid - 1] = p_allbasTeam[pid - 1] + temp[1];
                    p_allbasTeamB[pid - 1] = p_allbasTeamB[pid - 1] + temp[3];
                }
                if (temp[2] == tid) {
                    p_allbasTeam[pid - 1] = p_allbasTeam[pid - 1] + temp[3];
                    p_allbasTeamB[pid - 1] = p_allbasTeamB[pid - 1] + temp[1];
                }

                temp = mid_attackbas[mid - 1];
                if (temp[0] == tid) {
                    p_attackbasTeam[pid - 1] = p_attackbasTeam[pid - 1] + temp[1];
                    p_attackbasTeamB[pid - 1] = p_attackbasTeamB[pid - 1] + temp[3];
                }
                if (temp[2] == tid) {
                    p_attackbasTeam[pid - 1] = p_attackbasTeam[pid - 1] + temp[3];
                    p_attackbasTeamB[pid - 1] = p_attackbasTeamB[pid - 1] + temp[1];
                }

                temp = mid_defencebas[mid - 1];
                if (temp[0] == tid) {
                    p_defencebasTeam[pid - 1] = p_defencebasTeam[pid - 1] + temp[1];
                    p_defencebasTeamB[pid - 1] = p_defencebasTeamB[pid - 1] + temp[3];
                }
                if (temp[2] == tid) {
                    p_defencebasTeam[pid - 1] = p_defencebasTeam[pid - 1] + temp[3];
                    p_defencebasTeamB[pid - 1] = p_defencebasTeamB[pid - 1] + temp[1];
                }

                temp = mid_penaltyall[mid - 1];
                if (temp[0] == tid) {
                    p_penaltyallTeam[pid - 1] = p_penaltyallTeam[pid - 1] + temp[1];
                    p_penaltyallTeamB[pid - 1] = p_penaltyallTeamB[pid - 1] + temp[3];
                }
                if (temp[2] == tid) {
                    p_penaltyallTeam[pid - 1] = p_penaltyallTeam[pid - 1] + temp[3];
                    p_penaltyallTeamB[pid - 1] = p_penaltyallTeamB[pid - 1] + temp[1];
                }

                temp = mid_mistake[mid - 1];
                if (temp[0] == tid) {
                    p_mistakeTeam[pid - 1] = p_mistakeTeam[pid - 1] + temp[1];
                    p_mistakeTeamB[pid - 1] = p_mistakeTeamB[pid - 1] + temp[3];
                }
                if (temp[2] == tid) {
                    p_mistakeTeam[pid - 1] = p_mistakeTeam[pid - 1] + temp[3];
                    p_mistakeTeamB[pid - 1] = p_mistakeTeamB[pid - 1] + temp[1];
                }

            }
        }

        private double[] pLegB;
        private double[] p_FGP;
        private double[] p_TPSP;
        private double[] p_FTP;
        private double[] p_BSP;
        private double[] p_reboundP;
        private double[] p_OREB;
        private double[] p_DREB;
        private double[] p_stealP;
        private double[] p_turnoverP;
        private double[] p_effiency;
        private double[] p_GmSc;
        private double[] p_TSP;
        private double[] p_OSE;
        private double[] p_utiliation;
        private double[] p_assistP;
        private double[] p_avgAssist;
        private double[] p_avgBlockShot;
        private double[] p_avgDefend;
        private double[] p_avgFault;
        private double[] p_avgFoul;
        private double[] p_avgMinute;
        private double[] p_avgOffend;
        private double[] p_avgPoint;
        private double[] p_avgRebound;
        private double[] p_avgSteal;
        private String[] p_division;
        private String[] p_team;
        private String[] p_teamName;
        private char[] p_league;
        private int[] p_number;
        private int[] p_age;
        private String[] p_teamPhoto;
        private String[] p_school;
        private String[] p_birth;
        private int[] p_exp;
        private String[] p_weigth;
        private String[] p_hight;

        private void setPlayerDataLevel3() {

            pLegB = new double[playerSaver.getNum()];
            p_FGP = new double[playerSaver.getNum()];
            p_BSP = new double[playerSaver.getNum()];
            p_TPSP = new double[playerSaver.getNum()];
            p_FTP = new double[playerSaver.getNum()];
            p_assistP = new double[playerSaver.getNum()];
            p_reboundP = new double[playerSaver.getNum()];
            p_OREB = new double[playerSaver.getNum()];
            p_DREB = new double[playerSaver.getNum()];
            p_stealP = new double[playerSaver.getNum()];
            p_turnoverP = new double[playerSaver.getNum()];
            p_effiency = new double[playerSaver.getNum()];
            p_GmSc = new double[playerSaver.getNum()];
            p_TSP = new double[playerSaver.getNum()];
            p_OSE = new double[playerSaver.getNum()];
            p_utiliation = new double[playerSaver.getNum()];
            p_avgAssist = new double[playerSaver.getNum()];
            p_avgBlockShot = new double[playerSaver.getNum()];
            p_avgDefend = new double[playerSaver.getNum()];
            p_avgFault = new double[playerSaver.getNum()];
            p_avgFoul = new double[playerSaver.getNum()];
            p_avgMinute = new double[playerSaver.getNum()];
            p_avgOffend = new double[playerSaver.getNum()];
            p_avgPoint = new double[playerSaver.getNum()];
            p_avgRebound = new double[playerSaver.getNum()];
            p_avgSteal = new double[playerSaver.getNum()];
            p_division = new String[playerSaver.getNum()];
            p_team = new String[playerSaver.getNum()];
            p_teamName = new String[playerSaver.getNum()];
            p_league = new char[playerSaver.getNum()];
            p_number = new int[playerSaver.getNum()];
            p_age = new int[playerSaver.getNum()];
            p_exp = new int[playerSaver.getNum()];
            p_teamName = new String[playerSaver.getNum()];
            p_teamPhoto = new String[playerSaver.getNum()];
            p_school = new String[playerSaver.getNum()];
            p_birth = new String[playerSaver.getNum()];
            p_weigth = new String[playerSaver.getNum()];
            p_hight = new String[playerSaver.getNum()];
            for (int i = 0; i < playerSaver.getNum(); i++) {
                pLegB[i] = p_throwallTeamB[i] + 0.4 * p_penaltyallTeamB[i] - 1.07 * ((double)p_attackbasTeamB[i] / (p_attackbasTeamB[i] + p_defencebasTeam[i])) * (double) (p_throwallTeamB[i] - p_throwinTeamB[i]) + 1.07 * p_mistakeTeamB[i];
//                legB[i] = b_throwall[i] + 0.4 * b_penaltyall[i] - 1.07 * ((double) b_attackbas[i] / (b_attackbas[i] + a_defencebas[i])) * (double) (b_throwall[i] - b_throwin[i]) + 1.07 * b_mistake[i];
                if (i == 32){
                    System.out.println("pLegB"+" "+p_throwallTeamB[i]+" "+p_penaltyallTeamB[i]+" "+p_attackbasTeamB[i]+" "+p_defencebasTeam[i]+" "+p_throwinTeamB[i]+" "+p_mistakeTeamB[i]+" "+pLegB[i]);
                }

                if (this.p_throwall[i] > 0) {
                    p_FGP[i] = this.p_throwin[i] / (double) this.p_throwall[i];
//                    System.out.println(p_throwin[i]+";;;;;;;;;;;;;;"+p_throwall[i]+"------"+p_FGP[i]);
                } else {
                    p_FGP[i] = -1;
                }

                if (this.p_throw3all[i] > 0) {
                    p_TPSP[i] = this.p_throw3in[i] / (double) this.p_throw3all[i];
                } else {
                    p_TPSP[i] = -1;
                }

                if (this.p_penaltyall[i] > 0) {
                    p_FTP[i] = this.p_penaltyin[i] / (double) this.p_penaltyall[i];
                } else {
                    p_FTP[i] = -1;
                }

                if (p_matchNum[i] > 0) {
                    p_avgAssist[i] = (double) p_helpatt[i] / p_matchNum[i];
                    p_avgBlockShot[i] = (double) p_block[i] / p_matchNum[i];
                    p_avgDefend[i] = (double) p_defencebas[i] / p_matchNum[i];
                    p_avgFault[i] = (double) p_mistake[i] / p_matchNum[i];
                    p_avgFoul[i] = (double) p_foul[i] / p_matchNum[i];
                    p_avgMinute[i] = (double) p_inplacetime[i] / p_matchNum[i];
                    p_avgOffend[i] = (double) p_attackbas[i] / p_matchNum[i];
                    p_avgPoint[i] = (double) p_score[i] / p_matchNum[i];
                    p_avgRebound[i] = (double) p_allbas[i] / p_matchNum[i];
                    p_avgSteal[i] = (double) p_interp[i] / p_matchNum[i];
                } else {
                    p_avgAssist[i] = -1;
                    p_avgBlockShot[i] = -1;
                    p_avgDefend[i] = -1;
                    p_avgFault[i] = -1;
                    p_avgFoul[i] = -1;
                    p_avgMinute[i] = -1;
                    p_avgOffend[i] = -1;
                    p_avgPoint[i] = -1;
                    p_avgRebound[i] = -1;
                    p_avgSteal[i] = -1;
                }

                if (this.p_inplacetime[i] > 0) {
                    p_BSP[i] = (this.p_block[i] * ((double) this.p_inplacetimeTeam[i] / 5) / (this.p_inplacetime[i])) / (this.p_throwallTeamB[i] - this.p_throw3allTeamB[i]);
                    p_assistP[i] = (this.p_helpatt[i] )/ (((double) this.p_inplacetime[i] / ((double) this.p_inplacetimeTeam[i] / 5)) * this.p_throwinTeam[i] - this.p_throwin[i]);
                    p_reboundP[i] = ((this.p_allbas[i] * ((double) this.p_inplacetimeTeam[i] / 5)) / (this.p_inplacetime[i])) / (this.p_allbasTeam[i] + this.p_allbasTeamB[i]);
                    p_OREB[i] = ((this.p_attackbas[i] * ((double) this.p_inplacetimeTeam[i] / 5)) / (this.p_inplacetime[i])) / (this.p_allbasTeam[i] + this.p_allbasTeamB[i]);
                    if(i == 32)
                        System.out.println("p_OREB "+p_attackbas[i]+" "+p_inplacetimeTeam[i]+" "+p_inplacetime[i]+" "+p_allbasTeam[i]+" "+p_allbasTeamB[i]+" "+p_OREB[i]);
                    p_DREB[i] = ((this.p_defencebas[i] * ((double) this.p_inplacetimeTeam[i] / 5)) / (this.p_inplacetime[i])) / (this.p_allbasTeam[i] + this.p_allbasTeamB[i]);
                } else {
                    p_BSP[i] = -1;
                    p_assistP[i] = -1;
                    p_reboundP[i] = -1;
                    p_OREB[i] = -1;
                    p_DREB[i] = -1;
                }

                if (this.p_inplacetime[i] > 0 || pLegB[i] > 0) {
                    p_stealP[i] = ((this.p_interp[i] * ((double) this.p_inplacetimeTeam[i] / 5)) / (this.p_inplacetime[i])) / (this.pLegB[i]);
                    if (i == 32)
                        System.out.println(p_interp[i]+"----"+((double)p_inplacetimeTeam[i] / 5)+"------"+p_inplacetime[i]+"------"+pLegB[i]+"---------"+p_stealP[i]);
                } else {
                    p_stealP[i] = -1;
                }

                if (p_mistake[i] > 0 || p_throwall[i] > 0 || p_throw3all[i] > 0 || p_mistake[i] > 0) {
                    p_turnoverP[i] = (p_mistake[i]) / ((double) p_throwall[i] - p_throw3all[i] + 0.44 * p_penaltyall[i] + p_mistake[i]);
                } else {
                    p_turnoverP[i] = -1;
                }

                if (p_inplacetime[i] > 0 || p_throwall[i] > 0 || p_throw3all[i] > 0 || p_mistake[i] > 0) {
                    p_utiliation[i] = (((double) p_throwall[i]  + 0.44 * p_penaltyall[i] + p_mistake[i]) * ((double) p_inplacetimeTeam[i] / 5) / (p_inplacetime[i])) / ((double) p_throwallTeam[i] + 0.44 * p_penaltyallTeam[i] + p_mistakeTeam[i]);
                } else {
                    p_utiliation[i] = -1;
                }

                if (p_score[i] > 0 || p_allbas[i] > 0 || p_interp[i] > 0 || p_helpatt[i] > 0 ||
                        p_block[i] > 0 || p_throwall[i] > 0 || p_throwin[i] > 0 || p_penaltyall[i] > 0 ||
                        p_penaltyin[i] > 0 || p_mistake[i] > 0 || p_attackbas[i] > 0 || p_defencebas[i] > 0) {
                    p_effiency[i] = (p_score[i] + p_allbas[i] + p_interp[i] + p_helpatt[i] + p_block[i]) -
                            (p_throwall[i] - p_throwin[i]) - (p_penaltyall[i] - p_penaltyin[i]) - p_mistake[i];
                    p_GmSc[i] = (p_score[i]) + 0.4 * p_throwin[i] - 0.7 * p_throwall[i] - 0.4 * (p_penaltyall[i] - p_penaltyin[i])
                            + 0.7 * p_attackbas[i] + 0.3 * p_defencebas[i] + p_interp[i] + 0.7 * p_helpatt[i] + 0.7 * p_block[i]
                            - 0.4 * p_foul[i] - p_mistake[i];
                } else {
                    p_effiency[i] = -1;
                    p_GmSc[i] = -1;
                }
                if (p_score[i] > 0 || p_throwall[i] > 0 || p_penaltyall[i] > 0) {
                    p_TSP[i] = p_score[i] / (2 * ((double) p_throwall[i] + 0.44 * p_penaltyall[i]));
                } else {
                    p_TSP[i] = -1;
                }

                if (p_throwin[i] > 0 || p_throwall[i] > 0 || p_throw3in[i] > 0) {
                    p_OSE[i] = (p_throwin[i] + 0.5 * p_throw3in[i]) / p_throwall[i];
                } else {
                    p_OSE[i] = -1;
                }


                if (p_tid_mid[i][0] > 0) {

                    p_division[i] = teamSaver.getDivision()[p_tid_mid[i][0] - 1];
                    p_team[i] = teamSaver.getAbridge()[p_tid_mid[i][0] - 1];
                    p_teamName[i] = teamSaver.getTeamName()[p_tid_mid[i][0] - 1];
//                    if (i == 490){
//                        System.out.println(p_tid_mid[i][0]+"--------------______------"+p_teamName[i]);
//                    }
                    p_league[i] = teamSaver.getLeague()[p_tid_mid[i][0] - 1];
                    p_teamPhoto[i] = teamSaver.getPhoto()[p_tid_mid[i][0] - 1];

                } else {
                    p_division[i] = null;
                    p_team[i] = null;
                    p_teamName[i] = null;
                    p_league[i] = '\0';
                    p_teamPhoto[i] = null;
                }

                p_number[i] = playerSaver.getNumber()[i];
                p_age[i] = playerSaver.getAge()[i];
                p_exp[i] = playerSaver.getExp()[i];
                p_school[i] = playerSaver.getSchool()[i];
                p_birth[i] = playerSaver.getBirth()[i];
                p_weigth[i] = playerSaver.getWeight()[i] < 0 ? null:String.valueOf(playerSaver.getWeight()[i]);
                p_hight[i] = (playerSaver.getHeight1()[i] < 0 || playerSaver.getHeight2()[i] < 0)?null:playerSaver.getHeight1()[i] + "."+ playerSaver.getHeight2()[i];
            }

        }

        private int[][] mid_inplacetime;
        private int[][] mid_attackbas;
        private int[][] mid_defencebas;
        private int[][] mid_throwall;
        private int[][] mid_throw3all;
        private int[][] mid_throwin;
        private int[][] mid_mistake;
        private int[][] mid_penaltyall;
        private int[][] mid_allbas;

        public void showPidTid(){
            for (int i = 0; i < p_tid_mid.length;i++){
                System.out.println(i+" "+p_tid_mid[i][0]+" "+p_tid_mid[i][1]);
            }

            for (int i = 0; i< p_teamName.length;i++){
                System.out.println(i+" "+p_teamName[i]);
            }
        }

        private void setPlayerDataLevel1() {
            mid_inplacetime = new int[matchInfoSaver.getNum()][4];
            mid_attackbas = new int[matchInfoSaver.getNum()][4];
            mid_defencebas = new int[matchInfoSaver.getNum()][4];
            mid_throwall = new int[matchInfoSaver.getNum()][4];
            mid_throw3all = new int[matchInfoSaver.getNum()][4];
            mid_throwin = new int[matchInfoSaver.getNum()][4];
            mid_penaltyall = new int[matchInfoSaver.getNum()][4];
            mid_mistake = new int[matchInfoSaver.getNum()][4];
            mid_allbas = new int[matchInfoSaver.getNum()][4];

            for (int j = 0; j < length; j++) {
                int i = points[j];
                int mid = PlayerScoreSaver.this.mid[i];
                int tid1 = PlayerScoreSaver.this.tid[i];
                int tid2 = PlayerScoreSaver.this.d_tid[i];
                if (tid1 > tid2) {
                    if (PlayerScoreSaver.this.inplacetime[i] > 0) {
                        mid_inplacetime[mid - 1][0] = tid1;
                        mid_inplacetime[mid - 1][1] = mid_inplacetime[mid - 1][1] + PlayerScoreSaver.this.inplacetime[i];
                    }
                    if (PlayerScoreSaver.this.attackbas[i] > 0) {
                        mid_attackbas[mid - 1][0] = tid1;
                        mid_attackbas[mid - 1][1] = mid_attackbas[mid - 1][1] + PlayerScoreSaver.this.attackbas[i];
                    }
                    if (PlayerScoreSaver.this.defencebas[i] > 0) {
                        mid_defencebas[mid - 1][0] = tid1;
                        mid_defencebas[mid - 1][1] = mid_defencebas[mid - 1][1] + PlayerScoreSaver.this.defencebas[i];
                    }
                    if (PlayerScoreSaver.this.throwall[i] > 0) {
                        mid_throwall[mid - 1][0] = tid1;
                        mid_throwall[mid - 1][1] = mid_throwall[mid - 1][1] + PlayerScoreSaver.this.throwall[i];
                    }
                    if (PlayerScoreSaver.this.throw3all[i] > 0) {
                        mid_throw3all[mid - 1][0] = tid1;
                        mid_throw3all[mid - 1][1] = mid_throw3all[mid - 1][1] + PlayerScoreSaver.this.throw3all[i];
                    }
                    if (PlayerScoreSaver.this.throwin[i] > 0) {
                        mid_throwin[mid - 1][0] = tid1;
                        mid_throwin[mid - 1][1] = mid_throwin[mid - 1][1] + PlayerScoreSaver.this.throwin[i];
                    }
                    if (PlayerScoreSaver.this.penaltyall[i] > 0) {
                        mid_penaltyall[mid - 1][0] = tid1;
                        mid_penaltyall[mid - 1][1] = mid_penaltyall[mid - 1][1] + PlayerScoreSaver.this.penaltyall[i];
                    }
                    if (PlayerScoreSaver.this.mistake[i] > 0) {
                        mid_mistake[mid - 1][0] = tid1;
                        mid_mistake[mid - 1][1] = mid_mistake[mid - 1][1] + PlayerScoreSaver.this.mistake[i];
                    }
                    if (PlayerScoreSaver.this.allbas[i] > 0) {
                        mid_allbas[mid - 1][0] = tid1;
                        mid_allbas[mid - 1][1] = mid_allbas[mid - 1][1] + PlayerScoreSaver.this.allbas[i];
                    }
                }

                if (tid1 < tid2) {
                    if (PlayerScoreSaver.this.inplacetime[i] > 0) {
                        mid_inplacetime[mid - 1][2] = tid1;
                        mid_inplacetime[mid - 1][3] = mid_inplacetime[mid - 1][3] + PlayerScoreSaver.this.inplacetime[i];
                    }
                    if (PlayerScoreSaver.this.attackbas[i] > 0) {
                        mid_attackbas[mid - 1][2] = tid1;
                        mid_attackbas[mid - 1][3] = mid_attackbas[mid - 1][3] + PlayerScoreSaver.this.attackbas[i];
                    }
                    if (PlayerScoreSaver.this.defencebas[i] > 0) {
                        mid_defencebas[mid - 1][2] = tid1;
                        mid_defencebas[mid - 1][3] = mid_defencebas[mid - 1][3] + PlayerScoreSaver.this.defencebas[i];
                    }
                    if (PlayerScoreSaver.this.throwall[i] > 0) {
                        mid_throwall[mid - 1][2] = tid1;
                        mid_throwall[mid - 1][3] = mid_throwall[mid - 1][3] + PlayerScoreSaver.this.throwall[i];
                    }
                    if (PlayerScoreSaver.this.throw3all[i] > 0) {
                        mid_throw3all[mid - 1][2] = tid1;
                        mid_throw3all[mid - 1][3] = mid_throw3all[mid - 1][3] + PlayerScoreSaver.this.throw3all[i];
                    }
                    if (PlayerScoreSaver.this.throwin[i] > 0) {
                        mid_throwin[mid - 1][2] = tid1;
                        mid_throwin[mid - 1][3] = mid_throwin[mid - 1][3] + PlayerScoreSaver.this.throwin[i];
                    }
                    if (PlayerScoreSaver.this.penaltyall[i] > 0) {
                        mid_penaltyall[mid - 1][2] = tid1;
                        mid_penaltyall[mid - 1][3] = mid_penaltyall[mid - 1][3] + PlayerScoreSaver.this.penaltyall[i];
                    }
                    if (PlayerScoreSaver.this.mistake[i] > 0) {
                        mid_mistake[mid - 1][2] = tid1;
                        mid_mistake[mid - 1][3] = mid_mistake[mid - 1][3] + PlayerScoreSaver.this.mistake[i];
                    }
                    if (PlayerScoreSaver.this.allbas[i] > 0) {
                        mid_allbas[mid - 1][2] = tid1;
                        mid_allbas[mid - 1][3] = mid_allbas[mid - 1][3] + PlayerScoreSaver.this.allbas[i];
                    }
                }

            }
        }

        private int[] points;
        private int length;

        private PlayerData(int[] points, int length) {
            this.points = points;
            this.length = length;
            setPlayerDataLevel1();
            setPlayerDataLevel2();
            setPlayerDataLevel3();
            lastModifiedTime = System.currentTimeMillis();
        }

        public long getLastModifiedTime() {
            return lastModifiedTime;
        }

        public int[] getAssist() {
            return p_helpatt;
        }

        public int[] getBlockShot() {
            return p_block;
        }

        public double[] getEfficiency() {
            return p_effiency;
        }

        public int[] getFault() {
            return p_mistake;
        }

        public int[] getFoul() {
            return p_foul;
        }

        public int[] getMinute() {
            return p_inplacetime;
        }

        public int[] getOffend() {
            return p_attackbas;
        }

        public int[] getDefend() {
            return p_defencebas;
        }

        public double[] getPenalty() {
            return p_FTP;
        }

        public int[] getPoint() {
            return p_score;
        }

        public int[] getRebound() {
            return p_allbas;
        }

        public double[] getShot() {
            return p_FGP;
        }

        public int[] getStart() {
            return p_startSession;
        }

        public int[] getSteal() {
            return p_interp;
        }

        public double[] getThree() {
            return p_TPSP;
        }

        public double[] getAvgAssist() {
            return p_avgAssist;
        }

        public double[] getAvgBlockShot() {
            return p_avgBlockShot;
        }

        public double[] getAvgDefend() {
            return p_avgDefend;
        }

        public double[] getAvgFault() {
            return p_avgFault;
        }

        public double[] getAvgFoul() {
            return p_avgFoul;
        }

        public double[] getAvgMinute() {
            return p_avgMinute;
        }

        public double[] getAvgOffend() {
            return p_avgOffend;
        }

        public double[] getAvgPoint() {
            return p_avgPoint;
        }

        public double[] getAvgRebound() {
            return p_avgRebound;
        }

        public double[] getAvgSteal() {
            return p_avgSteal;
        }

        public double[] getAssistEfficient() {
            return p_assistP;
        }

        public double[] getBlockShotEfficient() {
            return p_BSP;
        }

        public double[] getDefendReboundEfficient() {
            return p_DREB;
        }

        public double[] getFaultEfficient() {
            return p_turnoverP;
        }

        public double[] getFrequency() {
            return p_utiliation;
        }

        public double[] getGmSc() {
            return p_GmSc;
        }

        public double[] getOffendReboundEfficient() {
            return p_OREB;
        }

        public double[] getRealShot() {
            return p_TSP;
        }

        public double[] getReboundEfficient() {
            return p_reboundP;
        }


        public double[] getShotEfficient() {
            return p_OSE;
        }

        public double[] getStealEfficient() {
            return p_stealP;
        }

        public String[] getPhoto() {
            return playerSaver.getPhoto();
        }

        public String[] getDivision() {
            return p_division;
        }

        public String[] getName() {
            return playerSaver.getName();
        }

        public String[] getTeam() {
            return p_team;
        }

        public String[] getTeamName() {

            return p_teamName;
        }

        public String[] getPosition() {
            return playerSaver.getPosition();
        }

        public char[] getLeague() {
            return p_league;
        }

        public int[] getNumber() {
            return p_number;
        }

        public int[] getAge() {
            return p_age;
        }

        public int[] getNumOfGame() {
            return p_matchNum;
        }

        public PlayerData(String date) {
            this.date = date;

            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i <= currentPoint; i++) {
                int mid = PlayerScoreSaver.this.mid[i];
                if (date.equals(matchInfoSaver.getDate(mid))) {
                    arrayList.add(i);
                }
            }

            this.points = getArray(arrayList);
            this.length = this.points.length;
            setPlayerDataLevel1();
            setPlayerDataLevel2();
            setPlayerDataLevel3();
            lastModifiedTime = System.currentTimeMillis();
        }

        private int[] getArray(ArrayList<Integer> arrayList) {
            int[] res = new int[arrayList.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = arrayList.get(i);
            }
            return res;
        }

        public String[] getTeamPhoto() {
            return p_teamPhoto;
        }

        public int getPlayerId(String name) {
            return playerSaver.getPlayerId(name);
        }

        public int getNum() {
            return playerSaver.getNum();
        }

        public int[] getTid() {
            int[] tids = new int[playerSaver.getNum()];
            for (int i = 0; i < tids.length; i++) {
                tids[i] = p_tid_mid[i][0];
            }
            return tids;
        }

        public String[] getSchool() {
            return p_school;
        }

        public String[] getBirth() {
            return p_birth;
        }

        public int[] getExp() {
            return p_exp;
        }

        public String[] getP_weigth() {
            return p_weigth;
        }

        public String[] getHight() {
            return p_hight;
        }
    }

    public ArrayList<MatchContentPlayerVO>[] getTeamPlayer(int mid) {
        ArrayList<MatchContentPlayerVO>[] matchContentPlayerVOs = new ArrayList[2];
        matchContentPlayerVOs[0] = new ArrayList<>();
        matchContentPlayerVOs[1] = new ArrayList<>();
        int tid1 = matchInfoSaver.getTeamf()[mid - 1];
        for (int i = 0; i < currentPoint + 1; i++) {
            if (PlayerScoreSaver.this.mid[i] == mid) {
                MatchContentPlayerVO matchContentPlayerVO = getMatchContentPlayerVO(i);
                if (tid1 == PlayerScoreSaver.this.tid[i]) {
                    matchContentPlayerVOs[0].add(matchContentPlayerVO);
                } else {
                    matchContentPlayerVOs[1].add(matchContentPlayerVO);
                }
            }
        }
        return matchContentPlayerVOs;
    }

    public MatchContentPlayerVO getMatchContentPlayerVO(int i) {
        int mid = PlayerScoreSaver.this.mid[i];
        MatchContentPlayerVO matchContentPlayerVO = new MatchContentPlayerVO();
        matchContentPlayerVO.matchID = mid;
        matchContentPlayerVO.date = matchInfoSaver.getDate(mid);
        matchContentPlayerVO.vs = teamSaver.getTeamName()[PlayerScoreSaver.this.d_tid[i] - 1];
        matchContentPlayerVO.name = playerSaver.getName()[PlayerScoreSaver.this.pid[i] - 1];
        matchContentPlayerVO.position = PlayerScoreSaver.this.position[i];
        matchContentPlayerVO.minute = PlayerScoreSaver.this.inplacetime[i];
        matchContentPlayerVO.shot = PlayerScoreSaver.this.throwin[i];
        matchContentPlayerVO.shotA = PlayerScoreSaver.this.throwall[i];
        matchContentPlayerVO.three = PlayerScoreSaver.this.throw3in[i];
        matchContentPlayerVO.threeA = PlayerScoreSaver.this.throw3all[i];
        matchContentPlayerVO.penalty = PlayerScoreSaver.this.penaltyin[i];
        matchContentPlayerVO.penaltyA = PlayerScoreSaver.this.penaltyall[i];
        matchContentPlayerVO.offendRebound = PlayerScoreSaver.this.attackbas[i];
        matchContentPlayerVO.defendRebound = PlayerScoreSaver.this.defencebas[i];
        matchContentPlayerVO.rebound = PlayerScoreSaver.this.allbas[i];
        matchContentPlayerVO.assist = PlayerScoreSaver.this.helpatt[i];
        matchContentPlayerVO.blockShot = PlayerScoreSaver.this.block[i];
        matchContentPlayerVO.fault = PlayerScoreSaver.this.mistake[i];
        matchContentPlayerVO.foul = PlayerScoreSaver.this.foul[i];
        matchContentPlayerVO.point = PlayerScoreSaver.this.score[i];
        return matchContentPlayerVO;
    }

}


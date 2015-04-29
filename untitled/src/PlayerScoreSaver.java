import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by chenghao on 15/4/21.
 */
public class PlayerScoreSaver {

    private PlayerSaver playerSaver;
    private MatchInfoSaver matchInfoSaver;
    private TeamSaver teamSaver;

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


    public PlayerScoreSaver(PlayerSaver playerSaver,
                            MatchInfoSaver matchInfoSaver,
                            TeamSaver teamSaver) {

        this.playerSaver = playerSaver;
        this.matchInfoSaver = matchInfoSaver;
        this.teamSaver = teamSaver;

        int size = 30000;
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
    private TeamData teamDataDefault;


    public void complete() {
        setPidDefaultMid();
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                setPidL5Mid();
//                setPidBeforeMid();
//            }
//        }.start();
        playerDataDefault = new PlayerData(pidDefaultMid,pidDefaultMid.length);
        teamDataDefault = new TeamData(pidDefaultMid);
        setPidL5Mid();
        setPidBeforeMid();
        playerDataL5 = new PlayerData(pidL5Mid.getPointInL5Mid(),pidL5Mid.getLength());
        playerDataBefore = new PlayerData(pidBeforeMid, pidBeforeMid.length);
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
        res = res * 60 + Integer.parseInt(ss[0].trim());
        return res;
    }

    public void show() {
        for (int i = 0; i <= currentPoint; i++) {
            System.out.println(mid[i] + " " + pid[i] + " " + tid[i] + " "
                    + position[i] + " " + inplacetime[i] + " " + throwin[i] + " " + throwall[i] + " "
                    + throw3in[i] + " " + throw3all[i] + " " + penaltyin[i] + " " + penaltyall[i] + " "
                    + attackbas[i] + " " + defencebas[i] + " " + helpatt[i] + " " + interp[i] + " " +
                    block[i] + " " + mistake[i] + " " + foul[i] + " " + score[i] + " " + serialid[i] + " "
                    + d_tid[i]);
        }
    }

    private void refreshTime() {
        lastModifiedTime = System.currentTimeMillis();
    }

    /**
     * 根据队伍id，计算该队伍的总进球数
     *
     * @param tid
     * @return
     */
    public int get_sum_a_throwin(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.throwin[i] > 0)
                    result = result + this.throwin[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总进球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_throwins(int[] points) {
        int[] sum_a_throwins = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throwin[i] > 0) {
                int tid = this.tid[i];
                sum_a_throwins[tid - 1] = sum_a_throwins[tid - 1] + this.throwin[i];
            }
        }
        return sum_a_throwins;
    }

    /**
     * 获得所有的队伍的每场总进球数
     *
     * @param points
     * @return
     */
    public int[][] get_sum_mid_a_throwins(int[] points) {
        int[][] sum_mid_a_throwins = new int[matchInfoSaver.getNum()][4];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throwin[i] > 0) {
                int mid = this.mid[i];
                int tid1 = this.tid[i];
                int tid2 = this.d_tid[i];
                if (tid1 > tid2) {
                    sum_mid_a_throwins[mid - 1][0] = tid1;
                    sum_mid_a_throwins[mid - 1][1] = sum_mid_a_throwins[mid - 1][1] + this.throwin[i];
                }

                if (tid1 < tid2) {
                    sum_mid_a_throwins[mid - 1][1] = tid2;
                    sum_mid_a_throwins[mid - 1][2] = sum_mid_a_throwins[mid - 1][1] + this.throwin[i];
                }
            }
        }
        return sum_mid_a_throwins;
    }

    /**
     * 根据队伍id，计算该队伍的对手总进球数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_b_throwin(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.throwin[i] > 0)
                    result = result + this.throwin[i];
            }

        }
        return result;
    }

    /**
     * @param points int[]
     * @return int[] 获得所有的队伍的对手总进球数
     */
    public int[] get_sum_b_throwins(int[] points) {
        int[] sum_b_throwins = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throwin[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_throwins[tid - 1] = sum_b_throwins[tid - 1] + this.throwin[i];
            }
        }
        return sum_b_throwins;
    }

    /**
     * 根据队伍id，计算该队伍的总进球数
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_throwin(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.throwin[i] > 0)
                    result = result + this.throwin[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的球员的总进球数
     *
     * @param points int[]
     * @return
     */
    public int[] get_sum_p_throwins(int[] points) {
        int[] sum_a_throwins = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throwin[i] > 0) {
                int pid = this.pid[i];
                sum_a_throwins[pid - 1] = sum_a_throwins[pid - 1] + this.throwin[i];
            }
        }
        return sum_a_throwins;
    }

    /**
     * 根据队伍id，计算该队伍的总投球数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_a_throwall(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.throwall[i] > 0)
                    result = result + this.throwall[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总投球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_throwalls(int[] points) {
        int[] sum_a_throwalls = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throwall[i] > 0) {
                int tid = this.tid[i];
                sum_a_throwalls[tid - 1] = sum_a_throwalls[tid - 1] + this.throwall[i];
            }
        }
        return sum_a_throwalls;
    }

    /**
     * 获得所有的队伍的每场总投球球数
     *
     * @param points
     * @return
     */
    public int[][] get_sum_mid_a_throwalls(int[] points) {
        int[][] res = new int[matchInfoSaver.getNum()][4];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throwall[i] > 0) {
                int mid = this.mid[i];
                int tid1 = this.tid[i];
                int tid2 = this.d_tid[i];
                if (tid1 > tid2) {
                    res[mid - 1][0] = tid1;
                    res[mid - 1][1] = res[mid - 1][1] + this.throwall[i];
                }

                if (tid1 < tid2) {
                    res[mid - 1][1] = tid2;
                    res[mid - 1][2] = res[mid - 1][1] + this.throwin[i];
                }
            }
        }
        return res;
    }

    /**
     * 根据队伍id，计算该队伍的对手总投球数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_b_throwall(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.throwall[i] > 0)
                    result = result + this.throwall[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总投球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_b_throwalls(int[] points) {
        int[] sum_b_throwalls = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throwall[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_throwalls[tid - 1] = sum_b_throwalls[tid - 1] + this.throwall[i];
            }
        }
        return sum_b_throwalls;
    }

    /**
     * 根据球员id，计算该球员的总投球数
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_throwall(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.throwall[i] > 0)
                    result = result + this.throwall[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的球员的总投球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_p_throwalls(int[] points) {
        int[] sum_a_throwalls = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throwall[i] > 0) {
                int pid = this.pid[i];
                sum_a_throwalls[pid - 1] = sum_a_throwalls[pid - 1] + this.throwall[i];
            }
        }
        return sum_a_throwalls;
    }

    /**
     * 根据队伍id，计算该队伍的总三分进球数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_a_throw3in(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.throw3in[i] > 0)
                    result = result + this.throw3in[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总三分进球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_throw3ins(int[] points) {
        int[] sum_a_throw3ins = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throw3in[i] > 0) {
                int tid = this.tid[i];
                sum_a_throw3ins[tid - 1] = sum_a_throw3ins[tid - 1] + this.throw3in[i];
            }
        }
        return sum_a_throw3ins;
    }

    /**
     * 获得所有的队伍的每场总投球球数
     *
     * @param points
     * @return
     */
    public int[][] get_sum_mid_a_throw3ins(int[] points) {
        int[][] res = new int[matchInfoSaver.getNum()][4];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throw3in[i] > 0) {
                int mid = this.mid[i];
                int tid1 = this.tid[i];
                int tid2 = this.d_tid[i];
                if (tid1 > tid2) {
                    res[mid - 1][0] = tid1;
                    res[mid - 1][1] = res[mid - 1][1] + this.throw3in[i];
                }

                if (tid1 < tid2) {
                    res[mid - 1][1] = tid2;
                    res[mid - 1][2] = res[mid - 1][1] + this.throw3in[i];
                }
            }
        }
        return res;
    }

    /**
     * 根据队伍id，计算该队伍的对手总三分进球数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_b_throw3in(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.throw3in[i] > 0)
                    result = result + this.throw3in[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总三分进球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_b_throw3ins(int[] points) {
        int[] sum_b_throw3ins = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throw3in[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_throw3ins[tid - 1] = sum_b_throw3ins[tid - 1] + this.throw3in[i];
            }
        }
        return sum_b_throw3ins;
    }

    /**
     * 根据队伍id，计算该球员的总三分进球数
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_throw3in(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.throw3in[i] > 0)
                    result = result + this.throw3in[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的球员的总三分进球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_p_throw3ins(int[] points) {
        int[] sum_a_throw3ins = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throw3in[i] > 0) {
                int pid = this.pid[i];
                sum_a_throw3ins[pid - 1] = sum_a_throw3ins[pid - 1] + this.throw3in[i];
            }
        }
        return sum_a_throw3ins;
    }

    /**
     * 根据队伍id，计算该队伍的总三分投球数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_a_throw3all(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.throw3all[i] > 0)
                    result = result + this.throw3all[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总投球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_throw3alls(int[] points) {
        int[] sum_a_throw3alls = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throw3all[i] > 0) {
                int tid = this.tid[i];
                sum_a_throw3alls[tid - 1] = sum_a_throw3alls[tid - 1] + this.throw3all[i];
            }
        }
        return sum_a_throw3alls;
    }

    /**
     * 获得所有的队伍的每场总三分投球球数
     *
     * @param points
     * @return
     */
    public int[][] get_sum_mid_a_throw3alls(int[] points) {
        int[][] res = new int[matchInfoSaver.getNum()][4];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throw3all[i] > 0) {
                int mid = this.mid[i];
                int tid1 = this.tid[i];
                int tid2 = this.d_tid[i];
                if (tid1 > tid2) {
                    res[mid - 1][0] = tid1;
                    res[mid - 1][1] = res[mid - 1][1] + this.throw3all[i];
                }

                if (tid1 < tid2) {
                    res[mid - 1][1] = tid2;
                    res[mid - 1][2] = res[mid - 1][1] + this.throw3all[i];
                }
            }
        }
        return res;
    }

    /**
     * 根据队伍id，计算该队伍的对手总三分投球数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_b_throw3all(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.throw3all[i] > 0)
                    result = result + this.throw3all[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总投球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_b_throw3alls(int[] points) {
        int[] sum_b_throw3alls = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throw3all[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_throw3alls[tid - 1] = sum_b_throw3alls[tid - 1] + this.throw3all[i];
            }
        }
        return sum_b_throw3alls;
    }

    /**
     * 根据球员id，计算该球员的总三分投球数
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_throw3all(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.throw3all[i] > 0)
                    result = result + this.throw3all[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的球员的总投球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_p_throw3alls(int[] points) {
        int[] sum_a_throw3alls = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.throw3all[i] > 0) {
                int pid = this.pid[i];
                sum_a_throw3alls[pid - 1] = sum_a_throw3alls[pid - 1] + this.throw3all[i];
            }
        }
        return sum_a_throw3alls;
    }


    /**
     * 根据队伍id，计算该队伍的总罚进球数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_a_penaltyin(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.penaltyin[i] > 0)
                    result = result + this.penaltyin[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总罚进球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_penaltyins(int[] points) {
        int[] sum_a_throwins = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.penaltyin[i] > 0) {
                int tid = this.tid[i];
                sum_a_throwins[tid - 1] = sum_a_throwins[tid - 1] + this.penaltyin[i];
            }
        }
        return sum_a_throwins;
    }

    /**
     * 获得所有的队伍的每场总罚球进球数
     *
     * @param points
     * @return
     */
    public int[][] get_sum_mid_a_penaltyins(int[] points) {
        int[][] res = new int[matchInfoSaver.getNum()][4];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.penaltyin[i] > 0) {
                int mid = this.mid[i];
                int tid1 = this.tid[i];
                int tid2 = this.d_tid[i];
                if (tid1 > tid2) {
                    res[mid - 1][0] = tid1;
                    res[mid - 1][1] = res[mid - 1][1] + this.penaltyin[i];
                }

                if (tid1 < tid2) {
                    res[mid - 1][1] = tid2;
                    res[mid - 1][2] = res[mid - 1][1] + this.penaltyin[i];
                }
            }
        }
        return res;
    }

    /**
     * 根据队伍id，计算该队伍的对手总罚进球数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_penaltyin(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.penaltyin[i] > 0)
                    result = result + this.penaltyin[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总罚进球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_b_penaltyins(int[] points) {
        int[] sum_b_penaltyins = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.penaltyin[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_penaltyins[tid - 1] = sum_b_penaltyins[tid - 1] + this.penaltyin[i];
            }
        }
        return sum_b_penaltyins;
    }

    /**
     * 根据球员id，计算该球员的总罚进球数
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_penaltyin(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.penaltyin[i] > 0)
                    result = result + this.penaltyin[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的球员的总罚进球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_p_penaltyins(int[] points) {
        int[] sum_a_throwins = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.penaltyin[i] > 0) {
                int pid = this.pid[i];
                sum_a_throwins[pid - 1] = sum_a_throwins[pid - 1] + this.penaltyin[i];
            }
        }
        return sum_a_throwins;
    }

    /**
     * 根据队伍id，计算该队伍的总罚球数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_a_penaltyall(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.penaltyall[i] > 0)
                    result = result + this.penaltyall[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总罚进球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_penaltyalls(int[] points) {
        int[] sum_a_penaltyall = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.penaltyall[i] > 0) {
                int tid = this.tid[i];
                sum_a_penaltyall[tid - 1] = sum_a_penaltyall[tid - 1] + this.penaltyall[i];
            }
        }
        return sum_a_penaltyall;
    }

    /**
     * 获得所有的队伍的每场总罚球投球球数
     *
     * @param points
     * @return
     */
    public int[][] get_sum_mid_a_penaltyalls(int[] points) {
        int[][] res = new int[matchInfoSaver.getNum()][4];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.penaltyall[i] > 0) {
                int mid = this.mid[i];
                int tid1 = this.tid[i];
                int tid2 = this.d_tid[i];
                if (tid1 > tid2) {
                    res[mid - 1][0] = tid1;
                    res[mid - 1][1] = res[mid - 1][1] + this.penaltyall[i];
                }

                if (tid1 < tid2) {
                    res[mid - 1][1] = tid2;
                    res[mid - 1][2] = res[mid - 1][1] + this.penaltyall[i];
                }
            }
        }
        return res;
    }

    /**
     * 根据队伍id，计算该队伍的对手总罚进球数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_b_penaltyall(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.penaltyall[i] > 0)
                    result = result + this.penaltyall[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总罚进球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_b_penaltyalls(int[] points) {
        int[] sum_b_penaltyalls = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.penaltyall[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_penaltyalls[tid - 1] = sum_b_penaltyalls[tid - 1] + this.penaltyall[i];
            }
        }
        return sum_b_penaltyalls;
    }

    /**
     * 根据队伍id，计算该球员的总罚球数
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_penaltyall(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.penaltyall[i] > 0)
                    result = result + this.penaltyall[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的球员的总罚进球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_p_penaltyalls(int[] points) {
        int[] sum_a_penaltyall = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.penaltyall[i] > 0) {
                int pid = this.pid[i];
                sum_a_penaltyall[pid - 1] = sum_a_penaltyall[pid - 1] + this.penaltyall[i];
            }
        }
        return sum_a_penaltyall;
    }

    /**
     * 根据队伍id，计算该队伍的总进攻篮板数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_a_attackbas(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.attackbas[i] > 0)
                    result = result + this.attackbas[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总进攻篮板数
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_attackbass(int[] points) {
        int[] sum_a_attackbass = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.attackbas[i] > 0) {
                int tid = this.tid[i];
                sum_a_attackbass[tid - 1] = sum_a_attackbass[tid - 1] + this.attackbas[i];
            }
        }
        return sum_a_attackbass;
    }

    /**
     * 获得所有的队伍的每场总进攻篮板数
     *
     * @param points
     * @return
     */
    public int[][] get_sum_mid_a_attackbass(int[] points) {
        int[][] res = new int[matchInfoSaver.getNum()][4];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.attackbas[i] > 0) {
                int mid = this.mid[i];
                int tid1 = this.tid[i];
                int tid2 = this.d_tid[i];
                if (tid1 > tid2) {
                    res[mid - 1][0] = tid1;
                    res[mid - 1][1] = res[mid - 1][1] + this.attackbas[i];
                }

                if (tid1 < tid2) {
                    res[mid - 1][1] = tid2;
                    res[mid - 1][2] = res[mid - 1][1] + this.attackbas[i];
                }
            }
        }
        return res;
    }

    /**
     * 根据队伍id，计算该队伍的对手总进攻篮板数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_b_attackbas(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.attackbas[i] > 0)
                    result = result + this.attackbas[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总进攻篮板数
     *
     * @param points
     * @return
     */
    public int[] get_sum_b_attackbass(int[] points) {
        int[] sum_b_attackbass = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.attackbas[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_attackbass[tid - 1] = sum_b_attackbass[tid - 1] + this.attackbas[i];
            }
        }
        return sum_b_attackbass;
    }

    /**
     * 根据球员id，计算该球员的总进攻篮板数
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_attackbas(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.attackbas[i] > 0)
                    result = result + this.attackbas[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的球员的总进攻篮板数
     *
     * @param points
     * @return
     */
    public int[] get_sum_p_attackbass(int[] points) {
        int[] sum_a_attackbass = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.attackbas[i] > 0) {
                int pid = this.pid[i];
                sum_a_attackbass[pid - 1] = sum_a_attackbass[pid - 1] + this.attackbas[i];
            }
        }
        return sum_a_attackbass;
    }

    /**
     * 根据队伍id，计算该队伍的总防守篮板数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_a_defencebas(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.defencebas[i] > 0)
                    result = result + this.defencebas[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总防守篮板数
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_defencebass(int[] points) {
        int[] sum_a_defencebass = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.defencebas[i] > 0) {
                int tid = this.tid[i];
                sum_a_defencebass[tid - 1] = sum_a_defencebass[tid - 1] + this.defencebas[i];
            }
        }
        return sum_a_defencebass;
    }

    /**
     * 获得所有的队伍的每场总进攻篮板数
     *
     * @param points
     * @return
     */
    public int[][] get_sum_mid_a_defencebass(int[] points) {
        int[][] res = new int[matchInfoSaver.getNum()][4];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.defencebas[i] > 0) {
                int mid = this.mid[i];
                int tid1 = this.tid[i];
                int tid2 = this.d_tid[i];
                if (tid1 > tid2) {
                    res[mid - 1][0] = tid1;
                    res[mid - 1][1] = res[mid - 1][1] + this.defencebas[i];
                }

                if (tid1 < tid2) {
                    res[mid - 1][1] = tid2;
                    res[mid - 1][2] = res[mid - 1][1] + this.defencebas[i];
                }
            }
        }
        return res;
    }

    /**
     * 根据队伍id，计算该队伍的对手总防守篮板数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_b_defencebas(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.defencebas[i] > 0)
                    result = result + this.defencebas[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总防守篮板数
     *
     * @param points
     * @return
     */
    public int[] get_sum_b_defencebass(int[] points) {
        int[] sum_b_defencebass = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.defencebas[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_defencebass[tid - 1] = sum_b_defencebass[tid - 1] + this.defencebas[i];
            }
        }
        return sum_b_defencebass;
    }

    /**
     * 根据队伍id，计算该队伍的总防守篮板数
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_defencebas(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.defencebas[i] > 0)
                    result = result + this.defencebas[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总防守篮板数
     *
     * @param points
     * @return
     */
    public int[] get_sum_p_defencebass(int[] points) {
        int[] sum_a_defencebass = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.defencebas[i] > 0) {
                int pid = this.pid[i];
                sum_a_defencebass[pid - 1] = sum_a_defencebass[pid - 1] + this.defencebas[i];
            }
        }
        return sum_a_defencebass;
    }


    /**
     * 根据队伍id，计算该队伍的总篮板数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_a_allbas(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.allbas[i] > 0)
                    result = result + this.allbas[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总篮板数
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_allbass(int[] points) {
        int[] sum_a_allbass = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.allbas[i] > 0) {
                int tid = this.tid[i];
                sum_a_allbass[tid - 1] = sum_a_allbass[tid - 1] + this.allbas[i];
            }
        }
        return sum_a_allbass;
    }

    /**
     * 获得所有的队伍的每场总进攻篮板数
     *
     * @param points
     * @return
     */
    public int[][] get_sum_mid_a_allbass(int[] points) {
        int[][] res = new int[matchInfoSaver.getNum()][4];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.allbas[i] > 0) {
                int mid = this.mid[i];
                int tid1 = this.tid[i];
                int tid2 = this.d_tid[i];
                if (tid1 > tid2) {
                    res[mid - 1][0] = tid1;
                    res[mid - 1][1] = res[mid - 1][1] + this.allbas[i];
                }

                if (tid1 < tid2) {
                    res[mid - 1][1] = tid2;
                    res[mid - 1][2] = res[mid - 1][1] + this.allbas[i];
                }
            }
        }
        return res;
    }

    /**
     * 根据队伍id，计算该队伍的对手总篮板数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_b_allbas(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.allbas[i] > 0)
                    result = result + this.allbas[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总篮板数
     *
     * @param points
     * @return
     */
    public int[] get_sum_b_allbass(int[] points) {
        int[] sum_b_allbass = new int[teamSaver.getNum()];
        for (int i = 0; i < currentPoint; i++) {
            if (this.allbas[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_allbass[tid - 1] = sum_b_allbass[tid - 1] + this.allbas[i];
            }
        }
        return sum_b_allbass;
    }

    /**
     * 根据队伍id，计算该队伍的总篮板数
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_allbas(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.allbas[i] > 0)
                    result = result + this.allbas[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总篮板数
     *
     * @param points
     * @return
     */
    public int[] get_sum_p_allbass(int[] points) {
        int[] sum_a_allbass = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.allbas[i] > 0) {
                int pid = this.pid[i];
                sum_a_allbass[pid - 1] = sum_a_allbass[pid - 1] + this.allbas[i];
            }
        }
        return sum_a_allbass;
    }

    /**
     * 根据队伍id，计算该队伍的总助攻数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_a_helpatt(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.helpatt[i] > 0)
                    result = result + this.helpatt[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总助攻数
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_helpatts(int[] points) {
        int[] sum_a_helpatts = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.helpatt[i] > 0) {
                int tid = this.tid[i];
                sum_a_helpatts[tid - 1] = sum_a_helpatts[tid - 1] + this.helpatt[i];
            }
        }
        return sum_a_helpatts;
    }

    /**
     * 获得所有的队伍的每场总助攻数
     *
     * @param points
     * @return
     */
    public int[][] get_sum_mid_a_helpatts(int[] points) {
        int[][] res = new int[matchInfoSaver.getNum()][4];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.helpatt[i] > 0) {
                int mid = this.mid[i];
                int tid1 = this.tid[i];
                int tid2 = this.d_tid[i];
                if (tid1 > tid2) {
                    res[mid - 1][0] = tid1;
                    res[mid - 1][1] = res[mid - 1][1] + this.helpatt[i];
                }

                if (tid1 < tid2) {
                    res[mid - 1][1] = tid2;
                    res[mid - 1][2] = res[mid - 1][1] + this.helpatt[i];
                }
            }
        }
        return res;
    }

    /**
     * 根据队伍id，计算该队伍的对手总助攻数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_b_helpatt(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.helpatt[i] > 0)
                    result = result + this.helpatt[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总助攻数
     *
     * @param points
     * @return
     */
    public int[] get_sum_b_helpatts(int[] points) {
        int[] sum_b_helpatts = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.helpatt[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_helpatts[tid - 1] = sum_b_helpatts[tid - 1] + this.helpatt[i];
            }
        }
        return sum_b_helpatts;
    }

    /**
     * 根据球员id，计算该球员的总助攻数
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_helpatt(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.helpatt[i] > 0)
                    result = result + this.helpatt[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的球员的总助攻数
     *
     * @param points
     * @return
     */
    public int[] get_sum_p_helpatts(int[] points) {
        int[] sum_a_helpatts = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.helpatt[i] > 0) {
                int pid = this.pid[i];
                sum_a_helpatts[pid - 1] = sum_a_helpatts[pid - 1] + this.helpatt[i];
            }
        }
        return sum_a_helpatts;
    }

    /**
     * 根据队伍id，计算该队伍的总抢断数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_a_interp(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.interp[i] > 0)
                    result = result + this.interp[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总抢断数
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_interps(int[] points) {
        int[] sum_a_interps = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.interp[i] > 0) {
                int tid = this.tid[i];
                sum_a_interps[tid - 1] = sum_a_interps[tid - 1] + this.interp[i];
            }
        }
        return sum_a_interps;
    }

    /**
     * 获得所有的队伍的每场总抢断数
     *
     * @param points
     * @return
     */
    public int[][] get_sum_mid_a_interps(int[] points) {
        int[][] res = new int[matchInfoSaver.getNum()][4];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.interp[i] > 0) {
                int mid = this.mid[i];
                int tid1 = this.tid[i];
                int tid2 = this.d_tid[i];
                if (tid1 > tid2) {
                    res[mid - 1][0] = tid1;
                    res[mid - 1][1] = res[mid - 1][1] + this.interp[i];
                }

                if (tid1 < tid2) {
                    res[mid - 1][1] = tid2;
                    res[mid - 1][2] = res[mid - 1][1] + this.interp[i];
                }
            }
        }
        return res;
    }


    /**
     * 根据队伍id，计算该队伍的对手总抢断数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_b_interp(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.interp[i] > 0)
                    result = result + this.interp[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总抢断数
     *
     * @param points
     * @return
     */
    public int[] get_sum_b_interps(int[] points) {
        int[] sum_b_interps = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.interp[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_interps[tid - 1] = sum_b_interps[tid - 1] + this.interp[i];
            }
        }
        return sum_b_interps;
    }

    /**
     * 根据球员id，计算该球员的总抢断数
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_interp(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.interp[i] > 0)
                    result = result + this.interp[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的球员的总抢断数
     *
     * @param points
     * @return
     */
    public int[] get_sum_p_interps(int[] points) {
        int[] sum_a_interps = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.interp[i] > 0) {
                int pid = this.pid[i];
                sum_a_interps[pid - 1] = sum_a_interps[pid - 1] + this.interp[i];
            }
        }
        return sum_a_interps;
    }

    /**
     * 根据队伍id，计算该队伍的总盖帽数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_a_block(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.block[i] > 0)
                    result = result + this.block[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总盖帽数
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_blocks(int[] points) {
        int[] sum_a_blocks = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.block[i] > 0) {
                int tid = this.tid[i];
                sum_a_blocks[tid - 1] = sum_a_blocks[tid - 1] + this.block[i];
            }
        }
        return sum_a_blocks;
    }

    /**
     * 获得所有的队伍的每场总盖帽数
     *
     * @param points
     * @return
     */
    public int[][] get_sum_mid_a_blocks(int[] points) {
        int[][] res = new int[matchInfoSaver.getNum()][4];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.block[i] > 0) {
                int mid = this.mid[i];
                int tid1 = this.tid[i];
                int tid2 = this.d_tid[i];
                if (tid1 > tid2) {
                    res[mid - 1][0] = tid1;
                    res[mid - 1][1] = res[mid - 1][1] + this.block[i];
                }

                if (tid1 < tid2) {
                    res[mid - 1][1] = tid2;
                    res[mid - 1][2] = res[mid - 1][1] + this.block[i];
                }
            }
        }
        return res;
    }

    /**
     * 根据队伍id，计算该队伍的对手总盖帽数
     *
     * @param tid    int
     * @param points int[]
     * @return sum_b_block
     */
    public int get_sum_b_block(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.block[i] > 0)
                    result = result + this.block[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总盖帽数
     *
     * @param points
     * @return
     */
    public int[] get_sum_b_blocks(int[] points) {
        int[] sum_b_blocks = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.block[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_blocks[tid - 1] = sum_b_blocks[tid - 1] + this.block[i];
            }
        }
        return sum_b_blocks;
    }

    /**
     * 根据球员id，计算该球员的总盖帽数
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_block(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.block[i] > 0)
                    result = result + this.block[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的球员的总盖帽数
     *
     * @param points
     * @return
     */
    public int[] get_sum_p_blocks(int[] points) {
        int[] sum_a_blocks = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.block[i] > 0) {
                int pid = this.pid[i];
                sum_a_blocks[pid - 1] = sum_a_blocks[pid - 1] + this.block[i];
            }
        }
        return sum_a_blocks;
    }

    /**
     * 根据队伍id，计算该队伍的总失误数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_a_mistake(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.mistake[i] > 0)
                    result = result + this.mistake[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总失误数
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_mistakes(int[] points) {
        int[] sum_a_mistakes = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.mistake[i] > 0) {
                int tid = this.tid[i];
                sum_a_mistakes[tid - 1] = sum_a_mistakes[tid - 1] + this.mistake[i];
            }
        }
        return sum_a_mistakes;
    }

    /**
     * 获得所有的队伍的每场总失误数
     *
     * @param points
     * @return
     */
    public int[][] get_sum_mid_a_mistakes(int[] points) {
        int[][] res = new int[matchInfoSaver.getNum()][4];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.mistake[i] > 0) {
                int mid = this.mid[i];
                int tid1 = this.tid[i];
                int tid2 = this.d_tid[i];
                if (tid1 > tid2) {
                    res[mid - 1][0] = tid1;
                    res[mid - 1][1] = res[mid - 1][1] + this.mistake[i];
                }

                if (tid1 < tid2) {
                    res[mid - 1][1] = tid2;
                    res[mid - 1][2] = res[mid - 1][1] + this.mistake[i];
                }
            }
        }
        return res;
    }

    /**
     * 根据队伍id，计算该队伍的对手总失误数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_b_mistake(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.mistake[i] > 0)
                    result = result + this.mistake[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总失误数
     *
     * @param points
     * @return
     */
    public int[] get_sum_b_mistakes(int[] points) {
        int[] sum_b_mistakes = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.mistake[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_mistakes[tid - 1] = sum_b_mistakes[tid - 1] + this.mistake[i];
            }
        }
        return sum_b_mistakes;
    }

    /**
     * 根据球员id，计算该球员的总失误数
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_mistake(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.mistake[i] > 0)
                    result = result + this.mistake[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的球员的总失误数
     *
     * @param points
     * @return
     */
    public int[] get_sum_p_mistakes(int[] points) {
        int[] sum_a_mistakes = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.mistake[i] > 0) {
                int pid = this.pid[i];
                sum_a_mistakes[pid - 1] = sum_a_mistakes[pid - 1] + this.mistake[i];
            }
        }
        return sum_a_mistakes;
    }

    /**
     * 根据队伍id，计算该队伍的总罚球数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_a_foul(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.foul[i] > 0)
                    result = result + this.foul[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总犯规数
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_fouls(int[] points) {
        int[] sum_a_fouls = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.foul[i] > 0) {
                int tid = this.tid[i];
                sum_a_fouls[tid - 1] = sum_a_fouls[tid - 1] + this.foul[i];
            }
        }
        return sum_a_fouls;
    }

    /**
     * 获得所有的队伍的每场总犯规数
     *
     * @param points
     * @return
     */
    public int[][] get_sum_mid_a_fouls(int[] points) {
        int[][] res = new int[matchInfoSaver.getNum()][4];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.foul[i] > 0) {
                int mid = this.mid[i];
                int tid1 = this.tid[i];
                int tid2 = this.d_tid[i];
                if (tid1 > tid2) {
                    res[mid - 1][0] = tid1;
                    res[mid - 1][1] = res[mid - 1][1] + this.foul[i];
                }

                if (tid1 < tid2) {
                    res[mid - 1][1] = tid2;
                    res[mid - 1][2] = res[mid - 1][1] + this.foul[i];
                }
            }
        }
        return res;
    }


    /**
     * 根据队伍id，计算该队伍的对手总罚球数
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_b_foul(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.foul[i] > 0)
                    result = result + this.foul[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总罚球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_b_fouls(int[] points) {
        int[] sum_b_fouls = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.foul[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_fouls[tid - 1] = sum_b_fouls[tid - 1] + this.foul[i];
            }
        }
        return sum_b_fouls;
    }

    /**
     * 根据球员id，计算该球员的总罚球数
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_foul(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.foul[i] > 0)
                    result = result + this.foul[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的球员的总罚球数
     *
     * @param points
     * @return
     */
    public int[] get_sum_p_fouls(int[] points) {
        int[] sum_a_fouls = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.foul[i] > 0) {
                int pid = this.pid[i];
                sum_a_fouls[pid - 1] = sum_a_fouls[pid - 1] + this.foul[i];
            }
        }
        return sum_a_fouls;
    }


    /**
     * 根据队伍id，计算该队伍的总分
     *
     * @param tid
     * @param points
     * @return
     */
    public int get_sum_a_score(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.tid[i]) {
                if (this.score[i] > 0)
                    result = result + this.score[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总分
     *
     * @param points
     * @return
     */
    public int[] get_sum_a_scores(int[] points) {
        int[] sum_a_scores = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.score[i] > 0) {
                int tid = this.tid[i];
                sum_a_scores[tid - 1] = sum_a_scores[tid - 1] + this.score[i];
            }
        }
        return sum_a_scores;
    }

    /**
     * 根据队伍id，计算该队伍的对手总分
     *
     * @param tid
     * @return
     */
    public int get_sum_b_score(int tid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (tid == this.d_tid[i]) {
                if (this.score[i] > 0)
                    result = result + this.score[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总分
     *
     * @param points
     * @return
     */
    public int[] get_sum_b_scores(int[] points) {
        int[] sum_b_scores = new int[teamSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.score[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_scores[tid - 1] = sum_b_scores[tid - 1] + this.score[i];
            }
        }
        return sum_b_scores;
    }

    /**
     * 根据球员id，计算该球员的总分
     *
     * @param pid
     * @param points
     * @return
     */
    public int get_sum_p_score(int pid, int[] points) {
        int result = 0;
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (pid == this.pid[i]) {
                if (this.score[i] > 0)
                    result = result + this.score[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的球员的总分
     *
     * @param points
     * @return
     */
    public int[] get_sum_p_scores(int[] points) {
        int[] sum_a_scores = new int[playerSaver.getNum()];
        for (int j = 0; j < points.length; j++) {
            int i = points[j];
            if (this.score[i] > 0) {
                int pid = this.pid[i];
                sum_a_scores[pid - 1] = sum_a_scores[pid - 1] + this.score[i];
            }
        }
        return sum_a_scores;
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
            ArrayList arrayList = new ArrayList();
            String date = matchInfoSaver.getDate(mid);
            for (int i = 0; i <= pid_point; i++) {
                if (this.pid[i] == pid) {

                    arrayList.add(i);
                    if (arrayList.size() == 5)
                        break;
                }
            }

            if (arrayList.size() < 5) {
                if (pid_point < size - 1) {
                    pid_point++;
                    length++;
                    this.pid[pid_point] = pid;
                    this.mid[pid_point] = mid;
                    this.pointInL5Mid[pid_point] = m;
                }
                return;
            }

            int temp = (int) arrayList.get(0);
            for (int i = 0; i < arrayList.size(); i++) {
                int a = (int) arrayList.get(i);
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

    /**
     *
     */
    public void showPIdL5Mid() throws FileNotFoundException {
        int[] pointL5Mid = pidL5Mid.getPointInL5Mid();
        int length = pidL5Mid.getLength();
        for (int i = 0; i < length; i++) {
            int m = pointL5Mid[i];
            System.out.println(mid[m] + " " + pid[m] + " " + tid[m] + " "
                    + position[m] + " " + inplacetime[m] + " " + throwin[m] + " " + throwall[m] + " "
                    + throw3in[m] + " " + throw3all[m] + " " + penaltyin[m] + " " + penaltyall[m] + " "
                    + attackbas[m] + " " + defencebas[m] + " " + helpatt[m] + " " + interp[m] + " " +
                    block[m] + " " + mistake[m] + " " + foul[m] + " " + score[m] + " " + serialid[m] + " "
                    + d_tid[m]);
        }
    }

    private int[] pidDefaultMid;
    private boolean pidDefaultMidFlag = false;

    /**
     * 默认比赛信息表
     */
    public void setPidDefaultMid() {
        pidDefaultMid = new int[currentPoint + 1];
        for (int i = 0; i < pidDefaultMid.length; i++) {
            pidDefaultMid[i] = i;
        }
        pidDefaultMidFlag = true;
    }

    public int[] getPidDefaultMid() {
        return pidDefaultMid;
    }

    private int[] pidBeforeMid;
    private boolean pidBeforeMidFlag = false;

    /**
     * 默认比赛信息表
     */
    public void setPidBeforeMid() {
        pidBeforeMid = new int[pidDefaultMid.length - pidL5Mid.getLength()];
        int m = 0;
        for (int i = 0; i <= currentPoint; i++) {
            if (pidL5Mid.isInPointInL5Mid(i))
                continue;
            pidBeforeMid[m] = i;
            m++;
        }
        pidBeforeMidFlag = true;
    }

    public int[] getPidBeforeMid() {
        return pidBeforeMid;
    }

    //----------------------------team 数据计算----------------------------------------------//
    class TeamData {

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
        private int[] b_throwin;
        private int[] b_throwall;
        private int[] b_penaltyall;
        private int[] b_attackbas;
        private int[] b_defencebas;
        private int[] b_mistake;
        private int[] b_score;


        private double[] FPG;
        private double[] TPSP;
        private double[] FTP;
        private double[] leg;
        private double[] legB;
        private double[] assistP;
        private double[] stealP;
        private double[] ORtg;
        private double[] DRtg;

        private void setTeamDataLevel2() {
            FPG = new double[teamSaver.getNum()];
            TPSP = new double[teamSaver.getNum()];
            leg = new double[teamSaver.getNum()];
            legB = new double[teamSaver.getNum()];
            assistP = new double[teamSaver.getNum()];
            stealP = new double[teamSaver.getNum()];
            ORtg = new double[teamSaver.getNum()];
            DRtg = new double[teamSaver.getNum()];
            FTP = new double[teamSaver.getNum()];
            for (int i = 0; i < teamSaver.getNum(); i++) {
                FPG[i] = ((double) a_throwin[i]) / a_throwall[i];
                TPSP[i] = ((double) a_throw3in[i]) / a_throw3all[i];
                leg[i] = a_throwall[i] + 0.4 * a_penaltyall[i] - 1.07 * (a_attackbas[i] / ((a_attackbas[i] + b_defencebas[i]) * (double) (a_throwall[i] - a_throwin[i]))) + 1.07 * a_mistake[i];
                legB[i] = b_throwall[i] + 0.4 * b_penaltyall[i] - 1.07 * (b_attackbas[i] / ((b_attackbas[i] + a_defencebas[i]) * (double) (b_throwall[i] - b_throwin[i]))) + 1.07 * b_mistake[i];
                assistP[i] = 100 * a_helpatt[i] / leg[i];
                stealP[i] = 100 * a_interp[i] / legB[i];
                ORtg[i] = 100 * a_score[i] / leg[i];
                DRtg[i] = 100 * b_score[i] / legB[i];
                FTP[i] = ((double) a_penaltyin[i]) / a_penaltyall[i];
            }
        }

        private void setTeamDataLevel1(int[] points) {
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
            b_throwin = new int[teamSaver.getNum()];
            b_throwall = new int[teamSaver.getNum()];
            b_penaltyall = new int[teamSaver.getNum()];
            b_attackbas = new int[teamSaver.getNum()];
            b_defencebas = new int[teamSaver.getNum()];
            b_mistake = new int[teamSaver.getNum()];
            b_score = new int[teamSaver.getNum()];

            for (int j = 0; j < points.length; j++) {
                int i = points[j];
                if (PlayerScoreSaver.this.throwin[i] > 0) {
                    int tid = PlayerScoreSaver.this.tid[i];
                    int d_tid = PlayerScoreSaver.this.d_tid[i];
                    a_throwin[tid - 1] = a_throwin[tid - 1] + PlayerScoreSaver.this.throwin[i];
                    a_throwall[tid - 1] = a_throwall[tid - 1] + PlayerScoreSaver.this.throwall[i];
                    a_throw3in[tid - 1] = a_throw3in[tid - 1] + PlayerScoreSaver.this.throw3in[i];
                    a_throw3all[tid - 1] = a_throw3all[tid - 1] + PlayerScoreSaver.this.throw3all[i];
                    a_penaltyin[tid - 1] = a_penaltyin[tid - 1] + PlayerScoreSaver.this.penaltyin[i];
                    a_penaltyall[tid - 1] = a_penaltyall[tid - 1] + PlayerScoreSaver.this.penaltyall[i];
                    a_attackbas[tid - 1] = a_attackbas[tid - 1] + PlayerScoreSaver.this.attackbas[i];
                    a_defencebas[tid - 1] = a_defencebas[tid - 1] + PlayerScoreSaver.this.defencebas[i];
                    a_allbas[tid - 1] = a_allbas[tid - 1] + PlayerScoreSaver.this.allbas[i];
                    a_helpatt[tid - 1] = a_helpatt[tid - 1] + PlayerScoreSaver.this.helpatt[i];
                    a_interp[tid - 1] = a_interp[tid - 1] + PlayerScoreSaver.this.interp[i];
                    a_mistake[tid - 1] = a_mistake[tid - 1] + PlayerScoreSaver.this.mistake[i];
                    a_foul[tid - 1] = a_foul[tid - 1] + PlayerScoreSaver.this.foul[i];
                    a_score[tid - 1] = a_score[tid - 1] + PlayerScoreSaver.this.score[i];
                    b_throwin[d_tid - 1] = b_throwin[d_tid - 1] + PlayerScoreSaver.this.throwin[i];
                    b_throwall[d_tid - 1] = b_throwall[d_tid - 1] + PlayerScoreSaver.this.throwall[i];
                    b_penaltyall[d_tid - 1] = b_penaltyall[d_tid - 1] + PlayerScoreSaver.this.penaltyall[i];
                    b_attackbas[d_tid - 1] = b_attackbas[d_tid - 1] + PlayerScoreSaver.this.attackbas[i];
                    b_defencebas[d_tid - 1] = b_defencebas[d_tid - 1] + PlayerScoreSaver.this.defencebas[i];
                    b_mistake[d_tid - 1] = b_mistake[d_tid - 1] + PlayerScoreSaver.this.mistake[i];
                    b_score[d_tid - 1] = b_score[d_tid - 1] + PlayerScoreSaver.this.score[i];
                }
            }

        }

        private int[] points;

        TeamData(int[] points) {
            this.points = points;
            setTeamDataLevel1(points);
            setTeamDataLevel2();
        }
    }

    //--------------------------------------------------------------------------------------//
    class PlayerData {

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
            for (int j = 0; j < length; j++) {
                int i = points[j];
                int pid = PlayerScoreSaver.this.pid[i];
                int tid = PlayerScoreSaver.this.tid[i];
                int mid = PlayerScoreSaver.this.mid[i];

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
                }
                if (temp[2] == tid) {
                    p_throwinTeam[pid - 1] = p_throwinTeam[pid - 1] + temp[3];
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
                }
                if (temp[2] == tid) {
                    p_penaltyallTeam[pid - 1] = p_penaltyallTeam[pid - 1] + temp[3];
                }

                temp = mid_mistake[mid - 1];
                if (temp[0] == tid) {
                    p_mistakeTeam[pid - 1] = p_mistakeTeam[pid - 1] + temp[1];
                    p_mistakeTeamB[pid - 1] = p_mistakeTeamB[pid - 1] + p_mistakeTeamB[3];
                }
                if (temp[2] == tid) {
                    p_mistakeTeam[pid - 1] = p_mistakeTeam[pid - 1] + temp[3];
                    p_mistakeTeamB[pid - 1] = p_mistakeTeamB[pid - 1] + p_mistakeTeamB[1];
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

            for (int i = 0; i < playerSaver.getNum(); i++) {

                pLegB[i] = p_throwallTeamB[i] + 0.4 * p_penaltyallTeamB[i] - 1.07 * (p_attackbasTeamB[i] / ((p_attackbasTeamB[i] + p_defencebasTeam[i]) * (double) (p_throwallTeamB[i] - p_throwinTeamB[i]))) + 1.07 * p_mistakeTeamB[i];


                if (this.p_throwall[i] > 0) {
                    p_FGP[i] = this.p_throwin[i] / (double) this.p_throwall[i];
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

                if (this.p_inplacetime[i] > 0) {
                    p_BSP[i] = (this.p_block[i] * ((double) this.p_inplacetimeTeam[i] / 5) / (this.p_inplacetime[i])) / (this.p_throwallTeamB[i] - this.p_throw3allTeamB[i]);
                    p_assistP[i] = (this.p_helpatt[i] / ((double) this.p_inplacetime[i] / ((double) this.p_inplacetimeTeam[i] / 5))) * this.p_throwinTeam[i] - this.p_throwin[i];
                    p_reboundP[i] = ((this.p_allbas[i] * ((double) this.p_inplacetimeTeam[i] / 5)) / (this.p_inplacetime[i])) / (this.p_allbasTeam[i] + this.p_allbasTeamB[i]);
                    p_OREB[i] = ((this.p_attackbas[i] * ((double) this.p_inplacetimeTeam[i] / 5)) / (this.p_inplacetime[i])) / (this.p_allbasTeam[i] + this.p_allbasTeamB[i]);
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
                } else {
                    p_stealP[i] = -1;
                }

                if (p_mistake[i] > 0 || p_throwall[i] > 0 || p_throw3all[i] > 0 || p_mistake[i] > 0) {
                    p_turnoverP[i] = (p_mistake[i]) / ((double) p_throwall[i] - p_throw3all[i] + 0.44 * p_penaltyall[i] + p_mistake[i]);
                } else {
                    p_turnoverP[i] = -1;
                }

                if (p_inplacetime[i] > 0 || p_throwall[i] > 0 || p_throw3all[i] > 0 || p_mistake[i] > 0) {
                    p_utiliation[i] = (((double) p_throwall[i] - p_throw3all[i] + 0.44 * p_penaltyall[i] + p_mistake[i]) * ((double) p_inplacetimeTeam[i] / 5) / (p_inplacetime[i])) / ((double) p_throwallTeam[i] - p_throw3allTeam[i] + 0.44 * p_penaltyallTeam[i] + p_mistakeTeam[i]);
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
                    p_TSP[i] = p_score[i] / (2 * (p_throwall[i] + 0.44 * p_penaltyall[i]));
                } else {
                    p_TSP[i] = -1;
                }

                if (p_throwin[i] > 0 || p_throwall[i] > 0 || p_throw3in[i] > 0) {
                    p_OSE[i] = (p_throwin[i] + 0.5 * p_throw3in[i]) / p_throwall[i];
                } else {
                    p_OSE[i] = -1;
                }
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
                        mid_allbas[mid - 1][3] = mid_allbas[mid - 1][1] + PlayerScoreSaver.this.allbas[i];
                    }
                }

            }
        }

        private int[] points;
        private int length;

        PlayerData(int[] points, int length) {
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
    }

}


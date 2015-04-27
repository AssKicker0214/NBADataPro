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
    private String[] inplacetime;
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
        inplacetime = new String[size];
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

    /**
     * 插入一条球员比赛记录
     *
     * @param ss
     */
    public void insert(String[] ss) {
        int m_mid = -1;
        try {
            m_mid = ss[0] == null ? -1 : Integer.parseInt(ss[0].trim());
        } catch (Exception e) {

        }
        int m_tid = -1;
        try {
            m_tid = ss[1] == null ? -1 : Integer.parseInt(ss[1].trim());
        } catch (Exception e) {

        }
        int m_pid = -1;
        try {
            m_pid = ss[2] == null ? -1 : Integer.parseInt(ss[2].trim());
        } catch (Exception e) {

        }
        String m_position = ss[3] == null ? null : ss[3].trim();
        String m_inplacetime = ss[4] == null ? null : ss[4].trim();

        int m_throwin = -1;
        try {
            m_throwin = ss[5] == null ? -1 : Integer.parseInt(ss[5].trim());
        } catch (Exception e) {

        }
        int m_throwall = -1;
        try {
            m_throwall = ss[6] == null ? -1 : Integer.parseInt(ss[6].trim());
        } catch (Exception e) {

        }
        int m_throw3in = -1;
        try {
            m_throw3in = ss[7] == null ? -1 : Integer.parseInt(ss[7].trim());
        } catch (Exception e) {

        }
        int m_throw3all = -1;
        try {
            m_throw3all = ss[8] == null ? -1 : Integer.parseInt(ss[8].trim());
        } catch (Exception e) {

        }
        int m_penaltyin = -1;
        try {
            m_penaltyin = ss[9] == null ? -1 : Integer.parseInt(ss[9].trim());
        } catch (Exception e) {

        }
        int m_penaltyall = -1;
        try {
            m_penaltyall = ss[10] == null ? -1 : Integer.parseInt(ss[10].trim());
        } catch (Exception e) {

        }
        int m_attackbas = -1;
        try {
            m_attackbas = ss[11] == null ? -1 : Integer.parseInt(ss[11].trim());
        } catch (Exception e) {

        }
        int m_defencebas = -1;
        try {
            m_defencebas = ss[12] == null ? -1 : Integer.parseInt(ss[12].trim());
        } catch (Exception e) {

        }
        int m_allbas = -1;
        try {
            m_allbas = ss[13] == null ? -1 : Integer.parseInt(ss[13].trim());
        } catch (Exception e) {

        }
        int m_helpatt = -1;
        try {
            m_helpatt = ss[14] == null ? -1 : Integer.parseInt(ss[14].trim());
        } catch (Exception e) {

        }
        int m_interp = -1;
        try {
            m_interp = ss[15] == null ? -1 : Integer.parseInt(ss[15].trim());
        } catch (Exception e) {

        }
        int m_block = -1;
        try {
            m_block = ss[16] == null ? -1 : Integer.parseInt(ss[16].trim());
        } catch (Exception e) {

        }
        int m_mistake = -1;
        try {
            m_mistake = ss[17] == null ? -1 : Integer.parseInt(ss[17].trim());
        } catch (Exception e) {

        }
        int m_foul = -1;
        try {
            m_foul = ss[18] == null ? -1 : Integer.parseInt(ss[18].trim());
        } catch (Exception e) {

        }
        int m_score = -1;
        try {
            m_score = ss[19] == null ? -1 : Integer.parseInt(ss[19].trim());
        } catch (Exception e) {

        }
        int m_serialid = -1;
        try {
            m_serialid = ss[20] == null ? -1 : Integer.parseInt(ss[20].trim());
        } catch (Exception e) {

        }
        int m_d_tid = -1;
        try {
            m_d_tid = ss[21] == null ? -1 : Integer.parseInt(ss[21].trim());
        } catch (Exception e) {

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

    public void show() {
        for (int i = 0; i <= currentPoint; i++) {
            System.out.println(mid[i] + " " + pid[i] + " " + tid[i] + " "
                    + position[i] + " " + inplacetime[i] + " " + throwin[i] + " " + throwall[i] + " "
                    + throw3in[i] + " " + throw3all[i] + " " + penaltyin[i] + " " + penaltyall[i] + " "
                    + attackbas[i] + " " + defencebas[i] + " " + helpatt[i] + " " + interp[i] + " " +
                    block[i] + " " + mistake[i] + " " + foul[i] + " " + score[i] + " " + serialid[i]+" "
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
    public int get_sum_a_throwin(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_a_throwins(int size) {
        int[] sum_a_throwins = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.throwin[i] > 0) {
                int tid = this.tid[i];
                sum_a_throwins[tid - 1] = sum_a_throwins[tid - 1] + this.throwin[i];
            }
        }
        return sum_a_throwins;
    }

    /**
     * 根据队伍id，计算该队伍的对手总进球数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_throwin(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
            if (tid == this.d_tid[i]) {
                if (this.throwin[i] > 0)
                    result = result + this.throwin[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的对手总进球数
     *
     * @param size
     * @return
     */
    public int[] get_sum_b_throwins(int size) {
        int[] sum_b_throwins = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.throwin[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_throwins[tid - 1] = sum_b_throwins[tid - 1] + this.throwin[i];
            }
        }
        return sum_b_throwins;
    }

    /**
     * 根据队伍id，计算该队伍的总投球数
     *
     * @param tid
     * @return
     */
    public int get_sum_a_throwall(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_a_throwalls(int size) {
        int[] sum_a_throwalls = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.throwall[i] > 0) {
                int tid = this.tid[i];
                sum_a_throwalls[tid - 1] = sum_a_throwalls[tid - 1] + this.throwall[i];
            }
        }
        return sum_a_throwalls;
    }

    /**
     * 根据队伍id，计算该队伍的对手总投球数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_throwall(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_b_throwalls(int size) {
        int[] sum_b_throwalls = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.throwall[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_throwalls[tid - 1] = sum_b_throwalls[tid - 1] + this.throwall[i];
            }
        }
        return sum_b_throwalls;
    }

    /**
     * 根据队伍id，计算该队伍的总三分进球数
     *
     * @param tid
     * @return
     */
    public int get_sum_a_throw3in(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_a_throw3ins(int size) {
        int[] sum_a_throw3ins = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.throw3in[i] > 0) {
                int tid = this.tid[i];
                sum_a_throw3ins[tid - 1] = sum_a_throw3ins[tid - 1] + this.throw3in[i];
            }
        }
        return sum_a_throw3ins;
    }

    /**
     * 根据队伍id，计算该队伍的对手总三分进球数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_throw3in(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_b_throw3ins(int size) {
        int[] sum_b_throw3ins = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.throw3in[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_throw3ins[tid - 1] = sum_b_throw3ins[tid - 1] + this.throw3in[i];
            }
        }
        return sum_b_throw3ins;
    }
    /**
     * 根据队伍id，计算该队伍的总三分投球数
     *
     * @param tid
     * @return
     */
    public int get_sum_a_throw3all(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_a_throw3alls(int size) {
        int[] sum_a_throw3alls = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.throw3all[i] > 0) {
                int tid = this.tid[i];
                sum_a_throw3alls[tid - 1] = sum_a_throw3alls[tid - 1] + this.throw3all[i];
            }
        }
        return sum_a_throw3alls;
    }

    /**
     * 根据队伍id，计算该队伍的对手总三分投球数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_throw3all(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_b_throw3alls(int size) {
        int[] sum_b_throw3alls = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.throw3all[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_throw3alls[tid - 1] = sum_b_throw3alls[tid - 1] + this.throw3all[i];
            }
        }
        return sum_b_throw3alls;
    }

    /**
     * 根据队伍id，计算该队伍的总罚进球数
     *
     * @param tid
     * @return
     */
    public int get_sum_a_penaltyin(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_a_penaltyins(int size) {
        int[] sum_a_throwins = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.penaltyin[i] > 0) {
                int tid = this.tid[i];
                sum_a_throwins[tid - 1] = sum_a_throwins[tid - 1] + this.penaltyin[i];
            }
        }
        return sum_a_throwins;
    }

    /**
     * 根据队伍id，计算该队伍的对手总罚进球数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_penaltyin(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_b_penaltyins(int size) {
        int[] sum_b_penaltyins = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.penaltyin[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_penaltyins[tid - 1] = sum_b_penaltyins[tid - 1] + this.penaltyin[i];
            }
        }
        return sum_b_penaltyins;
    }

    /**
     * 根据队伍id，计算该队伍的总罚球数
     *
     * @param tid
     * @return
     */
    public int get_sum_a_penaltyall(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_a_penaltyalls(int size) {
        int[] sum_a_penaltyall = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.penaltyall[i] > 0) {
                int tid = this.tid[i];
                sum_a_penaltyall[tid - 1] = sum_a_penaltyall[tid - 1] + this.penaltyall[i];
            }
        }
        return sum_a_penaltyall;
    }

    /**
     * 根据队伍id，计算该队伍的对手总罚进球数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_penaltyall(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_b_penaltyalls(int size) {
        int[] sum_b_penaltyalls = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.penaltyall[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_penaltyalls[tid - 1] = sum_b_penaltyalls[tid - 1] + this.penaltyall[i];
            }
        }
        return sum_b_penaltyalls;
    }

    /**
     * 根据队伍id，计算该队伍的总进攻篮板数
     *
     * @param tid
     * @return
     */
    public int get_sum_a_attackbas(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_a_attackbass(int size) {
        int[] sum_a_attackbass = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.attackbas[i] > 0) {
                int tid = this.tid[i];
                sum_a_attackbass[tid - 1] = sum_a_attackbass[tid - 1] + this.attackbas[i];
            }
        }
        return sum_a_attackbass;
    }

    /**
     * 根据队伍id，计算该队伍的对手总进攻篮板数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_attackbas(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_b_attackbass(int size) {
        int[] sum_b_attackbass = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.attackbas[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_attackbass[tid - 1] = sum_b_attackbass[tid - 1] + this.attackbas[i];
            }
        }
        return sum_b_attackbass;
    }
    
    /**
     * 根据队伍id，计算该队伍的总防守篮板数
     *
     * @param tid
     * @return
     */
    public int get_sum_a_defencebas(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_a_defencebass(int size) {
        int[] sum_a_defencebass = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.defencebas[i] > 0) {
                int tid = this.tid[i];
                sum_a_defencebass[tid - 1] = sum_a_defencebass[tid - 1] + this.defencebas[i];
            }
        }
        return sum_a_defencebass;
    }

    /**
     * 根据队伍id，计算该队伍的对手总防守篮板数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_defencebas(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_b_defencebass(int size) {
        int[] sum_b_defencebass = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.defencebas[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_defencebass[tid - 1] = sum_b_defencebass[tid - 1] + this.defencebas[i];
            }
        }
        return sum_b_defencebass;
    }

    /**
     * 根据队伍id，计算该队伍的总篮板数
     *
     * @param tid
     * @return
     */
    public int get_sum_a_allbas(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_a_allbass(int size) {
        int[] sum_a_allbass = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.allbas[i] > 0) {
                int tid = this.tid[i];
                sum_a_allbass[tid - 1] = sum_a_allbass[tid - 1] + this.allbas[i];
            }
        }
        return sum_a_allbass;
    }

    /**
     * 根据队伍id，计算该队伍的对手总篮板数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_allbas(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_b_allbass(int size) {
        int[] sum_b_allbass = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.allbas[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_allbass[tid - 1] = sum_b_allbass[tid - 1] + this.allbas[i];
            }
        }
        return sum_b_allbass;
    }
    
    /**
     * 根据队伍id，计算该队伍的总助攻数
     *
     * @param tid
     * @return
     */
    public int get_sum_a_helpatt(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_a_helpatts(int size) {
        int[] sum_a_helpatts = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.helpatt[i] > 0) {
                int tid = this.tid[i];
                sum_a_helpatts[tid - 1] = sum_a_helpatts[tid - 1] + this.helpatt[i];
            }
        }
        return sum_a_helpatts;
    }

    /**
     * 根据队伍id，计算该队伍的对手总助攻数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_helpatt(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_b_helpatts(int size) {
        int[] sum_b_helpatts = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.helpatt[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_helpatts[tid - 1] = sum_b_helpatts[tid - 1] + this.helpatt[i];
            }
        }
        return sum_b_helpatts;
    }

    /**
     * 根据队伍id，计算该队伍的总抢断数
     *
     * @param tid
     * @return
     */
    public int get_sum_a_interp(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_a_interps(int size) {
        int[] sum_a_interps = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.interp[i] > 0) {
                int tid = this.tid[i];
                sum_a_interps[tid - 1] = sum_a_interps[tid - 1] + this.interp[i];
            }
        }
        return sum_a_interps;
    }

    /**
     * 根据队伍id，计算该队伍的对手总抢断数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_interp(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_b_interps(int size) {
        int[] sum_b_interps = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.interp[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_interps[tid - 1] = sum_b_interps[tid - 1] + this.interp[i];
            }
        }
        return sum_b_interps;
    }

    /**
     * 根据队伍id，计算该队伍的总盖帽数
     *
     * @param tid
     * @return
     */
    public int get_sum_a_block(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_a_blocks(int size) {
        int[] sum_a_blocks = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.block[i] > 0) {
                int tid = this.tid[i];
                sum_a_blocks[tid - 1] = sum_a_blocks[tid - 1] + this.block[i];
            }
        }
        return sum_a_blocks;
    }

    /**
     * 根据队伍id，计算该队伍的对手总盖帽数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_block(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_b_blocks(int size) {
        int[] sum_b_blocks = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.block[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_blocks[tid - 1] = sum_b_blocks[tid - 1] + this.block[i];
            }
        }
        return sum_b_blocks;
    }

    /**
     * 根据队伍id，计算该队伍的总失误数
     *
     * @param tid
     * @return
     */
    public int get_sum_a_mistake(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_a_mistakes(int size) {
        int[] sum_a_mistakes = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.mistake[i] > 0) {
                int tid = this.tid[i];
                sum_a_mistakes[tid - 1] = sum_a_mistakes[tid - 1] + this.mistake[i];
            }
        }
        return sum_a_mistakes;
    }

    /**
     * 根据队伍id，计算该队伍的对手总失误数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_mistake(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_b_mistakes(int size) {
        int[] sum_b_mistakes = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.mistake[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_mistakes[tid - 1] = sum_b_mistakes[tid - 1] + this.mistake[i];
            }
        }
        return sum_b_mistakes;
    }

    /**
     * 根据队伍id，计算该队伍的总罚球数
     *
     * @param tid
     * @return
     */
    public int get_sum_a_foul(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
            if (tid == this.tid[i]) {
                if (this.foul[i] > 0)
                    result = result + this.foul[i];
            }

        }
        return result;
    }

    /**
     * 获得所有的队伍的总罚球数
     *
     * @param size
     * @return
     */
    public int[] get_sum_a_fouls(int size) {
        int[] sum_a_fouls = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.foul[i] > 0) {
                int tid = this.tid[i];
                sum_a_fouls[tid - 1] = sum_a_fouls[tid - 1] + this.foul[i];
            }
        }
        return sum_a_fouls;
    }

    /**
     * 根据队伍id，计算该队伍的对手总罚球数
     *
     * @param tid
     * @return
     */
    public int get_sum_b_foul(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_b_fouls(int size) {
        int[] sum_b_fouls = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.foul[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_fouls[tid - 1] = sum_b_fouls[tid - 1] + this.foul[i];
            }
        }
        return sum_b_fouls;
    }

    /**
     * 根据队伍id，计算该队伍的总分
     *
     * @param tid
     * @return
     */
    public int get_sum_a_score(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_a_scores(int size) {
        int[] sum_a_scores = new int[size];
        for (int i = 0; i < currentPoint; i++) {
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
    public int get_sum_b_score(int tid) {
        int result = 0;
        for (int i = 0; i < currentPoint; i++) {
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
     * @param size
     * @return
     */
    public int[] get_sum_b_scores(int size) {
        int[] sum_b_scores = new int[size];
        for (int i = 0; i < currentPoint; i++) {
            if (this.score[i] > 0) {
                int tid = this.d_tid[i];
                sum_b_scores[tid - 1] = sum_b_scores[tid - 1] + this.score[i];
            }
        }
        return sum_b_scores;
    }

    private class TidL5Mid{
        private long lastModifiedTime;
        private int currentPoint;
        private int length;
        private int[] point;
        private int[] tid;
        private int tid_point;
        private int[] mid;

        TidL5Mid(){
            int size = 5000;
            point = new int[size];
            tid = new int[150];
            mid = new int[150];
            currentPoint = -1;
            tid_point = -1;
            for (int i = 0; i< PlayerScoreSaver.this.currentPoint; i++){
                int mid = PlayerScoreSaver.this.mid[i];
                int tid = PlayerScoreSaver.this.tid[i];
                currentPoint++;

            }
        }

        /**
         * 在缓存中查询是否属于最新五场比赛
         * @param tid
         * @param mid
         * @return
         */
        private boolean isL5Mid1(int tid, int mid){
            for (int i = 0; i<= tid_point;i++){
                if (this.tid[i]==tid && this.mid[i] == mid){
                    return true;
                }
            }
            return false;
        }

        /**
         * 在缓存中更新一条五场比赛信息
         * @param tid
         * @param mid
         */
        private void insertL5Mid1(int tid,int mid){
            if (tid_point < 149){
                tid_point++;
                this.tid[tid_point] = tid;
                this.mid[tid_point] = mid;
            }
        }

        private boolean isL5Mid2(int tid, int mid){

            return false;
        }
    }

    private class PidL5Mid{

        private long lastModifiedTime;
        private int length;
        private int size;
        private int[] pid;
        private int pid_point;
        private int[] mid;

        private PidL5Mid(){
            size = playerSaver.getNum()*5;
            pid = new int[size];
            mid = new int[size];
            pid_point = -1;
            length = 0;
            for (int i = 0; i<= currentPoint;i++){
                int pid1 = PlayerScoreSaver.this.pid[i];
                int mid1 = PlayerScoreSaver.this.mid[i];

                insert(pid1,mid1);
            }
        }

        /**
         * 插入一条记录
         * @param pid
         * @param mid
         */
        private void insert(int pid, int mid){
            ArrayList arrayList = new ArrayList();
            String date = matchInfoSaver.getDate(mid);
            for (int i = 0 ; i <= pid_point; i++){
                if (this.pid[i] == pid){
                    if (matchInfoSaver.getDate(this.mid[i]).compareTo(date) > 0){
                        return;
                    }

                    arrayList.add(i);
                }
            }

            if (arrayList.size() < 5){
                if (pid_point < size - 1) {
                    pid_point++;
                    length++;
                    this.pid[pid_point] = pid;
                    this.mid[pid_point] = mid;
                }
                return;
            }

            int temp = (int)arrayList.get(0);
            for (int i = 1;  i< arrayList.size(); i++){
                int a = (int) arrayList.get(i);
                if (matchInfoSaver.getDate(this.mid[temp]).compareTo(matchInfoSaver.getDate(this.mid[a])) > 0){
                    temp = a;
                }
            }

            this.pid[temp] = pid;
            this.mid[temp] = mid;
        }

        /**
         * 在缓存中查询是否属于最新五场比赛
         *
         * @param pid
         * @param mid
         * @return
         */
        private boolean isL5Mid1(int pid, int mid) {
            for (int i = 0; i <= pid_point; i++) {
                if (this.pid[i] == pid && this.mid[i] == mid) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 在缓存中更新一条五场比赛信息
         *
         * @param pid
         * @param mid
         */
        private void insertL5Mid1(int pid, int mid) {
            if (pid_point < size - 1) {
                for (int i = 0; i <= pid_point; i++) {
                    if (this.pid[i] == pid && this.mid[i] == mid)
                        return;
                }
                pid_point++;
                length++;
                this.pid[pid_point] = pid;
                this.mid[pid_point] = mid;
            }
        }

        /**
         * 在所有比赛信息中查询是否属于最新五场比赛
         * @param pid
         * @param mid
         * @return
         */
        private boolean isL5Mid2(int pid, int mid) {
            ArrayList mids = new ArrayList();
            String date = matchInfoSaver.getDate(mid);
            for (int i = 0; i <= currentPoint; i++) {
                if (pid == PlayerScoreSaver.this.pid[i]) {
                    if (matchInfoSaver.getDate(PlayerScoreSaver.this.mid[i]).compareTo(date) > 0)
                        mids.add(PlayerScoreSaver.this.mid[i]);
                }
            }
            if (mids.size() < 5){
                for (int i = 0; i < mids.size(); i++){
                    insertL5Mid1(pid,(int)mids.get(i));
                }
                insertL5Mid1(pid,mid);
                return true;
            }
            return false;
        }

        /**
         * 返回上次修改时间
         * @return
         */
        public long getLastModifiedTime(){
            return lastModifiedTime;
        }

        public int getLength(){
            return length;
        }

        public void show(){
            for (int i = 0; i<=pid_point;i++){
                System.out.println(pid[i]+" "+mid[i]);
            }
        }
    }

    private PidL5Mid pidL5Mid;

    /**
     * 数据插入完成后计算最新五场比赛信息表
     */
    public void setPidL5Mid(){
        if (pidL5Mid == null)
            pidL5Mid = new PidL5Mid();
        else if (pidL5Mid.getLastModifiedTime() < this.lastModifiedTime)
            pidL5Mid = new PidL5Mid();
    }

    /**
     * 获得最新五场比赛表
     * @return
     */
    public PidL5Mid getPidL5Mid(){
        setPidL5Mid();
        return pidL5Mid;
    }

    /**
     *
     */
    public void showPIdL5Mid(){
        pidL5Mid.show();
    }

}


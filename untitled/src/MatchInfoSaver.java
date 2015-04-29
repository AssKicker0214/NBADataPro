import java.util.ArrayList;

/**
 * Created by chenghao on 15/4/21.
 */
public class MatchInfoSaver {
    private long lastModifiedTime;
    private int currentPoint;
    private int[] mid;
    private String[] matchtime;
    private int[] teamf;
    private int[] teaml;
    private int[] allscoref;
    private int[] allscorel;
    private TidL5Mid tidL5Mid;

    public MatchInfoSaver() {
        int size = 4096;
        mid = new int[size];
        matchtime = new String[size];
        teamf = new int[size];
        teaml = new int[size];
        allscoref = new int[size];
        allscorel = new int[size];
        currentPoint = -1;
        refreshTime();
    }

    /**
     * When the data modified,update the lastModifiedTime
     */
    private void refreshTime() {
        lastModifiedTime = System.currentTimeMillis();
    }

    /**
     * 插入一条新的比赛信息
     *
     * @param ss
     * @return
     */
    public int insert(String[] ss) {
        String m_matchtime = ss[0] == null ? null : ss[0].trim();
        int m_teamf = ss[1] == null ? -1 : Integer.parseInt(ss[1].trim());
        int m_teaml = ss[2] == null ? -1 : Integer.parseInt(ss[2].trim());
        int m_allscoref = ss[3] == null ? -1 : Integer.parseInt(ss[3].trim());
        int m_allscorel = ss[4] == null ? -1 : Integer.parseInt(ss[4].trim());

        currentPoint++;
        mid[currentPoint] = currentPoint + 1;
        matchtime[currentPoint] = m_matchtime;
        teamf[currentPoint] = m_teamf;
        teaml[currentPoint] = m_teaml;
        allscoref[currentPoint] = m_allscoref;
        allscorel[currentPoint] = m_allscorel;

        return currentPoint + 1;
    }

    public void show() {
        for (int i = 0; i <= currentPoint; i++) {
            System.out.println(mid[i] + " " + matchtime[i] + " " + teamf[i] + " " + teaml[i] + " "
                    + allscoref[i] + " " + allscorel[i]);
        }
    }

    /**
     * 获得一场比赛中对方队伍的id
     *
     * @param tid
     * @param mid
     * @return
     */
    public int get_battle_tid(int tid, int mid) {
        for (int i = 0; i <= currentPoint; i++) {
            if (this.mid[i] == mid) {
                if (this.teamf[i] == tid)
                    return this.teaml[i];
                if (this.teaml[i] == tid)
                    return this.teamf[i];
            }
        }
        return -1;
    }

    /**
     * 获得mid对应的比赛日期
     *
     * @param mid
     * @return
     */
    public String getDate(int mid) {
        if (mid <= currentPoint + 1)
            return this.matchtime[mid - 1];
        return null;
    }

    /**
     * 数据插入完成后计算最新五场比赛信息表
     */
    public void setTidL5Mid() {
        if (tidL5Mid == null)
            tidL5Mid = new TidL5Mid();
        else if (tidL5Mid.getLastModifiedTime() < this.lastModifiedTime)
            tidL5Mid = new TidL5Mid();
    }

    /**
     * 获得最新五场比赛表
     *
     * @return
     */
    public TidL5Mid getTidL5Mid() {
        setTidL5Mid();
        return tidL5Mid;
    }

    public int getNum() {
        return currentPoint + 1;
    }

    private class TidL5Mid {
        private long lastModifiedTime;
        private int length;
        private int[] tid;
        private int tid_point;
        private int[] mid;

        TidL5Mid() {
            tid = new int[150];
            mid = new int[150];
            tid_point = -1;
            length = 0;
            for (int i = 0; i <= currentPoint; i++) {
                int tid1 = MatchInfoSaver.this.teamf[i];
                int tid2 = MatchInfoSaver.this.teaml[i];
                int mid1 = MatchInfoSaver.this.mid[i];

                insert(tid1, mid1);
                insert(tid2, mid1);
            }
        }

        /**
         * 插入一条记录
         *
         * @param tid
         * @param mid
         */
        private void insert(int tid, int mid) {
            if (isL5Mid1(tid, mid)) {
                return;
            } else if (isL5Mid2(tid, mid)) {
                return;
            }
        }

        /**
         * 在缓存中查询是否属于最新五场比赛
         *
         * @param tid
         * @param mid
         * @return
         */
        private boolean isL5Mid1(int tid, int mid) {
            for (int i = 0; i <= tid_point; i++) {
                if (this.tid[i] == tid && this.mid[i] == mid) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 在缓存中更新一条五场比赛信息
         *
         * @param tid
         * @param mid
         */
        private void insertL5Mid1(int tid, int mid) {
            if (tid_point < 149) {
                for (int i = 0; i <= tid_point; i++) {
                    if (this.tid[i] == tid && this.mid[i] == mid)
                        return;
                }
                tid_point++;
                length++;
                this.tid[tid_point] = tid;
                this.mid[tid_point] = mid;
            }
        }

        /**
         * 在所有比赛信息中查询是否属于最新五场比赛
         *
         * @param tid
         * @param mid
         * @return
         */
        private boolean isL5Mid2(int tid, int mid) {
            ArrayList mids = new ArrayList();
            String date = getDate(mid);
            for (int i = 0; i <= currentPoint; i++) {
                if (MatchInfoSaver.this.teamf[i] == tid ||
                        MatchInfoSaver.this.teaml[i] == tid) {
                    if (MatchInfoSaver.this.matchtime[i].compareTo(date) > 0)
                        mids.add(MatchInfoSaver.this.mid[i]);
                }
            }
            if (mids.size() < 5) {
                for (int i = 0; i < mids.size(); i++) {
                    insertL5Mid1(tid, (int) mids.get(i));
                }
                insertL5Mid1(tid, mid);
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
    }

    /**
     * 返回上次修改时间
     *
     * @return
     */
    public long getLastModifiedTime() {
        return lastModifiedTime;
    }

}

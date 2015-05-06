package data.saver;

import java.util.ArrayList;
import java.util.Comparator;

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
    public static final int DEFAULT = 1;
    public static final int L5MID = 2;
    public static final int BEFORE = 3;

    private static MatchInfoSaver matchInfoSaver;

    private MatchInfoSaver() {
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

    public static MatchInfoSaver getMatchInfoSaver(){
        if (matchInfoSaver == null){
            matchInfoSaver = new MatchInfoSaver();
        }
        return matchInfoSaver;
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

        refreshTime();

        return currentPoint + 1;
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

    public int[] getHomePoint() {
        return this.allscoref;
    }

    public int[] getGuestPoint() {
        return this.allscorel;
    }

    public int[] getTeamf() {
        return teamf;
    }

    public int[] getTeaml() {
        return teaml;
    }

    public ArrayList<Integer> getFindRecentMatches_t(int tid) {
        ArrayList<Integer> res  = new ArrayList<>();
        TidL5Mid tidL5Mid = getTidL5Mid();
        int[] points = tidL5Mid.getPointInL5Mid();
        for (int i = 0;i<tidL5Mid.getPointInL5Mid().length;i++){
            int j = points[i];
            if ((teamf[j] == tid || teaml[j] == tid)){
                res.add(j + 1);
            }
        }
        return res;
    }

    public ArrayList<Integer> getMids(String start, String end) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= currentPoint; i++){
            if (matchtime[i].compareTo(start) >= 0 && matchtime[i].compareTo(end)<=0){
                res.add(i + 1);
            }
        }
        return res;
    }

    public  boolean isInDate(int i, String start, String end) {
        return matchtime[i - 1].compareTo(start) >= 0 && matchtime[i - 1].compareTo(end) <= 0;
    }

    public ArrayList<Integer> getFindMatches_t(String start, String end, int tid) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i<=currentPoint;i++){
            if ((teamf[i] == tid || teaml[i] == tid) && matchtime[i].compareTo(start) >= 0 && matchtime[i].compareTo(end)<=0){
                arrayList.add(i + 1);
            }
        }
        return arrayList;
    }

    public ArrayList<Integer> findRecent20() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0 ; i <=currentPoint;i++){
            arrayList.add(i);
        }

        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int res = MatchInfoSaver.this.matchtime[o1].compareTo(MatchInfoSaver.this.matchtime[o2]);
                if (res != 0){
                    return res * -1;
                }else {
                    return o2 - o1;
                }
            }
        });
        return arrayList;
    }

    public void show() {
        for (int i = 0; i <= currentPoint;i++){
            System.out.println("mid:"+mid[i]+" date:"+matchtime[i]);
        }
    }

    private class TidL5Mid {
        private long lastModifiedTime;
        private int length;
        private int[] tid;
        private int tid_point;
        private int[] mid;
        private int[] pointInL5Mid;
        private int size;

        TidL5Mid() {
            this.size = 150;
            tid = new int[size];
            mid = new int[size];
            pointInL5Mid = new int[size / 2];
            tid_point = -1;
            length = 0;
            for (int i = 0; i <= currentPoint; i++) {
                insert(i);
            }
        }

        /**
         * 插入一条记录
         */
        private void insert(int m) {
            int tid1 = MatchInfoSaver.this.teamf[m];
            int tid2 = MatchInfoSaver.this.teaml[m];
            int mid1 = MatchInfoSaver.this.mid[m];

            int[] arrayList = new int[5];
            int size = 0;
            String date = getDate(mid1);
            for (int i = 0; i <= tid_point; i++) {
                if (this.tid[i] == tid1) {

                    arrayList[size] = i;
                    size++;
                    if (size == 5)
                        break;
                }
            }

            if (size < 5) {
                if (tid_point < this.size - 1) {
                    tid_point++;
                    length++;
                    this.tid[tid_point] = tid1;
                    this.mid[tid_point] = mid1;
                    tid_point++;
                    length++;
                    this.tid[tid_point] = tid2;
                    this.mid[tid_point] = mid1;
                    this.pointInL5Mid[tid_point / 2] = m;
                }
                refreshTime();
                return;
            }

            int temp = arrayList[0];
            for (int i = 0; i < size; i++) {
                int a = arrayList[i];
                if (getDate(this.mid[temp]).compareTo(getDate(this.mid[a])) > 0) {
                    temp = a;
                }
            }

            if (date.compareTo(getDate(this.mid[temp])) > 0) {
                if (temp % 2 == 0) {
                    this.tid[temp] = tid1;
                    this.mid[temp] = mid1;
                    this.tid[temp + 1] = tid2;
                    this.mid[temp + 1] = mid1;
                } else {
                    this.tid[temp] = tid1;
                    this.mid[temp] = mid1;
                    this.tid[temp - 1] = tid2;
                    this.mid[temp - 1] = mid1;
                }
                this.pointInL5Mid[temp / 2] = m;
                return;
            }

        }

        private boolean isL5Mid(int m) {
            for (int i = 0; i < length / 2; i++) {
                if (pointInL5Mid[i] == m) {
                    return true;
                }
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

        private void refreshTime() {
            lastModifiedTime = System.currentTimeMillis();
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

    public int[][] getMatchNum(int type) {
        int[][] res = new int[2][30];
        int[] points;
        int length;
        if (type == DEFAULT) {
            points = tidDefaultMid;
            length = tidDefaultMid.length;
        } else if (type == L5MID) {
            points = getTidL5Mid().getPointInL5Mid();
            length = getTidL5Mid().getLength() / 2;
        } else {
            points = tidBeforeMid;
            length = tidBeforeMid.length;
        }

        for (int j = 0; j < length; j++) {
            int i = points[j];
            int mid = this.mid[i];
            int teamf = this.teamf[i];
            int teaml = this.teaml[i];

            int score1 = this.allscoref[i];
            int score2 = this.allscorel[i];

            if (score1 > score2) {
                res[0][teamf - 1] = res[0][teamf - 1] + 1;
            }

            if (score1 < score2) {
                res[0][teaml - 1] = res[0][teaml - 1] + 1;
            }

            res[1][teamf - 1] = res[1][teamf - 1] + 1;
            res[1][teaml - 1] = res[1][teaml - 1] + 1;
        }
        return res;
    }

    private int[] tidDefaultMid;
    private int[] tidBeforeMid;

    public void setMid() {
        tidDefaultMid = new int[getNum()];
        tidBeforeMid = new int[getNum() - (getTidL5Mid().length / 2)];

        int m = 0;
        for (int i = 0; i <= currentPoint; i++) {
            tidDefaultMid[i] = i;
            if (!getTidL5Mid().isL5Mid(i)) {
                tidBeforeMid[m] = i;
                m++;
            }
        }
    }

    public void update() {
        setTidL5Mid();
        setMid();
    }

}

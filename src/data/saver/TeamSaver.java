package data.saver;

/**
 * Created by chenghao on 15/4/21.
 */
public class TeamSaver {
    private long lastModifiedTime;
    private int currentPoint;
    private int[] tid;
    private String[] fullname;
    private String[] abbreviation;
    private String[] location;
    private char[] area;
    private String[] subarea;
    private String[] homefield;
    private int[] establishmenttime;

    private static TeamSaver teamSaver;
    public static TeamSaver getTeamSaver(){
        if (teamSaver == null){
            teamSaver = new TeamSaver();
        }
        return teamSaver;
    }


    private TeamSaver() {
        tid = new int[30];
        fullname = new String[30];
        abbreviation = new String[30];
        location = new String[30];
        area = new char[30];
        subarea = new String[30];
        homefield = new String[30];
        establishmenttime = new int[30];
        currentPoint = -1;
        lastModifiedTime = System.currentTimeMillis();
    }

    /**
     * 插入一条新的队伍信息
     *
     * @param ss
     * @return
     */
    public boolean insert(String[] ss) {
        String m_fullname = ss[0].trim();
        String m_abbreviation = ss[1].trim();
        String m_location = ss[2].trim();
        char m_area = ss[3].trim().charAt(0);
        String m_subarea = ss[4].trim();
        String m_homefield = ss[5].trim();
        int m_establishmenttime = -1;
        try {
            m_establishmenttime = Integer.parseInt(ss[6].trim());
        } catch (Exception e) {

        }
        currentPoint++;
        tid[currentPoint] = currentPoint + 1;
        fullname[currentPoint] = m_fullname;
        abbreviation[currentPoint] = m_abbreviation;
        location[currentPoint] = m_location;
        area[currentPoint] = m_area;
        subarea[currentPoint] = m_subarea;
        homefield[currentPoint] = m_homefield;
        establishmenttime[currentPoint] = m_establishmenttime;
        refreshTime();
        return true;
    }

    private void refreshTime() {
        lastModifiedTime = System.currentTimeMillis();
    }

    public void show() {
        for (int i = 0; i < currentPoint; i++) {
            System.out.println(tid[i] + " " + fullname[i] + " "
                    + abbreviation[i] + " "
                    + location[i] + " " + area[i] + " "
                    + subarea[i] + " " + homefield[i] + " "
                    + establishmenttime[i]);
        }
    }

    /**
     * 返回缩写的对应的tid,-1代表找不到
     *
     * @param abbreviation
     * @return
     */
    public int getTid(String abbreviation) {
        for (int i = 0; i <= currentPoint; i++) {
            if (abbreviation.equals(this.abbreviation[i]))
                return i + 1;
        }
        return -1;
    }

    public int getNum() {
        return currentPoint + 1;
    }

    /**
     * 返回上次修改时间
     * @return
     */
    public long getLastModifiedTime(){
        return lastModifiedTime;
    }

    public String[] getPhoto() {
        return abbreviation;
    }

    public String[] getTeamName() {
        return fullname;
    }

    public String[] getAbridge() {
        return abbreviation;
    }

    public String[] getLocation() {
        return location;
    }

    public char[] getLeague() {
        return area;
    }

    public String[] getDivision() {
        return subarea;
    }

    public String[] getHomeCourt() {
        return homefield;
    }

    public int[] getFoundTime() {
        return establishmenttime;
    }


    public int getTeamId(String teamName) {
        for (int i = 0; i < currentPoint + 1;i++){
            if (this.fullname[i].equals(teamName))
                return i + 1;
        }
        return 0;
    }

}

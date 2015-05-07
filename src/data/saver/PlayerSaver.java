package data.saver;

/**
 * Created by chenghao on 15/4/21.
 */
public class PlayerSaver {
    /**
     * 特殊数值定义空
     * pid 不能为空
     * name 不能为空
     * number -1
     * position null
     * heightfoot -1
     * heightinch -1
     * weight -1
     * birth null
     * age -1
     * exp -1
     * school null
     * imgsrc null
     */
    private long lastModifiedTime;
    private int currentPoint;
    private int[] pid;
    private String[] name;
    private int[] number;
    private String[] position;
    private int[] heightfoot;
    private int[] heightinch;
    private int[] weight;
    private String[] birth;
    private int[] age;
    private int[] exp;
    private String[] school;
    private String[] imgsrc;

    private static PlayerSaver playerSaver;
    public static PlayerSaver getPlayerSaver(){
        if (playerSaver == null){
            playerSaver = new PlayerSaver();
        }
        return playerSaver;
    }

    private PlayerSaver() {
        int size = 5000;
        pid = new int[size];
        name = new String[size];
        number = new int[size];
        position = new String[size];
        heightfoot = new int[size];
        heightinch = new int[size];
        weight = new int[size];
        birth = new String[size];
        age = new int[size];
        exp = new int[size];
        school = new String[size];
        imgsrc = new String[size];
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
     * 插入一条新的球员信息
     *
     * @param ss
     * @return
     */
    public int insert(String[] ss) {
        ss = expand(ss);
        String m_name = ss[0] == null ? null : ss[0].trim();
        int m_number = -1;
        try {
            m_number = ss[1] == null ? -1 : Integer.parseInt(ss[1].trim());
        } catch (Exception e) {

        }
        String m_position = ss[2] == null ? null : ss[2].trim();
        int m_heightfoot = -1;
        try {
            m_heightfoot = ss[3] == null ? -1 : Integer.parseInt(ss[3].trim());
        } catch (Exception e) {

        }
        int m_heightinch = -1;
        try {
            m_heightinch = ss[4] == null ? -1 : Integer.parseInt(ss[4].trim());
        } catch (Exception e) {

        }
        int m_weight = -1;
        try {
            m_weight = ss[5] == null ? -1 : Integer.parseInt(ss[5].trim());
        } catch (Exception e) {

        }
        String m_birth = ss[6] == null ? null : ss[6].trim();
        int m_age = -1;
        try {
            m_age = ss[7] == null ? -1 : Integer.parseInt(ss[7].trim());
        } catch (Exception e) {

        }
        int m_exp = -1;
        try {
            m_exp = ss[8] == null ? -1 : Integer.parseInt(ss[8].trim());
        } catch (Exception e) {

        }
        String m_school = ss[9] == null ? null : ss[9].trim();
        String m_imgsrc = ss[10] == null ? null : ss[10].trim();

        currentPoint++;
        pid[currentPoint] = currentPoint + 1;
        name[currentPoint] = m_name;
        number[currentPoint] = m_number;
        position[currentPoint] = m_position;
        heightfoot[currentPoint] = m_heightfoot;
        heightinch[currentPoint] = m_heightinch;
        weight[currentPoint] = m_weight;
        birth[currentPoint] = m_birth;
        age[currentPoint] = m_age;
        exp[currentPoint] = m_exp;
        school[currentPoint] = m_school;
        imgsrc[currentPoint] = m_imgsrc;
        refreshTime();
        return currentPoint+1;
    }

    /**
     * 将要插入的信息数组用null扩展到匹配大小
     *
     * @param ss
     * @return
     */
    private String[] expand(String[] ss) {
        if (ss.length > 11) {
            return ss;
        } else {
            String[] new_ss = new String[11];
            for (int i = 0; i < ss.length; i++) {
                new_ss[i] = ss[i];
            }
            for (int i = ss.length; i < 11; i++) {
                new_ss[i] = null;
            }
            return new_ss;
        }
    }

    public void show() {
        for (int i = 0; i <= currentPoint; i++) {
            System.out.println(pid[i] + " " + name[i] + " " + number[i] + " " +
                    position[i] + " " + heightfoot[i] + " " + heightinch[i] + " " +
                    weight[i] + " " + birth[i] + " " + age[i] + " " + exp[i] + " " +
                    school[i] + " " + imgsrc[i]);

        }
    }

    /**
     * 根据球员名称返回对应的id编号
     * @param name
     * @return
     */
    public int getPid(String name){
        for (int i = 0; i<= currentPoint; i++){
            if (this.name[i].equals(name))
                return this.pid[i];
        }
        return -1;
    }

    public int getNum() {
        return currentPoint + 1;
    }

    public String[] getPhoto() {
        return imgsrc;
    }

    public String[] getName() {
        return name;
    }

    public int[] getNumber() {
        return number;
    }

    public int[] getAge() {
        return age;
    }

    public int getPlayerId(String name) {
        for (int i = 0; i<= currentPoint; i++){
            if (this.name[i].equals(name)){
                return i+1;
            }
        }
        return 0;
    }

    public String[] getSchool() {
        return school;
    }

    public String[] getBirth() {
        return birth;
    }

    public int[] getExp() {
        return exp;
    }

    public int[] getWeight() {
        return weight;
    }

    public int[] getHeight1() {
        return heightfoot;
    }

    public int[] getHeight2() {
        return heightinch;
    }

    public String[] getPosition() {
        return position;
    }
}

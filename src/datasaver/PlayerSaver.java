package datasaver;

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

    /**
     * When the data modified,update the lastModifiedTime
     */
    private void refreshTime(){
        lastModifiedTime = System.currentTimeMillis();
    }

    public boolean insert(Object[] objects){
        refreshTime();
        return false;
    }
}

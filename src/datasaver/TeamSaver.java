package datasaver;

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

    private void refreshTime(){
        lastModifiedTime = System.currentTimeMillis();
    }

    public boolean insert(Object[] objects){
        refreshTime();
        return false;
    }
}

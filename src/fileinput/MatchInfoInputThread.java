package fileinput;

import java.io.File;

/**
 * Created by chenghao on 15/4/13.
 */
public class MatchInfoInputThread extends Thread {
    private File[] files;
    private int start;
    private int end;

    public MatchInfoInputThread(File[] files, int start, int end) {
        this.files = files;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (files[i].isDirectory() == false) {
                try {
                    new MatchInfoInputReader().readMatch(files[i]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();

                }
            }
        }
    }
}

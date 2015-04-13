package fileinput;

import java.io.File;
import java.util.concurrent.CountDownLatch;

/**
 * Created by chenghao on 15/4/13.
 */
public class MatchInfoInput {
    public void readMatch() {

        File file = new File("/Users/chenghao/Documents/迭代一数据/matches");
        File[] files = file.listFiles();
        int gap = 100;
        int num = (int) Math.ceil(((double) files.length)/gap);
//        for (int i = 0; i < files.length; i = i + gap) {
//            if (i + gap < files.length)
//                new MatchInfoInputThread(files, i, i + gap).start();
//            else
//                new MatchInfoInputThread(files, i, files.length).start();
//        }
        for (int i = 0;i < files.length;i++){
            new MatchInfoInputReader().readMatch(files[i]);
        }

    }
}

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

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory() == false)
                new MatchInfoInputReader().readMatch(files[i]);
        }

    }
}

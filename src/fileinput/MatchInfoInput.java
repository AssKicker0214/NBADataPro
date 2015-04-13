package fileinput;

import java.io.File;

/**
 * Created by chenghao on 15/4/13.
 */
public class MatchInfoInput {
    public void readMatch() {

        File file = new File("/Users/chenghao/Documents/迭代一数据/matches");
        File[] files = file.listFiles();
        int gap = 100;
        for (int i = 0; i < files.length; i = i + gap) {
            if (i + gap < files.length)
                new MatchInfoInputThread(files, i, i + gap);
            else
                new MatchInfoInputThread(files, i, files.length);
        }
//        for (int i = 0;i < files.length;i++){
//            new MatchInfoInputReader().readMatch(files[i]);
//        }

    }
}

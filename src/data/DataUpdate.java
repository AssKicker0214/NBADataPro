package data;

import data.input.FileName;
import data.input.Match;
import data.saver.*;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by chenghao on 15/4/30.
 */
public class DataUpdate extends Thread {
    private FileName fileName;

    private String path;

    public DataUpdate(String path) {
        this.fileName = FileName.getFileName();
        this.path = path;
    }

    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            checker();
        }
    }

    private void checker() {
        File file = new File(path);
        File[] files = file.listFiles();
        int size = 0;
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isDirectory()) {
                size++;
            }
        }
        if (size > fileName.getSize()) {
            ArrayList<File> arrayList = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                if (!files[i].isDirectory()) {
                    String name = files[i].getName();
                    if (fileName.isInList(name) == false) {
                        arrayList.add(files[i]);
                    }
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                Match.insert(arrayList.get(i), MatchInfoSaver.getMatchInfoSaver(), TeamSaver.getTeamSaver(), PlayerSaver.getPlayerSaver(), PlayerScoreSaver.getPlayerScoreSaver(), MatchScoreSaver.getMatchScoreSaver());
            }
//        new Match().insert();
        }
    }
}

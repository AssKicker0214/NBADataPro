package data;

import data.input.FileName;
import data.input.Match;
import data.saver.*;
import dataservice.Updatable;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by chenghao on 15/4/30.
 */
public class DataUpdate extends Thread {
    private FileName fileName;
    private ArrayList<Updatable> updatables = new ArrayList<>();
    private String path;
    private boolean flag = true;
    public DataUpdate(String path) {
        this.fileName = FileName.getFileName();
        this.path = path;
    }

    @Override
    public void run(){
        while (flag){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            checker();
        }
    }

    public void end(){
        flag = false;
    }

    private void checker() {
        File file = new File(path);
        File[] files = file.listFiles();
        int size = 0;
        for (int i = 0; i < files.length; i++) {
            if ((files[i].isDirectory()==false) && (files[i].getName().trim().startsWith(".") == false)) {
//                System.out.println(files[i].getName());
                size++;
            }
        }
        if (size > fileName.getSize()) {
            ArrayList<File> arrayList = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                if (!files[i].isDirectory()) {
                    String name = files[i].getName();
                    if ((files[i].isDirectory()==false) && (files[i].getName().trim().startsWith(".") == false) && (fileName.isInFileName(files[i])==false)) {
                        arrayList.add(files[i]);
                    }
                }
            }

            if (arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    Match.insert(arrayList.get(i), MatchInfoSaver.getMatchInfoSaver(), TeamSaver.getTeamSaver(), PlayerSaver.getPlayerSaver(), PlayerScoreSaver.getPlayerScoreSaver(), MatchScoreSaver.getMatchScoreSaver());
                }
//        new Match().insert();
                for (int i = 0; i < updatables.size(); i++){
                    updatables.get(i).update();
                }
            }

        }
    }

    public void add(Updatable updatable) {
        updatables.add(updatable);
    }
}

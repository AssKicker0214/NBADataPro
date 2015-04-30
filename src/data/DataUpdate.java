package data;

import data.input.FileName;
import data.saver.MatchInfoSaver;
import data.saver.PlayerScoreSaver;
import data.saver.TeamSaver;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by chenghao on 15/4/30.
 */
public class DataUpdate extends Thread {
    private FileName fileName;
    private PlayerScoreSaver playerScoreSaver;
    private MatchInfoSaver matchInfoSaver;
    private TeamSaver teamSaver;
    private String path;

    public DataUpdate(){
        this.fileName = FileName.getFileName();
    }

    private void checker(){
        File file = new File(path);
        File[] files = file.listFiles();
        int size = 0;
        for ( int i = 0; i < files.length; i++){
            if (!files[i].isDirectory()){
                size++;
            }
        }
        if (size > fileName.getSize()){
            ArrayList<File> arrayList = new ArrayList<>();
            for ( int i = 0; i < files.length; i++){
                if (!files[i].isDirectory()){
                    String name = files[i].getName();
                    if (fileName.isInList(name) == false){
                        arrayList.add(files[i]);
                    }
                }
            }


        }
    }
}

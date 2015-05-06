package data.input;

import java.util.ArrayList;

/**
 * Created by chenghao on 15/4/30.
 */
public class FileName {
    private ArrayList<String> arrayList;
    private static FileName fileName;

    private FileName(){
        arrayList = new ArrayList<>();
    }

    public static FileName getFileName(){
        if (fileName == null){
            fileName = new FileName();
        }
        return fileName;
    }

    public void add(String name){
        if (isInList(name))
            return;
        arrayList.add(name);
    }

    public boolean isInList(String name){
        for (int i = 0;i < arrayList.size(); i++){
            if (arrayList.get(i).equals(name)){
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return arrayList.size();
    }
}

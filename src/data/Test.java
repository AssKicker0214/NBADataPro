package data;

import data.saver.PlayerSaver;
import data.saver.PlayerScoreSaver;

/**
 * Created by chenghao on 15/5/7.
 */
public class Test {
    public static void main(String[] args){
        DataInitial.init();
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println("---------------start----------------");
                PlayerSaver.getPlayerSaver().show();
                System.out.println("---------------end----------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

import org.junit.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by chenghao on 15/4/23.
 */
public class PlayerTest {
    private PlayerSaver playerSaver;


    public PlayerTest(PlayerSaver playerSaver){
        this.playerSaver = playerSaver;
    }

    public void test(){
        readPlayer("/Users/chenghao/Documents/迭代一数据/players/info");
    }

    public static void main(String[] args){
        PlayerSaver playerSaver = new PlayerSaver();
        PlayerTest playerTest = new PlayerTest(playerSaver);
        playerTest.readPlayer("/Users/chenghao/Documents/迭代一数据/players/info");
        playerSaver.show();
    }

    public void readPlayer(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        try {
            for (int m = 0; m < files.length; m++) {

                if (!files[m].isDirectory()) {
                    if (files[m].getName().startsWith("."))
                        continue;
                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new InputStreamReader(
                                new FileInputStream(files[m])));
                        String input = null;
                        br.readLine();
                        String[] buffs = new String[9];
                        int i = 0;
                        while ((input = br.readLine()) != null) {
                            input = input.trim();
                            input = input.substring(1, input.length() - 1);
                            if (input.startsWith("═") || input.startsWith("─"))
                                continue;
                            String[] ss = input.split("│");
                            buffs[i] = ss[1].trim();
                            i++;
                        }
                        buffs[5] = changeDate(buffs[5]);
                        String[] objects = change(buffs);

                        playerSaver.insert(objects);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (br != null) {
                            try {
                                br.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }

                /*
                 * for (int j = 0; j < objects.length; j++){
				 * System.out.print(objects[j]+","); } System.out.println();
				 */

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String changeDate(String s) {
        String date = "";
        String[] ss = s.split(" ");
        date = ss[2].trim() + "-";
        if (ss[0].equals("JAN"))
            date += "1-";
        else if (ss[0].equals("FEB"))
            date += "2-";
        else if (ss[0].equals("MAR"))
            date += "3-";
        else if (ss[0].equals("APR"))
            date += "4-";
        else if (ss[0].equals("MAY"))
            date += "5-";
        else if (ss[0].equals("JUN"))
            date += "6-";
        else if (ss[0].equals("JUL"))
            date += "7-";
        else if (ss[0].equals("AUG"))
            date += "8-";
        else if (ss[0].equals("SEP"))
            date += "9-";
        else if (ss[0].equals("OCT"))
            date += "10-";
        else if (ss[0].equals("NOV"))
            date += "11-";
        else if (ss[0].equals("DEC"))
            date += "12-";
        date += ss[1].substring(0, ss[1].length() - 1);
        return date;
    }

    public static String[] change(String[] ss) {
        String[] objects = new String[11];
        for (int i = 0; i < 3; i++) {
            objects[i] = ss[i];
        }
        objects[3] = ss[3].split("-")[0];
        objects[4] = ss[3].split("-")[1];
        for (int i = 5; i < 10; i++) {
            objects[i] = ss[i - 1];
        }
        objects[10] = ss[0];
        return objects;
    }

    public static int getIndex(String s) {

        if (s.equals("name")) {
            return 0;
        } else if (s.equals("number")) {
            return 1;
        } else if (s.equals("position")) {
            return 2;
        } else if (s.equals("heightfoot")) {
            return 3;
        } else if (s.equals("heightinch")) {
            return 4;
        } else if (s.equals("weight")) {
            return 5;
        } else if (s.equals("birth")) {
            return 6;
        } else if (s.equals("age")) {
            return 7;
        } else if (s.equals("exp")) {
            return 8;
        } else if (s.equals("school")) {
            return 9;
        } else if (s.equals("imgsrc")) {
            return 10;
        }
        return -1;
    }
}

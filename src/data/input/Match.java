package data.input;

import data.saver.*;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenghao on 15/4/23.
 */
public class Match {

    private static boolean isInit = false;

    public void init() {
        if (isInit == false){
            File file = new File(path);
            File[] files = file.listFiles();
            MatchInfoSaver matchInfoSaver = MatchInfoSaver.getMatchInfoSaver();
            PlayerScoreSaver playerScoreSaver = PlayerScoreSaver.getPlayerScoreSaver();
            MatchScoreSaver matchScoreSaver = MatchScoreSaver.getMatchScoreSaver();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() == false && files[i].getName().startsWith(".") == false)
                    insert(files[i], matchInfoSaver, TeamSaver.getTeamSaver(), PlayerSaver.getPlayerSaver(), playerScoreSaver, matchScoreSaver);
            }
            matchInfoSaver.update();
            playerScoreSaver.update();
            isInit = true;
        }
    }

    private String path;

    public Match(String path) {
        this.path = path;
    }

    public static void insert(File file, MatchInfoSaver matchInfoSaver,
                              TeamSaver teamSaver, PlayerSaver playerSaver,
                              PlayerScoreSaver playerScoreSaver,
                              MatchScoreSaver matchScoreSaver) {
        BufferedReader br = null;
        try {
            String title = file.getName();
            FileName.getFileName().add(title);
            String input = null;
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file),"utf-8"));
            input = br.readLine();
            String[] matchinfo = getMatchInfo(title, input);
            int teamf = teamSaver.getTid(matchinfo[1]);
            if (teamf == -1) {
                System.err.println("CAN NOT FOUND TEAM " + matchinfo[1]);
            }
            matchinfo[1] = String.valueOf(teamf);
            int teaml = teamSaver.getTid(matchinfo[2]);
            if (teaml == -1) {
                System.err.println("CAN NOT FOUND TEAM " + matchinfo[2]);
            }
            matchinfo[2] = String.valueOf(teaml);
            String mid = String.valueOf(matchInfoSaver.insert(matchinfo));
            input = br.readLine();
            String[] scores = input.split(";");
            for (int i = 0; i < scores.length; i++) {
                String[] scoresinfo = getMatchScore(mid, String.valueOf(i + 1), scores[i]);
                matchScoreSaver.insert(scoresinfo);
            }
            int serialId = 0;
            String tid = null;
            String d_tid = null;
            while ((input = br.readLine()) != null) {
                String input_trim = input.trim();
                if (input_trim.length() <= 3) {
                    tid = String.valueOf(teamSaver.getTid(input.trim()));
                    if (matchinfo[1].equals(tid))
                        d_tid = matchinfo[2];
                    if (matchinfo[2].equals(tid))
                        d_tid = matchinfo[1];
                    serialId = 1;
                    continue;
                }

                String[] playerInfos = getPlayerInfo(mid, tid, input, serialId, d_tid);
                int pid = playerSaver.getPid(playerInfos[2]);

                if (pid == -1) {
                    String[] ss = new String[1];
                    ss[0] = playerInfos[2];
                    playerInfos[2] = String.valueOf(playerSaver.insert(ss));
                } else {
                    playerInfos[2] = String.valueOf(pid);
                }
                playerScoreSaver.insert(playerInfos);
                serialId++;
            }

        } catch (Exception e) {
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

    }

    public static String[] getMatchInfo(String title, String s) {
        String[] ss = s.split(";");
        String[] titles = title.split("_");
        String[] objects = new String[5];
        String[] seasons = titles[0].split("-");
        //objects[0] = seasons[0];
        //SSobjects[1] = seasons[1];
//        System.out.println(title+" "+titles.length);
        String[] teams = titles[2].split("-");
        objects[1] = teams[0];
        objects[2] = teams[1];
        String[] scores = ss[2].split("-");
        objects[3] = scores[0];
        objects[4] = scores[1];
        String[] times = titles[1].split("-");
        int month = Integer.parseInt(times[0]);
        if (month < 9) {
            objects[0] = seasons[1] + "-" + titles[1];
        } else {
            objects[0] = seasons[0] + "-" + titles[1];
        }
        return objects;
    }

    public static String[] getPlayerInfo(String mid, String tid, String info, int serialId, String d_tid) {
        String[] infos = info.split(";");
        String[] objects = null;
        int all = Integer.parseInt(infos[3].trim());
        int three = Integer.parseInt(infos[5].trim());
        int fa = Integer.parseInt(infos[7].trim());
        int two = all - three;
        int score = three * 3 + two * 2 + fa;
        if (infos[infos.length - 1].equals("null")) {
            if (score < 0) {
            } else {
                infos[infos.length - 1] = String.valueOf(score);
            }
        } else {
            int dataScore = Integer.parseInt(infos[infos.length - 1]);
            if (score != dataScore) {
                System.out.println(info);
                System.out.println("不相等计算为：" + score + "实际为:" + dataScore);
            }
        }
        objects = new String[22];
        objects[0] = mid;
        objects[1] = tid;
        for (int i = 0; i < infos.length; i++) {
            objects[i + 2] = infos[i];
        }
        String inPlaceTime = null;
        inPlaceTime = "00:" + infos[2];
        objects[4] = format(inPlaceTime);
        objects[objects.length - 2] = String.valueOf(serialId);
        objects[objects.length - 1] = d_tid;
        return objects;
    }

    public static String format(String time) {
        Pattern pattern = Pattern.compile("[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}");
        Matcher matcher = pattern.matcher(time);
        boolean b = matcher.matches();
        if (b) {
            String[] times = time.split(":");
            int s = Integer.parseInt(times[2]);
            int min = Integer.parseInt(times[1]);
            int h = Integer.parseInt(times[0]);
            if (s == 60) {
                s = s - 60;
                min = min + 1;
            }

            if (min >= 60) {
                min = min - 60;
                h = h + 1;
            }

            return "" + h + ":" + min + ":" + s;
        }
        return null;
    }

    public static String[] getMatchScore(String mid, String index, String score) {
        String[] objects = new String[4];
        objects[0] = mid;
        objects[1] = index;
        String[] scores = score.split("-");
        objects[2] = scores[0];
        objects[3] = scores[1];
        return objects;
    }
}

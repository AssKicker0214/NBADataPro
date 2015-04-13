package fileinput;

import DBmanage.InitialDatabase;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenghao on 15/4/13.
 */
public class MatchInfoInputReader {
    public void readMatch(File file) {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = InitialDatabase.getConnection();
        insert(queryRunner, connection, file);
    }

    public void insert(QueryRunner queryRunner, Connection connection,
                       File file) {
        BufferedReader br = null;
        try {
            connection.setAutoCommit(false);
            String title = file.getName();
            String input = null;
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file)));
            input = br.readLine();
            Object[] matchinfo = getMatchInfo(title, input);
            String sqlInsert1 = "insert into matchinfo(seasonf,seasonl,matchtime,teamf,teaml,allscoref,allscorel) values(?,?,?,(select tid from team where abbreviation = ?),(select tid from team where abbreviation = ?),?,?)";
            queryRunner.update(connection, sqlInsert1, matchinfo);

            Object scalar = queryRunner.query(connection,
                    "values IDENTITY_VAL_LOCAL()", new ScalarHandler());
            String mid = String.valueOf(scalar);

            String sqlInsert2 = "insert into matchscore values(?,?,?,?)";

            input = br.readLine();
            String[] scores = input.split(";");
            for (int i = 0; i < scores.length; i++) {
                Object[] scoresinfo = getMatchScore(mid, i + 1, scores[i]);
                queryRunner.update(connection, sqlInsert2, scoresinfo);
            }

            String sqlInsert3 = "insert into playerscore values"
                    + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            String tid = null;
            int serialId = 0;
            while ((input = br.readLine()) != null) {
                if (input.trim().length() <= 3) {
                    Object scalar1 = queryRunner.query(connection,
                            "select tid from team where abbreviation = ?",
                            new ScalarHandler(), input.trim());
                    tid = String.valueOf(scalar1);
                    serialId = 1;
                    continue;
                }

                Object[] playerInfos = getPlayerInfo(mid, tid, input, serialId);
                Object pid = queryRunner.query(connection,
                        "select pid from player where name = ?",
                        new ScalarHandler(), playerInfos[2]);
                if (pid == null) {
                    queryRunner.update(connection,
                            "insert into player (name) values(?)",
                            playerInfos[2]);
                    playerInfos[2] = queryRunner.query(connection,
                            "values IDENTITY_VAL_LOCAL()", new ScalarHandler());
                } else {
                    playerInfos[2] = pid;
                }
                queryRunner.update(connection, sqlInsert3, playerInfos);
                serialId++;
            }

            connection.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public Object[] getMatchInfo(String title, String s) {
        String[] ss = s.split(";");
        String[] titles = title.split("_");
        Object[] objects = new Object[7];
        String[] seasons = titles[0].split("-");
        objects[0] = seasons[0];
        objects[1] = seasons[1];
        String[] teams = titles[2].split("-");
        objects[3] = teams[0];
        objects[4] = teams[1];
        String[] scores = ss[2].split("-");
        objects[5] = scores[0];
        objects[6] = scores[1];
        String[] times = titles[1].split("-");
        int month = Integer.parseInt(times[0]);
        if (month < 9) {
            objects[2] = seasons[1] + "-" + titles[1];
        } else {
            objects[2] = seasons[0] + "-" + titles[1];
        }
        return objects;
    }

    public static Object[] getMatchScore(String mid, int index, String score) {
        Object[] objects = new Object[4];
        objects[0] = mid;
        objects[1] = index;
        String[] scores = score.split("-");
        objects[2] = scores[0];
        objects[3] = scores[1];
        return objects;
    }

    public Object[] getPlayerInfo(String mid, String tid, String info, int serialId) {
        String[] infos = info.split(";");
        Object[] objects = null;
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
        objects = new Object[21];
        objects[0] = mid;
        objects[1] = tid;
        for (int i = 0; i < infos.length; i++) {
            objects[i + 2] = infos[i];
        }
        String inPlaceTime = null;
        inPlaceTime = "00:" + infos[2];
        objects[4] = format(inPlaceTime);
        objects[objects.length - 1] = serialId;
        return objects;
    }

    public String format(String time) {
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
}

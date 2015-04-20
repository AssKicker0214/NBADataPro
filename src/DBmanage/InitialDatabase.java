package DBmanage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by chenghao on 15/4/12.
 */
public class InitialDatabase {
    private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String url = "jdbc:derby:memory:myDB;create=true";
    private static ArrayList<Connection> pool = new ArrayList<Connection>();

    private static void initialDataBase() {

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url);

            Statement stat = connection.createStatement();
            // insert data
            stat.execute(DBDDL.createFileInputTable);
            stat.execute(DBDDL.createTeamTable);
            stat.execute(DBDDL.createPlayerTable);
            stat.execute(DBDDL.createMatchinfoTable);
            stat.execute(DBDDL.createMatchscoreTable);
            stat.execute(DBDDL.createPlayerScoreTable);
            stat.execute(DBDDL.createPlayerpositionTable);
            stat.execute(DBDDL.createViewAllPid);
            stat.execute(DBDDL.createViewPid2Tidtemp);
            stat.execute(DBDDL.createViewPid2Tnametemp);
            stat.execute(DBDDL.createViewPid2SStemp);
            stat.execute(DBDDL.createViewPid2SS);
            stat.execute(DBDDL.createViewPid2DDtemp);
            stat.execute(DBDDL.createViewPid2DD);
            stat.execute("create index pid_index_playerscore on playerscore(pid)");
            stat.execute("create index tid_index_playerscore on playerscore(tid)");
            stat.execute("create index mid_index_playerscore on playerscore(mid)");
            stat.execute("create index mid_index_matchinfo on matchinfo(mid)");
            stat.execute("create index mid_index_team on team(tid)");
            stat.execute("create index mid_index_player on player(pid)");
            stat.execute(DBDDL.createViewAllPlayerscore);
            stat.execute(DBDDL.createViewPidMid2matchtime);
            stat.execute(DBDDL.createViewPid2L5Mid);
            stat.execute(DBDDL.createViewl5Playerscore);
            stat.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized Connection getConnection() {
        if (pool.size() == 0)
            initialPool();
        return pool.remove(0);
    }

    public static void initial() {
        initialDataBase();
        initialPool();
    }

    private static void initialPool() {

        try {
            for (int i = 0; i < 10; i++) {

                Connection connection = DriverManager.getConnection(url);
                pool.add(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

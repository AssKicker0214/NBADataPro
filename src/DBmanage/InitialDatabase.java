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

            stat.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (pool.size() == 0)
            initialPool();
        return pool.remove(0);
    }

    public static void initial(){
        initialPool();
        initialDataBase();
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

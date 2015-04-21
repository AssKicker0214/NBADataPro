import DBmanage.InitialDatabase;
import fileinput.MatchInfoInput;
import fileinput.MatchInfoInputReader;
import fileinput.PlayerFileInput;
import fileinput.TeamFileInput;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TEst {
    public static void main(String[] args) throws SQLException {
        InitialDatabase.initial();

        long a = System.currentTimeMillis();
        new TeamFileInput().ReadTeam();
        new PlayerFileInput().readPlayer();
        new MatchInfoInput().readMatch();
//        File file = new File("/Users/chenghao/Documents/迭代一数据/matches");
//        File[] files = file.listFiles();
//        for (int i = 0; i < 47; i++) {
//            new MatchInfoInputReader().readMatch(files[0]);
//        }
//
        System.out.println(System.currentTimeMillis() - a);

//        long b = System.currentTimeMillis();
        Connection connection = InitialDatabase.getConnection();
//        Statement stat = connection.createStatement();
//

        QueryRunner queryRunner = new QueryRunner();
        System.out.println("------------------------------------------------------------");
        long b = System.currentTimeMillis();
        List<Object[]> arraylist = queryRunner
                .query(connection, "select * from playerscore2matchinfo,pid2lmtime where playerscore2matchinfo.pid=pid2lmtime.pid,playerscore2matchinfo.matchtime=pid2lmtime.matchtime"
                ,new ArrayListHandler());
        System.out.println(System.currentTimeMillis() - b);
//        System.out.println(arraylist.size());
//        for (int i = 0; i < arraylist.size(); i++) {
//            Object[] objects = arraylist.get(i);
//            printArray(objects);
//        }
//        System.out.println(arraylist.size());
//        System.out.println(System.currentTimeMillis() - b);
//        List<Object[]> arraylist1 = queryRunner
//                .query(connection, "select * from playerscore where pid = 491",new ArrayListHandler());
//        for (int i = 0; i < arraylist1.size(); i++) {
//            Object[] objects = arraylist1.get(i);
//            printArray(objects);
//        }

    }

    public static void printArray(Object[] objects) {
        if (objects.length > 0) {
            for (int i = 0; i < objects.length - 1; i++) {
                System.out.print(objects[i] + " ");
            }
            System.out.println(objects[objects.length - 1]);
        }
    }
}

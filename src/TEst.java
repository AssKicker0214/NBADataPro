import DBmanage.InitialDatabase;
import fileinput.MatchInfoInput;
import fileinput.MatchInfoInputReader;
import fileinput.PlayerFileInput;
import fileinput.TeamFileInput;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TEst {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        File file = new File("/Users/chenghao/data1.txt");
        PrintStream pr = new PrintStream(new FileOutputStream(file));
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
                .query(connection, "select * from pid2l5mid" ,new ArrayListHandler());
        System.out.println(System.currentTimeMillis() - b);
//        System.out.println(arraylist.size());
        for (int i = 0; i < arraylist.size(); i++) {
            Object[] objects = arraylist.get(i);
            printArray(objects,pr);
        }
//        System.out.println(arraylist.size());
//        System.out.println(System.currentTimeMillis() - b);
//        List<Object[]> arraylist1 = queryRunner
//                .query(connection, "select * from playerscore where pid = 491",new ArrayListHandler());
//        for (int i = 0; i < arraylist1.size(); i++) {
//            Object[] objects = arraylist1.get(i);
//            printArray(objects);
//        }

    }

    public static void printArray(Object[] objects,PrintStream pr) {
        if (objects.length > 0) {
            for (int i = 0; i < objects.length - 1; i++) {
                pr.print(objects[i] + " ");
            }
            pr.println(objects[objects.length - 1]);
        }
    }
}

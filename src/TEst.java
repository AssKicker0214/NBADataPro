import DBmanage.InitialDatabase;
import fileinput.MatchInfoInput;
import fileinput.PlayerFileInput;
import fileinput.TeamFileInput;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

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
        System.out.println(System.currentTimeMillis() - a);
        long b = System.currentTimeMillis();
        Connection connection = InitialDatabase.getConnection();


        QueryRunner queryRunner = new QueryRunner();
        List<Object[]> arraylist = queryRunner
                .query(connection, "select playerscore.mid,playerscore.tid,player.pid,playerscore.position,playerscore.inplacetime,playerscore.throwin,playerscore.throwall,playerscore.throw3in,playerscore.throw3all,playerscore.penaltyin,playerscore.penaltyall,playerscore.attackbas,playerscore.defencebas,playerscore.allbas,playerscore.helpatt,playerscore.interp,playerscore.interp,playerscore.block,playerscore.mistake,playerscore.foul,playerscore.score,playerscore.serialid from player natural left outer join playerscore", new ArrayListHandler());
//        System.out.println(arraylist.size());
        for (int i = 0; i < arraylist.size(); i++) {
            Object[] objects = arraylist.get(i);
            printArray(objects);
        }
        System.out.println(arraylist.size());
        System.out.println(System.currentTimeMillis() - b);
        List<Object[]> arraylist1 = queryRunner
                .query(connection, "select * from playerscore where pid = 491",new ArrayListHandler());
        for (int i = 0; i < arraylist1.size(); i++) {
            Object[] objects = arraylist1.get(i);
            printArray(objects);
        }

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

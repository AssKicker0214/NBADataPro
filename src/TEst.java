import DBmanage.InitialDatabase;
import fileinput.MatchInfoInput;
import fileinput.PlayerFileInput;
import fileinput.TeamFileInput;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TEst {
	public static void main(String[] args) throws SQLException {
        InitialDatabase.initial();
        long a = System.currentTimeMillis();
        new TeamFileInput().ReadTeam();


        new PlayerFileInput().readPlayer();
        new MatchInfoInput().readMatch();
        System.out.println(System.currentTimeMillis() - a);
//        Connection connection = InitialDatabase.getConnection();
//        QueryRunner queryRunner = new QueryRunner();
//        List<Object[]> arraylist = queryRunner
//                .query(connection, "select * from matchinfo ",
//                        new ArrayListHandler());
//        System.out.println(arraylist.size());
//        for (int i = 0; i < arraylist.size(); i++){
//            Object[] objects = arraylist.get(i);
//            System.out.println(objects[0]+":"+objects[1]+":"+objects[2]+":"+objects[3]+":"+objects[4]+":"+objects[5]+":"+objects[6]+":"+objects[7]+":");
//        }
	}
}

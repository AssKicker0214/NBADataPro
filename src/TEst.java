import DBmanage.InitialDatabase;
import fileinput.PlayerFileInput;
import fileinput.TeamFileInput;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TEst {
	public static void main(String[] args) throws SQLException {
        InitialDatabase.initial();
        new TeamFileInput().ReadTeam();
        Connection connection = InitialDatabase.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        List<Object[]> arraylist = queryRunner
                .query(connection, "select * from team ",
                        new ArrayListHandler());
        for (int i = 0; i < arraylist.size(); i++){
            Object[] objects = arraylist.get(i);
            System.out.println(objects[0]+":"+objects[1]+":"+objects[2]+":"+objects[3]+":"+objects[4]+":"+objects[5]+":"+objects[6]+":"+objects[7]+":");
        }
        new PlayerFileInput().readPlayer();
	}
}

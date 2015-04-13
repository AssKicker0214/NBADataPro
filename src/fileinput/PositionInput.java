package fileinput;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by chenghao on 15/4/12.
 */
public class PositionInput {
    public static void readPosition(Connection connection, QueryRunner queryRunner, int pid,String position) {
        try {
            if (position == null) {
                return;
            }
            if (position.length() == 3) {
                String[] positions = position.split("-");

                boolean exited1 = exit(connection, queryRunner, pid, positions[0]);
                if (exited1 == false) {
                    insert(connection, queryRunner, pid, positions[0]);
                }
                boolean exited2 = exit(connection, queryRunner, pid, positions[1]);
                if (exited2 == false) {
                    insert(connection, queryRunner, pid, positions[1]);
                }

            } else {
                boolean exited = exit(connection, queryRunner, pid, position);
                if (exited == false) {
                    insert(connection, queryRunner, pid, position);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insert(Connection connection,QueryRunner queryRunner,int pid, String string) throws SQLException {
        String sql = "insert into playerposition values(?,?)";
        queryRunner.update(connection,sql, pid, string);
    }

    public static boolean exit(Connection connection,QueryRunner queryRunner,int id, String position) throws SQLException {
        String sql = "select pid from playerposition where pid=? and position=?";
        Object object = queryRunner.query(connection,sql, new ScalarHandler("pid"), id,
                position);
        if (object != null) {
            return true;
        }
        return false;
    }
}

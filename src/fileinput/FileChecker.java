package fileinput;

import DBmanage.InitialDatabase;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by chenghao on 15/4/12.
 */
public class FileChecker extends Thread {
    private File[] files;
    private int start;
    private int end;
    private Connection connection;

    public FileChecker(File[] files, int s, int e) {
        this.files = files;
        this.start = s;
        this.end = e;
        this.connection = InitialDatabase.getConnection();

    }

    @Override
    public void run() {
        try {

            for (int i = start; i <= end; i++) {
                String fileName = files[i].getName();
                if (readed(fileName)) {
                    //TODO
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Boolean readed(String fileName) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from fileinput where filename = ?";
        Object result = queryRunner.query(connection, sql, new ScalarHandler(), fileName);
        if (result != null)
            return true;
        return false;
    }
}

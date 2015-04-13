package fileinput;

import DBmanage.InitialDatabase;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by chenghao on 15/4/12.
 */
public class TeamFileInput {
    public void ReadTeam() {
        BufferedReader br = null;
        Connection connection = InitialDatabase.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            File file = new File("/Users/chenghao/Documents/迭代一数据/teams/teams");
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file)));
            String input = null;
            br.readLine();
            while ((input = br.readLine()) != null) {
                input = input.trim();
                input = input.substring(1, input.length() - 1);
                if (input.startsWith("═"))
                    continue;
                String[] ss = input.split("│");
                // 第二步 准备方法参数
                String sql = "insert into team(fullname,abbreviation,location,area,subarea,homefield,establishmenttime) values(?,?,?,?,?,?,?)";
                Object[] objects = change(ss);
                // 第三步 调用 query / update
                queryRunner.update(connection,sql, objects);
                Object scalar = queryRunner.query(connection,
                        "values IDENTITY_VAL_LOCAL()", new ScalarHandler());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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

    public static Object[] change(String[] ss){
        Object[] objects = new Object[ss.length];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = ss[i].trim();
        }
        return objects;
    }
}

import org.junit.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by chenghao on 15/4/22.
 */
public class TeamTest {
    private TeamSaver teamSaver;
    @Test
    public void test(){
        ReadTeam("/Users/chenghao/Documents/迭代一数据/teams/teams");
    }

    public TeamTest(TeamSaver teamSaver){
    this.teamSaver = teamSaver;
    }

    public void ReadTeam(String path) {
        BufferedReader br = null;
        try {
            File file = new File(path);
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

                // 第三步 调用 query / update
                teamSaver.insert(ss);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}

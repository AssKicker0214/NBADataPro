package data.input;

import org.junit.Test;
import data.saver.TeamSaver;

import java.io.*;

/**
 * Created by chenghao on 15/4/22.
 */
public class Team {
    private TeamSaver teamSaver;
    private String path;

    @Test
    public void test() {
        ReadTeam(path);
    }

    public Team(TeamSaver teamSaver, String path) {
        this.teamSaver = teamSaver;
        this.path = path;
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

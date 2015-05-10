package configure;

import java.io.*;

/**
 * Created by chenghao on 15/5/5.
 */
public class Configure {
    public static String getTeamPath() {
        String rootPath = getRootPath();
        return rootPath + "/teams/teams";
    }

    public static String getPlayerPath() {
        return getRootPath() + "/players/info";
    }

    public static String getMatchPath() {
        return getRootPath() + "/matches";
    }

    public static void set(String path) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter((new FileOutputStream(new File("conf.xml")))));
            bw.write(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String getConfigureDocument() {
        return null;
    }

    private static String getRootPath() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("conf.xml"))));
            String path = br.readLine();
            if (path != null){
                return path;
            }
        } catch (FileNotFoundException e) {
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
        }
        return "";
    }
}

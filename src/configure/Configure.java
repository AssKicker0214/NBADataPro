package configure;

import autotest.Config;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;

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
            bw = new BufferedWriter(new OutputStreamWriter((new FileOutputStream(new File(getRoot() + "conf/conf.xml")))));
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
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getRoot() + "conf/conf.xml"))));
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

    private static String getRoot(){
        URL url = Config.class.getProtectionDomain().getCodeSource().getLocation();
        String filePath = null;
        try {
            filePath = URLDecoder.decode(url.getPath(), "utf-8");// 转化为utf-8编码
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (filePath.endsWith(".jar")) {// 可执行jar包运行的结果里包含".jar"
            // 截取路径中的jar包名
            filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
        }
        return filePath;
    }
}

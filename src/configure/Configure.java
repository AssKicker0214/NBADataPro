package configure;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
        Document document = getConfigureDocument();
        Element root = document.getRootElement();
        Element pathElement = root.element("path");
        pathElement.setText(path);
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter output = null;
        try {
            output = new XMLWriter(new FileWriter("src/conf.xml"), format);
            output.write(document);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Document getConfigureDocument() {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new File("src/conf.xml"));
            return document;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getRootPath() {
        Element root = getConfigureDocument().getRootElement();
        Element pathElement = root.element("path");
        String rootPath = pathElement.getTextTrim();
        return rootPath;
    }
}

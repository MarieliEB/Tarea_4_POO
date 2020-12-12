package cr.ac.ucenfotec.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class Utilities {
    public static String[] getProperties() throws Exception{
        String[] dbInfo = new String[2];
        Properties prop = new Properties();
        prop.load(new FileInputStream("db.props"));
        dbInfo[0] = prop.getProperty("driver");
        dbInfo[1] = prop.getProperty("url");
        return dbInfo;
    }

    public static String[] getPropertiesMySql() throws  Exception{
        String [] dbInfo = new String[4];
        Properties prop = new Properties();
        prop.load(new FileInputStream("db.props"));
        dbInfo[0] = prop.getProperty("driver");
        dbInfo[1] = prop.getProperty("url");
        dbInfo[2] = prop.getProperty("user");
        dbInfo[3] = prop.getProperty("password");
        return dbInfo;
    }
    public static String getMotorDB() throws Exception{
        Properties prop = new Properties();
        prop.load(new FileInputStream("db.props"));
        return prop.getProperty("persistencia");
    }
}

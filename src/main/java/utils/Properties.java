package utils;

import java.io.*;

/**
 * Created by Michael Strizhov on 21.03.2017.
 */
public class Properties {
    private final static String FILE_NAME = ".//res//test.properties";
    public static java.util.Properties properties;
    public Properties(){
        properties = new java.util.Properties();
        try {
            InputStream stream = new FileInputStream(FILE_NAME);
            Reader reader = new InputStreamReader(stream, "UTF-8");
            properties.load(reader);
            //properties.load(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String name){
        return  properties.getProperty(name);
/*        try {
            //return new String(properties.getProperty(name).getBytes("ISO8859-1"));
            //return new String(properties.getProperty(name).getBytes("UTF-8"));
            //return new String(properties.getProperty(name).getBytes("windows-1251"));
            //return new String(properties.getProperty(name).getBytes("UTF-16"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";*/
    }
}

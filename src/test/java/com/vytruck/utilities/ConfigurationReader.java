package com.vytruck.utilities;


import java.io.FileInputStream;

import java.util.Properties;

public class ConfigurationReader {

private static Properties configfile;


static {

    try {
        FileInputStream fileInputStream=new FileInputStream("configuration.properties");
        configfile =new Properties();
        configfile.load(fileInputStream);
    fileInputStream.close();
    } catch (Exception e) {
        e.printStackTrace();
    }


}
public static String getProperty(String key){


    return configfile.getProperty(key);
}

}


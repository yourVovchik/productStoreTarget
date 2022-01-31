package com.isoft.zhelakovich.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Config {

    public static String getPropertiesKey(String param) throws IOException {
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream("src/main/resources/db_coonection.properties")));
        return properties.getProperty(param);
    }
}

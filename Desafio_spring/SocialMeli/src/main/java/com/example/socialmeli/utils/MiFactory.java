package com.example.socialmeli.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MiFactory {

    public static Sorter getInstance(String sorter)  {

        FileReader reader = null;
        try {
            reader = new FileReader("src/main/resources/sorter.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties p = new Properties();

        try {
            p.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String property = p.getProperty(sorter);

        Class c = null;
        try {
            c = Class.forName(property);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            return (Sorter) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;

    }

}

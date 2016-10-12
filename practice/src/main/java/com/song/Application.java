package com.song;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 该项目用于测试各种代码片段
 *
 * @author song@liu@ele.me
 * @date 2016-10-11 16:46
 */
public class Application {
    private static final String OS_NAME = System.getProperties().getProperty("os.name");
    public static void main(String[] args){

        String filePath = "world";
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            System.out.println("2" + OS_NAME);
        }catch (Exception e){
            System.out.println(OS_NAME);
        }
    }
}

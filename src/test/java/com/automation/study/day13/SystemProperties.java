package com.automation.study.day13;

import org.testng.annotations.Test;

public class SystemProperties {

    @Test
    public void test(){
        // /Users/studio2/IdeaProjects/Fall2019Selenium/pom.xml
        // System
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.home"));

        String pathDownloads = System.getProperty("user.home") + "/Downloads";

        System.out.println(pathDownloads);

        System.out.println(System.getProperty("os.arch"));
    }
}

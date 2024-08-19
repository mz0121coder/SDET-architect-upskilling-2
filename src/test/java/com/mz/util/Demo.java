package com.mz.util;

public class Demo {
    public static void main(String[] args) {
        System.setProperty("browser", "firefox");
        Config.initialise();
        System.out.println(Config.get("selenium.grid.hubhost"));
    }
}

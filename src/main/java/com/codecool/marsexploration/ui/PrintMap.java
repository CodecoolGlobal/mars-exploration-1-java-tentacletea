package com.codecool.marsexploration.ui;

import java.util.ArrayList;
import java.util.List;

public class PrintMap {

    public void run(List<List<String>> map){
        int mapWidth = map.size();
        for(int i = 0;i< mapWidth;i++){
            for(int j= 0; j< mapWidth;j++){
                System.out.print(ANSI_RED + map.get(i).get(j));
            }
            System.out.println();
        }
    }
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
}


package com.codecool.marsexploration.ui;

import java.util.ArrayList;
import java.util.List;

public class PrintMap {

    public void run(List<List<String>> map){
        int mapWidth = map.size();
        for(int i = 0;i< mapWidth;i++){
            for(int j= 0; j< mapWidth;j++){
                System.out.print(map.get(i).get(j));
            }
            System.out.println();
        }
    }
}


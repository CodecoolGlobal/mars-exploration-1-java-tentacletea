package com.codecool.marsexploration.io;

import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.MapSize;

import java.util.ArrayList;
import java.util.List;

public class InitConfig {
    public MapConfig init(String outputPath) {
        int mapWidth = MapSize.SMALL.getSize();
        List<Integer> mountains = new ArrayList<>();
        List<Integer> pits = new ArrayList<>();
        mountains.add(10);
        mountains.add(20);
        mountains.add(30);
        pits.add(5);
        pits.add(15);
        int water = 5;
        int minerals = 5;
        MapConfig mapConfig = new MapConfig(outputPath, mapWidth, mountains, pits, water, minerals);
        return mapConfig;
    }
}

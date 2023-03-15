package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.MapSize;
import com.codecool.marsexploration.logic.ShapeGenerator;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        String outputPath = "src/main/resources/exploration.map";
        int mapWidth = 50;
        Random random = new Random();
        List<Integer> mountains = new ArrayList<>();
        List<Integer> pits = new ArrayList<>();
        mountains.add(10);
        mountains.add(20);
        mountains.add(30);
        pits.add(5);
        pits.add(15);

        int water = 2;
        int minerals = 5;

        MapConfig mapConfig = new MapConfig(outputPath, mapWidth, mountains, pits, water, minerals);
        ShapeGenerator shapegenerator = new ShapeGenerator(mapConfig.mapWidth());

        //shapegenerator.run(mapConfig.mountains(),mapConfig.pits(),random);
        //MapGenerator mapGenerator = new MapGenerator(mapConfig);
       // mapGenerator.generate();
    }
}

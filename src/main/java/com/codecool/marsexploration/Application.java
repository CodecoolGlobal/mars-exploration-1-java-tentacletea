package com.codecool.marsexploration;

import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.MapSize;
import com.codecool.marsexploration.logic.AreaGenerator;
import com.codecool.marsexploration.logic.ShapeGenerator;
import com.codecool.marsexploration.logic.ConfigValidator;
import com.codecool.marsexploration.logic.MapGenerator;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        String outputPath = "src/main/resources/exploration.map";
        Random random = new Random();

        int mapWidth = 25;
        
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
        
        ConfigValidator configValidator = new ConfigValidator(mapConfig);
        System.out.println("mapConfig is valid = " + configValidator.validate(25));


        ShapeGenerator shapeGenerator = new ShapeGenerator(random);
        AreaGenerator areaGenerator = new AreaGenerator();
        MapGenerator mapGenerator = new MapGenerator(mapConfig,areaGenerator,shapeGenerator);
        mapGenerator.generate();
    }
}

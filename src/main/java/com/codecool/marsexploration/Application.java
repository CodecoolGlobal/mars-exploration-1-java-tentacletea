package com.codecool.marsexploration;
import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.MapSize;
import com.codecool.marsexploration.logic.AreaGenerator;
import com.codecool.marsexploration.io.MapReader;
import com.codecool.marsexploration.logic.ResourceManager;
import com.codecool.marsexploration.logic.resource.Minerals;
import com.codecool.marsexploration.logic.ShapeGenerator;
import com.codecool.marsexploration.logic.ConfigValidator;
import com.codecool.marsexploration.logic.MapGenerator;
import com.codecool.marsexploration.logic.resource.Resource;
import com.codecool.marsexploration.io.MapWriter;
import com.codecool.marsexploration.io.PrintMap;
import com.codecool.marsexploration.logic.resource.Water;

import java.util.*;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        String outputPath = "src/main/resources/Terra-formers.map";
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
        System.out.println("MapConfig is valid = " + configValidator.validate(25));

        ShapeGenerator shapeGenerator = new ShapeGenerator(random);
        AreaGenerator areaGenerator = new AreaGenerator();
        MapGenerator mapGenerator = new MapGenerator(mapConfig,areaGenerator,shapeGenerator);
        List<List<String>> map = mapGenerator.generate();

        Set<Resource> resources = new HashSet<>();
        Minerals minerals1 = new Minerals();
        resources.add(minerals1);
        Water water1 = new Water();
        resources.add(water1);
        ResourceManager resourceManager = new ResourceManager(map, mapConfig, resources);
        resourceManager.placeResource();

        //TODO : question for el is mapStream = mapReader.read(addedMountainMap) better ?
        MapReader mapReader = new MapReader();
        Stream<String> mapStream = mapReader.read(map);
        MapWriter mapWriter = new MapWriter();
        mapWriter.write(mapStream, outputPath);
        PrintMap printMap = new PrintMap();
        printMap.run(map);
    }
}

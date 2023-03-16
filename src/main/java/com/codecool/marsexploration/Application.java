package com.codecool.marsexploration;

import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.logic.ResourceManager;
import com.codecool.marsexploration.logic.resource.Minerals;
import com.codecool.marsexploration.logic.ShapeGenerator;
import com.codecool.marsexploration.logic.ConfigValidator;
import com.codecool.marsexploration.logic.MapGenerator;
import com.codecool.marsexploration.logic.resource.Resource;
import com.codecool.marsexploration.logic.resource.Water;
import com.codecool.marsexploration.ui.PrintMap;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        String outputPath = "src/main/resources/exploration.map";
        Random random = new Random();

        int mapWidth = 20;
        
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
        
        ConfigValidator configValidator = new ConfigValidator(mapConfig);
        System.out.println("mapConfig is valid = " + configValidator.validate(25));


        ShapeGenerator shapegenerator = new ShapeGenerator(mapConfig.mapWidth());

        PrintMap printMap = new PrintMap();
        List<List<String>> addedMountainMap=   shapegenerator.addShapesToMap(shapegenerator.getEmptyMap(),shapegenerator.getDummyMountainShapes(),"^");
        List<List<String>> addedPitsToMountainMap = shapegenerator.addShapesToMap(addedMountainMap,shapegenerator.getDummyPitShapes(),"#");



        Set<Resource> resources = new HashSet<>();
        Minerals minerals1 = new Minerals();
        resources.add(minerals1);
        Water water1 = new Water();
        resources.add(water1);
        ResourceManager resourcementManager = new ResourceManager(addedPitsToMountainMap, mapConfig, resources);
        resourcementManager.placeResource();



        printMap.run(addedPitsToMountainMap);


        MapGenerator mapGenerator = new MapGenerator(mapConfig);
        mapGenerator.generate();
    }
}

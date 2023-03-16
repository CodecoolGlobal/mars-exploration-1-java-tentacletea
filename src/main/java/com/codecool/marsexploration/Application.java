package com.codecool.marsexploration;

import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.MapSize;
import com.codecool.marsexploration.logic.AreaGenerator;
import com.codecool.marsexploration.io.MapReader;
import com.codecool.marsexploration.logic.ResourceManager;
import com.codecool.marsexploration.data.resource.Minerals;
import com.codecool.marsexploration.logic.ShapeGenerator;
import com.codecool.marsexploration.logic.ConfigValidator;
import com.codecool.marsexploration.logic.MapGenerator;
import com.codecool.marsexploration.data.resource.Resource;
import com.codecool.marsexploration.io.MapWriter;
import com.codecool.marsexploration.io.PrintMap;
import com.codecool.marsexploration.data.resource.Water;

import java.util.*;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        String outputPath = "src/main/resources/Terra-formers.map";
        MapConfig mapConfig = initalizeMapConfig(outputPath);
        ConfigValidator configValidator = new ConfigValidator(mapConfig);
        if(configValidator.validate(25)){
            System.out.println("MapConfig is valid");
            ShapeGenerator shapeGenerator = new ShapeGenerator(random);
            AreaGenerator areaGenerator = new AreaGenerator();
            MapGenerator mapGenerator = new MapGenerator(mapConfig,areaGenerator,shapeGenerator);
            List<List<String>> map = mapGenerator.generateMapWithTerrain();
            placeResourcesOnMap(mapConfig, map);
            writeMapToFile(outputPath, map);
            PrintMap printMap = new PrintMap();
            printMap.run(map);
        }
        else {
            System.out.println("MapConfig is not valid!");
        }
    }
    private static void writeMapToFile(String outputPath, List<List<String>> map) {
        MapReader mapReader = new MapReader();
        Stream<String> mapStream = mapReader.read(map);
        MapWriter mapWriter = new MapWriter();
        mapWriter.write(mapStream, outputPath);
    }

    private static void placeResourcesOnMap(MapConfig mapConfig, List<List<String>> map) {
        Set<Resource> resources = new HashSet<>();
        Minerals minerals1 = new Minerals();
        resources.add(minerals1);
        Water water1 = new Water();
        resources.add(water1);
        ResourceManager resourceManager = new ResourceManager(map, mapConfig, resources);
        resourceManager.placeResource();
    }

    private static MapConfig initalizeMapConfig(String outputPath) {
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
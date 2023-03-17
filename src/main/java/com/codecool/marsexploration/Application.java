package com.codecool.marsexploration;

import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.resource.Minerals;
import com.codecool.marsexploration.data.resource.Resource;
import com.codecool.marsexploration.data.resource.Water;
import com.codecool.marsexploration.io.InitConfig;
import com.codecool.marsexploration.io.MapReader;
import com.codecool.marsexploration.io.MapWriter;
import com.codecool.marsexploration.io.PrintMap;
import com.codecool.marsexploration.logic.*;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        String outputPath = "src/main/resources/Terra-formers.map";
        InitConfig initConfig = new InitConfig();
        MapConfig mapConfig = initConfig.init(outputPath);
        ConfigValidator configValidator = new ConfigValidator(mapConfig);
        //TODO: make init function
        if(configValidator.validate(25)){
            System.out.println("MapConfig is valid");
            Random random = new Random();
            ShapeGenerator shapeGenerator = new ShapeGenerator(random);
            AreaGenerator areaGenerator = new AreaGenerator();
            MapGenerator mapGenerator = new MapGenerator(mapConfig,areaGenerator,shapeGenerator);
            List<List<String>> map = mapGenerator.generateMapWithTerrain();

            Set<Resource> resources = new HashSet<>();
            Minerals minerals = new Minerals();
            resources.add(minerals);
            Water water = new Water();
            resources.add(water);
            ResourceManager resourceManager = new ResourceManager(map, mapConfig, resources, random);
            resourceManager.placeResource();

            MapReader mapReader = new MapReader();
            Stream<String> mapStream = mapReader.read(map);
            MapWriter mapWriter = new MapWriter();
            mapWriter.write(mapStream, outputPath);

            PrintMap printMap = new PrintMap();
            printMap.run(map);
        }
        else {
            System.out.println("MapConfig is not valid!");
        }
    }
}
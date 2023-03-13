package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.MapSize;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(42));

        MapConfig map = new MapConfig(fileName, mapWidth, terrainSymbols, resourceSymbols, coordinates);

        AreaGenerator areaGenerator = new AreaGenerator(MapSize.LARGE.getSize());

        ResourcePlacement placement = new ResourucePlacement();

        MapGenerator mapGenerator = new MapGenerator();
        mapGenerator.init();

    }
}

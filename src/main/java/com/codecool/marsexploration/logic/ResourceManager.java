package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.logic.resource.Resource;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class ResourceManager {

    private final List<List<String>> terrainMap;
    private final MapConfig mapConfig;
    private final Set<Resource> resources;

    public ResourceManager(List<List<String>> terrainMap, MapConfig mapConfig, Set<Resource> resources) {
        this.terrainMap = terrainMap;
        this.mapConfig = mapConfig;
        this.resources = resources;
    }

    public boolean isAdjacentToPreferredTerrain(Coordinate coordinate, String terrain){
        int y = coordinate.y();
        int x = coordinate.x();

        if (y > 0 && terrainMap.get(y - 1).get(x).equals(terrain)) { // Check North
            return true;
        } else if (y < terrainMap.size() - 1 && terrainMap.get(y + 1).get(x).equals(terrain)) { // Check South
            return true;
        } else if (x > 0 && terrainMap.get(y).get(x - 1).equals(terrain)) { // Check West
            return true;
        } else if (x < terrainMap.get(y).size() - 1 && terrainMap.get(y).get(x + 1).equals(terrain)) { // Check East
            return true;
        } else {
            return false;
        }
    }



    public void placeResource(){
        resources
                .forEach(resource -> {
                    int count = resource.getResource().equals("*") ? mapConfig.minerals() : mapConfig.water();
                    while (count > 0){
                        Coordinate coordinate = getRandomCoordinatesForResource();
                        if (isAdjacentToPreferredTerrain(coordinate, resource.getTerrainForResource())){
                            terrainMap.get(coordinate.y()).set(coordinate.x(), resource.getResource());
                            count--;
                        }
                    }
                });
    }

    private int randomNumberGenerator(int min, int max){
        Random rand = new Random();
        return rand.nextInt(max - min + 1);
    }

    public Coordinate getRandomCoordinatesForResource(){
        int min = 0;
        int max = mapConfig.mapWidth() -1;
        boolean isEmpty = false;
        int x = 0;
        int y = 0;
        while (!isEmpty) {
            x = randomNumberGenerator(min, max);
            y = randomNumberGenerator(min, max);
            isEmpty = validateIfSpaceIsEmpty(x, y);
        }
        return new Coordinate(x, y);
    }


    public boolean validateIfSpaceIsEmpty(int x, int y){
        return terrainMap.get(y).get(x).equals(" ");
    }



}



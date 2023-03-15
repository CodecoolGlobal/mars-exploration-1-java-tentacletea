package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.logic.resource.Resource;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class ResourceManager {

    private List<List<String>> mapWithTerreins;
    private MapConfig mapConfig;
    private Set<Resource> resources;

    public ResourceManager(List<List<String>> mapWithTerreins, MapConfig mapConfig, Set<Resource> resources) {
        this.mapWithTerreins = mapWithTerreins;
        this.mapConfig = mapConfig;
        this.resources = resources;
    }

    private int randomNumberGenerator(int min, int max){
        Random rand = new Random();
        return rand.nextInt(max - min + 1);
    }


    public void placeResource(){

        for (Resource resource : resources){
            int count = 0;
            if (resource.getResource().equals("*")){
                count = mapConfig.minerals();
            } else {
                count = mapConfig.water();
            }
            while (count > 0){
                Coordinate coordinate = getRandomCoordinatesForResource();
                mapWithTerreins.get(coordinate.y()).set(coordinate.x(), resource.getResource());
                count--;
            }
        }



        //loop und alle mineralien plazieren
        //mineralien sind in mapconfig
        //

//        Coordinate coordinate = getRandomCoordinatesForResource();
//        mapWithTerreins.get(coordinate.y()).set(coordinate.x(), "*");
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
        if (mapWithTerreins.get(y).get(x).equals(" ")){
            return true;
        }
        return false;
    }



}



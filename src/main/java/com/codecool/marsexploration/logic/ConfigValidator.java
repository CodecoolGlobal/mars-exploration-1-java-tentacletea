package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.MapConfig;

import java.util.List;

public class ConfigValidator {
    private final MapConfig mapConfig;
    private final int mapWidth;
    private final List<Integer> mountains;
    private final List<Integer> pits;
    private final int water;
    private final int minerals;

    public ConfigValidator(MapConfig mapConfig) {
        this.mapConfig = mapConfig;
        this.mapWidth = mapConfig.mapWidth();
        this.mountains = mapConfig.mountains();
        this.pits = mapConfig.pits();
        this.water = mapConfig.water();
        this.minerals = mapConfig.minerals();
    }

    public boolean validate (int maxOccupyPercentage) {
        int availableCells = getAvailableCells(maxOccupyPercentage);
        int occupiedCells = getOccupiedCells();

        if (occupiedCells > availableCells) {
            return false;
        }
        return true;
    }

    private int getOccupiedCells () {
        int pitSymbols = pits.stream()
                .mapToInt(Integer::intValue)
                .sum();
        int mountainSymbols = mountains.stream()
                .mapToInt(Integer::intValue)
                .sum();

        int occupiedCells = mountainSymbols + pitSymbols + water + minerals;
        System.out.println("occupiedCells = " + occupiedCells);
        return occupiedCells;
    }

    private int getAvailableCells (int maxOccupancyPercent) {
        int totalCells = mapWidth * mapWidth;
        System.out.println("totalCells = " + totalCells);
        int availableCells = (int) Math.floor(totalCells * (maxOccupancyPercent / 100.0));
        System.out.println("availableCells = " + availableCells);
        return availableCells;
    }
    
}

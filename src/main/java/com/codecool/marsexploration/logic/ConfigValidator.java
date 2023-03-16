package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.MapConfig;

import java.util.List;

public class ConfigValidator {
    private final int mapWidth;
    private final List<Integer> mountains;
    private final List<Integer> pits;
    private final int water;
    private final int minerals;

    public ConfigValidator(MapConfig mapConfig) {
        this.mapWidth = mapConfig.mapWidth();
        this.mountains = mapConfig.mountains();
        this.pits = mapConfig.pits();
        this.water = mapConfig.water();
        this.minerals = mapConfig.minerals();
    }

    public boolean validate (int maxOccupancyPercent) {
        int availableCells = getAvailableCells(maxOccupancyPercent);
        int occupiedCells = getOccupiedCells();

        return occupiedCells <= availableCells;
    }

    private int getOccupiedCells () {
        int pitSymbols = pits.stream()
                .mapToInt(Integer::intValue)
                .sum();
        int mountainSymbols = mountains.stream()
                .mapToInt(Integer::intValue)
                .sum();
        int occupiedCells = mountainSymbols + pitSymbols + water + minerals;
        return occupiedCells;
    }

    private int getAvailableCells (int maxOccupancyPercent) {
        int totalCells = mapWidth * mapWidth;
        int availableCells = (int) Math.floor(totalCells * (maxOccupancyPercent / 100.0));

        return availableCells;
    }
    
}

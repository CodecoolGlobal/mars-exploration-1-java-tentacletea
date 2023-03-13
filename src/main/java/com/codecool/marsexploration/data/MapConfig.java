package com.codecool.marsexploration.data;

import java.util.Map;
import java.util.Set;

public record MapConfig(String fileName, int mapWidth, Map<Character, Integer> terrainSymbols,
                        Map<Character, Integer> resourceSymbols, Set<Coordinate> coordinates) {
}

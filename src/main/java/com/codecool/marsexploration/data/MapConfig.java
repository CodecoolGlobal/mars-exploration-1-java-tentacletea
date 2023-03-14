package com.codecool.marsexploration.data;

import java.util.List;
import java.util.Set;

public record MapConfig(
        String fileName,
        int mapWidth,
        List<Integer> mountains,
        List<Integer> pits,
        int water,
        int minerals
) { }

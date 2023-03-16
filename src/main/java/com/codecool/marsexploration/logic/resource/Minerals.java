package com.codecool.marsexploration.logic.resource;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MapConfig;

import java.util.List;
import java.util.Random;

public class Minerals  implements Resource {

    @Override
    public String getResource() {
        return "*";
    }

    @Override
    public String getTerrainForResource() {
        return "^";
    }

}

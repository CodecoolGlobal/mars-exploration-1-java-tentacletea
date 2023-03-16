package com.codecool.marsexploration.logic.resource;

public class Water implements Resource{
    @Override
    public String getResource() {
        return "~";
    }

    @Override
    public String getTerrainForResource() {
        return "#";
    }
}

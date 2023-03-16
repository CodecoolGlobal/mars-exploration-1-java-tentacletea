package com.codecool.marsexploration.data.resource;

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

package com.codecool.marsexploration.data.resource;

public class Minerals  implements Resource {

    @Override
    public String getResource() {
        return "*";
    }

    @Override
    public String getTerrainForResource() {
        return "▲";
    }

}

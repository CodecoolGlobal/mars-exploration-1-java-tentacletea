package com.codecool.marsexploration.data;

public enum MapSize {
    SMALL(25),
    MEDIUM(50),
    LARGE(75);

    private final int size;
    MapSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
}

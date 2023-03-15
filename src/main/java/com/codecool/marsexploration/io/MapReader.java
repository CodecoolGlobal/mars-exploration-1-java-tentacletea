package com.codecool.marsexploration.io;

import java.util.List;
import java.util.stream.Stream;

public class MapReader {
    private final List<List<String>> addedMountainMap;

    public MapReader(List<List<String>> addedMountainMap) {
        this.addedMountainMap = addedMountainMap;
    }

    public Stream<String> read() {
        return addedMountainMap.stream()
                .map(row -> row.stream()
                        .reduce("", (s1, s2) -> s1 + s2) + "\n");
    }
}
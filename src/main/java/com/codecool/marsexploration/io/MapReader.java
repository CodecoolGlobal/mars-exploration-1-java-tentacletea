package com.codecool.marsexploration.io;

import java.util.List;
import java.util.stream.Stream;

public class MapReader {
    public Stream<String> read(List<List<String>> map) {
        return map.stream()
                .map(row -> row.stream()
                        .reduce("", (s1, s2) -> s1 + s2) + "\n");
    }
}
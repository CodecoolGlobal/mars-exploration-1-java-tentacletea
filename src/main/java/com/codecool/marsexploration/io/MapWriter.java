package com.codecool.marsexploration.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

public class MapWriter {
    private final String filePath;

    public MapWriter(String filePath) {
        this.filePath = filePath;
    }

    public void write(Stream<String> lines) {
        try {
            FileWriter writer = new FileWriter(filePath);
            lines.forEach(line -> {
                try {
                    writer.write(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

//            this looks better lol

//            for (List<String> row : addedMountainMap) {
//                for (String value : row) {
//                    writer.write(value);
//                }
//                writer.write("\n");
//            }
//            writer.close();
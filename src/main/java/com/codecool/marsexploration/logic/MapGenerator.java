package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MapConfig;

import java.util.*;

public class MapGenerator {
    private final MapConfig mapConfig;
    ShapeGenerator shapeGenerator;
    AreaGenerator areaGenerator;

    public MapGenerator(MapConfig mapConfig,AreaGenerator areaGenerator,ShapeGenerator shapeGenerator) {
        this.areaGenerator = areaGenerator;
        this.shapeGenerator = shapeGenerator;
        this.mapConfig = mapConfig;
    }

    public List<List<String>> generateMapWithTerrain() {
        List<List<Coordinate>> mountainAreas = new ArrayList<>();
        List<List<Coordinate>> pitAreas = new ArrayList<>();
        int[] indexesOfArea = new int[]{5, 10, 15, 20, 30};
        Collections.shuffle(Collections.singletonList(indexesOfArea));

        mountainAreas.add(shapeGenerator.getOneShape(indexesOfArea[0], areaGenerator.getAreasForSmallMap().get(0)));
        pitAreas.add(shapeGenerator.getOneShape(indexesOfArea[1], areaGenerator.getAreasForSmallMap().get(1)));
        mountainAreas.add(shapeGenerator.getOneShape(indexesOfArea[2], areaGenerator.getAreasForSmallMap().get(2)));
        pitAreas.add(shapeGenerator.getOneShape(indexesOfArea[3], areaGenerator.getAreasForSmallMap().get(3)));
        mountainAreas.add(shapeGenerator.getOneShape(indexesOfArea[0], areaGenerator.getAreasForSmallMap().get(4)));

        List<List<String>> stringMap = getEmptyMap();
        addShapesToMap(stringMap, mountainAreas, "▲");
        addShapesToMap(stringMap, pitAreas, "#");
        return stringMap;
    }
    public List<List<String>> getEmptyMap(){
        List<List<String>> emptyMap = new ArrayList<>();
        for(int i = 0;i< mapConfig.mapWidth();i++){
            emptyMap.add(new ArrayList<>());
            for(int j= 0; j< mapConfig.mapWidth();j++){
                emptyMap.get(i).add(" ");
            }
        }
        return emptyMap;
    }
    public List<List<String>> addShapesToMap(List<List<String>> map, List<List<Coordinate>> shapes, String sign){
        int x;
        int y;
        for(int i=0;i <shapes.size();i++ ){
            for(int j= 0; j< shapes.get(i).size();j++){
                x = shapes.get(i).get(j).x();
                y = shapes.get(i).get(j).y();
                map.get(x).set(y,sign);
            }
        }
        return map;
    }
}

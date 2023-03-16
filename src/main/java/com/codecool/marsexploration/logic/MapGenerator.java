package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.ui.PrintMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapGenerator {
    private final MapConfig mapConfig;
    ShapeGenerator shapeGenerator;
    AreaGenerator areaGenerator;

    public MapGenerator(MapConfig mapConfig,AreaGenerator areaGenerator,ShapeGenerator shapeGenerator) {
        this.areaGenerator = areaGenerator;
        this.shapeGenerator = shapeGenerator;
        this.mapConfig = mapConfig;
    }

    public void generate() {

        List<List<Coordinate>> allAreas = new ArrayList<>();
        allAreas.add(shapeGenerator.getOneShapeSecondVersion(30,areaGenerator.getAreasForSmallMap().get(0)));
        allAreas.add(shapeGenerator.getOneShapeSecondVersion(20,areaGenerator.getAreasForSmallMap().get(1)));
        allAreas.add(shapeGenerator.getOneShapeSecondVersion(10,areaGenerator.getAreasForSmallMap().get(2)));
        allAreas.add(shapeGenerator.getOneShapeSecondVersion(5,areaGenerator.getAreasForSmallMap().get(3)));
        allAreas.add(shapeGenerator.getOneShapeSecondVersion(15,areaGenerator.getAreasForSmallMap().get(4)));


        List<List<String>> stringMap = getEmptyMap();
        addShapesToMap(stringMap,allAreas,"*");

        PrintMap printMap = new PrintMap();
        printMap.run(stringMap);
    
    }
    public List<List<Coordinate>> getShapesForOneResource(List<Coordinate> shapes){
        AreaGenerator areaGenerator = new AreaGenerator();


        for(int i =0;i< areaGenerator.getAreasForSmallMap().size();i++){
          // allAreas.add(new ArrayList<>());
        }
       for(int i = 0; i< mapConfig.mountains().size();i++){
           for(int j=0; j< shapes.size();j++){

           }
       }

        return null;
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
        int x ;
        int y;
        System.out.println(shapes.get(0));
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

package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Area;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MapConfig;

import java.util.*;

public class ShapeGenerator {

private Random random;
    public ShapeGenerator(Random random) {
        this.random = random;
    }
    public  List<Coordinate> getOneShape(int shapeLength, Area area){
        Map<String,Coordinate > uniqueCoordinatesOfShape = new HashMap<>();
        int x = random.nextInt(area.yMin(), area.yMax()+1);
        int y = random.nextInt(area.xMin(), area.xMax()+1);
        String keyOfStartingPoint = setStartingPoint(uniqueCoordinatesOfShape, y, x);
        setUniqueCoordinatesForOneShape(shapeLength, area, uniqueCoordinatesOfShape, x, y, keyOfStartingPoint);
        return new ArrayList<>(uniqueCoordinatesOfShape.values());
    }
    private static String setStartingPoint(Map<String, Coordinate> shapeCoordinate, int x, int y) {
        Coordinate startingPoint  = new Coordinate(x, y);
        String keyOfStartingPoint =(x + "" + y);
        shapeCoordinate.put(keyOfStartingPoint,startingPoint);
        return keyOfStartingPoint;
    }
    private void setUniqueCoordinatesForOneShape(int shapeLength, Area area, Map<String, Coordinate> shapeList, int x, int y, String keyOfStartingPoint) {
        while(shapeList.size()< shapeLength){
            y = random.nextInt(y -1, y +2);
            x = random.nextInt(x -1, x +2);
            if(y < area.xMin() || y >= area.xMax()|| x < area.yMin() || x >= area.yMax()) {
                y = shapeList.get(keyOfStartingPoint).x();
                x = shapeList.get(keyOfStartingPoint).y();
                continue;
            }
            shapeList.put(y +""+ x,new Coordinate(y, x));
        }
    }

}

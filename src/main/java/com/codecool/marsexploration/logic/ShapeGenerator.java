package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Area;
import com.codecool.marsexploration.data.Coordinate;

import java.util.*;

public class ShapeGenerator {

private Random random;
    public ShapeGenerator(Random random) {
        this.random = random;
    }
    public  List<Coordinate> getOneShapeSecondVersion( int shapeLength, Area area){
        Map<String,Coordinate > shapeList = new HashMap<>();
        int x = random.nextInt(area.xMin(), area.xMax()+1);
        int y = random.nextInt(area.yMin(), area.yMax()+1);
        Coordinate startingPoint  = new Coordinate(x,y);
        String keyOfStartingPoint =(x+ "" +y);
        shapeList.put(keyOfStartingPoint,startingPoint);
        while(shapeList.size()< shapeLength){
            x = random.nextInt(x-1,x+2);
            y= random.nextInt(y-1,y+2);
            if(x< area.xMin() || x >= area.xMax()|| y < area.yMin() || y >= area.yMax()) {
                x = shapeList.get(keyOfStartingPoint).x();
                y = shapeList.get(keyOfStartingPoint).y();
                continue;
            }
            shapeList.put(x+""+y,new Coordinate(x,y));
        }
        return new ArrayList<>(shapeList.values());
    }
}

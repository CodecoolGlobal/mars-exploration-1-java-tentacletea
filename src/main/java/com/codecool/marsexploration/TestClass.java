package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.logic.ShapeGenerator;
import com.codecool.marsexploration.ui.PrintMap;

import java.util.*;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        String outputPath = "src/main/resources/exploration.map";
        int mapWidth = 20;
        Random random = new Random();
        List<Integer> mountains = new ArrayList<>();
        List<Integer> pits = new ArrayList<>();
        mountains.add(10);
        mountains.add(20);
        mountains.add(30);
        pits.add(5);
        pits.add(15);

        int water = 2;
        int minerals = 5;

        MapConfig mapConfig = new MapConfig(outputPath, mapWidth, mountains, pits, water, minerals);
        ShapeGenerator shapegenerator = new ShapeGenerator(mapConfig.mapWidth());

        PrintMap printMap = new PrintMap();
      //  List<List<String>> addedMountainMap=   shapegenerator.addShapesToMap(shapegenerator.getEmptyMap(),shapegenerator.getDummyMountainShapes(),"^");
      //  List<List<String>> addedPitsToMountainMap = shapegenerator.addShapesToMap(addedMountainMap,shapegenerator.getDummyPitShapes(),"#");
       List<List<String>> testShape = shapegenerator.addShapesToMap(shapegenerator.getEmptyMap(),shapegenerator.getOneShapeSecondVersion(random,30),"*");
        printMap.run(testShape);
       // System.out.println(getOneShapeSecondVersion(random,10));
    }

    public static List<Coordinate> getOneShapeThirdVersion(Random random, int shapesize){

        Map<String,Coordinate > shape = new HashMap();
        int x = random.nextInt(0,19);
        int y = random.nextInt(0,19);
        Coordinate startingPoint  = new Coordinate(x,y);
        shape.put((x+ "" +y),startingPoint);
        while(shape.size()< shapesize){
            x = random.nextInt(x-1,x+2);
            y= random.nextInt(y-1,y+2);
            shape.put(x+" "+y,new Coordinate(x,y));
        }


        //shape.values().stream().collect(Collectors.toList());
        return new ArrayList<>(shape.values());
    }



    public static List<Coordinate> getOneShape(Random random, int shapesize){
        List<Coordinate> shape = new ArrayList<>();
        List<String>alreadyChosenCoordinates = new ArrayList<>();
        int x = random.nextInt(0,19);
        int y = random.nextInt(0,19);
        Coordinate startingPoint = new Coordinate(x,y);
        shape.add(startingPoint);
        alreadyChosenCoordinates.add(x+""+y);
        boolean alreadyChoosen ;
        for(int i =0; i< shapesize-1;i++){
            do {
                alreadyChoosen = false;
                x = random.nextInt(x-1,x+2);
                y= random.nextInt(y-1,y+2);

                for (String coordinate:alreadyChosenCoordinates) {
                    String generatedRandom =(x+""+y);
                    if(coordinate.equals(generatedRandom)){
                        alreadyChoosen=true;
                    }
                }
            }while((x < 0 || x > 19) && (y< 0 || y>19)&& alreadyChoosen);

            shape.add(new Coordinate(x,y));
            alreadyChosenCoordinates.add((x+""+y));
        }
        return shape;
    }
}

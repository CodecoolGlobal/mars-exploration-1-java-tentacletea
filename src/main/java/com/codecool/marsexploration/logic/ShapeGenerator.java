package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;

import java.util.*;

public class ShapeGenerator {

private int mapWidth;

    public ShapeGenerator(int mapWidth) {
        this.mapWidth = mapWidth;
    }


    public List<List<String>> getEmptyMap(){
        List<List<String>> emptyMap = new ArrayList<>();
        for(int i = 0;i< mapWidth;i++){
            emptyMap.add(new ArrayList<>());
            for(int j= 0; j< mapWidth;j++){
               emptyMap.get(i).add(" ");
            }
        }
        return emptyMap;
    }

 public List<List<String>> addShapesToMap(List<List<String>> map,List<List<Coordinate>> shapes,String sign){
         int x ;
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
    public  List<List<Coordinate>> getOneShapeSecondVersion(Random random, int shapesize){

        Map<String,Coordinate > shape = new HashMap<>();
        int x = random.nextInt(0,19);
        int y = random.nextInt(0,19);
        int previousX;
        int previousY;
        Coordinate startingPoint  = new Coordinate(x,y);
        shape.put((x+ "" +y),startingPoint);
        while(shape.size()< shapesize){

            x = random.nextInt(x-1,x+2);
            y= random.nextInt(y-1,y+2);
            System.out.println("x: " + x +" y: " + y);
            if(x< 0 || x > shapesize-1 || y < 0 || y > shapesize -1){
                continue;
            }
            shape.put(x+" "+y,new Coordinate(x,y));
        }
        System.out.println(shape.size());
        //shape.values().stream().collect(Collectors.toList());
        List<List<Coordinate>> test = new ArrayList<>();
        test.add( new ArrayList<>(shape.values()));
        return test;
    }


 public List<List<Coordinate>> getDummyMountainShapes(){
        List<List<Coordinate>> mountainShapes = new ArrayList<>();
        List<Coordinate> mountainShape1 = new ArrayList<>();
        List<Coordinate> mountainShape2 = new ArrayList<>();
        List<Coordinate> mountainShape3 = new ArrayList<>();

        mountainShape1.add(new Coordinate(2,0));
        mountainShape1.add(new Coordinate(3,1));
        mountainShape1.add(new Coordinate(4,1));
        mountainShape1.add(new Coordinate(5,0));
        mountainShape1.add(new Coordinate(6,0));
        mountainShape1.add(new Coordinate(7,1));
        mountainShape1.add(new Coordinate(6,2));
        mountainShape1.add(new Coordinate(5,3));
        mountainShape1.add(new Coordinate(5,4));
        mountainShape1.add(new Coordinate(6,4));

        mountainShape1.add(new Coordinate(7,4));
        mountainShape1.add(new Coordinate(8,3));
        mountainShape1.add(new Coordinate(9,2));
        mountainShape1.add(new Coordinate(9,3));
        mountainShape1.add(new Coordinate(9,4));
        mountainShape1.add(new Coordinate(10,4));
        mountainShape1.add(new Coordinate(9,6));
        mountainShape1.add(new Coordinate(8,7));
        mountainShape1.add(new Coordinate(7,7));
        mountainShape1.add(new Coordinate(6,8));

        mountainShape1.add(new Coordinate(7,8));
        mountainShape1.add(new Coordinate(8,7));
        mountainShape1.add(new Coordinate(9,6));
        mountainShape1.add(new Coordinate(10,6));
        mountainShape1.add(new Coordinate(11,5));
        mountainShape1.add(new Coordinate(10,4));
        mountainShape1.add(new Coordinate(11,3));
        mountainShape1.add(new Coordinate(12,2));
        mountainShape1.add(new Coordinate(11,1));
        mountainShape1.add(new Coordinate(12,0));

        //---------------------------------------------

        mountainShape2.add(new Coordinate(19,18));
        mountainShape2.add(new Coordinate(18,18));
        mountainShape2.add(new Coordinate(18,17));
        mountainShape2.add(new Coordinate(17,17));
        mountainShape2.add(new Coordinate(17,16));
        mountainShape2.add(new Coordinate(16,16));
        mountainShape2.add(new Coordinate(16,15));
        mountainShape2.add(new Coordinate(17,14));
        mountainShape2.add(new Coordinate(18,13));
        mountainShape2.add(new Coordinate(19,12));

        mountainShape2.add(new Coordinate(15,16));
        mountainShape2.add(new Coordinate(14,17));
        mountainShape2.add(new Coordinate(13,18));
        mountainShape2.add(new Coordinate(14,17));
        mountainShape2.add(new Coordinate(13,15));
        mountainShape2.add(new Coordinate(12,16));
        mountainShape2.add(new Coordinate(11,16));
        mountainShape2.add(new Coordinate(10,17));
        mountainShape2.add(new Coordinate(9,18));
        mountainShape2.add(new Coordinate(8,17));
        //--------------------------------------------

        mountainShape3.add(new Coordinate(1,17));
        mountainShape3.add(new Coordinate(2,17));
        mountainShape3.add(new Coordinate(3,18));
        mountainShape3.add(new Coordinate(4,17));
        mountainShape3.add(new Coordinate(3,16));
        mountainShape3.add(new Coordinate(4,15));
        mountainShape3.add(new Coordinate(3,14));
        mountainShape3.add(new Coordinate(4,14));
        mountainShape3.add(new Coordinate(5,14));
        mountainShape3.add(new Coordinate(6,15));

        mountainShapes.add(mountainShape1);
        mountainShapes.add(mountainShape2);
        mountainShapes.add(mountainShape3);

        return mountainShapes;
    }


    public List<List<Coordinate>> getDummyPitShapes(){
        List<List<Coordinate>> pitShapes = new ArrayList<>();
        List<Coordinate> pitShape1 = new ArrayList<>();
        List<Coordinate> pitShape2 = new ArrayList<>();

        pitShape1.add(new Coordinate(18,1));
        pitShape1.add(new Coordinate(18,2));
        pitShape1.add(new Coordinate(18,3));
        pitShape1.add(new Coordinate(17,2));
        pitShape1.add(new Coordinate(17,3));
        pitShape1.add(new Coordinate(16,4));
        pitShape1.add(new Coordinate(15,4));
        pitShape1.add(new Coordinate(15,3));
        pitShape1.add(new Coordinate(15,2));
        pitShape1.add(new Coordinate(14,3));
        pitShape1.add(new Coordinate(14,4));
        pitShape1.add(new Coordinate(14,5));
        pitShape1.add(new Coordinate(13,6));
        pitShape1.add(new Coordinate(14,7));
        pitShape1.add(new Coordinate(15,8));
//-----------------------------------------------

        pitShape2.add(new Coordinate(8,12));
        pitShape2.add(new Coordinate(7,12));
        pitShape2.add(new Coordinate(6,12));
        pitShape2.add(new Coordinate(5,12));
        pitShape2.add(new Coordinate(4,13));
        pitShape2.add(new Coordinate(3,14));
        pitShape2.add(new Coordinate(1,14));
        pitShape2.add(new Coordinate(5,13));
        pitShape2.add(new Coordinate(3,13));
        pitShape2.add(new Coordinate(4,11));

        pitShapes.add(pitShape1);
        pitShapes.add(pitShape2);
        return pitShapes;
    }




}

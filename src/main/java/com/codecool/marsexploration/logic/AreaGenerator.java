package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Area;
import com.codecool.marsexploration.data.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class AreaGenerator {


    public List<Area> getAreasForSmallMap(){
        List<Area> areas = new ArrayList<>();
        Area area1 = new Area(0,7,13,24);
        Area area2 =new Area(8,15,13,24);
        Area area3 = new Area(16,24,13,24);
        Area area4 = new Area(0,11,0,11);
        Area area5 = new Area(13,24,0,11);
        areas.add(area1);
        areas.add(area2);
        areas.add(area3);
        areas.add(area4);
        areas.add(area5);

      return  areas;
    }
    public List<Area> getAreasForMediumMap(){
return null;
    }
    public List<Area> getAreasForBigMap(){
      return null;
    }
}

package Airline.Comparator;

import Airline.Plane;
import java.util.Comparator;

public class FlyDistanceComparator implements Comparator<Plane>{
    @Override
    public int compare(Plane p1, Plane p2){
        return p2.getFlyDistance() - p1.getFlyDistance();
    }
}

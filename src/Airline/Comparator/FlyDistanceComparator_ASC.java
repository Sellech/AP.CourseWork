package Airline.Comparator;

import Airline.Plane;
import java.util.Comparator;

public class FlyDistanceComparator_ASC implements Comparator<Plane>{
    @Override
    public int compare(Plane p1, Plane p2){
        return p1.getFlyDistance() - p2.getFlyDistance();
    }
}

package Airline.Comparator;

import Airline.Plane;
import java.util.Comparator;

public class CargoCapacityComparator_ASC implements Comparator<Plane>{
    @Override
    public int compare(Plane p1, Plane p2){
        return (int)(p1.getCargoCapacity() - p2.getCargoCapacity());
    }
}

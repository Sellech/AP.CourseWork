package Airline.Comparator;

import Airline.Plane;
import java.util.Comparator;

public class PassengerCapacityComparator implements Comparator<Plane>{
    @Override
    public int compare(Plane p1, Plane p2){
        return p2.getPassengerCapacity() - p1.getPassengerCapacity();
    }
}

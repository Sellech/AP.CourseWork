package Airline.Comparator;

import Airline.Plane;
import java.util.Comparator;

public class PassengerCapacityComparator_ASC implements Comparator<Plane>{
    @Override
    public int compare(Plane p1, Plane p2){
        return p1.getPassengerCapacity() - p2.getPassengerCapacity();
    }
}
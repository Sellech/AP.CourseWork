package Airline.Comparator;

import Airline.Plane;
import java.util.Comparator;

public class FuelConsumptionComparator implements Comparator<Plane>{
    @Override
    public int compare(Plane p1, Plane p2){
        return (int)(p2.getFuelConsumption() - p1.getFuelConsumption());
    }
}
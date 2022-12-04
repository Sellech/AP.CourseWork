package Airline;

public class Plane {
    private String Name;
    private String SideNumber;
    private int FlyDistance;
    private double FuelConsumption;
    private int PassengerCapacity;
    private int CargoCapacity;

    public Plane(String Name, String SideNumber, int FlyDistance,
                 double FuelConsumption, int PassengerCapacity, int CargoCapacity) {
        this.Name = Name;
        this.SideNumber = SideNumber;
        this.FlyDistance = FlyDistance;
        this.FuelConsumption = FuelConsumption;
        this.PassengerCapacity = PassengerCapacity;
        this.CargoCapacity = CargoCapacity;
    }

    @Override
    public String toString() {
        return Name + " " + SideNumber;
    }
}

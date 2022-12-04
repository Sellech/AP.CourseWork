package Airline;

public class Plane {
    private String Name;
    private String SideNumber;
    private int FlyDistance;
    private double FuelConsumption;
    private int PassengerCapacity;
    private double CargoCapacity;

    public Plane(String Name, String SideNumber, int FlyDistance,
                 double FuelConsumption, int PassengerCapacity, double CargoCapacity) {
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

    public void setName(String name) {
        Name = name;
    }

    public void setSideNumber(String sideNumber) {
        SideNumber = sideNumber;
    }

    public void setFlyDistance(int flyDistance) {
        FlyDistance = flyDistance;
    }

    public void setFuelConsumption(double fuelConsumption) {
        FuelConsumption = fuelConsumption;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        PassengerCapacity = passengerCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        CargoCapacity = cargoCapacity;
    }

    public String getName() {
        return Name;
    }

    public String getSideNumber() {
        return SideNumber;
    }

    public int getFlyDistance() {
        return FlyDistance;
    }

    public double getFuelConsumption() {
        return FuelConsumption;
    }

    public int getPassengerCapacity() {
        return PassengerCapacity;
    }

    public double getCargoCapacity() {
        return CargoCapacity;
    }
}

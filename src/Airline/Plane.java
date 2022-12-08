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

    /**
     * Метод для виведення детальної інформації про літак
     * @return містить сформовану стрічку на 5 рядків, яка містить необхідну інформацію
     */
    public String detailInformation(){
        return (Name + "  SN:" + SideNumber
                + "\n\tДальність: " + FlyDistance + " (км)"
                + "\n\tСпоживання палива: " + FuelConsumption + " (т/год)"
                + "\n\tПасажиромісткість: " + PassengerCapacity
                + "\n\tВантажопідйомність: " + CargoCapacity + " (т)");
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

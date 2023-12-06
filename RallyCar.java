package org.example;

public class RallyCar extends Car{
    private double consumptionChange;
    private double powerChange;

    public RallyCar(String VIN, String brand, Engine engine, String owner, int year, double mileage, double consumptionChange, double powerChange) {
        super(VIN, brand, engine, owner, year, mileage);
        engine.setPower((engine.getPower()*powerChange)/ 100 + engine.getPower());
        engine.setConsumption((engine.getConsumption()*consumptionChange)/100 + engine.getConsumption());
        this.consumptionChange = consumptionChange;
        this.powerChange = powerChange;

    }

    @Override
    public String toString() {
        return "RallyCar{" +
                "VIN='" + getVIN() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", engine:(" + getEngine() +
                "), owner='" + getOwner() + '\'' +
                ", year=" + getYear() +
                ", mileage=" + getMileage() +
                ", consumptionCahnge=" + consumptionChange +
                ", powerChange=" +powerChange +
                '}';
    }
}

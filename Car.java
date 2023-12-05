package org.example;

public class Car {
    private String VIN;
    private String brand;
    private Engine engine;
    private String owner;
    private int year; // production year
    private double mileage; // przebieg w tys km np 15.45 (15450)

    public Car(String VIN, String brand, Engine engine, String owner, int year, double mileage) {
        this.VIN = VIN;
        this.brand = brand;
        this.engine = engine;
        this.owner = owner;
        this.year = year;
        this.mileage = mileage;
    }

    public String getVIN() {
        return VIN;
    }

    public String getBrand() {
        return brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getOwner() {
        return owner;
    }

    public int getYear() {
        return year;
    }

    public double getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "VIN='" + VIN + '\'' +
                ", brand='" + brand + '\'' +
                ", engine:(" + engine +
                "), owner='" + owner + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                '}';
    }
}

package org.example;

public class Engine {
    private String name;
    private double consumption;
    private double power;

    public Engine(String name, double consumption, double power) {
        this.name = name;
        this.consumption = consumption;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "name='" + name + '\'' +
                ", consumption=" + consumption +
                ", power=" + power +
                '}';
    }
}

package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        try{
            Path path = Paths.get("D:/Kolokwium/src/main/java/org/example/Cars_Data.txt");
            List<String> lines = Files.readAllLines(path);

            for(String line : lines){
                String [] carData = line.split("\\s+");

                String owner = String.join(" ", carData[5], carData[6]);

                Car car = new Car(carData[0], carData[1], new Engine(carData[2], Double.parseDouble(carData[3]),
                        Double.parseDouble(carData[4])), owner, Integer.parseInt(carData[7]), Double.parseDouble(carData[8]));
                cars.add(car);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        try{
            Path path = Paths.get("D:/Kolokwium/src/main/java/org/example/RC_Data.txt");
            List<String> lines = Files.readAllLines(path);

            for(String line : lines){
                String carData[] = line.split("\\s+");

                String owner = String.join(" ", carData[5], carData[6]);

                Car car = new RallyCar(carData[0], carData[1], new Engine(carData[2], Double.parseDouble(carData[3]),
                        Double.parseDouble(carData[4])), owner, Integer.parseInt(carData[7]), Double.parseDouble(carData[8]), Double.parseDouble(carData[9]), Double.parseDouble(carData[10]));
                cars.add(car);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        printAllInfoAboutCars(cars);
    }
    private static void printAllInfoAboutCars(List<Car> cars){
        for(Car car : cars){
            System.out.println(car);
        }
    }
}
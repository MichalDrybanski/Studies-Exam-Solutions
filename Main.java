package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = readCarsFromFile("D:/Kolokwium/src/main/java/org/example/Cars_Data.txt");
        cars.addAll(readRallyCarsFromFile("D:/Kolokwium/src/main/java/org/example/RC_Data.txt"));

        printAllInfoAboutCars(cars);
        System.out.print("-".repeat(20) + "\n");
        printStandardCars(cars);
        System.out.print("-".repeat(20) + "\n");
        changingMillageStandardCars(cars);
        System.out.print("-".repeat(20) + "\n");
        displayTotalMileageForFordCarsAfter2018(cars, "Ford", 2018);
        System.out.print("-".repeat(20) + "\n");
        displaySortedCarsByOwnerByYearByMileage(cars);
    }
    private static void displaySortedCarsByOwnerByYearByMileage(List<Car> cars){
        cars.stream()
                .sorted(Comparator.comparing(Car::getOwner)
                        .thenComparingInt(Car::getYear)
                        .thenComparingDouble(Car::getMileage))
                .forEach(s -> System.out.println(s));
    }
    private static void displayTotalMileageForFordCarsAfter2018(List<Car> cars, String carBrand, int yearProduction){
        Function<Car, Double> mileageMapper = car -> car.getMileage();

        double totalMileage = cars.stream()
                .filter(car -> carBrand.equals(car.getBrand()) && car.getYear() > yearProduction)
                .peek(System.out::println)
                .mapToDouble(mileageMapper::apply)
                .sum();
        printMassage("Laczny przebieg samochodow marki Ford po 2018 roku to: " + totalMileage);
    }

    private static List<Car> readCarsFromFile(String filePath) {
        List<Car> cars = new ArrayList<>();
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                String[] carData = line.split("\\s+");
                String owner = String.join(" ", carData[5], carData[6]);

                Car car = new Car(carData[0], carData[1], new Engine(carData[2],
                        Double.parseDouble(carData[3]),
                        Double.parseDouble(carData[4])), owner, Integer.parseInt(carData[7]),
                        Double.parseDouble(carData[8]));
                cars.add(car);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }

    private static List<Car> readRallyCarsFromFile(String filePath) {
        List<Car> rallyCars = new ArrayList<>();
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                String carData[] = line.split("\\s+");
                String owner = String.join(" ", carData[5], carData[6]);

                Car car = new RallyCar(carData[0], carData[1], new Engine(carData[2], Double.parseDouble(carData[3]),
                        Double.parseDouble(carData[4])), owner, Integer.parseInt(carData[7]), Double.parseDouble(carData[8]), Double.parseDouble(carData[9]), Double.parseDouble(carData[10]));
                rallyCars.add(car);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return rallyCars;
    }

    private static void changingMillageStandardCars(List<Car> cars) {
        try (Scanner scanner = new Scanner(System.in)) {
            printMassage("Podaj wysokosc zmiany przbiegu standardowych pojazdow (w procentach)");
            double percentChange = scanner.nextDouble();
            for (Car car : cars) {
                if (car.getClass() == Car.class) {
                    printMassage("Przed zmiana:\n" + car);
                    car.setMileage(((car.getMileage() * percentChange) / 100) + car.getMileage());
                    printMassage("Po zmianie: \n" + car);
                }
            }
        }
    }

    private static void printAllInfoAboutCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static void printStandardCars(List<Car> cars) {
        for (Car car : cars) {
            if (car.getClass() == Car.class)
                System.out.println(car);
        }
    }

    private static void printMassage(String message) {
        System.out.println(message);
    }
}
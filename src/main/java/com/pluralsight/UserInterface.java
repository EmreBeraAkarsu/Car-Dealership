package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }

    public void display() {

        init();

        byte option = 0;

        while (true) {

            option = displayMenu();

            switch (option) {
                case 1:

                    processGetByPriceRequest();
                    break;

                case 2:

                    processGetByMakeModelRequest();
                    break;

                case 3:

                    processGetByYearRequest();
                    break;

                case 4:

                    processGetByColorRequest();
                    break;

                case 5:

                    processGetByMileageRequest();
                    break;

                case 6:

                    processGetByVehicleTypeRequest();
                    break;

                case 7:

                    processGetAllVehiclesRequest();
                    break;

                case 8:

                    processAddVehicleRequest();
                    break;

                case 9:

                    processRemoveVehicleRequest();
                    break;

                case 99:

                    return;
            }
        }
    }

    public byte displayMenu() {

        System.out.println("Enter one of the following options: ");

        System.out.println("1 - Find vehicles within a price range");
        System.out.println("2 - Find vehicles by make / model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type (car, truck, SUV, van");
        System.out.println("7 - List All vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");

        byte option = scanner.nextByte();
        scanner.nextLine();

        if (option >= 1 && option <= 9 || option == 99) {
            return option;
        } else {
            System.out.println("Invalid Option selected");
            return displayMenu();
        }
    }

    public void processGetByPriceRequest() {

        System.out.println("Enter the min price: ");
        double min = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter the max price: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    public void processGetByMakeModelRequest() {
        System.out.println("Enter the make of the car: ");
        String make = scanner.nextLine();

        System.out.println("Enter the model of the car: ");
        String model = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetByYearRequest() {
        System.out.println("Enter the min year: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the max year: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    public void processGetByColorRequest() {
        System.out.println("Enter the color: ");
        String color = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest() {
        System.out.println("Enter the min mileage: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the max mileage: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("Enter the type: ");
        String type = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByType(type));
    }

    public void processGetAllVehiclesRequest() {

        displayVehicles(this.dealership.getAllVehicles());

    }

    public void processAddVehicleRequest() {
        System.out.println("Enter the vin of the vehicle: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the year of the vehicle: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the make of the vehicle: ");
        String  make = scanner.nextLine();

        System.out.println("Enter the model of the vehicle: ");
        String  model = scanner.nextLine();

        System.out.println("Enter the vehicle type of the vehicle: ");
        String  vehicleType = scanner.nextLine();

        System.out.println("Enter the color of the vehicle: ");
        String  color = scanner.nextLine();

        System.out.println("Enter the odometer of the vehicle: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the price of the vehicle: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
    }

    public void processRemoveVehicleRequest() {
        System.out.println("Enter the vin of the vehicle you want to remove: ");
        int vin = scanner.nextInt();
        scanner.nextInt();

        dealership.removeVehicle(vin);
    }

    private void init() {

        DealershipFileManager dealershipFileManager = new DealershipFileManager();

        this.dealership = dealershipFileManager.getDealership();

    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }
}

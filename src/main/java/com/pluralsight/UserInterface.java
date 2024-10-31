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

            //Call displayMenu and store the option returned
            option = displayMenu();

            //Use the option to determine which method to call
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

    //Displays a menu and prompts the user for an option to select
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
        //Prompt the user to enter the values for min and max price
        System.out.println("Enter the min price: ");
        double min = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter the max price: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        //Call the Dealership's getVehiclesByPrice method and display the returned list
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    public void processGetByMakeModelRequest() {

        //Prompt the user to enter the make and model
        System.out.println("Enter the make of the car: ");
        String make = scanner.nextLine();

        System.out.println("Enter the model of the car: ");
        String model = scanner.nextLine();

        //Call the Dealership's getVehiclesByMakeModel method and display the returned list
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetByYearRequest() {
        //Prompt the user to enter the year
        System.out.println("Enter the min year: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the max year: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        //Call the Dealership's getVehiclesByYear method and display the returned list
        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    public void processGetByColorRequest() {
        //Prompt the user to enter the color
        System.out.println("Enter the color: ");
        String color = scanner.nextLine();

        //Call the Dealership's getVehiclesByColor method and display the returned list
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest() {
        //Prompt the user to enter the Mileage
        System.out.println("Enter the min mileage: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the max mileage: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        //Call the Dealership's getVehiclesByMileage method and display the returned list
        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    public void processGetByVehicleTypeRequest() {
        //Prompt the user to enter the type
        System.out.println("Enter the type: ");
        String type = scanner.nextLine();

        //Call the Dealership's getVehiclesByType method and display the returned list
        displayVehicles(dealership.getVehiclesByType(type));
    }

    public void processGetAllVehiclesRequest() {

        displayVehicles(this.dealership.getAllVehicles());

    }

    public void processAddVehicleRequest() {
        //Prompt the user to enter the variables of the vehicle to add
        System.out.println("Enter the vin of the vehicle: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the year of the vehicle: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the make of the vehicle: ");
        String make = scanner.nextLine();

        System.out.println("Enter the model of the vehicle: ");
        String model = scanner.nextLine();

        System.out.println("Enter the vehicle type of the vehicle: ");
        String vehicleType = scanner.nextLine();

        System.out.println("Enter the color of the vehicle: ");
        String color = scanner.nextLine();

        System.out.println("Enter the odometer of the vehicle: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the price of the vehicle: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        //Call the Dealership's addVehicle method and add a newly created vehicle with the inputted variables
        dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
    }

    public void processRemoveVehicleRequest() {

        //Prompt the user to enter the vin of the vehicle to remove
        System.out.println("Enter the vin of the vehicle you want to remove: ");
        int vin = scanner.nextInt();
        scanner.nextInt();

        //Call the Dealership's removeVehicle method and remove the vehicle with the matching vin
        dealership.removeVehicle(vin);
    }

    //Initialize a new Dealership with the data of the file
    private void init() {

        DealershipFileManager dealershipFileManager = new DealershipFileManager();

        this.dealership = dealershipFileManager.getDealership();

    }

    //Iterate through the inputted list and display its contents
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

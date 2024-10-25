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


    }

    public void processGetByMakeModelRequest() {


    }

    public void processGetByYearRequest() {


    }

    public void processGetByColorRequest() {


    }

    public void processGetByMileageRequest() {


    }

    public void processGetByVehicleTypeRequest() {


    }

    public void processGetAllVehiclesRequest() {

        displayVehicles(this.dealership.getAllVehicles());

    }

    public void processAddVehicleRequest() {


    }

    public void processRemoveVehicleRequest() {


    }

    private void init() {

        DealershipFileManager dealershipFileManager = new DealershipFileManager();

        this.dealership = dealershipFileManager.getDealership();

    }

    private void displayVehicles(List<Vehicle> vehicles) {

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}

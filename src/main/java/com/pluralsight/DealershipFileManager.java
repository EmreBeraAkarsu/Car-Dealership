package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Manages reading and writing dealership data to and from a file.
public class DealershipFileManager {

    // Default filename for storing dealership data
    private String filename = "dealership.csv";

    public String getFilename() {
        return filename;
    }

    //// Instance of the Dealership class to hold dealership data
    Dealership dealership;

    public void setFilename(String filename) {
        this.filename = filename;
    }

    //Reads dealership data from the specified file and constructs a Dealership object.
    public Dealership getDealership() {

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            //Initialize the dealership variables
            String dealerName = "";
            String dealerAddress = "";
            String dealerPhone = "";

            ArrayList<Vehicle> vehicles = new ArrayList<>();
            //Initialize the vehicle variables
            int vin = 0;
            int year = 0;
            String make = "";
            String model = "";
            String vehicleType = "";
            String color = "";
            int odometer = 0;
            double price = 0;

            String input;

            //Counter to determine which line we are at
            int i = 0;

            while ((input = bufferedReader.readLine()) != null) {

                String[] strings = input.split("\\|");

                //If the counter shows we are reading the first line, create a dealership object
                if (i < 1) {

                    dealerName = strings[0];
                    dealerAddress = strings[1];
                    dealerPhone = strings[2];
                }

                //If the counter shows we are reading not the first line, create a vehicle object
                if (i >= 1) {

                    vin = Integer.parseInt(strings[0]);
                    year = Integer.parseInt(strings[1]);
                    make = strings[2];
                    model = strings[3];
                    vehicleType = strings[4];
                    color = strings[5];
                    odometer = Integer.parseInt(strings[6]);
                    price = Double.parseDouble(strings[7]);

                    vehicles.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
                }

                i++;
            }

            dealership = new Dealership(dealerName, dealerAddress, dealerPhone);

            for (Vehicle vehicle : vehicles) {

                dealership.addVehicle(vehicle);
            }

            bufferedReader.close();

            return dealership;

        } catch (Exception e) {
            System.err.println("Error reading the file");
            return null;
        }
    }

    public void saveDealership(Dealership dealership) {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(dealership);

            List<Vehicle> vehicles = dealership.getAllVehicles();

            for (Vehicle vehicle : vehicles) {
                stringBuilder.append(vehicle);
            }

            bufferedWriter.write(String.valueOf(stringBuilder));

            bufferedWriter.close();

        } catch (Exception e) {
            System.err.println("Error writing to the file");
        }

    }
}

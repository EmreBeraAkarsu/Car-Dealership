package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    private String filename = "dealership.csv";

    public String getFilename() {
        return filename;
    }

    Dealership dealership;

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Dealership getDealership() {

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            String dealerName = "";
            String dealerAddress = "";
            String dealerPhone = "";

            ArrayList<Vehicle> vehicles = new ArrayList<>();
            int vin = 0;
            int year = 0;
            String make = "";
            String model = "";
            String vehicleType = "";
            String color = "";
            int odometer = 0;
            double price = 0;

            String input;
            int i = 0;

            while ((input = bufferedReader.readLine()) != null) {

                String[] strings = input.split("\\|");

                if (i < 1) {

                    dealerName = strings[0];
                    dealerAddress = strings[1];
                    dealerPhone = strings[2];
                }

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

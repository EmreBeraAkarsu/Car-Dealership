package com.pluralsight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    //Retrieves a list of vehicles within a specified price range.
    public List<Vehicle> getVehiclesByPrice(double min,double max){

        List<Vehicle> filteredList = new ArrayList<>();

        Iterator<Vehicle> iterator = inventory.iterator();

        while (iterator.hasNext()){

            Vehicle vehicle = iterator.next();

            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max){
                filteredList.add(vehicle);
            }
        }
        return filteredList;

    }

    //Retrieves a list of vehicles that match a specified make and model.
    public List<Vehicle> getVehiclesByMakeModel(String make, String model){

        List<Vehicle> filteredList = new ArrayList<>();

        Iterator<Vehicle> iterator = inventory.iterator();


        while (iterator.hasNext()){
            Vehicle vehicle = iterator.next();
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                filteredList.add(vehicle);
            }
        }
        return filteredList;
    }

    //Retrieves a list of vehicles within a specified range of manufacturing years.
    public List<Vehicle>  getVehiclesByYear(int min, int max){

        List<Vehicle> filteredList = new ArrayList<>();

        Iterator<Vehicle> iterator = inventory.iterator();

        while (iterator.hasNext()){

            Vehicle vehicle = iterator.next();
            if (vehicle.getYear() >= min && vehicle.getYear() <= max){
                filteredList.add(vehicle);
            }
        }
        return filteredList;
    }

    //Retrieves a list of vehicles that match a specified color.
    public List<Vehicle> getVehiclesByColor(String color){

        List<Vehicle> filteredList = new ArrayList<>();

        Iterator<Vehicle> iterator = inventory.iterator();

        while (iterator.hasNext()){

            Vehicle vehicle = iterator.next();
            if (vehicle.getColor().equalsIgnoreCase(color)){
                filteredList.add(vehicle);
            }
        }
        return filteredList;
    }

    //Retrieves a list of vehicles within a specified range of mileage (odometer reading).
    public  List<Vehicle> getVehiclesByMileage(int min, int max){

        List<Vehicle> filteredList = new ArrayList<>();

        Iterator<Vehicle> iterator = inventory.iterator();

        while (iterator.hasNext()){
            Vehicle vehicle = iterator.next();
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                filteredList.add(vehicle);
            }
        }

        return filteredList;
    }

    //Retrieves a list of vehicles that match a specified type.
    public  List<Vehicle> getVehiclesByType(String vehicleType){

        List<Vehicle> filteredList = new ArrayList<>();

        Iterator<Vehicle> iterator = inventory.iterator();

        while (iterator.hasNext()){
            Vehicle vehicle = iterator.next();
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                filteredList.add(vehicle);
            }
        }

        return filteredList;
    }

    //Retrieves the entire inventory of vehicles.
    public  List<Vehicle> getAllVehicles(){

        return inventory;
    }

    //Adds a new vehicle to the inventory.
    public void addVehicle(Vehicle vehicle){

        inventory.add(vehicle);
    }

    ///**
    //     * Removes a vehicle from the inventory by VIN.
    //     *
    //     * @param vin, VIN of the vehicle to be removed
    //     */
    public void removeVehicle(int vin){

        Iterator<Vehicle> iterator = inventory.iterator();

        while (iterator.hasNext()){

            Vehicle vehicle = iterator.next();
            if (vehicle.getVin() == vin){
                iterator.remove();
            }
        }
    }

    //Returns a string representation of the dealership, including its name, address, phone number, and inventory.
    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}

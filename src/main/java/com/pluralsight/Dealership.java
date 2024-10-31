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

    public List<Vehicle> getVehiclesByPrice(double min,double max){

        List<Vehicle> filteredList = new ArrayList<>();

        Iterator<Vehicle> iterator = inventory.iterator();

        while (iterator.hasNext()){
            if (iterator.next().getPrice() >= min && iterator.next().getPrice() <= max){
                filteredList.add(iterator.next());
            }
        }
        return filteredList;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){

        List<Vehicle> filteredList = new ArrayList<>();

        Iterator<Vehicle> iterator = inventory.iterator();

        while (iterator.hasNext()){
            if (iterator.next().getMake().equalsIgnoreCase(make) && iterator.next().getModel().equalsIgnoreCase(model)){
                filteredList.add(iterator.next());
            }
        }
        return filteredList;
    }

    public List<Vehicle>  getVehiclesByYear(int min, int max){

        List<Vehicle> filteredList = new ArrayList<>();

        Iterator<Vehicle> iterator = inventory.iterator();

        while (iterator.hasNext()){
            if (iterator.next().getYear() >= min && iterator.next().getYear() <= max){
                filteredList.add(iterator.next());
            }
        }
        return filteredList;
    }

    public List<Vehicle> getVehiclesByColor(String color){

        List<Vehicle> filteredList = new ArrayList<>();

        Iterator<Vehicle> iterator = inventory.iterator();

        while (iterator.hasNext()){
            if (iterator.next().getColor().equalsIgnoreCase(color)){
                filteredList.add(iterator.next());
            }
        }
        return filteredList;
    }

    public  List<Vehicle> getVehiclesByMileage(int min, int max){

        List<Vehicle> filteredList = new ArrayList<>();

        Iterator<Vehicle> iterator = inventory.iterator();

        while (iterator.hasNext()){
            if (iterator.next().getOdometer() >= min && iterator.next().getOdometer() <= max){
                filteredList.add(iterator.next());
            }
        }

        return filteredList;
    }

    public  List<Vehicle> getVehiclesByType(String vehicleType){

        List<Vehicle> filteredList = new ArrayList<>();

        Iterator<Vehicle> iterator = inventory.iterator();

        while (iterator.hasNext()){
            if (iterator.next().getVehicleType().equalsIgnoreCase(vehicleType)){
                filteredList.add(iterator.next());
            }
        }

        return filteredList;
    }

    public  List<Vehicle> getAllVehicles(){

        return inventory;
    }

    public void addVehicle(Vehicle vehicle){

        inventory.add(vehicle);
    }

    public void removeVehicle(int vin){

        Iterator<Vehicle> iterator = inventory.iterator();

        while (iterator.hasNext()){
            if (iterator.next().getVin() == vin){
                iterator.remove();
            }
        }
    }
}

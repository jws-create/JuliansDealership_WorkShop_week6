package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public ArrayList<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max){
        ArrayList<Vehicle> vehiclesByPrice = new ArrayList<>();
        for(Vehicle vehicle: inventory){
            if(vehicle.getPrice().compareTo(min) == 1 && vehicle.getPrice().compareTo(max) == -1){
                vehiclesByPrice.add(vehicle);
                printV(vehicle);
            }

        }
        checkEmpty(vehiclesByPrice);
        return vehiclesByPrice;

    }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){

        ArrayList<Vehicle> vehiclesByMakeModel = new ArrayList<>();

        for(Vehicle vehicle : inventory){

            if(vehicle.getMake().equalsIgnoreCase(make)
                    && vehicle.getModel().equalsIgnoreCase(model)){

                vehiclesByMakeModel.add(vehicle);
                printV(vehicle);
            }

        }
        checkEmpty(vehiclesByMakeModel);

        return vehiclesByMakeModel;
    }
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){

        ArrayList<Vehicle> vehiclesByYear = new ArrayList<>();

        for(Vehicle vehicle : inventory){

            if(vehicle.getYear() >= min && vehicle.getYear() <= max){

                vehiclesByYear.add(vehicle);
                printV(vehicle);
            }
        }
        checkEmpty(vehiclesByYear);
        return vehiclesByYear;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color){

        ArrayList<Vehicle> vehiclesByColor = new ArrayList<>();

        for(Vehicle vehicle : inventory){

            if(vehicle.getColor().equalsIgnoreCase(color)){

                vehiclesByColor.add(vehicle);
                printV(vehicle);
            }
        }
        checkEmpty(vehiclesByColor);
        return vehiclesByColor;
    }
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max){

        ArrayList<Vehicle> vehiclesByMileage = new ArrayList<>();

        for(Vehicle vehicle : inventory){

            if(vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){

                vehiclesByMileage.add(vehicle);
                printV(vehicle);
            }
        }
        checkEmpty(vehiclesByMileage);
        return vehiclesByMileage;
    }
    public ArrayList<Vehicle> getVehiclesByType(VehicleType vehicleType){

        ArrayList<Vehicle> vehiclesByType = new ArrayList<>();

        for(Vehicle vehicle : inventory){

            if(vehicle.getVehicleType() == vehicleType){

                vehiclesByType.add(vehicle);
                printV(vehicle);
            }
        }
        checkEmpty(vehiclesByType);
        return vehiclesByType;
    }
    public ArrayList<Vehicle> getAllVehicles(){

        for(Vehicle vehicle : inventory){
            printV(vehicle);
        }

        return inventory;
    }
    public void removeVehicle(Vehicle vehicle){
        printV(vehicle);

        inventory.remove(vehicle);

    }
    public void printV(Vehicle vehicle){
        System.out.println(
                "VIN:" + vehicle.getVin() +
                        " YEAR:" + vehicle.getYear() +
                        " MAKE:" + vehicle.getMake() +
                        " MODEL:" + vehicle.getModel() +
                        " TYPE:" + vehicle.getVehicleType() +
                        " COLOR:" + vehicle.getColor() +
                        " ODOMETER:" + vehicle.getOdometer() +
                        " PRICE:" + vehicle.getPrice());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void checkEmpty(ArrayList<Vehicle> exList){
        if(exList.isEmpty()) {
            System.out.println("the search is empty.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

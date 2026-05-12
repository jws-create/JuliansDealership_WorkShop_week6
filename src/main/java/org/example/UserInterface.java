package org.example;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);


    public static void userInterface(){
        System.out.println("| | / /     |_ U _| |  __   \\\n" +
                "| |/ /        |L|   | |  \\  |\n" +
                "|I| /         |I|   | |   | |\n" +
                "|N| \\    __   |A|   | |   | |\n" +
                "|G|\\ \\  |  |__/N|   | |__/  |\n" +
                "|_| \\_\\  \\ ____/    |_______/EALERS");
        display();
    }
    public static String options(){

            // ANSI Colors
            String RESET = "\u001B[0m";

            String RED = "\u001B[31m";
            String GREEN = "\u001B[32m";
            String YELLOW = "\u001B[33m";
            String BLUE = "\u001B[34m";
            String PURPLE = "\u001B[35m";
            String CYAN = "\u001B[36m";
            String WHITE = "\u001B[37m";

            System.out.println(CYAN +
                    "========================================");
            System.out.println("        FAST VEHICLES DEALERSHIP");
            System.out.println("========================================"
                    + RESET);

            System.out.println(GREEN + "1)" + RESET + " Search by Price");

            System.out.println(YELLOW + "2)" + RESET + " Search by Make / Model");

            System.out.println(BLUE + "3)" + RESET + " Search by Year");

            System.out.println(PURPLE + "4)" + RESET + " Search by Color");

            System.out.println(CYAN + "5)" + RESET + " Search by Mileage");

            System.out.println(RED + "6)" + RESET + " Search by Vehicle Type");

            System.out.println(WHITE + "7)" + RESET + " Show All Vehicles");

            System.out.println(GREEN + "8)" + RESET + " Add Vehicle");

            System.out.println(RED + "9)" + RESET + " Remove Vehicle");

            System.out.println(YELLOW + "0)" + RESET + " Exit");

            System.out.println(CYAN +
                    "========================================"
                    + RESET);

            System.out.print("Select an option: ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return choice;

    }
    public static void display(){
        Dealership dealership = DealershipFileManager.getDealership();
        while (true) {
            Scanner scanner = new Scanner(System.in);

            switch (options()) {
                case "1":
                    System.out.println("enter min");
                    BigDecimal min = scanner.nextBigDecimal();
                    System.out.println("enter max");
                    BigDecimal max = scanner.nextBigDecimal();
                    dealership.getVehiclesByPrice(min, max);
                    break;
                case "2":

                    scanner.nextLine();

                    System.out.println("Enter make:");
                    String make = scanner.nextLine();

                    System.out.println("Enter model:");
                    String model = scanner.nextLine();

                    dealership.getVehiclesByMakeModel(make, model);

                    break;

                case "3":

                    System.out.println("Enter minimum year:");
                    int minYear = scanner.nextInt();

                    System.out.println("Enter maximum year:");
                    int maxYear = scanner.nextInt();

                    dealership.getVehiclesByYear(minYear, maxYear);

                    break;
                case "4":

                    System.out.println("Enter color:");
                    String color = scanner.nextLine();

                    dealership.getVehiclesByColor(color);

                    break;

                case "5":

                    System.out.println("Enter minimum mileage:");
                    int minMileage = scanner.nextInt();

                    System.out.println("Enter maximum mileage:");
                    int maxMileage = scanner.nextInt();

                    dealership.getVehiclesByMileage(minMileage, maxMileage);

                    break;
                case "6":

                    System.out.println("Select Vehicle Type:");
                    System.out.println("1) SEDAN");
                    System.out.println("2) COUP");
                    System.out.println("3) TRUCK");
                    System.out.println("4) MINIVAN");
                    System.out.println("5) SUV");

                    String vehicleChoice = scanner.nextLine();

                    VehicleType vehicleType = null;

                    switch (vehicleChoice) {

                        case "1":
                            vehicleType = VehicleType.SEDAN;
                            break;

                        case "2":
                            vehicleType = VehicleType.COUP;
                            break;

                        case "3":
                            vehicleType = VehicleType.TRUCK;
                            break;

                        case "4":
                            vehicleType = VehicleType.MINIVAN;
                            break;

                        case "5":
                            vehicleType = VehicleType.SUV;
                            break;

                        default:
                            System.out.println("Invalid vehicle type.");
                            break;
                    }

                    if (vehicleType != null) {
                        dealership.getVehiclesByType(vehicleType);
                    }

                    break;
                case "7":

                    dealership.getAllVehicles();

                    break;
                case "8":

                    System.out.println("Enter VIN:");
                    int vin = scanner.nextInt();

                    System.out.println("Enter year:");
                    int year = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Enter make:");
                    String newMake = scanner.nextLine();

                    System.out.println("Enter model:");
                    String newModel = scanner.nextLine();

                    System.out.println("Enter vehicle type:");
                    VehicleType newVehicleType =
                            VehicleType.valueOf(scanner.nextLine().toUpperCase());

                    System.out.println("Enter color:");
                    String newColor = scanner.nextLine();

                    System.out.println("Enter odometer:");
                    int odometer = scanner.nextInt();

                    System.out.println("Enter price:");
                    BigDecimal price = scanner.nextBigDecimal();

                    Vehicle newVehicle = new Vehicle(
                            vin,
                            year,
                            newMake,
                            newModel,
                            newVehicleType,
                            newColor,
                            odometer,
                            price
                    );

                    dealership.addVehicle(newVehicle);

                    System.out.println("Vehicle added.");

                    break;

                case "9":

                    System.out.println("Enter VIN of vehicle to remove:");
                    int removeVin = scanner.nextInt();

                    for (Vehicle vehicle : dealership.getAllVehicles()) {

                        if (vehicle.getVin() == removeVin) {

                            dealership.removeVehicle(vehicle);

                            System.out.println("Vehicle removed.");

                            break;
                        }
                    }

                    break;
                case "0":
                    System.out.println("good bye!");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.exit(130);

                default:
                    System.out.println("invalid option");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
            System.out.println("returning to main");
            System.out.println("loading");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}

package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
        public static Dealership getDealership() {
            Dealership dealership = new Dealership("fastVehicles", "9101 South Boulevard, Charlotte, NC 28273", "(704) 552-7600");

            try {
                FileReader file = new FileReader("src/main/resources/DealershipInventory.csv");
                BufferedReader reader = new BufferedReader(file);
                String input;

                while ((input = reader.readLine()) != null) {

                    String[] csvRow = input.split("\\|");

                    int vin = Integer.parseInt(csvRow[0]);
                    int year = Integer.parseInt(csvRow[1]);
                    String make = csvRow[2];
                    String model = csvRow[3];
                    VehicleType vehicleType = VehicleType.valueOf(csvRow[4]);
                    String color = csvRow[5];
                    int odometer = Integer.parseInt(csvRow[6]);
                    BigDecimal price = new BigDecimal(csvRow[7]);
                    Vehicle newVehicle = new Vehicle(
                            vin,
                            year,
                            make,
                            model,
                            vehicleType,
                            color,
                            odometer,
                            price
                    );

                    dealership.addVehicle(newVehicle);


                }
                reader.close();

            } catch (IOException ex) {
                System.out.println("There was a problem with the file");

            }

            return dealership;
        }
        public static void writeVehicle(Vehicle v) {

            try {

                FileWriter fileWriter = new FileWriter("src/main/resources/vehicles.csv", true);

                fileWriter.write(String.format(
                        "\n%d|%d|%s|%s|%s|%s|%d|%s",
                        v.getVin(),
                        v.getYear(),
                        v.getMake(),
                        v.getModel(),
                        v.getVehicleType(),
                        v.getColor(),
                        v.getOdometer(),
                        v.getPrice()
                ));

                fileWriter.close();

            } catch (IOException ex) {

                System.out.println("Error writing to file.");
            }
        }
    }


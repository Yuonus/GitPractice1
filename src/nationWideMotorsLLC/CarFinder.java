package nationWideMotorsLLC;

import java.util.Scanner;

public class CarFinder {
	
	// Parallel arrays to store car data
    static String[] vinNumbers = {"1234", "2345", "3456", "4567"};
    static String[] makes = {"Toyota", "Hyundai", "Ford", "Nissan"};
    static String[] models = {"Corolla", "Sonata", "Fusion", "Altima"};
    static int[] years = {2010, 2014, 2011, 2018};
    static int[] mileages = {75000, 138000, 170000, 90000};
    static int[] prices = {7000, 5800, 2500, 11000};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Nationwide Motors LCC inventory");
        System.out.print("Enter the last 4 digits of the VIN number: ");
        String vin = input.nextLine();

        // Check if user only entered VIN
        if (vin.length() == 4 && isVINOnly(input)) {
            displayCarByVIN(vin);
        } else {
            String make, model;
            int year, mileage, budget;

            System.out.print("Enter the make of the car: ");
            make = input.nextLine();

            System.out.print("Enter the model of the car: ");
            model = input.nextLine();

            System.out.print("Enter the year of the car: ");
            year = input.nextInt();

            System.out.print("Enter the mileage (50000 - 200000): ");
            mileage = input.nextInt();
            while (mileage < 50000 || mileage > 200000) {
                System.out.print("Invalid mileage. Enter a value between 50000 - 200000: ");
                mileage = input.nextInt();
            }

            System.out.print("Enter your budget ($2000 - $20000): ");
            budget = input.nextInt();
            while (budget < 2000 || budget > 20000) {
                System.out.print("Invalid budget. Enter a value between $2000 - $20000: ");
                budget = input.nextInt();
            }

            searchCars(make, model, year, mileage, budget);
        }

        input.close();
    }

    // Method to check if VIN is the only input
    public static boolean isVINOnly(Scanner input) {
        System.out.print("Do you want to search by VIN only? (yes/no): ");
        String choice = input.nextLine();
        return choice.equalsIgnoreCase("yes");
    }

    // Display car details by VIN
    public static void displayCarByVIN(String vin) {
        boolean found = false;
        for (int i = 0; i < vinNumbers.length; i++) {
            if (vinNumbers[i].equals(vin)) {
                System.out.println("Car Found:");
                System.out.println("Make: " + makes[i]);
                System.out.println("Model: " + models[i]);
                System.out.println("Year: " + years[i]);
                System.out.println("Mileage: " + mileages[i]);
                System.out.println("Price: $" + prices[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No car found with VIN: " + vin);
        }
    }

    // Search for cars based on input filters
    public static void searchCars(String make, String model, int year, int mileage, int budget) {
        boolean matchFound = false;
        System.out.println("\nSearching for matching cars...");
        for (int i = 0; i < makes.length; i++) {
            if (makes[i].equalsIgnoreCase(make)
                && models[i].equalsIgnoreCase(model)
                && years[i] == year
                && mileages[i] <= mileage
                && prices[i] <= budget) {

                System.out.println("\nMatch Found:");
                System.out.println("VIN: " + vinNumbers[i]);
                System.out.println("Make: " + makes[i]);
                System.out.println("Model: " + models[i]);
                System.out.println("Year: " + years[i]);
                System.out.println("Mileage: " + mileages[i]);
                System.out.println("Price: $" + prices[i]);
                matchFound = true;
            }
        }

        if (!matchFound) {
            System.out.println("No matching cars found within your criteria.");
        }
    }

}

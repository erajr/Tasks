import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        
        Car[] cars = new Car[10];

        cars[0] = new Car(1, "Ford", "Mustang", 1967, "Red", "150000", "AN-2903");
        cars[1] = new Car(2, "Ford", "F-350", 2003, "Navy Blue", "65000", "BX-3811");
        cars[2] = new Car(3, "Toyota", "Corolla", 2014, "Black", "25000", "AM-1441");
        cars[3] = new Car(4, "Toyota", "Camry", 2005, "Silver", "60000", "AY-3914");
        cars[4] = new Car(5, "Honda", "Civic", 2021, "Red", "50000", "AB-7651");
        cars[5] = new Car(6, "Honda", "Accord", 2015, "White", "130000", "BN-0231");
        cars[6] = new Car(7, "Mercedes-Benz", "SLS AMG", 2007, "White", "230000", "BA-0986");
        cars[7] = new Car(8, "Mercedes-Benz", "S580", 2022, "Black", "175000", "AZ-0912");
        cars[8] = new Car(9, "Audi", "R8", 2012, "Grey", "250000", "AA-8301");
        cars[9] = new Car(10, "Audi", "A8", 2022, "Black", "200000", "BB-1209");

        App app = new App();

        
        // Using set because Set does not take duplicates.
        Set<String> brands = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        Set<String> models = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        Set<Integer> yearOfManufactureList = new TreeSet<>();
        Set<Integer> priceList =  new HashSet<>();
        for(int i = 0; i < cars.length; i++) {
            brands.add(cars[i].getMake());
            models.add(cars[i].getModel());
            yearOfManufactureList.add(cars[i].getYearOfManufacture());
            priceList.add(Integer.parseInt(cars[i].getPrice()));
        }

        // For part A (a list of cars of a given brand)
        System.out.println("Choose car brand from one of the following: " + brands + " :");
        Scanner input = new Scanner(System.in);
        String givenBrand = input.nextLine();
        // input.close();

        if(brands.contains(givenBrand)) {
            app.saveCarsToFile(filterCarsByMake(givenBrand, cars), givenBrand + ".txt");
            System.out.println(givenBrand + ".txt File printed successfully.");
        } else {
            System.out.println("ERROR: brand name not found.");
        }

        // For part B (a list of cars of a given model that have been in use for more than n years)
        System.out.println("Now enter model from: " + models + " and number of years: \nModel: ");
        String givenModel = input.nextLine();
        System.out.println("Years: " );
        int years = input.nextInt();
        for(int i = 0; i < cars.length; i++) {
            if(cars[i].getModel().equalsIgnoreCase(givenModel) && (java.util.Calendar.getInstance().get(Calendar.YEAR) - cars[i].getYearOfManufacture() > years)) {
                app.saveCarsToFile(filterCarsByModelAndUsage(givenModel, years, cars), givenModel + "_" + years + "yearsOld.txt");
                System.out.println(givenModel + "_" + years + "yearsOld.txt printed successfully");
            }
        }

        Scanner scanner = new Scanner(System.in);

        // For part C (a list of cars of a given year of manufacture, the price of which is higher than the specified one)
        System.out.println("Enter year of manufacture and price: \nPrice: ");
        String specifiedPrice = scanner.nextLine();

        System.out.println("Year of manufacture of car: ");
        int givenYearOfManufacture = scanner.nextInt();

        app.saveCarsToFile(filterCarsByYearAndPrice(givenYearOfManufacture, specifiedPrice, cars), givenYearOfManufacture + "-Expensive-Cars.txt");

        input.close();
        scanner.close();
        
    }

    public static Car[] filterCarsByMake(String make, Car[] listOfCars) {
        int filteredCarCount = 0;
        for(int i = 0; i < listOfCars.length; i++) {
            if(listOfCars[i].getMake().equalsIgnoreCase(make))
                filteredCarCount++;
        }
        Car[] filteredCars = new Car[filteredCarCount];
        int i = 0;
        for(Car car : listOfCars) {
            if(car.getMake().equalsIgnoreCase(make))
                filteredCars[i++] = car;
        }
        return filteredCars;
    }

    public static Car[] filterCarsByModelAndUsage(String model, int years, Car[] listOfCars) {
        int filteredCarCount = 0;
        int filteredYears = 0;
        int year = 0;
        for(int i = 0; i < listOfCars.length; i++) {
            filteredYears = java.util.Calendar.getInstance().get(Calendar.YEAR) - listOfCars[i].getYearOfManufacture();
            if(listOfCars[i].getModel().equalsIgnoreCase(model)) {
                if(years <= filteredYears) {
                    year = filteredYears;
                    filteredCarCount++;
                }
            }
        }

        System.out.println("Count: " + filteredCarCount);

        Car[] filteredCars = new Car[filteredCarCount];
        
        int i = 0;
        for(Car car : listOfCars) {
            if(car.getModel().equalsIgnoreCase(model)) {
                if(years <= year)
                    filteredCars[i++] = car;
            }
        }
        return filteredCars;

    }

    public static Car[] filterCarsByYearAndPrice(int yearOfManufacture, String price, Car[] listOfCars) {
        int filteredCarCount = 0;
        for(int i = 0; i < listOfCars.length; i++) {
            if(listOfCars[i].getYearOfManufacture() == yearOfManufacture && (Integer.parseInt(listOfCars[i].getPrice()) >= Integer.parseInt(price))) 
                filteredCarCount++;
        }

        Car[] filteredCars = new Car[filteredCarCount];
        
        int i = 0;
        for(Car car : listOfCars) {
            if(car.getYearOfManufacture() == yearOfManufacture && Integer.parseInt(car.getPrice()) >= Integer.parseInt(price))
                filteredCars[i++] = car;
        }
        return filteredCars;        
    }

    public void saveCarsToFile(Car[] listOfCars, String file) {
        try (FileWriter writer = new FileWriter(file)) {
            for (Car car : listOfCars) {
                writer.write(car.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

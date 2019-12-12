import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

//final grade: 100
//code was corrected after

/**
 * Name: Zane Emerick 
 * Class: CS1150 
 * Assignment #11 
 * Due: November 21, 2019
 * 
 * Description: Create a program that simulates the racing of cars. Each car needs to have it's own object and contain an
 *              Odometer object inside of it. The race will conclude when a car reaches 500 miles driven distance.
 */

public class EmerickZaneAssignment11 {
    public static void main(String[] args) throws IOException {
        //build the cars
        RaceCar[] raceCars = new RaceCar[5];
        setupRaceCars(raceCars);
        printRaceCars(raceCars);

        //loop for the race
        boolean carWon = false;
        double timeRacing = 0;
        while(carWon == false) {
            timeRacing++;
            if(timeRacing % 4 == 0) {
                //update each car's distance
                for(RaceCar car : raceCars) {
                    car.updateOdometer();
                    //if the car reaches 500 miles, end race
                    if(car.getOdometer().getMiles() >= 500) {
                        carWon = true;
                    }
                }
            }
            System.out.println("Racing time: " + (double)(timeRacing / 4) + " hours.");
        }

        //print and write to file at end
        printRaceCars(raceCars);
        writeCarDetailsToFile(raceCars);
    }

    /**
     * Creates all of the racecar objects
     * @param raceCars Array where objects are placed
     */
    public static void setupRaceCars(RaceCar[] raceCars) {
        raceCars[0] = new RaceCar("Shrek", 8, 67);
        raceCars[1] = new RaceCar("Fiona", 11, 85);
        raceCars[2] = new RaceCar("Donkey", 7, 118);
        raceCars[3] = new RaceCar("Farquaad", 24, 71);
        raceCars[4] = new RaceCar("Dragon", 43, 108);
    }

    /**
     * Prints out the Name, Number, Speed, and Miles of each car
     * @param raceCars the Array of race car objects
     */
    public static void printRaceCars(RaceCar[] raceCars) {
        System.out.println("+----------------------------------------------+");
        System.out.printf("| %-9s| %-7s| %-7s| %-16s| %n", "Name", "Number", "Speed", "Miles Completed");
        System.out.println("|----------+--------+--------+-----------------+");

        for(RaceCar car : raceCars) {
            System.out.printf("| %-9s| %-7d| %-7.2f| %-16.2f| %n", car.getDriver(), car.getNumber(), car.getSpeed(), car.getOdometer().getMiles());
        }
        System.out.println("+----------------------------------------------+");
    }

    /**
     * Writes the stats of each car to a seperate file named "Assignment11.txt"
     * @param raceCars the Array of race car objects
     * @throws IOException the error that is thrown if a problem occurs writing to the file
     */
    public static void writeCarDetailsToFile(RaceCar[] raceCars) throws IOException {
        File fileOne = new File("Assignment11.txt");

        PrintWriter resultsFile = new PrintWriter(fileOne);

        resultsFile.println("Race car details");

        for(RaceCar car : raceCars) {
            resultsFile.println(car.getDriver());
            resultsFile.println(car.getNumber());
            resultsFile.println(car.getOdometer().getMiles());
        }

        resultsFile.close();


    }
}

class RaceCar {
    private String driver;
    private double speed;
    private int number;
    private Odometer odometer;

    public RaceCar(String driver, int number, double speed) {
        this.driver = driver;
        this.number = number;
        this.speed = speed;

        odometer = new Odometer();
    }

    public int getNumber() {
        return number;
    }

    public String getDriver() {
        return driver;
    }

    public double getSpeed() {
        return speed;
    }

    public Odometer getOdometer() {
        return odometer;
    }

    public void updateOdometer() {
        this.getOdometer().incrementMiles(speed);
    }

}

class Odometer {
    private double miles;

    public Odometer() {
        miles = 0.0;
    }

    public double getMiles() {
        return miles;
    }

    public void incrementMiles(double speed) {
        miles += speed;
    }
}
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class EmerickZaneAssignment11 {
    public static void main(String[] args) {
        RaceCar[] raceCars = new RaceCar[5];
        setupRaceCars(raceCars);
        printRaceCars(raceCars);

        boolean carWon = false;
        int timeRacing = 0;
        while(carWon = false) {
            timeRacing++;
            if(timeRacing % 4 == 0) {
                
            }
        }
    }

    public static void setupRaceCars(RaceCar[] raceCars) {
        raceCars[0] = new RaceCar("Shrek", 8, 67);
        raceCars[1] = new RaceCar("Fiona", 11, 85);
        raceCars[2] = new RaceCar("Donkey", 7, 118);
        raceCars[3] = new RaceCar("Farquaad", 24, 71);
        raceCars[4] = new RaceCar("Dragon", 43, 108);
    }

    public static void printRaceCars(RaceCar[] raceCars) {
        System.out.println("+---------------------------+");
        System.out.printf("| %-8s| %-7s| %-7s|%n", "Name", "Number", "Speed");
        System.out.println("|---------+--------+--------|");

        for(RaceCar car : raceCars) {
            System.out.printf("| %-8s| %-7d| %-7.2f|%n", car.getDriver(), car.getNumber(), car.getSpeed());
        }
        System.out.println("+---------------------------+");
    }

    public static void writeCarDetailsToFile(RaceCar[] raceCars) throws IOException {
        File fileOne = new File("Assignment11.txt");

        PrintWriter resultsFile = new PrintWriter(fileOne);

        resultsFile.println("Race car details");

        for(RaceCar car : raceCars) {
            resultsFile.println(car.getNumber());
            resultsFile.println(car.getDriver());
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
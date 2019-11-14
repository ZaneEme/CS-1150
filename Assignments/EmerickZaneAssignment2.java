import java.util.Scanner;

/**
 * Name: Zane Emerick 
 * Class: CS1150 
 * Due: Sept 12, 2019
 * 
 * Description: This program shows that I understand how to take user input and
 * do math with stored variables. The goal is to compare the amount of water
 * that two cities waste every year on leaky faucets.
 */
public class EmerickZaneAssignment2 {
    // print a certain length of dashes to be used for styling
    public static void drawHorizontalLines(int length, int spacing) {
        for (int j = 0; j <= length; j++) {
            if (j % (spacing + 2) == 0) {
                System.out.print("+");
            } else {
                System.out.print("-");
            }

        }
        System.out.println("");
    }

    public static void main(String[] args) {
        String testString = "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n";
        Scanner input = new Scanner(testString);
        // constants need to be all uppercase with an underscore seperator
        final int DRIPS_PER_GAL = 15140;
        // total number of homes in each city
        int[] homesNumber = new int[2];
        // total average amount of leaky faucets each home has
        int[] averageFaucets = new int[2];
        // average drips per minute for said leaky faucets
        int[] dripsPerMin = new int[2];
        // number of gallons wasted per day
        double[] galsPerDay = { 0, 0 };
        // number of gallons wasted per year
        double[] galsPerYear = { 0, 0 };

        // prompt user number of homes, average faucet number, and drips per minute for
        // each city
        // then calculate number of gallons used by each city
        for (int i = 1; i <= 2; i++) {
            System.out.println("\nCity Number " + i);
            drawHorizontalLines(50, 48);

            // get user input
            System.out.print("\nEnter the number of homes in city #" + i + ": ");
            homesNumber[i - 1] = input.nextInt();
            System.out.print("\nEnter the average number of faucets: ");
            averageFaucets[i - 1] = input.nextInt();
            System.out.print("\nEnter the average number of drips per minute: ");
            dripsPerMin[i - 1] = input.nextInt();
            // create a gap between the two cities in loop
            System.out.println("");

            // equation to find the gallons city i - 1 uses each day
            // drips * faucets * houses * 60 minutes * 24 hours / 15140 drips per gallon
            galsPerDay[i - 1] = ((double) (dripsPerMin[i - 1] * averageFaucets[i - 1] * homesNumber[i - 1]) * 60 * 24)
                    / DRIPS_PER_GAL;
            // equation to find the gallons city i - 1 uses each year
            galsPerYear[i - 1] = galsPerDay[i - 1] * 365;
        }

        // code for the actual drip calculator
        drawHorizontalLines(25, 23);
        System.out.println("Wasted Water Calculator");
        drawHorizontalLines(25, 23);

        // create table
        drawHorizontalLines(102, 100);
        System.out.printf("| %-15s| %-15s| %-15s| %-15s| %-15s| %-15s|%n", "", "Homes", "Faucets", "Drips / Min",
                "Gals / Day", "Gals / Year");
        drawHorizontalLines(102, 15);
        System.out.printf("| %-15s| %-15d| %-15d| %-15d| %-15.3f| %-15.3f|%n", "City One", homesNumber[0],
                averageFaucets[0], dripsPerMin[0], galsPerDay[0], galsPerYear[0]);
        drawHorizontalLines(102, 15);
        System.out.printf("| %-15s| %-15d| %-15d| %-15d| %-15.3f| %-15.3f|%n", "City Two", homesNumber[1],
                averageFaucets[1], dripsPerMin[1], galsPerDay[1], galsPerYear[1]);
        drawHorizontalLines(102, 15);

        // find the totals
        System.out.printf("| %-15s| %50s %-15.3f| %-15.3f|%n", "Totals", "|", galsPerDay[0] + galsPerDay[1],
                galsPerYear[0] + galsPerYear[1]);
        drawHorizontalLines(102, 100);

        // close the scanner
        input.close();
    }

}

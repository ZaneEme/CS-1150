import java.util.Scanner;

//final grade: 80/80 
//code was corrected after

/**
 * Name: Zane Emerick 
 * Class: CS1160 
 * Assignment #3 
 * Due: Sept 19, 2019
 * 
 * Description: Calculate tuition cost for a student based on which year they
 * are in and how many credit-hours they take.
 */

public class EmerickZaneAssignment3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final double[] TUITION_PRICES = { 380, 400, 430, 451 };
        final String[] GRADE_LEVELS = { "Freshman", "Sophomore", "Junior", "Senior" };
        double totalTuition;
        double totalFees;

        // Print out table for grade prices
        drawHorizontalLines(60, 58);
        System.out.printf("| %-18s| %-18s| %-18s|%n", "Chart Number", "Class Level", "Rate / Credit Hour");
        drawHorizontalLines(60, 18);
        System.out.printf("| %-18s| %-18s| %-18s|%n", "1", "Freshman", "$380.00");
        drawHorizontalLines(60, 18);
        System.out.printf("| %-18s| %-18s| %-18s|%n", "2", "Sophomore", "$400.00");
        drawHorizontalLines(60, 18);
        System.out.printf("| %-18s| %-18s| %-18s|%n", "3", "Junior", "$430.00");
        drawHorizontalLines(60, 18);
        System.out.printf("| %-18s| %-18s| %-18s|%n", "4", "Senior", "$451.00");
        drawHorizontalLines(60, 58);

        // prompt for user's grade level
        System.out.println("\nEnter your grade level (1, 2, 3, 4):");
        int gradeLevel = input.nextInt();

        // if gradeLevel input valid
        if (gradeLevel >= 1 && gradeLevel <= 4) {
            System.out.println("\nEnter how many credit hours you plan to take (1-30):");
            double creditHours = input.nextInt();

            // if creditHours input valid
            if (creditHours >= 1 && creditHours <= 30) {
                totalFees = 200 + (20 * creditHours);
                totalTuition = TUITION_PRICES[gradeLevel - 1] * creditHours;

                // print out calculator table
                System.out.println("");
                drawHorizontalLines(38, 36);
                System.out.printf("| %-17s| %-17s|%n", "Level:", GRADE_LEVELS[gradeLevel - 1]);
                drawHorizontalLines(38, 17);
                System.out.printf("| %-17s| %-17s|%n", "Credit Hours:", creditHours);
                drawHorizontalLines(38, 17);
                System.out.printf("| %-17s| %,-17.2f|%n", "Tuition Price:", totalTuition);
                drawHorizontalLines(38, 17);
                System.out.printf("| %-17s| %,-17.2f|%n", "Fees:", totalFees);
                drawHorizontalLines(38, 17);
                System.out.printf("| %-17s| %-17s|%n", "", "");
                drawHorizontalLines(38, 17);
                System.out.printf("| %-17s| %,-17.2f|%n", "Total:", totalFees + totalTuition);
                drawHorizontalLines(38, 36);
            } else {
                System.out.println("Sorry, " + creditHours + " is not valid. Run the code again for another try");
            }
        } else {
            System.out.println("Sorry, " + gradeLevel + " is not valid. Run the code again for another try");
        }
        input.close();
    }

    /**
     * print a certain length of dashes to be used for styling
     * 
     * @param totalLength is the total length of the line
     * @param plusSpacing is the spacing between plus signs
     */
    public static void drawHorizontalLines(int totalLength, int plusSpacing) {
        for (int j = 0; j <= totalLength; j++) {
            if (j % (plusSpacing + 2) == 0) { // plus two for the "| "
                System.out.print("+");
            } else {
                System.out.print("-");
            }
        }
        System.out.println("");
    }
}
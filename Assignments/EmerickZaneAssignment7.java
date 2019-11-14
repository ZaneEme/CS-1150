import java.util.Scanner;
/**
 * Name: Zane Emerick 
 * Class: CS1150 
 * Assignment #7 
 * Due: Oct 17, 2019
 * 
 * Description: Create a program that can calculate a user's BMR and display it, as well
 * as facts about their recommended daily calorie intake based on how active they are
 */

public class EmerickZaneAssignment7{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean calculatorRunning = true;
        
        while(calculatorRunning){
            System.out.println("\nCalorie Calculator");
            //get numbers
            char userGender = getGender(input);
            double userAge = getAge(input);
            double userHeight = getHeight(input);
            double userWeight = getWeight(input);
            //calculate the BMR
            double userBMR = getBMR(userGender, userAge, userHeight, userWeight);

            //display the results
            System.out.println("\n------------------------------------");
            System.out.printf("Your BMR is %.2f calories per day%n", userBMR);
            System.out.println("------------------------------------");
            displayResults(userBMR);

            //check to run again
            calculatorRunning = continueProcessing(input);
        }
    }

    /**
     * Calculates the gender of the user (M or F)
     * @param input is a scanner object
     * @return the user's gender as a char
     */
    public static char getGender(Scanner input){
        System.out.print("Enter your gender (M/F): ");
        char userGender = input.next().trim().toUpperCase().charAt(0);

        while (userGender != 'M' && userGender != 'F'){
            System.out.print(userGender + " is not a valid gender, try again: ");
            userGender = input.next().trim().toUpperCase().charAt(0);
        }
        return userGender;
    }

    /**
     * Calculates the age of the user (1 - 120)
     * @param input is a scanner object
     * @return the user's age as a double
     */
    public static double getAge(Scanner input){
        System.out.print("Enter your age (1-120): ");
        double userAge = input.nextDouble();

        while (userAge < 1 || userAge > 120){
            System.out.print(userAge + " is not a valid age, try again: ");
            userAge = input.nextDouble();
        }
        return userAge;
    }

    /**
     * Calculates the user's height (1'0" to 8'11") in inches
     * @param input is a scanner object
     * @return the user's total height as a double
     */
    public static double getHeight(Scanner input){
        System.out.print("Enter your height in feet: ");
        double userHeightFeet = input.nextDouble();

        while (userHeightFeet < 1 || userHeightFeet > 8){
            System.out.print(userHeightFeet + " is not a valid height, try again: ");
            userHeightFeet = input.nextDouble();
        }

        System.out.print("Enter the inches portion of your height: ");
        double userHeightInches = input.nextDouble();
        
        while (userHeightInches < 0 || userHeightInches > 11){
            System.out.print(userHeightInches + "is not a valid height, try again: ");
            userHeightInches = input.nextDouble();
        }

        return (userHeightFeet * 12) + userHeightInches;
    }

    /**
     * Calculates the user's weight in pounds
     * @param input is a scanner object
     * @return the user's total weight as a double
     */
    public static double getWeight(Scanner input){
        System.out.print("Enter your weight in pounds: ");
        double userWeight = input.nextDouble();

        while(userWeight < 1 || userWeight > 600){
            System.out.print(userWeight + " is not a valid weight, try again: ");
            userWeight = input.nextDouble();
        }

        return userWeight;
    }

    /**
     * determines whether the program should continue running or not
     * @param input is a scanner object
     * @return the user's choice as a boolean
     */
    public static boolean continueProcessing(Scanner input){
        System.out.print("Continue with another calorie check? (Y/N): ");
        char userIn = input.next().toUpperCase().charAt(0);

        while(userIn != 'Y' && userIn != 'N'){
            System.out.print(userIn + " is not a valid option, try again: ");
            userIn = input.next().toUpperCase().charAt(0);
        }

        if(userIn == 'Y'){
            return true;
        } else {
            System.out.println("Have a great day!");
            return false;
        }
    }

    /**
     * calculates the Basal Metabolic Rate for a user with given information
     * @param gender user's gender (M/F)
     * @param age user's age (years)
     * @param height user's height (inches)
     * @param weight user's weight (pounds)
     * @return calculated BMR as a double
     */
    public static double getBMR(char gender, double age, double height, double weight){
        if(gender == 'M'){
            return (66 + (6.23 * weight) + (12.7 * height) - (6.8 * age));
        } else {
            return (655 + (4.35 * weight) + (4.7 * height) - (4.7 * age));
        }
    }

    /**
     * determine the number of calories burned based on activity level
     * @param bmr the user's Basal Metabolic Rate
     * @param activityLevel the level of the user's activity
     * @return the number of calories the user would likely burn
     */
    public static double dailyCaloriesWithActivity(double bmr, int activityLevel){
        switch(activityLevel){
            case 1:
                return bmr * 1.2; 
            case 2:
                return bmr * 1.375; 
            case 3:
                return bmr * 1.55; 
            case 4:
                return bmr * 1.725; 
            case 5:
                return bmr * 1.9;
            default:
                return 0;
        }
    }

    /**
     * displays the number of calories expended daily with a given
     * bmr and differing levels of activity
     * @param bmr the user's Basal Metabolic Rate
     */
    public static void displayResults(double bmr){
        System.out.println("\nDaily calorie needs based on activity level");
        System.out.println("----------------------------------------------+");
        System.out.println("Activity level\t\t\t      Calories|");
        System.out.println("----------------------------------------------+");
        System.out.printf("Sedentary with little exercise %15.2f|%n", dailyCaloriesWithActivity(bmr, 1));
        System.out.printf("Exercise 1-3 times weekly %20.2f|%n", dailyCaloriesWithActivity(bmr, 2));
        System.out.printf("Exercise 4-5 times weekly %20.2f|%n", dailyCaloriesWithActivity(bmr, 3));
        System.out.printf("Intense Exercise 6-7 times weekly %12.2f|%n", dailyCaloriesWithActivity(bmr, 4));
        System.out.printf("Very intense exercise daily %18.2f|%n", dailyCaloriesWithActivity(bmr, 5));
        System.out.println("----------------------------------------------+");
    }
}
/**
 * Name: Zane Emerick 
 * Class: CS1150 
 * Assignment #8 
 * Due: November 1, 2019
 * 
 * Description: Create a program that takes the average rainfall of various cities and does calculations with them.
 * The program also needs to create Dog objects which can be called to bark for the user.
 */

public class EmerickZaneAssignment8 {
    public static void main (String [] args){
        //create variables
        double [] rainfall = {15.54, 37.19, 53.19, 34.25, 46.00, 35.82, 61.90};
        String [] cities = {"Denver", "Seattle", "Orlando", "Austin", "Vancouver", "Chicago", "Miami"};
        double averageRain = computeAverageRainfall(rainfall);
        int highestRainIndex = findCityWithMostRainfall(rainfall);

        //run displays
        displayRainfalls(rainfall, cities);

        System.out.println("Total rainfall for all cities is: " + computeTotalRainfall(rainfall));

        System.out.printf("Average rainfall for all cities is: %.2f%n", averageRain);
        System.out.println("\nThe city with the most rain is " + cities[highestRainIndex] + " with " + rainfall[highestRainIndex] + " inches per year.\n");

        displayCitiesWithAboveAverageRainfall(rainfall, cities, averageRain);


        //Dog section of assignment
        Dog [] dogArray = {
            new Dog("Rover", "woof woof"),
            new Dog("Max", "arf arf arf"),
            new Dog("Tiny", "yap yap yap"),
            new Dog("Trooper", "ruff ruff ruff"),
            new Dog("Magoo", "bow wow bow wow")
        };

        makeDogsBark(dogArray);

    }

    /**
     * Displays the rainfalls that each city recieves
     * @param rainfall (double array) the amount of rain
     * @param cities (String array) the corresponding city
     */
    public static void displayRainfalls(double [] rainfall, String [] cities) {
        System.out.println("+------------------------+");
        System.out.println("| City          Rainfall |");
        System.out.println("+------------------------+");

        for(int i = 0; i < rainfall.length; i++){
            System.out.printf("| %-13s %4.2f    |%n", cities[i], rainfall[i]);
        }

        System.out.println("+------------------------+");
    }

    /**
     * Computes the total rainfall for every city
     * @param rainfall (double array) the amount of rain
     * @return (double) the total rain
     */
    public static double computeTotalRainfall(double [] rainfall) {
        double sum = 0;

        for(double rain : rainfall) {
            sum += rain;
        }
        return sum;
    }

    /**
     * Computes the average rain throughout every city
     * @param rainfall (double array) the amount of rain
     * @return the average rain
     */
    public static double computeAverageRainfall(double [] rainfall) {
        return (computeTotalRainfall(rainfall) / rainfall.length);
    }
    

    /**
     * loops through and finds the city with the most rain
     * @param rainfall (double array) the amount of rain
     * @return the index of the city with the most rain
     */  
    public static int findCityWithMostRainfall(double [] rainfall) {
        int mostRain = 0;

        for(int i = 0; i < rainfall.length; i++) {
            if(rainfall[i] > rainfall[mostRain]) {
                mostRain = i;
            }
        }

        return mostRain;
    }

    /**
     * prints out each city which gets above average rainfall, and the amount they recieve
     * @param rainfall (double array) the amount of rain
     * @param cities (String array) a list of the cities
     * @param average the average rainfall of all cities
     */
    public static void displayCitiesWithAboveAverageRainfall(double [] rainfall, String [] cities, double average) {
        for(int i = 0; i < rainfall.length; i++) {
            if(rainfall[i] > average) {
                System.out.println(cities[i] + " get " + rainfall[i] + " inches, which is above average");
            }
        }
        System.out.println("");
    }

    /**
     * Print out the barks each dog makes
     * @param dogArray An array of Dog objects
     */
    public static void makeDogsBark(Dog[] dogArray) {
        System.out.println("Create the dog objects:\n");
        for(Dog dog : dogArray){
            System.out.printf("%-7s barks like this: %-16s%n", dog.getName(), dog.getBark());
        }
    }
}

//dog class for last section of assignment
class Dog {
    private String name;
    private String bark;
    
    Dog (String name, String bark) {
        this.name = name;
        this.bark = bark;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBark() {
        return bark;
    }
    public void setBark(String bark) {
        this.bark = bark;
    }
} // Dog
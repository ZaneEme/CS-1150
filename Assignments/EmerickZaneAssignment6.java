import java.util.Scanner;

//final grade: 91
//code was corrected after

/**
 * Name: Zane Emerick 
 * Class: CS1150 
 * Assignment #6 
 * Due: Oct 10, 2019
 * 
 * Description: Create a program that operates as a bike rental station,
 * complete with multiple pass options and a way to return rented bikes.
 */
public class EmerickZaneAssignment6{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        Boolean stationRunning = true;
        int bikesAvailable = 7;
        int userSelection = 0;
        int chosenBikes = 0;
        int totalBikesRented = 0;
        double profits = 0.0;
        final int ONE_TRIP = 1;
        final int TWENTY_FOUR_HOUR_TRIP = 2;
        final int RETURN_BIKE = 3;
        

        //create the main loop
        while(stationRunning){
            System.out.println("*********************************************");
            System.out.println("     Welcome to the Bike Sharing Station     ");
            System.out.printf ("        %d bikes currently available         %n", bikesAvailable);
            System.out.println("*********************************************\n");

            System.out.println("Single Pass:  $2");
            System.out.println("24-hour Pass: $8");
            System.out.println("----------------");
            System.out.println("1: Single Trip");
            System.out.println("2: 24-hour Trip");
            System.out.println("3: Return Bike\n");

            System.out.print("Select a menu option: 1, 2, or 3: ");
            Boolean inputCorrect = false;

            //check for user selection being correct
            while(inputCorrect == false){
                userSelection = input.nextInt();
                if(userSelection == ONE_TRIP || userSelection == TWENTY_FOUR_HOUR_TRIP || userSelection == RETURN_BIKE){
                    inputCorrect = true;
                    //code to end loop and stop program
                } else if(userSelection == 999){ 
                    System.out.println("\n\nClosing station");
                    stationRunning = false;
                    break;
                } else {
                    System.out.print("Invalid entry, enter either 1, 2, or 3: ");
                }
            }
            //set to false for later use
            inputCorrect = false;

            //if user selected one trip or 24 hour
            if(userSelection == ONE_TRIP || userSelection == TWENTY_FOUR_HOUR_TRIP){
                //if out of bikes
                if(bikesAvailable == 0){
                    System.out.println("Sorry, we are currently out of bikes.");
                } else {
                    System.out.printf("How many bikes? Limit is %d: ", bikesAvailable);
                    chosenBikes = input.nextInt();

                    //loop to ensure user chooses correct number of bikes
                    while(chosenBikes > bikesAvailable || chosenBikes <= 0){
                        System.out.print("Invalid input, please choose a different number of bikes: ");
                        chosenBikes = input.nextInt();
                    }
                    //add the number of bikes and duration to total profits
                    switch(userSelection){
                        case 1:
                        //single trip pass
                            profits += (chosenBikes * 2);
                            break;
                        case 2:
                        // 24 hour day pass
                            profits += (chosenBikes * 8);
                            break;
                    }
                    totalBikesRented += chosenBikes;
                    bikesAvailable -= chosenBikes;
                    //print the receipt for the user
                    printReciept(userSelection, chosenBikes);
                }          
            }

            // if user selected to return a bike
            if(userSelection == 3){
                int bikesToReturn = 0;
                System.out.println("How many bikes would you like to return?");
                bikesToReturn = input.nextInt();
                //if the total will be > 7
                while((bikesToReturn + bikesAvailable) > 7){
                    System.out.println("Sorry, the bike rack can only hold 7 bikes. Please try again");
                    bikesToReturn = input.nextInt();
                }
                System.out.println("Successfully returned " + bikesToReturn + " bikes.\n");
                bikesAvailable += bikesToReturn;
            }
        }
        System.out.println("Successfully shut down bike station.");
        System.out.println("Total bikes rented: " + totalBikesRented);
        System.out.printf("Total profits earned: $%.2f%n", profits);

        input.close();
    }


    /**
     * @param userSelection which option the user chose, single trip or 24 hour
     * @param chosenBikes how many bikes the user chose to rent
     */
    public static void printReciept(int userSelection, int chosenBikes){
        double rentalCost = 0.0;
        System.out.println("\n\n-------------------");
        System.out.println("------Receipt------");
        System.out.println("-------------------");
        
        switch(userSelection){
            case 1:
                System.out.print("Single trip pass ");
                rentalCost = (chosenBikes * 2); break;
            case 2:
                System.out.print("24 hour pass ");
                rentalCost = (chosenBikes * 8); break;
        } 
        System.out.printf("for %d bikes%n", chosenBikes); 
        int randomNum;
        for(int i = 1; i <= chosenBikes; i++){
            randomNum = (int)((Math.random() * 89999)+ 10000);
            System.out.printf("Unlock code for bike #%d: %d%n", i, randomNum);
        }

        System.out.printf("Total cost: %.2f%n", rentalCost);
        System.out.println("Thank you for your business!\n\n");

    }
}
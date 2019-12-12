import java.util.Scanner;

// original grade: 63 / 70
// redone, should be 70 / 70 now

/**
 * Name: Zane Emerick 
 * Class: CS1160 
 * Assignment #5 
 * Due: Oct 3, 2019
 * 
 * Description: Create a program that can compare the sales of different stores
 * and has the ability to print out charts and statistics for the companies
 */

 public class EmerickZaneAssignment5 {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);

         //create variables for categories
         int numBetween1kAnd5k = 0;
         int numMoreThan5k = 0;
         int numLessThan1k = 0;
         double sum = 0;
         int count = 0;

         System.out.print("Enter the sales from all stores, end input with a \"-1\": ");
         double salesAmount = input.nextDouble();
         System.out.println();

         double largestSale = salesAmount;
         double smallestSale = salesAmount;

         //loop through input until -1 is reached
         while(salesAmount != 1) {
             if(salesAmount < 1000) {
                 numLessThan1k++;
             } else if(salesAmount >= 1000 && salesAmount <= 5000) {
                 numBetween1kAnd5k++;
             } else {
                 numMoreThan5k++;
             }

             if(salesAmount > largestSale) {
                 largestSale = salesAmount;
             }

             if (salesAmount < smallestSale) {
                 smallestSale = salesAmount;
             }

             sum += salesAmount;
             count++;

             //code to print the stars out
             int numStars = (int)(salesAmount / 100);
             System.out.print("Sales #" + count + ":");

             for(int i = 0; i < numStars; i++) {
                 System.out.print("*");
             }
             System.out.println();

             salesAmount = input.nextDouble();
         }

         //display results / error message
         if(count == 0) {
             System.out.println("No sales were entered except -1");
         } else {
            System.out.println();
            System.out.println("Number of sales amounts    = " + count);
            System.out.println("Largest sales amount       = " + largestSale);
            System.out.println("Smallest sales amount      = " + smallestSale);
            System.out.println("Sum of all sales amounts   = " + sum);
            System.out.println("Range (largest - smallest) = " + (largestSale - smallestSale));
            System.out.printf ("Average                    = %.2f\n",  (double) sum / count);
            System.out.println();
            System.out.println("Number of sales amounts less than $1000      = " + numLessThan1k);
            System.out.println("Number of sales amounts between $1000 and $5000 = " + numBetween1kAnd5k);
            System.out.println("Number of sales amounts more than $5000      = " + numMoreThan5k);
         }
         input.close();

     }

 }
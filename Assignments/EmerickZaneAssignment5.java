import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Name: Zane Emerick 
 * Class: CS1160 
 * Assignment #5 
 * Due: Oct 3, 2019
 * 
 * Description: Create a program that can compare the sales of different stores
 * and has the ability to print out charts and statistics for the companies
 */

public class EmerickZaneAssignment5{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        ArrayList <Integer> totalSalesList = new ArrayList<>();

        System.out.print("Enter the sales from all stores, end input with a \"-1\": ");

        //build arrayList with all the prices arranged
        int priceTotals = 0;
        while(priceTotals != -1){
            priceTotals = input.nextInt();
            totalSalesList.add(priceTotals);
        }

        if(totalSalesList.size() != 1){
            //remove the -1 at the end of the array
            totalSalesList.remove(totalSalesList.size()-1);
            System.out.println("");

            //build the bar graph for data
            buildStarChart(totalSalesList);
            //sort the array for data purposes
            Collections.sort(totalSalesList);
            //print out statistics for data
            System.out.println("Number of sales: " + totalSalesList.size());
            System.out.println("Largest sales amount = " + (double)(totalSalesList.get(totalSalesList.size() - 1)));
            System.out.println("Smallest sales amount = " + (double)(totalSalesList.get(0)));
            System.out.println("Sum of all sales amounts = " + sumList(totalSalesList));
            System.out.println("Range (Largest - Smallest) = " + (double)(totalSalesList.get(totalSalesList.size() - 1) - totalSalesList.get(0)));
            System.out.println("Average = " + sumList(totalSalesList) / totalSalesList.size());
            //find number between various amounts
            System.out.println("\nNumber of sales less than 1000 = " + salesLessThan(totalSalesList, 1000));
            System.out.println("Number of sales between 1000 and 5000 = " + (salesLessThan(totalSalesList, 5000) - salesLessThan(totalSalesList, 1000)));
            System.out.println("Number of sales greater than 5000 = " + (totalSalesList.size() - salesLessThan(totalSalesList, 5000)));
        } else {
            System.out.println("The only number entered was -1...");
        }

        input.close();
    }

    /**
     * @param list a list of integers containing the sales from companies
     * @param amount the specified highest number for search
     * @return number of objects in list that are less than amount
     */
    public static int salesLessThan(ArrayList<Integer> list,int amount){
        int count = 0;
        for(int i : list){
            if(i < amount){
                count++;
            }
        }
        return count;
    }

    /**
     * @param list a list of integers to be counted
     * @return the total value of all objects in list added together
     */
    public static double sumList(ArrayList<Integer> list){
        int sum = 0;
        for(int i : list){ 
            sum += i;
        }
        return sum;
    }

    /**
     * @param list a list of sales from companies to create a chart based upon
     * prints out a chart, with one star per hundred sales
     */
    public static void buildStarChart(ArrayList<Integer> list){
        int starNum;
        for(int i = 0; i < list.size(); i++){
            starNum = (list.get(i) / 100);
            System.out.print("Sales #" + (i + 1) + ": ");

            for(int j = starNum; j > 0; j--){
                System.out.print("*");
            }

            System.out.println("");
        }
        System.out.println("\n");
    }
}
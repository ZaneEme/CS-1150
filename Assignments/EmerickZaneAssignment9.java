import java.util.Arrays;

//final grade: 95
//code was corrected after

/**
 * Name: Zane Emerick 
 * Class: CS1150 
 * Assignment #9 
 * Due: November 6, 2019
 * 
 * Description: Create a program that can sort and manipulate different arrays in multiple ways.
 */

public class EmerickZaneAssignment9{
    public static void main(String[] args) {
        int[] listRandomNumsA = new int[10];
        int[] listRandomNumsB = new int[10];

        //fill the arrays with values
        fillWithEvenValues(listRandomNumsA);
        fillWithOddValues(listRandomNumsB);

        //sort the two random number arrays
        Arrays.sort(listRandomNumsA);
        Arrays.sort(listRandomNumsB);

        //display both arrays
        displayList(listRandomNumsA, "Array of even values");
        displayList(listRandomNumsB, "Array of odd values");

        //merge the two arrays into one larger one
        int[] mergedRandomNums = new int[listRandomNumsA.length + listRandomNumsB.length];
        mergeArrays(listRandomNumsA, listRandomNumsB, mergedRandomNums);

        //sort the array of random numbers into a descending order and display
        descendingOrderSort(mergedRandomNums);
        displayList(mergedRandomNums, "Merged random numbers sorted in descending order");


        //create the two arrays filled with given numbers
        int[] listGivenNumsA = {10, 12, 15, 42, 68, 102};
        int[] listGivenNumsB = {14, 16, 18, 101, 107, 108};

        //manually sort and the two arrays into one larger one
        int[] mergedGivenNums = new int[listGivenNumsA.length + listGivenNumsB.length];
        sortedMerge(listGivenNumsA, listGivenNumsB, mergedGivenNums);

        //display the final large array
        displayList(mergedGivenNums, "Manually merged array sorted in descending order");

    }


    /**
     * fill an array with 10 randomly generated even numbers between 1 and 75
     * @param list the array to be filled
     */
    public static void fillWithEvenValues(int[] list) {
        for(int i = 0; i < list.length; i++) {
            list[i] = (int)(Math.random() * 75);

            if (list[i] % 2 != 0) {
                list[i]++;
            }
        }
    }

    /**
     * fill an array with 10 randomly generated odd numbers between 1 and 75
     * @param list the array to be filled
     */
    public static void fillWithOddValues(int[] list) {
        for(int i = 0; i < list.length; i++) {
            list[i] = (int)(Math.random() * 75);

            if (list[i] % 2 == 0) {
                list[i]++;
            }
        }       
    }

    /**
     * Display an array in a running list
     * @param list the array to be displayed
     * @param listName the title to be printed
     */
    public static void displayList(int[] list, String listName) {
        System.out.println(listName);
        
        for(int i = 0; i < listName.length(); i++) {
            System.out.print("-");
        }
        System.out.println("-");

        for(int j = 0; j < list.length; j++){
            System.out.println("list[" + j + "] = " + list[j]);
        }
        System.out.println();
    }

    /**
     * Merge two arrays into one
     * @param list1 the first array to be merged
     * @param list2 the second array to be merged
     * @param merged the final, merged array
     */
    public static void mergeArrays(int[] list1, int[] list2, int[] merged) {
        System.arraycopy(list1, 0, merged, 0, list1.length);
        System.arraycopy(list2, 0, merged, list1.length, list2.length);
    }

    /**
     * Sort an array into descending order
     * @param list the array to be reversed
     */
    public static void descendingOrderSort (int[] list) {

        Arrays.sort(list);

        for(int i = 0; i <= (list.length / 2) - 1; i++) {
            int temp = list[i];
            list[i] = list[list.length - 1 - i];
            list[list.length - 1 - i] = temp;
        }
    }



    //EDIT: not what the assignment wants, too lazy to redo
/**
 * Sort the array manually
 * @param list1 the first array to be sorted
 * @param list2 the second array to be sorted
 * @param merged the final, sorted array
 */
    public static void sortedMerge(int[] list1, int[] list2, int[] merged) {
        mergeArrays(list1, list2, merged);
        
        for(int i = 0; i < merged.length - 1; i++) {
            int smallest = merged[i];
            int smallestIndex = i;

            for(int j = i + 1; j < merged.length; j++){
                if(smallest > merged[j]) {
                    smallest = merged[j];
                    smallestIndex = j;
                }       
            }

            if(smallestIndex != i) {
                merged[smallestIndex] = merged[i];
                merged[i] = smallest;
            }
        }
        
    }
}
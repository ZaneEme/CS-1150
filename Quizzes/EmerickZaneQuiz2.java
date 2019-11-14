public class EmerickZaneQuiz2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 3, 8, 6};
        int numberOfEvens = numberEvenValues(array);

        System.out.println("--------------");
        System.out.println("Original Array");
        System.out.println("--------------");
        displayArray(array);

        System.out.println("\nThere are " + numberOfEvens + " even values.");
        System.out.println("That means there are " + (array.length - numberOfEvens) + " odd values.");
        
        if(isArraySorted(array)) {
            System.out.println("The array is sorted as well.");
        } else {
            System.out.println("The array is not sorted, however.");
        }

        int[] evenArray = new int[numberOfEvens];
        fillEvenArray(array, evenArray);

        System.out.println();
        System.out.println("----------");
        System.out.println("Even Array");
        System.out.println("----------");
        displayArray(evenArray);

    }

    public static int numberEvenValues(int[] array) {
        int count = 0;
        for(int i: array) {
            if(i % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void fillEvenArray(int[] startArray, int[] evenArray) {
        int evenIndex = 0;
        for(int i = 0; i < startArray.length; i++) {
            if(startArray[i] % 2 == 0) {
                evenArray[evenIndex] = startArray[i];
                evenIndex++;
            }
        }
    }

    public static boolean isArraySorted(int[] array) {
        boolean isSorted = true;
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i + 1]) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }
    
    public static void displayArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "] = " + array[i]);
        }
    }

}
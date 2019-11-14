import java.util.Scanner;

public class EmerickZaneQuiz1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        // 1: prompt for wash type as a char
        System.out.println("\nEnter a character for the desired type of wash: \nP: Premium\tD: Deluxe\nS: Standard");
        char selectedWashType = input.next().toLowerCase().charAt(0);

        // 2: verify slected wash type
        if(selectedWashType == 'p' || selectedWashType == 'd' || selectedWashType == 's'){

            switch(selectedWashType){
                case 'p': System.out.println("You selected: Premium wash"); break;
                case 'd': System.out.println("You selected: Deluxe wash"); break;
                case 's': System.out.println("You selected: Standard wash"); break;
            }

            // 3: prompt for vehicle type as an int
            System.out.println("\nEnter a number for which type of vehicle you have: \n1: Compact\t2: Standard\n3: Truck\t4: SUV");
            int selectedVehicleType = input.nextInt();

            // 3: verify selected vehicle type
            if(selectedVehicleType == 1 || selectedVehicleType == 2 || selectedVehicleType == 3 || selectedVehicleType == 4){
                // 4A: switch statement to determine price based on vehicle type
                int totalWashPrice = 5;
                switch(selectedVehicleType){
                    case 1:
                        break;
                    case 2:
                        totalWashPrice += 1; break;
                    case 3:
                    case 4:
                        totalWashPrice += 3; break;
                }
                // 4B: display cost to user
                System.out.println("The price of your car wash will be: $" + totalWashPrice);

            } else {
                System.out.println("Invalid type of vehicle, please run again.");
            }

        } else {
            System.out.println("Invalid type of wash, please run again.");
        }
        input.close();
    }
}
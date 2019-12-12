import java.util.Scanner;

//final grade: 100
//code was corrected after

/**
 * Name: Zane Emerick 
 * Class: CS1160 
 * Assignment #4 
 * Due: Sept 26, 2019
 * 
 * Description: Create randomly generated credit card numbers based on two inputs:
 *  The card company, and the member's credit level
 */

public class EmerickZaneAssignment4 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        //ask for inputs from user
        System.out.println("Enter a character and a number (ex: A1):");
        System.out.println("V: Visa \t\t A: American Express \t I: Random international Number");
        System.out.println("1: Regular Level \t 2: Platinum Level \t 3: Signature Level");
        String userIn = input.next().toLowerCase();

        //store inputs
        char chosenCardMaker = userIn.charAt(0);
        char chosenCardLevel = userIn.charAt(1);

        if(chosenCardMaker == 'v' || chosenCardMaker == 'a' || chosenCardMaker == 'i'){
            if(chosenCardLevel == 1 || chosenCardLevel == 2 || chosenCardLevel == 3){
                String createdNumber = "0";
                switch(chosenCardMaker){
                    case 'v': createdNumber = generateVisa(); break;
                    case 'a': createdNumber = generateAmex(); break;
                    case 'i': createdNumber = generateRandIntl(); break;
                }
                switch (chosenCardLevel){
                    case '1': System.out.println("Regular" + createdNumber); break;
                    case '2': System.out.println("Platinum" + createdNumber); break;
                    case '3': System.out.println("Signature" + createdNumber); break;
                }
            } else {
                System.out.println("Please run again and enter a valid credit card level");
            }
        } else {
            System.out.println("Please run again and enter a valid credit card company");
        }
        input.close();
    }

    /**
     * generates a random Visa number
     * @return  Visa 4### #### #### #### (4-4-4-4)
     */  
    public static String generateVisa(){
        String visaNum = "Visa ";
        visaNum += (int)(Math.random() * 1000) + 4000;
        for(int i = 0; i < 3; i++){
            visaNum += " ";
            visaNum += (int)(Math.random() * 9000) + 1000;
        }
        return visaNum;
    }

    /**
     * generates a random American Express number
     * @return American Express 37## ###### ##### (4-6-5)
     */
    public static String generateAmex(){
        String amexNum = "American Express ";
        amexNum += (int)(Math.random() * (99)) + 3700;
        amexNum += " ";
        amexNum += (int)(Math.random() * 999000) + 1000;
        amexNum += " ";
        amexNum += (int)(Math.random() * 99000) + 1000;

        return amexNum;
    }

    /**
     * generates a random International number
     * @return Random International XXXX #### ##### (4-4-5)
     */
    public static String generateRandIntl(){
        String randIntlNum = "Random International ";
        for(int i = 0; i < 4; i++){
            randIntlNum += (char)((Math.random() * ((90 - 65) + 1)) + 65);
        }
        randIntlNum += " ";
        randIntlNum += (int)((Math.random() * 9000) + 1000);
        randIntlNum += " ";
        randIntlNum += (int)((Math.random() * 99000) + 1000);

        return randIntlNum;
    }
}
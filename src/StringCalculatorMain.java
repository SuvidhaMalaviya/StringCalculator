import java.util.Arrays;
import java.util.Scanner;

/**
 * This class is the main class for the String Calculator that will be used to
 * take string from user and call add method to add numbers is that using different delimiter
 * and applying different validation
 */

public class StringCalculatorMain
{

    public static void main(String args[])
    {
        String inputString;

        inputString="";
        generateOutput(inputString);

        inputString="1";
        generateOutput(inputString);

        inputString="1,2";
        generateOutput(inputString);

        inputString="1,2,3,4,5,6,7,8,9,10";
        generateOutput(inputString);

        inputString="1\n2,3";
        generateOutput(inputString);
    }

    static void generateOutput(String inputString){

        System.out.println("Input : " + inputString);


        int sumOfNumber = StringCalculator.Add(inputString);

        System.out.println("Sum : " + sumOfNumber + "\n\n");
    }
}

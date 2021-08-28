import java.util.Scanner;

/**
 * This class is the main class for the String Calculator that will be used to
 * take string from user and call add method to add numbers is that using different delimiter
 * and applying different validation
 */

public class StringCalculatorMain
{
    static Scanner scanner;

    public static void main(String args[])
    {
        scanner = new Scanner(System.in);
        String inputString;

        inputString = scanner.nextLine();
        int sumOfNumber = StringCalculator.Add(inputString);

        System.out.println(sumOfNumber);
    }
}

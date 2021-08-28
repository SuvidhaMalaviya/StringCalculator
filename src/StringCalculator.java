/**
 * This class is used to add the numbers given in string format
 */

public class StringCalculator
{
    public static int Add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        else if(numbers.contains(","))
        {
            String[] listOfNumbers = numbers.split(",");
            int sum = toInt(listOfNumbers[0]) + toInt(listOfNumbers[1]);
            return sum;
        }
        else
        {
            return toInt(numbers);
        }
    }

    // This method will be used to convert the string to integer if the string is digit else it throws exception
    private static int toInt(String number)
    {
        int convertedInt = -1;
        try
        {
            convertedInt = Integer.parseInt(number);
        }
        catch (Exception e)
        {
            System.out.println("The value must be number without decimal point");
        }
        return convertedInt;
    }
}

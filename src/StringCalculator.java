import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

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
        else
        {
            String[] listOfNumbers = splitArray(numbers);

            int[] listOfNumberInInt = convertStringArraytoIntArray(listOfNumbers);

            int sum = IntStream.of(listOfNumberInInt).sum();

            return sum;
        }

    }

    // This method will split the array by using delimiter
    private static String[] splitArray(String numbers) {

        if(numbers.startsWith("//"))
        {
            return splitByDynamicDelimiter(numbers);
        }

        String[] tokens = numbers.split(",|\n");
        return tokens;
    }

    private static String[] splitByDynamicDelimiter(String numbers) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
        matcher.matches();

        String dynamicDelimiter = matcher.group(1);
        String listOfNumber = matcher.group(2);

        return listOfNumber.split(Pattern.quote(dynamicDelimiter));
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

    // This method will convert string array to int array
    private static int[] convertStringArraytoIntArray(String[] listOfNumbers)
    {
        try
        {
            return Arrays.stream(listOfNumbers).mapToInt(Integer::parseInt).toArray();
        }
        catch (Exception e)
        {
            System.out.println("The value must be number without decimal point");
        }
        return new int[0];
    }

}

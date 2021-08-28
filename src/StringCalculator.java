import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


/**
 * This class is used to add the numbers given in string format
 */

public class StringCalculator
{
    static int coundAddMethodCalling = 0; // counter for add method calling

    public static int Add(String numbers)
    {
        coundAddMethodCalling++;
        if(numbers.isEmpty())
        {
            return 0;
        }
        else
        {
            String[] listOfNumbers = splitArray(numbers);

            int[] listOfNumberInInt = convertStringArraytoIntArray(listOfNumbers);

            checkAllNumbersAreNonNegative(listOfNumberInInt);

            listOfNumberInInt = getNumbersLessThan1000(listOfNumberInInt);

            int sum = IntStream.of(listOfNumberInInt).sum();

            return sum;
        }

    }

    // This method will return the value of how many time the Add method was called
    public static int GetCalledCount()
    {
        return coundAddMethodCalling;
    }

    // This method will check that if all numbers are non negative or not.
    // If not it will throw an Exception
    private static void checkAllNumbersAreNonNegative(int[] listOfNumberInInt) {
        int[] negativeNumbers = Arrays.stream(listOfNumberInInt)
                .filter(i -> i < 0)
                .toArray();

        if (negativeNumbers.length > 0)
        {
            throw new RuntimeException("Negatives not allowed : " + Arrays.toString(negativeNumbers));
        }
    }

    // This method will filter the number that are less than 1000
    private static int[] getNumbersLessThan1000(int[] listOfNumberInInt) {

        int[] lessThan1000 = Arrays.stream(listOfNumberInInt)
                .filter(i -> i < 1000)
                .toArray();

        return lessThan1000;
    }

    // This method will split the array by using delimiter
    private static String[] splitArray(String numbers) {

        if(numbers.startsWith("//["))
        {
            return splitByDynamicDelimiterOfAnyLength(numbers);
        }

        if(numbers.startsWith("//"))
        {
            return splitByDynamicDelimiter(numbers);
        }

        String[] tokens = numbers.split(",|\n");
        return tokens;
    }

    // This method will split the array in to parts the delimeter and the numbers string and then split to number array
    private static String[] splitByDynamicDelimiter(String numbers) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
        matcher.matches();

        String dynamicDelimiter = matcher.group(1);
        String listOfNumber = matcher.group(2);

        return listOfNumber.split(Pattern.quote(dynamicDelimiter));
    }

    // This method will split the array in to parts the delimeter and the numbers string and then split to number array
    // Allow any length of delimiter
    private static String[] splitByDynamicDelimiterOfAnyLength(String numbers) {

        String dynamicDelimiter = "";
        dynamicDelimiter = findDelimiter(numbers);
        String listOfNumber = numbers.substring(numbers.lastIndexOf(']')+2,numbers.length());
        if(listOfNumber.startsWith("]"))
        {
            listOfNumber = listOfNumber.substring(3);
            return listOfNumber.split(dynamicDelimiter);
        }

        return listOfNumber.split(dynamicDelimiter);
    }

    // This method will generate more than one delimeter
    private static String findDelimiter(String numbers) {
        String deliPart = numbers.substring(2,numbers.lastIndexOf("]")+1);
        String tempS = deliPart;
        String delimiter = "";

        while (!tempS.isEmpty())
        {
            int closingPosition = tempS.indexOf("]");
            delimiter = delimiter + Pattern.quote(tempS.substring(1,closingPosition));
            tempS = tempS.substring(closingPosition + 1);

            if(!tempS.isEmpty())
            {
                delimiter = delimiter + "|";
            }
        }

        return delimiter;
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

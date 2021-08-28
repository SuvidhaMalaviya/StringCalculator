import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class is used to generate test cases for the add method of StringCalculator class.
 */

public class StringCalculatorTest
{
    // This method will take care of empty string
    @Test
    public void returnZeroWhenEmptyString()
    {
        assertEquals(0,StringCalculator.Add(""));
    }

    // This method will used to take care of single number string
    @Test
    public void returnNumberWhenStringHavingNumber()
    {
        assertEquals(1,StringCalculator.Add("1"));
    }

    // This method will used to take care of the two number string separated by comma
    @Test
    public void returnSumWhenStringHavingTwoNumberDeliByComma()
    {
        assertEquals(3,StringCalculator.Add("1,2"));
    }

    //This method will used to take care of more than two number separated by comma
    @Test
    public void returnSumWhenStringHavingMoreThenTwoNumbersDeliByComma()
    {
        assertEquals(6,StringCalculator.Add("2,2,2"));
    }

    //This method will used to take care of \n as valid delimiter
    @Test
    public void acceptNewLineAsValidDelimiter()
    {
        assertEquals(6,StringCalculator.Add("2,2\n2"));
    }

    //This method will used to support dynamic delimiter syntax of string
    @Test
    public void acceptStringWithDynamicDelimiter()
    {
        assertEquals(3,StringCalculator.Add("//;\n1;2"));
    }

    //This method will used to support dynamic delimiter that is special symbol
    @Test
    public void acceptStringWithDynamicDelimiterThatIsSpecialSymbol()
    {
        assertEquals(3,StringCalculator.Add("//.\n1.2"));
    }

    //This method will raise an Exception when string contains negative numbers
    @Test
    public void raiseExceptionWhenGetNegativesValues()
    {
        try
        {
            StringCalculator.Add("-1,2,3,4");
            fail("Negatives not allowed");
        }
        catch (Exception e)
        {
            assertEquals("Negatives not allowed : [-1]", e.getMessage());
        }
    }

    //This method will count how many times the Add method was called
    @Test
    public void countHowManyTimeAddMethodCalled()
    {
        StringCalculator.Add("11");
        StringCalculator.Add("11");
        assertEquals(StringCalculator.GetCalledCount(),StringCalculator.GetCalledCount());
    }

    //This method will used to sum the number but the value greater than 1000 should be ignored
    @Test
    public void doSumByIgnoringValueGreaterThan1000()
    {
        assertEquals(6,StringCalculator.Add("1,2,3,1001,1002"));
    }

    //This method will used accept dynamic delimiter of any length
    @Test
    public void allowDelimiterOfAnyLength()
    {
        assertEquals(6,StringCalculator.Add("//[***]\n1***2***3"));
    }

    //This method will used accept multiple dynamic delimiter
    @Test
    public void allowMultipleDelimiter()
    {
        assertEquals(6,StringCalculator.Add("//[*][%]\n1*2%3"));
    }

    //This method will used accept multiple dynamic delimiterof any length
    @Test
    public void allowMultipleDelimiterOfAnyLength()
    {
        assertEquals(6,StringCalculator.Add("//[**][%%]\n1**2%%3"));
    }
}

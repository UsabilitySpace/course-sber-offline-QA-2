package utils;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PrimeNumberUtilTest {

    private Integer inputNumber;
    private Boolean expectedResult;
    private PrimeNumberUtil primeNumberUtil;

    @Before
    public void initialize() {
        primeNumberUtil = new PrimeNumberUtil();
    }

    // Each parameter should be placed as an argument here
    // Every time runner triggers, it will pass the arguments
    // from parameters we defined in primeNumbers() method

    public PrimeNumberUtilTest(Integer inputNumber, Boolean expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {2, true},
                {6, false},
                {19, true},
                {22, false},
                {23, true}
        });
    }

    // This test will run 5 times
    @Test
    public void testPrimeNumberChecker() {
        System.out.println("Parameterized Number is : " + inputNumber + " ; expected result is : " + expectedResult);
        assertEquals(expectedResult,
                primeNumberUtil.validate(inputNumber));
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;

import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Ignore;

public class TestAssertions {

    // run once before any of the test methods in the class
    @BeforeClass
    public static void beforeClass() {
        System.out.println("in before class");
    }


    // run once before any of the test methods in the class
    @AfterClass
    public static void  afterClass() {
        System.out.println("in after class");
    }

    // run before each Test method
    @Before
    public void before() {
        System.out.println("in before");
    }

    // run after each Test method.
    @After
    public void after() {
        System.out.println("in after");
    }

    //If a test class is annotated with @Ignore, then none of its test methods will be executed.

    // If test method is annotated with @Ignore, then it will not be executed.
    @Ignore
    @Test
    public void ignoreTest() {
        System.out.println("in ignore test");
    }

    @Test
    public void testAssertEquals() {
        System.out.println("in testAssertEquals");

        String str = "Junit is working fine";
        //Check that two objects are equal
        assertEquals("assertEquals works fine" , "Junit is working fine", str);
    }

    @Test
    public void testAssertTrue() {
        System.out.println("in testAssertTrue");

        //Check that a condition is true
        int val1 = 5;
        int val2 = 6;
        assertTrue (val1 < val2);
    }

    @Test
    public void testAssertFalse() {
        System.out.println("in testAssertFalse");

        int num = 5;
        //Check that a condition is false
        assertFalse("assertFalse works fine", num > 6);
    }

    @Test
    public void testAssertNotNull() {
        System.out.println("in testAssertNotNull");

        String str = "Junit is working fine";
        //Check that an object isn't null
        assertNotNull("assertNotNull works fine", str);
    }

    @Test
    public void testAssertNull() {
        System.out.println("in testAssertNull");

        String temp = null;
        //Check that an object is null
        assertNull("assertNull works fine", temp);
    }

    @Test
    public void testAssertSame() {
        System.out.println("in testAssertSame");

        //Check if two object references point to the same object
        String str1 = "abc";
        String str2 = "abc";
        assertSame(str1,str2);
    }

    @Test
    public void testNotAssertSame() {
        System.out.println("in testNotAssertSame");

        String str1 = "abc";
        String str2 = "abcd";
        //Check if two object references not point to the same object
        assertNotSame(str1,str2);
    }

    @Test
    public void testAssertEqualsForArrays() {
        System.out.println("in testAssertEqualsForArrays");

        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray =  {"one", "two", "three"};

        //Check whether two arrays are equal to each other.
        assertArrayEquals(expectedArray, resultArray);
    }

}

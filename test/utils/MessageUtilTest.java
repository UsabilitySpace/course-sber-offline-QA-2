package utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageUtilTest {

    @Test(timeout = 1000)
    public void printMessageTest() {
        System.out.println("Inside testPrintMessage()");
        String message = "Message text";
        assertEquals(message, new MessageUtil(message).printMessage());
    }

    @Test(expected = ArithmeticException.class)
    public void printDivisionMessageTest(){
        System.out.println("Inside testPrintDivisionMessage");
        new MessageUtil().printDivisionMessage(5, 0);
    }

}

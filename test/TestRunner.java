import controller.TestEmployeeLogic;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import junit.framework.*;
import utils.MessageUtilTest;

public class TestRunner {
    public static void main(String[] args) {

        /*Result result = JUnitCore.runClasses(MessageUtilTest.class, TestAssertions.class,
                TestCaseTest.class, TestResultTest.class, TestEmployeeLogic.class);*/

        Result result = JUnitCore.runClasses(JunitTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure);
        }

        System.out.println(result.wasSuccessful());

        System.out.println();

        // run tests with TestSuite
        System.out.println("*** Run tests with TestSuite ***");
        TestSuite suite = new TestSuite(MessageUtilTest.class, TestAssertions.class,
                TestResultTest.class, TestEmployeeLogic.class);
        suite.addTestSuite(TestCaseTest.class);

        TestResult res = new TestResult();
        suite.run(res);
        System.out.println("Number of test cases = " + res.runCount());
    }
}

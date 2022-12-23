import controller.EmployeeLogicTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import utils.MessageUtilTest;
import utils.PrimeNumberUtilTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MessageUtilTest.class,
        TestAssertions.class,
        TestCaseTest.class,
        TestResultTest.class,
        EmployeeLogicTest.class,
        PrimeNumberUtilTest.class
})
public class JunitTestSuite {
}

import controller.TestEmployeeLogic;
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
        TestEmployeeLogic.class,
        PrimeNumberUtilTest.class
})
public class JunitTestSuite {
}

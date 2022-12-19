package controller;

import model.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestEmployeeLogic {
    private EmployeeLogic empBusinessLogic;
    private Employee employee;

    @Before
    public void setUp() {
        empBusinessLogic = new EmployeeLogic();

        employee = new Employee();
        employee.setName("Ivanov");
        employee.setAge(25);
        employee.setMonthlySalary(8000);
    }

    //test to check appraisal
    @Test
    public void testCalculateRating() {
        assertEquals(500, empBusinessLogic.calculateRating(employee), 0.0);
    }

    // test to check yearly salary
    @Test
    public void testCalculateYearlySalary() {
        assertEquals(96000, empBusinessLogic.calculateYearlySalary(employee), 0.0);
    }

    @After
    public void tearDown() {
        empBusinessLogic = null;
        employee = null;
    }

}

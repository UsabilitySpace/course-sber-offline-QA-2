package controller;

import model.Employee;

public class EmployeeLogic {

    // Calculate the yearly salary of employee
    public double calculateYearlySalary (Employee employee) {
        return employee.getMonthlySalary() * 12;
    }

    // Calculate the rating of employee
    public double calculateRating (Employee employee) {
        if (employee.getMonthlySalary() < 10000){
            return 500;
        } else {
            return 1000;
        }
    }

}

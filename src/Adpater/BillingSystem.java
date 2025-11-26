package Adpater;

import java.util.List;

public class BillingSystem {
    public void ProcessSalary(List<Employee> employees){
        for(Employee employee : employees){
            System.out.println("Rs. + " + employee.getSalary() + " Salary Credited to " + employee.getName() + " Account");
        }
    }
}

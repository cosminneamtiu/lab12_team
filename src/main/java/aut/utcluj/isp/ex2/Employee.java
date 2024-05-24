package aut.utcluj.isp.ex2;

/**
 * @author stefan
 */
public class Employee {
    private String firstName;
    private String lastName;
    private Double salary;

    public Employee(String firstName, String lastName, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double getSalary() {
        return salary;
    }

    /**
     * Show employee information
     * @return employee information (Firstname: firstname Lastname: lastname Salary: salary)
     */


    public String showEmployeeInfo() {
        return String.format("First Name: %s, Last Name: %s, Salary: %.2f",firstName,lastName,salary);
        // throw new UnsupportedOperationException("Not supported yet.");
    }
}

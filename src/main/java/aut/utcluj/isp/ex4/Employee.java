package aut.utcluj.isp.ex4;

public class Employee implements IdentityManager {
    private String firstName;
    private String lastName;
    private String cnp;
    private SalaryInfo employeeSalaryInfo;

    public Employee(String firstName, String lastName, String cnp, Double monthlyRevenue) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.employeeSalaryInfo = new SalaryInfo(monthlyRevenue);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCnp() {
        return cnp;
    }

    /**
     * Add salary to the employee
     */
    public void addSalary() {
        this.employeeSalaryInfo.addSalary();
    }

    /**
     * Add money as bonus to the employee
     * Value added should be positive
     *
     * @param money - money to be added
     */
    public void addMoney(final Double money) {
        this.employeeSalaryInfo.addMoney(money);
    }

    /**
     * Pay tax from salary
     *
     * @param tax - tax to be paid
     */
    public void payTax(final Double tax) {
        this.employeeSalaryInfo.payTax(tax);
    }

    /**
     * Get salary info
     *
     * @return salary info
     */
    public SalaryInfo getSalaryInfo() {
        return this.employeeSalaryInfo;
    }

    /**
     * Get identity info
     *
     * @return identity info
     */
    @Override
    public String getIdentity() {
        return String.format("%s_%s_%s", firstName, lastName, cnp);
    }
}

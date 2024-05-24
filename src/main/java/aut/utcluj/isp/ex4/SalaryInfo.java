package aut.utcluj.isp.ex4;

public class SalaryInfo {
    private Double totalRevenue;
    private Double monthlyRevenue;

    /**
     * If the monthlyRevenue is not positive, a {@link NegativeAmountException} exception should be thrown
     *
     * @param monthlyRevenue
     */
    public SalaryInfo(Double monthlyRevenue) {
        if (monthlyRevenue <= 0) {
            throw new NegativeAmountException("Monthly revenue should be positive");
        }
        this.monthlyRevenue = monthlyRevenue;
        this.totalRevenue = 0.0;
    }

    /**
     * Add incoming salary to total revenue
     */
    public void addSalary() {
        this.totalRevenue += this.monthlyRevenue;
    }

    /**
     * Add a certain amount of money as bonus
     * If it is not positive, a {@link NegativeAmountException} exception should be thrown
     *
     * @param value - money to be added
     */
    public void addMoney(final Double value) {
        if (value > 0) {
            this.totalRevenue += value;
        } else {
            throw new NegativeAmountException("Value added should be positive");
        }
    }

    /**
     * Pay a certain amount of money as tax
     * If it is not positive, a {@link NegativeAmountException} exception should be thrown
     * If not enough revenue is found, a {@link NegativeBalanceException } exception should be thrown
     *
     * @param value - value to be paid
     */
    public void payTax(final Double value) {
        if (value > 0) {
            if (this.totalRevenue - value >= 0) {
                this.totalRevenue -= value;
            } else {
                throw new NegativeBalanceException("Not enough revenue found");
            }
        } else {
            throw new NegativeAmountException("Value added should be positive");
        }
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public Double getMonthlyRevenue() {
        return monthlyRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}

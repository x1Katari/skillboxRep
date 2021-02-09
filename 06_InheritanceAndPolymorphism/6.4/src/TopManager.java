public class TopManager implements Employee {
    private long salary;
    private long profit;
    private Company company;
    private static final double salaryFactor = 1.5;
    private static final double profitFactor = 2.2;

    public TopManager(Company company) {
        this.company = company;
        this.salary = (long) (110000 +  (Math.random() * 30000));
        if (company.getIncome() > 10000000)
            this.salary += (long) (this.salary * salaryFactor);
        this.profit = (long) (this.salary * profitFactor);
    }
    @Override
    public long getMonthSalary() {
        return salary;
    }
    @Override
    public int compareTo(Employee o) {
        return Long.compare(o.getMonthSalary(), getMonthSalary());
    }
    @Override
    public long getProfit() {
        return profit;
    }
    @Override
    public Company getCompany() {
        return company;
    }
}

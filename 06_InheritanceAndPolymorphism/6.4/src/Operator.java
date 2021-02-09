public class Operator implements Employee  {
    private long salary;
    private long profit;
    private Company company;
    private static final double profitFactor = 1.6;
    public Operator(Company company) {
        this.company = company;
        this.salary = 30000 + (long) (Math.random() * 20000);
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
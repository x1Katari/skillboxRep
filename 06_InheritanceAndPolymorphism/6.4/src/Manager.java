public class Manager implements Employee {
    private long salary;
    private long profit;
    private Company company;
    private static final double salaryFactor = 0.05;

    public Manager(Company company) {
        this.company = company;
        this.profit = (long) (115000 + Math.random() * 35000);
        this.salary = 70000 + (long) (this.profit * salaryFactor);
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

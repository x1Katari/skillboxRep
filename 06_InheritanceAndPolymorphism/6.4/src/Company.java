import java.util.*;

public class Company {
    private long income;
    private String name;
    private ArrayList<Employee> list = new ArrayList<>();

    public Company(String name) {
        this.income = 0;
        this.name = name;
    }
    public List<Employee> getTopSalaryStaff(int count) {
        if (count > 0 && count <= list.size())
            return list.subList(0, count);
        else
            return Collections.emptyList();
    }
    public List<Employee> getLowestSalaryStaff(int count) {
        ArrayList<Employee> list2 = new ArrayList<>();
        if (count > 0 && count <= list.size()) {
            for (int i = list.size() - 1; i >= list.size() - count ; i--) {
                list2.add(list.get(i));
                Collections.sort(list2);
            }
        }
        else
            System.out.println("Недопустимое число");
        return list2;
    }
    public void hire(Employee employee) {
        this.list.add(employee);
        addProfit(employee);
    }
    public void hireALL(List<Employee> employees) {
            for (Employee employee : employees)
                hire(employee);
    }
    public void addProfit(Employee employee) {
        this.income += employee.getProfit();
        Collections.sort(list);
    }
    public void fire(int count) {
        if (list.size() == count)
            System.out.println("В компании не осталось сотрудников");
        if (list.size() >= count)
            for (int i = 0; i < count; i++) {
                int index = (int) (Math.random() * list.size());
                list.remove(index);
            }
    }
    public void fire(List<Employee> employees) {
        if (employees.size() == list.size())
            System.out.println("В компании не осталось сотрудников");
        else if (employees.size() <= list.size())
            for (Employee employee : employees) {
                list.remove(employee);
            }
        else
            System.out.println("Недопустимое число");
    }
    public long getIncome() {
        return income;
    }
    public int getCountEmployees() {
        return list.size();
    }
    public String getName() {
        return name;
    }
    public void print (List<Employee> employees) {
        for (Employee employee : employees)
            System.out.println(employee.getMonthSalary() + " руб");
        System.out.println("==========");
    }
}

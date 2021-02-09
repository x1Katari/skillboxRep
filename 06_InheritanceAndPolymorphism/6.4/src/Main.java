import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        Company company = new Company("ООО Монетка");

        for (int i = 0; i < 180; i++)
            list.add(new Operator(company));
        for (int i = 0; i < 80; i++)
            list.add(new Manager(company));
        for (int i = 0; i < 10; i++)
            list.add(new TopManager(company));

        company.hireALL(list);

        company.print(company.getTopSalaryStaff(30));
        company.print(company.getLowestSalaryStaff(30));

        company.fire(company.getCountEmployees() / 2);

        company.print(company.getTopSalaryStaff(30));
        company.print(company.getLowestSalaryStaff(30));

        company.fire(company.getTopSalaryStaff(5));
        company.fire(company.getLowestSalaryStaff(5));
    }
}

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main
{
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) {
        ArrayList<Employee> staff = loadStaffFromFile();
        Date now = new Date();
        Date start = new Date(1483228799000L);
        Date end = new Date(1514764800000L);
        long duration = 7200000L;


//        Collections.sort(staff, Comparator.comparingInt(Employee::getSalary).thenComparing(Employee::getName));
//        for (Employee employee : staff)
//            System.out.println(employee);

        // Задание №1
        staff.stream()
                .filter(e -> (e.getWorkStart().compareTo(start)
                        * end.compareTo(e.getWorkStart()) == 1))
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);

        System.out.println("\n=========\n");

        // Задание №2
        Airport.getInstance().getTerminals().stream()
                .flatMap(f -> f.getFlights().stream())
                .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                .filter(f -> f.getDate().after(now))
                .filter(f -> f.getDate().getTime() - now.getTime() <= duration)
                .forEach(System.out::println);

    }
    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                    fragments[0],
                    Integer.parseInt(fragments[1]),
                    (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}
import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws EmailIsNotCorrectException, NumberIsNotCorrectException {
        String[] components = data.split("\\s+");
        if (components.length != 4)
            throw new IllegalArgumentException("Wrong format. Correct format: \n" +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        else {
            if (!checkMail(components[2]))
                throw new EmailIsNotCorrectException("Wrong email format. Correct format: \n" +
                        "vasily.petrov@gmail.com");
            else if (!checkNumber(components[3]))
                throw new NumberIsNotCorrectException("Wrong number format. Correct format: \n" +
                        "+79215637722");
            else {
                String name = components[0] + " " + components[1];
                storage.put(name, new Customer(name, components[3], components[2]));
            }
        }
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }
    public boolean checkNumber(String number) {
        Pattern p = Pattern.compile("\\+[0-9]{11}");
        Matcher m = p.matcher(number);
        return m.matches();
    }

    public boolean checkMail(String email) {
        Pattern p = Pattern.compile("(([\\w]+)(\\.?)([\\w]+)@[a-z]+\\.([a-z]+))");
        Matcher m = p.matcher(email);
        return m.matches();
    }
    public void removeCustomer(String name) {
        String[] data = name.split("\\s+");
        if (data.length != 2) {
            throw new IllegalArgumentException("Wrong format. Correct format: \n" +
                    "remove Василий Петров");
        }
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}
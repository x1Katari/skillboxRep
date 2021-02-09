import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите адрес электронной почты");
        System.out.println("Введите LIST, что получить список");
        System.out.println("Введите STOP, что завершить работу программы");
        Scanner scanner = new Scanner(System.in);
        String line = "-1";
        String stopWord = "STOP";
        HashSet<String> emailList = new HashSet<>();

        while (!line.toUpperCase().equals(stopWord)) {
            if (line.toUpperCase().equals("LIST"))
                list(emailList);
            if (line != "-1" & !line.toUpperCase().equals("LIST")) {
                if (testEmail(line))
                    emailList.add(line);
                else
                    System.out.println("Адрес введен не корректно.");
            }
            line = scanner.nextLine();
            if (emailList.contains(line))
                System.out.println("Данный адрес уже содержится в списке");
        }
    }
    public static boolean testEmail(String email){
        Pattern p = Pattern.compile("(([\\w]+)@[a-z]+\\.([a-z]+))");
        Matcher m = p.matcher(email);
        boolean b = m.matches();

        return b;
    }
    public static void list (HashSet<String> a)
    {
        for (String word : a)
            System.out.println(word);
    }
}

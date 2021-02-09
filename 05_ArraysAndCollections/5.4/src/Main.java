import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    private static TreeMap<String, Integer> name2num = new TreeMap<>();
    private static TreeMap<Integer, String> num2name = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = "_";
        while (true) {
            int num = 0;
            String name = "";
            if (!word.equals(""))
                System.out.println("Введите номер телефона или имя абонента");
            word = scanner.nextLine();
            if  (word.equals("LIST"))
                printName(name2num, num2name);
            if (!word.equals("LIST") && !word.equals("")) {
                try {
                    num = Integer.parseInt(word);
                    if(num2name.containsKey(num)) {
                        printNameByNumber(num);
                    }
                    else {
                        System.out.println("Введите имя абонента");
                        name = scanner.nextLine();
                        num2name.put(num, name);
                    }
                }
                catch (NumberFormatException e) {
                    if (name2num.containsKey(word))
                        printNumberByName(word);
                    else {
                        System.out.println("Введите номер телефона");
                        num = scanner.nextInt();
                        name2num.put(word, num);
                    }
                }
            }
        }
    }

    private static void printNameByNumber (int num) {
        System.out.println(num2name.get(num) + " => " + num);
    }
    private static void printNumberByName (String name) {
        System.out.println(name + " => " + name2num.get(name));
    }
    private static void printName(TreeMap<String, Integer> a, TreeMap<Integer, String> b) {
        TreeMap<String, Integer> names = new TreeMap<>();
        for (String key : a.keySet())
            names.put(key, a.get(key));
        for (int key : b.keySet())
            names.put(b.get(key), key);
        for(Map.Entry<String, Integer> entry : names.entrySet())
            System.out.println(entry.getKey() + " => "+ entry.getValue());
    }
}
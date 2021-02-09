import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> dealList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String task = "";
        String stopWord = "STOP";

        System.out.println("Введите LIST, чтобы получить список дел");
        System.out.println("Введите ADD, чтобы добавить новое дело в конец списка");
        System.out.println("Введите ADD и номер через пробел, чтобы добавить новое дело в выбранное поле");
        System.out.println("Введите DELETE и номер через пробел, чтобы удалить дело в выбранном поле");
        System.out.println("Введите EDIT, номер, дело через пробел, чтобы заменить дело в выбранном поле");
        System.out.println("Введите STOP, что завершить работу программы");

        while (!task.toUpperCase().equals(stopWord)) {
            if (task != "") {
                String[] logTask = task.split(" ");
                String commandType = logTask[0].toUpperCase();
                int index = findIndex(logTask, dealList);
                int indexNum = findDealElement(logTask);
                String pull = stack(logTask, indexNum);
                if (commandType.startsWith("ADD"))
                    dealList = add(dealList, pull, index);
                if (commandType.startsWith("LIST"))
                    list(dealList);
                if (commandType.startsWith("DELETE"))
                    dealList = delete(dealList, index);
                if (commandType.startsWith("EDIT"))
                    dealList = edit(dealList, pull, index);
            }
                task = scanner.nextLine();
            }

        System.out.println("Работа программы завершена");
    }
        public static ArrayList<String> add (ArrayList < String > a, String b, int c)
        {
            if (c != -1)
                a.add(c, b);
            else
                a.add(b);
            return a;
        }
        public static void list (ArrayList < String > a)
        {
            if (a.size() > 0) {
                for (int i = 0; i < a.size(); i++)
                    System.out.println(i + " - " + a.get(i));
            }
            else
                System.out.println("Список пуст");
        }
        public static ArrayList<String> delete (ArrayList < String > a, int b)
        {
            if (b != -1)
                a.remove(b);
            else
                System.out.println("В списке нет дела под номером " + b);
            return a;
        }
        public static String stack(String[] a, int b)
        {
            String pull = "";
            for (int i = b; i < a.length; i++)
                pull += a[i] + " ";
            return pull;
        }
        public static int findIndex (String[] a, ArrayList<String> b)
        {
            int flag = -1;
            if (a.length > 1)
                if (a[1].matches("[0-9]"))
                    if (Integer.parseInt(a[1]) <= b.size())
                        flag = Integer.parseInt(a[1]);
            return flag;
        }
        public static ArrayList<String> edit (ArrayList < String > a, String b, int c)
        {
            if (c != -1) {
                a.remove(c);
                a.add(c,b);
            }
            else
                System.out.println("В списке нет дела под номером " + b);
            return a;
        }
        public static int findDealElement (String[] a)
        {
            int flag = 1;
            if (a.length > 1)
                if (a[1].matches("[0-9]"))
                    flag = 2;
            return flag;
        }
}

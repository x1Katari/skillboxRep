import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите номер автомобиля");
        Scanner scanner = new Scanner(System.in);
        long start;
        long duration;
        String c;
        ArrayList<String> numbers = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        String[] chars = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        String[] area = new String[197];
        for (int i = 1; i <= 197; i++) {
            c = String.format("%02d", i);
            area[i-1] = c;
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < 10; j++) {
                for (int z = 0; z < chars.length; z++) {
                    for (int x = 0; x < chars.length; x++) {
                        for (int v = 0; v < area.length; v++) {
                            //c = chars[i] + Integer.toString(j) + Integer.toString(j) + Integer.toString(j) + chars[z] + chars[x] + area[v];
                            c = String.format("%s%03d%s%s%02d", chars[i], Integer.toString(j), chars[z], chars[x], area[v]);
                            numbers.add(c);
                            hashSet.add(c);
                            treeSet.add(c); } } } } }
        Collections.sort(numbers);
        while (true)
        {
            String word = scanner.nextLine();

            start = System.nanoTime();
            String answer = numbers.contains(word) ? "номер найден" : "номер не найден";
            duration = System.nanoTime() - start;
            System.out.println("Поиск перебором: " + answer + ", поиск занял " + duration + " наносекунд");

            start = System.nanoTime();
            int index = Collections.binarySearch(numbers, word);
            duration = System.nanoTime() - start;
            if (index != -1)
                answer = "номер найден";
            else
                answer = "номер не найден";
            System.out.println("Бинарный поиск: " + answer + ", поиск занял " + duration + " наносекунд");

            start = System.nanoTime();
            answer = hashSet.contains(word) ? "номер найден" : "номер не найден";
            duration = System.nanoTime() - start;
            System.out.println("Поиск в HashSet: " + answer + ", поиск занял " + duration + " наносекунд");

            start = System.nanoTime();
            answer = treeSet.contains(word) ? "номер найден" : "номер не найден";
            duration = System.nanoTime() - start;
            System.out.println("Поиск в treeSet: " + answer + ", поиск занял " + duration + " наносекунд\n");
        }



    }
}

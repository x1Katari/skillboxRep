import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("Выберите задание и введите номер: \n");
        System.out.println("Задание 1");
        System.out.println("Задание 2");
        System.out.println("Задание 3\n");

        Scanner scan = new Scanner(System.in);
        int task = scan.nextInt();
        if (task == 1) {

            String text = "красный, оранжевый, желтый, зеленый, голубой, синий, фиолетовый";
            String[] colors = text.split(",?\\s+");
            ArrayList<String> reversColor = new ArrayList<>();
            for (int i = 0; i < colors.length; i++) {
                reversColor.add(colors[colors.length - 1 - i]);
            }
            for (int i = 0; i < reversColor.size(); i++) {
                System.out.println(reversColor.get(i) + " ");
            }
        }



        if (task == 2) {
            float avg = 0;
            int countHealth = 0;
            float[] temp = new float[30];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = (32 + (float) Math.round(80 * Math.random()) / 10);
            }
            countHealth = countHealth(temp);
            avg = avgTemp(temp);
            for (float tempIndex : temp)
            {
                System.out.print(tempIndex + ", ");
            }

            System.out.println("Средняя температура по больнице - " + avg);
            System.out.println("Здоровых пациентов - " +  countHealth);
        }


        if (task == 3) {
            System.out.println("Введите размер креста (нечетное число)");
            Scanner scanner = new Scanner(System.in);
            int size = scanner.nextInt();
            String[][] cross = new String[size][size];
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    if (i == j || i + j == size - 1)
                    {
                        cross[i][j] = "X";
                    }
                    else {
                        cross[i][j] = " ";
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(cross[i][j]);
                }
                System.out.print("\n");
            }
        }
    }

    public static float avgTemp(float[] a) {
        float sumTemp = 0;
        float avg = 0;
        for (int i = 0; i < a.length; i++)
        {
            sumTemp += a[i];
        }
        avg = (float) Math.round(10 * sumTemp/a.length) / 10;
        return avg;
    }

    public static int countHealth(float[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] >= 36.2 && a[i] <= 36.9)
            {
                count++;
            }
        }
        return count;
    }
}

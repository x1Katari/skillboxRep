import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static final String dimensions[] = {" байт", " килобайт", " мегабайт", " гигабайт", " терабайт", " петабайт"};
    public static int size = 0;

    public static void main(String[] args) {
        System.out.println("Введите желаемый путь к файлу / папке");
        while (true) {
            int dimension = 0;
            double result = qwe(args[0]);
            while (result > 1024) {
                result /= 1024;
                dimension++;
            }
            result = (double) Math.round(result * 10) / 10;
            System.out.println(result + dimensions[dimension]);
            size = 0;
        }
    }
    public static double qwe(String path) {
        long result = 0;
        try {
            result = Files.walk(Paths.get(path), Integer.MAX_VALUE).map(Path::toFile).map(f -> f.length()).reduce((s1,s2) -> s1 + s2).get();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return (double) result;
    }
}

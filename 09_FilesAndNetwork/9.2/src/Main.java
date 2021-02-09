import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Path srcFolder = Paths.get(args[0]);
        Path dstFolder = Paths.get(args[1]);
        CopyDIr copyDIrResult = new CopyDIr(srcFolder, dstFolder);
        Files.walkFileTree(srcFolder, copyDIrResult);
    }

}



























//    public static void main(String[] args) {

//        File srcFolder = new File(args[0]);
//        File destFolder = new File(args[1]);
//
//        if (!srcFolder.exists()) {
//            System.out.println("Директории не существует");
//            System.exit(0);
//        } else {
//            try {
//                copyFolder(srcFolder, destFolder);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                System.exit(0);
//            }
//        }
//        System.out.println("Копирование завершено");
//    }




//    public static void copyFolder(File src, File dest) throws IOException {
//
//        if (src.isDirectory()) {
//            if (!dest.exists()) {
//                dest.mkdir();
//            }
//            String[] files = src.list();
//            for (String file : files) {
//                File srcFile = new File(src, file);
//                File destFile = new File(dest, file);
//                copyFolder(srcFile, destFile);
//            }
//        } else {
//            Files.copy(src.toPath(), dest.toPath());
//            System.out.println("Файл " + src + " успешно скопирован");
//        }
//    }
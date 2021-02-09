import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class Main {
    private static final String folderName = "images";
    public static void main(String[] args) throws IOException {
        ArrayList<String> links = new ArrayList<>();
        Document doc = Jsoup.connect("https://lenta.ru/").get();
        Elements elements = doc.getElementsByTag("img");
        elements.forEach(e -> {
            if (e.attr("abs:src").contains(".png") || e.attr("abs:src").contains(".jpg"))
                links.add(e.attr("abs:src"));
        });
        for (String link : links)
            getImage(link);
    }
    private static void getImage(String src) throws IOException  {
        File theDir = new File(folderName);
        if (!theDir.exists())
            theDir.mkdir();
        URL url = new URL(src);
        String fileName = url.getFile();
        String destName = folderName + fileName.substring(fileName.lastIndexOf("/"));

        try (InputStream is = url.openStream(); OutputStream fos = new FileOutputStream(destName)) {
            byte[] b = new byte[2048];
            int length;
            while ((length = is.read(b)) != -1)
                fos.write(b, 0, length);
        }
    }
}

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String dataFile = "data/stations.json";
    public static void main(String[] args) throws Exception {
        Metro metro = new Metro();

        Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
        Elements namesOfStations = doc.getElementsByClass("js-metro-stations");
        namesOfStations.forEach(el -> {
            LineStations lineStations = new LineStations();
            el.children().forEach(element -> {
                lineStations.add(element.getElementsByClass("name").text()); // название станции
//                System.out.println(el.attr("data-line") + "// номер линии");
            });
            metro.addLineStations(lineStations);
        });
        Elements namesOfLines = doc.getElementsByClass("js-metro-line");
        namesOfLines.forEach(el -> {
            Line line = new Line();
            line.setName(el.text());
            line.setNumber(el.attr("data-line"));
            metro.addLine(line);
        });

        String jsonResult = new ObjectMapper().writeValueAsString(metro);
        try (FileWriter file = new FileWriter(dataFile)) {
            file.write(jsonResult);
        }
        Metro newMetro = new ObjectMapper().readValue(getJsonFile(), Metro.class);
        for (int i = 0; i < newMetro.getLines().size(); i++)
            System.out.println(newMetro.getLines().get(i).getName() + " - " + newMetro.getStations().get(i).getNumberLine().size() + " станций");
    }
    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(dataFile));
            lines.forEach(builder::append);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}

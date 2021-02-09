import java.util.ArrayList;
import java.util.List;

public class Metro {
    private List<LineStations> Stations;
    private List<Line> lines;

    public Metro() {
        this.Stations = new ArrayList();
        this.lines = new ArrayList();
    }
    public List<LineStations> getStations() {
        return Stations;
    }
    public List<Line> getLines() {
        return lines;
    }

    public void setStations(List<LineStations> stations) {
        Stations = stations;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public void addLine(Line line) {
        lines.add(line);
    }
    public void addLineStations(LineStations lineStations) {
        Stations.add(lineStations);
    }
}

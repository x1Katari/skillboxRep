import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.ArrayList;
import java.util.List;

public class LineStations {
    private List<String> numberLine;

    public LineStations() {
        this.numberLine = new ArrayList();
    }
    @JsonGetter("№")
    public List<String> getNumberLine() {
        return numberLine;
    }
    public void add(String station) {
        numberLine.add(station);
    }

    public void setNumberLine(List<String> numberLine) {
        this.numberLine = numberLine;
    }
}

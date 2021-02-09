import core.*;
import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class Tests {
    List<Station> stations = new ArrayList<>();
    StationIndex stationIndex = new StationIndex();
    RouteCalculator calculator = new RouteCalculator(stationIndex);
    Line line1 = new Line(1, "Первая");
    Line line2 = new Line(2, "Вторая");
    Line line3 = new Line(3, "Третья");
    Line line4 = new Line(4, "Четвертая");
    Line line5 = new Line(5, "Пятая");

    Station s11 = new Station("s11", line1);
    Station s12 = new Station("s12", line1);
    Station s13 = new Station("s13", line1);
    Station s14 = new Station("s14", line1);
    Station s15 = new Station("s15", line1);
    Station s16 = new Station("s16", line1);

    Station s21 = new Station("s21", line2);
    Station s22 = new Station("s22", line2);
    Station s23 = new Station("s23", line2);
    Station s24 = new Station("s24", line2);
    Station s25 = new Station("s25", line2);
    Station s26 = new Station("s26", line2);

    Station s31 = new Station("s31", line3);
    Station s32 = new Station("s32", line3);
    Station s33 = new Station("s33", line3);
    Station s34 = new Station("s34", line3);
    Station s35 = new Station("s35", line3);
    Station s36 = new Station("s36", line3);

    Station s41 = new Station("s41", line4);
    Station s42 = new Station("s42", line4);
    Station s43 = new Station("s43", line4);
    Station s44 = new Station("s44", line4);
    Station s45 = new Station("s45", line4);
    Station s46 = new Station("s46", line4);

    Station s51 = new Station("s51", line5);
    Station s52 = new Station("s52", line5);
    Station s53 = new Station("s53", line5);
    Station s54 = new Station("s54", line5);
    Station s55 = new Station("s55", line5);
    Station s56 = new Station("s56", line5);

    @Before
    public void setUp() {
        stations.add(s11);
        stations.add(s12);
        stations.add(s13);
        stations.add(s14);
        stations.add(s15);
        stations.add(s16);

        stations.add(s21);
        stations.add(s22);
        stations.add(s23);
        stations.add(s24);
        stations.add(s25);
        stations.add(s26);

        stations.add(s31);
        stations.add(s32);
        stations.add(s33);
        stations.add(s34);
        stations.add(s35);
        stations.add(s36);

        stations.add(s41);
        stations.add(s42);
        stations.add(s43);
        stations.add(s44);
        stations.add(s45);
        stations.add(s46);

        stations.add(s51);
        stations.add(s52);
        stations.add(s53);
        stations.add(s54);
        stations.add(s55);
        stations.add(s56);

        line1.addStation(s11);
        line1.addStation(s12);
        line1.addStation(s13);
        line1.addStation(s14);
        line1.addStation(s15);
        line1.addStation(s16);

        line2.addStation(s21);
        line2.addStation(s22);
        line2.addStation(s23);
        line2.addStation(s24);
        line2.addStation(s25);
        line2.addStation(s26);

        line3.addStation(s31);
        line3.addStation(s32);
        line3.addStation(s33);
        line3.addStation(s34);
        line3.addStation(s35);
        line3.addStation(s36);

        line4.addStation(s41);
        line4.addStation(s42);
        line4.addStation(s43);
        line4.addStation(s44);
        line4.addStation(s45);
        line4.addStation(s46);

        line5.addStation(s51);
        line5.addStation(s52);
        line5.addStation(s53);
        line5.addStation(s54);
        line5.addStation(s55);
        line5.addStation(s56);

        List<Station> connection1 = new ArrayList<>();
        List<Station> connection2 = new ArrayList<>();
        List<Station> connection3 = new ArrayList<>();
        List<Station> connection4 = new ArrayList<>();
        List<Station> connection5 = new ArrayList<>();
        List<Station> connection6 = new ArrayList<>();
        List<Station> connection7 = new ArrayList<>();
        connection1.add(s22);
        connection1.add(s32);

        connection2.add(s12);
        connection2.add(s33);

        connection3.add(s13);
        connection3.add(s42);

        connection4.add(s23);
        connection4.add(s41);
        connection4.add(s53);

        connection5.add(s34);
        connection5.add(s43);

        connection6.add(s14);
        connection6.add(s54);

        connection7.add(s15);
        connection7.add(s24);
        stationIndex.addConnection(connection1);
        stationIndex.addConnection(connection2);
        stationIndex.addConnection(connection3);
        stationIndex.addConnection(connection4);
        stationIndex.addConnection(connection5);
        stationIndex.addConnection(connection6);
        stationIndex.addConnection(connection7);
    }

    @Test
    public void testCalculateDuration () {
        double actual = calculator.calculateDuration(getRouteByString(
                "s12->s13->s42->s43->s44->s45->s46"));
        double expected = 16;
        assertEquals(expected,actual, 0.1);
    }
    @Test
    public void testGetRouteOnTheLine () {
        List<Station> actual = calculator.getShortestRoute(s11, s16);
        List<Station> expected = getRouteByString("s11->s12->s13->s14->s15->s16");
        assertEquals(expected,actual);
    }
    @Test
    public void testGetRouteWithOneConnection () {
        List<Station> actual = calculator.getShortestRoute(s11, s36);
        List<Station> expected = getRouteByString("s11->s12->s33->s34->s35->s36");
        assertEquals(expected,actual);
    }
    @Test
    public void testGetRouteWithTwoConnections () {
        List<Station> actual = calculator.getShortestRoute(s52, s35);
        List<Station> expected = getRouteByString("s52->s53->s41->s42->s43->s34->s35");
        assertEquals(expected,actual);
    }

    private List getRouteByString(String stringRoute) {
        List route = new ArrayList<>();
        String[] routeNames = stringRoute.split("->");
            for (int i = 0; i < routeNames.length; i++) {
                for (Station station : stations) {
                    if (station.getName().equals(routeNames[i]))
                        route.add(station);
                }
        }
        return route;
    }
}

package denilai.rtu.subway;

import java.util.*;

public class MoscowSubway {
    List <Line> lines;
    Map<String,List<String>> stations;

    public MoscowSubway(){
        lines = new ArrayList<>();
        stations = new LinkedHashMap<>();
    }

    public void addLine(String name, String alias){
        lines.add(new Line(name, alias));
    }

    public void addStation(String lineAlias, String stationName) {

        if (!stations.containsKey(lineAlias)) {
            stations.put(lineAlias, new ArrayList<>(Collections.singletonList(stationName)));
            return;
        }
        List<String> stationsOnLine = stations.get(lineAlias);
        stationsOnLine.add(stationName);
        stations.put(lineAlias, stationsOnLine);
    }

    public void stationOnEachLineReport(){
        System.out.printf("%-38s|%-10s%n","Линия метро","Число станций");
        System.out.printf("%-51s%n",
                "--------------------------------------------------------------------");

        for(Line line:lines){
            int count = stations.get(line.getAlias()).size();
            String lineName = line.getName();
            System.out.printf("%-38s|%-10s%n",lineName,count);
        }
        System.out.println("\n\n");
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public void setStations(Map<String, List<String>> stations) {
        this.stations = stations;
    }

    public List<Line> getLines(){return lines;}

    public Map<String,List<String>> getStations(){return stations;}

}

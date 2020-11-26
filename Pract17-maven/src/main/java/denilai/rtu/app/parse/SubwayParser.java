package denilai.rtu.app.parse;

import denilai.rtu.subway.MoscowSubway;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SubwayParser {


    public void autoMod(){

    }

    public static MoscowSubway parseSubwayResource(String url){
        MoscowSubway subway = new MoscowSubway();
        try {
            Document doc = Jsoup.connect(url).maxBodySize(0).get();


            Elements linesAndStation = doc.select("div[class=content-wrapper]");
            Elements lineSet = linesAndStation.select("span[data-line~=[0-9]]");
            lineSet.forEach(line -> {
                String lineKey = line.attr("data-line");
                String lineName = line.text();
                subway.addLine(lineName,lineKey);
            });

            Elements stationSet = linesAndStation.select("div[data-line~=[0-9]]");
            stationSet.forEach( station -> {
                String lineKey = station.attr("data-line");
                Elements stationName = station.select("div[data-line="+lineKey+"]").select("span[class=name]");
                stationName.forEach(name -> {
                    subway.addStation(lineKey, name.text());
                });
            });

        }
        catch (IOException a){
            a.printStackTrace();
        }
        return subway;
    }



}

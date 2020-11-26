package denilai.rtu.gson.serialize;

import com.google.gson.*;
import denilai.rtu.subway.Line;
import denilai.rtu.subway.MoscowSubway;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class MoscowSubwaySerializer implements JsonSerializer <MoscowSubway> {
    @Override
    public JsonElement serialize(MoscowSubway subway, Type type, JsonSerializationContext context) {

        JsonObject result = new JsonObject();


        JsonObject stationsObject = new JsonObject();

        for(Map.Entry<String, List<String>> entry : subway.getStations().entrySet()){
            stationsObject.add(entry.getKey(),context.serialize(entry.getValue()));
        }

        result.add("stations",context.serialize(subway.getStations()));


        JsonArray linesArray = new JsonArray();

        for(Line line : subway.getLines()){
            linesArray.add(context.serialize(line));
        }

        result.add("lines",linesArray);;

        return result;
    }
}

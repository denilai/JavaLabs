package denilai.rtu.gson.deserialize;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import denilai.rtu.subway.Line;
import denilai.rtu.subway.MoscowSubway;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MoscowSubwayDeserializer implements JsonDeserializer<MoscowSubway> {
    @Override
    public MoscowSubway deserialize(
            JsonElement jsonElement,
            Type type,
            JsonDeserializationContext context) throws JsonParseException {

        MoscowSubway subway = new MoscowSubway();

        JsonObject mainObject = jsonElement.getAsJsonObject();

        JsonObject stationsObject = mainObject.get("stations").getAsJsonObject();

        Map<String, List<String>> rawStations = new LinkedHashMap<>();
        for(Map.Entry<String, JsonElement> entry : stationsObject.entrySet()){
            rawStations.put(
                            entry.getKey(),
                            context.deserialize(
                                entry.getValue(),
                                new TypeToken<List<String>>() {}.getType()));
        }
        subway.setStations(rawStations);

        JsonArray linesArray = mainObject.get("lines").getAsJsonArray();

        List<Line> rawLines = new ArrayList<>();

        for(JsonElement element : linesArray){
            rawLines.add(context.deserialize(element,Line.class));
        }
        subway.setLines(rawLines);
        return subway;
    }
}

package denilai.rtu.gson.serialize;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class StationsSerializer implements JsonSerializer <List<String>>{
    @Override
    public JsonElement serialize(
                                List<String> sameLineStations,
                                Type type,
                                JsonSerializationContext context) {



        JsonArray result = new JsonArray();
        for(String station: sameLineStations)
            result.add(station);

        return result;
    }
}





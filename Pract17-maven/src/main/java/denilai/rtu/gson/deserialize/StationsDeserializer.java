package denilai.rtu.gson.deserialize;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StationsDeserializer implements JsonDeserializer<List<String>> {
    @Override
    public List<String> deserialize(
            JsonElement jsonElement,
            Type type,
            JsonDeserializationContext context) throws JsonParseException {

        JsonArray jsonArray = jsonElement.getAsJsonArray();

        List<String> sameLineStations = new ArrayList<>();

        for(JsonElement element : jsonArray){
            sameLineStations.add(element.getAsJsonPrimitive().getAsString());
        }

        return sameLineStations;
    }
}

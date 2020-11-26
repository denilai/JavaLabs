package denilai.rtu.gson.serialize;

import com.google.gson.*;
import denilai.rtu.subway.Line;

import java.lang.reflect.Type;
import java.util.List;

public class LineSerializer implements JsonSerializer <Line> {
    @Override
    public JsonElement serialize(Line line, Type type, JsonSerializationContext context) {

        JsonObject lineObject = new JsonObject();
        lineObject.addProperty("number", line.getAlias());
        lineObject.addProperty("name", line.getName());

        return lineObject;
    }
}

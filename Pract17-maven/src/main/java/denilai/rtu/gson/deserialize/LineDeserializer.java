package denilai.rtu.gson.deserialize;

import com.google.gson.*;
import denilai.rtu.subway.Line;

import java.lang.reflect.Type;

public class LineDeserializer implements JsonDeserializer <Line> {
    @Override
    public Line deserialize(
                            JsonElement jsonElement,
                            Type type,
                            JsonDeserializationContext context) throws JsonParseException {


        JsonObject object = jsonElement.getAsJsonObject();

        Line resultLine = new Line(
                object.get("name").getAsString(),
                object.get("number").getAsString());

        return resultLine;
    }
}

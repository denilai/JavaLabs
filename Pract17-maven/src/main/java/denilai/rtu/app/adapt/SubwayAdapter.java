package denilai.rtu.app.adapt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import denilai.rtu.gson.serialize.*;
import denilai.rtu.gson.deserialize.*;
import denilai.rtu.subway.*;

import java.util.List;

public class SubwayAdapter {

    public static String serializeSubway(MoscowSubway subway) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(MoscowSubway.class, new MoscowSubwaySerializer())
                .registerTypeAdapter(new TypeToken<List<String>>() {
                }.getType(), new StationsSerializer())
                .registerTypeAdapter(Line.class, new LineSerializer())
                .create();
        String json = gson.toJson(subway);

        System.out.println(json);
        return json;
    }

    public static MoscowSubway deserializeSubway(String json){

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(MoscowSubway.class, new MoscowSubwayDeserializer())
                .registerTypeAdapter(new TypeToken<List<String>>() {
                }.getType(), new StationsDeserializer())
                .registerTypeAdapter(Line.class, new LineDeserializer())
                .create();
        MoscowSubway subway = gson.fromJson(json,MoscowSubway.class);

        return subway;
    }

}

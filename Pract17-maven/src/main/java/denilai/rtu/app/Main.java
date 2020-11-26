package denilai.rtu.app;

import denilai.rtu.app.adapt.SubwayAdapter;
import denilai.rtu.app.parse.SubwayParser;
import denilai.rtu.subway.MoscowSubway;

import java.io.*;
import java.nio.CharBuffer;

public class Main {
    public static void main(String [] args){
        while (Menu.execute(Menu.task())){}
    }

}

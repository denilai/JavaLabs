package denilai.rtu.app.parse;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class FileMaster {

    public static void deleteAllFilesFolder(String path) {
        try {
            for (File myFile : Objects.requireNonNull(new File(path).listFiles()))

                if (myFile.isFile())
                    Files.delete(Path.of(myFile.getAbsolutePath()));
        }
        catch (IOException | NullPointerException a){
            a.printStackTrace();
        }
    }

    public static void writeToFile(String path, String content) throws IOException {
        BufferedWriter bufWriter = new BufferedWriter(new FileWriter(path, false));
        bufWriter.write(content);
        bufWriter.flush();
        bufWriter.close();
    }

    public static String readFromFile(String path) throws IOException {

        BufferedReader bufReader = new BufferedReader(new FileReader(path));
        StringBuilder content = new StringBuilder();

        // чтение посимвольно
        String s;
        while((s=bufReader.readLine())!=null){

            content.append(s);
        }
        return content.toString();
    }



}

package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Main
{
    static int coreCount = Runtime.getRuntime().availableProcessors();

    static String srcFolder = "images";
    static String dstFolder = "destination";


    public static void main(String[] args)
    {
        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        assert files != null;
        long toOneThread = Math.round((double)files.length/coreCount);

        int size = files.length;
        int head = 0;

        try
        {
            if (!Files.exists(Paths.get(dstFolder)))
            {
                Files.createDirectories(Paths.get(dstFolder));
            }
            deleteAllFilesFolder(dstFolder);
            System.out.println("The " +dstFolder+ " folder is empty");
            int num = 1;

            while (head < files.length){
                File[] files1 = new File[(int) toOneThread];
                System.arraycopy(files, head, files1, 0, (int)toOneThread);
                head += toOneThread;
                size-= toOneThread;
                toOneThread = Math.round((double)(size)/--coreCount);

                new Thread(new ImageResizer(dstFolder, files1, num)).start();
                num++;

            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Duration of the main method: " + (System.currentTimeMillis() - start));

        System.out.println("Result - " + files.length + " images were reduced and moved to a " + dstFolder + " folder");

    }


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

}
package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupDownloadImages {

    private static final String IMAGE_DESTINATION_FOLDER = "resources\\images";

    public static List<String> parseImageFromResources(){

        System.out.println("Images upload to the \\"+IMAGE_DESTINATION_FOLDER+" folder");

        List <String> imgNames = new ArrayList<>();
        try {

            Document doc = Jsoup.connect("https://www.mirea.ru").get();
            Elements imageElements = doc.select("img");
            for(Element imageElement : imageElements){

                String strImageURL = imageElement.attr("abs:src");
                String strDataImageUrl = imageElement.attr("abs:data");

                //загружаем изображеия по одному
                if(!strImageURL.equals(""))
                    imgNames.add(downloadImage(strImageURL));
                if(!strDataImageUrl.equals(""))
                    imgNames.add(downloadImage(strDataImageUrl));

            }
        }
        catch (IOException a){
            a.printStackTrace();
        }
        return imgNames;
    }

    private static String downloadImage(String strImageURL ){

        //инициализируем имя переменной из пути к папке с вложениями
        String strImageName =
                strImageURL.substring( strImageURL.lastIndexOf("/") + 1 );


        try {

            //открываем поток из URL
            URL urlImage = new URL(strImageURL);
            InputStream in = urlImage.openStream();

            byte[] buffer = new byte[4096];
            int n = -1;

            OutputStream os =
                    new FileOutputStream( IMAGE_DESTINATION_FOLDER + "/" + strImageName );

            while ( (n = in.read(buffer)) != -1 ){
                os.write(buffer, 0, n);
            }

            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return strImageName;
    }

}

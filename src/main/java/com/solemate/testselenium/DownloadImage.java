/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Going to this inititally open the connection with aws 
//get all url calls download image function 
//close aws after page depth has finnished
package com.solemate.testselenium;

import com.google.common.io.Files;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

/**
 *
 * @author Paul made this its own class so we can implement AWS S3 in this
 * function
 */
public class DownloadImage {

    private final String IMAGE_DESTINATION_FOLDER;
    private final String SHOE_TYPE;
    private int COUNT;
    public DownloadImage(String Dest, String shoe, int count) {
        IMAGE_DESTINATION_FOLDER = Dest;
        SHOE_TYPE = shoe;
        COUNT = count;
    }

    public void saveDataImg(String strImageURL) throws URISyntaxException, MalformedURLException {

    }

    public void saveImage(String imageUrl) throws IOException, URISyntaxException {
        try {
            URL url = new URL(imageUrl);
            String protocol = url.getProtocol();
            System.out.println("Current protocol is: " + protocol + " The url is: " + url.toString());
            if ("data".equals(protocol)) {
                saveDataImg(imageUrl);
            } else if ("https".equals(protocol) || "http".equals(protocol)) {
                String fileName = url.getFile();
                fileName = fileName.substring(fileName.lastIndexOf("/"));
                if(!(fileName.contains(".jpg") || (fileName.contains(".png")))) {
                    COUNT++;
                    fileName = SHOE_TYPE +"_" + COUNT +".jpg";
                }
                String destName = IMAGE_DESTINATION_FOLDER + fileName;
                OutputStream os;
                InputStream is = url.openStream();
                os = new FileOutputStream(destName);
                byte[] b = new byte[4096];
                int length;
                while ((length = is.read(b)) != -1) {
                    os.write(b, 0, length);
                }

                System.out.println("Saved " + fileName);

                os.close();
            } else {
                System.out.println("error, not http or data file");
            }
        } catch (Exception e) {
            System.out.println("another data formatting thing");
        }
    }
}

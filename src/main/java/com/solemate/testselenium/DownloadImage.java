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
import java.util.Random;

/**
 *
 * @author Paul made this its own class so we can implement AWS S3 in this
 * function
 */
public class DownloadImage {

    private final String IMAGE_DESTINATION_FOLDER;
    private final String SHOE_TYPE;

    public DownloadImage(String Dest, String shoe) {
        IMAGE_DESTINATION_FOLDER = Dest;
        SHOE_TYPE = shoe;
    }

    public void saveDataImg(String strImageURL) throws URISyntaxException, MalformedURLException {
        //TODO? is this possible
    }

    public void saveImage(String imageUrl, int count) throws IOException, URISyntaxException {
        try {
            URL url = new URL(imageUrl);
            String protocol = url.getProtocol();
            //System.out.println("Current protocol is: " + protocol + " The url is: " + url.toString());
            if ("data".equals(protocol)) {
                saveDataImg(imageUrl);
            } else if ("https".equals(protocol) || "http".equals(protocol)) {
                String fileName = url.getFile();
                fileName = fileName.substring(fileName.lastIndexOf("/"));
                count++;
                Random rand = new Random();
                int randNum = rand.nextInt(10000) + 1;
                if (!(fileName.contains(".jpg") || (fileName.contains(".png")))) {  //deal with the case where the end is not really the .jpg
                    fileName = SHOE_TYPE + "_" + count +"_"+  randNum + ".jpg";
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
            //System.out.println("another data formatting thing");
        }
    }
}

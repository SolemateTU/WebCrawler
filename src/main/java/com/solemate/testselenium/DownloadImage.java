/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Going to this inititally open the connection with aws 
//get all url calls download image function 
//close aws after page depth has finnished

package com.solemate.testselenium;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 *
 * @author Paul
 */
public class DownloadImage {
    private final String IMAGE_DESTINATION_FOLDER;
    public DownloadImage(String Dest){
        IMAGE_DESTINATION_FOLDER = Dest;
    }
    
    
    private void downloadImage(String strImageURL) {

        //get file name from image path
        String strImageName
                = strImageURL.substring(strImageURL.lastIndexOf("/") + 1);

        System.out.println("Saving: " + strImageName + ", from: " + strImageURL);

        try {

            //open the stream from URL
            URL urlImage = new URL(strImageURL);
            InputStream in = urlImage.openStream();

            byte[] buffer = new byte[4096];
            int n = -1;

            OutputStream os = new FileOutputStream(IMAGE_DESTINATION_FOLDER + "/" + strImageName);

            //write bytes to the output stream
            while ((n = in.read(buffer)) != -1) {
                os.write(buffer, 0, n);
            }
            //close the stream
            os.close();
            //System.out.println("Image saved");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

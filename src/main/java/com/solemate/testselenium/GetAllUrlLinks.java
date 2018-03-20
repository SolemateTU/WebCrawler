/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solemate.testselenium;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Paul
 */
public class GetAllUrlLinks {

    private HashSet<String> links;
    private static final int MAX_DEPTH = 10;
    //private final String IMAGE_DESTINATION_FOLDER = "C:\\Users\\Paul\\Documents\\Crawl\\Jordan_3";
    private final String IMAGE_DESTINATION_FOLDER = "C:\\Users\\Paul\\Documents\\Crawl\\cats";

    private final String SHOE_TYPE = "Jordan_3";
    private int count;

    public GetAllUrlLinks(int c) {
        links = new HashSet<>();
        count = c;
        //webDriver = webDriverin;

    }

    public void getPageLinks(String URL, int depth) throws MalformedURLException, URISyntaxException, IOException, InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        if ((!links.contains(URL) && (depth < MAX_DEPTH) && !(URL.isEmpty()))) {
            System.out.println(">> Depth: " + depth + " [" + URL + "]");
            //links.add(URL);
            webDriver.get(URL);

            findImagesOnPage(webDriver); //get the images on page

            //for loop recursively calls getpagelinks
            depth++;
            for (WebElement link : webDriver.findElements(By.tagName("a"))) {
                String StrLink = link.getAttribute("href");

                if ((StrLink != null) && (StrLink.contains("/imgres?imgurl=https"))) {
                    webDriver.close();
                    getPageLinks(StrLink, depth);
                }
            }

        } else {
            System.out.println("REACHED THE END!");
            webDriver.close();
            Thread.sleep(4000);
            webDriver.quit();
        }

    }

    private void findImagesOnPage(WebDriver webDriver) throws IOException, URISyntaxException {
        DownloadImage down = new DownloadImage(IMAGE_DESTINATION_FOLDER, SHOE_TYPE);
        List<WebElement> listOfimg = webDriver.findElements(By.tagName("img"));

        //This for loop is to attempt to download all pictures on page
        for (int k = 0; k < listOfimg.size() - 1; k++) {
            String ImgSource = listOfimg.get(k).getAttribute("src");
            if ((ImgSource != null) && (ImgSource.length() != 0)) {
                count++;
                down.saveImage(ImgSource, count);
            }
        }
    }

}

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
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Paul
 */
public class GetAllUrlLinks {

    // private List<WebElement> no;
    private List urls; //old
    private HashSet<String> links;
    private static final int MAX_DEPTH = 3;
    private final HashSet<String> img;
    private final String IMAGE_DESTINATION_FOLDER = "C:\\Users\\Paul\\Documents\\Crawl\\";
    private final String SHOE_TYPE = "Jordan_3";
    private int count;

    public GetAllUrlLinks() {
        links = new HashSet<>();
        img = new HashSet<>();
        //webDriver = webDriverin;

    }

    public void getPageLinks(String URL, int depth) throws MalformedURLException, URISyntaxException, IOException {
        if ((!links.contains(URL) && (depth < MAX_DEPTH))) {
            if (!URL.isEmpty()) {
                System.out.println(">> Depth: " + depth + " [" + URL + "]");
                links.add(URL);
                WebDriver webDriver = new ChromeDriver();
                webDriver.get(URL);

                List<WebElement> listOfimg = webDriver.findElements(By.tagName("img"));
                List<WebElement> listOfLinks = webDriver.findElements(By.tagName("a"));
                DownloadImage down = new DownloadImage(IMAGE_DESTINATION_FOLDER, SHOE_TYPE, count++);

                //This for loop is to attempt to download all pictures on page
                System.out.println("BEGIN IMAGE DOWNLOAD:******************** There are: " + listOfimg.size() + " images");

                //check list of image
                for (int k = 0; k < listOfimg.size() - 1; k++) {
                    String ImgSource = listOfimg.get(k).getAttribute("src");
                    if ((ImgSource != null) && (ImgSource.length() != 0)) {
                        down.saveImage(ImgSource);
                    }
                }
                System.out.println("END img links:****************");

                System.out.println("Size of listOfLinks " + listOfLinks.size());
                depth++;
                System.out.println("depth incremented: " + depth);

                //GET THE URLs
                //for loop prints out all links on page for testign purposes - delete when complete or replace with recursive function call 
                for (int i = 0; i <= listOfLinks.size() - 1; i++) {
                    String StrLink = listOfLinks.get(i).getAttribute("href");
                    if ((StrLink != null) && StrLink.contains("https://www.google.com/search?q=jordan+3")) {
                        System.out.println("Link address: " + StrLink);
                    }else{
                        listOfLinks.remove(i); //remove any invalid links that we dont want 
                    }
                }
            }

//                //for loop recursively calls getpagelinks
//                for (int r = 0; r <= listOfLinks.size() - 1; r++) {
//                    String StrLink = listOfLinks.get(r).getAttribute("href");
//                    if (StrLink != null && StrLink.contains("/images/search?")) {
//                        getPageLinks(StrLink, depth); //Disable untill we can get first page to downlaod
//                    }
//                }
//           }
        }

    }

}

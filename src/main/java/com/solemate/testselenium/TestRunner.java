/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solemate.testselenium;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import static org.openqa.grid.common.SeleniumProtocol.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Paul
 */
public class TestRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, URISyntaxException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Paul\\Documents\\Crawl\\chromedriver.exe");
        //String url = "https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-safari-driver";
        //String url = "https://www.jordan.com/collection/air-jordan-18";
        //String url = "http://www.adidas.com/us/men-running-shoes";
        //String url = "https://www.goat.com/sneakers/air-jordan-6-cny-aa2492-021";
        //String url = "https://www.reddit.com/";
        //String url = "https://gizmodo.com/";
        String url = "https://www.google.com/search?tbm=isch&source=hp&biw=1280&bih=590&ei=Rx6sWvqzAqmb_QbXoo7QCg&q=jordan+3&oq=jordan+3&gs_l=img.3..0l10.657.7766.0.7926.35.25.8.2.2.0.165.1599.15j5.20.0....0...1ac.1.64.img..5.30.1667.0..35i39k1j0i10k1.0.Ex35RAhYWNo";
        //String url = "https://www.bing.com/images/search?q=jordan+3&qs=n&form=QBILPG&sp=-1&pq=jordan+3&sc=8-8&cvid=BC11D1A2D2384B61B88A11176E08FEF9&first=1&cw=1263&ch=590";
        //TODO 
        //Create header to comply with robots.txt
        //create pause/wait function for scraping/downlaoding

        System.out.println("*******************");
       // WebDriver webDriver = new ChromeDriver();

        GetAllUrlLinks current = new GetAllUrlLinks();
        current.getPageLinks(url, 0);
        //ystem.out.println(current.getlinks());       
        //current.numOfLinks();
        System.out.println("*************");
//
//        webDriver.close();
//        webDriver.quit();
    }

}

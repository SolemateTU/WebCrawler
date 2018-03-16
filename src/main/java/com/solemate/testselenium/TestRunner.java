/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solemate.testselenium;

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
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Paul\\Documents\\Crawl\\chromedriver.exe");
        //String url = "https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-safari-driver";
        //String url = "https://www.jordan.com/collection/air-jordan-18";
        //String url = "http://www.adidas.com/us/men-running-shoes";
        //String url = "https://www.goat.com/sneakers/air-jordan-6-cny-aa2492-021";
        String url = "https://www.reddit.com/";
        //String url = "https://gizmodo.com/";
        //WebDriver page = new ChromeDriver();

        // Navigate to URL
        //page.get(url);

        //WebElement table = page.findElement(By.xpath("//*[@id=\"landinghero\"]/div[1]/div[2]/div/div/div[1]/div[20]/div/div/div/div[1]/img"));
        //List<WebElement> list_of_url = table.findElements(By.tagName("img"));

        // Read page content
        //String content = page.getPageSource();
        System.out.println("*******************");
        GetAllUrlLinks current = new GetAllUrlLinks();
        current.getPageLinks(url, 0);
        System.out.println(current.getlinks());
        
        //current.numOfLinks();
        System.out.println("*************");
        // Print the page content
        //System.out.println(content);

        // Close driver
        //page.quit();

    }

}


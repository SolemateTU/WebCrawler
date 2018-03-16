/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solemate.testselenium;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
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

    public GetAllUrlLinks() {
        links = new HashSet<>();

    }

    public void getPageLinks(String URL, int depth) {
        if ((!links.contains(URL) && (depth < MAX_DEPTH))) {
            System.out.println(">> Depth: " + depth + " [" + URL + "]");
            links.add(URL);
            WebDriver webDriver = new ChromeDriver();
            webDriver.get(URL);
            //GET THE URLs
            //List<WebElement> listOfLinks = webDriver.findElements(By.xpath("//a"));
            List<WebElement> listOfLinks = webDriver.findElements(By.xpath("//*[@id=\"thing_t3_84pgkp\"]/div[2]/div[1]/p[1]/a"));
            System.out.println(listOfLinks.toString());
            depth++;
            System.out.println("depth incremented: " + depth);
            for (WebElement link : listOfLinks) {
                getPageLinks(link.getAttribute("abs:href"), depth);
            }
            webDriver.close();
            webDriver.quit();
        }

    }
    
    public HashSet <String> getlinks(){
        return links;
    }
}

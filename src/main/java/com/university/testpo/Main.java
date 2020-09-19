package com.university.testpo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        StartPage startPage = new StartPage();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\semenovea\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(startPage.getUrl());

    }
}

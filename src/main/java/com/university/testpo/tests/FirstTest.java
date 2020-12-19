package com.university.testpo.tests;

import com.university.testpo.pages.StartPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    private static Properties property = new Properties();
    private static WebDriver driver;
    private static StartPage startPage;
    private static String email;
    private static String password;


    @BeforeClass
    public static void setup() {
        try(FileInputStream fis = new FileInputStream("src/main/resources/conf.properties")){
            property.load(new InputStreamReader(fis, Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        email = property.getProperty("login");
        password = property.getProperty("password");
        String chromedriver = property.getProperty("chromedriver");
        System.setProperty("webdriver.chrome.driver", chromedriver);

        driver = new ChromeDriver();
        startPage = new StartPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(StartPage.URL);
    }

    @Test
    public void loginTest() throws InterruptedException {
        startPage.login(email, password);
        Assert.assertEquals(startPage.getName(), property.getProperty("name"));
    }

    @AfterClass
    public static void exit()
    {
        driver.quit();
    }

}

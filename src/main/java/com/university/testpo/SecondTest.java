package com.university.testpo;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SecondTest {
    private static Properties property = new Properties();
    private static WebDriver driver;
    private static StartPage startPage;
    private static ProfilePage profilePage;
    private static String chromedriver;
    private static String city;
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
        city = property.getProperty("city");
        chromedriver = property.getProperty("chromedriver");
        System.setProperty("webdriver.chrome.driver", chromedriver);

        driver = new ChromeDriver();
        startPage = new StartPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(StartPage.URL);
    }

    @Test
    public void changeCityTest() throws InterruptedException {
        startPage.clickFirstLoginBtn();
        startPage.inputLogin(email);
        startPage.inputPasswd(password);
        Thread.sleep(10000);
        startPage.clickSecondLoginBtn();

        startPage.clickCityBtn();
        startPage.clickCityChangeBtn(city);
        Assert.assertEquals(startPage.getCity(), city);


        startPage.clickHeaderUserNameBtn();
        startPage.clickProfileBtn();
        Assert.assertEquals(profilePage.getDeliveryAddress(), profilePage.getCurrentCityityName());


    }

    @AfterClass
    public static void Exit()
    {
        driver.quit();
    }
}

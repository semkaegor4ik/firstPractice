package com.university.testpo.tests;

import com.university.testpo.pages.ProfilePage;
import com.university.testpo.pages.StartPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class SecondTest {
    private static final Properties property = new Properties();
    private static WebDriver driver;
    private static StartPage startPage;
    private static ProfilePage profilePage;
    private final String city;
    private static String email;
    private static String password;

    public SecondTest(String city) {
        this.city = city;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> GetParams()
    {
        return Arrays.asList(new Object[][]{
                { "Абакан" }, { "Балаково" }, { "Самара" },{ "Белгород" }
        });
    }



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
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(StartPage.URL);
    }

    @Test
    public void changeCityTest() throws InterruptedException {
        startPage.login(email, password);

        startPage.changeCity(city);
        Assert.assertEquals(startPage.getCity(), city);
        startPage.openProfile();
        try {
            Assert.assertEquals(profilePage.getDeliveryAddress(), profilePage.getCurrentCityityName());
        }
        catch (ComparisonFailure ex){
            ex.getStackTrace();
        }
        finally {
            startPage.exetFromAccount();
        }
    }

    @AfterClass
    public static void Exit()
    {
        driver.quit();
    }
}

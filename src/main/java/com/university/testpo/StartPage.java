package com.university.testpo;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class StartPage{
    public static final String URL = "https://www.citilink.ru/";

    public WebDriver driver;

    @FindBy(xpath = "/html/body/div[3]/div[2]/header/div[2]/div[2]/div[2]/div/div[6]")
    private WebElement firstLoginBtn;
    @FindBy(xpath = "//*[@id=\"authorization_popup\"]/div[1]/form/div[4]/div[1]/button")
    private WebElement secondLoginBtn;
    @FindBy(xpath = "//*[@id=\"authorization_popup\"]/div[1]/form/div[1]/div/label")
    private WebElement loginField;
    @FindBy(xpath = "//*[@id=\"authorization_popup\"]/div[1]/form/div[2]/div/label")
    private WebElement passwdField;

    @FindBy(xpath = "/html/body/div[3]/div[2]/header/div[2]/div[2]/div[2]/div/div[6]/div[1]/div/div[1]/div/div[2]")
    private WebElement name;

    @FindBy(className = "MainHeader__city")
    private WebElement cityButton;
    @FindBy(xpath = "/html/body/div[3]/div[2]/header/div[1]/div[2]/div[1]/div[6]/div[2]/div/div/div/div[3]/div[2]/ul/li[1]/a")
    private WebElement newCity;


    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }
    public void clickFirstLoginBtn() {
        firstLoginBtn.click();
    }
    public void clickSecondLoginBtn() {
        secondLoginBtn.click();
    }

    public String getName() {
        return name.getText();
    }

    public void clickCityBtn() {
        cityButton.click();
    }
    public void clickCityChangeBtn() {
        newCity.click();
    }
    public String getCity() {
        return cityButton.getText();
    }

}

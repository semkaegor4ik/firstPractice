package com.university.testpo;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class StartPage{
    public static final String URL = "https://www.citilink.ru/";

    public WebDriver driver;

    @FindBy(className = "AuthPopup")
    private WebElement firstLoginBtn;
    @FindBy(className = "SignIn__actions")
    private WebElement secondLoginBtn;
    @FindBy(name = "login")
    private WebElement loginField;
    @FindBy(name = "pass")
    private WebElement passwdField;

    @FindBy(className = "HeaderUserName__name")
    private WebElement name;

    @FindBy(className = "MainHeader__city")
    private WebElement cityButton;

    private WebElement newCity;

    @FindBy(partialLinkText = "Мой профиль")
    private WebElement profile;

    @FindBy(partialLinkText = "Выйти")
    private WebElement exit;

    @FindBy(className = "HeaderUserName")
    private WebElement headUsername;



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

    public void clickCityChangeBtn(String cityName) {
        newCity = driver.findElement(By.partialLinkText(cityName));
        newCity.click();
    }
    public void clickProfileBtn() {
        profile.click();
    }

    public void clickExitBtn(){
        exit.click();
    }

    public void clickHeaderUserNameBtn(){
        headUsername.click();
    }

    public String getCity() {
        return cityButton.getText();
    }

}

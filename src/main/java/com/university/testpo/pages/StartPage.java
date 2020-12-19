package com.university.testpo.pages;

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

    @FindBy(partialLinkText = "Каталог товаров")
    private WebElement catalog;

    @FindBy(partialLinkText = "Красота и здоровье")
    private WebElement beauty;

    @FindBy(partialLinkText = "Зубные щетки")
    private WebElement toothBrushes;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public String getName() {
        return name.getText();
    }
    public String getCity() {
        return cityButton.getText();
    }

    public void login(String email, String password) throws InterruptedException {
        firstLoginBtn.click();
        loginField.sendKeys(email);
        passwdField.sendKeys(password);
        Thread.sleep(10000);
        secondLoginBtn.click();
    }

    public void changeCity(String city) {
        cityButton.click();
        newCity = driver.findElement(By.partialLinkText(city));
        newCity.click();
    }

    public void openProfile() {
        headUsername.click();
        profile.click();
    }

    public void exetFromAccount() {
        headUsername.click();
        exit.click();
    }
}

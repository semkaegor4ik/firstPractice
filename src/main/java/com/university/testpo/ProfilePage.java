package com.university.testpo;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class ProfilePage {
    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "delivery_address")
    private WebElement deliveryAddress;

    @FindBy(className = "MainHeader__city")
    private WebElement currentCity;

    public String getDeliveryAddress(){
        return deliveryAddress.getText().split(",")[0];                     //could take the cityname only from here
    }

    public String getCurrentCityityName(){
        return currentCity.getText();
    }

}

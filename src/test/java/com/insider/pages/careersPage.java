package com.insider.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class careersPage extends BasePage {

    @FindBy(xpath = "//section[@id='career-find-our-calling']/div/div/div[2]/div")
    public List<WebElement> teams;

    @FindBy(className = "location-info")
    public List<WebElement> locations;

    @FindBy(xpath = "//div[starts-with(@aria-label, 'life-at-insider-')]")
    public List<WebElement> lifeAtInsider;

    @FindBy(xpath = "//h3[contains(text(),'Find your calling')]")
    public WebElement findYourCallingHeader;

    @FindBy(xpath = "//h3[contains(text(),'Our Locations')]")
    public WebElement ourLocationsHeader;

    @FindBy(xpath = "//h3[contains(text(),'Our Locations')]")
    public WebElement lifeAtInsiderHeader;

}

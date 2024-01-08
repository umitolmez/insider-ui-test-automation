package com.insider.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends BasePage{

    @FindBy(partialLinkText = "Get a Demo")
    public WebElement getADemo;

    @FindBy(xpath = "//a[@href='/']/img")
    public WebElement logo;
}

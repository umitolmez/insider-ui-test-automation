package com.insider.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class qualityAssurancePage extends BasePage{

    @FindBy(linkText = "See all QA jobs")
    public WebElement seeAllQAJobsBtn;
}

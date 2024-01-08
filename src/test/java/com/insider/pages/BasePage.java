package com.insider.pages;

import com.insider.utils.BrowserUtils;
import com.insider.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateToPage(String dropdown, String page){
        WebElement dropdownElement = Driver.get().findElement(
                By.xpath("//*[contains(text(), '"+ dropdown +"')]"));

        dropdownElement.click();

        WebElement pageElement = Driver.get().findElement(By.linkText(page));

        BrowserUtils.waitForClickablity(pageElement, 4);
        pageElement.click();
    }

    public void navigateToPage(String dropdown){
        WebElement dropdownElement = Driver.get().findElement(
                By.xpath("//*[contains(text(), '"+ dropdown +"')]"));

        dropdownElement.click();
    }

    public void allElementsDisplayed(List<WebElement> elements){
        for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed(), "Element is not visible");
        }
    }

    public void allElementsContains(List<WebElement> elements, String text){
        for (WebElement element : elements) {
            String actualText = element.getText();
            Assert.assertTrue(actualText.contains(text),
                    "Expected :"+ text +". Actual: " + actualText);
        }
    }

    public void acceptCookies(){
        WebElement acceptBtn = Driver.get().findElement(By.id("wt-cli-accept-all-btn"));

        BrowserUtils.waitForClickablity(acceptBtn, 4);

        acceptBtn.click();
    }
}

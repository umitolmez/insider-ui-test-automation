package com.insider.pages;

import com.insider.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.insider.utils.BrowserUtils.selectOptionByVisibleText;

public class openPositionsPage extends BasePage{

    @FindBy(name ="filter-by-location")
    public WebElement filterByLocationDropdown;
    @FindBy(id="select2-filter-by-location-container")
    public WebElement filterByLocationField;

    @FindBy(id = "filter-by-department")
    public WebElement filterByDepartmentDropdown;
    @FindBy(id = "select2-filter-by-department-container")
    public WebElement filterByDepartmentField;

    @FindBy(xpath = "//div[@id='jobs-list']/div")
    public List<WebElement> jobList;

    @FindBy(xpath = "//div[@id='jobs-list']/div/div/p")
    public List<WebElement> positionTitle;
    @FindBy(xpath = "//div[@id='jobs-list']/div/div/span")
    public List<WebElement> positionDepartment;
    @FindBy(xpath = "//div[@id='jobs-list']/div/div/div")
    public List<WebElement> positionLocation;

    @FindBy(linkText = "View Role")
    public WebElement viewRoleBtn;

    @FindBy(xpath = "//h3[contains(text(),'Browse')]")
    public WebElement openPositionsHeader;


    public void filterByLocation(String option){
        try {
            selectOptionByVisibleText(filterByLocationDropdown, option);
        }catch (ElementNotInteractableException e){
            filterByLocationField.click();
            Driver.get().findElement(
                    By.xpath("//li[contains(text(), '"+ option +"')]"))
                    .click();
        }
    }

    public void filterByDepartment(String option){
        try {
            selectOptionByVisibleText(filterByDepartmentDropdown, option);
        }catch (ElementNotInteractableException e){
            filterByDepartmentField.click();
            Driver.get().findElement(
                            By.xpath("//li[contains(text(), '"+ option +"')]"))
                    .click();
        }
    }
}

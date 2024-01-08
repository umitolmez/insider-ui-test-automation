package com.insider.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

public class BrowserUtils {

    /**
     * takes screenshot
     *
     * @param name
     * take a name of a test and returns a path to screenshot takes
     */
    public static String getScreenshot(String name) throws IOException {
        // name the screenshot with the current date time to avoid duplicate name
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        // TakesScreenshot ---> interface from selenium which takes screenshots
        TakesScreenshot ts = (TakesScreenshot) Driver.get();
        File source = ts.getScreenshotAs(OutputType.FILE);

        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);

        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);

        return target;
    }

    /**
     * Selects an option from a dropdown menu based on its visible text if dropdown has Select class.
     *
     * @param dropdownElement The WebElement representing the dropdown menu.
     * @param option The visible text of the option to be selected.
     */
    public static void selectOptionByVisibleText(WebElement dropdownElement, String option){
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(option);

    }

    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for the provided element to be clickable on the page
     */
    public static void waitForClickablity(WebElement element, int timeToWait) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for the provided element to be visible on the page
     */
    public static void waitForVisibility(WebElement element, int timeToWait) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Performs hover over action
     */
    public static void hoverOver(WebElement element) {
        Actions action = new Actions(Driver.get());
        action.moveToElement(element).perform();
    }

    /**
     * Scroll to given element until visible
     * @param element web element
     */
    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Switches to new window. Does not return to original window if target founded
     */
    public static void switchToWindow() {
        String currentWindowHandle = Driver.get().getWindowHandle();

        Set<String> windowHandles = Driver.get().getWindowHandles();

        for (String handle : windowHandles) {

            if (!handle.equals(currentWindowHandle)) {
                Driver.get().switchTo().window(handle);
            }
        }
    }
}

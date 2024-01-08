package com.insider.tests;

import com.insider.pages.careersPage;
import com.insider.pages.homePage;
import com.insider.pages.openPositionsPage;
import com.insider.pages.qualityAssurancePage;
import com.insider.utils.BrowserUtils;
import com.insider.utils.ConfigurationReader;
import com.insider.utils.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class jobApplicationTest extends TestBase{

    homePage homePage = new homePage();
    careersPage careersPage = new careersPage();
    qualityAssurancePage qaPage= new qualityAssurancePage();
    openPositionsPage openPositionspage = new openPositionsPage();

    @Test
    public void scenario1() {
        extentLogger= report.createTest("task");

        navigateToHomePage();
        navigateToPage();
        filterJobs();
        checkJobFilterResult();
        viewRole();
    }

    private void navigateToHomePage(){
        extentLogger.info("navigate to URL");
        Driver.get().get(ConfigurationReader.get("url"));
        homePage.acceptCookies();

        extentLogger.info("verify that Insider home page is opened or not");
        Assert.assertEquals(Driver.get().getCurrentUrl(), ConfigurationReader.get("url"));

        BrowserUtils.waitForVisibility(homePage.logo, 2);
        Assert.assertTrue(homePage.logo.isDisplayed());
        Assert.assertTrue(homePage.getADemo.isDisplayed());
    }

    private void navigateToPage(){
        extentLogger.info("Select the Company menu in the navigation bar, select Careers");
        homePage.navigateToPage("Company", "Careers");

        extentLogger.info("check Career page, its Locations, Teams, and Life at Insider blocks are open or not");
        Assert.assertEquals(Driver.get().getCurrentUrl(), "https://useinsider.com/careers/");

        BrowserUtils.scrollToElement(careersPage.findYourCallingHeader);
        Assert.assertFalse(careersPage.teams.isEmpty());

        BrowserUtils.scrollToElement(careersPage.ourLocationsHeader);
        Assert.assertFalse(careersPage.locations.isEmpty());

        BrowserUtils.scrollToElement(careersPage.lifeAtInsiderHeader);
        Assert.assertFalse(careersPage.lifeAtInsider.isEmpty());
    }

    private void filterJobs() {
        extentLogger.info("Go to https://useinsider.com/careers/quality-assurance/");
        Driver.get().get("https://useinsider.com/careers/quality-assurance/");

        extentLogger.info("click See all QA jobs");
        qaPage.seeAllQAJobsBtn.click();

        extentLogger.info("filter jobs by Location: Istanbul, Turkey, and Department: Quality Assurance");
        openPositionspage.filterByLocation("Istanbul, Turkey");
        openPositionspage.filterByDepartment("Quality Assurance");

        extentLogger.info("check the presence of the job list");
        BrowserUtils.scrollToElement(openPositionspage.openPositionsHeader);
        BrowserUtils.waitFor(1);
        openPositionspage.allElementsDisplayed(openPositionspage.jobList);
    }

    private void checkJobFilterResult(){
        //this step will fail based on scenario
        extentLogger.info("Check that all jobs' Position contains Quality Assurance");
        openPositionspage.allElementsContains(openPositionspage.positionTitle, "Quality Assurance");

        extentLogger.info("Check that all jobs' Department contains Quality Assurance");
        openPositionspage.allElementsContains(openPositionspage.positionDepartment, "Quality Assurance");

        extentLogger.info("Check that all jobs' Location contains Istanbul, Turkey");
        openPositionspage.allElementsContains(openPositionspage.positionLocation, "Istanbul, Turkey");
    }

    private void viewRole(){
        extentLogger.info("Click the View Role button");
        BrowserUtils.hoverOver(openPositionspage.jobList.get(0));
        openPositionspage.viewRoleBtn.click();

        extentLogger.info("check that this action redirects us to the Lever Application form page");
        BrowserUtils.switchToWindow();

        Assert.assertTrue(Driver.get().getCurrentUrl().startsWith("https://jobs.lever.co/useinsider/"));
    }

}

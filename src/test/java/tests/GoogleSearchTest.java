package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GooglePage;

public class GoogleSearchTest extends BaseTest {

    @Test(description = "Verify Google search returns results")
    public void testGoogleSearch() {
        GooglePage googlePage = new GooglePage(driver);
        googlePage.open();
        googlePage.search("Selenium automation testing");

        Assert.assertTrue(
            googlePage.isResultDisplayed(),
            "Search results should be displayed"
        );
    }

    @Test(description = "Verify page title contains search term")
    public void testPageTitle() {
        GooglePage googlePage = new GooglePage(driver);
        googlePage.open();
        googlePage.search("QA Engineer");

        Assert.assertTrue(
            googlePage.getTitle().contains("QA Engineer"),
            "Page title should contain search term"
        );
    }
}

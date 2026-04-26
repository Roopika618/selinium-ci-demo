package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GooglePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By searchBox = By.name("q");
    private By searchResults = By.id("search");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.google.com");
    }

    public void search(String keyword) {
        WebElement box = wait.until(
            ExpectedConditions.visibilityOfElementLocated(searchBox)
        );
        box.sendKeys(keyword);
        box.submit();
    }

    public boolean isResultDisplayed() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(searchResults)
        ).isDisplayed();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}

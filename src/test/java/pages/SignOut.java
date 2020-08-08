package pages;

import basic.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignOut extends PageObject {
    public SignOut(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, 25);
    By settingsClick = By.cssSelector(".icon-hamburger-animated");
    By signOutClick = By.xpath("//a[text()='Sign out']");
    By getTitle = By.tagName("h1");
    public String title, welcomPage;

    public void signOut() {

        wait.until(ExpectedConditions.elementToBeClickable(settingsClick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(signOutClick)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getTitle));

        title = driver.findElement(getTitle).getText();
        String lines[] = title.split("\\r?\\n");
        welcomPage = lines[0] + lines[1] + lines[2];

    }
}

package pages;

import basic.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn extends PageObject {
    public SignIn(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, 25);
    By loginLinkClick = By.xpath("//*[contains(text(),' Sign in')]");
    By userEmailClick = By.cssSelector(".btn.btn-link");
    By userEmailField = By.name("email");
    By nextClick = By.cssSelector(".btn.btn-xl.btn-success");
    By passField = By.name("password");
    By getTitle = By.tagName("h1");
    public String title, welcomPage;

    public void signIn(String url, String emailAdd, String password) throws InterruptedException {

        driver.get(url);
        WebElement element = driver.findElement(loginLinkClick);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        wait.until(ExpectedConditions.elementToBeClickable(userEmailClick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userEmailField)).sendKeys(emailAdd);
        wait.until(ExpectedConditions.elementToBeClickable(nextClick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(passField)).sendKeys(password);

        Thread.sleep(1500);
        driver.findElement(nextClick).click();
        Thread.sleep(5000);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(1500);

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.manage().window().maximize();
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(getTitle)).getText();
        String lines[] = title.split("\\r?\\n");
        welcomPage = lines[0];
    }
}

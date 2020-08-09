package pages;

import basic.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailAccountCreation extends PageObject {
    public EmailAccountCreation(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, 25);
    By loginLinkClick = By.xpath("//*[contains(text(),' Sign in')]");
    By userEmailClick = By.cssSelector(".btn.btn-link");
    By userEmailField = By.name("email");
    By nextClick = By.cssSelector(".btn.btn-xl.btn-success");
    By settingsClick = By.cssSelector(".icon-hamburger-animated");
    By profileClick = By.xpath("//a[@href='/user/profile/']");
    By firstNameField = By.name("user[firstname]");
    By lastNameField = By.name("user[lastname]");
    By saveButtonClick = By.cssSelector("button.btn.btn-lg.btn-success");
    By updatePasswordClick = By.xpath("//a[@href='/user/password/']");
    By updatePasswordField = By.name("user[password]");
    By confirmPasswordField = By.name("user[passwordConfirm]");
    By getTitle = By.cssSelector(".alert.alert-dismissable.alert-success");
    public String title, getPasswordUpdateTitle;

    public void accountCreation(String url, String emailAdd, String firstName, String lastName, String password)
            throws InterruptedException {

        driver.get(url);
        WebElement element = driver.findElement(loginLinkClick);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        wait.until(ExpectedConditions.elementToBeClickable(userEmailClick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userEmailField)).sendKeys(emailAdd);
        wait.until(ExpectedConditions.elementToBeClickable(nextClick)).click();
        Thread.sleep(5000);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(2000);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.findElement(settingsClick).click();
        wait.until(ExpectedConditions.elementToBeClickable(profileClick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(firstNameField)).sendKeys(firstName);
        wait.until(ExpectedConditions.elementToBeClickable(lastNameField)).sendKeys(lastName);
        wait.until(ExpectedConditions.elementToBeClickable(saveButtonClick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(updatePasswordClick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(updatePasswordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(confirmPasswordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(saveButtonClick)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getTitle));

        title = driver.findElement(getTitle).getText();
        String splitData[] = title.split("\\s", 2);
        getPasswordUpdateTitle = splitData[1];

    }
}

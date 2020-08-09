package pages;

import basic.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class PastBookCreation extends PageObject {
    public PastBookCreation(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, 25);
    public String readMessage;
    By titleFiled = By.name("title");
    By createClick = By.id("create-button");
    By uploadClick = By.xpath("//a[text()='Upload your pictures']");
    By selectFilesClick = By.xpath("//input[@type='file']");
    By fileSystemClick = By.cssSelector("span.fsp-source-list__icon.fsp-icon.fsp-icon--local_file_system");
    By uploadBtnClick = By.xpath("//span[text()=' Upload ']");
    By continueClick = By.cssSelector("button.bb-action.btn.btn-success");
    By imageClick = By.xpath("//img[contains(@src,'/assets/img/books/moment-minimized.png')]");
    By openBookClick = By.cssSelector("button.btn.btn-primary.btn-lg");
    By pageFlipClick = By.cssSelector("span.icon-arrow-left");
    By getTitles = By.xpath("//div[@class='quick-link-cover-title hidden-xs']");

    public void addPastBook(String title, String file1, String file2) throws InterruptedException {

        Thread.sleep(6000);
        driver.findElement(titleFiled).sendKeys(title);
        wait.until(ExpectedConditions.elementToBeClickable(createClick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(uploadClick)).click();

        Thread.sleep(4000);
        WebElement elementTest1 = driver.findElement(selectFilesClick);
        File fileOne = new File(file1);
        elementTest1.sendKeys(fileOne.getAbsolutePath());

        wait.until(ExpectedConditions.elementToBeClickable(fileSystemClick)).click();
        Thread.sleep(4000);

        WebElement elementTest2 = driver.findElement(selectFilesClick);
        File fileTwo = new File(file2);
        elementTest2.sendKeys(fileTwo.getAbsolutePath());
        wait.until(ExpectedConditions.elementToBeClickable(uploadBtnClick)).click();

        Thread.sleep(15000);
        WebElement imageSelection = wait.until(ExpectedConditions.elementToBeClickable(imageClick));
        imageSelection.click();
        Thread.sleep(6000);
        driver.findElement((continueClick)).click();

        wait.until(ExpectedConditions.elementToBeClickable(openBookClick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pageFlipClick)).click();

        Thread.sleep(3000);

        WebElement element = driver.findElement(getTitles);
        readMessage= (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", element);
        Thread.sleep(2000);
    }
}

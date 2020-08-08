package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class FunctionalTest {

    public static WebDriver driver;


    @BeforeClass
    public void baseSetup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver 11");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

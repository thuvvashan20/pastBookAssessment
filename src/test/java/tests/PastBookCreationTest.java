package tests;

import basic.FunctionalTest;
import basic.ReadFileData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PastBookCreation;
import pages.SignIn;
import pages.SignOut;

public class PastBookCreationTest extends FunctionalTest {
    private static ReadFileData data = new ReadFileData();
    SignIn pastBookLogin = null;
    SignOut pastBookLogout = null;
    PastBookCreation pastBook = null;
    String filePath1 = "/Users/thuvvareka/Documents/gapstar_assessment/src/test/java/files/pic1.jpeg";
    String filePath2 = "/Users/thuvvareka/Documents/gapstar_assessment/src/test/java/files/pic2.png";

    @BeforeClass
    public void base() {
        data.readPropertiesFile();
        pastBookLogin = new SignIn(driver);
        pastBookLogout = new SignOut(driver);
        pastBook = new PastBookCreation(driver);
    }

    @BeforeClass
    public void signIn() {
        try {
            pastBookLogin.signIn(data.getPropertyValue("url"), data.getPropertyValue("email_address"),
                    data.getPropertyValue("password"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void emailAccountCreationTest() throws InterruptedException {

        pastBook.addPastBook(data.getPropertyValue("title"), filePath1, filePath2);

    }
}

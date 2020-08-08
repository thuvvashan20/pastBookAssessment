package tests;

import basic.FunctionalTest;
import basic.ReadFileData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EmailAccountCreation;
import pages.SignOut;

public class EmailAccountCreationTest extends FunctionalTest {
    private static ReadFileData data = new ReadFileData();
    EmailAccountCreation pastBook = null;
    SignOut pastBookLogout = null;

    @BeforeClass
    public void base() {
        data.readPropertiesFile();
        pastBook = new EmailAccountCreation(driver);
        pastBookLogout = new SignOut(driver);
    }

    @Test
    public void emailAccountCreationTest() throws InterruptedException {

        pastBook.accountCreation(data.getPropertyValue("url"), data.getPropertyValue("email_address"),
                data.getPropertyValue("first_name"), data.getPropertyValue("last_name"),
                data.getPropertyValue("password"));
        Assert.assertEquals(pastBook.getPasswordUpdateTitle, "Password updated!");
    }

    @Test
    public void signOutTest() {

        pastBookLogout.signOut();
        Assert.assertEquals(pastBookLogout.welcomPage, "Create beautiful photo albums,together with your " +
                "friends.Hassle-free.");
    }
}

package tests;

import basic.FunctionalTest;
import basic.ReadFileData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SignIn;

public class SignInTest extends FunctionalTest {

    private static ReadFileData data = new ReadFileData();
    SignIn pastBook = null;

    @BeforeClass
    public void base() {
        data.readPropertiesFile();
        pastBook = new SignIn(driver);

    }

    @Test
    public void emailAccountCreationTest() throws InterruptedException {

        pastBook.signIn(data.getPropertyValue("url"), data.getPropertyValue("email_address"),
                data.getPropertyValue("password"));
        Assert.assertEquals(pastBook.welcomPage, "Create your PastBook in 1 minute!");

    }
}

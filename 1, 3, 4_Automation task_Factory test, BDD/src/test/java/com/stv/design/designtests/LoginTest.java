package com.stv.design.designtests;

import com.stv.design.designpages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BasicTest {

    @Test(description = "Assert the login page is loaded and the email field is visible")
    public void assertEmailFieldIsDisplayed() {
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(loginPage.isEmailFieldDisplayed(), true, "The email field isn't displayed");
    }

    @Test(description = "Assert the password field is visible")
    public void assertPasswordFieldIsDisplayed() {
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(loginPage.isPasswordFieldDisplayed(), true, "The password field isn't displayed");
    }

    @Test(description = "Assert the login button is visible")
    public void assertLoginButtonIsDisplayed() {
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(loginPage.isLoginButtonDisplayed(), true, "The login button isn't displayed");
    }


}
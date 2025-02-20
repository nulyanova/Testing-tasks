package com.stv.design.designtests;

import com.stv.design.designpages.LoginPage;
import com.stv.design.designpages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BasicTest {

    @Test(description = "Assert the main page is loaded and the main logo is visible")
    public void assertParaBankIconIsDisplayed() {
        MainPage mainPage = new MainPage();
        Assert.assertEquals(mainPage.isMainLogoDisplayed(), true, "The main page isn't loaded properly");
    }

    @Test(description = "Navigate to the login page and assert the email field is visible")
    public void navigateToLoginPage() {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = mainPage.clickOnLoginLink(); // Переход на страницу логина
        Assert.assertTrue(loginPage.isEmailFieldDisplayed(), "The login page isn't loaded properly");
    }
}

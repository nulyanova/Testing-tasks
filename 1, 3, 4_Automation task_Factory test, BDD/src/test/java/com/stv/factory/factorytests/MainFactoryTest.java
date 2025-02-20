package com.stv.factory.factorytests;

import com.stv.factory.factorypages.LoginFactoryPage;
import com.stv.factory.factorypages.MainFactoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.stv.framework.core.utils.Waiters.waitForElementVisible;

// наследуется от BasicFactoryTest
public class MainFactoryTest extends BasicFactoryTest {
    MainFactoryPage mainFactoryPage = new MainFactoryPage();

    // Тест 1: Проверка, что главная страница загружена и виден основной логотип
    @Test(description = "Assert the main page is loaded and main logo is visible")
    public void assertMainLogoIsDisplayed() {
        boolean actualResult = mainFactoryPage.isMainLogoDisplayed();
        Assert.assertEquals(actualResult, true, "Main Logo isn't visible");
    }

    // Тест 2: Проверка, что панель навигации загружена
    @Test(description = "Assert the Navigation panel is loaded", dependsOnMethods = "assertMainLogoIsDisplayed")
    public void assertAdminPanelOpened() {
        waitForElementVisible(getDriver(), Duration.ofSeconds(2), mainFactoryPage.getNavigationPanel());
        Assert.assertEquals(mainFactoryPage.isNavigationPanelDisplayed(), true, "Admin panel isn't visible");
    }

    // Тест 3: Переход на страницу входа и проверка видимости поля для ввода email
    @Test(description = "Navigate to the login page and assert the email field is visible")
    public void navigateToLoginPage() {
        LoginFactoryPage loginFactoryPage = mainFactoryPage.clickOnLoginLink(); // Переход на страницу логина
        Assert.assertTrue(loginFactoryPage.isEmailFieldDisplayed(), "The login page isn't loaded properly");
    }
}
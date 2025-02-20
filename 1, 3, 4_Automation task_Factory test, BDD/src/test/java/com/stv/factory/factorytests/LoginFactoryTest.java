// тестовый класс LoginFactoryTest для проверки страницы входа
package com.stv.factory.factorytests;

import com.stv.design.designtests.BasicTest;
import com.stv.factory.factorypages.LoginFactoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

// наследуется от BasicFactoryTest
public class LoginFactoryTest extends BasicTest {
    // Тест 1: Проверка, что страница входа загружена и видимо поле для ввода email
    @Test(description = "Assert the login page is loaded and the email field is visible")
    public void assertEmailFieldIsDisplayed() {
        LoginFactoryPage loginFactoryPage = new LoginFactoryPage();
        Assert.assertEquals(loginFactoryPage.isEmailFieldDisplayed(), true, "The email field isn't displayed");
    }
    // Тест 2: Проверка, что поле для ввода пароля видимо
    @Test(description = "Assert the password field is visible")
    public void assertPasswordFieldIsDisplayed() {
        LoginFactoryPage loginFactoryPage = new LoginFactoryPage();
        Assert.assertEquals(loginFactoryPage.isPasswordFieldDisplayed(), true, "The password field isn't displayed");
    }
    // Тест 3: Проверка, что кнопка входа видима
    @Test(description = "Assert the login button is visible")
    public void assertLoginButtonIsDisplayed() {
        LoginFactoryPage loginFactoryPage = new LoginFactoryPage();
        Assert.assertEquals(loginFactoryPage.isLoginButtonDisplayed(), true, "The login button isn't displayed");
    }
}


// метод getEmailFieldValue(), который возвращает текст из поля email.
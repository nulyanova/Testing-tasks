// класс LoginFactoryPage представляет собой страницу входа и содержит методы для взаимодействия с элементами на этой странице
package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.stv.framework.core.drivers.MyDriver.driver;

public class LoginFactoryPage extends FactoryPage {

    @FindBy(css = "#username")
    private WebElement emailField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "#login-submit")
    private WebElement loginButton;

    @FindBy(css = ".forgot-password") // Локатор для ссылки на страницу логина
    private WebElement forgotPasswordLink;

    @FindBy(css = ".uHkM6")//Accept All Cookies
    private WebElement acceptAllCookiesCheckbox;

    private WebDriverWait wait;

    public LoginFactoryPage() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // метод проверяет, видим ли элемент для принятия cookies, и если он не выбран, то кликает на него.
    public void acceptAllCookiesIfVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(acceptAllCookiesCheckbox));
            if (!acceptAllCookiesCheckbox.isSelected()) {
                acceptAllCookiesCheckbox.click();
            }
        } catch (Exception e) {
            System.out.println("Cookies checkbox not found or not visible.");
        }
    }

    // методы проверяют видимость полей для ввода email, пароля и кнопки входа
    public boolean isEmailFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(emailField)).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(passwordField)).isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(loginButton)).isDisplayed();
    }

    // методы позволяют вводить email в поле для ввода и получать значение из этого поля.
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email); // Ввод email
    }

    public String getEmailFieldValue() {
        return wait.until(ExpectedConditions.visibilityOf(emailField)).getAttribute("value"); // Получение значения поля "Email Address"
    }
}
package com.stv.design.designpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends Page {
    private final By EMAIL_FIELD = By.cssSelector("#username");
    private final By PASSWORD_FIELD = By.cssSelector("#password");
    private final By LOGIN_BUTTON = By.cssSelector("#login-submit");
    //   private final By FORGOT_PASSWORD = By.cssSelector(".forgot-password");

    public boolean isEmailFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_FIELD));
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        return passwordField.isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return loginButton.isDisplayed();
    }
}

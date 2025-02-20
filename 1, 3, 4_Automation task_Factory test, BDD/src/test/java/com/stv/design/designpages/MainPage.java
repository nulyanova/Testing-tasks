package com.stv.design.designpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/* Created by tatti on 5/25/2024*/
public class MainPage extends Page {
    private final By IMMOTION_HOSTING_LOGO = By.cssSelector("*[alt ='InMotion Hosting Logo']");
    private final By UP_MENU_SECTION = By.cssSelector("div.upper-menu-section");
    private final By LOGIN_LINK = By.cssSelector(".nav-link.btn-secondary-alt.btn-login"); // Локатор для ссылки на страницу логина

    public boolean isMainLogoDisplayed() {
        WebElement registerLink = getDriver().findElement(IMMOTION_HOSTING_LOGO);
        return registerLink.isDisplayed();
    }

    public MainPage clickOnUpMenuSection() {
        WebElement trustButton = getDriver().findElement(UP_MENU_SECTION);
        trustButton.click();
        return this;
    }
    // Метод для перехода на страницу логина
    public LoginPage clickOnLoginLink() {
        WebElement loginLink = getDriver().findElement(LOGIN_LINK);
        loginLink.click();
        return new LoginPage(); // Возвращаем объект LoginPage
    }
}


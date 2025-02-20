package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.stv.framework.core.drivers.MyDriver.driver;

public class MainFactoryPage extends FactoryPage {
    @FindBy(css = "*[alt ='InMotion Hosting Logo']")
    private WebElement immotionLogo;

    @FindBy(css = ".nav-link.btn-secondary-alt.btn-login") // Локатор для ссылки на страницу логина
    private WebElement loginLink;

    @FindBy(id = "navbarNavDropdown")
    private WebElement navigationPanel;

    @FindBy(xpath = "//button[contains(text(), 'Согласиться с использованием всех файлов cookie')]") // Accept All Cookies
    private WebElement acceptAllCookiesButton;

    private WebDriverWait wait;

    public MainFactoryPage() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getNavigationPanel() {
        return navigationPanel;
    }

    public MainFactoryPage acceptAllCookiesIfVisible() {
        if (acceptAllCookiesButton.isEnabled())
            acceptAllCookiesButton.click();
        return this;
    }

    public boolean isMainLogoDisplayed() {
        acceptAllCookiesIfVisible();
        return immotionLogo.isDisplayed();
    }

    public boolean isNavigationPanelDisplayed() {
        return navigationPanel.isDisplayed();
    }

    // Метод для перехода на страницу логина
    public LoginFactoryPage clickOnLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
        return new LoginFactoryPage(); // Возвращаем LoginFactoryPage
    }
}
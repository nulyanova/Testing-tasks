// Класс LoginSteps представляет реализацию шагов тестов, написанных с использованием Cucumber для страницы входа
package com.stv.ddlFrameworks.steps;

import com.stv.factory.factorypages.LoginFactoryPage;
import com.stv.framework.core.config.Config;
import com.stv.framework.core.drivers.MyDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import static com.stv.framework.core.drivers.MyDriver.driver;

public class LoginSteps {

    private LoginFactoryPage loginFactoryPage;

    @Before
    public void setUp() {
        MyDriver.getDriver();
    }

    @After
    public void tearDown() {
        if (MyDriver.getDriver() != null) {
            MyDriver.getDriver().quit();
            driver = null;
        }
    }

    @Given("I am on the login page") // Открывает страницу входа, используя URL
    public void iAmOnTheLoginPage() {
        driver.get(Config.LOGIN_PAGE_URL);
        loginFactoryPage = new LoginFactoryPage();

    }

    @When("I enter a valid email address {string}") // Вводит указанный email в поле email
    public void iEnterAValidEmailAddress(String email) {
        loginFactoryPage.enterEmail(email); // Ввод email
    }

    @Then("the email address field should contain {string}") // Проверяет, что введенный email отображается в поле email
    public void theEmailAddressFieldShouldContain(String expectedEmail) {
        String actualEmail = loginFactoryPage.getEmailFieldValue(); // Получение значения поля "Email Address"
        Assert.assertEquals(actualEmail, expectedEmail, "The email address field does not contain the expected value.");
    }

    @Then("the AMP Login label should be present and contain the text {string}")
     public void the_amp_login_label_should_be_present_and_contain_the_text(String expectedText) {
        // Находим элемент с надписью AMP Login по его тегу и тексту
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ampLoginLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='AMP Login']")));

        // Проверяем, что элемент с надписью AMP Login отображается на странице
        Assert.assertTrue(ampLoginLabel.isDisplayed(), "AMP Login label is not displayed");

        // Проверяем, что текст элемента совпадает с ожидаемым
        Assert.assertEquals(ampLoginLabel.getText(), expectedText, "AMP Login label text is incorrect");
    }
}
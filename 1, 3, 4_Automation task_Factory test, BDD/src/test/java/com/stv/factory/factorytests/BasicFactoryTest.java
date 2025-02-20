// класс BasicFactoryTest служит базовым тестовым классом,
// который содержит настройки для запуска и завершения тестов с использованием Selenium WebDriver.
package com.stv.factory.factorytests;

import com.stv.framework.core.drivers.MyDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import static com.stv.framework.core.lib.ImmotionPageURLs.START_URL;

public class BasicFactoryTest {
    public static WebDriver getDriver() {
        return MyDriver.getDriver();
    }
    // метод будет выполняться один раз перед запуском всех тестов в классе
    @BeforeClass(description = "Start browser")
    public void setUp() {
        WebDriver driver = getDriver(); // Получается экземпляр WebDriver
        driver.get(START_URL); // Открывается URL
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // неявное ожидание на 15 секунд
        driver.manage().window().maximize(); // Окно браузера разворачивается на полный экран
    }
    // метод будет выполняться один раз после выполнения всех тестов в классе
    @AfterClass
    public void afterClass() throws Exception {
        getDriver().quit(); // метод quit() для завершения работы WebDriver и закрытия браузера
    }
}

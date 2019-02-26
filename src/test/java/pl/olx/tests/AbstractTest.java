package pl.olx.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.olx.pages.HomePage;
import pl.olx.pages.ResultPage;

import static java.lang.Thread.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AbstractTest {

    WebDriver driver;
    HomePage homePage = new HomePage(driver);
    ResultPage resultPage = new ResultPage(driver);

    boolean results;
    String url = "www.olx.pl";
    String brandCar = "honda";
    String modelCar = "accord";

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeEach
    void openSession() {
        setup();
        driver.get(url);
        driver.manage().window().fullscreen();
    }

    @AfterEach
    void closeSession() {
        driver.quit();
        System.out.println("session is closed");
    }

    @Test
    public void searchCarTest() throws InterruptedException {
        homePage.clickMotoryzacja();
        homePage.clickSamochodyOsobowe();
        homePage.clickMarka();
        sleep(5000);
        homePage.generateWebElementByBrandCar(brandCar);
        sleep(5000);
        homePage.clickModel();
        homePage.generateWebElementByModelCar(modelCar);
        sleep(10000);
        results = (resultPage.verifyResults(brandCar + " " + modelCar));
        assertTrue(results);
    }


}

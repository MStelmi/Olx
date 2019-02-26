package pl.olx.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.olx.pages.HomePage;
import pl.olx.pages.ResultPage;

public class AbstractTest {

    WebDriver driver;
    HomePage homePage = new HomePage(driver);
    ResultPage resultPage = new ResultPage(driver);

    String results;
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

    homePage.clickMotoryzacja();
    homePage.clickSamochodyOsobowe();
    homePage.clickMarka();
    Thread.sleep(5000);
    homePage.generateWebElementByBrandCar(brandCar);
    Thread.sleep(5000);
    homePage.ClickModel();
    homePage.generateWebElementByModelCar(modelCar);
    Thread.sleep(10000);
    results = (resultPage.verifyResults(brandCar + " " + modelCar));
    assertTrue(results);

}

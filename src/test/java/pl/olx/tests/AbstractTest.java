package pl.olx.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.olx.pages.HomePage;
import pl.olx.pages.ResultPage;

public class AbstractTest {
    String url = "https://www.olx.pl/";

    WebDriver driver;
    public HomePage homePage;
    public ResultPage resultPage;

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        resultPage = new ResultPage(driver);
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
}

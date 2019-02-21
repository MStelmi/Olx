import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class test {

    WebDriver driver;
    String url = "https://www.olx.pl";

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
    public void findCar() throws InterruptedException {
       String results;
       String brandCar = "honda";
       String modelCar = "accord";

        driver.findElement(By.linkText("Samochody osobowe")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@data-default-label='Marka']")).click();
        driver.findElement(By.xpath("//a[@data-code='" + brandCar + "']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//li//div//a//span[@data-default-label='Model']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='checkbox' and @data-value='" + modelCar + "']")).click();
        Thread.sleep(10000);
        results = driver.findElement(By.xpath("//table[@summary='Ogłoszenia']")).getText().toLowerCase();
        boolean x = results.contains(brandCar + " " + modelCar);
        assertTrue(x);

        System.out.println(results);
        driver.close();
    }
}

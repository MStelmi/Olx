import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

    WebDriver driver;
    String url = "https://www.olx.pl";
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
    }

    @AfterEach
    void closeSession() {
        driver.quit();
        System.out.println("session is closed");
    }

    @Test
    public void findCar() {
       String results;

        driver.findElement(By.linkText("Motoryzacja")).click();
        driver.findElement(By.linkText("Samochody osobowe")).click();
        driver.findElement(By.linkText("Marka")).click();
        driver.findElement(By.xpath("//a[@data-code='" + brandCar + "']")).click();
        driver.findElement(By.xpath("//li[@class='subcategory']")).click();
        driver.findElement(By.xpath("//label[@data-label='" + modelCar + "']")).click();
        results = driver.findElement(By.xpath("//table[@summary='Ogłoszenia']")).getText();
        System.out.println(results);
        driver.close();
    }
}

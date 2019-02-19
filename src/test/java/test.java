import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

    WebDriver driver;
    String url = "https://www.google.com";

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
    public void runGooglePage() {
        driver.findElement(By.name("q")).sendKeys("wikipedia");
        driver.findElement(By.name("btnK")).click();

        driver.close();
    }
}

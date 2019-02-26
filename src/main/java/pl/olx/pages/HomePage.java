package pl.olx.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    @FindBy(linkText="Motoryzacja")
    WebElement categoryMotoryzacja;

    @FindBy(linkText="Samochody osobowe")
    WebElement subcategorySamochodyOsobowe;

    @FindBy(xpath="//span[@data-default-label='Marka']")
    WebElement marka;

    @FindBy(xpath="//li//div//a//span[@data-default-label='Model']")
    WebElement model;

    public HomePage (WebDriver driver) {
        super(driver);
    }

    public void selectBrandCar(String brand) {
//        this.driver.findElement(By.xpath(("//a[@data-code='" + brand + "']"))).click();
        WebElement b = driver.findElement(By.xpath("//a[@data-code='" + brand + "']"));
         click(b);
   // new Actions(driver).moveToElement(b).click().build().perform();
    }
    public void selectModelCar(String model) {
        WebElement m = driver.findElement(By.xpath("//input[@type='checkbox' and @data-value='" + model + "']"));
        click(m);
    }

    public void clickMarka() {
        click(marka);
    }
    public void clickModel(){
        click(model);
    }
    public void clickMotoryzacja() {
        click(categoryMotoryzacja);
    }
    public void clickSamochodyOsobowe() {
        click(subcategorySamochodyOsobowe);
    }
}


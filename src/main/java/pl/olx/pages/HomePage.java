package pl.olx.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    WebElement generateWebElementByBrandCar(String brand) {
        return this.driver.findElement(By.xpath("//a[@data-code='" + brand + "']"));
    }

    public void clickMarka() {
        marka.click();
    }
    public void clickModel(){
        model.click();
    }

    public void clickMotoryzacja() {
        categoryMotoryzacja.click();
    }

    public void clickSamochodyOsobowe() {
        subcategorySamochodyOsobowe.click();
    }
}


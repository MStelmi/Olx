package fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchCarProperties {

    @FindBy(xpath="//span[@data-default-label='Marka']")
    WebElement marka;

    @FindBy(xpath="//li//div//a//span[@data-default-label='Model']")
    WebElement model;

    public SearchCarProperties(WebElement driver) {
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
}

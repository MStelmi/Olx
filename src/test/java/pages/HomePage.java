package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(linkText="Samochody osobowe")
    WebElement categorySamochodyOsobowe;

    @FindBy(xpath="//span[@data-default-label='Marka']")
    WebElement marka;

    @FindBy(xpath="//li//div//a//span[@data-default-label='Model']")
    WebElement model;

    void selectModel(String model) {

    }
}

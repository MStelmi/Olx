package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage {

    @FindBy(xpath="//table[@summary='Ogłoszenia']")
    WebElement results;
}

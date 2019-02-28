package pl.olx.tests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchCarTest extends AbstractTest{
    String brandCar = "honda";
    String modelCar = "accord";
    boolean results;

    @Test
    public void SearchCarTest() throws InterruptedException {
        homePage.clickMotoryzacja();
        homePage.clickSamochodyOsobowe();
        homePage.clickMarka();
        homePage.selectBrandCar(brandCar);
        homePage.clickModel();
        homePage.selectModelCar(modelCar);
        results = (resultPage.verifyResults(brandCar + " " + modelCar));
        assertTrue(results);
    }
}

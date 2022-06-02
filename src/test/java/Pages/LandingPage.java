package Pages;

import org.openqa.selenium.By;

public class LandingPage extends BasePage {

    By elementsTile = By.xpath("//h5[contains(text(),'Elements')]");
    By elementsTile2 = By.xpath("//h5[contains(text(),'Elements')]");


    public void clickElementsTile() {
        clickThis(elementsTile);
    }
}

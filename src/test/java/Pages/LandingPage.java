package Pages;

import org.openqa.selenium.By;

public class LandingPage extends BasePage {

    By elementsTile = By.xpath("//h5[contains(text(),'Elements')]");
    By alertsTile = By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]");


    public void clickElementsTile() {
        clickThis(elementsTile);
    }

    public void clickAlertsTile() {
        clickThis(alertsTile);
    }

}

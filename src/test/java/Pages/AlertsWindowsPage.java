package Pages;

import org.openqa.selenium.By;

public class AlertsWindowsPage extends BasePage{

    By alertsOption = By.xpath("//span[contains(text(),'Alerts')]");

    public void clickAlerts() {
        clickThis(alertsOption);
    }
}

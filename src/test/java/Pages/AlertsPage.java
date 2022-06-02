package Pages;

import org.openqa.selenium.By;

public class AlertsPage extends BasePage {

    By timerAlertButton = By.xpath("//button[@id='timerAlertButton']");

    public void clickTimerAlertButton() {
        clickThis(timerAlertButton);
    }

    public boolean isTimerAlertPresent() {
        return isAlertPresent();
    }

    public void closeAlert() {
        switchToAlert();
        clickPositiveOnAlert();
    }
}

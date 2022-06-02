package Pages;

import org.openqa.selenium.By;

public class CheckBoxPage extends BasePage {


    By plusIcon = By.xpath("//button[@title='Expand all']");
    By angular = By.xpath("//label[@for='tree-node-angular']//span[@class='rct-checkbox']");
    By angularChecked = By.xpath("//label[@for='tree-node-angular']//span[@class='rct-checkbox']//*[contains(@class, 'rct-icon-check')]");
    By angularUnchecked = By.xpath("//label[@for='tree-node-angular']//span[@class='rct-checkbox']//*[contains(@class, 'rct-icon-uncheck')]");


    public void clickPlusIcon() {
        clickThis(plusIcon);
    }

    public void selectAngular() {
        clickThis(angular);
    }

    public boolean isElemSelected() {
        return isElementDisplayed(angularChecked);
    }

    public boolean isElemNotSelected() {
        return isElementDisplayed(angularUnchecked);
    }
}

package Pages;

import org.openqa.selenium.By;

public class ElementsPage extends BasePage{

    By checkBox = By.xpath("//span[contains(text(),'Check Box')]");


    public void clickCheckBox() {
        clickThis(checkBox);
    }


}

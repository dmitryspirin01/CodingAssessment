package Pages;

import DriverWrapper.Web;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {

    Alert alert;

    public WebElement findElementUsingFluentWait(final By locator) {
        Wait<WebDriver> fWait = new FluentWait<>(Web.getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(5000))
                .ignoring(NoAlertPresentException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Element is not found after 30 seconds of wait");

        return fWait.until((Function<WebDriver, WebElement>) driver -> {
            assert driver != null;
            return driver.findElement(locator);
        });
    }

    public List<WebElement> findAllElementsUsingFluentWait(final By locator) {
        Wait<WebDriver> fWait = new FluentWait<>(Web.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class)
                .ignoring(NoSuchElementException.class)
                .withMessage("Elements is not found after 30 seconds of wait");

        return fWait.until((Function<WebDriver, List<WebElement>>) driver -> {
            assert driver != null;
            return driver.findElements(locator);
        });
    }

    public void waitUntilAllElementsAppear(By locator) {
        WebDriverWait wait = new WebDriverWait(Web.getDriver(), 30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void type(By locator, String data) {
        waitForElement(locator);
        findElementUsingFluentWait(locator).clear();
        findElementUsingFluentWait(locator).sendKeys(data);
    }

    public void type(By locator, Keys data) {
        waitForElement(locator);
        findElementUsingFluentWait(locator).clear();
        findElementUsingFluentWait(locator).sendKeys(data);
    }

    public void pressEnter(By locator) {
        findElementUsingFluentWait(locator).sendKeys(Keys.ENTER);
    }

    public void clickThis(By locator) {
        waitForElement(locator);
        scrollIntoView(locator);
        findElementUsingFluentWait(locator).click();
    }

    public boolean isElementDisplayed(By locator) {
        return findElementUsingFluentWait(locator).isDisplayed();
    }

    public boolean isElementSelected(By locator) {
        return findElementUsingFluentWait(locator).isSelected();
    }

    public void selectFromDropdownUsingVisibleText(By locator, String data) {
        WebElement dropdownElement = findElementUsingFluentWait(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(data);
    }

    public void selectFromDropdownUsingIndex(By locator, int index) {
        WebElement dropdownElement = findElementUsingFluentWait(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }

    public String getWebpageTitle() {
        return Web.getDriver().getTitle();
    }

    public void setCursor(By locator) {
        WebElement element = findElementUsingFluentWait(locator);
        Actions act = new Actions(Web.getDriver());
        act.moveToElement(element).build().perform();
    }

    public void sleepFor(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void switchToWindow(int index) {
        List<String> listOfWindows = new ArrayList<String>(Web.getDriver().getWindowHandles());
        Web.getDriver().switchTo().window(listOfWindows.get(index));
    }

    public void scrollDown(int pixelsDown) {
        JavascriptExecutor js = (JavascriptExecutor) Web.getDriver();
        js.executeScript("scrollBy(0," + pixelsDown + ");");
    }

    public void scrollIntoView(By element) {
        WebElement webElement = Web.getDriver().findElement(element);
        JavascriptExecutor js = (JavascriptExecutor) Web.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Web.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(Web.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void locationOfElement(By elem) {
        WebElement element = Web.getDriver().findElement(elem);
        Point location = element.getLocation();
        int x = location.getX();
        int y = location.getY();
    }

    public boolean isElementExist(By element) {
        Web.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        try {
            Web.getDriver().findElement(element);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Set<String> getAllWindowHandles() {
        return Web.getDriver().getWindowHandles();
    }

    public String getCurrentWindowHandle() {
        return Web.getDriver().getWindowHandle();
    }

    public void switchToNewWindow(String handle) {
        Web.getDriver().switchTo().window(handle);
    }

    public void switchToFrame(String frameId) {
        Web.getDriver().switchTo().frame(frameId);
    }

    public void switchToFrame(By locator) {
        WebElement myFrame = findElementUsingFluentWait(locator);
        Web.getDriver().switchTo().frame(myFrame);
    }

    public String getTextValue(By locator) {
        return Web.getDriver().findElement(locator).getText();
    }

    public void switchToAlert() {
        alert = Web.getDriver().switchTo().alert();
    }

    public void clickPositiveOnAlert() {
        alert.accept();
    }

    public void clickNegativeOnAlert() {
        alert.dismiss();
    }

    public void typeOnAlert(String data) {
        alert.sendKeys(data);
    }

}
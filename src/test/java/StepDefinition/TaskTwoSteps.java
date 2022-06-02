package StepDefinition;

import Pages.AlertsPage;
import Pages.AlertsWindowsPage;
import Pages.LandingPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class TaskTwoSteps {

    LandingPage landingPage = new LandingPage();
    AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage();
    AlertsPage alertsPage = new AlertsPage();


    @When("I select “Alerts, Frame, & Windows” tile")
    public void i_select_alerts_frame_windows_tile() {
        landingPage.clickAlertsTile();
    }

    @When("I select the “Alerts” option from the side menu")
    public void i_select_the_alerts_option_from_the_side_menu() {
        alertsWindowsPage.clickAlerts();
    }

    @When("I click on the “On button click, alert will appear after 5 seconds” button")
    public void i_click_on_the_on_button_click_alert_will_appear_after_seconds_button() {
        alertsPage.clickTimerAlertButton();
    }

    @Then("I verify the alert pop up has appeared")
    public void i_verify_the_alert_pop_up_has_appeared() {
        Assert.assertTrue("Alert is NOT present", alertsPage.isTimerAlertPresent());
    }

    @Then("I close the alert")
    public void i_close_the_alert() {
        alertsPage.closeAlert();
    }


}

package StepDefinition;

import Pages.CheckBoxPage;
import Pages.ElementsPage;
import Pages.LandingPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class TaskOneSteps {

    LandingPage landingPage = new LandingPage();
    ElementsPage elementsPage = new ElementsPage();
    CheckBoxPage checkBoxPage = new CheckBoxPage();

    @When("I select “Elements” tile")
    public void i_select_elements_tile() {
        landingPage.clickElementsTile();
    }

    @When("I select the “Check Box” option from the side menu")
    public void i_select_the_check_box_option_from_the_side_menu() {
        elementsPage.clickCheckBox();
    }

    @When("I expand the folder tree using the “+” button on the top right corner")
    public void i_expand_the_folder_tree_using_the_button_on_the_top_right_corner() {
        checkBoxPage.clickPlusIcon();
    }

    @When("I select the checkbox under the file path “Home” > “Workspace”> “Angular”")
    public void i_select_the_checkbox_under_the_file_path_home_workspace_angular() {
        checkBoxPage.selectAngular();
    }

    @Then("I verify the selection")
    public void i_verify_the_selection() {
        Assert.assertTrue("CheckBox is NOT selected", checkBoxPage.isElemSelected());
    }

    @Then("I uncheck the Angular checkbox")
    public void i_uncheck_the_angular_checkbox() {
        checkBoxPage.selectAngular();
    }

    @Then("I verify it is no longer selected")
    public void i_verify_it_is_no_longer_selected() {
        Assert.assertTrue("CheckBox is NOT selected", checkBoxPage.isElemNotSelected());
    }


}

@test
Feature: TaskOne

  Scenario: TaskOne - verify Elements tile actions
    When I select “Elements” tile
    And I select the “Check Box” option from the side menu
    And I expand the folder tree using the “+” button on the top right corner
    And I select the checkbox under the file path “Home” > “Workspace”> “Angular”
    Then I verify the selection
    And I uncheck the Angular checkbox
    Then I verify it is no longer selected

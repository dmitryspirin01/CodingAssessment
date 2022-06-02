@test
Feature: TaskTwo

  Scenario: TaskTwo - verify Elements tile actions
  When I select “Alerts, Frame, & Windows” tile
  And I select the “Alerts” option from the side menu
  And I click on the “On button click, alert will appear after 5 seconds” button
  Then I verify the alert pop up has appeared
  Then I close the alert


Feature: Login Page - Email Address Field

  Scenario: User can fill in the email address field and verify AMP Login label
    Given I am on the login page
    When I enter a valid email address "email@example.com"
    Then the email address field should contain "email@example.com"
    Then the AMP Login label should be present and contain the text "AMP Login"
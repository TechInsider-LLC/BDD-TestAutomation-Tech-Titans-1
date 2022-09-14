@regression
Feature: Log-in
  @login
  Scenario: Successful User Login

    Given User has valid credentials

    When User logs in

    Then User logs in successfully

  Scenario: Unsuccessful User Login

    Given User has invalid credentials

    When User logs in

    Then User fails to login
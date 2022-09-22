@regression

  Feature: Funding Transfer
    Scenario: Card Funding Transfer
      Given User is on Ebanq page
      When User Logs in and click on transfers then click on Card Funding Transfer
      And User Select account click Continue and clicks confirm
      Then User sees success message
      
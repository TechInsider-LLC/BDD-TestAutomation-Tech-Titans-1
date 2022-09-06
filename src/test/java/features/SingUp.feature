@regression
  Feature: User sing up for EBANQ account
    Scenario: User sing up successfully
      Given Customer go to EBANQ homepage
      When Customer enter all the requirements
      Then Customer see success message


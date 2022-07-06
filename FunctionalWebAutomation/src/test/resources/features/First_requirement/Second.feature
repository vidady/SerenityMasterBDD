Feature: Feature to verify second user the login functionality

  Background:
    Given Navigate to application

  @manual
  Scenario Outline: Do Login by user
    Given When user <username> is on homepage with password <password>
    Then verify login of google

    Examples:
      |username|password|
      |trainer@way2automation.com   |warpath       |
      |java@way2automation.com      |dynamic       |
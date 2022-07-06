Feature: Feature to verify the login functionality

  Background:
  Given Navigate to application

Scenario Outline: Do Login by user
  Given When user <username> is on homepage with password <password>
  Then verify login of google

  Examples:
  |username|password|
  |trainer@way2automation.com   |dubey       |
  |java@way2automation.com      |sdfsfds     |

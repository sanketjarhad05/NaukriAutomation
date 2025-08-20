Feature: Resume Management Delete on Naukri

  Background:
    Given User is logged into Naukri portal
    |username|password|
    |sanketjarhad05@gmail.com|Sanket@05|

  @DeleteResume
  Scenario: Delete existing resume
    When User navigates to Profile page
    And User deletes the existing resume
    Then Resume should be removed successfully
  
Feature: Login page feature


Scenario: Verify Naukri page title
    Given User is on naukri page
    Then Page title should be "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com"


Scenario: Successful login to naukri	
Given User is on naukri page
When User enters valid Username "sanketjarhad05@gmail.com"
And User enters valid Password "Sanket@05"
And User clicks on Login button
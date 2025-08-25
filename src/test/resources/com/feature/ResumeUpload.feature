Feature: Resume Management Upload on Naukri

  Background:
    Given User is logged into Naukri portal
   

 
  @UploadResume
  Scenario: Upload new resume
    When User uploads a new resume file "sanket-resume-QA.pdf"
    Then Resume should be uploaded successfully

 
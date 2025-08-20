package stepDefinations;

import com.pages.HomePage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResumeUploadSteps
{
	private HomePage homepage = new HomePage(DriverFactory.getDriver());
	
	@When("User uploads a new resume file {string}")
	public void user_uploads_a_new_resume_file(String fileName) throws InterruptedException {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/Resume/" + fileName;
        System.out.println(filePath);
        System.out.println(fileName);
		homepage.clickOnCompleteProfileButton();
		homepage.uploadResume();
		//homepage.fileUpload("C://Users//sanke//eclipse-workspace//AUTOMATION//CucumberNaukriAutomation//src//test//resources//Resume//sanket-resume QA.pdf");
		Thread.sleep(5000);
		homepage.fileUpload(filePath);
		Thread.sleep(5000);
	}
	@Then("Resume should be uploaded successfully")
	public void resume_should_be_uploaded_successfully() {
	    
	}



}






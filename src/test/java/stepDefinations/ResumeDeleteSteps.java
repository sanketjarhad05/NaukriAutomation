package stepDefinations;

import java.util.List;
import java.util.Map;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResumeDeleteSteps {
	private HomePage homepage = new HomePage(DriverFactory.getDriver());
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	
	@Given("User is logged into Naukri portal")
	public void user_is_logged_into_naukri_portal(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps(); String userName =
				 credList.get(0).get("username"); String password =
				  credList.get(0).get("password");
				  
				  DriverFactory.getDriver().get("https://www.naukri.com/"); homepage =
				 loginpage.doLogin(userName, password);
	}
	@When("User navigates to Profile page")
	public void user_navigates_to_profile_page() {
		homepage.clickOnViewProfileButton();
	}
	@When("User deletes the existing resume")
	public void user_deletes_the_existing_resume() {
		homepage.clickOndeleteResumeBtn();
	}
	@Then("Resume should be removed successfully")
	public void resume_should_be_removed_successfully() {
	   
	}
	
	
	 
	
	  
		
		

		

}
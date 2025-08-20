package stepDefinations;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("User is on naukri page")
	public void user_is_on_naukri_page() {
		DriverFactory.getDriver().get("https://www.naukri.com/");
		loginPage.clickOnLoginButton();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Title of the login page is " + title);
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@When("User enters valid Username {string}")
	public void user_enters_valid_username(String Username) {
		loginPage.enterUserName(Username);
	}

	@When("User enters valid Password {string}")
	public void user_enters_valid_password(String Password) {
		loginPage.enterPassword(Password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLoginbtn();
	}

//	@Then("User Should be navigated to home page {string}")
//	public void user_should_be_navigated_to_home_page(String expectedTitle) {
//		String actualTitle = DriverFactory.getDriver().getTitle();
//		System.out.println("Home Page Title "+actualTitle);
//	    Assert.assertEquals(actualTitle, expectedTitle);	}

}

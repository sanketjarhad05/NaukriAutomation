package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
    private WebDriverWait wait;

//Locators

//login Button
@FindBy(xpath="//a[@id='login_Layer']")
private WebElement loginButton;

//User Name
@FindBy(xpath="//label[text()='Email ID / Username']/following-sibling :: input")
private WebElement txtUsername;

//password
@FindBy(xpath="//label[text()='Password']/following-sibling :: input")
private WebElement txtPassword;

//Login button
@FindBy(xpath = "//button[text()='Login']")
private WebElement btnLogin;

public LoginPage(WebDriver driver) {
	this.driver=driver;
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
}

//page actions : features of the page in the form of methods.

public String getLoginPageTitle() {
	return driver.getTitle();


}
public void clickOnLoginButton() {
	wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
}

public void enterUserName(String Username) {
	wait.until(ExpectedConditions.visibilityOf(txtUsername)).sendKeys(Username);
	
}
public void enterPassword(String Password) {
	wait.until(ExpectedConditions.visibilityOf(txtPassword)).sendKeys(Password);
	
}
public void clickOnLoginbtn() {
	wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
	
}
public HomePage doLogin(String uname,String pwd) {
	wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	wait.until(ExpectedConditions.visibilityOf(txtUsername)).sendKeys(uname);
	wait.until(ExpectedConditions.visibilityOf(txtPassword)).sendKeys(pwd);
	wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
	return new HomePage(driver);

}

}

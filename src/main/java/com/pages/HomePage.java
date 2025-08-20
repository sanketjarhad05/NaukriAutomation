package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//div[@class='view-profile-wrapper']/a")
	private WebElement viewProfileBtn;
	
	@FindBy(xpath = "//div[@class='view-profile-wrapper']/a")
	private WebElement completeProfileBtn;

	@FindBy(xpath = "//div[@class='cvPreview']//span[@class='icon-wrap'][2]")
	private WebElement deleteResumeIconBtn;

	@FindBy(xpath = "//div[@class='confirmationBox profileSummaryConfirmation']//p[contains(text(),'delete the resume')]/following::button[text()='Delete'][1]")
	private WebElement deleteResumeBtn;

	@FindBy(xpath = "//span[text()='Upload resume']")
	private WebElement uploadResumeBtn;
	
	@FindBy(xpath = "//div[@class='uploadBtn']//input[@type='button']")
	private WebElement uploadResumeBtn12;
	
	//span[text()='Upload resume']
	@FindBy(xpath = "//input[@type='file' and @id='attachCV']")
	private WebElement fileUploadBtn;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}

	public void clickOnViewProfileButton() {
		wait.until(ExpectedConditions.elementToBeClickable(viewProfileBtn)).click();
	}
	public void clickOnCompleteProfileButton() {
		wait.until(ExpectedConditions.elementToBeClickable(completeProfileBtn)).click();
	}
	public void clickOndeleteResumeBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(deleteResumeIconBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteResumeBtn)).click();
	}

	public void uploadResume() {
		//wait.until(ExpectedConditions.elementToBeClickable(uploadResumeBtn)).click();
	}

	public void uploadResumebtn() {
		//wait.until(ExpectedConditions.elementToBeClickable(uploadResumeBtn12)).click();
	}

	public void fileUpload(String filePath) {
		WebElement hiddenInput = driver.findElement(By.id("attachCV"));

		// Use JavaScript to set display = block
		//JavascriptExecutor js = (JavascriptExecutor) driver;

		// Case 1: Element has display:none
		//js.executeScript("arguments[0].style.display='block';", hiddenInput);

		// Case 2: Element has visibility:hidden
		//js.executeScript("arguments[0].style.visibility='visible';", hiddenInput);
//
		// Case 3: Element has opacity:0
		//js.executeScript("arguments[0].style.opacity='1';", hiddenInput);

		// Case 4: Element covered by another due to z-index
		//js.executeScript("arguments[0].style.zIndex='9999';", hiddenInput);

		// Now upload the file
		hiddenInput.sendKeys(filePath);

	fileUploadBtn.sendKeys(filePath);
	}
}

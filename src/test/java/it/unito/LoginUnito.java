package it.unito;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import it.unito.defaults.BrowserDriverFactory;

public  class LoginUnito extends BrowserDriverFactory{

	
	
	
	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 2, groups = { "negativeTests", "smokeTests" })
	public void negativeLoginTest(String username, String password, @Optional()String expectedErrorMessage) throws InterruptedException {
		System.out.println("Starting negative Login Test !! with " + username + " and " + password);
		
		WebDriverWait wait = new WebDriverWait(	driver,Duration.ofSeconds(10));
		
		
		WebElement LogInButton = driver.findElement(By.cssSelector(".header-slim-right-zone > a[role='button']"));
	wait.until(ExpectedConditions.elementToBeClickable(LogInButton));
		
		LogInButton.click();
		
		
		
String expectedUrl = "https://idp.unito.it/idp/profile/SAML2/Redirect/SSO?execution=e1s2";

		sleep(1000);

	String actualUrl = driver.getCurrentUrl();
	Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
	

        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		usernameElement.sendKeys(username);
		

//	enter password
		WebElement passwordElement = driver.findElement(By.id("password"));
		passwordElement.sendKeys(password);

//	click login button 
		WebElement logInButton = driver.findElement(By.cssSelector("button[name='_eventId_proceed']"));
	wait.until(ExpectedConditions.elementToBeClickable(logInButton));
		
		logInButton.click();
		
		sleep(3000);
		
	

		WebElement errorMessage = driver.findElement(By.cssSelector("section > .form-element.form-error"));
		String actualErrorMessage = errorMessage.getText();
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"Actual error message does not contain expected \n Actual:" + actualErrorMessage + "Expected:"
						+ expectedErrorMessage);
		

	}
	
	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void positiveLoginTest(String username, String password, @Optional()String expectedErrorMessage) throws InterruptedException {
		System.out.println("Starting negative Login Test !! with " + username + " and " + password);
		
		WebDriverWait wait = new WebDriverWait(	driver,Duration.ofSeconds(10));
		
		
		WebElement LogInButton = driver.findElement(By.cssSelector(".header-slim-right-zone > a[role='button']"));
wait.until(ExpectedConditions.elementToBeClickable(LogInButton));
		
		LogInButton.click();
		
		
		
String expectedUrl = "https://idp.unito.it/idp/profile/SAML2/Redirect/SSO?execution=e1s2";
String loginUrl ="https://my.unito.it/";

	sleep(1000);

	String actualUrl = driver.getCurrentUrl();
	Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
//enter username
	WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));		
	usernameElement.sendKeys(username);
			

//	enter password
		WebElement passwordElement = driver.findElement(By.id("password"));
		passwordElement.sendKeys(password);

//	click login button 
		WebElement logInButton = driver.findElement(By.xpath("/html//section[@class='wrapperErrorMsg']//form[@action='/idp/profile/SAML2/Redirect/SSO?execution=e1s2']//button[@name='_eventId_proceed']"));
	wait.until(ExpectedConditions.elementToBeClickable(logInButton));
		
		
		logInButton.click();
		
		sleep(1000);
		
		String trueUrl = driver.getCurrentUrl();
		Assert.assertEquals(trueUrl, loginUrl, "Actual page url is not the same as expected");
		
	}




}

	

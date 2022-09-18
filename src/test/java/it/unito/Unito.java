package it.unito;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import it.unito.defaults.BrowserDriverFactory;


public class Unito extends BrowserDriverFactory {
	


	@Parameters({ "text" })
	@Test(groups = { "claim" }, enabled = true)

	public void claims(String text) throws InterruptedException {

		// coockie banner acceptance
		WebElement coockieAccept = driver.findElement(By.xpath("//button[contains(text(),'Solo cookie tecnici')]"));
		coockieAccept.click();
		WebElement claimsButton = driver.findElement(By.linkText("Reclami e segnalazioni"));
		claimsButton.click();

		// verification url of the new page opend
		String expectedUrl = "https://www.unito.it/reclami-e-segnalazioni-imbuca-lidea";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Error: the actual url is different from the expected one.");

		// Locating and clicking the icon 'imbuca l'idea'
		WebElement imbucaIdea = driver.findElement(By.cssSelector(
				"body.no-sidebars.html.not-front.not-logged-in.one-sidebar.sidebar-first.page-node.page-node-.page-node-1902.node-type-pagina-area0.pagina-base.www.og-context.og-context-node.og-context-node-830.eu-cookie-compliance-processed.eu-cookie-compliance-status-0:nth-child(2) div.main-container.container:nth-child(3) div.col-12.col-xs-12.col-sm-12.col-md-8.col-lg-9.col-xl-9.colonna2:nth-child(3) section.col-12.col-xs-12.col-sm-12.colonnasx1.colonnadx0.contenuto div.region.region-content:nth-child(4) div.ds-1col.node.node-pagina-area0.view-mode-full.clearfix:nth-child(2) div.field-collection-container.clearfix div.field.field-name-field-paragrafo.field-type-field-collection.field-label-hidden div.field-items div.field-item.odd:nth-child(4) div.field-collection-view.clearfix.view-mode-full div.ds-1col.entity.entity-field-collection-item.field-collection-item-field-paragrafo.view-mode-full.clearfix div.rientro-lista.field.field-name-field-link-contatti.field-type-link-field.field-label-hidden ul.arrow-red li.odd > a:nth-child(1)"));
		imbucaIdea.click();
		sleep(2000);

		// verification url new page opened
		String expectedUrl1 = "https://webapps.unito.it/imbuca_idea/";
		String actualUrl1 = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl1, expectedUrl1, "Error: the actual url is different from the expected one.");

		// Locating inputBox web element WebElement inputBoxTxt =
		WebElement inputBoxTxt = driver.findElement(By.xpath("//textarea[@id='idea']"));

		// Get the typed value
		// String typedValue = inputBoxTxt.getAttribute("value");

		String typedValues = inputBoxTxt.getText();
		System.out.println("testo " + typedValues);

		// Requirement: max 1000 characters
		// Get the number of characters of typed value
		int size = text.length();

		// Assert with expected
		if (size < 1000) {
			System.out.println("Max character functionality is working fine.");
			inputBoxTxt.sendKeys(text);
			WebElement privacyButton = driver
					.findElement(By.xpath("//label[contains(text(),'Presa visione informativa')]"));
			privacyButton.click();
			WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
			submitButton.click();
			// verification claim sent

			WebElement thankfulMessage = driver.findElement(By.cssSelector("div.container.pl-0.pr-0:nth-child(2) div.row:nth-child(3) div.col-md-12.pl-4.pr-4.pl-md-5.pr-md-5 div.containerAlert div.alert.alert-dismissible.alert-success > p:nth-child(1)"));
			String expectedMessage = "Se hai fornito un indirizzo email sarai aggiornato rispetto alle azioni di miglioramento intraprese.";
			String actualMessage = thankfulMessage.getText();
			Assert.assertTrue(actualMessage.contains(expectedMessage),
					"Error: the message dispayed is different from the expected");

			sleep(2000);


		}

		else {
			System.out.println("exceedes the number of characters.");


		}

		sleep(1000);
	}



	
	@Test  (groups = { "dropdownmenu" })

	public void dropdownTest() throws InterruptedException {
		


		System.out.println("Starting dropdownTest");

		System.out.println("Page is opened.");

		sleep(2000);

		WebElement dropdown = driver.findElement(By.xpath(
				"/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/ul[1]/li[2]/a[1]"));
		dropdown.click();

		WebElement drop1 = driver.findElement(By.xpath(
				"/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
		WebElement drop2 = driver.findElement(By.xpath(
				"/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[2]/a[1]"));
		WebElement drop3 = driver.findElement(By.xpath(
				"/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[3]/a[1]"));
		WebElement drop4 = driver.findElement(By.xpath(
				"/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[4]/a[1]"));
		WebElement drop5 = driver.findElement(By.xpath(
				"/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[5]/a[1]"));
		WebElement drop6 = driver.findElement(By.xpath(
				"/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[6]/a[1]"));

		ArrayList<WebElement> options = new ArrayList<WebElement>();

		options.add(drop1);
		options.add(drop2);
		options.add(drop3);
		options.add(drop4);
		options.add(drop5);
		options.add(drop6);
//      System.out.println(options);

		for (int i = 0; i < options.size(); i++) {

			if (!(i == 0)) {
				dropdown.click();
				sleep(1000);
			}

			options.get(i).click();
			sleep(1000);

			boolean verify = driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[1]/div[3]/section[1]/div[2]/section[1]/div[1]/a[1]/span[1]/span[1]/span[1]"))
					.isDisplayed();

			if (verify) {
				driver.navigate().back();
			} else {
				System.out.println(options.get(i) + " 's page doesnt have ReadSpeaker option");
			}

		}

		sleep(2000);

	}



}

package it.unito.defaults;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BrowserDriverFactory {
	
	
	

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	protected void setUp(@Optional("chrome") String browser) {
		// create driver
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		default:
			
			System.out.println("do not know how to start " + browser + "starting chrome insted");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			
			break;
		}
			
		// open test page
		String url = "https://www.unito.it/";
		driver.get(url);
		System.out.println("Page is opened");

		// maximize browser window
		driver.manage().window().maximize();

		// implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		

	}
	

	
	
	protected WebDriver driver;
	String urlHomepage = "https://www.unito.it/";

	
	protected void sleep(int i) throws InterruptedException {
		Thread.sleep(1000);
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
}

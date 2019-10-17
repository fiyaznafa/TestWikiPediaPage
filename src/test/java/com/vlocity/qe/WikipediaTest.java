package com.vlocity.qe;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class verifies elements on the wikipedia homepage.
 */
public class WikipediaTest {

	private Logger log = LoggerFactory.getLogger(WikipediaTest.class);
	private WebDriver driver;
	private ElementFinder finder;
	private HttpMethods httpMethods= new HttpMethods();

	@BeforeClass
	public void setup() {

		/*
		 * If the following driver version doesn't work with your Chrome version see
		 * https://sites.google.com/a/chromium.org/chromedriver/downloads and update it
		 * as needed.
		 */

		WebDriverManager.chromedriver().version("77.0.3865.40").setup();
		driver = new ChromeDriver();
		finder = new ElementFinder(driver);
		driver.get("https://www.wikipedia.org/");
	}

	@Test
	public void sloganPresent() {

		String sloganClass = "localized-slogan";
		WebElement slogan = finder.findElement(By.className(sloganClass));

		Assert.assertNotNull(slogan, String.format("Unable to find slogan div by class: %s", sloganClass));

		log.info("Slogan text is {}", slogan.getText());

		Assert.assertEquals(slogan.getText(), "The Free Encyclopedia");
	}

	@Test(dataProvider="Languages",dataProviderClass =InputDataProvider.class)
    public void checkLanguage(String xpath,String expectedText) {
    	String languageXpath ="//a[@id='"+xpath+"']/strong";
    	WebElement languageElement = finder.findElement(By.xpath(languageXpath));
        log.info("Element Language to be validated is {} ", languageElement.getText());
        Assert.assertEquals( languageElement.getText(), expectedText);	
   }
	
	@Test(dataProvider="Languages",dataProviderClass =InputDataProvider.class)
	public void checkLink(String xpath,String expectedText){
		String linkXpath="//a[@id='"+xpath+"']";
    	WebElement languageElement = finder.findElement(By.xpath(linkXpath));
    	String url=languageElement.getAttribute("href");
    	log.info("Verifying the URl {} ",url);
    	int status=httpMethods.testLinksWorking(url);
    	Assert.assertEquals(status, 200);
	}

	@AfterClass
	public void closeBrowser() {

		if (driver != null) {
			driver.close();
		}
	}
}

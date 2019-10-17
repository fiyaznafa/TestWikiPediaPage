package com.vlocity.qe;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to wrap Selenium Find methods.
 *
 */
public class ElementFinder
{
    private WebDriver driver;
    private Logger log = LoggerFactory.getLogger(ElementFinder.class);

    public ElementFinder(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By by) {

        log.info("Using By {}", by.toString());
        WebElement value = null;

        try {
            value = driver.findElement(by);
        } catch (NoSuchElementException e) {
            // the element can not be found
        }

        return value;
    }
    
}

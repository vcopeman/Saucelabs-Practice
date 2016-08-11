package com.tests.SaucelabTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestSauce
{
	  public static final String USERNAME = "VikkiCopeman";
	  public static final String ACCESS_KEY = "1f34220e-b6a1-46a2-924e-c4763e817518";
	  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	  @Test	
	  public void testGmail() throws MalformedURLException, InterruptedException 
	  {
	 
	    //DesiredCapabilities caps = DesiredCapabilities.chrome();
	    //caps.setCapability("platform", "Windows XP");
	    //caps.setCapability("version", "43.0");
	    //caps.setCapability("name", "Man we are testing Sauce");
	    
	    DesiredCapabilities caps = //is this needed in this case?
	    DesiredCapabilities.iphone();
	    caps.setCapability("platform", "iOS");
	    caps.setCapability("version", "8.1");
	    caps.setCapability("name", "Man we are testing Sauce");

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	 
	    driver.get("https://www.gmail.com");
	    driver.manage().deleteAllCookies();
	    driver.findElement(By.id("Email")).sendKeys("sauce@sauce.com");
	    Thread.sleep(5000);
	    driver.quit();
	  }

}
    
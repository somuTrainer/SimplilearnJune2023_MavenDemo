package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class ScrollPageWithTestNG {
	
	WebDriver driver;
	//JavascriptExecutor js = (JavascriptExecutor)(driver);
		
	  @Test(priority=2, enabled=false)
	  public void test1() {
		  System.out.println("Test1");
			WebElement elemnt = driver.findElement(By.xpath("//div[@id='premium-collection-wdgt']/div/a"));
		    new Actions(driver)
		            .scrollToElement(elemnt)
		            .perform();
		    elemnt.click();
	  }

	  @Test(priority=3)
	  public void test2() throws Exception {
		  System.out.println("Test2");
		  JavascriptExecutor js = (JavascriptExecutor)(driver);
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");        
		    WebElement aboutUsLink = driver.findElement(By.linkText("About us"));
		    Assert.assertTrue(aboutUsLink.isDisplayed(), "The About Us Link is not seen on the page after scrolling to the bottom");
		    Thread.sleep(2000);
	  }

	  @Test(enabled=false)
	  public void test3() {
		  System.out.println("Test3");
		  JavascriptExecutor js = (JavascriptExecutor)(driver);
		    WebElement elemnt = driver.findElement(By.xpath("//div[@id='premium-collection-wdgt']/div/a"));
		    js.executeScript("arguments[0].scrollIntoView()", elemnt);
		    elemnt.click();
	  }

	  @Test(priority=1, enabled=false)
	  public void test4() throws Exception {
		  System.out.println("Test4");	
		  JavascriptExecutor js = (JavascriptExecutor)(driver);
		    js.executeScript("window.scrollBy(0, 1000)");        
		    Thread.sleep(2000);
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() throws Exception {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.naukri.com/");	
			Thread.sleep(2000);
			
			String title = driver.getTitle();
			System.out.println("The title of the page is: "+title);
			Thread.sleep(2000);
			
			Assert.assertEquals(title, "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com");
			
			driver.findElement(By.className("acceptance-btn")).click();		
			Thread.sleep(2000);
	  }	

	  @AfterMethod
	  public void afterMethod() throws Exception {
		  System.out.println("AfterMethod");
		  Thread.sleep(5000);    
		    driver.quit();

	  }
}

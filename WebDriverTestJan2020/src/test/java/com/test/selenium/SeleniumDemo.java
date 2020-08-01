package com.test.selenium;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDemo {

	WebDriver driver;
	WebDriverWait wait;
//	String url = "https://www.ultimatix.net/";
//	String url = "https://www.ultimatix.net/";

	public SeleniumDemo(String url) throws InterruptedException {
		File path = new File("").getAbsoluteFile();
		System.out.println(path);
		//url = "https://www.ultimatix.net/";
		System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver83.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.get(url);
		sleepWell();
	}
	
	public void verifyDragandDrop() throws InterruptedException {
		sleepWell();
		WebElement from = driver.findElement(By.xpath("//*[contains(text(),'BANK')]"));
		WebElement to = driver.findElement(By.xpath("//*[@id='bank']"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(from, to).build().perform();
		sleepWell();
		WebElement from1 = driver.findElement(By.xpath("//*[contains(text(),'5000')]"));
		WebElement to1 = driver.findElement(By.xpath("//*[@id='amt7']"));
		actions.dragAndDrop(from1, to1).build().perform();
		sleepWell();
		
	}
	
	public void highlightElement(WebElement e) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border: 2px solid red;');", e);
		sleepWell();
		js.executeScript("arguments[0].setAttribute('style','border: 2px white');", e);
		
	}

	public void sleepWell() throws InterruptedException {
		Thread.sleep(5000);
	}

	public void verifyJavaScript() throws InterruptedException {

		
		sleepWell();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'News')]")));
		System.out.println("Url is : " + driver.getCurrentUrl());
		System.out.println("Title is : " + driver.getTitle());
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle.toString());
		Set<String> windowHandles = driver.getWindowHandles();
		for (String s : windowHandles) {
			System.out.println(s);
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('proceed-button').click()");

		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Need Help?')]"));
		js.executeScript("arguments[0].click()", element);
		
		System.out.println("Url is : " + driver.getCurrentUrl());
		System.out.println("Title is : " + driver.getTitle());
		sleepWell();
	}

	public void closeDriver() {
		driver.close();
	}

	public void mouseHover() throws InterruptedException {
		sleepWell();
		Actions action = new Actions(driver);
		
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'About Us')]"));
		highlightElement(element);
		
		action.moveToElement(element).perform();
		sleepWell();
	}
	

	
	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.vedantalimited.com/Pages/Home.aspx";
//		String url = "http://demo.guru99.com/test/drag_drop.html";
		SeleniumDemo myObject = new SeleniumDemo(url);
		//myObject.verifyJavaScript();
		myObject.mouseHover();
//		myObject.verifyDragandDrop();
		myObject.closeDriver();
	}
}

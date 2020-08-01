package com.test.selenium;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

public class XPathDemo {

	WebDriver driver;
	WebDriverWait wait;
//	String url = "https://www.ultimatix.net/";
//	String url = "https://www.ultimatix.net/";

	public XPathDemo(String url) throws InterruptedException {
		File path = new File("").getAbsoluteFile();
		System.out.println(path);
		// url = "https://www.ultimatix.net/";
		System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver83.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.get(url);
		sleepWell();
	}

	public void sleepWell() throws InterruptedException {
		Thread.sleep(5000);
	}

	public void takeScreenshot() {
		Shutterbug.shootPage(driver,ScrollStrategy.WHOLE_PAGE,500,true).withName("FullPage").save();
	}
	public void testTables() {
		takeScreenshot();
//		String table= "//*[@id='mw-content-text']/div/table[3]//tr//td//a[contains(text(),'Australian Open')]/../following-sibling::td[1]";
		String table = "//*[@id='mw-content-text']/div/table[3]//tr";
		List<WebElement> rows = driver.findElements(By.xpath(table));
		for (int i = 0; i < rows.size(); i++) {
			String td = "//*[@id='mw-content-text']/div/table[3]//tr[i]//td";
			List<WebElement> cells = driver.findElements(By.xpath(td));

			for (int j = 0; j < cells.size(); j++) {
				String cell = "//*[@id='mw-content-text']/div/table[3]//tr[i]//td[j]";
				String value = driver.findElement(By.xpath(cell)).toString();
				System.out.print(value+"  :  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url = "https://en.wikipedia.org/wiki/Roger_Federer_career_statistics";
		XPathDemo myObj = new XPathDemo(url);
		myObj.testTables();
	}

}

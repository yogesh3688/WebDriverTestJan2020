package com.test.extentreport;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestingReport {

	ExtentReports extent;
	
	
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir")+"\\ExtentReports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("My Test Report");
		reporter.config().setDocumentTitle("Test Automation");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Yogi");
	}
	
	@Test
	public void SeleniumDemo()  {
		extent.createTest("Extent Report Demo");
		File path = new File("").getAbsoluteFile();
		System.out.println(path);
		String url = "https://www.ultimatix.net/";
		System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver83.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.quit();
		extent.flush();
	}
}

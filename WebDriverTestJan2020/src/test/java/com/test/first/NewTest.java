package com.test.first;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

@Listeners(ITestListenerDemo.class)
public class NewTest {
	
  @Test()
  public void f() {
	  System.out.println("Simple Test ");
  }
  
  @Test
  public void f1() {
	  System.out.println("This is f1 test Date"); 
  }
  
  @Test
  public void f2() {
	  System.out.println("This is f2 test");
  }

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("beforeMethod");
  }


 
  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("afterSuite");
  }
  
  @Test
  public void myTestOne() {
	  System.out.println("------- Created on 28 May 2020 -------");
  }

  @Test(priority = 1)
  public void Ford() {
	  System.out.println("Inside Ford Method");
  }
  

  @Test(priority = 2)
  public void Ferrari() {
	  System.out.println("Inside Ford Ferrari");
  }
  
  @Test(dependsOnMethods = {"Ferrari"})
  public void dependTest() {
	  System.out.println("----- depeendTest -----");
  }
  
  @Test(timeOut = 100000)
  public void TimeoutTest() {
	  System.out.println("---- Timeout Test -----------");
  }
  
  @Test(groups = {"Sanity","Smoke"})
  public void loginTest() {
	  System.out.println("----- Inside Login Test Sanity Group");
  }
  
  @Parameters({"URL","Name"})
  @Test
  public void ParameterTest(String url,String name) {
	  System.out.println("----- ParameterTest ------- ");
	  System.out.println("URL is "+url);
	  System.out.println("Name is "+name);
  }
}

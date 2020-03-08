package com.test.first;

import com.test.utility.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider ="TestData")
	public void loginTC(String user,String password) {
		System.out.println(" User "+user);
		System.out.println(" Password "+password);
	}
	
	@Test(dataProvider ="Authentication")
	public void AuthTC(String user,String password) {
		System.out.println(" User :"+user);
		System.out.println(" Password :"+password);
	}
	
	@DataProvider
	public Object[][] TestData() {
		Object[][] data = {
				{ "Yogesh","Nipte" } ,
				{ "Priyansha","Nipte" }
				};
		return data;
	}
	
	@DataProvider
	public Object [][] Authentication() throws Exception{
		String filePath = "F:\\Users\\ingle\\git\\repository\\WebDriverTestJan2020\\data\\TestData.xls";
		String sheetName = "Login";
		Object [][] data = ExcelUtils.readExcel(filePath, sheetName);
		
		
		return data;
	}
}

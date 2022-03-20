package testcases;


import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;


public class LoginTest  extends BaseClass {
	
	@Test
		public void LoginFailureTest() {
		
		//test = report.startTest("LoginFailureTest");
		
		LoginPage login = new LoginPage();
		login.LoginFunction("xyz@abc.com", "Abc@12345");
		
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box")); 
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		
		AssertJUnit.assertEquals(ActualMsg, ExpMsg);
		
		
		
		
		}
	
	@Test
	public void LoginSuccessTest() {
		
		LoginPage login = new LoginPage();
		
		login.LoginFunction("deep@abc.com", "Abc@12345");
		
	}
	

@Test // wont run in eclipse runs in xml file
	@Parameters({"Param1","Param2"})
	public void ParameterizedTest(String UserNameVal, String PasswordVal) {
		
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal,PasswordVal);		
		

	}
	

@Test
public void ExternalDataTest() {
		
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal,PasswordVal);		
	}


	
	
}

	
	
  
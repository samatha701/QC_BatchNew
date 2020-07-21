package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;



public class LendNationSubmitApplication extends LendNation{

	  @Test(priority=5)
	  public static void submitApplication(String SSN,String AppURL) throws Exception
	  {
		  try{
			  String FileName= prop.getProperty("file_name");
				ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName); 
			int lastrow=TestData.getLastRow("Submit Application");
			String sheetName="Submit Application";
			WebDriverWait wait = new WebDriverWait(driver, 30000);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{	
			String LoanAmount = TestData.getCellData(sheetName,"LoanAmount",row);
			
			Thread.sleep(40000);
			driver.findElement(locator(prop.getProperty("loan_amount"))).sendKeys(LoanAmount);
			// test.log(LogStatus.INFO, "Lend Nation application navigated to Submit Application page " );
			test.log(LogStatus.INFO, "Lend Nation application navigated to Submit Application page");


			  test.log(LogStatus.PASS, "Entered Loan Amount as : " + LoanAmount);
			  
			  Thread.sleep(10000);
			  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("radio_button_email")))));

			  
			  Thread.sleep(5000);
			

			//driver.findElement(locator(prop.getProperty("check_box_signature"))).click();

			  driver.findElement(locator(prop.getProperty("verification_code_field"))).sendKeys("123");
			  test.log(LogStatus.PASS, "Entered the Verification code " );
			  Thread.sleep(10000);
			  driver.findElement(locator(prop.getProperty("confirm_button"))).click();
			  test.log(LogStatus.PASS, "Clicked on Confirm " );
			  
			  Thread.sleep(5000);
			  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("ratechart_disclosure_checkbox")))));

			  driver.findElement(locator(prop.getProperty("ratechart_disclosure_checkbox"))).click();
			  test.log(LogStatus.PASS, "Checked the radio button of Rate Chart, License and Related State Disclosures " );
/*
			WebElement element = driver.findElement(locator(prop.getProperty("scroll_area1_submit_appplication")));
			 driver.findElement(locator(prop.getProperty("scroll_area1_submit_appplication"))).click();

			Actions action = new Actions(driver);

			action.moveToElement(element);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			
			*/
			  Thread.sleep(5000);
			driver.findElement(locator(prop.getProperty("ability_to_repay_checkbox"))).click();
			test.log(LogStatus.PASS, "Accepted the Rate Chart, License and Related State Disclosures " );
			 Thread.sleep(5000);
			driver.findElement(locator(prop.getProperty("radio_button_email"))).click();
			  test.log(LogStatus.PASS, "Selected Radio button for email documents " );
			Thread.sleep(5000);
			driver.findElement(locator(prop.getProperty("submit_button_under_submit"))).click();
			test.log(LogStatus.PASS, "Clicked on Submit " );
			Thread.sleep(50000);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));
			
			 if( driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).isEnabled())
			  {
					//test.log(LogStatus.PASS, "Submitted Application Successfully with SSN : " +SSN);	
					test.log(LogStatus.PASS, "Submitted Application Successfully with SSN : " +SSN);

				 	}
					else
					{
					test.log(LogStatus.FAIL, " Application not submitted successfully with SSN : " +SSN);
					}


		
				}
				}
			
		  }
		  catch(Exception e)
		  {
			  test.log(LogStatus.ERROR, "Unable to submit App with SSN  " +SSN);
			  test.log(LogStatus.ERROR, "Error message  " +e);
			  String screenshotPath = getScreenhot(driver, "Submit");
			  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
			

		  }
			
			
			}

}

package tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;

public class LendNationLoanDecision extends LendNation{

	  @Test(priority=4)
	  public static void loandecision(String SSN,String AppURL) throws Exception
		  
	  {
	                int lastrow=TestData.getLastRow("Loan Decision");
					String sheetName="Loan Decision";

					for(int row=2;row<=lastrow;row++)
					{		
						String RegSSN = TestData.getCellData(sheetName,"SSN",row);
	  
				if(SSN.equals(RegSSN))
				{	
			//String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row);
			  String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			  String Verification_Code = TestData.getCellData(sheetName,"Verification_Code",row);
			
			Thread.sleep(500);
			test.log(LogStatus.INFO, "******Lend Nation application navigated to Loan Decision page******" );
			Thread.sleep(5000);
			  //wait.until(ExpectedConditions.elementToBeClickable(locator(prop.getProperty("repayment_method_type"))));
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rad1']")));
			  
			  if (ProductID.equals("PDL")) {	 
			     driver.findElement(By.xpath("//*[@id='pdlloan']/span")).click();
			     test.log(LogStatus.PASS, "Product Type selected as : " +ProductID);
			  }
			     else{
			     driver.findElement(By.xpath("//*[@id='insloan']/span")).click();
			     //test.log(LogStatus.PASS, "Clicked on Installment Loan Radio buton " );
			     test.log(LogStatus.PASS, "Product Type selected as : " +ProductID);
			     }
			  
			  //Thread.sleep(5000);
			  
			  //driver.findElement(By.xpath("//*[@id='productSelectBtn']")).click();
			
			  test.log(LogStatus.PASS, "Clicked on Next button " );

			  Thread.sleep(30000);
			  Thread.sleep(30000);
			  Thread.sleep(30000);
			  
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loanAmt']")));
			  Thread.sleep(30000);
			  
			  String MaxEligibleLoanamount = driver.findElement(By.xpath("//*[@id='maxAmt']")).getAttribute("value");
			  test.log(LogStatus.PASS, "Max Eligible Loan amount is : " +MaxEligibleLoanamount );
			  
			  Thread.sleep(500);
			  
			  String Loanamount = driver.findElement(By.name("loanAmt")).getAttribute("value");
			  test.log(LogStatus.PASS, "Loan amount is : " +Loanamount );
			  
			  Thread.sleep(500);
			  			     
			  driver.findElement(By.xpath("//input[@value='3' and @type='radio']")).click();
			  test.log(LogStatus.PASS, "Clicked on send email Radio button " );
			  
			  Thread.sleep(500);
			  
			  driver.findElement(By.name("aEmailVerificationCode")).sendKeys(Verification_Code);
			  test.log(LogStatus.PASS, "Verification Code set as : " +Verification_Code );
			  
			  Thread.sleep(500);
			  
			  driver.findElement(By.xpath("//*[@id='confirm']")).click();
			  test.log(LogStatus.PASS, "Clicked on Verification Confirm button " );
			  
			  Thread.sleep(500);
			  			 
			 /* if(driver.findElement(By.xpath("//*[@id='msg']/span")).isDisplayed())
				                              
			    	
			 	{
				
					 test.log(LogStatus.FAIL,"Verification Code Doesn't Match");
					 
					 
					 //Assert.assertTrue(false);

			 	}
			 	else
				{
				
				 test.log(LogStatus.PASS,"Verification Code Match");

				}*/
			  
			  driver.findElement(By.xpath("//*[@id='loanRateChartChk']")).click();
			  test.log(LogStatus.PASS, "Clicked on Rate Chart Check Box " );
			  
			  Thread.sleep(1000);
			  
			  driver.findElement(By.xpath("//*[@id='abilityToRepayChk']")).click();
			  test.log(LogStatus.PASS, "Clicked on Ability to Repay Check Box " );
			  
              Thread.sleep(1000);
			  
		
			  driver.findElement(By.xpath("//*[@id='productSubmitBtn']")).click();
			  test.log(LogStatus.PASS, "Clicked on Submit Button " );
			  test.log(LogStatus.INFO, "******************************************************** ");
			  
			  Thread.sleep(30000);
			  Thread.sleep(1000);
			 
               
			break;
		
			
			
				}
			}
			
		
	  }
	  
	  

}

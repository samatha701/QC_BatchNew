package tests;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;


import tests.LendNation;

public class OnlineLogin extends LendNation{
	
	
	
	
	public static void login(String SSN,String AppURL) throws Exception
		
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("OnlineLogin");
				String sheetName="OnlineLogin";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{	
				
			String state = TestData.getCellData(sheetName,"State",row);
			String email1 = TestData.getCellData(sheetName,"Email",row);
			String email2 = TestData.getCellData(sheetName,"EmailExt",row);
			String email=email1.concat(email2);
			String password = TestData.getCellData(sheetName,"Password",row);
			
			String SSN1 = SSN.substring(0, 3);
		    String SSN2 = SSN.substring(3,5);
		    String SSN3 = SSN.substring(5,9);
		    
			
			
		  //driver.get(AppURL);
		    
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			
		
		  driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
		
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Opened Lend Nation Portal For Esign ********* ");
		  test.log(LogStatus.INFO, "******************************************************** ");

		  Thread.sleep(2000);
		  
		    //driver.findElement(locator(prop.getProperty("Automation_link"))).click();
		    //driver.findElement(locator(prop.getProperty("QTP_link"))).click();
		  
		    driver.findElement(By.xpath("/html/body/div/div[2]/div/a")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");
		    
		  //driver.findElement(By.xpath("/html/body/div/div[4]/div/a")).click();	
		  //test.log(LogStatus.PASS, "Clicked on Pre-Prod link ");
		  //test.log(LogStatus.PASS, "Clicked on QTP link ");

		  Thread.sleep(4000);
		  try{
			 // 
			  
			  new Select(driver.findElement(locator(prop.getProperty("state_selection")))).selectByVisibleText(state);
			  test.log(LogStatus.PASS, "Selected the State : "+state);
			
			  
			  driver.findElement(locator(prop.getProperty("continue_button"))).click();
			  test.log(LogStatus.PASS, "Clicked on Continue button ");

		  }
		  catch(Exception e)
		  {
			  System.out.println("under catch");
			  //driver.findElement(By.xpath("//div[id='StateConfirmation']/div/div/div/div[2]/select")).click();
		  }
	  
		  Thread.sleep(4000);
		  
		  
//========================  Script For Login Through Email =================

		  driver.findElement(By.xpath("//*[@id='loginCaption']")).click();
		  test.log(LogStatus.PASS, "Clicked on Login button ");
		  
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
		  test.log(LogStatus.PASS, "User Name Enter as : " +email);

		  Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		  test.log(LogStatus.PASS, "Password Enter as : " +password);
		  
          Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='loginbtn']")).click();
		  test.log(LogStatus.PASS, "Clicked on Login");
		  
		  Thread.sleep(10000);
		  
		  driver.findElement(By.xpath("//*[@id='needEsign']")).click();
		  test.log(LogStatus.PASS, "Clicked on Need Esign Tab");
		  
		  Thread.sleep(20000);
		  
		  test.log(LogStatus.INFO, "****** Navigating to Sign Contract PAge ****** ");
		  		  
		  LendNationSignContract.signContract(SSN, AppURL);
		
		

			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Completed Successfully with SSN : " +SSN);
			test.log(LogStatus.INFO, "******************************************************** ");
			

		  
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Unable to Login through Email");
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "OnlineLogin");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }

	public static void refinance(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Refinance");
				String sheetName="Refinance";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{	
				
			String state = TestData.getCellData(sheetName,"State",row);
			String email1 = TestData.getCellData(sheetName,"Email",row);
			String email2 = TestData.getCellData(sheetName,"EmailExt",row);
			String email=email1.concat(email2);
			String password = TestData.getCellData(sheetName,"Password",row);
			String Payment_Method = TestData.getCellData(sheetName,"Payment_Method",row);
			String firstname = TestData.getCellData(sheetName,"FirstName",row);
			String lastname = TestData.getCellData(sheetName,"LastName",row);
			String Signaturename=firstname+" "+lastname;
			
			String SSN1 = SSN.substring(0, 3);
		    String SSN2 = SSN.substring(3,5);
		    String SSN3 = SSN.substring(5,9);
		    
			
			
		  //driver.get(AppURL);
		    
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			
		
		  driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
		
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Opened Lend Nation Portal For Refinance ********* ");
		  test.log(LogStatus.INFO, "******************************************************** ");

		  Thread.sleep(2000);
		  
		    //driver.findElement(locator(prop.getProperty("Automation_link"))).click();
		    //driver.findElement(locator(prop.getProperty("QTP_link"))).click();
		  
		    driver.findElement(By.xpath("/html/body/div/div[2]/div/a")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");
		    
		  //driver.findElement(By.xpath("/html/body/div/div[4]/div/a")).click();	
		  //test.log(LogStatus.PASS, "Clicked on Pre-Prod link ");
		  //test.log(LogStatus.PASS, "Clicked on QTP link ");

		  Thread.sleep(4000);
		  try{
			 // 
			  
			  new Select(driver.findElement(locator(prop.getProperty("state_selection")))).selectByVisibleText(state);
			  test.log(LogStatus.PASS, "Selected the State : "+state);
			
			  
			  driver.findElement(locator(prop.getProperty("continue_button"))).click();
			  test.log(LogStatus.PASS, "Clicked on Continue button ");

		  }
		  catch(Exception e)
		  {
			  System.out.println("under catch");
			  //driver.findElement(By.xpath("//div[id='StateConfirmation']/div/div/div/div[2]/select")).click();
		  }
	  
		  Thread.sleep(4000);
		  
		  
//========================  Script For Login Through Email =================

		  driver.findElement(By.xpath("//*[@id='loginCaption']")).click();
		  test.log(LogStatus.PASS, "Clicked on Login button ");
		  
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
		  test.log(LogStatus.PASS, "User Name Enter as : " +email);

		  Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		  test.log(LogStatus.PASS, "Password Enter as : " +password);
		  
          Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='loginbtn']")).click();
		  test.log(LogStatus.PASS, "Clicked on Login");
		  
		  Thread.sleep(30000);
		  				  
		  Thread.sleep(20000);
				  
		  
//======================================  Refinance Started =======================================================
		  //Thread.sleep(20000);
		  
		  //driver.findElement(By.xpath("//*[@id='extendLoan10863923']")).click();
		  driver.findElement(By.xpath("//input[@value='Extend/Refinance ' and @type='button']")).click();
	
		  test.log(LogStatus.PASS, "Clicked on Refinance Tab");
		 
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rad1']")));
		  Thread.sleep(1000);
		 
		  driver.findElement(By.xpath("//*[@id='rad1']")).click();
		  test.log(LogStatus.PASS, "Clicked on Minimum Payment Amount Radio button");
		  
		  Thread.sleep(500);
		  
		  
//====================================================================================
		  if(Payment_Method.equalsIgnoreCase("ACH")){
			  
			  driver.findElement(By.xpath("//*[@id='paymentType']")).sendKeys(Payment_Method);
			  test.log(LogStatus.PASS, "Payment Method Selected as :" +Payment_Method);
			  Thread.sleep(5000);
				 
				  
			  driver.findElement(By.xpath("//*[@id='getloan']")).click();
			  test.log(LogStatus.PASS, "Clicked on Continue button");
				  
			  Thread.sleep(10000);
				
		  }
				  else if(Payment_Method.equalsIgnoreCase("DEBIT CARD")){
					  test.log(LogStatus.PASS, "Receive Type is : "+Payment_Method);  
				  }
				
			
				
		  
		  
//=====================================================================================
		  
		 /* driver.findElement(By.xpath("//*[@id='paymentType']")).sendKeys(Payment_Method);
		  test.log(LogStatus.PASS, "Payment Method Selected as :" +Payment_Method);
		  
		  Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='getloan']")).click();
		  test.log(LogStatus.PASS, "Clicked on Continue button");
		  
		  Thread.sleep(10000);*/
		  
		  
		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='getLoanNowButton']")));
		 // driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
		  //test.log(LogStatus.PASS, "Clicked on get loan button");
		  Thread.sleep(15000);

		   //test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Completed Successfully with SSN : " +SSN);
		  test.log(LogStatus.INFO, "**************** Navigating To Sign Contract Page ************************* ");
		  Thread.sleep(500);
		    System.out.println("Under SignContract");
			driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();
			//test.log(LogStatus.INFO, "Lend Nation application navigated to Sign Contract page ");
			


			test.log(LogStatus.PASS, "Checked the first checkbox ");
			Thread.sleep(3000);
			driver.findElement(locator(prop.getProperty("checkbox2_signpage"))).click();
			test.log(LogStatus.PASS, "Checked the second checkbox");
			Thread.sleep(3000);

			driver.findElement(locator(prop.getProperty("checkbox3_signpage"))).click();
			test.log(LogStatus.PASS, "Checked the third checkbox");
			Thread.sleep(3000);

			driver.findElement(locator(prop.getProperty("checkbox4_signpage"))).click();

			test.log(LogStatus.PASS, "Checked the fourth checkbox");
			//driver.findElement(locator(prop.getProperty("signature_field1"))).sendKeys(Signaturename);
			driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);
			//*[@id="SignatureRequired0"]
			test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
			Thread.sleep(3000);

			//driver.findElement(locator(prop.getProperty("checkbox5_signpage"))).click();
			driver.findElement(By.xpath("//*[@id='checkBox4']")).click();
			test.log(LogStatus.PASS, "Checked the fifth checkbox");
			
			Thread.sleep(1000);
			
			//driver.findElement(locator(prop.getProperty("signature_field2"))).sendKeys(Signaturename);
			driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);			
			test.log(LogStatus.PASS, "Entered the Second Signature field details as : "+Signaturename);
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id='checkBox5']")).click();
			test.log(LogStatus.PASS, "Checked the Sixth checkbox");
			
			Thread.sleep(1000);
			
			//driver.findElement(locator(prop.getProperty("signature_field3"))).sendKeys(Signaturename);
			driver.findElement(By.xpath("//*[@id='SignatureRequired2']")).sendKeys(Signaturename);
			test.log(LogStatus.PASS, "Entered the Second Signature field details as : "+Signaturename);
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id='checkBox6']")).click();
			test.log(LogStatus.PASS, "Checked the Sixth checkbox");
			
          Thread.sleep(1000);
			
			//driver.findElement(locator(prop.getProperty("signature_field2"))).sendKeys(Signaturename);
          //driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);
          driver.findElement(By.xpath("//*[@id='SignatureRequired3']")).sendKeys(Signaturename);
			test.log(LogStatus.PASS, "Entered the Second Signature field details as : "+Signaturename);
			
			 driver.findElement(By.xpath("//*[@id='SignatureRequired4']")).sendKeys(Signaturename);
			 test.log(LogStatus.PASS, "Entered the Second Signature field details as : "+Signaturename);
			 
			 Thread.sleep(1000);
			
			
			Thread.sleep(2000);
			
			driver.findElement(locator(prop.getProperty("get_loan_button"))).click();
			test.log(LogStatus.PASS, "Clicked on Get New Loan button");
			
			Thread.sleep(30000);
			
			String Refinance_Msg = driver.findElement(By.xpath("//*[@id='submit']/h2")).getText();
			test.log(LogStatus.PASS, "Message : " +Refinance_Msg);
			
			test.log(LogStatus.INFO, "**************** Refinance Finished ************************* ");
			Thread.sleep(2000);
			driver.close();
			Thread.sleep(2000);

		  
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				//test.log(LogStatus.ERROR, "Unable to Login through Email");
				//test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "OnlineLogin");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }
	
	
	
	
}

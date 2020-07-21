package tests;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
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

public class LendNationRegistration extends LendNation{
	
	
	
	
	public static void registration(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

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
		    
			String security_question_a = TestData.getCellData(sheetName,"SecurityQuestionA",row);
			String security_question_answer_a = TestData.getCellData(sheetName,"SecurityAnswerA",row);
				
			String security_question_b = TestData.getCellData(sheetName,"SecurityQuestionB",row);
			String security_question_answer_b = TestData.getCellData(sheetName,"SecurityAnswerB",row);
				
			String security_question_c = TestData.getCellData(sheetName,"SecurityQuestionC",row);
			String security_question_answer_c = TestData.getCellData(sheetName,"SecurityAnswerC",row);
				



			System.out.println(state);
			
		  //driver.get(AppURL);
			
		
		  driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);

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
		 
		  
		  
		  //new Select(driver.findElement(By.xpath("//select[@class='form-control valid']"))).selectByVisibleText(state);
		  Thread.sleep(4000);
		 // test.log(LogStatus.INFO, "Lend Nation application navigated to Registration page",ExtentColor.GREEN);

		  

		  driver.findElement(locator(prop.getProperty("start_new_loan_button"))).click();
		  test.log(LogStatus.PASS, "Clicked on Start New Loan button");
		  //test.log(LogStatus.INFO, "Lend Nation application navigated to Registration page" );
		test.log(LogStatus.INFO, "*******Lend Nation application navigated to Registration page*******");

		  //test.log(LogStatus.INFO, "Lend Nation application navigated to Registration page", ExtentColor.GREEN));
		//test.log(LogStatus.PASS,(Throwable) "Test Case Passed is passTest", ExtentColor.GREEN));



		  //driver.findElement(By.linkText("START LOAN APPLICATION ")).click();
		  Thread.sleep(2000);

		  driver.findElement(locator(prop.getProperty("email_field"))).sendKeys(email);
		  test.log(LogStatus.PASS, "Entered Email : "+email);

		  
		  driver.findElement(locator(prop.getProperty("confirm_email_field"))).sendKeys(email);
		  test.log(LogStatus.PASS, "Entered confirm Email : "+email);

		  
		  
		  driver.findElement(locator(prop.getProperty("password_field"))).sendKeys(password);
		  test.log(LogStatus.PASS, "Entered Password : "+password);

		   driver.findElement(locator(prop.getProperty("confirm_password_field"))).sendKeys(password);
		  test.log(LogStatus.PASS, "Entered confirm Password : "+password);

		 
		  driver.findElement(locator(prop.getProperty("SSN_first_field"))).sendKeys(SSN1);
		  driver.findElement(locator(prop.getProperty("SSN_second_field"))).sendKeys(SSN2);
		  driver.findElement(locator(prop.getProperty("SSN_third_field"))).sendKeys(SSN3);
		  test.log(LogStatus.PASS, "Entered SSN Number : "+SSN);

		  //new Select(driver.findElement(By.id("question0"))).selectByIndex(1);

		  /*
		 try{
			 new Select(driver.findElement(By.id("question0"))).selectByVisibleText(security_question);
		 }
		  catch(Exception e){
			  new Select(driver.findElement(By.id("question0"))).selectByIndex(1);
		  }
	*/
		  int i_security_question_a=Integer.parseInt(security_question_a);
		  new Select(driver.findElement(locator(prop.getProperty("question_first_field")))).selectByIndex(i_security_question_a);
		  test.log(LogStatus.PASS, "Selected the first question  ");
		  

		  driver.findElement(locator(prop.getProperty("answer_fisrt_field"))).sendKeys(security_question_answer_a);
		  test.log(LogStatus.PASS, "Entered the first question answer as "+ security_question_answer_a);

		  int i_security_question_b=Integer.parseInt(security_question_b);
		  new Select(driver.findElement(locator(prop.getProperty("question_second_field")))).selectByIndex(i_security_question_b);
		  test.log(LogStatus.PASS, "Selected the second question  " );

		  driver.findElement(locator(prop.getProperty("answer_second_field"))).sendKeys(security_question_answer_b);
		  test.log(LogStatus.PASS, "Entered the second question answer as "+ security_question_answer_b);

		  int i_security_question_c=Integer.parseInt(security_question_c);
		  new Select(driver.findElement(locator(prop.getProperty("question_third_field")))).selectByIndex(i_security_question_c);
		  test.log(LogStatus.PASS, "Selected the third question  ");
		  driver.findElement(locator(prop.getProperty("answer_third_field"))).sendKeys(security_question_answer_c);
		  test.log(LogStatus.PASS, "Entered the third question answer  as "+ security_question_answer_c);
		  Thread.sleep(3000);
		 // driver.findElement(By.xpath("//span[@id='recaptcha-anchor' and @tabindex='0']/div[5]")).click();  // Added on 29-01-2019
		 // test.log(LogStatus.PASS, "Clicked on Captha button ");
		  Thread.sleep(3000);
		  driver.findElement(locator(prop.getProperty("submit_button"))).click();
		  test.log(LogStatus.PASS, "Clicked on Submit button ");
		  
		

		  Thread.sleep(20000);
		 // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("firstname_field")))));
		/*  if( driver.findElement(locator(prop.getProperty("firstname_field"))).isEnabled())
		  {
				//test.log(LogStatus.PASS, "Registered Successfully with SSN : " +SSN);	
				test.log(LogStatus.PASS, "Registered Successfully with SSN : " +SSN,);

			 	}
				else
				{
				test.log(LogStatus.FAIL, "Registered is not Successfull with SSN  : " +SSN);
				}*/
			//test.log(LogStatus.PASS, "Registered Successfully with SSN : " +SSN);
		  
		  try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				//if alert present, accept and move on.

			}
			catch (NoAlertPresentException e) {
				//do what you normally would if you didn't have the alert.
			}
		  Thread.sleep(1000);
		  try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				//if alert present, accept and move on.

			}
			catch (NoAlertPresentException e) {
				//do what you normally would if you didn't have the alert.
			}

			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Registration Completed Successfully with SSN : " +SSN);
			test.log(LogStatus.INFO, "******************************************************** ");
			

		  
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "registration Information is not successfully filled with SSN : " +SSN);
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "registration");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }

}

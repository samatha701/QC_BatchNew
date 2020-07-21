package tests;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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


//import tests.LendNation;
import tests.QCStore;

public class LendNationRegistration extends QCStore{
	
	
	
	
	public static void registration(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";
				
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//WebDriverWait wait = new WebDriverWait(driver, 5000);
				

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
			String SSNorITIN = TestData.getCellData(sheetName,"SSNorITIN",row);
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
			
		
		  driver.get("https://qcln.qfund.net:8090/");
		  test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);

		  Thread.sleep(2000);
		  //html/body/div/div/div/a[4]
		    driver.findElement(By.xpath("/html/body/div/div/div/a[4]")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");

		  Thread.sleep(4000);
		
		 		 
		 // Thread.sleep(4000);

		  driver.findElement(By.linkText("APPLY NOW")).click();
		  test.log(LogStatus.PASS, "Clicked on APPLY NOW button");
		  Thread.sleep(4000);
		  test.log(LogStatus.INFO, "*******Lend Nation application navigated to Create An Account Page *******");

		  Thread.sleep(2000);

		  driver.findElement(locator(prop.getProperty("email_field"))).sendKeys(email);
		  test.log(LogStatus.PASS, "Entered Email : "+email);

		  
		  driver.findElement(locator(prop.getProperty("confirm_email_field"))).sendKeys(email);
		  test.log(LogStatus.PASS, "Entered confirm Email : "+email);

		  
		  
		  driver.findElement(locator(prop.getProperty("password_field"))).sendKeys(password);
		  test.log(LogStatus.PASS, "Entered Password : "+password);

		   driver.findElement(locator(prop.getProperty("confirm_password_field"))).sendKeys(password);
		   test.log(LogStatus.PASS, "Entered confirm Password : "+password);
		   
		   Thread.sleep(500);
		   
		   driver.findElement(By.name("idType")).sendKeys(SSNorITIN);
		   test.log(LogStatus.PASS, "SSN Selected");
		   
		   Thread.sleep(500);
		 
		  /*driver.findElement(locator(prop.getProperty("SSN_first_field"))).sendKeys(SSN1);
		  driver.findElement(locator(prop.getProperty("SSN_second_field"))).sendKeys(SSN2);
		  driver.findElement(locator(prop.getProperty("SSN_third_field"))).sendKeys(SSN3);*/
		  driver.findElement(By.name("SSN")).sendKeys(SSN);
		  test.log(LogStatus.PASS, "Entered SSN Number : "+SSN);

		
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
		  //driver.findElement(locator(prop.getProperty("submit_button"))).click();
		  driver.findElement(By.xpath("//*[@id='apply']/div[7]/button[1]")).click();
		  test.log(LogStatus.PASS, "Clicked on Create Your Account button ");
		  
		

		  Thread.sleep(10000);
		
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

			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Create Account Completed Successfully with SSN : " +SSN);
			test.log(LogStatus.INFO, "******************************************************** ");
			

		  
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Create Account Information is not successfully filled with SSN : " +SSN);
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "registration");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }
	
public static void registration_with_invalidITIN(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";
				
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//WebDriverWait wait = new WebDriverWait(driver, 5000);
				

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
			String SSNorITIN = TestData.getCellData(sheetName,"SSNorITIN",row);
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
			
		
		  driver.get("https://qcln.qfund.net:8090/");
		  test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);

		  Thread.sleep(2000);
		  //html/body/div/div/div/a[4]
		    driver.findElement(By.xpath("/html/body/div/div/div/a[4]")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");

		  Thread.sleep(4000);
		
		 		 
		 // Thread.sleep(4000);

		  driver.findElement(By.linkText("APPLY NOW")).click();
		  test.log(LogStatus.PASS, "Clicked on APPLY NOW button");
		  Thread.sleep(4000);
		  test.log(LogStatus.INFO, "*******Lend Nation application navigated to Create An Account Page *******");

		  Thread.sleep(2000);

		  driver.findElement(locator(prop.getProperty("email_field"))).sendKeys(email);
		  test.log(LogStatus.PASS, "Entered Email : "+email);

		  
		  driver.findElement(locator(prop.getProperty("confirm_email_field"))).sendKeys(email);
		  test.log(LogStatus.PASS, "Entered confirm Email : "+email);

		  
		  
		  driver.findElement(locator(prop.getProperty("password_field"))).sendKeys(password);
		  test.log(LogStatus.PASS, "Entered Password : "+password);

		   driver.findElement(locator(prop.getProperty("confirm_password_field"))).sendKeys(password);
		   test.log(LogStatus.PASS, "Entered confirm Password : "+password);
		   
		   Thread.sleep(500);
		   
		   driver.findElement(By.name("idType")).sendKeys(SSNorITIN);
		   test.log(LogStatus.PASS, "SSN Selected");
		   
		   Thread.sleep(500);
		 
		  /*driver.findElement(locator(prop.getProperty("SSN_first_field"))).sendKeys(SSN1);
		  driver.findElement(locator(prop.getProperty("SSN_second_field"))).sendKeys(SSN2);
		  driver.findElement(locator(prop.getProperty("SSN_third_field"))).sendKeys(SSN3);*/
		  driver.findElement(By.name("SSN")).sendKeys(SSN);
		  test.log(LogStatus.PASS, "Entered SSN Number : "+SSN);

		
		  int i_security_question_a=Integer.parseInt(security_question_a);
		  new Select(driver.findElement(locator(prop.getProperty("question_first_field")))).selectByIndex(i_security_question_a);
		  test.log(LogStatus.PASS, "Selected the first question  ");
		 WebElement e= driver.findElement(By.xpath("//*[@id='eidtype']/center/span/strong"));
		 if(e.isDisplayed())
		 {
			 test.log(LogStatus.PASS, "test passed");
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "test failed");
		 }
		 
		  

		  			

		  
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Create Account Information is not successfully filled with SSN : " +SSN);
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "registration");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }

	
public static void store_customersetup(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Borrower_Registration");
				String sheetName="Borrower_Registration";
				
				/*driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
				//WebDriverWait wait = new WebDriverWait(driver, 5000);
				

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
			String SSNorITIN = TestData.getCellData(sheetName,"SSNorITIN",row);
			
			String SSN1 = SSN.substring(0, 3);
		    String SSN2 = SSN.substring(3,5);
		    String SSN3 = SSN.substring(5,9);
		    
			String security_question_a = TestData.getCellData(sheetName,"SecurityQuestionA",row);
			String security_question_answer_a = TestData.getCellData(sheetName,"SecurityAnswerA",row);
				
			String security_question_b = TestData.getCellData(sheetName,"SecurityQuestionB",row);
			String security_question_answer_b = TestData.getCellData(sheetName,"SecurityAnswerB",row);
				
			String security_question_c = TestData.getCellData(sheetName,"SecurityQuestionC",row);
			String security_question_answer_c = TestData.getCellData(sheetName,"SecurityAnswerC",row);
				
			String FirstName = TestData.getCellData(sheetName,"FirstName",row);
			String LastName = TestData.getCellData(sheetName,"LastName",row);
			String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);


			System.out.println(state);
			
		  //driver.get(AppURL);
			
		
		 /* driver.get("https://qcln.qfund.net:8090/");
		  test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);*/

		  Thread.sleep(2000);
		  //html/body/div/div/div/a[4]
		    driver.findElement(By.xpath("/html/body/div/div/div/a[4]")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");

		  Thread.sleep(4000);
		
		 		 
		//driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
		  driver.findElement(By.linkText("Sign In")).click(); 
		test.log(LogStatus.PASS, "Clicked on sign in button");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='loginForm']/div[8]/button")).click();
		test.log(LogStatus.PASS, "Clicked on store customer setup button");
		Thread.sleep(5000);
		driver.findElement(By.name("FirstName1")).sendKeys(FirstName);
		test.log(LogStatus.PASS, "FirstName entered as" +FirstName);
		driver.findElement(By.xpath("//*[@id='LastName1']")).sendKeys(LastName);
		test.log(LogStatus.PASS, "LastName entered as" +LastName);
		driver.findElement(By.xpath("//*[@id='idType']")).sendKeys(SSNorITIN);
		//*[@id="idType"]
		driver.findElement(By.xpath("//*[@id='SSN']")).sendKeys(SSN);
		test.log(LogStatus.PASS, "SSN entered as" +SSN);
		WebElement dateBox = driver.findElement(By.xpath("//*[@id='dateOfBirth']"));
        dateBox.click();
        test.log(LogStatus.PASS, "Clicked On DOB Calender");
        Thread.sleep(300);
        WebElement year = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]"));
        year.click();
        Thread.sleep(300);
        test.log(LogStatus.PASS, "Clicked On Year");
        Actions action1 = new Actions(driver);

		action1.moveToElement(year);
        action1.sendKeys(Keys.PAGE_UP).build().perform();
        Thread.sleep(300);
        action1.sendKeys(Keys.PAGE_UP).build().perform();
        Thread.sleep(300);
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']")).click();
        //driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[6]/a")).click();
        Thread.sleep(300);
        String Dob = driver.findElement(By.xpath("//*[@id='dateOfBirth']")).getAttribute("value");
	   System.out.println(Dob);
		test.log(LogStatus.PASS, "Entered DOB as  :"+ Dob);
		 Thread.sleep(300);
		 driver.findElement(By.xpath("//*[@id='ZipCode']")).sendKeys(ZipCode);
		 test.log(LogStatus.PASS, "ZipCode entered as" +ZipCode);
		 driver.findElement(By.xpath("//*[@id='EmailAddress']")).sendKeys(email);
		 test.log(LogStatus.PASS, "email entered as" +email);
		 driver.findElement(By.xpath("//*[@id='PasswordVal']")).sendKeys(password);
		 test.log(LogStatus.PASS, "password entered as" +password);
		 driver.findElement(By.xpath("//*[@id='PasswordConfirmation']")).sendKeys(password);
		 test.log(LogStatus.PASS, "confirm password entered as" +password);
		 int i_security_question_a=Integer.parseInt(security_question_a);
		  new Select(driver.findElement(By.xpath("//*[@id='question0']"))).selectByIndex(i_security_question_a);
		  test.log(LogStatus.PASS, "Selected the first question  ");
		  

		  driver.findElement(By.xpath("//*[@id='answer0']")).sendKeys(security_question_answer_a);
		  test.log(LogStatus.PASS, "Entered the first question answer as "+ security_question_answer_a);

		  int i_security_question_b=Integer.parseInt(security_question_b);
		  new Select(driver.findElement(By.xpath("//*[@id='question1']"))).selectByIndex(i_security_question_b);
		  test.log(LogStatus.PASS, "Selected the second question  " );

		  driver.findElement(By.xpath("//*[@id='answer1']")).sendKeys(security_question_answer_b);
		  test.log(LogStatus.PASS, "Entered the second question answer as "+ security_question_answer_b);

		  int i_security_question_c=Integer.parseInt(security_question_c);
		  new Select(driver.findElement(By.xpath("//*[@id='question2']"))).selectByIndex(i_security_question_c);
		  test.log(LogStatus.PASS, "Selected the third question  ");
		  driver.findElement(By.xpath("//*[@id='answer2']")).sendKeys(security_question_answer_c);
		  test.log(LogStatus.PASS, "Entered the third question answer  as "+ security_question_answer_c);
		  
		  driver.findElement(By.xpath("//*[@id='submitOnBoarding']")).click();
		
		  test.log(LogStatus.PASS, "Clicked on submit button");
		  Thread.sleep(10000);
		  try{
			  driver.findElement(By.xpath("//*[@id='submitOnBoarding']")).click();
				
			  test.log(LogStatus.PASS, "Clicked on submit button");
		  }
		catch(Exception e){
			
		}
		  Thread.sleep(3000);
		  if(driver.findElement(By.xpath("//*[@id='sucessLogin']/div/div/div[2]/div/div[1]/div/center/a/button")).isDisplayed())
		  {                                 
			  test.log(LogStatus.PASS, "test passed");
			  driver.close();
		  }
		 

		  
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.FAIL, "Create Account Information is not successfully filled with SSN : " +SSN);
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "registration");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }

public static void forgot_username(String SSN,String AppURL) throws Exception	

{
	 
	try{
		//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("Personal Information");
			String sheetName="Personal Information";
			
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//WebDriverWait wait = new WebDriverWait(driver, 5000);
			

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
		String SSNorITIN = TestData.getCellData(sheetName,"SSNorITIN",row);
		
		String SSN1 = SSN.substring(0, 3);
	    String SSN2 = SSN.substring(3,5);
	    String SSN3 = SSN.substring(5,9);
	    
		String security_question_a = TestData.getCellData(sheetName,"SecurityQuestionA",row);
		String security_question_answer_a = TestData.getCellData(sheetName,"SecurityAnswerA",row);
			
		String security_question_b = TestData.getCellData(sheetName,"SecurityQuestionB",row);
		String security_question_answer_b = TestData.getCellData(sheetName,"SecurityAnswerB",row);
			
		String security_question_c = TestData.getCellData(sheetName,"SecurityQuestionC",row);
		String security_question_answer_c = TestData.getCellData(sheetName,"SecurityAnswerC",row);
			
		String FirstName = TestData.getCellData(sheetName,"FirstName",row);
		String LastName = TestData.getCellData(sheetName,"LastName",row);
		String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);


		System.out.println(state);
		
	  //driver.get(AppURL);
		
	
	  driver.get("https://qcln.qfund.net:8090/");
	  test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);

	  Thread.sleep(2000);
	  //html/body/div/div/div/a[4]
	    driver.findElement(By.xpath("/html/body/div/div/div/a[4]")).click();	
	    test.log(LogStatus.PASS, "Clicked on QTP link ");

	  Thread.sleep(4000);
	
	 		 
	driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
	test.log(LogStatus.PASS, "Clicked on sign in button");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id='loginForm']/div[5]/div/div[2]/div/a[1]")).click();
	Thread.sleep(5000);
	String ssn = driver.findElement(By.xpath("//*[@id='ForgotRequestSsn']")).getAttribute("value");
	test.log(LogStatus.INFO, ssn);
	if(ssn.contains("xx"))
	{
		test.log(LogStatus.PASS, "test passed");
	}
	
	  
		break;
		}
	}
  }
	 catch(Exception e)
	  {
			test.log(LogStatus.ERROR, "Create Account Information is not successfully filled with SSN : " +SSN);
			test.log(LogStatus.ERROR, "Error message  " +e);
			  String screenshotPath = getScreenhot(driver, "registration");
			  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
			Assert.assertTrue(false);
	
}
  
  }


public static void store_customersetup_WithSSN(String SSN,String AppURL) throws Exception	

{
	 
	try{
		//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("Personal Information");
			String sheetName="Personal Information";
			
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//WebDriverWait wait = new WebDriverWait(driver, 5000);
			

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
			
		String FirstName = TestData.getCellData(sheetName,"FirstName",row);
		String LastName = TestData.getCellData(sheetName,"LastName",row);
		String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);


		System.out.println(state);
		
	  //driver.get(AppURL);
		
	
	  driver.get("https://qcln.qfund.net:8090/");
	  test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);

	  Thread.sleep(2000);
	  //html/body/div/div/div/a[4]
	    driver.findElement(By.xpath("/html/body/div/div/div/a[4]")).click();	
	    test.log(LogStatus.PASS, "Clicked on QTP link ");

	  Thread.sleep(4000);
	
	 		 
	driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
	test.log(LogStatus.PASS, "Clicked on sign in button");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id='loginForm']/div[8]/button")).click();
	test.log(LogStatus.PASS, "Clicked on store customer setup button");
	driver.findElement(By.xpath("//*[@id='FirstName1']")).sendKeys(FirstName);
	test.log(LogStatus.PASS, "FirstName entered as" +FirstName);
	driver.findElement(By.xpath("//*[@id='LastName1']")).sendKeys(LastName);
	test.log(LogStatus.PASS, "LastName entered as" +LastName);
	driver.findElement(By.xpath("//*[@id='idType']")).sendKeys("SSN");
	//*[@id="idType"]
	driver.findElement(By.xpath("//*[@id='SSN']")).sendKeys(SSN);
	test.log(LogStatus.PASS, "SSN entered as" +SSN);
	WebElement dateBox = driver.findElement(By.xpath("//*[@id='dateOfBirth']"));
    dateBox.click();
    test.log(LogStatus.PASS, "Clicked On DOB Calender");
    Thread.sleep(300);
    WebElement year = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]"));
    year.click();
    Thread.sleep(300);
    test.log(LogStatus.PASS, "Clicked On Year");
    Actions action1 = new Actions(driver);

	action1.moveToElement(year);
    action1.sendKeys(Keys.PAGE_UP).build().perform();
    Thread.sleep(300);
    action1.sendKeys(Keys.PAGE_UP).build().perform();
    Thread.sleep(300);
    driver.findElement(By.xpath("//*[@id='ui-datepicker-div']")).click();
    //driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[6]/a")).click();
    Thread.sleep(300);
    String Dob = driver.findElement(By.xpath("//*[@id='dateOfBirth']")).getAttribute("value");
   System.out.println(Dob);
	test.log(LogStatus.PASS, "Entered DOB as  :"+ Dob);
	 Thread.sleep(300);
	 driver.findElement(By.xpath("//*[@id='ZipCode']")).sendKeys(ZipCode);
	 test.log(LogStatus.PASS, "ZipCode entered as" +ZipCode);
	 driver.findElement(By.xpath("//*[@id='EmailAddress']")).sendKeys(email);
	 test.log(LogStatus.PASS, "email entered as" +email);
	 driver.findElement(By.xpath("//*[@id='PasswordVal']")).sendKeys(password);
	 test.log(LogStatus.PASS, "password entered as" +password);
	 driver.findElement(By.xpath("//*[@id='PasswordConfirmation']")).sendKeys(password);
	 test.log(LogStatus.PASS, "confirm password entered as" +password);
	 int i_security_question_a=Integer.parseInt(security_question_a);
	  new Select(driver.findElement(By.xpath("//*[@id='question0']"))).selectByIndex(i_security_question_a);
	  test.log(LogStatus.PASS, "Selected the first question  ");
	  

	  driver.findElement(By.xpath("//*[@id='answer0']")).sendKeys(security_question_answer_a);
	  test.log(LogStatus.PASS, "Entered the first question answer as "+ security_question_answer_a);

	  int i_security_question_b=Integer.parseInt(security_question_b);
	  new Select(driver.findElement(By.xpath("//*[@id='question1']"))).selectByIndex(i_security_question_b);
	  test.log(LogStatus.PASS, "Selected the second question  " );

	  driver.findElement(By.xpath("//*[@id='answer1']")).sendKeys(security_question_answer_b);
	  test.log(LogStatus.PASS, "Entered the second question answer as "+ security_question_answer_b);

	  int i_security_question_c=Integer.parseInt(security_question_c);
	  new Select(driver.findElement(By.xpath("//*[@id='question2']"))).selectByIndex(i_security_question_c);
	  test.log(LogStatus.PASS, "Selected the third question  ");
	  driver.findElement(By.xpath("//*[@id='answer2']")).sendKeys(security_question_answer_c);
	  test.log(LogStatus.PASS, "Entered the third question answer  as "+ security_question_answer_c);
	  
	  driver.findElement(By.xpath("//*[@id='submitOnBoarding']")).click();
	  test.log(LogStatus.PASS, "Clicked on submit button");
	 Thread.sleep(10000);

	  
		break;
		}
	}
  }
	 catch(Exception e)
	  {
			test.log(LogStatus.ERROR, "Create Account Information is not successfully filled with SSN : " +SSN);
			test.log(LogStatus.ERROR, "Error message  " +e);
			  String screenshotPath = getScreenhot(driver, "registration");
			  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
			Assert.assertTrue(false);
	
}
  
  }
	
public static void registration_withITIN(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";
				
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//WebDriverWait wait = new WebDriverWait(driver, 5000);
				

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
			
		
		  driver.get("https://qcln.qfund.net:8090/");
		  test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);

		  Thread.sleep(2000);
		  //html/body/div/div/div/a[4]
		    driver.findElement(By.xpath("/html/body/div/div/div/a[4]")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");

		  Thread.sleep(4000);
		
		 		 
		 // Thread.sleep(4000);

		  driver.findElement(By.linkText("APPLY NOW")).click();
		  test.log(LogStatus.PASS, "Clicked on APPLY NOW button");
		  Thread.sleep(4000);
		  test.log(LogStatus.INFO, "*******Lend Nation application navigated to Create An Account Page *******");

		  Thread.sleep(2000);

		  driver.findElement(locator(prop.getProperty("email_field"))).sendKeys(email);
		  test.log(LogStatus.PASS, "Entered Email : "+email);

		  
		  driver.findElement(locator(prop.getProperty("confirm_email_field"))).sendKeys(email);
		  test.log(LogStatus.PASS, "Entered confirm Email : "+email);

		  
		  
		  driver.findElement(locator(prop.getProperty("password_field"))).sendKeys(password);
		  test.log(LogStatus.PASS, "Entered Password : "+password);

		   driver.findElement(locator(prop.getProperty("confirm_password_field"))).sendKeys(password);
		   test.log(LogStatus.PASS, "Entered confirm Password : "+password);
		   
		   Thread.sleep(500);
		   
		   driver.findElement(By.name("idType")).sendKeys("ITIN");
		   test.log(LogStatus.PASS, "ITIN Selected");
		   
		   Thread.sleep(500);
		 
		  /*driver.findElement(locator(prop.getProperty("SSN_first_field"))).sendKeys(SSN1);
		  driver.findElement(locator(prop.getProperty("SSN_second_field"))).sendKeys(SSN2);
		  driver.findElement(locator(prop.getProperty("SSN_third_field"))).sendKeys(SSN3);*/
		  driver.findElement(By.name("SSN")).sendKeys(SSN);
		  test.log(LogStatus.PASS, "Entered SSN Number : "+SSN);

		
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
		  //driver.findElement(locator(prop.getProperty("submit_button"))).click();
		  driver.findElement(By.xpath("//*[@id='apply']/div[7]/button[1]")).click();
		  test.log(LogStatus.PASS, "Clicked on Create Your Account button ");
		  
		

		  Thread.sleep(10000);
		
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

			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Create Account Completed Successfully with SSN : " +SSN);
			test.log(LogStatus.INFO, "******************************************************** ");
			

		  
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Create Account Information is not successfully filled with SSN : " +SSN);
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "registration");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }

public static void registration_with_existed_ITIN(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";
				
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//WebDriverWait wait = new WebDriverWait(driver, 5000);
				

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
			
		
		  driver.get("https://qcln.qfund.net:8090/");
		  test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);

		  Thread.sleep(2000);
		  //html/body/div/div/div/a[4]
		    driver.findElement(By.xpath("/html/body/div/div/div/a[4]")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");

		  Thread.sleep(4000);
		
		 		 
		 // Thread.sleep(4000);

		  driver.findElement(By.linkText("APPLY NOW")).click();
		  test.log(LogStatus.PASS, "Clicked on APPLY NOW button");
		  Thread.sleep(4000);
		  test.log(LogStatus.INFO, "*******Lend Nation application navigated to Create An Account Page *******");

		  Thread.sleep(2000);

		  driver.findElement(locator(prop.getProperty("email_field"))).sendKeys(email);
		  test.log(LogStatus.PASS, "Entered Email : "+email);

		  
		  driver.findElement(locator(prop.getProperty("confirm_email_field"))).sendKeys(email);
		  test.log(LogStatus.PASS, "Entered confirm Email : "+email);

		  
		  
		  driver.findElement(locator(prop.getProperty("password_field"))).sendKeys(password);
		  test.log(LogStatus.PASS, "Entered Password : "+password);

		   driver.findElement(locator(prop.getProperty("confirm_password_field"))).sendKeys(password);
		   test.log(LogStatus.PASS, "Entered confirm Password : "+password);
		   
		   Thread.sleep(500);
		   
		   driver.findElement(By.name("idType")).sendKeys("ITIN");
		   test.log(LogStatus.PASS, "ITIN Selected");
		   
		   Thread.sleep(500);
		 
		  /*driver.findElement(locator(prop.getProperty("SSN_first_field"))).sendKeys(SSN1);
		  driver.findElement(locator(prop.getProperty("SSN_second_field"))).sendKeys(SSN2);
		  driver.findElement(locator(prop.getProperty("SSN_third_field"))).sendKeys(SSN3);*/
		  driver.findElement(By.name("SSN")).sendKeys(SSN);
		  test.log(LogStatus.PASS, "Entered ITIN Number : "+SSN);
		  int i_security_question_a=Integer.parseInt(security_question_a);
		  new Select(driver.findElement(locator(prop.getProperty("question_first_field")))).selectByIndex(i_security_question_a);
		  test.log(LogStatus.PASS, "Selected the first question  ");
		  Thread.sleep(5000);

		try{
		 String errormessage = driver.findElement(By.xpath("//*[@id='operr']/div/div/div[2]/div/div[1]/p")).getText();
		 
		 if(errormessage.contains("You are already a registered customer"))
		 {
			 test.log(LogStatus.PASS, "test passed");
		 }
		
		}
		catch(Exception e)
		{
			String errmsg = driver.findElement(By.xpath("//*[@id='operq']/div/div/div[2]/div/div[1]/p")).getText();
			
			if(errmsg.contains("You are already a registered customer."))
			{
				test.log(LogStatus.PASS, "test passed");
			}
			
		}
		  driver.close();
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Create Account Information is not successfully filled with SSN : " +SSN);
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "registration");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }

public static void registration_with_existed_SSN(String SSN,String AppURL) throws Exception	

{
	 
	try{
		//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("Personal Information");
			String sheetName="Personal Information";
			
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//WebDriverWait wait = new WebDriverWait(driver, 5000);
			

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
		
	
	  driver.get("https://qcln.qfund.net:8090/");
	  test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);

	  Thread.sleep(2000);
	  //html/body/div/div/div/a[4]
	    driver.findElement(By.xpath("/html/body/div/div/div/a[4]")).click();	
	    test.log(LogStatus.PASS, "Clicked on QTP link ");

	  Thread.sleep(4000);
	
	 		 
	 // Thread.sleep(4000);

	  driver.findElement(By.linkText("APPLY NOW")).click();
	  test.log(LogStatus.PASS, "Clicked on APPLY NOW button");
	  Thread.sleep(4000);
	  test.log(LogStatus.INFO, "*******Lend Nation application navigated to Create An Account Page *******");

	  Thread.sleep(2000);

	  driver.findElement(locator(prop.getProperty("email_field"))).sendKeys(email);
	  test.log(LogStatus.PASS, "Entered Email : "+email);

	  
	  driver.findElement(locator(prop.getProperty("confirm_email_field"))).sendKeys(email);
	  test.log(LogStatus.PASS, "Entered confirm Email : "+email);

	  
	  
	  driver.findElement(locator(prop.getProperty("password_field"))).sendKeys(password);
	  test.log(LogStatus.PASS, "Entered Password : "+password);

	   driver.findElement(locator(prop.getProperty("confirm_password_field"))).sendKeys(password);
	   test.log(LogStatus.PASS, "Entered confirm Password : "+password);
	   
	   Thread.sleep(500);
	   
	   driver.findElement(By.name("idType")).sendKeys("SSN");
	   test.log(LogStatus.PASS, "SSN Selected");
	   
	   Thread.sleep(500);
	 
	  /*driver.findElement(locator(prop.getProperty("SSN_first_field"))).sendKeys(SSN1);
	  driver.findElement(locator(prop.getProperty("SSN_second_field"))).sendKeys(SSN2);
	  driver.findElement(locator(prop.getProperty("SSN_third_field"))).sendKeys(SSN3);*/
	  driver.findElement(By.name("SSN")).sendKeys(SSN);
	  test.log(LogStatus.PASS, "Entered SSN Number : "+SSN);
	  int i_security_question_a=Integer.parseInt(security_question_a);
	  new Select(driver.findElement(locator(prop.getProperty("question_first_field")))).selectByIndex(i_security_question_a);
	  test.log(LogStatus.PASS, "Selected the first question  ");
	  Thread.sleep(5000);

	
	 String errormessage = driver.findElement(By.xpath("//*[@id='operr']/div/div/div[2]/div/div[1]/p")).getText();
	 test.log(LogStatus.INFO, "error message is" +errormessage);
	 if(errormessage.contains("You are already a registered customer at Store."))
	 {
		 test.log(LogStatus.PASS, "test passed");
	 }
	 else
	 {
		 test.log(LogStatus.FAIL, "test failed");
	 }

	  driver.close();
		break;
		}
	}
  }
	 catch(Exception e)
	  {
			test.log(LogStatus.ERROR, "Create Account Information is not successfully filled with SSN : " +SSN);
			test.log(LogStatus.ERROR, "Error message  " +e);
			  String screenshotPath = getScreenhot(driver, "registration");
			  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
			Assert.assertTrue(false);
	
}
  
  }
	public static void Validate_SSNITIN_dropdown(String SSN, String AppURL) throws Exception
	{
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";
				
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//WebDriverWait wait = new WebDriverWait(driver, 5000);

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					
			if(SSN.equals(RegSSN))
			{	
				  driver.get("https://qcln.qfund.net:8090/");
				  test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);

				  Thread.sleep(2000);
				  //html/body/div/div/div/a[4]
				    driver.findElement(By.xpath("/html/body/div/div/div/a[4]")).click();	
				    test.log(LogStatus.PASS, "Clicked on QTP link ");

				  Thread.sleep(4000);
				
				 		 
				 // Thread.sleep(4000);

				  driver.findElement(By.linkText("APPLY NOW")).click();
				  test.log(LogStatus.PASS, "Clicked on APPLY NOW button");
				  Thread.sleep(4000);
				  test.log(LogStatus.INFO, "*******Lend Nation application navigated to Create An Account Page *******");

				  Thread.sleep(2000);

				  driver.findElement(By.xpath("//*[@id='idType']")).click();
						  
				   List<WebElement> l = driver.findElements(By.xpath("(//*[@id='idType'])/option"));
				   //test.log(LogStatus.INFO, "size is" +i);
				   for (int i = 2; i <=l.size(); i++) {
					String x =  driver.findElement(By.xpath("(//*[@id='idType'])/option["+i+"]")).getText();
					test.log(LogStatus.INFO, x);
					
					if(x.equals("SSN"))
					{
						test.log(LogStatus.PASS, "test passed");
					}
					else if(x.equals("ITIN"))
					{
						test.log(LogStatus.PASS, "test passed");
					}
					else
					{
						test.log(LogStatus.FAIL, "test failed");
					}
				}
				   
			}
			
	}
		}
				catch(Exception e)
				{
					test.log(LogStatus.ERROR, "Create Account Information is not successfully filled with SSN : " +SSN);
					test.log(LogStatus.ERROR, "Error message  " +e);
					  String screenshotPath = getScreenhot(driver, "registration");
					  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					Assert.assertTrue(false);	

}
		}
	public static void login(String SSN, String AppURL) throws Exception
	{
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";
				
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//WebDriverWait wait = new WebDriverWait(driver, 5000);

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String email1 = TestData.getCellData(sheetName,"Email",row);
					String email2 = TestData.getCellData(sheetName,"EmailExt",row);
					String email=email1.concat(email2);
					String password = TestData.getCellData(sheetName,"Password",row);
					
			if(SSN.equals(RegSSN))
			{	
				  driver.get("https://qcln.qfund.net:8090/");
				  test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);

				  Thread.sleep(2000);
				  //html/body/div/div/div/a[4]
				    driver.findElement(By.xpath("/html/body/div/div/div/a[4]")).click();	
				    test.log(LogStatus.PASS, "Clicked on QTP link ");

				  Thread.sleep(4000);
				  
				  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
				  test.log(LogStatus.PASS, "Clicked on Sign in button ");
				  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
				  test.log(LogStatus.PASS, "Entered username as" +email);
				  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
				  test.log(LogStatus.PASS, "Entered password as" +password);
				  Thread.sleep(4000);
				  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
				  test.log(LogStatus.PASS, "Clicked on Login button ");
				 		 
								
				   
			}
			
	}
		}
				catch(Exception e)
				{
					test.log(LogStatus.ERROR, "Create Account Information is not successfully filled with SSN : " +SSN);
					test.log(LogStatus.ERROR, "Error message  " +e);
					  String screenshotPath = getScreenhot(driver, "registration");
					  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					Assert.assertTrue(false);	

}
		}
	
	public static void viewProfile(String SSN, String AppURL) throws Exception
	{
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";
				
			

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String email1 = TestData.getCellData(sheetName,"Email",row);
					String email2 = TestData.getCellData(sheetName,"EmailExt",row);
					String email=email1.concat(email2);
					String password = TestData.getCellData(sheetName,"Password",row);
					
			if(SSN.equals(RegSSN))
			{	
				
				 

				  Thread.sleep(4000);
				  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
				  test.log(LogStatus.PASS, "Clicked on My Account");
				  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/ul/li[1]/a")).click();
				  test.log(LogStatus.PASS, "Clicked on My Dashboard");
				  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/a[1]/img")).click();
				  test.log(LogStatus.PASS, "Clicked on personal information img");
				  String ssn = driver.findElement(By.xpath("//*[@id='ssn']")).getAttribute("value");
				  test.log(LogStatus.INFO, "ssn is" +ssn);
				  if(ssn.contains("xx"))
				  {
					  test.log(LogStatus.PASS, "test passed");
				  }
				 
				/*  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
				  test.log(LogStatus.PASS, "Clicked on Sign in button ");
				  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
				  test.log(LogStatus.PASS, "Entered username as" +email);
				  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
				  test.log(LogStatus.PASS, "Entered password as" +password);
				  Thread.sleep(4000);
				  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
				  test.log(LogStatus.PASS, "Clicked on Login button ");*/
				 		 
								
				   
			}
			
	}
		}
				catch(Exception e)
				{
					test.log(LogStatus.ERROR, "Create Account Information is not successfully filled with SSN : " +SSN);
					test.log(LogStatus.ERROR, "Error message  " +e);
					  String screenshotPath = getScreenhot(driver, "registration");
					  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					Assert.assertTrue(false);	

}
		}
	
	
	public static void SSNITIN_validation(String SSN, String AppURL) throws Exception
	{
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";
				
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//WebDriverWait wait = new WebDriverWait(driver, 5000);

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
					
				  driver.get("https://qcln.qfund.net:8090/");
				  test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);

				  Thread.sleep(2000);
				  //html/body/div/div/div/a[4]
				    driver.findElement(By.xpath("/html/body/div/div/div/a[4]")).click();	
				    test.log(LogStatus.PASS, "Clicked on QTP link ");

				  Thread.sleep(4000);
				
				 		 
				 // Thread.sleep(4000);

				  driver.findElement(By.linkText("APPLY NOW")).click();
				  test.log(LogStatus.PASS, "Clicked on APPLY NOW button");
				  Thread.sleep(4000);
				  test.log(LogStatus.INFO, "*******Lend Nation application navigated to Create An Account Page *******");

				  Thread.sleep(2000);

				  driver.findElement(locator(prop.getProperty("email_field"))).sendKeys(email);
				  test.log(LogStatus.PASS, "Entered Email : "+email);

				  
				  driver.findElement(locator(prop.getProperty("confirm_email_field"))).sendKeys(email);
				  test.log(LogStatus.PASS, "Entered confirm Email : "+email);

				  
				  
				  driver.findElement(locator(prop.getProperty("password_field"))).sendKeys(password);
				  test.log(LogStatus.PASS, "Entered Password : "+password);

				   driver.findElement(locator(prop.getProperty("confirm_password_field"))).sendKeys(password);
				   test.log(LogStatus.PASS, "Entered confirm Password : "+password);
				   
				   Thread.sleep(500);
				   
				   driver.findElement(By.name("idType")).sendKeys("ITIN");
				   test.log(LogStatus.PASS, "ITIN Selected");
				   
				   driver.findElement(By.name("SSN")).sendKeys(SSN);
					  test.log(LogStatus.PASS, "Entered SSN Number : "+SSN);
				   
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
					  //driver.findElement(locator(prop.getProperty("submit_button"))).click();
					  driver.findElement(By.xpath("//*[@id='apply']/div[7]/button[1]")).click();
					  test.log(LogStatus.PASS, "Clicked on Create Your Account button ");
					  
					

					  Thread.sleep(10000);
					
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

						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Create Account Completed Successfully with SSN : " +SSN);
						test.log(LogStatus.INFO, "******************************************************** ");
						

					  
						break;
						}
					}
				  }
					 catch(Exception e)
					  {
							test.log(LogStatus.ERROR, "Create Account Information is not successfully filled with SSN : " +SSN);
							test.log(LogStatus.ERROR, "Error message  " +e);
							  String screenshotPath = getScreenhot(driver, "registration");
							  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
							Assert.assertTrue(false);
					
			 }
				  
				  }
	
	public static void invalidITIN_validation(String SSN, String AppURL) throws Exception
	{
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";
				
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//WebDriverWait wait = new WebDriverWait(driver, 5000);

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
					
				  driver.get("https://qcln.qfund.net:8090/");
				  test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);

				  Thread.sleep(2000);
				  //html/body/div/div/div/a[4]
				    driver.findElement(By.xpath("/html/body/div/div/div/a[4]")).click();	
				    test.log(LogStatus.PASS, "Clicked on QTP link ");

				  Thread.sleep(4000);
				
				 		 
				 // Thread.sleep(4000);

				  driver.findElement(By.linkText("APPLY NOW")).click();
				  test.log(LogStatus.PASS, "Clicked on APPLY NOW button");
				  Thread.sleep(4000);
				  test.log(LogStatus.INFO, "*******Lend Nation application navigated to Create An Account Page *******");

				  Thread.sleep(2000);

				  driver.findElement(locator(prop.getProperty("email_field"))).sendKeys(email);
				  test.log(LogStatus.PASS, "Entered Email : "+email);

				  
				  driver.findElement(locator(prop.getProperty("confirm_email_field"))).sendKeys(email);
				  test.log(LogStatus.PASS, "Entered confirm Email : "+email);

				  
				  
				  driver.findElement(locator(prop.getProperty("password_field"))).sendKeys(password);
				  test.log(LogStatus.PASS, "Entered Password : "+password);

				   driver.findElement(locator(prop.getProperty("confirm_password_field"))).sendKeys(password);
				   test.log(LogStatus.PASS, "Entered confirm Password : "+password);
				   
				   Thread.sleep(500);
				   
				   driver.findElement(By.name("idType")).sendKeys("ITIN");
				   test.log(LogStatus.PASS, "ITIN Selected");
				   
				   driver.findElement(By.name("SSN")).sendKeys(SSN);
					  test.log(LogStatus.PASS, "Entered SSN Number : "+SSN);
				   
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
					  //driver.findElement(locator(prop.getProperty("submit_button"))).click();
					  driver.findElement(By.xpath("//*[@id='apply']/div[7]/button[1]")).click();
					  test.log(LogStatus.PASS, "Clicked on Create Your Account button ");
					  
					WebElement errormessage = driver.findElement(By.xpath("//*[@id='eidtype']/center/span/strong"));

					if(errormessage.isDisplayed())
					{
						test.log(LogStatus.PASS, "test passed");
					}
					else
					{
						test.log(LogStatus.FAIL, "test failed");
					}
					  Thread.sleep(10000);
					
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

						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Create Account Completed Successfully with SSN : " +SSN);
						test.log(LogStatus.INFO, "******************************************************** ");
						

					  
						break;
						}
					}
				  }
					 catch(Exception e)
					  {
							test.log(LogStatus.ERROR, "Create Account Information is not successfully filled with SSN : " +SSN);
							test.log(LogStatus.ERROR, "Error message  " +e);
							  String screenshotPath = getScreenhot(driver, "registration");
							  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
							Assert.assertTrue(false);
					
			 }
				  
				  }
		}



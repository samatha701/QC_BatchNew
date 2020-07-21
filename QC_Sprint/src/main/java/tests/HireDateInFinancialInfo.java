package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;



public class HireDateInFinancialInfo extends QCStore {
	
public static void financialInformation(String SSN,String AppURL) throws Exception
		  
	  {
	
	   int lastrow=TestData.getLastRow("Reg");
	   String sheetName="Reg";
       for(int row=2;row<=lastrow;row++)
					{		
						String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{	
			    String IncomeSourse = TestData.getCellData(sheetName,"IncomeSourse",row);
			//Thread.sleep(10000);
			WebElement w=driver.findElement(By.name("iIncomeType"));
			Select s=new Select(w);
		    s.selectByVisibleText("Salary");
		    test.log(LogStatus.INFO, "*******Lend Nation application navigated to Financial Information page*******");


		  test.log(LogStatus.PASS, "Selected Income source as salary");
		  Thread.sleep(1000);
		 String dateType = driver.findElement(By.xpath("//*[@id='timeAtEmployee']/div[1]/label")).getText();
		 test.log(LogStatus.PASS, "Date Type is "+dateType);
		 s.selectByVisibleText("Self Employed");
		 test.log(LogStatus.PASS, "Selected Income source as Self Employed");
		 String dateType1 = driver.findElement(By.xpath("//*[@id='timeAtEmployee']/div[1]/label")).getText();
		 test.log(LogStatus.PASS, "Date Type is "+dateType1);
		 s.selectByVisibleText("Hourly");
		test.log(LogStatus.PASS, "Selected Income source as Hourly");
		 String dateType2 = driver.findElement(By.xpath("//*[@id='timeAtEmployee']/div[1]/label")).getText();
		 test.log(LogStatus.PASS, "Date Type is "+dateType2);
		 s.selectByVisibleText("Commission");
		 //driver.findElement(By.name("iIncomeType")).sendKeys("Commision");
		 test.log(LogStatus.PASS, "Selected Income source as Commission");
		 String dateType3 = driver.findElement(By.xpath("//*[@id='timeAtEmployee']/div[1]/label")).getText();
		 test.log(LogStatus.PASS, "Date Type is "+dateType3);
		 if(dateType.equalsIgnoreCase("Hire Date")&dateType1.equalsIgnoreCase("Hire Date")&dateType2.equalsIgnoreCase("Hire Date")&dateType3.equalsIgnoreCase("Hire Date"))
		 {
			 test.log(LogStatus.PASS, "Date Type Displayed as Hire Date");
		 }
		 else
			 test.log(LogStatus.FAIL, "Date Type IS NOT Displayed as Hire Date");
		 s.selectByVisibleText("Alimony");
		 //driver.findElement(By.name("iIncomeType")).sendKeys("Alimony");
		 test.log(LogStatus.PASS, "Selected Income source as Alimony");
		 String dateType4 = driver.findElement(By.xpath("//*[@id='timeAtEmployee']/div[1]/label")).getText();
		 test.log(LogStatus.PASS, "Date Type is "+dateType4);
		 s.selectByVisibleText("Child Support");
		 //driver.findElement(By.name("iIncomeType")).sendKeys("Child Support");
		 test.log(LogStatus.PASS, "Selected Income source as Child Support");
		 String dateType5 = driver.findElement(By.xpath("//*[@id='timeAtEmployee']/div[1]/label")).getText();
		 test.log(LogStatus.PASS, "Date Type is "+dateType5);
		s.selectByVisibleText("Disability");
		test.log(LogStatus.PASS, "Selected Income source as Disability");
		 String dateType6 = driver.findElement(By.xpath("//*[@id='timeAtEmployee']/div[1]/label")).getText();
		 test.log(LogStatus.PASS, "Date Type is "+dateType6);
		 s.selectByVisibleText("Foster Care Income");
		test.log(LogStatus.PASS, "Selected Income source as Foster Care Income");
		 String dateType7 = driver.findElement(By.xpath("//*[@id='timeAtEmployee']/div[1]/label")).getText();
		 test.log(LogStatus.PASS, "Date Type is "+dateType7);
		 s.selectByVisibleText("Pension");
		 test.log(LogStatus.PASS, "Selected Income source as Pension");
		 String dateType8 = driver.findElement(By.xpath("//*[@id='timeAtEmployee']/div[1]/label")).getText();
		 test.log(LogStatus.PASS, "Date Type is "+dateType8);
		 s.selectByVisibleText("Social Security");
		 test.log(LogStatus.PASS, "Selected Income source as Social Security");
		 String dateType9 = driver.findElement(By.xpath("//*[@id='timeAtEmployee']/div[1]/label")).getText();
		 test.log(LogStatus.PASS, "Date Type is "+dateType9);
		 s.selectByVisibleText("Unemployment");
		 test.log(LogStatus.PASS, "Selected Income source as Unemployment");
		 String dateType10 = driver.findElement(By.xpath("//*[@id='timeAtEmployee']/div[1]/label")).getText();
		 test.log(LogStatus.PASS, "Date Type is "+dateType10);
		 s.selectByVisibleText("Worker's Compensation");
		 test.log(LogStatus.PASS, "Selected Income source as Worker's Compensation");
		 String dateType11 = driver.findElement(By.xpath("//*[@id='timeAtEmployee']/div[1]/label")).getText();
		 test.log(LogStatus.PASS, "Date Type is "+dateType11);	 
		 if(dateType4.equalsIgnoreCase("Benefits Start Date")&dateType5.equalsIgnoreCase("Benefits Start Date")&dateType6.equalsIgnoreCase("Benefits Start Date")&dateType7.equalsIgnoreCase("Benefits Start Date")&dateType8.equalsIgnoreCase("Benefits Start Date")&dateType9.equalsIgnoreCase("Benefits Start Date")&dateType10.equalsIgnoreCase("Benefits Start Date")&dateType11.equalsIgnoreCase("Benefits Start Date"))
		 {
			 test.log(LogStatus.PASS, "Date Type Displayed as Benefits Start Date");
			 boolean a=true;
			boolean datePicker = driver.findElement(By.className("ui-datepicker-trigger")).isDisplayed();
			test.log(LogStatus.PASS, "datePicker is displayed" +Boolean.compare(datePicker,a));
			{
				
			}
				
		 }
		 else
			 test.log(LogStatus.FAIL, "Date Type IS NOT Displayed as Hire Date");
	}
  }
}
}


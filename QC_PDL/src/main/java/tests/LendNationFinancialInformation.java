package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class LendNationFinancialInformation extends LendNation {
	@Test(priority=3)
	  public static void financialInformation(String SSN,String AppURL) throws Exception
	  {
		  try{
			  String FileName= prop.getProperty("file_name");
				ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);	 
			int lastrow=TestData.getLastRow("Personal Information");
			String sheetName="Personal Information";
			WebDriverWait wait = new WebDriverWait(driver, 30000);
			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{	
			String IncomeSourse = TestData.getCellData(sheetName,"IncomeSourse",row);
			String EmployerName = TestData.getCellData(sheetName,"EmployerName",row);
			String EmployerIndustry = TestData.getCellData(sheetName,"EmployerIndustry",row);
			String WorkPhone = TestData.getCellData(sheetName,"WorkPhone",row);
			String TimeAtJob = TestData.getCellData(sheetName,"TimeAtJob",row);
			String Income_GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
			String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
			String PayMethod = TestData.getCellData(sheetName,"PayMethod",row);
			String PaidDay = TestData.getCellData(sheetName,"PaidDay",row);
			String TakeHome = TestData.getCellData(sheetName,"TakeHome",row);
			String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
			
			String AccountType = TestData.getCellData(sheetName,"AccountType",row);
			String AccountNumber = TestData.getCellData(sheetName,"AccountNumber",row);
			String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
			//String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row);




		  
		  
	Thread.sleep(20000);
		  driver.findElement(locator(prop.getProperty("income_type"))).sendKeys(IncomeSourse);
		 //test.log(Status.INFO, "Lend Nation application navigated to Financial Information page ");
	test.log(Status.INFO, MarkupHelper.createLabel("Lend Nation application navigated to Financial Information page",ExtentColor.BLUE ));


		  test.log(Status.PASS, "Selected Income source as " + IncomeSourse);
		  Thread.sleep(3000);
		  wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(locator(prop.getProperty("employer_name")))));

		  driver.findElement(locator(prop.getProperty("employer_name"))).sendKeys(EmployerName);
		  test.log(Status.PASS, "Entered Employer Name : " + EmployerName);

		  driver.findElement(locator(prop.getProperty("employer_industry"))).sendKeys(EmployerIndustry);
		  test.log(Status.PASS, "Selected Employer Industry as " + EmployerIndustry);
		  Thread.sleep(3000);
		  wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(locator(prop.getProperty("employer_phone_no")))));

		  driver.findElement(locator(prop.getProperty("employer_phone_no"))).sendKeys(WorkPhone);
		  test.log(Status.PASS, "Enterted Employer phone no :" + WorkPhone);

		  driver.findElement(locator(prop.getProperty("time_at_employer"))).sendKeys(TimeAtJob);
		  test.log(Status.PASS, "Selected Time at employer as " + TimeAtJob);
		  Thread.sleep(3000);
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("pay_frequency")))));

		  driver.findElement(locator(prop.getProperty("pay_frequency"))).sendKeys(Income_PayFrequency);
		  test.log(Status.PASS, "Selected Pay frequency as " + Income_PayFrequency);

		  driver.findElement(locator(prop.getProperty("income_method_type"))).sendKeys(PayMethod);
		  test.log(Status.PASS, "Selected Income method type as " + PayMethod);
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("income_pay_day")))));
		  driver.findElement(locator(prop.getProperty("income_pay_day"))).sendKeys(PaidDay);
		  test.log(Status.PASS, "Selected Income paid day as " + PaidDay);

		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("next_pay_day")))));

		  driver.findElement(locator(prop.getProperty("next_pay_day"))).click();
		  test.log(Status.PASS, "Selected Next pay date " );

		  
		  driver.findElement(locator(prop.getProperty("gross_pay"))).sendKeys(Income_GrossIncome);
		  test.log(Status.PASS, "Enterted Gross pay amount is " + Income_GrossIncome);

		  driver.findElement(locator(prop.getProperty("net_pay"))).sendKeys(TakeHome);
		  test.log(Status.PASS, "Entered Net pay amount is : " + TakeHome);

		  
		  driver.findElement(locator(prop.getProperty("add_income_button"))).click();
		  test.log(Status.PASS, "Added Income " );
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("receive_type_financial_page")))));
		  driver.findElement(locator(prop.getProperty("receive_type_financial_page"))).sendKeys(ReceiveType);
		  test.log(Status.PASS, "Selected Receive type as " + ReceiveType);

		  driver.findElement(locator(prop.getProperty("income_submit_button"))).click();
		  test.log(Status.PASS, "Submitted income : " + IncomeSourse);

		  
		  driver.findElement(locator(prop.getProperty("account_type"))).sendKeys(AccountType);
		  test.log(Status.PASS, "Selected account type as " + AccountType );
		 
		  driver.findElement(locator(prop.getProperty("ABA_number_field"))).sendKeys(Bank_ABARoutingNbr);
		  test.log(Status.PASS, "Entered ABA number : " + Bank_ABARoutingNbr);
		  driver.findElement(locator(prop.getProperty("account_number_field"))).sendKeys(AccountNumber);
		  test.log(Status.PASS, "Entered Account number : " + AccountNumber);

		  driver.findElement(locator(prop.getProperty("confirm_account_number_field"))).sendKeys(AccountNumber);
		  test.log(Status.PASS, "Confirmed account number : " + AccountNumber);


		  driver.findElement(locator(prop.getProperty("continue_button_financial_inf_page"))).click();
		  test.log(Status.PASS, "Clicked on Continue " );
		  Thread.sleep(20000);
		  
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("repayment_method_type")))));

		  if( driver.findElement(locator(prop.getProperty("repayment_method_type"))).isEnabled())
		  {
				//test.log(Status.PASS, "Finanacial Information Entered Successfully with SSN : " +SSN);	
				test.log(Status.PASS, MarkupHelper.createLabel("Finanacial Information Entered Successfully with SSN : " +SSN,ExtentColor.GREEN ));

			 	}
				else
				{
				test.log(Status.FAIL, "Financial Information is not entered Successfully with SSN : " +SSN);
				}
	  




		  
		  
		  
				}
			}
			
	  }
			 catch(Exception e)
			  {
					test.log(Status.ERROR, "Financial Information is not successfully filled with SSN : " +SSN);
					test.log(Status.ERROR, "Error message  " +e);
					e.printStackTrace();
			
	  }
	  

}
}

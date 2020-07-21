package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class RefinanceVerify extends QCStore {
	
	public static void refinanceStepDown(String SSN,String AppURL) throws InterruptedException
	{
		
			driver.get(prop.getProperty("login_page")); 
			int lastrow=TestData.getLastRow("New_Loan");
			String sheetName="New_Loan";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
									
					 String Bank_ChkgAcctNbr = TestData.getCellData(sheetName,"Bank_ChkgAcctNbr",row);
						String last4cheknum= Bank_ChkgAcctNbr.substring(Bank_ChkgAcctNbr.length() - 4);
						String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
						String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
						String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
						String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);
						String No_of_checks = TestData.getCellData(sheetName,"No_of_checks",row);
						String Esign_Password = TestData.getCellData(sheetName,"ESign_Password",row);
						String Esign_CollateralType = TestData.getCellData(sheetName,"Esign_CollateralType",row);
						String Collateral= TestData.getCellData(sheetName,"Collateral",row);
						 
						 
								String SSN1 = SSN.substring(0, 3);
								 String SSN2 = SSN.substring(3,5);
								 String SSN3 = SSN.substring(5,9);
								
								Thread.sleep(3000);
								test.log(LogStatus.INFO,"Refinance StepDown  process has started");
							   driver.switchTo().frame("topFrame");
								driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
								test.log(LogStatus.PASS, "Clicked on Loan Transactions");
								
								driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");
								
								driver.findElement(By.cssSelector("li[id='911101']")).click();
								test.log(LogStatus.PASS, "Clicked on Transaction");		
								driver.switchTo().frame("main");	
								Thread.sleep(500);
								driver.findElement(By.name("ssn1")).sendKeys(SSN1);
								test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
								driver.findElement(By.name("ssn2")).sendKeys(SSN2);
								test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
								driver.findElement(By.name("ssn3")).sendKeys(SSN3);
								test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
								driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
								test.log(LogStatus.PASS, "Clicked on submit Button");		
								/*for(String winHandle : driver.getWindowHandles())
								{
							    driver.switchTo().window(winHandle);*/				
							    driver.switchTo().defaultContent();
							    driver.switchTo().frame("mainFrame");
							    driver.switchTo().frame("main");					    					   					     
							    driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
							    test.log(LogStatus.PASS, "Clicked on GO Button under search results");
							    Thread.sleep(2000);					  
							/*	for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}*/			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								
								 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
								 test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
								// driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
								 // test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
								 Thread.sleep(5000);
								 /*driver.findElement(By.name("transactionList")).sendKeys("Refinance");
								 test.log(LogStatus.PASS, "Transaction Type is selected as Refinance");*/
								 
								 Select drop = new Select(driver.findElement(By.name("transactionList")));

								 List<WebElement> options = drop.getOptions();

								 System.out.println(options.size());
								
								 for (int j = 0; j < options.size(); j++) {
								     System.out.println(options.get(j).getText());
								    String listOfOptions = options.get(j).getText();
								    test.log(LogStatus.PASS, "list of options"+listOfOptions);
								     if(listOfOptions.contains("Refinance"))
									 {
								    	 test.log(LogStatus.FAIL, "Refinance option is available in transactionList");
									 }
								     else
								    	 test.log(LogStatus.PASS, "Refinance option is not available in transactionList");

								 }
								 
								
								 
								
}
}
	
		}
	}


		
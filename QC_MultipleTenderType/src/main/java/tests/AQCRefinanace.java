package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import com.relevantcodes.extentreports.LogStatus;

public class AQCRefinanace extends QCStore {
	public static void payment (String SSN,String AppURL) throws Exception
	{	
		test.log(LogStatus.INFO, "******************Performing  payment ******************");

		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

		for(int row=2;row<=lastrow+1;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{	
				String TxnType = TestData.getCellData(sheetName,"TxnType",row);
				String TenderType1 = TestData.getCellData(sheetName,"TenderType1",row);
				String TenderType2 = TestData.getCellData(sheetName,"TenderType2",row);
				String CCNumber = TestData.getCellData(sheetName,"CCNumber",row);
				String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);			
				String TenderAmount1 = TestData.getCellData(sheetName,"TenderAmount1",row);
				String TenderAmount2 = TestData.getCellData(sheetName,"TenderAmount2",row);	
				String PIN = "1234";
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"PartialPayment started");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Aprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Aprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Aprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Aprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Aprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);					  


				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys(TxnType);
				test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(10000);	
				driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(PaymentAmount);
				test.log(LogStatus.PASS, "PaymentAmount entered :"+PaymentAmount);

				if(TenderType1.equalsIgnoreCase("Cash")&&(TenderType2.equalsIgnoreCase("CashierCheck")||TenderType2.equalsIgnoreCase("MoneyOrder")))
				{
					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType1);
					test.log(LogStatus.PASS, "First Tender Type is :"+TenderType1);
					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(TenderAmount1);
					test.log(LogStatus.PASS, "First TenderAmount is :"+TenderAmount1);	

					driver.findElement(By.name("transactionDataBean.tenderTypeSecond")).sendKeys(TenderType2);
					test.log(LogStatus.PASS, "Second Tender Type is :"+TenderType2);

					driver.findElement(By.name("transactionDataBean.ccmoNbrSecond")).sendKeys(CCNumber);
					test.log(LogStatus.PASS, "CC Number entered as :"+CCNumber);

					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderAmtSecond")).sendKeys(TenderAmount2);
					test.log(LogStatus.PASS, "Second TenderAmount is :"+TenderAmount2);

				}

				if((TenderType1.equalsIgnoreCase("CashierCheck")||TenderType1.equalsIgnoreCase("MoneyOrder"))&&TenderType2.equalsIgnoreCase("Cash")){

					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType1);
					test.log(LogStatus.PASS, "First Tender Type is :"+TenderType1);
					driver.findElement(By.name("transactionDataBean.ccmoNbrFirst")).sendKeys(CCNumber);
					test.log(LogStatus.PASS, "CC Number entered as :"+CCNumber);
					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(TenderAmount1);
					test.log(LogStatus.PASS, "First TenderAmount is :"+TenderAmount1);	

					driver.findElement(By.name("transactionDataBean.tenderTypeSecond")).sendKeys(TenderType2);
					test.log(LogStatus.PASS, "Second Tender Type is :"+TenderType2);

					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderAmtSecond")).sendKeys(TenderAmount2);
					test.log(LogStatus.PASS, "Second TenderAmount is :"+TenderAmount2);

				}

				Thread.sleep(500);
				driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
				test.log(LogStatus.PASS, "Pin is entered");
				driver.findElement(By.name("finish")).click();
				test.log(LogStatus.PASS, "Clicked on Finish Partial Payment");


				Thread.sleep(2500);
				try { 
					Alert alert = driver.switchTo().alert();

					alert.accept();
					test.log(LogStatus.PASS, "Alert Handeld");

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}
				Thread.sleep(6000);
				driver.findElement(By.name("checkyes")).click();
				test.log(LogStatus.PASS, "Clicked on Yes button");

				test.log(LogStatus.PASS,"Partial Payment Completed Successfully");

			}

		}
	}



}

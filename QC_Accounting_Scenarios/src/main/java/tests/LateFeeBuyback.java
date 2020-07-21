package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class LateFeeBuyback extends QCStore {
	public static void lateFee(String SSN,String AppURL) throws InterruptedException
	{
		
			int lastrow=TestData.getLastRow("Payment");
			String sheetName="Payment";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN)){
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
					
					String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);
				
					String Scenario = TestData.getCellData(sheetName,"Scenario",row);
					

					 String SSN1 = SSN.substring(0, 3);
					 String SSN2 = SSN.substring(3,5);
					 String SSN3 = SSN.substring(5,9);
					
				String TxnType = TestData.getCellData(sheetName,"TxnType",row);
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				
				String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				

				Thread.sleep(3000);
				test.log(LogStatus.INFO, "LateFee Buyback  process has started");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Sprop.getProperty("transactions_tab"))).click();
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");
				driver.switchTo().frame("main");
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
				driver.findElement(locator(Sprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
				driver.findElement(locator(Sprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
				driver.findElement(locator(Sprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(locator(Sprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);
				/*
				 * for( String winHandle1 : driver.getWindowHandles()) {
				 * driver.switchTo().window(winHandle1); }
				 */
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
			    Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys("History");
				test.log(LogStatus.PASS, "Transaction Type is selected as History");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(5000);
									
				/*List<WebElement> rows =driver.findElements(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr"));
				int rcount=rows.size();
				System.out.println("No of rows"+rcount);
				rcount=rcount-1;*/
				String LoanAmt=	driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[2]/td[8]")).getText();
				System.out.println("transaction type is "+LoanAmt);
				test.log(LogStatus.PASS, "Transaction type is"+LoanAmt);
				Thread.sleep(1000);
				String LateFee=	driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[3]/td[8]")).getText();
				System.out.println("Late Fee is "+LateFee);
				test.log(LogStatus.PASS, "Late Fee is"+LateFee);
				float TotalAmt = Float.valueOf(LoanAmt) + Float.valueOf(LateFee);
				String TotalAmount = String.valueOf(TotalAmt);
				test.log(LogStatus.PASS, "TotalAmount is" +TotalAmount);
				driver.findElement(By.name("back")).click();
				test.log(LogStatus.PASS, "clicked on Back button");
				driver.findElement(By.name("transactionList")).sendKeys(TxnType);
				test.log(LogStatus.PASS, "Transaction type is selected as "+TxnType);
				driver.findElement(By.name("button")).click();
			   test.log(LogStatus.PASS, "Clicked on Go button");
			   
			        driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String PayAmt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Buyback amt is" + PayAmt);
			if(TotalAmount.equalsIgnoreCase(PayAmt)){
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "tender type selected as "+TenderType);
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(PayAmt);
					test.log(LogStatus.PASS, "tender type selected as "+PayAmt);
					}
					driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, "password entered as "+PIN);
					driver.findElement(By.name("finish")).click();
					test.log(LogStatus.PASS, "clicked on finish buybabk button");
					try { 
				    Alert alert = driver.switchTo().alert();
				
				    alert.accept();
				    test.log(LogStatus.PASS, "Alert Handeld");
				    //if alert present, accept and move on.														
			 }
				catch (Exception e) {
				    //do what you normally would if you didn't have the alert.
				}
			 Thread.sleep(6000);
			 driver.findElement(By.name("checkyes")).click();
			 test.log(LogStatus.PASS, "Clicked on Yes button");
			 
			 //driver.findElement(By.name("checkno")).click();
			 //test.log(LogStatus.PASS, "BuyBack Completed Successfully");
			 test.log(LogStatus.PASS, " Buyback completed successfully");
				test.log(LogStatus.PASS, "********************************************** ");
			 //Thread.sleep(5000);
			   Thread.sleep(500);	

				}

			}
	}

public static void waiveFee(String SSN,String AppURL) throws InterruptedException
{
	
		int lastrow=TestData.getLastRow("Payment");
		String sheetName="Payment";

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN)){
				
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
				
				String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);
			
				String Scenario = TestData.getCellData(sheetName,"Scenario",row);
				

				 String SSN1 = SSN.substring(0, 3);
				 String SSN2 = SSN.substring(3,5);
				 String SSN3 = SSN.substring(5,9);
				
			String TxnType = TestData.getCellData(sheetName,"TxnType",row);
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			
			String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
			

			Thread.sleep(3000);
			test.log(LogStatus.INFO, "LateFee Buyback  process has started");
			driver.switchTo().frame("topFrame");
			driver.findElement(locator(Sprop.getProperty("transactions_tab"))).click();
			test.log(LogStatus.PASS, "Clicked on Loan Transactions");

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");

			driver.findElement(By.cssSelector("li[id='911101']")).click();
			test.log(LogStatus.PASS, "Clicked on Transaction");
			driver.switchTo().frame("main");
			Thread.sleep(500);
			driver.findElement(By.name("ssn1")).sendKeys(SSN1);
			test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
			driver.findElement(locator(Sprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
			test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
			driver.findElement(locator(Sprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
			test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
			driver.findElement(locator(Sprop.getProperty("csr_new_loan_submit_button"))).click();
			test.log(LogStatus.PASS, "Clicked on submit Button");
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			driver.findElement(locator(Sprop.getProperty("csr_new_loan_go_button"))).click();
			test.log(LogStatus.PASS, "Clicked on GO Button under search results");
			Thread.sleep(2000);
			/*
			 * for( String winHandle1 : driver.getWindowHandles()) {
			 * driver.switchTo().window(winHandle1); }
			 */
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");

			driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
			test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
		    Thread.sleep(5000);
			driver.findElement(By.name("transactionList")).sendKeys("History");
			test.log(LogStatus.PASS, "Transaction Type is selected as History");
			driver.findElement(By.name("button")).click();
			test.log(LogStatus.PASS, "Clicked on Go button");
			Thread.sleep(5000);
								
			/*List<WebElement> rows =driver.findElements(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr"));
			int rcount=rows.size();
			System.out.println("No of rows"+rcount);
			rcount=rcount-1;*/
			String LoanAmt=	driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[2]/td[8]")).getText();
			System.out.println("transaction type is "+LoanAmt);
			test.log(LogStatus.PASS, "Transaction type is"+LoanAmt);
			Thread.sleep(1000);
			String LateFee=	driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[3]/td[8]")).getText();
			System.out.println("Late Fee is "+LateFee);
			test.log(LogStatus.PASS, "Late Fee is"+LateFee);
			float TotalAmt = Float.valueOf(LoanAmt) + Float.valueOf(LateFee);
			String TotalAmount = String.valueOf(TotalAmt);
			test.log(LogStatus.PASS, "TotalAmount is" +TotalAmount);
			driver.findElement(By.name("back")).click();
			test.log(LogStatus.PASS, "clicked on Back button");
			driver.findElement(By.name("transactionList")).sendKeys(TxnType);
			test.log(LogStatus.PASS, "Transaction type is selected as "+TxnType);
			driver.findElement(By.name("button")).click();
		   test.log(LogStatus.PASS, "Clicked on Go button");
		   
		        driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				String PayAmt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
				test.log(LogStatus.PASS, "Buyback amt is" + PayAmt);
		if(LoanAmt.equalsIgnoreCase(PayAmt)){
				driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
				test.log(LogStatus.PASS, "tender type selected as "+TenderType);
				driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(PayAmt);
				test.log(LogStatus.PASS, "tender type selected as "+PayAmt);
				}
				driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
				test.log(LogStatus.PASS, "password entered as "+PIN);
				driver.findElement(By.name("finish")).click();
				test.log(LogStatus.PASS, "clicked on finish buybabk button");
				try { 
			    Alert alert = driver.switchTo().alert();
			
			    alert.accept();
			    test.log(LogStatus.PASS, "Alert Handeld");
			    //if alert present, accept and move on.														
		 }
			catch (Exception e) {
			    //do what you normally would if you didn't have the alert.
			}
		 Thread.sleep(6000);
		 driver.findElement(By.name("checkyes")).click();
		 test.log(LogStatus.PASS, "Clicked on Yes button");
		 
		 //driver.findElement(By.name("checkno")).click();
		 //test.log(LogStatus.PASS, "BuyBack Completed Successfully");
		 test.log(LogStatus.PASS, " Buyback completed successfully");
			test.log(LogStatus.PASS, "********************************************** ");
		 //Thread.sleep(5000);
		   Thread.sleep(500);	

			}

		}
}
}

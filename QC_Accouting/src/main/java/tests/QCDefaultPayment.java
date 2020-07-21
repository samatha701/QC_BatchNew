package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCDefaultPayment extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void sdefaultpayment(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("DefaultPayment");
			String sheetName = "DefaultPayment";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				String Tender_Amount = TestData.getCellData(sheetName,"TenderAmount",row);
				String CCMONbr = TestData.getCellData(sheetName,"CCMONbr",row);
				String CardType = TestData.getCellData(sheetName,"Card Type ",row);
				String CardNbr = TestData.getCellData(sheetName,"Debit Card No",row);
				String ExpMonth = TestData.getCellData(sheetName,"Expiry Month",row);
				String ExpYear = TestData.getCellData(sheetName,"Expiry Year",row);
				String CVVNbr = TestData.getCellData(sheetName,"CVV",row);
				String CCName = TestData.getCellData(sheetName,"CardHolderName",row);

				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "DefaultPayment Started");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(Rprop.getProperty("transactions_tab"))).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(locator(Rprop.getProperty("csr_transaction_link"))).click();
					test.log(LogStatus.PASS, "Clicked on Transaction");
					driver.switchTo().frame("main");
					Thread.sleep(500);
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
					driver.findElement(locator(Rprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
					driver.findElement(locator(Rprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
					driver.findElement(locator(Rprop.getProperty("csr_new_loan_submit_button"))).click();
					test.log(LogStatus.PASS, "Clicked on submit Button");
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(locator(Rprop.getProperty("csr_new_loan_go_button"))).click();
						test.log(LogStatus.PASS, "Clicked on GO Button");
						Thread.sleep(5000);
						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on GO Button");
						Thread.sleep(500);

						String BalanceStatus = driver.findElement(By.xpath("//*[@id='CustGrid']/tbody/tr[2]/td[5]")).getText();
						System.out.println(BalanceStatus);
						Thread.sleep(5000);
					
						if (BalanceStatus.trim().equalsIgnoreCase("Default")){
							test.log(LogStatus.PASS, "Balance Status is :" + Balance_Status);
						}
						else
						{
						test.log(LogStatus.PASS, "Balance Status is :" + BalanceStatus);
						}	
							driver.findElement(By.name("transactionList")).sendKeys(TxnType);
							test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
							driver.findElement(By.name("button")).click();
							test.log(LogStatus.PASS, "Clicked on Go button");
							Thread.sleep(500);
							
							String DefaultBalance = driver.findElement(By.name("transactionDataBean.paymentBalAmt")).getAttribute("value");
							test.log(LogStatus.PASS, "DefaultBalance is :" + DefaultBalance);
							driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
							driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(DefaultBalance);
							test.log(LogStatus.PASS, "Payment amount entered :" + DefaultBalance);
							driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
							test.log(LogStatus.PASS, "Tender Type entered :" + TenderType);
							
							driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(DefaultBalance);
							test.log(LogStatus.PASS, "Tender amount entered :" + DefaultBalance);
							
							
							if(TenderType.equalsIgnoreCase("Debit Card"))
							{
							 
							
								Thread.sleep(2000);
								/*driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(CardType);
								 test.log(LogStatus.PASS, " Tender amount " +CardNbr);*/
								driver.findElement(By.name("cardType")).sendKeys(CardType);
							 test.log(LogStatus.PASS, " Enter the Card Number " +CardNbr);
							 driver.findElement(By.name("ccnumber")).sendKeys(CardNbr);
							 test.log(LogStatus.PASS, " Enter the Card Number " +CardNbr);
							 driver.findElement(By.name("expmonth")).sendKeys(ExpMonth);
							 test.log(LogStatus.PASS, " Enter the Exp Month " +ExpMonth);
							 driver.findElement(By.name("expyear")).sendKeys(ExpYear);
							 test.log(LogStatus.PASS, " Enter the Exp Year " +ExpYear);
							 Thread.sleep(500);
							 driver.findElement(By.id("cvvnumber")).sendKeys(CVVNbr);
							 test.log(LogStatus.PASS, " Enter the CVV number " +CVVNbr);
							 driver.findElement(By.name("ccname")).sendKeys(CCName);
							 test.log(LogStatus.PASS, " Enter the card holder name " +CCName);
								//driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount);
								//test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
					
							}
							
							
							
							driver.findElement(By.xpath("//*[@id='userPwdCredentials']/td/input")).sendKeys(PIN);
							test.log(LogStatus.PASS, "Pin is entered :" + PIN);
							Thread.sleep(500);
							driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[9]/td/table/tbody/tr[5]/td[2]/input")).click();
							test.log(LogStatus.PASS, "Clicked on Finish");
							Thread.sleep(5000);
							try {
								Alert alert = driver.switchTo().alert();

								alert.accept();
								// if alert present, accept and move on.

							} catch (NoAlertPresentException e) {
								// do what you normally would if you didn't have
								// the alert.
							}
							Thread.sleep(8000);
							Thread.sleep(8000);
							 driver.findElement(By.name("checkno")).click();
							Thread.sleep(8000);
							Thread.sleep(5000);
	                        test.log(LogStatus.PASS, "Clicked on Do you want another transaction for this customer : No");
	                        test.log(LogStatus.PASS, "Default Payment Transaction Completed Successfully");		
	                        Thread.sleep(500);
							driver.close();
				
						
                          
						break;
					}
				}

			}
			// }

		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//test.log(LogStatus.FAIL, "Default Payment is failed");

		}

	}
}

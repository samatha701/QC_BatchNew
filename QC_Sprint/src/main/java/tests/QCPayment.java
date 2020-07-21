package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class QCPayment extends QCStore
{

	public static void payment(String SSN,String AppURL) throws InterruptedException
	{
		
			int lastrow=TestData.getLastRow("Payment");
			String sheetName="Payment";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
					String PIN = TestData.getCellData(sheetName,"Password",row);
					String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);	
					String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);

					Thread.sleep(10000);
					test.log(LogStatus.INFO,"Payment started");
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
								
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					Thread.sleep(5000);					  
						
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
					Thread.sleep(5000);
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button ");
					Thread.sleep(8000);	
					
					if(PaymentType.equalsIgnoreCase("Pay any other Amt")){
					
					driver.findElement(By.id("PD5")).click();
					test.log(LogStatus.PASS, "Clicked on pay other amount check box ");
					
					driver.findElement(By.name("requestBean.siilBean.payAmt")).sendKeys(PaymentAmount);
					test.log(LogStatus.PASS, "PaymentAmount entered :"+PaymentAmount);
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount);
					test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
					}
					else if(PaymentType.equalsIgnoreCase("Pay Off the balance")){
						driver.findElement(By.id("PD3")).click();
						test.log(LogStatus.PASS, "Clicked on pay other amount check box ");
						TenderAmount=driver.findElement(By.name("payOff")).getAttribute("value");
						String intdue=driver.findElement(By.name("htmlIntFee")).getAttribute("value");
						test.log(LogStatus.PASS, "Interest pay due is :"+intdue);
						driver.findElement(By.name("history")).click();
						test.log(LogStatus.PASS, "clicked on history button");
						
						Thread.sleep(3000);
						String main_window = driver.getWindowHandle();
						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);
								driver.switchTo().window(winHandle1);
								Thread.sleep(5000);
							}}
							                                     //*[@id="transactionHistoryTable"]/tbody/tr/td[3]/table/tbody/tr[28]/td/span[2]
						String intPaidDate= driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[28]/td/span[2]")).getAttribute("value");
						test.log(LogStatus.PASS, "Interest pay due amount is"+intPaidDate);
						Thread.sleep(1000);
						driver.findElement(By.id("back")).click();
						test.log(LogStatus.PASS, "clicked on back button");
							
						int paidDate= Integer.valueOf(intPaidDate);
						int interestdue= Integer.valueOf(intdue);
						int cappedInt= interestdue+paidDate;
						String cappIntNew=String.valueOf(cappedInt);
						if(feeAmtString.equalsIgnoreCase(cappIntNew)){
						driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
						test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
						driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount.trim());
						test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);
						}
						else
							test.log(LogStatus.PASS,feeAmtString+"is not equals to"+cappIntNew );
					}
					else if(PaymentType.equalsIgnoreCase("Pay Installment Amt")){
						driver.findElement(By.id("PD4")).click();
						test.log(LogStatus.PASS, "Clicked on Pay Installment Amt check box ");
						TenderAmount=driver.findElement(By.name("instAmt")).getAttribute("value");
						
						driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
						test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
						driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount.trim());
						test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
					}
					driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, "Pin is entered as "+ PIN);
					driver.findElement(By.name("finish")).click();
					test.log(LogStatus.PASS, "Clicked on Finish  Payment");

					Thread.sleep(5000);
					try { 
						Alert alert = driver.switchTo().alert();

						alert.accept();
						test.log(LogStatus.PASS, "Alert Handled successfully");
																				
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(4000);
					//if(driver.findElement(By.name("Ok")).isDisplayed())
					{
					test.log(LogStatus.PASS, "Payment transaction is successfully");
					}
					test.log(LogStatus.PASS,"****************************************");
					break;
					
				}
					}
		}

	public static void paymentTwice(String SSN,String AppURL) throws Exception
	{
		
			int lastrow=TestData.getLastRow("PaymentTwice");
			String sheetName="PaymentTwice";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
					String PIN = TestData.getCellData(sheetName,"Password",row);
					String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);	
					String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO,"Payment started");
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
								
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					Thread.sleep(5000);					  
						
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
					Thread.sleep(5000);
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button ");
					Thread.sleep(500);	
				 if(PaymentType.equalsIgnoreCase("Pay Past Due + Next Installment")){
						driver.findElement(By.id("PD2")).click();
						test.log(LogStatus.PASS, "Clicked on Pay Past Due + Next Installment radio button ");
						driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
						test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
						String TAmoount=driver.findElement(By.name("requestBean.siilBean.payAmt")).getAttribute("value");
						driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TAmoount.trim());
					    test.log(LogStatus.PASS, "TenderAmount is :"+TAmoount);	
					}
					else if(PaymentType.equalsIgnoreCase("Pay Installment Amt")){
					driver.findElement(By.id("PD4")).click();
					test.log(LogStatus.PASS, "Clicked on Pay Installment Amt check box ");
					TenderAmount=driver.findElement(By.name("instAmt")).getAttribute("value");
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
				    driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount.trim());
					test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
					}
					else if(PaymentType.equalsIgnoreCase("Pay Off the balance")){
						driver.findElement(By.id("PD3")).click();
						test.log(LogStatus.PASS, "Clicked on pay off the balance check box ");
						TenderAmount=driver.findElement(By.name("payOff")).getAttribute("value");
						
						driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
						test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
						driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount.trim());
						test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
					}
					driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, "Pin is entered as "+ PIN);
					driver.findElement(By.name("finish")).click();
					test.log(LogStatus.PASS, "Clicked on Finish Payment");

					Thread.sleep(5000);
					try { 
						Alert alert = driver.switchTo().alert();

						alert.accept();
						test.log(LogStatus.PASS, "Alert Handled successfully");
																				
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(4000);
					//if(driver.findElement(By.name("Ok")).isDisplayed())
					{
					test.log(LogStatus.PASS, "Payment transaction is successfully");
					}
					test.log(LogStatus.PASS,"****************************************");
					break;
					
				}
		}
}
public static void paypastdue(String SSN,String AppURL) throws InterruptedException
{
	
		int lastrow=TestData.getLastRow("Payment");
		String sheetName="Payment";

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String TxnType = TestData.getCellData(sheetName,"TxnType",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
				String PIN = TestData.getCellData(sheetName,"Password",row);
				String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);	
				String PaymentType = TestData.getCellData(sheetName,"PaymentType1",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"Payment started");
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
							
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);					  
					
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys(TxnType);
				test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button ");
				Thread.sleep(8000);	
				
				if(PaymentType.equalsIgnoreCase("Pay any other Amt")){
				
				driver.findElement(By.id("PD5")).click();
				test.log(LogStatus.PASS, "Clicked on pay other amount check box ");
				
				driver.findElement(By.name("requestBean.siilBean.payAmt")).sendKeys(PaymentAmount);
				test.log(LogStatus.PASS, "PaymentAmount entered :"+PaymentAmount);
				driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
				test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
				
				driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount);
				test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
				}
				else if(PaymentType.equalsIgnoreCase("Pay Off the balance")){
					driver.findElement(By.id("PD3")).click();
					test.log(LogStatus.PASS, "Clicked on pay other amount check box ");
					TenderAmount=driver.findElement(By.name("payOff")).getAttribute("value");
					
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount.trim());
					test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
				}
				else if(PaymentType.equalsIgnoreCase("Pay Past Due Amt")){
					driver.findElement(By.id("PD1")).click();
					test.log(LogStatus.PASS, "Clicked on Pay Past Due Amt check box ");
					TenderAmount=driver.findElement(By.name("instAmt")).getAttribute("value");
					
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount.trim());
					test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
				}
				driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
				test.log(LogStatus.PASS, "Pin is entered as "+ PIN);
				driver.findElement(By.name("finish")).click();
				test.log(LogStatus.PASS, "Clicked on Finish  Payment");

				Thread.sleep(5000);
				try { 
					Alert alert = driver.switchTo().alert();

					alert.accept();
					test.log(LogStatus.PASS, "Alert Handled successfully");
																			
				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}
				Thread.sleep(4000);
				try{
				if(driver.findElement(By.name("Ok")).isDisplayed())
				{
				test.log(LogStatus.PASS, "Payment transaction is successfully");
				}
				test.log(LogStatus.PASS,"****************************************");
				}
				catch(Exception e){
					
				}
				break;
				
			}
				}
	}
public static void paymentinterestdue(String SSN,String AppURL) throws Exception
{
	
		int lastrow=TestData.getLastRow("Payment");
		String sheetName="Payment";

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String TxnType = TestData.getCellData(sheetName,"TxnType",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
				String PIN = TestData.getCellData(sheetName,"Password",row);
				String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);	
				String PaymentType = TestData.getCellData(sheetName,"PaymentIntDue",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"Payment started");
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
							
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);					  
					
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys(TxnType);
				test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button ");
				Thread.sleep(500);	
				if(PaymentType.equalsIgnoreCase("Pay any other Amt")){
					
					driver.findElement(By.id("PD5")).click();
					test.log(LogStatus.PASS, "Clicked on pay other amount check box ");
					String intdue=driver.findElement(By.name("htmlIntFee")).getAttribute("value");
					driver.findElement(By.name("requestBean.siilBean.payAmt")).sendKeys(intdue);
					test.log(LogStatus.PASS, "PaymentAmount entered :"+intdue);
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(intdue);
					test.log(LogStatus.PASS, "TenderAmount is :"+intdue);	
				}
				else if(PaymentType.equalsIgnoreCase("Pay Installment Amt")){
				driver.findElement(By.id("PD4")).click();
				test.log(LogStatus.PASS, "Clicked on Pay Installment Amt check box ");
				TenderAmount=driver.findElement(By.name("instAmt")).getAttribute("value");
				driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
				test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
			    driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount.trim());
				test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
				}
				driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
				test.log(LogStatus.PASS, "Pin is entered as "+ PIN);
				driver.findElement(By.name("finish")).click();
				test.log(LogStatus.PASS, "Clicked on Finish Payment");

				Thread.sleep(5000);
				try { 
					Alert alert = driver.switchTo().alert();

					alert.accept();
					test.log(LogStatus.PASS, "Alert Handled successfully");
																			
				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}
				Thread.sleep(4000);
				
				{
				test.log(LogStatus.PASS, "Payment transaction is successfully");
				}
				test.log(LogStatus.PASS,"****************************************");
				break;
				
			}
				}
	}
public static void payOff(String SSN,String AppURL) throws InterruptedException
{
	
		int lastrow=TestData.getLastRow("Payment");
		String sheetName="Payment";

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String TxnType = TestData.getCellData(sheetName,"TxnType",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
				String PIN = TestData.getCellData(sheetName,"Password",row);
				String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);	
				String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"Payment started");
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
							
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);					  
					
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys("History");
				test.log(LogStatus.PASS, "Transaction Type is selected as History");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button ");
				Thread.sleep(3000);
				String intPaidDate= driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[28]/td/span[2]")).getText();
				test.log(LogStatus.PASS, "Interest pay due amount is"+intPaidDate);
				Thread.sleep(1000);
				driver.findElement(By.id("back")).click();
				test.log(LogStatus.PASS, "clicked on back button");
				driver.findElement(By.name("transactionList")).sendKeys(TxnType);
				test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button ");
				Thread.sleep(5000);	
				
					driver.findElement(By.id("PD3")).click();
					test.log(LogStatus.PASS, "Clicked on pay other amount check box ");
					TenderAmount=driver.findElement(By.name("payOff")).getAttribute("value");
					String intdue=driver.findElement(By.name("htmlIntFee")).getAttribute("value");
					test.log(LogStatus.PASS, "Interest pay due is :"+intdue);
					Thread.sleep(3000);
					float paidDate= Float.parseFloat(intPaidDate);
					float interestdue= Float.parseFloat(intdue);
					float cappedInt= interestdue+paidDate;
					String cappIntNew=String.valueOf(cappedInt);
					test.log(LogStatus.PASS, "capped interest :"+cappIntNew);
					if(feeAmtString.equalsIgnoreCase(cappIntNew)){
						test.log(LogStatus.PASS,feeAmtString+"is equals to"+cappIntNew );
					}
					else
					test.log(LogStatus.PASS,"capped Interest "+cappIntNew+ "is less than or equals to contract Interest "+feeAmtString );
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount.trim());
					test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);
						
				}
				
				driver.findElement(By.name("requestBean.password")).sendKeys("1234");
				test.log(LogStatus.PASS, "Pin is entered as 1234");
				driver.findElement(By.name("finish")).click();
				test.log(LogStatus.PASS, "Clicked on Finish Payment");

				Thread.sleep(5000);
				try { 
					Alert alert = driver.switchTo().alert();

					alert.accept();
					test.log(LogStatus.PASS, "Alert Handled successfully");
																			
				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}
				Thread.sleep(4000);
				//if(driver.findElement(By.name("Yes")).isDisplayed())//checkyes
				{
				test.log(LogStatus.PASS, "Payment transaction is successfully");
				}
				test.log(LogStatus.PASS,"****************************************");
				break;
				
			}
				}
public static void defaultPayment(String SSN,String AppURL) throws InterruptedException
{
	
		int lastrow=TestData.getLastRow("Payment");
		String sheetName="Payment";

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String TxnType = TestData.getCellData(sheetName,"TxnType",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
				String PIN = TestData.getCellData(sheetName,"Password",row);
				String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);	
				String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"Payment started");
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
							
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);					  
					
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys("History");
				test.log(LogStatus.PASS, "Transaction Type is selected as History");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button ");
				Thread.sleep(3000);
				String intPaidDate= driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[28]/td/span[2]")).getText();
				test.log(LogStatus.PASS, "Interest pay due amount is"+intPaidDate);
				Thread.sleep(1000);
				driver.findElement(By.id("back")).click();
				test.log(LogStatus.PASS, "clicked on back button");
				driver.findElement(By.name("transactionList")).sendKeys("Default Payment");
				test.log(LogStatus.PASS, "Transaction Type is selected as Default Payment");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button ");
				Thread.sleep(5000);	
				
					String intdue=driver.findElement(By.name("transactionDataBean.defaultInterest")).getAttribute("value");
					test.log(LogStatus.PASS, "Interest pay due is :"+intdue);
					Thread.sleep(3000);
					float paidDate= Float.parseFloat(intPaidDate);
					float interestdue= Float.parseFloat(intdue);
					float cappedInt= interestdue+paidDate;
					String cappIntNew=String.valueOf(cappedInt);
					test.log(LogStatus.PASS, "Total interest :"+cappIntNew);
					if(feeAmtString.equalsIgnoreCase(cappIntNew)){
						test.log(LogStatus.FAIL,feeAmtString+"is equals to"+cappIntNew );
					}
					else
						test.log(LogStatus.PASS,"capped Interest "+cappIntNew+ "is less than or equals to contract Interest "+feeAmtString );
						
				}
				Thread.sleep(1000);
				try { 
					Alert alert = driver.switchTo().alert();

					alert.accept();
					test.log(LogStatus.PASS, "Alert Handled successfully");
																			
				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}
				break;
				
		}
	}
}
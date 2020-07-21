package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class QCCSRDefaultPayment extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void defaultpayment(String SSN, String AppURL) throws InterruptedException {
		
			int lastrow = TestData.getLastRow("DefaultPayment");
			String sheetName = "DefaultPayment";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
			    //String TxnType = "Default Payment";
				String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "Default Payment started");
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
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(locator(Sprop.getProperty("csr_new_loan_go_button"))).click();
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
						//WebElement w1=driver.findElement(By.className("dropDown180"))
						
                            driver.findElement(By.name("transactionList")).sendKeys(TxnType);
							test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
							driver.findElement(By.name("button")).click();
							test.log(LogStatus.PASS, "Clicked on Go button");
							Thread.sleep(500);
							
							String Paymentamt = driver.findElement(By.className("textBox119editable")).getAttribute("value");
							test.log(LogStatus.PASS, "Paymentamt is :" + Paymentamt);
							driver.findElement(By.id("payAmt")).clear();
							driver.findElement(By.id("payAmt")).sendKeys(Paymentamt);
							test.log(LogStatus.PASS, "Payment amount entered :" + Paymentamt);
							Thread.sleep(500);
							/* String defaultamt =driver.findElement(By.id("payAmt1")).getText();
				             driver.findElement(By.id("payAmt")).sendKeys(defaultamt);*/
							 
							driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
							test.log(LogStatus.PASS, "Tender Type selected :" + TenderType);
							WebElement w1=driver.findElement(By.name("crditNbrFirst"));
							Select s=new Select(w1);
							s.selectByIndex(2);
							driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Paymentamt);
							test.log(LogStatus.PASS, "Tender amount entered :" + Paymentamt);
							driver.findElement(By.name("password")).sendKeys(PIN);
							
							test.log(LogStatus.PASS, "Pin is entered :" + PIN);
							Thread.sleep(500);
							driver.findElement(By.name("Submit22")).click();
							test.log(LogStatus.PASS, "Clicked on Finish Payment");
							
							test.log(LogStatus.PASS, "<FONT color=green style=Arial>Default Payment Transaction Completed Successfully");
							Thread.sleep(5000);
							
					}
		}
        }
		
	}
}
		
		
	

	

		


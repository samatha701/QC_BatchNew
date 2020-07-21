package tests;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCHistoryold extends QCStore {
	public static String Pbal;
	public static String cardType;
	public static String cardNumber;
	public static String cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;

	public static void history(String SSN, String AppURL) throws Exception {
		int i;
		for (i = 0; i < 3; i++) {
			
			try {
				int lastrow = TestData.getLastRow("Refinance");
				String sheetName = "Refinance";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {

						String Bank_ChkgAcctNbr = TestData.getCellData(sheetName, "Bank_ChkgAcctNbr", row);
						String last4cheknum = Bank_ChkgAcctNbr.substring(Bank_ChkgAcctNbr.length() - 4);
						String ESign_DisbType = TestData.getCellData(sheetName, "ESign_DisbType", row);
						String ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent",
								row);
						String ESign_Preference = TestData.getCellData(sheetName, "ESign_Preference", row);
						String ESign_CheckNbr = TestData.getCellData(sheetName, "ESign_CheckNbr", row);
						String No_of_checks = TestData.getCellData(sheetName, "No_of_checks", row);
						String Esign_Password = TestData.getCellData(sheetName, "ESign_Password", row);
						String Esign_CollateralType = TestData.getCellData(sheetName, "Esign_CollateralType", row);
						String Collateral = TestData.getCellData(sheetName, "Collateral", row);

						cardType = TestData.getCellData(sheetName, "Card Type ", row);
						cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
						cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
						cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
						cvv = TestData.getCellData(sheetName, "CVV", row);
						CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3, 5);
						String SSN3 = SSN.substring(5, 9);

						Thread.sleep(3000);
						test.log(LogStatus.INFO, "Refinance StepDown  process has started");
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
						test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
						driver.findElement(locator(prop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
						driver.findElement(locator(prop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
						driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
						test.log(LogStatus.PASS, "Clicked on submit Button");
						/*
						 * for(String winHandle : driver.getWindowHandles()) {
						 * driver.switchTo().window(winHandle);
						 */
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
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
						// driver.findElement(By.xpath("
						// /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						// test.log(LogStatus.PASS, "Clicked on Go button under
						// Loans section");
						Thread.sleep(5000);
						driver.findElement(By.name("transactionList")).sendKeys("History");
						test.log(LogStatus.PASS, "Transaction Type is selected as History");
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(5000);
						
						List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr")); 
						int n=rows.size();
						
						n=n-1;
						//*[@id="transactionDetailsTable"]/tbody/tr[3]/td[5]/font
						
					/*String cust_transaction_date= driver.findElement(locator(prop.getProperty("cust_transaction_date"))).getText();
					String cust_transaction_date_array[]=cust_transaction_date.split(" ");
					cust_transaction_date=cust_transaction_date_array[0];*/
						cust_doc_total_amount= driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+n+"]/td[7]/font")).getText();
						test.log(LogStatus.PASS, "Transaction amount from History is "+cust_doc_total_amount);
						break;
					}
				}

				break;

			}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// test.log(LogStatus.FAIL, MarkupHelper.createLabel("Getting
				// Encryption from Admin is failed", ExtentColor.RED));
				test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
				String screenshotPath = getScreenhot(driver, "Exception");
								test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.INFO, "Refinance StepSame process is initiated again due to Application sync issue");
				driver.get(prop.getProperty("login_page")); 
				continue;

			}

		}
		if (i == 3) {
			test.log(LogStatus.FAIL, "Store setup is failed");
			Assert.assertTrue(false);

		}
	}
}

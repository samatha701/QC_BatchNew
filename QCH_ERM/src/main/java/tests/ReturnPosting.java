package tests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class ReturnPosting extends QCStore {
	public static String Pbal;
	public static String cardType;
	public static String cardNumber;
	public static String cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;

	public static void returnPosting(String SSN, String AppURL) throws Exception {
		
				int lastrow = TestData.getLastRow("NewLoan");
				String sheetName = "NewLoan";

				for (int row = 2; row <= lastrow+1; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {

						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3, 5);
						String SSN3 = SSN.substring(5, 9);

						Thread.sleep(3000);
						test.log(LogStatus.INFO, "Return Posting  process has started");
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
						test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
						driver.findElement(locator(Aprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
						driver.findElement(locator(Aprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
						driver.findElement(locator(Aprop.getProperty("csr_new_loan_submit_button"))).click();
						test.log(LogStatus.PASS, "Clicked on submit Button");
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(locator(Aprop.getProperty("csr_new_loan_go_button"))).click();
						test.log(LogStatus.PASS, "Clicked on GO Button under search results");
						Thread.sleep(2000);
						
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
						Thread.sleep(1000);
											
						List<WebElement> rows =driver.findElements(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr"));
						int rcount=rows.size();
						System.out.println("No of rows"+rcount);
						rcount=rcount-1;
						String TXtype=	driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+rcount+"]/td[6]")).getText();
						System.out.println("transaction type is "+TXtype);
						test.log(LogStatus.PASS, "Transaction type is"+TXtype);
						if(TXtype.equalsIgnoreCase("Debit Card Return Posting"))
						{
							
							test.log(LogStatus.PASS,"Debit card returnposting completed" );
							Thread.sleep(4000);
						}
						else
						{
							test.log(LogStatus.FAIL, "Debit Card returnposting is failed");
						}
						
					
						}
						
						
					}
				}
}

 



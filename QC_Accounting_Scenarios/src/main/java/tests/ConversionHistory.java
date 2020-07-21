package tests;

    import java.text.DateFormat;
	import java.text.DecimalFormat;
	import java.text.SimpleDateFormat;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.NoAlertPresentException;
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
	public class ConversionHistory extends QCStore {

		public static String Pbal;
		public static String cardType;
		public static String cardNumber;
		public static String cardEx_month;
		public static String cardEx_Year;
		public static String cvv;
		public static String CardHolderName;

		public static void history(String SSN, String AppURL) throws Exception {
			
					int lastrow = TestData.getLastRow("New_Loan");
					String sheetName = "New_Loan";

					for (int row = 2; row <= lastrow; row++) {
						String RegSSN = TestData.getCellData(sheetName, "SSN", row);
						if (SSN.equals(RegSSN)) {

						
							String SSN1 = SSN.substring(0, 3);
							String SSN2 = SSN.substring(3, 5);
							String SSN3 = SSN.substring(5, 9);

							Thread.sleep(3000);
							test.log(LogStatus.INFO, "Chargeback  process has started");
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
							String TXtype=	driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[6]/td[6]/font")).getText();
							System.out.println("transaction type is "+TXtype);
							test.log(LogStatus.PASS, "Transaction type is"+TXtype);
							if(TXtype.equalsIgnoreCase("Cash Again Buyback"))
							{
								driver.findElement(By.name("back")).click();
								test.log(LogStatus.PASS, "clicked on Back button");
								driver.findElement(By.xpath("//input[@value='Back']")).click();
								test.log(LogStatus.PASS, "clicked on Back button");
								driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[7]/td[13]/input")).click();
								test.log(LogStatus.PASS, "clicked on ILP Go button");
								driver.findElement(By.name("transactionList")).sendKeys("History");
								test.log(LogStatus.PASS, "Transaction Type is selected as History");
								driver.findElement(By.name("button")).click();
								test.log(LogStatus.PASS, "Clicked on Go button");
								Thread.sleep(5000);
								String TXtype1= driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[6]/td[6]/font")).getText();
								if(TXtype1.equalsIgnoreCase("Cash Again Buyback"))
								{
									test.log(LogStatus.PASS, "void completed");
							}
							
							try{
								Alert alert = driver.switchTo().alert();
								alert.accept();
								String s=alert.getText();
								test.log(LogStatus.PASS, "Alert accepted "+s);
								Thread.sleep(2000);
								// if alert present, accept and move on.
							}
							catch(Exception e){
								
							}
						
							}
							
							
						}
					}

	}


}

package tests;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class BGracedays_Loan extends QCStore{
	public static String ACH_type;
	public static String ACH_transaction;
	public static String ACH_status;
	public static String ACH_amount;
	public static String ACH_ABA_code;
	public static String ACH_check_acc_no;
	public static String ach_history_ach_type;
	public static String ach_history_ach_transaction;
	public static String ach_history_ach_status;
	public static String ach_history_ach_amt;
	public static String ach_history_ach_check_acc_no;
	public static String ach_history_ach_ABA_code;

	public static void duedate(String SSN,String AppURL) throws InterruptedException, ParseException
	{
		
	
		
		int lastrow = TestData.getLastRow("New_Loan");
		String sheetName = "New_Loan";
			

			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{

					
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					        String AgeStore = TestData.getCellData(sheetName, "AgeStore", row);
				
				
					        
					Thread.sleep(4000);
				//	test.log(LogStatus.INFO, MarkupHelper.createLabel("Transaction History validation has started", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "Transaction Gracedays validation has started");
					 
			        driver.switchTo().frame("bottom");
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					String store_date[]=Str_date.split(":");
	
					business_date=store_date[1].trim();
					test.log(LogStatus.PASS, "Business date is :"+business_date);
				      String cust_transaction_date_test=business_date;

					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
					/*driver.switchTo().defaultContent();				
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();	*/		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(3000);
	
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
			
					driver.findElement(By.cssSelector("li[id='911101']")).click();			
					test.log(LogStatus.PASS, "Clicked on Transactions");		
					driver.switchTo().frame("main");		
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(By.name("submit1")).click();
					test.log(LogStatus.PASS, "Click on submit Button");		
					for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    
				    
				  // String loan_nbr= driver.findElement(locator(Sprop.getProperty("csr_loan_nbr"))).getText();
				  // test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					// driver.findElement(By.name("button")).click();
					
				for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
				
					   // driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					    Thread.sleep(6000);
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 
						
						 Thread.sleep(6000);
					
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
						 
	
							 NextDueDate= driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
						loan_nbr= driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]")).getText();
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("topFrame");
						driver.findElement(By.xpath("//*[@id='930000']/a")).click();
						test.log(LogStatus.PASS, "Clicked on Cash Management");
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						try {
							driver.findElement(By.xpath("//*[@id='988190657']/a")).click();
							test.log(LogStatus.PASS, "Clicked on Start Scheduler");
						} catch (Exception e) {
							driver.get(Sprop.getProperty("login_page")); 

							driver.switchTo().defaultContent();
							driver.switchTo().frame("topFrame");
							driver.findElement(By.xpath("//*[@id='930000']/a")).click();

							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.findElement(By.xpath("//*[@id='988190657']/a")).click();
							test.log(LogStatus.PASS, "Clicked on Start Scheduler");
						}
						int IAgeStore = Integer.parseInt(AgeStore);

						DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
						Date DDueDateminus1 = df.parse(business_date);
						Calendar cal = Calendar.getInstance();
						cal.setTime(DDueDateminus1);
						cal.add(Calendar.DATE, IAgeStore);
						Date DDueDate1 = cal.getTime();
						String Gracedays = df.format(DDueDate1);
						System.out.println(Gracedays);
						NextDueDate=Gracedays;

						test.log(LogStatus.PASS, "Age Store Date after increasing is :" + Gracedays);

						Thread.sleep(5000);

						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
				
						Thread.sleep(5000);
						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						String Due_Date[] = Gracedays.split("/");
						String Due_Date1 = Due_Date[0];
						String Due_Date2 = Due_Date[1];
						String Due_Date3 = Due_Date[2];
						driver.findElement(By.name("endMonth")).sendKeys(Due_Date1);
						test.log(LogStatus.PASS, "Month is entered: " + Due_Date1);
						driver.findElement(By.name("endDay")).sendKeys(Due_Date2);
						test.log(LogStatus.PASS, "Date is entered: " + Due_Date2);
						driver.findElement(By.name("endYear")).sendKeys(Due_Date3);
						test.log(LogStatus.PASS, "Year is entered: " + Due_Date3);
						driver.findElement(By.name("runSchedulerBtn")).click();
						test.log(LogStatus.PASS, "Clicked on Run Scheduler");
						Thread.sleep(500);
						// String alert1= driver.switchTo().alert().getText();
						// test.log(LogStatus.PASS, "Clicked on Finish Loan:
						// "+alert1);

						try {
							Alert alert = driver.switchTo().alert();

							alert.accept();
							// if alert present, accept and move on.

						} catch (Exception e) {
							// do what you normally would if you didn't have the
							// alert.
						}
						Thread.sleep(30000);

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ok")));
						Thread.sleep(5000);
						driver.findElement(By.name("ok")).click();
						// test.log(LogStatus.PASS, "Clicked on Scheduler Ok");
						// test.log(LogStatus.PASS,
						// MarkupHelper.createLabel("Clicked on Scheduler Ok
						// Successfully",ExtentColor.GREEN));
						test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
						test.log(LogStatus.PASS, "************************************************");

						Thread.sleep(5000);
						driver.close();

						break;
					}
			}
	}
}
	


			

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

public class VQCSRWaiveFee extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	public static String PartialAmount;
	public static void WaiveFeeFull(String SSN, String AppURL) {
		try {
						int lastrow = TestData.getLastRow("WaiveFee");
			String sheetName = "WaiveFee";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String Waive_Type= TestData.getCellData(sheetName,"Waive_Type",row);
				encryption_store_no = TestData.getCellData(sheetName,"StoreID",row);
				
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName,"StateID",row);
					
					 
	
					 SSN1 = SSN.substring(0, 3);
					 SSN2 = SSN.substring(3,5);
					 SSN3 = SSN.substring(5,9);
					
					
					Thread.sleep(3000);
					test.log(LogStatus.INFO,"Waive Fee started");
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
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(By.name("submit1")).click();
					test.log(LogStatus.PASS, "Clicked on submit Button");		
					/*for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);*/				
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");					    					   					     
				    driver.findElement(By.name("button")).click();
				    test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				    Thread.sleep(5000);					  
					for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}			
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					
					 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					 test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
					 Thread.sleep(5000);
					 driver.findElement(By.name("transactionList")).sendKeys("Waive Fee");
					 test.log(LogStatus.PASS, "Transaction Type is selected as Waive Fee");
					 driver.findElement(By.name("button")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button");
					 Thread.sleep(500);	
					 driver.findElement(By.name("lateFeeChkBox")).click();
					 test.log(LogStatus.PASS, "Clicked on Waive fee Checkbox button");
					
										 						 
					 String Late_Fee_Due = driver.findElement(By.name("transactionDataBean.lateFeeDue")).getAttribute("value");
					
					 driver.findElement(By.name("transactionDataBean.waiveLateFeeAmt")).sendKeys(Late_Fee_Due);
					 test.log(LogStatus.PASS, "Full late Late_Fee is :"+Late_Fee_Due);
					 
					 encryption_transaction_nbr = driver.findElement(By.name("transactionDataBean.origTranNbr")).getAttribute("value");
					 test.log(LogStatus.PASS, "Tran_Nbr :"+encryption_transaction_nbr);
					
						
		//Admin Login For Getting Encryption Key
						
						//driver1 = new InternetExplorerDriver();
						String mainwindow2=driver.getWindowHandle();
						AdminLoginForEncryption.getEncryption(driver1, SSN, AppURL);
						 Thread.sleep(5000);
						 driver.switchTo().window(mainwindow2);
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						 Thread.sleep(3000);
						 //driver.findElement(By.name("customerBean.eanNbr1")).sendKeys(Eankey);
						 
						 driver.findElement(By.name("transactionDataBean.encryptionKey")).sendKeys(Eankey);
						 test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
						 
						 driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
						 
						 test.log(LogStatus.PASS, "Entered the PIN as: " +PIN);
						 Thread.sleep(500);
						 driver.findElement(By.name("finish")).click();
						 test.log(LogStatus.PASS, "Clicked on finish Button");
						 Thread.sleep(5000);
						 
						 test.log(LogStatus.PASS, "WaveOff Completed Successfully");
						// driver.close();
						 

					 //break;
					}
			}
	
	


		}
		

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Getting Encryption from Admin is failed", ExtentColor.RED));
					test.log(LogStatus.INFO, "Store setup process is initiated again due to Application sync issue");

					//continue;


				}
	}


public static void WaiveFeePartial(String SSN, String AppURL){
	try {
		int lastrow = TestData.getLastRow("WaiveFee");
String sheetName = "WaiveFee";

for (int row = 2; row <= lastrow; row++) {
String RegSSN = TestData.getCellData(sheetName, "SSN", row);
String TenderType = TestData.getCellData(sheetName,"TenderType",row);
String PIN = TestData.getCellData(sheetName,"PIN",row);
String Waive_Type= TestData.getCellData(sheetName,"Waive_Type",row);

if (SSN.equals(RegSSN)) {
	State = TestData.getCellData(sheetName,"StateID",row);
	
	 

	 SSN1 = SSN.substring(0, 3);
	 SSN2 = SSN.substring(3,5);
	 SSN3 = SSN.substring(5,9);
	
	
	Thread.sleep(3000);
	test.log(LogStatus.INFO,"Waive Fee Partial started");
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
	test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
	driver.findElement(By.name("ssn2")).sendKeys(SSN2);
	test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
	driver.findElement(By.name("ssn3")).sendKeys(SSN3);
	test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
	driver.findElement(By.name("submit1")).click();
	test.log(LogStatus.PASS, "Clicked on submit Button");		
	/*for(String winHandle : driver.getWindowHandles()){
    driver.switchTo().window(winHandle);*/				
    driver.switchTo().defaultContent();
    driver.switchTo().frame("mainFrame");
    driver.switchTo().frame("main");					    					   					     
    driver.findElement(locator(Sprop.getProperty("csr_new_loan_go_button"))).click();
    test.log(LogStatus.PASS, "Clicked on GO Button under search results");
    Thread.sleep(5000);					  
	for( String winHandle1 : driver.getWindowHandles())
	{
	    driver.switchTo().window(winHandle1);
	}			
	 driver.switchTo().defaultContent();
	 driver.switchTo().frame("mainFrame");
	 driver.switchTo().frame("main");
	
	 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
	 test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
	 Thread.sleep(5000);
	 driver.findElement(By.name("transactionList")).sendKeys("Waive Fee");
	 test.log(LogStatus.PASS, "Transaction Type is selected as Waive Fee");
	 driver.findElement(By.name("button")).click();
	 test.log(LogStatus.PASS, "Clicked on Go button");
	 Thread.sleep(500);	
	 driver.findElement(By.name("lateFeeChkBox")).click();
	 test.log(LogStatus.PASS, "Clicked on Waive fee Checkbox button");
	
						 						 
	 String Late_Fee_Due = driver.findElement(By.name("transactionDataBean.lateFeeDue")).getAttribute("value");
	
	 //-----------------*06-AUG-2019*----------------------//
		
	
	 float PartialAmt=Float.valueOf(Late_Fee_Due);
		PartialAmt=PartialAmt-10;
		PartialAmount = Float.toString(PartialAmt);
		driver.findElement(By.name("transactionDataBean.waiveLateFeeAmt")).sendKeys(PartialAmount);
	    test.log(LogStatus.PASS, "Partial Late_Fee is :"+PartialAmount);
	    
		
	 driver.findElement(By.name("transactionDataBean.waiveLateFeeAmt")).sendKeys(PartialAmount);
	 test.log(LogStatus.PASS, "PartialAmount is :"+PartialAmount);
	 
	 Tran_Nbr= driver.findElement(By.name("transactionDataBean.origTranNbr")).getAttribute("value");
	 test.log(LogStatus.PASS, "Tran_Nbr :"+Tran_Nbr);
	 
		String mainwindow2=driver.getWindowHandle();
		AdminLoginForEncryption.getEncryption(driver1, SSN, AppURL);
		 Thread.sleep(5000);
		 driver.switchTo().window(mainwindow2);
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame("mainFrame");
		 driver.switchTo().frame("main");
		 Thread.sleep(5000);
		 
		 driver.findElement(By.name("transactionDataBean.encryptionKey")).sendKeys(Eankey);
		 test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
		 
		 driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
		 
		 test.log(LogStatus.PASS, "Entered the PIN as: " +PIN);
		 Thread.sleep(500);
		 driver.findElement(By.name("finish")).click();
		 test.log(LogStatus.PASS, "Clicked on finish Button");
		 Thread.sleep(5000);
		 
		 test.log(LogStatus.PASS, "WaveOff Completed Successfully");
		 driver.close();
		 

	 break;
	}
}




}


catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Getting Encryption from Admin is failed", ExtentColor.RED));
	test.log(LogStatus.INFO, "Store setup process is initiated again due to Application sync issue");

	//continue;


}
}

	
	
	
}


		
	



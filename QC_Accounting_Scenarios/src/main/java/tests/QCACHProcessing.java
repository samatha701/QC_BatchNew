package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class QCACHProcessing extends QCStore {
	
	public static void achProcess(String SSN,String NextDueDate) throws Exception
	{
		 
		
			int lastrow=TestData.getLastRow("Deposit");
			String sheetName= "Deposit";
			
				
			for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String StoreID = TestData.getCellData(sheetName,"StoreID",row);
					
					if(SSN.equals(RegSSN))
					{
							
			       Thread.sleep(4000);
					test.log(LogStatus.INFO, "ACH Processing through from Admin has initiated");
					driver.switchTo().defaultContent();	
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					driver.findElement(By.id("500000")).click();		
					test.log(LogStatus.PASS, "Clicked on Transactions");
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
				
					 Actions action = new Actions(driver);  
					 WebElement ACH=driver.findElement(By.id("503000"));
					 action.moveToElement(ACH).build().perform();
					 test.log(LogStatus.PASS, " Mouse hover on ACH menu");
					 Thread.sleep(2000);
					 WebElement pdl=driver.findElement(By.id("503010"));
					 action.moveToElement(pdl).build().perform();
					 test.log(LogStatus.PASS, " Mouse hover on payday loan menu");
					 Thread.sleep(3000);
					 driver.findElement(By.id("503019")).click();
					 test.log(LogStatus.PASS, " click on ACH Processing");
					 Thread.sleep(3000);
					
				for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
				 driver.switchTo().defaultContent();
				 driver.switchTo().frame("mainFrame");
				 driver.switchTo().frame("main");
				 
				 driver.findElement(By.xpath("//b/input[@name='filterOption']")).click();
				 driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);
				 test.log(LogStatus.PASS, "StoreID is entered: "+StoreID);
				
				 test.log(LogStatus.PASS, "Store Date is :"+business_date);
				 Thread.sleep(5000);
				 String Due_Date[] =business_date.split("/");
			     String Due_Date1 = Due_Date[0];
			     String Due_Date2 = Due_Date[1];
			     String Due_Date3 = Due_Date[2];
			     driver.findElement(By.name("fromDate1")).clear();
			     driver.findElement(By.name("fromDate1")).sendKeys(Due_Date1);
			        test.log(LogStatus.PASS, "Begin Month is entered: "+Due_Date1);
			        driver.findElement(By.name("fromDate2")).clear();
			        driver.findElement(By.name("fromDate2")).sendKeys(Due_Date2);
					test.log(LogStatus.PASS, "Begin Date is entered: "+Due_Date2);
					driver.findElement(By.name("fromDate3")).clear();
					driver.findElement(By.name("fromDate3")).sendKeys(Due_Date3);
					test.log(LogStatus.PASS, "Begin Year is entered: "+Due_Date3);
					
					driver.findElement(By.name("toDate1")).clear();
					driver.findElement(By.name("toDate1")).sendKeys(Due_Date1);
			        test.log(LogStatus.PASS, "End Month is entered: "+Due_Date1);
			        driver.findElement(By.name("toDate2")).clear();
			        driver.findElement(By.name("toDate2")).sendKeys(Due_Date2);
					test.log(LogStatus.PASS, "End Date is entered: "+Due_Date2);
					driver.findElement(By.name("toDate3")).clear();
					driver.findElement(By.name("toDate3")).sendKeys(Due_Date3);
					test.log(LogStatus.PASS, "End Year is entered: "+Due_Date3); 
					driver.findElement(By.name("submit")).click();
					test.log(LogStatus.PASS, "Click on Submit button ");
					Thread.sleep(5000);
					driver.findElement(By.id("CmdReturnPosting")).click();
					driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					if(driver.findElement(By.xpath("//td[text()='ACH file(s) created successfully']")).isDisplayed()){
					test.log(LogStatus.PASS, "Clicked on ACH Process Now Successfully");
					 test.log(LogStatus.PASS, "********************************************** ");
					}else{
						test.log(LogStatus.INFO, "Clicked on ACH Process Now Successfully");
						 test.log(LogStatus.PASS, "********************************************** ");
					}
					break;
						 
					}
				
					}

}

}

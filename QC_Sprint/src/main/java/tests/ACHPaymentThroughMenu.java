package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class ACHPaymentThroughMenu extends QCStore {
	
	public static void ACHProcess(String SSN,String NextDueDate) throws InterruptedException
	{
		 
	
			int lastrow=TestData.getLastRow("Login");
			String sheetName="Login";
	
				
			for(int row=2;row<=lastrow+1;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String StoreID = TestData.getCellData(sheetName,"StoreID",row);
					//String StoreID ="1706";
					if(SSN.equals(RegSSN))
					{
							
			       Thread.sleep(4000);
					test.log(LogStatus.INFO, "ACH Processing through from Admin has initiated");
					driver.switchTo().defaultContent();	
					driver.switchTo().frame("topFrame");
					driver.findElement(By.linkText("Transactions")).click();
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
					/*WebElement ILP = driver.findElement (By.xpath("//*[@id='503030']"));*/
					 WebElement TLP=driver.findElement(By.id("9881908058"));
					 action.moveToElement(TLP).build().perform();
					 test.log(LogStatus.PASS, " Mouse hover on Title loan menu");

}}
	}
}

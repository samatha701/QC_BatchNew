package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.relevantcodes.extentreports.LogStatus;

public class AdminCapInterest extends QCStore {
	public static void capRule() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topFrame");
		//driver.findElement(By.linkText("Product Config")).click();
		driver.findElement(By.id("400000")).click();
		test.log(LogStatus.PASS, "Clicked on Product config");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		
		//driver.findElement(By.linkText("Product Configuration")).click();
		driver.findElement(By.id("400100")).click();
		test.log(LogStatus.PASS, "Clicked on Product configuration");
		driver.switchTo().frame("main");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,5000)", " ");
		
		Thread.sleep(1000);                  //*[@id="tblGrid"]/tbody/tr[25]/td[2]
		String productname =driver.findElement(By.xpath("//*[@id='tblGrid']/tbody/tr[55]/td[2]")).getText();
		test.log(LogStatus.PASS, "product name displayed as"+productname);
		if(productname.equalsIgnoreCase("MO Multi Title")){
			//*[@id="tblGrid"]/tbody/tr[25]/td[8]/input
		driver.findElement(By.xpath("//*[@id='tblGrid']/tbody/tr[55]/td[8]/input")).click();
		test.log(LogStatus.PASS, "Clicked on MO Multi Title Edit Button");
		}
//		String ruleName =driver.findElement(By.xpath("//*[@id='rulerow-23']/td[3]/div")).getText();
//		test.log(LogStatus.PASS, "Cap Interest Rule Status Displayed as"+ruleName);
	    //check is capInterest status
		String capInrstStatus =driver.findElement(By.xpath("//*[@id='rulerow-24']/td[3]/div")).getText();
		test.log(LogStatus.PASS, "Cap Interest Rule Status Displayed as"+capInrstStatus);
		if(capInrstStatus.equalsIgnoreCase("Yes"))
		{
			test.log(LogStatus.PASS, "Status Varified");
			driver.switchTo().defaultContent();
			 driver.switchTo().frame("topFrame");
			driver.findElement(By.xpath("//*[@id='icons']/li[5]/a")).click();
			test.log(LogStatus.PASS, "Clicked on logOut");
		}
		else
		{
			test.log(LogStatus.PASS, "Cap Interest Rule Status Displayed as No");
		}
	}


}

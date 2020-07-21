package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

public class QC_Online_NewLoanVerify extends QCStore {
	public static void newLoanVerify(String SSN,String AppURL) throws Exception
	{
			
		int lastrow=TestData.getLastRow("Login");
		String sheetName="Login";
		
		/*driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
		//WebDriverWait wait = new WebDriverWait(driver, 5000);
		

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);



	if(SSN.equals(RegSSN))
	{	
		driver.findElement(By.xpath("//*[@id='continueApplication']")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//*[@id='isCustInClearencePeriod']/div/div/div[2]/div[2]/div/center/button")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Payment pending POPUP is displayed");
		}
		else
			test.log(LogStatus.FAIL, "Payment pending POPUP is not displayed");
		driver.close();
}
}}
}
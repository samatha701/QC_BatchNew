package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import tests.LendNation;
public class LendNationLogin extends LendNation
{
	public static void login () throws Exception

	{
		
		try{


	String Url="https://qcln.qfund.net:8090/";

	String state="Missouri";

	driver.get(Url);

	test.log(LogStatus.PASS, "Opened Lend Natino URL "+Url);


	System.out.println("under Registration");

	driver.findElement(By.linkText("QTP")).click();


	test.log(LogStatus.PASS, "Clicked on QTP link ");


	Thread.sleep(4000);

	try{

	//
	 
	try{
		new Select(driver.findElement(By.xpath("//div[@id='StateConfirmation']/div/div/div/div[2]/select"))).selectByVisibleText(state);
	

	test.log(LogStatus.PASS, "Selected the state "+state);
	driver.findElement(By.xpath("//*[@id='StateConfirmation']/div/div/div/div[2]/button")).click();

	test.log(LogStatus.PASS, "clicked on Continue button ");
	}
	catch(Exception e)
	{
		
	}

	


	}

	catch(Exception e)

	{

	System.out.println("under catch");

	//driver.findElement(By.xpath("//div[id='StateConfirmation']/div/div/div/div[2]/select")).click();
	 
	}



	driver.findElement(By.id("loginCaption")).click();
	

	driver.findElement(By.id("Username")).sendKeys("aditya_id2@qfund.net");
	 test.log(LogStatus.PASS, "Entered the username aditya_id2@qfund.net");

	driver.findElement(By.id("Password")).sendKeys("Qfund@123");
	
	 test.log(LogStatus.PASS, "Entered the password Qfund@123");

	driver.findElement(By.id("loginbtn")).click();
	 test.log(LogStatus.PASS, "Clicked on Login button ");
	 Thread.sleep(3000);

		}
		catch(Exception e)
		{
			test.log(LogStatus.ERROR, "Error message  " +e);
			  String screenshotPath = getScreenhot(driver, "registration");
			  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
			Assert.assertTrue(false);
		}

	}


	}


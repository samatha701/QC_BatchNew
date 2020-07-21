package tests;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class LendnationILPPayment extends QCStore {
	
	public static void payment(String SSN,String AppURL) throws Exception
	{
			
		int lastrow=TestData.getLastRow("OnlinePayment");
		String sheetName="OnlinePayment";
		
		/*driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
		//WebDriverWait wait = new WebDriverWait(driver, 5000);
		

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);



	if(SSN.equals(RegSSN))
	{	
		String TxnType = TestData.getCellData(sheetName,"TxnType",row);
		String TenderType = TestData.getCellData(sheetName,"TenderType",row);
		String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
		String PIN = TestData.getCellData(sheetName,"Password",row);
		String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);	
		String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
		String CCMONbr = TestData.getCellData(sheetName,"CCMONbr",row);
		String CardType = TestData.getCellData(sheetName,"Card Type ",row);
		String CardNbr = TestData.getCellData(sheetName,"Debit Card No",row);
		String ExpMonth = TestData.getCellData(sheetName,"Expiry Month",row);
		String ExpYear = TestData.getCellData(sheetName,"Expiry Year",row);
		String CVVNbr = TestData.getCellData(sheetName,"CVV",row);
		String CCName = TestData.getCellData(sheetName,"CardHolderName",row);
		String CheckNO = TestData.getCellData(sheetName,"ChkgAcctNbr_lastfour",row);
		String firstName = TestData.getCellData(sheetName,"FirstName",row);
		String lasstName = TestData.getCellData(sheetName,"LastName",row);
		String addres = TestData.getCellData(sheetName,"AddressLine",row);
		String zip = TestData.getCellData(sheetName,"ZipCode",row);
		//String CheckNO = TestData.getCellData(sheetName,"ChkgAcctNbr_lastfour",row);
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO,"Payment started");
		driver.findElement(By.xpath("//*[@id='cur']")).click();
		test.log(LogStatus.PASS,"clicked on current loans button");
		//*[@id="makePay"]
		driver.findElement(By.id("makePay")).click();
		test.log(LogStatus.PASS,"clicked on make payments button");
		Thread.sleep(1000);
		Robot rb =new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='isCustInClearencePeriod_pmt']/div/div/div[2]/div[2]/div[1]/button")).click();
		test.log(LogStatus.PASS,"clicked on continue button");
		Thread.sleep(6000);
		if(PaymentType.equalsIgnoreCase("Scheduled Payment Amount")){
			
			//driver.findElement(By.id("instAmtRad")).click();
			driver.findElement(By.xpath("//*[@id='instAmtRad']")).click();
			test.log(LogStatus.PASS, "Clicked on Scheduled Payment Amount check box ");
			
			/*driver.findElement(By.name("requestBean.siilBean.payAmt")).sendKeys(PaymentAmount);
			test.log(LogStatus.PASS, "PaymentAmount entered :"+PaymentAmount);*/
			driver.findElement(By.name("paymentType")).sendKeys(TenderType);//Debit Card
			test.log(LogStatus.PASS, "Payment Type selected as :"+TenderType);
			
			driver.findElement(By.name("fName")).sendKeys(firstName);
			test.log(LogStatus.PASS, "Firstname entered as :"+firstName);
			driver.findElement(By.name("lName")).sendKeys(lasstName);
			test.log(LogStatus.PASS, "lasstName entered as :"+lasstName);
			driver.findElement(By.name("cardNumber")).sendKeys(CardNbr);
			test.log(LogStatus.PASS, "CardNbr entered as :"+CardNbr);
			driver.findElement(By.name("addres")).sendKeys(addres);
			test.log(LogStatus.PASS, "addres entered as :"+addres);
			driver.findElement(By.name("zip")).sendKeys(zip);
			test.log(LogStatus.PASS, "zip entered as :"+zip);
			//driver.findElement(By.name("rCardType")).sendKeys(CardType);
			test.log(LogStatus.PASS, "CardType entered as :"+CardType);
			driver.findElement(By.name("cvvNumber")).sendKeys(CVVNbr);
			test.log(LogStatus.PASS, "CVVNbr entered as :"+CVVNbr);
			driver.findElement(By.name("rExpiresMonth")).sendKeys(ExpMonth);
			test.log(LogStatus.PASS, "ExpMonth entered as :"+ExpMonth);
			driver.findElement(By.name("rExpiresYear")).sendKeys(ExpYear);
			test.log(LogStatus.PASS, "ExpYear entered as :"+ExpYear);
			driver.findElement(By.xpath("//*[@id='continueBtn']")).click();
			test.log(LogStatus.PASS, "clicked on submit button :");
			Thread.sleep(40000);
			}
			else if(PaymentType.equalsIgnoreCase("Pay Off the balance")){
				driver.findElement(By.id("payOffAmtRad")).click();
				test.log(LogStatus.PASS, "Clicked on pay off amount check box ");
				driver.findElement(By.name("paymentType")).sendKeys(TenderType);//Debit Card
				test.log(LogStatus.PASS, "Payment Type selected as :"+TenderType);
				
				driver.findElement(By.name("fName")).sendKeys(firstName);
				test.log(LogStatus.PASS, "Firstname entered as :"+firstName);
				driver.findElement(By.name("lName")).sendKeys(lasstName);
				test.log(LogStatus.PASS, "lasstName entered as :"+lasstName);
				driver.findElement(By.name("cardNumber")).sendKeys(CardNbr);
				test.log(LogStatus.PASS, "CardNbr entered as :"+CardNbr);
				driver.findElement(By.name("addres")).sendKeys(addres);
				test.log(LogStatus.PASS, "addres entered as :"+addres);
				driver.findElement(By.name("zip")).sendKeys(zip);
				test.log(LogStatus.PASS, "zip entered as :"+zip);
				//driver.findElement(By.name("rCardType")).sendKeys(CardType);
				test.log(LogStatus.PASS, "CardType entered as :"+CardType);
				driver.findElement(By.name("cvvNumber")).sendKeys(CVVNbr);
				test.log(LogStatus.PASS, "CVVNbr entered as :"+CVVNbr);
				driver.findElement(By.name("rExpiresMonth")).sendKeys(ExpMonth);
				test.log(LogStatus.PASS, "ExpMonth entered as :"+ExpMonth);
				driver.findElement(By.name("rExpiresYear")).sendKeys(ExpYear);
				test.log(LogStatus.PASS, "ExpYear entered as :"+ExpYear);
				driver.findElement(By.xpath("//*[@id='continueBtn']")).click();
				test.log(LogStatus.PASS, "clicked on submit button :");
				Thread.sleep(40000);
			}
			else if(PaymentType.equalsIgnoreCase("Maximum amount")){
				driver.findElement(By.id("maxAmtDefWORad")).click();
				test.log(LogStatus.PASS, "Clicked on Maximum amount check box ");
				driver.findElement(By.name("paymentType")).sendKeys(TenderType);//Debit Card
				test.log(LogStatus.PASS, "Payment Type selected as :"+TenderType);
				
				driver.findElement(By.name("fName")).sendKeys(firstName);
				test.log(LogStatus.PASS, "Firstname entered as :"+firstName);
				driver.findElement(By.name("lName")).sendKeys(lasstName);
				test.log(LogStatus.PASS, "lasstName entered as :"+lasstName);
				driver.findElement(By.name("cardNumber")).sendKeys(CardNbr);
				test.log(LogStatus.PASS, "CardNbr entered as :"+CardNbr);
				driver.findElement(By.name("addres")).sendKeys(addres);
				test.log(LogStatus.PASS, "addres entered as :"+addres);
				driver.findElement(By.name("zip")).sendKeys(zip);
				test.log(LogStatus.PASS, "zip entered as :"+zip);
				//driver.findElement(By.name("rCardType")).sendKeys(CardType);
				test.log(LogStatus.PASS, "CardType entered as :"+CardType);
				driver.findElement(By.name("cvvNumber")).sendKeys(CVVNbr);
				test.log(LogStatus.PASS, "CVVNbr entered as :"+CVVNbr);
				driver.findElement(By.name("rExpiresMonth")).sendKeys(ExpMonth);
				test.log(LogStatus.PASS, "ExpMonth entered as :"+ExpMonth);
				driver.findElement(By.name("rExpiresYear")).sendKeys(ExpYear);
				test.log(LogStatus.PASS, "ExpYear entered as :"+ExpYear);
				driver.findElement(By.xpath("//*[@id='continueBtn']")).click();
				test.log(LogStatus.PASS, "clicked on submit button :");
				Thread.sleep(40000);
			}
		if(driver.findElement(By.xpath("//*[@id='submit']/div[1]/h3/strong")).isDisplayed())
		{
			String Successmessage=driver.findElement(By.xpath("//*[@id='submit']/div[1]/h3/strong")).getText();
			test.log(LogStatus.PASS, "message displayed as :"+ Successmessage);
		}
		else
			test.log(LogStatus.FAIL, "Payment through online failed :");
}
	}
		}
	}

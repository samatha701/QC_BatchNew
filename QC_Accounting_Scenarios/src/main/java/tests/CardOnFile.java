package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class CardOnFile extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	public static String ESign_Password;
	public static String ESign_Checks;
	public static String CouponNbr;
	public static String ChkgAcctNbr;
	public static String AllowPromotion;
	public static String ESign_Preference;
	public static String ESign_CourtesyCallConsent;
	public static String ESign_DisbType;
	public static String ESign_LoanAmt;
	public static Object stateProductType;
	public static Object stateProduct;
	public static String StoreID;
	public static String NewVIN;
	public static String VehicleType;
	public static String NewLoan_Term;
	public static String NewLoan_ProductName;
	public static String ProductType;
	public static String Password;
	public static String UserName;
	public static String ProductID;
	public static CharSequence last4cheknum;
	public static String InsuranceExpiryDate0[]=null;
	public static String InsuranceExpiryDate3;
	public static String InsuranceExpiryDate2;
	public static String InsuranceExpiryDate1;
	public static String PolicyNumber;
	public static String InsuranceCompany;
	public static String PhoneNbr3;
	public static String PhoneNbr2;
	public static String PhoneNbr1;
	public static String PhoneNbr;
	public static String InsuranceCoverage;
	public static String LicensePlateExp;
	public static String LicensePlateNumber;
	public static String ExteriorColor;
	public static String AppraisalValue;
	public static String InsuranceExpiryDate;
	public static String TitleNumber;
	public static int rnum;
	public static int cnum;
	public static Object product_name;
	public static int count;
	public static List<WebElement> rows;
	public static String No_of_checks;
	public static String cardType;
	public static String cardNumber;
	public static String  cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;
	
	public static void cardOnFile(String SSN,String AppURL) throws Exception
	{

		test.log(LogStatus.INFO, "*****Performing  New Loan transaction *****");
		int lastrow=TestData.getLastRow("CardOnFile");
		String sheetName="CardOnFile";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			State= TestData.getCellData(sheetName,"StateID",row);
			ProductID=TestData.getCellData(sheetName,"ProductID",row);
			encryption_store_no = TestData.getCellData(sheetName,"StoreID",row);
			cardType = TestData.getCellData(sheetName, "Card Type ", row);
			cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
			cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
			cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
			cvv = TestData.getCellData(sheetName, "CVV", row);
			CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);

			if(SSN.equals(RegSSN))
			{		
				
				test.log(LogStatus.INFO, "Card On File Process has initiated");
				driver.switchTo().defaultContent();	
				driver.switchTo().frame("topFrame");
				driver.findElement(By.partialLinkText("Transactions")).click();
				test.log(LogStatus.PASS, "Clicked on Transactions");
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
			    
				 Actions action = new Actions(driver);  
				 WebElement Debitcard=driver.findElement(By.id("988190800"));
				 action.moveToElement(Debitcard).build().perform();
				 test.log(LogStatus.PASS, " Mouse hover on Debitcards menu");
				 Thread.sleep(2000);
				/*WebElement ILP = driver.findElement (By.xpath("//*[@id='503030']"));*/
				 if(ProductID.equalsIgnoreCase("PDL"))
				 {
				 WebElement PDL=driver.findElement(By.id("988190836"));
				 action.moveToElement(PDL).build().perform();
				 test.log(LogStatus.PASS, " Mouse hover on Payday loan menu");
				 Thread.sleep(3000);
				 }
				 else if(ProductID.equalsIgnoreCase("ILP"))
			     {
					 WebElement ILP=driver.findElement(By.id("988190835"));
					 action.moveToElement(ILP).build().perform();
					 test.log(LogStatus.PASS, " Mouse hover on Installment loan menu");
					 Thread.sleep(3000);
			     }
				 else if(ProductID.equalsIgnoreCase("TLP"))
				 {
					 WebElement TLP=driver.findElement(By.id("9881908052"));
					 action.moveToElement(TLP).build().perform();
					 test.log(LogStatus.PASS, " Mouse hover on Title loan menu");
					 Thread.sleep(3000);
				 }
				// driver.findElement(locator(Aprop.getProperty("admin_ACH_processing"))).click();
				 driver.findElement(By.linkText("Debit Card On File")).click();
				 test.log(LogStatus.PASS, " Debit Card On File");
				 Thread.sleep(3000);
			     
			     driver.switchTo().defaultContent();
				 driver.switchTo().frame("mainFrame");
				 driver.switchTo().frame("main");
				 driver.findElement(By.name("submit")).click();
				 test.log(LogStatus.PASS, " clicked on submit button");
				 driver.findElement(By.xpath("//input[@value='GO']")).click();
				 test.log(LogStatus.PASS, " clicked on GO button");
				 Thread.sleep(2000);
				 WebElement w=driver.findElement(By.name("cardNmbr"));
				 Select s=new Select(w);
				 s.selectByIndex(1);
				 test.log(LogStatus.PASS, " Debit card selected");
				 driver.findElement(By.id("ccnumber")).sendKeys(cardNumber);
				 test.log(LogStatus.PASS, "New card number entered as"+cardNumber);
				 driver.findElement(By.name("cardType")).sendKeys(cardType);
				 test.log(LogStatus.PASS, "New card Type entered as"+cardType);
				 driver.findElement(By.name("expmonth")).sendKeys(cardEx_month);
				 test.log(LogStatus.PASS, "New card Type entered as"+cardEx_month);
				 driver.findElement(By.name("expyear")).sendKeys(cardEx_Year);
				 test.log(LogStatus.PASS, "New card Type entered as"+cardEx_Year);
				 driver.findElement(By.name("cvvnumber")).sendKeys(cvv);
				 test.log(LogStatus.PASS, "New card Type entered as"+cvv);
				 driver.findElement(By.name("ccname")).sendKeys(CardHolderName);
				 test.log(LogStatus.PASS, "New card Type entered as"+CardHolderName);
				 driver.findElement(By.xpath("//input[@value='Add Card']")).click();
				 test.log(LogStatus.PASS, "clicked on add card button");
				 Thread.sleep(10000);
				 try{
				 encryption_transaction_nbr = driver.findElement(By.name("requestBean.origTranNbr")).getAttribute("value");
				 test.log(LogStatus.PASS, " getting tran number"+encryption_transaction_nbr);
				 
				 AdminLoginForEncryption.getEncryption( driver, SSN, AppURL);
				 Thread.sleep(2000);
				 
				 driver.findElement(By.name("requestBean.encryptionKey")).sendKeys(Eankey);
				 test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
				 Thread.sleep(5000);
				 }
				 catch(Exception e){
				 }
				 
				 driver.findElement(By.xpath("//input[@value='submit']")).click();
				 test.log(LogStatus.PASS, " clicked on submit button");
				 Thread.sleep(1000);
			}
		}
	}
}

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
	
	public static void newLoan(String SSN,String AppURL) throws Exception
	{

		test.log(LogStatus.INFO, "*****Performing  New Loan transaction *****");
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{		
				 State= TestData.getCellData(sheetName,"StateID",row);
				ProductID=TestData.getCellData(sheetName,"ProductID",row);
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
				 WebElement Debitcard=driver.findElement(By.id("988190800"));
				 action.moveToElement(Debitcard).build().perform();
				 test.log(LogStatus.PASS, " Mouse hover on Debitcards menu");
				 Thread.sleep(2000);
				/*WebElement ILP = driver.findElement (By.xpath("//*[@id='503030']"));*/
				 WebElement PDL=driver.findElement(By.id("988190836"));
				 action.moveToElement(PDL).build().perform();
				 test.log(LogStatus.PASS, " Mouse hover on Payday loan menu");
				 Thread.sleep(3000);
				// driver.findElement(locator(Aprop.getProperty("admin_ACH_processing"))).click();
				 driver.findElement(By.linkText("Debit Card On File")).click();
				 test.log(LogStatus.PASS, " Debit Card On File");
				 Thread.sleep(3000);
				 driver.findElement(By.name("submit")).click();
				 test.log(LogStatus.PASS, " clicked on submit button");
				 driver.findElement(By.xpath("//input[@value='GO']")).click();
				 test.log(LogStatus.PASS, " clicked on GO button");
				 Thread.sleep(2000);
				 WebElement w=driver.findElement(By.name("cardNmbr"));
				 Select s=new Select(w);
				 s.selectByIndex(2);
				 test.log(LogStatus.PASS, " Debit card selected");
				 driver.findElement(By.name("requestBean.origTranNbr")).getText();
				 test.log(LogStatus.PASS, " getting tran number");
				 
				 //AdminLoginForEncryption.getEncryption( driver, SSN, AppURL);
				 Thread.sleep(2000);
			}
		}
	}
}

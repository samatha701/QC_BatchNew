package tests;

import static tests.AQCAgeStoreDueDate.ageStoreDueDate;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//This  is an executable class file.(Execution starts from here)
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCStore {

	public static WebDriverWait wait;
	public static WebDriver driver;
	public static WebDriver driver1;
	String appUrl;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());

	public static Properties prop;
	public static Properties Jprop;
	public static Properties Rprop;
	public static Properties Aprop;
	public static Properties Vprop;
	public static String loan_number;
	public static ExtentReports reports;
	public static ExtentReports Breports;
	public static ExtentReports Jreports;
	public static ExtentReports Rreports;
	public static ExtentReports Areports;
	public static ExtentTest test;
	
	public static String Eankey = null;
	public static String encryption_store_no = null;
	public static String encryption_transaction_nbr = null;
	public static String FileName;
	public static ExcelNew TestData;

	public static String loan_nbr;
	public static String NextDueDate;
	//public static String NextDueDate= "04/03/2019";
	public static String AppURL = "https://qclocalreg.qfund.net/cc/demoIndex.do";
	public static String business_date;
	public static String No_of_Installments;
	public static String transaction_date;

	public static String ESign_CheckNbr;
	public static String Password;
	public static String ESign_CollateralType;
	public static String ESign_DisbType;
	public static String ESign_CourtesyCallConsent;
	public static String AllowPromotion;
	public static String ESign_Preference;
	public static String No_of_checks;
	public static String ESign_Password;
	public static String appdate;
	public static String Date1;
	public static String Date2;
	public static String Date3;
	public static String customer_number;
	public static String Drawer_OverShort_Amount;
	public static String Due_Date1;
	public static String Due_Date2;
	public static String Due_Date3;
	public static String passwrd;
	public static String FirstName;
	public static String AdminURL;
	public static String csr_url;
	public static String csrloginpage;
	public static String NatchaFilename;
	//public static String args;
	public static int Gross;
	public static double PTIamt;
	public static double paymentAmount2_Int;
	public static int paymentAmount2_Int2;
	public static double paymentAmount1_Int;
	public static int paymentAmount1_Int1;
	public static int PTIamt2;
	public static double sumofInterest;
		
	public static String loanamtinNegscreen;
	public static double reqloanAmountInt;
	public static double loanamtinNegscreenInt;
	
	//NewLoan values
	public static String reqloanAmount;
	public static String InterestRateInNewLoan;
	public static String FrequencyInNewLoan;
	public static String NoofInstallmentsInNewLoan;
	public static String APRInNewLoan;
	public static String InstallmentAmountInNewLoan;
	public static String InstallmentDate1InNewLoan;
	public static String InstallmentDate2InNewLoan;
	public static String InstallmentDate3InNewLoan;
	public static String a;
	public static String cardType;
	public static String cardNumber;
	public static String cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;
	public static String NewLoan_Term;
	public static String paymentdate1;
	public static String paymentdate2;
	public static String Biw_NoofWeeks;
	public static String Biw_NoofMonths;
	public static String Wek_NoofMonths;
	public static String Wek_NoofWeeks;
	public static int Biw_NoofMonthsInt;
	public static int Biw_NoofWeeksInt;
	public static int Wek_NoofMonthsInt;
	public static int Wek_StringNoofWeeksInt;
	public static String Income_PayFrequency;
	public static int CalMonthlyIncome;
	public static String Income_GrossIncome;

	//================================  Shashidhar ERM Scenarios  ====================================================


     @Test(priority = 1, enabled = true,groups = "ERM1")
     public static void QC_DCDeposit_Txn() throws Exception {
			
				test = reports.startTest(("QC_DCDeposit_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Duedate-->DCDeposit");
				FileName = "QC_DCDeposit_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
					}	
 
   	
     
    // @Test(priority = 2, enabled = true,groups = "ERM")
     public static void QC_DC_PPayDeposit_Txn() throws Exception {
			
				test = reports.startTest(("QC_DC_PPayDeposit_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan--> 3 days age -->Payment $9 Age to Duedate-->DCDeposit");
				FileName = "QC_DC_PPayDeposit_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRGraceDaysAge.agerescind(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						ILP_Payment.payment(SSN,AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
					}	
     
     
     ////@Test(priority = 3, enabled = true,groups = "ERM")
     public static void QC_DC_InstaPayDeposit_Txn() throws Exception {
			
				test = reports.startTest(("QC_DC_InstaPayDeposit_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->3 days age -->Pay Installment Amount-->Age to 2Insta Duedate-->-->DCDeposit");
				FileName = "QC_DC_InstaPayDeposit_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRGraceDaysAge.agerescind(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						ILP_Payment.payment(SSN,AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
					}	
     @Test(priority = 4, enabled = true,groups = "ERM1")
     public static void QC_DC_PayOff_Deposit_Txn() throws Exception {
			
				test = reports.startTest(("QC_DC_PayOff_Deposit_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->3 days age -->Pay-Off The Amount-2.02-->Age to last Insta Duedate-->-->DCDeposit");
				FileName = "QC_DC_PayOff_Deposit_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRGraceDaysAge.agerescind(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						ILP_Payment.payment(SSN,AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
					}
     
     @Test(priority = 5, enabled = true,groups = "ERM1")
     public static void QC_DCDeposit_Return_Txn() throws Exception {
			
				test = reports.startTest(("QC_DCDeposit_Return_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Duedate-->DCDeposit-->DCReturn");
				FileName = "QC_DCDeposit_Return_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						try{
						DBReturn.proc();
						}
						catch(Exception e){
							test.log(LogStatus.FAIL, "Failed due to SCH_Attr/RepayDeposit schedules are mis matched/Not working");
						}
						Thread.sleep(2000);
						ReturnPosting.returnPosting(SSN, AppURL);
						ACSRLoginLogout.logout();
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
					}	
  
     @Test(priority = 6, enabled = true,groups = "ERM")
     public static void QC_DCRedeposit_Txn() throws Exception {
			
				test = reports.startTest(("QC_DCRedeposit_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Duedate-->DCDeposit-->DCReturn-->Redepost(Representment Now)");
				FileName = "QC_DCRedeposit_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						try{
						DBReturn.proc();
						}
						catch(Exception e){
							test.log(LogStatus.FAIL, "Failed due to SCH_Attr/RepayDeposit schedules are mis matched/Not working");
						}
						Thread.sleep(3000);
						ReturnPosting.returnPosting(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						try{
							DBReturn.redepositDC(SSN);
							}
							catch(Exception e){
								test.log(LogStatus.FAIL, "Failed due to RepayDeposit schedule CC_info _key mis matched/Not working");
							}
						Thread.sleep(1000);
						AQC_Redeposit.redepositDC(SSN, AppURL);
						ACSRLoginLogout.logout();
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
					}	

     @Test(priority = 7, enabled = true,groups = "ERM")
     public static void QC_DCInst2Redeposit_Txn() throws Exception {
			
				test = reports.startTest(("QC_DCInst2Redeposit_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Duedate-->DCDeposit-->DCReturn-->Age to 2#InstDuedate-->DCDeposit-->DCReturn-->Redepost(Representment Now)");
				FileName = "QC_DCInst2Redeposit_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						try{
						DBReturn.proc();
						}
						catch(Exception e){
							test.log(LogStatus.FAIL, "Failed due to SCH_Attr/RepayDeposit schedules are mis matched/Not working");
						}
						Thread.sleep(1000);
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRGraceDaysAge.agerescind(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						ReturnPosting.returnPosting(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						try{
						DBReturn.proc();
						}
						catch(Exception e){
							test.log(LogStatus.FAIL, "Failed due to SCH_Attr/RepayDeposit schedules are mis matched/Not working");
						}
						Thread.sleep(3000);
						ACSRLoginLogout.login(SSN, AppURL);
						ReturnPosting.returnPosting(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						try{
							DBReturn.redepositDC(SSN);
							}
							catch(Exception e){
								test.log(LogStatus.FAIL, "Failed due to RepayDeposit schedule CC_info _key mis matched/Not working");
							}
						Thread.sleep(1000);
						AQC_Redeposit.redepositDC(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
					}	
    
     @Test(priority = 8, enabled = true,groups = "ERM")
     public static void QC_DCDeposit_EOD_Return_Txn() throws Exception {
			
				test = reports.startTest(("QC_DCDeposit_EOD_Return_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Duedate-->DCDeposit-->EOD-->DCReturn-->Verify ERM");
				FileName = "QC_DCDeposit_EOD_Return_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCSafeAssign.safeAssign(SSN, AppURL);
						AQCDrawerAssign.drawerAssign(SSN, AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						try{
						DBReturn.proc();
						}
						catch(Exception e){
							test.log(LogStatus.FAIL, "Failed due to SCH_Attr/RepayDeposit schedules are mis matched/Not working");
						}
						Thread.sleep(3000);
						ReturnPosting.returnPosting(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						try{
							DBReturn.redepositDC(SSN);
							}
							catch(Exception e){
								test.log(LogStatus.FAIL, "Failed due to RepayDeposit schedule CC_info _key mis matched/Not working");
							}
						Thread.sleep(1000);
						AQC_Redeposit.redepositDC(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
					}	
     
     @Test(priority = 9, enabled = true,groups = "ERM")
     public static void QC_DCDeposit_Return_EOD_Txn() throws Exception {
			
				test = reports.startTest(("QC_DCDeposit_Return_EOD_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Duedate-->DCDeposit-->DCReturn-->EOD-->Verify ERM");
				FileName = "QC_DCDeposit_Return_EOD_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						try{
						DBReturn.proc();
						}
						catch(Exception e){
							test.log(LogStatus.FAIL, "Failed due to SCH_Attr/RepayDeposit schedules are mis matched/Not working");
						}
						Thread.sleep(3000);
						ReturnPosting.returnPosting(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCSafeAssign.safeAssign(SSN, AppURL);
						AQCDrawerAssign.drawerAssign(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						try{
							DBReturn.redepositDC(SSN);
							}
							catch(Exception e){
								test.log(LogStatus.FAIL, "Failed due to RepayDeposit schedule CC_info _key mis matched/Not working");
							}
						Thread.sleep(1000);
						AQC_Redeposit.redepositDC(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
					}	
   
     @Test(priority = 10, enabled = true,groups = "ERM")    
     public static void QC_DCDeposit_EOD_2InstaReturn_Txn() throws Exception {
			
				test = reports.startTest(("QC_DCDeposit_EOD_2InstaReturn_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Due date->DC Deposit->EOD->DC Return->Age to 2nd Installment due date->DC Deposit->EOD->DC Return->verify in ERM screen");
				FileName = "QC_DCDeposit_EOD_2InstaReturn_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCSafeAssign.safeAssign(SSN, AppURL);
						AQCDrawerAssign.drawerAssign(SSN, AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						try{
						DBReturn.proc();
						}
						catch(Exception e){
							test.log(LogStatus.FAIL, "Failed due to SCH_Attr/RepayDeposit schedules are mis matched/Not working");
						}
						Thread.sleep(3000);
						ReturnPosting.returnPosting(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCSafeAssign.safeAssign(SSN, AppURL);
						AQCDrawerAssign.drawerAssign(SSN, AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						try{
						DBReturn.proc();
						}
						catch(Exception e){
							test.log(LogStatus.FAIL, "Failed due to SCH_Attr/RepayDeposit schedules are mis matched/Not working");
						}
						Thread.sleep(3000);
						ReturnPosting.returnPosting(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						try{
							DBReturn.redepositDC(SSN);
							}
							catch(Exception e){
								test.log(LogStatus.FAIL, "Failed due to RepayDeposit schedule CC_info _key mis matched/Not working");
							}
						Thread.sleep(1000);
						AQC_Redeposit.redepositDC(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
					}	
     
     @Test(priority = 11, enabled = true,groups = "ERM1")
     public static void QC_DCDeposit_2InstaRtnEOD_Txn() throws Exception {
			
				test = reports.startTest(("QC_DCDeposit_2InstaRtnEOD_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Due date->DC Deposit->DC Return->EOD->Age to 2nd Insttalment due date->DC Deposit->DC Return->EOD->verify in ERM screen");
				FileName = "QC_DCDeposit_2InstaRtnEOD_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						/*ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						try{
						DBReturn.proc();
						}
						catch(Exception e){
							test.log(LogStatus.FAIL, "Failed due to SCH_Attr/RepayDeposit schedules are mis matched/Not working");
						}
						Thread.sleep(3000);
						ReturnPosting.returnPosting(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCSafeAssign.safeAssign(SSN, AppURL);
						AQCDrawerAssign.drawerAssign(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						try{
						DBReturn.proc();
						}
						catch(Exception e){
							test.log(LogStatus.FAIL, "Failed due to SCH_Attr/RepayDeposit schedules are mis matched/Not working");
						}
						Thread.sleep(3000);
						ReturnPosting.returnPosting(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCSafeAssign.safeAssign(SSN, AppURL);
						AQCDrawerAssign.drawerAssign(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						try{
							DBReturn.redepositDC(SSN);
							}
							catch(Exception e){
								test.log(LogStatus.FAIL, "Failed due to RepayDeposit schedule CC_info _key mis matched/Not working");
							}
						Thread.sleep(1000);
						AQC_Redeposit.redepositDC(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
					}	
     @Test(priority = 12, enabled = true,groups = "ERMACH")
     public static void QC_ACHDeposit_Txn() throws Exception {
			
				test = reports.startTest(("QC_ACHDeposit_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Duedate-->ACHDeposit");
				FileName = "QC_ACHDeposit_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
		}
     @Test(priority = 13, enabled = true,groups = "ERMACH")
     public static void QC_ACH_PPayDeposit_Txn() throws Exception {
			
				test = reports.startTest(("QC_ACH_PPayDeposit_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan--> 3 days age -->Payment $9 Age to Duedate-->ACHDeposit");
				FileName = "QC_ACH_PPayDeposit_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRGraceDaysAge.agerescind(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						ILP_Payment.payment(SSN,AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
		}	
     
    @Test(priority = 14, enabled = true,groups = "ERMACH")
     public static void QC_ACH_InstaPayDeposit_Txn() throws Exception {
			
				test = reports.startTest(("QC_ACH_InstaPayDeposit_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->3 days age -->Pay Installment Amount-->Age to 2Insta Duedate-->-->ACHDeposit");
				FileName = "QC_ACH_InstaPayDeposit_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRGraceDaysAge.agerescind(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						ILP_Payment.payment(SSN,AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
		}	
     @Test(priority = 15, enabled = true,groups = "ERMACH")
     public static void QC_ACH_PayOff_Deposit_Txn() throws Exception {
			
				test = reports.startTest(("QC_ACH_PayOff_Deposit_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->3 days age -->Pay-Off The Amount-2.02-->Age to last Insta Duedate-->-->ACHDeposit");
				FileName = "QC_ACH_PayOff_Deposit_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRGraceDaysAge.agerescind(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						ILP_Payment.payment(SSN,AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
		}
     @Test(priority = 16, enabled = true,groups = "ERMACH")
     public static void QC_ACHDeposit_Return_Txn() throws Exception {
			
				test = reports.startTest(("QC_ACHDeposit_Return_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Duedate-->ACHDeposit-->Return");
				FileName = "QC_ACHDeposit_Return_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						AQCAdminLoginLogout.login(SSN,AppURL);
						AQCACHProcessing.ACHProcess(SSN, NextDueDate);
						//AQCAdminLoginLogout.login(SSN,AppURL);
						AQCDownloadNACHA.ACHProcess(SSN);
						AQCDownloadNACHA.ACHReturnProcess_UploadFile();
						AQCAdminLoginLogout.logout(SSN, AppURL);
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
		}
     @Test(priority = 17, enabled = true,groups = "ERMACH")
     public static void QC_ACHRedeposit_Txn() throws Exception {
			
				test = reports.startTest(("QC_ACHRedeposit_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Duedate-->ACHDeposit-->ACHReturn-->Redepost(Representment Now)");
				FileName = "QC_ACHRedeposit_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						AQCAdminLoginLogout.login(SSN,AppURL);
						AQCACHProcessing.ACHProcess(SSN, NextDueDate);
						AQCAdminLoginLogout.login(SSN,AppURL);
						AQCDownloadNACHA.ACHProcess(SSN);
						AQCDownloadNACHA.ACHReturnProcess_UploadFile();
						AQCAdminLoginLogout.logout(SSN, AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ILP_Redeposit.redeposit(SSN, AppURL);
						ACSRLoginLogout.logout();
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
	}	
     //@Test(priority = 18, enabled = true,groups = "ERMACH")
     public static void QC_ACHInst2Redeposit_Txn() throws Exception {
			
				test = reports.startTest(("QC_ACHInst2Redeposit_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Duedate-->ACHDeposit-->ACHReturn-->Age to 2#InstDuedate-->ACHDeposit-->ACHReturn-->Redepost(Representment Now)");
				FileName = "QC_ACHInst2Redeposit_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						AQCAdminLoginLogout.login(SSN,AppURL);
						AQCACHProcessing.ACHProcess(SSN, NextDueDate);
						AQCDownloadNACHA.ACHProcess(SSN);
						AQCDownloadNACHA.ACHReturnProcess_UploadFile();
						AQCAdminLoginLogout.logout(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRGraceDaysAge.age1day(SSN,AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						AQCAdminLoginLogout.login(SSN,AppURL);
						AQCACHProcessing.ACHProcess(SSN, NextDueDate);
						AQCDownloadNACHA.ACHProcess(SSN);
						AQCDownloadNACHA.ACHReturnProcess_UploadFile();
						AQCAdminLoginLogout.logout(SSN, AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ILP_Redeposit.redeposit(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
	 }	
     @Test(priority = 19, enabled = true,groups = "ERMACHa1")
     public static void QC_ACHDeposit_EOD_Return_Txn() throws Exception {
			
				test = reports.startTest(("QC_ACHDeposit_EOD_Return_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Duedate-->ACHDeposit-->EOD-->ACHReturn-->Verify ERM");
				FileName = "QC_ACHDeposit_EOD_Return_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCSafeAssign.safeAssign(SSN, AppURL);
						AQCDrawerAssign.drawerAssign(SSN, AppURL);
						
						AQCAdminLoginLogout.login(SSN,AppURL);
						AQCACHProcessing.ACHProcess(SSN, NextDueDate);
						AQCDownloadNACHA.ACHProcess(SSN);
						AQCDownloadNACHA.ACHReturnProcess_UploadFile();
						AQCAdminLoginLogout.logout(SSN, AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ILP_Redeposit.redeposit(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
	}	
     @Test(priority = 20, enabled = true,groups = "ERMACHa")                            //not executed
     public static void QC_ACHDeposit_Return_EOD_Txn() throws Exception {
			
				test = reports.startTest(("QC_ACHDeposit_Return_EOD_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Duedate-->ACHDeposit-->ACHReturn-->EOD-->Verify ERM");
				FileName = "QC_ACHDeposit_Return_EOD_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						AQCAdminLoginLogout.login(SSN,AppURL);
						AQCACHProcessing.ACHProcess(SSN, NextDueDate);
						AQCDownloadNACHA.ACHProcess(SSN);
						AQCDownloadNACHA.ACHReturnProcess_UploadFile();
						AQCAdminLoginLogout.logout(SSN, AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCSafeAssign.safeAssign(SSN, AppURL);
						AQCDrawerAssign.drawerAssign(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ILP_Redeposit.redeposit(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
	}	
     @Test(priority = 21, enabled = true,groups = "ERMACHa")
     public static void QC_ACHDeposit_EOD_2InstaReturn_Txn() throws Exception {
			
				test = reports.startTest(("QC_ACHDeposit_EOD_2InstaReturn_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Due date->ACH Deposit->EOD->ACH Return->Age to 2nd Installment due date->ACH Deposit->EOD->ACH Return->verify in ERM screen");
				FileName = "QC_ACHDeposit_EOD_2InstaReturn_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCSafeAssign.safeAssign(SSN, AppURL);
						AQCDrawerAssign.drawerAssign(SSN, AppURL);
						
						AQCAdminLoginLogout.login(SSN,AppURL);
						AQCACHProcessing.ACHProcess(SSN, NextDueDate);
						AQCDownloadNACHA.ACHProcess(SSN);
						AQCDownloadNACHA.ACHReturnProcess_UploadFile();
						AQCAdminLoginLogout.logout(SSN, AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRGraceDaysAge.age1day(SSN,AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCSafeAssign.safeAssign(SSN, AppURL);
						AQCDrawerAssign.drawerAssign(SSN, AppURL);
						
						AQCAdminLoginLogout.login(SSN,AppURL);
						AQCACHProcessing.ACHProcess(SSN, NextDueDate);
						AQCDownloadNACHA.ACHProcess(SSN);
						AQCDownloadNACHA.ACHReturnProcess_UploadFile();
						AQCAdminLoginLogout.logout(SSN, AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ILP_Redeposit.redeposit(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
	}	
     @Test(priority = 22, enabled = true,groups = "ERMACHa")
     public static void QC_ACHDeposit_2InstaRtnEOD_Txn() throws Exception {
			
				test = reports.startTest(("QC_ACHDeposit_2InstaRtnEOD_Txn"),
						
			    "CSR Login->Borrower Registration-->NewLoan-->Age to Due date->ACH Deposit->ACH Return->EOD->Age to 2nd Insttalment due date->ACH Deposit->ACH Return->EOD->verify in ERM screen");
				FileName = "QC_ACHDeposit_2InstaRtnEOD_Txn.xls";	                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						System.out.println(AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						AQCAdminLoginLogout.login(SSN,AppURL);
						AQCACHProcessing.ACHProcess(SSN, NextDueDate);
						AQCDownloadNACHA.ACHProcess(SSN);
						AQCDownloadNACHA.ACHReturnProcess_UploadFile();
						AQCAdminLoginLogout.logout(SSN, AppURL);
						
						
						ACSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCSafeAssign.safeAssign(SSN, AppURL);
						AQCDrawerAssign.drawerAssign(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCDepositDropdown.depositDropDown(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						AQCAdminLoginLogout.login(SSN,AppURL);
						AQCACHProcessing.ACHProcess(SSN, NextDueDate);
						AQCDownloadNACHA.ACHProcess(SSN);
						AQCDownloadNACHA.ACHReturnProcess_UploadFile();
						AQCAdminLoginLogout.logout(SSN, AppURL);;
						ACSRLoginLogout.login(SSN, AppURL);
						
						AQCEODDeposit.eodDeposit(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						AQCSafeAssign.safeAssign(SSN, AppURL);
						AQCDrawerAssign.drawerAssign(SSN, AppURL);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ILP_Redeposit.redeposit(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						/*ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();*/
						
						

					}
				}
	}	
     
    
     
//============================================================================================================
	


	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

			BufferedReader reader;
			BufferedReader Jreader;
			BufferedReader Rreader;
			BufferedReader Areader;
			BufferedReader Vreader;

			

			try {
				Areader = new BufferedReader(

						new FileReader("C:/QC_Batch_Recon/QCH_ERM/src/test/java/tests/AObjects.properties"));

				Aprop = new Properties();
				Aprop.load(Areader);
				Areader.close();
				csr_url = Aprop.getProperty("CSR_URL");
				csrloginpage = Aprop.getProperty("Login_Page");
				AdminURL = Aprop.getProperty("ADMIN_CSR_URL");
				
				
				String Afilename = Aprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Aprop.getProperty("QC_Store_extent_report_path") + Afilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

		

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

		}

		catch (Exception e) {

			test.log(LogStatus.ERROR, "Unable to setup for the QC Store ");

		}

	}

	@BeforeMethod(alwaysRun = true)

	public void killProcess() throws Exception {

		try {

			//Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			//Thread.sleep(5000); // Allow OS to kill the process
			System.out.println("killed the process ILP scenarios");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QC_Store/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod(alwaysRun = true)

	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			 test.log(LogStatus.FAIL, "Test Case Failed is"+result.getThrowable());

			String screenshotPath = getScreenhot(driver, result.getName());
			// To add it in the extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");
		}
		reports.flush();
		driver.quit();

	}

	@AfterMethod(alwaysRun = true)

	public void endReport() {

		// reports.endTest(test);
		// reports.flush();

		// driver.quit();
		// extent.flush();

	}

	public static By locator(String obj) {

		String loctype = null;
		String locname = null;
		By locator = null;
		String[] locobj = obj.split("%%");
		loctype = locobj[0];
		locname = locobj[1];
		

		if (loctype.equalsIgnoreCase("id"))
			return locator = By.id(locname);
		else if (loctype.equalsIgnoreCase("name"))
			return locator = By.name(locname);
		else if (loctype.equalsIgnoreCase("linkText"))
			return locator = By.linkText(locname);
		else if (loctype.equalsIgnoreCase("partialLinkText"))
			return locator = By.partialLinkText(locname);
		else if (loctype.equalsIgnoreCase("xpath"))
			return locator = By.xpath(locname);
		else if (loctype.equalsIgnoreCase("cssSelector"))
			return locator = By.cssSelector(locname);
		return locator;

		// System.out.println(locator);
		// return locator;

	}

}

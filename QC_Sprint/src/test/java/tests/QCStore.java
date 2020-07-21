package tests;

import java.io.BufferedReader;
import java.io.File;
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
import org.testng.annotations.AfterMethod;
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

public class QCStore {

	public static WebDriverWait wait;
	public static WebDriver driver;
	public static WebDriver driver1;
	String appUrl;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	public static Properties prop;
	public static String loan_number;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static String Eankey = null;
	public static String encryption_store_no = null;
	public static String encryption_transaction_nbr = null;
	public static String FileName;
	public static ExcelNew TestData;
	public static String loan_nbr;
	public static String business_date;
	//public static String NextDueDate ="04/17/2019";
	public static String NextDueDate;
	public static String AppURL;
	public static String AdminURL;
	public static String transaction_date;
	public static String ESign_CheckNbr;
	public static String Password;
	public static String ESign_CollateralType;
	public static String No_of_Installments;
	public static String Date1;
	public static String Date2;
	public static String Date3;
	public static String customer_number;

	public static String FirstName;
	public static String passwrd;
	public static String report_filename;
	public static String LastName;

	public static String Due_Date1;
	public static String Due_Date2;
	public static String Due_Date3;

	public static String Str_date;
	public static String Ctc_PrimaryPhone;
	public static String Storeid;
	public static String SSN;
	public static String PP1;
	public static String PP2;
	public static String PP3;

	public static String age_Date1;
	public static String age_Date2;
	public static String age_Date3;
	public static String appdate;
	public static String day;
	public static int payment_no;
	public static String NatchaFilename;
	public static String feeAmtString;
	
	@Test(priority = 1, groups="RCQ_908")
	public static void QF_908_TS_001() throws Exception {
		test = reports.startTest("QF_908_TS_001","AdminLogin-->clicked on product config-->Product Configuration-->Select MO Multi Title-->check Interest Capping rule status");
        FileName = "QF_908_TS_001" + ".xls";
        TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
				
					QCCSRLoginLogout.adminLogin(SSN, SSN);
                    AdminCapInterest.capRule();
                    }
			}
	}
	@Test(priority = 2, groups="RCQ_908")
	public static void QF_908_TS_002() throws Exception {
		
			
		test = reports.startTest("QF_908_TS_002","Login-->Home Screen-->Borrower Registration-->New Loan");

			FileName = "QF_908_TS_002" + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					}
			}
	}
	@Test(priority = 3, groups="RCQ_908")
	public static void QF_908_TS_003() throws Exception {
		
			
		test = reports.startTest("QF_908_TS_003","Login-->Borrower Registration-->New Loan-->agestore#1 installment-->pay past due amount-->agestore to#2nd installment-->age store to#3rd installment-->paypast due+next due amount-->#4th instalment->Deposit-->Return->#5th intalment->pay interest due amt ");

			FileName = "QF_908_TS_003" + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);
					
					System.out.println(AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.age1day(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.paypastdue(SSN, AppURL);//#1 pay past due date
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.age1day(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					AgestoreDefault.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.paymentTwice(SSN, AppURL);//#3 insta Pay past due + Next installment
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN,AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.adminLogin(SSN,AppURL);
					AQCACHProcessing.ACHProcess(SSN, NextDueDate);
					AQCDownloadNACHA.ACHProcess(SSN);
					AQCDownloadNACHA.ACHReturnProcess_UploadFile();
					QCCSRLoginLogout.adminLogout(driver,SSN,AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.age1day(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					AgestoreDefault.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.paymentinterestdue(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}
	@Test(priority = 4, groups="RCQ_908")
	public static void QF_908_TS_004() throws Exception {
		
			
		test = reports.startTest("QF_908_TS_004","Login-->Borrower Registration-->New Loan-->agestore#1 installment-->payment with instalment amt-->agestore to#2nd installment-->payment with instalment amt->age store to#3rd installment-->payment with instalment amt-->#4th instalment->payment with instalment amt->#5th intalment->payment with instalment amt->age store to #6th instalment->payoff");

			FileName = "QF_908_TS_004" + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);
					
					System.out.println(AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);//1st payment
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);//2nd payment
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);//3rd payment
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);//4th payment
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);//5th payment
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					try{
						DBverify.feeAmt();
					}
					catch(Exception e){
						 test.log(LogStatus.PASS, "unable to connect DB");
					}
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payOff(SSN, AppURL);//6th payment payoff
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
		}
	}
	@Test(priority = 5, groups="RCQ_908")
	public static void QF_908_TS_005() throws Exception {
			
			test = reports.startTest("QF_908_TS_005","Login-->Borrower Registration-->New Loan-->agestore#1 installment-->payment with instalment amt-->agestore to#2nd installment-->payment with instalment amt->age store to#3rd installment-->payment with instalment amt-->#4th instalment->payment with instalment amt->#5th intalment->payment with instalment amt->age store to #6th instalment->payoff");
            FileName = "QF_908_TS_005" + ".xls";
            TestData = new ExcelNew(System.getProperty("user.dir")+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);

						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.age1day(SSN, SSN);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCPayment.paypastdue(SSN, AppURL);//#1 pay past due date
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.age1day(SSN, SSN);
						QCCSRLoginLogout.login(SSN, AppURL);
						AgestoreDefault.ageStoreDueDate(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCPayment.paymentTwice(SSN, AppURL);//#3 insta Pay past due + Next installment
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						try{
							DBverify.feeAmt();
						}
						catch(Exception e){
							 test.log(LogStatus.PASS, "unable to connect DB");
						}
						QCCSRLoginLogout.login(SSN, AppURL);
						QCPayment.payOff(SSN, AppURL);//#4th insta payoff 
						QCCSRLoginLogout.logout(SSN, AppURL);
					}
				}
		}
		@Test(priority = 7, groups="RCQ_9081")
		public static void QF_908_TS_007() throws Exception 
		{
			
			test = reports.startTest("QF_908_TS_007","Login-->Borrower Registration-->New Loan-->agestore#1 installment-->payment with instalment amt-->agestore to#2nd installment-->payment with instalment amt->age store to#3rd installment-->ACH Deposit->Return->4th instalment->ACH Deposit->Return->EOD");
            FileName = "QF_908_TS_007" + ".xls";
            TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						System.out.println(AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, AppURL);//1st payment
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, AppURL);//2nd payment
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN,AppURL);//Deposit Return
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.adminLogin(SSN,AppURL);
						AQCACHProcessing.ACHProcess(SSN, NextDueDate);
						AQCDownloadNACHA.ACHProcess(SSN);
						AQCDownloadNACHA.ACHReturnProcess_UploadFile();
						QCCSRLoginLogout.adminLogout(driver,SSN,AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.age1day(SSN, SSN);
						QCCSRLoginLogout.login(SSN, AppURL);
						AgestoreDefault.ageStoreDueDate(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN,AppURL);//Deposit Return
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.adminLogin(SSN,AppURL);
						AQCACHProcessing.ACHProcess(SSN, NextDueDate);
						//QCCSRLoginLogout.adminLogin(SSN,AppURL);
						AQCDownloadNACHA.ACHProcess(SSN);
						AQCDownloadNACHA.ACHReturnProcess_UploadFile();
						QCCSRLoginLogout.adminLogout(driver,SSN,AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
                      
						QCCSRLoginLogout.adminLogin(SSN,AppURL);
						QCAdminStoreSetup.storeSetup(SSN, SSN);
						
						QCCSRLoginLogout.login(SSN, AppURL);
					    QCSafeAssign.safeAssign(SSN, AppURL);
					   // QCCSRLoginLogout.login(SSN, AppURL);
						QCDrawerAssign.drawerAssign(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						try{
							DBverify.feeAmt();
						}
						catch(Exception e){
							 test.log(LogStatus.PASS, "unable to connect DB");
						}
						QCCSRLoginLogout.login(SSN, AppURL);
						QCPayment.defaultPayment(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
					}
				}
		}
		@Test(priority = 8, groups="RCQ_908a")
		public static void QF_908_TS_008() throws Exception 
		{
			
			test = reports.startTest("QF_908_TS_008","Login-->Borrower Registration-->New Loan-->agestore#1 installment-->payment with instalment amt-->agestore to#2nd installment-->ACH Deposit->Return->3rd instalment->ACH Deposit->Return->EOD");
            FileName = "QF_908_TS_008" + ".xls";
            TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						System.out.println(AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, AppURL);//1st payment
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN,AppURL);//Deposit Return
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.adminLogin(SSN,AppURL);
						AQCACHProcessing.ACHProcess(SSN, NextDueDate);
						AQCDownloadNACHA.ACHProcess(SSN);
						AQCDownloadNACHA.ACHReturnProcess_UploadFile();
						QCCSRLoginLogout.adminLogout(driver,SSN,AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.age1day(SSN, SSN);
						QCCSRLoginLogout.login(SSN, AppURL);
						AgestoreDefault.ageStoreDueDate(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN,AppURL);//Deposit Return
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.adminLogin(SSN,AppURL);
						AQCACHProcessing.ACHProcess(SSN, NextDueDate);
						AQCDownloadNACHA.ACHProcess(SSN);
						AQCDownloadNACHA.ACHReturnProcess_UploadFile();
						QCCSRLoginLogout.adminLogout(driver,SSN,AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
						
						QCCSRLoginLogout.adminLogin(SSN,AppURL);
						QCAdminStoreSetup.storeSetup(SSN, SSN);
						
                        QCCSRLoginLogout.login(SSN, AppURL);
					    QCSafeAssign.safeAssign(SSN, AppURL);
					   // QCCSRLoginLogout.login(SSN, AppURL);
						QCDrawerAssign.drawerAssign(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL); 
						/*try{
							DBverify.feeAmt();
						}
						catch(Exception e){
							 test.log(LogStatus.PASS, "unable to connect DB");
						}
						QCCSRLoginLogout.login(SSN, AppURL);
						QCPayment.defaultPayment(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);*/
					}
				}
		}
//========================================== Sprint2&3 Scenarios ==========================================	
		//@Test(priority = 1, groups="RCQ_ILP_6011")
		public static void QF_601_TS_025() throws Exception 
		{
			
			test = reports.startTest("QF_601_TS_025","Login TO 2997-->Borrower Registration-->New Loan-->agestore#1 installment-->payment with instalment amt-->agestore to#2nd installment-->ACH Deposit->Return->3rd instalment->ACH Deposit->Return->EOD");
            FileName = "QF_601_TS_025" + ".xls";
            TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						System.out.println(AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						 QCCSRLoginLogout.login(SSN, AppURL);
						 LoanNumber.loanNumber(SSN, SSN);
						 QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login2997(SSN, AppURL);
						QCPromiseToPay.promisetoPay(SSN,SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						try{
							DBScheduler.scheduler1025();
							Thread.sleep(4000);
						
							DBScheduler.scheduler116();
							Thread.sleep(4000);
						}
						catch(Exception e){
							test.log(LogStatus.FAIL, " unable to connect db");
						}
						
					}
				}
		}
		//@Test(priority = 2, groups="RCQ_ILP_601")
		public static void QF_601_TS_026() throws Exception 
		{
			
			test = reports.startTest("QF_601_TS_026","Login TO 2997-->Borrower Registration-->New Loan-->agestore#1 installment-->payment with instalment amt-->agestore to#2nd installment-->ACH Deposit->Return->3rd instalment->ACH Deposit->Return->EOD");
            FileName = "QF_601_TS_025" + ".xls";
            TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						System.out.println(AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login2997(SSN, AppURL);
						QCPromiseToPay.promisetoPay(SSN,SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						JQCClearDropdown.clearDropDown(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
						}
				}
		}
		//@Test(priority = 3, groups="RCQ_ILP_601")
		public static void QF_601_TS_027() throws Exception 
		{
			
			test = reports.startTest("QF_601_TS_027","Login TO csr-->Borrower Registration-->New Loan-->login to 2997-->promise to pay-->age store to payment date-->Run 1025 ACH PTP Scheduler-->Run 116 Scheduler(Nacha file creation)");
            FileName = "QF_601_TS_025" + ".xls";
            TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						System.out.println(AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login2997(SSN, AppURL);
						QCPromiseToPay.promisetoPay(SSN,SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						}
				}
		}
		@Test(priority = 10, groups="RCQ_ILP_601")
		public static void QF_601_TS_034() throws Exception 
		{
			
			test = reports.startTest("QF_601_TS_034","Login TO csr-->Borrower Registration-->New Loan-->agestore#1 installment-->payment with instalment amt-->agestore to#2nd installment-->ACH Deposit->Return->3rd instalment->ACH Deposit->Return->EOD");
            FileName = "QF_601_TS_034" + ".xls";
            TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						System.out.println(AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCILPPayment.payment(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
						//QCCSRLoginLogout.login2997(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
					    QCSafeAssign.safeAssign(SSN, AppURL);
					   // QCCSRLoginLogout.login(SSN, AppURL);
						QCDrawerAssign.drawerAssign(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL); 
					}
				}
		}
		@Test(priority = 11, groups="RCQ_ILP_601")
		public static void QF_601_TS_035() throws Exception 
		{
			
			test = reports.startTest("QF_601_TS_035","Login to csr-->Borrower Registration-->New Loan-->agestore#1 installment-->payment with instalment amt-->agestore to#2nd installment-->internal transfer->cash management->clear dropdown");
            FileName = "QF_601_TS_035" + ".xls";
            TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
                       String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						System.out.println(AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCILPPayment.payment(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						InternalTfAndCashManagement.internaltf(SSN,AppURL);
						//QCCashMgmtDeposit.cashmgmtDeposit(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						JQCClearDropdown.clearDropDown(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
						}
			}
}
       
		@Test(priority = 12, groups="RCQ_ILP_601")//-->dev completed
        public static void QF_601_TS_036() throws Exception 
		{
		test = reports.startTest("QF_601_TS_036","Login-->Borrower Registration-->New Loan-->agestore#1 installment-->payment with instalment amt-->agestore to#2nd installment-->ACH Deposit->Return->3rd instalment->ACH Deposit->Return->EOD");
		FileName = "QF_601_TS_036" + ".xls";
	   TestData = new ExcelNew(System.getProperty("user.dir")+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		                int lastrow = TestData.getLastRow("Start");
						String sheetName = "Start";
						
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							
							if (RunFlag.equals("Y")) {

								String SSN = TestData.getCellData(sheetName, "SSN", row);
								
								System.out.println(AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
		                        QCCSRLoginLogout.login(SSN, AppURL);
								QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								//QCCSRLoginLogout.login(SSN, AppURL);
								//QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
						        QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
								QCCSRLoginLogout.login(SSN, AppURL);
								QCILPPayment.payment(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								AQCEODDeposit.eodDeposit(SSN, AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
							    QCSafeAssign.safeAssign(SSN, AppURL);
							   // QCCSRLoginLogout.login(SSN, AppURL);
								QCDrawerAssign.drawerAssign(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL); 
								QCCSRLoginLogout.login(SSN, AppURL);
								QCClearMenu.clearMenu(SSN, SSN);
								QCCSRLoginLogout.logout(SSN, AppURL);
								}
					}
		}   	
      	
		   @Test(priority = 13, groups="RCQ_ILP_601")
    	  public static void QF_601_TS_037() throws Exception 
    		{
    			
    			test = reports.startTest("QF_601_TS_037","Login to csr-->Borrower Registration-->New Loan-->agestore#1 installment-->payment with instalment amt-->agestore to#2nd installment-->internal transfer->cash management->clear dropdown");
                FileName = "QF_601_TS_037" + ".xls";
                TestData = new ExcelNew(System.getProperty("user.dir")
    						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                    int lastrow = TestData.getLastRow("Start");
    				String sheetName = "Start";
    				
    				for (int row = 2; row <= lastrow; row++) {

    					String RunFlag = TestData.getCellData(sheetName, "Run", row);
    					if (RunFlag.equals("Y")) {
                           String SSN = TestData.getCellData(sheetName, "SSN", row);
    						
    						System.out.println(AppURL);
    						
    						QCCSRLoginLogout.login(SSN, AppURL);
    						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
                            QCCSRLoginLogout.login(SSN, AppURL);
    						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.login(SSN, AppURL);
    						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
    						
    						QCCSRLoginLogout.login(SSN, AppURL);
    						QCILPPayment.payment(SSN, AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.login(SSN, AppURL);
    						InternalTfAndCashManagement.internaltf(SSN,AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.adminLogin(SSN, AppURL);
    						QCClearMenu.adminClearMenu(SSN, SSN);
    						QCCSRLoginLogout.adminLogout(driver,SSN,AppURL);
    						}
    			}
    }
    	  @Test(priority = 14, groups="RCQ_ILP_601")
    	  public static void QF_601_TS_038() throws Exception 
    		{
    			
    			test = reports.startTest("QF_601_TS_038","Login to csr-->Borrower Registration-->New Loan-->agestore#1 installment-->payment with instalment amt-->agestore to#2nd installment-->internal transfer->cash management->clear dropdown");
                FileName = "QF_601_TS_038" + ".xls";
                TestData = new ExcelNew(System.getProperty("user.dir")
    						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                    int lastrow = TestData.getLastRow("Start");
    				String sheetName = "Start";
    				
    				for (int row = 2; row <= lastrow; row++) {

    					String RunFlag = TestData.getCellData(sheetName, "Run", row);
    					if (RunFlag.equals("Y")) {
                           String SSN = TestData.getCellData(sheetName, "SSN", row);
    						
    						System.out.println(AppURL);
    						
    						QCCSRLoginLogout.login(SSN, AppURL);
    						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
                            QCCSRLoginLogout.login(SSN, AppURL);
    						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.login(SSN, AppURL);
    						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
    						
    						QCCSRLoginLogout.login(SSN, AppURL);
    						QCILPPayment.payment(SSN, AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.login(SSN, AppURL);
    						InternalTfAndCashManagement.internaltf(SSN,AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						
    						}
    			}
    } 	
      	
    		@Test(priority = 15, groups="RCQ_ILP_601")
      		public static void QF_601_TS_039() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_039","Login TO csr-->Borrower Registration-->New Loan-->agestore#1 installment-->payment with instalment amt-->agestore to#2nd installment-->ACH Deposit->Return->3rd instalment->ACH Deposit->Return->EOD");
                  FileName = "QF_601_TS_039" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
                            QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCILPPayment.payment(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
      						//QCCSRLoginLogout.login2997(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCSafeAssign.safeAssign(SSN, AppURL);
      					   // QCCSRLoginLogout.login(SSN, AppURL);
      						QCDrawerAssign.drawerAssign(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL); 
      						QCCSRLoginLogout.login(SSN, AppURL);
    						JQCClearDropdown.clearDropDown(SSN, SSN);
    						QCCSRLoginLogout.logout(SSN, AppURL);
      					}
      				}
      		}

    		@Test(priority = 16, groups="RCQ_ILP_601")
      		public static void QF_601_TS_040() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_040","Login TO csr-->Borrower Registration-->New Loan-->agestore#1 installment-->payment with instalment amt-->agestore to#2nd installment-->ACH Deposit->Return->3rd instalment->ACH Deposit->Return->EOD");
                  FileName = "QF_601_TS_040" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
                            QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCILPPayment.payment(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
    						InternalTfAndCashManagement.internaltf(SSN,AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
    						JQCClearDropdown.clearDropDown(SSN, SSN);
    						QCCSRLoginLogout.logout(SSN, AppURL);
      					}
      				}
      		} 	    	
    		@Test(priority = 17, groups="RCQ_ILP_601")
      		public static void QF_601_TS_041() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_041","Login TO csr-->Borrower Registration-->New Loan-->payment with tender type Check-->EOD-->clear menu through Admin portal ");
                  FileName = "QF_601_TS_041" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
                            QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCILPPayment.payment(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
      						//QCCSRLoginLogout.login2997(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCSafeAssign.safeAssign(SSN, AppURL);
      					   // QCCSRLoginLogout.login(SSN, AppURL);
      						QCDrawerAssign.drawerAssign(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL); 
      						QCCSRLoginLogout.adminLogin(SSN, AppURL);
      						QCClearMenu.adminClearMenu(SSN, SSN);
      						QCCSRLoginLogout.adminLogout(driver,SSN,AppURL);
      					}
      				}
      		}
    		@Test(priority = 18, groups="RCQ_ILP_601")
      		public static void QF_601_TS_042() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_042","Login TO csr-->Borrower Registration-->New Loan-->payment with tender type Check-->EOD ");
                  FileName = "QF_601_TS_042" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSRDefaultPayment.lessPayment(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
      						//QCCSRLoginLogout.login2997(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCSafeAssign.safeAssign(SSN, AppURL);
      					   //QCCSRLoginLogout.login(SSN, AppURL);
      						QCDrawerAssign.drawerAssign(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL); 
      						
      					}
      				}
      		}
    		@Test(priority = 19, groups="RCQ_ILP_601")
      		public static void QF_601_TS_043() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_043","Login TO csr-->Borrower Registration-->New Loan-->DefaultLoan-->defaultpayment lessAMT with tender type Check-->EOD-->clear from dropdown ");
                  FileName = "QF_601_TS_043" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSRDefaultPayment.lessPayment(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
    						InternalTfAndCashManagement.internaltf(SSN,AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
    						JQCClearDropdown.clearDropDown(SSN, SSN);
    						QCCSRLoginLogout.logout(SSN, AppURL);
      						
      					}
      				}
      		}
    		@Test(priority = 20, groups="RCQ_ILP_601")
      		public static void QF_601_TS_044() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_044","Login TO csr-->Borrower Registration-->New Loan-->defaulpayment lessAmt with tender type Check-->EOD-->clear menu through Admin portal ");
                  FileName = "QF_601_TS_044" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSRDefaultPayment.lessPayment(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
      						//QCCSRLoginLogout.login2997(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCSafeAssign.safeAssign(SSN, AppURL);
      					    //QCCSRLoginLogout.login(SSN, AppURL);
      						QCDrawerAssign.drawerAssign(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL); 
      						QCCSRLoginLogout.login(SSN, AppURL);
							QCClearMenu.clearMenu(SSN, SSN);
							QCCSRLoginLogout.logout(SSN, AppURL);
      						
      					}
      				}
      		}
      	    @Test(priority = 21, groups="RCQ_ILP_601")
      		public static void QF_601_TS_045() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_045","Login TO csr-->Borrower Registration-->New Loan-->defaultpayment lessAmt with tender type Check-->InternalTransfer-->clear menu through Admin portal ");
                  FileName = "QF_601_TS_045" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSRDefaultPayment.lessPayment(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
    						InternalTfAndCashManagement.internaltf(SSN,AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.adminLogin(SSN, AppURL);
      						QCClearMenu.adminClearMenu(SSN, SSN);
      						QCCSRLoginLogout.adminLogout(driver,SSN,AppURL);
      						
      					}
      				}
      		}
      		@Test(priority = 22, groups="RCQ_ILP_601")
      		public static void QF_601_TS_046() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_046","Login TO csr-->Borrower Registration-->New Loan-->payment with tender type Check-->Internal Transfer deposit");
                  FileName = "QF_601_TS_046" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSRDefaultPayment.defaultpayment(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
    						InternalTfAndCashManagement.internaltf(SSN,AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						
      					}
      				}
      		}
      		@Test(priority = 23, groups="RCQ_ILP_601")
      		public static void QF_601_TS_047() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_047","Login TO csr-->Borrower Registration-->New Loan-->payment equal Amt with tender type Check-->EOD-->clear from dropdown ");
                  FileName = "QF_601_TS_047" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSRDefaultPayment.defaultpayment(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
    						InternalTfAndCashManagement.internaltf(SSN,AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.login(SSN, AppURL);
    						JQCClearDropdown.clearDropDown(SSN, SSN);
    						QCCSRLoginLogout.logout(SSN, AppURL);
      						
      					}
      				}
      		}
      		@Test(priority = 24, groups="RCQ_ILP_601")
      		public static void QF_601_TS_048() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_048","Login TO csr-->Borrower Registration-->New Loan-->payment equal Amt with tender type Check-->InternalTransfer-->clear through CsrMenu ");
                  FileName = "QF_601_TS_048" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSRDefaultPayment.defaultpayment(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
    						InternalTfAndCashManagement.internaltf(SSN,AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.login(SSN, AppURL);
    						QCClearMenu.clearMenu(SSN, SSN);
    						QCCSRLoginLogout.logout(SSN, AppURL);
      						
      					}
      				}
      		}
      		@Test(priority = 25, groups="RCQ_ILP_601")
      		public static void QF_601_TS_049() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_049","Login TO csr-->Borrower Registration-->New Loan-->payment equal Amt with tender type Check-->InternalTransfer-->clear through admin ");
                  FileName = "QF_601_TS_049" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSRDefaultPayment.defaultpayment(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
    						InternalTfAndCashManagement.internaltf(SSN,AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.adminLogin(SSN, AppURL);
      						QCClearMenu.adminClearMenu(SSN, SSN);
      						QCCSRLoginLogout.adminLogout(driver,SSN,AppURL);
      						
      					}
      				}
      		}
      		@Test(priority = 26, groups="RCQ_ILP_601")
      		public static void QF_601_TS_051() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_050","Login TO csr-->Borrower Registration-->New Loan-->DefaultLoan-->WriteOff-->WriteOffRecovery With partial balance-->EOD-->clear from dropdown ");
                  FileName = "QF_601_TS_050" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      					    QCCSRLoginLogout.login(SSN, AppURL);
      					    RQCCSRWriteOff.writeoff(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSRWriteOffRecovery.partialWriteoffRecovery(SSN, AppURL);
    					    QCCSRLoginLogout.logout(SSN, AppURL);
    					   
    					    QCCSRLoginLogout.login(SSN, AppURL);
     						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
     						//QCCSRLoginLogout.login2997(SSN, AppURL);
     						QCCSRLoginLogout.login(SSN, AppURL);
     					    QCSafeAssign.safeAssign(SSN, AppURL);
     					    QCCSRLoginLogout.login(SSN, AppURL);
     						QCDrawerAssign.drawerAssign(SSN, AppURL);
     						QCCSRLoginLogout.logout(SSN, AppURL); 
     						QCCSRLoginLogout.login(SSN, AppURL);
    						JQCClearDropdown.clearDropDown(SSN, SSN);
    						QCCSRLoginLogout.logout(SSN, AppURL);
      					}
      				}
      		}
      		@Test(priority = 27, groups="RCQ_ILP_601")
      		public static void QF_601_TS_052() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_052","Login TO csr-->Borrower Registration-->New Loan-->DefaultLoan-->WriteOff-->WriteOffRecovery With partial balance-->EOD-->clear through CsrMenu ");
                  FileName = "QF_601_TS_052" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      					     QCCSRLoginLogout.login(SSN, AppURL);
      					     RQCCSRWriteOff.writeoff(SSN, AppURL);
      					     QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSRWriteOffRecovery.partialWriteoffRecovery(SSN, AppURL);
    					    QCCSRLoginLogout.logout(SSN, AppURL);
    					   
    					    QCCSRLoginLogout.login(SSN, AppURL);
     						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
     						//QCCSRLoginLogout.login2997(SSN, AppURL);
     						QCCSRLoginLogout.login(SSN, AppURL);
     					    QCSafeAssign.safeAssign(SSN, AppURL);
     					    //QCCSRLoginLogout.login(SSN, AppURL);
     						QCDrawerAssign.drawerAssign(SSN, AppURL);
     						QCCSRLoginLogout.logout(SSN, AppURL); 
     						QCCSRLoginLogout.login(SSN, AppURL);
    						QCClearMenu.clearMenu(SSN, SSN);
    						QCCSRLoginLogout.logout(SSN, AppURL);
      					}
      				}
      		}
      		@Test(priority = 28, groups="RCQ_ILP_601")
      		public static void QF_601_TS_053() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_053","Login TO csr-->Borrower Registration-->New Loan-->DefaultLoan-->WriteOff-->WriteOffRecovery With partial balance-->EOD-->clear through AdminMenu ");
                  FileName = "QF_601_TS_053" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      					     QCCSRLoginLogout.login(SSN, AppURL);
      					     RQCCSRWriteOff.writeoff(SSN, AppURL);
      					     QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSRWriteOffRecovery.partialWriteoffRecovery(SSN, AppURL);
    					    QCCSRLoginLogout.logout(SSN, AppURL);
    					   
    					    QCCSRLoginLogout.login(SSN, AppURL);
     						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
     						//QCCSRLoginLogout.login2997(SSN, AppURL);
     						QCCSRLoginLogout.login(SSN, AppURL);
     					    QCSafeAssign.safeAssign(SSN, AppURL);
     					    //QCCSRLoginLogout.login(SSN, AppURL);
     						QCDrawerAssign.drawerAssign(SSN, AppURL);
     						QCCSRLoginLogout.logout(SSN, AppURL); 
     						QCCSRLoginLogout.adminLogin(SSN, AppURL);
      						QCClearMenu.adminClearMenu(SSN, SSN);
      						QCCSRLoginLogout.adminLogout(driver,SSN,AppURL);
      					}
      				}
      		}
      		@Test(priority = 29, groups="RCQ_ILP_601")
      		public static void QF_601_TS_054() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_054","Login TO csr-->Borrower Registration-->New Loan-->DefaultLoan-->WriteOff-->WriteOffRecovery With partial balance-->EOD-->clear in clearance period ");
                  FileName = "QF_601_TS_054" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      					     QCCSRLoginLogout.login(SSN, AppURL);
      					     RQCCSRWriteOff.writeoff(SSN, AppURL);
      					     QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
    					    QCCSRLoginLogout.logout(SSN, AppURL);
    					   
    					    QCCSRLoginLogout.login(SSN, AppURL);
     						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
     						//QCCSRLoginLogout.login2997(SSN, AppURL);
     						QCCSRLoginLogout.login(SSN, AppURL);
     					    QCSafeAssign.safeAssign(SSN, AppURL);
     					    //QCCSRLoginLogout.login(SSN, AppURL);
     						QCDrawerAssign.drawerAssign(SSN, AppURL);
     						QCCSRLoginLogout.logout(SSN, AppURL); 
     						
      					}
      				}
      		}
      		@Test(priority = 28, groups="RCQ_ILP_601aa")
      		public static void QF_601_TS_055() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_055","Login TO csr-->Borrower Registration-->New Loan-->DefaultLoan-->WriteOff-->WriteOffRecovery With partial balance-->EOD-->clear from dropdown ");
                  FileName = "QF_601_TS_055" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      					     QCCSRLoginLogout.login(SSN, AppURL);
      					     RQCCSRWriteOff.writeoff(SSN, AppURL);
      					     QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
    					    QCCSRLoginLogout.logout(SSN, AppURL);
    					   
    					    QCCSRLoginLogout.login(SSN, AppURL);
    						InternalTfAndCashManagement.internaltf(SSN,AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
     						QCCSRLoginLogout.login(SSN, AppURL);
    						JQCClearDropdown.clearDropDown(SSN, SSN);
    						QCCSRLoginLogout.logout(SSN, AppURL);
      					}
      				}
      		}
      		@Test(priority = 29, groups="RCQ_ILP_601aa")
      		public static void QF_601_TS_056() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_056","Login TO csr-->Borrower Registration-->New Loan-->DefaultLoan-->WriteOff-->WriteOffRecovery With partial balance-->EOD-->clear from dropdown ");
                  FileName = "QF_601_TS_056" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      					     QCCSRLoginLogout.login(SSN, AppURL);
      					     RQCCSRWriteOff.writeoff(SSN, AppURL);
      					     QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
    					    QCCSRLoginLogout.logout(SSN, AppURL);
    					   
    					    QCCSRLoginLogout.login(SSN, AppURL);
     						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
     						//QCCSRLoginLogout.login2997(SSN, AppURL);
     						QCCSRLoginLogout.login(SSN, AppURL);
     					    QCSafeAssign.safeAssign(SSN, AppURL);
     					    //QCCSRLoginLogout.login(SSN, AppURL);
     						QCDrawerAssign.drawerAssign(SSN, AppURL);
     						QCCSRLoginLogout.logout(SSN, AppURL); 
    						QCCSRLoginLogout.login(SSN, AppURL);
    						QCClearMenu.clearMenu(SSN, SSN);
    						QCCSRLoginLogout.logout(SSN, AppURL);
      					}
      				}
      		}
      		@Test(priority = 30, groups="RCQ_ILP_601aa")
      		public static void QF_601_TS_057() throws Exception 
      		{
      			
      			test = reports.startTest("QF_601_TS_057","Login TO csr-->Borrower Registration-->New Loan-->DefaultLoan-->WriteOff-->WriteOffRecovery With partial balance-->EOD-->clear from dropdown ");
                  FileName = "QF_601_TS_057" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      					     QCCSRLoginLogout.login(SSN, AppURL);
      					     RQCCSRWriteOff.writeoff(SSN, AppURL);
      					     QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
    					    QCCSRLoginLogout.logout(SSN, AppURL);
    					   
    					    QCCSRLoginLogout.login(SSN, AppURL);
    						InternalTfAndCashManagement.internaltf(SSN,AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.adminLogin(SSN, AppURL);
      						QCClearMenu.adminClearMenu(SSN, SSN);
      						QCCSRLoginLogout.adminLogout(driver,SSN,AppURL);
      					}
      				}
      		}

//=============================== REQ-716 =================================================================

      	    @Test(priority = 1, groups="RCQ_ILP_716o")
      		public static void QF_716_TS_07() throws Exception 
      		{
      			
      			test = reports.startTest("QF-716_TS_007","Login TO csr-->Borrower Registration-->New Loan-->payment with tender type Check-->EOD-->clear menu through Admin portal ");
                  FileName = "QF-716_TS_007" + ".xls";
                  TestData = new ExcelNew(System.getProperty("user.dir")
      						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                      int lastrow = TestData.getLastRow("Start");
      				String sheetName = "Start";
      				
      				for (int row = 2; row <= lastrow; row++) {

      					String RunFlag = TestData.getCellData(sheetName, "Run", row);
      					
      					if (RunFlag.equals("Y")) {

      						String SSN = TestData.getCellData(sheetName, "SSN", row);
      						
      						System.out.println(AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
                            QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCILPPayment.payment(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
      						//QCCSRLoginLogout.login2997(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCSafeAssign.safeAssign(SSN, AppURL);
      					   // QCCSRLoginLogout.login(SSN, AppURL);
      						QCDrawerAssign.drawerAssign(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL); 
      						LendNationLogin.login(SSN,AppURL);
      						LendNationRegistration.store_customersetup(SSN, SSN);
      						LendNationLogin.signIn(SSN, AppURL);
      						QC_Online_NewLoanVerify.newLoanVerify(SSN, AppURL);
      					}
      					
      				}
      		}
      	    @Test(priority = 2, groups="RCQ_ILP_716o")
    		public static void QF_716_TS_09() throws Exception 
    		{
    			
    			test = reports.startTest("QF-716_TS_009","Login TO csr-->Borrower Registration-->New Loan-->partial default payment-->Internal transfer-->login to online-->Customer store setup-->verify pending paymentpopup  ");
                FileName = "QF-716_TS_009" + ".xls";
                TestData = new ExcelNew(System.getProperty("user.dir")
    						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                    int lastrow = TestData.getLastRow("Start");
    				String sheetName = "Start";
    				
    				for (int row = 2; row <= lastrow; row++) {

    					String RunFlag = TestData.getCellData(sheetName, "Run", row);
    					
    					if (RunFlag.equals("Y")) {

    						String SSN = TestData.getCellData(sheetName, "SSN", row);
    						
    						System.out.println(AppURL);
    						
    						QCCSRLoginLogout.login(SSN, AppURL);
      						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
      					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
      					    QCCSRLoginLogout.logout(SSN, AppURL);
      						
      						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSRDefaultPayment.lessPayment(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
      						QCCSRLoginLogout.login(SSN, AppURL);
    						InternalTfAndCashManagement.internaltf(SSN,AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						LendNationLogin.login(SSN,AppURL);
    						LendNationRegistration.store_customersetup(SSN, SSN);
    						LendNationLogin.signIn(SSN, AppURL);
    						QC_Online_NewLoanVerify.newLoanVerify(SSN, AppURL);
    					}
    					
    				}
    		}
      	//@Test(priority = 3, groups="RCQ_ILP_716o")
  		public static void QF_716_TS_10() throws Exception 
  		{
  			
  			test = reports.startTest("QF-716_TS_010","Login TO csr-->Borrower Registration-->New Loan-->default payment-->Internal transfer-->login to online-->Customer store setup-->verify pending paymentpopup ");
              FileName = "QF-716_TS_010" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						    QCCSRLoginLogout.login(SSN, AppURL);
    						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.login(SSN, AppURL);
    						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.login(SSN, AppURL);
    					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
    					    QCCSRLoginLogout.logout(SSN, AppURL);
    						
    						QCCSRLoginLogout.login(SSN, AppURL);
    						QCCSRDefaultPayment.defaultpayment(SSN, SSN);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.login(SSN, AppURL);
  						    InternalTfAndCashManagement.internaltf(SSN,AppURL);
  						    QCCSRLoginLogout.logout(SSN, AppURL);
  						    LendNationLogin.login(SSN,AppURL);
  						    LendNationRegistration.store_customersetup(SSN, SSN);
  						    LendNationLogin.signIn(SSN, AppURL);
  						    QC_Online_NewLoanVerify.newLoanVerify(SSN, AppURL);
  					}
  					
  				}
  		}

      	@Test(priority = 4, groups="RCQ_ILP_716o")
  		public static void QF_716_TS_11() throws Exception 
  		{
  			
  			test = reports.startTest("QF-716_TS_011","Login TO csr-->Borrower Registration-->New Loan-->default-->writeoff-->writeoffrecovery with partial payment-->Internal transfer-->login to online-->Customer store setup-->verify pending paymentpopup ");
              FileName = "QF-716_TS_011" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  					    QCCSRLoginLogout.login(SSN, AppURL);
  					    RQCCSRWriteOff.writeoff(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSRWriteOffRecovery.partialWriteoffRecovery(SSN, AppURL);
					    QCCSRLoginLogout.logout(SSN, AppURL);
					    QCCSRLoginLogout.login(SSN, AppURL);
						InternalTfAndCashManagement.internaltf(SSN,AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
  					    LendNationLogin.login(SSN,AppURL);
  						LendNationRegistration.store_customersetup(SSN, SSN);
  						LendNationLogin.signIn(SSN, AppURL);
  						QC_Online_NewLoanVerify.newLoanVerify(SSN, AppURL);
  					}
  					
  				}
  		}
      	//@Test(priority = 5, groups="RCQ_ILP_716o")
  		public static void QF_716_TS_12() throws Exception 
  		{
  			
  			test = reports.startTest("QF-716_TS_012","Login TO csr-->Borrower Registration-->New Loan-->default loan-->writeoff-->writeoffrecovery-->EOD-->Login to Online portal-->verify new loan ");
              FileName = "QF-716_TS_012" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  					    QCCSRLoginLogout.login(SSN, AppURL);
  					    RQCCSRWriteOff.writeoff(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSRWriteOffRecovery.writeoffrecovery(SSN, SSN);
					    QCCSRLoginLogout.logout(SSN, AppURL);
					    QCCSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
						//QCCSRLoginLogout.login2997(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
					    QCSafeAssign.safeAssign(SSN, AppURL);
					   // QCCSRLoginLogout.login(SSN, AppURL);
						QCDrawerAssign.drawerAssign(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL); 
  					    LendNationLogin.login(SSN,AppURL);
  						LendNationRegistration.store_customersetup(SSN, SSN);
  						LendNationLogin.signIn(SSN, AppURL);
  						QC_Online_NewLoanVerify.newLoanVerify(SSN, AppURL);
  					}
  					
  				}
  		}
        @Test(priority = 6, groups="RCQ_ILP_716o")
  		public static void QF_716_TS_015() throws Exception 
  		{
  			
  			test = reports.startTest("QF-716_TS_015","Login TO csr-->Borrower Registration-->New Loan-->payment pay installment amt with tender type Check-->internal transfer-->Login to online-->customer store setup-->NewLoan verify ");
              FileName = "QF-716_TS_015" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCILPPayment.payment(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						 QCCSRLoginLogout.login(SSN, AppURL);
 						InternalTfAndCashManagement.internaltf(SSN,AppURL);
 						QCCSRLoginLogout.logout(SSN, AppURL);
  						LendNationLogin.login(SSN,AppURL);
  						LendNationRegistration.store_customersetup(SSN, SSN);
  						LendNationLogin.signIn(SSN, AppURL);
  						QC_Online_NewLoanVerify.newLoanVerify(SSN, AppURL);
  					}
  					
  				}
  		}
        
        @Test(priority = 7, groups="RCQ_ILP_716o1")
		public static void QF_716_TS_019() throws Exception 
		{
			
			test = reports.startTest("QF-716_TS_019","Login TO csr-->Borrower Registration-->New Loan-->Default loan-->partial default payment-->EOD-->login to online customer store setup-->Newloan verify ");
            FileName = "QF-716_TS_019" + ".xls";
            TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						System.out.println(AppURL);
						
						/*QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSRDefaultPayment.lessPayment(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
*/						//QCCSRLoginLogout.login2997(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
					    QCSafeAssign.safeAssign(SSN, AppURL);
					   // QCCSRLoginLogout.login(SSN, AppURL);
						QCDrawerAssign.drawerAssign(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL); 
						LendNationLogin.login(SSN,AppURL);
						LendNationRegistration.store_customersetup(SSN, SSN);
						LendNationLogin.signIn(SSN, AppURL);
						QC_Online_NewLoanVerify.newLoanVerify(SSN, AppURL);
					}
					
				}
		}
        //@Test(priority = 8, groups="RCQ_ILP_716o")
		public static void QF_716_TS_020() throws Exception 
		{
			
			test = reports.startTest("QF-716_TS_020","Login TO csr-->Borrower Registration-->New Loan-->Default loan-->default payment-->EOD-->login to online customer store setup-->Newloan verify ");
            FileName = "QF-716_TS_020" + ".xls";
            TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						System.out.println(AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSRDefaultPayment.defaultpayment(SSN, SSN);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
						//QCCSRLoginLogout.login2997(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
					    QCSafeAssign.safeAssign(SSN, AppURL);
					   // QCCSRLoginLogout.login(SSN, AppURL);
						QCDrawerAssign.drawerAssign(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL); 
						LendNationLogin.login(SSN,AppURL);
						LendNationRegistration.store_customersetup(SSN, SSN);
						LendNationLogin.signIn(SSN, AppURL);
						QC_Online_NewLoanVerify.newLoanVerify(SSN, AppURL);
					}
					
				}
		}
        @Test(priority = 9, groups="RCQ_ILP_716o1")
  		public static void QF_716_TS_029() throws Exception 
  		{
  			
  			test = reports.startTest("QF-716_TS_029","Login TO csr-->Borrower Registration-->New Loan-->payment pay installment amt with tender type Check-->internal transfer-->Login to online-->customer store setup-->NewLoan verify ");
              FileName = "QF-716_TS_029" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCILPPayment.payment(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
						//QCCSRLoginLogout.login2997(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
					    QCSafeAssign.safeAssign(SSN, AppURL);
					   // QCCSRLoginLogout.login(SSN, AppURL);
						QCDrawerAssign.drawerAssign(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL); 
  						LendNationLogin.login(SSN,AppURL);
  						LendNationRegistration.store_customersetup(SSN, SSN);
  						LendNationLogin.signIn(SSN, AppURL);
  						QC_Online_NewLoanVerify.newLoanVerify(SSN, AppURL);
  					}
  					
  				}
  		}

      	    //@Test(priority = 10, groups="RCQ_ILP_716")
    		public static void QF_716_TS_021() throws Exception 
    		{
    			
    			test = reports.startTest("QF-716_TS_021","Login TO csr-->Borrower Registration-->New Loan-->payment with tender type Check-->EOD-->clear menu through Admin portal ");
                FileName = "QF-716_TS_021" + ".xls";
                TestData = new ExcelNew(System.getProperty("user.dir")
    						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                    int lastrow = TestData.getLastRow("Start");
    				String sheetName = "Start";
    				
    				for (int row = 2; row <= lastrow; row++) {

    					String RunFlag = TestData.getCellData(sheetName, "Run", row);
    					
    					if (RunFlag.equals("Y")) {

    						String SSN = TestData.getCellData(sheetName, "SSN", row);
    						
    						System.out.println(AppURL);
    						
    						QCCSRLoginLogout.login(SSN, AppURL);
    						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
                          QCCSRLoginLogout.login(SSN, AppURL);
    						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.login(SSN, AppURL);
    						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
    						QCCSRLoginLogout.login(SSN, AppURL);
    						QCILPPayment.payment(SSN, AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL);
    						QCCSRLoginLogout.login(SSN, AppURL);
    						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
    						//QCCSRLoginLogout.login2997(SSN, AppURL);
    						QCCSRLoginLogout.login(SSN, AppURL);
    					    QCSafeAssign.safeAssign(SSN, AppURL);
    					   // QCCSRLoginLogout.login(SSN, AppURL);
    						QCDrawerAssign.drawerAssign(SSN, AppURL);
    						QCCSRLoginLogout.logout(SSN, AppURL); 
    						QCCSRLoginLogout.login(SSN, AppURL);
      						QCCSR_ILP_NewLoan.newLoanVerify(SSN, AppURL);
      						QCCSRLoginLogout.logout(SSN, AppURL);
    					}
    					
    				}
    		}

      	//@Test(priority = 11, groups="RCQ_ILP_716")
		public static void QF_716_TS_022() throws Exception 
		{
			
			test = reports.startTest("QF-716_TS_022","Login TO csr-->Borrower Registration-->New Loan-->payment with tender type Check-->EOD-->clear menu through Admin portal ");
            FileName = "QF-716_TS_022" + ".xls";
            TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						System.out.println(AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCILPPayment.payment(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						InternalTfAndCashManagement.internaltf(SSN,AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.login(SSN, AppURL);
                        QCCSR_ILP_NewLoan.newLoanVerify(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
					}
					
				}
		}
      	//@Test(priority = 12, groups="RCQ_ILP_716")
  		public static void QF_716_TS_025() throws Exception 
  		{
  			
  			test = reports.startTest("QF_716_TS_025","Login TO csr-->Borrower Registration-->New Loan-->defaultpayment lessAmt with tender type Check-->InternalTransfer-->clear menu through Admin portal ");
              FileName = "QF-716_TS_025" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSRDefaultPayment.lessPayment(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
						InternalTfAndCashManagement.internaltf(SSN,AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_ILP_NewLoan.newLoanVerify(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						
  					}
  				}
  		}
        @Test(priority = 13, groups="RCQ_ILP_716")
  		public static void QF_716_TS_026() throws Exception 
  		{
  			
  			test = reports.startTest("QF_716_TS_026","Login TO csr-->Borrower Registration-->New Loan-->payment equal Amt with tender type Check-->InternalTransfer-->clear through CsrMenu ");
              FileName = "QF-716_TS_026" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSRDefaultPayment.defaultpayment(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
						//QCCSRLoginLogout.login2997(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
					    QCSafeAssign.safeAssign(SSN, AppURL);
					   // QCCSRLoginLogout.login(SSN, AppURL);
						QCDrawerAssign.drawerAssign(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL); 
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_ILP_NewLoan.newLoanVerify(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  					}
  				}
  		}

        @Test(priority = 14, groups="RCQ_ILP_716")
  		public static void QF_716_TS_027() throws Exception 
  		{
  			
  			test = reports.startTest("QF_716_TS_027","Login TO csr-->Borrower Registration-->New Loan-->DefaultLoan-->WriteOff-->WriteOffRecovery With partial balance-->EOD-->clear through AdminMenu ");
              FileName = "QF-716_TS_027" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  					     QCCSRLoginLogout.login(SSN, AppURL);
  					     RQCCSRWriteOff.writeoff(SSN, AppURL);
  					     QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSRWriteOffRecovery.partialWriteoffRecovery(SSN, AppURL);
					    QCCSRLoginLogout.logout(SSN, AppURL);
					    QCCSRLoginLogout.login(SSN, AppURL);
						InternalTfAndCashManagement.internaltf(SSN,AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
 						QCCSRLoginLogout.login(SSN, AppURL);
 						QCCSR_ILP_NewLoan.newLoanVerify(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  					}
  				}
  		}
  
        @Test(priority = 15, groups="RCQ_ILP_716")
  		public static void QF_716_TS_028() throws Exception 
  		{
  			
  			test = reports.startTest("QF_716_TS_028","Login TO csr-->Borrower Registration-->New Loan-->DefaultLoan-->WriteOff-->WriteOffRecovery With partial balance-->EOD-->clear through AdminMenu ");
              FileName = "QF-716_TS_028" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  					    QCCSRLoginLogout.login(SSN, AppURL);
  					    RQCCSRWriteOff.writeoff(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSRWriteOffRecovery.writeoffrecovery(SSN, SSN);
					    QCCSRLoginLogout.logout(SSN, AppURL);
					    QCCSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
						//QCCSRLoginLogout.login2997(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
					    QCSafeAssign.safeAssign(SSN, AppURL);
					    //QCCSRLoginLogout.login(SSN, AppURL);
						QCDrawerAssign.drawerAssign(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL); 
 						QCCSRLoginLogout.login(SSN, AppURL);
 						QCCSR_ILP_NewLoan.newLoanVerify(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  					}
  				}
  		}
        @Test(priority = 16, groups="RCQ_ILP_716")
  		public static void QF_716_TS_30() throws Exception 
  		{
  			
  			test = reports.startTest("QF-716_TS_030","Login TO csr-->Borrower Registration-->New Loan-->payment with tender type Check-->EOD-->clear menu through Admin portal ");
              FileName = "QF-716_TS_030" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCILPPayment.payment(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
  						//QCCSRLoginLogout.login2997(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCSafeAssign.safeAssign(SSN, AppURL);
  					   // QCCSRLoginLogout.login(SSN, AppURL);
  						QCDrawerAssign.drawerAssign(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL); 
  						QCCSRLoginLogout.login(SSN, AppURL);
  						RefinanceVerify.refinanceStepDown(SSN, SSN);
  						QCCSRLoginLogout.logout(SSN, AppURL); 
  					}
  					
  				}
  		}
        @Test(priority = 17, groups="RCQ_ILP_716")
  		public static void QF_716_TS_31() throws Exception 
  		{
  			
  			test = reports.startTest("QF-716_TS_031","Login TO csr-->Borrower Registration-->New Loan-->payment with tender type Check-->EOD-->clear menu through Admin portal ");
              FileName = "QF-716_TS_031" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCILPPayment.payment(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
  						//QCCSRLoginLogout.login2997(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCSafeAssign.safeAssign(SSN, AppURL);
  					   // QCCSRLoginLogout.login(SSN, AppURL);
  						QCDrawerAssign.drawerAssign(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL); 
  						QCCSRLoginLogout.login(SSN, AppURL);
  						RefinanceVerify.refinanceStepDown(SSN, SSN);
  						QCCSRLoginLogout.logout(SSN, AppURL);  
  					}
  					
  				}
  		}
        @Test(priority = 18, groups="RCQ_ILP_716")
  		public static void QF_716_TS_034() throws Exception 
  		{
  			
  			test = reports.startTest("QF_716_TS_034","Login TO csr-->Borrower Registration-->New Loan-->defaultpayment lessAmt with tender type Check-->InternalTransfer-->clear menu through Admin portal ");
              FileName = "QF-716_TS_034" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSRDefaultPayment.lessPayment(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
						InternalTfAndCashManagement.internaltf(SSN,AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
  						RefinanceVerify.refinanceStepDown(SSN, SSN);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						
  					}
  				}
  		}
        @Test(priority = 19, groups="RCQ_ILP_716")
  		public static void QF_716_TS_035() throws Exception 
  		{
  			
  			test = reports.startTest("QF_716_TS_035","Login TO csr-->Borrower Registration-->New Loan-->defaultpayment lessAmt with tender type Check-->InternalTransfer-->clear menu through Admin portal ");
              FileName = "QF-716_TS_035" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSRDefaultPayment.defaultpayment(SSN, SSN);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						AQCEODDeposit.eodDeposit(SSN, AppURL);//-->EOD
 						//QCCSRLoginLogout.login2997(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCSafeAssign.safeAssign(SSN, AppURL);
  					    //QCCSRLoginLogout.login(SSN, AppURL);
  						QCDrawerAssign.drawerAssign(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL); 
						QCCSRLoginLogout.login(SSN, AppURL);
  						RefinanceVerify.refinanceStepDown(SSN, SSN);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						
  					}
  				}
  		}

        //@Test(priority = 1, groups="RCQ_ILP_884")
  		public static void QF_884_TS_005() throws Exception 
  		{
  			
  			test = reports.startTest("QF-884_TS_005","Login TO csr-->Borrower Registration-->New Loan-->payment pay installment amt with tender type Check-->internal transfer-->Login to online-->customer store setup-->NewLoan verify ");
              FileName = "QF-884_TS_005" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCILPPayment.payment(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						 QCCSRLoginLogout.login(SSN, AppURL);
 						InternalTfAndCashManagement.internaltf(SSN,AppURL);
 						QCCSRLoginLogout.logout(SSN, AppURL);
  						LendNationLogin.login(SSN,AppURL);
  						LendNationRegistration.store_customersetup(SSN, SSN);
  						LendNationLogin.signIn(SSN, AppURL);
  						LendnationILPPayment.payment(SSN, AppURL);
  					}
  					
  				}
  		}
        //@Test(priority = 18, groups="RCQ_ILP_884")
  		public static void QF_884_TS_007() throws Exception 
  		{
  			
  			test = reports.startTest("QF-884_TS_007","Login TO csr-->Borrower Registration-->New Loan-->defaultpayment lessAmt with tender type Check-->InternalTransfer-->clear menu through Admin portal ");
              FileName = "QF-884_TS_007" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSRDefaultPayment.lessPayment(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
						InternalTfAndCashManagement.internaltf(SSN,AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						LendNationLogin.login(SSN,AppURL);
  						LendNationRegistration.store_customersetup(SSN, SSN);
  						LendNationLogin.signIn(SSN, AppURL);
  						LendnationILPPayment.payment(SSN, AppURL);
  						
  					}
  				}
  		}

        @Test(priority = 14, groups="RCQ_ILP_884")
  		public static void QF_884_TS_008() throws Exception 
  		{
  			
  			test = reports.startTest("QF-884_TS_008","Login TO csr-->Borrower Registration-->New Loan-->DefaultLoan-->WriteOff-->WriteOffRecovery With partial balance-->EOD-->clear through AdminMenu ");
              FileName = "QF-884_TS_008" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
  					    QCCSRLoginLogout.logout(SSN, AppURL);
  					     QCCSRLoginLogout.login(SSN, AppURL);
  					     RQCCSRWriteOff.writeoff(SSN, AppURL);
  					     QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  					    QCCSRWriteOffRecovery.partialWriteoffRecovery(SSN, AppURL);
					    QCCSRLoginLogout.logout(SSN, AppURL);
					    QCCSRLoginLogout.login(SSN, AppURL);
						InternalTfAndCashManagement.internaltf(SSN,AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						LendNationLogin.login(SSN,AppURL);
  						LendNationRegistration.store_customersetup(SSN, SSN);
  						LendNationLogin.signIn(SSN, AppURL);
  						LendnationILPPayment.payment(SSN, AppURL);
  					}
  				}
  		}
  		//@Test(priority = 1, groups="RCQ_804")
  		public static void TS_804_Store_TLP_Refi_01() throws Exception {
  			
  				
  			test = reports.startTest("TS_804_Store_TLP_Refi_01","Login-->Home Screen-->Borrower Registration-->New Loan-->age store to 60days-->Refinance");

  				FileName = "TS_804_Store_TLP_Refi_01" + ".xls";

  				TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

  				int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				System.out.println(lastrow);
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);

  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);

  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSRNewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCRefinance60DaysRule.tlpRefinance(SSN, SSN);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						}
  				}
  		}
  		@Test(priority = 2, groups="RCQ_804")
  		public static void TS_804_Store_ILP_Refi_01() throws Exception 
  		{
  			
  			test = reports.startTest("TS_804_Store_ILP_Refi_01","Login TO csr-->Borrower Registration-->New Loan-->age store to 60 days-->Rfinance ");
              FileName = "TS_804_Store_ILP_Refi_01" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCCSR_ILP_NewLoan.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCRefinance60DaysRule.ilpRefinance(SSN, SSN);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  					}
  				}
  		}

  		@Test(priority = 3, groups="RCQ_804")
  		public static void TS_804_Store_ILP_Refi_04() throws Exception 
  		{
  			
  			test = reports.startTest("TS_804_Store_ILP_Refi_04","Login TO csr-->Borrower Registration-->ILP New Loan with lessAmount-->age store to 60days-->Refinance ");
              FileName = "TS_804_Store_ILP_Refi_04" + ".xls";
              TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                  int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);
  						
  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						NewloanWithLessAmt.newLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCRefinance60DaysRule.ilpRefinance(SSN, SSN);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  					}
  				}
  		}
  		@Test(priority = 4, groups="RCQ_804")
   		public static void TS_804_Store_ILP_Refi_03() throws Exception 
   		{
   			
   			test = reports.startTest("TS_804_Store_ILP_Refi_03","Login TO csr-->Borrower Registration-->ILP New Loan with less amount-->autoDefault-->Refinance ");
               FileName = "TS_804_Store_ILP_Refi_03" + ".xls";
               TestData = new ExcelNew(System.getProperty("user.dir")
   						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
                   int lastrow = TestData.getLastRow("Start");
   				String sheetName = "Start";
   				
   				for (int row = 2; row <= lastrow; row++) {

   					String RunFlag = TestData.getCellData(sheetName, "Run", row);
   					
   					if (RunFlag.equals("Y")) {

   						String SSN = TestData.getCellData(sheetName, "SSN", row);
   						
   						System.out.println(AppURL);
   						
   						QCCSRLoginLogout.login(SSN, AppURL);
   						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
   						QCCSRLoginLogout.logout(SSN, AppURL);
   						QCCSRLoginLogout.login(SSN, AppURL);
   						NewloanWithLessAmt.newLoan(SSN, AppURL);
   						QCCSRLoginLogout.logout(SSN, AppURL);
   						QCCSRLoginLogout.login(SSN, AppURL);
   					    AQCCSRDefault.Adefault(SSN, AppURL);
   					    QCCSRLoginLogout.login(SSN, AppURL);
   						QCRefinance60DaysRule.ilpRefinanceForDefault(SSN, SSN);
   						QCCSRLoginLogout.logout(SSN, AppURL);
   					}
   				}
   		}
  	    @Test(priority = 2, groups="RCQ_804")//--->pending loan defaulted less than 60 days
  		public static void TS_804_Store_TLP_Refi_03() throws Exception {
  			
  				
  			test = reports.startTest("TS_804_Store_TLP_Refi_03","Login-->Home Screen-->Borrower Registration-->New Loan with lessAmt-->Refinance");

  				FileName = "TS_804_Store_TLP_Refi_03" + ".xls";

  				TestData = new ExcelNew(System.getProperty("user.dir")
  						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

  				int lastrow = TestData.getLastRow("Start");
  				String sheetName = "Start";
  				
  				System.out.println(lastrow);
  				for (int row = 2; row <= lastrow; row++) {

  					String RunFlag = TestData.getCellData(sheetName, "Run", row);
  					
  					if (RunFlag.equals("Y")) {

  						String SSN = TestData.getCellData(sheetName, "SSN", row);

  						System.out.println(AppURL);
  						
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);

  						QCCSRLoginLogout.login(SSN, AppURL);
  						NewloanWithLessAmt.tlpNewLoan(SSN, AppURL);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
  						QCCSRLoginLogout.login(SSN, AppURL);
  						QCRefinance60DaysRule.tlpRefinance(SSN, SSN);
  						QCCSRLoginLogout.logout(SSN, AppURL);
  						}
  				}
  		}
  	  @Test(priority = 5, groups="RCQ_804a")//--->pending loan defaulted less than 60 days
		public static void TS_804_Store_TLP_Refi_04() throws Exception {
			
				
			test = reports.startTest("TS_804_Store_TLP_Refi_04","Login-->Home Screen-->Borrower Registration-->New Loan with lessAmt-->default loan-->Refinance");

				FileName = "TS_804_Store_TLP_Refi_04" + ".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);

						QCCSRLoginLogout.login(SSN, AppURL);
						NewloanWithLessAmt.tlpNewLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
  						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCRefinance60DaysRule.tlpDefaultRefinance(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
						}
				}
		}


     
//==================================Sprint1 Online Scenarios=======================================		
		//@Test(priority=0, groups={"REQ_856"} )
		public static void Req_ID_856_01() throws Exception {
			test = reports.startTest(("Req_ID_856_01_02"),
							"Generate Loan-->Approved Loan in PAM-->Finish Loan");
					String FileName = "CashtoStore_Simple_Loan.xls";
					
					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					
					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							
							String SSN = TestData.getCellData(sheetName, "SSN", row);
		//==========================================================================================================				
						
						
						/*for(int i=0; i<=10; i++)
						{
							LendNationLogin.login();
							Thread.sleep(2000);
							test.log(LogStatus.PASS, "Page refreshed");
							
						}*/
						
						
						System.out.println(loan_number);
						
						//LendNationRegistration.registration(SSN, AppURL);
						LendNationLogin.login(SSN,AppURL);
						//LendNationPersonalInformation.personalInformation(SSN, AppURL);
						HireDateInFinancialInfo.financialInformation(SSN, AppURL);
					   
			//break;
						
		  }
	}
  }
		//@Test(priority=1, groups={"REQ_856"} )
		public static void Req_ID_856_03() throws Exception {
			test = reports.startTest(("Req_ID_856_03_04"),
							"Generate Loan-->Approved Loan in PAM-->Finish Loan");
					String FileName = "CashtoStore_Simple_Loan.xls";
					
					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					
					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					// int lastrow=TestData.getLastRow("Borrower");
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						// System.out.println(RunFlag);
						if (RunFlag.equals("Y")) {
							
							String SSN = TestData.getCellData(sheetName, "SSN", row);
		//==========================================================================================================				
						
						
						/*for(int i=0; i<=10; i++)
						{
							LendNationLogin.login();
							Thread.sleep(2000);
							test.log(LogStatus.PASS, "Page refreshed");
							
						}*/
						
						
						System.out.println(loan_number);
						LendNationLogin.login(SSN,AppURL);
						/*LendNationRegistration.registration(SSN, AppURL);
						LendNationPersonalInformation.personalInformation(SSN, AppURL);*/
						//HireDateInFinancialInfo.financialInformation(SSN, AppURL);
					   
			//break;
						
		  }
	}
  }

   @BeforeClass(alwaysRun = true)
   public void setup() throws IOException {

		try {

			// prop=prop.getProperty("user.dir")+"/Tests/Objects.properties";
			BufferedReader reader;
			
			try {
				reader = new BufferedReader(
						new FileReader("C:/QC_Batch_Recon/QC_Sprint/src/test/java/tests/Objects.properties"));
				prop = new Properties();
				prop.load(reader);
				reader.close();
				String filename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + filename,
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

			Thread.sleep(5000); // Allow OS to kill the process
			System.out.println("killed the process in TLP");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}
    public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/TLP/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod(alwaysRun = true)
        public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
		test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());

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

	
	}

}

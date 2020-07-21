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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
@Listeners(tests.TestListeners.class)
public class QCStore {

	public static WebDriverWait wait;
	public static WebDriver driver;
	public static WebDriver driver1;
	String appUrl;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	public static Properties prop;
	public static Properties Aprop;
	public static Properties Jprop;
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
	public static String AppURL;
	public static String AdminURL;
	public static String FirstName;
	public static String passwrd;
	public static String report_filename;
	public static String LastName;
	public static String ESign_CheckNbr;
	public static String ESign_CollateralType;
	public static String Due_Date1;
	public static String Due_Date2;
	public static String Due_Date3;

	public static String NextDueDate;
	
	public static String NatchaFilename;
	

	//---------------------------------------------------------------------------------------------------------------
	
	//TLP MultiTendertype
	

	//TLP MultiTendertype
	@Test(priority = 13, enabled=true, groups = "Anoop1")
	public void TLPACHPayment() throws Exception {
		FileName = "TLP_ACHPayment_MT.xls";
		test = reports.startTest("QC_TLP_ACHPayment_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->"
				+ "Age to due date-->Deposit Dropdown-->ACH Process-->ACH return-->ACH payment");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_TLP_CSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				MT_TLP_DepositDropDown.depositDropDown(SSN, SSN);
				ACSRLoginLogout.logout();
				
				AQCAdminLoginLogout.login(SSN);
				AQCACHProcessing.ACHProcess(SSN, NextDueDate);
				AQCDownloadNACHA.ACHProcess(SSN);
				AQCDownloadNACHA.ACHReturnProcess_UploadFile();
				AQCAdminLoginLogout.logout();
				
			
				
				
				
				ACSRLoginLogout.login(SSN, AppURL);
				ATLP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, SSN);
				ACSRLoginLogout.logout();

			
			}
		}
	}
	
	
	//TLP MultiTendertype
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void TLPPrePayment() throws Exception {
		FileName = "TLP_PrePayment_MT.xls";
		test = reports.startTest("QC_TLP_Prepayment_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Age to due date-->"
				+ "Deposit Dropdown-->Age the sore-->PrePayment");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_TLP_CSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				MT_TLP_DepositDropDown.depositDropDown(SSN, SSN);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				ATLP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, SSN);
				ACSRLoginLogout.logout();

			
			}
		}
	} 
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void TLPWORecovry() throws Exception {
		FileName = "TLP_WORecovry_MT.xls";
		test = reports.startTest("TLP_WORecovery_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->"
				+ "Age to due date-->Deposit-->InternalTf and cash management-->ReturnPosting-->WrireoFf-->WO Recovery");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				/*ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();*/
				/*ACSRLoginLogout.login(SSN, AppURL);
				AQC_TLP_CSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();*/
				/*ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);

				TLP_WriteOff.writeoff(SSN,AppURL);
				ACSRLoginLogout.logout();*/
				
				ACSRLoginLogout.login(SSN, AppURL);
				TLP_WriteOffRecovry.writeoffrecovery(SSN, SSN);
				ACSRLoginLogout.logout();
				/*ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, SSN);
				ACSRLoginLogout.logout();*/
				
			}
		}
	}

	
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void TLP_Refinance() throws Exception {
		FileName = "TLP_Refinance_MT.xls";
		test = reports.startTest("TLP_Refinance_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->"
				+ "Age the store -->Refinance");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				
				/*ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();*/
				/*ACSRLoginLogout.login(SSN, AppURL);
				AQC_TLP_CSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();*/
				
				
				/*ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);*/
				ACSRLoginLogout.login(SSN, AppURL);
				PDL_Refinance_MT.refinance(SSN, SSN);
				ACSRLoginLogout.logout();
				/*
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, SSN);
				ACSRLoginLogout.logout();*/

			}
		}
	}

      //TLP MultiTendertype
		@Test(priority = 13, enabled=true, groups = "Anoop")
		public void TLP_PayanyotherAmt() throws Exception {
			FileName = "QC_TLP_Payanyotheramount_Void_Txn.xls";
			test = reports.startTest("QC_TLP_Payanyotheramount_Void","Login-->Home Screen-->Borrower Registration-->New Loan-->Payment with multiple tenders-->Payanyother Amt");

			TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow+1; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {
				
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					
					ACSRLoginLogout.login(SSN, AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN, AppURL);
					AQC_TLP_CSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					ACSRRescindLoan.agerescind(SSN, AppURL);

					ACSRLoginLogout.login(SSN, AppURL);
					ATLP_Payment.payment(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					AQCCSRVoid.QcVoid(SSN, SSN);
					ACSRLoginLogout.logout();
							
				}
			}
		}
		@Test(priority = 13, enabled=true, groups = "Anoop")
		public void TLPBuyBack() throws Exception {
			FileName = "TLP_Buyback_MT.xls";
			test = reports.startTest("QC_TLP_BuyBack_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Age to due date-->BuyBack");

			TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow+1; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {
					//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					
					ACSRLoginLogout.login(SSN, AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN, AppURL);
					AQC_TLP_CSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN, AppURL);
					ATLP_Payment.payment(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					AQCCSRVoid.QcVoid(SSN, SSN);
					ACSRLoginLogout.logout();
					

				
				}
			}
		}
	//TLP MultiTendertype
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void TLP_InstallmentPayment() throws Exception {
		FileName = "QC_TLP_PartialPayment.xls";
		test = reports.startTest("QC_TLP_PartialPayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Payment with multiple tenders");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
			
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_TLP_CSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ATLP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, SSN);
				ACSRLoginLogout.logout();
						
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------------------\

	//ILP Installment amount
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void ILP_DefaultPayment() throws Exception {
		FileName = "ILP_DefaultPayment_MT.xls";
		test = reports.startTest("QC_IDefaultPayment_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Age to due date-->Installment payment");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				/*ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				RQCCSRDefault.sdefault(SSN, AppURL);
				ACSRLoginLogout.logout();*/
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);
				
				/*ACSRLoginLogout.login(SSN, AppURL);
				RQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
				ACSRLoginLogout.logout();*/
				
			}
		}
	}

	//ILP Refinance
		@Test(priority = 13, enabled=true, groups = "Anoop")
		public void ILP_Refinance() throws Exception {
			FileName = "ILP_Refinance_MT.xls";
			test = reports.startTest("ILP_Refinancet_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->"
					+ "Age the store -->Refinance");

			TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow+1; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {
					
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					
					
					ACSRLoginLogout.login(SSN, AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					ACSRNewLoanPage.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					
					ACSRLoginLogout.login(SSN, AppURL);
					ACSRRescindLoan.agerescind(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					PDL_Refinance_MT.refinance(SSN, SSN);
					ACSRLoginLogout.logout();

				}
			}
		}

		//PDL MultiTendertype
		@Test(priority = 13, enabled=true, groups = "Anoop")
		public void ILP_NSFpayment() throws Exception {
			FileName = "ILP_NsfPayment_MT.xls";
			test = reports.startTest("QC_ILP_NSF Payment_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Age to due date--> "
					+ "Deposit Dropdown-->InternalTf cash management-->Check Return-->NsfPayment");

			TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow+1; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {
					//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					
					ACSRLoginLogout.login(SSN, AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					ACSRNewLoanPage.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					ACSRLoginLogout.login(SSN, AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, SSN);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					AInternalTfAndCashManagement.internaltf(SSN, SSN);
					ACSRLoginLogout.logout();
					AQCAdminLoginLogout.login(SSN);
					JQCCSRReturnPosting.ReturnPosting(SSN, SSN);					
					AQCAdminLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					NSFpayment.nsfPayment(SSN, SSN);
					ACSRLoginLogout.logout();
					
					ACSRLoginLogout.login(SSN, AppURL);
					AQCCSRVoid.QcVoid(SSN, SSN);
					ACSRLoginLogout.logout();
					
					

				
				}
			}
		}

	//ILP Installment amount
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void ILP_InstallmentAmount() throws Exception {
		FileName = "ILP_InstallmentAmount_MT.xls";
		test = reports.startTest("QC_ILP_Installment amount_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Age to due date-->Installment payment");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

			
			}
		}
	}

	
	//ILP MultiTendertype:Payoff
			@Test(priority = 13, enabled=true, groups = "Anoop")
			public void ILP_BuyBack() throws Exception {
				FileName = "ILP_Buyback_MT.xls";
				test = reports.startTest("QC_ILP_BuyBack_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Age to due date-->BuyBack");

				TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);

					if (RunFlag.equals("Y")) {
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRRescindLoan.agerescind(SSN, AppURL);

						
						ACSRLoginLogout.login(SSN, AppURL);
						ILP_Payment.payment(SSN, AppURL);
						ACSRLoginLogout.logout();

					
					}
				}
			}
		

	
	
	
	//ILP MultiTendertype
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void borrowregNewloan_ILP() throws Exception {
		FileName = "ILP_QC_BorrowerRegistration_NewLoan.xls";
		test = reports.startTest("QC_ILP_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Payment with multiple tenders");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
						
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------
	
		//PDL MultiTendertype

	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void EPP_NSFPayment() throws Exception {
		FileName = "EPP_NSFPayment.xls";
		test = reports.startTest("PDL_EPPPayment_MT_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->"
				+ "Age to due date-->EPP-->Age the store-->EPP payment");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPPayment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, SSN);
				ACSRLoginLogout.logout();
				

			
			}
		}
	}
	
	
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void PDL_Refinance() throws Exception {
		FileName = "PDL_Refinance_MT.xls";
		test = reports.startTest("PDL_Refinance_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->"
				+ "Age the store -->Refinance");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				PDL_Refinance_MT.refinance(SSN, SSN);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, SSN);
				ACSRLoginLogout.logout();

			}
		}
	}
	
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void WORecovry() throws Exception {
		FileName = "PDL_WORecovry_MT.xls";
		test = reports.startTest("PDL_WORecovery_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->"
				+ "Age to due date-->Deposit-->InternalTf and cash management-->ReturnPosting-->WrireoFf-->WO Recovery");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, SSN);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, SSN);
				ACSRLoginLogout.logout();
				AQCAdminLoginLogout.login(SSN);
				JQCCSRReturnPosting.ReturnPosting(SSN, SSN);					
				AQCAdminLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRWriteOff.writeoff(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRWriteOffRecovery_MT.WORecovery(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, SSN);
				ACSRLoginLogout.logout();

			}
		}
	}

	
	
	
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void EPPPayment() throws Exception {
		FileName = "PDL_EPP_Prepayment_MT.xls";
		test = reports.startTest("PDL_EPPPayment_MT_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->"
				+ "Age to due date-->EPP-->Age the store-->EPP payment");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPPayment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, SSN);
				ACSRLoginLogout.logout();
				

			
			}
		}
	}
	
	//PDL MultiTendertype
	//@Test(priority = 13, enabled=true, groups = "Anoop")
	public void defaultPayment() throws Exception {
		FileName = "PDL_DefalutPayment_MT.xls";
		test = reports.startTest("QC_PDL_defaultPayment_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->"
				+ "Age to due date-->Deposit Dropdown-->ACH Process-->ACH return-->Age to the store--->Default payment");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, SSN);
				ACSRLoginLogout.logout();
				
				AQCAdminLoginLogout.login(SSN);
				JQCACHProcessing.ACHProcess(SSN);
				AQCAdminLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				JQCACHReturn.ACHReturn(SSN, SSN);				
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);
				
			/*	ACSRLoginLogout.login(SSN, AppURL);
				MT_ACHPayment.AchPayment(SSN, SSN);
				ACSRLoginLogout.logout();*/

			
			}
		}
	}
	//PDL MultiTendertype
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void ACHPayment() throws Exception {
		FileName = "PDL_ACHPayment_MT.xls";
		test = reports.startTest("QC_PDL_ACHPayment_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->"
				+ "Age to due date-->Deposit Dropdown-->ACH Process-->ACH return-->ACH payment");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, SSN);
				ACSRLoginLogout.logout();
				
				AQCAdminLoginLogout.login(SSN);
				JQCACHProcessing.ACHProcess(SSN);
				AQCAdminLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				JQCACHReturn.ACHReturn(SSN, SSN);				
				ACSRLoginLogout.logout();
				
				
				
				ACSRLoginLogout.login(SSN, AppURL);
				MT_ACHPayment.AchPayment(SSN, SSN);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, SSN);
				ACSRLoginLogout.logout();

			
			}
		}
	}
	
	
	//PDL MultiTendertype
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void Prepayment() throws Exception {
		FileName = "PDL_PrePayment_MT.xls";
		test = reports.startTest("QC_PDL_Prepayment_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Age to due date-->"
				+ "Deposit Dropdown-->Age the sore-->PrePayment");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, SSN);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);
				
				ACSRLoginLogout.login(SSN, AppURL);
				QCPrePayment.prePayment(SSN, SSN);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, SSN);
				ACSRLoginLogout.logout();

			
			}
		}
	}


	
	//PDL MultiTendertype
			@Test(priority = 13, enabled=true, groups = "Anoop")
			public void NSFpayment() throws Exception {
				FileName = "PDL_NsfPayment_MT.xls";
				test = reports.startTest("QC_PDL__NSF Payment_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Age to due date--> "
						+ "Deposit Dropdown-->InternalTf cash management-->Check Return-->NsfPayment");

				TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow+1; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);

					if (RunFlag.equals("Y")) {
						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRNewLoanPage.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRACHDeposit.runscheduler(SSN, AppURL);

						ACSRLoginLogout.login(SSN, AppURL);
						JQCDepositDropdown.depositDropDown(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						AInternalTfAndCashManagement.internaltf(SSN, SSN);
						ACSRLoginLogout.logout();
						AQCAdminLoginLogout.login(SSN);
						JQCCSRReturnPosting.ReturnPosting(SSN, SSN);					
						AQCAdminLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						NSFpayment.nsfPayment(SSN, SSN);
						ACSRLoginLogout.logout();
						
						ACSRLoginLogout.login(SSN, AppURL);
						AQCCSRVoid.QcVoid(SSN, SSN);
						ACSRLoginLogout.logout();
						
						

					
					}
				}
			}
	
	//PDL MultiTendertype
		@Test(priority = 13, enabled=true, groups = "Anoop")
		public void BuyBack() throws Exception {
			FileName = "PDL_Buyback_MT.xls";
			test = reports.startTest("QC_PDL_BuyBack_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Age to due date-->BuyBack");

			TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow+1; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {
					//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					
					ACSRLoginLogout.login(SSN, AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					ACSRNewLoanPage.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					ACSRLoginLogout.login(SSN, AppURL);
					ACSRACHDeposit.runscheduler(SSN, AppURL);

					ACSRLoginLogout.login(SSN, AppURL);
					JQCCSRBuyBack.buyback(SSN, SSN);
					ACSRLoginLogout.logout();
					
					ACSRLoginLogout.login(SSN, AppURL);
					AQCCSRVoid.QcVoid(SSN, SSN);
					ACSRLoginLogout.logout();
					

				
				}
			}
		}
	
	//PDL MultiTendertype
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void PartialPayment() throws Exception {
		FileName = "QC_BorrowerRegistration_NewLoan.xls";
		test = reports.startTest("QC_PDL_PartialPayment_MultiTenderTypePayment","Login-->Home Screen-->Borrower Registration-->New Loan-->Payment with multiple tenders");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
			
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, SSN);
				ACSRLoginLogout.logout();

			
			}
		}
	}
//-----------------------------------------------------------------------------------------------------------------------------	
	
	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

		
		
			BufferedReader Areader;
			BufferedReader Jreader;

			try {
				Areader = new BufferedReader(
						
						new FileReader("C:/QC_Batch/QC_MultipleTenderType/src/test/java/tests/AObjects.properties"));
				Aprop = new Properties();
				Aprop.load(Areader);
				Areader.close();
				String Afilename = Aprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Aprop.getProperty("QC_Store_extent_report_path") + Afilename,
						true);

			}
			

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}
			try {
				Jreader = new BufferedReader(

						new FileReader("C:/QC_Batch/QC_MultipleTenderType/src/test/java/tests/JObjects.properties"));

				Jprop = new Properties();
				Jprop.load(Jreader);
				Jreader.close();
				String Jfilename = Jprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Jprop.getProperty("QC_Store_extent_report_path") + Jfilename,
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

			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			Thread.sleep(1000); // Allow OS to kill the process
			System.out.println("killed the process");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/FailedTestsScreenshots/"
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

			String screenshotPath =getScreenhot(driver, result.getName());
			// To add it in the extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
			
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");
		}
		
		
		reports.flush();
		driver.quit();

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
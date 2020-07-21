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
	public static Properties Sprop;
	public static Properties Vprop;
	public static String loan_number;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public static String Eankey = null;
	public static String encryption_store_no = null;
	public static String encryption_transaction_nbr = null;
	public static String FileName;
	public static ExcelNew TestData;
	public static String loan_nbr;
	//public static String NextDueDate = "05/23/2019";
	public static String NextDueDate;
	public static String AppURL;
	public static String BAdminURL;
	public static String AdminURL;
	public static String business_date;
	public static String No_of_Installments;
	public static String FirstName;
	public static String passwrd;
	public static String report_filename;
	public static String LastName;
	public static String ESign_CheckNbr;

	public static String ESign_CollateralType;

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
	public static String Statementdate;
	public static String Duedate_confirm_text3;

	public static String customer_number;

	public static String Drawer_OverShort_Amount; 
	public static String transaction_date;

	public static String Date1;

	public static String csr_url;

	public static String csrloginpage;

	public static String Date2;
	public static String Date3;

	public static String Password;

	public static String LOCamount;

	private static final String QCAdmin_Deceased = null;
	private static final QCCSRHistory VQC_LOC_History = null;

	public static String Bank_Status;

	public static String App_date1;

	public static String logout;

	private static Object rescind;

	public static String bstoreid="1253";
	public static String busername="csr1253";
	
	public static String vstoreid="508";
	public static String vusername="csr508";
	
	public static String nstoreid="581";
	public static String nusername="csr581";


    //@Test(priority = 1, groups = { "Samatha" })
	public static void LOC_ACHDeposit_EODs_Return_RedepositTxn() throws Exception {
		

			test = reports.startTest("LOC_ACHDeposit_EODs_Return_RedepositTxn",
					"Login->Borrower Registratino->New LOC Loan with ACH->Age to Due date->ACH Deposit->EOD->admin Portal Login->ACH Return->Redeposit->verify in ERM screen.");
			FileName = "LOC_ACHDeposit_EODs_Return_Redeposit_Txn" + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					SQCCSRNewLoan.newLoan(SSN,AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					System.out.println("first EOD"); // first EOD
					QCCSRLoginLogout.login(SSN, AppURL);
					AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

				     QCCSRLoginLogout.login(SSN, AppURL);
				    QCSafeAssign.safeAssign(SSN, AppURL);
				    //QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					JQCACHProcessing.achProcess(SSN, NextDueDate);
					QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminACHReturn.achreturn(SSN,AppURL);
					//QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.age1day(SSN,AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCRedeposit.redeposit(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
				
					

				}
			}
		}
    //@Test(priority = 2, groups = { "Samatha" })
	public static void LOC_ACHDep_EODs_Return_Redeposit_parpay() throws Exception {
		

			test = reports.startTest("LOC_ACHDep_EODs_Return_Redeposit_parpay",
					"Login->Borrower Registratino->New LOC Loan with ACH->Age to Due date->ACH Deposit->EOD->admin Portal Login->ACH Return->parpay->Redeposit->verify in ERM screen.");
			FileName = "LOC_ACHDep_EODs_Return_parpay_Redeposit" + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					SQCCSRNewLoan.newLoan(SSN,AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					System.out.println("first EOD"); // first EOD
					QCCSRLoginLogout.login(SSN, AppURL);
					AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					//QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					JQCACHProcessing.achProcess(SSN, NextDueDate);
					QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminACHReturn.achreturn(SSN,AppURL);
					//QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					SLOCPayments.payment(SSN,AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.age1day(SSN,AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCRedeposit.redeposit(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					

					

				}
			}
		}
    //@Test(priority = 3, groups = { "Samatha" })
	public static void LOC_ACHDep_EODs_Return_payoff_Redeposit() throws Exception {
		

			test = reports.startTest("LOC_ACHDep_EODs_Return_payoff_Redeposit",
					"Login->Borrower Registratino->New LOC Loan with ACH->Age to Due date->ACH Deposit->EOD->ACH Process->ACH Return->payoff->Redeposit->verify in ERM screen.");
			FileName = "LOC_ACHDep_EODs_Return_payoff_Redeposit" + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					SQCCSRNewLoan.newLoan(SSN,AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					JQCACHProcessing.achProcess(SSN, NextDueDate);
					QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminACHReturn.achreturn(SSN,AppURL);
					//QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					SLOCPayments.payment(SSN,AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					RedepositVerification.redepositVerify(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN,AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.age1day(SSN,AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCRedeposit.redeposit(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					}
			}
		}
   // @Test(priority = 5, groups = { "Samatha" })
	public static void LOC_ACHDep_EODs_Return_fullpay_Redeposit() throws Exception {
		

			test = reports.startTest("LOC_ACHDep_EODs_Return_Fullpay_Redeposit",
					"Login->Borrower Registratino->New LOC Loan with ACH->Age to Due date->ACH Deposit->EOD->ACH Process->ACH Return->Full payment->Redeposit->verify in ERM screen.");
			FileName = "LOC_ACHDep_EODs_Return_fullpay_Redeposit" + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					SQCCSRNewLoan.newLoan(SSN,AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					System.out.println("first EOD"); // first EOD
					QCCSRLoginLogout.login(SSN, AppURL);
					AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					JQCACHProcessing.achProcess(SSN, NextDueDate);
					QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminACHReturn.achreturn(SSN,AppURL);
					//QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					SLOCPayments.fullPayment(SSN,AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					RedepositVerification.redepositVerify(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
	}
        //@Test(priority = 6, groups = { "Samatha" })
		public static void LOC_ACHDep_Return_Eod_Redeposit() throws Exception {
			

				test = reports.startTest("LOC_ACHDep_Return_EOD_Redeposit",
						"Login->Borrower Registratino->New LOC Loan with ACH->Age to Due date->ACH Deposit->ACH Process->ACH Return->EOD->Redeposit->verify in ERM screen.");
				FileName = "LOC_ACHDeposit_Return_EOD_Redeposit" + ".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);

						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						SQCCSRNewLoan.newLoan(SSN,AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						System.out.println("first EOD"); // first EOD
						QCCSRLoginLogout.login(SSN, AppURL);
						AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
                        QCCSRLoginLogout.adminLogin(SSN, SSN);
						JQCACHProcessing.achProcess(SSN, NextDueDate);
						QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCAdminACHReturn.achreturn(SSN,AppURL);
						//QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);

						QCAdminStoreSetup.storeSetup(SSN, AppURL);
						QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

						QCCSRLoginLogout.login(SSN, AppURL);
						QCSafeAssign.safeAssign(SSN, AppURL);
						//QCCSRLoginLogout.login(SSN, AppURL);
						QCDrawerAssign.drawerAssign(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.age1day(SSN,AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCRedeposit.redeposit(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
					}
				}
		}
   // @Test(priority = 7, groups = { "Samatha" })// two EODS
	public static void LOC_ACHDep_EOD_Return_ACHdeposit_EOD_Return() throws Exception {
		

			test = reports.startTest("LOC_ACHDep_EOD_Return_ACHdeposit_EOD_Return",
					"Login->Borrower Registratino->New LOC Loan with ACH->Age to Due date->ACH Deposit->EOD->ACH Process->ACH Return->EOD->2nd due date->ACH Deposit->EOD->ACH Process->ACH Return->Redeposit->verify in ERM screen.");
			FileName = "LOC_ACHDeposit_Return_2EODs_Redeposit" + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+ FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					SQCCSRNewLoan.newLoan(SSN,AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					System.out.println("first EOD"); // first EOD
					QCCSRLoginLogout.login(SSN, AppURL);
					AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					
					
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					JQCACHProcessing.achProcess(SSN, NextDueDate);
					QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminACHReturn.achreturn(SSN,AppURL);
					//QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN,AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					//AgestoreDefault.ageStoreDueDate(SSN, SSN);
					AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					JQCACHProcessing.achProcess(SSN, NextDueDate);
					QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminACHReturn.achreturn(SSN,AppURL);
					//QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCRedeposit.redeposit(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
	 }
	    //@Test(priority = 8, groups = { "Samatha" })// two EODS
		public static void LOC_ACHDep_Return_EOD_ACHdeposit_Return_EOD() throws Exception {
			

				test = reports.startTest("LOC_ACHDep_Return_EOD_ACHdeposit_Return_EOD",
						"Login->Borrower Registratino->New LOC Loan with ACH->Age to Due date->ACH Deposit-->ACH Process->ACH Return->EOD->2nd due date->ACH Deposit->ACH Process->ACH Return->EOD->Redeposit->verify in ERM screen.");
				FileName = "LOC_ACHDep_Return_EOD_ACHdeposit_Return_EOD" + ".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);

						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						SQCCSRNewLoan.newLoan(SSN,AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						System.out.println("first EOD"); // first EOD
						QCCSRLoginLogout.login(SSN, AppURL);
						AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.adminLogin(SSN, SSN);
						JQCACHProcessing.achProcess(SSN, NextDueDate);
						QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCAdminACHReturn.achreturn(SSN,AppURL);
						//QCCSRLoginLogout.adminLogout(driver,SSN, SSN);

						QCCSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);

						QCAdminStoreSetup.storeSetup(SSN, AppURL);
						QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

						QCCSRLoginLogout.login(SSN, AppURL);
						QCSafeAssign.safeAssign(SSN, AppURL);
						
						
						QCDrawerAssign.drawerAssign(SSN, AppURL);

						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
					
						QCCSRLoginLogout.adminLogin(SSN, SSN);
						JQCACHProcessing.achProcess(SSN, NextDueDate);
						QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCAdminACHReturn.achreturn(SSN,AppURL);
						//QCCSRLoginLogout.adminLogout(driver,SSN, SSN);

						QCCSRLoginLogout.login(SSN, AppURL);
						AQCEODDeposit.eodDeposit(SSN, AppURL);

						QCAdminStoreSetup.storeSetup(SSN, AppURL);
						QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

						QCCSRLoginLogout.login(SSN, AppURL);
						QCSafeAssign.safeAssign(SSN, AppURL);
						//QCCSRLoginLogout.login(SSN, AppURL);
						QCDrawerAssign.drawerAssign(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCRedeposit.redeposit(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
					}
				}
		}
		//@Test(priority = 9, groups = { "Samatha" })// two EODS
	    public static void LOC_Payment_ACHDeposit() throws Exception {
		

		test = reports.startTest("LOC_Payment_ACHDeposit",
				"Login->Borrower Registratino->New LOC Loan with ACH->3days Age->Payment->ACH Deposit");
		FileName = "LOC_Payment_ACHDeposit" + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			
			if (RunFlag.equals("Y")) {

				// AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				System.out.println(AppURL);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				SQCCSRNewLoan.newLoan(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				
				QCCSRLoginLogout.login(SSN, AppURL);
			    QCAgetheStore.ageGracedays(SSN,AppURL);
			    QCCSRLoginLogout.login(SSN, AppURL);
				SLOCPayments.payment(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCDepositDropdown.depositDropDown(SSN, SSN);
				QCCSRLoginLogout.logout(SSN, AppURL);
			}
		}
	}
	//@Test(priority = 10, groups = { "Samatha" })// two EODS
	public static void LOC_Payment_2ndDuedate_ACHDeposit() throws Exception {
		test = reports.startTest("LOC_Payment_2ndDuedate_ACHDeposit",
				"Login->Borrower Registratino->New LOC Loan with ACH->3days Age->Payment->Age the store to 2nd due date->ACH Deposit");
		FileName = "LOC_Payment_2ndDuedate_ACHDeposit" + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				// AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				System.out.println(AppURL);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				SQCCSRNewLoan.newLoan(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				
				QCCSRLoginLogout.login(SSN, AppURL);
			    QCAgetheStore.ageGracedays(SSN,AppURL);
			    QCCSRLoginLogout.login(SSN, AppURL);
				SLOCPayments.fullPayment(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.age1day(SSN, SSN);
				QCCSRLoginLogout.login(SSN, AppURL);
				AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCDepositDropdown.depositDropDown(SSN, SSN);
				QCCSRLoginLogout.logout(SSN, AppURL);
			}
		}
	}
	@Test(priority = 11, groups = { "Samatha" })
	public static void LOC_Payoff_ageLastInst_ACHDeposit() throws Exception {
		test = reports.startTest("LOC_Payoff_ageLastInst_ACHDeposit",
				"Login->Borrower Registratino->New LOC Loan with ACH->3days Age->Payoff->Age the store to 2nd due date->ACH Deposit");
		FileName = "LOC_Payoff_lastDuedate_ACHDeposit" + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				// AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				System.out.println(AppURL);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				SQCCSRNewLoan.newLoan(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				
				QCCSRLoginLogout.login(SSN, AppURL);
			    QCAgetheStore.ageGracedays(SSN,AppURL);
			    QCCSRLoginLogout.login(SSN, AppURL);
				SLOCPayments.payment(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.age1day(SSN, SSN);
				QCCSRLoginLogout.login(SSN, AppURL);
				AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCDepositDropdown.depositDropDown(SSN, SSN);
				QCCSRLoginLogout.logout(SSN, AppURL);
			}
		}
		}
		@Test(priority = 12, groups = { "Samatha" })// two EODS
		public static void LOC_ACHDeposit_Return() throws Exception {
					

		test = reports.startTest("LOC_ACHDeposit_Return",
								"Login->Borrower Registratino->New LOC Loan with ACH->Age to Due date->ACH Deposit-->ACH Return");
		FileName = "LOC_ACHDeposit_Return" + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								// AppURL = TestData.getCellData(sheetName, "AppURL", row);
								String SSN = TestData.getCellData(sheetName, "SSN", row);

								System.out.println(AppURL);

								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								SQCCSRNewLoan.newLoan(SSN,AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								System.out.println("first EOD"); // first EOD
								QCCSRLoginLogout.login(SSN, AppURL);
								AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
								QCCSRLoginLogout.login(SSN, AppURL);
								QCDepositDropdown.depositDropDown(SSN, SSN);
								QCCSRLoginLogout.logout(SSN, AppURL);
								QCCSRLoginLogout.adminLogin(SSN, SSN);
								JQCACHProcessing.achProcess(SSN, NextDueDate);
								QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
								QCCSRLoginLogout.adminLogin(SSN, SSN);
								QCAdminACHReturn.achreturn(SSN,AppURL);
								
							}
						}
		}
		@Test(priority = 13, groups = { "Samatha" })
		public static void LOC_ACHDeposit_Return_Redeposit() throws Exception {
					

		test = reports.startTest("LOC_ACHDeposit_Return_Redeposit",
								"Login->Borrower Registratino->New LOC Loan with ACH->Age to Due date->ACH Deposit-->ACH Return");
		FileName = "LOC_ACHDeposit_Return_Redeposit" + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

						String sheetName = "Start";
						int lastrow = TestData.getLastRow("Start");
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							// System.out.println(RunFlag);
							if (RunFlag.equals("Y")) {

								// AppURL = TestData.getCellData(sheetName, "AppURL", row);
								String SSN = TestData.getCellData(sheetName, "SSN", row);

								System.out.println(AppURL);

								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								SQCCSRNewLoan.newLoan(SSN,AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								AgeStoreDueDate.ageStoreDueDate(SSN, SSN);
								QCCSRLoginLogout.login(SSN, AppURL);
								QCDepositDropdown.depositDropDown(SSN, SSN);
								QCCSRLoginLogout.logout(SSN, AppURL);
								QCCSRLoginLogout.adminLogin(SSN, SSN);
								JQCACHProcessing.achProcess(SSN, NextDueDate);
								QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
								QCCSRLoginLogout.adminLogin(SSN, SSN);
								QCAdminACHReturn.achreturn(SSN,AppURL);
								QCCSRLoginLogout.login(SSN, AppURL);
								QCAgetheStore.age1day(SSN, SSN);
								QCCSRLoginLogout.login(SSN, AppURL);
								QCRedeposit.redeposit(SSN, SSN);
								QCCSRLoginLogout.logout(SSN, AppURL);
								
							}
						}
		}
    @BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

			// prop=prop.getProperty("user.dir")+"/Tests/Objects.properties";
			BufferedReader reader;
			BufferedReader Jreader;
			BufferedReader Rreader;
			BufferedReader Areader;
			BufferedReader Sreader;
			BufferedReader Vreader;

			try {
				reader = new BufferedReader(
						new FileReader("C:/QC_Batch_Recon/QCH_ERM_ACH1/src/test/java/tests/Objects.properties"));

				prop = new Properties();
				prop.load(reader);
				reader.close();
				AppURL = prop.getProperty("CSR_URL");

				BAdminURL = prop.getProperty("ADMIN_CSR_URL");
				String Bfilename = Vprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";


				reports = new ExtentReports(
						System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + Bfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Jreader = new BufferedReader(
						new FileReader("C:/QC_Batch_reg/QCH_ERM_ACH1/src/test/java/tests/JObjects.properties"));
				Jprop = new Properties();
				Jprop.load(Jreader);
				Jreader.close();

				String Jfilename = Jprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				csr_url = prop.getProperty("CSR_URL");
				csrloginpage = prop.getProperty("Login_Page");
				
				AdminURL = prop.getProperty("ADMIN_URL");

				reports = new ExtentReports(
						System.getProperty("user.dir") + Jprop.getProperty("QC_Store_extent_report_path") + Jfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Rreader = new BufferedReader(
						new FileReader("C:/QC_Batch/QC_LOC/src/test/java/tests/RObjects.properties"));
				Rprop = new Properties();
				Rprop.load(Rreader);
				Rreader.close();
				csr_url = Rprop.getProperty("CSR_URL");
				csrloginpage = Rprop.getProperty("Login_Page");
				AdminURL = Rprop.getProperty("ADMIN_URL");
				String Rfilename = Rprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Rprop.getProperty("QC_Store_extent_report_path") + Rfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Areader = new BufferedReader(

						new FileReader("C:/QC_Batch/QC_LOC/src/test/java/tests/AObjects.properties"));

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
				Sreader = new BufferedReader(
						new FileReader("C:/QC_Batch_reg/QC_LOC/src/test/java/tests/SObjects.properties"));
				Sprop = new Properties();
				Sprop.load(Sreader);
				Sreader.close();
				String Sfilename = Sprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Sprop.getProperty("QC_Store_extent_report_path") + Sfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Vreader = new BufferedReader(
						new FileReader("C:/QC_Batch/QC_LOC/src/test/java/tests/VObjects.properties"));
				Vprop = new Properties();
				Vprop.load(Vreader);
				Vreader.close();
				csr_url = Vprop.getProperty("CSR_URL");
				csrloginpage = Vprop.getProperty("Login_Page");
				AdminURL = Vprop.getProperty("ADMIN_URL");
				String Vfilename = Vprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Vprop.getProperty("QC_Store_extent_report_path") + Vfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

		}

		catch (Exception e) {
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// setup for the QC Store " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to setup for the QC Store ");

		}

	}

	@BeforeMethod(alwaysRun = true)
	public void killProcess() throws Exception {

		try {

			//Runtime.getRuntime().exec("taskkill /IM iexplore.exe /F");
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			Thread.sleep(2000); // Allow OS to kill the process
			System.out.println("killed the IE process LOC process");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/LOC/FailedTestsScreenshots/"
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

	// @AfterMethod(alwaysRun = true)

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
		// System.out.println("startign of switch case");
		// System.out.println(obj);
		/*
		 * switch(loctype) { case "id": locator=By.id(locname); break; case
		 * "name": locator=By.name(locname); break; case "linkText":
		 * locator=By.linkText(locname); break; case "xpath":
		 * locator=By.xpath(locname); case "cssSelector":
		 * locator=By.cssSelector(locname); break; }
		 */

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

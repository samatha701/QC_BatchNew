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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCStore {

	public static WebDriverWait wait;
	public static WebDriver driver;
	public static WebDriver driver1;
	String appUrl;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());

	
	public static Properties Sprop;
	public static String loan_number;
	public static ExtentReports reports;
	public static ExtentReports Breports;
	public static ExtentReports Jreports;
	public static ExtentReports Rreports;
	public static ExtentReports Areports;
	public static ExtentTest test;
	// public static ExtentReports reports;
	// public static ExtentTest test;
	// static ExtentHtmlReporter htmlReporter;
	// static ExtentReports extent;
	public static String Eankey = null;
	public static String encryption_store_no = null;
	public static String encryption_transaction_nbr = null;
	public static String FileName;
	public static ExcelNew TestData;

	public static String loan_nbr;
	public static String NextDueDate;
	public static String AppURL = "https://qclocalreg.qfund.net/cc/demoIndex.do";
	//public static String business_date= "12/31/2018";
	public static String business_date;
	public static String No_of_Installments;
	public static String transaction_date;

	public static String ESign_CheckNbr;
	public static String Password;
	public static String ESign_CollateralType;
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
	public static int payment_no;
	public static String cust_doc_total_amount;
	public static String interest_page[] = new String [20];
	public static int increment;
	public static int totalrows;
	public static String cust_doc_interest;
	public static String Tran_Nbr;
	
	
	// -------- ILP ---------
    @Test(priority = 1,groups = "Samatha")

	public void ILP_ManualDefault_ChargeBack() throws Exception {

		FileName = "QC_Accounting_MDefault_ChargeBack_Txn_Testdata1.xls";
		test = reports.startTest("ILP_MDefault_ChargeBack","Login->Borrower Registration->New Loan->Payment->manualDefault->chargeback");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		//TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("/STestData_BiWeekly/QCStore/PDL/") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
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
				QCPayment.payment(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
			    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
			    QCCSRLoginLogout.logout(SSN, AppURL);
			    QCCSRLoginLogout.login(SSN, AppURL);
			    QCCSRDefaultPayment.defaultpayment(SSN, AppURL);
			    QCCSRLoginLogout.logout(SSN, AppURL);
			    QCCSRLoginLogout.login(SSN, AppURL);
			    Chargeback.chargeback(SSN, AppURL);
			    QCCSRLoginLogout.logout(SSN, AppURL);
			   
			    
			}
		}
	}
	@Test(priority = 2, groups = "Samatha")
	public void ILP_Default_ChargeBack() throws Exception {

		FileName = "ILP_Default_ChargeBack.xls";
		test = reports.startTest("ILP_Default_ChargeBack","Login->Borrower Registration->New Loan->Default->DefaultPayment->chargeback");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		//TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("/STestData_BiWeekly/QCStore/PDL/") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				AgestoreDefault.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.age1day(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				AgestoreDefault.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.age1day(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				AgestoreDefault.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.age1day(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRDefaultPayment.defaultpayment(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				Chargeback.chargeback(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				
			}
		}
	}
	
    //@Test(priority = 3, groups = "Samatha")//--->validation pending
	public void ILP_NewLoanPromotion_Buyback() throws Exception {

		FileName = "ILP_NewLoanPromotion_Buyback.xls";
		test = reports.startTest("ILP_NewLoanPromotion_Buyback","Login->Borrower Registration->New Loan->Payment->manualDefault->chargeback");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		//TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("/STestData_BiWeekly/QCStore/PDL/") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
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
				ILP_Payment.payment(SSN,AppURL);//Selected payoff in payment Screen
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
			}
		}
	}
	@Test(priority = 4 , groups ="Samatha")
    public void ILP_Manualdefault_Returnposting() throws Exception{
     
		FileName = "ILP_MDefault_ReturnPosting1.xls";
		test = reports.startTest("QC_ILP_DC_ReturnPosting","Login->Borrower Registration->New Loan->Payment->manualDefault->DefaulPayment->ReturnPosting");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
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
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
			    QCCSR_ILP_ManualDefault.manualdefault(SSN, AppURL);
			    QCCSRLoginLogout.logout(SSN, AppURL);
			    QCCSRLoginLogout.login(SSN, AppURL);
			    QCCSRDefaultPayment.defaultpayment(SSN, AppURL);
			    QCCSRLoginLogout.logout(SSN, AppURL);
			    try{
			    DBReturn.proc();
			    Thread.sleep(8000);
			    }
			    catch(Exception e){
			    	test.log(LogStatus.FAIL, "Failed due to db charge back proc ");
			    }
			    
				QCCSRLoginLogout.login(SSN, AppURL);
			    ReturnPosting.returnPosting(SSN, AppURL);
			    QCCSRLoginLogout.logout(SSN, AppURL);
			    
           }
		}
	}
    //  ------LOC-----
	//@Test(priority = 5 , groups ="Samatha")
    public void LOC_PaymentWith_ChangeAmount() throws Exception{
     
		FileName = "LOC_PaymentWith_ChangeAmount.xls";
		test = reports.startTest("LOC_PaymentWith_ChangeAmount","Login->Borrower Registration->New Loan->Statement1->aging the store->second statement generated->Partial payment with change amount");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoanLOC.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCPaymentLoc.payment(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.age1day(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCPaymentLoc.paymentWithChangeAmount(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.age60day(SSN, AppURL);
			
			}
		}
	}
	//@Test(priority = 6 , groups ="Samatha")
    public void LOC_PartialPayment_ChargeBack() throws Exception{
     
		FileName = "LOC_PartialPayment_ChargeBack.xls";
		test = reports.startTest("LOC_PartialPayment_ChargeBack","Login->Borrower Registration->New Loan->aging the store 10days->partial payment withDC-->ChargeBack");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoanLOC.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.ageGracedays(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCPaymentLoc.payment(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				EppChargeBack.chargeback(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				//QCCSRLoginLogout.login(SSN, AppURL);
				
			}
		}
	}
    
    //@Test(priority = 7 , groups ="Samatha")
    public void DC_Bankrupt_Writeoff_Recovery() throws Exception{
     
		FileName = "DC_Bankrupt_Writeoff_Recovery.xls";
		test = reports.startTest("DC_Bankrupt_Writeoff_Recovery","Login->Borrower Registration->New Loan_with_DC-->Mark as default-->Payment_with_DC-->Mark as bankruptcy-->write off recovery with DC-");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoanLOC.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				try{
				DBReturn.proc();
				Thread.sleep(10000);
				}
				catch(Exception e){
					test.log(LogStatus.FAIL, "Failed due to db charge back proc ");
				}
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				try{
					DBReturn.proc();
					Thread.sleep(10000);
					}
				catch(Exception e){
						test.log(LogStatus.FAIL, "Failed due to db charge back proc ");
						}
				QCCSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				
			}
		}
	}
    //   ----PDL----completed 
    @Test(priority = 8 , groups ="Samatha")
    public void DC_EPP_ChargeBack() throws Exception{
     
		FileName = "DC_EPP_ChargeBack.xls";
		test = reports.startTest("DC_EPP_ChargeBack","Login->Borrower Registration->New Loan_with_DC-->EPP_Payment_with_DC-->ChargeBack");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCStoreEPP.epp(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QC_EPPPayment.epppayment(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				EppChargeBack.chargeback(SSN, AppURL);
			    QCCSRLoginLogout.logout(SSN, AppURL);
			    }
		 }
	}
 //----------------------------------------------------------------------------
   //Brahmith
   @Test(priority = 9, groups = "Samatha")
   public static void Txn1_Recon_ILP_Debit_Card_Variance_scenario() throws Exception {
		

			test = reports.startTest(Sprop.getProperty("Recon_ILP_Debit_Card_Variance_scenario"),
					"New ILP Loan->Age the store after Rescind period->Refinance");

			FileName = Sprop.getProperty("Recon_ILP_Debit_Card_Variance_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);
					
					/*QCCSRLoginLogout.adminLogin(SSN, SSN);
					BAdminStartDate.toStartdate(SSN, SSN);
					QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
					BProc3.proc();*/

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					BGracedays_Loan.duedate(SSN, SSN);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCRefinance.refinance(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCHistoryold.history(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCHistoryNew.history(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
		
				}
			}
		
	}

	@Test(priority = 10, groups = "Samatha")
    public static void Txn3_4_Reverse_and_Reallocation() throws Exception{
		
			test = reports.startTest((Sprop.getProperty("Reverse_and_Reallocation_scenario")),
					"While posting chargeback transaction for current / DLQ customers Checking Reverse and reallocation");

			FileName = Sprop.getProperty("Reverse_and_Reallocation_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
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
					BDueDate_Loan.duedate(SSN, SSN);
					
					for(payment_no=1;payment_no<=5;payment_no++)
					{
						QCCSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						BDueDate_Loan.duedate(SSN, SSN);
					
					}
					
					QCCSRLoginLogout.login(SSN, AppURL);
					Chargeback.chargeback(SSN, SSN);
					
					Thread.sleep(20000);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					RRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					try{
						
					ChargebackQuery.proc();
					
					}
					catch(Exception e){
						test.log(LogStatus.FAIL, "Failed due to db charge back proc ");
					}
					}
				}
			}
		
	@Test(priority = 11, groups = "Samatha")  //Issue in Writeoff

	public static void Txn5_WriteOff() throws Exception {
		
			
			test = reports.startTest((Sprop.getProperty("WriteOff_scenario")),
					"Write-Off - After write-off, if any payment returned/chargeback");

			FileName = Sprop.getProperty("WriteOff_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

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
					BDueDate_Loan.duedate(SSN, SSN);
					//QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);		
					
					QCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					
					QCCSRLoginLogout.login(SSN, AppURL);
					BGracedays_Loan.duedate(SSN, SSN);
					
					try{//QCCSRLoginLogout.logout(SSN, AppURL);
					DBReturn1.proc();
					Thread.sleep(10000);
					DBverify1.proc();
					Thread.sleep(10000);
					}
					catch(Exception e){
						test.log(LogStatus.FAIL, "Failed due to db charge back proc ");
					}
						QCCSRLoginLogout.login(SSN, AppURL);
						AgestoreDefault.ageStoreDueDate(SSN,AppURL);
					
					
					QCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
										
					//QCCSRLoginLogout.login(SSN, AppURL);
					//Chargeback.chargeback(SSN, SSN);
					//QCCSRLoginLogout.logout(SSN, AppURL);
					//Need to check here by adding due date
					/*			
						DBReturn.proc();
					DBverify.proc();
					
								//QCCSRLoginLogout.login(SSN, AppURL);
					//BGracedays_Loan.duedate(SSN, SSN);
					//QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					
					
					
					//QCCSRLoginLogout.login(SSN, AppURL);
					//BGracedays_Loan.duedate(SSN, SSN);
					//QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
		
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDefaultPayment.sdefaultpayment(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
			
						QCCSRLoginLogout.login(SSN, AppURL);

					
					QCCSRWriteOff.writeoff(SSN, SSN);
				QCCSRLoginLogout.login(SSN, AppURL);
					BGracedays_Loan.duedate(SSN, SSN);
					//QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					Chargeback.chargeback(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					*/
					
					}
			}
		}
       @Test(priority = 12, groups = "Samatha")  //NSF checkbox issue , Development  completed

	    public static void Txn6_Recon_CashRoll() throws Exception {
		
			
			test = reports.startTest((Sprop.getProperty("Recon_CashRoll_FEE_scenario")),
					"New Loan->Age the store date to Due date->DC Deposit->Return DC Deposit->NSF Payment");

			FileName = Sprop.getProperty("Recon_CashRoll_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

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
					QCCSRNewLoan_pdl.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					BDueDate_Loan.duedate(SSN, SSN);
				
					QCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdownPDL.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					BGracedays_Loan.duedate(SSN, SSN);
				    try{
					DBReturn1.proc();
					Thread.sleep(8000);
					DBverify1.proc();
					Thread.sleep(10000);
				    }
				    catch(Exception e){
				    	test.log(LogStatus.FAIL, "Failed due to db charge back proc ");
				    }
					QCCSRLoginLogout.login(SSN, AppURL);
					AQC_NSFPayment.nsfpayment(SSN, SSN);
					
		
				}
			}
		}
       @Test(priority = 13, groups = { "Samatha" })
	   public static void Txn11_EPP() throws Exception {
		
			test = reports.startTest("EPP",
					"In Payment Plan, while doing installment check deposit,the tran ID is being stored as DP instead of PPay");

			FileName = Sprop.getProperty("EPP_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = 12;
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					BDueDate_Loan.duedate(SSN, SSN);
				
					QCCSRLoginLogout.login(SSN, AppURL);
					QCStoreEPP.epp(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					BDueDate_Loan.duedate(SSN, SSN);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					SQLquery.proc();	
					
					
	
					break;
				}
			}
		}

   @Test(priority = 14, groups = "Samatha2")

	public static void Txn8_Recon_ILP_EARNED_FEE_Variance() throws Exception {
		

			test = reports.startTest(Sprop.getProperty("Recon_ILP_EARNED_FEE_Variance_scenario"),
					"New ILP Loan->Age the store after Rescind period->Refinance");

			FileName = Sprop.getProperty("Recon_ILP_EARNED_FEE_Variance_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
		
				if (RunFlag.equals("Y")) {
                   String SSN = TestData.getCellData(sheetName, "SSN", row);

					QCCSRLoginLogoutTX.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogoutTX.login(SSN, AppURL);
					QCCSRNewLoanTX.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogoutTX.login(SSN, AppURL);
					BGracedays_Loan.duedate(SSN, SSN);
					
					QCCSRLoginLogoutTX.login(SSN, AppURL);
					RefinanceTX.refinance(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					
		
			}
	}
}
    // ------Check Cashing-------
    ////@Test(priority = 15 , groups ="Samatha")
    public void CC_Return_Nsf_fullPayment_chargeBack() throws Exception{
    FileName = "CC_Return_Nsf_fullPayment_ChargeBack.xls";
		test = reports.startTest("DC_EPP_ChargeBack","Login->Borrower Registration->New Loan_with_DC-->Deposit Return-->Nsf fullpay-->ChargeBack");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				
				
				
				
				
				
				
			}
		}
	}
    //@Test(priority = 16 , groups ="Conv1")//--->completed
    public void ILP_PDL_Conversion() throws Exception{
     
		FileName = "ILP_PDL_Conversion.xls";
		test = reports.startTest("ILP_PDL_Conversion","Login->Borrower Registration->ILP_New Loan->Payment->PDL_New Loan-->");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.ageGracedays(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRILPConversion.conversion(SSN,AppURL);
			}
		}
  }
    //@Test(priority = 17 , groups ="Conv1")//--->completed
    public void Void_ILP_PDL_Conversion() throws Exception{
     
		FileName = "Void_ILP_PDL_Conversion.xls";
		test = reports.startTest("Void_ILP_PDL_Conversion","Login->Borrower Registration->ILP_New Loan->Payment->PDL_New Loan-->pdl to ilp conversion-->void consolidated loan");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.ageGracedays(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRILPConversion.conversion(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				AQCVoid.qcVoid(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
			}
		}
  }
    @Test(priority = 18, groups ="Conv1")//--->completed
    public void Void_Conversion_UsingEncryption() throws Exception{
     
		FileName = "Void_Conversion_UsingEncryption.xls";
		test = reports.startTest("Void_Conversion_UsingEncryption","Login->Borrower Registration->ILP_New Loan->Payment->PDL_New Loan-->pdl to ilp conversion-->void consolidated loan");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.ageGracedays(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRILPConversion.conversion(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.age1day(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgestorevoid.encryptionVoid(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				ConversionHistory.history(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
			}
		}
  }
    @Test(priority = 19 , groups ="Cof")//--->completed
    public void PDL_Deposit_Cardonfile() throws Exception{
     
		FileName = "PDL_Deposit_CardOnFile.xls";
		test = reports.startTest("PDL_Deposit_CardOnFile","Login->Borrower Registration->ILP_New Loan->Deposit->Card on file");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				CardOnFile.cardOnFile(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				try{
					DBReturn.depositScheduler();
					DBverify.proc();
					}
				catch(Exception e)
				{
					test.log(LogStatus.PASS," deposit scheduler failed");
				}
			}
		}
    }
    @Test(priority = 20 , groups ="Cof")//--->completed
    public void ILP_Deposit_Cardonfile() throws Exception{
     
		FileName = "ILP_Deposit_CardOnFile.xls";
		test = reports.startTest("ILP_Deposit_CardOnFile","Login->Borrower Registration->ILP_New Loan->Deposit->Card on file");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
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
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				CardOnFile.cardOnFile(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				
				try{
					DBReturn.depositScheduler();
					DBverify.proc();
					}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, " deposit scheduler failed");
				}
			}
		}
    }
    @Test(priority = 21 , groups ="Cof")//--->completed
    public void TLP_Deposit_Cardonfile() throws Exception{
     
		FileName = "TLP_Deposit_CardOnFile.xls";
		test = reports.startTest("TLP_Deposit_CardOnFile","Login->Borrower Registration->TLP_New Loan->Deposit->Card on file");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSR_TLPNewLoan.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				CardOnFile.cardOnFile(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				try{
					DBReturn.depositScheduler();
					DBverify.proc();
					}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, " deposit scheduler failed");
				}
			}
		}
    }
    //@Test(priority = 22 , groups ="Cof")//--->completed
    public void PDLNewLoan_Cancel_RollBack() throws Exception{
     
		FileName = "PDL_Cancel_RollBack.xls";
		test = reports.startTest("PDLNewLoan_Cancel_RollBack","Login->Borrower Registration->PDL_New Loan->Cancel-->RollBack");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.rescind(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				/*QCCSRLoginLogout.login(SSN, AppURL);
				QCPayment_PDL.payment(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);*/
			}
		}
    }
    //@Test(priority = 23 , groups ="Cof")
    public void PDLNewLoan_Cancel_RollBack_CabRtn() throws Exception{
        
		FileName = "PDL_Cancel_RollBack _CabRtn.xls";
		test = reports.startTest("PDLNewLoan_Cancel_RollBack_CabRtn","Login->Borrower Registration->PDL_New Loan->Cancel-->RollBack-->CabReturn");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.ageGracedays(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCPayment_PDL.payment(SSN,AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				
				QCCSRLoginLogout.login(SSN, AppURL);
				QCRefinanceNew.refinance(SSN,AppURL);
	            QCCSRLoginLogout.logout(SSN, AppURL);
				
			}
		}
    }
    @Test(priority = 23 , groups ="Cofa")
    public void TXPDL_LateFee_ACHDeposit() throws Exception{
        
		FileName = "TXPDL_LateFee_ACHDeposit.xls";
		test = reports.startTest("TXPDL_LateFee_ACHDeposit","Login->Borrower Registration->PDL_New Loan->age the store to due date-->age store 12days->LateFee-->Deposit");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.ageGracedays(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				LateFeeDeposit.deposit(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.adminLogin(SSN, SSN);
				QCACHProcessing.achProcess(SSN, NextDueDate);
				QCCSRLoginLogout.adminLogout(driver,SSN, SSN);
				QCCSRLoginLogout.adminLogin(SSN, SSN);
				QCAdminACHReturn.achreturn(SSN,AppURL);
			}
		}
    }
   @Test(priority = 24 , groups ="Cof1")
    public void TXPDL_LateFee_DCDeposit_Rtrn() throws Exception{
        
		FileName = "TXPDL_LateFee_DCDeposit.xls";
		test = reports.startTest("TXPDL_LateFee_DCDeposit_Rtrn","Login->Borrower Registration->PDL_New Loan->age the store to due date-->age store 12days->LateFee-->Deposit");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.ageGracedays(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				LateFeeDeposit.deposit(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				try{
				    DBReturn.proc();
				    Thread.sleep(8000);
				    }
				    catch(Exception e){
				    	test.log(LogStatus.FAIL, "Failed due to db charge back proc ");
				    }
			}
		}
    }
   @Test(priority = 25 , groups ="Cof1")
    public void TXPDL_LateFee_DCBuyback() throws Exception{
        
		FileName = "TXPDL_LateFee_DCBuyback.xls";
		test = reports.startTest("TXPDL_LateFee_DCBuyback","Login->Borrower Registration->PDL_New Loan->age the store to due date-->age store 12days->LateFee-->Buyback");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.ageGracedays(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				LateFeeBuyback.lateFee(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
			}
		}
    }
    @Test(priority = 26 , groups ="Cof1")
    public void TXPDL_LateFee_waiveLateFee_Buyback() throws Exception{
        
		FileName = "TXPDL_LateFee_waveLateFee_Buyback.xls";
		test = reports.startTest("TXPDL_LateFee_waiveLateFee_DCBuyback","Login->Borrower Registration->PDL_New Loan->age the store to due date-->age store 12days->LateFee-->wave latefee--> Buyback");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.ageGracedays(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				VQCSRWaiveFee.WaiveFeeFull(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				LateFeeBuyback.waiveFee(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
			}
		}
    }
    @Test(priority = 27 , groups ="Cof1")
    public void TXPDL_LateFee_waiveLateFee_ACHBuyback() throws Exception{
        
		FileName = "TXPDL_LateFee_waveLateFee_ACHBuyback.xls";
		test = reports.startTest("TXPDL_LateFee_waiveLateFee_ACHBuyback","Login->Borrower Registration->PDL_New Loan With ACH->age the store to due date-->age store 12days->LateFee-->wave latefee--> Buyback");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.ageGracedays(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				VQCSRWaiveFee.WaiveFeeFull(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				LateFeeBuyback.waiveFee(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
			}
		}
    }
  @Test(priority = 28 , groups ="Cof1") 
  public void TXPDL_LateFee_ACHBuyback() throws Exception{
        
		FileName = "TXPDL_LateFee_ACHBuyback.xls";
		test = reports.startTest("TXPDL_LateFee_ACHBuyback","Login->Borrower Registration->PDL_New Loan->age the store to due date-->age store 12days->LateFee-->Buyback");

		TestData = new ExcelNew(System.getProperty("user.dir") + Sprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				QCCSRLoginLogout.login(SSN, AppURL);
				QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan_pdl.newLoan(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgetheStore.ageGracedays(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				LateFeeBuyback.lateFee(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
			}
		}
    }
	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

			BufferedReader reader;
			BufferedReader Jreader;
			BufferedReader Rreader;
			BufferedReader Areader;
			BufferedReader Vreader;
			BufferedReader Sreader;

			

			try {
				Sreader = new BufferedReader(new FileReader("C:/QC_Batch_Recon/QC_Accounting_Scenarios/src/test/java/tests/SObjects.properties"));

				Sprop = new Properties();
				Sprop.load(Sreader);
				Sreader.close();
				AppURL = Sprop.getProperty("CSR_URL");
				csrloginpage = Sprop.getProperty("Login_Page");
				AdminURL = Sprop.getProperty("ADMIN_CSR_URL");
				
				
				String Sfilename = Sprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Sprop.getProperty("QC_Store_extent_report_path") + Sfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

		

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
			//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/MicrosoftWebDriver.exe");

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
			System.out.println("killed the process PDL scenarios");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/PDL/FailedTestsScreenshots/"
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
		else if (loctype.equalsIgnoreCase("className"))
			return locator = By.className(locname);
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

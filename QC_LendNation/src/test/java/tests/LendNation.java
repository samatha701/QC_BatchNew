package tests;

import org.testng.annotations.Test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*import Pages.LendNationCSR;
import Pages.LendNationFinancialInformation;
import Pages.LendNationLogin;
import Pages.LendNationPersonalInformation;
import Pages.LendNationRegistration;
import Pages.LendNationRepaymentInformation;
import Pages.LendNationSignContract;
import Pages.LendNationSubmitApplication;*/
//import Utilities.ExtentReports.Excel;
//import Utilities.ExtentReports.Excel;

import tests.LendNationRegistration;




import tests.ExcelNew;

public class LendNation {
	
	public static WebDriverWait wait;	
	public static WebDriver driver;	
	public static com.relevantcodes.extentreports.ExtentReports reports;
	public static com.relevantcodes.extentreports.ExtentTest test;
	String appUrl;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	public static ExcelNew TestData;
	public static String AppURL;
	public static String csr_url;
	public static String AdminURL;
	public static String csrloginpage;
	
	
	
	

	public static Properties prop;
	public static String loan_number;
	public static String Proc_Date;
	public static String App_Due_Date;
	public static String Loan_Date;
	public static String Due_Date;
	
	
	
	//static ExtentHtmlReporter htmlReporter;
	//static ExtentReports extent;
	//ExtentTest logger;
	
	
	
	
	//Extent 3.0.3 logging
	//ExtentHtmlReporter htmlReporter;
	//ExtentReports extent;
	//ExtentTest logger;

	
  @Test(priority=0, groups={"Samatha"} )
  public static void LendNation_ACH_SimpleLoan() throws Exception {
	
	  
	  try {
			test = reports.startTest(("QC Online - ACH Normal Loan"),
					"Generate Loan-->Approved Loan in PAM-->Finish Loan");
			String FileName = "ACH_Simple_Loan.xls";
			// String FileName=
			// Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("Test_data_sheet_path") + FileName);

			// test=reports.startTest("Lend Nation Smoke_testing","Lend Nation
			// Application test report");

			// String FileName= "Registration_Lend_Nation.xls";
			// Excel TestData = new
			// ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
			// int lastrow=TestData.getLastRow("Start");
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					// driver.get(appUrl);
					// test.log(LogStatus.INFO, "Application is launched");
					// driver.manage().window().maximize();
					// String AppURL =
					// TestData.getCellData(sheetName,"AppURL",row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
//==========================================================================================================				
				
				
				/*for(int i=0; i<=10; i++)
				{
					LendNationLogin.login();
					Thread.sleep(2000);
					test.log(LogStatus.PASS, "Page refreshed");
					
				}*/
				
				
				System.out.println(loan_number);
				
				LendNationRegistration.registration(SSN, AppURL);
				LendNationPersonalInformation.personalInformation(SSN, AppURL);
			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
				LendNationLoanDecision.loandecision(SSN, AppURL);			    
			            //LendNationSubmitApplication.submitApplication(SSN, AppURL);
			    LendNationSignContract.signContract(SSN, AppURL);
				
				
				
			                 //QCCSRLoginLogout.login(SSN, AppURL);
							/*QCCSRLoginLogout.PAMLogin(SSN, AppURL);
							LendNationCSR.SimpleNewLoan(SSN, AppURL, loan_number);
							LendNationCSR.PAM(SSN, AppURL, loan_number);
							QCCSRLoginLogout.logout(SSN, AppURL);*/
			    
				          //OnlineLogin.login(SSN, AppURL);	
				QCCSRLoginLogout.PAMLogin(SSN, AppURL);
				          //EditLoan_Esign_PAMLoanApproval.pamloanapproval(SSN, AppURL, SSN);
				EditLoan_Esign_PAMLoanApproval.PAM_ACH(SSN, AppURL, loan_number);
				QCCSRLoginLogout.logout(SSN, AppURL);
	
				
				break;
				
  }
  }
  }
  
	  catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "ACH_Loan");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}
  
  
  //@Test(priority=1)
  public static void LendNation_ACH_EditLoan() throws Exception {
	
	  
	  try {
			test = reports.startTest(("QC Online - ACH Edited Loan"),
					"Generate Loan-->Change Loan Amount in PAM-->Login LendNation with Email-->Complete Esign-->Approved Loan in PAM-->Finish Loan");
			String FileName = "ACH_Edit_Loan.xls";
			// String FileName=
			// Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("Test_data_sheet_path") + FileName);

			// test=reports.startTest("Lend Nation Smoke_testing","Lend Nation
			// Application test report");

			// String FileName= "Registration_Lend_Nation.xls";
			// Excel TestData = new
			// ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
			// int lastrow=TestData.getLastRow("Start");
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					// driver.get(appUrl);
					// test.log(LogStatus.INFO, "Application is launched");
					// driver.manage().window().maximize();
					// String AppURL =
					// TestData.getCellData(sheetName,"AppURL",row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
//==========================================================================================================				
				System.out.println(AppURL);
				
				/*for(int i=0; i<=10; i++)
				{
					LendNationLogin.login();
					Thread.sleep(2000);
					test.log(LogStatus.PASS, "Page refreshed");
					
				}*/
				
				
				System.out.println(loan_number);
				
				LendNationRegistration.registration(SSN, AppURL);
				LendNationPersonalInformation.personalInformation(SSN, AppURL);
			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
				LendNationLoanDecision.loandecision(SSN, AppURL);			    			            
			    LendNationSignContract.signContract(SSN, AppURL);
	
			    
	     
				QCCSRLoginLogout.PAMLogin(SSN, AppURL);	
				//EditLoan_Esign_PAMLoanApproval.PAM_ACH(SSN, RunFlag, SSN);
				EditLoan_Esign_PAMLoanApproval.PAM_ACH(SSN, AppURL, loan_number);
				QCCSRLoginLogout.logout(SSN, AppURL);
	
	            OnlineLogin.login(SSN, AppURL);
	
			    QCCSRLoginLogout.PAMLogin(SSN, AppURL);	        
			    AfterEditLoan_LoanApproved.afteredit_loanapproved(SSN, AppURL, loan_number);
			    QCCSRLoginLogout.logout(SSN, AppURL);
			
			    QCCSRLoginLogout.login(SSN, AppURL);
			    EditLoan_Esign_PAMLoanApproval.pamloanapproval(SSN, AppURL, loan_number);
			    QCCSRLoginLogout.logout(SSN, AppURL);
	
				
				break;
				
  }
  }
  }
  
	  catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "ACH_Loan");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}
  
  
  
  
  //@Test(priority=2)
  public static void LendNation_CashtoStore_SimpleLoan() throws Exception {
	
	  try {
			test = reports.startTest(("QC Online - Cash to Store Normal Loan"),
					"Generate Loan-->Approved Loan in PAM-->Login CSR-->Finish Loan in Cash to Store");
			String FileName = "CashtoStore_Simple_Loan.xls";
			// String FileName=
			// Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("Test_data_sheet_path") + FileName);

			// test=reports.startTest("Lend Nation Smoke_testing","Lend Nation
			// Application test report");

			// String FileName= "Registration_Lend_Nation.xls";
			// Excel TestData = new
			// ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
			// int lastrow=TestData.getLastRow("Start");
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					// driver.get(appUrl);
					// test.log(LogStatus.INFO, "Application is launched");
					// driver.manage().window().maximize();
					// String AppURL =
					// TestData.getCellData(sheetName,"AppURL",row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);		
//=======================================================================================				
				System.out.println(loan_number);
				
				LendNationRegistration.registration(SSN, AppURL);
				LendNationPersonalInformation.personalInformation(SSN, AppURL);
			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
				LendNationLoanDecision.loandecision(SSN, AppURL);			    
			            //LendNationSubmitApplication.submitApplication(SSN, AppURL);
			    LendNationSignContract.signContract(SSN, AppURL);
																																																						    			    
	         
	            QCCSRLoginLogout.PAMLogin(SSN, AppURL);	        
	                     //EditLoan_Esign_PAMLoanApproval.PAM_CashtoStore(SSN, AppURL, SSN);	
	            EditLoan_Esign_PAMLoanApproval.PAM_CashtoStore(SSN, AppURL, loan_number);
	            QCCSRLoginLogout.logout(SSN, AppURL);
	
	            QCCSRLoginLogout.login(SSN, AppURL);
	                   //EditLoan_Esign_PAMLoanApproval.pamloanapproval(SSN, AppURL, SSN);
	            EditLoan_Esign_PAMLoanApproval.pamloanapproval(SSN, AppURL, loan_number);
	            QCCSRLoginLogout.logout(SSN, AppURL);
			    
			    
			    
			  
				
				break;
				
  }
  }
  }
	  catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "CashtoStore_Loan");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}
 
  //@Test(priority=3)
  public static void LendNation_CashtoStore_EditLoan() throws Exception {
	  

	  
	  try {
			test = reports.startTest(("QC Online - Cash to Store Edit Loan Amount"),
					"Generate Loan-->Change Loan Amount in PAM-->Login LendNation with Email-->Complete Esign-->Approved Loan in PAM-->Login CSR-->Finish Loan");
			String FileName = "CashtoStore_Edit_Loan.xls";
			// String FileName=
			// Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("Test_data_sheet_path") + FileName);

			// test=reports.startTest("Lend Nation Smoke_testing","Lend Nation
			// Application test report");

			// String FileName= "Registration_Lend_Nation.xls";
			// Excel TestData = new
			// ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
			// int lastrow=TestData.getLastRow("Start");
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					// driver.get(appUrl);
					// test.log(LogStatus.INFO, "Application is launched");
					// driver.manage().window().maximize();
					// String AppURL =
					// TestData.getCellData(sheetName,"AppURL",row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
//================================================================================
				System.out.println(loan_number);
				
				LendNationRegistration.registration(SSN, AppURL);
				LendNationPersonalInformation.personalInformation(SSN, AppURL);
			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
				LendNationLoanDecision.loandecision(SSN, AppURL);			    
			            //LendNationSubmitApplication.submitApplication(SSN, AppURL);
			    LendNationSignContract.signContract(SSN, AppURL);
																																																						    			    
	         
	            QCCSRLoginLogout.PAMLogin(SSN, AppURL);	        
	            EditLoan_Esign_PAMLoanApproval.PAM_CashtoStore(SSN, AppURL, loan_number);   
	            QCCSRLoginLogout.logout(SSN, AppURL);
				
				OnlineLogin.login(SSN, AppURL);
				
				System.out.println(loan_number);
				
			    QCCSRLoginLogout.PAMLogin(SSN, AppURL);	        
			    AfterEditLoan_LoanApproved.afteredit_loanapproved(SSN, AppURL, loan_number);
	            QCCSRLoginLogout.logout(SSN, AppURL);
          
	            QCCSRLoginLogout.login(SSN, AppURL);
	            EditLoan_Esign_PAMLoanApproval.pamloanapproval(SSN, AppURL, loan_number);
	            QCCSRLoginLogout.logout(SSN, AppURL);
			    
			    
			    
			  
				
				break;
				
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "CashtoStore_Edit_Loan");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}
				
/*  }
  }
  }
  */
 
  
  //===============================  OnLine Accounting Scenarios  ==================================================
  
  //@Test(priority=4)
  public static void QC_Accounting_OnlineRefinance_CabReturn_ACHDeposit_Return() throws Exception {
	
	  
	  try {
			test = reports.startTest(("QC Online Loan-->Grace Days-->Refinance-->Due Date-->Deposit-->Return"),
					"Generate Loan-->Approved Loan in PAM-->Finish Loan");
			String FileName = "QC_Accounting_OnlineRefinance_CabReturn_ACHDeposit_Return_Txn_Testdata.xls";
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("Test_data_sheet_path") + FileName);

			
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
				System.out.println(AppURL);
				
			
				
				System.out.println(loan_number);
				
				LendNationRegistration.registration(SSN, AppURL);
				LendNationPersonalInformation.personalInformation(SSN, AppURL);
			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
				LendNationLoanDecision.loandecision(SSN, AppURL);			    			            
			    LendNationSignContract.signContract(SSN, AppURL);
				          
				QCCSRLoginLogout.PAMLogin(SSN, AppURL);				         
				EditLoan_Esign_PAMLoanApproval.PAM_ACH(SSN, AppURL, loan_number);
				    //QCCSRLoginLogout.logout(SSN, AppURL);
				
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRLoginLogout.ageStoreGraceDays(SSN, SSN);
				
				OnlineLogin.refinance(SSN, AppURL);
				
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRLoginLogout.ageStoreDueDate(SSN, SSN);
				
				
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSR_Deposit.deposit(SSN, AppURL);
												
				QCCSRReturnPosting.returnposting(SSN, AppURL);
				
				QCAdminACHReturn.achreturn(SSN, AppURL);
				
				/*QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);*/
			
				/*QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRLoginLogout.ageStoreDueDate(SSN, SSN);*/
				
				//OnlineLogin.login(SSN, AppURL);
				
				break;
				
  }
  }
  }
  
	  catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Accounting_OnlineRefinance_CabReturn_ACHDeposit_Return");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}
  
  @Test(priority=5)
  public static void QC_Accounting_OnlineAdvance_LateFee_Deposit_Txn_Testdata() throws Exception {
	
	  
	  try {
			test = reports.startTest(("QC Online Loan-->Due Date-->-->10days grace days-->Deposit"),
					"Generate OnLineLoan-->Approved Loan in PAM-->Due Date-->10days grace days-->Deposit");
			String FileName = "QC_Accounting_OnlineAdvance_LateFee_Deposit_Txn_Testdata.xls";
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("Test_data_sheet_path") + FileName);

			
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
				System.out.println(AppURL);
				
			
				
				System.out.println(loan_number);
				
				LendNationRegistration.registration(SSN, AppURL);
				LendNationPersonalInformation.personalInformation(SSN, AppURL);
			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
				LendNationLoanDecision.loandecision(SSN, AppURL);			    			            
			    LendNationSignContract.signContract(SSN, AppURL);
				          
				QCCSRLoginLogout.PAMLogin(SSN, AppURL);				         
				EditLoan_Esign_PAMLoanApproval.PAM_ACH(SSN, AppURL, loan_number);
				    //QCCSRLoginLogout.logout(SSN, AppURL);
				
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRLoginLogout.ageStoreDueDate(SSN, SSN);
				
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRLoginLogout.ageStoreGraceDays(SSN, SSN);										
				
				QCCSRLoginLogout.login(SSN, AppURL);
				QCCSR_Deposit.deposit(SSN, AppURL);
																				
				/*QCCSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);*/
				
				break;
				
  }
  }
  }
  
	  catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Accounting_OnlineAdvance_LateFee_Deposit");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}
  
  
  
  
  
//=================================================================================================================== 
  @BeforeClass
  public void setup() throws IOException {	
		
		String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
		//Date D = new Date();		
		String filename="LendNation_"+timestamp+".html";
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
		
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/geckodriver.exe");

		//driver = new InternetExplorerDriver();	
		//driver = new FirefoxDriver();	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5000);	
		
		//prop=prop.getProperty("user.dir")+"/Tests/Objects.properties";
		BufferedReader reader;
		String propertyFilePath=("user.dir")+"/Objects.properties";
		
		//InputStream input = new FileInputStream("D:/QC_Workspace/AA_Automation/src/Tests/Objects.properties");
		//prop.load(input);
		//System.out.println(prop.getProperty("LendNation_URL"));
		
		try {
			//reader = new BufferedReader(new FileReader("D:/QC_Workspace/AA_Automation/src/Tests/Objects.properties"));
			reader = new BufferedReader(new FileReader("C:/QC_Batch/QC_LendNation/src/test/java/tests/Objects.properties"));

			prop = new Properties();
						try {
							prop.load(reader);
							reader.close();
							csr_url = prop.getProperty("CSR_URL");
							csrloginpage = prop.getProperty("Login_Page");
							AdminURL = prop.getProperty("ADMIN_URL");
						} 
						catch (IOException e) {
							e.printStackTrace();
							}
		  }
			catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
			}
		reports = new ExtentReports(System.getProperty("user.dir") +prop.getProperty("extent_report_path")+filename, true);
	
		
		//Extent reports added code
	/*	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +prop.getProperty("extent_report_path")+filename);
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "QTLSYS2-238");
		extent.setSystemInfo("Java Version", "1.8.0_171");
		extent.setSystemInfo("Environment", "Windows 7");


		extent.setSystemInfo("User Name", "Brahmith P");
		extent.config();
		
		htmlReporter.config().setDocumentTitle("Lend Nation Smoke_Testing");
		htmlReporter.config().setReportName("Lend Nation Online");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		test = extent.createTest("Lend Nation");*/
	
		}
		
  
  public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/LendNation/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	//@BeforeMethod
	 public void killProcess() throws Exception{
	 
           try{
    
        Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f"); 

        Thread.sleep(5000); //Allow OS to kill the process
        System.out.println("killed the process");
        //break;
        
     }
	 catch(Exception e)
        {
		//break;
		// continue;
        }   
	    }
	 @AfterMethod
	 public void getResult(ITestResult result) throws Exception{
	 if(result.getStatus() == ITestResult.FAILURE){
		 test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
		 test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	 //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
	                        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 
	                        //String screenshotPath = getScreenhot(driver, result.getName());
	 //To add it in the extent report 
	                        
 //Commented this
 //test.log(LogStatus.FAIL, test.addScreenCaptureFromPath(screenshotPath));
	 }else if(result.getStatus() == ITestResult.SKIP){
		 test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	 }else if(result.getStatus() == ITestResult.SUCCESS){
		 test.log(LogStatus.PASS, result.getName()+" Test Case is Passed");}
	// reports.endTest(test);
    // reports.flush();
    // extent.flush();

 	 }			
	 @AfterTest
	 
	 public void endReport(){
	 
		// reports.endTest(test);
	     reports.flush();
	                
	               // extent.flush();
	                //driver.quit();
	         
	               
	    }
	 
	 public static By locator(String obj)
		{
			
			String loctype=null;
			String locname=null;
			 By locator=null;
			 String[] locobj=obj.split("%%"); 
			 loctype=locobj[0];
			 locname=locobj[1];
			// System.out.println("startign of switch case");
			// System.out.println(obj);
			 /*switch(loctype)
			 {
			 case "id": 
				 locator=By.id(locname);
				break;
			 case "name": 
				 locator=By.name(locname);
				break;
			 case "linkText": 
				 locator=By.linkText(locname);
				break;
			 case "xpath": 
				 locator=By.xpath(locname);
				break;
			 }*/
			 
			 if(loctype.equalsIgnoreCase("id"))
				 return locator=By.id(locname);
			 else if(loctype.equalsIgnoreCase("name"))
				 return locator=By.name(locname);
			 else if(loctype.equalsIgnoreCase("linkText"))
				 return locator=By.linkText(locname);
			 else if(loctype.equalsIgnoreCase("xpath"))
				 return locator=By.xpath(locname);
			return locator;
			 
			 
			 
			 
			 
			 
			// System.out.println(locator);
			// return locator;
			
			
			 }
			
}

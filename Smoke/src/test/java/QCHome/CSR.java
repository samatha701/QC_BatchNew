package QCHome;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*import LendNation.QC_LendNation.CSRBorrowerRegistration;
import LendNation.QC_LendNation.CSRLoginLogout;
import LendNation.QC_LendNation.Excel;
import LendNation.QC_LendNation.QC_NewLoan_Veritec;
import LendNation.QC_LendNation.QC_PDL_NewLoanPage;
*/



public class CSR {
	public static String FileName;
	public static WebDriverWait wait;
	public static WebDriver driver;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	public static ExtentReports reports;
	public static ExtentTest test;
	public static Properties prop;
	public static String FirstName;
	public static String passwrd;
	public static String report_filename;
	public static String LastName;
	public static String ESign_CheckNbr;
	public static String loan_nbr;
	public static Excel TestData;
	public static String ESign_CollateralType;
	public static String LOCamount;
	public static String Statementdate;
	public static String ChkgAcctNbr;
	public static String day;
	public static String age_Date1;
	public static String age_Date2;
	public static String age_Date3;
	public static String NextDueDate;
	public static String Due_Date1;
	public static String Due_Date2;
	public static String Due_Date3;
	public static String Duedate_confirm_text3;
	public static String business_date;
	public static String Str_date;
	public static String stateid;
	public static String ProductID;
	/*public static String 
	public static String 
	public static String */
	
	
//**************************************************************************/Rati-Set/***************************************************************//	
	
		
//@Test(priority=41,enabled=true)
	public void borrowregsaveloan() throws Exception{
		FileName=  "PDL_BorrowerRegistration_Save_Loan.xls";
		test=reports.startTest("PDL_Borrower Registration_Save_Loan","Login-->Home Screen-->Borrower Registration-->Check NewLoan Page Displayed");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);
				
				QC_BorrowRegestration.qcborrowerreg_saveloan(SSN, AppURL);
				               //CSRBorrowRegestration_Save_Loan.borrowerreg_saveloan(SSN, AppURL);
				CSRLoginLogout.logout ();
				                //CSRLoginLogout.logout(SSN, AppURL);


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=42,enabled=true)
	public void borrowregsavenext() throws Exception{
		FileName=  "PDL_BorrowerRegistration_Save_Next.xls";
		test=reports.startTest("PDL_BorrowerRegistration_Save_Next","Login-->Home Screen-->Borrower Registration-->Save and Next");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				CSRLoginLogout.login(SSN,AppURL);				
				QC_BorrowRegestration.qcborrowerreg_savenext(SSN, AppURL);				                    
				CSRLoginLogout.logout ();
				

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=43,enabled=true)
	public void borrowregsavedeny() throws Exception{
		FileName=  "PDL_BorrowerRegistration_Deny.xls";
		test=reports.startTest("PDL_BorrowerRegistration_Deny","Login-->Home Screen-->Borrower Registration-->Deny");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				CSRLoginLogout.login(SSN,AppURL);								
				QC_BorrowRegestration.qcborrowerreg_deny(SSN, AppURL);
				CSRLoginLogout.logout ();
				

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=44,enabled=true)
	public void borrowregsaveexit() throws Exception{
		FileName=  "PDL_BorrowerRegistration_Save_Exit.xls";
		test=reports.startTest("PDL_BorrowerRegistration_Save_Exit","Login-->Home Screen-->Borrower Registration-->Save and Exit");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);
				QC_BorrowRegestration.qcborrowerreg_saveexit(SSN, AppURL);
				CSRLoginLogout.logout ();
				


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=45,enabled=true)
	public void editborrowregsaveexit() throws Exception{
		FileName=  "PDL_EditBorrowerRegistration_Save_Exit.xls";
		test=reports.startTest("PDL_EditBorrowerRegistration_Save_Exit","Login-->Home Screen-->Borrower Registration-->Check NewLoan Page Displayed-->Login-->Edit Borrower-->Save&Exit-->Verify Borrower Updated");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);			                
				QC_BorrowRegestration.qcborrowerreg_saveexit(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				QC_Edit_BorrowRegestration.editborrower_saveexit(SSN, AppURL);
				CSRLoginLogout.logout ();
				
				


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=46,enabled=true)
	public void editborrowregsavenext() throws Exception{
		FileName=  "PDL_EditBorrowerRegistration_Save_Next.xls";
		test=reports.startTest("PDL_EditBorrowerRegistration_Save_Next","Login-->Home Screen-->Borrower Registration-->Click Save&Next-->Login-->Edit Borrower-->Save&Next");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);			                
				QC_BorrowRegestration.qcborrowerreg_savenext(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				QC_Edit_BorrowRegestration.editborrower_savenext(SSN, AppURL);
				CSRLoginLogout.logout ();
				
				


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=47,enabled=true)
	public void editborrowregsaveloan() throws Exception{
		FileName=  "PDL_EditBorrowerRegistration_Save_Loan.xls";
		test=reports.startTest("PDL_EditBorrowerRegistration_Save_Loan","Login-->Home Screen-->Borrower Registration-->Click Save&Loan-->Verify NewLoan Screen-->Login-->Edit Borrower-->Save&Loan");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);			                
				QC_BorrowRegestration.qcborrowerreg_saveloan(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				QC_Edit_BorrowRegestration.editborrower_saveloan(SSN, AppURL);
				CSRLoginLogout.logout ();
				
				


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}

	
//@Test(priority=48,enabled=true)
	 	public void pdlborrowregsaveexiteditssn() throws Exception{
	 		FileName=  "PDL_BorrowerRegistration_Save_Exit_EditSSN.xls";
	 		test=reports.startTest("PDL_BorrowerRegistration_Save_Exit_EditSSN","Login-->Home Screen-->Borrower Registration-->Save and Exit-->Edit SSN");


	 		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
	 		String sheetName="Start";
	 		int lastrow=TestData.getLastRow("Start");
	 		System.out.println(lastrow);
	 		for(int row=2;row<=lastrow;row++)
	 		{
	 			String RunFlag = TestData.getCellData(sheetName,"Run",row);

	 			if(RunFlag.equals("Y"))
	 			{	
	 				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
	 				String SSN = TestData.getCellData(sheetName,"SSN",row); 
	 				CSRLoginLogout.login(SSN,AppURL);
	 				QC_BorrowRegestration.qcborrowerreg_saveexit(SSN, AppURL);
	 				CSRLoginLogout.logout ();
	 				CSRLoginLogout.login(SSN,AppURL);
	 				QC_BorrowRegestration_EditSSN.borrower_saveexit_editssn(SSN, AppURL);
	 				CSRLoginLogout.logout ();
	 				


	 				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
	 			}}}
	
	
//@Test(priority=49,enabled=true)
	public void ilpborrowregsavenext() throws Exception{
		FileName=  "ILP_BorrowerRegistration_Save_Next.xls";
		test=reports.startTest("ILP_BorrowerRegistration_Save_Next","Login-->Home Screen-->Borrower Registration-->Save and Next");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				CSRLoginLogout.login(SSN,AppURL);				
				QC_BorrowRegestration.qcborrowerreg_savenext(SSN, AppURL);
				CSRLoginLogout.logout ();
				

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=50,enabled=true)
	public void ilpborrowregsaveloan() throws Exception{
		FileName=  "ILP_BorrowerRegistration_Save_Loan.xls";
		test=reports.startTest("ILP_BorrowerRegistration_Save_Loan","Login-->Home Screen-->Borrower Registration-->Check NewLoan Page Displayed");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				CSRLoginLogout.login(SSN,AppURL);				        
				QC_BorrowRegestration.qcborrowerreg_saveloan(SSN, AppURL);
				CSRLoginLogout.logout ();
				


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}

	
//@Test(priority=51,enabled=true)
	public void ilpborrowregsavedeny() throws Exception{
		FileName=  "ILP_BorrowerRegistration_Deny.xls";
		test=reports.startTest("ILP_BorrowerRegistration_Deny","Login-->Home Screen-->Borrower Registration-->Deny");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				CSRLoginLogout.login(SSN,AppURL);								
				QC_BorrowRegestration.qcborrowerreg_deny(SSN, AppURL);
				CSRLoginLogout.logout ();
				

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=52,enabled=true)
	public void ilpborrowregsaveexit() throws Exception{
		FileName=  "ILP_BorrowerRegistration_Save_Exit.xls";
		test=reports.startTest("ILP_BorrowerRegistration_Save_Exit","Login-->Home Screen-->Borrower Registration-->Save and Exit");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				CSRLoginLogout.login(SSN,AppURL);
				QC_BorrowRegestration.qcborrowerreg_saveexit(SSN, AppURL);
				CSRLoginLogout.logout ();
				


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=53,enabled=true)
	public void ilpeditborrowregsaveexit() throws Exception{
		FileName=  "ILP_EditBorrowerRegistration_Save_Exit.xls";
		test=reports.startTest("ILP_EditBorrowerRegistration_Save_Exit","Login-->Home Screen-->Borrower Registration-->Login-->Edit Borrower-->Save&Exit-->Verify Borrower Updated");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);			                
				QC_BorrowRegestration.qcborrowerreg_saveexit(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				QC_Edit_BorrowRegestration.editborrower_saveexit(SSN, AppURL);
				CSRLoginLogout.logout ();
				
				


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=54,enabled=true)
	public void ilpeditborrowregsavenext() throws Exception{
		FileName=  "ILP_EditBorrowerRegistration_Save_Next.xls";
		test=reports.startTest("ILP_EditBorrowerRegistration_Save_Next","Login-->Home Screen-->Borrower Registration-->Save&Next-->Login-->Edit Borrower-->Save&Exit");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);			                
				QC_BorrowRegestration.qcborrowerreg_savenext(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				QC_Edit_BorrowRegestration.editborrower_savenext(SSN, AppURL);
				CSRLoginLogout.logout ();
				
				


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=55,enabled=true)
	public void ilpeditborrowregsaveloan() throws Exception{
		FileName=  "ILP_EditBorrowerRegistration_Save_Loan.xls";
		test=reports.startTest("ILP_EditBorrowerRegistration_Save_Loan","Login-->Home Screen-->Borrower Registration-->Save&Loan-->Verify NewLoan Page Display-->Login-->Edit Borrower");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);			                
				QC_BorrowRegestration.qcborrowerreg_saveloan(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				QC_Edit_BorrowRegestration.editborrower_saveloan(SSN, AppURL);
				CSRLoginLogout.logout ();
				
				


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
	    
//@Test(priority=56,enabled=true)
	 	public void ilpborrowregsaveexiteditssn() throws Exception{
	 		FileName=  "ILP_BorrowerRegistration_Save_Exit_EditSSN.xls";
	 		test=reports.startTest("ILP_BorrowerRegistration_Save_Exit_EditSSN","Login-->Home Screen-->Borrower Registration-->Save and Exit-->Edit SSN");


	 		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
	 		String sheetName="Start";
	 		int lastrow=TestData.getLastRow("Start");
	 		System.out.println(lastrow);
	 		for(int row=2;row<=lastrow;row++)
	 		{
	 			String RunFlag = TestData.getCellData(sheetName,"Run",row);

	 			if(RunFlag.equals("Y"))
	 			{	
	 				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
	 				String SSN = TestData.getCellData(sheetName,"SSN",row); 
	 				CSRLoginLogout.login(SSN,AppURL);
	 				QC_BorrowRegestration.qcborrowerreg_saveexit(SSN, AppURL);
	 				CSRLoginLogout.logout ();
	 				CSRLoginLogout.login(SSN,AppURL);
	 				QC_BorrowRegestration_EditSSN.borrower_saveexit_editssn(SSN, AppURL);
	 				CSRLoginLogout.logout ();
	 				


	 				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
	 			}}}	    
	
//@Test(priority=57,enabled=true)
	public void tlpeditborrowregsaveexit() throws Exception{
		FileName=  "TLP_EditBorrowerRegistration_Save_Exit.xls";
		test=reports.startTest("TLP_EditBorrowerRegistration_Save_Exit","Login-->Home Screen-->Borrower Registration-->Save&Exit-->Verify Regestration Successfull-->Login-->Edit Borrower-->Save&Exit");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);			                
				QC_BorrowRegestration.qcborrowerreg_saveexit(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				QC_Edit_BorrowRegestration.editborrower_saveexit(SSN, AppURL);
				CSRLoginLogout.logout ();
				
				


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=58,enabled=true)
	public void tlpeditborrowregsavenext() throws Exception{
		FileName=  "TLP_EditBorrowerRegistration_Save_Next.xls";
		test=reports.startTest("TLP_EditBorrowerRegistration_Save_Next","Login-->Home Screen-->Borrower Registration-->Save&Next-->Login-->Edit Borrower-->Save&Next");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);			                
				QC_BorrowRegestration.qcborrowerreg_savenext(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				QC_Edit_BorrowRegestration.editborrower_savenext(SSN, AppURL);
				CSRLoginLogout.logout ();
				
				


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=59,enabled=true)
	public void tlpeditborrowregsaveloan() throws Exception{
		FileName=  "TLP_EditBorrowerRegistration_Save_Loan.xls";
		test=reports.startTest("TLP_EditBorrowerRegistration_Save_Loan","Login-->Home Screen-->Borrower Registration-->Save&Loan--->Verify New Loan Screen Display-->Login-->Edit Borrower-->Save&Loan-->Verify NewLoan creen Display");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);			                
				QC_BorrowRegestration.qcborrowerreg_saveloan(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				QC_Edit_BorrowRegestration.editborrower_saveloan(SSN, AppURL);
				CSRLoginLogout.logout ();
							

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=60,enabled=true)
	public void TLPBorrowerRegistrationsavenext() throws Exception{
		FileName=  "TLP_BorrowerRegistration_Save_Next.xls";
		test=reports.startTest("TLP_BorrowerRegistration_Save_Next","Login-->Home Screen-->Borrower Registration-->NewLoan Screen-->Co-Borrower");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				//String CSSN = TestData.getCellData(sheetName,"CSSN",row);
				
				CSRLoginLogout.login(SSN,AppURL);								
				QC_BorrowRegestration.qcborrowerreg_savenext(SSN, AppURL);
				CSRLoginLogout.logout ();
				
				

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=61,enabled=true)
	public void TLPBorrowerRegistrationsaveloan() throws Exception{
		FileName=  "TLP_BorrowerRegistration_Save_Loan.xls";
		test=reports.startTest("TLP_BorrowerRegistration_Save_Loan","Login-->Home Screen-->Borrower Registration-->Check Save and loan-->NewLoan Screen");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				//String CSSN = TestData.getCellData(sheetName,"CSSN",row);
				
				CSRLoginLogout.login(SSN,AppURL);												        
				QC_BorrowRegestration.qcborrowerreg_saveloan(SSN, AppURL);
				CSRLoginLogout.logout ();
				
				

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=62,enabled=true)
	public void TLPBorrowerRegistrationsavedeny() throws Exception{
		FileName=  "TLP_BorrowerRegistration_Deny.xls";
		test=reports.startTest("TLP_BorrowerRegistration_Deny","Login-->Home Screen-->Borrower Registration-->Check Deny");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				//String CSSN = TestData.getCellData(sheetName,"CSSN",row);
				
				CSRLoginLogout.login(SSN,AppURL);								
				QC_BorrowRegestration.qcborrowerreg_deny(SSN, AppURL);
				CSRLoginLogout.logout ();
				
				

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
//@Test(priority=63,enabled=true)
	public void TLPBorrowerRegistrationsaveexit() throws Exception{
		FileName=  "TLP_BorrowerRegistration_Save_Exit.xls";
		            
		test=reports.startTest("TLP_BorrowerRegistration_Save_Exit","Login-->Home Screen-->Borrower Registration-->Save&Exit");

		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				//String CSSN = TestData.getCellData(sheetName,"CSSN",row);
				
				CSRLoginLogout.login(SSN,AppURL);								
				QC_BorrowRegestration.qcborrowerreg_saveexit(SSN, AppURL);
				CSRLoginLogout.logout ();
				
				

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}

//@Test(priority=64,enabled=true)
	public void tlpborrowregsaveexiteditssn() throws Exception{
		FileName=  "TLP_BorrowerRegistration_Save_Exit_EditSSN.xls";
		test=reports.startTest("TLP_BorrowerRegistration_Save_Exit_EditSSN","Login-->Home Screen-->Borrower Registration-->Save and Exit-->Edit SSN");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);
				QC_BorrowRegestration.qcborrowerreg_saveexit(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				QC_BorrowRegestration_EditSSN.borrower_saveexit_editssn(SSN, AppURL);
				CSRLoginLogout.logout ();
				


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}	    
	
//@Test(priority=65,enabled=true)
	public void locborrowregsavenext() throws Exception{
		FileName=  "LOC_BorrowerRegistration_Save_Next.xls";
		test=reports.startTest("LOC_BorrowerRegistration_Save_Next","Login-->Home Screen-->Borrower Registration-->Save and Next");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				CSRLoginLogout.login(SSN,AppURL);				
				QC_BorrowRegestration.qcborrowerreg_savenext(SSN, AppURL);
				CSRLoginLogout.logout ();
				

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=66,enabled=true)
	public void locborrowregsaveloan() throws Exception{
		FileName=  "LOC_BorrowerRegistration_Save_Loan.xls";
		test=reports.startTest("LOC_BorrowerRegistration_Save_Loan","Login-->Home Screen-->Borrower Registration-->Save and Loan");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				CSRLoginLogout.login(SSN,AppURL);								                    
				QC_BorrowRegestration.qcborrowerreg_saveloan(SSN, AppURL);
				CSRLoginLogout.logout ();
				

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=67,enabled=true)
	public void locborrowregsavedeny() throws Exception{
		FileName=  "LOC_BorrowerRegistration_Save_Deny.xls";
		test=reports.startTest("LOC_BorrowerRegistration_Save_Deny","Login-->Home Screen-->Borrower Registration-->Check Deny");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				CSRLoginLogout.login(SSN,AppURL);				
				QC_BorrowRegestration.qcborrowerreg_deny(SSN, AppURL);
				CSRLoginLogout.logout ();
				

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}

//@Test(priority=68,enabled=true)
	public void locborrowregsaveexit() throws Exception{
		FileName=  "LOC_BorrowerRegistration_Save_Exit.xls";
		test=reports.startTest("LOC_BorrowerRegistration_Save_Exit","Login-->Home Screen-->Borrower Registration-->Verify Save&Exit");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				CSRLoginLogout.login(SSN,AppURL);				
				QC_BorrowRegestration.qcborrowerreg_saveexit(SSN, AppURL);
				CSRLoginLogout.logout ();
				

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=69,enabled=true)
	public void loceditborrowregsaveexit() throws Exception{
		FileName=  "LOC_EditBorrowerRegistration_Save_Exit.xls";
		test=reports.startTest("LOC_EditBorrowerRegistration_Save_Exit","Login-->Home Screen-->Borrower Registration-->Save&Exit--->Login-->Edit Borrower-->Save&Exit-->Verify Customer Updated");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);			                
				QC_BorrowRegestration.qcborrowerreg_saveexit(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				QC_Edit_BorrowRegestration.editborrower_saveexit(SSN, AppURL);
				CSRLoginLogout.logout ();
							

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}

//@Test(priority=70,enabled=true)
	public void loceditborrowregsavenext() throws Exception{
		FileName=  "LOC_EditBorrowerRegistration_Save_Next.xls";
		test=reports.startTest("LOC_EditBorrowerRegistration_Save_Next","Login-->Home Screen-->Borrower Registration-->Save&Next--->Login-->Edit Borrower-->Save&Next");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);			                
				QC_BorrowRegestration.qcborrowerreg_savenext(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				QC_Edit_BorrowRegestration.editborrower_savenext(SSN, AppURL);
				CSRLoginLogout.logout ();
							

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}	
	
//@Test(priority=71,enabled=true)
	public void loceditborrowregsaveloan() throws Exception{
		FileName=  "LOC_EditBorrowerRegistration_Save_Loan.xls";
		test=reports.startTest("LOC_EditBorrowerRegistration_Save_Loan","Login-->Home Screen-->Borrower Registration-->Save&Loan-->Verify New Loan Screen Display--->Login-->Edit Borrower-->Save&Loan-->Verify NewLoan Screen Displayed");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);			                
				QC_BorrowRegestration.qcborrowerreg_saveloan(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				QC_Edit_BorrowRegestration.editborrower_saveloan(SSN, AppURL);
				CSRLoginLogout.logout ();
							

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}	

//@Test(priority=72,enabled=true)
public void locborrowregsaveexiteditssn() throws Exception{
	FileName=  "LOC_EditBorrowerRegistration_Save_Exit_EditSSN.xls";
	test=reports.startTest("LOC_EditBorrowerRegistration_Save_Exit_EditSSN","Login-->Home Screen-->Borrower Registration-->Save and Exit-->Edit SSN");


	TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
	String sheetName="Start";
	int lastrow=TestData.getLastRow("Start");
	System.out.println(lastrow);
	for(int row=2;row<=lastrow;row++)
	{
		String RunFlag = TestData.getCellData(sheetName,"Run",row);

		if(RunFlag.equals("Y"))
		{	
			String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			String SSN = TestData.getCellData(sheetName,"SSN",row); 
			CSRLoginLogout.login(SSN,AppURL);
			QC_BorrowRegestration.qcborrowerreg_saveexit(SSN, AppURL);
			CSRLoginLogout.logout ();
			CSRLoginLogout.login(SSN,AppURL);
			QC_BorrowRegestration_EditSSN.borrower_saveexit_editssn(SSN, AppURL);
			CSRLoginLogout.logout ();
			


			test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
		}}}	    

	
//@Test(priority=73,enabled=true)
	public void CSRBorrowerRegistration() throws Exception{
		FileName=  "TLP_CoBorrowerRegestration.xls";
		test=reports.startTest("TLP_CoBorrower Registration_Complete NewLoan","Login-->Home Screen-->Borrower Registration-->NewLoan Screen-->Co-Borrower-->Complete New Loan");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				String CSSN = TestData.getCellData(sheetName,"CSSN",row);
				
				CSRLoginLogout.login(SSN,AppURL);								
				CSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				TLP_CoBorrower.coborrower(SSN, AppURL);
				QCCSRCoBorrowerRegestration.coborrowerReg(CSSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				TLPCSRNewLoan.newLoan(SSN, AppURL);
				CSRLoginLogout.logout ();
				

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=74,enabled=true)
	public void CSRCoBorrowerRegistrationsavenext() throws Exception{
		FileName=  "TLP_CoBorrowerRegestration_Save_Next.xls";
		test=reports.startTest("TLP_CoBorrowerRegestration_Save_Next","Login-->Home Screen-->Borrower Registration-->NewLoan Screen-->Co-Borrower-->Save and Next");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				String CSSN = TestData.getCellData(sheetName,"CSSN",row);
				
				CSRLoginLogout.login(SSN,AppURL);								
				CSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				TLP_CoBorrower.coborrower(SSN, AppURL);
				TLP_CoBorrowRegestration_Save_next.coborrowerRegsavenext(CSSN, AppURL);
				CSRLoginLogout.logout ();
				
							

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=75,enabled=true)
	public void CSRCoBorrowerRegistrationsaveloan() throws Exception{
		FileName=  "TLP_CoBorrowerRegestration_Save_Loan.xls";
		test=reports.startTest("TLP_CoBorrowerRegestration_Save_Loan","Login-->Home Screen-->Borrower Registration-->NewLoan Screen-->Co-Borrower-->Save and Loan-->Verify New Loan Screen");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				String CSSN = TestData.getCellData(sheetName,"CSSN",row);
				
				CSRLoginLogout.login(SSN,AppURL);								
				CSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				TLP_CoBorrower.coborrower(SSN, AppURL);
				TLP_CoBorrowRegestration_Save_Loan.coborrowerRegsaveloan(CSSN, AppURL);				
				CSRLoginLogout.logout ();
				
							

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=76,enabled=true)
	public void CSRCoBorrowerRegistrationsavedeny() throws Exception{
		FileName=  "TLP_CoBorrowerRegestration_Deny.xls";
		test=reports.startTest("TLP_CoBorrowerRegestration_Deny","Login-->Home Screen-->Borrower Registration-->NewLoan Screen-->Co-Borrower-->Deny");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				String CSSN = TestData.getCellData(sheetName,"CSSN",row);
				
				CSRLoginLogout.login(SSN,AppURL);								
				CSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				TLP_CoBorrower.coborrower(SSN, AppURL);
				TLP_CoBorrowRegestration_Deny.coborrowerRegsavedeny(CSSN, AppURL);
				CSRLoginLogout.logout ();
				
							

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
//@Test(priority=77,enabled=true)
	public void CSRCoBorrowerRegistrationsaveexit() throws Exception{
		FileName=  "TLP_CoBorrowerRegestration_Save_Exit.xls";
		test=reports.startTest("TLP_CoBorrowerRegestration_Save_Exit","Login-->Home Screen-->Borrower Registration-->NewLoan Screen-->Co-Borrower-->Save and Exit");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				String CSSN = TestData.getCellData(sheetName,"CSSN",row);
				
				CSRLoginLogout.login(SSN,AppURL);								
				CSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN,AppURL);
				TLP_CoBorrower.coborrower(SSN, AppURL);
				TLP_BorrowRegestration_Save_Exit.coborrowerRegsaveexit(CSSN, AppURL);
				CSRLoginLogout.logout ();
										

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}

	

	
//***************************************************************/JD-Set/************************************************************//	
	
	
//@Test(priority=78,enabled=true)
public static void QC_NE_PDL_Txn() throws Exception {
	try
	{			
		test=reports.startTest("QC_NE_PDL_BorrowerNewLoan","Login->Borrower Registratino->New Loan");

		FileName= "QC_Borrower_NewLoan.xls";

		TestData = new Excel(System.getProperty("user.dir")+prop.getProperty("QC_Store_Test_data_sheet_path")+FileName);

		int lastrow=TestData.getLastRow("Start");
		String sheetName="Start";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			

			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			stateid=TestData.getCellData(sheetName,"StateID",row);
			ProductID=TestData.getCellData(sheetName,"ProductID",row);
			
			if(RunFlag.equals("Y") && stateid.equalsIgnoreCase("NE") && ProductID.equalsIgnoreCase("PDL"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				System.out.println(AppURL);
				
				CSRLoginLogout.login(SSN, AppURL);
				QC_PDL_BorrowerRegistration.borrowerRegistration(SSN, AppURL);
				CSRLoginLogout.logout ();
				CSRLoginLogout.login(SSN, AppURL);
				QC_PDL_NewLoan.newLoan(SSN, AppURL);
				CSRLoginLogout.logout ();
			}
		}
	}

	catch(Exception e)
	{
		System.out.println("under catch of Test" + e);
		String screenshotPath = getScreenhot(driver, "QC_NE_PDL");
		test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
		
		test.log(LogStatus.ERROR,"Unable to start scenario QC_NE_PDL ");


	}
}
	//@Test(priority=79,enabled=true)
	public static void QC_LA_PDL_Txn() throws Exception {
		try
		{			
			test=reports.startTest("QC_LA_PDL_BorrowerNewLoan","Login->Borrower Registratino->New Loan");

			FileName= "QC_Borrower_NewLoan.xls";

			TestData = new Excel(System.getProperty("user.dir")+prop.getProperty("QC_Store_Test_data_sheet_path")+FileName);

			int lastrow=TestData.getLastRow("Start");
			String sheetName="Start";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{


				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				stateid=TestData.getCellData(sheetName,"StateID",row);
				ProductID=TestData.getCellData(sheetName,"ProductID",row);
				
				if(RunFlag.equals("Y") && stateid.equalsIgnoreCase("LA") && ProductID.equalsIgnoreCase("PDL"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 
					System.out.println(AppURL);
					
					CSRLoginLogout.login(SSN, AppURL);
					QC_PDL_BorrowerRegistration.borrowerRegistration(SSN, AppURL);
					CSRLoginLogout.logout ();
					CSRLoginLogout.login(SSN, AppURL);
					QC_PDL_NewLoan.newLoan(SSN, AppURL);
					CSRLoginLogout.logout ();
				}
			}
		}

		catch(Exception e)
		{
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_LA_PDL_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			
			test.log(LogStatus.ERROR,"Unable to start scenario QC_LA_PDL_Txn ");


		}
}
	//@Test(priority=80,enabled=true)
	public static void QC_NV_PDL_Txn() throws Exception {
		try
		{			
			test=reports.startTest("QC_NV_PDL_BorrowerNewLoan","Login->Borrower Registratino->New Loan");

			FileName= "QC_Borrower_NewLoan.xls";

			TestData = new Excel(System.getProperty("user.dir")+prop.getProperty("QC_Store_Test_data_sheet_path")+FileName);

			int lastrow=TestData.getLastRow("Start");
			String sheetName="Start";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{


				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				stateid=TestData.getCellData(sheetName,"StateID",row);
				ProductID=TestData.getCellData(sheetName,"ProductID",row);
				
				if(RunFlag.equals("Y") && stateid.equalsIgnoreCase("NV") && ProductID.equalsIgnoreCase("PDL"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 
					System.out.println(AppURL);
					
					CSRLoginLogout.login(SSN, AppURL);
					QC_PDL_BorrowerRegistration.borrowerRegistration(SSN, AppURL);
					CSRLoginLogout.logout ();
					CSRLoginLogout.login(SSN, AppURL);
					QC_PDL_NewLoan.newLoan(SSN, AppURL);
					CSRLoginLogout.logout ();
				}
			}
		}

		catch(Exception e)
		{
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_NV_PDL_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			
			test.log(LogStatus.ERROR,"Unable to start scenario QC_NV_PDL_Txn ");


		}
}
	//@Test(priority=81,enabled=true)
	public static void QC_MO_PDL_Txn() throws Exception {
		try
		{			
			test=reports.startTest("QC_MO_PDL_Txn","Login->Borrower Registratino->New Loan");

			FileName= "QC_Borrower_NewLoan.xls";

			TestData = new Excel(System.getProperty("user.dir")+prop.getProperty("QC_Store_Test_data_sheet_path")+FileName);

			int lastrow=TestData.getLastRow("Start");
			String sheetName="Start";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{


				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				stateid=TestData.getCellData(sheetName,"StateID",row);
				ProductID=TestData.getCellData(sheetName,"ProductID",row);
				
				if(RunFlag.equals("Y") && stateid.equalsIgnoreCase("MO") && ProductID.equalsIgnoreCase("PDL"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 
					System.out.println(AppURL);
					
					CSRLoginLogout.login(SSN, AppURL);
					QC_PDL_BorrowerRegistration.borrowerRegistration(SSN, AppURL);
					CSRLoginLogout.logout ();
					CSRLoginLogout.login(SSN, AppURL);
					QC_PDL_NewLoan.newLoan(SSN, AppURL);
					CSRLoginLogout.logout ();
				}
			}
		}

		catch(Exception e)
		{
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_MO_PDL_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			
			test.log(LogStatus.ERROR,"Unable to start scenario QC_MO_PDL_Txn ");


		}
}
	//@Test(priority=82,enabled=true)
	public static void QC_WI_ILP_Txn() throws Exception {
		try
		{			
			test=reports.startTest("QC_WI_ILP_BorrowerNewLoan","Login->Borrower Registratino->New Loan");

			FileName= "QC_Borrower_NewLoan.xls";

			TestData = new Excel(System.getProperty("user.dir")+prop.getProperty("QC_Store_Test_data_sheet_path")+FileName);

			int lastrow=TestData.getLastRow("Start");
			String sheetName="Start";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{


				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				stateid=TestData.getCellData(sheetName,"StateID",row);
				ProductID=TestData.getCellData(sheetName,"ProductID",row);
				
				if(RunFlag.equals("Y") && stateid.equalsIgnoreCase("WI") && ProductID.equalsIgnoreCase("ILP"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 
					System.out.println(AppURL);
					
					CSRLoginLogout.login(SSN, AppURL);
					QC_ILP_BorrowerRegistration.borrowerRegistration(SSN, AppURL);
					CSRLoginLogout.logout ();
					CSRLoginLogout.login(SSN, AppURL);
					QC_ILP_NewLoan.newLoan(SSN, AppURL);
					CSRLoginLogout.logout ();
				}
			}
		}

		catch(Exception e)
		{
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_WI_ILP_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			
			test.log(LogStatus.ERROR,"Unable to start scenario QC_WI_ILP_Txn ");


		}
}
	//@Test(priority=83,enabled=true)
	public static void QC_NM_ILP_Txn() throws Exception {
		try
			{			
					test=reports.startTest("QC_NM_ILP_BorrowerNewLoan","Login->Borrower Registratino->New Loan");

					FileName= "QC_Borrower_NewLoan.xls";

					TestData = new Excel(System.getProperty("user.dir")+prop.getProperty("QC_Store_Test_data_sheet_path")+FileName);

					int lastrow=TestData.getLastRow("Start");
					String sheetName="Start";
					System.out.println(lastrow);
					for(int row=2;row<=lastrow;row++)
					{


						String RunFlag = TestData.getCellData(sheetName,"Run",row);
						stateid=TestData.getCellData(sheetName,"StateID",row);
						ProductID=TestData.getCellData(sheetName,"ProductID",row);
						
						if(RunFlag.equals("Y") && stateid.equalsIgnoreCase("NM") && ProductID.equalsIgnoreCase("ILP"))
						{	
							String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
							String SSN = TestData.getCellData(sheetName,"SSN",row); 
							System.out.println(AppURL);
							
							CSRLoginLogout.login(SSN, AppURL);
							QC_ILP_BorrowerRegistration.borrowerRegistration(SSN, AppURL);
							CSRLoginLogout.logout ();
							CSRLoginLogout.login(SSN, AppURL);
							QC_ILP_NewLoan.newLoan(SSN, AppURL);
							CSRLoginLogout.logout ();
						}
					}
				}

				catch(Exception e)
				{
					System.out.println("under catch of Test" + e);
					String screenshotPath = getScreenhot(driver, "QC_NM_ILP_Txn");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					
					test.log(LogStatus.ERROR,"Unable to start scenario QC_NM_ILP_Txn ");


				}
		}
			
			//@Test(priority=84,enabled=true)
			public static void QC_MO_ILP_Txn() throws Exception {
				try
				{			
					test=reports.startTest("QC_MO_ILP_BorrowerNewLoan","Login->Borrower Registratino->New Loan");

					FileName= "QC_Borrower_NewLoan.xls";

					TestData = new Excel(System.getProperty("user.dir")+prop.getProperty("QC_Store_Test_data_sheet_path")+FileName);

					int lastrow=TestData.getLastRow("Start");
					String sheetName="Start";
					System.out.println(lastrow);
					for(int row=2;row<=lastrow;row++)
					{


						String RunFlag = TestData.getCellData(sheetName,"Run",row);
						stateid=TestData.getCellData(sheetName,"StateID",row);
						ProductID=TestData.getCellData(sheetName,"ProductID",row);
						
						if(RunFlag.equals("Y") && stateid.equalsIgnoreCase("MO") && ProductID.equalsIgnoreCase("ILP"))
						{	
							String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
							String SSN = TestData.getCellData(sheetName,"SSN",row); 
							System.out.println(AppURL);
							
							CSRLoginLogout.login(SSN, AppURL);
							QC_ILP_BorrowerRegistration.borrowerRegistration(SSN, AppURL);
							CSRLoginLogout.logout ();
							CSRLoginLogout.login(SSN, AppURL);
							QC_ILP_NewLoan.newLoan(SSN, AppURL);
							CSRLoginLogout.logout ();
						}
					}
				}

				catch(Exception e)
				{
					System.out.println("under catch of Test" + e);
					String screenshotPath = getScreenhot(driver, "QC_MO_ILP_Txn");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					
					test.log(LogStatus.ERROR,"Unable to start scenario QC_MO_ILP_Txn ");


				}
		}
			//@Test(priority=85,enabled=true)
			public static void QC_MO_TLP_Txn() throws Exception {
				try
				{			
					test=reports.startTest("QC_MO_TLP_BorrowerNewLoan","Login->Borrower Registratino->New Loan");

					FileName= "QC_Borrower_NewLoan.xls";

					TestData = new Excel(System.getProperty("user.dir")+prop.getProperty("QC_Store_Test_data_sheet_path")+FileName);

					int lastrow=TestData.getLastRow("Start");
					String sheetName="Start";
					System.out.println(lastrow);
					for(int row=2;row<=lastrow;row++)
					{


						String RunFlag = TestData.getCellData(sheetName,"Run",row);
						stateid=TestData.getCellData(sheetName,"StateID",row);
						ProductID=TestData.getCellData(sheetName,"ProductID",row);
						
						if(RunFlag.equals("Y") && stateid.equalsIgnoreCase("MO") && ProductID.equalsIgnoreCase("TLP"))
						{	
							String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
							String SSN = TestData.getCellData(sheetName,"SSN",row); 
							System.out.println(AppURL);
							
							CSRLoginLogout.login(SSN, AppURL);
							QC_TLP_BorrowerRegistration.borrowerRegistration(SSN, AppURL);
							CSRLoginLogout.logout ();
							CSRLoginLogout.login(SSN, AppURL);
							QC_TLP_NewLoan.newLoan(SSN, AppURL);
							CSRLoginLogout.logout ();
						}
					}
				}

				catch(Exception e)
				{
					System.out.println("under catch of Test" + e);
					String screenshotPath = getScreenhot(driver, "QC_MO_TLP_Txn");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					
					test.log(LogStatus.ERROR,"Unable to start scenario QC_MO_TLP_Txn ");


				}
		}
			//@Test(priority=86,enabled=true)
			public static void QC_NM_TLP_Txn() throws Exception {
				try
				{			
					test=reports.startTest("QC_NM_TLP_BorrowerNewLoan","Login->Borrower Registratino->New Loan");

					FileName= "QC_Borrower_NewLoan.xls";

					TestData = new Excel(System.getProperty("user.dir")+prop.getProperty("QC_Store_Test_data_sheet_path")+FileName);

					int lastrow=TestData.getLastRow("Start");
					String sheetName="Start";
					System.out.println(lastrow);
					for(int row=2;row<=lastrow;row++)
					{


						String RunFlag = TestData.getCellData(sheetName,"Run",row);
						stateid=TestData.getCellData(sheetName,"StateID",row);
						ProductID=TestData.getCellData(sheetName,"ProductID",row);
						
						if(RunFlag.equals("Y") && stateid.equalsIgnoreCase("NM") && ProductID.equalsIgnoreCase("TLP"))
						{	
							String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
							String SSN = TestData.getCellData(sheetName,"SSN",row); 
							System.out.println(AppURL);
							
							CSRLoginLogout.login(SSN, AppURL);
							QC_TLP_BorrowerRegistration.borrowerRegistration(SSN, AppURL);
							CSRLoginLogout.logout ();
							CSRLoginLogout.login(SSN, AppURL);
							QC_TLP_NewLoan.newLoan(SSN, AppURL);
							CSRLoginLogout.logout ();
						}
					}
				}

				catch(Exception e)
				{
					System.out.println("under catch of Test" + e);
					String screenshotPath = getScreenhot(driver, "QC_NM_TLP_Txn");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					
					test.log(LogStatus.ERROR,"Unable to start scenario QC_NM_TLP_Txn ");


				}
		}
			//@Test(priority=87,enabled=true)
			public static void QC_NV_TLP_Txn() throws Exception {
				try
				{			
					test=reports.startTest("QC_NV_TLP_BorrowerNewLoan","Login->Borrower Registratino->New Loan");

					FileName= "QC_Borrower_NewLoan.xls";

					TestData = new Excel(System.getProperty("user.dir")+prop.getProperty("QC_Store_Test_data_sheet_path")+FileName);

					int lastrow=TestData.getLastRow("Start");
					String sheetName="Start";
					System.out.println(lastrow);
					for(int row=2;row<=lastrow;row++)
					{


						String RunFlag = TestData.getCellData(sheetName,"Run",row);
						stateid=TestData.getCellData(sheetName,"StateID",row);
						ProductID=TestData.getCellData(sheetName,"ProductID",row);
						
						if(RunFlag.equals("Y") && stateid.equalsIgnoreCase("NV") && ProductID.equalsIgnoreCase("TLP"))
						{	
							String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
							String SSN = TestData.getCellData(sheetName,"SSN",row); 
							System.out.println(AppURL);
							
							CSRLoginLogout.login(SSN, AppURL);
							QC_TLP_BorrowerRegistration.borrowerRegistration(SSN, AppURL);
							CSRLoginLogout.logout ();
							CSRLoginLogout.login(SSN, AppURL);
							QC_TLP_NewLoan.newLoan(SSN, AppURL);
							CSRLoginLogout.logout ();
						}
					}
				}

				catch(Exception e)
				{
					System.out.println("under catch of Test" + e);
					String screenshotPath = getScreenhot(driver, "QC_NV_TLP_Txn");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					
					test.log(LogStatus.ERROR,"Unable to start scenario QC_NV_TLP_Txn ");


				}
		}
			//@Test(priority=88,enabled=true)
			public static void QC_KS_LOC_Txn() throws Exception {
				try
				{			
					test=reports.startTest("QC_KS_LOC_BorrowerNewLoan","Login->Borrower Registratino->New Loan");

					FileName= "QC_Borrower_NewLoan.xls";

					TestData = new Excel(System.getProperty("user.dir")+prop.getProperty("QC_Store_Test_data_sheet_path")+FileName);

					int lastrow=TestData.getLastRow("Start");
					String sheetName="Start";
					System.out.println(lastrow);
					for(int row=2;row<=lastrow;row++)
					{


						String RunFlag = TestData.getCellData(sheetName,"Run",row);
						stateid=TestData.getCellData(sheetName,"StateID",row);
						ProductID=TestData.getCellData(sheetName,"ProductID",row);
						
						if(RunFlag.equals("Y") && stateid.equalsIgnoreCase("KS") && ProductID.equalsIgnoreCase("LOC"))
						{	
							String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
							String SSN = TestData.getCellData(sheetName,"SSN",row); 
							System.out.println(AppURL);
							
							CSRLoginLogout.login(SSN, AppURL);
							QC_LOC_BorrowerRegistration.borrowerRegistration(SSN, AppURL);
							CSRLoginLogout.logout ();
							CSRLoginLogout.login(SSN, AppURL);
							QC_LOC_NewLoan.newLoan(SSN, AppURL);
							CSRLoginLogout.logout ();
						}
					}
				}

				catch(Exception e)
				{
					System.out.println("under catch of Test" + e);
					String screenshotPath = getScreenhot(driver, "QC_KS_LOC_Txn");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					
					test.log(LogStatus.ERROR,"Unable to start scenario QC_KS_LOC_Txn ");


				}
		}
	
//*************************************************************/Veritec/*****************************************************************//		
			
//@Test(priority=89,enabled=true)
			        public void NewLoanVeritec() throws Exception{
					FileName="QC_NewLoan_Veritec_Txn.xls";
					//test=reports.startTest("QC_PDL_NewLoan_Veritec");
					TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
					String sheetName="Start";
					int lastrow=TestData.getLastRow("Start");
					
					for(int row=2;row<=lastrow+1;row++)
					{
						String RunFlag = TestData.getCellData(sheetName,"Run",row);

						if(RunFlag.equals("Y"))
						{	
							String StateID = TestData.getCellData(sheetName,"StateID",row);
							test=reports.startTest("QC_"+StateID+"_NewLoan_Veritec");
							String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
							String SSN = TestData.getCellData(sheetName,"SSN",row); 

							CSRLoginLogout.login(SSN,AppURL);
							CSRBorrowerRegistration.borrowerReg(SSN,AppURL);
							CSRLoginLogout.logout();
							CSRLoginLogout.login(SSN,AppURL);
							QC_NewLoan_Veritec.newLoan(SSN,AppURL);
							CSRLoginLogout.login(SSN,AppURL);
							QC_PDL_NewLoanPage.newLoan(SSN,AppURL);
							CSRLoginLogout.logout();
							
							test.log(LogStatus.INFO, "****Test Scenario for Veritec loan Validation is pass******");
						}}}

			
			
			
			
//********************************************************************/Anoop-Set/**********************************************************//

	

//@Test(priority=40,enabled=true)
	public void LOC_History() throws Exception{
		FileName="QC_LOC_Payment_Refinance.xls";
		test=reports.startTest("LOC_History","Login-->History");

		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 

				
				CSRLoginLogout.login(SSN,AppURL);
				LOC_History.history(SSN, AppURL);
				CSRLoginLogout.logout();	
	
			}}}
	//@Test(priority=39,enabled=true)
	public void LOC_Payoff() throws Exception{
		FileName="QC_LOC_Payment_Refinance.xls";
		test=reports.startTest("LOC_Refinance","Login-->Payoff");

		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 

				
				CSRLoginLogout.login(SSN,AppURL);
				LOC_PayOff.payoff(SSN, AppURL);
				CSRLoginLogout.logout();	
	
			}}}
	
	//@Test(priority=38,enabled=true)
	public void LOC_Payment() throws Exception{
		FileName="QC_LOC_Payment_Refinance.xls";
		test=reports.startTest("LOC_Payment","Login-->Payment");

		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 

				CSRLoginLogout.login(SSN,AppURL);
				LOC_AgetheStore.ageGracedays(SSN, AppURL);
				CSRLoginLogout.login(SSN,AppURL);
				LOCPayments.payment(SSN, AppURL);
				CSRLoginLogout.logout();	
	
			}}}
	
	//@Test(priority=37,enabled=true)
	public void LOC_NewLoan() throws Exception{
		FileName="QC_LOC_Payment_Refinance.xls";
		test=reports.startTest("LOC_NewLoan","Login-->NewLoan");

		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 

				CSRLoginLogout.login(SSN,AppURL);
				LOC_CSRNewLoan.newLoan(SSN, AppURL);
				CSRLoginLogout.logout();	
	
			}}}
	
	//@Test(priority=36,enabled=true)
	public void LOC_BorrowerReg() throws Exception{
		FileName="QC_LOC_Payment_Refinance.xls";
		test=reports.startTest("LOC_BorrowerRegistration","Login-->BorrowerRegistration");

		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 

				CSRLoginLogout.login(SSN,AppURL);
				LOC_CSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				CSRLoginLogout.logout();	
	
			}}}
//---------------------------------------------------------------------------------------------------------------------------------------------------	
	
//*****************************************************TLP************************************************
	
	//@Test(priority=35,enabled=true)
	public void HistoryTLp() throws Exception{
		FileName=  "TLPnewloan2.xls";
		test=reports.startTest("TLP_History","Login-->Transactions-->History");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 

				CSRLoginLogout.login(SSN,AppURL);
				TLP_History.history(SSN, AppURL);
				CSRLoginLogout.logout ();

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
		//@Test(priority=34,enabled=true)
		
			public void TLPBuyback() throws Exception{
				FileName=  "TLPnewloan2.xls";
				test=reports.startTest("TLP_BuyBack","Login-->Home Screen-->Buyback");


				TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
				String sheetName="Start";
				int lastrow=TestData.getLastRow("Start");
				
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);

					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
	
		                
						CSRLoginLogout.login(SSN,AppURL);
						TLP_CSRBorrowerRegistration.borrowerReg(SSN,AppURL);
						CSRLoginLogout.logout ();
						
						CSRLoginLogout.login(SSN,AppURL);
						QCCSRNewLoan.newLoan(SSN, AppURL);
						CSRLoginLogout.logout ();
						
						CSRLoginLogout.login(SSN,AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);	
						
						CSRLoginLogout.login(SSN,AppURL);
						QCCSRBuyBack.buyback(SSN, AppURL);
						CSRLoginLogout.logout ();
						
						test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
					}}}
	//@Test(priority=33,enabled=true)
		public void TLPRefinance() throws Exception{
			FileName=  "TLPnewloan.xls";
			test=reports.startTest("TLP_Refinance","Login-->Home Screen-->Refinance");


			TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 
					
					CSRLoginLogout.login(SSN,AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);				
	                
					CSRLoginLogout.login(SSN,AppURL);
					TLP_Refinance_StepSame.StepSame(SSN, AppURL);
					CSRLoginLogout.logout ();
					
					test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
				}}}
	
	//@Test(priority=32,enabled=true)
	public void TLPPayment() throws Exception{
		FileName=  "TLPnewloan.xls";
		test=reports.startTest("TLP_Payment","Login-->Home Screen-->Payment");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				CSRLoginLogout.login(SSN,AppURL);
				CSRRescindLoan.agerescind(SSN,AppURL);				
                
				CSRLoginLogout.login(SSN,AppURL);
				TLP_Payment.payment(SSN, AppURL);
				CSRLoginLogout.logout ();
				
				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
	
	
	
	
	//@Test(priority=31,enabled=true)
	public void TLPnewLoan() throws Exception{
		FileName=  "TLPnewloan.xls";
		test=reports.startTest("QC_TLP_NewLoan","Login-->Home Screen-->NewLoan");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				CSRLoginLogout.login(SSN,AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				CSRLoginLogout.logout ();

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
	

	//@Test(priority=30,enabled=true)
	public void TLPborrowreg() throws Exception{
		FileName=  "TLPnewloan.xls";
		test=reports.startTest("TLP_Borrower Registration","Login-->Home Screen-->Borrower Registration");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				CSRLoginLogout.login(SSN,AppURL);
				TLP_CSRBorrowerRegistration.borrowerReg(SSN,AppURL);
				CSRLoginLogout.logout ();


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	
	//-------------------------------------------------------------------------------------------------------------------------
	
	//@Test(priority=29,enabled=true)
	public void DailyTransactionJournal() throws Exception{
		FileName=  "TLPnewloan.xls";
		test=reports.startTest("DailyTransactionJournal","Login-->Home Screen-->NewLoan");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[@id='950000']/a")).click();
				Thread.sleep(500);
				test.log(LogStatus.PASS, "Clicked on Reports");
				Thread.sleep(500);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				test.log(LogStatus.PASS, "Verifying the Collection sub menu");
				if (driver.findElement(By.linkText("Collection")).isDisplayed()) {
					test.log(LogStatus.PASS, "Collection sub menu is enabled");
					test.log(LogStatus.PASS, "Reports is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Reports is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Daily Summary Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");
				
				driver.findElement(By.linkText("Daily Transaction Journal")).click();
				test.log(LogStatus.PASS, "Clicked on Daily Transaction Journal");
				driver.switchTo().frame("main");
				if (driver.findElement(By.name("B2")).isDisplayed()) {

					test.log(LogStatus.PASS, "Reset button is enabled");
					test.log(LogStatus.PASS, "Daily Transaction Journal link is working fine");
					driver.findElement(By.name("requestBean.transaction")).sendKeys("ALL");
					test.log(LogStatus.PASS, "Selected All under the transaction list");

					driver.findElement(By.name("beginMonth")).sendKeys("01");
					test.log(LogStatus.PASS, "Entered Begin month as 01");
					driver.findElement(By.name("beginDay")).sendKeys("01");
					test.log(LogStatus.PASS, "Entered Begin date as 01");
					driver.findElement(By.name("endMonth")).sendKeys("01");
					test.log(LogStatus.PASS, "Entered Begin month as 01");
					driver.findElement(By.name("endDay")).sendKeys("01");
					test.log(LogStatus.PASS, "Entered Begin date as 01");

					driver.findElement(By.name("btnPreview")).click();
					test.log(LogStatus.PASS, "clicked on Preview");
					Thread.sleep(6000);

					if (driver.findElement(By.xpath("//input[@id='idControl' and @value='Print']")).isDisplayed()) {

						test.log(LogStatus.PASS, "Print button is enabled");
						test.log(LogStatus.PASS, "Daily Transaction Journal Report is generated successfully");
						test.log(LogStatus.PASS, "*******************************************");
					} else {
						test.log(LogStatus.FAIL, "Daily Transaction Journal Report is not generated successfully");
					}

					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.FAIL, "Daily Transaction Journal link is not working fine");
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Daily Summary Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");
				
				
				CSRLoginLogout.logout ();


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	

	//@Test(priority=27,enabled=true)
	public void Collections() throws Exception {

		FileName=  "ILP_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("Collections","Login-->Collections");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 

				CSRLoginLogout.login(SSN,AppURL);


				// Borrower link
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));

				driver.findElement(locator(prop.getProperty("borrower_tab"))).click();
				Thread.sleep(500);
				test.log(LogStatus.PASS, "Clicked on Borrower");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='901000']")));

				test.log(LogStatus.PASS, "Verifying the Registration link");
				if (driver.findElement(locator(prop.getProperty("registration_link"))).isDisplayed()) {
					test.log(LogStatus.PASS, "Verifying registration link is enabled");
					test.log(LogStatus.PASS, "Borrower link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Borrower link is not working ");
				}
				// Collections link
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Collections")).click();
				Thread.sleep(500);
				test.log(LogStatus.PASS, "Clicked on collections link");
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				test.log(LogStatus.PASS, "Verifying the store dropdown");
				if (driver.findElement(By.name("requestBean.dealLocNbr")).isDisplayed()) {
					test.log(LogStatus.PASS, "store dropdown is enabled");
					test.log(LogStatus.PASS, "Collection link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Collection link is not working fine");
				}

				Select sel = new Select(driver.findElement(By.xpath(
						"//*[@id='Search']/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[3]/td[3]/select")));

				List<WebElement> elementCount = sel.getOptions();
				int no_records = elementCount.size();


				for (int i = 1; i < no_records; i++) {
					String option_name = driver.findElement(By
							.xpath("//*[@id='Search']/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[3]/td[3]/select/option["
									+ (i + 1) + "]"))
							.getText();
					test.log(LogStatus.PASS, option_name + " option is Selected from the list");
					new Select(driver.findElement(By
							.xpath("//*[@id='Search']/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[3]/td[3]/select")))
					.selectByIndex(i);

					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Cliked on search button");
					Thread.sleep(30000);
					try {
						String text = driver.findElement(By.xpath("//*[@id='errordata']/h3/font/ul")).getText();
						if (text.trim().equalsIgnoreCase("No records returned.")) {
							test.log(LogStatus.PASS, "No records are displayed");
							continue;
						}
					} catch (Exception e) {

					}
					if (driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).isDisplayed())

					{
						test.log(LogStatus.PASS, "Records are displayed for the search");
						test.log(LogStatus.PASS, "Verified the Go button for the records");
						test.log(LogStatus.PASS, "collection searching is Passed");
						test.log(LogStatus.PASS, "**********************************");
						break;
					} else {
						test.log(LogStatus.PASS, "collection searching is failed");
					}

				}

			}}CSRLoginLogout.logout ();}

	//@Test(priority=28,enabled=true)
	public void CourtesyCalls() throws Exception {

		FileName=  "ILP_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("Courtesy calls","Login-->CourtesyCalls");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 

				CSRLoginLogout.login(SSN,AppURL);


				// Borrower link
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));

				driver.findElement(locator(prop.getProperty("borrower_tab"))).click();
				Thread.sleep(500);
				test.log(LogStatus.PASS, "Clicked on Borrower");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='901000']")));

				test.log(LogStatus.PASS, "Verifying the Registration link");
				if (driver.findElement(locator(prop.getProperty("registration_link"))).isDisplayed()) {
					test.log(LogStatus.PASS, "Verifying registration link is enabled");
					test.log(LogStatus.PASS, "Borrower link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Borrower link is not working ");
				}
				// Courtesy link
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Courtesy Calls")).click();
				Thread.sleep(500);
				test.log(LogStatus.PASS, "Clicked on Courtesy Calls link");
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				test.log(LogStatus.PASS, "Verifying the store field");
				if (driver.findElement(By.name("requestBean.colLocNbr")).isDisplayed()) {
					test.log(LogStatus.PASS, "store number field is enabled");
					test.log(LogStatus.PASS, "Courtesy Calls link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Courtesy Calls link is not working fine");
				}

				Select sel = new Select(driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[1]/td[3]/select")));
				List<WebElement> elementCount = sel.getOptions();
				int no_records = elementCount.size();
				
				for (int i = 1; i < no_records; i++) {

					String option_name = driver
							.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[1]/td[3]/select/option[" + (i + 1) + "]"))
							.getAttribute("value");
					test.log(LogStatus.PASS, option_name + " option is Selected from the list");
					new Select(driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[1]/td[3]/select")))
					.selectByIndex(i);

					driver.findElement(By.name("searchajax")).click();
					test.log(LogStatus.PASS, "Cliked on search button");
					Thread.sleep(30000);
					try {
						String text = driver.findElement(By.xpath("//*[@id='errordata']/h3/font/ul")).getText();
						if (text.trim().equalsIgnoreCase("No records returned.")) {
							test.log(LogStatus.PASS, "No records are displayed");
							continue;
						}
					} catch (Exception e) {

					}

					// else
					{
						String loan_nmb = "7780840";
						driver.findElement(By
								.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input"))
						.click();

						// input[@name='myButton' and @value='Go']
						test.log(LogStatus.PASS, "clicked on Go for the searched record");
						Thread.sleep(10000);
						if (driver.findElement(By.name("transhistory")).isDisplayed()) {
							test.log(LogStatus.PASS, "Records are displayed for the search");
							test.log(LogStatus.PASS, "Verified the transaction History");
							test.log(LogStatus.PASS, "collection searching is Passed");
							test.log(LogStatus.PASS, "**********************************");
							break;
						} else {
							test.log(LogStatus.PASS, "collection searching is failed");
						}

					}

				}}
		}
		CSRLoginLogout.logout ();
	}
	

	
//---------------------------------------ILP---------------------------------------------------------------------	
	
	//*****************************************************ILP*********************************************
	//@Test(priority=26,enabled=true)
	public void HistoryILp() throws Exception{
		FileName=  "ILP_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("ILP_History","Login-->Transactions-->History");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 

				CSRLoginLogout.login(SSN,AppURL);
				ILPHistory.history(SSN, AppURL);
				CSRLoginLogout.logout ();

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}
	//@Test(priority=25,enabled=true)
	public void ILPpayoff() throws Exception{
		FileName=  "ILP_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("ILP_Buyback","Login-->Age the Store-->payment-->Buyback");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row);

				CSRLoginLogout.login(SSN,AppURL);
				ILP_AgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				CSRLoginLogout.login(SSN,AppURL);
				ILP_Payoff.payment(SSN, AppURL);
				CSRLoginLogout.logout ();

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}

	//@Test(priority=24,enabled=true)
	public void ILPRefinance() throws Exception{
		FileName=  "ILP_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("ILP_Refinance","Login-->Transactions-->Refinance");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 

				CSRLoginLogout.login(SSN,AppURL);
				ILPRefinanceprocess.Refinance(SSN, AppURL);
				CSRLoginLogout.logout ();

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}

	//@Test(priority=23,enabled=true)
	public void ILPpayment() throws Exception{
		FileName=  "ILP_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("ILP_Payment","Login-->Age the store to due date-->payment");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);
				ILP_AgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				CSRLoginLogout.login(SSN,AppURL);
				ILP_Payment.payment(SSN, AppURL);
				CSRLoginLogout.logout ();

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}


	//@Test(priority=22,enabled=true)
	public void ILPnewLoan() throws Exception{
		FileName=  "ILP_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("ILP_NewLoan","Login-->Transactions-->NewLoan");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);
				ILPCSRNewLoanPage.newLoan(SSN, AppURL);
				CSRLoginLogout.logout ();


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}


	//@Test(priority=21,enabled=true)
	public void ILPborrowreg() throws Exception{
		FileName=  "ILP_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("ILP_Borrower Registration","Login-->Home Screen-->Borrower Registration");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);
				ILP_CSRBorrowerRegistration.borrowerReg(SSN,AppURL);
				CSRLoginLogout.logout ();


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}


	//**************************************PDL****************************************************************************
	//@Test(priority=14,enabled=true)
	public void borrowreg() throws Exception{
		FileName=  "QC_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("PDL_Borrower Registration","Login-->Home Screen-->Borrower Registration");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);
				CSRBorrowerRegistration.borrowerReg(SSN,AppURL);
				CSRLoginLogout.logout ();


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}

	//@Test(priority=15,enabled=true)
	public void newLoan() throws Exception{
		FileName=  "QC_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("PDL_NewLoan","Login-->Transactions-->NewLoan");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);
				CSRNewLoanPage.newLoan(SSN, AppURL);
				CSRLoginLogout.logout ();


				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}

	//@Test(priority=16,enabled=true)

	public void search() throws Exception{

		FileName=  "QC_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("Search","Login-->Home Screen--> Borrower Search--> New Loan Search--> Transaction Search");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				CSRLoginLogout.login(SSN,AppURL);


				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				driver.switchTo().frame("topFrame");
				if( driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).isDisplayed()){

					test.log(LogStatus.PASS, "Borrower link is enabled");
					driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();			
					test.log(LogStatus.PASS, "Clicked on Borrower Registration");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");


					if(driver.findElement(By.cssSelector("li[id='902000']")).isDisplayed()){

						test.log(LogStatus.PASS, "Edit link is enabled");
						driver.findElement(By.cssSelector("li[id='902000']")).click();			 
						test.log(LogStatus.PASS, "Clicked on Edit link");
						driver.switchTo().frame("main");

						test.log(LogStatus.INFO, "****Borrower Search Started******");

						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
						driver.findElement(By.name("ssn2")).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
						driver.findElement(By.name("ssn3")).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);

						driver.findElement(By.name("submit1")).click();
						test.log(LogStatus.PASS, "Clicked on submit link");
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						if(driver.findElement(By.xpath("//*[contains(text(),'1-1')]")).isDisplayed()){

							String status=driver.findElement(By.xpath("//*[contains(text(),'1-1')]")).getText();
							test.log(LogStatus.PASS, "Search records: "+status);
							Assert.assertEquals("1 record(s) found. Showing 1-1",status);
							String ssnnum=driver.findElement(By.xpath("//*[@id='pic1']")).getText();
							test.log(LogStatus.PASS, "SSN number: "+ssnnum);
							String RegSSN1 = ssnnum.substring(0, 3);
							String RegSSN2 = ssnnum.substring(3,7);
							String RegSSN3 = ssnnum.substring(7,11);
							test.log(LogStatus.PASS, "Last four digits of Application SSN number: "+RegSSN3);
							Assert.assertEquals(SSN3,RegSSN3);

							test.log(LogStatus.PASS, "Borrower Search working");
							test.log(LogStatus.INFO, "****Borrower Search Successfull******");
						}
						else{
							test.log(LogStatus.FAIL, "Borrower Search Failed");
						}
					}

				}

				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
				if( driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).isDisplayed()){

					test.log(LogStatus.PASS, "Loan Transactions link is enabled");
					driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");


					if(driver.findElement(By.cssSelector("li[id='911100']")).isDisplayed()){

						test.log(LogStatus.PASS, "New Loan is enabled");
						driver.findElement(By.cssSelector("li[id='911100']")).click();			 
						test.log(LogStatus.PASS, "Clicked on New Loan");
						driver.switchTo().frame("main");

						test.log(LogStatus.INFO, "****New Loan Search Started******");

						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
						driver.findElement(By.name("ssn2")).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
						driver.findElement(By.name("ssn3")).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);

						driver.findElement(By.name("submit1")).click();
						test.log(LogStatus.PASS, "Clicked on submit link");
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						if(driver.findElement(By.xpath("//*[contains(text(),'1-1')]")).isDisplayed()){

							String status=driver.findElement(By.xpath("//*[contains(text(),'1-1')]")).getText();
							test.log(LogStatus.PASS, "Search records: "+status);
							Assert.assertEquals("1 record(s) found. Showing 1-1",status);
							String ssnnum=driver.findElement(By.xpath("//*[@id='pic1']")).getText();
							test.log(LogStatus.PASS, "SSN number: "+ssnnum);
							String RegSSN1 = ssnnum.substring(0, 3);
							String RegSSN2 = ssnnum.substring(3,7);
							String RegSSN3 = ssnnum.substring(7,11);
							test.log(LogStatus.PASS, "Last four digits of Application SSN number: "+RegSSN3);
							Assert.assertEquals(SSN3,RegSSN3);

							test.log(LogStatus.PASS, "New Loan Search working");
							test.log(LogStatus.INFO, "******New Loan Search Successfull******");
						}
						else{
							test.log(LogStatus.FAIL, "New Loan Search Failed");
						}
					}					 				
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");					
					if(driver.findElement(By.cssSelector("li[id='911100']")).isDisplayed()){

						test.log(LogStatus.PASS, "Transactions is enabled");
						driver.findElement(By.cssSelector("li[id='911100']")).click();			 
						test.log(LogStatus.PASS, "Clicked on Transactions");
						driver.switchTo().frame("main");

						test.log(LogStatus.INFO, "****Transactions Search Started******");

						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
						driver.findElement(By.name("ssn2")).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
						driver.findElement(By.name("ssn3")).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);

						driver.findElement(By.name("submit1")).click();
						test.log(LogStatus.PASS, "Clicked on submit link");
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						if(driver.findElement(By.xpath("//*[contains(text(),'1-1')]")).isDisplayed()){

							String status=driver.findElement(By.xpath("//*[contains(text(),'1-1')]")).getText();
							test.log(LogStatus.PASS, "Search records: "+status);
							Assert.assertEquals("1 record(s) found. Showing 1-1",status);
							String ssnnum=driver.findElement(By.xpath("//*[@id='pic1']")).getText();
							test.log(LogStatus.PASS, "SSN number: "+ssnnum);
							String RegSSN1 = ssnnum.substring(0, 3);
							String RegSSN2 = ssnnum.substring(3,7);
							String RegSSN3 = ssnnum.substring(7,11);
							test.log(LogStatus.PASS, "Last four digits of Application SSN number: "+RegSSN3);
							Assert.assertEquals(SSN3,RegSSN3);

							test.log(LogStatus.PASS, "Transactions Search working");
							test.log(LogStatus.INFO, "*****Transactions Search Successfull******");
						}
						else{
							test.log(LogStatus.FAIL, "Transactions Search Failed");
						}
					}

					CSRSmokeLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
				}
			}
		}}
	



	//@Test(priority=17,enabled=true)
	public void partialpayment() throws Exception{
		FileName=  "QC_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("PDL_partialpayment","Login-->Home Age the store to due date-->Payment");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 

				CSRLoginLogout.login(SSN,AppURL);
				AgestoreToDuedate.runscheduler(SSN, AppURL);

				CSRLoginLogout.login(SSN,AppURL);
				Partialpayment.payment(SSN, AppURL);
				CSRLoginLogout.logout ();

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}


	//@Test(priority=18,enabled=true)
	public void refinance() throws Exception{
		FileName=  "QC_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("PDL_Refinance","Login-->Transactions-->Refinance");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 

				CSRLoginLogout.login(SSN,AppURL);
				QCRefinance.Refinance(SSN, AppURL);
				CSRLoginLogout.logout ();

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}


	//@Test(priority=19,enabled=true)
	public void buyBack() throws Exception{
		FileName=  "QC_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("PDL_Buyback","Login-->Age the Store to due date-->Buyback");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 

				CSRLoginLogout.login(SSN,AppURL);
				AgestoreToDuedate.runscheduler(SSN, AppURL);
				
				CSRLoginLogout.login(SSN,AppURL);
				PDLCSRBuyBack.buyback(SSN, AppURL);
				CSRLoginLogout.logout ();

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}


	//@Test(priority=20,enabled=true)
	public void history() throws Exception{
		FileName=  "QC_BorrowerRegistration_NewLoan.xls";
		test=reports.startTest("PDL_History","Login-->Transaction-->History");


		TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		String sheetName="Start";
		int lastrow=TestData.getLastRow("Start");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 

				CSRLoginLogout.login(SSN,AppURL);
				History.history(SSN, AppURL);
				CSRLoginLogout.logout ();

				test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
			}}}


	//****************************************************************************************************************************
	//@Test(priority=1,enabled=true)

	public void login() throws Exception{

		FileName="QC_Smoke.xls";
		test=reports.startTest("CSR Login","Login Scenario");

		TestData = new Excel(System.getProperty("user.dir")+"/Testdata/"+FileName);
		CSRSmokeLoginLogout.csrlogin();

		driver.switchTo().frame("topFrame");
		if( driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).isDisplayed()){
			test.log(LogStatus.PASS, "Loan transactions link is enabled");
		}
		test.log(LogStatus.PASS, "Login is  successfully");
		CSRLoginLogout.logout();
		test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");

	}

	//@Test(priority=2,enabled=true)

	public void Adminlogin() throws Exception{


		FileName="QC_Smoke.xls";
		test=reports.startTest("Admin Login","Admin Login");

		TestData = new Excel(System.getProperty("user.dir")+"/Testdata/"+FileName);
		QCAdminLoginLogout.adminlogin();

		driver.switchTo().frame("mainFrame");
		if( driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[1]/td")).getText().equalsIgnoreCase("qfund")){
			test.log(LogStatus.PASS, "Qfund text validation successfull");
		}
		test.log(LogStatus.PASS, "Admin Login   successfully");
		test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
	}


	//@Test(priority=3,enabled=true)

	public void borrower() throws Exception{

		FileName="QC_Smoke.xls";
		test=reports.startTest("Borrower","Login-->Borrower");

		TestData = new Excel(System.getProperty("user.dir")+"/Testdata/"+FileName);
		CSRSmokeLoginLogout.csrlogin();
		// Borrower link
		driver.switchTo().frame("topFrame");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));

		driver.findElement(locator(prop.getProperty("borrower_tab"))).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on Borrower");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='901000']")));

		test.log(LogStatus.PASS, "Verifying the Registration link");
		if (driver.findElement(locator(prop.getProperty("registration_link"))).isDisplayed()) {
			test.log(LogStatus.PASS, "Verifying registration link is enabled");
			test.log(LogStatus.PASS, "Borrower link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Borrower link is not working ");
		}

		// Registration link
		driver.findElement(locator(prop.getProperty("registration_link"))).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on Registration link");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");

		test.log(LogStatus.PASS, "Verifying the product type dropdown");
		if (driver.findElement(By.name("customerBean.custProdType")).isDisplayed()) {
			test.log(LogStatus.PASS, "Product type dropdown is enabled");
			test.log(LogStatus.PASS, "Registration link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Registration link is not working fine");
		}

		Thread.sleep(500);
		// Edit link
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on Edit link");
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");

		test.log(LogStatus.PASS, "Verifying the first name field");
		if (driver.findElement(By.name("requestBean.firstNames")).isDisplayed()) {
			test.log(LogStatus.PASS, "first name field is enabled");
			test.log(LogStatus.PASS, "Edit link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Edit link is not working fine");
		}
		// Collections link
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collections")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on collections link");
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");

		test.log(LogStatus.PASS, "Verifying the store dropdown");
		if (driver.findElement(By.name("requestBean.dealLocNbr")).isDisplayed()) {
			test.log(LogStatus.PASS, "store dropdown is enabled");
			test.log(LogStatus.PASS, "Collection link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Collection link is not working fine");
		}

		//Thread.sleep(2000);
		// Bankrupt/Deceased Suite link
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Bankrupt/Deceased Suite")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on Bankrupt/Deceased Suite link");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");

		test.log(LogStatus.PASS, "Verifying the store field");
		if (driver.findElement(By.name("requestBean.bnklocnbr")).isDisplayed()) {
			test.log(LogStatus.PASS, "store number field is enabled");
			test.log(LogStatus.PASS, "Bankrupt/Deceased Suite link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Bankrupt/Deceased Suite link is not working fine");
		}

		Thread.sleep(500);

		// Courtesy Calls link
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Courtesy Calls")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on Courtesy Calls link");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");

		test.log(LogStatus.PASS, "Verifying the store field");
		if (driver.findElement(By.name("requestBean.colLocNbr")).isDisplayed()) {
			test.log(LogStatus.PASS, "store number field is enabled");
			test.log(LogStatus.PASS, "Courtesy Calls link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Courtesy Calls link is not working fine");
		}

		Thread.sleep(500);
		// Emp Movement link
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Emp Movement")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on Emp Movement link");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");

		test.log(LogStatus.PASS, "Verifying the employee number field");
		if (driver.findElement(By.name("requestBean.empNbr")).isDisplayed()) {
			test.log(LogStatus.PASS, "employee number field is enabled");
			test.log(LogStatus.PASS, "Emp Movement link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Emp Movement link is not working fine");
		}

		Thread.sleep(500);
		// Active Military link
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Active Military")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on Active Military link");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");

		test.log(LogStatus.PASS, "Verifying the Store number field");
		if (driver.findElement(By.name("requestBean.bnklocnbr")).isDisplayed()) {
			test.log(LogStatus.PASS, "Store number field is enabled");
			test.log(LogStatus.PASS, "Active Military link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Active Military link is not working fine");
		}

		Thread.sleep(500);
		// Edit SSN link
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Edit SSN")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on Edit SSN link");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");

		test.log(LogStatus.PASS, "Verifying the Store number field");
		if (driver.findElement(By.name("requestBean.locationNbr")).isDisplayed()) {
			test.log(LogStatus.PASS, "Store number field is enabled");
			test.log(LogStatus.PASS, "Edit SSN link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Edit SSN link is not working fine");
		}


		// Bank Master link
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Bank Master")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on Bank Master link");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		test.log(LogStatus.PASS, "Verifying the Add Bank link");
		if (driver.findElement(By.linkText("Add Bank")).isDisplayed()) {
			test.log(LogStatus.PASS, "Add Bank is displayed");
			test.log(LogStatus.PASS, "Bank Master link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Bank Master link is not working fine");
		}


		CSRLoginLogout.logout();
		test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");

	}

	//@Test(priority=4,enabled=true)

	public void borrowerSublinks() throws Exception{

		FileName="QC_Smoke.xls";
		test=reports.startTest("Borrower_Sublinks","Login-->Borrower-->Borrower_Sublinks");

		TestData = new Excel(System.getProperty("user.dir")+"/Testdata/"+FileName);
		CSRSmokeLoginLogout.csrlogin();
		// Borrower link
		driver.switchTo().frame("topFrame");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
		driver.findElement(locator(prop.getProperty("borrower_tab"))).click();
		Thread.sleep(500);
		//Bank Master link --> Add Bank Sub-link
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		Actions action = new Actions(driver);  
		WebElement bank=driver.findElement(By.linkText("Bank Master"));
		action.moveToElement(bank).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on Bank Master Link");
		Thread.sleep(500);
		driver.findElement(By.id("988190804")).click();
		test.log(LogStatus.PASS, " click on Add Bank Sub-link");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");
		test.log(LogStatus.PASS, "Verifying the Add Bank link");
		if (driver.findElement(By.xpath("//td[text()='ABA Nbr  ']")).isDisplayed()) {
			test.log(LogStatus.PASS, "Add Bank is displayed");
			test.log(LogStatus.PASS, "Add Bank Sub-link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Add Bank Sub-link is not working fine");
		}

		CSRLoginLogout.logout();
		test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");

	}


	//@Test(priority=5,enabled=true)

	public void LoanTransactions() throws Exception{


		FileName="QC_Smoke.xls";
		test=reports.startTest("LoanTransactions ","Login-->Loan transactions");

		TestData = new Excel(System.getProperty("user.dir")+"/Testdata/"+FileName);
		CSRSmokeLoginLogout.csrlogin();

		driver.switchTo().frame("topFrame");
		if( driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).isDisplayed()){

			test.log(LogStatus.PASS, "Loan transactions link is enabled");
			driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
			test.log(LogStatus.PASS, "Clicked on Loan Transactions");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");

			if(driver.findElement(By.cssSelector("li[id='911100']")).isDisplayed()){

				test.log(LogStatus.PASS, "New loan link is enabled");
				driver.findElement(By.cssSelector("li[id='911100']")).click();			 
				test.log(LogStatus.PASS, "Clicked on New Loan");
				driver.switchTo().frame("main");
				String fname=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[1]")).getText();

				Assert.assertEquals("First Name",fname);
				test.log(LogStatus.PASS, "NewLoan page working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "New loan is disabled");
			}

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			if(driver.findElement(By.cssSelector("li[id='911101']")).isDisplayed()){

				test.log(LogStatus.PASS, "Transaction  link is enabled");
				driver.findElement(By.cssSelector("li[id='911101']")).click();			 
				test.log(LogStatus.PASS, "Clicked transaction");
				driver.switchTo().frame("main");		
				String fname=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[1]")).getText();

				Assert.assertEquals("First Name",fname);
				test.log(LogStatus.PASS, "Transaction  is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "Transaction  link is disabled");
			}

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			if(driver.findElement(By.cssSelector("li[id='988190800']")).isDisplayed()){

				test.log(LogStatus.PASS, "Debit cards  link is enabled");
				driver.findElement(By.cssSelector("li[id='988190800']")).click();			 
				test.log(LogStatus.PASS, "Clicked debit card");

				String product=driver.findElement(By.partialLinkText("Installment Loan")).getText();

				Assert.assertEquals("Installment Loan",product);
				test.log(LogStatus.PASS, "debit card is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "Debit card  link is disabled");
			}


			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			if(driver.findElement(By.cssSelector("li[id='913000']")).isDisplayed()){

				test.log(LogStatus.PASS, "ACH  link is enabled");
				driver.findElement(By.cssSelector("li[id='988190800']")).click();			 
				test.log(LogStatus.PASS, "Clicked Ach");

				String product=driver.findElement(By.partialLinkText("Payday Loan")).getText();
				Assert.assertEquals("Payday Loan",product);
				test.log(LogStatus.PASS, "ACH module is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "ACH   link is disabled");
			}
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			if(driver.findElement(By.cssSelector("li[id='959003']")).isDisplayed()){
				test.log(LogStatus.PASS, "Letter management  link is enabled");
				driver.findElement(By.cssSelector("li[id='959003']")).click();			 
				test.log(LogStatus.PASS, "Clicked Letter management");
				driver.switchTo().frame("main");
				String field=driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[1]")).getText();
				Assert.assertEquals("Store Nbr",field);
				test.log(LogStatus.PASS, "Letter management is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "Letter management  link is disabled");
			}

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			if(driver.findElement(By.cssSelector("li[id='95519019']")).isDisplayed()){

				test.log(LogStatus.PASS, "Collateral checks link is enabled");
				driver.findElement(By.cssSelector("li[id='95519019']")).click();			 
				test.log(LogStatus.PASS, "Clicked on Collateral checks");

				String product=driver.findElement(By.partialLinkText("Payday Loan")).getText();
				Assert.assertEquals("Payday Loan",product);
				test.log(LogStatus.PASS, "Collateral checks is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "Collateral checks  link is disabled");
			}


			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			if(driver.findElement(By.cssSelector("li[id='955190063']")).isDisplayed()){

				test.log(LogStatus.PASS, "Issuer details link is enabled");
				driver.findElement(By.cssSelector("li[id='955190063']")).click();			 
				test.log(LogStatus.PASS, "Clicked on Issuer details");

				String product=driver.findElement(By.partialLinkText("Assign Warnings")).getText();
				Assert.assertEquals("Assign Warnings",product);
				test.log(LogStatus.PASS, "Issuer details is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "Issuer details  link is disabled");
			}
			if(driver.findElement(By.cssSelector("li[id='988190528']")).isDisplayed()){

				test.log(LogStatus.PASS, "New Check cashing link is enabled");
				driver.findElement(By.cssSelector("li[id='988190528']")).click();			 
				test.log(LogStatus.PASS, "Clicked on New Check cashing");
				driver.switchTo().frame("main");
				String fname=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[1]")).getText();

				Assert.assertEquals("First Name",fname);
				test.log(LogStatus.PASS, "New Check cashing is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "New Check cashing is disabled");
			}

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			if(driver.findElement(By.cssSelector("li[id='988190659']")).isDisplayed()){

				test.log(LogStatus.PASS, "return check print link is enabled");
				driver.findElement(By.cssSelector("li[id='988190659']")).click();			 
				test.log(LogStatus.PASS, " click on return check print link");
				driver.switchTo().frame("main");
				String loannbr=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td[1]/span")).getText();

				Assert.assertEquals("Loan Nbr*",loannbr);
				test.log(LogStatus.PASS, "return check print is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "return check print is disabled");
			}

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");

			if(driver.findElement(By.cssSelector("li[id='9881908122']")).isDisplayed()){

				test.log(LogStatus.PASS, "Manual default link is enabled");
				driver.findElement(By.cssSelector("li[id='9881908122']")).click();			 
				test.log(LogStatus.PASS, "click on return Manual default link");
				driver.switchTo().frame("main");
				String CustomerNbr=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[1]/td[1]")).getText();

				Assert.assertEquals("Customer Nbr",CustomerNbr);
				test.log(LogStatus.PASS, "Manual default link is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "Manual default link is disabled");
			}

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");

			if(driver.findElement(By.cssSelector("li[id='9881908139']")).isDisplayed()){

				test.log(LogStatus.PASS, "Void Manual default link is enabled");
				driver.findElement(By.cssSelector("li[id='9881908139']")).click();			 
				test.log(LogStatus.PASS, "click on Void Manual default link");
				driver.switchTo().frame("main");
				String CustomerNbr=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[1]/td[1]")).getText();

				Assert.assertEquals("Customer Nbr",CustomerNbr);
				test.log(LogStatus.PASS, "Void Manual default link is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, " Void Manual default link is disabled");
			}
		}
		else{
			test.log(LogStatus.FAIL, "Loan transactions link is disabled");
		}

		CSRSmokeLoginLogout.logout();;

		test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
	}

	//@Test(priority=6,enabled=true)

	public void LoanTransactionsSbulinks() throws Exception{


		FileName="QC_Smoke.xls";
		test=reports.startTest("LoanTransactions_Sublinks","Login-->Loan transactions-->Loan transactions_Sublinks");

		TestData = new Excel(System.getProperty("user.dir")+"/Testdata/"+FileName);

		CSRSmokeLoginLogout.csrlogin();

		driver.switchTo().frame("topFrame");
		if( driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).isDisplayed()){

			test.log(LogStatus.PASS, "Loan transactions link is enabled");
			driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
			test.log(LogStatus.PASS, "Clicked on Loan Transactions");
			DebitCard();
			ACH();					
			collateralchecks();
			IssuerDetails();
		}
		else{
			test.log(LogStatus.FAIL, "Loan transactions link is disabled");
		}

		CSRLoginLogout.logout();;

		test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
	}
	public static void DebitCard() throws Exception
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");

		Actions action = new Actions(driver);
		WebElement debit=driver.findElement(By.cssSelector("li[id='988190800']"));
		WebElement instal=driver.findElement(By.cssSelector("li[id='988190835']"));
		WebElement Payday=driver.findElement(By.cssSelector("li[id='988190836']"));
		WebElement title=driver.findElement(By.cssSelector("li[id='988190836']"));

		if(driver.findElement(By.cssSelector("li[id='988190800']")).isDisplayed()){	 
			action.moveToElement(debit).build().perform();
			test.log(LogStatus.PASS, " Mouse hover on Debit Card Link");
			Thread.sleep(500);
			String product=driver.findElement(By.partialLinkText("Installment Loan")).getText();

			Assert.assertEquals("Installment Loan",product);
			test.log(LogStatus.PASS, "Debit card is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Debit card  link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		action.moveToElement(debit).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on Debit Card Link");
		Thread.sleep(500);

		if(driver.findElement(By.cssSelector("li[id='988190835']")).isDisplayed()){
			test.log(LogStatus.PASS, "Installment loan Sub-link is enabled"); 
			action.moveToElement(instal).build().perform();
			test.log(LogStatus.PASS, " Mouse hover on Installment Loan Sub-Link");
			Thread.sleep(500);
			String Deposit=driver.findElement(By.partialLinkText("Deposit")).getText();
			Assert.assertEquals("Deposit",Deposit);
			test.log(LogStatus.PASS, "Debit card -->Installment loan Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Debit card -->Installment loan Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		action.moveToElement(debit).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on Debit Card Link");
		Thread.sleep(500); 
		action.moveToElement(instal).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on Installment Loan Sub-Link");
		Thread.sleep(500);			
		if(driver.findElement(By.linkText("Deposit")).isDisplayed()){
			test.log(LogStatus.PASS, "Deposit Child-link is enabled"); 
			driver.findElement(By.linkText("Deposit")).click();
			test.log(LogStatus.PASS, " Click on Deposit Child-link");
			Thread.sleep(500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Debit card -->Installment Loan -->Deposit Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Debit card -->Installment Loan -->Deposit Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		action.moveToElement(debit).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on Debit Card Link");
		Thread.sleep(500);	
		action.moveToElement(instal).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on Installment Loan Sub-Link");
		Thread.sleep(500);

		if(driver.findElement(By.linkText("ReDeposit/Representment")).isDisplayed()){
			test.log(LogStatus.PASS, "ReDeposit/Representment Child-link is enabled"); 
			Thread.sleep(3000);
			driver.findElement(By.linkText("ReDeposit/Representment")).click();
			test.log(LogStatus.PASS, " Click on ReDeposit/Representment Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Debit card -->Installment Loan -->ReDeposit/Representment Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Debit card -->Installment Loan -->ReDeposit/Representment Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		action.moveToElement(debit).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on Debit Card Link");
		Thread.sleep(1500);

		if(driver.findElement(By.cssSelector("li[id='988190836']")).isDisplayed()){
			test.log(LogStatus.PASS, "Payday loan Sub-link is enabled"); 
			action.moveToElement(Payday).build().perform();
			test.log(LogStatus.PASS, " Mouse hover on Payday Loan Sub-Link");
			Thread.sleep(1500);
			String Deposit=driver.findElement(By.partialLinkText("Deposit")).getText();
			Assert.assertEquals("Deposit",Deposit);
			test.log(LogStatus.PASS, "Debit card -->Payday loan Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Debit card -->Payday loan Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		action.moveToElement(debit).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on Debit Card Link");
		Thread.sleep(1500);
		action.moveToElement(Payday).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on Payday Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("Deposit")).isDisplayed()){
			test.log(LogStatus.PASS, "Deposit Child-link is enabled"); 
			driver.findElement(By.linkText("Deposit")).click();
			test.log(LogStatus.PASS, " Click on Deposit Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Debit card -->Payday Loan -->Deposit Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Debit card -->Payday Loan -->Deposit Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		action.moveToElement(debit).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on Debit Card Link");
		Thread.sleep(1500);	
		action.moveToElement(Payday).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on Payday Loan Sub-Link");
		Thread.sleep(1500);

		if(driver.findElement(By.linkText("ReDeposit/Representment")).isDisplayed()){
			test.log(LogStatus.PASS, "ReDeposit/Representment Child-link is enabled");
			Thread.sleep(1500);
			driver.findElement(By.linkText("ReDeposit/Representment")).click();
			test.log(LogStatus.PASS, " Click on ReDeposit/Representment Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Debit card -->Payday Loan -->ReDeposit/Representment Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Debit card -->Payday Loan -->ReDeposit/Representment Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		action.moveToElement(debit).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on Debit Card Link");
		Thread.sleep(1500);

		if(driver.findElement(By.cssSelector("li[id='9881908052']")).isDisplayed()){
			test.log(LogStatus.PASS, "Title loan Sub-link is enabled"); 
			action.moveToElement(title).build().perform();
			test.log(LogStatus.PASS, " Mouse hover on title Loan Sub-Link");
			Thread.sleep(1500);
			String Deposit=driver.findElement(By.partialLinkText("Deposit")).getText();
			Assert.assertEquals("Deposit",Deposit);
			test.log(LogStatus.PASS, "Debit card -->Title loan Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Debit card -->Title loan Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		action.moveToElement(debit).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on Debit Card Link");
		Thread.sleep(1500);
		action.moveToElement(title).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on title Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("Deposit")).isDisplayed()){
			test.log(LogStatus.PASS, "Deposit Child-link is enabled"); 
			driver.findElement(By.linkText("Deposit")).click();
			test.log(LogStatus.PASS, " Click on Deposit Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Debit card -->Title Loan -->Deposit Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Debit card -->Title Loan -->Deposit Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		action.moveToElement(debit).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on Debit Card Link");
		Thread.sleep(1500);	
		action.moveToElement(title).build().perform();
		test.log(LogStatus.PASS, " Mouse hover on title Loan Sub-Link");
		Thread.sleep(1500);

		if(driver.findElement(By.linkText("ReDeposit/Representment")).isDisplayed()){
			test.log(LogStatus.PASS, "ReDeposit/Representment Child-link is enabled"); 
			driver.findElement(By.linkText("ReDeposit/Representment")).click();
			test.log(LogStatus.PASS, " Click on ReDeposit/Representment Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Debit card -->Title Loan -->ReDeposit/Representment Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Debit card -->Title Loan -->ReDeposit/Representment Child-link is disabled");
		}
	}
	public static void ACH() throws Exception
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		if(driver.findElement(By.linkText("ACH")).isDisplayed()){

			test.log(LogStatus.PASS, "ACH  link is enabled");
			driver.findElement(By.linkText("ACH")).click();			 
			test.log(LogStatus.PASS, "Clicked on ACH");
			Thread.sleep(1500);
			String product=driver.findElement(By.partialLinkText("Payday Loan")).getText();
			Assert.assertEquals("Payday Loan",product);
			test.log(LogStatus.PASS, "ACH module is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH   link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");		
		driver.findElement(By.linkText("ACH")).click();			 
		test.log(LogStatus.PASS, "Clicked on ACH");
		Thread.sleep(1500);
		if(driver.findElement(By.linkText("Payday Loan")).isDisplayed()){
			test.log(LogStatus.PASS, "Payday loan Sub-link is enabled"); 
			driver.findElement(By.linkText("Payday Loan")).click();
			test.log(LogStatus.PASS, " Click on Payday Loan Sub-Link");
			Thread.sleep(1500);
			String Deposit=driver.findElement(By.partialLinkText("ACH Deposit")).getText();
			Assert.assertEquals("ACH Deposit",Deposit);
			test.log(LogStatus.PASS, "ACH -->Payday loan Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH -->Payday loan Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("ACH")).click();			 
		test.log(LogStatus.PASS, "Clicked on ACH");
		Thread.sleep(1500);
		driver.findElement(By.linkText("Payday Loan")).click();
		test.log(LogStatus.PASS, " Click on Payday Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("ACH Deposit")).isDisplayed()){
			test.log(LogStatus.PASS, "ACH Deposit Child-link is enabled"); 
			driver.findElement(By.linkText("ACH Deposit")).click();
			test.log(LogStatus.PASS, " Click on ACH Deposit Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "ACH -->Payday Loan -->ACH Deposit Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH -->Payday Loan -->ACH Deposit Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("ACH")).click();			 
		test.log(LogStatus.PASS, "Clicked on ACH");
		Thread.sleep(2000);
		try{
		driver.findElement(By.xpath("//*[@id='913010']/a")).click();
		test.log(LogStatus.PASS, " Click on Payday Loan Sub-Link");
		}
		catch(Exception e)
		{
		driver.findElement(By.linkText("Payday Loan")).click();
		test.log(LogStatus.PASS, " Click on Payday Loan Sub-Link");
		}
		
		test.log(LogStatus.PASS, " Click on Payday Loan Sub-Link");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("ACH Clear")));
		if(driver.findElement(By.linkText("ACH Clear")).isDisplayed()){
			test.log(LogStatus.PASS, "ACH Clear Child-link is enabled"); 
			driver.findElement(By.linkText("ACH Clear")).click();
			test.log(LogStatus.PASS, " Click on ACH Clear Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "ACH -->Payday Loan -->ACH Clear Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH -->Payday Loan -->ACH Clear Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("ACH")).click();			 
		test.log(LogStatus.PASS, "Clicked on ACH");
		Thread.sleep(1500);
		driver.findElement(By.linkText("Payday Loan")).click();
		test.log(LogStatus.PASS, " Click on Payday Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("ACH Clear")).isDisplayed()){
			test.log(LogStatus.PASS, "ACH Clear Child-link is enabled"); 
			driver.findElement(By.linkText("ACH Clear")).click();
			test.log(LogStatus.PASS, " Click on ACH Clear Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "ACH -->Payday Loan -->ACH Clear Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH -->Payday Loan -->ACH Clear Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("ACH")).click();			 
		test.log(LogStatus.PASS, "Clicked on ACH");
		Thread.sleep(1500);
		driver.findElement(By.linkText("Payday Loan")).click();
		test.log(LogStatus.PASS, " Click on Payday Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("ReDeposit/Representment")).isDisplayed()){
			test.log(LogStatus.PASS, "ReDeposit/Representment Child-link is enabled"); 
			driver.findElement(By.linkText("ReDeposit/Representment")).click();
			test.log(LogStatus.PASS, " Click on ReDeposit/Representment Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "ACH -->Payday Loan -->ReDeposit/Representment Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH -->Payday Loan -->ReDeposit/Representment Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");								
		driver.findElement(By.linkText("ACH")).click();			 
		test.log(LogStatus.PASS, "Clicked on ACH");
		Thread.sleep(1500);
		if(driver.findElement(By.linkText("Installment Loan")).isDisplayed()){
			test.log(LogStatus.PASS, "Installment Loan Sub-link is enabled"); 
			driver.findElement(By.linkText("Installment Loan")).click();
			test.log(LogStatus.PASS, " Click on Installment Loan Sub-Link");
			Thread.sleep(1500);
			String Deposit=driver.findElement(By.partialLinkText("ACH Deposit")).getText();
			Assert.assertEquals("ACH Deposit",Deposit);
			test.log(LogStatus.PASS, "ACH -->Installment Loan Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH -->Installment Loan Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("ACH")).click();			 
		test.log(LogStatus.PASS, "Clicked on ACH");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Installment Loan")).click();
		test.log(LogStatus.PASS, " Click on Installment Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("ACH Deposit")).isDisplayed()){
			test.log(LogStatus.PASS, "ACH Deposit Child-link is enabled"); 
			driver.findElement(By.linkText("ACH Deposit")).click();
			test.log(LogStatus.PASS, " Click on ACH Deposit Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "ACH -->Installment Loan -->ACH Deposit Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH -->Installment Loan -->ACH Deposit Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("ACH")).click();			 
		test.log(LogStatus.PASS, "Clicked on ACH");
		Thread.sleep(1500);
		driver.findElement(By.linkText("Installment Loan")).click();
		test.log(LogStatus.PASS, " Click on Installment Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("ACH Clear")).isDisplayed()){
			test.log(LogStatus.PASS, "ACH Clear Child-link is enabled"); 
			driver.findElement(By.linkText("ACH Clear")).click();
			test.log(LogStatus.PASS, " Click on ACH Clear Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "ACH -->Installment Loan -->ACH Clear Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH -->Installment Loan -->ACH Clear Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("ACH")).click();			 
		test.log(LogStatus.PASS, "Clicked on ACH");
		Thread.sleep(1500);
		driver.findElement(By.linkText("Installment Loan")).click();
		test.log(LogStatus.PASS, " Click on Installment Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("ReDeposit/Representment")).isDisplayed()){
			test.log(LogStatus.PASS, "ReDeposit/Representment Child-link is enabled"); 
			driver.findElement(By.linkText("ReDeposit/Representment")).click();
			test.log(LogStatus.PASS, " Click on ReDeposit/Representment Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "ACH -->Installment Loan -->ReDeposit/Representment Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH -->Installment Loan -->ReDeposit/Representment Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("ACH")).click();			 
		test.log(LogStatus.PASS, "Clicked on ACH");
		Thread.sleep(1500);
		driver.findElement(By.linkText("Installment Loan")).click();
		test.log(LogStatus.PASS, " Click on Installment Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("ReDeposit Clear")).isDisplayed()){
			test.log(LogStatus.PASS, "ReDeposit Clear Child-link is enabled"); 
			driver.findElement(By.linkText("ReDeposit Clear")).click();
			test.log(LogStatus.PASS, " Click on ReDeposit Clear Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "ACH -->Installment Loan -->ReDeposit Clear Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH -->Installment Loan -->ReDeposit Clear Child-link is disabled");
		}	

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");								
		driver.findElement(By.linkText("ACH")).click();			 
		test.log(LogStatus.PASS, "Clicked on ACH");
		Thread.sleep(1500);
		if(driver.findElement(By.linkText("Title Loan")).isDisplayed()){
			test.log(LogStatus.PASS, "Title Loan Sub-link is enabled"); 
			driver.findElement(By.linkText("Title Loan")).click();
			test.log(LogStatus.PASS, " Click on Title Loan Sub-Link");
			Thread.sleep(1500);
			String Deposit=driver.findElement(By.partialLinkText("ACH Deposit")).getText();
			Assert.assertEquals("ACH Deposit",Deposit);
			test.log(LogStatus.PASS, "ACH -->Title Loan Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH -->Title Loan Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("ACH")).click();			 
		test.log(LogStatus.PASS, "Clicked on ACH");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Title Loan")).click();
		test.log(LogStatus.PASS, " Click on Title Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("ACH Deposit")).isDisplayed()){
			test.log(LogStatus.PASS, "ACH Deposit Child-link is enabled"); 
			driver.findElement(By.linkText("ACH Deposit")).click();
			test.log(LogStatus.PASS, " Click on ACH Deposit Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "ACH -->Title Loan -->ACH Deposit Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH -->Title Loan -->ACH Deposit Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("ACH")).click();			 
		test.log(LogStatus.PASS, "Clicked on ACH");
		Thread.sleep(1500);
		driver.findElement(By.linkText("Title Loan")).click();
		test.log(LogStatus.PASS, " Click on Title Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("ACH Clear")).isDisplayed()){
			test.log(LogStatus.PASS, "ACH Clear Child-link is enabled"); 
			driver.findElement(By.linkText("ACH Clear")).click();
			test.log(LogStatus.PASS, " Click on ACH Clear Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "ACH -->Title Loan -->ACH Clear Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH -->Title Loan -->ACH Clear Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("ACH")).click();			 
		test.log(LogStatus.PASS, "Clicked on ACH");
		Thread.sleep(1500);
		driver.findElement(By.linkText("Title Loan")).click();
		test.log(LogStatus.PASS, " Click on Title Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("ReDeposit/Representment")).isDisplayed()){
			test.log(LogStatus.PASS, "ReDeposit/Representment Child-link is enabled"); 
			driver.findElement(By.linkText("ReDeposit/Representment")).click();
			test.log(LogStatus.PASS, " Click on ReDeposit/Representment Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "ACH -->Title Loan -->ReDeposit/Representment Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "ACH -->Title Loan -->ReDeposit/Representment Child-link is disabled");
		}	
	}
	public static void collateralchecks() throws Exception
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");

		if(driver.findElement(By.linkText("Collateral Checks")).isDisplayed()){

			test.log(LogStatus.PASS, "Collateral checks link is enabled");
			driver.findElement(By.linkText("Collateral Checks")).click();			 
			test.log(LogStatus.PASS, "Clicked on Collateral checks");

			String product=driver.findElement(By.partialLinkText("Payday Loan")).getText();
			Assert.assertEquals("Payday Loan",product);
			test.log(LogStatus.PASS, "Collateral checks is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral checks  link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");		
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1500);
		if(driver.findElement(By.linkText("Payday Loan")).isDisplayed()){
			test.log(LogStatus.PASS, "Payday loan Sub-link is enabled"); 
			driver.findElement(By.linkText("Payday Loan")).click();
			test.log(LogStatus.PASS, " Click on Payday Loan Sub-Link");
			Thread.sleep(1500);
			String Deposit=driver.findElement(By.partialLinkText("Deposit")).getText();
			Assert.assertEquals("Deposit",Deposit);
			test.log(LogStatus.PASS, "Collateral Checks -->Payday loan Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Payday loan Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Payday Loan")).click();
		test.log(LogStatus.PASS, " Click on Payday Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("Deposit")).isDisplayed()){
			test.log(LogStatus.PASS, "Deposit Child-link is enabled"); 
			driver.findElement(By.linkText("Deposit")).click();
			test.log(LogStatus.PASS, " Click on Deposit Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Collateral Checks -->Payday Loan -->Deposit Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Payday Loan -->Deposit Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Payday Loan")).click();
		test.log(LogStatus.PASS, " Click on Payday Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("Clear")).isDisplayed()){
			test.log(LogStatus.PASS, "Clear Child-link is enabled"); 
			driver.findElement(By.linkText("Clear")).click();
			test.log(LogStatus.PASS, " Click on Clear Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Collateral Checks -->Payday Loan -->Clear Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Payday Loan -->Clear Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Payday Loan")).click();
		test.log(LogStatus.PASS, " Click on Payday Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("ReDeposit/Representment")).isDisplayed()){
			test.log(LogStatus.PASS, "Deposit Child-link is enabled"); 
			driver.findElement(By.linkText("ReDeposit/Representment")).click();
			test.log(LogStatus.PASS, " Click on ReDeposit/Representment Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Collateral Checks -->Payday Loan -->ReDeposit/Representment Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Payday Loan -->ReDeposit/Representment Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");		
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1500);
		if(driver.findElement(By.linkText("Installment Loan")).isDisplayed()){
			test.log(LogStatus.PASS, "Installment Loan Sub-link is enabled"); 
			driver.findElement(By.linkText("Installment Loan")).click();
			test.log(LogStatus.PASS, " Click on Installment Loan Sub-Link");
			Thread.sleep(1500);
			String Deposit=driver.findElement(By.linkText("Clear")).getText();
			Assert.assertEquals("Clear",Deposit);
			test.log(LogStatus.PASS, "Collateral Checks -->Installment Loan Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Installment Loan Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Installment Loan")).click();
		test.log(LogStatus.PASS, " Click on Installment Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("Clear")).isDisplayed()){
			test.log(LogStatus.PASS, "Clear Child-link is enabled"); 
			driver.findElement(By.linkText("Clear")).click();
			test.log(LogStatus.PASS, " Click on Clear Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Collateral Checks -->Installment Loan -->Clear Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Installment Loan -->Clear Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Installment Loan")).click();
		test.log(LogStatus.PASS, " Click on Installment Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("ReDeposit/Representment")).isDisplayed()){
			test.log(LogStatus.PASS, "Deposit Child-link is enabled"); 
			driver.findElement(By.linkText("ReDeposit/Representment")).click();
			test.log(LogStatus.PASS, " Click on ReDeposit/Representment Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Collateral Checks -->Installment Loan -->ReDeposit/Representment Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Installment Loan -->ReDeposit/Representment Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Installment Loan")).click();
		test.log(LogStatus.PASS, " Click on Installment Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("Deposit")).isDisplayed()){
			test.log(LogStatus.PASS, "Deposit Child-link is enabled"); 
			driver.findElement(By.linkText("Deposit")).click();
			test.log(LogStatus.PASS, " Click on Deposit Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Collateral Checks -->Installment Loan -->Deposit Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Installment Loan -->Deposit Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");		
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		if(driver.findElement(By.linkText("Check Cashing")).isDisplayed()){
			test.log(LogStatus.PASS, "Check Cashing Sub-link is enabled"); 
			driver.findElement(By.linkText("Check Cashing")).click();
			test.log(LogStatus.PASS, " Click on Check Cashing Sub-Link");
			Thread.sleep(1000);
			String Deposit=driver.findElement(By.linkText("Clear")).getText();
			Assert.assertEquals("Clear",Deposit);
			test.log(LogStatus.PASS, "Collateral Checks -->Check Cashing Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Check Cashing Sub-link is disabled");
		}													 												 	

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Check Cashing")).click();
		test.log(LogStatus.PASS, " Click on Check Cashing Sub-Link");
		Thread.sleep(500);	
		if(driver.findElement(By.linkText("Clear")).isDisplayed()){
			test.log(LogStatus.PASS, "Clear Child-link is enabled"); 
			driver.findElement(By.linkText("Clear")).click();
			test.log(LogStatus.PASS, " Click on Clear Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Collateral Checks -->Check Cashing -->Clear Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Check Cashing -->Clear Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Check Cashing")).click();
		test.log(LogStatus.PASS, " Click on Check Cashing Sub-Link");
		Thread.sleep(500);	
		if(driver.findElement(By.linkText("ReDeposit/Representment")).isDisplayed()){
			test.log(LogStatus.PASS, "ReDeposit/Representment Child-link is enabled"); 
			driver.findElement(By.linkText("ReDeposit/Representment")).click();
			test.log(LogStatus.PASS, " Click on ReDeposit/Representment Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Collateral Checks -->Check Cashing -->ReDeposit/Representment Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Check Cashing -->ReDeposit/Representment Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Check Cashing")).click();
		test.log(LogStatus.PASS, " Click on Check Cashing Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("Void ReDeposit Clear")).isDisplayed()){
			test.log(LogStatus.PASS, "Void ReDeposit Clear Child-link is enabled"); 
			driver.findElement(By.linkText("Void ReDeposit Clear")).click();
			test.log(LogStatus.PASS, " Click on Void ReDeposit Clear Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Collateral Checks -->Check Cashing -->Void ReDeposit Clear Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Check Cashing -->Void ReDeposit Clear Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Check Cashing")).click();
		test.log(LogStatus.PASS, " Click on Check Cashing Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("Void ReDeposit")).isDisplayed()){
			test.log(LogStatus.PASS, "Void ReDeposit Child-link is enabled"); 
			driver.findElement(By.linkText("Void ReDeposit")).click();
			test.log(LogStatus.PASS, " Click on Void ReDeposit Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Collateral Checks -->Check Cashing -->Void ReDeposit Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Check Cashing -->Void ReDeposit Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Check Cashing")).click();
		test.log(LogStatus.PASS, " Click on Check Cashing Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("Void Clear")).isDisplayed()){
			test.log(LogStatus.PASS, "Void Clear"); 
			driver.findElement(By.linkText("Void Clear")).click();
			test.log(LogStatus.PASS, " Click on Void Clear");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Collateral Checks -->Check Cashing -->Void Clear Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Check Cashing -->Void Clear Child-link is disabled");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");		
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1500);
		if(driver.findElement(By.linkText("Title Loan")).isDisplayed()){
			test.log(LogStatus.PASS, "Title Loan Sub-link is enabled"); 
			driver.findElement(By.linkText("Title Loan")).click();
			test.log(LogStatus.PASS, " Click on Title Loan Sub-Link");
			Thread.sleep(1500);
			String Deposit=driver.findElement(By.partialLinkText("ReDeposit/Representment")).getText();
			Assert.assertEquals("ReDeposit/Representment",Deposit);
			test.log(LogStatus.PASS, "Collateral Checks -->Title Loan Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Title Loan Sub-link is disabled");
		}


		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Title Loan")).click();
		test.log(LogStatus.PASS, " Click on Title Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("ReDeposit/Representment")).isDisplayed()){
			test.log(LogStatus.PASS, "Deposit Child-link is enabled"); 
			driver.findElement(By.linkText("ReDeposit/Representment")).click();
			test.log(LogStatus.PASS, " Click on ReDeposit/Representment Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Collateral Checks -->Title Loan -->ReDeposit/Representment Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Title Loan -->ReDeposit/Representment Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Title Loan")).click();
		test.log(LogStatus.PASS, " Click on Title Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("Deposit")).isDisplayed()){
			test.log(LogStatus.PASS, "Deposit Child-link is enabled"); 
			driver.findElement(By.linkText("Deposit")).click();
			test.log(LogStatus.PASS, " Click on Deposit Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Collateral Checks -->Title Loan -->Deposit Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Title Loan -->Deposit Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collateral Checks")).click();			 
		test.log(LogStatus.PASS, "Clicked on Collateral checks");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Title Loan")).click();
		test.log(LogStatus.PASS, " Click on Title Loan Sub-Link");
		Thread.sleep(1500);	
		if(driver.findElement(By.linkText("Clear")).isDisplayed()){
			test.log(LogStatus.PASS, "Clear Child-link is enabled"); 
			driver.findElement(By.linkText("Clear")).click();
			test.log(LogStatus.PASS, " Click on Clear Child-link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String store=driver.findElement(By.xpath("//td[text()='Store Nbr']")).getText();
			Assert.assertEquals("Store Nbr",store);
			test.log(LogStatus.PASS, "Collateral Checks -->Title Loan -->Clear Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Collateral Checks -->Title Loan -->Clear Child-link is disabled");
		}																															
	}
	public static void IssuerDetails() throws Exception{

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		if(driver.findElement(By.linkText("Issuer Details")).isDisplayed()){

			test.log(LogStatus.PASS, "Issuer details link is enabled");
			driver.findElement(By.linkText("Issuer Details")).click();			 
			test.log(LogStatus.PASS, "Clicked on Issuer details");

			String product=driver.findElement(By.linkText("Assign Warnings")).getText();
			Assert.assertEquals("Assign Warnings",product);
			test.log(LogStatus.PASS, "Issuer details is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Issuer details  link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");		
		driver.findElement(By.linkText("Issuer Details")).click();			 
		test.log(LogStatus.PASS, "Clicked on Issuer Details");
		Thread.sleep(1500);
		if(driver.findElement(By.linkText("Assign Warnings")).isDisplayed()){
			test.log(LogStatus.PASS, "Assign Warnings Sub-link is enabled"); 
			driver.findElement(By.linkText("Assign Warnings")).click();
			test.log(LogStatus.PASS, " Click on Assign Warnings Sub-Link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String Warnings=driver.findElement(By.xpath("//td[text()='Warnings']")).getText();
			Assert.assertEquals("Warnings",Warnings);
			test.log(LogStatus.PASS, "Issuer details -->Assign Warnings Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Issuer details -->Assign Warnings Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");		
		driver.findElement(By.linkText("Issuer Details")).click();			 
		test.log(LogStatus.PASS, "Clicked on Issuer Details");
		Thread.sleep(1000);
		if(driver.findElement(By.linkText("Issuer Registration")).isDisplayed()){
			test.log(LogStatus.PASS, "Issuer Registration Sub-link is enabled"); 
			driver.findElement(By.linkText("Issuer Registration")).click();
			test.log(LogStatus.PASS, " Click on Issuer Registration Sub-Link");
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String Name=driver.findElement(By.xpath("//td[text()='Name/Address']")).getText();
			Assert.assertEquals("Name/Address",Name);
			test.log(LogStatus.PASS, "Issuer details -->Issuer Registration Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Issuer details -->Issuer Registration Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");		
		driver.findElement(By.linkText("Issuer Details")).click();			 
		test.log(LogStatus.PASS, "Clicked on Issuer Details");
		Thread.sleep(500);
		if(driver.findElement(By.linkText("Edit Issuer")).isDisplayed()){
			test.log(LogStatus.PASS, "Edit Issuer Sub-link is enabled"); 
			driver.findElement(By.linkText("Edit Issuer")).click();
			test.log(LogStatus.PASS, " Click on Edit Issuer Sub-Link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String Name=driver.findElement(By.xpath("//td[text()='Issuer Name']")).getText();
			Assert.assertEquals("Issuer Name",Name);
			test.log(LogStatus.PASS, "Issuer details -->Edit Issuer Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Issuer details -->Edit Issuer Sub-link is disabled");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");		
		driver.findElement(By.linkText("Issuer Details")).click();			 
		test.log(LogStatus.PASS, "Clicked on Issuer Details");
		Thread.sleep(1500);
		if(driver.findElement(By.linkText("List of Issuers")).isDisplayed()){
			test.log(LogStatus.PASS, "List of Issuers Sub-link is enabled"); 
			driver.findElement(By.linkText("List of Issuers")).click();
			test.log(LogStatus.PASS, " Click on List of Issuers Sub-Link");
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String Name=driver.findElement(By.xpath("//td[text()='Issuer Name']")).getText();
			Assert.assertEquals("Issuer Name",Name);
			test.log(LogStatus.PASS, "Issuer details -->List of Issuers Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Issuer details -->List of Issuers Sub-link is disabled");
		}
	}



	//**********************************************************************************************


	//@Test(priority=7,enabled=true)

	public void MiscLoanTransactions() throws Exception{


		FileName="QC_Smoke.xls";
		test=reports.startTest("MiscLoanTransactions","Login-->Misc LoanTransactions ");

		TestData = new Excel(System.getProperty("user.dir")+"/Testdata/"+FileName);
		CSRSmokeLoginLogout.csrlogin();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("topFrame");
		if( driver.findElement(By.xpath("//*[@id='920000']/a")).isDisplayed()){

			test.log(LogStatus.PASS, "Misc transactions link is enabled");
			driver.findElement(By.xpath("//*[@id='920000']/a")).click();			
			test.log(LogStatus.PASS, "Clicked on Misc Transactions");


			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			if(driver.findElement(By.cssSelector("li[id='921000']")).isDisplayed()){

				test.log(LogStatus.PASS, "Misc recipts  link is enabled");
				driver.findElement(By.cssSelector("li[id='921000']")).click();			 
				test.log(LogStatus.PASS, "Clicked on Misc recipts");

				String product=driver.findElement(By.partialLinkText("Bill Pay")).getText();

				Assert.assertEquals("Bill Pay",product);
				test.log(LogStatus.PASS, "Misc recipts is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "Misc recipts  link is disabled");
			}

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			if(driver.findElement(By.cssSelector("li[id='922000']")).isDisplayed()){

				test.log(LogStatus.PASS, "Misc Disbursement  link is enabled");
				driver.findElement(By.cssSelector("li[id='922000']")).click();			 
				test.log(LogStatus.PASS, "Clicked on Misc Disbursement");

				String product=driver.findElement(By.partialLinkText("Wire Transfer Receive")).getText();

				Assert.assertEquals("Wire Transfer Receive",product);
				test.log(LogStatus.PASS, "Disbursement is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "Disbursement  link is disabled");
			}

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");

			if(driver.findElement(By.cssSelector("li[id='924000']")).isDisplayed()){

				test.log(LogStatus.PASS, "Misc customer edit link is enabled");
				driver.findElement(By.cssSelector("li[id='924000']")).click();			 
				test.log(LogStatus.PASS, "Clicked on Misc customer edit link");
				driver.switchTo().frame("main");
				String fname=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td[1]")).getText();

				Assert.assertEquals("First Name",fname);
				test.log(LogStatus.PASS, "Misc customer edit working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "Misc customer edit is disabled");
			}
		}
		else{
			test.log(LogStatus.FAIL, "Misc transactions  is disabled");
		}

		CSRSmokeLoginLogout.logout();;
		test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
	}


	//@Test(priority=8,enabled=true)

	public void MiscLoanTransactionsSublinks() throws Exception{


		FileName="QC_Smoke.xls";
		test=reports.startTest("MiscLoanTransactions_Sublinks","Login-->MiscLoanTransactions-->MiscLoanTransactions_Sublinks");

		TestData = new Excel(System.getProperty("user.dir")+"/Testdata/"+FileName);
		CSRSmokeLoginLogout.csrlogin();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("topFrame");
		if( driver.findElement(By.xpath("//*[@id='920000']/a")).isDisplayed()){

			test.log(LogStatus.PASS, "Misc transactions link is enabled");
			driver.findElement(By.xpath("//*[@id='920000']/a")).click();			
			test.log(LogStatus.PASS, "Clicked on Misc Transactions");

			MiscReceipts();

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			if(driver.findElement(By.linkText("Misc Disbursement")).isDisplayed()){

				test.log(LogStatus.PASS, "Misc Disbursement  link is enabled");
				driver.findElement(By.linkText("Misc Disbursement")).click();			 
				test.log(LogStatus.PASS, "Clicked on Misc Disbursement");

				String product=driver.findElement(By.linkText("Wire Transfer Receive")).getText();

				Assert.assertEquals("Wire Transfer Receive",product);
				test.log(LogStatus.PASS, "Misc Disbursement is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "Misc Disbursement  link is disabled");
			}

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.findElement(By.linkText("Misc Disbursement")).click();			 
			test.log(LogStatus.PASS, "Clicked on Misc Disbursement");
			if(driver.findElement(By.linkText("Wire Transfer Receive")).isDisplayed()){
				test.log(LogStatus.PASS, "Wire Transfer Receive  Sub-link is enabled");
				driver.findElement(By.linkText("Wire Transfer Receive")).click();			 
				test.log(LogStatus.PASS, "Clicked on Wire Transfer Receive");
				Thread.sleep(500);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				String product=driver.findElement(By.xpath("//td[text()='First Name']")).getText();
				Assert.assertEquals("First Name",product);
				test.log(LogStatus.PASS, "Wire Transfer Receive Sub-link is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "Wire Transfer Receive  Sub-link is disabled");
			}
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.findElement(By.linkText("Misc Disbursement")).click();			 
			test.log(LogStatus.PASS, "Clicked on Misc Disbursement");
			if(driver.findElement(By.linkText("Other Disbursements")).isDisplayed()){
				test.log(LogStatus.PASS, "Other Disbursements  Sub-link is enabled");
				driver.findElement(By.linkText("Other Disbursements")).click();			 
				test.log(LogStatus.PASS, "Clicked on Other Disbursements");
				Thread.sleep(500);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				String Type=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td")).getText();
				Assert.assertEquals("Miscellaneous Disbursement",Type);
				test.log(LogStatus.PASS, "Other Disbursements Sub-link is working");
				test.log(LogStatus.PASS, "*******************************************");
			}
			else{
				test.log(LogStatus.FAIL, "Other Disbursements Sub-link is disabled");
			}

		}
		else{
			test.log(LogStatus.FAIL, "Misc transactions  is disabled");
		}

		CSRLoginLogout.logout();;
		test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
	}

	public static void MiscReceipts() throws Exception{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		if(driver.findElement(By.linkText("Misc Receipts")).isDisplayed()){

			test.log(LogStatus.PASS, "Misc recipts  link is enabled");
			driver.findElement(By.linkText("Misc Receipts")).click();			 
			test.log(LogStatus.PASS, "Clicked on Misc recipts");

			String product=driver.findElement(By.linkText("Bill Pay")).getText();

			Assert.assertEquals("Bill Pay",product);
			test.log(LogStatus.PASS, "Misc recipts is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Misc recipts  link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");		
		driver.findElement(By.linkText("Misc Receipts")).click();			 
		test.log(LogStatus.PASS, "Clicked on Misc recipts");
		if(driver.findElement(By.linkText("Bill Pay")).isDisplayed()){
			test.log(LogStatus.PASS, "Bill Pay link is enabled");
			driver.findElement(By.linkText("Bill Pay")).click();			 
			test.log(LogStatus.PASS, "Clicked on Bill Pay");
			Thread.sleep(500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String product=driver.findElement(By.xpath("//td[text()='First Name']")).getText();
			Assert.assertEquals("First Name",product);
			test.log(LogStatus.PASS, "Bill Pay Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Bill Pay Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");			
		driver.findElement(By.linkText("Misc Receipts")).click();			 
		test.log(LogStatus.PASS, "Clicked on Misc recipts");
		if(driver.findElement(By.linkText("Money Order")).isDisplayed()){
			test.log(LogStatus.PASS, "Money Order Sub-link is enabled");
			driver.findElement(By.linkText("Money Order")).click();			 
			test.log(LogStatus.PASS, "Clicked on Money Order");
			Thread.sleep(500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String product=driver.findElement(By.xpath("//td[text()='First Name']")).getText();
			Assert.assertEquals("First Name",product);
			test.log(LogStatus.PASS, "Money Order Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Money Order Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");			
		driver.findElement(By.linkText("Misc Receipts")).click();			 
		test.log(LogStatus.PASS, "Clicked on Misc recipts");
		if(driver.findElement(By.linkText("Postal Services")).isDisplayed()){
			test.log(LogStatus.PASS, "Postal Services Sub-link is enabled");
			driver.findElement(By.linkText("Postal Services")).click();			 
			test.log(LogStatus.PASS, "Clicked on Postal Services");
			Thread.sleep(500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String product=driver.findElement(By.xpath("//td[text()='First Name']")).getText();
			Assert.assertEquals("First Name",product);
			test.log(LogStatus.PASS, "Postal Services Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Postal Services Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");			
		driver.findElement(By.linkText("Misc Receipts")).click();			 
		test.log(LogStatus.PASS, "Clicked on Misc recipts");
		if(driver.findElement(By.linkText("Wire Transfer Send")).isDisplayed()){
			test.log(LogStatus.PASS, "Wire Transfer Send Sub-link is enabled");
			driver.findElement(By.linkText("Wire Transfer Send")).click();			 
			test.log(LogStatus.PASS, "Clicked on Wire Transfer Send");
			Thread.sleep(500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String product=driver.findElement(By.xpath("//td[text()='First Name']")).getText();
			Assert.assertEquals("First Name",product);
			test.log(LogStatus.PASS, "Wire Transfer Send Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Wire Transfer Send Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");			
		driver.findElement(By.linkText("Misc Receipts")).click();			 
		test.log(LogStatus.PASS, "Clicked on Misc recipts");
		if(driver.findElement(By.linkText("Other Receipts")).isDisplayed()){
			test.log(LogStatus.PASS, "Other Receipts Sub-link is enabled");
			driver.findElement(By.linkText("Other Receipts")).click();			 
			test.log(LogStatus.PASS, "Clicked on Other Receipts");
			Thread.sleep(500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String product=driver.findElement(By.xpath("//td[text()='First Name']")).getText();
			Assert.assertEquals("First Name",product);
			test.log(LogStatus.PASS, "Other Receipts Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Other Receipts Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");			
		driver.findElement(By.linkText("Misc Receipts")).click();			 
		test.log(LogStatus.PASS, "Clicked on Misc recipts");
		if(driver.findElement(By.linkText("Insight")).isDisplayed()){
			test.log(LogStatus.PASS, "Insight Sub-link is enabled");
			driver.findElement(By.linkText("Insight")).click();			 
			test.log(LogStatus.PASS, "Clicked on Insight");
			Thread.sleep(500);
			String product=driver.findElement(By.linkText("Insight New Card")).getText();
			Assert.assertEquals("Insight New Card",product);
			test.log(LogStatus.PASS, "Insight Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Insight Sub-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");			
		driver.findElement(By.linkText("Misc Receipts")).click();			 
		test.log(LogStatus.PASS, "Clicked on Misc recipts");
		driver.findElement(By.linkText("Insight")).click();			 
		test.log(LogStatus.PASS, "Clicked on Insight");
		Thread.sleep(500);
		if(driver.findElement(By.linkText("Insight New Card")).isDisplayed()){
			test.log(LogStatus.PASS, "Insight New Card Child-link is enabled");
			driver.findElement(By.linkText("Insight New Card")).click();			 
			test.log(LogStatus.PASS, "Clicked on Insight New Card");
			Thread.sleep(500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String product=driver.findElement(By.xpath("//td[text()='First Name']")).getText();
			Assert.assertEquals("First Name",product);
			test.log(LogStatus.PASS, "Insight New Card Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Insight New Card Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");			
		driver.findElement(By.linkText("Misc Receipts")).click();			 
		test.log(LogStatus.PASS, "Clicked on Misc recipts");
		driver.findElement(By.linkText("Insight")).click();			 
		test.log(LogStatus.PASS, "Clicked on Insight");
		//Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Insight Load Funds")));
		if(driver.findElement(By.linkText("Insight Load Funds")).isDisplayed()){
			test.log(LogStatus.PASS, "Insight Load Funds Child-link is enabled");
			driver.findElement(By.linkText("Insight Load Funds")).click();			 
			test.log(LogStatus.PASS, "Clicked on Insight Load Funds");
			Thread.sleep(500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String product=driver.findElement(By.xpath("//td[text()='First Name']")).getText();
			Assert.assertEquals("First Name",product);
			test.log(LogStatus.PASS, "Insight Load Funds Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Insight Load Funds Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");			
		driver.findElement(By.linkText("Misc Receipts")).click();			 
		test.log(LogStatus.PASS, "Clicked on Misc recipts");
		driver.findElement(By.linkText("Insight")).click();			 
		test.log(LogStatus.PASS, "Clicked on Insight");
		//Thread.sleep(500);
		WebDriverWait wt = new WebDriverWait (driver, 20);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Insight Change Password")));
		if(driver.findElement(By.linkText("Insight Change Password")).isDisplayed()){
			test.log(LogStatus.PASS, "Insight Change Password Child-link is enabled");
			driver.findElement(By.linkText("Insight Change Password")).click();			 
			test.log(LogStatus.PASS, "Clicked on Insight Change Password");
			Thread.sleep(500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String product=driver.findElement(By.xpath("//td[text()='Confirm Insight Password']")).getText();
			Assert.assertEquals("Confirm Insight Password",product);
			test.log(LogStatus.PASS, "Insight Change Password Child-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Insight Change Password Child-link is disabled");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");			
		driver.findElement(By.linkText("Misc Receipts")).click();			 
		test.log(LogStatus.PASS, "Clicked on Misc recipts");
		if(driver.findElement(By.linkText("Legacy Debt Payment")).isDisplayed()){
			test.log(LogStatus.PASS, "Legacy Debt Payment Sub-link is enabled");
			driver.findElement(By.linkText("Legacy Debt Payment")).click();			 
			test.log(LogStatus.PASS, "Clicked on Legacy Debt Payment");
			Thread.sleep(500);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String product=driver.findElement(By.xpath("//td[text()='First Name']")).getText();
			Assert.assertEquals("First Name",product);
			test.log(LogStatus.PASS, "Legacy Debt Payment Sub-link is working");
			test.log(LogStatus.PASS, "*******************************************");
		}
		else{
			test.log(LogStatus.FAIL, "Legacy Debt Payment Sub-link is disabled");
		}
	}





	//**********************************************************************************************
	//@Test(priority=9,enabled=true)

	public void cashManagement() throws Exception{


		FileName="QC_Smoke.xls";
		test=reports.startTest("Cash Managemernt","Login-->cash Managemernt");

		TestData = new Excel(System.getProperty("user.dir")+"/Testdata/"+FileName);
		CSRSmokeLoginLogout.csrlogin();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("topFrame");
		driver.findElement(By.xpath("//*[@id='930000']/a")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on cash Management");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");


		test.log(LogStatus.PASS, "Verifying the Drawer sub menu");
		if (driver.findElement(By.linkText("Drawer")).isDisplayed()) {
			test.log(LogStatus.PASS, "Drawer sub menu is enabled");
			test.log(LogStatus.PASS, "cash Management is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "cash Management is not working fine");
		}

		Thread.sleep(500);
		// Drawer link
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Drawer")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on Drawer");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");


		test.log(LogStatus.PASS, "Verifying the Assign sub menu");
		if (driver.findElement(By.linkText("Assign")).isDisplayed()) {
			test.log(LogStatus.PASS, "Assign sub menu is enabled");
			test.log(LogStatus.PASS, "Drawer link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Drawer link is not working fine");
		}

		// Safe link
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Safe")).click();
		test.log(LogStatus.PASS, "Clicked on Safe");
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");


		test.log(LogStatus.PASS, "Verifying the Assign sub menu");
		if (driver.findElement(By.linkText("Assign")).isDisplayed()) {
			test.log(LogStatus.PASS, "Assign sub menu is enabled");
			test.log(LogStatus.PASS, "Safe link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Safe link is not working fine");
		}

		Thread.sleep(2000);
		// Start Scheduler
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Start Scheduler")).click();
		test.log(LogStatus.PASS, "Clicked on Start Scheduler");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");

		test.log(LogStatus.PASS, "Verifying the Store code field");
		if (driver.findElement(By.name("endMonth")).isDisplayed()) {
			test.log(LogStatus.PASS, "Store code field is enabled");
			test.log(LogStatus.PASS, "Start Scheduler link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Start Scheduler link is not working fine");
		}

		CSRSmokeLoginLogout.logout();
		test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");

	}

	//@Test(priority=10,enabled=true)
	public void cashManagemerntSublinks() throws Exception {

		FileName = "QC_Smoke.xls";
		test = reports.startTest("Cash ManagemerntSublinks", "Login-->cash Management-->cash Management Sub-links");

		TestData = new Excel(System.getProperty("user.dir") + "/Testdata/" + FileName);
		CSRSmokeLoginLogout.csrlogin();


		driver.switchTo().defaultContent();
		driver.switchTo().frame("topFrame");
		driver.findElement(By.xpath("//*[@id='930000']/a")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on cash Management");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");

		test.log(LogStatus.PASS, "Verifying the Drawer sub menu");
		if (driver.findElement(By.linkText("Drawer")).isDisplayed()) {
			test.log(LogStatus.PASS, "Drawer sub menu is enabled");
			test.log(LogStatus.PASS, "cash Management is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "cash Management is not working fine");
		}

		Thread.sleep(500);
		// Drawer link
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Drawer")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on Drawer");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");

		test.log(LogStatus.PASS, "Verifying the Assign sub menu");
		if (driver.findElement(By.linkText("Assign")).isDisplayed()) {
			test.log(LogStatus.PASS, "Assign sub menu is enabled");
			test.log(LogStatus.PASS, "Drawer link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Drawer link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Drawer")).click();
		test.log(LogStatus.PASS, "Clicked on Drawer");

		// Assign link

		driver.findElement(By.linkText("Assign")).click();
		test.log(LogStatus.PASS, "Clicked on Assign");
		driver.switchTo().frame("main");
		test.log(LogStatus.PASS, "Verifying the Assign sub menu");
		try{
			if (driver.findElement(By.name("previous")).isDisplayed())

			{

				test.log(LogStatus.PASS, "Next button is enabled");
				test.log(LogStatus.PASS, "Assign link is working fine");
				test.log(LogStatus.PASS, "*******************************************");
			} else {
				test.log(LogStatus.FAIL, "Assign link is not working fine");
			}
		}
		catch(Exception e)
		{

		}
		try{
			if (driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/h3/font")).isDisplayed())

			{

				test.log(LogStatus.PASS, "Next button is enabled");
				test.log(LogStatus.PASS, "Assign link is working fine");
				test.log(LogStatus.PASS, "*******************************************");
			} else {
				test.log(LogStatus.FAIL, "Assign link is not working fine");
			}
		}
		catch(Exception e)
		{

		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Drawer")).click();
		test.log(LogStatus.PASS, "Clicked on Drawer");

		// Balance link

		driver.findElement(By.linkText("Balance")).click();
		test.log(LogStatus.PASS, "Clicked on Balance");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("drawerbalance")).isDisplayed()) {

			test.log(LogStatus.PASS, "Finish drawer balance button is enabled");
			test.log(LogStatus.PASS, "Balance link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Balance link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Drawer")).click();
		test.log(LogStatus.PASS, "Clicked on Drawer");

		// Deassign link

		driver.findElement(By.linkText("Deassign")).click();
		test.log(LogStatus.PASS, "Clicked on Deassign");
		Thread.sleep(2000);
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("drawerdeassign")).isDisplayed()) {

			test.log(LogStatus.PASS, "Drawer de assign button is enabled");
			test.log(LogStatus.PASS, "Deassign link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Deassign link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Drawer")).click();
		test.log(LogStatus.PASS, "Clicked on Drawer");

		// Safe link
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Safe")).click();
		test.log(LogStatus.PASS, "Clicked on Safe");
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");

		test.log(LogStatus.PASS, "Verifying the Assign sub menu");
		try{
			if (driver.findElement(By.name("previous")).isDisplayed()) {

				test.log(LogStatus.PASS, "previous button is enabled");
				test.log(LogStatus.PASS, "Assign link is working fine");
				test.log(LogStatus.PASS, "*******************************************");
			} else {
				test.log(LogStatus.FAIL, "Assign link is not working fine");
			}
		}
		catch(Exception e)
		{

		}

		try{
			if (driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/h3/font")).isDisplayed()) {

				test.log(LogStatus.PASS, "previous button is enabled");
				test.log(LogStatus.PASS, "Assign link is working fine");
				test.log(LogStatus.PASS, "*******************************************");
			} else {
				test.log(LogStatus.FAIL, "Assign link is not working fine");
			}
		}
		catch(Exception e)
		{

		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Safe")).click();
		test.log(LogStatus.PASS, "Clicked on Safe");

		// cashIn link

		driver.findElement(By.linkText("Cash In")).click();
		test.log(LogStatus.PASS, "Clicked on Cash In");
		Thread.sleep(2000);
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("cashIn")).isDisplayed()) {

			test.log(LogStatus.PASS, "finish cashIn button is enabled");
			test.log(LogStatus.PASS, "Cash In link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Cash In link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Safe")).click();
		test.log(LogStatus.PASS, "Clicked on Safe");
		// Assign link

		driver.findElement(By.linkText("Assign")).click();
		test.log(LogStatus.PASS, "Clicked on Assign");
		Thread.sleep(2000);
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("previous")).isDisplayed()) {

			test.log(LogStatus.PASS, "previous button is enabled");
			test.log(LogStatus.PASS, "Assign link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Assign link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Safe")).click();
		test.log(LogStatus.PASS, "Clicked on Safe");

		// Balance link

		driver.findElement(By.linkText("Balance")).click();
		test.log(LogStatus.PASS, "Clicked on Balance");
		Thread.sleep(2000);
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("safebalance")).isDisplayed()) {

			test.log(LogStatus.PASS, "safebalance button is enabled");
			test.log(LogStatus.PASS, "Balance link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Balance link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Safe")).click();
		test.log(LogStatus.PASS, "Clicked on Safe");

		// Deassign link

		driver.findElement(By.linkText("Deassign")).click();
		test.log(LogStatus.PASS, "Clicked on Deassign");
		Thread.sleep(2000);
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("safedeassign")).isDisplayed()) {

			test.log(LogStatus.PASS, "safe deassign button is enabled");
			test.log(LogStatus.PASS, "Deassign link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Deassign link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Safe")).click();
		test.log(LogStatus.PASS, "Clicked on Safe");

		// Internal Transfer  link

		driver.findElement(By.linkText("Internal Transfer")).click();
		test.log(LogStatus.PASS, "Clicked on Internal Transfer ");
		Thread.sleep(2000);
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("internaltransfer")).isDisplayed()) {

			test.log(LogStatus.PASS, "internal transfer button is enabled");
			test.log(LogStatus.PASS, "Internal Transfer  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Internal Transfer  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Safe")).click();
		test.log(LogStatus.PASS, "Clicked on Safe");

		// Deposit link

		driver.findElement(By.linkText("Deposit")).click();
		test.log(LogStatus.PASS, "Clicked on Deposit  ");
		Thread.sleep(2000);
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("finishdeposit")).isDisplayed()) {

			test.log(LogStatus.PASS, "finish deposit button is enabled");
			test.log(LogStatus.PASS, "Deposit   link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Deposit  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Safe")).click();
		test.log(LogStatus.PASS, "Clicked on Safe");

		// Store To Store Transfers link

		driver.findElement(By.linkText("Store To Store Transfers")).click();
		test.log(LogStatus.PASS, "Clicked on Store To Store Transfers  ");
		Thread.sleep(2000);
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("loctoloc")).isDisplayed()) {

			test.log(LogStatus.PASS, "finish store button is enabled");
			test.log(LogStatus.PASS, "Store To Store Transfers link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Store To Store Transfers link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Safe")).click();
		test.log(LogStatus.PASS, "Clicked on Safe");




		Thread.sleep(2000);
		// Start Scheduler
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Start Scheduler")).click();
		test.log(LogStatus.PASS, "Clicked on Start Scheduler");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");

		test.log(LogStatus.PASS, "Verifying the Store code field");
		if (driver.findElement(By.name("endMonth")).isDisplayed()) {
			test.log(LogStatus.PASS, "Store code field is enabled");
			test.log(LogStatus.PASS, "Start Scheduler link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Start Scheduler link is not working fine");
		}

		CSRLoginLogout.logout();
		test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");

	}




	//*********************************************************************************
	//@Test(priority=11,enabled=true)

	public void DailyProcessing() throws Exception{


		FileName="QC_Smoke.xls";
		test=reports.startTest("DailyProcessing","Login-->DailyProcessing");

		TestData = new Excel(System.getProperty("user.dir")+"/Testdata/"+FileName);
		CSRSmokeLoginLogout.csrlogin();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("topFrame");
		if( driver.findElement(By.xpath("//*[@id='daily']/a")).isDisplayed()){

			test.log(LogStatus.PASS, "Daily proceesing  link is enabled");
			driver.findElement(By.xpath("//*[@id='daily']/a")).click();			
			test.log(LogStatus.PASS, "Clicked on Daily proceesing");

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");

			String fname=driver.findElement(By.xpath(" /html/body/form/table/tbody/tr[1]/td")).getText();
			if(fname.contains("EOD Process")){
				test.log(LogStatus.PASS, "Daily proceesing is enabled");}
		}
		else{
			test.log(LogStatus.FAIL, "Daily proceesing  is disabled");
		}
		CSRSmokeLoginLogout.logout();
		test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");
	}

	//@Test(priority=12,enabled=true)

	public void reports() throws Exception{


		FileName="QC_Smoke.xls";
		test=reports.startTest("Reports","Login-->Reports");

		TestData = new Excel(System.getProperty("user.dir")+"/Testdata/"+FileName);
		CSRSmokeLoginLogout.csrlogin();

		// reports
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topFrame");
		driver.findElement(By.xpath("//*[@id='950000']/a")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on Reports");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");

		test.log(LogStatus.PASS, "Verifying the Collection sub menu");
		if (driver.findElement(By.linkText("Collection")).isDisplayed()) {
			test.log(LogStatus.PASS, "Collection sub menu is enabled");
			test.log(LogStatus.PASS, "Reports is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Reports is not working fine");
		}


		// Collection
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collection")).click();
		test.log(LogStatus.PASS, "Clicked on Collection");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");


		test.log(LogStatus.PASS, "Verifying the Past Due Report link ");
		if (driver.findElement(By.linkText("Past Due Report")).isDisplayed()) {
			test.log(LogStatus.PASS, "Past Due Report link  is enabled");
			test.log(LogStatus.PASS, "Collection link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Collection link is not working fine");
		}

		// Customer Reports
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");

		test.log(LogStatus.PASS, "Verifying the Bankruptcy Report link ");
		if (driver.findElement(By.linkText("Bankruptcy Report")).isDisplayed()) {
			test.log(LogStatus.PASS, "Bankruptcy Report link  is enabled");
			test.log(LogStatus.PASS, "Customer Reports link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Customer Reports link is not working fine");
		}

		Thread.sleep(2000);
		// Daily Summary Reports
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");
		//Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");


		test.log(LogStatus.PASS, "Verifying the EOD Summary link ");
		if (driver.findElement(By.linkText("EOD Summary")).isDisplayed()) {
			test.log(LogStatus.PASS, "EOD Summary link  is enabled");
			test.log(LogStatus.PASS, "Daily Summary Reports link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Daily Summary Reports link is not working fine");
		}
		//Thread.sleep(2000);
		//Loan Reports
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Loan Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Loan Reports");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		test.log(LogStatus.PASS, "Verifying the PWO Report link ");
		if (driver.findElement(By.linkText("PWO Report")).isDisplayed()) {
			test.log(LogStatus.PASS, "PWO Report link  is enabled");
			test.log(LogStatus.PASS, "Loan Reports link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Loan Reports link is not working fine");
		}
		Thread.sleep(500);
		//Other Reports
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Other Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Other Reports");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");


		test.log(LogStatus.PASS, "Verifying the Monetary Transfer Log link ");
		if (driver.findElement(By.linkText("Monetary Transfer Log")).isDisplayed()) {
			test.log(LogStatus.PASS, "Monetary Transfer Log link  is enabled");
			test.log(LogStatus.PASS, "Other Reports link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Other Reports link is not working fine");
		}
		//Thread.sleep(2000);
		//Title Reports
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Title Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Title Reports");
		//Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");


		test.log(LogStatus.PASS, "Verifying the Blackbook Report link ");
		if (driver.findElement(By.linkText("Blackbook Report")).isDisplayed()) {
			test.log(LogStatus.PASS, "Blackbook Report link  is enabled");
			test.log(LogStatus.PASS, "Title Reports link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Title Reports link is not working fine");
		}


		CSRSmokeLoginLogout.logout();
		test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");

	}

	//@Test(priority=13,enabled=true)
	public void reportsSublinks() throws Exception {

		FileName = "QC_Smoke.xls";
		test = reports.startTest("ReportsSublinks", "Login-->Reports--> Reports sub-links");

		TestData = new Excel(System.getProperty("user.dir") + "/Testdata/" + FileName);
		CSRSmokeLoginLogout.csrlogin();

		// reports
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topFrame");
		
		driver.findElement(By.linkText("Reports")).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Clicked on Reports");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");

		test.log(LogStatus.PASS, "Verifying the Collection sub menu");
		if (driver.findElement(By.linkText("Collection")).isDisplayed()) {
			test.log(LogStatus.PASS, "Collection sub menu is enabled");
			test.log(LogStatus.PASS, "Reports is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Reports is not working fine");
		}

		collectionlink();
		CustomerReports();
		DailySummaryReports();
		loanReports();
		otherReports();


		//Title Reports
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Title Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Title Reports");
				//Thread.sleep(3000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");


				test.log(LogStatus.PASS, "Verifying the Blackbook Report link ");
				if (driver.findElement(By.linkText("Blackbook Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Blackbook Report link  is enabled");
					test.log(LogStatus.PASS, "Title Reports link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Title Reports link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Title Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Title Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Blackbook Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Blackbook Report link  is enabled");
					driver.findElement(By.linkText("Blackbook Report")).click();
					test.log(LogStatus.PASS, "Clicked on Blackbook Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Blackbook Report']")).getText();
					Assert.assertEquals("Blackbook Report",product);
					test.log(LogStatus.PASS, "Blackbook Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Blackbook Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Title Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Title Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Title New Loans Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Title New Loans Report link  is enabled");
					driver.findElement(By.linkText("Title New Loans Report")).click();
					test.log(LogStatus.PASS, "Clicked on Title New Loans Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Title New Loans Report']")).getText();
					Assert.assertEquals("Title New Loans Report",product);
					test.log(LogStatus.PASS, "Title New Loans Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Title New Loans Report Sub_link is not working fine");
				}
				

		CSRLoginLogout.logout();
		test.log(LogStatus.INFO, "****Test Scenario for Smoke test is pass******");

	}
	
	
	//************************************************************************************

	public static void collectionlink() {
		// Collection
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collection")).click();
		test.log(LogStatus.PASS, "Clicked on Collection");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");

		test.log(LogStatus.PASS, "Verifying the Past Due Report link ");
		if (driver.findElement(By.linkText("Past Due Report")).isDisplayed()) {
			test.log(LogStatus.PASS, "Past Due Report link  is enabled");
			test.log(LogStatus.PASS, "Collection link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Collection link is not working fine");
		}
		// Past Due Report
		driver.findElement(By.linkText("Past Due Report")).click();
		test.log(LogStatus.PASS, "Clicked on Past Due Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Past Due Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Past Due Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collection")).click();
		test.log(LogStatus.PASS, "Clicked on Collection");

		// Promise To Pay
		driver.findElement(By.linkText("Promise To Pay")).click();
		test.log(LogStatus.PASS, "Clicked on Promise To Pay");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Promise To Pay link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Promise To Pay link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collection")).click();
		test.log(LogStatus.PASS, "Clicked on Collection");
		// Collection Activity
		driver.findElement(By.linkText("Collection Activity")).click();
		test.log(LogStatus.PASS, "Clicked on Collection Activity");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Collection Activity link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Collection Activity link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collection")).click();
		test.log(LogStatus.PASS, "Clicked on Collection");

		// Collection Activity
		driver.findElement(By.linkText("Collection Activity")).click();
		test.log(LogStatus.PASS, "Clicked on Collection Activity");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Collection Activity link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Collection Activity link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collection")).click();
		test.log(LogStatus.PASS, "Clicked on Collection");
		// Courtesy Call Report
		driver.findElement(By.linkText("Courtesy Call Report")).click();
		test.log(LogStatus.PASS, "Clicked on Courtesy Call Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Courtesy Call Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Courtesy Call Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collection")).click();
		test.log(LogStatus.PASS, "Clicked on Collection");

		// Store to Central Collections Report
		driver.findElement(By.linkText("Store to Central Collections Report")).click();
		test.log(LogStatus.PASS, "Clicked on Store to Central Collections Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Store to Central Collections Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Store to Central Collections Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Collection")).click();
		test.log(LogStatus.PASS, "Clicked on Collection");

		// Store Call Report
		driver.findElement(By.linkText("Store Call Report")).click();
		test.log(LogStatus.PASS, "Clicked on Store Call Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Store Call Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Store Call Report link is not working fine");
		}

	}

	public static void CustomerReports() throws InterruptedException {
		// Customer Reports
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");

		test.log(LogStatus.PASS, "Verifying the Bankruptcy Report link ");
		if (driver.findElement(By.linkText("Bankruptcy Report")).isDisplayed()) {
			test.log(LogStatus.PASS, "Bankruptcy Report link  is enabled");
			test.log(LogStatus.PASS, "Customer Reports link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Customer Reports link is not working fine");
		}
		// Bankruptcy Report
		driver.findElement(By.linkText("Bankruptcy Report")).click();
		test.log(LogStatus.PASS, "Clicked on Bankruptcy Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Bankruptcy Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Bankruptcy Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

		// Pending Bankruptcy Report
		driver.findElement(By.linkText("Pending Bankruptcy Report")).click();
		test.log(LogStatus.PASS, "Clicked on Pending Bankruptcy Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Pending Bankruptcy Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Pending Bankruptcy Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

		// Inactive Customer
		driver.findElement(By.linkText("Inactive Customer")).click();
		test.log(LogStatus.PASS, "Clicked on Inactive Customer ");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Inactive Customer  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Inactive Customer  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

		// Active Customer
		driver.findElement(By.linkText("Active Customer")).click();
		test.log(LogStatus.PASS, "Clicked on Active Customer  ");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Active Customer  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Active Customer  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

		// Updated Customer Information Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Updated Customer Information Report")).click();
		test.log(LogStatus.PASS, "Clicked on Updated Customer Information Report ");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Updated Customer Information Report  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Updated Customer Information Report  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

		// OFAC Response Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("OFAC Response Report")).click();
		test.log(LogStatus.PASS, "Clicked on OFAC Response Report ");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "OFAC Response Report  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "OFAC Response Report  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");
		// Do Not Call Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Do Not Call Report")).click();
		test.log(LogStatus.PASS, "Clicked on Do Not Call Report ");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Do Not Call Report  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Do Not Call Report  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");
		// Bankruptcy Payment Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Bankruptcy Payment Report")).click();
		test.log(LogStatus.PASS, "Clicked on Bankruptcy Payment Report ");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Bankruptcy Payment Report  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Bankruptcy Payment Report  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");
		// Active Military Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Active Military Report")).click();
		test.log(LogStatus.PASS, "Clicked on Active Military Report ");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Active Military Report  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Active Military Report  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

		// Pending Bankruptcy Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Pending Bankruptcy Report")).click();
		test.log(LogStatus.PASS, "Clicked on Pending Bankruptcy Report ");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Pending Bankruptcy Report  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Pending Bankruptcy Report  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

		// Customer Cam Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Customer Cam Report")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Cam Report ");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Customer Cam Report  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Customer Cam Report  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

		// Customer Information Summary Report(CIS)
		Thread.sleep(1000);
		driver.findElement(By.linkText("Customer Information Summary Report(CIS)")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Information Summary Report(CIS) ");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Customer Information Summary Report(CIS)  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Customer Information Summary Report(CIS)  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

		// Inactive Bank Account Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Inactive Bank Account Report")).click();
		test.log(LogStatus.PASS, "Clicked on Inactive Bank Account Report ");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Inactive Bank Account Report  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Inactive Bank Account Report  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

		// Hit List Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Hit List Report")).click();
		test.log(LogStatus.PASS, "Clicked on Hit List Report ");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("btnPreview")).isDisplayed()) {

			test.log(LogStatus.PASS, "Preview button is enabled");
			test.log(LogStatus.PASS, "Hit List Report  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Hit List Report  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

		// Former Borrowers Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Former Borrowers Report")).click();
		test.log(LogStatus.PASS, "Clicked on Former Borrowers Report ");
		Thread.sleep(8000);
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("ok")).isDisplayed()) {

			test.log(LogStatus.PASS, "Ok button is enabled");
			test.log(LogStatus.PASS, "Former Borrowers Report  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Former Borrowers Report  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

		// Cease null
		Thread.sleep(1000);
		driver.findElement(By.linkText("Cease & Desist")).click();
		test.log(LogStatus.PASS, "Clicked on Cease & Desist ");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Cease & Desist  link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Cease & Desist  link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Customer Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Customer Reports");

	}

	public static void DailySummaryReports() throws InterruptedException {
		Thread.sleep(2000);
		// Daily Summary Reports
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");
		// Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");

		test.log(LogStatus.PASS, "Verifying the EOD Summary link ");
		if (driver.findElement(By.linkText("EOD Summary")).isDisplayed()) {
			test.log(LogStatus.PASS, "EOD Summary link  is enabled");
			test.log(LogStatus.PASS, "Daily Summary Reports link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.PASS, "Daily Summary Reports link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");

		// EOD Summary
		Thread.sleep(1000);
		driver.findElement(By.linkText("EOD Summary")).click();
		test.log(LogStatus.PASS, "Clicked on EOD Summary");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "EOD Summary link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "EOD Summary link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");

		

		// Daily Statistics Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Daily Statistics Report")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Statistics Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Daily Statistics Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Daily Statistics Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");

		// Store Cash Management
		Thread.sleep(1000);
		driver.findElement(By.linkText("Store Cash Management")).click();
		test.log(LogStatus.PASS, "Clicked on Store Cash Management");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Store Cash Management link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Store Cash Management link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");

		// Voided Transactions
		Thread.sleep(1000);
		driver.findElement(By.linkText("Voided Transactions")).click();
		test.log(LogStatus.PASS, "Clicked on Voided Transactions");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Voided Transactions link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Voided Transactions link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");


		// Accounts Receivable Aging Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Accounts Receivable Aging Report")).click();
		test.log(LogStatus.PASS, "Clicked on Accounts Receivable Aging Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Accounts Receivable Aging Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Accounts Receivable Aging Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");

		// Store Cash Management Summary Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Store Cash Management Summary Report")).click();
		test.log(LogStatus.PASS, "Clicked on Store Cash Management Summary Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Store Cash Management Summary Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Store Cash Management Summary Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");

		// All Payments Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("All Payments Report")).click();
		test.log(LogStatus.PASS, "Clicked on All Payments Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "All Payments Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "All Payments Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");

		// Cash Over/Short Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Cash Over/Short Report")).click();
		test.log(LogStatus.PASS, "Clicked on Cash Over/Short Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Cash Over/Short Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Cash Over/Short Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");

		// Cash Balance Transaction Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Cash Balance Transaction Report")).click();
		test.log(LogStatus.PASS, "Clicked on Cash Balance Transaction Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Cash Balance Transaction Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Cash Balance Transaction Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");

		// Daily Statistics Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Daily Statistics Report")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Statistics Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Daily Statistics Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Daily Statistics Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");

		// EOD Summary
		Thread.sleep(1000);
		driver.findElement(By.linkText("EOD Summary")).click();
		test.log(LogStatus.PASS, "Clicked on EOD Summary");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "EOD Summary link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "EOD Summary link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");

		// Drawer Journal Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Drawer Journal Report")).click();
		test.log(LogStatus.PASS, "Clicked on Drawer Journal Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Drawer Journal Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Drawer Journal Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");

		// Daily Performance Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Daily Performance Report")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Performance Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Daily Performance Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Daily Performance Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");

		// Key Performance Indicator Report
		Thread.sleep(1000);
		driver.findElement(By.linkText("Key Performance Indicator Report")).click();
		test.log(LogStatus.PASS, "Clicked on Key Performance Indicator Report");
		driver.switchTo().frame("main");
		if (driver.findElement(By.name("B2")).isDisplayed()) {

			test.log(LogStatus.PASS, "Reset button is enabled");
			test.log(LogStatus.PASS, "Key Performance Indicator Report link is working fine");
			test.log(LogStatus.PASS, "*******************************************");
		} else {
			test.log(LogStatus.FAIL, "Key Performance Indicator Report link is not working fine");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Daily Summary Reports")).click();
		test.log(LogStatus.PASS, "Clicked on Daily Summary Reports");

	}
	public static void loanReports() throws Exception{

		//Loan Reports
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				test.log(LogStatus.PASS, "Verifying the PWO Report link ");
				if (driver.findElement(By.linkText("PWO Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "PWO Report link  is enabled");
					test.log(LogStatus.PASS, "Loan Reports link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Loan Reports link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("PWO Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "PWO Report link  is enabled");
					driver.findElement(By.linkText("PWO Report")).click();
					test.log(LogStatus.PASS, "Clicked on PWO Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='PWO Report']")).getText();
					Assert.assertEquals("PWO Report",product);
					test.log(LogStatus.PASS, "PWO Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "PWO Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Write Off Loans Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Write Off Loans Report link  is enabled");
					driver.findElement(By.linkText("Write Off Loans Report")).click();
					test.log(LogStatus.PASS, "Clicked on Write Off Loans Report");
					Thread.sleep(1500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Write Off Loans Report']")).getText();
					Assert.assertEquals("Write Off Loans Report",product);
					test.log(LogStatus.PASS, "Write Off Loans Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Write Off Loans Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Returned Items Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Returned Items Report link  is enabled");
					driver.findElement(By.linkText("Returned Items Report")).click();
					test.log(LogStatus.PASS, "Clicked on Returned Items Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Returned Items Report']")).getText();
					Assert.assertEquals("Returned Items Report",product);
					test.log(LogStatus.PASS, "Returned Items Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Returned Items Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Sold Loan Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Sold Loan Report link  is enabled");
					driver.findElement(By.linkText("Sold Loan Report")).click();
					test.log(LogStatus.PASS, "Clicked on Sold Loan Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Sold Loan Report']")).getText();
					Assert.assertEquals("Sold Loan Report",product);
					test.log(LogStatus.PASS, "Sold Loan Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Sold Loan Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Check Register Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Check Register Report link  is enabled");
					driver.findElement(By.linkText("Check Register Report")).click();
					test.log(LogStatus.PASS, "Clicked on Check Register Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Check Register Report']")).getText();
					Assert.assertEquals("Check Register Report",product);
					test.log(LogStatus.PASS, "Check Register Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Check Register Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Deposit Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Deposit Report link  is enabled");
					driver.findElement(By.linkText("Deposit Report")).click();
					test.log(LogStatus.PASS, "Clicked on Deposit Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Deposit Report']")).getText();
					Assert.assertEquals("Deposit Report",product);
					test.log(LogStatus.PASS, "Deposit Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Deposit Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Waive Fee Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Waive Fee Report link  is enabled");
					driver.findElement(By.linkText("Waive Fee Report")).click();
					test.log(LogStatus.PASS, "Clicked on Waive Fee Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Waive Fee Report']")).getText();
					Assert.assertEquals("Waive Fee Report",product);
					test.log(LogStatus.PASS, "Waive Fee Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Waive Fee Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Refund Transaction Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Refund Transaction Report link  is enabled");
					driver.findElement(By.linkText("Refund Transaction Report")).click();
					test.log(LogStatus.PASS, "Clicked on Refund Transaction Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Refund Transaction Report']")).getText();
					Assert.assertEquals("Refund Transaction Report",product);
					test.log(LogStatus.PASS, "Refund Transaction Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Refund Transaction Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("New Loan Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "New Loan Report link  is enabled");
					driver.findElement(By.linkText("New Loan Report")).click();
					test.log(LogStatus.PASS, "Clicked on New Loan Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='New Loan Report']")).getText();
					Assert.assertEquals("New Loan Report",product);
					test.log(LogStatus.PASS, "New Loan Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "New Loan Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Returned Items Inventory Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Returned Items Inventory Report link  is enabled");
					driver.findElement(By.linkText("Returned Items Inventory Report")).click();
					test.log(LogStatus.PASS, "Clicked on Returned Items Inventory Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Returned Items Inventory Report']")).getText();
					Assert.assertEquals("Returned Items Inventory Report",product);
					test.log(LogStatus.PASS, "Returned Items Inventory Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Returned Items Inventory Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Current Loan Inventory Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Current Loan Inventory Report link  is enabled");
					driver.findElement(By.linkText("Current Loan Inventory Report")).click();
					test.log(LogStatus.PASS, "Clicked on Current Loan Inventory Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td")).getText();
					Assert.assertEquals("Current Loan Inventory Report",product);
					test.log(LogStatus.PASS, "Current Loan Inventory Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Current Loan Inventory Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Representment Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Representment Report link  is enabled");
					driver.findElement(By.linkText("Representment Report")).click();
					test.log(LogStatus.PASS, "Clicked on Representment Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Representment Report']")).getText();
					Assert.assertEquals("Representment Report",product);
					test.log(LogStatus.PASS, "Representment Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Representment Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Coupon Tracking Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Coupon Tracking Report link  is enabled");
					driver.findElement(By.linkText("Coupon Tracking Report")).click();
					test.log(LogStatus.PASS, "Clicked on Coupon Tracking Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Coupon Tracking Report']")).getText();
					Assert.assertEquals("Coupon Tracking Report",product);
					test.log(LogStatus.PASS, "Coupon Tracking Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Coupon Tracking Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("ACH Details Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "ACH Details Report link  is enabled");
					driver.findElement(By.linkText("ACH Details Report")).click();
					test.log(LogStatus.PASS, "Clicked on ACH Details Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='ACH Details Report']")).getText();
					Assert.assertEquals("ACH Details Report",product);
					test.log(LogStatus.PASS, "ACH Details Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "ACH Details Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Held Check Summary")).isDisplayed()) {
					test.log(LogStatus.PASS, "Held Check Summary link  is enabled");
					driver.findElement(By.linkText("Held Check Summary")).click();
					test.log(LogStatus.PASS, "Clicked on Held Check Summary");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Held Check Summary Report']")).getText();
					Assert.assertEquals("Held Check Summary Report",product);
					test.log(LogStatus.PASS, "Held Check Summary Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Held Check Summary Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Transfer Payments Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Transfer Payments Report link  is enabled");
					driver.findElement(By.linkText("Transfer Payments Report")).click();
					test.log(LogStatus.PASS, "Clicked on Transfer Payments Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Transfer Payments Report']")).getText();
					Assert.assertEquals("Transfer Payments Report",product);
					test.log(LogStatus.PASS, "Transfer Payments Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Transfer Payments Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Loan Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Default Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Default Report link  is enabled");
					driver.findElement(By.linkText("Default Report")).click();
					test.log(LogStatus.PASS, "Clicked on Default Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Default Report']")).getText();
					Assert.assertEquals("Default Report",product);
					test.log(LogStatus.PASS, "Default Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Default Report Sub_link is not working fine");
				}
				
				
	}
	public static void otherReports() throws Exception{
		//Other Reports
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				test.log(LogStatus.PASS, "Verifying the Monetary Transfer Log link ");
				if (driver.findElement(By.linkText("Monetary Transfer Log")).isDisplayed()) {
					test.log(LogStatus.PASS, "Monetary Transfer Log link  is enabled");
					test.log(LogStatus.PASS, "Other Reports link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Other Reports link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Monetary Transfer Log")).isDisplayed()) {
					test.log(LogStatus.PASS, "Monetary Transfer Log link  is enabled");
					driver.findElement(By.linkText("Monetary Transfer Log")).click();
					test.log(LogStatus.PASS, "Clicked on Monetary Transfer Log");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//b[text()='Employee Number']")).getText();
					Assert.assertEquals("Employee Number",product);
					test.log(LogStatus.PASS, "Monetary Transfer Log Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Monetary Transfer Log Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("EncryptionKey Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "EncryptionKey Report link  is enabled");
					driver.findElement(By.linkText("EncryptionKey Report")).click();
					test.log(LogStatus.PASS, "Clicked on EncryptionKey Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='EncryptionKey Report']")).getText();
					Assert.assertEquals("EncryptionKey Report",product);
					test.log(LogStatus.PASS, "EncryptionKey Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "EncryptionKey Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Active Users Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Active Users Report link  is enabled");
					driver.findElement(By.linkText("Active Users Report")).click();
					test.log(LogStatus.PASS, "Clicked on Active Users Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Active Users Report']")).getText();
					Assert.assertEquals("Active Users Report",product);
					test.log(LogStatus.PASS, "Active Users Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Active Users Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Misc Disbursements Log Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Misc Disbursements Log Report link  is enabled");
					driver.findElement(By.linkText("Misc Disbursements Log Report")).click();
					test.log(LogStatus.PASS, "Clicked on Misc Disbursements Log Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Misc Disbursements Log Report']")).getText();
					Assert.assertEquals("Misc Disbursements Log Report",product);
					test.log(LogStatus.PASS, "Misc Disbursements Log Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Misc Disbursements Log Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Currency Transaction Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Currency Transaction Report link  is enabled");
					driver.findElement(By.linkText("Currency Transaction Report")).click();
					test.log(LogStatus.PASS, "Clicked on Currency Transaction Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Currency Transaction Report']")).getText();
					Assert.assertEquals("Currency Transaction Report",product);
					test.log(LogStatus.PASS, "Currency Transaction Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Currency Transaction Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Rescission Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Rescission Report link  is enabled");
					driver.findElement(By.linkText("Rescission Report")).click();
					test.log(LogStatus.PASS, "Clicked on Rescission Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Rescission Report']")).getText();
					Assert.assertEquals("Rescission Report",product);
					test.log(LogStatus.PASS, "Rescission Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Rescission Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Debit Card payments Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Debit Card payments Report link  is enabled");
					driver.findElement(By.linkText("Debit Card payments Report")).click();
					test.log(LogStatus.PASS, "Clicked on Debit Card payments Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Debit Card payments Report']")).getText();
					Assert.assertEquals("Debit Card payments Report",product);
					test.log(LogStatus.PASS, "Debit Card payments Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Debit Card payments Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Loans With Credit Balance Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Loans With Credit Balance Report link  is enabled");
					driver.findElement(By.linkText("Loans With Credit Balance Report")).click();
					test.log(LogStatus.PASS, "Clicked on Loans With Credit Balance Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Loans With Credit Balance Report']")).getText();
					Assert.assertEquals("Loans With Credit Balance Report",product);
					test.log(LogStatus.PASS, "Loans With Credit Balance Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Loans With Credit Balance Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("NOAT Missing Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "NOAT Missing Report link  is enabled");
					driver.findElement(By.linkText("NOAT Missing Report")).click();
					test.log(LogStatus.PASS, "Clicked on NOAT Missing Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//u[text()='Filter Options']")).getText();
					Assert.assertEquals("Filter Options",product);
					test.log(LogStatus.PASS, "NOAT Missing Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "NOAT Missing Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Miscellaneous Receipts Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Miscellaneous Receipts Report link  is enabled");
					driver.findElement(By.linkText("Miscellaneous Receipts Report")).click();
					test.log(LogStatus.PASS, "Clicked on Miscellaneous Receipts Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Miscellaneous Receipts Report']")).getText();
					Assert.assertEquals("Miscellaneous Receipts Report",product);
					test.log(LogStatus.PASS, "Miscellaneous Receipts Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Miscellaneous Receipts Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Teller Productivity Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Teller Productivity Report link  is enabled");
					driver.findElement(By.linkText("Teller Productivity Report")).click();
					test.log(LogStatus.PASS, "Clicked on Teller Productivity Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Teller Productivity Report']")).getText();
					Assert.assertEquals("Teller Productivity Report",product);
					test.log(LogStatus.PASS, "Teller Productivity Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Teller Productivity Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Large Scale Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Large Scale Report link  is enabled");
					driver.findElement(By.linkText("Large Scale Report")).click();
					test.log(LogStatus.PASS, "Clicked on Large Scale Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Large Scale Report']")).getText();
					Assert.assertEquals("Large Scale Report",product);
					test.log(LogStatus.PASS, "Large Scale Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Large Scale Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Loan Denial Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Loan Denial Report link  is enabled");
					driver.findElement(By.linkText("Loan Denial Report")).click();
					test.log(LogStatus.PASS, "Clicked on Loan Denial Report");
					//Thread.sleep(1500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Loan Denial Report']")));
					String product=driver.findElement(By.xpath("//td[text()='Loan Denial Report']")).getText();
					Assert.assertEquals("Loan Denial Report",product);
					test.log(LogStatus.PASS, "Loan Denial Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Loan Denial Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("ACH Collection Inventory Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "ACH Collection Inventory Report link  is enabled");
					driver.findElement(By.linkText("ACH Collection Inventory Report")).click();
					test.log(LogStatus.PASS, "Clicked on ACH Collection Inventory Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='ACH Collection Inventory Report']")).getText();
					Assert.assertEquals("ACH Collection Inventory Report",product);
					test.log(LogStatus.PASS, "ACH Collection Inventory Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "ACH Collection Inventory Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Payment Plan Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Payment Plan Report link  is enabled");
					driver.findElement(By.linkText("Payment Plan Report")).click();
					test.log(LogStatus.PASS, "Clicked on Payment Plan Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Payment Plan Report']")).getText();
					Assert.assertEquals("Payment Plan Report",product);
					test.log(LogStatus.PASS, "Payment Plan Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Payment Plan Report Sub_link is not working fine");
				}
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Other Reports")).click();
				test.log(LogStatus.PASS, "Clicked on Other Reports");
				Thread.sleep(500);				
				if (driver.findElement(By.linkText("Refinance Report")).isDisplayed()) {
					test.log(LogStatus.PASS, "Refinance Report link  is enabled");
					driver.findElement(By.linkText("Refinance Report")).click();
					test.log(LogStatus.PASS, "Clicked on Refinance Report");
					Thread.sleep(500);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					String product=driver.findElement(By.xpath("//td[text()='Refinance Report']")).getText();
					Assert.assertEquals("Refinance Report",product);
					test.log(LogStatus.PASS, "Refinance Report Sub_link is working fine");
					test.log(LogStatus.PASS, "*******************************************");
				} else {
					test.log(LogStatus.PASS, "Refinance Report Sub_link is not working fine");
				}
				
			
	
	}
	

	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
			//We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method.
			String screenshotPath = this.getScreenhot(driver, result.getName());
			//To add it in the extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		}else if(result.getStatus() == ITestResult.SKIP){
			test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}else if(result.getStatus() == ITestResult.SUCCESS){
			test.log(LogStatus.PASS, result.getName()+" Test Case is Passed");}

	}
	@BeforeClass
	//public void callSetup() throws Exception  {
	// TestBase.setup();
	//This method to generate extent reports and driver initialization
	public static void setup() throws IOException {

		try{ String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());

		report_filename="QC_Smoke_Execution_Report_"+timestamp+".html";
		reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/QC_CSR/Smoke/"+report_filename,true);
		//      reports.addSystemInfo("Browser Version","Chrome 69");

		//****Browser initializations
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/IEDriverServer.exe");
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
		driver = new InternetExplorerDriver();
		//driver=new ChromeDriver();

		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(05, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(03, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10000);

		BufferedReader reader;
		reader = new BufferedReader(new FileReader("D:/QC_Batch/Smoke/src/test/java/QCHome/Objects.properties"));
		prop = new Properties();

		prop.load(reader);
		reader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@AfterTest
	public void endReport(){
		reports.flush();
		//driver.quit();

	}
	public  static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/LendNation/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	public static By locator(String obj)
	{

		String loctype=null;
		String locname=null;
		By locator=null;
		String[] locobj=obj.split("%%"); 
		loctype=locobj[0];
		locname=locobj[1];

		if(loctype.equalsIgnoreCase("id"))
			return locator=By.id(locname);
		else if(loctype.equalsIgnoreCase("name"))
			return locator=By.name(locname);
		else if(loctype.equalsIgnoreCase("linkText"))
			return locator=By.linkText(locname);
		else if(loctype.equalsIgnoreCase("xpath"))
			return locator=By.xpath(locname);
		else if(loctype.equalsIgnoreCase("cssSelector"))
			return locator=By.cssSelector(locname);
		return locator;

	}



}

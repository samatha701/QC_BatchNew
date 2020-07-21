package DBtesting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import DBtesting.QCStore;

public class QCValidations extends QCStore {
	


	public static void validation(String SSN,String AppURL) throws Exception
	{
		int i;
		for(i=0;i<3;i++)
		{
			
		try{
			//String FileName= prop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Borrower_Registration");
				String sheetName="Borrower_Registration";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					
					


					if(SSN.equals(RegSSN))
					{	
				
						test.log(LogStatus.INFO, "Verifying Borrower Registration values from the DB and entered details ");
						
						//test.log(LogStatus.INFO, MarkupHelper.createLabel("Borrower Registration has started", ExtentColor.BLUE));
							          
				
						String UserName = TestData.getCellData(sheetName,"UserName",row);
						String Password = TestData.getCellData(sheetName,"Password",row);
				       // System.out.println(Password);
				        String StoreId = TestData.getCellData(sheetName,"StoreID",row);
				        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				        String StateID = TestData.getCellData(sheetName,"StateID",row);
				      	
				        String Header = StateID+ "_" + ProductID;	      
				        String ProductType= TestData.getCellData(sheetName,"ProductType",row);         
				       String LastName = TestData.getCellData(sheetName,"LastName",row);
				       String FirstName = TestData.getCellData(sheetName,"FirstName",row);
				       String AddressLine = TestData.getCellData(sheetName,"AddressLine",row);
				       String City = TestData.getCellData(sheetName,"City",row);
				       String State = TestData.getCellData(sheetName,"State",row);	      
				       String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);
				       String MonthsAtAddress = TestData.getCellData(sheetName,"MonthsAtAddress",row);	     
				       String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
				       String Bank_ChkgAcctNbr = SSN.substring(SSN.length() - 6);  
				       String Ctc_PrimaryPhone = TestData.getCellData(sheetName,"Ctc_PrimaryPhone",row);
				       String Ctc_PhoneType = TestData.getCellData(sheetName,"Ctc_PhoneType",row);
				       String Misc_PhotoIDNbr = SSN.substring(SSN.length() - 6);
				       String Misc_IDExpDate = TestData.getCellData(sheetName,"Misc_IDExpDate",row);	   
				       String Misc_PhotoIDType = TestData.getCellData(sheetName,"Misc_PhotoIDType",row);
				       String BorrDOB = TestData.getCellData(sheetName,"Misc_DOB",row);
				       String Income_IncomeType = TestData.getCellData(sheetName,"Income_IncomeType",row);
				       String Income_Employer = TestData.getCellData(sheetName,"Income_Employer",row);
				       String Income_WorkPhone = TestData.getCellData(sheetName,"Income_WorkPhone",row);
				       String Income_NetIncomeAmt = TestData.getCellData(sheetName,"Income_NetIncomeAmt",row);
				       String Income_GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
				       String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				       String Income_HireDt = TestData.getCellData(sheetName,"Income_HireDt",row);
				       String Income_DirectDeposit=TestData.getCellData(sheetName,"Income_DirectDeposit",row);	       
				       String PrimaryRef_LastName = TestData.getCellData(sheetName,"PrimaryRef_LastName",row);
				       String PrimaryRef_FirstName = TestData.getCellData(sheetName,"PrimaryRef_FirstName",row);
				       String PrimaryRef_Relationship = TestData.getCellData(sheetName,"PrimaryRef_Relationship",row);
				       String PrimaryRef_PhoneNbr=TestData.getCellData(sheetName,"PrimaryRef_PhoneNbr",row);
				       String Ref_LastName = TestData.getCellData(sheetName,"Ref_LastName",row);
				       String Ref_FirstName = TestData.getCellData(sheetName,"Ref_FirstName",row);
				       String Ref_Relationship = TestData.getCellData(sheetName,"Ref_Relationship",row);
				       String Ref_PhoneNbr=TestData.getCellData(sheetName,"Ref_PhoneNbr",row);	       
				       String Bankruptcy=TestData.getCellData(sheetName,"Bankruptcy",row);	     
						//	test.log(LogStatus.INFO, "Borrower Registration-SSN: " +SSN);
							
							   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
						        String SSN1 = SSN.substring(0, 3);
						        String SSN2 = SSN.substring(3,5);
						        String SSN3 = SSN.substring(5,9);
						        String PP1 = Ctc_PrimaryPhone.substring(0, 3);
						        String PP2 = Ctc_PrimaryPhone.substring(3, 6);
						        String PP3 = Ctc_PrimaryPhone.substring(6, 10);
						        String IncomeP1 = Income_WorkPhone.substring(0, 3);
						        String IncomeP2 = Income_WorkPhone.substring(3, 6);
						        String IncomeP3 = Income_WorkPhone.substring(6, 10);
						        String PrimaryRef_PhoneNbr1 = PrimaryRef_PhoneNbr.substring(0, 3);
						        String PrimaryRef_PhoneNbr2 = PrimaryRef_PhoneNbr.substring(3, 6);
						        String PrimaryRef_PhoneNbr3 = PrimaryRef_PhoneNbr.substring(6, 10);
						        String Ref_PhoneNbr1 = Ref_PhoneNbr.substring(0, 3);
						        String Ref_PhoneNbr2 = Ref_PhoneNbr.substring(3, 6);
						        String Ref_PhoneNbr3 = Ref_PhoneNbr.substring(6, 10);			       
						        System.out.println(Misc_IDExpDate);
						        Date Misc_IDExpDt = df.parse(Misc_IDExpDate);
						        String IDExpDate0 =df.format(Misc_IDExpDt);	
						        System.out.println(IDExpDate0);
						        String IDExpDate[] =IDExpDate0.split("/");
						        String IDExpD1 = IDExpDate[0];
						        String IDExpD2 = IDExpDate[1];
						        String IDExpD3 = IDExpDate[2];
						        String DOB[] =BorrDOB.split("/");
						        String DOB1 = DOB[0];
						        String DOB2 = DOB[1];
						        String DOB3 = DOB[2];	
						        String Monthly_Type= TestData.getCellData(sheetName,"MonthlyType",row);
						        String Monthly_payWeek=TestData.getCellData(sheetName,"MonthlyPayWeek",row);
						        String Monthly_payWeekDay=TestData.getCellData(sheetName,"MonthlyPayWeekDay",row);
						        String Monthly_payday= TestData.getCellData(sheetName,"MonthlyPayDay",row);
						       
						        
						        if (SSN.equalsIgnoreCase(SSN_DB)) {
						        	
						        	test.log(LogStatus.PASS, "SSN entered from the sheet "+SSN+" is equals to SSN retrieved from the DB is "+SSN_DB);
						        	
									
								} else {
						        	test.log(LogStatus.FAIL, "SSN entered from the sheet "+SSN+" is not equals to SSN retrieved from the DB is"+SSN_DB);

								}
						        
						        if (FirstName.equalsIgnoreCase(first_name_db)) {
						        	
						        	test.log(LogStatus.PASS, "FirstName entered from the sheet "+FirstName+" is equals to SSN retrieved from the DB is"+first_name_db);
						        	
									
								} else {
						        	test.log(LogStatus.FAIL, "FirstName entered from the sheet "+FirstName+" is not equals to SSN retrieved from the DB is "+first_name_db);

								}
	        if (LastName.equalsIgnoreCase(last_name_db)) {
						        	
						        	test.log(LogStatus.PASS, "LastName entered from the sheet "+last_name_db+" is equals to SSN retrieved from the DB is "+LastName);
						        	
									
								} else {
						        	test.log(LogStatus.FAIL, "LastName entered from the sheet "+last_name_db+" is not equals to SSN retrieved from the DB is "+LastName);

								}
						        
	        if (Misc_PhotoIDNbr.equalsIgnoreCase(drivers_lin_db)) {
	        	
	        	test.log(LogStatus.PASS, "Misc_PhotoIDNbr entered from the sheet "+drivers_lin_db+" is equals to SSN retrieved from the DB is "+Misc_PhotoIDNbr);
	        	
				
			} else {
	        	test.log(LogStatus.FAIL, "Misc_PhotoIDNbr entered from the sheet "+drivers_lin_db+" is not equals to SSN retrieved from the DB is "+Misc_PhotoIDNbr);

			}
	        
						      
						       
							break;
							}
					
					}	
			break;
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Borrower Registration is failed", ExtentColor.RED));
				test.log(LogStatus.FAIL,"Exception occured "+e.toString().substring(0, 250));
				
				test.log(LogStatus.FAIL, "Validation is failed");
				
				continue;

			}
		

}
		
	}
	}


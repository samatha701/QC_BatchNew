package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class HistoryTesting extends QCStore{

	public static String ACH_type;
	public static String ACH_transaction;
	public static String ACH_status;
	public static String ACH_amount;
	public static String ACH_ABA_code;
	public static String ACH_check_acc_no;
	public static String ach_history_ach_type;
	public static String ach_history_ach_transaction;
	public static String ach_history_ach_status;
	public static String ach_history_ach_amt;
	public static String ach_history_ach_check_acc_no;
	public static String ach_history_ach_ABA_code;
	public static String appdate;
	public static String Trasn_date;
	public static String Transaction ;
	public static String Total_Amt ;
	public static String Inst ;
	public static String Tender_type;
	public static String Adv_amt ;
	public static String Interest;
	public static String CoupAmt ;
	public static String LTrasn_date1;
	public static String LTransaction;
	public static String LTotal_Amt;
	public static String LTender_type;
	public static String LInst;
	public static String LAdv_amt;
	public static String LInterest;
	public static String LCoupAmt;
	
	public static void testing (String SSN,String AppURL) throws Exception
	{	
		//test.log(LogStatus.PASS, "******************Performing  payment ******************");
		  	
		int lastrow=TestData.getLastRow("Borrower_Registration");
		String sheetName="Borrower_Registration";
		String sheetName_calc="HistoryFieldsValidation";
		String sheetName_new_loan="New_Loan";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String UserName = TestData.getCellData(sheetName,"UserName",row);
				String Password = TestData.getCellData(sheetName,"Password",row);
		       // System.out.println(Password);
		        String StoreId = TestData.getCellData(sheetName,"StoreID",row);
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
		        String Header = StateID+ "_" + ProductID;	      
		        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
		        System.out.println(columnname);
		       String LastName = TestData.getCellData(sheetName,"LastName",row);
		       String FirstName = TestData.getCellData(sheetName,"FirstName",row);
		       String customer_name=LastName+", "+FirstName;
		       String AddressLine = TestData.getCellData(sheetName,"AddressLine",row);
		       String City = TestData.getCellData(sheetName,"City",row);
		       String State = TestData.getCellData(sheetName,"State",row);	      
		       String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);
		       String MonthsAtAddress = TestData.getCellData(sheetName,"MonthsAtAddress",row);	     
		       String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
		       String Bank_ChkgAcctNbr = TestData.getCellData(sheetName,"Bank_ChkgAcctNbr",row);	       
		       String Ctc_PrimaryPhone = TestData.getCellData(sheetName,"Ctc_PrimaryPhone",row);
		       String Ctc_PhoneType = TestData.getCellData(sheetName,"Ctc_PhoneType",row);
		       String Misc_PhotoIDNbr = TestData.getCellData(sheetName,"Misc_PhotoIDNbr",row);
		       String Misc_IDExpDate = TestData.getCellData(sheetName,"Misc_IDExpDate",row);	   
		       String Misc_PhotoIDType = TestData.getCellData(sheetName,"Misc_PhotoIDType",row);
		       String BorrDOB = TestData.getCellData(sheetName,"Misc_DOB",row);
		       String Income_IncomeType = TestData.getCellData(sheetName,"Income_IncomeType",row);
		       String ESign_CollateralType = TestData.getCellData(sheetName_new_loan,"ESign_CollateralType",row);
		       String courtesy_consent=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",23);
		     //  String courtesy_consent_status=TestData.getCellData(sheetName_new_loan,"ESign_Preference",row);
		       String collateral_type=TestData.getCellData(sheetName_new_loan,"ESign_CollateralType",row);
		       
		       String primary_source_of_income = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",4);


		     
		       String Income_WorkPhone = TestData.getCellData(sheetName,"Income_WorkPhone",row);
		       String NetIncomeAmt = TestData.getCellData(sheetName,"Income_NetIncomeAmt",row);
		       
		       String GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
		       String pay_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",7);
		       String loan_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",8);
		       String check_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",9);
		       String NextDueDate=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",10);
		       String AccuredInterest=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",11);
		       String product_name=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",12);
		       String product_type=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",13);
		       String loan_amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",15);
		      // String finance_charge=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",13);
		       
		       String noofinstall=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",20);
		       
		       String apr=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",17);
		   //String collateral_type=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",18);
		       String loan_account_inf_inst_amt_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",19);
		       String loan_account_inf_no_of_installments_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",20);
		       
		       String loan_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",21);
		   //    String credot_or_verification_fee=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",18);
		    
		       
		       String available_credit=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",22);
		       String courtesy_consent_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",23);
		       String courtesy_inf_courtesy_status_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",24);
		       
		       String principal_balance=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",25);
		       String fee_due=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",26);
		       
		       String pay_off_amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",27);
		       String loan_balance_inf_past_due_amt_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",28);

		       String principal_paid_to_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",29);

		       String fee_paid_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",30);

		       String loan_paid_summary_total_paid_amt_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",31);
		       String campaign_name=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",32);
		       String promotion_code=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",33);
		       
		       driver.switchTo().frame("bottom");
				String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
				String appdatelist[]=Str_date.split(":");
				appdate=appdatelist[1].trim();
				test.log(LogStatus.INFO, "Business Date is "+appdate);
				//String cust_transaction_date_test=appdate;
				String tran_date_sheet=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",2);
		       
		       //String cust_transaction_date_test=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",2);
		       String cust_tran_test=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",3);
		       String cust_doc_total_amount_test=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",4);
		       String cust_doc_tender_type_test=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",5);
		       String cust_doc_inst_test=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",6);
		       String cust_doc_adv_amount_test=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",7);
		       String cust_doc_interest_test=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",8);
		       //String cust_doc_new_balance_test=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",9);
		       String cust_doc_PromotionCoupon_Amt_test=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",9);
		       String total_paid_amountc=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",31);
			      
//ACH collateral details from sheet
		      if(ESign_CollateralType.equals("ACH"))
		      {
			    	//To read from Excel
		    	  ACH_type=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",2);
			       ACH_transaction=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",3);
			        ACH_status=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",4);
			       ACH_amount=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",5);
			       ACH_ABA_code=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",6);
			       ACH_check_acc_no=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",7);
			       
		
		      }

		       
		      
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
					
					   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        
				        String SSNverify="XXX-XX-"+SSN3;
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
				        
				Thread.sleep(4000);
			//	test.log(LogStatus.INFO, MarkupHelper.createLabel("Transaction History validation has started", ExtentColor.BLUE));
				test.log(LogStatus.INFO, "Transaction History validation has started");
		       
				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
		        driver.findElement(By.cssSelector("li[id='910000']")).click();	
		        Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("li[id='911101']")).click();			
				Thread.sleep(5000);	
				driver.switchTo().frame("main");	
				driver.findElement(By.name("ssn1")).sendKeys(RegSSN);
				
				driver.findElement(By.name("submit1")).click();

				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    driver.findElement(By.name("button")).click();
				    Thread.sleep(5000);	
				    driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
				    Thread.sleep(10000);        ////*[@id="CustGrid"]/tbody/tr[2]/td[13]/table/tbody/tr/td[1]/select 
				    driver.findElement(By.xpath("//*[@id='CustGrid']/tbody/tr[2]/td[11]/table/tbody/tr/td[1]/select")).sendKeys("History");

				    driver.findElement(By.xpath("//*[@id='go_Button']")).click();
				    
				    //Customer Inforrmation
				    //test.log(LogStatus.INFO,"<FONT color=blue style=Bold> Third Party Collection PASS");
				    test.log(LogStatus.INFO, "<b> <FONT color=green style=Bold> History field values at screen level</b>");
				    test.log(LogStatus.INFO, "<b> <FONT color=blue style=Bold> Customer Information </b>");
				    String customer = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[2]/td/span[2]/span")).getText();
				    test.log(LogStatus.PASS, "customer: " +customer);
				   
				    String customer_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[3]/td/span[2]/span")).getText();
					 test.log(LogStatus.PASS, "customer_Nbr: " + customer_Nbr);
					    
					    String SSN_ITLN = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[4]/td/span[2]/span")).getText();
					    test.log(LogStatus.PASS, "SSN_ITLN:  " + SSN_ITLN);
					    
					    String primary_phone_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[5]/td/span[2]")).getText();
					    test.log(LogStatus.PASS, "primary_phone_Nbr:  " + primary_phone_Nbr);
					    
					    String phone_type = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[6]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "phone type: " + phone_type);
					    
					    String state = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[7]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "state:  " + state);
					    
					    String customer_type = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[9]/td/span[2]")).getText();
					    test.log(LogStatus.PASS, "customer_type: " + customer_type);
					    
					    //Customer Active Bank Information
					    test.log(LogStatus.INFO, "<b> <FONT color=blue style=Bold> Customer Active Bank Information </b>");
					    String type_of_account = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[12]/td/span[2]")).getText();
					    test.log(LogStatus.PASS, "type_of_account:  " + type_of_account);
					    
					    String Routing_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[13]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Routing_Nbr:  " + Routing_Nbr);
					    
					    String Account_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[14]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Account_Nbr:  " + Account_Nbr);
					    
					    String Account_status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[15]/td/span[2]")).getText();
					 test.log(LogStatus.PASS, "Account_status:  " + Account_status);
					    
					    String Bank_Name = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[16]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Bank_Name:  " + Bank_Name);
					    
					    //UnderWriting Information
					   test.log(LogStatus.INFO, "<b> <FONT color=blue style=Bold> UnderWriting Information </b>");
					    String Veritec_Tran_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[19]/td/span[2]")).getText();
					    test.log(LogStatus.PASS,"Veritec_Tran_Nbr:" +Veritec_Tran_Nbr);
					    
					    String MLA_Status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[20]/td/span[2]")).getText();
					    test.log(LogStatus.PASS, "MLA_Status:" +MLA_Status);
					    
					    String OFAC_Status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[21]/td/span[2]")).getText();
					    test.log(LogStatus.PASS, "OFAC_Status:" +OFAC_Status);
					    
					    
					    //Promotion/Coupon Information
					    test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Promotion/Coupon Information </b>");
					    String Campaign_Name = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[24]/td/span/span")).getText();
					    test.log(LogStatus.PASS, "Campaign_Name:" +Campaign_Name);
					    
					    String Hpromotion_code = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[25]/td/span/span")).getText();
					   test.log(LogStatus.PASS, "promotion_code:  " + Hpromotion_code);
					    
					    /*String promotion_discount = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[26]/td/span/span")).getText();
					    //System.out.println("promotion_discount:" +promotion_discount);
					    test.log(LogStatus.PASS, "promotion_discount: " + promotion_discount);*/
					    
					    //Employer Information
					   test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Employer Information </b>");
					    String 	Primary_Source_Of_Income = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[2]/td/span[2]")).getText();
					 test.log(LogStatus.PASS, "Primary_Source_Of_Income:  " + Primary_Source_Of_Income);
					    
					    String Current_Employer = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[3]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Current_Employer:  " + Current_Employer);
					    
					    String Net_Pay = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[4]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Net_pay:  " + Net_Pay);
					    
					    String Gross_Pay = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[5]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Gross_Pay:  " + Gross_Pay);
					    
					    String Pay_Frequency = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[6]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Pay_Frequency:  " + Pay_Frequency);
					    
					    String Employer_Phone_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[7]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Employer_Phone_Nbr: " + Employer_Phone_Nbr);
					    
					    //Courtesy/Collection Information
					   test.log(LogStatus.INFO, "<b> <FONT color=blue style=Bold> Courtesy/Collection Information </b>");
					    String Courtesy_Consent = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[10]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Courtesy_Consent:  " + Courtesy_Consent);
					    
					    String Consent_Type = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[11]/td/span[2]")).getText();
					    test.log(LogStatus.PASS, "Consent_Type: " + Consent_Type);
					                                                  //*[@id="transactionHistoryTable"]/tbody/tr/td[2]/table/tbody/tr[12]/td/span[2]
					    String Status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[12]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Staus: " + Status);
					  
					  String Assigned_To = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[13]/td/span[2]")).getText();
					    test.log(LogStatus.PASS, "Assigned_To:" +Assigned_To);
					    
					    String CAD_Flag = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[14]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "CAD_Flag:  " + CAD_Flag);
					    
					    String DMC_Details = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[15]/td/span[2]")).getText();
					 test.log(LogStatus.PASS, "DMC_Details: " + DMC_Details);
					 
					 String DMC_Customer = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[16]/td/span[2]")).getText();
					 test.log(LogStatus.PASS,"DMC_Customer: " +DMC_Customer);
					 
					 String DMC_Company = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[17]/td/span[2]")).getText();
					 test.log(LogStatus.PASS,"DMC_Company: " +DMC_Company);
					 
					 String DMC_Phone = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[18]/td/span[2]")).getText();
					 test.log(LogStatus.PASS,"DMC_Phone: " +DMC_Phone);
					 
					 String Legal_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[19]/td/span[2]")).getText();
					 test.log(LogStatus.PASS,"Legal_Date: " +Legal_Date);
					 
					  String IS_Legal = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[20]/td/span[2]")).getText();
					test.log(LogStatus.PASS, "IS_Legal: " + IS_Legal);
					    
					String Granishment_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[21]/td/span[2]")).getText();
					test.log(LogStatus.PASS,"Granishment_Date: " +Granishment_Date);
					
					 String IS_Garnishment = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[22]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "IS_Garnishment: " + IS_Garnishment);
					  
					  String VPD_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[23]/td/span[2]")).getText();
					  test.log(LogStatus.PASS,"VPD_Date: " +VPD_Date);
					    
					    String IS_Vpd = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[2]/table/tbody/tr[24]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "IS_VPD: " + IS_Vpd);
					    
					    //Loan Account Status
					    test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Loan Account Status </b>");
					    String Loan_Status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[2]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Loan_Status:  " + Loan_Status);
					    
					    String Balance_Status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[3]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Balance_Status: " + Balance_Status);
					    
					    String Next_Due_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Next_Due_Date: " + Next_Due_Date);
					    
					    String Number_Of_Installmets_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[5]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Number_Of_Installments_Due:  " + Number_Of_Installmets_Due);
					    
					    String Latest_Payment_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[6]/td/span[2]")).getText();
					 test.log(LogStatus.PASS, "Latest_Payment_Date:  " + Latest_Payment_Date);
					 
					 String Default_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[7]/td/span[2]")).getText();
					 test.log(LogStatus.PASS,"Default_Date: " +Default_Date);
					 
					 String Write_off_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[8]/td/span[2]")).getText();
					 test.log(LogStatus.PASS,"Write_off_Date: " +Write_off_Date);
					    
					    String Pending_Bankruptcy = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[9]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Pending_Bankruptcy: " + Pending_Bankruptcy);
					  
					  String Bankruptcy_Filling_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[10]/td/span[2]")).getText();
					  test.log(LogStatus.PASS,"Bankruptcy_Filling_Date: " +Bankruptcy_Filling_Date);
					  
					  String Bankruptcy_status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[11]/td/span[2]")).getText();
					  test.log(LogStatus.PASS,"Bankruptcy_status: " +Bankruptcy_status);
					  
					  String Discharge_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[12]/td/span[2]")).getText();
					  test.log(LogStatus.PASS,"Discharge_Date: " +Discharge_Date);
					    
					    String As_of_Today_Accrued_Intrest = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[13]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "As_of_Today_Accrued_Intrest: " + As_of_Today_Accrued_Intrest);
					    
					    //Loan Balance Summery
					    test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Loan Balance Summery </b>");
					                                                            //*[@id="transactionHistoryTable"]/tbody/tr/td[3]/table/tbody/tr[16]/td/span[2]
					    String Principle_Balance = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[16]/td/span[2]")).getText();
					test.log(LogStatus.PASS, "Principle_Balance: " + Principle_Balance);
					    
					    String Earned_and_unpaid_intrest = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[17]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Earned_and_unpaid_intrest: " + Earned_and_unpaid_intrest);
					    
					    String Return_Fee_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[18]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Return_Fee_Due: " + Return_Fee_Due);
					    
					    String Late_Fee_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[19]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Late_Fee_Due: " + Late_Fee_Due);
					    
					    String Pay_off_Amt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[20]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Pay_off_Amt: " + Pay_off_Amt);
					    
					    String Past_Due_Amt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[21]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Past_Due_Amt: " + Past_Due_Amt);
					    
					    String Verification_Fee_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[22]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Verification_Fee_Due: " + Verification_Fee_Due);
					    
					    String CSO_Fee_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[23]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "CSO_Fee_Due: " + CSO_Fee_Due);
					    
					    //Loan Paid To_Date Summery
					       
					    //*[@id="transactionHistoryTable"]/tbody/tr/td[3]/table/tbody/tr[26]/td/span/span
					   test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Loan Paid To_Date Summery </b>");
					    String Principal_Paid_To_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[26]/td/span/span")).getText();
					   test.log(LogStatus.PASS, "Principal_Paid_To_Date: " + Principal_Paid_To_Date);
					    
					    String Intrest_Paid_to_date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[27]/td/span/span")).getText();
					  test.log(LogStatus.PASS, "Intrest_Paid_to_date: " + Intrest_Paid_to_date);
					    
					    String Return_Fee_Paid_to_date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[28]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Return_Fee_Paid_to_date: " + Return_Fee_Paid_to_date);
					    
					    String Late_Fee_Paid_to_date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[29]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Late_Fee_Paid_to_date: " + Late_Fee_Paid_to_date);
					    
					    String Total_Paid_Amt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[30]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Total_Paid_Amt: " + Total_Paid_Amt);
					    
					    String Orig_Fee_Paid = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[31]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Orig_Fee_Paid: " + Orig_Fee_Paid);
					    
					    String Verification_Fee_Paid = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[32]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Verification_Fee_Paid: " + Verification_Fee_Paid);
					    
					    String Orig_Fee_Waived = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[33]/td/span[2]")).getText();
					    test.log(LogStatus.PASS, "Orig_Fee_Waived:  " + Orig_Fee_Waived);
					    
					    String CSO_Fee_Paid = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[34]/td/span[2]")).getText();
					test.log(LogStatus.PASS, "CSO_Fee_Paid: " + CSO_Fee_Paid);
					    
					    //Loan Account Information
						  test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Loan Account Information </b>");
						//*[@id="transactionHistoryTable"]/tbody/tr/td[4]/table/tbody/tr[2]/td/span/text()
						//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[2]/td
					    String Product_Name = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[2]/td/span")).getText();
					  test.log(LogStatus.PASS, "Product_Name: " + Product_Name);
					    
					    String Product_Type = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[3]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Product_Type: " + Product_Type);
					    
					    String Loan_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Loan_Nbr: " + Loan_Nbr);
					    
					    String Loan_Amt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[5]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Loan_Amt: " + Loan_Amt);
					    
					    String APR = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[6]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "APR: " + APR);
					    
					    String Intrest_Fee = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[7]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Intrest_Fee: " + Intrest_Fee);
					    
					    String Loan_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[8]/td/span[2]")).getText();
					 test.log(LogStatus.PASS, "Loan_Date:  " + Loan_Date);
					 
					                                                           //*[@id="transactionHistoryTable"]/tbody/tr/td[4]/table/tbody/tr[9]/td/span[2]					 		    
					    String Installment_Amt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[9]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Installment_Amt: " + Installment_Amt);
					    
					    String Number_of_installments = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[10]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Number_of_installments: " + Number_of_installments);
					    
					    String Collateral_Type = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[11]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Collateral_Type: " + Collateral_Type);
					    
					    String Loan_Frequency = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[12]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Loan_Frequency:  " + Loan_Frequency);
					    
					    String Origination_Store = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[13]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Origination_Store:  " + Origination_Store);
					    
					    String Verification_Fee = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[32]/td/span[2]")).getText();
					    test.log(LogStatus.PASS, "Verification_Fee:  " + Verification_Fee);
					    
					    String CSO_Fee = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[34]/td/span[2]")).getText();
					    //System.out.println("CSO_Fee:" +CSO_Fee);
					    test.log(LogStatus.PASS, "CSO_Fee:  " + CSO_Fee);
					    
					    String Available_Credit = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[16]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Available_Credit:  " + Available_Credit);
					    
					  //Loan Bank Account Information
					   test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Loan Bank Account Information </b>");
					    String Loan_ABA_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[19]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Loan_ABA_Nbr:  " + Loan_ABA_Nbr);
					    
					    String Loan_Account_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[20]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Loan_Account_Nbr:  " + Loan_Account_Nbr);
					    
					    //Third Party Collection Information
					   test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> <FONT color=blue style=Bold> Third Party Collection Information </b>");
					   String Transfer_Out_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[24]/td/span[2]")).getText();
					   test.log(LogStatus.PASS,"Transfer_Out_Date: " +Transfer_Out_Date);
					   
					   String Transfer_In_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[25]/td/span[2]")).getText();
					   test.log(LogStatus.PASS,"Transfer_In_Date: " +Transfer_In_Date);
					   
					    String Account_Sold = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[26]/td/span[2]")).getText();
					  test.log(LogStatus.PASS, "Account_Sold:  " + Account_Sold);
					  
					  String Sold_To = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[27]/td/span[2]")).getText();
					  test.log(LogStatus.PASS,"Sold_To: " +Sold_To);
					  
					  String Sold_date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[28]/td/span[2]")).getText();
					  test.log(LogStatus.PASS,"Sold_date: " +Sold_date);
					    
					    String Mark_For_Sale = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[29]/td/span[2]")).getText();
					   test.log(LogStatus.PASS, "Mark_For_Sale:  " + Mark_For_Sale);
					   
					   String Agency_Name = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[30]/td/span[2]")).getText();
					   test.log(LogStatus.PASS,"Agency_Name: " +Agency_Name);
					    
					   test.log(LogStatus.INFO, "<b> <FONT color=blue style=Bold>Customer Transaction field values at screen level</b>");
					    //Loan Tran Code
					    List<WebElement> list=driver.findElements(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr"));
					    int x=list.size();
					    //test.log(LogStatus.PASS, "list size" +x);
					    for(int i=2;i<list.size()-1;i++){
					    	
					 // test.log(LogStatus.INFO,  i-1 +  "<b> <FONT color=blue style=Bold> Row </b>");
					    	
					  String Loan_Tran_Code = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[2]")).getText();
					  test.log(LogStatus.PASS, "Loan_Tran_Code:" + Loan_Tran_Code);
					  
					  String loc_Nbr = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[3]")).getText();
					  test.log(LogStatus.PASS, "loc_Nbr:" + loc_Nbr);
					  
					  String other_loc_Nbr = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[4]")).getText();
					  test.log(LogStatus.PASS, "other_loc_Nbr:" + other_loc_Nbr);
					  
					   Trasn_date = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[5]")).getText();
					  test.log(LogStatus.PASS, "Trasn_date:" + Trasn_date);
					  
					   Transaction = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[6]")).getText();
					  test.log(LogStatus.PASS, "Transaction:" + Transaction);
					  
					   Total_Amt = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[7]")).getText();
					  test.log(LogStatus.PASS, "Total_Amt:" + Total_Amt);
					  
					   Tender_type = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[8]")).getText();
					  test.log(LogStatus.PASS, "Tender_type:" + Tender_type);
					  
					  Inst = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[9]")).getText();
					  test.log(LogStatus.PASS, "Inst:" + Inst);
					  
					  Adv_amt = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[10]")).getText();
					  test.log(LogStatus.PASS, "Adv_amt:" + Adv_amt);
					  
					  Interest = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[11]")).getText();
					  test.log(LogStatus.PASS, "Interest:" + Interest);
					  
					  String Nsf_Fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[12]")).getText();
					  test.log(LogStatus.PASS, "Nsf_Fee:" + Nsf_Fee);
					  
					  String Waived_Nsf_Fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[13]")).getText();
					  test.log(LogStatus.PASS, "Waived_Nsf_Fee:" + Waived_Nsf_Fee);
					  
					  String Late_fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[14]")).getText();
					  test.log(LogStatus.PASS, "Late_fee:" + Late_fee);
					  
					  String Waived_late_fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[15]")).getText();
					  test.log(LogStatus.PASS, "Waived_late_fee:" + Waived_late_fee);
					  
					  String Other_fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[16]")).getText();
					  test.log(LogStatus.PASS, "Other_fee:" + Other_fee);
					  
					  String New_balance = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[17]")).getText();
					  test.log(LogStatus.PASS, "New_balance:" + New_balance);
					  
					  String CoupAmt = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[18]")).getText();
					  test.log(LogStatus.PASS, "CoupAmt:" + CoupAmt);
					  
					  String Orig_Fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[19]")).getText();
					  test.log(LogStatus.PASS, "Orig_Fee:" + Orig_Fee);
					  
					  String Verification_fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[20]")).getText();
					  test.log(LogStatus.PASS, "Verification_fee:" + Verification_fee);
					  
					  String CSO_fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[21]")).getText();
					  test.log(LogStatus.PASS, "CSO_fee:" + CSO_fee);
					  
					  String EMP_Nbr = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[22]")).getText();
					  test.log(LogStatus.PASS, "EMP_Nbr:" + EMP_Nbr);
					  
					  String Is_DND = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[23]")).getText();
					  test.log(LogStatus.PASS, "Is_DND:" + Is_DND);
					  
					  String Owner = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[24]")).getText();
					  test.log(LogStatus.PASS, "Owner:" + Owner);
					  
					  String Online_Transaction = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[25]")).getText();
					  test.log(LogStatus.PASS, "Online_Transaction:" + Online_Transaction);
						
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial>" +Transaction +"Transaction Completed" );
					    }
					    
					    for(int i=list.size()-1;i<list.size();i++){
					    	//test.log(LogStatus.INFO, "<b> <FONT color=blue> Last Row </b>");
					    String LLoan_Tran_Code = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[2]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LLoan_Tran_Code:" + LLoan_Tran_Code);
					  
					  String Lloc_Nbr = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[3]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> loc_Nbr:" + Lloc_Nbr);
					  
					  String Lother_loc_Nbr = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[4]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> Lother_loc_Nbr:" + Lother_loc_Nbr);
					  
					  String LTrasn_date = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[5]")).getText();
					  String[] actdate= LTrasn_date.split(" ");
					  LTrasn_date1 = actdate[0];
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LTrasn_date:" + LTrasn_date1);
						 
					 LTransaction = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[6]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LTransaction:" + LTransaction);
					  
					 LTotal_Amt = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[7]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LTotal_Amt:" + LTotal_Amt);
					  
					   LTender_type = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[8]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LTender_type:" + LTender_type);
					  
					  LInst = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[9]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LInst:" + LInst);
					  
					  LAdv_amt = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[10]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LAdv_amt:" + LAdv_amt);
					  
					  LInterest = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[11]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LInterest:" + LInterest);
					  
					  String LNsf_Fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[12]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LNsf_Fee:" + LNsf_Fee);
					  
					  String LWaived_Nsf_Fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[13]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LWaived_Nsf_Fee:" + LWaived_Nsf_Fee);
					  
					  String LLate_fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[14]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LLate_fee:" + LLate_fee);
					  
					  String LWaived_late_fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[15]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LWaived_late_fee:" + LWaived_late_fee);
					  
					  String LOther_fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[16]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LOther_fee:" + LOther_fee);
					  
					  String LNew_balance = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[17]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LNew_balance:" + LNew_balance);
					  
					  LCoupAmt = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[18]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LCoupAmt:" + LCoupAmt);
					  
					  String LOrig_Fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[19]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LOrig_Fee:" + LOrig_Fee);
					  
					  String LVerification_fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[20]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LVerification_fee:" + LVerification_fee);
					  
					  String LCSO_fee = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[21]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LCSO_fee:" + LCSO_fee);
					  
					  String LEMP_Nbr = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[22]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LEMP_Nbr:" + LEMP_Nbr);
					  
					  String LIs_DND = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[23]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LIs_DND:" + LIs_DND);
					  
					  String LOwner = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[24]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> LOwner:" + LOwner);
					  
					  String LOnline_Transaction = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[25]")).getText();
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial> Online_Transaction:" + LOnline_Transaction);
						
					  test.log(LogStatus.PASS, "<FONT color=green style=Arial>" +LTransaction +"Transaction Completed" );
					    }


					    test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> <FONT color=blue style=Bold> History field validation with Actual and Expected </b>");
//				   
					    if(customer_name.toLowerCase().trim().equalsIgnoreCase(customer.toLowerCase().trim()))
						{
							test.log(LogStatus.PASS, "Customer Name->Expected value:"+customer_name.toLowerCase() +"; == Actual value:"+customer.toLowerCase());
						} 
					    else
						{
							test.log(LogStatus.FAIL, "Customer Name->Expected value:"+customer_name.toLowerCase() +"; not equals to Actual value:"+customer.toLowerCase());

						}
					    if(SSNverify.equalsIgnoreCase(SSN_ITLN))
						{
							test.log(LogStatus.PASS, "SSN->Expected value:"+SSNverify +"; == Actual value:"+SSN_ITLN);
						}
						else
						{
							test.log(LogStatus.FAIL, "SSN->Expected value:"+SSNverify +"; not equals to Actual value:"+SSN_ITLN);

						}
					    if(Bank_ABARoutingNbr.equalsIgnoreCase(Routing_Nbr))
						{
							test.log(LogStatus.PASS, "Bank_ABARoutingNbr->Expected value:"+Bank_ABARoutingNbr +"; == Actual value:"+Routing_Nbr);
						}
						else
						{
							test.log(LogStatus.FAIL, "Bank_ABARoutingNbr->Expected value:"+Bank_ABARoutingNbr +"; not equals to Actual value:"+Routing_Nbr);

						}
					    if(Bank_ChkgAcctNbr.equalsIgnoreCase(Account_Nbr))
						{
							test.log(LogStatus.PASS, "Bank_ChkgAcctNbr->Expected value:"+Bank_ChkgAcctNbr +"; == Actual value:"+Account_Nbr);
						}
						else
						{
							test.log(LogStatus.FAIL, "Bank_ChkgAcctNbr->Expected value:"+Bank_ChkgAcctNbr +"; not equals to Actual value:"+Account_Nbr);

						}
					    if(primary_source_of_income.equalsIgnoreCase(Primary_Source_Of_Income))
						{
							test.log(LogStatus.PASS, "primary_source_of_income->Expected value:"+primary_source_of_income +"; == Actual value:"+Primary_Source_Of_Income);
						}
						else
						{
							test.log(LogStatus.FAIL, "primary_source_of_income->Expected value:"+primary_source_of_income +"; not equals to Actual value:"+Primary_Source_Of_Income);

						}
						if(NetIncomeAmt.equalsIgnoreCase(Net_Pay))
						{
							test.log(LogStatus.PASS, "NetIncomeAmt->Expected value:"+NetIncomeAmt +"; == Actual value:"+Net_Pay);
						}
						else
						{
							test.log(LogStatus.FAIL, "NetIncomeAmt->Expected value:"+NetIncomeAmt +"; not equals to Actual value:"+Net_Pay);

						}
						if(GrossIncome.equalsIgnoreCase(Gross_Pay))
						{
							test.log(LogStatus.PASS, "GrossIncome->Expected value:"+GrossIncome +"; == Actual value:"+Gross_Pay);
						}
						else
						{
							test.log(LogStatus.FAIL, "GrossIncome->Expected value:"+GrossIncome +"; not equals to Actual value:"+Gross_Pay);

						}
						if(Income_PayFrequency.equalsIgnoreCase(Pay_Frequency))
						{
							test.log(LogStatus.PASS, "Income_PayFrequency->Expected value:"+Income_PayFrequency +"; == Actual value:"+Pay_Frequency);
						}
						else
						{
							test.log(LogStatus.FAIL, "Income_PayFrequency->Expected value:"+Income_PayFrequency +"; not equals to Actual value:"+Pay_Frequency);

						}
						if(loan_status.equalsIgnoreCase(Loan_Status))
						{
							test.log(LogStatus.PASS, "loan_status->Expected value:"+loan_status +"; == Actual value:"+Loan_Status);
						}
						else
						{
							test.log(LogStatus.FAIL, "loan_status->Expected value:"+loan_status +"; not equals to Actual value:"+Loan_Status);

						}
						/*if(check_status.equalsIgnoreCase(loan_status_inf_checkstatus))
						{
							test.log(LogStatus.PASS, "check_status->Expected value:"+check_status +"; == Actual value:"+loan_status_inf_checkstatus);
						}
						else
						{
							test.log(LogStatus.FAIL, "check_status->Expected value:"+check_status +"; not equals to Actual value:"+loan_status_inf_checkstatus);

						}*/
						
						if(product_type.equalsIgnoreCase(product_type))
						{
							test.log(LogStatus.PASS, "product_type->Expected value:"+product_type +"; == Actual value:"+product_type);
						}
						else
						{
							test.log(LogStatus.FAIL, "product_type->Expected value:"+product_type +"; not equals to Actual value:"+product_type);

						}
						if(loan_amount.equalsIgnoreCase(Loan_Amt))
						{
							test.log(LogStatus.PASS, "loan_amount->Expected value:"+loan_amount +"; == Actual value:"+Loan_Amt);
						}
						else
						{
							test.log(LogStatus.FAIL, "loan_amount->Expected value:"+loan_amount +"; not equals to Actual value:"+Loan_Amt);

						}
						if(noofinstall.equalsIgnoreCase(Number_of_installments))
						{
							test.log(LogStatus.PASS, "No of installments->Expected value:"+noofinstall +"; == Actual value:"+Number_of_installments);
						}
						else
						{
							test.log(LogStatus.FAIL, "No of installments->Expected value:"+noofinstall +"; not equals to Actual value:"+Number_of_installments);

						}
						if(loan_account_inf_inst_amt_test.equalsIgnoreCase(Installment_Amt))
						{
							test.log(LogStatus.PASS, "Instalment amount->Expected value:"+loan_account_inf_inst_amt_test +"; == Actual value:"+Installment_Amt);
						}
						else
						{
							test.log(LogStatus.FAIL, "Instalment amount->Expected value:"+loan_account_inf_inst_amt_test +"; not equals to Actual value:"+Installment_Amt);

						}
						if(apr.equalsIgnoreCase(APR))
						{
							test.log(LogStatus.PASS, "apr->Expected value:"+apr +"; == Actual value:"+APR);
						}
						else
						{
							test.log(LogStatus.FAIL, "apr->Expected value:"+apr +"; not equals to Actual value:"+APR);

						}
						if(collateral_type.equalsIgnoreCase(Collateral_Type)||"CHK".equalsIgnoreCase(Collateral_Type)||"NOC".equalsIgnoreCase(Collateral_Type))
						{
							test.log(LogStatus.PASS, "collateral_type->Expected value:"+Collateral_Type +"; == Actual value:"+Collateral_Type);
						}
						else
						{
							test.log(LogStatus.FAIL, "collateral_type->Expected value:"+Collateral_Type +"; not equals to Actual value:"+Collateral_Type);

						}
						if(loan_frequency.toLowerCase().trim().equalsIgnoreCase(Loan_Frequency.toLowerCase().trim()))
						{
							test.log(LogStatus.PASS, "loan_frequency->Expected value:"+loan_frequency +"; == Actual value:"+Loan_Frequency);
						}
						else
						{
							test.log(LogStatus.FAIL, "loan_frequency->Expected value:"+loan_frequency +"; not equals to Actual value:"+Loan_Frequency);

						}
						if(available_credit.equalsIgnoreCase(Available_Credit))
						{
							test.log(LogStatus.PASS, "available_credit->Expected value:"+available_credit +"; == Actual value:"+Available_Credit);
						}
						else
						{
							test.log(LogStatus.FAIL, "available_credit->Expected value:"+available_credit +"; not equals to Actual value:"+Available_Credit);

						}
						if(courtesy_consent.toLowerCase().trim().equalsIgnoreCase(Courtesy_Consent.toLowerCase().trim()))
						{
							test.log(LogStatus.PASS, "courtesy_consent->Expected value:"+courtesy_consent +"; == Actual value:"+Courtesy_Consent);
						}
						else
						{
							test.log(LogStatus.FAIL, "courtesy_consent->Expected value:"+courtesy_consent +"; not equals to Actual value:"+Courtesy_Consent);

						}
						if(courtesy_consent_status.toLowerCase().trim().equalsIgnoreCase(Status.toLowerCase().trim()))
						{
							test.log(LogStatus.PASS, "courtesy_consent_status->Expected value:"+courtesy_consent_status +"; == Actual value:"+Status);
						}
						else
						{
							test.log(LogStatus.FAIL, "courtesy_consent_status->Expected value:"+courtesy_consent_status +"; not equals to Actual value:"+Status);

						}
						if(principal_balance.equalsIgnoreCase(Principle_Balance))
						{
							test.log(LogStatus.PASS, "principal_balance->Expected value:"+principal_balance +"; == Actual value:"+Principle_Balance);
						}
						else
						{
							test.log(LogStatus.FAIL, "principal_balance->Expected value:"+principal_balance +"; not equals to Actual value:"+Principle_Balance);

						}
						/*if(fee_due.equalsIgnoreCase(loan_balance_inf_fee_due))
						{
							test.log(LogStatus.PASS, "Earned and unpaid interest->Expected value:"+fee_due +"; == Actual value:"+loan_balance_inf_fee_due);
						}hhh
						else
						{
							test.log(LogStatus.FAIL, "Earned and unpaid interest:"+fee_due +"; not equals to Actual value:"+loan_balance_inf_fee_due);

						}
					*/	if(pay_off_amount.equalsIgnoreCase(Pay_off_Amt))
						{
							test.log(LogStatus.PASS, "pay_off_amount->Expected value:"+pay_off_amount +"; == Actual value:"+Pay_off_Amt);
						}
						else
						{
							test.log(LogStatus.FAIL, "pay_off_amount->Expected value:"+pay_off_amount +"; not equals to Actual value:"+Pay_off_Amt);

						}
						if(loan_balance_inf_past_due_amt_test.equalsIgnoreCase(Past_Due_Amt))
						{
							test.log(LogStatus.PASS, "past due amount->Expected value:"+loan_balance_inf_past_due_amt_test +"; == Actual value:"+Past_Due_Amt);
						}
						else
						{
							test.log(LogStatus.FAIL, "past due amount->Expected value:"+loan_balance_inf_past_due_amt_test +"; not equals to Actual value:"+Past_Due_Amt);

						}

						if(principal_paid_to_date.equalsIgnoreCase(Principal_Paid_To_Date))
						{
							test.log(LogStatus.PASS, "principal_paid_to_date->Expected value:"+principal_paid_to_date +"; == Actual value:"+Principal_Paid_To_Date);
						}
						else
						{
							test.log(LogStatus.FAIL, "principal_paid_to_date->Expected value:"+principal_paid_to_date +"; not equals to Actual value:"+Principal_Paid_To_Date);

						}
						if(fee_paid_date.equalsIgnoreCase(Intrest_Paid_to_date))
						{
							test.log(LogStatus.PASS, "Interset_paid to date->Expected value:"+fee_paid_date +"; == Actual value:"+Intrest_Paid_to_date);
						}
						else
						{
							test.log(LogStatus.FAIL, "Interset_paid to date->Expected value:"+fee_paid_date +"; not equals to Actual value:"+Intrest_Paid_to_date);

						}
						if(total_paid_amountc.equalsIgnoreCase(Total_Paid_Amt))
						{
							test.log(LogStatus.PASS, "total_paid_amount->Expected value:"+total_paid_amountc +"; == Actual value:"+Total_Paid_Amt);
						}
						else
						{
							test.log(LogStatus.FAIL, "total_paid_amount->Expected value:"+total_paid_amountc +"; not equals to Actual value:"+Total_Paid_Amt);

						} 
						if(campaign_name.equalsIgnoreCase(Campaign_Name))
						{
							test.log(LogStatus.PASS, "campaign_name->Expected value:"+campaign_name+"; == Actual value:"+Campaign_Name);
						}
						else
						{
							test.log(LogStatus.FAIL, "campaign_name->Expected value:"+campaign_name +"; not equals to Actual value:"+Campaign_Name);

						}
						if(promotion_code.equalsIgnoreCase(Hpromotion_code))
						{
							test.log(LogStatus.PASS, "promotion_code->Expected value:"+promotion_code +"; == Actual value:"+Hpromotion_code);
						}
						else
						{
							test.log(LogStatus.FAIL, "promotion_code->Expected value:"+promotion_code +"; not equals to Actual value:"+Hpromotion_code);

						}
						if(Product_Name.contains("Installment Loan"))
							{
								test.log(LogStatus.PASS, "product_name->Expected value:"+product_name +"; == Actual value:"+Product_Name);
							}
							
						/*if(product_name.equalsIgnoreCase(Product_Name))
						{
							test.log(LogStatus.PASS, "product_name->Expected value:"+product_name +"; == Actual value:"+Product_Name);
						}
						else
						{
							test.log(LogStatus.FAIL, "product_name->Expected value:"+product_name +"; not equals to Actual value:"+Product_Name);

						}*/
						if(tran_date_sheet.isEmpty()){
							
							if(appdate.equalsIgnoreCase(LTrasn_date1))
							{
								test.log(LogStatus.PASS, "transaction date->Expected value:"+appdate +"; == Actual value:"+LTrasn_date1);
							}
							else
							{
								test.log(LogStatus.FAIL, "transaction date->Expected value:"+appdate +"; not equals to Actual value:"+LTrasn_date1);

							}	
						}
						else{
							if(tran_date_sheet.equalsIgnoreCase(LTrasn_date1))
							{
								test.log(LogStatus.PASS, "transaction date->Expected value:"+appdate +"; == Actual value:"+LTrasn_date1);
							}
							else
							{
								test.log(LogStatus.FAIL, "transaction date->Expected value:"+appdate +"; not equals to Actual value:"+LTrasn_date1);

							}
							}
						if(cust_tran_test.equalsIgnoreCase(LTransaction))
						{
							test.log(LogStatus.PASS, "Transaction->Expected value:"+cust_tran_test +"; == Actual value:"+LTransaction);
						}
						else
						{
							test.log(LogStatus.FAIL, "Transaction->Expected value:"+cust_tran_test +"; not equals to Actual value:"+LTransaction);

						}
						if(cust_doc_total_amount_test.equalsIgnoreCase(LTotal_Amt))
						{
							test.log(LogStatus.PASS, "total_amount->Expected value:"+cust_doc_total_amount_test +"; == Actual value:"+LTotal_Amt);
						}
						else
						{
							test.log(LogStatus.FAIL, "total_amount->Expected value:"+cust_doc_total_amount_test +"; not equals to Actual value:"+LTotal_Amt);

						}
						if(cust_doc_tender_type_test.equalsIgnoreCase(LTender_type)||" ".trim().equalsIgnoreCase(LTender_type.trim()))
						{
							test.log(LogStatus.PASS, "Tender type->Expected value:"+cust_doc_tender_type_test +"; == Actual value:"+LTender_type);
						}
						else
						{
							test.log(LogStatus.FAIL, "Tender type->Expected value:"+cust_doc_tender_type_test +"; not equals to Actual value:"+LTender_type);

						}
						if(cust_doc_inst_test.equalsIgnoreCase(LInst))
						{
							test.log(LogStatus.PASS, "Inst#->Expected value:"+cust_doc_inst_test +"; == Actual value:"+LInst);
						}
						else
						{
							test.log(LogStatus.FAIL, "Inst#->Expected value:"+cust_doc_inst_test +"; not equals to Actual value:"+LInst);

						}
						if(cust_doc_adv_amount_test.equalsIgnoreCase(LAdv_amt))
						{
							test.log(LogStatus.PASS, "Adv amount->Expected value:"+cust_doc_adv_amount_test +"; == Actual value:"+LAdv_amt);
						}
						else
						{
							test.log(LogStatus.FAIL, "Adv amount->Expected value:"+cust_doc_adv_amount_test +"; not equals to Actual value:"+LAdv_amt);

						}	
						if(cust_doc_interest_test.equalsIgnoreCase(LInterest))
						{
							test.log(LogStatus.PASS, "Interest->Expected value:"+cust_doc_interest_test +"; == Actual value:"+LInterest);
						}
						else
						{
							test.log(LogStatus.FAIL, "Interest->Expected value:"+cust_doc_interest_test +"; not equals to Actual value:"+LInterest);

						}
						if(cust_doc_PromotionCoupon_Amt_test.equalsIgnoreCase(LCoupAmt)||" ".trim().equalsIgnoreCase(LCoupAmt.trim()))
						{
							test.log(LogStatus.PASS, "Promotion/Coupon Amt->Expected value:"+cust_doc_PromotionCoupon_Amt_test +"; == Actual value:"+LCoupAmt);
						}
						else
						{
							test.log(LogStatus.FAIL, "Promotion/Coupon Amt->Expected value:"+cust_doc_PromotionCoupon_Amt_test +"; not equals to Actual value:"+LCoupAmt);

						}
						//ACH validations
						/*
						if(ESign_CollateralType.equals("ACH"))
						{
							if(ACH_type.equalsIgnoreCase(ach_history_ach_type))
							{
								test.log(LogStatus.PASS, "ACH_type->Expected value:"+ACH_type +"; == Actual value:"+ach_history_ach_type);
							}
							else
							{
								test.log(LogStatus.FAIL, "ACH_type->Expected value:"+ACH_type +"; not equals to Actual value:"+ach_history_ach_type);

							}
							if(ACH_transaction.equalsIgnoreCase(ach_history_ach_transaction))
							{
								test.log(LogStatus.PASS, "ACH_transaction->Expected value:"+ACH_transaction +"; == Actual value:"+ach_history_ach_transaction);
							}
							else
							{
								test.log(LogStatus.FAIL, "ACH_transaction->Expected value:"+ACH_transaction +"; not equals to Actual value:"+ach_history_ach_transaction);

							}
							

							if(ACH_status.equalsIgnoreCase(ach_history_ach_status))
							{
								test.log(LogStatus.PASS, "ACH_status->Expected value:"+ACH_status +"; == Actual value:"+ach_history_ach_status);
							}
							else
							{
								test.log(LogStatus.FAIL, "ACH_status->Expected value:"+ACH_status +"; not equals to Actual value:"+ach_history_ach_status);

							}
							if(ACH_amount.equalsIgnoreCase(ach_history_ach_amt))
							{
								test.log(LogStatus.PASS, "ACH_amount->Expected value:"+ACH_amount +"; == Actual value:"+ach_history_ach_amt);
							}
							else
							{
								test.log(LogStatus.FAIL, "ACH_amount->Expected value:"+ACH_amount +"; not equals to Actual value:"+ach_history_ach_amt);

							}
							if(ACH_ABA_code.equalsIgnoreCase(ach_history_ach_ABA_code))
							{
								test.log(LogStatus.PASS, "ACH_ABA_code->Expected value:"+ACH_ABA_code +"; == Actual value:"+ach_history_ach_ABA_code);
							}
							else
							{
								test.log(LogStatus.FAIL, "ACH_ABA_code->Expected value:"+ACH_ABA_code +"; not equals to Actual value:"+ach_history_ach_ABA_code);

							}
							if(Bank_ChkgAcctNbr.equalsIgnoreCase(ach_history_ach_check_acc_no))
							{
								test.log(LogStatus.PASS, "ACH_check_acc_no->Expected value:"+Bank_ChkgAcctNbr +"; == Actual value:"+ach_history_ach_check_acc_no);
							}
							else
							{
								test.log(LogStatus.FAIL, "ACH_check_acc_no->Expected value:"+Bank_ChkgAcctNbr +"; not equals to Actual value:"+ach_history_ach_check_acc_no);

							}
						}	
					//	test.log(LogStatus.PASS, MarkupHelper.createLabel("History Transaction is successful", ExtentColor.GREEN));
						test.log(LogStatus.PASS, "History Transaction is successful");
						test.log(LogStatus.PASS, "**********************************************");

						break;*/
			
					
				   
				  // driver.close();
				

	
	}
}
	}
}

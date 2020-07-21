package tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class History extends QCStore
{
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
	public static String Trasn_date;
	public static String Transaction;
	public static String Total_Amt;
	public static String Tender_type;
	public static String Inst;
	public static String Adv_amt;
	public static String Interest;
	public static String LTrasn_date1;
	public static String LTransaction;
	public static String LTotal_Amt;
	public static String LTender_type;
	public static String LInst;
	public static String LInterest;
	public static String LAdv_amt;
	public static String LCoupAmt;
	public static String Verification_fee;
	public static String Available_Credit;
	public static String EPP_Fees;
	public static String Documentation_fee;
	public static String Intrest_Fee;
	public static String WO_Amt;
	public static String Adv_Fees;
	public static String NSF_Amt;
	

	public static void history(String SSN,String AppURL) throws ParseException, InterruptedException
	{

			int lastrow=TestData.getLastRow("Borrower_Registration");
			String sheetName="Borrower_Registration";
			String sheetName_calc="HistoryFieldsValidation";
			String sheetName_new_loan="New_Loan";
	       
			

			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				
				if(SSN.equals(RegSSN))
				{
					
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			        String StateID = TestData.getCellData(sheetName,"StateID",row);
			        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
			        String Header = StateID+ "_" + ProductID;	      
			        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
			        System.out.println(columnname);
			       String LastName = TestData.getCellData(sheetName,"LastName",row);
			       String FirstName = TestData.getCellData(sheetName,"FirstName",row);
			       String customer_name=FirstName+" "+LastName;
			      
			       String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
			     
			       String  Bank_ChkgAcctNbr=SSN.substring(SSN.length() - 6);
			       String Ctc_PrimaryPhone = TestData.getCellData(sheetName,"Ctc_PrimaryPhone",row);

			
			     
			       String Misc_IDExpDate = TestData.getCellData(sheetName,"Misc_IDExpDate",row);	   
			     
			       String BorrDOB = TestData.getCellData(sheetName,"Misc_DOB",row);
			       String Income_IncomeType = TestData.getCellData(sheetName,"Income_IncomeType",row);
			       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
			       String courtesy_consent=TestData.getCellData(sheetName_new_loan,"ESign_CourtesyCallConsent",row);
			     //  String courtesy_consent_status=TestData.getCellData(sheetName_new_loan,"ESign_Preference",row);
			       String collateral_type=TestData.getCellData(sheetName_new_loan,"ESign_CollateralType",row);
			       
			       String primary_source_of_income = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",4);
System.out.println(sheetName_calc);
System.out.println(columnname+"_TxnHistory_FieldValue");

			       String Income_Employer = TestData.getCellData(sheetName,"Income_Employer",row);
			       String Income_WorkPhone = TestData.getCellData(sheetName,"Income_WorkPhone",row);
			      // String NetIncomeAmt = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",5);
			       //String GrossIncome = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",6);
			       String NetIncomeAmt = TestData.getCellData(sheetName,"Income_NetIncomeAmt",row);
			       String GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
			       NetIncomeAmt=NetIncomeAmt+".00";
			       //GrossIncome=GrossIncome+".00";
			       String pay_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",7);
			       String loan_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",8);
			       String check_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",9);
			       String product_type=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",11);
			       String loan_amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",12);
			       String finance_charge=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",13);
			       String apr=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",14);
			   //    String collateral_type=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",16);
			       String loan_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",17);
			       String credot_or_verification_fee=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",18);
			       String available_credit=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",19);
			       String courtesy_consent_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",21);
			       String principal_balance=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",22);
			       String fee_due=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",23);
			       String pay_off_amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",24);

			       String principal_paid_to_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",25);

			       String fee_paid_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",26);

			       String total_paid_amountc=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",27);
			       String campaign_name=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",28);
			       String promotion_code=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",29);
			       String product_name=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",30);
			       String transaction = TestData.getCellData(sheetName_calc, columnname+"_TxnHistory_FieldValue", 31);
			       String total_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",2);
			       String advance_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",3);
			       String advance_fees=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",4);
			       String NSF_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",5);
			       String WO_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",6);
			       String interest_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",7);
			       String origination_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",8);
			       String credit_or_verification_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",9);
			       String EPP_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",10);
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
							driver.switchTo().frame("bottom");
							String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
						
							
							test.log(LogStatus.PASS, ""+Str_date);
								
						//	test.log(LogStatus.INFO, MarkupHelper.createLabel("Transaction History validation has started", ExtentColor.BLUE));
							test.log(LogStatus.INFO, "Transaction History validation has started");

							driver.switchTo().defaultContent();	
							
					        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
							driver.switchTo().frame("topFrame");
							wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					        driver.findElement(By.cssSelector("li[id='910000']")).click();	
							/*driver.switchTo().defaultContent();				
							driver.switchTo().frame("topFrame");
							driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();	*/		
							test.log(LogStatus.PASS, "Clicked on Loan Transactions");
							Thread.sleep(5000);
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							driver.findElement(By.cssSelector("li[id='911101']")).click();			
							test.log(LogStatus.PASS, "Clicked on Transactions");		
							driver.switchTo().frame("main");		
							driver.findElement(By.name("ssn1")).sendKeys(SSN1);
							test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
							driver.findElement(By.name("ssn2")).sendKeys(SSN2);
							test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
							driver.findElement(By.name("ssn3")).sendKeys(SSN3);
							test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
							driver.findElement(By.name("submit1")).click();
							test.log(LogStatus.PASS, "Click on submit Button");		
							for(String winHandle : driver.getWindowHandles()){
						    driver.switchTo().window(winHandle);
							}
						    driver.switchTo().defaultContent();
						    driver.switchTo().frame("mainFrame");
						    driver.switchTo().frame("main");
						    
						    
						  // String loan_nbr= driver.findElement(locator(Jprop.getProperty("csr_loan_nbr"))).getText();
						  // test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
							// driver.findElement(By.name("button")).click();
							
						for(String winHandle : driver.getWindowHandles()){
							    driver.switchTo().window(winHandle);
								}				    
							 driver.switchTo().defaultContent();
							    driver.switchTo().frame("mainFrame");
							    driver.switchTo().frame("main");Thread.sleep(5000);	
							                                     // /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[11]/input[1]
								    driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[11]/input[1]")).click();
								    Thread.sleep(10000);        ////*[@id="CustGrid"]/tbody/tr[2]/td[13]/table/tbody/tr/td[1]/select
								    ///html/body/table/tbody/tr/td/table/tbody/tr/td/form[1]/table[2]/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td[10]/select
								    driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form[1]/table[2]/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td[10]/select")).sendKeys("History");

								    driver.findElement(By.xpath("//*[@id='go_Button']")).click();
								    test.log(LogStatus.INFO, "<b> <FONT color=green style=Bold> History field values at screen level</b>");
								    
								    //Customer Inforrmation
								    //test.log(LogStatus.INFO,"<FONT color=blue style=Bold> Third Party Collection PASS");
								    test.log(LogStatus.INFO, "<b> <FONT color=blue style=Bold> Customer Information </b>");
								                                                       //*[@id="transactionHistoryTable"]/tbody/tr/td[1]/table/tbody/tr[2]/td/span[2]
								    String customer = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[2]/td/span[2]")).getText();
								    test.log(LogStatus.PASS, "customer: " +customer);
								   
								    String customer_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[3]/td/span[2]")).getText();
									 test.log(LogStatus.PASS, "customer_Nbr: " + customer_Nbr);
									    
									    String SSN_ITLN = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[4]/td/span[2]")).getText();
									    test.log(LogStatus.PASS, "SSN_ITLN:  " + SSN_ITLN);
									    
									    String primary_phone_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[5]/td/span[2]")).getText();
									    test.log(LogStatus.PASS, "primary_phone_Nbr:  " + primary_phone_Nbr);
									    
									    String phone_type = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[6]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "phone type: " + phone_type);
									    
									    String state = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[7]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "state:  " + state);
									    
									   String Email = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[8]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Email:  " + Email);
									   
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
									    
									    String Check_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[15]/td/span[2]")).getText();
									 test.log(LogStatus.PASS, "Check_Nbr:  " + Check_Nbr);
									    
									    String Account_Status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[16]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Account_Status:  " + Account_Status);
									    
									   String Bank_Name = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[17]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Bank_Name:  " + Bank_Name);
									   
									    //UnderWriting Inforrmation
									   test.log(LogStatus.INFO, "<b> <FONT color=blue style=Bold> UnderWriting Information </b>");
									 //*[@id="transactionHistoryTable"]/tbody/tr/td[1]/table/tbody/tr[20]/td/span/span
									    String Veritec_Tran_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[20]/td/span/span")).getText();
									    test.log(LogStatus.PASS,"Veritec_Tran_Nbr:" +Veritec_Tran_Nbr);
									    
									    String MLA_Status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[21]/td/span[2]")).getText();
									    test.log(LogStatus.PASS, "MLA_Status:" +MLA_Status);
									    
									    String OFAC_Status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[22]/td/span[2]")).getText();
									    test.log(LogStatus.PASS, "OFAC_Status:" +OFAC_Status);
									    
									    
									    //Promotion/Coupon Info
									    test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Promotion/Coupon Information </b>");
									    String Campaign_Name = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[25]/td/span/span")).getText();
									    test.log(LogStatus.PASS, "Campaign_Name:" +Campaign_Name);
									    
									    String Hpromotion_code = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[1]/table/tbody/tr[26]/td/span/span")).getText();
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
									    
									    String Check_Status = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[3]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Check_Status: " + Check_Status);
									    
									    String Due_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Due_Date: " +Due_Date);
									    
									    String Future_Deposit_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[5]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Future_Deposit_Date:  " + Future_Deposit_Date);
									    
									    String Re_Deposit_Count = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[6]/td/span[2]")).getText();
									 test.log(LogStatus.PASS, "Re_Deposit_Count:  " + Re_Deposit_Count);
									 
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
									    
									    /*String As_of_Today_Accrued_Intrest = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[13]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "As_of_Today_Accrued_Intrest: " + As_of_Today_Accrued_Intrest);*/
									    
									    //Loan Balance Summery
									    test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Loan Balance Summery </b>");
									                                                             //*[@id="transactionHistoryTable"]/tbody/tr/td[3]/table/tbody/tr[15]/td/span[2]
									    String Principle_Balance = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[15]/td/span[2]")).getText();
									test.log(LogStatus.PASS, "Principle_Balance: " + Principle_Balance);
									    
									    String Fee_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[16]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Fee_Due: " + Fee_Due);
									    
									    String Return_Fee_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[17]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Return_Fee_Due: " + Return_Fee_Due);
									    
									    String Late_Fee_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[18]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Late_Fee_Due: " + Late_Fee_Due);
									    
									    String Pay_off_Amt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[19]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Pay_off_Amt: " + Pay_off_Amt);
									    
									   /* String Past_Due_Amt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[20]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Past_Due_Amt: " + Past_Due_Amt);
									    
									    String Verification_Fee_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[21]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Verification_Fee_Due: " + Verification_Fee_Due);
									    
									    String CSO_Fee_Due = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[22]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "CSO_Fee_Due: " + CSO_Fee_Due);
									    */
									    //Loan Paid To_Date Summery
									       
									    //*[@id="transactionHistoryTable"]/tbody/tr/td[3]/table/tbody/tr[26]/td/span/span
									   test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Loan Paid To_Date Summery </b>");
									                                                                 //*[@id="transactionHistoryTable"]/tbody/tr/td[3]/table/tbody/tr[22]/td/span/span
									    String Principal_Paid_To_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[22]/td/span/span")).getText();
									   test.log(LogStatus.PASS, "Principal_Paid_To_Date: " + Principal_Paid_To_Date);
									    
									    String Fee_Paid_to_date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[23]/td/span/span")).getText();
									  test.log(LogStatus.PASS, "Fee_Paid_to_date: " + Fee_Paid_to_date);
									    
									    String Return_Fee_Paid_to_date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[24]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Return_Fee_Paid_to_date: " + Return_Fee_Paid_to_date);
									    
									    String Late_Fee_Paid_to_date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[25]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Late_Fee_Paid_to_date: " + Late_Fee_Paid_to_date);
									    
									    String Total_Paid_Amt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[26]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Total_Paid_Amt: " + Total_Paid_Amt);
									    
									    /*String Orig_Fee_Paid = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[27]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Orig_Fee_Paid: " + Orig_Fee_Paid);
									    
									    String Verification_Fee_Paid = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[28]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Verification_Fee_Paid: " + Verification_Fee_Paid);
									    
									    String Orig_Fee_Waived = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[29]/td/span[2]")).getText();
									    test.log(LogStatus.PASS, "Orig_Fee_Waived:  " + Orig_Fee_Waived);
									    
									    String CSO_Fee_Paid = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[30]/td/span[2]")).getText();
									test.log(LogStatus.PASS, "CSO_Fee_Paid: " + CSO_Fee_Paid);
									    */
									    //Loan Account Information
										  test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Loan Account Inforrmation </b>");
										//*[@id="transactionHistoryTable"]/tbody/tr/td[4]/table/tbody/tr[2]/td/span/text()
										//*[@id="transactionHistoryTable"]/tbody/tr/td[4]/table/tbody/tr[2]/td
									    String Product_Name = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[2]/td")).getText();
									  test.log(LogStatus.PASS, "Product_Name: " + Product_Name);
									    
									    String Product_Type = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[3]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Product_Type: " + Product_Type);
									    
									    String Loan_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Loan_Nbr: " + Loan_Nbr);
									    
									    String Loan_Amt = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[5]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Loan_Amt: " + Loan_Amt);
									    
									    String Finance_Charge = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[6]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Finance_Charge: " + Finance_Charge);
									    
									    String APR = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[7]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "APR: " + APR);
									    
									    String Intrest_Rate = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[8]/td/span[2]")).getText();
									 test.log(LogStatus.PASS, "Intrest_Rate:  " + Intrest_Rate);
									 
									                                                           //*[@id="transactionHistoryTable"]/tbody/tr/td[4]/table/tbody/tr[9]/td/span[2]					 		    
									    String Loan_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[9]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Loan_Date: " + Loan_Date);
									    
									    String Max_Term_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[10]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Max_Term_Date: " + Max_Term_Date);
									    
									    String Collateral_Type = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[11]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Collateral_Type: " + Collateral_Type);
									    
									    String Loan_Frequency = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[12]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Loan_Frequency:  " + Loan_Frequency);
									    
									    String Origination_Store = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[13]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Origination_Store:  " + Origination_Store);
									    
									    String Origination_Fee = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[14]/td/span[2]")).getText();
									    test.log(LogStatus.PASS, "Origination_Fee:  " + Origination_Fee);
									    
									    Available_Credit = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[15]/td/span[2]")).getText();
									    //System.out.println("CSO_Fee:" +CSO_Fee);
									    test.log(LogStatus.PASS, "Avilable_Credit:  " + Available_Credit);
									    
									    String payroll_deduction_signed = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[16]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "payroll_deduction_signed:  " + payroll_deduction_signed);
									    
									  //Loan Bank Account Information
									   test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> Loan Bank Account Information </b>");
									   
									    String Loan_ABA_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[19]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Loan_ABA_Nbr:  " + Loan_ABA_Nbr);
									    
									    String Loan_Account_Nbr = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[20]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Loan_Account_Nbr:  " + Loan_Account_Nbr);
									    
									    //Third Party Collection PASS
									   test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> <FONT color=blue style=Bold> Third Party Collection Information </b>");
									 //*[@id="transactionHistoryTable"]/tbody/tr/td[4]/table/tbody/tr[23]/td/span[2]
									   String Transfer_Out_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[23]/td/span[2]")).getText();
									   test.log(LogStatus.PASS,"Transfer_Out_Date: " +Transfer_Out_Date);
									   
									   String Transfer_In_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[24]/td/span[2]")).getText();
									   test.log(LogStatus.PASS,"Transfer_In_Date: " +Transfer_In_Date);
									   
									    String Account_Sold = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[25]/td/span[2]")).getText();
									  test.log(LogStatus.PASS, "Account_Sold:  " + Account_Sold);
									  
									  String Sold_To = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[26]/td/span[2]")).getText();
									  test.log(LogStatus.PASS,"Sold_To: " +Sold_To);
									  
									  String Sold_date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[27]/td/span[2]")).getText();
									  test.log(LogStatus.PASS,"Sold_date: " +Sold_date);
									    
									    String Mark_For_Sale = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[28]/td/span[2]")).getText();
									   test.log(LogStatus.PASS, "Mark_For_Sale:  " + Mark_For_Sale);
									 //*[@id="transactionHistoryTable"]/tbody/tr/td[4]/table/tbody/tr[29]/td/span[2]
									   String Agency_Name = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[29]/td/span[2]")).getText();
									   test.log(LogStatus.PASS,"Agency_Name: " +Agency_Name);
									    
									    //Loan Tran Code
									   test.log(LogStatus.INFO, "<b> <FONT color=blue style=Bold>Customer Transaction field values at screen level</b>");
									    List<WebElement> list=driver.findElements(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr"));
									    int x=list.size();
									    //test.log(LogStatus.PASS, "list size" +x);
									    for(int i=2;i<=list.size()-1;i++){
									    	
									   
									 // test.log(LogStatus.INFO,  i-1 +  "<b> <FONT color=blue style=Bold> Row </b>");
									    	
									  String Loan_Tran_Code = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[2]")).getText();
									  test.log(LogStatus.PASS, "Loan_Tran_Code:" + Loan_Tran_Code);
									  
									  String Store_Nbr = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[3]")).getText();
									  test.log(LogStatus.PASS, "Store_Nbr:" + Store_Nbr);
									  
									  String other_Store_Nbr = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[4]")).getText();
									  test.log(LogStatus.PASS, "other_Store_Nbr:" + other_Store_Nbr);
									  
									   Trasn_date = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[5]")).getText();
									  test.log(LogStatus.PASS, "Trasn_date:" + Trasn_date);
									  
									   Transaction = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[6]")).getText();
									  test.log(LogStatus.PASS, "Transaction:" + Transaction);
									  
									  Tender_type = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[7]")).getText();
									  test.log(LogStatus.PASS, "Tender_type:" + Tender_type);
									  
									  Total_Amt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[8]")).getText();
									  test.log(LogStatus.PASS, "Total_Amt:" + Total_Amt);
									  
									  Adv_amt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[9]")).getText();
									  test.log(LogStatus.PASS, "Adv_amt:" + Adv_amt);
									  
									  Adv_Fees = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[10]")).getText();
									  test.log(LogStatus.PASS, "Adv_Fees:" + Adv_Fees);
									  
									  NSF_Amt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[11]")).getText();
									  test.log(LogStatus.PASS, "NSF_Amt:" + NSF_Amt);
									  
									  WO_Amt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[12]")).getText();
									  test.log(LogStatus.PASS, "WO_Amt:" + WO_Amt);
									  
									  Intrest_Fee = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[13]")).getText();
									  test.log(LogStatus.PASS, "Intrest_Fee:" + Intrest_Fee);
									  
									  Documentation_fee = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[14]")).getText();
									  test.log(LogStatus.PASS, "Documentation_fee:" + Documentation_fee);
									  
									  Verification_fee = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[15]")).getText();
									  test.log(LogStatus.PASS, "Verification_fee:" + Verification_fee);
									  
									  EPP_Fees = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[16]")).getText();
									  test.log(LogStatus.PASS, "EPP_Fees:" + EPP_Fees);
									  
									  String NSF_Fees = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[17]")).getText();
									  test.log(LogStatus.PASS, "NSF_Fees:" + NSF_Fees);
									  
									  String WO_Fees = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[18]")).getText();
									  test.log(LogStatus.PASS, "WO_Fees:" + WO_Fees);
									  
									  String Waived_Fees = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[19]")).getText();
									  test.log(LogStatus.PASS, "Waived_Fees:" + Waived_Fees);
									  
									  String Rebate_Amt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[20]")).getText();
									  test.log(LogStatus.PASS, "Rebate_Amt:" + Rebate_Amt);
									  
									  String Promotion_Amt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[21]")).getText();
									  test.log(LogStatus.PASS, "Promotion_Amt:" + Promotion_Amt);
									  
									  String Check_Cashing_Payment = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[22]")).getText();
									  test.log(LogStatus.PASS, "Check_Cashing_Payment:" + Check_Cashing_Payment);
									  
									  String Emp_Nbr = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[23]")).getText();
									  test.log(LogStatus.PASS, "Emp_Nbr:" + Emp_Nbr);
									  
									  String Promotion_code = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[24]")).getText();
									  test.log(LogStatus.PASS, "Promotion_code:" + Promotion_code);
									  
									  String Owner = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[25]")).getText();
									  test.log(LogStatus.PASS, "Owner:" + Owner);
									  
									  String Online_Transaction = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[26]")).getText();
									  test.log(LogStatus.PASS, "Online_Transaction:" + Online_Transaction);
										
									  //test.log(LogStatus.PASS,  Transaction +  " Transaction Completed");
									  test.log(LogStatus.PASS, "<FONT color=green style=Arial>" +Transaction +"Transaction Completed" );

									    }
									    
									    for(int i=list.size();i<=list.size();i++){
									    	//test.log(LogStatus.INFO, "<b> <FONT color=blue> Last Row </b>");
									    	  String Loan_Tran_Code = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[2]")).getText();
											  test.log(LogStatus.PASS, "Loan_Tran_Code:" + Loan_Tran_Code);
											  
											  String Store_Nbr = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[3]")).getText();
											  test.log(LogStatus.PASS, "Store_Nbr:" + Store_Nbr);
											  
											  String other_Store_Nbr = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[4]")).getText();
											  test.log(LogStatus.PASS, "other_Store_Nbr:" + other_Store_Nbr);
											  
											   Trasn_date = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[5]")).getText();
											  test.log(LogStatus.PASS, "Trasn_date:" + Trasn_date);
											  
											   Transaction = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[6]")).getText();
											  test.log(LogStatus.PASS, "Transaction:" + Transaction);
											  
											  Tender_type = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[7]")).getText();
											  test.log(LogStatus.PASS, "Tender_type:" + Tender_type);
											  
											  Total_Amt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[8]")).getText();
											  test.log(LogStatus.PASS, "Total_Amt:" + Total_Amt);
											  
											  Adv_amt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[9]")).getText();
											  test.log(LogStatus.PASS, "Adv_amt:" + Adv_amt);
											  
											  Adv_Fees = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[10]")).getText();
											  test.log(LogStatus.PASS, "Adv_Fees:" + Adv_Fees);
											  
											  NSF_Amt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[11]")).getText();
											  test.log(LogStatus.PASS, "NSF_Amt:" + NSF_Amt);
											  
											  WO_Amt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[12]")).getText();
											  test.log(LogStatus.PASS, "WO_Amt:" + WO_Amt);
											  
											  Intrest_Fee = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[13]")).getText();
											  test.log(LogStatus.PASS, "Intrest_Fee:" + Intrest_Fee);
											  
											  Documentation_fee = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[14]")).getText();
											  test.log(LogStatus.PASS, "Documentation_fee:" + Documentation_fee);
											  
											  Verification_fee = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[15]")).getText();
											  test.log(LogStatus.PASS, "Verification_fee:" + Verification_fee);
											  
											  EPP_Fees = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[16]")).getText();
											  test.log(LogStatus.PASS, "EPP_Fees:" + EPP_Fees);
											  
											  String NSF_Fees = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[17]")).getText();
											  test.log(LogStatus.PASS, "NSF_Fees:" + NSF_Fees);
											  
											  String WO_Fees = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[18]")).getText();
											  test.log(LogStatus.PASS, "WO_Fees:" + WO_Fees);
											  
											  String Waived_Fees = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[19]")).getText();
											  test.log(LogStatus.PASS, "Waived_Fees:" + Waived_Fees);
											  
											  String Rebate_Amt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[20]")).getText();
											  test.log(LogStatus.PASS, "Rebate_Amt:" + Rebate_Amt);
											  
											  String Promotion_Amt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[21]")).getText();
											  test.log(LogStatus.PASS, "Promotion_Amt:" + Promotion_Amt);
											  
											  String Check_Cashing_Payment = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[22]")).getText();
											  test.log(LogStatus.PASS, "Check_Cashing_Payment:" + Check_Cashing_Payment);
											  
											  String Emp_Nbr = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[23]")).getText();
											  test.log(LogStatus.PASS, "Emp_Nbr:" + Emp_Nbr);
											  
											  String Promotion_code = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[24]")).getText();
											  test.log(LogStatus.PASS, "Promotion_code:" + Promotion_code);
											  
											  String Owner = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[25]")).getText();
											  test.log(LogStatus.PASS, "Owner:" + Owner);
											  
											  String Online_Transaction = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr["+i+"]/td[26]")).getText();
											  test.log(LogStatus.PASS, "Online_Transaction:" + Online_Transaction); 
											  test.log(LogStatus.PASS, "<FONT color=green style=Arial>" +Transaction +  " Transaction Completed" );
									    }
									    
									    test.log(LogStatus.INFO,"<b> <FONT color=blue style=Bold> <FONT color=blue style=Bold> History field validation with Actual and Expected </b>");
									    if(customer_name.toLowerCase().trim().equalsIgnoreCase(customer.toLowerCase().trim()))
										{
											test.log(LogStatus.PASS, "Customer Name->Expected value:"+customer_name +"; == Actual value:"+customer);
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
									    if(Bank_ChkgAcctNbr.contains(Account_Nbr))
										{
											test.log(LogStatus.PASS, "Bank_ChkgAcctNbr->Expected value:"+Bank_ChkgAcctNbr +"; == Actual value:"+Account_Nbr);
										}
										else
										{
											test.log(LogStatus.FAIL, "Bank_ChkgAcctNbr->Expected value:"+Bank_ChkgAcctNbr +"; not equals to Actual value:"+Account_Nbr);
											//Assert.assertTrue(false);
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
										if(loan_status.toLowerCase().trim().equalsIgnoreCase(Loan_Status.toLowerCase().trim()))
										{
											test.log(LogStatus.PASS, "loan_status->Expected value:"+loan_status +"; == Actual value:"+Loan_Status);
										}
										else
										{
											test.log(LogStatus.FAIL, "loan_status->Expected value:"+loan_status +"; not equals to Actual value:"+Loan_Status);
											//Assert.assertTrue(false);
										}
										/*if(check_status.toLowerCase().trim().equalsIgnoreCase(loan_status_inf_checkstatus.toLowerCase().trim()))
										{
											test.log(LogStatus.PASS, "check_status->Expected value:"+check_status +"; == Actual value:"+loan_status_inf_checkstatus);
										}
										else
										{
											test.log(LogStatus.FAIL, "check_status->Expected value:"+check_status +"; not equals to Actual value:"+loan_status_inf_checkstatus);

										}*/
										if(product_type.toLowerCase().trim().equalsIgnoreCase(product_type.toLowerCase().trim()))
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
										/*if(finance_charge.equalsIgnoreCase(loan_account_inf_finance_charge))
										{
											test.log(LogStatus.PASS, "finance_charge->Expected value:"+finance_charge +"; == Actual value:"+loan_account_inf_finance_charge);
										}
										else
										{
											test.log(LogStatus.FAIL, "finance_charge->Expected value:"+finance_charge +"; not equals to Actual value:"+loan_account_inf_finance_charge);

										}*/
										if(apr.equalsIgnoreCase(APR))
										{
											test.log(LogStatus.PASS, "apr->Expected value:"+apr +"; == Actual value:"+APR);
										}
										else
										{
											test.log(LogStatus.FAIL, "apr->Expected value:"+apr +"; not equals to Actual value:"+APR);

										}
										if(collateral_type.equalsIgnoreCase(Collateral_Type))
										{
											test.log(LogStatus.PASS, "collateral_type->Expected value:"+collateral_type +"; == Actual value:"+Collateral_Type);
										}
										else
										{
											test.log(LogStatus.FAIL, "collateral_type->Expected value:"+collateral_type +"; not equals to Actual value:"+Collateral_Type);

										}
										if(loan_frequency.toLowerCase().trim().equalsIgnoreCase(Loan_Frequency.toLowerCase().trim()))
										{
											test.log(LogStatus.PASS, "loan_frequency->Expected value:"+loan_frequency +"; == Actual value:"+Loan_Frequency);
										}
										else
										{
											test.log(LogStatus.FAIL, "loan_frequency->Expected value:"+loan_frequency +"; not equals to Actual value:"+Loan_Frequency);

										}
										if(credot_or_verification_fee.equalsIgnoreCase(Verification_fee))
										{
											test.log(LogStatus.PASS, "credot_or_verification_fee->Expected value:"+credot_or_verification_fee +"; == Actual value:"+Verification_fee);
										}
										else
										{
											test.log(LogStatus.FAIL, "credot_or_verification_fee->Expected value:"+credot_or_verification_fee +"; not equals to Actual value:"+Verification_fee);

										}
										if(available_credit.equalsIgnoreCase(Available_Credit))
										{
											test.log(LogStatus.PASS, "available_credit->Expected value:"+available_credit +"; == Actual value:"+Available_Credit);
										}
										else
										{
											test.log(LogStatus.FAIL, "available_credit->Expected value:"+available_credit +"; not equals to Actual value:"+Available_Credit);

										}
										if(courtesy_consent.equalsIgnoreCase(Courtesy_Consent))
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
										if(fee_due.equalsIgnoreCase(Fee_Due))
										{
											test.log(LogStatus.PASS, "fee_due->Expected value:"+fee_due +"; == Actual value:"+Fee_Due);
										}
										else
										{
											test.log(LogStatus.FAIL, "fee_due->Expected value:"+fee_due +"; not equals to Actual value:"+Fee_Due);

										}
										if(pay_off_amount.equalsIgnoreCase(Pay_off_Amt))
										{
											test.log(LogStatus.PASS, "pay_off_amount->Expected value:"+pay_off_amount +"; == Actual value:"+Pay_off_Amt);
										}
										else
										{
											test.log(LogStatus.FAIL, "pay_off_amount->Expected value:"+pay_off_amount +"; not equals to Actual value:"+Pay_off_Amt);

										}
										if(principal_paid_to_date.equalsIgnoreCase(Principal_Paid_To_Date))
										{
											test.log(LogStatus.PASS, "principal_paid_to_date->Expected value:"+principal_paid_to_date +"; == Actual value:"+Principal_Paid_To_Date);
										}
										else
										{
											test.log(LogStatus.FAIL, "principal_paid_to_date->Expected value:"+principal_paid_to_date +"; not equals to Actual value:"+Principal_Paid_To_Date);

										}
										if(fee_paid_date.equalsIgnoreCase(Fee_Paid_to_date))
										{
											test.log(LogStatus.PASS, "fee_paid_date->Expected value:"+fee_paid_date +"; == Actual value:"+Fee_Paid_to_date);
										}
										else
										{
											test.log(LogStatus.FAIL, "fee_paid_date->Expected value:"+fee_paid_date +"; not equals to Actual value:"+Fee_Paid_to_date);

										}
										
							/*			if(total_paid_amountc.equalsIgnoreCase(loan_paid_summary_total_paid_amt))
										{
											test.log(LogStatus.PASS, "total_paid_amount->Expected value:"+total_paid_amountc +"; == Actual value:"+loan_paid_summary_total_paid_amt);
										}
										else
										{
											test.log(LogStatus.FAIL, "total_paid_amount->Expected value:"+total_paid_amountc +"; not equals to Actual value:"+loan_paid_summary_total_paid_amt);

										} */
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
										/*if(product_name.equalsIgnoreCase(Product_Name))
										{
											test.log(LogStatus.PASS, "product_name->Expected value:"+product_name +"; == Actual value:"+Product_Name);
										}*/
										if(product_name.contains("PDL"))
										{
											test.log(LogStatus.PASS, "product_name->Expected value:"+product_name +"; == Actual value:"+Product_Name);
										}
										else
										{
											test.log(LogStatus.FAIL, "product_name->Expected value:"+product_name +"; not equals to Actual value:"+Product_Name);

										}
										if(transaction.equalsIgnoreCase(Transaction))
										{
											test.log(LogStatus.PASS, "Transaction->Expected value:"+transaction +"; == Actual value:"+Transaction);
										}
										else
										{
											test.log(LogStatus.FAIL, "Transaction->Expected value:"+transaction +"; not equals to Actual value:"+Transaction);

										}
										if(total_amount.equalsIgnoreCase(Total_Amt))
										{
											test.log(LogStatus.PASS, "total_amount->Expected value:"+total_amount +"; == Actual value:"+Total_Amt);
										}
										else
										{
											test.log(LogStatus.FAIL, "total_amount->Expected value:"+total_amount +"; not equals to Actual value:"+Total_Amt);

										}
										if(advance_amount.equalsIgnoreCase(Adv_amt))
										{
											test.log(LogStatus.PASS, "advance_amount->Expected value:"+advance_amount +"; == Actual value:"+Adv_amt);
										}
										else
										{
											test.log(LogStatus.FAIL, "advance_amount->Expected value:"+advance_amount +"; not equals to Actual value:"+Adv_amt);

										}
										if(advance_fees.equalsIgnoreCase(Adv_Fees))
										{
											test.log(LogStatus.PASS, "advance_fees->Expected value:"+advance_fees +"; == Actual value:"+Adv_Fees);
										}
										else
										{
											test.log(LogStatus.FAIL, "advance_fees->Expected value:"+advance_fees +"; not equals to Actual value:"+Adv_Fees);

										}
										if(NSF_amount.equalsIgnoreCase(NSF_Amt))
										{
											test.log(LogStatus.PASS, "NSF_amount->Expected value:"+NSF_amount +"; == Actual value:"+NSF_Amt);
										}
										else
										{
											test.log(LogStatus.FAIL, "NSF_amount->Expected value:"+NSF_amount +"; not equals to Actual value:"+NSF_Amt);

										}
										if(WO_amount.equalsIgnoreCase(WO_Amt))
										{
											test.log(LogStatus.PASS, "WO_amount->Expected value:"+WO_amount +"; == Actual value:"+WO_Amt);
										}
										else
										{
											test.log(LogStatus.FAIL, "WO_amount->Expected value:"+WO_amount +"; not equals to Actual value:"+WO_Amt);

										}
										if(interest_fee.equalsIgnoreCase(Intrest_Fee))
										{
											test.log(LogStatus.PASS, "interest_fee->Expected value:"+interest_fee +"; == Actual value:"+Intrest_Fee);
										}
										else
										{
											test.log(LogStatus.FAIL, "interest_fee->Expected value:"+interest_fee +"; not equals to Actual value:"+Intrest_Fee);

										}
										if(origination_fee.equalsIgnoreCase(Documentation_fee))
										{
											test.log(LogStatus.PASS, "origination_fee->Expected value:"+origination_fee +"; == Actual value:"+Documentation_fee);
										}
										else
										{
											test.log(LogStatus.FAIL, "origination_fee->Expected value:"+origination_fee +"; not equals to Actual value:"+Documentation_fee);

										}
										if(credit_or_verification_fee.equalsIgnoreCase(Verification_fee))
										{
											test.log(LogStatus.PASS, "credit_or_verification_fee->Expected value:"+credit_or_verification_fee +"; == Actual value:"+Verification_fee);
										}
										else
										{
											test.log(LogStatus.FAIL, "credit_or_verification_fee->Expected value:"+credit_or_verification_fee +"; not equals to Actual value:"+Verification_fee);

										}
										if(EPP_fee.equalsIgnoreCase(EPP_Fees))
										{
											test.log(LogStatus.PASS, "EPP_fee->Expected value:"+EPP_fee +"; == Actual value:"+EPP_Fees);
										}
										else
										{
											test.log(LogStatus.FAIL, "EPP_fee->Expected value:"+EPP_fee +"; not equals to Actual value:"+EPP_Fees);

										}

									    
									    
					        
					

}
			}
	}
}

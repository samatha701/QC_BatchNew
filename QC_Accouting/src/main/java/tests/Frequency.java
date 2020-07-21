package tests;

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


import tests.QCStore;

public class Frequency extends QCStore {
	


	public static void borrowerRegistration(String SSN,String AppURL) throws Exception
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
				
						test.log(LogStatus.INFO, "Borrower Registration has started");
						
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
						       
						      
						        driver.switchTo().frame("bottom");
								String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
								String store_date[]=Str_date.split(":");
								business_date=store_date[1].trim();
								business_date=store_date[1].trim();
								test.log(LogStatus.PASS, "Business date is :"+business_date);
								Thread.sleep(2000);
								driver.switchTo().defaultContent();	      
						  
						// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));

				        driver.switchTo().frame("topFrame");	        
				        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
				       
				        driver.findElement(locator(prop.getProperty("borrower_tab"))).click();	
				        Thread.sleep(2000);
						//driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();			
						test.log(LogStatus.PASS, "Clicked on Borrower");
						 Thread.sleep(2000);
					
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");			 
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='901000']")));
						driver.findElement(locator(prop.getProperty("registration_link"))).click();
					
						test.log(LogStatus.PASS, "Clicked on Registration");			
						driver.switchTo().frame("main");	
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);

						
						if(Income_PayFrequency.equals("Bi-Weekly")){
							{
							driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
							test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
							driver.findElement(By.id("rad_wk1")).click();
							test.log(LogStatus.PASS, "Selected Sunday button : ");
							//String day=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getText();
							//String day1=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getAttribute("value");
					
							String date=driver.findElement(By.xpath("//input[@id='biwkfstid' and @name='biwk']")).getAttribute("value");
							String date2=driver.findElement(By.xpath("//input[@id='biwksndid' and @name='biwk']")).getAttribute("value");
							
							Date d = df.parse(date2);
							 Calendar cal = Calendar.getInstance();
							 cal.setTime(d);
							int day_display= d.getDay();
							int month_dispay=d.getMonth();
							int year_display=d.getYear();
							
							
							Date d1 = df.parse(date);
							 Calendar cal1 = Calendar.getInstance();
							 cal1.setTime(d1);
							int day_display1= d1.getDay();
							if(day_display1==0&&day_display==0)
							{
								test.log(LogStatus.PASS, "Displayed date : "+date+" is fall on Sunday");
								test.log(LogStatus.PASS, "Displayed second date : "+date2+" is fall on Sunday");
							}
							else{
								test.log(LogStatus.FAIL, "Displayed date : "+date+" is not on Sunday");
							}
							}
//Monday
									{
									driver.findElement(By.id("rad_wk2")).click();
									test.log(LogStatus.PASS, "Selected Monday button: ");
									//String day=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getText();
									//String day1=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getAttribute("value");
							
									String date=driver.findElement(By.xpath("//input[@id='biwkfstid' and @name='biwk']")).getAttribute("value");
									String date2=driver.findElement(By.xpath("//input[@id='biwksndid' and @name='biwk']")).getAttribute("value");

										
									Date d = df.parse(date2);
									 Calendar cal = Calendar.getInstance();
									 cal.setTime(d);
									int day_display= d.getDay();
									
									Date d2 = df.parse(date);
									 Calendar cal2 = Calendar.getInstance();
									 cal2.setTime(d2);
									int day_display2= d2.getDay();
									if(day_display2==1&&day_display==1)									{
										test.log(LogStatus.PASS, "Displayed date : "+date+" is fall on Monday");
										test.log(LogStatus.PASS, "Displayed second date : "+date2+" is fall on Monday");
									}
									else{
										test.log(LogStatus.FAIL, "Displayed date : "+date+" is not on Monday");
									}
									}
									Thread.sleep(2000);
							
//Tuesday
									{
							driver.findElement(By.id("rad_wk3")).click();
							test.log(LogStatus.PASS, "Selected Tuesday button: ");
							//String day=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getText();
							//String day1=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getAttribute("value");
					
							String date=driver.findElement(By.xpath("//input[@id='biwkfstid' and @name='biwk']")).getAttribute("value");
							String date2=driver.findElement(By.xpath("//input[@id='biwksndid' and @name='biwk']")).getAttribute("value");

								
							Date d = df.parse(date2);
							 Calendar cal = Calendar.getInstance();
							 cal.setTime(d);
							int day_display= d.getDay();
							
							Date d3 = df.parse(date);
							 Calendar cal3 = Calendar.getInstance();
							 cal3.setTime(d3);
							int day_display3= d3.getDay();
							if(day_display3==2&&day_display==2)			
							{
								test.log(LogStatus.PASS, "Displayed date : "+date+" is fall on Tuesday");
								test.log(LogStatus.PASS, "Displayed second date : "+date2+" is fall on Tuesday");
							}
							else{
								test.log(LogStatus.FAIL, "Displayed date : "+date+" is not on Tuesday");
							}
									}
							Thread.sleep(2000);
							
//Wednesday
							{
							driver.findElement(By.id("rad_wk4")).click();
							test.log(LogStatus.PASS, "Selected Wednesday button: ");
							//String day=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getText();
							//String day1=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getAttribute("value");
					
							String date=driver.findElement(By.xpath("//input[@id='biwkfstid' and @name='biwk']")).getAttribute("value");
							String date2=driver.findElement(By.xpath("//input[@id='biwksndid' and @name='biwk']")).getAttribute("value");

								
							Date d = df.parse(date2);
							 Calendar cal = Calendar.getInstance();
							 cal.setTime(d);
							int day_display= d.getDay();
							
							Date d4 = df.parse(date);
							 Calendar cal4 = Calendar.getInstance();
							 cal4.setTime(d4);
							int day_display4= d4.getDay();
							if(day_display4==3&&day_display==3)			
							{
								test.log(LogStatus.PASS, "Displayed date : "+date+" is fall on Wednesday");
								test.log(LogStatus.PASS, "Displayed second date : "+date2+" is fall on Wednesday");
							}
							else{
								test.log(LogStatus.FAIL, "Displayed date : "+date+" is not on Wednesday");
							}
							
							Thread.sleep(2000);
							}
							
							
//Thursday
							
							driver.findElement(By.id("rad_wk5")).click();
							test.log(LogStatus.PASS, "Selected Thursday: ");
							//String day=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getText();
							//String day1=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getAttribute("value");
					
							String date=driver.findElement(By.xpath("//input[@id='biwkfstid' and @name='biwk']")).getAttribute("value");
							String date2=driver.findElement(By.xpath("//input[@id='biwksndid' and @name='biwk']")).getAttribute("value");

								
							Date d = df.parse(date2);
							 Calendar cal = Calendar.getInstance();
							 cal.setTime(d);
							int day_display= d.getDay();
							
							Date d2 = df.parse(date);
							 Calendar cal2 = Calendar.getInstance();
							 cal2.setTime(d);
							int day_display2= d.getDay();
							if(day_display2==4&&day_display==4)			
							{
								test.log(LogStatus.PASS, "Displayed date : "+date+" is fall on Thursday");
								test.log(LogStatus.PASS, "Displayed second date : "+date2+" is fall on Thursday");
							}
							else{
								test.log(LogStatus.FAIL, "Displayed date : "+date+" is not on Thursday");
							}
						}
							Thread.sleep(2000);
//Friday
							{
							driver.findElement(By.id("rad_wk6")).click();
							test.log(LogStatus.PASS, "Selected Friday: ");
							//String day=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getText();
							//String day1=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getAttribute("value");
					
							String date=driver.findElement(By.xpath("//input[@id='biwkfstid' and @name='biwk']")).getAttribute("value");
							String date2=driver.findElement(By.xpath("//input[@id='biwksndid' and @name='biwk']")).getAttribute("value");

								
							Date d = df.parse(date2);
							 Calendar cal = Calendar.getInstance();
							 cal.setTime(d);
							int day_display= d.getDay();
							
							Date d2 = df.parse(date);
							 Calendar cal2 = Calendar.getInstance();
							 cal2.setTime(d);
							int day_display2= d.getDay();
							if(day_display2==5&&day_display==5)			
							{
								test.log(LogStatus.PASS, "Displayed date : "+date+" is fall on Friday");
								test.log(LogStatus.PASS, "Displayed second date : "+date2+" is fall on Friday");
							}
							else{
								test.log(LogStatus.FAIL, "Displayed date : "+date+" is not on Friday");
							}
							
							Thread.sleep(2000);
							}
						
					
					//Saturday
					{
					driver.findElement(By.id("rad_wk7")).click();
					test.log(LogStatus.PASS, "Selected Saturday: ");
					//String day=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getText();
					//String day1=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getAttribute("value");
			
					String date=driver.findElement(By.xpath("//input[@id='biwkfstid' and @name='biwk']")).getAttribute("value");
					String date2=driver.findElement(By.xpath("//input[@id='biwksndid' and @name='biwk']")).getAttribute("value");

						
					Date d = df.parse(date2);
					 Calendar cal = Calendar.getInstance();
					 cal.setTime(d);
					int day_display= d.getDay();
					
					Date d2 = df.parse(date);
					 Calendar cal2 = Calendar.getInstance();
					 cal2.setTime(d);
					int day_display2= d.getDay();
					if(day_display2==6&&day_display==6)			
					{
						test.log(LogStatus.PASS, "Displayed date : "+date+" is fall on Saturday");
						test.log(LogStatus.PASS, "Displayed second date : "+date2+" is fall on Saturday");
					}
					else{
						test.log(LogStatus.FAIL, "Displayed date : "+date+" is not on Saturday");
					}
					
					Thread.sleep(2000);		
				}
					
					
					
					/*	if(Income_PayFrequency.equals("Monthly")){
							driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
							test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
							
							if(Monthly_Type.equals("1")){
								 test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
							 driver.findElement(By.name("customerBean.monthlyDate")).sendKeys(Monthly_payday);
							 test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: "+Monthly_payday);	
							}
							else if(Monthly_Type.equals("2")){
								 test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
								 driver.findElement(By.id("rad_monthly2")).click();
								 test.log(LogStatus.PASS, "Clicked on monthly type: "+Monthly_Type);
								 driver.findElement(By.name("customerBean.monthlyWeek")).sendKeys(Monthly_payWeek);
								 test.log(LogStatus.PASS, "Monthly pay week is selected : "+Monthly_payWeek);
								 driver.findElement(By.name("customerBean.monthlyDay")).sendKeys(Monthly_payWeekDay);
								 test.log(LogStatus.PASS, "Monthly pay week is selected : "+Monthly_payWeekDay);
								}}
						else if(Income_PayFrequency.equals("Semi-Monthly"))
						{
							driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
							test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
							 driver.findElement(By.id("rad_semi1")).click();
							 test.log(LogStatus.PASS, "Clicked on 1st and 16th of check box  ");
							 
						}
						
						else if(Income_PayFrequency.equals("Weekly")){
							driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
							test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
							driver.findElement(By.id("rad_wk4")).click();
							 test.log(LogStatus.PASS, "Clicked on wednsday button ");
							
						}
						
						
						
						
						
						
						
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("bottom");
						 String  BusinessDt= driver.findElement(locator(prop.getProperty(("CSR_reg_business_date")))).getText();
						 String Busdate[]=BusinessDt.split(":");
						 String date = Busdate[1];
						
						 Date d1 = df.parse(date);
						 Calendar cal = Calendar.getInstance();
						 cal.setTime(d1);
						 cal.add(Calendar.DATE, -20);
						 Date PayStubReviewedDate1= cal.getTime();
						 
						 String PayStubReviewedDate =df.format(PayStubReviewedDate1);
								 //Date D=Add(date1,7);
						 //System.out.println(date);
						
						 //System.out.println(PayStubReviewedDate);
						 
						 
					
						driver.findElement(locator(prop.getProperty("CSR_reg_direct_deposit"))).sendKeys(Income_DirectDeposit);
						test.log(LogStatus.PASS, "DirectDeposit is entered: "+Income_DirectDeposit);
						cal.add(Calendar.DATE, -60);
						 Date Bank_AcctVerificationDt0= cal.getTime();*/
							/* 
							    String Bank_AcctVerificationDt =df.format(Bank_AcctVerificationDt0);
							    String Bank_AcctVerificationDt1[] =Bank_AcctVerificationDt.split("/");
						        String Bank_AcctVerificationDt2 = Bank_AcctVerificationDt1[0];
						        String Bank_AcctVerificationDt3 = Bank_AcctVerificationDt1[1];
						        String Bank_AcctVerificationDt4 = Bank_AcctVerificationDt1[2];
								driver.findElement(locator(prop.getProperty("CSR_reg_acc_verify_date1"))).sendKeys(Bank_AcctVerificationDt2);
								test.log(LogStatus.PASS, "Bank_AcctVerificationDt1 is entered: "+Bank_AcctVerificationDt2);
								driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
								driver.findElement(locator(prop.getProperty("CSR_reg_acc_verify_date2"))).sendKeys(Bank_AcctVerificationDt3);
								test.log(LogStatus.PASS, "Bank_AcctVerificationDt2 is entered: "+Bank_AcctVerificationDt3);
								driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
								driver.findElement(locator(prop.getProperty("CSR_reg_acc_verify_date3"))).sendKeys(Bank_AcctVerificationDt4);
								test.log(LogStatus.PASS, "Bank_AcctVerificationDt3 is entered: "+Bank_AcctVerificationDt4);
							
						 //driver.findElement(locator(prop.getProperty("customerBean.abaNbrDisp")).sendKeys(Bank_ABARoutingNbr);
						//driver.findElement(locator(prop.getProperty("phoneNbr3"))(PP3);
						//test.log(LogStatus.PASS, "PP3 is entered: "+PP3);
								driver.findElement(locator(prop.getProperty("CSR_reg_ABA_number"))).sendKeys(Bank_ABARoutingNbr);
								test.log(LogStatus.PASS, "Bank_ABARoutingNbr is entered: "+Bank_ABARoutingNbr);
								driver.findElement(locator(prop.getProperty("CSR_reg_confirm_ABA_number"))).sendKeys(Bank_ABARoutingNbr);
								test.log(LogStatus.PASS, "Confirm ABA/Routing Nbr is entered: "+Bank_ABARoutingNbr);
								driver.findElement(locator(prop.getProperty("CSR_reg_acc_number"))).sendKeys(Bank_ChkgAcctNbr);
								test.log(LogStatus.PASS, "Chkg Acct Nbr is entered: "+Bank_ChkgAcctNbr);			
								driver.findElement(locator(prop.getProperty("CSR_reg_confirm_acc_number"))).sendKeys(Bank_ChkgAcctNbr);
								test.log(LogStatus.PASS, "Confirm Chkg Acct Nbr is entered: "+Bank_ChkgAcctNbr);			
						//driver.findElement(locator(prop.getProperty("customerBean.drivingZipcode")).sendKeys(Bank_ChkgAcctNbr);
						//test.log(LogStatus.PASS, "drivingZipcode is entered: "+MiscZipCode);
						
						//Primary Reference Details
						
						
								driver.findElement(locator(prop.getProperty("CSR_reg_primary_ref_lastname"))).sendKeys(PrimaryRef_LastName);
								test.log(LogStatus.PASS, "PRLast Name is entered: "+PrimaryRef_LastName);
								driver.findElement(locator(prop.getProperty("CSR_reg_primary_ref_firstname"))).sendKeys(PrimaryRef_FirstName);
								test.log(LogStatus.PASS, "PRFirst Name is entered: "+PrimaryRef_FirstName);
						
						//driver.findElement(locator(prop.getProperty("customerBean.contName")).sendKeys(PrimaryRef_LastName);
								driver.findElement(locator(prop.getProperty("CSR_reg_primary_relation"))).sendKeys(PrimaryRef_Relationship);
								test.log(LogStatus.PASS, "Contactrelation is entered: "+PrimaryRef_Relationship);
								driver.findElement(locator(prop.getProperty("CSR_reg_primary_ref_phone1"))).sendKeys(PrimaryRef_PhoneNbr1);
								test.log(LogStatus.PASS, "PrimaryReference Phone Nbr1 is entered: "+PrimaryRef_PhoneNbr1);
								driver.findElement(locator(prop.getProperty("CSR_reg_primary_ref_phone2"))).sendKeys(PrimaryRef_PhoneNbr2);
								test.log(LogStatus.PASS, "PrimaryReference Phone Nbr1 is entered: "+PrimaryRef_PhoneNbr2);
								driver.findElement(locator(prop.getProperty("CSR_reg_primary_ref_phone3"))).sendKeys(PrimaryRef_PhoneNbr3);
								test.log(LogStatus.PASS, "PrimaryReference Phone Nbr1 is entered: "+PrimaryRef_PhoneNbr3);
						//Thread.sleep(10000);
						// Reference Details
								//driver.findElement(locator(prop.getProperty("bt_Reference")).click();			
								//test.log(LogStatus.PASS, "Clicked on ADD Reference");
							
								driver.findElement(locator(prop.getProperty("CSR_reg_secondary_ref_lastname"))).sendKeys(Ref_LastName);
								test.log(LogStatus.PASS, "RLast Name is entered: "+Ref_LastName);
								driver.findElement(locator(prop.getProperty("CSR_reg_secondary_ref_firstname"))).sendKeys(Ref_FirstName);
								test.log(LogStatus.PASS, "RFirst Name is entered: "+Ref_FirstName);
							    driver.findElement(locator(prop.getProperty("CSR_reg_secondary_relation"))).sendKeys(Ref_Relationship);
								test.log(LogStatus.PASS, "reference relation is entered: "+Ref_Relationship);
								driver.findElement(locator(prop.getProperty("CSR_reg_secondary_ref_phone1"))).sendKeys(Ref_PhoneNbr1);
								test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+Ref_PhoneNbr1);
								driver.findElement(locator(prop.getProperty("CSR_reg_secondary_ref_phone2"))).sendKeys(Ref_PhoneNbr2);
								test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+Ref_PhoneNbr2);
								driver.findElement(locator(prop.getProperty("CSR_reg_secondary_ref_phone3"))).sendKeys(Ref_PhoneNbr3);
								test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+Ref_PhoneNbr3);
								//Thread.sleep(10000);

								driver.findElement(locator(prop.getProperty("CSR_reg_add_reference_button"))).click();			
								test.log(LogStatus.PASS, "Clicked on ADD Reference");
						
								
								driver.findElement(locator(prop.getProperty("CSR_reg_bunkrupty_selection"))).sendKeys(Bankruptcy);
								test.log(LogStatus.PASS, "Bankrupty is selected as: "+Bankruptcy);
								 
								 for(int j=1;j<=7;j++){       //''''''For Performed on Save&Exit Button
								 driver.findElement(locator(prop.getProperty("CSR_reg_bunkrupty_selection"))).sendKeys(Keys.TAB);
								 break;
								 }
								 
								driver.findElement(By.xpath("//*[@id='btnShowModalExit']")).sendKeys(Keys.ENTER);
								test.log(LogStatus.PASS, "Clicked on Save & Exit");
							
								Thread.sleep(2000);
									try { 
									    Alert alert = driver.switchTo().alert();
									    alert.accept();
									   // if alert present, accept and move on.												
										
									}
									catch (NoAlertPresentException e) {
									    //do what you normally would if you didn't have the alert.
									}
										
									   
								for(String winHandle : driver.getWindowHandles()){
									    
								  driver.switchTo().window(winHandle);
								  driver.switchTo().defaultContent();
								  driver.switchTo().frame("mainFrame");
								  driver.switchTo().frame("main");
									 
									 Thread.sleep(10000);
									 String elementname= driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/b/font")).getText();
									 test.log(LogStatus.PASS, "Registration Success Screen::"+elementname);
							
								
							    if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/b/font")).isDisplayed())
							    	
							 	{
								
								   test.log(LogStatus.PASS, "Borrower is Registered Successfully with SSN as " +SSN);	
								   test.log(LogStatus.PASS, "**********************************************" );
									// test.log(LogStatus.PASS, MarkupHelper.createLabel("Borrower is Registered Successfully with SSN as " +SSN, ExtentColor.GREEN) );

							 	}
							 	else
								{
								test.log(LogStatus.FAIL, "Borrower is not Registered Successfully with SSN as " +SSN);
								// test.log(LogStatus.FAIL, MarkupHelper.createLabel("Borrower is not Registered Successfully with SSN as " +SSN, ExtentColor.RED) );

								}
							 	
								}
				
								 
								   driver.switchTo().defaultContent();
								   driver.switchTo().frame("topFrame");
									
								try { 
								    Alert alert = driver.switchTo().alert();
								    alert.accept();
								    //if alert present, accept and move on.														
									
								}
								catch (NoAlertPresentException e) {
								    //do what you normally would if you didn't have the alert.
								}*/
							break;
							}
					
					}	
			break;
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Borrower Registration is failed", ExtentColor.RED));
				test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
				String screenshotPath = getScreenhot(driver, "Borrower");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.INFO, "Borrower Registration process is initiated again due to Application sync issue");
				driver.get(prop.getProperty("login_page"));  
				continue;

			}
		

}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "Borrower Registration is failed");
			Assert.assertTrue(false);
	
		}
	}
	}


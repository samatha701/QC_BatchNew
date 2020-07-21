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

public class Frequency_Weekly extends QCStore {
	


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

						
						if(Income_PayFrequency.equals("Weekly")){
							{
							driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
							test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
							driver.findElement(By.id("rad_wk1")).click();
							test.log(LogStatus.PASS, "Selected Sunday button : ");
							//String day=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getText();
							//String day1=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getAttribute("value");
					
							String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
							String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
							String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
							String date=date1+"/"+date2+"/"+date3;

							
							
							Date d1 = df.parse(date);
							 Calendar cal1 = Calendar.getInstance();
							 cal1.setTime(d1);
							int day_display1= d1.getDay();
							if(day_display1==0)
							{
								test.log(LogStatus.PASS, "Displayed date : "+date+" is fall on Sunday");
								
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
							
									String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
									String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
									String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
									String date=date1+"/"+date2+"/"+date3;

									
									
									Date d1 = df.parse(date);
									 Calendar cal1 = Calendar.getInstance();
									 cal1.setTime(d1);
									int day_display1= d1.getDay();
									if(day_display1==1)
									{
										test.log(LogStatus.PASS, "Displayed date : "+date+" is fall on Monday");
										
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
					
							String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
							String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
							String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
							String date=date1+"/"+date2+"/"+date3;

							
							
							Date d1 = df.parse(date);
							 Calendar cal1 = Calendar.getInstance();
							 cal1.setTime(d1);
							int day_display1= d1.getDay();
							if(day_display1==2)
							{
								test.log(LogStatus.PASS, "Displayed date : "+date+" is fall on Tuesday");
								
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
					
							String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
							String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
							String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
							String date=date1+"/"+date2+"/"+date3;

							
							
							Date d1 = df.parse(date);
							 Calendar cal1 = Calendar.getInstance();
							 cal1.setTime(d1);
							int day_display1= d1.getDay();
							if(day_display1==3)
							{
								test.log(LogStatus.PASS, "Displayed date : "+date+" is fall on Wednesday");
								
							}
							else{
								test.log(LogStatus.FAIL, "Displayed date : "+date+" is not on wednesday");
							}
							
							Thread.sleep(2000);
							}
							
							
//Thursday
							
							driver.findElement(By.id("rad_wk5")).click();
							test.log(LogStatus.PASS, "Selected Thursday: ");
							//String day=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getText();
							//String day1=driver.findElement(By.xpath("//input[@name='rad_wk' and @id='rad_wk1']")).getAttribute("value");
					
							String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
							String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
							String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
							String date=date1+"/"+date2+"/"+date3;

							
							
							Date d1 = df.parse(date);
							 Calendar cal1 = Calendar.getInstance();
							 cal1.setTime(d1);
							int day_display1= d1.getDay();
							if(day_display1==4)
							{
								test.log(LogStatus.PASS, "Displayed date : "+date+" is fall on Thursday");
								
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
					
							String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
							String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
							String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
							String date=date1+"/"+date2+"/"+date3;

							
							
							Date d1 = df.parse(date);
							 Calendar cal1 = Calendar.getInstance();
							 cal1.setTime(d1);
							int day_display1= d1.getDay();
							if(day_display1==5)
							{
								test.log(LogStatus.PASS, "Displayed date : "+date+" is fall on Friday");
								
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
			
					String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
					String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
					String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
					String date=date1+"/"+date2+"/"+date3;

					
					
					Date d1 = df.parse(date);
					 Calendar cal1 = Calendar.getInstance();
					 cal1.setTime(d1);
					int day_display1= d1.getDay();
					if(day_display1==6)
					{
						test.log(LogStatus.PASS, "Displayed date : "+date+" is fall on Satuday");
						
					}
					else{
						test.log(LogStatus.FAIL, "Displayed date : "+date+" is not on Saturday");
					}
					
					Thread.sleep(2000);		
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


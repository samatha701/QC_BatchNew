package tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import static java.time.temporal.TemporalAdjusters.firstInMonth;


import tests.QCStore;

public class sample extends QCStore {
	


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
							          
						 String business_date2;
						 String business_date1;
						 String business_date3;
					      
				        String ProductType= TestData.getCellData(sheetName,"ProductType",row);         
				
				       String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				      
						//	test.log(LogStatus.INFO, "Borrower Registration-SSN: " +SSN);
							
							   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
						        String SSN1 = SSN.substring(0, 3);
						        String SSN2 = SSN.substring(3,5);
						        String SSN3 = SSN.substring(5,9);
						   
						        String Monthly_Type= TestData.getCellData(sheetName,"MonthlyType",row);
						        String Monthly_payWeek=TestData.getCellData(sheetName,"MonthlyPayWeek",row);
						        String Monthly_payWeekDay=TestData.getCellData(sheetName,"MonthlyPayWeekDay",row);
						        String Monthly_payday= TestData.getCellData(sheetName,"MonthlyPayDay",row);
						       
						      
						        driver.switchTo().frame("bottom");
								String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
								String store_date[]=Str_date.split(":");
								business_date=store_date[1].trim();
								String business_datenew[] =business_date.split("/");
						        business_date1 = business_datenew[0];
						        business_date2 = business_datenew[1];
						        business_date3 = business_datenew[2];	
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

						Date d = df.parse(business_date);
						 Calendar cal = Calendar.getInstance();
						 cal.setTime(d);
						int day_display= d.getDay();
						int month_dispay=d.getMonth();
						int year_display=d.getYear();
						

						
						
//For Februry
						if(month_dispay==1)	
					{
//For LastDay selection
							
							{
								driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
								test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);
								test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
								 driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("Last Day");
								 test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: v");
								 Date d1 = df.parse(business_date);
								 String lastdate = business_date;
								 LocalDate convertedDate = LocalDate.parse(lastdate, DateTimeFormatter.ofPattern("M/d/yyyy"));
								 convertedDate = convertedDate.withDayOfMonth(
								                                 convertedDate.getMonth().length(convertedDate.isLeapYear()));
								 String expected_date=String.valueOf(convertedDate);
								 String expected_datenew[] =expected_date.split("-");
								 String  expect_date1 = expected_datenew[0];
								 String   expect_date2 = expected_datenew[1];
								 String   expect_date3 = expected_datenew[2];	
								 
								 expected_date=expect_date2+"/"+expect_date3+"/"+expect_date1;
								 
								 
								
								 
								 String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
									String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
									String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
									String date=date1+"/"+date2+"/"+date3;
									if(date.equalsIgnoreCase(expected_date)||date.equalsIgnoreCase(expected_date)||date.equalsIgnoreCase(expected_date)||date.equalsIgnoreCase(expected_date))
									{
									test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+expected_date);		
									}
									else
									{
										test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+expected_date);	
									}
								 
								
							}
							
								
							
							
							
						driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
						test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
						 int business_date2_int=Integer.parseInt(business_date2);
						 
						 for(int k=1;k<=28;k++)
						{
						String kstring=String.valueOf(k);
						 test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
					 driver.findElement(By.name("customerBean.monthlyDate")).sendKeys(kstring);
					 test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: "+kstring);	
					
					 int business_date1_int=Integer.parseInt(business_date1);
					 int business_date3_int=Integer.parseInt(business_date3);
					 if(k<=business_date2_int)
					 {
						 String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
							String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
							String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
							String date=date1+"/"+date2+"/"+date3;
							String expected_date=business_date1_int+1+"/"+k+"/"+business_date3_int;
							String expected_date2="0"+(business_date1_int+1)+"/"+"0"+k+"/"+business_date3_int;
							String expected_date3=(business_date1_int+1)+"/"+"0"+k+"/"+business_date3_int;
							String expected_date4="0"+(business_date1_int+1)+"/"+k+"/"+business_date3_int;
							if(date.equalsIgnoreCase(expected_date)||date.equalsIgnoreCase(expected_date2)||date.equalsIgnoreCase(expected_date3)||date.equalsIgnoreCase(expected_date4))
							{
							test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+(business_date1_int+1)+"/"+k+"/"+business_date3);		
							}
							else
							{
								test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+business_date1_int+1+"/"+k+"/"+business_date3);	
							}
							Thread.sleep(3000);
							
					 }
					 
					 else if(k>business_date2_int)
					 {
						 String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
							String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
							String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
							String date=date1+"/"+date2+"/"+date3;
							
						
							
							String expected_date=business_date1_int+"/"+k+"/"+business_date3_int;
							String expected_date2="0"+(business_date1_int)+"/"+"0"+k+"/"+business_date3_int;
							String expected_date3=(business_date1_int)+"/"+"0"+k+"/"+business_date3_int;
							String expected_date4="0"+(business_date1_int)+"/"+k+"/"+business_date3_int;
							
							Date d1 = df.parse(expected_date);
							int date2_int=Integer.parseInt(date2);
							
							d1.setDate(date2_int);
					
							
							
							
							SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
						    sdfrmt.setLenient(false);
						    
							 Calendar cal1 = Calendar.getInstance();
							 cal1.setTime(d1);
							 
							 
							 try
							    {
							        Date javaDate = sdfrmt.parse(expected_date); 
							        //System.out.println(expected_date+" is valid date format");
							        if(date.equalsIgnoreCase(expected_date)||date.equalsIgnoreCase(expected_date2)||date.equalsIgnoreCase(expected_date3)||date.equalsIgnoreCase(expected_date4))
									{
									test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+business_date1_int+"/"+k+"/"+business_date3);		
									}
									else
									{
										test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+business_date1_int+"/"+k+"/"+business_date3);	
									} 
							    }
							    /* Date format is invalid */
							    catch (ParseException e)
							    {
							        //System.out.println(expected_date+" is Invalid Date format");
							    	
							        if(date.equalsIgnoreCase(expected_date)||date.equalsIgnoreCase(expected_date2)||date.equalsIgnoreCase(expected_date3)||date.equalsIgnoreCase(expected_date4))
									{
									test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+(business_date1_int+1)+"/"+1+"/"+business_date3);		
									}
									else
									{
										test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+(business_date1_int+1)+"/"+1+"/"+business_date3);	
									} 
							        
							    }
							 
							int day_display1= d1.getDay();
							
							
							
							
							
							
							Thread.sleep(3000);	
					}
					 
						}
						 SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
						    sdfrmt.setLenient(false);
						    String leap=business_date1+"/"+29+"/"+business_date3;
//For leap year						
						 try{
							 Date javaDate = sdfrmt.parse(leap); 
							 {
								 test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
								 driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("29");
								 test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: "+29);	 
								 String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
									String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
									String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
									String date=date1+"/"+date2+"/"+date3;
									String expected_date=02+"/"+29+"/"+business_date3;
									if(date.equalsIgnoreCase(expected_date))
									{
									test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+expected_date);		
									}
									else
									{
										test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+expected_date);	
									} 
								 }
									{
									test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
									 driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("30");
									 test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: "+30);	 
									 String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
										String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
										String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
										String date=date1+"/"+date2+"/"+date3;
										String expected_date=03+"/"+01+"/"+business_date3;
										if(date.equalsIgnoreCase(expected_date))
										{
										test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+expected_date);		
										}
										else
										{
											test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+expected_date);	
										} 
									}
									{
										test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
										 driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("31");
										 test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: "+31);	 
										 String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
											String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
											String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
											String date=date1+"/"+date2+"/"+date3;
											String expected_date=03+"/"+02+"/"+business_date3;
											if(date.equalsIgnoreCase(expected_date))
											{
											test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+expected_date);		
											}
											else
											{
												test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+expected_date);	
											} 
										
										
										
									}
							 
						 }
//For non leap year						 
						 catch(Exception e){
							 
							 {
								 test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
								 driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("29");
								 test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: "+29);	 
								 String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
									String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
									String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
									String date=date1+"/"+date2+"/"+date3;
									String expected_date=03+"/"+01+"/"+business_date3;
									if(date.equalsIgnoreCase(expected_date))
									{
									test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+expected_date);		
									}
									else
									{
										test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+expected_date);	
									} 
								 }
									{
									test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
									 driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("30");
									 test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: "+30);	 
									 String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
										String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
										String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
										String date=date1+"/"+date2+"/"+date3;
										String expected_date=03+"/"+02+"/"+business_date3;
										if(date.equalsIgnoreCase(expected_date))
										{
										test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+expected_date);		
										}
										else
										{
											test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+expected_date);	
										} 
									}
									{
										test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
										 driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("31");
										 test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: "+31);	 
										 String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
											String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
											String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
											String date=date1+"/"+date2+"/"+date3;
											String expected_date=03+"/"+03+"/"+business_date3;
											if(date.equalsIgnoreCase(expected_date))
											{
											test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+expected_date);		
											}
											else
											{
												test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+expected_date);	
											} 
										
										
										
									}
							 
							 
						 }
						 
						 
						 
							
						 
					}
//For December					 
					if(month_dispay==11)	
					{
					
						driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
						test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
						 int business_date2_int=Integer.parseInt(business_date2);
						
						if(Monthly_Type.equals("1")){
							for(int k=1;k<=31;k++)
							{
							String kstring=String.valueOf(k);
							 test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
						 driver.findElement(By.name("customerBean.monthlyDate")).sendKeys(kstring);
						 test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: "+kstring);	
						
						 int business_date1_int=Integer.parseInt(business_date1);
						 int business_date3_int=Integer.parseInt(business_date3);
						 if(k<=business_date2_int)
						 {
							 String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
								String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
								String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
								String date=date1+"/"+date2+"/"+date3;
								String expected_date="01"+"/"+k+"/"+(business_date3_int+1);
								String expected_date2="01"+"/"+"0"+k+"/"+(business_date3_int+1);
								String expected_date3="01"+"/"+"0"+k+"/"+(business_date3_int+1);
								String expected_date4="01"+"/"+k+"/"+(business_date3_int+1);
								if(date.equalsIgnoreCase(expected_date)||date.equalsIgnoreCase(expected_date2)||date.equalsIgnoreCase(expected_date3)||date.equalsIgnoreCase(expected_date4))
								{
								test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+01+"/"+k+"/"+(business_date3_int+1));		
								}
								else
								{
									test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+01+"/"+k+"/"+(business_date3_int+1));	
								}
								Thread.sleep(3000);
								
						 }
						 
						 else if(k>business_date2_int)
						 {
							 String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
								String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
								String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
								String date=date1+"/"+date2+"/"+date3;
								
							
								
								String expected_date=business_date1_int+"/"+k+"/"+business_date3_int;
								String expected_date2="0"+(business_date1_int)+"/"+"0"+k+"/"+business_date3_int;
								String expected_date3=(business_date1_int)+"/"+"0"+k+"/"+business_date3_int;
								String expected_date4="0"+(business_date1_int)+"/"+k+"/"+business_date3_int;
								
								Date d1 = df.parse(expected_date);
								int date2_int=Integer.parseInt(date2);
								
								d1.setDate(date2_int);
						
								
								
								
								SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
							    sdfrmt.setLenient(false);
							    
								 Calendar cal1 = Calendar.getInstance();
								 cal1.setTime(d1);
								 
								 
								 try
								    {
								        Date javaDate = sdfrmt.parse(expected_date); 
								        //System.out.println(expected_date+" is valid date format");
								        if(date.equalsIgnoreCase(expected_date)||date.equalsIgnoreCase(expected_date2)||date.equalsIgnoreCase(expected_date3)||date.equalsIgnoreCase(expected_date4))
										{
										test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+business_date1_int+"/"+k+"/"+business_date3);		
										}
										else
										{
											test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+business_date1_int+"/"+k+"/"+business_date3);	
										} 
								    }
								    /* Date format is invalid */
								    catch (ParseException e)
								    {
								        //System.out.println(expected_date+" is Invalid Date format");
								    	
								        if(date.equalsIgnoreCase(expected_date)||date.equalsIgnoreCase(expected_date2)||date.equalsIgnoreCase(expected_date3)||date.equalsIgnoreCase(expected_date4))
										{
										test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+(business_date1_int+1)+"/"+1+"/"+business_date3);		
										}
										else
										{
											test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+(business_date1_int+1)+"/"+1+"/"+business_date3);	
										} 
								        
								    }
								 
								int day_display1= d1.getDay();
								
								
								
								
								
								
								Thread.sleep(3000);
						 }
						 
													
							/*Date d1 = df.parse(date);
							 Calendar cal1 = Calendar.getInstance();
							 cal1.setTime(d1);
							int day_display1= d1.getDay();*/
						 
						 
						 
						}
						}
						else if(Monthly_Type.equals("2")){
							 test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
							 driver.findElement(By.id("rad_monthly2")).click();
							 test.log(LogStatus.PASS, "Clicked on monthly type: "+Monthly_Type);
							 driver.findElement(By.name("customerBean.monthlyWeek")).sendKeys(Monthly_payWeek);
							 test.log(LogStatus.PASS, "Monthly pay week is selected : "+Monthly_payWeek);
							 driver.findElement(By.name("customerBean.monthlyDay")).sendKeys(Monthly_payWeekDay);
							 test.log(LogStatus.PASS, "Monthly pay week is selected : "+Monthly_payWeekDay);
							}	
						
						
						
					}
						
//For other months					
					if(!(month_dispay==1)&&!(month_dispay==11)){
						driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
						test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
						 int business_date2_int=Integer.parseInt(business_date2);
						
						if(Monthly_Type.equals("1")){
							for(int k=31;k<=31;k++)
							{
							String kstring=String.valueOf(k);
							 test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
						 driver.findElement(By.name("customerBean.monthlyDate")).sendKeys(kstring);
						 test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: "+kstring);	
						
						 int business_date1_int=Integer.parseInt(business_date1);
						 int business_date3_int=Integer.parseInt(business_date3);
						 if(k<=business_date2_int)
						 {
							 String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
								String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
								String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
								String date=date1+"/"+date2+"/"+date3;
								String expected_date=business_date1_int+1+"/"+k+"/"+business_date3_int;
								String expected_date2="0"+(business_date1_int+1)+"/"+"0"+k+"/"+business_date3_int;
								String expected_date3=(business_date1_int+1)+"/"+"0"+k+"/"+business_date3_int;
								String expected_date4="0"+(business_date1_int+1)+"/"+k+"/"+business_date3_int;
								if(date.equalsIgnoreCase(expected_date)||date.equalsIgnoreCase(expected_date2)||date.equalsIgnoreCase(expected_date3)||date.equalsIgnoreCase(expected_date4))
								{
								test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+(business_date1_int+1)+"/"+k+"/"+business_date3);		
								}
								else
								{
									test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+business_date1_int+1+"/"+k+"/"+business_date3);	
								}
								Thread.sleep(3000);
								
						 }
						 
						 else if(k>business_date2_int)
						 {
							 String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
								String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
								String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
								String date=date1+"/"+date2+"/"+date3;
								
							
								
								String expected_date=business_date1_int+"/"+k+"/"+business_date3_int;
								String expected_date2="0"+(business_date1_int)+"/"+"0"+k+"/"+business_date3_int;
								String expected_date3=(business_date1_int)+"/"+"0"+k+"/"+business_date3_int;
								String expected_date4="0"+(business_date1_int)+"/"+k+"/"+business_date3_int;
								
								Date d1 = df.parse(expected_date);
								int date2_int=Integer.parseInt(date2);
								
								d1.setDate(date2_int);
						
								
								
								
								SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
							    sdfrmt.setLenient(false);
							    
								 Calendar cal1 = Calendar.getInstance();
								 cal1.setTime(d1);
								 
								 
								 try
								    {
								        Date javaDate = sdfrmt.parse(expected_date); 
								        //System.out.println(expected_date+" is valid date format");
								        if(date.equalsIgnoreCase(expected_date)||date.equalsIgnoreCase(expected_date2)||date.equalsIgnoreCase(expected_date3)||date.equalsIgnoreCase(expected_date4))
										{
										test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+business_date1_int+"/"+k+"/"+business_date3);		
										}
										else
										{
											test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+business_date1_int+"/"+k+"/"+business_date3);	
										} 
								    }
								    /* Date format is invalid */
								    catch (ParseException e)
								    {
								        //System.out.println(expected_date+" is Invalid Date format");
								    	
								        if(date.equalsIgnoreCase(expected_date)||date.equalsIgnoreCase(expected_date2)||date.equalsIgnoreCase(expected_date3)||date.equalsIgnoreCase(expected_date4))
										{
										test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date"+(business_date1_int+1)+"/"+1+"/"+business_date3);		
										}
										else
										{
											test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date"+(business_date1_int+1)+"/"+1+"/"+business_date3);	
										} 
								        
								    }
								 
								int day_display1= d1.getDay();
								
								
								
								
								
								
								Thread.sleep(3000);
						 }
						 
													
							/*Date d1 = df.parse(date);
							 Calendar cal1 = Calendar.getInstance();
							 cal1.setTime(d1);
							int day_display1= d1.getDay();*/
						 
						 
						 
						}
						}
						else if(Monthly_Type.equals("2")){
							 test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
							 driver.findElement(By.id("rad_monthly2")).click();
							 test.log(LogStatus.PASS, "Clicked on monthly type: "+Monthly_Type);
							 driver.findElement(By.name("customerBean.monthlyWeek")).sendKeys(Monthly_payWeek);
							 test.log(LogStatus.PASS, "Monthly pay week is selected : "+Monthly_payWeek);
							 driver.findElement(By.name("customerBean.monthlyDay")).sendKeys(Monthly_payWeekDay);
							 test.log(LogStatus.PASS, "Monthly pay week is selected : "+Monthly_payWeekDay);
							 String date1=driver.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']")).getAttribute("value");
								String date2=driver.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']")).getAttribute("value");
								String date3=driver.findElement(By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']")).getAttribute("value");
								String date=date1+"/"+date2+"/"+date3;
							 
							 
							 
							 
							 for(int j=1;i<7;i++)
							 {
								 Date d1 = df.parse(j+business_date2+business_date3);
								 d1.getMonth();
							 Calendar c = Calendar.getInstance();
							 c.setTime(d1);
							 int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
							int business_date1_int=Integer.parseInt(business_date1);
							 
							 
							 
							 if(dayOfWeek==5)
							 {
								 
								 if(j<=business_date1_int)
								 { 
									 
									 LocalDate now = LocalDate.now(); //2015-11-23
									 LocalDate firstMonday = now.with(firstInMonth(DayOfWeek.MONDAY));	 
									 
								 //String expected_date=j+business_date2+business_date3
									 String expected_date = business_date;
									 if(date.equalsIgnoreCase(expected_date))
										{
										test.log(LogStatus.PASS, "Displayed date: "+date+"== Expected date");		
										}
										else
										{
											test.log(LogStatus.FAIL, "Displayed date: "+date+"Not equals to Expected date");	
										} 
									 
									 
								 
								 }
								 
								 
							 }
							 
							 }
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							}
					
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


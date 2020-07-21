package tests;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class AQCDownloadNACHA extends QCStore {
	
	public static String st1;
	public static String st2;
	public static String st3;
	public static String st4;
	public static String st5;
	public static String st6;
	public static String st7;
	public static String st8;
	public static String st9;
	public static String st10;	
	public static String path;
	
	public static void ACHProcess(String SSN) throws InterruptedException, IOException, AWTException
	{
		 
		
		int lastrow=TestData.getLastRow("Login");
		String sheetName="Login";
				
			for(int row=2;row<=lastrow+1;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					//String StoreID = TestData.getCellData(sheetName,"StoreID",row);
					
					if(SSN.equals(RegSSN))
					{
							
			       Thread.sleep(4000);
					test.log(LogStatus.INFO, "ACH Processing through from Admin has initiated");
					driver.switchTo().defaultContent();	
			     
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(Aprop.getProperty("admin_ACH_transaction"))).click();		
					test.log(LogStatus.PASS, "Clicked on Transactions");
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
				
					 Actions action = new Actions(driver);  
					 WebElement ACH=driver.findElement(locator(Aprop.getProperty("admin_ACH_menu")));
					 action.moveToElement(ACH).build().perform();
					 test.log(LogStatus.PASS, " Mouse hover on ACH menu");
					 Thread.sleep(2000);
					/* driver.findElement (By.xpath("//*[@id='503030']"));*/
					 /*WebElement ILP=driver.findElement(locator(Aprop.getProperty("admin_ILP")));
					 action.moveToElement(ILP).build().perform();
					 test.log(LogStatus.PASS, " Mouse hover on Title loan menu");*/
					 driver.findElement(By.linkText("Title Loan")).click();
					 Thread.sleep(3000);
					 driver.findElement(locator(Aprop.getProperty("admin_Download_NACHA"))).click();
					 test.log(LogStatus.PASS, " click on ACH Download_NACHA");
					 Thread.sleep(3000);
					
					    
				 driver.switchTo().defaultContent();
				 driver.switchTo().frame("mainFrame");
				 driver.switchTo().frame("main");
				 /*driver.findElement(locator(Aprop.getProperty("admin_str_nbr_btn"))).click();
				 driver.findElement(locator(Aprop.getProperty("admin_str_nbr"))).sendKeys(StoreID);
				 test.log(LogStatus.PASS, "StoreID is entered: "+StoreID);
				 System.out.println(NextDueDate);
				 test.log(LogStatus.PASS, "Age Store Date is :"+NextDueDate);*/
				
				   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
				   LocalDateTime now = LocalDateTime.now();  
				   String date=dtf.format(now);
				   System.out.println(dtf.format(now)); 
				   test.log(LogStatus.PASS, "Getting the Current System date "+date);
				 
				 Thread.sleep(5000);
				 String Due_Date[] =date.split("/");
			     String Due_Date1 = Due_Date[0];
			     String Due_Date2 = Due_Date[1];
			     String Due_Date3 = Due_Date[2];
			     driver.findElement(locator(Aprop.getProperty("begin_mon"))).click();
			     driver.findElement(locator(Aprop.getProperty("begin_mon"))).clear();
			     driver.findElement(locator(Aprop.getProperty("begin_mon"))).sendKeys(Due_Date1);
			        test.log(LogStatus.PASS, "Begin Month is entered: "+Due_Date1);
			        driver.findElement(locator(Aprop.getProperty("begin_date"))).clear();
			        driver.findElement(locator(Aprop.getProperty("begin_date"))).sendKeys(Due_Date2);
					test.log(LogStatus.PASS, "Begin Date is entered: "+Due_Date2);
					driver.findElement(locator(Aprop.getProperty("begin_year"))).clear();
					driver.findElement(locator(Aprop.getProperty("begin_year"))).sendKeys(Due_Date3);
					test.log(LogStatus.PASS, "Begin Year is entered: "+Due_Date3);
					 Thread.sleep(2000);
					driver.findElement(locator(Aprop.getProperty("end_month"))).clear();
					driver.findElement(locator(Aprop.getProperty("end_month"))).sendKeys(Due_Date1);
			        test.log(LogStatus.PASS, "End Month is entered: "+Due_Date1);
			        driver.findElement(locator(Aprop.getProperty("end_day"))).clear();
			        driver.findElement(locator(Aprop.getProperty("end_day"))).sendKeys(Due_Date2);
					test.log(LogStatus.PASS, "End Date is entered: "+Due_Date2);
					driver.findElement(locator(Aprop.getProperty("end_yearr"))).clear();
					driver.findElement(locator(Aprop.getProperty("end_yearr"))).sendKeys(Due_Date3);
					test.log(LogStatus.PASS, "End Year is entered: "+Due_Date3); 
					driver.findElement(locator(Aprop.getProperty("Download_Search"))).click();
					test.log(LogStatus.PASS, "Click on Search button ");
					
					NatchaFilename=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[2]/tbody/tr[4]/td[1]/a")).getText();
					test.log(LogStatus.PASS, "natcha file name is "+NatchaFilename);
					System.out.println("file is"+NatchaFilename);
					
					driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[2]/tbody/tr[4]/td[1]/a")).sendKeys("");
					test.log(LogStatus.PASS, "Click on Download File Link (First Row) ");
					Thread.sleep(5000);
					
					Robot robot =new Robot();
					robot.keyPress(KeyEvent.VK_ENTER);
			        robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(2000);
				        robot.keyPress(KeyEvent.VK_ALT);
				        robot.keyPress(KeyEvent.VK_S);
				        Thread.sleep(2000);
				        robot.keyRelease(KeyEvent.VK_S);
				        robot.keyRelease(KeyEvent.VK_ALT);
					
					
					 path="C:/Users/samatha.k/Downloads/";
					
					
					  File file = new File(path+NatchaFilename); 
					  
					  BufferedReader br = new BufferedReader(new FileReader(file)); 		  
					  String st=""; 		
					  int lines = 0;
					  while ((st = br.readLine()) != null) {
					   		    
					    if(lines==0){
					    	 st1=st.substring(13, 23);
							  StringBuilder sb = new StringBuilder(st);				
							  sb.insert(3, st1);
							  st1= sb.toString();
							  StringBuilder sb1 = new StringBuilder(st1);
							  sb1.replace(23,33,"");
							  st1= sb1.toString();
							  StringBuilder sb2 = new StringBuilder(st1);
							  sb2.replace(63,89,"WELLS FARGO BANK          ");
							  st1= sb2.toString();			 
							   System.out.println(st1);
							   lines++;
							   continue;
							
					    }
					   		    
					    if(lines==1)
					    {
					    	st2=st;
					    	 System.out.println(st2);
					    	 lines++;
					    	 continue;
				    	
					    }
					    
					    if(lines==2)
					    {
					    	
					    	StringBuilder sb3 = new StringBuilder(st);
					    	  sb3.replace(78,82,"1091");
					    	  st= sb3.toString();
					    	  //System.out.println(st);
					    	  StringBuilder sb4 = new StringBuilder(st);
					    	  sb4.replace(2,3,"6");
					    	  st= sb4.toString();
					    	  st3=st;
					    	 System.out.println(st3);
					    	 lines++;
					    	 continue;
						    			    	
					    }
					    if(lines==3)
					    {
					    	
					    	StringBuilder sb5 = new StringBuilder(st);
					    	
					    	  sb5.replace(9,10,"2");
					    	  st= sb5.toString();
					    	  st4=st;
					    	  System.out.println(st4);		    	  		    			    	 
					    	 lines++;
					    	 continue;			    			    	
					    }
					    if(lines==4)
					    {
					    	
					    	StringBuilder sb6 = new StringBuilder(st);
					    	  sb6.replace(20,21,"2");
					    	  st= sb6.toString();
					    	  st5=st;
					    	  System.out.println(st5);
					    	 lines++;
					    	 continue;
						    	//break;
					    	
					    }
					    if(lines==5)
					    {
					    	
					    	st6=st;
					    	 System.out.println(st6);
					    	 lines++;
					    	 continue;
					    	 		    	 		    	
					    }
					    if(lines==6)
					    {
					    	
					    	st7=st;
					    	 System.out.println(st7);
					    	 lines++;
					    	 continue;		    	 		    	 		    	
					    }
					    if(lines==7)
					    {
					    	st8=st;		    	 
					    	 System.out.println(st8);
					    	 lines++;
					    	 continue;		    	 		    	 		    	
					    }
					    if(lines==8)
					    {
					    	
					    	st9=st;
					    	 System.out.println(st9);
					    	 lines++;
					    	 continue;		    	 		    	    	
					    }
					    if(lines==9)
					    {
					    	
					    	st10=st;
					    	 System.out.println(st10);
					    	 lines++;
					    	break;		    	 
					    	 	    	
					    }
					 		
					  }
					  
					  				
					  FileWriter writer = new FileWriter(path+NatchaFilename);
	
					writer.write(st1+"\r\n"+st2+"\r\n"+st3+"\r\n"+"799R01091000010921561      04121501                                            113024160000001"+"\r\n"+st4+"\r\n"+st5+"\r\n"+st6+"\r\n"+st7+"\r\n"+st8+"\r\n"+st9+"\r\n"+st10);
					 writer.close();			
					
					test.log(LogStatus.PASS, "********************************************** ");
					break;
						 
					}
				
					}


}
	
	public static void 	ACHReturnProcess_UploadFile() throws InterruptedException{
		
		test.log(LogStatus.INFO, "ACH Processing through from Admin has initiated");
		driver.switchTo().defaultContent();	
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
		driver.switchTo().frame("topFrame");
		driver.findElement(locator(Aprop.getProperty("admin_ACH_transaction"))).click();		
		test.log(LogStatus.PASS, "Clicked on Transactions");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
	
		 Actions action = new Actions(driver);  
		 WebElement ACH=driver.findElement(locator(Aprop.getProperty("admin_ACH_menu")));
		 action.moveToElement(ACH).build().perform();
		 test.log(LogStatus.PASS, " Mouse hover on ACH menu");
		 Thread.sleep(2000);
		
		 /*WebElement ILP=driver.findElement(locator(Aprop.getProperty("admin_ILP")));
		 action.moveToElement(ILP).build().perform();
		 test.log(LogStatus.PASS, " Mouse hover on Installment loan menu");*/
		 driver.findElement(By.linkText("Title Loan")).click();
		 Thread.sleep(3000);
		 
		 driver.findElement(By.linkText("ACH Return Process(NACHA)")).click();
		 test.log(LogStatus.PASS, " Clicked on Ach retun process");
		 
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame("mainFrame");
		 driver.switchTo().frame("main");
		// C:\Users\shashidhar.g\Downloads\ACH_FILE_08122019_014740_QFUND.TXT
		//
		 //C:\Users\shashidhar.g\Downloads
		 path="C:\\Users\\samatha.k\\Downloads\\";
		// NatchaFilename="ACH_FILE_08122019_014740_QFUND.TXT";
		 driver.findElement(By.name("upFile")).sendKeys(path+NatchaFilename);
		// driver.findElement(By.name("upFile")).sendKeys("C:\\Users\\shashidhar.g\\Downloads\\ACH_FILE_08122019_014740_QFUND.TXT");
		 test.log(LogStatus.PASS, " File Uploaded");
		 
		 
		 driver.findElement(By.name("Submit")).click();
		 test.log(LogStatus.PASS, " Clicked on submit button");
		 driver.findElement(By.name("Submit")).click();
		 test.log(LogStatus.PASS, " Clicked on submit button on NACHA return page");
		 
	}
	 
}

package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
/*
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCAgestorevoid extends QCStore{
	

	public static String encryption_transaction;
	public static String encryption_store;
	

	public static void encryptionVoid(String SSN,String AppURL)
	{
		 
		try{
				int lastrow=TestData.getLastRow("New_Loan");
				String sheetName="New_Loan";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					encryption_store_no="1709";
							//TestData.getCellData(sheetName,"StoreID",row);
					if(SSN.equals(RegSSN))
					{

                            String TenderType=TestData.getCellData(sheetName, "TenderType", row);
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					  			       
					
			       Thread.sleep(4000);
					test.log(LogStatus.INFO, "Getting required details for encryption Key from CSR has initiated");

					driver.switchTo().frame("bottom");
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					String store_date[]=Str_date.split(":");
					test.log(LogStatus.PASS, ""+Str_date);
					
					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
				
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
					Thread.sleep(2000);
					for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    Thread.sleep(3000);
				   
				  
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
					
				for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 //driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   //driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				       String loan_Nbr = driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[8]/td[2]")).getText();                     
				       test.log(LogStatus.PASS, "Loan number " + loan_Nbr);
				       driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[8]/td[13]/input")).click();
					   test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					   
					    Thread.sleep(5000);
					    
					    
						 driver.findElement(By.name("transactionList")).sendKeys("Void");
						 test.log(LogStatus.PASS, "Transaction Type is selected as Void");
						 Thread.sleep(5000);
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 Thread.sleep(8000);
		
						 for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							
							 encryption_transaction=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td")).getText();
							 String TranID0[] =encryption_transaction.split(":");
							 String TranID1 = TranID0[0];
							 System.out.println(TranID1);
								encryption_transaction_nbr = TranID0[1].trim();
							test.log(LogStatus.PASS, "TranId captured:"+encryption_transaction_nbr); 
							test.log(LogStatus.PASS, "StoreId captured:"+encryption_store_no); 

									
							driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 Thread.sleep(500);
						 //driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/input[2]")).click();
						 driver.findElement(By.name("YES")).click();
						 test.log(LogStatus.PASS, "Clicked on Yes button under Encryption details");
						 test.log(LogStatus.PASS, "***************************************");
						 
						 AdminLoginForEncryption.getEncryption( driver, SSN, AppURL);
						 Thread.sleep(2000);
						 
						 driver.findElement(By.name("tenderType")).sendKeys(TenderType);
						 test.log(LogStatus.PASS, "tenderType selected as "+TenderType);
						 driver.findElement(By.name("requestBean.siilBean.encryptionKey")).sendKeys(Eankey);
						 test.log(LogStatus.PASS, "Encryption Key entered as"+Eankey);
						 Thread.sleep(1000);
						 driver.findElement(By.name("requestBean.password")).sendKeys("1234");
						 test.log(LogStatus.PASS, "password entered as 1234");
						 driver.findElement(By.name("finish")).click();
						 test.log(LogStatus.PASS, "clicked on finish void button");
						 driver.switchTo().alert().accept();
						 test.log(LogStatus.PASS, "clicked on alert ok button");
						 Thread.sleep(1000);
						 
						 
						 //driver.close();
						 Thread.sleep(1000);
						 

				break;

					}
									}
		}
							catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Reading Encryption from CSR is failed", ExtentColor.RED));
								test.log(LogStatus.INFO,""+e);
								test.log(LogStatus.FAIL, "Reading Encryption from CSR is failed");


							}




	}
				
	 
					}
				
		
	


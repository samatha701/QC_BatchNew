/*package tests;

import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import tests.QCStore;*/
//===================================================================================================
package tests;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;



public class QCCSRLoginLogout extends LendNation
{

	public static void login(String SSN,String AppURL) throws Exception
	/*{
		try{
			String FileName= prop.getProperty("file_name1");
			
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
				int lastrow=TestData.getLastRow("Login_Logout");
				String sheetName="Login_Logout";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					//String admin_url = TestData.getCellData(sheetName,"AdminURL",row);
*/
	
	
	
	
	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Login_Logout");
				String sheetName="Login_Logout";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String username = TestData.getCellData(sheetName,"UserName",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String application_status = TestData.getCellData(sheetName,"ApplicationStatus",row);
					String comments = TestData.getCellData(sheetName,"Comments",row);
					String last_four_account_no = TestData.getCellData(sheetName,"LastFourAccountNo",row);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					   //String  last_four_account_no=SSN.substring(SSN.length() - 4);


					if(SSN.equals(RegSSN))
					{	
				
						//test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);
						test.log(LogStatus.INFO, "Opened the CSR URL " +csr_url);


						//test.log(LogStatus.INFO, "CSR Application is launched " );
						test.log(LogStatus.INFO, "******* CSR Application is launched *******");

						driver = new InternetExplorerDriver();
						WebDriverWait wait = new WebDriverWait(driver, 30000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
					
						driver.get(csr_url);
						
					    driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username);
				        test.log(LogStatus.PASS, "Username is entered: "+username);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password);
				        test.log(LogStatus.PASS, "Password is entered: "+password);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");
				        
				       Thread.sleep(5000);
					
				    
						
					
		
		
		break;
	}
				}
		}
	
					catch(Exception e)
					  {
						  test.log(LogStatus.ERROR, "Unable to complete  CSR with SSN and Loan Number : " +SSN+","+loan_number);
						  test.log(LogStatus.ERROR, "Error message  " +e);
						  String screenshotPath = getScreenhot(driver, "QCCSRLoginLogout");
						  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
							System.out.println(e);
	
}
	}
	
	
	
	public static void PAMLogin(String SSN,String AppURL) throws Exception
	/*{
		try{
			String FileName= prop.getProperty("file_name1");
			
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
				int lastrow=TestData.getLastRow("PAM");
				String sheetName="PAM";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					//String admin_url = TestData.getCellData(sheetName,"AdminURL",row);
*/
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("PAM");
				String sheetName="PAM";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String username = TestData.getCellData(sheetName,"UserName",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String username2 = TestData.getCellData(sheetName,"UserName2",row);
					String password2 = TestData.getCellData(sheetName,"Password2",row);
					String store_id2 = TestData.getCellData(sheetName,"StoreID2",row);
					String application_status = TestData.getCellData(sheetName,"ApplicationStatus",row);
					String comments = TestData.getCellData(sheetName,"Comments",row);
					String last_four_account_no = TestData.getCellData(sheetName,"LastFourAccountNo",row);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
					
					   //String  last_four_account_no=SSN.substring(SSN.length() - 4);


					if(SSN.equals(RegSSN))
					{	
				
						//test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);
						test.log(LogStatus.INFO, "Opened the CSR URL " +csr_url);


						//test.log(LogStatus.INFO, "CSR Application is launched " );
						test.log(LogStatus.INFO, "*******CSR Application is launched For Loan Approval*******");

						driver = new InternetExplorerDriver();
						WebDriverWait wait = new WebDriverWait(driver, 30000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
					
						driver.get(csr_url);
						
					if(ReceiveType.equalsIgnoreCase("ACH"))	{
						
					    driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username);
				        test.log(LogStatus.PASS, "Username is entered: "+username);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password);
				        test.log(LogStatus.PASS, "Password is entered: "+password);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");
				        
				       Thread.sleep(5000);
					}
				    
					else if(ReceiveType.equalsIgnoreCase("Cash At Store")){
						driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username2);
				        test.log(LogStatus.PASS, "Username is entered: "+username2);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password2);
				        test.log(LogStatus.PASS, "Password is entered: "+password2);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id2);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id2);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");	
						
						
					}
					
		
		
		break;
	}
				}
		}
	
					catch(Exception e)
					  {
						  test.log(LogStatus.ERROR, "Unable to complete  CSR with SSN and Loan Number : " +SSN+","+loan_number);
						  test.log(LogStatus.ERROR, "Error message  " +e);
						  String screenshotPath = getScreenhot(driver, "QCCSRLoginLogout");
						  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
							System.out.println(e);
	
}
	}
	
//==================================== For Logout =============================================	
	
              public static void logout(String SSN,String AppURL){
							
				try{
					
					
					driver.switchTo().defaultContent();
					 driver.switchTo().frame("topFrame");
					 Thread.sleep(5000);		
			       //driver.findElement(locator(prop.getProperty(("csr_logout_link")))).click();
			     driver.findElement(By.xpath("//a[@href='/cc/logout.do']")).click();
			     test.log(LogStatus.PASS, "Clicked On logout Button");
			     if(driver.getTitle().contains("Login")){
			    	// test.log(LogStatus.PASS, "Logout is Successfully");
			    	 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Logout Successfully ");
			    	 test.log(LogStatus.INFO,"loggged out from the CSR Application");
			    	 Thread.sleep(5000);
			     driver.close();
			    	 //driver.quit();
			    	 Thread.sleep(5000);
			     }
			    else{
			    	 //test.log(LogStatus.PASS, "Logout was Successfull"); 
			    	 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Logout Successfully ");
			     }


			     	
			}
						
			
		
		
		catch(Exception e)
		{
			test.log(LogStatus.ERROR,"CSR logout is failed");

			e.printStackTrace();
		}
	
	
	
}	

//============================ For Admin Logout ===============================

public static void Adminlogout(String SSN,String AdminURL){
	try{
		
		
		driver.switchTo().defaultContent();
		 driver.switchTo().frame("topFrame");
		
driver.findElement(locator(prop.getProperty(("admin_logout_link")))).click();
     test.log(LogStatus.PASS, "Clicked On logout Button");
     if(driver.getTitle().contains("Login")){
    	 test.log(LogStatus.PASS, "Logout is Successfully"); 
    	 test.log(LogStatus.INFO,"loggged out from the Admin Application");
    	 Thread.sleep(5000);
     //driver.close();
    	 driver.quit();
     }
    else{
    	 test.log(LogStatus.PASS, "Logout was unsuccessfull"); 
     }


     	
}
			



catch(Exception e)
{
test.log(LogStatus.ERROR,"CSR logout is failed");

e.printStackTrace();
}
}
public static void ageStoreGraceDays(String SSN,String AppURL){
	int i;
	for(i=0;i<4;i++)
	{
		//String curr_url=driver.getCurrentUrl();
		//driver.navigate().back();
		//driver.get(csr_url);
		
		
		
		//System.out.println(curr_url);
	 
	try{
		//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("PAM");
			String sheetName="PAM";

				for(int row=2;row<=lastrow;row++)
						{		
							String RegSSN = TestData.getCellData(sheetName,"SSN",row);
							if(SSN.equals(RegSSN))
							{
						
							//String PIN = TestData.getCellData(sheetName,"PIN",row);
					       // System.out.println(Password);
					        //String StoreId = TestData.getCellData(sheetName,"StoreID",row);
					        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					
					       String AgeStore = TestData.getCellData(sheetName,"AgeStore",row);
					      
					
								  
							        String SSN1 = SSN.substring(0, 3);
							        String SSN2 = SSN.substring(3,5);
							        String SSN3 = SSN.substring(5,9);
							
							        
					       Thread.sleep(4000);
							      //test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
							/*test.log(LogStatus.INFO, "Age Store Grace days process is initiated");
							driver.switchTo().frame("bottom");
							String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
							String store_date[]=Str_date.split(":");
							String business_date=store_date[1].trim();
							test.log(LogStatus.PASS, "Business date is :"+business_date);*/

							driver.switchTo().defaultContent();	
							  Thread.sleep(4000);
					        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
							driver.switchTo().frame("topFrame");
							  Thread.sleep(4000);
							//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					        driver.findElement(By.cssSelector("li[id='910000']")).click();	
							/*driver.switchTo().defaultContent();				
							driver.switchTo().frame("topFrame");
							driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();	*/		
							test.log(LogStatus.PASS, "Clicked on Loan Transactions");
							Thread.sleep(1000);
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							Thread.sleep(1000);
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
						    
						    
						  // String loan_nbr= driver.findElement(locator(Rprop.getProperty("csr_loan_nbr"))).getText();
						  // test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						    driver.findElement(By.name("button")).click();
							test.log(LogStatus.PASS, "Clicked on GO Button under Search results");
							// driver.findElement(By.name("button")).click();
							
						for(String winHandle : driver.getWindowHandles()){
							    driver.switchTo().window(winHandle);
								}				    
							 driver.switchTo().defaultContent();
							    driver.switchTo().frame("mainFrame");
							    driver.switchTo().frame("main");
							   // driver.findElement(By.name("button")).click();
							    
							  if(ProductID.equals("PDL"))
								 {
								  driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
								  test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
							    }
							    if(ProductID.equals("TLP"))
								 {
							    	driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
								 }
							    
							    Thread.sleep(5000);
							    if(ProductID.equals("LOC"))
								 {
							    	///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
							    	 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
								 }
							   
							    Thread.sleep(5000);
							   // if(!(GraceDays.equals(null)))
							    {
									// NextDueDate = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form[1]/table[2]/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]")).getText();
									 
									 
	
							    }
							   // else 
							    {
									 //NextDueDate = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form[1]/table[2]/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]")).getText();
									
							    	 test.log(LogStatus.INFO, "Going to History to capture Transaction date");
							    	 driver.findElement(By.name("transactionList")).sendKeys("History");
									 test.log(LogStatus.PASS, "Transaction Type is selected as History");
									 Thread.sleep(1000);
									 driver.findElement(By.name("button")).click();
									 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
									 Thread.sleep(500);
									 //String Loan_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[9]/td/span[2]")).getText();
									 Loan_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[9]/td/span[2]")).getText();
									                                                 
									 test.log(LogStatus.PASS, "Loan Date is : " +Loan_Date);
									 Thread.sleep(500);
							    	 String Due_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
							    	                                                
							    	 test.log(LogStatus.PASS, "Due Date is : " +Due_Date);
							    	 Thread.sleep(500);
							    	
							    	
							    	int IAgeStore=Integer.parseInt(AgeStore);
							    	
									DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
									Date DDueDateminus1 = df.parse(Loan_Date);
									Calendar cal = Calendar.getInstance();
									cal.setTime(DDueDateminus1);
									cal.add(Calendar.DATE, IAgeStore);
									Date DDueDate1= cal.getTime();
									Loan_Date =df.format(DDueDate1);
									System.out.println(Loan_Date);									     
									test.log(LogStatus.PASS, "Age Store Date after increasing is :"+Loan_Date);
									
									
									//Date date = new Date();  				
								    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yy");  
								    String strDate= formatter.format(DDueDate1);  
								    System.out.println(strDate); 
								    test.log(LogStatus.PASS, "After AgeStore the Date is : " +strDate);
								    
								    Thread.sleep(1000);
								    
								   // String strDate="26-July-19";
									String store_date[]=strDate.split("-");
									String business_date=store_date[1].trim();
									System.out.println(business_date.toUpperCase()); 
									String ddate=business_date.toUpperCase();
									 //System.out.println();
									 
									int n = 3;		
									String s = ddate;
									System.out.println(s.substring(0,n));
									
									ArrayList<String> list = new ArrayList<>();
								    Proc_Date=store_date[0]+""+"-"+s.substring(0,n)+"-"+store_date[2];	      
								    System.out.println(Proc_Date);
								    test.log(LogStatus.PASS, "Age Store Date For Store Aging is :"+Proc_Date);
								    Thread.sleep(500);
								    
								    driver.close();
								    
								    Thread.sleep(1000);
								    
								    test.log(LogStatus.INFO, "******* Now Move To DB To Change The Store Date *******");
								    
								    AgeStore_DB.accounting(SSN, AppURL);
								    
								    Thread.sleep(1000);
								    								  
									     
							
							    }
							    
			
			
									 test.log(LogStatus.PASS,"Date taken");
									 test.log(LogStatus.PASS,"************************************************");

									 Thread.sleep(5000);
									 driver.close();
						
						break;
					 
				}
			}
		

	break; //for FOR loop		
	}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Borrower Registration is failed", ExtentColor.RED));
				//test.log(LogStatus.FAIL, "Age store is failed");
				//test.log(LogStatus.FAIL, " "+e);
				//test.log(LogStatus.INFO, "Age store Grace days process is initiated again due to Application sync issue");
				//continue;


			}

}
	/*if(i==3)
	{
		test.log(LogStatus.FAIL, "Age store Grace days is failed");

	}*/
}

public static void ageStoreDueDate(String SSN,String AppURL){
	int i;
	for(i=0;i<4;i++)
	{
		//String curr_url=driver.getCurrentUrl();
		//driver.navigate().back();
		//driver.get(csr_url);
		
		
		
		//System.out.println(curr_url);
	 
	try{
		//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("PAM");
			String sheetName="PAM";

				for(int row=2;row<=lastrow;row++)
						{		
							String RegSSN = TestData.getCellData(sheetName,"SSN",row);
							if(SSN.equals(RegSSN))
							{
						
							//String PIN = TestData.getCellData(sheetName,"PIN",row);
					       // System.out.println(Password);
					        //String StoreId = TestData.getCellData(sheetName,"StoreID",row);
					        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					
					       String AgeStore_DueDate = TestData.getCellData(sheetName,"AgeStore_DueDate",row);
					      
					
								  
							        String SSN1 = SSN.substring(0, 3);
							        String SSN2 = SSN.substring(3,5);
							        String SSN3 = SSN.substring(5,9);
							
							        
					       Thread.sleep(4000);
							      //test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
							/*test.log(LogStatus.INFO, "Age Store Grace days process is initiated");
							driver.switchTo().frame("bottom");
							String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
							String store_date[]=Str_date.split(":");
							String business_date=store_date[1].trim();
							test.log(LogStatus.PASS, "Business date is :"+business_date);*/

							driver.switchTo().defaultContent();	
							  Thread.sleep(4000);
					        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
							driver.switchTo().frame("topFrame");
							  Thread.sleep(4000);
							//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					        driver.findElement(By.cssSelector("li[id='910000']")).click();	
							/*driver.switchTo().defaultContent();				
							driver.switchTo().frame("topFrame");
							driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();	*/		
							test.log(LogStatus.PASS, "Clicked on Loan Transactions");
							Thread.sleep(1000);
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							Thread.sleep(1000);
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
						    
						    
						  // String loan_nbr= driver.findElement(locator(Rprop.getProperty("csr_loan_nbr"))).getText();
						  // test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						    driver.findElement(By.name("button")).click();
							test.log(LogStatus.PASS, "Clicked on GO Button under Search results");
							// driver.findElement(By.name("button")).click();
							
						for(String winHandle : driver.getWindowHandles()){
							    driver.switchTo().window(winHandle);
								}				    
							 driver.switchTo().defaultContent();
							    driver.switchTo().frame("mainFrame");
							    driver.switchTo().frame("main");
							   // driver.findElement(By.name("button")).click();
							    
							  if(ProductID.equals("PDL"))
								 {
								  driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
								  test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
							    }
							    if(ProductID.equals("TLP"))
								 {
							    	driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
								 }
							    
							    Thread.sleep(5000);
							    if(ProductID.equals("LOC"))
								 {
							    	///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
							    	 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
								 }
							   
							    Thread.sleep(5000);
							   // if(!(GraceDays.equals(null)))
							    {
									// NextDueDate = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form[1]/table[2]/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]")).getText();
									 
									 
	
							    }
							   // else 
							    {
									 //NextDueDate = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form[1]/table[2]/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]")).getText();
									
							    	 test.log(LogStatus.INFO, "Going to History to capture Transaction date");
							    	 driver.findElement(By.name("transactionList")).sendKeys("History");
									 test.log(LogStatus.PASS, "Transaction Type is selected as History");
									 Thread.sleep(1000);
									 driver.findElement(By.name("button")).click();
									 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
									 Thread.sleep(500);
									 String Loan_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[9]/td/span[2]")).getText();
									 test.log(LogStatus.PASS, "Loan Date is : " +Loan_Date);
									 Thread.sleep(500);
							    	 Due_Date = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
							    	 test.log(LogStatus.PASS, "Due Date is : " +Due_Date);
							    	 Thread.sleep(500);
							    	
							    	/*int IAgeStore_DueDate=Integer.parseInt(AgeStore_DueDate);
							    	
									DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
									Date DDueDateminus1 = df.parse(Due_Date);
									Calendar cal = Calendar.getInstance();
									cal.setTime(DDueDateminus1);
									cal.add(Calendar.DATE, IAgeStore_DueDate);
									Date DDueDate1= cal.getTime();
									Due_Date =df.format(DDueDate1);
									System.out.println(Due_Date);									     
									test.log(LogStatus.PASS, "Age Store Date after increasing is :"+Due_Date);*/
							    	 
							    	 //SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yy");  
									 DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");									 
									 Date DDueDateminus1 = df.parse(Due_Date);
									 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yy");  
									 String strDate= formatter.format(DDueDateminus1);  
									 System.out.println(strDate); 
									 test.log(LogStatus.PASS, "After AgeStore to Due Date the Date is : " +strDate);
									
									
									//Date date = new Date();  				
								  /*  SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yy");  
								    String strDate= formatter.format(Due_Date);  
								    System.out.println(strDate); 
								    test.log(LogStatus.PASS, "After AgeStore to Due Date the Date is : " +strDate);*/
								    
								    Thread.sleep(1000);
						    
								   // String strDate="26-July-19";
									String store_date1[]=strDate.split("-");
									String business_date1=store_date1[1].trim();
									System.out.println(business_date1.toUpperCase()); 
									String ddate=business_date1.toUpperCase();
									 //System.out.println();
									 
									int n = 3;		
									String s = ddate;
									System.out.println(s.substring(0,n));
									
									ArrayList<String> list = new ArrayList<>();
								    App_Due_Date=store_date1[0]+""+"-"+s.substring(0,n)+"-"+store_date1[2];	      
								    System.out.println(App_Due_Date);
								    test.log(LogStatus.PASS, "Age Store Date For Store Aging is :"+App_Due_Date);
								    Thread.sleep(500);
								    
								    driver.close();
								    
								    Thread.sleep(1000);
								    
								    test.log(LogStatus.INFO, "******* Now Move To DB To Change The Store Date *******");
								    
								    AgeStore_DB.accounting_Duedate(SSN, AppURL);
								    
								    Thread.sleep(1000);
								    								  
									     
							
							    }
							    
			
			
									 test.log(LogStatus.PASS,"Date taken");
									 test.log(LogStatus.PASS,"************************************************");

									 Thread.sleep(5000);
									 driver.close();
						
						break;
					 
				}
			}
		

	break; //for FOR loop		
	}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Borrower Registration is failed", ExtentColor.RED));
				//test.log(LogStatus.FAIL, "Age store is failed");
				//test.log(LogStatus.FAIL, " "+e);
				//test.log(LogStatus.INFO, "Age store Grace days process is initiated again due to Application sync issue");
				//continue;


			}

}
	if(i==3)
	{
		test.log(LogStatus.FAIL, "Age store Grace days is failed");

	}
}


//===============================================================================






}



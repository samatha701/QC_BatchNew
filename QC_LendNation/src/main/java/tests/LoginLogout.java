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


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;



public class LoginLogout extends LendNation
{

	public static void csrLogin(String SSN,String AppURL) throws Exception
	{
		try{
			String FileName= prop.getProperty("file_name");
			
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
				int lastrow=TestData.getLastRow("Login");
				String sheetName="Login";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String csr_url = TestData.getCellData(sheetName,"CSRURL",row);

					String username = TestData.getCellData(sheetName,"Username",row);
					String Pwd = TestData.getCellData(sheetName,"Pwd",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
										
					if(SSN.equals(RegSSN))
					{	
						test.log(LogStatus.INFO, "Opened the CSR URL " +csr_url);

						test.log(LogStatus.INFO, "*******CSR Application is launched For Loan Approval*******");

						driver = new InternetExplorerDriver();
						WebDriverWait wait = new WebDriverWait(driver, 30000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
					
						driver.get(csr_url);
						
					    driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username);
				        test.log(LogStatus.PASS, "Username is entered: "+username);				        				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(Pwd);
				        test.log(LogStatus.PASS, "Password is entered: "+Pwd);
				        				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");
				        test.log(LogStatus.PASS, "<FONT color=green style=Arial> Login Successfully ");
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
	//=======================Online_Login===========================
	  public static void onlineLogin(String SSN,String AppURL) throws Exception{
		  try{
				String FileName= prop.getProperty("file_name");
				
				ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
					int lastrow=TestData.getLastRow("Login");
					String sheetName="Login";

					for(int row=2;row<=lastrow;row++)
					{		
						String RegSSN = TestData.getCellData(sheetName,"SSN",row);
						String OnlineURL = TestData.getCellData(sheetName,"OnlineURL",row);
						String Password = TestData.getCellData(sheetName,"Password",row);
						String email = TestData.getCellData(sheetName,"Email",row);
						String state = TestData.getCellData(sheetName,"State",row);
											
						if(SSN.equals(RegSSN))
						{	

							test.log(LogStatus.INFO, "Opened the Online URL " +OnlineURL);
							test.log(LogStatus.INFO, "*******ONline Application is launched For Loan Approval*******");

							driver=new ChromeDriver();
							driver.manage().window().maximize();
							driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
							WebDriverWait wait = new WebDriverWait(driver, 5000);	
							
							driver.get(OnlineURL);
							
							 Thread.sleep(2000);

							  driver.findElement(By.linkText("QTP")).click();	
							  test.log(LogStatus.PASS, "Clicked on QTP link ");
							  Thread.sleep(3000);
							  new Select(driver.findElement(By.xpath("//select[starts-with(@class,'form-control')]"))).selectByVisibleText(state);
							  test.log(LogStatus.PASS, "Selected the State : "+state);
							  
							  driver.findElement(locator(prop.getProperty("continue_button"))).click();
							  test.log(LogStatus.PASS, "Clicked on Continue button ");
							  Thread.sleep(2000);
							  driver.findElement(By.id("loginCaption")).click();	
							  test.log(LogStatus.PASS, "Clicked on login link ");
							  
							  driver.findElement(By.id("Username")).sendKeys(email);
						        test.log(LogStatus.PASS, "Username is entered: "+email);				        				        

							    driver.findElement(By.id("Password")).sendKeys(Password);
						        test.log(LogStatus.PASS, "Password is entered: "+Password);

							  driver.findElement(By.id("loginbtn")).click();	
							  test.log(LogStatus.PASS, "Clicked on login button ");
							  test.log(LogStatus.PASS, "<FONT color=green style=Arial> Login Successfully ");
							 Thread.sleep(5000);	
								
								break;

						}}}	catch(Exception e)
		  {
							  test.log(LogStatus.ERROR, "Unable to complete Online with SSN and Loan Number : " +SSN+","+loan_number);
							  test.log(LogStatus.ERROR, "Error message  " +e);
							  String screenshotPath = getScreenhot(driver, "QCCSRLoginLogout");
							  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
								System.out.println(e);
		
	}

}	
	//=======================Online_Logout===========================
	  public static void onlineLogout(String SSN,String AppURL) throws Exception{
		  try{
			  
			  Thread.sleep(500);
				
			  driver.findElement(By.id("login-down-arrow")).click();	
			  test.log(LogStatus.PASS, "Clicked on logout link ");
			  
			  Thread.sleep(500);
			  driver.findElement(By.xpath("//ul/li[2]/a[@ng-click='logout()']")).click();	
			  test.log(LogStatus.PASS, "Clicked on logout button ");
			  test.log(LogStatus.PASS, "<FONT color=green style=Arial> Logout Successfully ");
			  Thread.sleep(3000);
			  driver.close();
			  
				}	catch(Exception e)
		  {
							
					test.log(LogStatus.ERROR,"Online logout is failed");

					e.printStackTrace();
		
	}

}	
//==================================== For Logout =============================================	
	
              public static void csrLogout(String SSN,String AppURL){
							
				try{
					
					
					driver.switchTo().defaultContent();
					 driver.switchTo().frame("topFrame");
					 Thread.sleep(5000);		
			     driver.findElement(By.xpath("//a[@href='/cc/logout.do']")).click();
			     test.log(LogStatus.PASS, "Clicked On logout Button");
			     if(driver.getTitle().contains("Login")){
			    	 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Logout Successfully ");
			    	 test.log(LogStatus.INFO,"loggged out from the CSR Application");
			    	 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Logout Successfully ");
			    	 Thread.sleep(5000);
			     driver.close();
			    	 //Thread.sleep(10000);
			     }
			    else{
			    	 test.log(LogStatus.FAIL, "<FONT color=red style=Arial> Logout Not Successfully ");
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
}

//}

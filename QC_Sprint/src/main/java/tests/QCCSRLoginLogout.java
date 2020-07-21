package tests;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class QCCSRLoginLogout extends QCStore
{
	
	public static void login(String SSN,String AppURL) throws InterruptedException
	{
		 		 
				int lastrow=TestData.getLastRow("Login");
				String sheetName="Login";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String username = TestData.getCellData(sheetName,"UserName",row);						
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					AppURL=prop.getProperty("CSR_URL");
											

					if(SSN.equals(RegSSN))
					{	
				
						Thread.sleep(4000);
		
						test.log(LogStatus.INFO, "<FONT color=green style=Calibri > Opened the CSR URL " +AppURL);

						test.log(LogStatus.INFO, "CSR Application is launched " );					
						if(prop.getProperty("login_method").equalsIgnoreCase("local"))
						{
							driver = new InternetExplorerDriver();
						}
						else
						{
							String Node = "http://192.168.2.164:5555/wd/hub";
							
							Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
                            String browserName = cap.getBrowserName();
                            reports.addSystemInfo("Browser",browserName);

						}
						 wait = new WebDriverWait(driver, 40000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
						driver.get(AppURL);
			
						
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
				        
				       Thread.sleep(4000);
				       break;
}
					
	}
	
}
	public static void login2997(String SSN,String AppURL) throws InterruptedException
	{
		 		 
				int lastrow=TestData.getLastRow("Login");
				String sheetName="Login";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					//String username = TestData.getCellData(sheetName,"UserName",row);						
					//String password = TestData.getCellData(sheetName,"Password",row);
					//String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String username = "admin";
					String password = "advance";
					String store_id = "2997";
					AppURL=prop.getProperty("CSR_URL");
											
                    if(SSN.equals(RegSSN))
					{	
				
						Thread.sleep(4000);
		
						test.log(LogStatus.INFO, "<FONT color=green style=Calibri > Opened the CSR URL " +AppURL);

						test.log(LogStatus.INFO, "CSR Application is launched " );					
						if(prop.getProperty("login_method").equalsIgnoreCase("local"))
						{
							driver = new InternetExplorerDriver();
						}
						else
						{
							String Node = "http://192.168.2.164:5555/wd/hub";
							
							Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
                            String browserName = cap.getBrowserName();
                            reports.addSystemInfo("Browser",browserName);

						}
						 wait = new WebDriverWait(driver, 40000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
						driver.get(AppURL);
			
						
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
				        
				       Thread.sleep(4000);
				       break;
}
					
	}
	

}
	
public static void logout(String SSN,String AppURL){
		
			driver.switchTo().defaultContent();
			driver.switchTo().frame("topFrame");
					
			driver.findElement(locator(prop.getProperty(("csr_logout_link")))).click();
			     test.log(LogStatus.PASS, "Clicked On logout Button");
			     {
			    	 test.log(LogStatus.PASS, "Logout is Successfully"); 
			    	
			    	 test.log(LogStatus.INFO, "loggged out from the CSR Application");

			     driver.quit();
			     }
			   


			     	
			}
						
public static void adminLogin(String SSN,String AppURL) throws MalformedURLException{
					
			 int lastrow=TestData.getLastRow("Login");
			 String sheetName="Login";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
				String UserName = "admin";
				String Password = "advance";
				AdminURL=prop.getProperty("ADMIN_CSR_URL");
				test.log(LogStatus.INFO, "********Admin Application is launched********");
                if(prop.getProperty("login_method").equalsIgnoreCase("local"))
				{
					driver = new InternetExplorerDriver();
				}
				else
				{
					String Node = "http://192.168.2.164:5555/wd/hub";
					 
					 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
					 driver = new RemoteWebDriver(new URL(Node), cap);	
				}
				wait = new WebDriverWait(driver, 40000);

				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
				driver.get(AdminURL);

				driver.findElement(By.name("loginRequestBean.userId")).sendKeys(UserName);

				test.log(LogStatus.PASS, "Username is entered: "+UserName); 

				driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

				test.log(LogStatus.PASS, "Password is entered: "+Password); 

				

				driver.findElement(By.name("login")).click();

				test.log(LogStatus.PASS, "Clicked on Submit button");
				break;
           }
					
         }
   }	
	public static void adminLogout(WebDriver driver,String SSN,String AppURL) throws Exception{
		
		     driver.switchTo().defaultContent();
			 driver.switchTo().frame("topFrame");
			
	      driver.findElement(locator(prop.getProperty(("admin_logout_link")))).click();
	     test.log(LogStatus.PASS, "Clicked On logout Button");
	     if(driver.getTitle().contains("Login")){
	    	 test.log(LogStatus.PASS, "Logout is Successfully"); 
	    	
	    	 test.log(LogStatus.INFO, "loggged out from the Admin Application");

	     driver.close();
	     }
	    else{
	    	 test.log(LogStatus.FAIL, "Logout was unsuccessfull"); 
	     }


	     	
	}
				
}
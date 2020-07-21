package QCHome;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;
public class QCAdminLoginLogout extends CSR {


	public static void adminlogin() throws InterruptedException
	{
		
			
		test.log(LogStatus.PASS, "********Performing Login functionality********");
		
		String sheetName="AdminCred";
		//int lastrow=TestData.getLastRow("Smoke");


				String uname=TestData.getCellData(sheetName,"UserName",2);
		
				passwrd=TestData.getCellData(sheetName,"Password",2);
				String Storeid=TestData.getCellData(sheetName,"StoreID",2);
				String url=TestData.getCellData(sheetName,"APPURL",2);
				
				driver.get("http://192.168.2.203/cc/adminIndex.do");
				test.log(LogStatus.PASS, "Application Launched with URL :"+url);
			
				String passwordId = "loginRequestBean.password";
				String StoreId = "loginRequestBean.locNbr";
				String Login = "login";		
				driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(uname);
				test.log(LogStatus.PASS, "Username is entered: "+uname);

				driver.findElement(By.name(passwordId)).sendKeys(passwrd);;
				test.log(LogStatus.PASS, "Password is entered: "+passwrd);	        	       
				/*driver.findElement(By.name(StoreId)).sendKeys(Storeid);;
				test.log(LogStatus.PASS, "Storenumber is entered: "+Storeid);*/
				//Click Login Button
				driver.findElement(By.name(Login)).click();
				test.log(LogStatus.PASS, "Clicked on Submit ");

				test.log(LogStatus.INFO, "<FONT color=green> Login Sucessfully");
				test.log(LogStatus.INFO, "******************************************************** ");

			

				
			
		
	}
	public static void logout()
	{

		try{

			driver.switchTo().defaultContent();
			driver.switchTo().frame("topFrame");

			driver.findElement(locator(prop.getProperty(("admin_logout_link")))).click();
			test.log(LogStatus.PASS, "Clicked On logout Button");
			System.out.println("clicked on logout"); 

			if(driver.getTitle().contains("Login")){
				test.log(LogStatus.PASS, "Logout is Successfully"); 
				test.log(LogStatus.INFO, "************************************************************");
				//driver.close();
			}
			else{
				test.log(LogStatus.PASS, "Logout was unsuccessfull"); 
			}

		}		
		catch (Exception e) {
			test.log(LogStatus.FAIL,"admin login is failed");
			e.printStackTrace();
		}
	}
}

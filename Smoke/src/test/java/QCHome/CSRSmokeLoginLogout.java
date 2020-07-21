package QCHome;
//This class contains methods for login and logout functionality

import org.openqa.selenium.By;


import com.relevantcodes.extentreports.LogStatus;

public class CSRSmokeLoginLogout extends CSR{
	public static void csrlogin() throws Exception{

		test.log(LogStatus.PASS, "********Performing Login functionality********");
			
			String sheetName="Smoke";
			int lastrow=TestData.getLastRow("Smoke");

					String uname=TestData.getCellData(sheetName,"Login",2);
			
					passwrd=TestData.getCellData(sheetName,"Login",3);
					String Storeid=TestData.getCellData(sheetName,"Login",4);
					String url=TestData.getCellData(sheetName,"APPURL",2);
					
					//driver.get(url);
					driver.get("http://192.168.2.203/cc/demoIndex.do");
					test.log(LogStatus.PASS, "Application Launched with URL :"+url);
				
					String passwordId = "loginRequestBean.password";
					String StoreId = "loginRequestBean.locNbr";
					String Login = "login";		
					driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(uname);
					test.log(LogStatus.PASS, "Username is entered: "+uname);

					driver.findElement(By.name(passwordId)).sendKeys(passwrd);;
					test.log(LogStatus.PASS, "Password is entered: "+passwrd);	        	       
					driver.findElement(By.name(StoreId)).sendKeys(Storeid);;
					test.log(LogStatus.PASS, "Storenumber is entered: "+Storeid);
					//Click Login Button
					driver.findElement(By.name(Login)).click();
					test.log(LogStatus.PASS, "Clicked on Submit ");

					test.log(LogStatus.INFO, "<FONT color=green> Login Sucessfully");
					test.log(LogStatus.INFO, "******************************************************** ");
Thread.sleep(2000);
				

			
	}
	public static void logout(){

		try{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("topFrame");

			driver.findElement(By.xpath("//*[@id='icons']/li[7]/a")).click();
			test.log(LogStatus.PASS, "Clicked On logout Button");
			if(driver.getTitle().contains("Login")){
				test.log(LogStatus.PASS, "<FONT color=green> Logout Successfully"); 
				test.log(LogStatus.INFO, "******************************************************** ");
				//driver.close();
			}
			else{
				test.log(LogStatus.PASS, "<FONT color=Red> Logout was unsuccessfull"); 
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}}


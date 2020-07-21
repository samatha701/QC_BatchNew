package QCHome;
//This class contains methods for login and logout functionality

import org.openqa.selenium.By;


import com.relevantcodes.extentreports.LogStatus;

public class CSRLoginLogout extends CSR{
	public static void login(String SSN,String AppURL ) throws Exception{

		test.log(LogStatus.PASS, "********Performing Login functionality********");
			test.log(LogStatus.PASS, "Getting values from file"+FileName);
			String sheetName="Login";
			int lastrow=TestData.getLastRow("Login");

			for(int row=2;row<=lastrow;row++){

				String RegSSN = TestData.getCellData(sheetName,"SSN",row);

				if(SSN.equals(RegSSN))

				{
					String uname=TestData.getCellData(sheetName,"UserName",row);
					passwrd=TestData.getCellData(sheetName,"Password",row);
					String Storeid=TestData.getCellData(sheetName,"StoreID",row);

					//driver.get(AppURL);
					driver.get("http://192.168.2.203/cc/demoIndex.do");
					test.log(LogStatus.PASS, "Application Launched with URL :"+AppURL);
					// String usenameId = "loginRequestBean.userId";
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
					test.log(LogStatus.PASS, "Clicked on Submit button");

					test.log(LogStatus.INFO, "<FONT color=green> Login Sucessfully");
					test.log(LogStatus.INFO, "******************************************************** ");
Thread.sleep(2000);
					break;
				}	

			}
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


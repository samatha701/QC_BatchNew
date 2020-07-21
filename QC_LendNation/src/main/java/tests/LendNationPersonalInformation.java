package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;

public class LendNationPersonalInformation extends LendNation{
	@Test (priority=2)  
	  public static void personalInformation(String SSN,String AppURL) throws Exception
	  
	  {
			 
			try{
				//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
				
				//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
					int lastrow=TestData.getLastRow("Personal Information");
					String sheetName="Personal Information";

					for(int row=2;row<=lastrow;row++)
					{		
						String RegSSN = TestData.getCellData(sheetName,"SSN",row);
						
				if(SSN.equals(RegSSN))
				{	
		  
		  //Personal Information
				
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String middlename = TestData.getCellData(sheetName,"MiddleName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				
				String pphone = TestData.getCellData(sheetName,"PrimaryPhone",row);
				String sphone = TestData.getCellData(sheetName,"SecondaryPhone",row);
				String aphone = TestData.getCellData(sheetName,"AlternativePhone",row);
				String pphonetype = TestData.getCellData(sheetName,"PphoneType",row);
				String sphonetype = TestData.getCellData(sheetName,"SphoneType",row);
				String aphonetype = TestData.getCellData(sheetName,"AphoneType",row);
				
				String Paddress = TestData.getCellData(sheetName,"Paddress",row);
				String Pcity = TestData.getCellData(sheetName,"Pcity",row);
				String Ppostalcode = TestData.getCellData(sheetName,"Ppostalcode",row);
				String PstateName = TestData.getCellData(sheetName,"PstateName",row);
				String PhomeType = TestData.getCellData(sheetName,"PhomeType",row);
				String PtymeAtAddress = TestData.getCellData(sheetName,"PtymeAtAddress",row);
				
				String date_of_birth = TestData.getCellData(sheetName,"DOB",row);
				String DOB[] =date_of_birth.split("/");
		        String DOB1 = DOB[0];
		        String DOB2 = DOB[1];
		        String DOB3 = DOB[2];
				String Identification = TestData.getCellData(sheetName,"Identification",row);
				
				String IDNumber = TestData.getCellData(sheetName,"IDNumber",row);
				String date_of_exp = TestData.getCellData(sheetName,"IDExpDate",row);
				String DOE[] =date_of_exp.split("/");
		        String DOE1 = DOE[0];
		        String DOE2 = DOE[1];
		        String DOE3 = DOE[2];

		        
				String ReferenceFirstNameA = TestData.getCellData(sheetName,"ReferenceFirstNameA",row);
				String ReferenceLastNameA = TestData.getCellData(sheetName,"ReferenceLastNameA",row);
				String RelationA = TestData.getCellData(sheetName,"RelationA",row);
				String PhoneA = TestData.getCellData(sheetName,"PhoneA",row);
				String ReferenceFirstNameB = TestData.getCellData(sheetName,"ReferenceFirstNameB",row);
				String ReferenceLastNameB = TestData.getCellData(sheetName,"ReferenceLastNameB",row);
				String RelationB = TestData.getCellData(sheetName,"RelationB",row);
				String PhoneB = TestData.getCellData(sheetName,"PhoneB",row);

				//test.log(LogStatus.INFO, "Lend Nation application navigated to Personal Information page  ");
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Personal Information page*******");

          Thread.sleep(5000);
		  driver.findElement(locator(prop.getProperty("firstname_field"))).sendKeys(firstname);
			test.log(LogStatus.PASS, "Entered first name  :  " + firstname);

		  driver.findElement(locator(prop.getProperty("middlename_field"))).sendKeys(middlename);
			test.log(LogStatus.PASS, "Entered middle name  : " + middlename);

		  driver.findElement(locator(prop.getProperty("lastname_field"))).sendKeys(lastname);
			test.log(LogStatus.PASS, "Entered last name  : " +  lastname);

		  driver.findElement(locator(prop.getProperty("Military_check_option_No"))).click();
			test.log(LogStatus.PASS, "Selected Military option as No  ");

		  
		  driver.findElement(locator(prop.getProperty("primary_phone"))).sendKeys(pphone);
			test.log(LogStatus.PASS, "Entered primary number : "+pphone);

		  new Select(driver.findElement(locator(prop.getProperty("primary_phone_type")))).selectByVisibleText(pphonetype);
			test.log(LogStatus.PASS, "Selected Primary phone type as   "+  pphonetype);

		  driver.findElement(locator(prop.getProperty("seondary_phone"))).sendKeys(sphone);
			test.log(LogStatus.PASS, "Entered secondary phone number : "+sphone);

		  new Select(driver.findElement(locator(prop.getProperty("secondary_phone_type")))).selectByVisibleText(sphonetype);
			test.log(LogStatus.PASS, "Selected secondary phone type as  " + sphonetype);

		  driver.findElement(locator(prop.getProperty("alternative_phone"))).sendKeys(aphone);
			test.log(LogStatus.PASS, "Alternative phone No  " + aphone);

		  new Select(driver.findElement(locator(prop.getProperty("alternative_phone_type")))).selectByVisibleText(aphonetype);
			test.log(LogStatus.PASS, "Selected Alternative phone type as "+ aphonetype);

		  
		  driver.findElement(locator(prop.getProperty("marketing_call_checkbox_NO"))).click();
			test.log(LogStatus.PASS, "Selected Marketing button check box as No  ");

		  driver.findElement(locator(prop.getProperty("address"))).sendKeys(Paddress);
			test.log(LogStatus.PASS, "Entered Address as  "+ Paddress);

		  driver.findElement(locator(prop.getProperty("city_field"))).sendKeys(Pcity);
			test.log(LogStatus.PASS, "Entered City as   "+ Pcity);

		  driver.findElement(locator(prop.getProperty("postal_code_field"))).sendKeys(Ppostalcode);
			test.log(LogStatus.PASS, "Entered Postal code as " + Ppostalcode);

		 
		  new Select(driver.findElement(locator(prop.getProperty("state_name_field")))).selectByVisibleText(PstateName);
			test.log(LogStatus.PASS, "Selected State as   "+ PstateName);

		  new Select(driver.findElement(locator(prop.getProperty("home_type")))).selectByVisibleText(PhomeType);
			test.log(LogStatus.PASS, "Selected Home type as "+ PhomeType);

		  new Select(driver.findElement(locator(prop.getProperty("time_at_address")))).selectByVisibleText(PtymeAtAddress);
			test.log(LogStatus.PASS, "Selected time at address as  " + PtymeAtAddress);

		  // Time at address
		  
		  //Date of birth entering
		  driver.findElement(locator(prop.getProperty("dob_month_field"))).sendKeys(DOB1);
		  driver.findElement(locator(prop.getProperty("dob_day_field"))).sendKeys(DOB2);
		  driver.findElement(locator(prop.getProperty("dob_year_field"))).sendKeys(DOB3);
			test.log(LogStatus.PASS, "Entered DOB as  :"+ date_of_birth);

		  
		  //Identification selection
		  driver.findElement(locator(prop.getProperty("identification_field"))).sendKeys(Identification);
			test.log(LogStatus.PASS, "Entered identification  :"+ Identification);


	//entering id number
		  driver.findElement(locator(prop.getProperty("identification_no"))).sendKeys(IDNumber);
			test.log(LogStatus.PASS, "Entered ID No as "+ IDNumber);

		  driver.findElement(locator(prop.getProperty("doe_month_field"))).sendKeys(DOE1);
		  driver.findElement(locator(prop.getProperty("doe_day_field"))).sendKeys(DOE2);
		  driver.findElement(locator(prop.getProperty("doe_year_field"))).sendKeys(DOE3);
			test.log(LogStatus.PASS, "Entered Expiry date as  "+ date_of_exp);

	 //1st Reference details entering 
		  
		  driver.findElement(locator(prop.getProperty("first_reference_name"))).sendKeys(ReferenceFirstNameA);
			test.log(LogStatus.PASS, "Entered first reference name as  "+ ReferenceFirstNameA);

		  driver.findElement(locator(prop.getProperty("first_reference_lastname"))).sendKeys(ReferenceLastNameA);
			test.log(LogStatus.PASS, "Entered first reference last name as  "+ ReferenceLastNameA);

			driver.findElement(locator(prop.getProperty("first_reference_relation"))).sendKeys(RelationA);
			test.log(LogStatus.PASS, "Entered first reference relation as  "+ RelationA);

		  driver.findElement(locator(prop.getProperty("first_reference_phone"))).sendKeys(PhoneA);
			test.log(LogStatus.PASS, "Entered first reference phone number  as  "+ PhoneA);
		  
		  //2nd Reference details entering 
		  
		  driver.findElement(locator(prop.getProperty("second_reference_name"))).sendKeys(ReferenceFirstNameB);
			test.log(LogStatus.PASS, "Entered second reference name as  "+ ReferenceFirstNameB);

			driver.findElement(locator(prop.getProperty("second_reference_lastname"))).sendKeys(ReferenceLastNameB);
			test.log(LogStatus.PASS, "Entered second reference last name as  "+ ReferenceLastNameB);

			driver.findElement(locator(prop.getProperty("second_reference_relation"))).sendKeys(RelationB);
			test.log(LogStatus.PASS, "Entered second reference relation as  "+ RelationB);

			driver.findElement(locator(prop.getProperty("second_reference_phone"))).sendKeys(PhoneB);
			test.log(LogStatus.PASS, "Entered second reference phone number  as  "+ PhoneB);

			Thread.sleep(3000);
			
					
			//js.executeScript("window.scrollBy(0,1000)");

			//System.out.println("start scroll");
			//test.log(LogStatus.PASS, "scrolled under the document  ");

			//driver.findElement(By.id("scrollDiv1")).click();
			//driver.findElement(By.id("scrollDiv1")).sendKeys(Keys.ARROW_DOWN);
			//driver.findElement(By.id("scrollDiv1")).sendKeys(Keys.ARROW_DOWN);

			driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();

			//JavascriptExecutor js = (JavascriptExecutor) driver;



			WebElement element = driver.findElement(locator(prop.getProperty("first_scrolling_area")));

			Actions action = new Actions(driver);

			action.moveToElement(element);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Viewed Electronic Consent by scrolling down the document ");

			Thread.sleep(1000);
			//driver.findElement(locator(prop.getProperty("first_scroll_area_checkbox"))).click();
			driver.findElement(By.xpath("//*[@id='chk3']")).click();
			test.log(LogStatus.PASS, "Accepted the Electonic consent by checking the checkbox  ");

			Thread.sleep(2000);
			
			
			driver.findElement(locator(prop.getProperty("second_scrolling_area"))).click();

			WebElement element2 = driver.findElement(locator(prop.getProperty("second_scrolling_area")));

			//Actions action2 = new Actions(driver);

			action.moveToElement(element2);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Viewed the Privacy Policy by scrolling down the document ");

			driver.findElement(locator(prop.getProperty("second_scroll_area_checkbox"))).click();
			test.log(LogStatus.PASS, "Accepted the Privacy Policy by checking the checkbox  ");

			Thread.sleep(2000);

			driver.findElement(locator(prop.getProperty("next_button"))).click();
			test.log(LogStatus.PASS, "Clicked on Next button  ");

			//Thread.sleep(20000);
			
			/*
			Actions obj=new Actions(driver);
			//obj.moveToElement(target);
			//obj.moveToElement(element).click().keyDown(Keys.DOWN).keyDown(Keys.DOWN).build().perform();
			
			
			js.executeScript("scrollBy(0,200)");

			
			 js.executeScript("arguments[0].scrollIntoView();", element);
			 System.out.println("first scroll");
					//((JavascriptExecutor)driver).executeScript(“window.scrollBy(200,300)”, element);
			 WebElement element2 =driver.findElement(By.id("scrollDiv2"));
				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("window.scrollBy(0,1000)",element2);
				
				
				// js.executeScript("arguments[0].scrollIntoView();", element);
				 
				 */
			
			  wait.until(ExpectedConditions.elementToBeClickable(By.name("iIncomeType")));

			  if( driver.findElement(By.name("iIncomeType")).isEnabled())
			  {
					//test.log(LogStatus.PASS, "Personal Information Entered Successfully with SSN : " +SSN);
					//test.log(LogStatus.PASS, "Personal Information Entered Successfully with SSN : " +SSN);
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Personal Information Entered Successfully with SSN : " +SSN);
					test.log(LogStatus.INFO, "******************************************************** ");

				 	}
					else
					{
					test.log(LogStatus.FAIL, "Personal Information is not entered Successfully with SSN : " +SSN);
					}
		  
	 // break;
	  }
		}
			
		  }
			catch(Exception e)
			  {
					//test.log(LogStatus.ERROR, "Personal Information filling is failed with SSN  : " +SSN);
					//test.log(LogStatus.ERROR, "Error message  " +e);
					  String screenshotPath = getScreenhot(driver, "personalInformation");
					  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
			
	  }
			
		  }
}

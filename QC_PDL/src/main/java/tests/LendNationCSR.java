package tests;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class LendNationCSR extends LendNation{

	public static void lendNationCSR(String SSN,String AppURL,String loan_number)
	{
		try{
			String FileName= prop.getProperty("file_name");
			
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
				int lastrow=TestData.getLastRow("CSRLogin");
				String sheetName="CSRLogin";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String admin_url = TestData.getCellData(sheetName,"AdminURL",row);

					String username = TestData.getCellData(sheetName,"Username",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String application_status = TestData.getCellData(sheetName,"ApplicationStatus",row);
					String comments = TestData.getCellData(sheetName,"Comments",row);
					String last_four_account_no = TestData.getCellData(sheetName,"LastFourAccountNo",row);


					if(SSN.equals(RegSSN))
					{	
				
						//test.log(Status.INFO, "Opened the CSR URL " +AppURL);
						test.log(Status.INFO, MarkupHelper.createLabel("Opened the CSR URL " +AppURL, ExtentColor.BLUE));


						//test.log(Status.INFO, "CSR Application is launched " );
						test.log(Status.INFO, MarkupHelper.createLabel("CSR Application is launched", ExtentColor.BLUE));

						driver = new InternetExplorerDriver();
						WebDriverWait wait = new WebDriverWait(driver, 30000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
					
						driver.get(admin_url);
						
					    driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username);
				        test.log(Status.PASS, "Username is entered: "+username);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password);
				        test.log(Status.PASS, "Password is entered: "+password);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id);;
				        test.log(Status.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(Status.PASS, "Clicked on login button");
				        
				       Thread.sleep(5000);
					
				     // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator)("topFrame"));
				       
				        driver.switchTo().frame("topFrame");
					    wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(locator(prop.getProperty("borrower_tab"))))));

						driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
						Thread.sleep(3000);
						driver.findElement(locator(prop.getProperty("borrower_tab"))).click();			
						test.log(Status.PASS, "Clicked on Borrower tab");
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						
						driver.findElement(locator(prop.getProperty("pam_link"))).click();			
						//driver.switchTo().defaultContent();

						driver.switchTo().frame("main");

						//driver.findElement(By.cssSelector("li[id='955190406']")).click();			
						test.log(Status.PASS, "Clicked on PAM");	
						//test.log(Status.INFO, "Applicant Search page is displayed");	
						test.log(Status.INFO, MarkupHelper.createLabel("Applicant Search page is displayed", ExtentColor.BLUE));


						driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
						test.log(Status.PASS, "Entered Loan number : " +loan_number );
						Thread.sleep(4000);
						driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
						test.log(Status.PASS, "Clicked on Submit button " );
						
						Thread.sleep(2000);
						driver.findElement(locator(prop.getProperty("radio_button_of_search"))).click();
						test.log(Status.PASS, "Selected the radio button" );
						driver.findElement(locator(prop.getProperty("go_button"))).click();
						test.log(Status.PASS, "Clicked on Go button "  );
						
						driver.findElement(locator(prop.getProperty("applicatino_status_selection"))).sendKeys(application_status);
						test.log(Status.INFO, MarkupHelper.createLabel("PAM Action page is displayed",ExtentColor.BLUE ));

						//test.log(Status.PASS, "Selected Application status as " +application_status );
						test.log(Status.PASS, MarkupHelper.createLabel("Selected Application status as " +application_status,ExtentColor.GREEN ));

						
						driver.findElement(locator(prop.getProperty("comment_section"))).sendKeys(comments);
						test.log(Status.PASS, "Given comments as  " +comments );
						
						driver.findElement(locator(prop.getProperty("continue_button_loan"))).click();
						test.log(Status.PASS, "Clicked on Continue button "  );
						Thread.sleep(2000);
						driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
						test.log(Status.PASS, "Entered last four digits of account no : " +last_four_account_no );
						driver.findElement(locator(prop.getProperty("finish_loan"))).click();
						test.log(Status.PASS, "Clicked on Finish loan button "  );
						Thread.sleep(2000);

						Alert al=driver.switchTo().alert();
						String alert_text=al.getText();
						
						test.log(Status.PASS, "Loan number  "+loan_number+" status is  "  +application_status );
						test.log(Status.PASS, "  "  +alert_text );
						test.log(Status.PASS, MarkupHelper.createLabel("Pop up is displayed as "  +alert_text,ExtentColor.GREEN ));

						Thread.sleep(2000);

						al.accept();
						Thread.sleep(3000);
						driver.findElement(locator(prop.getProperty("confirm_yes"))).click();
						test.log(Status.PASS, "clicked on Yes for Confirm "  );
						Thread.sleep(2000);
						//driver.findElement(locator(prop.getProperty("ok_button_after_confirm"))).click();
						//test.log(Status.PASS, "clicked on OK after confirming "  );
						
					
		
		
		break;
	}
				}
		}
	
					catch(Exception e)
					  {
						  test.log(Status.ERROR, "Unable to complete  CSR with SSN and Loan Number : " +SSN+","+loan_number);
						  test.log(Status.ERROR, "Error message  " +e);

							e.printStackTrace();
							System.out.println(e);
	
}
	}
}

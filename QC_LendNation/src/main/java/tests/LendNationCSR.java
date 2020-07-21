package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
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

public class LendNationCSR extends LendNation {

	public static void SimpleNewLoan(String SSN,String AppURL,String loan_number) throws Exception
	{
		try{
			String FileName= prop.getProperty("file_name");
			
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
				int lastrow=TestData.getLastRow("CSRNewLoan");
				String sheetName="CSRNewLoan";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					//String admin_url = TestData.getCellData(sheetName,"AdminURL",row);

					String username = TestData.getCellData(sheetName,"Username",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String application_status = TestData.getCellData(sheetName,"ApplicationStatus",row);
					String comments = TestData.getCellData(sheetName,"Comments",row);
					String last_four_account_no = TestData.getCellData(sheetName,"LastFourAccountNo",row);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row);
					String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
					String LoanAmount = TestData.getCellData(sheetName,"LoanAmount",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					   //String  last_four_account_no=SSN.substring(SSN.length() - 4);


					if(SSN.equals(RegSSN))
					{	
														        
				       Thread.sleep(5000);
				      
				if(LoanAmount.equalsIgnoreCase("0")){
				       
				    if(ReceiveType.equalsIgnoreCase("ACH")){
				    	   
				    	 driver.switchTo().frame("topFrame");
						   
							driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
							Thread.sleep(3000);
							driver.findElement(locator(prop.getProperty("borrower_tab"))).click();			
							test.log(LogStatus.PASS, "Clicked on Borrower tab");
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							
							driver.findElement(locator(prop.getProperty("pam_link"))).click();			
							//driver.switchTo().defaultContent();

							driver.switchTo().frame("main");

							//driver.findElement(By.cssSelector("li[id='955190406']")).click();			
							test.log(LogStatus.PASS, "Clicked on PAM");	
							//test.log(LogStatus.INFO, "Applicant Search page is displayed");	
							test.log(LogStatus.INFO, "Applicant Search page is displayed");
							
							Thread.sleep(1000);
							driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
							test.log(LogStatus.PASS, "Product Type Select as : " +ProductType );
				loan_number="10788286";
							Thread.sleep(500);
							driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
							test.log(LogStatus.PASS, "Entered Loan number : " +loan_number );
							Thread.sleep(4000);
							
							driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
							test.log(LogStatus.PASS, "Clicked on Submit button " );
							
							Thread.sleep(2000);
							driver.findElement(locator(prop.getProperty("radio_button_of_search"))).click();
							test.log(LogStatus.PASS, "Selected the radio button" );
							driver.findElement(locator(prop.getProperty("go_button"))).click();
							test.log(LogStatus.PASS, "Clicked on Go button "  );
							
							driver.findElement(locator(prop.getProperty("applicatino_status_selection"))).sendKeys(application_status);
							//test.log(LogStatus.INFO, "Application Status Select as :");

							//test.log(LogStatus.PASS, "Selected Application status as " +application_status );
							test.log(LogStatus.PASS, "Selected Application status as " +application_status);

							
							driver.findElement(locator(prop.getProperty("comment_section"))).sendKeys(comments);
							test.log(LogStatus.PASS, "Given comments as  " +comments );
							
							driver.findElement(locator(prop.getProperty("continue_button_loan"))).click();
							test.log(LogStatus.PASS, "Clicked on Continue button "  );
							Thread.sleep(2000);
							
							if(RepaymentMethod.equalsIgnoreCase("ACH")){
								Thread.sleep(500);
								driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
								test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );
								Thread.sleep(500);
								driver.findElement(locator(prop.getProperty("finish_loan"))).click();
								test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
								
							}
							 else if(RepaymentMethod.equalsIgnoreCase("DEBIT CARD")){
								 Thread.sleep(500);
								 driver.findElement(locator(prop.getProperty("finish_loan"))).click();
								 test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
							 }
							
							/*driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
							test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );*/
							//Thread.sleep(500);
							/*driver.findElement(locator(prop.getProperty("finish_loan"))).click();
							test.log(LogStatus.PASS, "Clicked on Finish loan button "  );*/
							Thread.sleep(2000);

							Alert al=driver.switchTo().alert();
							String alert_text=al.getText();
							
							test.log(LogStatus.PASS, "Loan number  "+loan_number+" status is  "  +application_status );
							test.log(LogStatus.PASS, "  "  +alert_text );
							test.log(LogStatus.PASS, "Pop up is displayed as "  +alert_text);

							Thread.sleep(2000);

							al.accept();
							Thread.sleep(3000);
							driver.findElement(locator(prop.getProperty("confirm_yes"))).click();
							test.log(LogStatus.PASS, "clicked on Yes for Confirm "  );
							Thread.sleep(5000);
							driver.findElement(By.name("ok")).click();
							test.log(LogStatus.PASS, "clicked Loan Orginated Successfully OK "  );
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Loan Orginated Successfully ");
							test.log(LogStatus.INFO, "******************************************************** ");
							Thread.sleep(2000);											    	   
				    	   
				    }
				    
		}
		
		else 
		{
			
		System.out.println("Write Code For NewLoan Esign");
			
		    if(ReceiveType.equalsIgnoreCase("ACH")){
		    	   
		    	    driver.switchTo().frame("topFrame");
				   
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
					Thread.sleep(3000);
					driver.findElement(locator(prop.getProperty("borrower_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Borrower tab");
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					
					driver.findElement(locator(prop.getProperty("pam_link"))).click();			
					//driver.switchTo().defaultContent();

					driver.switchTo().frame("main");

					//driver.findElement(By.cssSelector("li[id='955190406']")).click();			
					test.log(LogStatus.PASS, "Clicked on PAM");	
					//test.log(LogStatus.INFO, "Applicant Search page is displayed");	
					test.log(LogStatus.INFO, "Applicant Search page is displayed");
					
					Thread.sleep(1000);
					driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
					test.log(LogStatus.PASS, "Product Type Select as : " +ProductType );
		loan_number="10788286";
					Thread.sleep(500);
					driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Entered Loan number : " +loan_number );
					Thread.sleep(4000);
					
					driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
					test.log(LogStatus.PASS, "Clicked on Submit button " );
					
					Thread.sleep(2000);
					driver.findElement(locator(prop.getProperty("radio_button_of_search"))).click();
					test.log(LogStatus.PASS, "Selected the radio button" );
					driver.findElement(locator(prop.getProperty("go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on Go button "  );
					
					driver.findElement(locator(prop.getProperty("applicatino_status_selection"))).sendKeys(application_status);
					//test.log(LogStatus.INFO, "Application Status Select as :");

					//test.log(LogStatus.PASS, "Selected Application status as " +application_status );
					test.log(LogStatus.PASS, "Selected Application status as " +application_status);

					
					driver.findElement(locator(prop.getProperty("comment_section"))).sendKeys(comments);
					test.log(LogStatus.PASS, "Given comments as  " +comments );
					
					driver.findElement(locator(prop.getProperty("continue_button_loan"))).click();
					test.log(LogStatus.PASS, "Clicked on Continue button "  );
					Thread.sleep(2000);
					
					if(RepaymentMethod.equalsIgnoreCase("ACH")){
						Thread.sleep(500);
						driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
						test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );
						Thread.sleep(500);
						driver.findElement(locator(prop.getProperty("finish_loan"))).click();
						test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
						
					}
					 else if(RepaymentMethod.equalsIgnoreCase("DEBIT CARD")){
						 Thread.sleep(500);
						 driver.findElement(locator(prop.getProperty("finish_loan"))).click();
						 test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
					 }
					
					/*driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
					test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );*/
					//Thread.sleep(500);
					/*driver.findElement(locator(prop.getProperty("finish_loan"))).click();
					test.log(LogStatus.PASS, "Clicked on Finish loan button "  );*/
					Thread.sleep(2000);

					Alert al=driver.switchTo().alert();
					String alert_text=al.getText();
					
					test.log(LogStatus.PASS, "Loan number  "+loan_number+" status is  "  +application_status );
					test.log(LogStatus.PASS, "  "  +alert_text );
					test.log(LogStatus.PASS, "Pop up is displayed as "  +alert_text);

					Thread.sleep(2000);

					al.accept();
					Thread.sleep(3000);
					driver.findElement(locator(prop.getProperty("confirm_yes"))).click();
					test.log(LogStatus.PASS, "clicked on Yes for Confirm "  );
					Thread.sleep(5000);
					driver.findElement(By.name("ok")).click();
					test.log(LogStatus.PASS, "clicked Loan Orginated Successfully OK "  );
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Loan Orginated Successfully ");
					test.log(LogStatus.INFO, "******************************************************** ");
					Thread.sleep(2000);											    	   
		    	   
		    }
			
		
			
			
			
			
			
		}
		
		
		
				      
				   if(ReceiveType.equalsIgnoreCase("Cash At Store")){
				    	 Thread.sleep(500);				    	
				    	 driver.switchTo().frame("topFrame");						   
						 driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
						 test.log(LogStatus.PASS, "Clicked on Loan Transactions tab");
						 
						 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						 Thread.sleep(500);
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 //driver.switchTo().frame("main");
						 
						 Thread.sleep(500);		
						 											
						 driver.findElement(By.xpath("//*[@id='955190407']/a")).click();
						 test.log(LogStatus.PASS, "Clicked on Cash At Store Link");
						 
						 Thread.sleep(1000);
						 
						 driver.switchTo().frame("main");
						 
						 driver.findElement(By.name("requestBean.stateCode")).sendKeys(StateID);
						 test.log(LogStatus.PASS, "State ID Select as :" +StateID);
						 
						 Thread.sleep(500);
						 
						 driver.findElement(By.name("requestBean.ssn")).sendKeys(RegSSN);
						 test.log(LogStatus.PASS, "SSN Entered as :" +RegSSN);
						 
						 Thread.sleep(500);
						 
						 driver.findElement(By.name("submit")).click();
						 test.log(LogStatus.PASS, "Clicked on Submit Button");
						 
						 Thread.sleep(1000);
						 
						 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						 test.log(LogStatus.PASS, "Clicked on Go Button");
						 
						 Thread.sleep(500);
						 
						 driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
						 test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );
						 
						 Thread.sleep(500);
						 
						 driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(PIN);
						 test.log(LogStatus.PASS, "PIN Set as :" +PIN);
						 
						 Thread.sleep(500);
						 
						 driver.findElement(locator(prop.getProperty("finish_loan"))).click();
						 test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
						 
						 Thread.sleep(2000);

							Alert al=driver.switchTo().alert();
							String alert_text=al.getText();
							
							test.log(LogStatus.PASS, "Loan number  "+loan_number+" status is  "  +application_status );
							test.log(LogStatus.PASS, "  "  +alert_text );
							test.log(LogStatus.PASS, "Pop up is displayed as "  +alert_text);

							Thread.sleep(2000);

							al.accept();
							Thread.sleep(3000);
							driver.findElement(locator(prop.getProperty("confirm_yes"))).click();
							test.log(LogStatus.PASS, "clicked on Yes for Confirm "  );
							Thread.sleep(5000);
							driver.findElement(By.name("Ok")).click();							                            
							test.log(LogStatus.PASS, "clicked Loan Orginated Successfully OK "  );
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Loan Orginated Successfully ");
							test.log(LogStatus.INFO, "******************************************************** ");
							Thread.sleep(2000);
						 
				    	
				    	
				    	
				    }
				    

		break;
	
				}
		}
				}
	
					catch(Exception e)
					  {
						  test.log(LogStatus.ERROR, "Unable to complete  CSR with SSN and Loan Number : " +SSN+","+loan_number);
						  test.log(LogStatus.ERROR, "Error message  " +e);
						  String screenshotPath = getScreenhot(driver, "lendNationCSR");
						  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
							System.out.println(e);
	
}
	
	}

//======================================================= PAM ===================================================================	

	public static void PAM(String SSN,String AppURL,String loan_number) throws Exception
	{
		try{
			String FileName= prop.getProperty("file_name");
			
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
				int lastrow=TestData.getLastRow("PAM");
				String sheetName="PAM";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					//String admin_url = TestData.getCellData(sheetName,"AdminURL",row);

					String username = TestData.getCellData(sheetName,"Username",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String application_status = TestData.getCellData(sheetName,"ApplicationStatus",row);
					String comments = TestData.getCellData(sheetName,"Comments",row);
					String last_four_account_no = TestData.getCellData(sheetName,"LastFourAccountNo",row);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row);
					String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
					String LoanAmount = TestData.getCellData(sheetName,"LoanAmount",row);
					   //String  last_four_account_no=SSN.substring(SSN.length() - 4);


					if(SSN.equals(RegSSN))
					{	
														        
				       Thread.sleep(5000);
				      
				if(LoanAmount.equalsIgnoreCase("0")){
				       
				    if(ReceiveType.equalsIgnoreCase("ACH")){
				    	   
				    	 driver.switchTo().frame("topFrame");
						   
							driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
							Thread.sleep(3000);
							driver.findElement(locator(prop.getProperty("borrower_tab"))).click();			
							test.log(LogStatus.PASS, "Clicked on Borrower tab");
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							
							driver.findElement(locator(prop.getProperty("pam_link"))).click();			
							//driver.switchTo().defaultContent();

							driver.switchTo().frame("main");

							//driver.findElement(By.cssSelector("li[id='955190406']")).click();			
							test.log(LogStatus.PASS, "Clicked on PAM");	
							//test.log(LogStatus.INFO, "Applicant Search page is displayed");	
							test.log(LogStatus.INFO, "Applicant Search page is displayed");
							
							Thread.sleep(1000);
							driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
							test.log(LogStatus.PASS, "Product Type Select as : " +ProductType );
				loan_number="10788286";
							Thread.sleep(500);
							driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
							test.log(LogStatus.PASS, "Entered Loan number : " +loan_number );
							Thread.sleep(4000);
							
							driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
							test.log(LogStatus.PASS, "Clicked on Submit button " );
							
							Thread.sleep(2000);
							driver.findElement(locator(prop.getProperty("radio_button_of_search"))).click();
							test.log(LogStatus.PASS, "Selected the radio button" );
							driver.findElement(locator(prop.getProperty("go_button"))).click();
							test.log(LogStatus.PASS, "Clicked on Go button "  );
							
							driver.findElement(locator(prop.getProperty("applicatino_status_selection"))).sendKeys(application_status);
							//test.log(LogStatus.INFO, "Application Status Select as :");

							//test.log(LogStatus.PASS, "Selected Application status as " +application_status );
							test.log(LogStatus.PASS, "Selected Application status as " +application_status);
							Thread.sleep(500);
							
							String ApprovedLoanAmount = driver.findElement(By.name("requestBean.appLoanAmount")).getAttribute("value");
							                                                        
							test.log(LogStatus.PASS, "Approved Loan Amount is : " +ApprovedLoanAmount);
							
							Thread.sleep(500);
							

							
							driver.findElement(locator(prop.getProperty("comment_section"))).sendKeys(comments);
							test.log(LogStatus.PASS, "Given comments as  " +comments );
							
							driver.findElement(locator(prop.getProperty("continue_button_loan"))).click();
							test.log(LogStatus.PASS, "Clicked on Continue button "  );
							Thread.sleep(2000);
							
							if(RepaymentMethod.equalsIgnoreCase("ACH")){
								Thread.sleep(500);
								driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
								test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );
								Thread.sleep(500);
								driver.findElement(locator(prop.getProperty("finish_loan"))).click();
								test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
								
							}
							 else if(RepaymentMethod.equalsIgnoreCase("DEBIT CARD")){
								 Thread.sleep(500);
								 driver.findElement(locator(prop.getProperty("finish_loan"))).click();
								 test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
							 }
							
							/*driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
							test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );*/
							//Thread.sleep(500);
							/*driver.findElement(locator(prop.getProperty("finish_loan"))).click();
							test.log(LogStatus.PASS, "Clicked on Finish loan button "  );*/
							Thread.sleep(2000);

							Alert al=driver.switchTo().alert();
							String alert_text=al.getText();
							
							test.log(LogStatus.PASS, "Loan number  "+loan_number+" status is  "  +application_status );
							test.log(LogStatus.PASS, "  "  +alert_text );
							test.log(LogStatus.PASS, "Pop up is displayed as "  +alert_text);

							Thread.sleep(2000);

							al.accept();
							Thread.sleep(3000);
							driver.findElement(locator(prop.getProperty("confirm_yes"))).click();
							test.log(LogStatus.PASS, "clicked on Yes for Confirm "  );
							Thread.sleep(5000);
							driver.findElement(By.name("ok")).click();
							test.log(LogStatus.PASS, "clicked Loan Orginated Successfully OK "  );
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Loan Orginated Successfully ");
							test.log(LogStatus.INFO, "******************************************************** ");
							Thread.sleep(2000);
							
				    	   
				    	   
				    }
				    
		}
		
		else 
		{
			
			System.out.println("Write Code For NewLoan Esign");
			
		    if(ReceiveType.equalsIgnoreCase("ACH")){
		    	   
		    	 driver.switchTo().frame("topFrame");
				   
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
					Thread.sleep(3000);
					driver.findElement(locator(prop.getProperty("borrower_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Borrower tab");
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					
					driver.findElement(locator(prop.getProperty("pam_link"))).click();			
					//driver.switchTo().defaultContent();

					driver.switchTo().frame("main");

					//driver.findElement(By.cssSelector("li[id='955190406']")).click();			
					test.log(LogStatus.PASS, "Clicked on PAM");	
					//test.log(LogStatus.INFO, "Applicant Search page is displayed");	
					test.log(LogStatus.INFO, "Applicant Search page is displayed");
					
					Thread.sleep(1000);
					driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
					test.log(LogStatus.PASS, "Product Type Select as : " +ProductType );
		loan_number="10788286";
					Thread.sleep(500);
					driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Entered Loan number : " +loan_number );
					Thread.sleep(4000);
					
					driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
					test.log(LogStatus.PASS, "Clicked on Submit button " );
					
					Thread.sleep(2000);
					driver.findElement(locator(prop.getProperty("radio_button_of_search"))).click();
					test.log(LogStatus.PASS, "Selected the radio button" );
					driver.findElement(locator(prop.getProperty("go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on Go button "  );
					
					Thread.sleep(500);
					driver.findElement(By.name("requestBean.appLoanAmount")).clear();
					Thread.sleep(500);
					
					driver.findElement(By.name("requestBean.appLoanAmount")).sendKeys(LoanAmount);
					test.log(LogStatus.PASS, "Approved Loan Amount Changed To : " +LoanAmount);
					
					Thread.sleep(500);
					
					
					/*driver.findElement(locator(prop.getProperty("applicatino_status_selection"))).sendKeys(application_status);
					//test.log(LogStatus.INFO, "Application Status Select as :");

					//test.log(LogStatus.PASS, "Selected Application status as " +application_status );
					test.log(LogStatus.PASS, "Selected Application status as " +application_status);*/

					
					driver.findElement(locator(prop.getProperty("comment_section"))).sendKeys(comments);
					test.log(LogStatus.PASS, "Given comments as  " +comments );
					
					driver.findElement(locator(prop.getProperty("continue_button_loan"))).click();
					test.log(LogStatus.PASS, "Clicked on Continue button "  );
					
					Thread.sleep(500);
					
					try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.														

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					
					
					Thread.sleep(500);
					
					try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.														

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
									
					
					Thread.sleep(2000);
					
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Customer Verification Details Completed Successfully, Customer need to Provide New E-sign Details");
					test.log(LogStatus.INFO, "******************************************************** ");
					Thread.sleep(2000);
					//driver.close();
					break;
					
		    }
		   break ;
		}
		
		
		
					if(RepaymentMethod.equalsIgnoreCase("ACH")){
						Thread.sleep(500);
						driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
						test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );
						Thread.sleep(500);
						driver.findElement(locator(prop.getProperty("finish_loan"))).click();
						test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
						
					}
					 else if(RepaymentMethod.equalsIgnoreCase("DEBIT CARD")){
						 Thread.sleep(500);
						 driver.findElement(locator(prop.getProperty("finish_loan"))).click();
						 test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
					 }
					
					/*driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
					test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );*/
					//Thread.sleep(500);
					/*driver.findElement(locator(prop.getProperty("finish_loan"))).click();
					test.log(LogStatus.PASS, "Clicked on Finish loan button "  );*/
					Thread.sleep(2000);

					Alert al=driver.switchTo().alert();
					String alert_text=al.getText();
					
					test.log(LogStatus.PASS, "Loan number  "+loan_number+" status is  "  +application_status );
					test.log(LogStatus.PASS, "  "  +alert_text );
					test.log(LogStatus.PASS, "Pop up is displayed as "  +alert_text);

					Thread.sleep(2000);

					al.accept();
					Thread.sleep(3000);
					driver.findElement(locator(prop.getProperty("confirm_yes"))).click();
					test.log(LogStatus.PASS, "clicked on Yes for Confirm "  );
					Thread.sleep(5000);
					driver.findElement(By.name("ok")).click();
					test.log(LogStatus.PASS, "clicked Loan Orginated Successfully OK "  );
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Loan Orginated Successfully ");
					test.log(LogStatus.INFO, "******************************************************** ");
					Thread.sleep(2000);
					
		    	   
		    	   
		    //}
			
			
			
		
			
			
			
			
			
		//}
		
		
		
				      
				   if(ReceiveType.equalsIgnoreCase("Cash At Store")){
				    	 Thread.sleep(500);				    	
				    	/* driver.switchTo().frame("topFrame");						   
						 driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
						 test.log(LogStatus.PASS, "Clicked on Loan Transactions tab");
						 
						 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						 Thread.sleep(500);
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 //driver.switchTo().frame("main");
						 
						 Thread.sleep(500);		
						 											
						 driver.findElement(By.xpath("//*[@id='955190407']/a")).click();
						 test.log(LogStatus.PASS, "Clicked on Cash At Store Link");*/
				    	 
				    	 driver.switchTo().frame("topFrame");
						   
							driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
							Thread.sleep(3000);
							driver.findElement(locator(prop.getProperty("borrower_tab"))).click();			
							test.log(LogStatus.PASS, "Clicked on Borrower tab");
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							
							driver.findElement(locator(prop.getProperty("pam_link"))).click();			
							//driver.switchTo().defaultContent();

							driver.switchTo().frame("main");

							//driver.findElement(By.cssSelector("li[id='955190406']")).click();			
							test.log(LogStatus.PASS, "Clicked on PAM");	
							//test.log(LogStatus.INFO, "Applicant Search page is displayed");	
							test.log(LogStatus.INFO, "Applicant Search page is displayed");
							
							Thread.sleep(1000);
							driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
							test.log(LogStatus.PASS, "Product Type Select as : " +ProductType );
				loan_number="10788286";
							Thread.sleep(500);
							driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
							test.log(LogStatus.PASS, "Entered Loan number : " +loan_number );
							Thread.sleep(4000);
							
							driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
							test.log(LogStatus.PASS, "Clicked on Submit button " );
							
							Thread.sleep(2000);
							driver.findElement(locator(prop.getProperty("radio_button_of_search"))).click();
							test.log(LogStatus.PASS, "Selected the radio button" );
							driver.findElement(locator(prop.getProperty("go_button"))).click();
							test.log(LogStatus.PASS, "Clicked on Go button "  );
							
							driver.findElement(locator(prop.getProperty("applicatino_status_selection"))).sendKeys(application_status);
							//test.log(LogStatus.INFO, "Application Status Select as :");

							//test.log(LogStatus.PASS, "Selected Application status as " +application_status );
							test.log(LogStatus.PASS, "Selected Application status as " +application_status);

							
							driver.findElement(locator(prop.getProperty("comment_section"))).sendKeys(comments);
							test.log(LogStatus.PASS, "Given comments as  " +comments );
							
							driver.findElement(locator(prop.getProperty("continue_button_loan"))).click();
							test.log(LogStatus.PASS, "Clicked on Continue button "  );
							Thread.sleep(2000);
							
							/*if(RepaymentMethod.equalsIgnoreCase("ACH")){
								Thread.sleep(500);
								driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
								test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );
								Thread.sleep(500);
								driver.findElement(locator(prop.getProperty("finish_loan"))).click();
								test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
								
							}
							 else if(RepaymentMethod.equalsIgnoreCase("DEBIT CARD")){
								 Thread.sleep(500);
								 driver.findElement(locator(prop.getProperty("finish_loan"))).click();
								 test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
							 }*/
							
							/*driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
							test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );*/
							//Thread.sleep(500);
							/*driver.findElement(locator(prop.getProperty("finish_loan"))).click();
							test.log(LogStatus.PASS, "Clicked on Finish loan button "  );*/
							/*Thread.sleep(2000);

							Alert al=driver.switchTo().alert();
							String alert_text=al.getText();
							
							test.log(LogStatus.PASS, "Loan number  "+loan_number+" status is  "  +application_status );
							test.log(LogStatus.PASS, "  "  +alert_text );
							test.log(LogStatus.PASS, "Pop up is displayed as "  +alert_text);

							Thread.sleep(2000);

							al.accept();
							Thread.sleep(3000);
							driver.findElement(locator(prop.getProperty("confirm_yes"))).click();
							test.log(LogStatus.PASS, "clicked on Yes for Confirm "  );
							Thread.sleep(5000);
							driver.findElement(By.name("ok")).click();
							test.log(LogStatus.PASS, "clicked Loan Orginated Successfully OK "  );*/
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> You Have Choosen Cash at Store. Please collect the Cash from nearest Store ");
							test.log(LogStatus.INFO, "******************************************************** ");
							Thread.sleep(2000);
				    	
				    	
				    	
				    }
				    

		break;
	
				}
		}
				}
	
					catch(Exception e)
					  {
						  test.log(LogStatus.ERROR, "Unable to complete  CSR with SSN and Loan Number : " +SSN+","+loan_number);
						  test.log(LogStatus.ERROR, "Error message  " +e);
						  String screenshotPath = getScreenhot(driver, "lendNationCSR");
						  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
							System.out.println(e);
	
}
	
	}
	
	
}

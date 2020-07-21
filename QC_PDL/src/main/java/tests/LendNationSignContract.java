package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class LendNationSignContract extends LendNation{
	

	public static void signContract(String SSN,String AppURL)
	{
		try{
			String FileName= prop.getProperty("file_name");
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";
				WebDriverWait wait = new WebDriverWait(driver, 40000);

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(10000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));

				System.out.println("Under SignContra");
				driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();
				//test.log(Status.INFO, "Lend Nation application navigated to Sign Contract page ");
				test.log(Status.INFO, MarkupHelper.createLabel("Lend Nation application navigated to Sign Contract page",ExtentColor.BLUE ));


				test.log(Status.PASS, "Checked the first checkbox ");
				Thread.sleep(2000);
				driver.findElement(locator(prop.getProperty("checkbox2_signpage"))).click();
				test.log(Status.PASS, "Checked the second checkbox");
				Thread.sleep(2000);

				driver.findElement(locator(prop.getProperty("checkbox3_signpage"))).click();
				test.log(Status.PASS, "Checked the third checkbox");
				Thread.sleep(2000);

				driver.findElement(locator(prop.getProperty("checkbox4_signpage"))).click();

				test.log(Status.PASS, "Checked the fourth checkbox");
				driver.findElement(locator(prop.getProperty("signature_field1"))).sendKeys(Signaturename);
				test.log(Status.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(2000);

				driver.findElement(locator(prop.getProperty("checkbox5_signpage"))).click();
				test.log(Status.PASS, "Checked the fifth checkbox");
				
				driver.findElement(locator(prop.getProperty("signature_field2"))).sendKeys(Signaturename);
				test.log(Status.PASS, "Entered the Second Signature field details as : "+Signaturename);
				

				driver.findElement(locator(prop.getProperty("get_loan_button"))).click();
				test.log(Status.PASS, "Clicked on Get New Loan button");
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("go_to_dashboard_button")))));
				
				 if( driver.findElement(locator(prop.getProperty("go_to_dashboard_button"))).isEnabled())
				  {
						//test.log(Status.PASS, "Esign Successfully with SSN :" +SSN);
						test.log(Status.PASS, MarkupHelper.createLabel("Esign Successfully with SSN :" +SSN,ExtentColor.GREEN ));

					 	}
				else
						{
						test.log(Status.FAIL, " Esign not successfully with SSN : " +SSN);
						}

//Verify By Phone page code
				 Thread.sleep(20000);
				 wait.until(ExpectedConditions.elementToBeClickable(locator(prop.getProperty("go_to_dashboard_button"))));
				 driver.findElement(locator(prop.getProperty("go_to_dashboard_button"))).click();
					//test.log(Status.INFO, "Lend Nation application navigated to Verify By Phone page ");
					test.log(Status.INFO, MarkupHelper.createLabel("Lend Nation application navigated to Verify By Phone page",ExtentColor.BLUE ));


					test.log(Status.PASS, "Clicked on go To Dashboard button");
					 Thread.sleep(10000);
					 //wait.until(ExpectedConditions.((driver.findElement(locator(prop.getProperty("Loan_number")))));
					 String loan_number_field=driver.findElement(locator(prop.getProperty("Loan_number"))).getText();
					 String[] loanfield=loan_number_field.split(":");
					 loan_number=loanfield[1];
					//test.log(Status.PASS, "Loan number generated is :"+loan_number);
					test.log(Status.PASS, MarkupHelper.createLabel("Loan number generated is :"+loan_number,ExtentColor.GREEN ));


					 
					 
					 

				 
			
					}
				  
				 
				  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  test.log(Status.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  test.log(Status.ERROR, "Error message  " +e);

					e.printStackTrace();
					System.out.println(e);

			  }
				
				
				}
	}
	
	
	


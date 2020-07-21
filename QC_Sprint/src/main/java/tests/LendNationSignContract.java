package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;



public class LendNationSignContract extends LendNation{
	

	public static void signContract(String SSN,String AppURL) throws Exception
	
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
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(20000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();
				//test.log(LogStatus.INFO, "Lend Nation application navigated to Sign Contract page ");
				


				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(3000);
				driver.findElement(locator(prop.getProperty("checkbox2_signpage"))).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(3000);

				driver.findElement(locator(prop.getProperty("checkbox3_signpage"))).click();
				test.log(LogStatus.PASS, "Checked the third checkbox");
				Thread.sleep(3000);

				driver.findElement(locator(prop.getProperty("checkbox4_signpage"))).click();

				test.log(LogStatus.PASS, "Checked the fourth checkbox");
				//driver.findElement(locator(prop.getProperty("signature_field1"))).sendKeys(Signaturename);
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);
				//*[@id="SignatureRequired0"]
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(3000);

				//driver.findElement(locator(prop.getProperty("checkbox5_signpage"))).click();
				driver.findElement(By.xpath("//*[@id='checkBox4']")).click();
				test.log(LogStatus.PASS, "Checked the fifth checkbox");
				
				Thread.sleep(1000);
				
				//driver.findElement(locator(prop.getProperty("signature_field2"))).sendKeys(Signaturename);
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);			
				test.log(LogStatus.PASS, "Entered the Second Signature field details as : "+Signaturename);
				
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id='checkBox5']")).click();
				test.log(LogStatus.PASS, "Checked the Sixth checkbox");
				
				Thread.sleep(1000);
				
				//driver.findElement(locator(prop.getProperty("signature_field3"))).sendKeys(Signaturename);
				driver.findElement(By.xpath("//*[@id='SignatureRequired2']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the Second Signature field details as : "+Signaturename);
				
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id='checkBox6']")).click();
				test.log(LogStatus.PASS, "Checked the Sixth checkbox");
				
                Thread.sleep(1000);
				
				//driver.findElement(locator(prop.getProperty("signature_field2"))).sendKeys(Signaturename);
                //driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);
                driver.findElement(By.xpath("//*[@id='SignatureRequired3']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the Second Signature field details as : "+Signaturename);
				
				 driver.findElement(By.xpath("//*[@id='SignatureRequired4']")).sendKeys(Signaturename);
				 test.log(LogStatus.PASS, "Entered the Second Signature field details as : "+Signaturename);
				 
				 Thread.sleep(1000);
				
				
				Thread.sleep(2000);
				
				driver.findElement(locator(prop.getProperty("get_loan_button"))).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				
				Thread.sleep(30000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("go_to_dashboard_button")))));
				
				 if( driver.findElement(locator(prop.getProperty("go_to_dashboard_button"))).isEnabled())
				  {
						//test.log(LogStatus.PASS, "Esign Successfully with SSN :" +SSN);
						//test.log(LogStatus.PASS, "Esign Successfully with SSN :" +SSN);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Successfully with SSN : " +SSN);
						test.log(LogStatus.INFO, "******************************************************** ");
						

					 	}
				else
						{
						test.log(LogStatus.FAIL, " Esign not successfully with SSN : " +SSN);
						}

//Verify By Phone page code
				 Thread.sleep(10000);
				 test.log(LogStatus.INFO, "**********Lend Nation application navigated to Verify By Phone page*********");
				 //wait.until(ExpectedConditions.elementToBeClickable(locator(prop.getProperty("go_to_dashboard_button"))));
				 driver.findElement(locator(prop.getProperty("go_to_dashboard_button"))).click();
					//test.log(LogStatus.INFO, "Lend Nation application navigated to Verify By Phone page ");
					


					test.log(LogStatus.PASS, "Clicked on go To Dashboard button");
					 Thread.sleep(10000);
					 //wait.until(ExpectedConditions.((driver.findElement(locator(prop.getProperty("Loan_number")))));
					 String loan_number_field=driver.findElement(locator(prop.getProperty("Loan_number"))).getText();
					 String[] loanfield=loan_number_field.split(":");
					 loan_number=loanfield[1];
					//test.log(LogStatus.PASS, "Loan number generated is :"+loan_number);
					//test.log(LogStatus.PASS, "Loan number generated is :"+loan_number);
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan number generated is : " +loan_number);
					Thread.sleep(500);
					String app_date=driver.findElement(By.xpath("//*[@id='payDueundefined']")).getText();
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Application Date is : " +app_date);
					test.log(LogStatus.INFO, "******************************************************** ");
					Thread.sleep(5000);
					driver.close();
					break ;
				
				


					 
					 
					 

				 
			
					}
				  
				 
				  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	}
	
	
	


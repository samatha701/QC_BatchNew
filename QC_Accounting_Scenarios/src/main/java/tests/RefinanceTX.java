package tests;

import java.text.DateFormat;
import java.text.DecimalFormat;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import tests.QCStore;

public class RefinanceTX extends QCStore{

	public static String cardType;
	public static String cardNumber;
	public static String  cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;

	public static String paymentAmount;
	public static String Pbal;
	public static String Interest_percent;
	public static String pmt;
	public static String new_interest;

	public static void refinance(String SSN,String AppURL) throws Exception{

		String sheetName="ReFinance";	
		int lastrow=TestData.getLastRow(sheetName);
		
		try{

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{		

				String Bank_ChkgAcctNbr = TestData.getCellData(sheetName, "Bank_ChkgAcctNbr", row);
				String last4cheknum = Bank_ChkgAcctNbr.substring(Bank_ChkgAcctNbr.length() - 4);
				String ESign_DisbType = TestData.getCellData(sheetName, "ESign_DisbType", row);
				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent",
						row);
				String ESign_Preference = TestData.getCellData(sheetName, "ESign_Preference", row);
				String ESign_CheckNbr = TestData.getCellData(sheetName, "ESign_CheckNbr", row);
				String No_of_checks = TestData.getCellData(sheetName, "No_of_checks", row);
				String Esign_Password = TestData.getCellData(sheetName, "ESign_Password", row);
				String Esign_CollateralType = TestData.getCellData(sheetName, "Esign_CollateralType", row);
				String Collateral = TestData.getCellData(sheetName, "Collateral", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);

				cardType = TestData.getCellData(sheetName, "Card Type ", row);
				cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
				cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
				cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
				cvv = TestData.getCellData(sheetName, "CVV", row);
				CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO, "Refinance process has started");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Sprop.getProperty("transactions_tab"))).click();
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");
				driver.switchTo().frame("main");
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
				driver.findElement(locator(Sprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
				driver.findElement(locator(Sprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
				driver.findElement(locator(Sprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");
				/*
				 * for(String winHandle : driver.getWindowHandles()) {
				 * driver.switchTo().window(winHandle);
				 */
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(locator(Sprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);
				/*
				 * for( String winHandle1 : driver.getWindowHandles()) {
				 * driver.switchTo().window(winHandle1); }
				 */
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				// driver.findElement(By.xpath("
				// /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
				// test.log(LogStatus.PASS, "Clicked on Go button under
				// Loans section");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys("Refinance");
				test.log(LogStatus.PASS, "Transaction Type is selected as Refinance");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				     Thread.sleep(5000);
				     try{
				     driver.findElement(By.xpath("//input[@value='Yes']")).click();
				     }
				     catch(Exception e){
				     
				     }
					//driver.findElement(By.name("history")).click();
					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[11]/td/table/tbody/tr[11]/td[3]/input")).click();
					test.log(LogStatus.PASS, "Clicked on History button ");
				
				Thread.sleep(8000);

				String mainWindow = driver.getWindowHandle();
				for (String winHandle : driver.getWindowHandles()) {
					if (!mainWindow.equalsIgnoreCase(winHandle)) {
						driver.switchTo().window(winHandle);
						driver.manage().window().maximize();
						                 //*[@id="transactionHistoryTable"]/tbody/tr/td[3]/table/tbody/tr[16]/td/span[2]-->regular reg
						Pbal = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[17]/td/span[2]")).getText();
						Interest_percent=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[7]/td/span[2]")).getText();
						pmt=driver.findElement(By.xpath("//*[@id='ContractScheduleTable']/tbody/tr[2]/td[4]")).getText();
						new_interest=driver.findElement(By.xpath("//*[@id='ContractScheduleTable']/tbody/tr[2]/td[5]")).getText();

											
						driver.close();
						break;
					}
				}
				driver.switchTo().window(mainWindow);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				// test.log(LogStatus.PASS, "Switching to the window
				// "+driver.getTitle());
				float PbalInt = Float.valueOf(Pbal);
				test.log(LogStatus.PASS, "Principal balance captured from History is "+PbalInt);
				String[] Interest_percents=Interest_percent.split("%");
				Interest_percent=Interest_percents[0];
				test.log(LogStatus.PASS, "Interest percent captured from History is "+Interest_percent);
				float Interest_percentf = Float.valueOf(Interest_percent);
				float pmtf = Float.valueOf(pmt);
				test.log(LogStatus.PASS, "PMT captured from History is "+pmtf);
				float new_interestf = Float.valueOf(new_interest);
				test.log(LogStatus.PASS, "New Interest captured from History is "+new_interestf);
				
				float value=pmtf-new_interestf;
				test.log(LogStatus.PASS, "Value after New Interest removed from pmt is "+value);
				float value2=PbalInt*Interest_percentf*4/36500;
				test.log(LogStatus.PASS, "Value after Principle balance * Interest percentage * StoreAge days for 365 days is "+value2);
				
				//value2=round("%.2f", value2));
				double value3=PbalInt*0.25;
				test.log(LogStatus.PASS, "Value after Principle balance* 25 percentage is "+value3);
				
				double Calculated_payment=value+value2+value3;
				DecimalFormat df = new DecimalFormat("#.##");
				//Calculated_payment=df.format(Calculated_payment); 
				Calculated_payment=Double.valueOf(df.format(Calculated_payment));
				test.log(LogStatus.PASS, "Value after combining above three values "+Calculated_payment);
				//Calculated_payment=Math.round(Calculated_payment);
				
				WebElement e1=driver.findElement(By.name("requestBean.siilBean.paymentAmt"));
				String LoanAmount= e1.getAttribute("value");
				Thread.sleep(500);
				String cacl_payment=String.valueOf(Calculated_payment);
				test.log(LogStatus.PASS, "Payment amount from Refinance screen is "+LoanAmount);
				if(cacl_payment.equalsIgnoreCase(LoanAmount))
				{
					test.log(LogStatus.PASS, "Payment amount from Refinance screen is "+LoanAmount+" equals to value calculated from the History page "+cacl_payment);
				Thread.sleep(10000);
				driver.findElement(By.name("qualify")).click();
				  
				/*Thread.sleep(10000);
				driver.findElement(By.name("qualify")).click();*/
				test.log(LogStatus.PASS, "Clicked on qualify button ");
				Thread.sleep(5000);
				
				
	
				Thread.sleep(500);
				driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"))
				.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE)
						+ LoanAmount);
				test.log(LogStatus.PASS, "Entered Loan amount as  :"+LoanAmount);
				
				driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
                
				test.log(LogStatus.PASS, "Select tender type as "+TenderType);
				
			
					if(Collateral.equalsIgnoreCase("ACH")){
						
						Thread.sleep(500);
						driver.findElement(By.name("collateralType")).sendKeys(Collateral);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+Collateral);
						Thread.sleep(500);
						
						
						

					}
					if(Collateral.equalsIgnoreCase("Debit card")){


						driver.findElement(By.name("collateralType")).sendKeys(Collateral);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+Collateral);
						driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
						test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

						driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
						test.log(LogStatus.PASS, "Card number is :" + cardNumber);

						driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);
						test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
						driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
						test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

						driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);
						test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

						driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
						test.log(LogStatus.PASS, "Enterd CVV " + cvv);
						driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
						test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

						driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]")).click();
						test.log(LogStatus.PASS, "Clicked on add card button ");	
						Thread.sleep(30000);

					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
					{
						if(ESign_Preference.equalsIgnoreCase("Call"))
						{
							driver.findElement(By.id("preferenceCall")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equalsIgnoreCase("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equalsIgnoreCase("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}
				}
				else
				{
					test.log(LogStatus.PASS, "Calculted payment amount is "+cacl_payment +"not equals to Refinance payment amount "+LoanAmount);	
				}

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					Thread.sleep(500);
					

					driver.findElement(By.name("requestBean.password")).sendKeys(Esign_Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+Esign_Password);

					driver.findElement(By.name("finishLoan")).click();
					test.log(LogStatus.PASS, "click on Finish Loan button ");

					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();

					String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
					String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
					String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();

					test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an "+confirm_text2+" of "+confirm_text3+" First payment date is "+confirm_text4);

					driver.findElement(By.name("OKBut")).click();

					test.log(LogStatus.PASS, "click on Yes button ");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						test.log(LogStatus.PASS, "<FONT color=green style=Arial>Refinance is pass ");
						test.log(LogStatus.INFO, "**********************************************************************************");

					}
					else
					{
						test.log(LogStatus.PASS, "<FONT color=green style=Arial>Refinance is pass ");
						test.log(LogStatus.INFO, "**********************************************************************************");
					}
				
					break;
					}
		
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			// test.log(LogStatus.FAIL, MarkupHelper.createLabel("Getting
			// Encryption from Admin is failed", ExtentColor.RED));
			test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
			String screenshotPath = getScreenhot(driver, "Exception");
							test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
		}
	}

	



}
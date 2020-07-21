package tests;

import static org.testng.Assert.assertFalse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCCSRNewLoan_pdl extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static String ESign_CheckNbr;
	public static String ESign_Password;
	public static String ESign_Checks;
	public static String CouponNbr;
	// public static String ChkgAcctNbr;
	public static String AllowPromotion;
	public static String ESign_Preference;
	public static String ESign_CourtesyCallConsent;
	public static String Esign_DisbType;
	public static String ESign_LoanAmt;
	public static String ESign_CollateralType;
	public static String stateProductType;
	public static String stateProduct;
	public static String StoreID;
	public static String NewVIN;
	public static String VehicleType;
	public static String NewLoan_Term;
	public static String NewLoan_ProductName;
	public static String ProductType;
	public static String Password;
	public static String UserName;
	public static String ProductID;
	public static String last4cheknum;
	public static String InsuranceExpiryDate0[] = null;
	public static String InsuranceExpiryDate3;
	public static String InsuranceExpiryDate2;
	public static String InsuranceExpiryDate1;
	public static String PolicyNumber;

	public static String InsuranceCompany;
	public static String PhoneNbr3;
	public static String PhoneNbr2;
	public static String PhoneNbr1;
	public static String PhoneNbr;
	public static String InsuranceCoverage;
	public static String LicensePlateExp;
	public static String LicensePlateNumber;
	public static String ExteriorColor;
	public static String AppraisalValue;
	public static String InsuranceExpiryDate;
	public static String TitleNumber;
	public static int rnum;
	public static int cnum;
	public static String product_name;
	public static int count;
	public static List<WebElement> rows;
	public static String No_of_checks;
	public static String cardType;
	public static String cardNumber;
	public static String cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;
	public static String VIN;
	public static String Miles;
	public static String VehicleGrade;
	public static String relamount;
	public static String  CC_Issuer_Name;

	public static void newLoan(String SSN, String AppURL) throws Exception {

		int lastrow = TestData.getLastRow("New_Loan");
		String sheetName = "New_Loan";

		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			if (SSN.equals(RegSSN)) {
				State = "MO";
				ProductID = "PDL";
				System.out.println(ProductID);
				UserName = TestData.getCellData(sheetName, "UserName", row);
				Password = TestData.getCellData(sheetName, "Password", row);
				//ProductType = TestData.getCellData(sheetName, "ProductType", row);
				ProductType ="PayDay Loan";
				NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
				NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
				VehicleType = TestData.getCellData(sheetName, "VehicleType", row);
				NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
				VIN = TestData.getCellData(sheetName, "VIN", row);
				Miles = TestData.getCellData(sheetName, "Miles", row);
				// System.out.println(Term);
				// String StoreId =
				// TestData.getCellData(sheetName,"StoreID",row);
				StoreID = TestData.getCellData(sheetName, "StoreID", row);
				stateProduct = State + " " + ProductID;
				stateProductType = State + " " + NewLoan_ProductName;
				ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				System.out.println(ESign_CollateralType);
				//ESign_LoanAmt = TestData.getCellData(sheetName, "ESign_LoanAmt", row);
				// ChkgAcctNbr =
				// TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				//Esign_DisbType = TestData.getCellData(sheetName, "Esign_DisbType", row);
				Esign_DisbType = "Cash";
				ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent", row);
				AllowPromotion = TestData.getCellData(sheetName, "AllowPromotion", row);
				CouponNbr = TestData.getCellData(sheetName, "CouponNbr", row);
				ESign_Preference = TestData.getCellData(sheetName, "ESign_Preference", row);
				ESign_Checks = TestData.getCellData(sheetName, "ESign_Checks", row);
				//ESign_Password = TestData.getCellData(sheetName, "ESign_Password", row);
				ESign_Password="1234";
				//ESign_CheckNbr = TestData.getCellData(sheetName, "ESign_CheckNbr", row);
				ESign_CheckNbr=SSN.substring(SSN.length() - 6);
				// last4cheknum=
				// ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				//last4cheknum = TestData.getCellData(sheetName, "ChkgAcctNbr_lastfour", row);
				last4cheknum= SSN.substring(SSN.length() - 4);

				SSN1 = SSN.substring(0, 3);
				SSN2 = SSN.substring(3, 5);
				SSN3 = SSN.substring(5, 9);
				TitleNumber = TestData.getCellData(sheetName, "TitleNumber", row);
				AppraisalValue = TestData.getCellData(sheetName, "Appraisal Value", row);
				ExteriorColor = TestData.getCellData(sheetName, "ExteriorColor", row);
				LicensePlateNumber = TestData.getCellData(sheetName, "License Plate Number", row);

				VehicleGrade = TestData.getCellData(sheetName, "Vehicle Grade", row);
				LicensePlateExp = TestData.getCellData(sheetName, "License Plate Expiry", row);
				InsuranceCoverage = TestData.getCellData(sheetName, "Insurance Coverage", row);
				PhoneNbr = TestData.getCellData(sheetName, "Phone Nbr", row);
				PhoneNbr1 = PhoneNbr.substring(0, 3);
				PhoneNbr2 = PhoneNbr.substring(3, 6);
				PhoneNbr3 = PhoneNbr.substring(6, 10);
				InsuranceCompany = TestData.getCellData(sheetName, "Insurance Company", row);
				InsuranceExpiryDate = TestData.getCellData(sheetName, "Insurance Expiry Date", row);
				PolicyNumber = TestData.getCellData(sheetName, "Policy Number", row);
				InsuranceExpiryDate0 = InsuranceExpiryDate.split("/");
				InsuranceExpiryDate1 = InsuranceExpiryDate0[0];
				InsuranceExpiryDate2 = InsuranceExpiryDate0[1];
				InsuranceExpiryDate3 = InsuranceExpiryDate0[2];
				No_of_checks = TestData.getCellData(sheetName, "No_of_checks", row);
				CC_Issuer_Name=TestData.getCellData(sheetName, "CC_Issuer_Name", row);

				cardType = TestData.getCellData(sheetName, "Card Type ", row);
				cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
				cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
				cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
				cvv = TestData.getCellData(sheetName, "CVV", row);
				CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);


				Thread.sleep(3000);
				// test.log(LogStatus.INFO,
				// MarkupHelper.createLabel("New Loan initiation has
				// started", ExtentColor.BLUE));
				test.log(LogStatus.INFO, "New Loan initiation has started");

				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Sprop.getProperty("transactions_tab"))).click();
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(locator(Sprop.getProperty("csr_new_loan_link"))).click();
				test.log(LogStatus.PASS, "Clicked on New Loan");
				driver.switchTo().frame("main");
				Thread.sleep(4000);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
				driver.findElement(locator(Sprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
				driver.findElement(locator(Sprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
				driver.findElement(locator(Sprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(locator(Sprop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on GO Button");

			if(ESign_CollateralType.equals("DEBIT CARD")){
				        driver.findElement(By.id("veh1")).click();
				        test.log(LogStatus.PASS, "clicked on vehchile details radio button ");
				        Thread.sleep(2000);
						 driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
					     
					     driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
		            	 test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");
		            	 Thread.sleep(1000);
		            	 driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
		            	 test.log(LogStatus.PASS, "Card number is :" + cardNumber);
		            	
		            	 driver.findElement(By.xpath("//*[@id='cardType']")).sendKeys("Visa");
		            	 test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
		            	//*[@id="cardType"]	            	 
		            	 driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
		            	 test.log(LogStatus.PASS, "Enterd Expiry month as" + cardEx_month);
		            	 
		            	 driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);
		            	 test.log(LogStatus.PASS, "Entered Expiry year as" + cardEx_month);
		            	 
		            	 driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
		            	 test.log(LogStatus.PASS, "Enterd CVV as " + cvv);
		            	
		            	 driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
		            	 test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
		            	 
		            	 //driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[12]/td[3]/div[1]/input[3]")).click();
		            	 driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[1]/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[5]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[6]/td[2]/div[2]/input")).click();
		            	 test.log(LogStatus.PASS, "Clicked on add card button ");
		            	 Thread.sleep(30000);
		            	 
		            	 if (State.equalsIgnoreCase("MO")) {
                             //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input-->local auto
                       driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input")).click();
                        } else if (State.equalsIgnoreCase("NV")) {
                         driver.findElement(locator(Sprop.getProperty("csr_new_loan_nv_product"))).click();

                        }
                         test.log(LogStatus.PASS, "Product selected as " + stateProduct);

                          driver.findElement(By.id("LoanButtonId")).click();
                         test.log(LogStatus.PASS, "Clicked on New Loan button ");
                         Thread.sleep(20000);

                         test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);
                        //if (!(ESign_LoanAmt.isEmpty())) {
                      String ESign_LoanAmt=driver.findElement(By.name("advanceRequestBean.advanceAmt")).getAttribute("value");

                      test.log(LogStatus.PASS, "Loan amount is entered as" + ESign_LoanAmt);
                      Thread.sleep(3000);
                      try {
                       Alert alert = driver.switchTo().alert();
// alert.dismiss();
                       alert.accept();

                   } catch (NoAlertPresentException e) {
// do what you normally would if you didn't have the alert.
                   }

		   }
		if (ESign_CollateralType.equals("CHECK")) {
			driver.findElement(By.id("veh1")).click();
	        test.log(LogStatus.PASS, "clicked on vehchile details radio button ");
	        Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						 Thread.sleep(10000);
						 if (State.equalsIgnoreCase("MO")) {
                             //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input-->local auto
                       driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]/input")).click();
                         } 
						 else if (State.equalsIgnoreCase("NV")) {
                         driver.findElement(locator(Sprop.getProperty("csr_new_loan_nv_product"))).click();
                   }
                  test.log(LogStatus.PASS, "Product selected as " + stateProduct);

                 driver.findElement(By.id("LoanButtonId")).click();
                test.log(LogStatus.PASS, "Clicked on New Loan button ");
                 Thread.sleep(10000);

                test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);
            
            String ESign_LoanAmt=driver.findElement(By.name("advanceRequestBean.advanceAmt")).getAttribute("value");

          test.log(LogStatus.PASS, "Loan amount is entered as" + ESign_LoanAmt);
            Thread.sleep(3000);
          try {
             Alert alert = driver.switchTo().alert();
        // alert.dismiss();
         alert.accept();

        } catch (NoAlertPresentException e) {
        // do what you normally would if you didn't have the alert.
         }

						driver.findElement(By.name("advanceRequestBean.chkgAcctNbr")).sendKeys(last4cheknum);
						test.log(LogStatus.PASS, "	Chkg Acct Nbr(Last 4 Digits Only) is enterted as " + last4cheknum);
						/*driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(Esign_DisbType);
						test.log(LogStatus.PASS, "Disb Type is enterted as " + Esign_DisbType);*/
						
						Thread.sleep(1000);
			            //driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
						//driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(Esign_DisbType);

						driver.findElement(By.name("requestBean.noOfChecks")).sendKeys(No_of_checks);
						test.log(LogStatus.PASS, "Selected no of checks as " + No_of_checks);
						driver.findElement(By.name("requestBean.noOfChecks")).sendKeys(Keys.ENTER);
						Thread.sleep(2000);
						driver.findElement(By.name("chkNbr0")).sendKeys(ESign_CheckNbr);
						test.log(LogStatus.PASS, "Check number is " + ESign_CheckNbr);
						// driver.findElement(By.name("chkBoxNbr0")).click();
						// test.log(LogStatus.PASS, "Selected the Check option radio
						// button");
						driver.findElement(By.name("Print0")).click();
						test.log(LogStatus.PASS, "Clicked on Print button");
						try {
							Alert alert = driver.switchTo().alert();
							String almsg = alert.getText();

							alert.accept();
							test.log(LogStatus.PASS, "alert handled " + almsg);

							// if alert present, accept and move on.

						} catch (NoAlertPresentException e) {
							// do what you normally would if you didn't have the alert.
						}

					}

					// '''''''''''''''''''''''''''''''''''''''''''''//'''''''''''''''''''''''''''''''''''''''''''''''//
					
					if (ESign_CollateralType.equals("ACH")) {
						driver.findElement(By.id("veh1")).click();
				        test.log(LogStatus.PASS, "clicked on vehchile details radio button ");
				        Thread.sleep(2000);
						 driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						 Thread.sleep(10000);
						 if (State.equalsIgnoreCase("MO")) {
                             //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input-->local auto
                       driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input")).click();
                         
						 } 
						 else if (State.equalsIgnoreCase("NV")) {
                         driver.findElement(locator(Sprop.getProperty("csr_new_loan_nv_product"))).click();
                   }
                  test.log(LogStatus.PASS, "Product selected as " + stateProduct);

                 driver.findElement(By.id("LoanButtonId")).click();
                test.log(LogStatus.PASS, "Clicked on New Loan button ");
                 Thread.sleep(10000);

                test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);
            
            String ESign_LoanAmt=driver.findElement(By.name("advanceRequestBean.advanceAmt")).getAttribute("value");

          test.log(LogStatus.PASS, "Loan amount is entered as" + ESign_LoanAmt);
          
          driver.findElement(By.name("advanceRequestBean.chkgAcctNbr")).sendKeys(last4cheknum);
			test.log(LogStatus.PASS, "	Chkg Acct Nbr(Last 4 Digits Only) is enterted as " + last4cheknum);
            Thread.sleep(3000);
        
							//Thread.sleep(10000);
					
			}
          }

		}
            driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).click();
			Thread.sleep(3000);
			driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
			driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(Keys.ENTER);
			test.log(LogStatus.PASS, "Payment Reminder Consent is selected as " + ESign_CourtesyCallConsent);
			Thread.sleep(2000);
			
		Thread.sleep(3000);

		if (ESign_CourtesyCallConsent.equals("Yes")) {
			if (ESign_Preference.equals("Call")) {
				//driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
				//Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);
			}
			if (ESign_Preference.equals("Mail")) {
				driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
				driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);
			}
			if (ESign_Preference.equals("SMS")) {
				driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
				driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				/*try {
					Alert alert = driver.switchTo().alert();
					// alert.dismiss();
					alert.accept();
                    } 
				catch (NoAlertPresentException e){ 
				}*/
			}

		} else {
			driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
		}

		if (AllowPromotion.equals("Yes")) {

			String main_window = driver.getWindowHandle();
			driver.findElement(locator(Sprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
			test.log(LogStatus.PASS, "Promotion button is clicked ");
			Thread.sleep(10000);

			for (String winHandle1 : driver.getWindowHandles()) {
				if (!main_window.equalsIgnoreCase(winHandle1)) {
					Thread.sleep(5000);
					driver.switchTo().window(winHandle1);
					Thread.sleep(5000);
					driver.findElement(locator(Sprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
					test.log(LogStatus.PASS, "Promotion radio button is selected ");
					driver.findElement(locator(Sprop.getProperty("csr_new_loan_promo_ok_btn"))).click();
					test.log(LogStatus.PASS, "OK button is clicked ");

					driver.switchTo().window(main_window);
					try {
						Alert alert = driver.switchTo().alert();
						String almsg = alert.getText();

						alert.accept();
						test.log(LogStatus.PASS, "Alert handled " + almsg);
						test.log(LogStatus.PASS, "Alert accepted");
						Thread.sleep(5000);
						driver.switchTo().window(main_window);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						// if alert present, accept and move on.

					} catch (Exception e) {

					}
					break;
				}

			}
}                                       
		driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(Esign_DisbType);
		test.log(LogStatus.PASS, "Disb Type is enterted as " + Esign_DisbType);
		driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(ESign_Password);
		test.log(LogStatus.PASS, "ESign_Checks is selected as " + ESign_Password);
		driver.findElement(By.name("finishadvance")).click();
		test.log(LogStatus.PASS, "clicked on Finish Loan button ");
		Thread.sleep(1000);
		

		// '''''''''''''''''''''''''''''''''''''''''''''''//'''''''''''''''''''''''''''''''''''''''''''''//
       //Thread.sleep(3000);
		try {
			Alert alert = driver.switchTo().alert();
			String almsg= alert.getText();

			alert.accept();
			test.log(LogStatus.PASS, "alert handled "+almsg);
	}
		catch (NoAlertPresentException e) {
			//do what you normally would if you didn't have the alert.
		}
		driver.findElement(By.name("OKBut")).click();
		test.log(LogStatus.PASS, "Clicked on Yes button ");
		driver.findElement(By.xpath("//*[@id='docEditor']/form/table/tbody/tr[4]/td/input[1]")).click();
		test.log(LogStatus.PASS, "click on Yes button ");
		
	    Thread.sleep(1000);
	    try{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");
		if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td/b")).getText().contains("Advance Completed Successfully")){
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Loan is Completed Successfully");
		}
		else
		{
			test.log(LogStatus.PASS, "<FONT color=green style=Arial>New Loan is not Completed Successfully ");
		}
	    }
	    catch(Exception e)
	    {
	    	
	    }
	    break;
	

}
}
	 
}


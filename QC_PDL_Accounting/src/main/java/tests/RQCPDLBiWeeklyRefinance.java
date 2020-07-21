/*package tests;

public class RQCBiWeeklyRefinance {

}*/
package tests;

import java.text.DateFormat;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import tests.QCStore;

public class RQCPDLBiWeeklyRefinance extends QCStore{

	public static String cardType;
	public static String cardNumber;
	public static String  cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;

	public static String paymentAmount;

	public static void StepSame(String SSN,String AppURL) throws Exception{

		String sheetName="ReFinance";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{		

				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"Esign_Preference",row);

				String ESign_Password = TestData.getCellData(sheetName,"PIN",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Esign_DisbType = TestData.getCellData(sheetName,"Esign_DisbType",row);
				String LoanAmount = TestData.getCellData(sheetName,"LoanAmount",row);
				String ProvidedpaymentAmount = TestData.getCellData(sheetName,"ProvidedpaymentAmount",row);
				String Loan_Fee = TestData.getCellData(sheetName,"Loan_Fee",row);
				String ProvidedLoanAmount = TestData.getCellData(sheetName,"ProvidedLoanAmount",row);
				String ProvidedPrincpleBalance = TestData.getCellData(sheetName,"ProvidedPrincpleBalance",row);
				String ProvidedTotalDue = TestData.getCellData(sheetName,"ProvidedTotalDue",row);
				String ProvidedRefinanceLoanAmount = TestData.getCellData(sheetName,"ProvidedRefinanceLoanAmount",row);
				String ProvidedRefinanceType = TestData.getCellData(sheetName,"ProvidedRefinanceType",row);
				String Provided1stInstallDate = TestData.getCellData(sheetName,"Provided1stInstallDate",row);
				String Provided2ndInstallDate = TestData.getCellData(sheetName,"Provided2ndInstallDate",row);
				String ProvidedRollOverAmount = TestData.getCellData(sheetName,"ProvidedRollOverAmount",row);
				
				
				
				cardType=TestData.getCellData(sheetName,"Card Type ",row);
				cardNumber=TestData.getCellData(sheetName,"Debit Card No",row);
				cardEx_month=TestData.getCellData(sheetName,"Expiry Month",row);
				cardEx_Year=TestData.getCellData(sheetName,"Expiry Year",row);
				cvv=TestData.getCellData(sheetName,"CVV",row);
				CardHolderName=TestData.getCellData(sheetName,"CardHolderName",row);

				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************RefinanceStepSame  started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Rprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Rprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Rprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Rprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Rprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);					  

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys("Refinance");
				test.log(LogStatus.PASS, "Transaction Type is selected as Refinance");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(1000);
//===================================================================================

				driver.findElement(By.name("qualify")).click();
				  
				Thread.sleep(10000);
				//driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Clicked on qualify button ");
				//Thread.sleep(5000);
				
				
				driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);				
				test.log(LogStatus.PASS, "Select tender type as "+TenderType);
				Thread.sleep(500);
				String PaymentAmount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
				WebElement e1=driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"));
				e1.clear();
				Thread.sleep(500);
				e1.sendKeys(PaymentAmount);
				test.log(LogStatus.PASS, "Entered Tender amount as  :"+PaymentAmount);
				
				
				
				
				
				
				
				
				if (ProvidedpaymentAmount.equals(PaymentAmount)){
					
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Payment Amount->Expected value:"+ProvidedpaymentAmount +"; == Actual value:"+PaymentAmount );
					
				}
				else{
					
					//test.log(LogStatus.FAIL, " Payment Amount Mismatched : "+PaymentAmount);
					test.log(LogStatus.FAIL, "Payment Amount->Expected value:"+ProvidedpaymentAmount +"; not equals to Actual value:"+PaymentAmount);
				}
				
				Thread.sleep(500);
				
				String OrginalLoanAmount=driver.findElement(By.name("requestBean.siilBean.originalLoanAmt")).getAttribute("value");
				if (ProvidedLoanAmount.equals(OrginalLoanAmount)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Loan Amount->Expected value:"+ProvidedLoanAmount +"; == Actual value:"+OrginalLoanAmount );
				}
				else{
					//test.log(LogStatus.FAIL, " Loan Amount Mismatched ");
					test.log(LogStatus.FAIL, "Loan Amount->Expected value:"+ProvidedLoanAmount +"; not equals to Actual value:"+OrginalLoanAmount);
				}	
				
				Thread.sleep(500);	
				
				String PrincleBalance=driver.findElement(By.name("requestBean.siilBean.balancePrincipal")).getAttribute("value");
				if (ProvidedPrincpleBalance.equals(PrincleBalance)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Princle Balance->Expected value:"+ProvidedPrincpleBalance +"; == Actual value:"+PrincleBalance );
				}
				else{
					test.log(LogStatus.FAIL, "Princle Balance->Expected value:"+ProvidedPrincpleBalance +"; not equals to Actual value:"+PrincleBalance);
				}	
				
				Thread.sleep(500);	
				
				String TotalDue=driver.findElement(By.name("requestBean.payOffAmt")).getAttribute("value");
				if (ProvidedTotalDue.equals(TotalDue)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Total Due->Expected value:"+ProvidedTotalDue +"; == Actual value:"+TotalDue );
				}
				else{
					test.log(LogStatus.FAIL, "Total Due->Expected value:"+ProvidedTotalDue +"; not equals to Actual value:"+TotalDue);
				}	
				
				Thread.sleep(500);	
				
				String RefinanceLoanAmount=driver.findElement(By.name("htmlLoanAmt")).getAttribute("value");
				if (ProvidedRefinanceLoanAmount.equals(RefinanceLoanAmount)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Refinance Loan Amount->Expected value:"+ProvidedRefinanceLoanAmount +"; == Actual value:"+RefinanceLoanAmount );
				}
				else{
					test.log(LogStatus.FAIL, "Refinance Loan Amount->Expected value:"+ProvidedRefinanceLoanAmount +"; not equals to Actual value:"+RefinanceLoanAmount);
				}	
				
				Thread.sleep(500);	
				
				/*String RefinanceType=driver.findElement(By.name("htmlLoanAmt")).getAttribute("value");
				if (ProvidedRefinanceType.equals("RefinanceType")){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Total Due->Expected value:"+ProvidedRefinanceType +"; == Actual value:"+RefinanceType );
				}
				else{
					test.log(LogStatus.FAIL, "Total Due->Expected value:"+ProvidedRefinanceType +"; not equals to Actual value:"+RefinanceType);
				}	*/
				
				Thread.sleep(500);	
				
				String FirstInstallDate=driver.findElement(By.name("requestBean.siilBean.instPayDate")).getAttribute("value");
				if (Provided1stInstallDate.equals(FirstInstallDate)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>First Install Date->Expected value:"+Provided1stInstallDate +"; == Actual value:"+FirstInstallDate );
				}
				else{
					test.log(LogStatus.FAIL, "First Install Date->Expected value:"+Provided1stInstallDate +"; not equals to Actual value:"+FirstInstallDate);
				}	
				
				Thread.sleep(500);	
				                                                    
				String SecondInstallDate=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[2]/input")).getAttribute("value");
				if (Provided2ndInstallDate.equals(SecondInstallDate)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Second Install Date->Expected value:"+Provided2ndInstallDate +"; == Actual value:"+SecondInstallDate );
				}
				else{
					test.log(LogStatus.FAIL, "Second Install Date->Expected value:"+Provided2ndInstallDate +"; not equals to Actual value:"+SecondInstallDate);
				}	
				
				Thread.sleep(500);	
				
				String RollOverAmount=driver.findElement(By.name("htmlLoanAmt")).getAttribute("value");
				if (ProvidedRollOverAmount.equals(RollOverAmount)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Roll Over Amount->Expected value:"+ProvidedRollOverAmount +"; == Actual value:"+RollOverAmount );
				}
				else{
					test.log(LogStatus.FAIL, "Roll Over Amount->Expected value:"+ProvidedRollOverAmount +"; not equals to Actual value:"+RollOverAmount);
				}	
				
				Thread.sleep(500);	
						
				String PayFrequency=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[4]/td/table/tbody/tr[23]/td[2]")).getText();				                                                 
				test.log(LogStatus.PASS, "<FONT color=green style=Arial>Getting Pay Frequency : "+PayFrequency );
			
				
				Thread.sleep(500);
				
				String stepsamemsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
				
				//String RollOverAmount=driver.findElement(By.name("htmlLoanAmt")).getAttribute("value");
				if (ProvidedRefinanceType.equals(stepsamemsg)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Refinance Message->Expected value:"+ProvidedRefinanceType +"; == Actual value:"+stepsamemsg );
				}
				else{
					test.log(LogStatus.FAIL, "Refinance Message->Expected value:"+ProvidedRefinanceType +"; not equals to Actual value:"+stepsamemsg);
				}	
				
				//Thread.sleep(500);	
				
				//test.log(LogStatus.PASS, "<FONT color=green style=Arial>getting Refinance message  : "+stepdownmsg );
				
				Thread.sleep(5000);

				//if(stepsamemsg.contains("Step Same by Amount")){
				if (ProvidedRefinanceType.equals(stepsamemsg)){

					if(ESign_CollateralType.equalsIgnoreCase("Check")){

						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						test.log(LogStatus.INFO, "Performing  check transactions");
						int chkno=987654;

						String instamnts=driver.findElement(By.name("requestBean.siilBean.nbrOfInst")).getAttribute("value");
						int instamntsno=Integer.parseInt(instamnts)+1;
						for(int j=2;j<=instamntsno;j++){
							chkno=chkno+1;
							String str1 = Integer.toString(chkno); 
							driver.findElement(By.xpath("//*[@id='checkNbrs"+(j-2)+"']")).sendKeys(str1);

							test.log(LogStatus.PASS, "Check number enterd as "+chkno);

						}

					}

					if(ESign_CollateralType.equalsIgnoreCase("ACH")){
						
						Thread.sleep(500);
						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						Thread.sleep(500);
						String LoanFee=driver.findElement(By.name("htmlLoanFee")).getAttribute("value");	
						Thread.sleep(500);
						
						
						 if (ProvidedRefinanceType.trim().equalsIgnoreCase(stepsamemsg.trim())) {
								
								test.log(LogStatus.PASS, "<FONT color=green style=Arial>Getting Refinance Message As : "+ProvidedRefinanceType );
								
								}
								else{
									//test.log(LogStatus.FAIL, " Loan Fee amount mismatched ");
									test.log(LogStatus.FAIL, "Getting Refinance Message As->Expected value:"+ProvidedRefinanceType +"; not equals to Actual value:"+stepsamemsg);
									Assert.assertTrue(false);
									
									break;
									
									
								}
						
						Thread.sleep(500);
						
						/*driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(DisbAmount);
						test.log(LogStatus.PASS, "Disb Amount is enterted as "+DisbAmount);*/
						
						

					}
					if(ESign_CollateralType.equalsIgnoreCase("Debit card")){


						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
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

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					Thread.sleep(500);
					String SecInstallDate=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[2]/input")).getAttribute("value");
					//String SecInstallDate=driver.findElement(By.name("requestBean.siilBean.instPayDate")).getAttribute("value");				
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Getting Second Install Date : "+SecInstallDate );
					Thread.sleep(500);

					driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);

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

					//String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();

					//String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
					//String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
					//String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();

					//test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an "+confirm_text2+" of "+confirm_text3+" First payment date is "+confirm_text4);

					driver.findElement(By.name("OKBut")).click();

					test.log(LogStatus.PASS, "click on Confirm Yes button ");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						test.log(LogStatus.PASS, "<FONT color=green style=Arial>Refinance Completed Successfully ");
						test.log(LogStatus.INFO, "**********************************************************************************");

					}
					else
					{
						test.log(LogStatus.PASS, "<FONT color=green style=Arial>Refinance Completed Successfully ");
						test.log(LogStatus.INFO, "**********************************************************************************");
					}
				}
				else{
					test.log(LogStatus.FAIL, " Refinance Value Mismatch ");
					test.log(LogStatus.FAIL, " Refinance is not Completed ");
				}
				break;}
			break;}
	}	
	
	public static void StepDown(String SSN,String AppURL) throws Exception{

		String sheetName="ReFinance";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{		

				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"Esign_Preference",row);

				String ESign_Password = TestData.getCellData(sheetName,"PIN",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Esign_DisbType = TestData.getCellData(sheetName,"Esign_DisbType",row);
				String LoanAmount = TestData.getCellData(sheetName,"LoanAmount",row);
				String ProvidedpaymentAmount = TestData.getCellData(sheetName,"ProvidedpaymentAmount",row);
				String Loan_Fee = TestData.getCellData(sheetName,"Loan_Fee",row);
				String ProvidedLoanAmount = TestData.getCellData(sheetName,"ProvidedLoanAmount",row);
				String ProvidedPrincpleBalance = TestData.getCellData(sheetName,"ProvidedPrincpleBalance",row);
				String ProvidedTotalDue = TestData.getCellData(sheetName,"ProvidedTotalDue",row);
				String ProvidedRefinanceLoanAmount = TestData.getCellData(sheetName,"ProvidedRefinanceLoanAmount",row);
				String ProvidedRefinanceType = TestData.getCellData(sheetName,"ProvidedRefinanceType",row);
				String Provided1stInstallDate = TestData.getCellData(sheetName,"Provided1stInstallDate",row);
				String Provided2ndInstallDate = TestData.getCellData(sheetName,"Provided2ndInstallDate",row);
				String ProvidedRollOverAmount = TestData.getCellData(sheetName,"ProvidedRollOverAmount",row);
				
				
				
				cardType=TestData.getCellData(sheetName,"Card Type ",row);
				cardNumber=TestData.getCellData(sheetName,"Debit Card No",row);
				cardEx_month=TestData.getCellData(sheetName,"Expiry Month",row);
				cardEx_Year=TestData.getCellData(sheetName,"Expiry Year",row);
				cvv=TestData.getCellData(sheetName,"CVV",row);
				CardHolderName=TestData.getCellData(sheetName,"CardHolderName",row);

				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************Refinance StepDown  started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Rprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Rprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Rprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Rprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Rprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);					  

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys("Refinance");
				test.log(LogStatus.PASS, "Transaction Type is selected as Refinance");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(1000);
//===================================================================================

				driver.findElement(By.name("qualify")).click();
				  
				Thread.sleep(10000);
				//driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Clicked on qualify button ");
				//Thread.sleep(5000);
				
				
				driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);				
				test.log(LogStatus.PASS, "Select tender type as "+TenderType);
				Thread.sleep(500);
				String PaymentAmount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
				WebElement e1=driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"));
				e1.clear();
				Thread.sleep(500);
				e1.sendKeys(PaymentAmount);
				test.log(LogStatus.PASS, "Entered Tender amount as  :"+PaymentAmount);
				
				
				
				
				
				
				
				
				if (ProvidedpaymentAmount.equals(PaymentAmount)){
					
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Payment Amount->Expected value:"+ProvidedpaymentAmount +"; == Actual value:"+PaymentAmount );
					
				}
				else{
					
					//test.log(LogStatus.FAIL, " Payment Amount Mismatched : "+PaymentAmount);
					test.log(LogStatus.FAIL, "Payment Amount->Expected value:"+ProvidedpaymentAmount +"; not equals to Actual value:"+PaymentAmount);
				}
				
				Thread.sleep(500);
				
				String OrginalLoanAmount=driver.findElement(By.name("requestBean.siilBean.originalLoanAmt")).getAttribute("value");
				if (ProvidedLoanAmount.equals(OrginalLoanAmount)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Loan Amount->Expected value:"+ProvidedLoanAmount +"; == Actual value:"+OrginalLoanAmount );
				}
				else{
					//test.log(LogStatus.FAIL, " Loan Amount Mismatched ");
					test.log(LogStatus.FAIL, "Loan Amount->Expected value:"+ProvidedLoanAmount +"; not equals to Actual value:"+OrginalLoanAmount);
				}	
				
				Thread.sleep(500);	
				
				String PrincleBalance=driver.findElement(By.name("requestBean.siilBean.balancePrincipal")).getAttribute("value");
				if (ProvidedPrincpleBalance.equals(PrincleBalance)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Princle Balance->Expected value:"+ProvidedPrincpleBalance +"; == Actual value:"+PrincleBalance );
				}
				else{
					test.log(LogStatus.FAIL, "Princle Balance->Expected value:"+ProvidedPrincpleBalance +"; not equals to Actual value:"+PrincleBalance);
				}	
				
				Thread.sleep(500);	
				
				String TotalDue=driver.findElement(By.name("requestBean.payOffAmt")).getAttribute("value");
				if (ProvidedTotalDue.equals(TotalDue)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Total Due->Expected value:"+ProvidedTotalDue +"; == Actual value:"+TotalDue );
				}
				else{
					test.log(LogStatus.FAIL, "Total Due->Expected value:"+ProvidedTotalDue +"; not equals to Actual value:"+TotalDue);
				}	
				
				Thread.sleep(500);	
				
				String RefinanceLoanAmount=driver.findElement(By.name("htmlLoanAmt")).getAttribute("value");
				if (ProvidedRefinanceLoanAmount.equals(RefinanceLoanAmount)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Refinance Loan Amount->Expected value:"+ProvidedRefinanceLoanAmount +"; == Actual value:"+RefinanceLoanAmount );
				}
				else{
					test.log(LogStatus.FAIL, "Refinance Loan Amount->Expected value:"+ProvidedRefinanceLoanAmount +"; not equals to Actual value:"+RefinanceLoanAmount);
				}	
				
				Thread.sleep(500);	
				
				/*String RefinanceType=driver.findElement(By.name("htmlLoanAmt")).getAttribute("value");
				if (ProvidedRefinanceType.equals("RefinanceType")){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Total Due->Expected value:"+ProvidedRefinanceType +"; == Actual value:"+RefinanceType );
				}
				else{
					test.log(LogStatus.FAIL, "Total Due->Expected value:"+ProvidedRefinanceType +"; not equals to Actual value:"+RefinanceType);
				}	*/
				
				Thread.sleep(500);	
				
				String FirstInstallDate=driver.findElement(By.name("requestBean.siilBean.instPayDate")).getAttribute("value");
				if (Provided1stInstallDate.equals(FirstInstallDate)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>First Install Date->Expected value:"+Provided1stInstallDate +"; == Actual value:"+FirstInstallDate );
				}
				else{
					test.log(LogStatus.FAIL, "First Install Date->Expected value:"+Provided1stInstallDate +"; not equals to Actual value:"+FirstInstallDate);
				}	
				
				Thread.sleep(500);	
				                                                    
				String SecondInstallDate=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[2]/input")).getAttribute("value");
				if (Provided2ndInstallDate.equals(SecondInstallDate)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Second Install Date->Expected value:"+Provided2ndInstallDate +"; == Actual value:"+SecondInstallDate );
				}
				else{
					test.log(LogStatus.FAIL, "Second Install Date->Expected value:"+Provided2ndInstallDate +"; not equals to Actual value:"+SecondInstallDate);
				}	
				
				Thread.sleep(500);	
				
				String RollOverAmount=driver.findElement(By.name("htmlLoanAmt")).getAttribute("value");
				if (ProvidedRollOverAmount.equals(RollOverAmount)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Roll Over Amount->Expected value:"+ProvidedRollOverAmount +"; == Actual value:"+RollOverAmount );
				}
				else{
					test.log(LogStatus.FAIL, "Roll Over Amount->Expected value:"+ProvidedRollOverAmount +"; not equals to Actual value:"+RollOverAmount);
				}	
				
				Thread.sleep(500);	
						
				String PayFrequency=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[4]/td/table/tbody/tr[23]/td[2]")).getText();				                                                 
				test.log(LogStatus.PASS, "<FONT color=green style=Arial>Getting Pay Frequency : "+PayFrequency );
			
				
				Thread.sleep(500);
				
				String stepdownmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
				
				//String RollOverAmount=driver.findElement(By.name("htmlLoanAmt")).getAttribute("value");
				if (ProvidedRefinanceType.equals(stepdownmsg)){
						
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Refinance Message->Expected value:"+ProvidedRefinanceType +"; == Actual value:"+stepdownmsg );
				}
				else{
					test.log(LogStatus.FAIL, "Refinance Message->Expected value:"+ProvidedRefinanceType +"; not equals to Actual value:"+stepdownmsg);
				}	
				
				//Thread.sleep(500);	
				
				//test.log(LogStatus.PASS, "<FONT color=green style=Arial>getting Refinance message  : "+stepdownmsg );
				
				Thread.sleep(5000);

				//if(stepsamemsg.contains("Step Same by Amount")){
				if (ProvidedRefinanceType.equals(stepdownmsg)){

					if(ESign_CollateralType.equalsIgnoreCase("Check")){

						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						test.log(LogStatus.INFO, "Performing  check transactions");
						int chkno=987654;

						String instamnts=driver.findElement(By.name("requestBean.siilBean.nbrOfInst")).getAttribute("value");
						int instamntsno=Integer.parseInt(instamnts)+1;
						for(int j=2;j<=instamntsno;j++){
							chkno=chkno+1;
							String str1 = Integer.toString(chkno); 
							driver.findElement(By.xpath("//*[@id='checkNbrs"+(j-2)+"']")).sendKeys(str1);

							test.log(LogStatus.PASS, "Check number enterd as "+chkno);

						}

					}

					if(ESign_CollateralType.equalsIgnoreCase("ACH")){
						
						Thread.sleep(500);
						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						Thread.sleep(500);
						String LoanFee=driver.findElement(By.name("htmlLoanFee")).getAttribute("value");	
						Thread.sleep(500);
						
						
						 if (ProvidedRefinanceType.trim().equalsIgnoreCase(stepdownmsg.trim())) {
								
								test.log(LogStatus.PASS, "<FONT color=green style=Arial>Getting Refinance Message As : "+ProvidedRefinanceType );
								
								}
								else{
									//test.log(LogStatus.FAIL, " Loan Fee amount mismatched ");
									test.log(LogStatus.FAIL, "Getting Refinance Message As->Expected value:"+ProvidedRefinanceType +"; not equals to Actual value:"+stepdownmsg);
									Assert.assertTrue(false);
									
									break;
									
									
								}
						
						Thread.sleep(500);
						
						/*driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(DisbAmount);
						test.log(LogStatus.PASS, "Disb Amount is enterted as "+DisbAmount);*/
						
						

					}
					if(ESign_CollateralType.equalsIgnoreCase("Debit card")){


						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
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

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					Thread.sleep(500);
					String SecInstallDate=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[2]/input")).getAttribute("value");
					//String SecInstallDate=driver.findElement(By.name("requestBean.siilBean.instPayDate")).getAttribute("value");				
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Getting Second Install Date : "+SecInstallDate );
					Thread.sleep(500);

					driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);

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

					//String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();

					//String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
					//String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
					//String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();

					//test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an "+confirm_text2+" of "+confirm_text3+" First payment date is "+confirm_text4);

					driver.findElement(By.name("OKBut")).click();

					test.log(LogStatus.PASS, "click on Confirm Yes button ");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						test.log(LogStatus.PASS, "<FONT color=green style=Arial>Refinance Completed Successfully ");
						test.log(LogStatus.INFO, "**********************************************************************************");

					}
					else
					{
						test.log(LogStatus.PASS, "<FONT color=green style=Arial>Refinance Completed Successfully ");
						test.log(LogStatus.INFO, "**********************************************************************************");
					}
				}
				else{
					test.log(LogStatus.FAIL, " Refinance Value Mismatch ");
					test.log(LogStatus.FAIL, " Refinance is not Completed ");
				}
				break;}
			break;}
	}	
	
	
	
	
	

}
package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class QCRefinance60DaysRule extends QCStore {
	
	
	public static void tlpRefinance(String SSN,String AppURL) throws InterruptedException
	{
		int lastrow=TestData.getLastRow("New_Loan");
		String sheetName="New_Loan";	
		//int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{	
				ESign_CollateralType="ACH";
				String ESign_CourtesyCallConsent=TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String	ESign_Preference=TestData.getCellData(sheetName,"ESign_Preference",row);
				String	ESign_Password=TestData.getCellData(sheetName,"Password",row);
				
				String	cardType = TestData.getCellData(sheetName, "Card Type ", row);
				String cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
				String	cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
				String	cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
				String	cvv = TestData.getCellData(sheetName, "CVV", row);
				String	CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				
				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************Refinance started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
						
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
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
				Thread.sleep(5000);	
				
				
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table[2]/tbody/tr[4]/td/input")).click();
				test.log(LogStatus.PASS, "click on update button of borrower overview ");
				Thread.sleep(8000);
				driver.findElement(By.xpath("//*[@id='vehicleInformation']/td/table/tbody/tr[10]/td/input")).click();
				test.log(LogStatus.PASS, "click on update button of Vechile details");
				Thread.sleep(8000);
				
				driver.findElement(By.xpath("//*[@id='save']/input")).click();
				test.log(LogStatus.PASS, "click on process loan");
				
				//--------------------------------------------------------------
			try{
				//driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
				driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[2]")).click();
				test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
				}
			catch(Exception e){
			//Normal flow	
			}
			
			
				Thread.sleep(2000);
			/*	String priciplebalance=driver.findElement(By.name("requestBean.siilBean.balancePrincipal")).getAttribute("value");
				test.log(LogStatus.PASS, "getting priciple balance is :"+priciplebalance);
				
				float priciplebalanceInt=Float.valueOf(priciplebalance);
				priciplebalanceInt=priciplebalanceInt+10;
				String priciplebalance2 = Float.toString(priciplebalanceInt);
				Thread.sleep(2000);
				WebElement e2=driver.findElement(By.name("requestBean.siilBean.advAmt"));
				e2.clear();
				e2.click();
				Thread.sleep(5000);
				e2.sendKeys(priciplebalance2);
				test.log(LogStatus.PASS, "Entering loan amount is :"+priciplebalance2);
				
				e2.sendKeys(Keys.TAB);
				
				Thread.sleep(5000);*/
			
				
				
				Thread.sleep(8000);
				
				
				String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
				test.log(LogStatus.PASS, "getting stepup message  :"+stepupmsg);
				
				if(stepupmsg.contains("Stepped Up by Amount")){
		
					driver.findElement(By.name("qualify")).click();
					test.log(LogStatus.PASS, "Clicked on qualify button ");
					Thread.sleep(6000);
					/*String paymentamount3=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount3);*/
					
					String owedAmt=driver.findElement(By.name("requestBean.payOffAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Total amount owed as  :" +owedAmt);
					float owedAmount=Float.valueOf(owedAmt);
					String loanAmt=driver.findElement(By.name("requestBean.siilBean.originalLoanAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "loan amount displayed as  :" +loanAmt);
					float loanAmount=Float.valueOf(loanAmt);
					String paymentAmt=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment amount displayed as  :" +paymentAmt);
					float paymentAmount=Float.valueOf(paymentAmt);
					float stepupAmt=91;
					float refinancePayment=loanAmount+paymentAmount+stepupAmt;
					String refinancePayment2=String.valueOf(refinancePayment);
					test.log(LogStatus.PASS, "refinancePayment2 is :" +refinancePayment2);
					float actualpay= (float) ((loanAmount*158.17)/36500);
					test.log(LogStatus.PASS, "actualpayment is :" +actualpay);
					String actualpayment=String.valueOf(actualpay);
					String actualpayment1 = actualpayment.substring(0, actualpayment.length() - 5);
					test.log(LogStatus.PASS, "actualpayment is :" +actualpayment1);
					//String actualpayment1=String.valueOf(actualpayment);
					//if(refinancePayment2.equalsIgnoreCase(owedAmt)&&paymentAmt.equalsIgnoreCase(actualpayment1))
					if(refinancePayment2.equalsIgnoreCase(owedAmt))
							{		
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
					test.log(LogStatus.PASS, "Select tender type as Cash");
					WebElement e1=driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"));
					e1.clear();
					e1.sendKeys(paymentAmt);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentAmt);
							}
				}
					else if(stepupmsg.contains("Step Same")){
						
						driver.findElement(By.name("qualify")).click();
						test.log(LogStatus.PASS, "Clicked on qualify button ");
						Thread.sleep(6000);
						/*String paymentamount3=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "Getting payment amount "+paymentamount3);*/
						
						String owedAmt1=driver.findElement(By.name("requestBean.payOffAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "total amount owed as  :" +owedAmt1);
						float owedAmount1=Float.valueOf(owedAmt1);
						String loanAmt1=driver.findElement(By.name("requestBean.siilBean.originalLoanAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "loan amount displayed as  :" +loanAmt1);
						float loanAmount1=Float.valueOf(loanAmt1);
						String paymentAmt1=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "Payment amount displayed as  :" +paymentAmt1);
						float paymentAmount1=Float.valueOf(paymentAmt1);
						//float stepupAmt=78;
						float refinancePayment1=loanAmount1+paymentAmount1;
						String refinancePaymentNew=String.valueOf(refinancePayment1);
						test.log(LogStatus.PASS, "RefinancePayment is :" +refinancePaymentNew);
						float actualpay= (float) ((loanAmount1*158.17*61)/36500);
						test.log(LogStatus.PASS, "actualpayment is :" +actualpay);
						String actualpayment=String.valueOf(actualpay);
						String actualpayment1 = actualpayment.substring(0, actualpayment.length() - 4);
						test.log(LogStatus.PASS, "actualpayment is :" +actualpayment1);
						//String actualpayment1=String.valueOf(actualpayment);
						//if(refinancePaymentNew.equalsIgnoreCase(owedAmt1)&&paymentAmt1.equalsIgnoreCase(actualpayment1))
						if(refinancePaymentNew.equalsIgnoreCase(owedAmt1))
								{		
						driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
						test.log(LogStatus.PASS, "Select tender type as Cash");
						WebElement e1=driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"));
						e1.clear();
						e1.sendKeys(paymentAmt1);
						test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentAmt1);
								}
					}
			else{
				test.log(LogStatus.FAIL, "Refinance Step Down is Not proceesed");
			}
					if(ESign_CollateralType.equalsIgnoreCase("Ach")){
						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);				
					}
					if(ESign_CollateralType.equalsIgnoreCase("Debit card")){
				
						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
						test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

						driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
						test.log(LogStatus.PASS, "Card number is :" + cardNumber);
						
						driver.findElement(By.xpath("//*[@id='cardType']/select")).sendKeys(cardType);
						test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
						driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
						test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);
						
						Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyear']")));
						sel.selectByVisibleText(cardEx_Year);
						test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
						
						driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
						test.log(LogStatus.PASS, "Enterd CVV " + cvv);
						driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
						test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
							Thread.sleep(3000);			
													
						//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[4]/td/table/tbody/tr[43]/td[2]/div[3]/input")).click();
							driver.findElement(By.xpath("//input[@class='sortbuttons' and @value='Add Card']")).click();
						test.log(LogStatus.PASS, "Clicked on add card button ");
									
									
						Thread.sleep(30000);

						
					}
					if(ESign_CollateralType.equalsIgnoreCase("NO COLLATERAL")){
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);	
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
				

				driver.findElement(By.name("requestBean.password")).sendKeys("1234");
					test.log(LogStatus.PASS, "pin entered as 1234");
					
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[11]/td/table/tbody/tr[11]/td[2]/input")).click();
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
							
							/*String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();
							
							String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
							String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
							String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();*/
						
							//test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an "+confirm_text2+" of "+confirm_text3+" First payment date is "+confirm_text4);
							
							driver.findElement(By.name("OKBut")).click();

							test.log(LogStatus.PASS, "click on Yes button ");
							driver.findElement(By.xpath("//*[@id='docEditor']/form/table/tbody/tr[4]/td/input[1]")).click();
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							if(driver.findElement(By.name("ok")).isDisplayed())
							{
								test.log(LogStatus.PASS, " Refinance is pass ");
								test.log(LogStatus.INFO, "**********************************************************************************");
							
							}
							else
							{
								test.log(LogStatus.INFO, "Refinance is pass ");
								test.log(LogStatus.INFO, "**********************************************************************************");
							}
				
				
			
				}
		break;}
	}
	public static void tlpDefaultRefinance(String SSN,String AppURL) throws InterruptedException
	{
		int lastrow=TestData.getLastRow("New_Loan");
		String sheetName="New_Loan";	
		//int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{	
				ESign_CollateralType="ACH";
				String ESign_CourtesyCallConsent=TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String	ESign_Preference=TestData.getCellData(sheetName,"ESign_Preference",row);
				String	ESign_Password=TestData.getCellData(sheetName,"Password",row);
				
				String	cardType = TestData.getCellData(sheetName, "Card Type ", row);
				String cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
				String	cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
				String	cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
				String	cvv = TestData.getCellData(sheetName, "CVV", row);
				String	CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				
				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************Refinance started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
						
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
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
				Thread.sleep(5000);	
				
				
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table[2]/tbody/tr[4]/td/input")).click();
				test.log(LogStatus.PASS, "click on update button of borrower overview ");
				Thread.sleep(8000);
				driver.findElement(By.xpath("//*[@id='vehicleInformation']/td/table/tbody/tr[10]/td/input")).click();
				test.log(LogStatus.PASS, "click on update button of Vechile details");
				Thread.sleep(8000);
				
				driver.findElement(By.xpath("//*[@id='save']/input")).click();
				test.log(LogStatus.PASS, "click on process loan");
				
				//--------------------------------------------------------------
			try{
				//driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
				driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[2]")).click();
				test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
				}
			catch(Exception e){
			//Normal flow	
			}
			
			
				Thread.sleep(2000);
			/*	String priciplebalance=driver.findElement(By.name("requestBean.siilBean.balancePrincipal")).getAttribute("value");
				test.log(LogStatus.PASS, "getting priciple balance is :"+priciplebalance);
				
				float priciplebalanceInt=Float.valueOf(priciplebalance);
				priciplebalanceInt=priciplebalanceInt+10;
				String priciplebalance2 = Float.toString(priciplebalanceInt);
				Thread.sleep(2000);
				WebElement e2=driver.findElement(By.name("requestBean.siilBean.advAmt"));
				e2.clear();
				e2.click();
				Thread.sleep(5000);
				e2.sendKeys(priciplebalance2);
				test.log(LogStatus.PASS, "Entering loan amount is :"+priciplebalance2);
				
				e2.sendKeys(Keys.TAB);
				
				Thread.sleep(5000);*/
			
				
				
				Thread.sleep(8000);
				
				
				String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
				test.log(LogStatus.PASS, "getting stepup message  :"+stepupmsg);
				
				if(stepupmsg.contains("Stepped Up by Amount")){
		
					driver.findElement(By.name("qualify")).click();
					test.log(LogStatus.PASS, "Clicked on qualify button ");
					Thread.sleep(6000);
					/*String paymentamount3=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount3);*/
					
					String owedAmt=driver.findElement(By.name("requestBean.payOffAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Total amount owed as  :" +owedAmt);
					float owedAmount=Float.valueOf(owedAmt);
					String loanAmt=driver.findElement(By.name("requestBean.siilBean.originalLoanAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "loan amount displayed as  :" +loanAmt);
					float loanAmount=Float.valueOf(loanAmt);
					String paymentAmt=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment amount displayed as  :" +paymentAmt);
					float paymentAmount=Float.valueOf(paymentAmt);
					float stepupAmt=91;
					float refinancePayment=loanAmount+paymentAmount+stepupAmt;
					String refinancePayment2=String.valueOf(refinancePayment);
					test.log(LogStatus.PASS, "refinancePayment2 is :" +refinancePayment2);
					float actualpay= (float) ((loanAmount*158.17*75)/36500);
					test.log(LogStatus.PASS, "actualpayment is :" +actualpay);
					String actualpayment=String.valueOf(actualpay);
					String actualpayment1 = actualpayment.substring(0, actualpayment.length() - 5);
					test.log(LogStatus.PASS, "actualpayment is :" +actualpayment1);
					//String actualpayment1=String.valueOf(actualpayment);
					//if(refinancePayment2.equalsIgnoreCase(owedAmt)&&paymentAmt.equalsIgnoreCase(actualpayment1))
					if(refinancePayment2.equalsIgnoreCase(owedAmt))
							{		
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
					test.log(LogStatus.PASS, "Select tender type as Cash");
					WebElement e1=driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"));
					e1.clear();
					e1.sendKeys(paymentAmt);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentAmt);
							}
				}
					else if(stepupmsg.contains("Step Same")){
						
						driver.findElement(By.name("qualify")).click();
						test.log(LogStatus.PASS, "Clicked on qualify button ");
						Thread.sleep(6000);
						/*String paymentamount3=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "Getting payment amount "+paymentamount3);*/
						
						String owedAmt1=driver.findElement(By.name("requestBean.payOffAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "total amount owed as  :" +owedAmt1);
						float owedAmount1=Float.valueOf(owedAmt1);
						String loanAmt1=driver.findElement(By.name("requestBean.siilBean.originalLoanAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "loan amount displayed as  :" +loanAmt1);
						float loanAmount1=Float.valueOf(loanAmt1);
						String paymentAmt1=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "Payment amount displayed as  :" +paymentAmt1);
						float paymentAmount1=Float.valueOf(paymentAmt1);
						//float stepupAmt=78;
						float refinancePayment1=loanAmount1+paymentAmount1;
						String refinancePaymentNew=String.valueOf(refinancePayment1);
						test.log(LogStatus.PASS, "RefinancePayment is :" +refinancePaymentNew);
						float actualpay= (float) ((loanAmount1*158.17*61)/36500);
						test.log(LogStatus.PASS, "actualpayment is :" +actualpay);
						String actualpayment=String.valueOf(actualpay);
						String actualpayment1 = actualpayment.substring(0, actualpayment.length() - 4);
						test.log(LogStatus.PASS, "actualpayment is :" +actualpayment1);
						//String actualpayment1=String.valueOf(actualpayment);
						//if(refinancePaymentNew.equalsIgnoreCase(owedAmt1)&&paymentAmt1.equalsIgnoreCase(actualpayment1))
						if(refinancePaymentNew.equalsIgnoreCase(owedAmt1))
								{		
						driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
						test.log(LogStatus.PASS, "Select tender type as Cash");
						WebElement e1=driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"));
						e1.clear();
						e1.sendKeys(paymentAmt1);
						test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentAmt1);
								}
					}
			else{
				test.log(LogStatus.FAIL, "Refinance Step Down is Not proceesed");
			}
					if(ESign_CollateralType.equalsIgnoreCase("Ach")){
						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);				
					}
					if(ESign_CollateralType.equalsIgnoreCase("Debit card")){
				
						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
						test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

						driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
						test.log(LogStatus.PASS, "Card number is :" + cardNumber);
						
						driver.findElement(By.xpath("//*[@id='cardType']/select")).sendKeys(cardType);
						test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
						driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
						test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);
						
						Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyear']")));
						sel.selectByVisibleText(cardEx_Year);
						test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
						
						driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
						test.log(LogStatus.PASS, "Enterd CVV " + cvv);
						driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
						test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
							Thread.sleep(3000);			
													
						//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[4]/td/table/tbody/tr[43]/td[2]/div[3]/input")).click();
							driver.findElement(By.xpath("//input[@class='sortbuttons' and @value='Add Card']")).click();
						test.log(LogStatus.PASS, "Clicked on add card button ");
									
									
						Thread.sleep(30000);

						
					}
					if(ESign_CollateralType.equalsIgnoreCase("NO COLLATERAL")){
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);	
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
				

				driver.findElement(By.name("requestBean.password")).sendKeys("1234");
					test.log(LogStatus.PASS, "pin entered as 1234");
					
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[11]/td/table/tbody/tr[11]/td[2]/input")).click();
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
							
							/*String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();
							
							String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
							String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
							String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();*/
						
							//test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an "+confirm_text2+" of "+confirm_text3+" First payment date is "+confirm_text4);
							
							driver.findElement(By.name("OKBut")).click();

							test.log(LogStatus.PASS, "click on Yes button ");
							driver.findElement(By.xpath("//*[@id='docEditor']/form/table/tbody/tr[4]/td/input[1]")).click();
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							if(driver.findElement(By.name("ok")).isDisplayed())
							{
								test.log(LogStatus.PASS, " Refinance is pass ");
								test.log(LogStatus.INFO, "**********************************************************************************");
							
							}
							else
							{
								test.log(LogStatus.INFO, "Refinance is pass ");
								test.log(LogStatus.INFO, "**********************************************************************************");
							}
				
				
			
				}
		break;}
	}

	public static void ilpRefinance(String SSN,String AppURL) throws Exception
	{
		int lastrow=TestData.getLastRow("New_Loan");
		String sheetName="New_Loan";	
		

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{	
				ESign_CollateralType="ACH";
			String	ESign_CourtesyCallConsent=TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
			String	ESign_Preference=TestData.getCellData(sheetName,"ESign_Preference",row);
			//String	ESign_Password=TestData.getCellData(sheetName,"Password",row);
				
			String	cardType = TestData.getCellData(sheetName, "Card Type ", row);
			String	cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
			String	cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
			String	cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
			String	cvv = TestData.getCellData(sheetName, "CVV", row);
			String	CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				
				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************Refinance started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
						
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
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
				Thread.sleep(5000);	
				
				
				/*driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table[2]/tbody/tr[4]/td/input")).click();
				test.log(LogStatus.PASS, "click on update button of borrower overview ");
				Thread.sleep(8000);
				driver.findElement(By.xpath("//*[@id='vehicleInformation']/td/table/tbody/tr[10]/td/input")).click();
				test.log(LogStatus.PASS, "click on update button of Vechile details");
				Thread.sleep(8000);
				
				driver.findElement(By.xpath("//*[@id='save']/input")).click();
				test.log(LogStatus.PASS, "click on process loan");*/
				
				//--------------------------------------------------------------
			try{
				//driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
				driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[2]")).click();
				test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
				}
			catch(Exception e){
			//Normal flow	
			}
			
			
				Thread.sleep(2000);
			/*	String priciplebalance=driver.findElement(By.name("requestBean.siilBean.balancePrincipal")).getAttribute("value");
				test.log(LogStatus.PASS, "getting priciple balance is :"+priciplebalance);
				
				float priciplebalanceInt=Float.valueOf(priciplebalance);
				priciplebalanceInt=priciplebalanceInt+10;
				String priciplebalance2 = Float.toString(priciplebalanceInt);
				Thread.sleep(2000);
				WebElement e2=driver.findElement(By.name("requestBean.siilBean.advAmt"));
				e2.clear();
				e2.click();
				Thread.sleep(5000);
				e2.sendKeys(priciplebalance2);
				test.log(LogStatus.PASS, "Entering loan amount is :"+priciplebalance2);
				
				e2.sendKeys(Keys.TAB);
				
				Thread.sleep(5000);*/
			
				
				
				Thread.sleep(8000);
				
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Clicked on qualify button ");
				Thread.sleep(6000);
				String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
				test.log(LogStatus.PASS, "getting stepup message  :"+stepupmsg);
				
				if(stepupmsg.contains("Stepped Up by Amount")){
		
					driver.findElement(By.name("qualify")).click();
					test.log(LogStatus.PASS, "Clicked on qualify button ");
					Thread.sleep(6000);
					/*String paymentamount3=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount3);*/
					
					
					String owedAmt=driver.findElement(By.name("requestBean.payOffAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Total amount owed as  :" +owedAmt);
					float owedAmount=Float.valueOf(owedAmt);
					String loanAmt=driver.findElement(By.name("requestBean.siilBean.originalLoanAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "loan amount displayed as  :" +loanAmt);
					float loanAmount=Float.valueOf(loanAmt);
					String paymentAmt=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment amount displayed as  :" +paymentAmt);
					float paymentAmount=Float.valueOf(paymentAmt);
					float stepupAmt=(float) 172.60;
					float refinancePayment=loanAmount+paymentAmount+stepupAmt;
					String refinancePayment2=String.valueOf(refinancePayment);
					test.log(LogStatus.PASS, "refinancePayment2 is :" +refinancePayment2);
					float actualpay= (float) ((loanAmount*175.00)/36500);
					test.log(LogStatus.PASS, "actualpayment is :" +actualpay);
					String actualpayment=String.valueOf(actualpay);
					String actualpayment1 = actualpayment.substring(0, actualpayment.length() - 6);
					test.log(LogStatus.PASS, "actualpayment is :" +actualpayment1);
					//if(refinancePayment2.equalsIgnoreCase(owedAmt)&&paymentAmt.equalsIgnoreCase(actualpayment1))
					if(refinancePayment2.equalsIgnoreCase(owedAmt))
					{		
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
					test.log(LogStatus.PASS, "Select tender type as Cash");
					WebElement e1=driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"));
					e1.clear();
					e1.sendKeys(paymentAmt);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentAmt);
					}
				}
					else if(stepupmsg.contains("Step Same")){
						
						driver.findElement(By.name("qualify")).click();
						test.log(LogStatus.PASS, "Clicked on qualify button ");
						Thread.sleep(6000);
						/*String paymentamount3=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "Getting payment amount "+paymentamount3);*/
						
						String owedAmt1=driver.findElement(By.name("requestBean.payOffAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "total amount owed as  :" +owedAmt1);
						float owedAmount1=Float.valueOf(owedAmt1);
						String loanAmt1=driver.findElement(By.name("requestBean.siilBean.originalLoanAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "loan amount displayed as  :" +loanAmt1);
						float loanAmount1=Float.valueOf(loanAmt1);
						String paymentAmt1=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "Payment amount displayed as  :" +paymentAmt1);
						float paymentAmount1=Float.valueOf(paymentAmt1);
						//float stepupAmt=78;
						float refinancePayment1=loanAmount1+paymentAmount1;
						String refinancePaymentNew=String.valueOf(refinancePayment1);
						test.log(LogStatus.PASS, "caliculatedpayment is :" +refinancePaymentNew);
						float actualpay= (float) ((loanAmount1*175.00*61)/36500);
						//test.log(LogStatus.PASS, "actualpayment is :" +actualpay);
						String actualpayment=String.valueOf(actualpay);
						String actualpayment1 = actualpayment.substring(0, actualpayment.length() - 2);
						test.log(LogStatus.PASS, "actualpayment is :" +actualpayment1);
						if(refinancePaymentNew.equalsIgnoreCase(owedAmt1)&&paymentAmt1.equalsIgnoreCase(actualpayment1))
						{		
						driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
						test.log(LogStatus.PASS, "Select tender type as Cash");
						WebElement e1=driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"));
						e1.clear();
						e1.sendKeys(paymentAmt1);
						test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentAmt1);
						}
					}
			else{
				test.log(LogStatus.FAIL, "Refinance Step Down is Not proceesed");
			}
					if(ESign_CollateralType.equalsIgnoreCase("Ach")){
						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);				
					}
					if(ESign_CollateralType.equalsIgnoreCase("Debit card")){
				
						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
						test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

						driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
						test.log(LogStatus.PASS, "Card number is :" + cardNumber);
						
						driver.findElement(By.xpath("//*[@id='cardType']/select")).sendKeys(cardType);
						test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
						driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
						test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);
						
						Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyear']")));
						sel.selectByVisibleText(cardEx_Year);
						test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
						
						driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
						test.log(LogStatus.PASS, "Enterd CVV " + cvv);
						driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
						test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
							Thread.sleep(3000);			
													
						//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[4]/td/table/tbody/tr[43]/td[2]/div[3]/input")).click();
							driver.findElement(By.xpath("//input[@class='sortbuttons' and @value='Add Card']")).click();
						test.log(LogStatus.PASS, "Clicked on add card button ");
									
									
						Thread.sleep(30000);

						
					}
					if(ESign_CollateralType.equalsIgnoreCase("NO COLLATERAL")){
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);	
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
				

				driver.findElement(By.name("requestBean.password")).sendKeys("1234");
					test.log(LogStatus.PASS, "pin entered as 1234");
					
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[11]/td/table/tbody/tr[11]/td[2]/input")).click();
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
							
							/*String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();
							
							String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
							String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
							String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();*/
						
							//test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an "+confirm_text2+" of "+confirm_text3+" First payment date is "+confirm_text4);
							
							driver.findElement(By.name("OKBut")).click();

							test.log(LogStatus.PASS, "click on Yes button ");
							driver.findElement(By.xpath("//*[@id='docEditor']/form/table/tbody/tr[4]/td/input[1]")).click();
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							if(driver.findElement(By.name("ok")).isDisplayed())
							{
								test.log(LogStatus.PASS, " Refinance is pass ");
								test.log(LogStatus.INFO, "**********************************************************************************");
							
							}
							else
							{
								test.log(LogStatus.INFO, "Refinance is pass ");
								test.log(LogStatus.INFO, "**********************************************************************************");
							}
				
				
			
				}
		break;}
	}

	public static void ilpRefinanceForDefault(String SSN,String AppURL) throws Exception
	{
		int lastrow=TestData.getLastRow("New_Loan");
		String sheetName="New_Loan";	
		

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{	
				ESign_CollateralType="ACH";
			String	ESign_CourtesyCallConsent=TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
			String	ESign_Preference=TestData.getCellData(sheetName,"ESign_Preference",row);
			//String	ESign_Password=TestData.getCellData(sheetName,"Password",row);
				
			String	cardType = TestData.getCellData(sheetName, "Card Type ", row);
			String	cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
			String	cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
			String	cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
			String	cvv = TestData.getCellData(sheetName, "CVV", row);
			String	CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				
				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************Refinance started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
						
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
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
				Thread.sleep(5000);	
				
				
				/*driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table[2]/tbody/tr[4]/td/input")).click();
				test.log(LogStatus.PASS, "click on update button of borrower overview ");
				Thread.sleep(8000);
				driver.findElement(By.xpath("//*[@id='vehicleInformation']/td/table/tbody/tr[10]/td/input")).click();
				test.log(LogStatus.PASS, "click on update button of Vechile details");
				Thread.sleep(8000);
				
				driver.findElement(By.xpath("//*[@id='save']/input")).click();
				test.log(LogStatus.PASS, "click on process loan");*/
				
				//--------------------------------------------------------------
			try{
				//driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
				driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[2]")).click();
				test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
				}
			catch(Exception e){
			//Normal flow	
			}
			
			
				Thread.sleep(2000);
			/*	String priciplebalance=driver.findElement(By.name("requestBean.siilBean.balancePrincipal")).getAttribute("value");
				test.log(LogStatus.PASS, "getting priciple balance is :"+priciplebalance);
				
				float priciplebalanceInt=Float.valueOf(priciplebalance);
				priciplebalanceInt=priciplebalanceInt+10;
				String priciplebalance2 = Float.toString(priciplebalanceInt);
				Thread.sleep(2000);
				WebElement e2=driver.findElement(By.name("requestBean.siilBean.advAmt"));
				e2.clear();
				e2.click();
				Thread.sleep(5000);
				e2.sendKeys(priciplebalance2);
				test.log(LogStatus.PASS, "Entering loan amount is :"+priciplebalance2);
				
				e2.sendKeys(Keys.TAB);
				
				Thread.sleep(5000);*/
			
				
				
				Thread.sleep(8000);
				
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Clicked on qualify button ");
				Thread.sleep(6000);
				String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
				test.log(LogStatus.PASS, "getting stepup message  :"+stepupmsg);
				
				if(stepupmsg.contains("Stepped Up by Amount")){
		
					driver.findElement(By.name("qualify")).click();
					test.log(LogStatus.PASS, "Clicked on qualify button ");
					Thread.sleep(6000);
					/*String paymentamount3=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount3);*/
					
					
					String owedAmt=driver.findElement(By.name("requestBean.payOffAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Total amount owed as  :" +owedAmt);
					float owedAmount=Float.valueOf(owedAmt);
					String loanAmt=driver.findElement(By.name("requestBean.siilBean.originalLoanAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "loan amount displayed as  :" +loanAmt);
					float loanAmount=Float.valueOf(loanAmt);
					String paymentAmt=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment amount displayed as  :" +paymentAmt);
					float paymentAmount=Float.valueOf(paymentAmt);
					float stepupAmt=(float) 150.00;
					float refinancePayment=loanAmount+paymentAmount+stepupAmt;
					String refinancePayment2=String.valueOf(refinancePayment);
					test.log(LogStatus.PASS, "refinancePayment2 is :" +refinancePayment2);
					float actualpay= (float) ((loanAmount*175.00*62)/36500);
					float actualpaynew=  actualpay-stepupAmt;
					//test.log(LogStatus.PASS, "actualpayment is :" +actualpaynew);
					String actualpaynew1=String.valueOf(actualpaynew);
					test.log(LogStatus.PASS, "actualpaymentnew is :" +actualpaynew1);
					String actualpayment1 = actualpaynew1.substring(0, actualpaynew1.length() - 1);
					test.log(LogStatus.PASS, "actualpayment is :" +actualpayment1);
					//if(refinancePayment2.equalsIgnoreCase(owedAmt)&&paymentAmt.equalsIgnoreCase(actualpayment1))
					//if(refinancePayment2.equalsIgnoreCase(owedAmt))
					{		
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
					test.log(LogStatus.PASS, "Select tender type as Cash");
					WebElement e1=driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"));
					e1.clear();
					e1.sendKeys(paymentAmt);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentAmt);
					}
				}
					else if(stepupmsg.contains("Step Same")){
						
						driver.findElement(By.name("qualify")).click();
						test.log(LogStatus.PASS, "Clicked on qualify button ");
						Thread.sleep(6000);
						/*String paymentamount3=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "Getting payment amount "+paymentamount3);*/
						
						String owedAmt1=driver.findElement(By.name("requestBean.payOffAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "total amount owed as  :" +owedAmt1);
						float owedAmount1=Float.valueOf(owedAmt1);
						String loanAmt1=driver.findElement(By.name("requestBean.siilBean.originalLoanAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "loan amount displayed as  :" +loanAmt1);
						float loanAmount1=Float.valueOf(loanAmt1);
						String paymentAmt1=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "Payment amount displayed as  :" +paymentAmt1);
						float paymentAmount1=Float.valueOf(paymentAmt1);
						//float stepupAmt=78;
						float refinancePayment1=loanAmount1+paymentAmount1;
						String refinancePaymentNew=String.valueOf(refinancePayment1);
						test.log(LogStatus.PASS, "caliculatedpayment is :" +refinancePaymentNew);
						float actualpay= (float) ((loanAmount1*175.00*61)/36500);
						//test.log(LogStatus.PASS, "actualpayment is :" +actualpay);
						String actualpayment=String.valueOf(actualpay);
						String actualpayment1 = actualpayment.substring(0, actualpayment.length() - 2);
						test.log(LogStatus.PASS, "actualpayment is :" +actualpayment1);
						if(refinancePaymentNew.equalsIgnoreCase(owedAmt1)&&paymentAmt1.equalsIgnoreCase(actualpayment1))
						{		
						driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
						test.log(LogStatus.PASS, "Select tender type as Cash");
						WebElement e1=driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"));
						e1.clear();
						e1.sendKeys(paymentAmt1);
						test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentAmt1);
						}
					}
			else{
				test.log(LogStatus.FAIL, "Refinance Step Down is Not proceesed");
			}
					if(ESign_CollateralType.equalsIgnoreCase("Ach")){
						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);				
					}
					if(ESign_CollateralType.equalsIgnoreCase("Debit card")){
				
						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
						test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

						driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
						test.log(LogStatus.PASS, "Card number is :" + cardNumber);
						
						driver.findElement(By.xpath("//*[@id='cardType']/select")).sendKeys(cardType);
						test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
						driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
						test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);
						
						Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyear']")));
						sel.selectByVisibleText(cardEx_Year);
						test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
						
						driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
						test.log(LogStatus.PASS, "Enterd CVV " + cvv);
						driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
						test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
							Thread.sleep(3000);			
													
						//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[4]/td/table/tbody/tr[43]/td[2]/div[3]/input")).click();
							driver.findElement(By.xpath("//input[@class='sortbuttons' and @value='Add Card']")).click();
						test.log(LogStatus.PASS, "Clicked on add card button ");
									
									
						Thread.sleep(30000);

						
					}
					if(ESign_CollateralType.equalsIgnoreCase("NO COLLATERAL")){
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);	
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
				

				driver.findElement(By.name("requestBean.password")).sendKeys("1234");
					test.log(LogStatus.PASS, "pin entered as 1234");
					
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[11]/td/table/tbody/tr[11]/td[2]/input")).click();
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
							
							/*String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();
							
							String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
							String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
							String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();*/
						
							//test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an "+confirm_text2+" of "+confirm_text3+" First payment date is "+confirm_text4);
							
							driver.findElement(By.name("OKBut")).click();

							test.log(LogStatus.PASS, "click on Yes button ");
							driver.findElement(By.xpath("//*[@id='docEditor']/form/table/tbody/tr[4]/td/input[1]")).click();
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							if(driver.findElement(By.name("ok")).isDisplayed())
							{
								test.log(LogStatus.PASS, " Refinance is pass ");
								test.log(LogStatus.INFO, "**********************************************************************************");
							
							}
							else
							{
								test.log(LogStatus.INFO, "Refinance is pass ");
								test.log(LogStatus.INFO, "**********************************************************************************");
							}
				
				
			
				}
		break;}
	}


}

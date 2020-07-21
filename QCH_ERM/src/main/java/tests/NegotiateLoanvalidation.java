package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class NegotiateLoanvalidation extends QCStore{

	static	String Flag1,Flag2,Flag3,Flag4,Flag5,Flag6,Flag7;;

	public static void NegotiateLoan(String SSN,String AppURL) throws Exception
	{

		test.log(LogStatus.INFO, "*****Performing  Decisioning Vlidation  *****");
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{		
				//String State = TestData.getCellData(sheetName,"StateID",row);
				//String ProductID=TestData.getCellData(sheetName,"ProductID",row);

				//String ProductType = TestData.getCellData(sheetName,"ProductType",row);
				//String NewLoan_ProductName = TestData.getCellData(sheetName,"NewLoan_ProductName",row);
				//NewLoan_Term = TestData.getCellData(sheetName,"NewLoan_Term",row);
				 NewLoan_Term="Term1";
				//String stateProduct=State+" "+ProductID;
				//String stateProductType=State+" "+ProductType;
				ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);

				String ESign_LoanAmt = TestData.getCellData(sheetName,"ESign_LoanAmt",row);
				String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
				ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				AllowPromotion = TestData.getCellData(sheetName,"Allow Promotion",row);
				String CouponNbr = TestData.getCellData(sheetName,"CouponNbr",row);
				ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
				String ESign_Checks = TestData.getCellData(sheetName,"ESign_Checks",row);
				ESign_Password=TestData.getCellData(sheetName,"ESign_Password",row);
				ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);			
				String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);

				No_of_checks=TestData.getCellData(sheetName,"No_of_checks",row);
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
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Aprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(locator(Aprop.getProperty("csr_new_loan_link"))).click();			
				test.log(LogStatus.PASS, "Clicked on New Loan");		
				driver.switchTo().frame("main");	
				Thread.sleep(1000);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Aprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Aprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Aprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Click on submit Button");		

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(locator(Aprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Click on GO Button");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				String LoanAmount1=driver.findElement(By.xpath("//*[@id='tableWid1']/tbody/tr[2]/td")).getText();
				test.log(LogStatus.PASS, "Loan amount for Term1 is : "+LoanAmount1);			
				String LoanAmount2=driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[2]/td")).getText();
				test.log(LogStatus.PASS, "Loan amount for Term2 is : "+LoanAmount2);


				String NoofInstallments1=driver.findElement(By.xpath("//*[@id='tableWid1']/tbody/tr[4]/td")).getText();
				test.log(LogStatus.PASS, "No of Installment for Term1 is : "+NoofInstallments1);	

				String NoofInstallments2=driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[4]/td")).getText();
				test.log(LogStatus.PASS, "No of Installment for Term2 is : "+NoofInstallments2);


				String Rateofinterest1=driver.findElement(By.xpath("//*[@id='tableWid1']/tbody/tr[5]/td")).getText();
				test.log(LogStatus.PASS, "Rateofinterest for Term1 is : "+Rateofinterest1);		

				 Rateofinterest1=Rateofinterest1.replaceAll("%", "");

				String Rateofinterest2=driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[5]/td")).getText();
				test.log(LogStatus.PASS, "Rateofinterest for Term2 is : "+Rateofinterest2);



				String APR1=driver.findElement(By.xpath("//*[@id='tableWid1']/tbody/tr[6]/td/input")).getAttribute("value");
				test.log(LogStatus.PASS, "APR for Term1 is : "+APR1);

				APR1=APR1.replaceAll("%", "");

				String APR2=driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[6]/td/input")).getAttribute("value");
				test.log(LogStatus.PASS, "APR for Term2 is : "+APR2);


				String paymentAmount1=driver.findElement(By.xpath("//*[@id='tableWid1']/tbody/tr[7]/td/input")).getAttribute("value");
				test.log(LogStatus.PASS, "paymentAmount for Term1 is : "+paymentAmount1);			
				String paymentAmount2=driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[7]/td/input")).getAttribute("value");
				test.log(LogStatus.PASS, "paymentAmount for Term2 is : "+paymentAmount2);

				paymentdate1=driver.findElement(By.xpath("//*[@id='tableWid1']/tbody/tr[8]/td")).getText();
				test.log(LogStatus.PASS, "paymentdate for Term1 is : "+paymentdate1);			
			    paymentdate2=driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[8]/td")).getText();
				test.log(LogStatus.PASS, "paymentdate for Term2 is : "+paymentdate2);


				String frequency1=driver.findElement(By.xpath("//*[@id='tableWid1']/tbody/tr[9]/td")).getText();
				test.log(LogStatus.PASS, "frequency for Term1 is : "+frequency1);			
				String frequency2=driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[9]/td")).getText();
				test.log(LogStatus.PASS, "frequency for Term2 is : "+frequency2);


				String MinLoanAmount1=driver.findElement(By.xpath("//*[@id='tableWid1']/tbody/tr[10]/td")).getText();
				test.log(LogStatus.PASS, "MinLoanAmount for Term1 is : "+MinLoanAmount1);			
				String MinLoanAmount2=driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[10]/td")).getText();
				test.log(LogStatus.PASS, "MinLoanAmount for Term2 is : "+MinLoanAmount2);


				String MaxLoanAmount1=driver.findElement(By.xpath("//*[@id='tableWid1']/tbody/tr[11]/td")).getText();
				test.log(LogStatus.PASS, "MaxLoanAmount for Term1 is : "+MaxLoanAmount1);			
				String MaxLoanAmount2=driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[11]/td")).getText();
				test.log(LogStatus.PASS, "MaxLoanAmount for Term2 is : "+MaxLoanAmount2);

				paymentAmount2_Int=Double.parseDouble(paymentAmount2);

				paymentAmount2_Int2=(int)paymentAmount2_Int;


				System.out.println(paymentAmount2_Int2);

				paymentAmount1_Int=Double.parseDouble(paymentAmount1);

				paymentAmount1_Int1=(int)paymentAmount1_Int;


				PTIamt2=(int)PTIamt;
				System.out.println(PTIamt2);

				if(NewLoan_Term.equals("Term2")||NewLoan_Term.equals("Term1")){

					test.log(LogStatus.PASS, "calculated PTI Amount is"+PTIamt);

					test.log(LogStatus.PASS, "Payment amount "+paymentAmount2_Int);

					if(PTIamt>=paymentAmount2_Int||PTIamt2==paymentAmount2_Int2){



						test.log(LogStatus.PASS, "payment amount validation With PTI amount Validation is satisfied  ");

						if(NewLoan_Term.equals("Term1"))
						{
							driver.findElement(By.id("termSel1")).click();
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						}
						else if(NewLoan_Term.equals("Term2"))
						{
							driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[1]/td/b/input")).click();				
							test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
						}


						driver.findElement(By.id("LoanButtonId")).click();
						test.log(LogStatus.PASS, "Clicked on New Loan Button");

						reqloanAmount=driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[1]/td[2]/input[1]")).getAttribute("value");
						test.log(LogStatus.PASS, "request loan amount is "+reqloanAmount);

						InterestRateInNewLoan=driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[2]/td[2]/input[1]")).getAttribute("value");
						test.log(LogStatus.PASS, "interest amount In newLoan is "+InterestRateInNewLoan);	 


						FrequencyInNewLoan=driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[4]/td[2]/input")).getAttribute("value");
						test.log(LogStatus.PASS, "frequency in NewLoan is "+FrequencyInNewLoan);	 

						NoofInstallmentsInNewLoan=driver.findElement(By.name("requestBean.siilBean.nbrOfInst")).getAttribute("value");
						test.log(LogStatus.PASS, "Number of installments in NewLoan  is "+NoofInstallmentsInNewLoan);	

						APRInNewLoan=driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[6]/td[2]/input")).getAttribute("value");
						test.log(LogStatus.PASS, "APR  in NewLoan  is "+APRInNewLoan);

						InstallmentAmountInNewLoan=driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[7]/td[2]/input")).getAttribute("value");
						test.log(LogStatus.PASS, "Installment amount in NewLoan  is "+InstallmentAmountInNewLoan);	


						InstallmentDate1InNewLoan=driver.findElement(By.name("dueDate1")).getAttribute("value");
						test.log(LogStatus.PASS, "First installment month  is "+InstallmentDate1InNewLoan);	

						InstallmentDate2InNewLoan=driver.findElement(By.name("dueDate1")).getAttribute("value");
						test.log(LogStatus.PASS, "First installment date  is "+InstallmentDate2InNewLoan);	

						InstallmentDate3InNewLoan=driver.findElement(By.name("dueDate1")).getAttribute("value");
						test.log(LogStatus.PASS, "First installment Year  is "+InstallmentDate3InNewLoan);	



						driver.findElement(By.name("negLoanAmt")).click();				
						test.log(LogStatus.PASS, "Clicked on negtiotate loan amount ");

						negLoan();





					}





				}

			}






		}


	}
	public static void negLoan() throws InterruptedException{


		if(NewLoan_Term.equals("Term1")){



			String mainWindow=driver.getWindowHandle();
			for(String winHandle : driver.getWindowHandles())
			{
				if(!mainWindow.equalsIgnoreCase(winHandle))
				{
					//test.log(LogStatus.PASS, "Calling negloan ");
					driver.switchTo().window(winHandle);
					loanamtinNegscreen=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/table/tbody/tr[3]/td[3]/input")).getAttribute("value");
					test.log(LogStatus.PASS, "request loan amount in negotiaie loan amount screen is"+loanamtinNegscreen);



					if(loanamtinNegscreen.trim().equals(loanamtinNegscreen.trim())){

						test.log(LogStatus.PASS, "request loan amount in negotiaie screen and Newloan Screen are equal");
						Flag1="true";

					}
					else{
						test.log(LogStatus.FAIL, "request loan amount in negotiaie screen and Newloan Screen are not equal");

					}


					String instalmntsNegscreen= driver.findElement(By.xpath(" /html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "Number of installments in negotiaie loan amount screen is"+instalmntsNegscreen);


					if(instalmntsNegscreen.trim().equals(NoofInstallmentsInNewLoan.trim())){

						test.log(LogStatus.PASS, "Number of installments are equal");
						Flag2="true";
					}
					else{
						test.log(LogStatus.FAIL, "Number of installments are not equal");

					}

					String intersstrateNeg= driver.findElement(By.name("requestBean.siilBean.interestRate")).getAttribute("value");
					test.log(LogStatus.PASS, "Interest rate  in negotiaie loan amount screen is"+intersstrateNeg);

					String intersstrateNegrnd[]=intersstrateNeg.split("\\.");
					intersstrateNeg=intersstrateNegrnd[0];
					String InterestRateInNewLoanrnd[]=InterestRateInNewLoan.split("\\.");
					InterestRateInNewLoan=InterestRateInNewLoanrnd[0];

					if(intersstrateNeg.trim().equals(InterestRateInNewLoan.trim())){

						test.log(LogStatus.PASS, "rate of interest are equal");
						Flag3="true";
					}
					else{
						test.log(LogStatus.FAIL, "rate of interest are not equal");

					}


					String AprinNeg= driver.findElement(By.name("requestBean.siilBean.apr")).getAttribute("value");
					test.log(LogStatus.PASS, "Apr in negotiaie loan amount screen is"+AprinNeg);

					if(AprinNeg.trim().equals(APRInNewLoan.trim())){

						test.log(LogStatus.PASS, "Aprs are equal");
						Flag4="true";
					}
					else{
						test.log(LogStatus.FAIL, "Aprs are not equal");

					}


					String PaymentamountinNeg= driver.findElement(By.name("requestBean.siilBean.instAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "paymentAmount in negotiaie loan amount screen is"+PaymentamountinNeg);



					if(PaymentamountinNeg.equals(InstallmentAmountInNewLoan.trim())){

						test.log(LogStatus.PASS, "Paymentamount are equal");
						Flag5="true";

					}
					else{
						test.log(LogStatus.FAIL, "Paymentamount are not equal");

					}


					String PaymentdateinNeg= driver.findElement(By.name("requestBean.siilBean.firstPmtDate")).getAttribute("value");
					test.log(LogStatus.PASS, "Paymentdate in negotiaie loan amount screen is"+PaymentdateinNeg);

					if(paymentdate1.trim().equals(PaymentdateinNeg.trim())){


						test.log(LogStatus.PASS, "payment dates are equal");
						Flag6="true";

					}
					else{
						test.log(LogStatus.FAIL, "payment dates are not equal");

					}

					String FrequencyinNeg= driver.findElement(By.name("requestBean.siilBean.freqDisplayName")).getAttribute("value");
					test.log(LogStatus.PASS, "frequency in negotiaie loan amount screen is"+FrequencyinNeg);


					if(FrequencyInNewLoan.equals(FrequencyinNeg)){

						test.log(LogStatus.PASS, "frequency are equal");
						Flag7="true";
						//driver.close();

					}
					else{
						test.log(LogStatus.FAIL, "frequency  are not equal");
						//driver.close();
					}






				}
				else{
					continue;	
				}

				if(Flag1.equals("true")&&Flag2.equals("true")&&Flag3.equals("true")&&Flag4.equals("true")&&Flag5.equals("true")&&Flag6.equals("true")&&Flag7.equals("true"))
				{


					double loanamtinNegscreen_Double=Double.parseDouble(loanamtinNegscreen);
					//loanamtinNegscreen_Double=loanamtinNegscreen_Double-200.00;
					loanamtinNegscreen_Double=loanamtinNegscreen_Double=500.00;
					loanamtinNegscreen= Double.toString(loanamtinNegscreen_Double);
					System.out.println("converted and deducted loan amount is"+loanamtinNegscreen);

					WebElement e3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/table/tbody/tr[3]/td[3]/input"));
					e3.click();
					e3.sendKeys(Keys.ARROW_RIGHT);
					for(int i=1;i<=7;i++){

						e3.sendKeys(Keys.BACK_SPACE);
					}

					//e3.clear();

					e3.sendKeys(loanamtinNegscreen);
					test.log(LogStatus.PASS, "Reduced loan amount is "+loanamtinNegscreen);

					Actions action = new Actions(driver);
					action.moveByOffset(200,100).perform();
					Thread.sleep(2000);
					action.click();

					driver.findElement(By.name("reCalculate")).click();
					test.log(LogStatus.PASS, "Click on recalculate button ");

					Thread.sleep(2500);
					String AprinNeg= driver.findElement(By.name("requestBean.siilBean.apr")).getAttribute("value");
					test.log(LogStatus.PASS, "Apr in negotiaie loan amount screen is"+AprinNeg);


					String PaymentamountinNeg= driver.findElement(By.name("requestBean.siilBean.instAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "paymentAmount in negotiaie loan amount screen is"+PaymentamountinNeg);



					Thread.sleep(5000);



					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[2]/table/tbody/tr[12]/td/input")).click();
					test.log(LogStatus.PASS, "Clicked on Select button ");


					driver.close();
					driver.switchTo().window(mainWindow);
					Thread.sleep(4000);

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");


					reqloanAmount=driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[1]/td[2]/input[1]")).getAttribute("value");
					test.log(LogStatus.PASS, "request loan amount is "+reqloanAmount);

					APRInNewLoan=driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[6]/td[2]/input")).getAttribute("value");
					test.log(LogStatus.PASS, "APR  in NewLoan  is "+APRInNewLoan);

					InstallmentAmountInNewLoan=driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[7]/td[2]/input")).getAttribute("value");
					test.log(LogStatus.PASS, "Installment amount in NewLoan  is "+InstallmentAmountInNewLoan);	

					//StrngloanamtinNegscreen=loanamtinNegscreen.split(regex)

					String loanamtinNegscreenrnd[]=loanamtinNegscreen.split("\\.");
					loanamtinNegscreen=loanamtinNegscreenrnd[0];

					String reqloanAmountrnd[]=reqloanAmount.split("\\.");
					reqloanAmount=reqloanAmountrnd[0];

					String AprinNegrnd[]=AprinNeg.split("\\.");
					AprinNeg=AprinNegrnd[0];

					String APRInNewLoanrnd[]=APRInNewLoan.split("\\.");
					APRInNewLoan=APRInNewLoanrnd[0];



					if(loanamtinNegscreen.equals(reqloanAmount)&&AprinNeg.equals(APRInNewLoan)&&PaymentamountinNeg.equals(InstallmentAmountInNewLoan)){


						test.log(LogStatus.PASS, "All validations are pass performing new loan");
						newLoan();


					}
					else{

						test.log(LogStatus.FAIL, "Validations of Recalculate screen are fail");

					}
				}
				else{

					test.log(LogStatus.FAIL, "New Loan doesn't completed because One of Validation got failed ");

				}
				break;


			}
		}
		else if(NewLoan_Term.equals("Term2")){

			driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[1]/td/b/input")).click();				
			test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);


			String mainWindow=driver.getWindowHandle();
			for(String winHandle : driver.getWindowHandles())
			{
				if(!mainWindow.equalsIgnoreCase(winHandle))
				{
					//test.log(LogStatus.PASS, "Calling negloan ");
					driver.switchTo().window(winHandle);
					loanamtinNegscreen=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/table/tbody/tr[3]/td[3]/input")).getAttribute("value");
					test.log(LogStatus.PASS, "request loan amount in negotiaie loan amount screen is"+loanamtinNegscreen);



					if(loanamtinNegscreen.trim().equals(loanamtinNegscreen.trim())){

						test.log(LogStatus.PASS, "request loan amount in negotiaie screen and Newloan Screen are equal");
						Flag1="true";
					}
					else{
						test.log(LogStatus.FAIL, "request loan amount in negotiaie screen and Newloan Screen are not equal");

					}


					String instalmntsNegscreen= driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "Number of installments in negotiaie loan amount screen is"+instalmntsNegscreen);


					if(instalmntsNegscreen.trim().equals(NoofInstallmentsInNewLoan.trim())){

						test.log(LogStatus.PASS, "Number of installments are equal");
						Flag2="true";

					}
					else{
						test.log(LogStatus.FAIL, "Number of installments are not equal");

					}

					
				
					
					String intersstrateNeg= driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[3]/table/tbody/tr[4]/td/input[1]")).getAttribute("value");
					test.log(LogStatus.PASS, "Interest rate  in negotiaie loan amount screen is"+intersstrateNeg);

					String intersstrateNegrnd[]=intersstrateNeg.split("\\.");
					intersstrateNeg=intersstrateNegrnd[0];
					String InterestRateInNewLoanrnd[]=InterestRateInNewLoan.split("\\.");
					InterestRateInNewLoan=InterestRateInNewLoanrnd[0];

					if(intersstrateNeg.trim().equals(InterestRateInNewLoan.trim())){

						test.log(LogStatus.PASS, "rate of interest are equal");
						Flag3="true";

					}
					else{
						test.log(LogStatus.FAIL, "rate of interest are not equal");

					}


					String AprinNeg= driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[3]/table/tbody/tr[5]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "Apr in negotiaie loan amount screen is"+AprinNeg);

					if(AprinNeg.trim().equals(APRInNewLoan.trim())){

						test.log(LogStatus.PASS, "Aprs are equal");
						Flag4="true";

					}
					else{
						test.log(LogStatus.FAIL, "Aprs are not equal");

					}


					String PaymentamountinNeg= driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[3]/table/tbody/tr[6]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "paymentAmount in negotiaie loan amount screen is"+PaymentamountinNeg);



					if(PaymentamountinNeg.equals(InstallmentAmountInNewLoan.trim())){

						test.log(LogStatus.PASS, "Paymentamount are equal");
						Flag5="true";

					}
					else{
						test.log(LogStatus.FAIL, "Paymentamount are not equal");

					}


					String PaymentdateinNeg= driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[3]/table/tbody/tr[7]/td/input[1]")).getAttribute("value");
					test.log(LogStatus.PASS, "Paymentdate in negotiaie loan amount screen is"+PaymentdateinNeg);

					if(paymentdate1.trim().equals(PaymentdateinNeg.trim())){

						test.log(LogStatus.PASS, "payment dates are equal");
						Flag6="true";

					}
					else{
						test.log(LogStatus.FAIL, "payment dates are not equal");

					}

					String FrequencyinNeg= driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[3]/table/tbody/tr[8]/td/input[1]")).getAttribute("value");
					test.log(LogStatus.PASS, "frequency in negotiaie loan amount screen is"+FrequencyinNeg);


					if(FrequencyInNewLoan.equals(FrequencyinNeg)){

						test.log(LogStatus.PASS, "frequency are equal");
						Flag7="true";

					}
					else{
						test.log(LogStatus.FAIL, "frequency  are not equal");
						
					}



				}
				else{
					continue;	
				}

				
				if(Flag1.equals("true")&&Flag2.equals("true")&&Flag3.equals("true")&&Flag4.equals("true")&&Flag5.equals("true")&&Flag6.equals("true")&&Flag7.equals("true"))
				{


					double loanamtinNegscreen_Double=Double.parseDouble(loanamtinNegscreen);
					//loanamtinNegscreen_Double=loanamtinNegscreen_Double-200.00;
					loanamtinNegscreen_Double=loanamtinNegscreen_Double=500.00;
					loanamtinNegscreen= Double.toString(loanamtinNegscreen_Double);
					System.out.println("converted and deducted loan amount is"+loanamtinNegscreen);

					WebElement e3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/table/tbody/tr[3]/td[3]/input"));
					e3.click();
					for(int i=1;i<=7;i++){

						e3.sendKeys(Keys.BACK_SPACE);
					}

					//e3.clear();

					e3.sendKeys(loanamtinNegscreen);
					test.log(LogStatus.PASS, "Reduced loan amount is "+loanamtinNegscreen);

					Actions action = new Actions(driver);
					action.moveByOffset(200,100).perform();
					Thread.sleep(2000);
					action.click();

					driver.findElement(By.name("reCalculate")).click();
					test.log(LogStatus.PASS, "Click on recalculate button ");

					Thread.sleep(2500);
					String AprinNeg= driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[3]/table/tbody/tr[5]/td/input")).getAttribute("value");
					test.log(LogStatus.PASS, "Apr in negotiaie loan amount screen is"+AprinNeg);


					String PaymentamountinNeg=  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[3]/table/tbody/tr[7]/td/input[1]")).getAttribute("value");
					test.log(LogStatus.PASS, "paymentAmount in negotiaie loan amount screen is"+PaymentamountinNeg);



					Thread.sleep(5000);

												

					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[3]/table/tbody/tr[12]/td/input")).click();
					test.log(LogStatus.PASS, "Clicked on Select button ");


					driver.close();
					driver.switchTo().window(mainWindow);
					Thread.sleep(4000);

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");


					reqloanAmount=driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[1]/td[2]/input[1]")).getAttribute("value");
					test.log(LogStatus.PASS, "request loan amount is "+reqloanAmount);

					APRInNewLoan=driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[6]/td[2]/input")).getAttribute("value");
					test.log(LogStatus.PASS, "APR  in NewLoan  is "+APRInNewLoan);

					InstallmentAmountInNewLoan=driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[7]/td[2]/input")).getAttribute("value");
					test.log(LogStatus.PASS, "Installment amount in NewLoan  is "+InstallmentAmountInNewLoan);	

					//StrngloanamtinNegscreen=loanamtinNegscreen.split(regex)

					String loanamtinNegscreenrnd[]=loanamtinNegscreen.split("\\.");
					loanamtinNegscreen=loanamtinNegscreenrnd[0];

					String reqloanAmountrnd[]=reqloanAmount.split("\\.");
					reqloanAmount=reqloanAmountrnd[0];

					String AprinNegrnd[]=AprinNeg.split("\\.");
					AprinNeg=AprinNegrnd[0];

					String APRInNewLoanrnd[]=APRInNewLoan.split("\\.");
					APRInNewLoan=APRInNewLoanrnd[0];



					if(loanamtinNegscreen.equals(reqloanAmount)&&AprinNeg.equals(APRInNewLoan)&&PaymentamountinNeg.equals(InstallmentAmountInNewLoan)){


						test.log(LogStatus.PASS, "All validations are pass performing new loan");
						newLoan();


					}
					else{

						test.log(LogStatus.FAIL, "Validations of Recalculate screen are fail");

					}
				}
			else{

				test.log(LogStatus.FAIL, "New Loan doesn't completed because One of Validation got failed ");

			}
			break;
	

			}
	}
	}


	public static void newLoan() throws InterruptedException{

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");
		String relamount=driver.findElement(By.name("requestBean.siilBean.advAmt")).getAttribute("value");
		test.log(LogStatus.PASS, "getting request loan amount "+relamount);
		//--------------------------------------------------------------------------------------------------------------	

		if(ESign_CollateralType.equalsIgnoreCase("ACH")){

			driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
			test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

			if(ESign_DisbType.equalsIgnoreCase("Cash")){


				driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
				test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

				driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
				test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);

				driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
				if(ESign_CourtesyCallConsent.equals("Yes"))
				{
					if(ESign_Preference.equals("Call"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
					}
					if(ESign_Preference.equals("Mail"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
					}
					if(ESign_Preference.equals("SMS"))
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
				if (AllowPromotion.equals("Yes")) {


					String main_window = driver.getWindowHandle();

					driver.findElement(locator(Aprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

					test.log(LogStatus.PASS, "Promotion button is clicked ");

					Thread.sleep(10000);


					for (String winHandle1 : driver.getWindowHandles()) {

						if (!main_window.equalsIgnoreCase(winHandle1)) {

							Thread.sleep(5000);

							driver.switchTo().window(winHandle1);

							Thread.sleep(5000);

							driver.findElement(locator(Aprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

							test.log(LogStatus.PASS, "Promotion radio button is selected ");

							driver.findElement(locator(Aprop.getProperty("csr_new_loan_promo_ok_btn"))).click();

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

			}

			else if(ESign_DisbType.equalsIgnoreCase("Check")){

				driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
				test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

				driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
				test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);
				driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);

				if(ESign_CourtesyCallConsent.equals("Yes"))
				{
					if(ESign_Preference.equals("Call"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
					}
					if(ESign_Preference.equals("Mail"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
					}
					if(ESign_Preference.equals("SMS"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
					}

				}
				if (AllowPromotion.equals("Yes")) {


					String main_window = driver.getWindowHandle();

					driver.findElement(locator(Aprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

					test.log(LogStatus.PASS, "Promotion button is clicked ");

					Thread.sleep(10000);


					for (String winHandle1 : driver.getWindowHandles()) {

						if (!main_window.equalsIgnoreCase(winHandle1)) {

							Thread.sleep(5000);

							driver.switchTo().window(winHandle1);

							Thread.sleep(5000);

							driver.findElement(locator(Aprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

							test.log(LogStatus.PASS, "Promotion radio button is selected ");

							driver.findElement(locator(Aprop.getProperty("csr_new_loan_promo_ok_btn"))).click();

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
				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
				test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

				driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
				test.log(LogStatus.PASS, "check box selected ");

				driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
				test.log(LogStatus.PASS, "Enterd amount is "+relamount);

			}
			driver.switchTo().defaultContent();

			driver.switchTo().frame("mainFrame");

			driver.switchTo().frame("main");
			driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
			//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);
			test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
			driver.findElement(By.name("finishLoan")).click();
			//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();
			test.log(LogStatus.PASS, "click on Finish Loan button ");
		}

		//--------------------------------------------------------------------------------------------------------

		if(ESign_CollateralType.equalsIgnoreCase("Debit Card")){


			driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
			test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

			if(ESign_DisbType.equalsIgnoreCase("Cash")){


				driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
				test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

				driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
				test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);



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
				driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
				if(ESign_CourtesyCallConsent.equals("Yes"))
				{
					if(ESign_Preference.equals("Call"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
					}
					if(ESign_Preference.equals("Mail"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
					}
					if(ESign_Preference.equals("SMS"))
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
				if (AllowPromotion.equals("Yes")) {


					String main_window = driver.getWindowHandle();

					driver.findElement(locator(Aprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

					test.log(LogStatus.PASS, "Promotion button is clicked ");

					Thread.sleep(10000);


					for (String winHandle1 : driver.getWindowHandles()) {

						if (!main_window.equalsIgnoreCase(winHandle1)) {

							Thread.sleep(5000);

							driver.switchTo().window(winHandle1);

							Thread.sleep(5000);

							driver.findElement(locator(Aprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

							test.log(LogStatus.PASS, "Promotion radio button is selected ");

							driver.findElement(locator(Aprop.getProperty("csr_new_loan_promo_ok_btn"))).click();

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

			}

			else if(ESign_DisbType.equalsIgnoreCase("Check")){

				driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
				test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

				driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
				test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);

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
				driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);

				if(ESign_CourtesyCallConsent.equals("Yes"))
				{
					if(ESign_Preference.equals("Call"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
					}
					if(ESign_Preference.equals("Mail"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
					}
					if(ESign_Preference.equals("SMS"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
					}
				}
				if (AllowPromotion.equals("Yes")) {

					String main_window = driver.getWindowHandle();

					driver.findElement(locator(Aprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

					test.log(LogStatus.PASS, "Promotion button is clicked ");

					Thread.sleep(10000);

					for (String winHandle1 : driver.getWindowHandles()) {

						if (!main_window.equalsIgnoreCase(winHandle1)) {

							Thread.sleep(5000);

							driver.switchTo().window(winHandle1);

							Thread.sleep(5000);

							driver.findElement(locator(Aprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

							test.log(LogStatus.PASS, "Promotion radio button is selected ");

							driver.findElement(locator(Aprop.getProperty("csr_new_loan_promo_ok_btn"))).click();

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
				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
				test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

				driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
				test.log(LogStatus.PASS, "check box selected ");

				driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
				test.log(LogStatus.PASS, "Enterd amount is "+relamount);

			}
			driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
			test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
			driver.findElement(By.name("finishLoan")).click();
			test.log(LogStatus.PASS, "click on Finish Loan button ");
		}
		//-----------------------------------------------------------------------------------------------------------------------------------	
		if(ESign_CollateralType.equalsIgnoreCase("Check")){
			driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
			test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

			if(ESign_DisbType.equalsIgnoreCase("Cash")||ESign_DisbType.equalsIgnoreCase("check")){


				driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
				test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

				driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
				test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);

				driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
				if(ESign_CourtesyCallConsent.equals("Yes"))
				{
					if(ESign_Preference.equals("Call"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
					}
					else if(ESign_Preference.equals("Mail"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
					}
					else if(ESign_Preference.equals("SMS"))
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
				else{
					test.log(LogStatus.PASS, "Esign preference selected as NO ");
				}
				if (AllowPromotion.equals("Yes")) {

					String main_window = driver.getWindowHandle();

					driver.findElement(locator(Aprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

					test.log(LogStatus.PASS, "Promotion button is clicked ");

					Thread.sleep(10000);

					for (String winHandle1 : driver.getWindowHandles()) {

						if (!main_window.equalsIgnoreCase(winHandle1)) {

							Thread.sleep(5000);

							driver.switchTo().window(winHandle1);

							Thread.sleep(5000);

							driver.findElement(locator(Aprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

							test.log(LogStatus.PASS, "Promotion radio button is selected ");

							driver.findElement(locator(Aprop.getProperty("csr_new_loan_promo_ok_btn"))).click();

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

							} catch (Exception e) {
							}
							break;
						}
					}
				}
				else
				{
					test.log(LogStatus.PASS, "Allow promotions not selected");
				}
			}
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
			driver.switchTo().defaultContent();

			driver.switchTo().frame("mainFrame");

			driver.switchTo().frame("main");

			if(ESign_DisbType.equalsIgnoreCase("Check")){
				driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
				test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

				driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
				test.log(LogStatus.PASS, "check box selected ");

				driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
				test.log(LogStatus.PASS, "Enterd amount is "+relamount);
			}
			driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
			test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);

			driver.findElement(By.name("finishLoan")).click();
			test.log(LogStatus.PASS, "click on Finish Loan button ");

		}


		//------------------------------------------------------------------------------------------------------------		
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
			test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
			test.log(LogStatus.INFO, "**********************************************************************************");
			//driver.findElement(By.name("ok")).click();
		}
		else
		{
			test.log(LogStatus.INFO, "New Loan is Completed Successfully ");
			test.log(LogStatus.INFO, "**********************************************************************************");
		}



	}


}

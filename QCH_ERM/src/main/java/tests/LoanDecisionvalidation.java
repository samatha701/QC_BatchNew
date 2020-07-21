package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

public class LoanDecisionvalidation extends QCStore{

	public static void Decisioningvalidation(String SSN,String AppURL) throws Exception
	{

		test.log(LogStatus.INFO, "*****Performing  Decisioning Vlidation  *****");
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

		for(int row=2;row<=lastrow+1;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{		
				
				String NewLoan_Term = TestData.getCellData(sheetName,"NewLoan_Term",row);
				ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				
				String ESign_LoanAmt = TestData.getCellData(sheetName,"ESign_LoanAmt",row);
				String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
			    ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
				ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				AllowPromotion = TestData.getCellData(sheetName,"Allow Promotion",row);
				String CouponNbr = TestData.getCellData(sheetName,"CouponNbr",row);
				ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
				String ESign_Checks = TestData.getCellData(sheetName,"ESign_Checks",row);
				String ESign_Password=TestData.getCellData(sheetName,"ESign_Password",row);
				ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);			
				String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);

				String No_of_checks=TestData.getCellData(sheetName,"No_of_checks",row);
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
				String Rateofinterest2=driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[5]/td")).getText();
				test.log(LogStatus.PASS, "Rateofinterest for Term2 is : "+Rateofinterest2);



				String APR1=driver.findElement(By.xpath("//*[@id='tableWid1']/tbody/tr[6]/td/input")).getAttribute("value");
				test.log(LogStatus.PASS, "APR for Term1 is : "+APR1);			
				String APR2=driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[6]/td/input")).getAttribute("value");
				test.log(LogStatus.PASS, "APR for Term2 is : "+APR2);


				String paymentAmount1=driver.findElement(By.xpath("//*[@id='tableWid1']/tbody/tr[7]/td/input")).getAttribute("value");
				test.log(LogStatus.PASS, "paymentAmount for Term1 is : "+paymentAmount1);			
				String paymentAmount2=driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[7]/td/input")).getAttribute("value");
				test.log(LogStatus.PASS, "paymentAmount for Term2 is : "+paymentAmount2);

				String paymentdate1=driver.findElement(By.xpath("//*[@id='tableWid1']/tbody/tr[8]/td")).getText();
				test.log(LogStatus.PASS, "paymentdate for Term1 is : "+paymentdate1);			
				String paymentdate2=driver.findElement(By.xpath("//*[@id='tableWid2']/tbody/tr[8]/td")).getText();
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

				paymentAmount2_Int = Double.parseDouble(paymentAmount2);

				 paymentAmount2_Int2 = (int)paymentAmount2_Int;
				
				
				System.out.println(paymentAmount2_Int2);
				
				 paymentAmount1_Int = Double.parseDouble(paymentAmount1);

				 paymentAmount1_Int1 = (int)paymentAmount1_Int;
				
				
			   PTIamt2 = (int)PTIamt;
				System.out.println(PTIamt2);
				
				if(NewLoan_Term.equals("Term2")){
					
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


					String date1=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[2]/td[2]/input")).getAttribute("value");				
					test.log(LogStatus.PASS, "First installment date is "+date1);

					DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
					Date Ddate1 = df.parse(date1);
					Date Dappdate= df.parse(appdate);

					long diffIndate = Math.abs(Ddate1.getTime() - Dappdate.getTime());
					long diffDays = diffIndate / (24 * 60 * 60 * 1000);
					test.log(LogStatus.PASS, "difference between days is "+diffDays);

					if(diffDays<31){

						String date2=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[2]/input")).getAttribute("value");				
						test.log(LogStatus.PASS, "Second installment date is "+date2);

						Date Ddate2 = df.parse(date2);

						long diffIndate2 = Math.abs(Ddate2.getTime() - Dappdate.getTime());
						long diffDays2 = diffIndate2 / (24 * 60 * 60 * 1000);
						test.log(LogStatus.PASS, "difference between days is"+diffDays2);

						if(diffDays2<31){

							String PA1=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[2]/td[4]/input")).getAttribute("value");				
							test.log(LogStatus.PASS, "First Payment amount is"+PA1);
							String PA2=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[4]/input")).getAttribute("value");				
							test.log(LogStatus.PASS, "Second   payment amount is"+PA2);
							double PA1int=Double.parseDouble(PA1);
							double PA2int=Double.parseDouble(PA2);
							Double sum=PA1int+PA2int;
							PTIamt=PTIamt*2;
							String PTIamtstr=String.format("%.1f", PTIamt);
							String sumstr=String.format("%.1f", sum);
							test.log(LogStatus.PASS, "Sum of payment amount is"+sumstr);
							test.log(LogStatus.PASS, "caluculated PTI Amount is "+PTIamtstr);
							
							
							
							
							if(PTIamt>=sum){
								
								
								
								test.log(LogStatus.PASS, "Sum of 2 installment payment amount and PTI amount validation is pass");
								
								interestSumValidation();
								
								

							}
							else{
								test.log(LogStatus.FAIL, "Sum of 2 installment payment amount and PTI amount validation is fail");
							}


						}
						else{
							String PA1=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[4]/input")).getAttribute("value");				
							test.log(LogStatus.PASS, "Getting  payment amount  from table"+PA1);
							double PA1int=Double.parseDouble(PA1);
							test.log(LogStatus.PASS, "Payment amount is "+PA1int);
							test.log(LogStatus.PASS, "Payment amountform loan decision screen " +paymentAmount2_Int);
							
							if(paymentAmount2_Int==PA1int){

								test.log(LogStatus.PASS, "payment amount in Newloan screen and PTI amount validation is pass");
								interestSumValidation();
								
							}
							else{
								test.log(LogStatus.FAIL, "payment amount in Newloan screen and PTI amount validation is Fail");
							}

						}


					}
					else{
						
						String PA1=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[4]/input")).getAttribute("value");				
						test.log(LogStatus.PASS, "Getting  payment amount  from table"+PA1);
						double PA1int=Double.parseDouble(PA1);
						test.log(LogStatus.PASS, "Payment amount is "+PA1int);
						test.log(LogStatus.PASS, "Payment amountform loan decision screen " +paymentAmount2_Int);
						
						if(paymentAmount2_Int==PA1int){

							test.log(LogStatus.PASS, "payment amount in Newloan screen and PTI amount validation is pass");
							interestSumValidation();
							
						}
						else{
							test.log(LogStatus.FAIL, "payment amount in Newloan screen and PTI amount validation is Fail");
						}
						
						
					}
}
				else{
					test.log(LogStatus.FAIL, "payment amount with PTI amount Validation failed  ");
				}
				
				}
				
				
				
				
				
				else if(NewLoan_Term.equals("Term1")){
					test.log(LogStatus.PASS, "Payment amount "+paymentAmount1_Int);
					
					if(PTIamt>=paymentAmount1_Int&&PTIamt2==paymentAmount1_Int1){

						
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


						String date1=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[2]/td[2]/input")).getAttribute("value");				
						test.log(LogStatus.PASS, "First installment date is "+date1);

						DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
						Date Ddate1 = df.parse(date1);
						Date Dappdate= df.parse(appdate);

						long diffIndate = Math.abs(Ddate1.getTime() - Dappdate.getTime());
						long diffDays = diffIndate / (24 * 60 * 60 * 1000);
						test.log(LogStatus.PASS, "difference between days is "+diffDays);

						if(diffDays<31){

							String date2=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[2]/input")).getAttribute("value");				
							test.log(LogStatus.PASS, "Second installment date is "+date2);

							Date Ddate2 = df.parse(date2);

							long diffIndate2 = Math.abs(Ddate2.getTime() - Dappdate.getTime());
							long diffDays2 = diffIndate2 / (24 * 60 * 60 * 1000);
							test.log(LogStatus.PASS, "difference between days is"+diffDays2);

							if(diffDays2<31){

								String PA1=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[2]/td[4]/input")).getAttribute("value");				
								test.log(LogStatus.PASS, "First Payment amount is"+PA1);
								String PA2=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[4]/input")).getAttribute("value");				
								test.log(LogStatus.PASS, "Second   payment amount is"+PA2);
								double PA1int=Double.parseDouble(PA1);
								double PA2int=Double.parseDouble(PA2);
								Double sum=PA1int+PA2int;
								PTIamt=PTIamt*2;
								test.log(LogStatus.PASS, "Sum of payment amount is"+sum);
								test.log(LogStatus.PASS, "caluculated PTI Amount is "+PTIamt);
								if(PTIamt>=sum){
									
									
									
									test.log(LogStatus.PASS, "Sum of 2 installment payment amount and PTI amount validation is pass");
									
									interestSumValidation();
									
									

								}
								else{
									test.log(LogStatus.FAIL, "Sum of 2 installment payment amount and PTI amount validation is fail");
								}


							}
							else{
								String PA1=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[4]/input")).getAttribute("value");				
								test.log(LogStatus.PASS, "Getting  payment amount  from table"+PA1);
								double PA1int=Double.parseDouble(PA1);
								test.log(LogStatus.PASS, "Payment amount is "+PA1int);
								test.log(LogStatus.PASS, "Payment amountform loan decision screen " +paymentAmount2_Int);
								
								if(paymentAmount2_Int==PA1int){

									test.log(LogStatus.PASS, "payment amount in Newloan screen and PTI amount validation is pass");
									interestSumValidation();
									
								}
								else{
									test.log(LogStatus.FAIL, "payment amount in Newloan screen and PTI amount validation is Fail");
								}

							}


						}
	}
					else{
						test.log(LogStatus.FAIL, "payment amount with PTI amount Validation failed  ");
					}
					}


			}
		}


	}
	
	
	public static void interestSumValidation() throws InterruptedException{
		

		
		test.log(LogStatus.INFO, "performing sum of interests  ");	
		
	
		String noofonstallments=driver.findElement(By.name("requestBean.siilBean.nbrOfInst")).getAttribute("value");
		test.log(LogStatus.PASS, "No of installments are  "+noofonstallments);	
		
		
		if(noofonstallments.equals("12")){
		
		String n1=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[2]/td[5]/input")).getAttribute("value");
		test.log(LogStatus.PASS, "Intereset amount in table "+n1);		
		String n2=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[5]/input")).getAttribute("value");
		test.log(LogStatus.PASS, "Intereset amount in table "+n2);
		String n3=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[4]/td[5]/input")).getAttribute("value");
		test.log(LogStatus.PASS, "Intereset amount in table "+n3);
		String n4=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[5]/td[5]/input")).getAttribute("value");
		test.log(LogStatus.PASS, "Intereset amount in table "+n4);
		String n5=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[6]/td[5]/input")).getAttribute("value");
		test.log(LogStatus.PASS, "Intereset amount in table "+n5);
		String n6=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[7]/td[5]/input")).getAttribute("value");
		test.log(LogStatus.PASS, "Intereset amount in table "+n6);
		String n7=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[8]/td[5]/input")).getAttribute("value");
		test.log(LogStatus.PASS, "Intereset amount in table "+n7);
		String n8=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[9]/td[5]/input")).getAttribute("value");
		test.log(LogStatus.PASS, "Intereset amount in table "+n8);
		String n9=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[10]/td[5]/input")).getAttribute("value");
		test.log(LogStatus.PASS, "Intereset amount in table "+n9);
		String n10=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[11]/td[5]/input")).getAttribute("value");
		test.log(LogStatus.PASS, "Intereset amount in table "+n10);
		String n11=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[12]/td[5]/input")).getAttribute("value");
		test.log(LogStatus.PASS, "Intereset amount in table "+n11);
		String n12=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[13]/td[5]/input")).getAttribute("value");
		test.log(LogStatus.PASS, "Intereset amount in table "+n12);
	
		
		String LoanFee=driver.findElement(By.name("htmlLoanFee")).getAttribute("value");
		test.log(LogStatus.PASS, "Loan Fee amount is "+LoanFee);
		
		double LoanFeeDouble=Double.parseDouble(LoanFee);
		
		
		double n1d=Double.parseDouble(n1);
		double n2d=Double.parseDouble(n2);
		double n3d=Double.parseDouble(n3);
		double n4d=Double.parseDouble(n4);
		double n5d=Double.parseDouble(n5);
		double n6d=Double.parseDouble(n6);
		double n7d=Double.parseDouble(n7);
		double n8d=Double.parseDouble(n8);
		double n9d=Double.parseDouble(n9);
		double n10d=Double.parseDouble(n10);
		double n11d=Double.parseDouble(n11);
		double n12d=Double.parseDouble(n12);
		
		double sumofInterest=n1d+n2d+n3d+n4d+n5d+n6d+n7d+n8d+n9d+n10d+n11d+n12d;
		
		int sumofInterestInt = (int)sumofInterest;
		int LoanFeeDoubleInt = (int)LoanFeeDouble;
		
		test.log(LogStatus.PASS, "Sum of interests "+sumofInterestInt);
		
		if(sumofInterestInt==LoanFeeDoubleInt){
			
			test.log(LogStatus.PASS, "Sum of interest and Loan fee validation is Pass");
			newLoan();
			
			
		}else{
			test.log(LogStatus.FAIL, "Sum of interest and Loan fee validation is Failed");
		}						
		}
		
		
		else if(noofonstallments.equals("8")){
			
			String n1=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[2]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n1);		
			String n2=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n2);
			String n3=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[4]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n3);
			String n4=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[5]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n4);
			String n5=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[6]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n5);
			String n6=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[7]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n6);
			String n7=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[8]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n7);
			String n8=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[9]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n8);
			
		
			
			//String LoanFee=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[7]/td/table/tbody/tr[2]/td[2]/input")).getAttribute("value");
			String LoanFee=driver.findElement(By.name("htmlLoanFee")).getAttribute("value");
			test.log(LogStatus.PASS, "Loan Fee amount is "+LoanFee);
			
			double LoanFeeDouble=Double.parseDouble(LoanFee);
			
			
			double n1d=Double.parseDouble(n1);
			double n2d=Double.parseDouble(n2);
			double n3d=Double.parseDouble(n3);
			double n4d=Double.parseDouble(n4);
			double n5d=Double.parseDouble(n5);
			double n6d=Double.parseDouble(n6);
			double n7d=Double.parseDouble(n7);
			double n8d=Double.parseDouble(n8);
			
			
			
			double sumofInterest=n1d+n2d+n3d+n4d+n5d+n6d+n7d+n8d;
			
			int sumofInterestInt = (int)sumofInterest;
			int LoanFeeDoubleInt = (int)LoanFeeDouble;
			
			test.log(LogStatus.PASS, "Sum of interests "+sumofInterestInt);
			
			if(sumofInterestInt==LoanFeeDoubleInt){
				
				test.log(LogStatus.PASS, "Sum of interest and Loan fee validation is Pass");
				newLoan();
				
				
			}else{
				test.log(LogStatus.FAIL, "Sum of interest and Loan fee validation is Failed");
			}
				
		}
		
else if(noofonstallments.equals("10")){
			
			String n1=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[2]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n1);		
			String n2=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n2);
			String n3=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[4]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n3);
			String n4=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[5]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n4);
			String n5=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[6]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n5);
			String n6=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[7]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n6);
			String n7=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[8]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n7);
			String n8=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[9]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n8);
			String n9=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[10]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n9);
			String n10=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[11]/td[5]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Intereset amount in table "+n10);
			
		
			
			//String LoanFee=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[7]/td/table/tbody/tr[2]/td[2]/input")).getAttribute("value");
			String LoanFee=driver.findElement(By.name("htmlLoanFee")).getAttribute("value");
			test.log(LogStatus.PASS, "Loan Fee amount is "+LoanFee);
			
			double LoanFeeDouble=Double.parseDouble(LoanFee);
			
			
			double n1d=Double.parseDouble(n1);
			double n2d=Double.parseDouble(n2);
			double n3d=Double.parseDouble(n3);
			double n4d=Double.parseDouble(n4);
			double n5d=Double.parseDouble(n5);
			double n6d=Double.parseDouble(n6);
			double n7d=Double.parseDouble(n7);
			double n8d=Double.parseDouble(n8);
			double n9d=Double.parseDouble(n9);
			double n10d=Double.parseDouble(n10);
			
			double sumofInterest=n1d+n2d+n3d+n4d+n5d+n6d+n7d+n8d+n9d+n10d;
			
			int sumofInterestInt = (int)sumofInterest;
			int LoanFeeDoubleInt = (int)LoanFeeDouble;
			
			test.log(LogStatus.PASS, "Sum of interests "+sumofInterestInt);
			
			if(sumofInterestInt==LoanFeeDoubleInt){
				
				test.log(LogStatus.PASS, "Sum of interest and Loan fee validation is Pass");
				newLoan();
				
				
			}else{
				test.log(LogStatus.FAIL, "Sum of interest and Loan fee validation is Failed");
			}
				
		}
			
		
else if(noofonstallments.equals("5")){
	
	String n1=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[2]/td[5]/input")).getAttribute("value");
	test.log(LogStatus.PASS, "Intereset amount in table "+n1);		
	String n2=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[5]/input")).getAttribute("value");
	test.log(LogStatus.PASS, "Intereset amount in table "+n2);
	String n3=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[4]/td[5]/input")).getAttribute("value");
	test.log(LogStatus.PASS, "Intereset amount in table "+n3);
	String n4=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[5]/td[5]/input")).getAttribute("value");
	test.log(LogStatus.PASS, "Intereset amount in table "+n4);
	String n5=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[6]/td[5]/input")).getAttribute("value");
	test.log(LogStatus.PASS, "Intereset amount in table "+n5);
	
													
	
	//String LoanFee=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[7]/td/table/tbody/tr[2]/td[2]/input")).getAttribute("value");
	String LoanFee=driver.findElement(By.name("htmlLoanFee")).getAttribute("value");
	test.log(LogStatus.PASS, "Loan Fee amount is "+LoanFee);
	
	double LoanFeeDouble=Double.parseDouble(LoanFee);
	
	
	double n1d=Double.parseDouble(n1);
	double n2d=Double.parseDouble(n2);
	double n3d=Double.parseDouble(n3);
	double n4d=Double.parseDouble(n4);
	double n5d=Double.parseDouble(n5);
	
	
	double sumofInterest=n1d+n2d+n3d+n4d+n5d;
	
	int sumofInterestInt = (int)sumofInterest;
	int LoanFeeDoubleInt = (int)LoanFeeDouble;
	
	test.log(LogStatus.PASS, "Sum of interests "+sumofInterestInt);
	
	if(sumofInterestInt==LoanFeeDoubleInt){
		
		test.log(LogStatus.PASS, "Sum of interest and Loan fee validation is Pass");
		newLoan();
		
		
	}else{
		test.log(LogStatus.FAIL, "Sum of interest and Loan fee validation is Failed");
	}
		
}
		
		
else if(noofonstallments.equals("4")){
	
	String n1=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[2]/td[5]/input")).getAttribute("value");
	test.log(LogStatus.PASS, "Intereset amount in table "+n1);		
	String n2=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[3]/td[5]/input")).getAttribute("value");
	test.log(LogStatus.PASS, "Intereset amount in table "+n2);
	String n3=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[4]/td[5]/input")).getAttribute("value");
	test.log(LogStatus.PASS, "Intereset amount in table "+n3);
	String n4=driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr[5]/td[5]/input")).getAttribute("value");
	test.log(LogStatus.PASS, "Intereset amount in table "+n4);
	
	//String LoanFee=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[7]/td/table/tbody/tr[2]/td[2]/input")).getAttribute("value");
	String LoanFee=driver.findElement(By.name("htmlLoanFee")).getAttribute("value");
	test.log(LogStatus.PASS, "Loan Fee amount is "+LoanFee);
	
	double LoanFeeDouble=Double.parseDouble(LoanFee);
	
	
	double n1d=Double.parseDouble(n1);
	double n2d=Double.parseDouble(n2);
	double n3d=Double.parseDouble(n3);
	double n4d=Double.parseDouble(n4);
	
	
	double sumofInterest=n1d+n2d+n3d+n4d;
	
	int sumofInterestInt = (int)sumofInterest;
	int LoanFeeDoubleInt = (int)LoanFeeDouble;
	
	test.log(LogStatus.PASS, "Sum of interests "+sumofInterestInt);
	
	if(sumofInterestInt==LoanFeeDoubleInt){
		
		test.log(LogStatus.PASS, "Sum of interest and Loan fee validation is Pass");
		
		newLoan();
		
		
	}else{
		test.log(LogStatus.FAIL, "Sum of interest and Loan fee validation is Failed");
	}
		
}
		
else{
	test.log(LogStatus.FAIL, "No of Installments not matched");
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
			test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
			driver.findElement(By.name("finishLoan")).click();
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
			test.log(LogStatus.PASS, "ESign_Password Selected As "+ESign_Password);
			
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




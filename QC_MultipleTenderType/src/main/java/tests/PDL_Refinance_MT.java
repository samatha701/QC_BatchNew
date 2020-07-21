package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import com.relevantcodes.extentreports.LogStatus;

public class PDL_Refinance_MT extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void refinance(String SSN, String AppURL) throws InterruptedException {

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		for (int row = 2; row <= lastrow+1; row++) {

			String RegSSN = TestData.getCellData(sheetName, "SSN", row);


			if (SSN.equals(RegSSN)) {

				//State = TestData.getCellData(sheetName,"StateID",row);
				String PIN ="1234";
				String TenderType1 = TestData.getCellData(sheetName,"TenderType1",row);
				String TenderType2 = TestData.getCellData(sheetName,"TenderType2",row);
				String CCNumber = TestData.getCellData(sheetName,"CCNumber",row);
				String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				String TenderAmount1 = TestData.getCellData(sheetName,"TenderAmount1",row);
				String TenderAmount2 = TestData.getCellData(sheetName,"TenderAmount2",row);

				SSN1 = SSN.substring(0, 3);
				SSN2 = SSN.substring(3,5);
				SSN3 = SSN.substring(5,9);


				Thread.sleep(3000);
				test.log(LogStatus.INFO,"Buy Back started");
				driver.switchTo().frame("topFrame");

				driver.findElement(locator(Aprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(3000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Aprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Aprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Aprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		

				driver.findElement(locator(Aprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button");
				Thread.sleep(3000);					  


				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button");
				Thread.sleep(3000);
				driver.findElement(By.name("transactionList")).sendKeys("Refinance");
				test.log(LogStatus.PASS, "Transaction Type is selected as Refinance");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(500);
				
				try{
					driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
					test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
					}
					catch(Exception e){
						//normal flow
					}
				
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Clicked on qualify button");
				Thread.sleep(15000);
				
				driver.findElement(By.name("transactionDataBean.checkAcctNbr")).sendKeys(last4cheknum);
				test.log(LogStatus.PASS, "Checking acoount number enterd as"+last4cheknum);
				
				driver.findElement(By.name("transactionDataBean.courtesyCallFlag")).sendKeys("NO");
				test.log(LogStatus.PASS, "Courtesy call flag selected as No");
				

				String paymentamount= driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
				test.log(LogStatus.PASS, "Payment amount is is :"+paymentamount);
				double paymentamount_float=Double.parseDouble(paymentamount);
				paymentamount_float=paymentamount_float-10.00;
				paymentamount=Double.toString(paymentamount_float);

				TenderAmount1=paymentamount;
				TenderAmount2="10.00";



				if(TenderType1.equalsIgnoreCase("Cash")&&(TenderType2.equalsIgnoreCase("CashierCheck")||TenderType2.equalsIgnoreCase("MoneyOrder")))
				{
					Thread.sleep(500);

					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType1);
					test.log(LogStatus.PASS, "First Tender Type is :"+TenderType1);
					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(TenderAmount1);
					test.log(LogStatus.PASS, "First TenderAmount is :"+TenderAmount1);	

					driver.findElement(By.name("transactionDataBean.tenderTypeSecond")).sendKeys(TenderType2);
					test.log(LogStatus.PASS, "Second Tender Type is :"+TenderType2);

					driver.findElement(By.name("transactionDataBean.ccmoNbrSecond")).sendKeys(CCNumber);
					test.log(LogStatus.PASS, "CC Number entered as :"+CCNumber);

					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderAmtSecond")).sendKeys(TenderAmount2);
					test.log(LogStatus.PASS, "Second TenderAmount is :"+TenderAmount2);

				}

				if((TenderType1.equalsIgnoreCase("CashierCheck")||TenderType1.equalsIgnoreCase("MoneyOrder"))&&TenderType2.equalsIgnoreCase("Cash")){

					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType1);
					test.log(LogStatus.PASS, "First Tender Type is :"+TenderType1);
					driver.findElement(By.name("transactionDataBean.ccmoNbrFirst")).sendKeys(CCNumber);
					test.log(LogStatus.PASS, "CC Number entered as :"+CCNumber);
					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(TenderAmount1);
					test.log(LogStatus.PASS, "First TenderAmount is :"+TenderAmount1);	

					driver.findElement(By.name("transactionDataBean.tenderTypeSecond")).sendKeys(TenderType2);
					test.log(LogStatus.PASS, "Second Tender Type is :"+TenderType2);
					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderAmtSecond")).sendKeys(TenderAmount2);
					test.log(LogStatus.PASS, "Second TenderAmount is :"+TenderAmount2);

				}


				driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
				test.log(LogStatus.PASS, "Pin is entered");
				driver.findElement(By.name("cashAgain")).click();
				test.log(LogStatus.PASS, "Clicked on Finish Refinance");
				Thread.sleep(5000);
				try { 
					Alert alert = driver.switchTo().alert();

					alert.accept();
					//if alert present, accept and move on.														

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}
				Thread.sleep(5000);
				driver.findElement(By.name("OKBut")).click();
				test.log(LogStatus.PASS, "Clicked on confirmation yes");
				 Thread.sleep(3000);
				 driver.findElement(By.name("checkyes")).click();
				test.log(LogStatus.PASS,"Refinance Completed Successfully");

			

			}


		}
		// }


	}
}

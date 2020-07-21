package tests;

import org.openqa.selenium.By;
import com.relevantcodes.extentreports.LogStatus;

public class AQC_Redeposit extends QCStore{

	public static void redepositDC(String SSN,String AppURL)
	{

		test.log(LogStatus.PASS, "************Debit Cards Redeposit Transaction started****************");
		int lastrow=TestData.getLastRow("Deposit");
		String sheetName="Deposit";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{

				String RepresentmentType = TestData.getCellData(sheetName,"RepresentmentType",row);
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Aprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.partialLinkText("Debit Cards")).click();
				test.log(LogStatus.PASS, "Clicked on Debit Cards");
				driver.findElement(By.partialLinkText("Installment Loan")).click();
				test.log(LogStatus.PASS, "Clicked on Installmentloan");
				driver.findElement(By.partialLinkText("ReDeposit")).click();
				test.log(LogStatus.PASS, "Clicked on Redeposit");
				//loan_nbr="11036309";
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_nbr);
				test.log(LogStatus.PASS, "Enterd loan number is :"+loan_nbr);
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on submit button");
				
				String loanno=driver.findElement(By.xpath("//*[@id='dealNbrId0']")).getText();
				test.log(LogStatus.PASS, "Getting loan number from table"+loanno);
				if(loanno.equals(loan_nbr)){

					driver.findElement(By.name("requestBean.chkName")).click();
					test.log(LogStatus.PASS, "clicking on check box to select customer having loan number"+loan_nbr);

					/*driver.findElement(By.name("dispRepresentmentType")).sendKeys(RepresentmentType);;
					test.log(LogStatus.PASS, "Selected representment type as :"+RepresentmentType);*/
					
					driver.findElement(By.name("CmdReturnPosting")).click();
					test.log(LogStatus.PASS, "Click on Representment Now Button");
				}
				else{
					test.log(LogStatus.FAIL, " loan number didn't match");
				}


				test.log(LogStatus.PASS, " Debit Card Redeposit  is successfull");
				test.log(LogStatus.PASS, "********************************************** ");
				break;
			}else
			{
				test.log(LogStatus.FAIL, "Debit Card Redeposit  is Failed ");
			}}			 }}

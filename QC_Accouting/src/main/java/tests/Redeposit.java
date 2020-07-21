package tests;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class Redeposit extends QCStore{
	
	public static void redeposit(String SSN, String AppURL) {
		try {

			int lastrow = TestData.getLastRow("Redeposit");
			String sheetName = "Redeposit";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String StoreID = TestData.getCellData(sheetName, "StoreID", row);
				String State = TestData.getCellData(sheetName, "State", row);
				String LastName = TestData.getCellData(sheetName, "LastName", row);
				if (SSN.equals(RegSSN)) {
					test.log(LogStatus.PASS, "ReDeposit has started");
					Thread.sleep(3000);
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions Tab");
					Thread.sleep(1000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.partialLinkText("Debit Cards")).click();
					test.log(LogStatus.PASS, "Clicked on Debit Cards link");
					driver.findElement(By.partialLinkText("Installment Loan")).click();
					test.log(LogStatus.PASS, "Clicked on Installment Loan link");
					driver.findElement(By.partialLinkText("Debit Card On File")).click();
					test.log(LogStatus.PASS, "Clicked on Debit Card On File link");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);
					test.log(LogStatus.PASS, "Enterd Store number :" + StoreID);
					
					driver.findElement(By.name("requestBean.lastName")).sendKeys(LastName);
					test.log(LogStatus.PASS, "Enterd Last Name :" + LastName);
					
					driver.findElement(By.name("requestBean.stateCd")).sendKeys(State);
					test.log(LogStatus.PASS, "Enterd State Code :" + State);
					Thread.sleep(500);
					driver.findElement(By.xpath("//input[@value='Submit' and @name='submit']")).click();
					test.log(LogStatus.PASS, "Clicked on Submit button");
					Thread.sleep(1000);
					
					
				}
			}
		}catch(Exception e){
			System.out.println(e);
			}
		
		}

}

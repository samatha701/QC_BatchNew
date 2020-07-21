package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class LoanNumber extends QCStore 
{

	public static void loanNumber(String SSN, String AppURL) throws InterruptedException {
		
		int lastrow = TestData.getLastRow("Login");
		String sheetName = "Login";

		for (int row = 2; row <= lastrow; row++) {

			// test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR
			// Application is launched", ExtentColor.BLUE));
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			if (SSN.equals(RegSSN)) {
				String UserName = TestData.getCellData(sheetName, "UserName", row);
				String Password = TestData.getCellData(sheetName, "Password", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				// System.out.println(Password);
				encryption_store_no = TestData.getCellData(sheetName, "encryption_store_no", row);
				String ProductID = TestData.getCellData(sheetName, "ProductID", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);

				// String CountofDollarCoins =
				// TestData.getCellData(sheetName,"CountofDollarCoins",row);

				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);

				Thread.sleep(4000);
				

				test.log(LogStatus.INFO, "WriteOff process");
				driver.switchTo().defaultContent();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				Thread.sleep(4000);
				driver.findElement(By.cssSelector("li[id='910000']")).click();

				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(4000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transactions");
				driver.switchTo().frame("main");
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				// String loan_nbr=
				// driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
				// test.log(LogStatus.PASS, "Loan Number is" +
				// loan_nbr);
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under search results");
				// driver.findElement(By.name("button")).click();

				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				// driver.findElement(By.name("button")).click();

				if (ProductID.equals("PDL")) {
					// driver.findElement(By.xpath("
					   
					// /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				}
				if (ProductID.equals("TLP")) {
					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
				}

				// Thread.sleep(5000);
				if (ProductID.equals("LOC")) {
					/// html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]
					driver.findElement(By
							.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]"))
							.click();
				}

			     loan_nbr = driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText();
				test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				Thread.sleep(5000);

}
}
	}}
		
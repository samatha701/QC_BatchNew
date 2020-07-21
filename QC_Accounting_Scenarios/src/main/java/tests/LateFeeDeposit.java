package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class LateFeeDeposit extends QCStore {
	
	public static String Pbal;
	public static String cardType;
	public static String cardNumber;
	public static String cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;

	public static void deposit(String SSN, String AppURL) throws Exception {
		
				int lastrow = TestData.getLastRow("Deposit");
				String sheetName = "Deposit";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {

						String Deposit_Type = TestData.getCellData(sheetName,"RepresentmentType",row);
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						
						String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3, 5);
						String SSN3 = SSN.substring(5, 9);

						Thread.sleep(3000);
						driver.switchTo().frame("bottom");
						String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
						test.log(LogStatus.PASS, ""+Str_date);
						String store_date[]=Str_date.split(":");
						business_date=store_date[1].trim();
						test.log(LogStatus.PASS, "Business date is :"+business_date);

						driver.switchTo().defaultContent();	
						
						test.log(LogStatus.INFO, "Chargeback  process has started");
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
					    Thread.sleep(5000);
						driver.findElement(By.name("transactionList")).sendKeys("History");
						test.log(LogStatus.PASS, "Transaction Type is selected as History");
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(5000);
											
						/*List<WebElement> rows =driver.findElements(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr"));
						int rcount=rows.size();
						System.out.println("No of rows"+rcount);
						rcount=rcount-1;*/
						String LoanAmt=	driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[2]/td[8]")).getText();
						System.out.println("transaction type is "+LoanAmt);
						test.log(LogStatus.PASS, "Transaction type is"+LoanAmt);
						Thread.sleep(1000);
						String LateFee=	driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[3]/tbody/tr[3]/td[8]")).getText();
						System.out.println("Late Fee is "+LateFee);
						test.log(LogStatus.PASS, "Late Fee is"+LateFee);
						driver.findElement(By.name("back")).click();
						test.log(LogStatus.PASS, "clicked on Back button");
							
						if(ESign_CollateralType.equalsIgnoreCase("ACH"))
						{

							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							driver.findElement(By.name("transactionList")).sendKeys(ESign_CollateralType+" Deposit");
							test.log(LogStatus.PASS, "Transaction type is selected "+ESign_CollateralType+" Deposit");
							driver.findElement(By.id("go_Button")).click();
							test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
							driver.findElement(By.name("requestBean.chkName")).click();
							test.log(LogStatus.PASS, "Clicked on deposit checkbox ");
							                                              
							String AchAmt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[4]/tbody/tr[6]/td[6]")).getText();
							test.log(LogStatus.PASS, "ACH deposit Amount "+AchAmt);
							if(LoanAmt.equalsIgnoreCase(AchAmt)){
								if(ProductID.equalsIgnoreCase("PDL")){
									driver.findElement(By.xpath("//input[@value='Next']")).click();
									test.log(LogStatus.PASS, "Clicked on Debit Card deposit next button ");
									driver.findElement(By.name("transactionDataBean.password")).sendKeys("1234");
									test.log(LogStatus.PASS, "password entered as "+1234);
									driver.findElement(By.xpath("//input[@value='Finish ACH Deposit']")).click();
									test.log(LogStatus.PASS, "Click on Debit Card deposit button ");
									test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
									test.log(LogStatus.PASS, "********************************************** ");
									}
							}
							else
							driver.findElement(locator(Sprop.getProperty("clear_finish"))).click();
							test.log(LogStatus.PASS, "Click on ACH deposit button ");

							test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
							test.log(LogStatus.PASS, "********************************************** ");
						}

						if(ESign_CollateralType.equalsIgnoreCase("CHECK"))
						{

							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							driver.findElement(By.name("transactionList")).sendKeys(ESign_CollateralType+" Deposit");
							test.log(LogStatus.PASS, "Transaction type is selected"+ESign_CollateralType+" Deposit");
							driver.findElement(By.id("go_Button")).click();
							test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");								 
							driver.findElement(locator(Sprop.getProperty("deposite_ilp_dstype"))).sendKeys(Deposit_Type);								 
							test.log(LogStatus.PASS, " Select the Deposit_Type as"+Deposit_Type);
							driver.findElement(locator(Sprop.getProperty("clear_finish"))).click();
							test.log(LogStatus.PASS, "Click on Check deposit button ");								 					

							test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
							test.log(LogStatus.PASS, "********************************************** ");

						}
						if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
						{

							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							driver.findElement(By.name("transactionList")).sendKeys("DebitCard Deposit");
							test.log(LogStatus.PASS, "Transaction type is selected"+ESign_CollateralType+" Deposit");
							driver.findElement(By.id("go_Button")).click();
							test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
							
							String AchAmt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[4]/tbody/tr[4]/td[5]")).getText();
							test.log(LogStatus.PASS, "ACH deposit Amount "+AchAmt);
							if(LoanAmt.equalsIgnoreCase(AchAmt)){
								if(ProductID.equalsIgnoreCase("PDL")){
									
									driver.findElement(By.xpath("//input[@value='Finish']")).click();
									test.log(LogStatus.PASS, "Click on Debit Card deposit button ");
									test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
									test.log(LogStatus.PASS, "********************************************** ");
									}
							}
							else
							driver.findElement(By.name("finish")).click();
							test.log(LogStatus.PASS, "Click on Debit Card deposit button ");
							
							test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
							test.log(LogStatus.PASS, "********************************************** ");

						}
	
						
						try{
							Alert alert = driver.switchTo().alert();
							alert.accept();
							String s=alert.getText();
							test.log(LogStatus.PASS, "Alert accepted "+s);
							Thread.sleep(2000);
							// if alert present, accept and move on.
						}
						catch(Exception e){
							
						}
					
						}
						
						
					}
				}

}







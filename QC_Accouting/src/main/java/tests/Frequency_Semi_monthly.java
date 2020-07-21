package tests;

import static java.time.temporal.TemporalAdjusters.firstInMonth;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
public class Frequency_Semi_monthly extends QCStore {


	public static void borrowerRegistration(String SSN, String AppURL) throws Exception {
		int i;
		for (i = 0; i < 3; i++) {

			try {
				// String FileName=
				// prop.getProperty("QC_Store_NewLoan_file_name");

				// ExcelNew TestData = new
				// ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");
				int lastrow = TestData.getLastRow("Borrower_Registration");
				String sheetName = "Borrower_Registration";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);

					if (SSN.equals(RegSSN)) {

						test.log(LogStatus.INFO, "Borrower Registration has started");

						// test.log(LogStatus.INFO,
						// MarkupHelper.createLabel("Borrower Registration has
						// started", ExtentColor.BLUE));

						String business_date2;
						String business_date1;
						String business_date3;
						

						String ProductType = TestData.getCellData(sheetName, "ProductType", row);

						String Income_PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);

						// test.log(LogStatus.INFO, "Borrower Registration-SSN:
						// " +SSN);

						DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3, 5);
						String SSN3 = SSN.substring(5, 9);

						String Monthly_Type = TestData.getCellData(sheetName, "MonthlyType", row);
						// int Monthly_Type=Integer.parseInt("Monthly_Type");
						String Monthly_payWeek = TestData.getCellData(sheetName, "MonthlyPayWeek", row);
						String Monthly_payWeekDay = TestData.getCellData(sheetName, "MonthlyPayWeekDay", row);
						String Monthly_payday = TestData.getCellData(sheetName, "MonthlyPayDay", row);

						driver.switchTo().frame("bottom");
						String Str_date = driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]"))
								.getText();
						String store_date[] = Str_date.split(":");
						business_date = store_date[1].trim();
						String business_datenew[] = business_date.split("/");
						business_date1 = business_datenew[0];
						business_date2 = business_datenew[1];
						business_date3 = business_datenew[2];
						int business_date1_int = Integer.parseInt(business_date1);
						int business_date2_int = Integer.parseInt(business_date2);
						int business_date3_int = Integer.parseInt(business_date3);
						
						test.log(LogStatus.PASS, "Business date is :" + business_date);
						Thread.sleep(2000);
						driver.switchTo().defaultContent();
						LocalDate firstday;

						// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));

						driver.switchTo().frame("topFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));

						driver.findElement(locator(prop.getProperty("borrower_tab"))).click();
						Thread.sleep(2000);
						// driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();
						test.log(LogStatus.PASS, "Clicked on Borrower");
						Thread.sleep(2000);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='901000']")));
						driver.findElement(locator(prop.getProperty("registration_link"))).click();

						test.log(LogStatus.PASS, "Clicked on Registration");
						driver.switchTo().frame("main");
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);

						Date d = df.parse(business_date);
						Calendar cal = Calendar.getInstance();
						cal.setTime(d);
						int day_display = d.getDay();
						int month_dispay = d.getMonth();
						int year_display = d.getYear();
						
						LocalDate convertedDate = LocalDate.parse(business_date, DateTimeFormatter.ofPattern("M/d/yyyy"));
						convertedDate = convertedDate.withDayOfMonth(
						                                convertedDate.getMonth().length(convertedDate.isLeapYear()));
						
						//LocalDate now = LocalDate.of((business_date3_int ), (business_date2_int), business_date1_int);// now();
						// //2015-11-23
						//firstday = now.with(firstInMonth(DayOfWeek.valueOf(business_date2)));
						String f=String.valueOf(convertedDate);
						String convertedDatenew[] = f.split("-");
						String convertedDate1 = convertedDatenew[0];
						String convertedDate2 = convertedDatenew[1];
						String convertedDate3 = convertedDatenew[2];
						
						int lst_date=Integer.parseInt(convertedDate3);
						String date = null;
						
					

						
						
						// First option
						if (Monthly_Type.equals("1-16")) {
							if (!(month_dispay == 11)){
								driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
								test.log(LogStatus.PASS, "Income_PayFrequency is entered: " + Income_PayFrequency);
								driver.findElement(By.id("rad_semi1")).click();
								 test.log(LogStatus.PASS, "Clicked on 1st and 16th check box  ");
								// int business_date2_int = Integer.parseInt(business_date2);
									
									Thread.sleep(3000);
										
										String date1 = driver
												.findElement(By
														.xpath("//input[@name='NPMM' and @class='textBox20editablepp']"))
												.getAttribute("value");
										String date2 = driver
												.findElement(By
														.xpath("//input[@class='textBox20editablepp' and @name='NPDD']"))
												.getAttribute("value");
										String date3 = driver
												.findElement(By
														.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']"))
												.getAttribute("value");
										date = date1 + "/" + date2 + "/" + date3;

									
										if (business_date2_int  <15 && business_date2_int <= 1) {
											
											
											String expected_date = business_date1_int + "/" + 16 + "/"
													+ business_date3_int;
											String expected_date2 = "0" + (business_date1_int) + "/0" + 16 + "/"
													+ business_date3_int;
											String expected_date3 = (business_date1_int ) + "/" + "0" + 16 + "/"
													+ business_date3_int;
											String expected_date4 = "0" + (business_date1_int) + "/" + 16 + "/"
													+ business_date3_int;
											if (date.equalsIgnoreCase(expected_date)
													|| date.equalsIgnoreCase(expected_date2)
													|| date.equalsIgnoreCase(expected_date3)
													|| date.equalsIgnoreCase(expected_date4)) {
												test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
														+ (business_date1_int) + "/" + 15 + "/" + business_date3);
											} else {
												test.log(LogStatus.FAIL,
														"Displayed date: " + date + "Not equals to Expected date"
																+ business_date1_int + "/" + 15 + "/"+business_date3);
										

										}
										}

										else if (business_date2_int >= 15) {
											

											String expected_date = (business_date1_int+1) + "/" + 1 + "/"+ business_date3_int;
											String expected_date2 = "0" + (business_date1_int+1) + "/" + "0" + 1 + "/"+ business_date3_int;
											String expected_date3 = (business_date1_int+1) + "/" + "0" + 1 + "/"+ business_date3_int;
											String expected_date4 = "0" + (business_date1_int+1) + "/" + 1 + "/"+ business_date3_int;

												if (date.equalsIgnoreCase(expected_date)
														|| date.equalsIgnoreCase(expected_date2)
														|| date.equalsIgnoreCase(expected_date3)
														|| date.equalsIgnoreCase(expected_date4)) {
													test.log(LogStatus.PASS,
													"Displayed date: " + date + "== Expected date"+ (business_date1_int+1) + "/" + 1 + "/"+ business_date3);
												
												} else {
													test.log(LogStatus.FAIL,
															"Displayed date: " + date + "Not equals to Expected date"
																	+ (business_date1_int+1) + "/" + 1 + "/"
																	+ business_date3);
												}
										

											

											Thread.sleep(3000);
										}

							
							}
						
						if ((month_dispay == 11)) {
							driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
							test.log(LogStatus.PASS, "Income_PayFrequency is entered: " + Income_PayFrequency);
							driver.findElement(By.id("rad_semi1")).click();
							 test.log(LogStatus.PASS, "Clicked on 1st and 16th of check box  ");
							// int business_date2_int = Integer.parseInt(business_date2);
								
								
									
									String date1 = driver
											.findElement(By
													.xpath("//input[@name='NPMM' and @class='textBox20editablepp']"))
											.getAttribute("value");
									String date2 = driver
											.findElement(By
													.xpath("//input[@class='textBox20editablepp' and @name='NPDD']"))
											.getAttribute("value");
									String date3 = driver
											.findElement(By
													.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']"))
											.getAttribute("value");
									date = date1 + "/" + date2 + "/" + date3;

								
									if (business_date2_int  <15 && business_date2_int  <=1) {
										
										
										String expected_date = business_date1_int + "/" + 16 + "/"
												+ business_date3_int;
										String expected_date2 = "0" + (business_date1_int) + "/0" + 16 + "/"
												+ business_date3_int;
										String expected_date3 = (business_date1_int ) + "/" + "0" + 16 + "/"
												+ business_date3_int;
										String expected_date4 = "0" + (business_date1_int) + "/" + 16 + "/"
												+ business_date3_int;
										if (date.equalsIgnoreCase(expected_date)
												|| date.equalsIgnoreCase(expected_date2)
												|| date.equalsIgnoreCase(expected_date3)
												|| date.equalsIgnoreCase(expected_date4)) {
											test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
													+ (business_date1_int) + "/" + 15 + "/" + business_date3);
										} else {
											test.log(LogStatus.FAIL,
													"Displayed date: " + date + "Not equals to Expected date"
															+ business_date1_int + "/" + 15 + "/"+business_date3);
									

									}
									}

									else if (business_date2_int >= 16) {
										

										String expected_date = (1) + "/" + 1 + "/"
												+ (business_date3_int+1);
										String expected_date2 = "0" + (1) + "/" + "0" + 1 + "/"
												+ (business_date3_int+1);
										String expected_date3 = (1) + "/" + "0" + 1 + "/"
												+ (business_date3_int+1);
										String expected_date4 = "0" + (1) + "/" + 1 + "/"
												+ (business_date3_int+1);

											if (date.equalsIgnoreCase(expected_date)
													|| date.equalsIgnoreCase(expected_date2)
													|| date.equalsIgnoreCase(expected_date3)
													|| date.equalsIgnoreCase(expected_date4)) {
												test.log(LogStatus.PASS,
														"Displayed date: " + date + "== Expected date"
																+ (1) + "/" + 1 + "/"
																+ (business_date3_int+1));
											} else {
												test.log(LogStatus.FAIL,
														"Displayed date: " + date + "Not equals to Expected date"
																+ (1) + "/" + 1 + "/"
																+ (business_date3_int+1));
											}
									

										

										Thread.sleep(3000);
									}
						}
						}
						//Second option
						if (Monthly_Type.equals("15-Last")) {
							if (!(month_dispay == 11)) {
								driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
								test.log(LogStatus.PASS, "Income_PayFrequency is entered: " + Income_PayFrequency);
								driver.findElement(By.id("rad_semi2")).click();
								 test.log(LogStatus.PASS, "Clicked on 16th and last day check box  ");
								//int business_date2_int = Integer.parseInt(business_date2);
									
									
							
										String date1 = driver
												.findElement(By
														.xpath("//input[@name='NPMM' and @class='textBox20editablepp']"))
												.getAttribute("value");
										String date2 = driver
												.findElement(By
														.xpath("//input[@class='textBox20editablepp' and @name='NPDD']"))
												.getAttribute("value");
										String date3 = driver
												.findElement(By
														.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']"))
												.getAttribute("value");
										date = date1 + "/" + date2 + "/" + date3;

									
										if (business_date2_int  <15) {
											
											
											String expected_date = business_date1_int + "/" + 15 + "/"
													+ business_date3_int;
											String expected_date2 = "0" + (business_date1_int) + "/0" + 15 + "/"
													+ business_date3_int;
											String expected_date3 = (business_date1_int ) + "/" + "0" + 15 + "/"
													+ business_date3_int;
											String expected_date4 = "0" + (business_date1_int) + "/" + 15 + "/"
													+ business_date3_int;
											if (date.equalsIgnoreCase(expected_date)
													|| date.equalsIgnoreCase(expected_date2)
													|| date.equalsIgnoreCase(expected_date3)
													|| date.equalsIgnoreCase(expected_date4)) {
												test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
														+ (business_date1_int) + "/" + 15 + "/" + business_date3);
											} else {
												test.log(LogStatus.FAIL,
														"Displayed date: " + date + "Not equals to Expected date"
																+ business_date1_int + "/" + 15 + "/"+business_date3);
										

										}
										}

										else if (business_date2_int >= 15&&business_date2_int <= 31) {
											
											
											
											
											String date_new = (business_date1_int) + "/" + business_date2_int + "/"
													+ business_date3_int;
											convertedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("M/d/yyyy"));
											convertedDate = convertedDate.withDayOfMonth(
											                                convertedDate.getMonth().length(convertedDate.isLeapYear()));
											String convertedDate_str=String.valueOf(convertedDate);
											String convertedDate_new[] = convertedDate_str.split("-");
											String expected_year = convertedDate_new[0];
											String expected_month = convertedDate_new[1];
											String expected_day = convertedDate_new[2];
											int expected_day_int = Integer.parseInt(expected_day);
											if(business_date2_int==expected_day_int)
											{
												String expected_date = (business_date1_int+1) + "/" + 15 + "/"
														+ expected_year;
												String expected_date2 = (business_date1_int+1) + "/" + 15 + "/"
														+ expected_year;
												String expected_date3 = (business_date1_int+1) + "/" + 15 + "/"
														+ expected_year;
												String expected_date4 = (business_date1_int+1) + "/" + 15 + "/"
														+ expected_year;

													if (date.equalsIgnoreCase(expected_date)
															|| date.equalsIgnoreCase(expected_date2)
															|| date.equalsIgnoreCase(expected_date3)
															|| date.equalsIgnoreCase(expected_date4)) {
														test.log(LogStatus.PASS,
																"Displayed date: " + date + "== Expected date"
																		+ ((business_date1_int+1)) + "/" + 15 + "/"
																		+ business_date3);
													} else {
														test.log(LogStatus.FAIL,
																"Displayed date: " + date + "Not equals to Expected date"
																		+ ((business_date1_int+1)) + "/" + 15 + "/"
																		+ business_date3);
													}	
											}
											
											else{
											String expected_date = (expected_month) + "/" + expected_day + "/"
													+ expected_year;
											String expected_date2 = (expected_month) + "/" + expected_day + "/"
													+ expected_year;
											String expected_date3 = (expected_month) + "/" + expected_day + "/"
													+ expected_year;
											String expected_date4 = (expected_month) + "/" + expected_day + "/"
													+ expected_year;

												if (date.equalsIgnoreCase(expected_date)
														|| date.equalsIgnoreCase(expected_date2)
														|| date.equalsIgnoreCase(expected_date3)
														|| date.equalsIgnoreCase(expected_date4)) {
													test.log(LogStatus.PASS,
															"Displayed date: " + date + "== Expected date"
																	+ (business_date1_int) + "/" + 31 + "/"
																	+ business_date3);
												} else {
													test.log(LogStatus.FAIL,
															"Displayed date: " + date + "Not equals to Expected date"
																	+ (business_date1_int) + "/" + 31 + "/"
																	+ business_date3);
												}
										

											}

											Thread.sleep(3000);
										}

							
							}
							//For December
							if ((month_dispay == 11)) {
								driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
								test.log(LogStatus.PASS, "Income_PayFrequency is entered: " + Income_PayFrequency);
								driver.findElement(By.id("rad_semi2")).click();
								 test.log(LogStatus.PASS, "Clicked on 16th and last day check box  ");
								//int business_date2_int = Integer.parseInt(business_date2);
									
									
							
										String date1 = driver
												.findElement(By
														.xpath("//input[@name='NPMM' and @class='textBox20editablepp']"))
												.getAttribute("value");
										String date2 = driver
												.findElement(By
														.xpath("//input[@class='textBox20editablepp' and @name='NPDD']"))
												.getAttribute("value");
										String date3 = driver
												.findElement(By
														.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']"))
												.getAttribute("value");
										date = date1 + "/" + date2 + "/" + date3;

									
										if (business_date2_int  < 15) {
											
											
											String expected_date = business_date1_int + "/" + 16 + "/"
													+ business_date3_int;
											String expected_date2 = "0" + (business_date1_int) + "/0" + 16 + "/"
													+ business_date3_int;
											String expected_date3 = (business_date1_int ) + "/" + "0" + 16 + "/"
													+ business_date3_int;
											String expected_date4 = "0" + (business_date1_int) + "/" + 16 + "/"
													+ business_date3_int;
											if (date.equalsIgnoreCase(expected_date)
													|| date.equalsIgnoreCase(expected_date2)
													|| date.equalsIgnoreCase(expected_date3)
													|| date.equalsIgnoreCase(expected_date4)) {
												test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
														+ (business_date1_int) + "/" + 16 + "/" + business_date3);
											} else {
												test.log(LogStatus.FAIL,
														"Displayed date: " + date + "Not equals to Expected date"
																+ business_date1_int + "/" + 16 + "/"+business_date3);
										

										}
										}

										else if (business_date2_int >= 15&&business_date2_int <= 31) {
											
											
											
											
											String date_new = (business_date1_int) + "/" + business_date2_int + "/"
													+ business_date3_int;
											convertedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("M/d/yyyy"));
											convertedDate = convertedDate.withDayOfMonth(
											                                convertedDate.getMonth().length(convertedDate.isLeapYear()));
											String convertedDate_str=String.valueOf(convertedDate);
											String convertedDate_new[] = convertedDate_str.split("-");
											String expected_year = convertedDate_new[0];
											String expected_month = convertedDate_new[1];
											String expected_day = convertedDate_new[2];
											int expected_day_int = Integer.parseInt(expected_day);
											if(business_date2_int==expected_day_int)
											{
												String expected_date = (1) + "/" + 16 + "/"
														+ (business_date3_int+1);
												String expected_date2 = (1) + "/" + 16 + "/"
														+ (business_date3_int+1);
												String expected_date3 = (1) + "/" + 16 + "/"
														+ (business_date3_int+1);
												String expected_date4 = (1) + "/" + 16 + "/"
														+ (business_date3_int+1);

													if (date.equalsIgnoreCase(expected_date)
															|| date.equalsIgnoreCase(expected_date2)
															|| date.equalsIgnoreCase(expected_date3)
															|| date.equalsIgnoreCase(expected_date4)) {
														test.log(LogStatus.PASS,
																"Displayed date: " + date + "== Expected date"
																		+ ((1)) + "/" + 15 + "/"
																		+ (business_date3_int+1));
													} else {
														test.log(LogStatus.FAIL,
																"Displayed date: " + date + "Not equals to Expected date"
																		+ ((1)) + "/" + 15 + "/"
																		+ (business_date3_int+1));
													}	
											}
											
											else{
											String expected_date = (expected_month) + "/" + expected_day + "/"
													+ expected_year;
											String expected_date2 = (expected_month) + "/" + expected_day + "/"
													+ expected_year;
											String expected_date3 = (expected_month) + "/" + expected_day + "/"
													+ expected_year;
											String expected_date4 = (expected_month) + "/" + expected_day + "/"
													+ expected_year;

												if (date.equalsIgnoreCase(expected_date)
														|| date.equalsIgnoreCase(expected_date2)
														|| date.equalsIgnoreCase(expected_date3)
														|| date.equalsIgnoreCase(expected_date4)) {
													test.log(LogStatus.PASS,
															"Displayed date: " + date + "== Expected date"
																	+ (business_date1_int) + "/" + 31 + "/"
																	+ business_date3);
												} else {
													test.log(LogStatus.FAIL,
															"Displayed date: " + date + "Not equals to Expected date"
																	+ (business_date1_int) + "/" + 31 + "/"
																	+ business_date3);
												}
										

											}

											Thread.sleep(3000);
										}

							
							}
						}
						
						else if (Monthly_Type.equals("Other")) {
							driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
							test.log(LogStatus.PASS, "Income_PayFrequency is entered: " + Income_PayFrequency);

							test.log(LogStatus.PASS, "Monthly type selected: " + Monthly_Type);
							//driver.findElement(By.id("rad_monthly2")).click();
							//test.log(LogStatus.PASS, "Clicked on monthly type: " + Monthly_Type);
							
							driver.findElement(By.id("oth1")).click();
							test.log(LogStatus.PASS, "Clicked on Other radio button");
							
							try { 
							    Alert alert = driver.switchTo().alert();
							    alert.accept();
							   // if alert present, accept and move on.												
								
							}
							catch (NoAlertPresentException e) {
							    //do what you normally would if you didn't have the alert.
							}
							driver.findElement(By.name("semi_other")).click();
							test.log(LogStatus.PASS, "Clicked first option/ dates radio button");
							
							
							Select dropdown = new Select(driver.findElement(By.name("customerBean.semiFirstDate")));

							List<WebElement> options = dropdown.getOptions();
							
							Select dropdown2 = new Select(driver.findElement(By.name("customerBean.semiSecondDate")));

							List<WebElement> options2 = dropdown2.getOptions();

							for (int k = 1; k <= 15; k++) {
								

									
								Thread.sleep(2000);
									driver.findElement(By.name("customerBean.semiFirstDate"))
											.sendKeys(options.get(k).getText());
									test.log(LogStatus.PASS,
											"Day selected : " + options.get(k).getText());
									dropdown2.selectByIndex(k);
									//driver.findElement(By.name("customerBean.semiSecondDate")).sendKeys(options2.get(k).getText());
									test.log(LogStatus.PASS,

											"Second Day selected : " + options2.get(k).getText());
									String date1 = driver
											.findElement(
													By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']"))
											.getAttribute("value");
									
									String date2 = driver
											.findElement(
													By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']"))
											.getAttribute("value");
									String date3 = driver
											.findElement(By
													.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']"))
											.getAttribute("value");
									Thread.sleep(2000);
									date = date1 + "/" + date2 + "/" + date3;
									
									
									
									
									if(business_date2_int>=k)
									{
										if(business_date2_int==k){
											 x=16-business_date2_int;
											business_date2_int=business_date2_int+x;
										}
										//k=15;
										String expected_date = business_date1_int + "/" + business_date2_int  + "/"
												+ business_date3_int;
	//Changed this code									
										//String expected_date = business_date1_int+1 + "/" + (k) + "/"
												//+ business_date3_int;
										String expected_date2 = "0" + (business_date1_int) + "/0" + business_date2_int + "/"
												+ business_date3_int;
										String expected_date3 = (business_date1_int ) + "/" + "0" + business_date2_int + "/"
												+ business_date3_int;
										String expected_date4 = "0" + (business_date1_int) + "/" + business_date2_int + "/"
												+ business_date3_int;
										
										/*else {
											k=1;
											String expected_date = business_date1_int+1 + "/" + (k) + "/"
											+ business_date3_int;
									String expected_date2 = "0" + (business_date1_int+1) + "/0" + (k) + "/"
											+ business_date3_int;
									String expected_date3 = (business_date1_int+1 ) + "/" + "0" + (k) + "/"
											+ business_date3_int;
									String expected_date4 = "0" + (business_date1_int+1) + "/" + (k) + "/"
											+ business_date3_int;}
										}*/
										
										
										if (date.equalsIgnoreCase(expected_date)|| date.equalsIgnoreCase(expected_date2)|| date.equalsIgnoreCase(expected_date3)|| date.equalsIgnoreCase(expected_date4))
										{
											test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
													+ (business_date1_int) + "/" + (business_date2_int) + "/" + business_date3);
											business_date2_int=business_date2_int-x;
										} else {
											test.log(LogStatus.FAIL,
													"Displayed date: " + date + "Not equals to Expected date"
															+ business_date1_int+1 + "/" + (k) + "/"+business_date3);
											getScreenhot(driver,"xyz");
											
											
									}
											
										
							}
									else if(business_date2_int<k&&!(month_dispay==11))
									{
										
										
										String expected_date = business_date1_int + "/" + (k) + "/"
												+ business_date3_int;
										String expected_date2 = "0" + (business_date1_int) + "/0" + (k) + "/"
												+ business_date3_int;
										String expected_date3 = (business_date1_int ) + "/" + "0" + (k) + "/"
												+ business_date3_int;
										String expected_date4 = "0" + (business_date1_int) + "/" + (k) + "/"
												+ business_date3_int;
										if (date.equalsIgnoreCase(expected_date)
												|| date.equalsIgnoreCase(expected_date2)
												|| date.equalsIgnoreCase(expected_date3)
												|| date.equalsIgnoreCase(expected_date4)) {
											test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
													+ (business_date1_int) + "/" + (k) + "/" + business_date3);
										} else {
											test.log(LogStatus.FAIL,
													"Displayed date: " + date + "Not equals to Expected date"
															+ business_date1_int + "/" + (k) + "/"+business_date3);
									}
										
											
										
							}
									
						
									else if(business_date2_int>=k&&(month_dispay==11))
									{
										
										
										String expected_date = business_date1_int + "/" + (k+15) + "/"
												+ business_date3_int;
										String expected_date2 = "0" + (business_date1_int) + "/0" + (k+15) + "/"
												+ business_date3_int;
										String expected_date3 = (business_date1_int ) + "/" + "0" + (k+15) + "/"
												+ business_date3_int;
										String expected_date4 = "0" + (business_date1_int) + "/" + (k+15) + "/"
												+ business_date3_int;
										if (date.equalsIgnoreCase(expected_date)
												|| date.equalsIgnoreCase(expected_date2)
												|| date.equalsIgnoreCase(expected_date3)
												|| date.equalsIgnoreCase(expected_date4)) {
											test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
													+ (business_date1_int) + "/" + (k+15) + "/" + business_date3);
										} else {
											test.log(LogStatus.FAIL,
													"Displayed date: " + date + "Not equals to Expected date"
															+ business_date1_int + "/" + (k+15) + "/"+business_date3);
									}

																				
									
									
									
									
						}
									dropdown.selectByIndex(0);
									Thread.sleep(2000);
									dropdown2.selectByIndex(0);
									Thread.sleep(2000);
							continue;}
							
								dropdown.selectByIndex(0);
								Thread.sleep(2000);
								dropdown2.selectByIndex(0);
								Thread.sleep(2000);
//Last Day selection
//feb and 28								
								if(month_dispay==1&&lst_date==28)
								{

									driver.findElement(By.name("customerBean.semiFirstDate"))
											.sendKeys("13");
									test.log(LogStatus.PASS,
											"Day selected : " + 13);
									
									driver.findElement(By.name("customerBean.semiSecondDate")).sendKeys("Last Day");
									test.log(LogStatus.PASS,

											"Second Day selected : Last day");
									String date1 = driver
											.findElement(
													By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']"))
											.getAttribute("value");
								
									String date2 = driver
											.findElement(
													By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']"))
											.getAttribute("value");
									String date3 = driver
											.findElement(By
													.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']"))
											.getAttribute("value");
									Thread.sleep(2000);
									date = date1 + "/" + date2 + "/" + date3;
								}
//feb and 29								
								if(month_dispay==1&&lst_date==29)
								{
									driver.findElement(By.name("customerBean.semiFirstDate"))
									.sendKeys("14");
							test.log(LogStatus.PASS,
									"Day selected : " + 14);
							
							driver.findElement(By.name("customerBean.semiSecondDate")).sendKeys("Last Day");
							test.log(LogStatus.PASS,

									"Second Day selected : Last day");
							String date1 = driver
									.findElement(
											By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']"))
									.getAttribute("value");
							Thread.sleep(3000);
							String date2 = driver
									.findElement(
											By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']"))
									.getAttribute("value");
							String date3 = driver
									.findElement(By
											.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']"))
									.getAttribute("value");
							Thread.sleep(2000);
							date = date1 + "/" + date2 + "/" + date3;	
								}
// 30 days month							
								if(lst_date==30)
								{
									driver.findElement(By.name("customerBean.semiFirstDate"))
									.sendKeys("15");
							test.log(LogStatus.PASS,
									"Day selected : " + 15);
							
							driver.findElement(By.name("customerBean.semiSecondDate")).sendKeys("Last Day");
							test.log(LogStatus.PASS,

									"Second Day selected : Last day");
							String date1 = driver
									.findElement(
											By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']"))
									.getAttribute("value");
							Thread.sleep(3000);
							String date2 = driver
									.findElement(
											By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']"))
									.getAttribute("value");
							String date3 = driver
									.findElement(By
											.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']"))
									.getAttribute("value");
							Thread.sleep(2000);
							date = date1 + "/" + date2 + "/" + date3;	
								}
//31 days month
				/*				if(lst_date==31)
								{
									driver.findElement(By.name("customerBean.semiFirstDate"))
									.sendKeys("14");
							test.log(LogStatus.PASS,
									"Day selected : " + 14);
							
							driver.findElement(By.name("customerBean.semiSecondDate")).sendKeys("Last Day");
							test.log(LogStatus.PASS,

									"Second Day selected : Last day");
							String date1 = driver
									.findElement(
											By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']"))
									.getAttribute("value");
							Thread.sleep(3000);
							String date2 = driver
									.findElement(
											By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']"))
									.getAttribute("value");
							String date3 = driver
									.findElement(By
											.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']"))
									.getAttribute("value");
							Thread.sleep(2000);
							date = date1 + "/" + date2 + "/" + date3;	
								}*/
	//verifying date of feb month							
								if(business_date2_int<15&&(lst_date==28)&&(month_dispay==1))
								{
									
									
									String expected_date = business_date1_int + "/" + (13) + "/"
											+ business_date3_int;
									String expected_date2 = "0" + (business_date1_int) + "/0" + (13) + "/"
											+ business_date3_int;
									String expected_date3 = (business_date1_int ) + "/" + "0" + (13) + "/"
											+ business_date3_int;
									String expected_date4 = "0" + (business_date1_int) + "/" + (13) + "/"
											+ business_date3_int;
									if (date.equalsIgnoreCase(expected_date)
											|| date.equalsIgnoreCase(expected_date2)
											|| date.equalsIgnoreCase(expected_date3)
											|| date.equalsIgnoreCase(expected_date4)) {
										test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
												+ (business_date1_int) + "/" + (13) + "/" + business_date3);
									} else {
										test.log(LogStatus.FAIL,
												"Displayed date: " + date + "Not equals to Expected date"
														+ business_date1_int + "/" + (13) + "/"+business_date3);
								}
										
									
						}
//verifying date of feb month					
								else if(business_date2_int>=13&&(lst_date==28))
								{
									
									
									String expected_date = business_date1_int + "/" + (28) + "/"
											+ business_date3_int;
									String expected_date2 = "0" + (business_date1_int) + "/0" + (28) + "/"
											+ business_date3_int;
									String expected_date3 = (business_date1_int ) + "/" + "0" + (28) + "/"
											+ business_date3_int;
									String expected_date4 = "0" + (business_date1_int) + "/" + (28) + "/"
											+ business_date3_int;
									if (date.equalsIgnoreCase(expected_date)
											|| date.equalsIgnoreCase(expected_date2)
											|| date.equalsIgnoreCase(expected_date3)
											|| date.equalsIgnoreCase(expected_date4)) {
										test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
												+ (business_date1_int) + "/" + (28) + "/" + business_date3);
									} else {
										test.log(LogStatus.FAIL,
												"Displayed date: " + date + "Not equals to Expected date"
														+ business_date1_int + "/" + (28) + "/"+business_date3);
								}
										
									
						}
//verifying date of feb month	29 days
								else if(business_date2_int<14&&(lst_date==29))
								{
									
									
									String expected_date = business_date1_int + "/" + (14) + "/"
											+ business_date3_int;
									String expected_date2 = "0" + (business_date1_int) + "/0" + (14) + "/"
											+ business_date3_int;
									String expected_date3 = (business_date1_int ) + "/" + "0" + (14) + "/"
											+ business_date3_int;
									String expected_date4 = "0" + (business_date1_int) + "/" + (14) + "/"
											+ business_date3_int;
									if (date.equalsIgnoreCase(expected_date)
											|| date.equalsIgnoreCase(expected_date2)
											|| date.equalsIgnoreCase(expected_date3)
											|| date.equalsIgnoreCase(expected_date4)) {
										test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
												+ (business_date1_int) + "/" + (14) + "/" + business_date3);
									} else {
										test.log(LogStatus.FAIL,
												"Displayed date: " + date + "Not equals to Expected date"
														+ business_date1_int + "/" + (14) + "/"+business_date3);
								}
										
									
						}
								else if(business_date2_int>=14&&(lst_date==29))
								{
									
									
									String expected_date = business_date1_int + "/" + (29) + "/"
											+ business_date3_int;
									String expected_date2 = "0" + (business_date1_int) + "/0" + (29) + "/"
											+ business_date3_int;
									String expected_date3 = (business_date1_int ) + "/" + "0" + (29) + "/"
											+ business_date3_int;
									String expected_date4 = "0" + (business_date1_int) + "/" + (29) + "/"
											+ business_date3_int;
									if (date.equalsIgnoreCase(expected_date)
											|| date.equalsIgnoreCase(expected_date2)
											|| date.equalsIgnoreCase(expected_date3)
											|| date.equalsIgnoreCase(expected_date4)) {
										test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
												+ (business_date1_int) + "/" + (29) + "/" + business_date3);
									} else {
										test.log(LogStatus.FAIL,
												"Displayed date: " + date + "Not equals to Expected date"
														+ business_date1_int + "/" + (29) + "/"+business_date3);
								}
										
									
						}
//verifying date of 30 days
								else if(business_date2_int<15&&(lst_date==30))
								{
									
									
									String expected_date = business_date1_int + "/" + (15) + "/"
											+ business_date3_int;
									String expected_date2 = "0" + (business_date1_int) + "/0" + (15) + "/"
											+ business_date3_int;
									String expected_date3 = (business_date1_int ) + "/" + "0" + (15) + "/"
											+ business_date3_int;
									String expected_date4 = "0" + (business_date1_int) + "/" + (15) + "/"
											+ business_date3_int;
									if (date.equalsIgnoreCase(expected_date)
											|| date.equalsIgnoreCase(expected_date2)
											|| date.equalsIgnoreCase(expected_date3)
											|| date.equalsIgnoreCase(expected_date4)) {
										test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
												+ (business_date1_int) + "/" + (15) + "/" + business_date3);
									} else {
										test.log(LogStatus.FAIL,
												"Displayed date: " + date + "Not equals to Expected date"
														+ business_date1_int + "/" + (15) + "/"+business_date3);
								}
										
									
						}	
	//Code changed							
								else if(business_date2_int>=15&&(lst_date==30))
								{
									
									
									String expected_date = business_date1_int+1 + "/" + (15) + "/"
											+ business_date3_int;
									String expected_date2 = "0" + (business_date1_int+1) + "/0" + (15) + "/"
											+ business_date3_int;
									String expected_date3 = (business_date1_int+1 ) + "/" + "0" + (15) + "/"
											+ business_date3_int;
									String expected_date4 = "0" + (business_date1_int+1) + "/" + (15) + "/"
											+ business_date3_int;
									if (date.equalsIgnoreCase(expected_date)
											|| date.equalsIgnoreCase(expected_date2)
											|| date.equalsIgnoreCase(expected_date3)
											|| date.equalsIgnoreCase(expected_date4)) {
										test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
												+ (business_date1_int+1) + "/" + (15) + "/" + business_date3);
									} else {
										test.log(LogStatus.FAIL,
												"Displayed date: " + date + "Not equals to Expected date"
														+ business_date1_int+1 + "/" + (15) + "/"+business_date3);
								}
										
									
						}
/*//verifying date of 31 days
								else if(business_date2_int<15&&(lst_date==31))
						{
							
							
							String expected_date = business_date1_int + "/" + (31) + "/"
									+ business_date3_int;
							String expected_date2 = "0" + (business_date1_int) + "/0" + (31) + "/"
									+ business_date3_int;
							String expected_date3 = (business_date1_int ) + "/" + "0" + (31) + "/"
									+ business_date3_int;
							String expected_date4 = "0" + (business_date1_int) + "/" + (31) + "/"
									+ business_date3_int;
							if (date.equalsIgnoreCase(expected_date)
									|| date.equalsIgnoreCase(expected_date2)
									|| date.equalsIgnoreCase(expected_date3)
									|| date.equalsIgnoreCase(expected_date4)) {
								test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
										+ (business_date1_int) + "/" + (31) + "/" + business_date3);
							} else {
								test.log(LogStatus.FAIL,
										"Displayed date: " + date + "Not equals to Expected date"
												+ business_date1_int + "/" + (31) + "/"+business_date3);
						}
								
							
				}*/
							
								
						
							
							
						}
							
						else if (Monthly_Type.equals("Other2")) {
							driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
							test.log(LogStatus.PASS, "Income_PayFrequency is entered: " + Income_PayFrequency);

							test.log(LogStatus.PASS, "Monthly type selected: " + Monthly_Type);
							driver.findElement(By.id("rad_monthly2")).click();
							test.log(LogStatus.PASS, "Clicked on monthly type: " + Monthly_Type);
							
							driver.findElement(By.id("oth1")).click();
							test.log(LogStatus.PASS, "Clicked on Other radio button");
							
							try { 
							    Alert alert = driver.switchTo().alert();
							    alert.accept();
							   // if alert present, accept and move on.												
								
							}
							catch (NoAlertPresentException e) {
							    //do what you normally would if you didn't have the alert.
							}
							driver.findElement(By.id("semi_other")).click();
							test.log(LogStatus.PASS, "Clicked first option/ dates radio button");
							
							
							Select dropdown = new Select(driver.findElement(By.name("customerBean.semiFirstDate")));

							List<WebElement> options = dropdown.getOptions();
							
							Select dropdown2 = new Select(driver.findElement(By.name("customerBean.semiSecondDate")));

							List<WebElement> options2 = dropdown2.getOptions();

							for (int k = 1; k <= 15; k++) {
								for (int m = 1; m <= 7; m++) {

									String weekday = options2.get(m).getText();

									driver.findElement(By.name("customerBean.monthlyWeek"))
											.sendKeys(options.get(k).getText());
									test.log(LogStatus.PASS,
											"Monthly pay week is selected : " + options.get(k).getText());
									driver.findElement(By.name("customerBean.monthlyDay")).sendKeys(weekday);
									test.log(LogStatus.PASS, "Monthly pay week is selected : " + weekday);
									String date1 = driver
											.findElement(
													By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']"))
											.getAttribute("value");
									String date2 = driver
											.findElement(
													By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']"))
											.getAttribute("value");
									String date3 = driver
											.findElement(By
													.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']"))
											.getAttribute("value");
									date = date1 + "/" + date2 + "/" + date3;

									LocalDate now;
									// First week
									if (options.get(k).getText().equalsIgnoreCase("FIRST")) {

										for (int j = 1; j <= 7; j++) {
											String dat = business_date1 + "/" + j + "/" + business_date3;
											Date d1 = df.parse(dat);
											int month = d1.getMonth();
											int year = Integer.parseInt(business_date3);

											Calendar c = Calendar.getInstance();
											c.setTime(d1);
											int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
											String day = String.valueOf(dayOfWeek);
											if (day.equalsIgnoreCase("1")) {
												day = "SUNDAY";
											}
											if (day.equalsIgnoreCase("2")) {
												day = "MONDAY";
											}
											if (day.equalsIgnoreCase("3")) {
												day = "TUESDAY";
											}
											if (day.equalsIgnoreCase("4")) {
												day = "WEDNESDAY";
											}
											if (day.equalsIgnoreCase("5")) {
												day = "THURSDAY";
											}
											if (day.equalsIgnoreCase("6")) {
												day = "FRIDAY";
											}
											if (day.equalsIgnoreCase("7")) {
												day = "SATURDAY";
											}

											

											if (day.equalsIgnoreCase(weekday)) {

												if (j <= business_date2_int) {

													// String month="fsd";
													// int
													// business_date3int=Integer.parseInt(business_date3);

													int dayOfMonth;

													if (month == 11) {
														now = LocalDate.of((year + 1), (1), j);// now();
																											// //2015-11-23
														firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
													} else {
														now = LocalDate.of(year, (month + 2), j);// now();
																											// //2015-11-23
														firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));

													}
													String firstday_string = String.valueOf(firstday);
													String Expected[] = firstday_string.split("-");
													String Expected_year = Expected[0];
													String Expected_month = Expected[1];
													String Expected_date = Expected[2];

													String expected_date = Expected_month + "/" + Expected_date + "/"
															+ Expected_year;
													if (date.equalsIgnoreCase(expected_date)) {
														test.log(LogStatus.PASS, "Displayed date: " + date
																+ "== Expected date" + expected_date);
													} else {
														test.log(LogStatus.FAIL, "Displayed date: " + date
																+ "Not equals to Expected date" + expected_date);
													}

													break;

												}

												if (j > business_date2_int) {
													String expected_date = (month + 1) + "/" + j + "/" + year;
													String expected_date2 = "0" + (month + 1) + "/" + j + "/" + year;
													String expected_date3 = +(month + 1) + "/0" + j + "/" + year;
													String expected_date4 = "0" + (month + 1) + "/0" + j + "/" + year;
													if (date.equalsIgnoreCase(expected_date)
															|| date.equalsIgnoreCase(expected_date2)
															|| date.equalsIgnoreCase(expected_date3)
															|| date.equalsIgnoreCase(expected_date4)) {
														test.log(LogStatus.PASS, "Displayed date: " + date
																+ "== Expected date" + expected_date);
													} else {
														test.log(LogStatus.FAIL, "Displayed date: " + date
																+ "Not equals to Expected date" + expected_date);
													}

													break;

												}

											}

										}
										Thread.sleep(3000);
									}

									// Second week
									if (options.get(k).getText().equalsIgnoreCase("SECOND")) {

										for (int j = 8; j <= 14; j++) {
											String dat = business_date1 + "/" + j + "/" + business_date3;
											Date d1 = df.parse(dat);
											int month = d1.getMonth();
											int year = Integer.parseInt(business_date3);

											Calendar c = Calendar.getInstance();
											c.setTime(d1);
											int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
											String day = String.valueOf(dayOfWeek);
											if (day.equalsIgnoreCase("1")) {
												day = "SUNDAY";
											}
											if (day.equalsIgnoreCase("2")) {
												day = "MONDAY";
											}
											if (day.equalsIgnoreCase("3")) {
												day = "TUESDAY";
											}
											if (day.equalsIgnoreCase("4")) {
												day = "WEDNESDAY";
											}
											if (day.equalsIgnoreCase("5")) {
												day = "THURSDAY";
											}
											if (day.equalsIgnoreCase("6")) {
												day = "FRIDAY";
											}
											if (day.equalsIgnoreCase("7")) {
												day = "SATURDAY";
											}

										

											if (day.equalsIgnoreCase(weekday)) {

												if (j <= business_date2_int) {

													// String month="fsd";
													// int
													// business_date3int=Integer.parseInt(business_date3);

													int dayOfMonth;
													if (month == 11) {
														now = LocalDate.of((year + 1), (1), j);// now();
																											// //2015-11-23
														firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));

													} else {
														now = LocalDate.of(year, (month + 2), j);// now();
																											// //2015-11-23
														firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
													}
													String firstday_string = String.valueOf(firstday);
													String Expected[] = firstday_string.split("-");
													String Expected_year = Expected[0];
													String Expected_month = Expected[1];
													String Expected_date = Expected[2];
													int Expected_date_int = Integer.parseInt(Expected_date);
													Expected_date_int = Expected_date_int + 7;

													String expected_date = Expected_month + "/" + Expected_date_int
															+ "/" + Expected_year;
													String expected_date2 = "0" + Expected_month + "/"
															+ Expected_date_int + "/" + Expected_year;
													String expected_date3 = Expected_month + "/0" + Expected_date_int
															+ "/" + Expected_year;
													String expected_date4 = "0" + Expected_month + "/0"
															+ Expected_date_int + "/" + Expected_year;
													if (date.equalsIgnoreCase(expected_date)
															|| date.equalsIgnoreCase(expected_date2)
															|| date.equalsIgnoreCase(expected_date3)
															|| date.equalsIgnoreCase(expected_date4)) {
														test.log(LogStatus.PASS, "Displayed date: " + date
																+ "== Expected date" + expected_date);
													} else {
														test.log(LogStatus.FAIL, "Displayed date: " + date
																+ "Not equals to Expected date" + expected_date);
													}

													break;

												}

												if (j > business_date2_int) {
													String expected_date = (month + 1) + "/" + j + "/" + year;
													String expected_date2 = "0" + (month + 1) + "/" + j + "/" + year;
													String expected_date3 = +(month + 1) + "/0" + j + "/" + year;
													String expected_date4 = "0" + (month + 1) + "/0" + j + "/" + year;
													if (date.equalsIgnoreCase(expected_date)
															|| date.equalsIgnoreCase(expected_date2)
															|| date.equalsIgnoreCase(expected_date3)
															|| date.equalsIgnoreCase(expected_date4)) {
														test.log(LogStatus.PASS, "Displayed date: " + date
																+ "== Expected date" + expected_date);
													} else {
														test.log(LogStatus.FAIL, "Displayed date: " + date
																+ "Not equals to Expected date" + expected_date);
													}

													break;

												}

											}

										}
										Thread.sleep(3000);
									}

									// Third week

									if (options.get(k).getText().equalsIgnoreCase("THIRD")) {

										for (int j = 15; j <= 21; j++) {
											String dat = business_date1 + "/" + j + "/" + business_date3;
											Date d1 = df.parse(dat);
											int month = d1.getMonth();
											int year = Integer.parseInt(business_date3);

											Calendar c = Calendar.getInstance();
											c.setTime(d1);
											int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
											String day = String.valueOf(dayOfWeek);
											if (day.equalsIgnoreCase("1")) {
												day = "SUNDAY";
											}
											if (day.equalsIgnoreCase("2")) {
												day = "MONDAY";
											}
											if (day.equalsIgnoreCase("3")) {
												day = "TUESDAY";
											}
											if (day.equalsIgnoreCase("4")) {
												day = "WEDNESDAY";
											}
											if (day.equalsIgnoreCase("5")) {
												day = "THURSDAY";
											}
											if (day.equalsIgnoreCase("6")) {
												day = "FRIDAY";
											}
											if (day.equalsIgnoreCase("7")) {
												day = "SATURDAY";
											}

											

											if (day.equalsIgnoreCase(weekday)) {

												if (j <= business_date2_int) {

													// String month="fsd";
													// int
													// business_date3int=Integer.parseInt(business_date3);

													int dayOfMonth;
													if (month == 11) {
													now = LocalDate.of((year + 1), (1), j);// now();
																											// //2015-11-23
														firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
													} else {
													 now = LocalDate.of(year, (month + 2), j);// now();
																											// //2015-11-23
														firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
													}
													String firstday_string = String.valueOf(firstday);
													String Expected[] = firstday_string.split("-");
													String Expected_year = Expected[0];
													String Expected_month = Expected[1];
													String Expected_date = Expected[2];
													int Expected_date_int = Integer.parseInt(Expected_date);
													Expected_date_int = Expected_date_int + 14;

													String expected_date = Expected_month + "/" + Expected_date_int
															+ "/" + Expected_year;
													String expected_date2 = "0" + Expected_month + "/"
															+ Expected_date_int + "/" + Expected_year;
													String expected_date3 = Expected_month + "/0" + Expected_date_int
															+ "/" + Expected_year;
													String expected_date4 = "0" + Expected_month + "/0"
															+ Expected_date_int + "/" + Expected_year;
													if (date.equalsIgnoreCase(expected_date)
															|| date.equalsIgnoreCase(expected_date2)
															|| date.equalsIgnoreCase(expected_date3)
															|| date.equalsIgnoreCase(expected_date4)) {
														test.log(LogStatus.PASS, "Displayed date: " + date
																+ "== Expected date" + expected_date);
													} else {
														test.log(LogStatus.FAIL, "Displayed date: " + date
																+ "Not equals to Expected date" + expected_date);
													}

													break;

												}

												if (j > business_date2_int) {
													String expected_date = (month + 1) + "/" + j + "/" + year;
													String expected_date2 = "0" + (month + 1) + "/" + j + "/" + year;
													String expected_date3 = +(month + 1) + "/0" + j + "/" + year;
													String expected_date4 = "0" + (month + 1) + "/0" + j + "/" + year;
													if (date.equalsIgnoreCase(expected_date)
															|| date.equalsIgnoreCase(expected_date2)
															|| date.equalsIgnoreCase(expected_date3)
															|| date.equalsIgnoreCase(expected_date4)) {
														test.log(LogStatus.PASS, "Displayed date: " + date
																+ "== Expected date" + expected_date);
													} else {
														test.log(LogStatus.FAIL, "Displayed date: " + date
																+ "Not equals to Expected date" + expected_date);
													}

													break;

												}

											}

										}
										Thread.sleep(3000);
									}

									// Forth week

									if (options.get(k).getText().equalsIgnoreCase("FOURTH")) {

										for (int j = 22; j <= 28; j++) {
											String dat = business_date1 + "/" + j + "/" + business_date3;
											Date d1 = df.parse(dat);
											int month = d1.getMonth();
											int year = Integer.parseInt(business_date3);

											Calendar c = Calendar.getInstance();
											c.setTime(d1);
											int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
											String day = String.valueOf(dayOfWeek);
											if (day.equalsIgnoreCase("1")) {
												day = "SUNDAY";
											}
											if (day.equalsIgnoreCase("2")) {
												day = "MONDAY";
											}
											if (day.equalsIgnoreCase("3")) {
												day = "TUESDAY";
											}
											if (day.equalsIgnoreCase("4")) {
												day = "WEDNESDAY";
											}
											if (day.equalsIgnoreCase("5")) {
												day = "THURSDAY";
											}
											if (day.equalsIgnoreCase("6")) {
												day = "FRIDAY";
											}
											if (day.equalsIgnoreCase("7")) {
												day = "SATURDAY";
											}

											

											if (day.equalsIgnoreCase(weekday)) {

												if (j <= business_date2_int) {

													// String month="fsd";
													// int
													// business_date3int=Integer.parseInt(business_date3);

													if (month == 11) {
												now = LocalDate.of((year + 1), (1), j);// now();
																											// //2015-11-23
														firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
													} else {
												now = LocalDate.of(year, (month + 2), j);// now();
																											// //2015-11-23
														firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
													}
													String firstday_string = String.valueOf(firstday);
													String Expected[] = firstday_string.split("-");
													String Expected_year = Expected[0];
													String Expected_month = Expected[1];
													String Expected_date = Expected[2];
													int Expected_date_int = Integer.parseInt(Expected_date);
													Expected_date_int = Expected_date_int + 21;

													String expected_date = Expected_month + "/" + Expected_date_int
															+ "/" + Expected_year;
													String expected_date2 = "0" + Expected_month + "/"
															+ Expected_date_int + "/" + Expected_year;
													String expected_date3 = Expected_month + "/0" + Expected_date_int
															+ "/" + Expected_year;
													String expected_date4 = "0" + Expected_month + "/0"
															+ Expected_date_int + "/" + Expected_year;
													if (date.equalsIgnoreCase(expected_date)
															|| date.equalsIgnoreCase(expected_date2)
															|| date.equalsIgnoreCase(expected_date3)
															|| date.equalsIgnoreCase(expected_date4)) {
														test.log(LogStatus.PASS, "Displayed date: " + date
																+ "== Expected date" + expected_date);
													} else {
														test.log(LogStatus.FAIL, "Displayed date: " + date
																+ "Not equals to Expected date" + expected_date);
													}

													break;

												}

												if (j > business_date2_int) {
													String expected_date = (month + 1) + "/" + j + "/" + year;
													String expected_date2 = "0" + (month + 1) + "/" + j + "/" + year;
													String expected_date3 = +(month + 1) + "/0" + j + "/" + year;
													String expected_date4 = "0" + (month + 1) + "/0" + j + "/" + year;
													if (date.equalsIgnoreCase(expected_date)
															|| date.equalsIgnoreCase(expected_date2)
															|| date.equalsIgnoreCase(expected_date3)
															|| date.equalsIgnoreCase(expected_date4)) {
														test.log(LogStatus.PASS, "Displayed date: " + date
																+ "== Expected date" + expected_date);
													} else {
														test.log(LogStatus.FAIL, "Displayed date: " + date
																+ "Not equals to Expected date" + expected_date);
													}

													break;

												}

											}

										}
										Thread.sleep(3000);
									}
									// For Februry LAST DAY
									if (month_dispay == 1) {
										if (options.get(k).getText().equalsIgnoreCase("LAST")) {

											for (int j = 22; j <= 29; j++) {
												String dat = business_date1 + "/" + j + "/" + business_date3;
												//business_date1_int=Integer.parseInt(business_date1);
												Date d1 = df.parse(dat);
												int month = d1.getMonth();
												int year = Integer.parseInt(business_date3);

												Calendar c = Calendar.getInstance();
												c.setTime(d1);
												int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
												String day = String.valueOf(dayOfWeek);
												if (day.equalsIgnoreCase("1")) {
													day = "SUNDAY";
												}
												if (day.equalsIgnoreCase("2")) {
													day = "MONDAY";
												}
												if (day.equalsIgnoreCase("3")) {
													day = "TUESDAY";
												}
												if (day.equalsIgnoreCase("4")) {
													day = "WEDNESDAY";
												}
												if (day.equalsIgnoreCase("5")) {
													day = "THURSDAY";
												}
												if (day.equalsIgnoreCase("6")) {
													day = "FRIDAY";
												}
												if (day.equalsIgnoreCase("7")) {
													day = "SATURDAY";
												}

												

												if (day.equalsIgnoreCase(weekday)) {

													if (j <= business_date2_int) {

														// String month="fsd";
														// int
														// business_date3int=Integer.parseInt(business_date3);

														int dayOfMonth;
														if (month == 11) {
															now = LocalDate.of((year + 1), (1), j);// now();
																												// //2015-11-23
															firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
														} else {
													now = LocalDate.of(year, (month + 2), j);// now();
																												// //2015-11-23
															firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
														}

														String firstday_string = String.valueOf(firstday);
														String Expected[] = firstday_string.split("-");
														String Expected_year = Expected[0];
														String Expected_month = Expected[1];
														String Expected_date = Expected[2];
														int Expected_date_int = Integer.parseInt(Expected_date);
														Expected_date_int = Expected_date_int + 28;

														String expected_date = Expected_month + "/" + Expected_date_int
																+ "/" + Expected_year;
														String expected_date2 = "0" + Expected_month + "/"
																+ Expected_date_int + "/" + Expected_year;
														String expected_date3 = Expected_month + "/0"
																+ Expected_date_int + "/" + Expected_year;
														String expected_date4 = "0" + Expected_month + "/0"
																+ Expected_date_int + "/" + Expected_year;
														if (date.equalsIgnoreCase(expected_date)
																|| date.equalsIgnoreCase(expected_date2)
																|| date.equalsIgnoreCase(expected_date3)
																|| date.equalsIgnoreCase(expected_date4)) {
															test.log(LogStatus.PASS, "Displayed date: " + date
																	+ "== Expected date" + expected_date);
														} else {
															test.log(LogStatus.FAIL, "Displayed date: " + date
																	+ "Not equals to Expected date" + expected_date);
														}

														break;

													}

													if (j > business_date2_int) {
														String expected_date = (month + 1) + "/" + j + "/" + year;
														String expected_date2 = "0" + (month + 1) + "/" + j + "/"
																+ year;
														String expected_date3 = +(month + 1) + "/0" + j + "/" + year;
														String expected_date4 = "0" + (month + 1) + "/0" + j + "/"
																+ year;
														if (date.equalsIgnoreCase(expected_date)
																|| date.equalsIgnoreCase(expected_date2)
																|| date.equalsIgnoreCase(expected_date3)
																|| date.equalsIgnoreCase(expected_date4)) {
															test.log(LogStatus.PASS, "Displayed date: " + date
																	+ "== Expected date" + expected_date);
														} else {
															test.log(LogStatus.FAIL, "Displayed date: " + date
																	+ "Not equals to Expected date" + expected_date);
														}

														break;

													}

												}

											}
										}
									}
									// For Other months LAST DAY
									else {
										if (options.get(k).getText().equalsIgnoreCase("LAST")) {

											for (int j = 31; j >= 24; j--) {
												String dat = business_date1 + "/" + j + "/" + business_date3;
												Date d1 = df.parse(dat);
												int month = d1.getMonth();
												if(month==(business_date1_int))
												{
												 continue;	
												}
												int year = Integer.parseInt(business_date3);

												Calendar c = Calendar.getInstance();
												c.setTime(d1);
												int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
												String day = String.valueOf(dayOfWeek);
												if (day.equalsIgnoreCase("1")) {
													day = "SUNDAY";
												}
												if (day.equalsIgnoreCase("2")) {
													day = "MONDAY";
												}
												if (day.equalsIgnoreCase("3")) {
													day = "TUESDAY";
												}
												if (day.equalsIgnoreCase("4")) {
													day = "WEDNESDAY";
												}
												if (day.equalsIgnoreCase("5")) {
													day = "THURSDAY";
												}
												if (day.equalsIgnoreCase("6")) {
													day = "FRIDAY";
												}
												if (day.equalsIgnoreCase("7")) {
													day = "SATURDAY";
												}

												

												if (day.equalsIgnoreCase(weekday)) {

													if (j <= business_date2_int) {

														// String month="fsd";
														// int
														// business_date3int=Integer.parseInt(business_date3);

														int dayOfMonth;
														if (month == 11) {
													now = LocalDate.of((year + 1), (1), j);// now();
																												// //2015-11-23
															firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
														} else {
															now = LocalDate.of(year, (month + 1), j);// now();
																												// //2015-11-23
															firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));

															
														}

														String firstday_string = String.valueOf(firstday);
														String Expected[] = firstday_string.split("-");
														String Expected_year = Expected[0];
														String Expected_month = Expected[1];
														String Expected_date = Expected[2];
														int Expected_date_int = Integer.parseInt(Expected_date);
														Expected_date_int = Expected_date_int + 28;

														String expected_date = Expected_month + "/" + Expected_date_int
																+ "/" + Expected_year;
														if (date.equalsIgnoreCase(expected_date)) {
															test.log(LogStatus.PASS, "Displayed date: " + date
																	+ "== Expected date" + expected_date);
														} else {
															test.log(LogStatus.FAIL, "Displayed date: " + date
																	+ "Not equals to Expected date" + expected_date);
														}

														break;

													}

													if (j > business_date2_int) {
														
													/*	LocalDate now = LocalDate.of((year+1), (1), j);// now();
														// //2015-11-23
														firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
														
														String firstday_string = String.valueOf(firstday);
											
														String Expected[] = firstday_string.split("-");
														String Expected_year = Expected[0];
														String Expected_month = Expected[1];
														String Expected_date = Expected[2];
														int Expected_date_int = Integer.parseInt(Expected_date);
														LocalDate now = LocalDate.of((year), (month + 1), 31-);// now();
*/														
																												
														String expected_date = (month + 1) + "/" + j + "/" + year;
														String expected_date2 = "0" + (month + 1) + "/" + j + "/"
																+ year;
														String expected_date3 = +(month + 1) + "/0" + j + "/" + year;
														String expected_date4 = "0" + (month + 1) + "/0" + j + "/"
																+ year;
														if (date.equalsIgnoreCase(expected_date)
																|| date.equalsIgnoreCase(expected_date2)
																|| date.equalsIgnoreCase(expected_date3)
																|| date.equalsIgnoreCase(expected_date4)) {
															test.log(LogStatus.PASS, "Displayed date: " + date
																	+ "== Expected date" + expected_date);
														} else {
															test.log(LogStatus.FAIL, "Displayed date: " + date
																	+ "Not equals to Expected date" + expected_date);
														}

														break;

													}

												}

											}
										}
									}
									// Last week

								}

							}
							break;
						}
					}
				}

				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// test.log(LogStatus.FAIL, MarkupHelper.createLabel("Borrower
				// Registration is failed", ExtentColor.RED));
				test.log(LogStatus.INFO, "Exception occured " + e.toString().substring(0, 250));
				String screenshotPath = getScreenhot(driver, "Borrower");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.INFO,
						"Borrower Registration process is initiated again due to Application sync issue");
				driver.get(prop.getProperty("login_page"));
				continue;

			}

		}
		if (i == 3) {
			test.log(LogStatus.FAIL, "Borrower Registration is failed");
			Assert.assertTrue(false);

		}
	}
}

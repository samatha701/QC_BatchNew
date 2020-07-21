package tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import static java.time.temporal.TemporalAdjusters.firstInMonth;

import tests.QCStore;

public class Frequency_Monthly extends QCStore {

	public static void borrowerRegistration(String SSN, String AppURL) throws Exception {
		int i;
		for ( i = 0; i < 3; i++) {

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

						// For February
						if (Monthly_Type.equals("1")) {
							// For LastDay selection
							if (month_dispay == 1){

							{
								driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
								test.log(LogStatus.PASS, "Income_PayFrequency is entered: " + Income_PayFrequency);
								test.log(LogStatus.PASS, "Monthly type selected: " + Monthly_Type+"option");
								driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("Last Day");
								test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: v");
								Date d1 = df.parse(business_date);
								String lastdate = business_date;
								LocalDate convertedDate = LocalDate.parse(lastdate,
										DateTimeFormatter.ofPattern("M/d/yyyy"));
								convertedDate = convertedDate
										.withDayOfMonth(convertedDate.getMonth().length(convertedDate.isLeapYear()));
								String expected_date = String.valueOf(convertedDate);
								String expected_datenew[] = expected_date.split("-");
								String expect_date1 = expected_datenew[0];
								String expect_date2 = expected_datenew[1];
								String expect_date3 = expected_datenew[2];

								expected_date = expect_date2 + "/" + expect_date3 + "/" + expect_date1;

								String date1 = driver
										.findElement(By.xpath("//input[@name='NPMM' and @class='textBox20editablepp']"))
										.getAttribute("value");
								String date2 = driver
										.findElement(By.xpath("//input[@class='textBox20editablepp' and @name='NPDD']"))
										.getAttribute("value");
								String date3 = driver
										.findElement(
												By.xpath("//input[@class='textBox50editablepp' and @name='NPYYYY']"))
										.getAttribute("value");
								String date = date1 + "/" + date2 + "/" + date3;
								if (date.equalsIgnoreCase(expected_date) || date.equalsIgnoreCase(expected_date)
										|| date.equalsIgnoreCase(expected_date)
										|| date.equalsIgnoreCase(expected_date)) {
									test.log(LogStatus.PASS,
											"Displayed date: " + date + "== Expected date" + expected_date);
								} else {
									test.log(LogStatus.FAIL,
											"Displayed date: " + date + "Not equals to Expected date" + expected_date);
								}

							}

							driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
							test.log(LogStatus.PASS, "Income_PayFrequency is entered: " + Income_PayFrequency);
							int business_date2_int = Integer.parseInt(business_date2);

							for (int k = 1; k <= 28; k++) {
								String kstring = String.valueOf(k);
								test.log(LogStatus.PASS, "Monthly type selected: " + Monthly_Type+"option");
								driver.findElement(By.name("customerBean.monthlyDate")).sendKeys(kstring);
								test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: " + kstring);

								//int business_date1_int = Integer.parseInt(business_date1);
								//int business_date3_int = Integer.parseInt(business_date3);
								if (k <= business_date2_int) {
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
									String date = date1 + "/" + date2 + "/" + date3;
									String expected_date = business_date1_int + 1 + "/" + k + "/" + business_date3_int;
									String expected_date2 = "0" + (business_date1_int + 1) + "/" + "0" + k + "/"
											+ business_date3_int;
									String expected_date3 = (business_date1_int + 1) + "/" + "0" + k + "/"
											+ business_date3_int;
									String expected_date4 = "0" + (business_date1_int + 1) + "/" + k + "/"
											+ business_date3_int;
									if (date.equalsIgnoreCase(expected_date) || date.equalsIgnoreCase(expected_date2)
											|| date.equalsIgnoreCase(expected_date3)
											|| date.equalsIgnoreCase(expected_date4)) {
										test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
												+ (business_date1_int + 1) + "/" + k + "/" + business_date3);
									} else {
										test.log(LogStatus.FAIL,
												"Displayed date: " + date + "Not equals to Expected date"
														+ business_date1_int + 1 + "/" + k + "/" + business_date3);
									}
									Thread.sleep(3000);

								}

								else if (k > business_date2_int) {
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
									String date = date1 + "/" + date2 + "/" + date3;

									String expected_date = business_date1_int + "/" + k + "/" + business_date3_int;
									String expected_date2 = "0" + (business_date1_int) + "/" + "0" + k + "/"
											+ business_date3_int;
									String expected_date3 = (business_date1_int) + "/" + "0" + k + "/"
											+ business_date3_int;
									String expected_date4 = "0" + (business_date1_int) + "/" + k + "/"
											+ business_date3_int;

									Date d1 = df.parse(expected_date);
									int date2_int = Integer.parseInt(date2);

									d1.setDate(date2_int);

									SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
									sdfrmt.setLenient(false);

									Calendar cal1 = Calendar.getInstance();
									cal1.setTime(d1);

									try {
										Date javaDate = sdfrmt.parse(expected_date);
										// System.out.println(expected_date+" is
										// valid date format");
										if (date.equalsIgnoreCase(expected_date)
												|| date.equalsIgnoreCase(expected_date2)
												|| date.equalsIgnoreCase(expected_date3)
												|| date.equalsIgnoreCase(expected_date4)) {
											test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
													+ business_date1_int + "/" + k + "/" + business_date3);
										} else {
											test.log(LogStatus.FAIL,
													"Displayed date: " + date + "Not equals to Expected date"
															+ business_date1_int + "/" + k + "/" + business_date3);
										}
									}
									/* Date format is invalid */
									catch (ParseException e) {
										// System.out.println(expected_date+" is
										// Invalid Date format");

										if (date.equalsIgnoreCase(expected_date)
												|| date.equalsIgnoreCase(expected_date2)
												|| date.equalsIgnoreCase(expected_date3)
												|| date.equalsIgnoreCase(expected_date4)) {
											test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
													+ (business_date1_int + 1) + "/" + 1 + "/" + business_date3);
										} else {
											test.log(LogStatus.FAIL,
													"Displayed date: " + date + "Not equals to Expected date"
															+ (business_date1_int + 1) + "/" + 1 + "/"
															+ business_date3);
										}

									}

									int day_display1 = d1.getDay();

									Thread.sleep(3000);
								}

							}
							SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
							sdfrmt.setLenient(false);
							String leap = business_date1 + "/" + 29 + "/" + business_date3;
							// For leap year
							try {
								Date javaDate = sdfrmt.parse(leap);
								{
									test.log(LogStatus.PASS, "Monthly type selected: " + Monthly_Type+"option");
									driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("29");
									test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: " + 29);
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
									String date = date1 + "/" + date2 + "/" + date3;
									String expected_date = 02 + "/" + 29 + "/" + business_date3;
									String expected_date2 = 02 + "/" + 29 + "/" + business_date3;
									String expected_date3 = 02 + "/" + 29 + "/" + business_date3;
									String expected_date4 = 02 + "/" + 29 + "/" + business_date3;
									if (date.equalsIgnoreCase(expected_date)
											|| date.equalsIgnoreCase(expected_date2)
											|| date.equalsIgnoreCase(expected_date3)
											|| date.equalsIgnoreCase(expected_date4)) {
										test.log(LogStatus.PASS,
												"Displayed date: " + date + "== Expected date" + expected_date);
									} else {
										test.log(LogStatus.FAIL, "Displayed date: " + date
												+ "Not equals to Expected date" + expected_date);
									}
								}
								{
									test.log(LogStatus.PASS, "Monthly type selected: " + Monthly_Type+"option");
									driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("30");
									test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: " + 30);
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
									String date = date1 + "/" + date2 + "/" + date3;
									String expected_date = 03 + "/" + 01 + "/" + business_date3;
									if (date.equalsIgnoreCase(expected_date)) {
										test.log(LogStatus.PASS,
												"Displayed date: " + date + "== Expected date" + expected_date);
									} else {
										test.log(LogStatus.FAIL, "Displayed date: " + date
												+ "Not equals to Expected date" + expected_date);
									}
								}
								{
									test.log(LogStatus.PASS, "Monthly type selected: " + Monthly_Type);
									driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("31");
									test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: " + 31);
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
									String date = date1 + "/" + date2 + "/" + date3;
									String expected_date = 03 + "/" + 02 + "/" + business_date3;
									String expected_date2 = 3 + "/" + 2 + "/" + business_date3;
									String expected_date3 = 3 + "/" + 02 + "/" + business_date3;
									String expected_date4 = 03 + "/" + 2 + "/" + business_date3;
									if (date.equalsIgnoreCase(expected_date)
											|| date.equalsIgnoreCase(expected_date2)
											|| date.equalsIgnoreCase(expected_date3)
											|| date.equalsIgnoreCase(expected_date4)) {
										test.log(LogStatus.PASS,
												"Displayed date: " + date + "== Expected date" + expected_date);
									} else {
										test.log(LogStatus.FAIL, "Displayed date: " + date
												+ "Not equals to Expected date" + expected_date);
									}

								}

							}
							// For non leap year
							catch (Exception e) {

								{
									test.log(LogStatus.PASS, "Monthly type selected: " + Monthly_Type+"option");
									driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("29");
									test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: " + 29);
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
									String date = date1 + "/" + date2 + "/" + date3;
									String expected_date = 03 + "/" + 01 + "/" + business_date3;
									if (date.equalsIgnoreCase(expected_date)) {
										test.log(LogStatus.PASS,
												"Displayed date: " + date + "== Expected date" + expected_date);
									} else {
										test.log(LogStatus.FAIL, "Displayed date: " + date
												+ "Not equals to Expected date" + expected_date);
									}
								}
								{
									test.log(LogStatus.PASS, "Monthly type selected: " + Monthly_Type);
									driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("30");
									test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: " + 30);
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
									String date = date1 + "/" + date2 + "/" + date3;
									String expected_date = 03 + "/" + 02 + "/" + business_date3;
									String expected_date2 = 3 + "/" + 2 + "/" + business_date3;
									String expected_date3 = 3 + "/" + 02 + "/" + business_date3;
									String expected_date4 = 03 + "/" + 2 + "/" + business_date3;
									if (date.equalsIgnoreCase(expected_date)
											|| date.equalsIgnoreCase(expected_date2)
											|| date.equalsIgnoreCase(expected_date3)
											|| date.equalsIgnoreCase(expected_date4)) {
										test.log(LogStatus.PASS,
												"Displayed date: " + date + "== Expected date" + expected_date);
									} else {
										test.log(LogStatus.FAIL, "Displayed date: " + date
												+ "Not equals to Expected date" + expected_date);
									}
								}
								{
									test.log(LogStatus.PASS, "Monthly type selected: " + Monthly_Type+"option");
									driver.findElement(By.name("customerBean.monthlyDate")).sendKeys("31");
									test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: " + 31);
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
									String date = date1 + "/" + date2 + "/" + date3;
									String expected_date = 03 + "/" + 03 + "/" + business_date3;
									String expected_date2 = 3 + "/" + 3 + "/" + business_date3;
									String expected_date3 = 3 + "/" + 03 + "/" + business_date3;
									String expected_date4 = 03 + "/" + 3 + "/" + business_date3;
									if (date.equalsIgnoreCase(expected_date)
											|| date.equalsIgnoreCase(expected_date2)
											|| date.equalsIgnoreCase(expected_date3)
											|| date.equalsIgnoreCase(expected_date4)) {
										test.log(LogStatus.PASS,
												"Displayed date: " + date + "== Expected date" + expected_date);
									} else {
										test.log(LogStatus.FAIL, "Displayed date: " + date
												+ "Not equals to Expected date" + expected_date);
									}

								}

							}

						}
						}
						// For December
						if (Monthly_Type.equals("1")) {
							if (month_dispay == 11) {

								driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
								test.log(LogStatus.PASS, "Income_PayFrequency is entered: " + Income_PayFrequency);
								int business_date2_int = Integer.parseInt(business_date2);

								if (Monthly_Type.equals("1")) {
									for (int k = 1; k <= 31; k++) {
										String kstring = String.valueOf(k);
										test.log(LogStatus.PASS, "Monthly type selected: " + Monthly_Type+"option");
										driver.findElement(By.name("customerBean.monthlyDate")).sendKeys(kstring);
										test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: " + kstring);

										//int business_date1_int = Integer.parseInt(business_date1);
										//int business_date3_int = Integer.parseInt(business_date3);
										if (k <= business_date2_int) {
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
											String date = date1 + "/" + date2 + "/" + date3;
											String expected_date = "01" + "/" + k + "/" + (business_date3_int + 1);
											String expected_date2 = "01" + "/" + "0" + k + "/"
													+ (business_date3_int + 1);
											String expected_date3 = "01" + "/" + "0" + k + "/"
													+ (business_date3_int + 1);
											String expected_date4 = "01" + "/" + k + "/" + (business_date3_int + 1);
											if (date.equalsIgnoreCase(expected_date)
													|| date.equalsIgnoreCase(expected_date2)
													|| date.equalsIgnoreCase(expected_date3)
													|| date.equalsIgnoreCase(expected_date4)) {
												test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
														+ 01 + "/" + k + "/" + (business_date3_int + 1));
											} else {
												test.log(LogStatus.FAIL,
														"Displayed date: " + date + "Not equals to Expected date" + 01
																+ "/" + k + "/" + (business_date3_int + 1));
											}
											Thread.sleep(3000);

										}

										else if (k > business_date2_int) {
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
											String date = date1 + "/" + date2 + "/" + date3;

											String expected_date = business_date1_int + "/" + k + "/"
													+ business_date3_int;
											String expected_date2 = "0" + (business_date1_int) + "/" + "0" + k + "/"
													+ business_date3_int;
											String expected_date3 = (business_date1_int) + "/" + "0" + k + "/"
													+ business_date3_int;
											String expected_date4 = "0" + (business_date1_int) + "/" + k + "/"
													+ business_date3_int;

											Date d1 = df.parse(expected_date);
											int date2_int = Integer.parseInt(date2);

											d1.setDate(date2_int);

											SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
											sdfrmt.setLenient(false);

											Calendar cal1 = Calendar.getInstance();
											cal1.setTime(d1);

											try {
												Date javaDate = sdfrmt.parse(expected_date);
												// System.out.println(expected_date+"
												// is valid date format");
												if (date.equalsIgnoreCase(expected_date)
														|| date.equalsIgnoreCase(expected_date2)
														|| date.equalsIgnoreCase(expected_date3)
														|| date.equalsIgnoreCase(expected_date4)) {
													test.log(LogStatus.PASS,
															"Displayed date: " + date + "== Expected date"
																	+ business_date1_int + "/" + k + "/"
																	+ business_date3);
												} else {
													test.log(LogStatus.FAIL,
															"Displayed date: " + date + "Not equals to Expected date"
																	+ business_date1_int + "/" + k + "/"
																	+ business_date3);
												}
											}
											/* Date format is invalid */
											catch (ParseException e) {
												// System.out.println(expected_date+"
												// is Invalid Date format");

												if (date.equalsIgnoreCase(expected_date)
														|| date.equalsIgnoreCase(expected_date2)
														|| date.equalsIgnoreCase(expected_date3)
														|| date.equalsIgnoreCase(expected_date4)) {
													test.log(LogStatus.PASS,
															"Displayed date: " + date + "== Expected date"
																	+ (business_date1_int + 1) + "/" + 1 + "/"
																	+ business_date3);
												} else {
													test.log(LogStatus.FAIL,
															"Displayed date: " + date + "Not equals to Expected date"
																	+ (business_date1_int + 1) + "/" + 1 + "/"
																	+ business_date3);
												}

											}

											int day_display1 = d1.getDay();

											Thread.sleep(3000);
										}

										/*
										 * Date d1 = df.parse(date); Calendar
										 * cal1 = Calendar.getInstance();
										 * cal1.setTime(d1); int day_display1=
										 * d1.getDay();
										 */

									}
								} 

							}
						}

						// For other months
						if (Monthly_Type.equals("1")) {
							if (!(month_dispay == 1) && !(month_dispay == 11)) {
								driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
								test.log(LogStatus.PASS, "Income_PayFrequency is entered: " + Income_PayFrequency);
								int business_date2_int = Integer.parseInt(business_date2);

								if (Monthly_Type.equals("1")) {
									for (int k = 1; k <= 31; k++) {
										String kstring = String.valueOf(k);
										test.log(LogStatus.PASS, "Monthly type selected: " + Monthly_Type+"option");
										driver.findElement(By.name("customerBean.monthlyDate")).sendKeys(kstring);
										test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: " + kstring);

										//int business_date1_int = Integer.parseInt(business_date1);
										//int business_date3_int = Integer.parseInt(business_date3);
										if (k <= business_date2_int) {
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
											String date = date1 + "/" + date2 + "/" + date3;
											String expected_date = business_date1_int + 1 + "/" + k + "/"
													+ business_date3_int;
											String expected_date2 = "0" + (business_date1_int + 1) + "/0" + k + "/"
													+ business_date3_int;
											String expected_date3 = (business_date1_int + 1) + "/" + "0" + k + "/"
													+ business_date3_int;
											String expected_date4 = "0" + (business_date1_int + 1) + "/" + k + "/"
													+ business_date3_int;
											if (date.equalsIgnoreCase(expected_date)
													|| date.equalsIgnoreCase(expected_date2)
													|| date.equalsIgnoreCase(expected_date3)
													|| date.equalsIgnoreCase(expected_date4)) {
												test.log(LogStatus.PASS, "Displayed date: " + date + "== Expected date"
														+ (business_date1_int + 1) + "/" + k + "/" + business_date3);
											} else {
												test.log(LogStatus.FAIL,
														"Displayed date: " + date + "Not equals to Expected date"
																+ business_date1_int + 1 + "/" + k + "/"
																+ business_date3);
											}
											Thread.sleep(3000);

										}

										else if (k > business_date2_int) {
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
											String date = date1 + "/" + date2 + "/" + date3;

											String expected_date = business_date1_int + "/" + k + "/"
													+ business_date3_int;
											String expected_date2 = "0" + (business_date1_int) + "/" + "0" + k + "/"
													+ business_date3_int;
											String expected_date3 = (business_date1_int) + "/" + "0" + k + "/"
													+ business_date3_int;
											String expected_date4 = "0" + (business_date1_int) + "/" + k + "/"
													+ business_date3_int;

											Date d1 = df.parse(expected_date);
											int date2_int = Integer.parseInt(date2);

											d1.setDate(date2_int);

											SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
											sdfrmt.setLenient(false);

											Calendar cal1 = Calendar.getInstance();
											cal1.setTime(d1);

											try {
												Date javaDate = sdfrmt.parse(expected_date);
												// System.out.println(expected_date+"
												// is valid date format");
												if (date.equalsIgnoreCase(expected_date)
														|| date.equalsIgnoreCase(expected_date2)
														|| date.equalsIgnoreCase(expected_date3)
														|| date.equalsIgnoreCase(expected_date4)) {
													test.log(LogStatus.PASS,
															"Displayed date: " + date + "== Expected date"
																	+ business_date1_int + "/" + k + "/"
																	+ business_date3);
												} else {
													test.log(LogStatus.FAIL,
															"Displayed date: " + date + "Not equals to Expected date"
																	+ business_date1_int + "/" + k + "/"
																	+ business_date3);
												}
											}
											/* Date format is invalid */
											catch (ParseException e) {
												// System.out.println(expected_date+"
												// is Invalid Date format");
												expected_date=(business_date1_int + 1) + "/" + 1 + "/"
														+ business_date3;
												expected_date2="0" +(business_date1_int + 1) + "/" + 1 + "/"
														+ business_date3;
												expected_date3=(business_date1_int + 1) + "/" + 1 + "/0"
														+ business_date3;
												expected_date4="0" +(business_date1_int + 1) + "/" + 1 + "/0"
														+ business_date3;
												if (date.equalsIgnoreCase(expected_date)
														|| date.equalsIgnoreCase(expected_date2)
														|| date.equalsIgnoreCase(expected_date3)
														|| date.equalsIgnoreCase(expected_date4)) {
													test.log(LogStatus.PASS,
															"Displayed date: " + date + "== Expected date"
																	+ (business_date1_int + 1) + "/" + 1 + "/"
																	+ business_date3);
												} else {
													test.log(LogStatus.FAIL,
															"Displayed date: " + date + "Not equals to Expected date"
																	+ (business_date1_int + 1) + "/" + 1 + "/"
																	+ business_date3);
												}

											}

											int day_display1 = d1.getDay();

											Thread.sleep(3000);
										}

										/*
										 * Date d1 = df.parse(date); Calendar
										 * cal1 = Calendar.getInstance();
										 * cal1.setTime(d1); int day_display1=
										 * d1.getDay();
										 */

									}
								}

							}
						}

						else if (Monthly_Type.equals("2")) {
							driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
							test.log(LogStatus.PASS, "Income_PayFrequency is entered: " + Income_PayFrequency);

							test.log(LogStatus.PASS, "Monthly type selected: " + Monthly_Type+"option");
							driver.findElement(By.id("rad_monthly2")).click();
							test.log(LogStatus.PASS, "Clicked on monthly type: " + Monthly_Type);

							Select dropdown = new Select(driver.findElement(By.name("customerBean.monthlyWeek")));

							List<WebElement> options = dropdown.getOptions();
							Select dropdown2 = new Select(driver.findElement(By.name("customerBean.monthlyDay")));

							List<WebElement> options2 = dropdown2.getOptions();

							for (int k = 1; k <= 5; k++) {
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
									String date = date1 + "/" + date2 + "/" + date3;

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

											int business_date2_int = Integer.parseInt(business_date2);

											if (day.equalsIgnoreCase(weekday)) {

												if (j <= business_date2_int) {

													// String month="fsd";
													// int
													// business_date3int=Integer.parseInt(business_date3);

													int dayOfMonth;

													if (month == 11) {
														LocalDate now = LocalDate.of((year + 1), (1), j);// now();
																											// //2015-11-23
														firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
													} else {
														LocalDate now = LocalDate.of(year, (month + 2), j);// now();
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

											int business_date2_int = Integer.parseInt(business_date2);

											if (day.equalsIgnoreCase(weekday)) {

												if (j <= business_date2_int) {

													// String month="fsd";
													// int
													// business_date3int=Integer.parseInt(business_date3);

													int dayOfMonth;
													if (month == 11) {
														LocalDate now = LocalDate.of((year + 1), (1), j);// now();
																											// //2015-11-23
														firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));

													} else {
														LocalDate now = LocalDate.of(year, (month + 2), j);// now();
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

											int business_date2_int = Integer.parseInt(business_date2);

											if (day.equalsIgnoreCase(weekday)) {

												if (j <= business_date2_int) {

													// String month="fsd";
													// int
													// business_date3int=Integer.parseInt(business_date3);

													int dayOfMonth;
													if (month == 11) {
														LocalDate now = LocalDate.of((year + 1), (1), j);// now();
																											// //2015-11-23
														firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
													} else {
														LocalDate now = LocalDate.of(year, (month + 2), j);// now();
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

											int business_date2_int = Integer.parseInt(business_date2);

											if (day.equalsIgnoreCase(weekday)) {

												if (j <= business_date2_int) {

													// String month="fsd";
													// int
													// business_date3int=Integer.parseInt(business_date3);

													if (month == 11) {
														LocalDate now = LocalDate.of((year + 1), (1), j);// now();
																											// //2015-11-23
														firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
													} else {
														LocalDate now = LocalDate.of(year, (month + 2), j);// now();
																											// //2015-11-23
														firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
														
													}
													String firstday_string = String.valueOf(firstday);
													String Expected[] = firstday_string.split("-");
													String Expected_year = Expected[0];
													String Expected_month = Expected[1];
													String Expected_date = Expected[2];
													/*int Expected_date_int = Integer.parseInt(Expected_date);
													Expected_date_int = Expected_date_int + 21;*/
													

													String expected_date = Expected_month + "/" + Expected_date
															+ "/" + Expected_year;
													
													
													DateFormat df3=new SimpleDateFormat("MM/dd/yyyy");
													Date ExDate = df3.parse(expected_date);

													Calendar cal3 = Calendar.getInstance();

													cal3.setTime(ExDate);

													cal3.add(Calendar.DATE, 21);
												

													Date DDueDate1= cal3.getTime();

													String ExDateStr =df.format(DDueDate1);

												/*	String expected_date = Expected_month + "/" + Expected_date_int
															+ "/" + Expected_year;
													String expected_date2 = "0" + Expected_month + "/"
															+ Expected_date_int + "/" + Expected_year;
													String expected_date3 = Expected_month + "/0" + Expected_date_int
															+ "/" + Expected_year;
													String expected_date4 = "0" + Expected_month + "/0"
															+ Expected_date_int + "/" + Expected_year;*/
													if (date.equalsIgnoreCase(ExDateStr)
												) {
														test.log(LogStatus.PASS, "Displayed date: " + date
																+ "== Expected date" + ExDateStr);
													} else {
														test.log(LogStatus.FAIL, "Displayed date: " + date
																+ "Not equals to Expected date" + ExDateStr);
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

												int business_date2_int = Integer.parseInt(business_date2);

												if (day.equalsIgnoreCase(weekday)) {

													if (j <= business_date2_int) {

														// String month="fsd";
														// int
														// business_date3int=Integer.parseInt(business_date3);

														int dayOfMonth;
														if (month == 11) {
															LocalDate now = LocalDate.of((year + 1), (1), j);// now();
																												// //2015-11-23
															firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
														} else {
															LocalDate now = LocalDate.of(year, (month + 2), j);// now();
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

												int business_date2_int = Integer.parseInt(business_date2);

												if (day.equalsIgnoreCase(weekday)) {

													if (j <= business_date2_int) {

														// String month="fsd";
														// int
														// business_date3int=Integer.parseInt(business_date3);

														int dayOfMonth;
														if (month == 11) {
															LocalDate now = LocalDate.of((year + 1), (1), j);// now();
																												// //2015-11-23
															firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));
														} else {
															LocalDate now = LocalDate.of(year, (month + 1), j);// now();
																												// //2015-11-23
															firstday = now.with(firstInMonth(DayOfWeek.valueOf(day)));

															
														}

														String firstday_string = String.valueOf(firstday);
														String Expected[] = firstday_string.split("-");
														String Expected_year = Expected[0];
														String Expected_month = Expected[1];
														String Expected_date = Expected[2];
														/*int Expected_date_int = Integer.parseInt(Expected_date);
														Expected_date_int = Expected_date_int + 28;*/
//EDITED THE CODE FOR LAST MONTH
														String expected_date = Expected_month + "/" + Expected_date
																+ "/" + Expected_year;
														
														
														DateFormat df4=new SimpleDateFormat("MM/dd/yyyy");
														Date ExDate = df4.parse(expected_date);

														Calendar cal4 = Calendar.getInstance();

														cal4.setTime(ExDate);

														cal4.add(Calendar.DATE, 28);
													

														Date DDueDate1= cal4.getTime();

														String ExDateStr =df.format(DDueDate1);

														/*String DueDate0[] =DueDate.split("/");

														String DueDate1 = DueDate0[0];

														String DueDate2 = DueDate0[1];

														String DueDate3 = DueDate0[2];*/
														
														
														
														if (date.equalsIgnoreCase(ExDateStr)) {
															test.log(LogStatus.PASS, "Displayed date: " + date
																	+ "== Expected date" + ExDateStr);
														} else {
															test.log(LogStatus.FAIL, "Displayed date: " + date
																	+ "Not equals to Expected date" + ExDateStr);
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

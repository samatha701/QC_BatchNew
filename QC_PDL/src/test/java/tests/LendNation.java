package tests;

import org.testng.annotations.Test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;

/*import Pages.LendNationCSR;
import Pages.LendNationFinancialInformation;
import Pages.LendNationLogin;
import Pages.LendNationPersonalInformation;
import Pages.LendNationRegistration;
import Pages.LendNationRepaymentInformation;
import Pages.LendNationSignContract;
import Pages.LendNationSubmitApplication;*/
//import Utilities.ExtentReports.Excel;
//import Utilities.ExtentReports.Excel;

import tests.LendNationRegistration;




import tests.ExcelNew;

public class LendNation {
	
	public static WebDriverWait wait;	
	public static WebDriver driver;		
	String appUrl;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	//static ExtentReports reports;
	public static ExtentTest test;
	public static Properties prop;
	public static String loan_number;
	
	
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	//ExtentTest logger;
	
	
	
	
	//Extent 3.0.3 logging
	//ExtentHtmlReporter htmlReporter;
	//ExtentReports extent;
	//ExtentTest logger;

	
  @Test(priority=0)
  public static void LendNation() throws Exception {
	  
	  
	  String FileName= prop.getProperty("file_name");
		ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  
	  //test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");
	  //test.log(Status.INFO, "Registration of Lend Nation has started ");
	  test.log(Status.INFO, MarkupHelper.createLabel("Registration of Lend Nation has started", ExtentColor.BLUE));
	  
	  //String FileName= "Registration_Lend_Nation.xls";
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
		int lastrow=TestData.getLastRow("Start");
		String sheetName="Start";
		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			
			
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
		if(RunFlag.equals("Y"))
		{	
			//driver.get(appUrl);
			//test.log(Status.INFO, "Application is launched");
			//driver.manage().window().maximize();
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				System.out.println(AppURL);
				//LendNationLogin.login();
				
				System.out.println(loan_number);
				
				LendNationRegistration.registration(SSN, AppURL);
				LendNationPersonalInformation.personalInformation(SSN, AppURL);
			   LendNationFinancialInformation.financialInformation(SSN, AppURL);
			  LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);
			LendNationSubmitApplication.submitApplication(SSN, AppURL);
			 LendNationSignContract.signContract(SSN, AppURL);
			LendNationCSR.lendNationCSR(SSN, AppURL, loan_number);
				
				break;
				
  }
  }
  }
  
 
  @BeforeClass
  public void setup() throws IOException {	
		
		String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
		//Date D = new Date();		
		String filename="LendNation_"+timestamp+".html";
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/IEDriverServer.exe");

		//driver = new InternetExplorerDriver();	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5000);	
		
		//prop=prop.getProperty("user.dir")+"/Tests/Objects.properties";
		BufferedReader reader;
		String propertyFilePath=("user.dir")+"/Objects.properties";
		
		//InputStream input = new FileInputStream("D:/QC_Workspace/AA_Automation/src/Tests/Objects.properties");
		//prop.load(input);
		//System.out.println(prop.getProperty("LendNation_URL"));
		
		try {
			//reader = new BufferedReader(new FileReader("D:/QC_Workspace/AA_Automation/src/Tests/Objects.properties"));
			reader = new BufferedReader(new FileReader("D:/QC_Workspace/QC/src/test/java/tests/Objects.properties"));

			prop = new Properties();
						try {
							prop.load(reader);
							reader.close();
						} 
						catch (IOException e) {
							e.printStackTrace();
							}
		  }
			catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
			}
		//reports = new ExtentReports(System.getProperty("user.dir") +prop.getProperty("extent_report_path")+filename, true);
		
		//Extent reports added code
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +prop.getProperty("extent_report_path")+filename);
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "QTLSYS2-238");
		extent.setSystemInfo("Java Version", "1.8.0_171");
		extent.setSystemInfo("Environment", "Windows 7");


		extent.setSystemInfo("User Name", "Brahmith P");
		extent.config();
		
		htmlReporter.config().setDocumentTitle("Lend Nation Smoke_Testing");
		htmlReporter.config().setReportName("Lend Nation Online");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		test = extent.createTest("Lend Nation");
		
		
		
		

		}
		
  
	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 //TakesScreenshot ts = (TakesScreenshot) driver;
		 //File source = ts.getScreenshotAs(OutputType.FILE);	
		 
		 File source = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);		 
		                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		 String destination = System.getProperty("user.dir") +prop.getProperty("failed_screenshot_path")+screenshotName+dateName+".png";
		 File finalDestination = new File(destination);
		 FileUtils.copyFile(source, finalDestination);
		 return destination;
		 }
	//@BeforeMethod
	 public void killProcess() throws Exception{
	 
           try{
    
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe"); 

        Thread.sleep(5000); //Allow OS to kill the process
        System.out.println("killed the process");
        //break;
        
     }
	 catch(Exception e)
        {
		//break;
		// continue;
        }   
	    }
	 @AfterMethod
	 public void getResult(ITestResult result) throws Exception{
	 if(result.getStatus() == ITestResult.FAILURE){
		 test.log(Status.FAIL, "Test Case Failed is "+result.getName());
		 test.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
	 //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
	                        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 
	                        //String screenshotPath = getScreenhot(driver, result.getName());
	 //To add it in the extent report 
	                        
 //Commented this
 //test.log(Status.FAIL, test.addScreenCaptureFromPath(screenshotPath));
	 }else if(result.getStatus() == ITestResult.SKIP){
		 test.log(Status.SKIP, "Test Case Skipped is "+result.getName());
	 }else if(result.getStatus() == ITestResult.SUCCESS){
		 test.log(Status.PASS, result.getName()+" Test Case is Passed");}
	// reports.endTest(test);
    // reports.flush();
    // extent.flush();

 	 }			
	 @AfterTest
	 
	 public void endReport(){
	 
		// reports.endTest(test);
	     //reports.flush();
	                
	                extent.flush();
	                //driver.quit();
	         
	               
	    }
	 
	 public static By locator(String obj)
		{
			
			String loctype=null;
			String locname=null;
			 By locator=null;
			 String[] locobj=obj.split("%%"); 
			 loctype=locobj[0];
			 locname=locobj[1];
			// System.out.println("startign of switch case");
			// System.out.println(obj);
			 /*switch(loctype)
			 {
			 case "id": 
				 locator=By.id(locname);
				break;
			 case "name": 
				 locator=By.name(locname);
				break;
			 case "linkText": 
				 locator=By.linkText(locname);
				break;
			 case "xpath": 
				 locator=By.xpath(locname);
				break;
			 }*/
			 
			 if(loctype.equalsIgnoreCase("id"))
				 return locator=By.id(locname);
			 else if(loctype.equalsIgnoreCase("name"))
				 return locator=By.name(locname);
			 else if(loctype.equalsIgnoreCase("linkText"))
				 return locator=By.linkText(locname);
			 else if(loctype.equalsIgnoreCase("xpath"))
				 return locator=By.xpath(locname);
			return locator;
			 
			 
			 
			 
			 
			 
			// System.out.println(locator);
			// return locator;
			
			
			 }
			
}

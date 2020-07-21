
package tests;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import oracle.jdbc.OracleTypes;
//import tests.QCStore;


public class AgeStore_DB extends LendNation {
	
//public static ExtentTest test;
public static String db_BoCode;
public static String App_BoCode;
public static String st_date;
//public static String Proc_Date;



	public static void accounting(String SSN,String AppURL) throws ClassNotFoundException, SQLException
 
	{
				
		// Object of Connection from the Database
				Connection conn = null;
				
		// Object of Statement. It is used to create a Statement to execute the query
			    Statement stmt = null;
			    
	    // Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
				ResultSet resultSet = null;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				test.log(LogStatus.INFO,"Connecting to DB and AgeStore has started");
				test.log(LogStatus.INFO, "******************************************************");
	    // Open a connection
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QCREL2_AUTOM_07212019", "QCREL2_AUTOM_07212019");
				
				System.out.println("Connecting to DB");
				test.log(LogStatus.PASS, "Connecting to DB Successfully");
				//System.out.println();
			
				stmt = conn.createStatement();
				      //Proc_Date="02-AUG-19";
				resultSet = stmt.executeQuery("update ca_ss_store_date set st_date= '"+Proc_Date+"' where ST_DATE_ID='PRO' and st_code in (2997,2029,99999)");
				                               
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> After Age the Store the Date is  :" +Proc_Date);
				while (resultSet .next()) 
				
				
				
				
		// Closing Connection		
				
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (Exception e) {
					}
				}
				
				if (stmt != null) {
					try {
						stmt.close();
					} catch (Exception e) {
					}
				}
				
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
					}
				}
			}

	public static void accounting_Duedate(String SSN,String AppURL) throws ClassNotFoundException, SQLException
	 
	{
	
		// TODO Auto-generated method stub
		
		// Object of Connection from the Database
				Connection conn = null;
				
		// Object of Statement. It is used to create a Statement to execute the query
			    Statement stmt = null;
			    
	    // Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
				ResultSet resultSet = null;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				test.log(LogStatus.INFO,"Connecting to DB and Fetching Data From Data base has started");
				test.log(LogStatus.INFO, "******************************************************");
	    // Open a connection
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_09232019", "QC_AUTOM_09232019");
				
				System.out.println("Connecting to DB");
				test.log(LogStatus.PASS, "Connecting to DB Successfully");
				//System.out.println();
			
				stmt = conn.createStatement();
				      //Proc_Date="28-JUL-19";
				resultSet = stmt.executeQuery("update ca_ss_store_date set st_date= '"+App_Due_Date+"' where ST_DATE_ID='PRO' and st_code in (2997,2029,99999)");
				
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> After Aging the Store to DueDate the Date is  :" +App_Due_Date);
				while (resultSet .next()) 
				
				
				
				
		// Closing Connection		
				
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (Exception e) {
					}
				}
				
				if (stmt != null) {
					try {
						stmt.close();
					} catch (Exception e) {
					}
				}
				
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
					}
				}
			}
	
	
}
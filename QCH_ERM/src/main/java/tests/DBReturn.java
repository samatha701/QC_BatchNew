package tests;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import oracle.jdbc.OracleTypes;

public class DBReturn extends QCStore{

	public static void proc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;
		Statement stmt2 = null;
		

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		//System.out.println("before conn");
		// Open a connection
		try {

			//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", prop.getProperty("db_username"),prop.getProperty("db_username"));
			
			//*********Pre-Prod Connection***********\\
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019","QCautoMDEC216");
			test.log(LogStatus.PASS, "Connecting to DB ");
			
			//*********Regression Connection**********\\
			
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_NOV2619","QCautoM261");
			//test.log(LogStatus.PASS, "Connecting to DB ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		stmt2 = conn.createStatement();
		
		//NextDueDate="11/20/19";
		test.log(LogStatus.PASS, "Current store date is "+NextDueDate);
		 String Due_Date[] =NextDueDate.split("/");
	     String Due_Date1 = Due_Date[0];
	     String Due_Date2 = Due_Date[1];
	     String Due_Date3 = Due_Date[2];
	     String DBdate=Due_Date2+"-"+Due_Date1+"-"+Due_Date3;
	     System.out.println(DBdate);
	     test.log(LogStatus.PASS, "Current store date format changed to DB SCHEDULE_DATE "+DBdate);
	     //loan_nbr="11036726";
		String schedule_id="1220";
		try {
			resultSet=stmt.executeQuery("select cc_info_key from repay_deposit_schedule where installment_nbr=1 and loan_code="+loan_nbr);
			String key = "";
			if(resultSet.next()){	
			 key=resultSet.getString("cc_info_key");
			}
			stmt.executeQuery("update REPAY_DEPOSIT_SCHEDULE set CC_info_key='123456789126' where SCHEDULE_DATE='"+DBdate+"' and loan_code="+loan_nbr);
			test.log(LogStatus.PASS, "Executing the query with loan number"+loan_nbr);
			test.log(LogStatus.PASS, "Updating the CC_info_key to 123456789126");
			
			stmt.executeQuery("update SCHEDULE_ATTR set IS_PROCESSED='NOP' where SCHEDULE_ID="+schedule_id);
			test.log(LogStatus.PASS, "Updating the Is_Processed to NOP");
			
	Thread.sleep(40000);					
					
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
		catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
			
		
		}

	}



//*****************------------------------------------------------**************************************\\



public static void redepositDC(String SSN) throws ClassNotFoundException, SQLException {
	Connection conn = null;

	// Object of Statement. It is used to create a Statement to execute the
	// query
	Statement stmt = null;
	Statement stmt2 = null;
	

	// Object of ResultSet => 'It maintains a cursor that points to the
	// current row in the result set'
	ResultSet resultSet = null;
	List<String> rowValues = new ArrayList();

	Class.forName("oracle.jdbc.driver.OracleDriver");
	int lastrow=TestData.getLastRow("Deposit");
	String sheetName="Deposit";

	for(int row=2;row<=lastrow+1;row++)
	{		
		String RegSSN = TestData.getCellData(sheetName,"SSN",row);
		if(SSN.equals(RegSSN))
		{
			String Insta = TestData.getCellData(sheetName,"Insta",row);

			String SSN1 = SSN.substring(0, 3);
			String SSN2 = SSN.substring(3,5);
			String SSN3 = SSN.substring(5,9);		       


			test.log(LogStatus.INFO, "DC Redeposit Qurrey has initiated");
	//System.out.println("before conn");
	// Open a connection
	try {

		//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", prop.getProperty("db_username"),prop.getProperty("db_username"));
		
		//*********Pre-Prod Connection***********\\
		
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019","QCautoMDEC216");
		test.log(LogStatus.PASS, "Connecting to DB ");
		
		//*********Regression Connection**********\\
		
		//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_NOV2619","QCautoM261");
		//test.log(LogStatus.PASS, "Connecting to DB ");

	} catch (SQLException e1) {

		System.out.println("Connection Failed! Check output console" + e1);
		e1.printStackTrace();
	}

	// Execute a query
	stmt = conn.createStatement();
	stmt2 = conn.createStatement();
	//loan_nbr="11164785";
	String schedule_id="1220";
	try {
		
		resultSet=stmt.executeQuery("select cc_info_key from repay_deposit_schedule where installment_nbr=5 and loan_code="+loan_nbr);
		String key = "";
		if(resultSet.next()){	
		 key=resultSet.getString("cc_info_key");
		}
		stmt.executeQuery("update REPAY_DEPOSIT_SCHEDULE set CC_info_key ='"+key+"'where installment_nbr='"+Insta+"' and loan_code="+loan_nbr);
		test.log(LogStatus.PASS, "Executing the query with loan number:"+loan_nbr+Insta);
		test.log(LogStatus.PASS, "Updating the CC_info_key to" +key);
		
		stmt.executeQuery("update REPAY_DEPOSIT_SCHEDULE set IS_REPRESENTMENT_NEXT='N' where installment_nbr='"+Insta+"' and loan_code="+loan_nbr);
		test.log(LogStatus.PASS, "Updating the IS_REPRESENTMENT_NEXT to N");
		
Thread.sleep(20000);					
				
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
	catch (Exception e2) {

		System.out.println(" console" + e2);
		e2.printStackTrace();
		driver.close();
	}

}
	}
}
}


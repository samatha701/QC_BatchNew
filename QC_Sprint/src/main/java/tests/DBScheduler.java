package tests;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.relevantcodes.extentreports.LogStatus;

import oracle.jdbc.OracleTypes;

public class DBScheduler extends QCStore{

	public static void scheduler1025() throws ClassNotFoundException, SQLException {
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

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", prop.getProperty("db_username"),prop.getProperty("db_password"));
			test.log(LogStatus.PASS, "Connecting to DB ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
			
		}

		// Execute a query
		stmt = conn.createStatement();
		stmt2 = conn.createStatement();
		//loan_nbr="11458414";
		String schedule_id="1025";
		
		try {
			
			stmt.executeQuery("update SCHEDULE_ATTR set IS_PROCESSED='NOP' where SCHEDULE_ID="+schedule_id);
			test.log(LogStatus.PASS, "Updating the Is_Processed to NOP"+schedule_id);
			System.out.println(" query succuesfully executed");
			
			Thread.sleep(40000);
			Thread.sleep(40000);
			
			resultSet =stmt.executeQuery("select is_enabled,is_processed from schedule_attr where schedule_id="+schedule_id);
			test.log(LogStatus.PASS, "Waiting for records to be updated");
			test.log(LogStatus.PASS, "Executing the query with is_processed and Scheduleid="+schedule_id);
			
			Thread.sleep(40000);
			Thread.sleep(40000);
			
			while (resultSet.next())
			{
				 rowValues.add(resultSet.getString(2)); 
				 test.log(LogStatus.PASS, "Getting values from the tables is_enabled and is_processed with the schedule_id="+schedule_id);
				 String statusId ="";
				 String statusId1 ="";
					statusId =resultSet .getString(1);
				    statusId1 = resultSet.getString(2);
									/*  resultSet.getString(3) + "  " +
									  resultSet.getString(4) + "  " +*/
									  
				    test.log(LogStatus.PASS, " is_enabled Displayed as "+statusId);
				    test.log(LogStatus.PASS, "is_processed Displayed as "+statusId1);	
			}
			 
			 
			System.out.println("after query");
			
						
			Thread.sleep(8000);
	
		

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

public static void scheduler116() throws ClassNotFoundException, SQLException {
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

		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", prop.getProperty("db_username"),prop.getProperty("db_password"));
		test.log(LogStatus.PASS, "Connecting to DB ");

	} catch (SQLException e1) {

		System.out.println("Connection Failed! Check output console" + e1);
		e1.printStackTrace();
		
	}

	// Execute a query
	stmt = conn.createStatement();
	stmt2 = conn.createStatement();
	//loan_nbr="11458414";
	
	String schedule_id1="116";
	
		
	try{	
		stmt.executeQuery("update SCHEDULE_ATTR set IS_PROCESSED='NOP' where SCHEDULE_ID="+schedule_id1);
		test.log(LogStatus.PASS, "Updating the Is_Processed to NOP"+schedule_id1);
		System.out.println(" query succuesfully executed");
		
		Thread.sleep(80000);
		
		resultSet =stmt.executeQuery("select is_enabled,is_processed from schedule_attr where schedule_id="+schedule_id1);
		test.log(LogStatus.PASS, "Waiting for records to be updated");
		test.log(LogStatus.PASS, "Executing the query with is_processed and Scheduleid="+schedule_id1);
		
		Thread.sleep(10000);
		
		while (resultSet.next())
		{
			 rowValues.add(resultSet.getString(2)); 
			 test.log(LogStatus.PASS, "Getting values from the tables is_enabled and is_processed with the schedule_id="+schedule_id1);
			 String status ="";
			 String status1 ="";
				status =resultSet .getString(1);
			    status1 = resultSet.getString(2);
								/*  resultSet.getString(3) + "  " +
								  resultSet.getString(4) + "  " +*/
								  
			    test.log(LogStatus.PASS, " is_enabled Displayed as "+status);
			    test.log(LogStatus.PASS, "is_processed Displayed as "+status1);	
		}
		 
		 
		System.out.println("after query");
		
		Thread.sleep(8000);

	

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
}


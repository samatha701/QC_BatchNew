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

public class DBverify extends QCStore{

	public static void proc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1",Sprop.getProperty("db_username"),
					Sprop.getProperty("db_password"));
			test.log(LogStatus.PASS, "Connecting to DB ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		
		stmt = conn.createStatement();
		//loan_nbr="11174965";
		try {
		
			resultSet =stmt.executeQuery("select loan_code,status_id,response_code,CC_info_key from REPAY_DEPOSIT_SCHEDULE where installment_nbr=1 and loan_code="+loan_nbr);
			test.log(LogStatus.PASS, "Verifying where LOAN is returned or not");
			test.log(LogStatus.PASS, "Waiting for records to be updated");
			test.log(LogStatus.PASS, "Executing the query with loan number"+loan_nbr);
			
			while (resultSet.next())
			{
				 rowValues.add(resultSet.getString(3)); 
				 test.log(LogStatus.PASS, "Getting values from the tables LOAN_CODE and STATUS_ID with the loan number"+loan_nbr);
				 String statusId ="";
				 String statusId1 ="";
					statusId =resultSet .getString(1);
				    statusId1 = resultSet.getString(2);
									/*  resultSet.getString(3) + "  " +
									  resultSet.getString(4) + "  " +*/
									  
				    test.log(LogStatus.PASS, "Loan Number Displayed as "+statusId);
				    test.log(LogStatus.PASS, "STATUS_ID Displayed as "+statusId1);	
			}
			 
			 
			System.out.println("after query");
			
			/*for(String value: rowValues)
			{
				System.out.println("verifying values"+ value);
				//test.log(LogStatus.PASS, "Verifying values in TRAS_ID table "+value);
				 if(value.equalsIgnoreCase("ERROR"))
					{
						System.out.println("Value of Response_code is ERROR");
						test.log(LogStatus.PASS, "Value of Response_code is ERROR");
						test.log(LogStatus.PASS, "Loan returned successfully");
						
					}
					else 
					{
						System.out.println("Value of Response_code is "+ value);
						test.log(LogStatus.PASS, "Value of Response_code is "+value);
						test.log(LogStatus.PASS, "Loan not returned");
						
					}
			}
*/
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
